package ru.skwardlow.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;
import ru.skwardlow.interfaces.JSON;

import javax.persistence.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User implements JSON {
    public static final String jsonPath = "src/main/resources/results/Users.json";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Address> address;

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Lang> lang;

    private String fio;
    private String email;


    public User(String fio, String email) {
        this.fio = fio;
        this.email = email;
    }

    @Override
    public void writeToJSON() throws IOException {
        FileWriter fw = new FileWriter(new File(jsonPath), true);
        ObjectMapper om = new ObjectMapper();
        om.writeValue(fw, this);
    }

    @Override
    public void readFromJSON() throws IOException {
        ObjectMapper om = new ObjectMapper();
        User tmp = om.readValue(new File(jsonPath), User.class);
        this.fio = tmp.fio;
        this.email = tmp.email;
        this.passport = tmp.passport;
        this.address = tmp.address;
        this.lang = tmp.lang;
    }
}
