package org.chatgut.url.pair;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UrlPairRepository implements PanacheMongoRepository<UrlPair> {

    public Optional<UrlPair> findByShortUrlPath(String shortUrlPath) {
        return find("shortenedUrl", "http://localhost:8080/"+shortUrlPath).firstResultOptional();
    }

}
