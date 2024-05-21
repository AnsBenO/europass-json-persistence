package com.nttdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality_name")
    private String nationalityName;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nationality")
    private Set<Resume> resumes = new LinkedHashSet<>();

}
