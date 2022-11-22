package link.ukrelay.federator.model.wellknown;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class WebFinger {
    private String subject;
    private List<String> aliases;
    private List<Link> links;
}
