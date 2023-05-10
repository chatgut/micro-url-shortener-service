package org.chatgut.url.id;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Counter extends PanacheMongoEntity {

    long count;

    public Counter() {
    }

    public Counter(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
