package ru.makarov.innerfunctionalinterface;

import ru.makarov.anonimclass.Attachment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SearchAtt {
    public static List<Attachment> fileSizeFunc(List<Attachment> list, int size) {
        Function<Attachment, Attachment> function = attachment -> {
            if (attachment.getSize() > size) {
                return attachment;
            }
            return null;
        };
        return filter(list, function);
    }

    public static List<Attachment> filterNameFunc(List<Attachment> list, String tag) {
        Function<Attachment, Attachment> function = attachment -> {
            if (attachment.getName().contains(tag)) {
                return attachment;
            }
            return null;
        };
        return filter(list, function);
    }

    private static List<Attachment> filter(List<Attachment> list, Function<Attachment, Attachment> function) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            Attachment attachment = function.apply(att);
            if (attachment != null) {
                rsl.add(attachment);
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
