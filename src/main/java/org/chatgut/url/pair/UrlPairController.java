package org.chatgut.url.pair;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.chatgut.Mapper;
import org.chatgut.dto.OriginalUrlDTO;
import org.chatgut.dto.ShortenedUrlDTO;

import java.net.URI;

@Path("/url")
public class UrlPairController {

    @Inject
    UrlPairRepository urlRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generate")
    public ShortenedUrlDTO generateShortUrl(OriginalUrlDTO originalUrl) {
        ShortenedUrlDTO shortUrl = Mapper.convertToShort(originalUrl);
        urlRepo.persist(new UrlPair(originalUrl.url(), shortUrl.short_url())); //TODO:: Handle possible exceptions/errors
        return shortUrl;
    }

    @GET
    @Path("/{shortPath}")
    public Response redirect(@PathParam("shortPath") String shortPath) {

        String url = urlRepo.findByShortUrlPath(shortPath).get().getOriginalUrl();
        return Response.status(303).location(URI.create(url)).build();
    }
}
