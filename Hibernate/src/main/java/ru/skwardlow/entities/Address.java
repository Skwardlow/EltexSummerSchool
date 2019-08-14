package ru.skwardlow.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @JoinTable(name = "u_address")
    private Collection<User> owner;

    private String city;

    private String street;
    private String building;


    public Address(String city, String street, String building){
        this.city = city;
        this.street = street;
        this.building = building;
    }

}
