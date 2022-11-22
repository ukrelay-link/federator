package link.ukrelay.federator.model.nodeinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Services {

    private List<Service> inbound;
    private List<Service> outbound;

    public Services() {
        inbound = new ArrayList<Service>();
        outbound = new ArrayList<Service>();
    }

}
