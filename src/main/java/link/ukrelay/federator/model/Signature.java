package link.ukrelay.federator.model;

import lombok.Data;

@Data
public class Signature {
    private String keyId;
    private String headers;
    private String signature;
}
