package com.fluxer.java.examples;

import com.fluxer.java.FluxerBuilder;
import com.fluxer.java.FluxerClient;
import com.fluxer.java.events.EventListener;
import com.fluxer.java.entities.Message;

public class QuickStart {
    public static void main(String[] args) {
        String token = "YOUR_BOT_TOKEN_HERE";

        FluxerClient client = FluxerBuilder.createDefault(token)
                .addEventListeners(new EventListener() {
                    @Override
                    public void onReady() {
                        System.out.println("✨ fluxer.java is online and ready!");
                    }

                    @Override
                    public void onMessageReceived(Message message) {
                        System.out.println("📩 New message from " + message.getAuthor().getUsername() + ": " + message.getContent());
                    }
                })
                .build();

        client.login();
    }
}
