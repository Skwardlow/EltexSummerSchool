package ru.skwardlow.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@lombok.Setter
@lombok.Getter
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    private String id;

    private String fio;
    private String phone;
    private String email;

    public User(String fio, String phone, String email){
        this.fio = fio;

    }

}
