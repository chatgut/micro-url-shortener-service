package org.chatgut.url.id;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CounterRepository implements PanacheMongoRepository<Counter> {

    public boolean counterExists() {
        return mongoCollection().countDocuments() != 0;
    }

    public Counter getCounter() {
        return findAll().firstResult();
    }
}
