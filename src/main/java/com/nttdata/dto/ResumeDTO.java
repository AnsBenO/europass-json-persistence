package com.nttdata.dto;

import java.util.ArrayList;
import java.util.List;

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
public class ResumeDTO {

    private PersonalInfoDTO personalInfoDTO;
    @Builder.Default
    private List<ExperienceDTO> experiences = new ArrayList<>();
    @Builder.Default
    private List<LanguageProficiencyDTO> languageProficiencies = new ArrayList<>();
    @Builder.Default
    private List<EducationDTO> educations = new ArrayList<>();
    @Builder.Default
    private List<SkillDTO> skills = new ArrayList<>();

}
