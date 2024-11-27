package com.example.task03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        if (stream == null || order == null || minMaxConsumer == null) {
            throw new IllegalArgumentException();
        }

        List<? extends T> list = stream.toList();

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T min = list.stream().min(order).orElse(null);
        T max = list.stream().max(order).orElse(null);

        minMaxConsumer.accept(min, max);
    }
}
