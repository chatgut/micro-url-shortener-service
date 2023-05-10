package org.chatgut.url.pair;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.chatgut.Generator;
import org.chatgut.dto.OriginalUrlDTO;
import org.chatgut.dto.ShortenedUrlDTO;

import java.net.URI;

@Path("")
public class UrlPairController {

    @Inject
    UrlPairRepository urlRepo;
    @Inject
    Generator generator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public ShortenedUrlDTO generateShortUrl(OriginalUrlDTO originalUrl) {
        var optionalResult = urlRepo.findByOriginalUrlPath(originalUrl.url());
        if (optionalResult.isPresent())
            return new ShortenedUrlDTO(optionalResult.get().getShortenedUrl());
        ShortenedUrlDTO shortUrl = generator.generateShort();
        try {
            urlRepo.persist(new UrlPair(originalUrl.url(), shortUrl.short_url())); //TODO:: Handle possible exceptions/errors
        } catch (Exception e) {
            return new ShortenedUrlDTO(String.valueOf(originalUrl));
        }
        return shortUrl;
    }

    @GET
    @Path("/{shortPath}")
    public Response redirect(@PathParam("shortPath") String shortPath) {

//        TODO::PresentCheck
        String url = urlRepo.findByShortUrlPath(shortPath).get().getOriginalUrl();
        return Response.status(303).location(URI.create(url)).build();
    }
}
