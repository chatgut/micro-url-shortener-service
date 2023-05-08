package org.chatgut.url.pair;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.chatgut.Mapper;
import org.chatgut.dto.OriginalUrlDTO;
import org.chatgut.dto.ShortenedUrlDTO;

@Path("/generate")
public class UrlPairController {

    UrlPairRepository urlRepo;

    public UrlPairController(UrlPairRepository urlRepo) {
        this.urlRepo = urlRepo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ShortenedUrlDTO generateShortUrl(OriginalUrlDTO originalUrl) {
        ShortenedUrlDTO shortUrl = Mapper.convertToShort(originalUrl);
        urlRepo.persist(new UrlPair(originalUrl.originalUrl(), shortUrl.shortenedUrl()));
        return shortUrl;
    }
}
