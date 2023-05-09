package org.chatgut.url.pair;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UrlPair urlPair = (UrlPair) o;

        if (!Objects.equals(originalUrl, urlPair.originalUrl)) return false;
        return Objects.equals(shortenedUrl, urlPair.shortenedUrl);
    }

    @Override
    public int hashCode() {
        return 13;
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
