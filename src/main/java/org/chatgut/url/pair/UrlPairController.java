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
    public Response generateShortUrl(OriginalUrlDTO originalUrl) {

        var optionalResult = urlRepo.findByOriginalUrlPath(originalUrl.url());

        if (optionalResult.isPresent())
            return Response.ok(new ShortenedUrlDTO(optionalResult.get().getShortenedUrl())).build();

        ShortenedUrlDTO shortUrl = generator.generateShort();

        try {
            urlRepo.persist(new UrlPair(originalUrl.url(), shortUrl.short_url()));
        } catch (Exception e) {
            return Response.status(503).header("Retry-After", 1).build();
        }
        return Response.status(201).entity(shortUrl).build();
    }

    @GET
    @Path("/{shortPath}")
    public Response redirect(@PathParam("shortPath") String shortPath) {
        var result = urlRepo.findByShortUrlPath(shortPath);
        return result.isPresent()
                ? Response.status(303).location(URI.create(result.get().getOriginalUrl())).build()
                : Response.noContent().build();
    }
}
