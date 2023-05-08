package org.chatgut.url.forward;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.chatgut.url.pair.UrlPairRepository;

import java.net.URI;

@Path("/{shortPath}")
public class UrlForwardController {

    @Inject
    UrlPairRepository urlPairRepository;

    @GET
    public Response redirect(@PathParam("shortPath") String shortPath) {
        urlPairRepository.findByShortUrlPath(shortPath); //TODO::
        
        return Response.status(303).location(URI.create("na.se")).build();
//        return new OriginalUrlDTO("");
    }
}
