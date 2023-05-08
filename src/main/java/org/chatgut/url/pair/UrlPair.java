package org.chatgut.url.pair;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class UrlPair extends PanacheMongoEntity {
    String originalUrl;
    String shortenedUrl;

    public UrlPair() {
    }

    public UrlPair(String originalUrl, String shortenedUrl) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
    }
}
