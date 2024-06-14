package com.nttdata.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExperienceDTO {
    private String title;
    private String organization;
    private String city;
    private String country;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
