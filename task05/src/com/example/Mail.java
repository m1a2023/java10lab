package com.example;


public interface Mail<T> {
    String getFrom();
    String getTo();
    T getContent();
}
