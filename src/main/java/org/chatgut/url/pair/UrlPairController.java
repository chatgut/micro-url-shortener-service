package org.chatgut.url.pair;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.chatgut.Mapper;
import org.chatgut.dto.OriginalUrlDTO;
import org.chatgut.dto.ShortenedUrlDTO;

import javax.annotation.processing.Generated;
import java.net.URI;

@Path("/url")
public class UrlPairController {

    @Inject
    UrlPairRepository urlRepo;

    public UrlPairController(UrlPairRepository urlRepo) {
        this.urlRepo = urlRepo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generate")
    public ShortenedUrlDTO generateShortUrl(OriginalUrlDTO originalUrl) {
        ShortenedUrlDTO shortUrl = Mapper.convertToShort(originalUrl);
        urlRepo.persist(new UrlPair(originalUrl.originalUrl(), shortUrl.shortenedUrl()));
        return shortUrl;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Generated(MediaType.APPLICATION_JSON)
    @Path("/get")
    public String redirect(ShortenedUrlDTO shortPath) {
        return urlRepo.findByShortUrlPath(shortPath.shortenedUrl()).getOriginalUrl(); //TODO::

//        return Response.status(303).location(URI.create(urlRepo.findByShortUrlPath(shortPath.shortenedUrl()).getOriginalUrl())).build();
//        return new OriginalUrlDTO("");
    }
}
