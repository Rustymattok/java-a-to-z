package ru.makarov.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(120, 100, -50, 32, -12);
        /*
        Filter by value > 0.
         */
        List<Integer> newList = list.stream().filter(num -> num > 0).collect(Collectors.toList());
    }
}
