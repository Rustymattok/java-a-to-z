package ru.makarov.first_lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaSamble {
    public static void main(String[] args) {
        String[] atts = {
                new String("image123"),
                new String("image1"),
                new String("image12")
        };
        Comparator<String> cmpText = (o1, o2) -> (o1.compareTo(o2));
        System.out.println("Сортировка по возрастанию");
        Arrays.sort(atts, cmpText);
        for (String att : atts) {
            System.out.println(att);
        }
        Comparator<String> cmpDescSize = (o1, o2) -> (-o1.compareTo(o2));
        System.out.println("Сортировка по убывания");
        Arrays.sort(atts, cmpDescSize);
        for (String att : atts) {
            System.out.println(att);
        }
    }

}
