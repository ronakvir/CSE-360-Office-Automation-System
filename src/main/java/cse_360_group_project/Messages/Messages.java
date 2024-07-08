package cse_360_group_project.Messages;

import cse_360_group_project.Users.Patient;
import cse_360_group_project.Users.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Messages implements Serializable {
    private final Patient patient;
    private final User staff;
    private final List<Message> messages;

    public Messages(Patient patient, User staff) {
        this.patient = patient;
        this.staff = staff;
        this.messages = new ArrayList<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public User getStaff() {
        return staff;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(User fromUser, String content, Instant timestamp) {
        Message message = new Message(fromUser, content, timestamp);
        messages.add(message);
    }

    public List<Message> getSortedMessages() {
        messages.sort(Comparator.comparing(Message::getTimestamp));
        return new ArrayList<>(messages);
    }
}