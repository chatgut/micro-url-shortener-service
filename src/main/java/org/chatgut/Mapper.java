package org.chatgut;

import org.chatgut.dto.OriginalUrlDTO;
import org.chatgut.dto.ShortenedUrlDTO;

public class Mapper {
    final static String SHORT_DOMAIN = "http://local.ho/";

    public Mapper() {
    }

    public static ShortenedUrlDTO convertToShort(OriginalUrlDTO originalUrl) {
        String shortUrlEndpoint = String.valueOf(originalUrl.originalUrl().hashCode()).substring(0, 5);
        return new ShortenedUrlDTO(SHORT_DOMAIN + shortUrlEndpoint);
    }


}
