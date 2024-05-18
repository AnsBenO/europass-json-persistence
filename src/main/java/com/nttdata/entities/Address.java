package com.nttdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_description")
    private String addressDescription;

    @Column(name = "postal_code")
    private Integer postalCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
