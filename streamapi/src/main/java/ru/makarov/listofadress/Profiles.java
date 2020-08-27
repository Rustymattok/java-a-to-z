package ru.makarov.listofadress;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparable = (o1, o2)-> -o1.getCity().compareTo(o2.getCity());
    return  profiles.stream().map(Profile::getAddress).sorted(comparable).distinct().collect(Collectors.toList());
    }
}