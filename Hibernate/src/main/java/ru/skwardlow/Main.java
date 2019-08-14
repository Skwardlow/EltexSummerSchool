package ru.skwardlow;

import ru.skwardlow.entities.Address;
import ru.skwardlow.entities.Lang;
import ru.skwardlow.entities.Passport;
import ru.skwardlow.entities.User;
import ru.skwardlow.services.UserService;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Collection<User> cUser = new ArrayList<>();


        User user1 = new User("Dasha","ab@cd");
        User user2 = new User("Masha","abc@d");
        cUser.add(user1);
        cUser.add(user2);

        Passport passport1 = new Passport(123123123);
        Passport passport2 = new Passport(345435345);
        user1.setPassport(passport1);
        passport1.setUser(user1);
        user2.setPassport(passport2);
        passport2.setUser(user2);

        Collection<Lang> cLang= new ArrayList<>();

        Address address = new Address("France","streetname","home/1");
        Collection<Address> cAdd= new ArrayList<>();
        cAdd.add(address);
        user1.setAddress(cAdd);
        address.setOwner(cUser);

        Lang lang = new Lang("Java");
        cLang.add(lang);
        user1.setLang(cLang);
        lang.setOwner(user1);

        userService.saveUser(user1);


    }
}
