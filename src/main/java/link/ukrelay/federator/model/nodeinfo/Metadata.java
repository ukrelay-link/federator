package link.ukrelay.federator.model.nodeinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Metadata {
    private List<String> peers;
}
