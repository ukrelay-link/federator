package link.ukrelay.federator.controllers;

import link.ukrelay.federator.Config;
import link.ukrelay.federator.model.Instance;
import link.ukrelay.federator.services.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class Index {

    private final Config config;

    private final InstanceService instanceService;

    public Index(@Autowired final Config config,
                 @Autowired final InstanceService instanceService) {
        this.config = config;
        this.instanceService = instanceService;
    }

    @GetMapping("/")
    public String index(final Model model) {

        model.addAttribute("baseurl", config.getBaseurl());
        model.addAttribute("host", config.getHost());
        model.addAttribute("note", config.getNote());

        var instances = instanceService.list().stream().map(Instance::getName).toList();
        model.addAttribute("instances", instances);

        return "index";
    }

}
