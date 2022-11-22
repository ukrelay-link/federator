package link.ukrelay.federator.controllers.wellknown;

import link.ukrelay.federator.Config;
import link.ukrelay.federator.model.wellknown.Link;
import link.ukrelay.federator.model.wellknown.NodeInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/.well-known/nodeinfo")
public class NodeInfoController {

    private final Config config;

    public NodeInfoController(final Config config) {
        this.config = config;
    }

    @GetMapping
    public NodeInfo nodeInfo() {
        var link = new Link();
        link.setRel("http://nodeinfo.diaspora.software/ns/schema/2.1");
        link.setHref(config.getBaseurl() + "/nodeinfo/2.1.json");
        var nodeInfo = new NodeInfo();
        nodeInfo.add(link);
        return nodeInfo;
    }

}
