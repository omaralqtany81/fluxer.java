package com.fluxer.java.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fluxer.java.entities.Message;
import com.fluxer.java.entities.User;

public class EntityParser {
    
    public static User parseUser(JsonNode data) {
        return new User(
            data.get("id").asText(),
            data.get("username").asText(),
            data.has("avatar") && !data.get("avatar").isNull() ? data.get("avatar").asText() : null,
            data.has("bot") && data.get("bot").asBoolean()
        );
    }

    public static Message parseMessage(JsonNode data) {
        return new Message(
            data.get("id").asText(),
            data.get("content").asText(),
            data.get("channel_id").asText(),
            parseUser(data.get("author"))
        );
    }
}
