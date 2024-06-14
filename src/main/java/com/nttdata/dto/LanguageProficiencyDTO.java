package com.nttdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class LanguageProficiencyDTO {
    private String languageCode;
    private String understandingListening;
    private String understandingReading;
    private String speakingInteraction;
    private String speakingProduction;
    private String writingProduction;
}
