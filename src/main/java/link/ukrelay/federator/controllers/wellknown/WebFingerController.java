package link.ukrelay.federator.controllers.wellknown;

import link.ukrelay.federator.Config;
import link.ukrelay.federator.exceptions.ResourceNotFoundException;
import link.ukrelay.federator.model.wellknown.Link;
import link.ukrelay.federator.model.wellknown.WebFinger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/.well-known/webfinger")
public class WebFingerController {

    private final Config config;

    public WebFingerController(final Config config) {
        this.config = config;
    }

    @GetMapping
    public WebFinger webFinger(@RequestParam("resource") final String resource) {

        if (!resource.equals("acct:relay@" + config.getHost())) throw new ResourceNotFoundException(resource);

        var webFinger = new WebFinger();
        webFinger.setSubject(resource);

        var links = new ArrayList<Link>();

        var actLink = new Link();
        actLink.setHref(config.getBaseurl() + "/actor");
        actLink.setRel("self");
        actLink.setType("application/activity+json");

        var ldLink = new Link();
        ldLink.setHref(config.getBaseurl() + "/actor");
        ldLink.setRel("self");
        ldLink.setType("application/ld+json; profile=\"https://www.w3.org/ns/activitystreams\"");

        links.add(actLink);
        links.add(ldLink);
        webFinger.setLinks(links);

        var aliases = Collections.singletonList(config.getBaseurl() + "/actor");
        webFinger.setAliases(aliases);

        return webFinger;

    }

}
