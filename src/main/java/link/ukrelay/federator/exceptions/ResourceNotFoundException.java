package link.ukrelay.federator.exceptions;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException {

    @Getter
    private final String resource;

    public ResourceNotFoundException(final String resource) {
        super("Resource not found: " + resource);
        this.resource = resource;
    }

}
