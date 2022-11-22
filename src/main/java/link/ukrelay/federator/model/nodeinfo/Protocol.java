package link.ukrelay.federator.model.nodeinfo;

public enum Protocol {
    ActivityPub("activitypub");

    private String json;

    Protocol(final String json) {
        this.json = json;
    }

}
