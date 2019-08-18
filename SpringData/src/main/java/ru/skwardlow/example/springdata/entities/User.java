package ru.skwardlow.example.springdata.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@lombok.Getter
@lombok.Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fio;
    private String phone;

    public User(String fio, String phone){
        this.fio = fio;
        this.phone = phone;
    }

}
