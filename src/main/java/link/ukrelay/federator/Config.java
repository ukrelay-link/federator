package link.ukrelay.federator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="federator")
public class Config {
    private String baseurl;
    private String host;
    private String note;
    private boolean openRegistrations = true;
}
