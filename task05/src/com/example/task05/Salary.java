package com.example.task05;

import com.example.Mail;

public class Salary implements Mail<Integer> {
    private final String from;
    private final String to;
    private final int amount;

    public Salary(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String getFrom() { return this.from; }

    @Override
    public String getTo() { return this.to; }

    @Override
    public Integer getContent() { return this.amount; }
}
