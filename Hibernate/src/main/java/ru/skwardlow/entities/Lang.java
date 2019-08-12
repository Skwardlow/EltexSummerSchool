package ru.skwardlow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@lombok.Getter
@lombok.Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "langs")
public class Lang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
  //  @JoinColumn(name = "u_lang")
    private User owner;

    private String name;


    public Lang(String name){
        this.name = name;
    }

    @ManyToOne(optional = false)
    private User users;

    }

