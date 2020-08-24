package ru.makarov.listofadress;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        Comparator<Profile> comparable = (o1, o2)-> -o1.getAddress().getCity().compareTo(o2.getAddress().getCity());
        return profiles.stream().sorted(comparable).map(Profile::getAddress).collect(Collectors.toList());
    }
}
