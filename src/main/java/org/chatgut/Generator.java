package org.chatgut;

import jakarta.enterprise.context.ApplicationScoped;
import org.chatgut.dto.ShortenedUrlDTO;
import org.hashids.Hashids;

@ApplicationScoped
public class Generator {

    final static String SHORT_DOMAIN = "http://localhost:8080/";
    //TODO:: get domain from configuration file
    private long counter = 0;

    public ShortenedUrlDTO generateShort() {
        Hashids hashids = new Hashids("7y35ogo23t");
        String hash = hashids.encode(counter++);
        return new ShortenedUrlDTO(SHORT_DOMAIN + hash);
    }
}
