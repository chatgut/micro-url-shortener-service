package org.chatgut;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriBuilder;
import org.chatgut.dto.ShortenedUrlDTO;
import org.chatgut.url.id.CounterRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.hashids.Hashids;

@ApplicationScoped
public class Generator {

    @ConfigProperty(name = "app.domain-name")
    String APP_DOMAIN;

    @Inject
    CounterRepository counterRepo;

    public ShortenedUrlDTO generateShort() {

        var counter = counterRepo.getCounter();

        Hashids hashids = new Hashids("7y35ogo23t");
        String hash = hashids.encode(counter.getCount());
        counter.setCount(counter.getCount() + 1L);
        counterRepo.persistOrUpdate(counter);

        return new ShortenedUrlDTO(UriBuilder.newInstance().path(APP_DOMAIN).path(hash).toString());
    }
}
