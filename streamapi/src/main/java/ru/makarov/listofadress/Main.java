package ru.makarov.listofadress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Profile> profileList = Arrays.asList(
                new Profile(new Address("Moscow", "Yb", 34, 101)),
                new Profile(new Address("Mitishi", "Mb", 21, 231)),
                new Profile(new Address("Dolgoprudniu", "Nb", 34, 78)),
                new Profile(new Address("Korolev", "Sl", 75, 20)),
                new Profile(new Address("Moscow", "Rb", 11, 63))
        );

        List<Address> addressList = new Profiles().collect(profileList);
        addressList.stream().map(Address::getCity).distinct().forEach(System.out::println);
    }
}
