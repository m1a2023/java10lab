package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import com.example.Mail;


public class MailService<T> implements Consumer<Mail<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>();

    @Override
    public void accept(Mail<T> mail) {
        mailBox
            .computeIfAbsent(mail.getTo(), k -> new ArrayList<>())
            .add(mail.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
