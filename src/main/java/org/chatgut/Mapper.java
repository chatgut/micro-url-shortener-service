package org.chatgut;

import org.chatgut.dto.OriginalUrlDTO;
import org.chatgut.dto.ShortenedUrlDTO;

public class Mapper {
    final static String SHORT_DOMAIN = "http://local.ho/";

    public Mapper() {
    }

    public static ShortenedUrlDTO convertToShort(OriginalUrlDTO originalUrlDTO) {
        String shortUrlEndpoint = String.valueOf(originalUrlDTO.url().hashCode()).substring(0, 5); //TODO:: change implementation
        return new ShortenedUrlDTO(SHORT_DOMAIN + shortUrlEndpoint);
    }


}
