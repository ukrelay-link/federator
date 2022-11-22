package link.ukrelay.federator.controllers.nodeinfo;

import link.ukrelay.federator.Config;
import link.ukrelay.federator.model.Instance;
import link.ukrelay.federator.model.nodeinfo.*;
import link.ukrelay.federator.services.InstanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/nodeinfo/2.1.json")
public class Version21Controller {

    private final Config config;

    private final InstanceService instanceService;

    public Version21Controller(final Config config,
                               final InstanceService instanceService) {
        this.config = config;
        this.instanceService = instanceService;
    }

    @GetMapping
    public NodeInfo nodeInfo() {

        var protocols = Collections.singletonList(Protocol.ActivityPub);

        var services = new Services();

        var software = new Software();
        software.setName("Federator");
        software.setVersion("0.0.1");
        software.setRepository("https://github.com/ukrelay-link/federator");

        var users = new Users();
        users.setTotal(0L);

        var usage = new Usage();
        usage.setLocalPosts(0L);
        usage.setUsers(users);

        var metadata = new Metadata();
        var instances = instanceService.list().stream().map(Instance::getName).toList();
        metadata.setPeers(instances);

        var nodeInfo = new NodeInfo();
        nodeInfo.setOpenRegistrations(this.config.isOpenRegistrations());
        nodeInfo.setProtocols(protocols);
        nodeInfo.setServices(services);
        nodeInfo.setSoftware(software);
        nodeInfo.setUsage(usage);
        nodeInfo.setMetadata(metadata);

        return nodeInfo;

    }

}


