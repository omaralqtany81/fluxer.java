package com.fluxer.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Every great bot starts with a great builder. 
 * FluxerBuilder provides a fluent way to configure and instantiate your library instance.
 */
public class FluxerBuilder {
    private String token;
    private String prefix = "!";
    private final List<Object> listeners = new ArrayList<>();

    public static FluxerBuilder create(String token) {
        FluxerBuilder builder = new FluxerBuilder();
        builder.token = token;
        return builder;
    }

    public static FluxerBuilder createDefault(String token) {
        return create(token);
    }

    public FluxerBuilder setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public FluxerBuilder addEventListeners(Object... listeners) {
        for (Object listener : listeners) {
            this.listeners.add(listener);
        }
        return this;
    }

    public FluxerClient build() {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty!");
        }
        return new FluxerClient(token, listeners, prefix);
    }
}
