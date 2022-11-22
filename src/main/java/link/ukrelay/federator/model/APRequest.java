package link.ukrelay.federator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class APRequest {

    @JsonProperty("@context")
    private String context;
    private String id;
    private String type;
    private String actor;
    private APObject object;

}
