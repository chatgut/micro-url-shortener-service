package org.chatgut.url.pair;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Optional;

@ApplicationScoped
public class UrlPairRepository implements PanacheMongoRepository<UrlPair> {

    @ConfigProperty(name = "app.domain-name")
    String APP_DOMAIN;

    public Optional<UrlPair> findByShortUrlPath(String shortUrlPath) {
        return find("shortenedUrl", APP_DOMAIN + shortUrlPath).firstResultOptional();
    }

    public Optional<UrlPair> findByOriginalUrlPath(String originalUrl) {
        return find("originalUrl", originalUrl).firstResultOptional();
    }

}
