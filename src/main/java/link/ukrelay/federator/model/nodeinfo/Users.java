package link.ukrelay.federator.model.nodeinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Users {
    private Long total;
}
