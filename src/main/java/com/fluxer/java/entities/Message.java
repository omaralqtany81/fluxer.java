package com.fluxer.java.entities;

public class Message {
    private final String id;
    private final String content;
    private final String channelId;
    private final User author;

    public Message(String id, String content, String channelId, User author) {
        this.id = id;
        this.content = content;
        this.channelId = channelId;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getChannelId() {
        return channelId;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Message{" + "id='" + id + '\'' + ", author=" + author + ", content='" + content + '\'' + '}';
    }
}
