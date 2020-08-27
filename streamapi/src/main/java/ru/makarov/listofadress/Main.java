package ru.makarov.listofadress;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile(new Address("Moscow", "Yb", 34, 101)));
        profileList.add(new Profile(new Address("Mitishi", "Mb", 21, 231)));
        profileList.add(new Profile(new Address("Dolgoprudniu", "Nb", 34, 78)));
        profileList.add(new Profile(new Address("Mitishi", "Sl", 75, 20)));
        profileList.add(new Profile(new Address("Moscow", "Yb", 34, 101)));
        profileList.add(new Profile(new Address("Moscvobad", "Rb", 11, 63)));

        List<Address> addressList = new Profiles().collect(profileList);
        addressList.stream().map(Address::getCity).forEach(System.out::println);
        System.out.println();
        addressList.stream().map(Address::getCity).distinct().forEach(System.out::println);
    }
}
