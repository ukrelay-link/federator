package link.ukrelay.federator.model.wellknown;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class NodeInfo {
    private List<Link> links;

    public NodeInfo() {
        this.links = new ArrayList<Link>();
    }

    public NodeInfo add(final Link link) {
        this.links.add(link);
        return this;
    }

}
