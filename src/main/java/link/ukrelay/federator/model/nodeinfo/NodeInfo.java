package link.ukrelay.federator.model.nodeinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class NodeInfo {

    private Boolean openRegistrations;
    private List<Protocol> protocols;
    private Services services;
    private Software software;
    private Usage usage;
    private Metadata metadata;
    private String version;

    public NodeInfo() {
        this.version = "2.1";
    }

}
