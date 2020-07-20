package ru.makarov.anonimclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 2", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13),
                new Attachment("image 2", 13),
                new Attachment("image 4", 13)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };

        Comparator comparatorName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                int comp = left.getName().compareTo(right.getName());
                if (comp != 0) {    // names are different
                    return comp;
                }
                return comp;
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}
