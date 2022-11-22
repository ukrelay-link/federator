package link.ukrelay.federator.controllers;

import link.ukrelay.federator.Config;
import link.ukrelay.federator.services.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final Config config;

    private final InstanceService instanceService;

    public ActorController(@Autowired final Config config,
                           @Autowired final InstanceService instanceService) {
        this.config = config;
        this.instanceService = instanceService;
    }

}
