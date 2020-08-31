package ru.makarov.flatmaplist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapSample {

    public static void main(String[] args) {
        int sizeX = 5;
        int sizeY = 5;

        Integer[][] matrix = new Integer[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matrix[i][j] = j;
            }
        }

        List<Integer> list;
        list = Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
