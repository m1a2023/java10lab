package com.example.task04;

import org.w3c.dom.Text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            List<String> words = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("[^\\p{L}\\p{Nd}]+")))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isEmpty())
                    .toList();

            List<String> topWords = words.stream()
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                            .thenComparing(Map.Entry::getKey))
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .toList();

            topWords.forEach(System.out::println);
        }
    }

}
