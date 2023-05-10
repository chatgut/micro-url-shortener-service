package org.chatgut;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.chatgut.url.id.Counter;
import org.chatgut.url.id.CounterRepository;

@ApplicationScoped
public class InitApp {

    @Inject
    CounterRepository counterRepo;

    void onStart(@Observes StartupEvent ev) {
        initCounter();
    }

    public void initCounter(){
        if (!counterRepo.counterExists())
            counterRepo.persist(new Counter(0));
    }

}
