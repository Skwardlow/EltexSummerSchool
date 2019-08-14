package ru.skwardlow.entities;

import lombok.AllArgsConstructor;
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
    @PrimaryKeyJoinColumn
    User user;

    private Long number;


    public Passport(long number){
        this.number = number;
    }


}
