package com.nttdata.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoDTO {
    private String givenName;
    private String familyName;
    private String legalName;
    private String formattedName;
    private LocalDate birthDate;
    private String nationality;
    private String email;
    private String phoneNumber;
    private String address;
    private String primaryLanguage;
}
