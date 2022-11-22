package link.ukrelay.federator.model.nodeinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Software {
    private String name;
    private String version;
    private String repository;
}
