package ru.makarov.innerfunctionalinterface;

import ru.makarov.anonimclass.Attachment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> fileSizeFunc(List<Attachment> list, int size) {
        Predicate<Attachment> function = attachment -> (attachment.getSize() > size);
        return filter(list, function);
    }

    public static List<Attachment> filterNameFunc(List<Attachment> list, String tag) {
        Predicate<Attachment> function = attachment -> (attachment.getName().contains(tag));
        return filter(list, function);
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> function) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (function.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 2", 101),
                new Attachment("image 2", 34),
                new Attachment("bug 3", 13),
                new Attachment("image 2", 13),
                new Attachment("bug", 13)
        );
        List<Attachment> attachmentsBySize = new ArrayList<>();
        List<Attachment> attachmentsByName = new ArrayList<>();
        attachmentsBySize = fileSizeFunc(attachments, 100);
        attachmentsByName = filterNameFunc(attachments, "bug");
        System.out.println(attachmentsBySize);
        System.out.println(attachmentsByName);


    }
}
