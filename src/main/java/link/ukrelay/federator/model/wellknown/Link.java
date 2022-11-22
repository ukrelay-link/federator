package link.ukrelay.federator.model.wellknown;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Link {
    private String href;
    private String rel;
    private String type;
    private String template;
}
