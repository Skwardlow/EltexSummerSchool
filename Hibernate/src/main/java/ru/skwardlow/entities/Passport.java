package ru.skwardlow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne(mappedBy = "passport",fetch = FetchType.EAGER)
    @JoinColumn(name = "u_passport")
    User user;

    private Long number;


    public Passport(long number){
        this.number = number;
    }


}
