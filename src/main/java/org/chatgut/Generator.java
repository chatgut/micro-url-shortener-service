package org.chatgut;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.chatgut.dto.ShortenedUrlDTO;
import org.chatgut.url.id.CounterRepository;
import org.hashids.Hashids;

@ApplicationScoped
public class Generator {

    final static String SHORT_DOMAIN = "http://localhost:8080/";
    //TODO:: get domain from configuration file

    @Inject
    CounterRepository counterRepo;

    public ShortenedUrlDTO generateShort() {

        var counter = counterRepo.getCounter();

        Hashids hashids = new Hashids("7y35ogo23t");
        String hash = hashids.encode(counter.getCount());
        counter.setCount(counter.getCount() + 1L);
        counterRepo.persistOrUpdate(counter);

        return new ShortenedUrlDTO(SHORT_DOMAIN + hash);
    }
}
