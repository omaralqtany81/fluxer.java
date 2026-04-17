package com.fluxer.java.examples;

import com.fluxer.java.FluxerBuilder;
import com.fluxer.java.FluxerClient;
import com.fluxer.java.entities.Message;
import com.fluxer.java.events.Subscribe;

public class QuickStart {
    public static void main(String[] args) {
        FluxerClient client = new FluxerBuilder("YOUR_TOKEN_HERE")
                .setPrefix("!")
                .build();

        client.registerListener(new QuickStart());
        client.login();
    }

    @Subscribe
    public void onMessage(Message message) {
        if (message.getContent().equalsIgnoreCase("!ping")) {
            message.reply("Pong! 🏓");
        }
    }
}
