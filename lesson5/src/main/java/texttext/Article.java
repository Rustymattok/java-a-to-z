package texttext;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        List<String> listOrigin = Arrays.asList(origin.split("\\s*(\\s|,|!|\\.)\\s*"));
        List<String> listLine = Arrays.asList(line.split("\\s*(\\s|,|!|\\.)\\s*"));
        listOrigin = listOrigin.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        listLine =  listLine.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        TreeSet<String> treeOrigin = new TreeSet<>(listOrigin);
        TreeSet<String> treeLine = new TreeSet<>(listLine);
        return treeOrigin.containsAll(treeLine);
    }
}
