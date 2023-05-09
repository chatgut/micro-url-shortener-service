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

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    @Override
    public String toString() {
        return "UrlPair{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortenedUrl='" + shortenedUrl + '\'' +
                ", id=" + id +
                '}';
    }
}
