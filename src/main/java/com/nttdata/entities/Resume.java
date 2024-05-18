package com.nttdata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "Resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "formatted_name")
    private String formattedName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "primary_language_id")
    private Language primaryLanguage;

    @OneToMany(mappedBy = "resume")
    private Set<Experience> experiences = new LinkedHashSet<>();

    @OneToMany(mappedBy = "resume")
    private Set<Skill> skills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "resume")
    private Set<LanguageProficiency> languageProficiencies = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "resume_id"))
    private Set<Certificate> certificates = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "resume_id"))
    private Set<Country> countries = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "Resume_educations",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "educations_id"))
    private Set<Education> educations = new LinkedHashSet<>();

}
