package cse_360_group_project.Messages;

import cse_360_group_project.Users.User;

import java.io.Serializable;
import java.time.Instant;

public class Message implements Serializable {
    private final User fromUser;
    private final String content;
    private final Instant timestamp;

    public Message(User fromUser, String content, Instant timestamp) {
        this.fromUser = fromUser;
        this.content = content;
        this.timestamp = timestamp;
    }

    public User getFromUser() {
        return fromUser;
    }

    public String getContent() {
        return content;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}