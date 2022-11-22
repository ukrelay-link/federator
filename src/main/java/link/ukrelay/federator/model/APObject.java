package link.ukrelay.federator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class APObject {
    private String id;
    private String type;
    private String published;
    private String attributedTo;
    private String inReplyTo;
    private String content;
    private String to;
}
