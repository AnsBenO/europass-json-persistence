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
@Table(name = "language_proficiency")
public class LanguageProficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Enumerated(EnumType.STRING)
    @Column(name = "listening_level")
    private LanguageLevel understandingListening;

    @Enumerated(EnumType.STRING)
    @Column(name = "reading_level")
    private LanguageLevel understandingReading;

    @Enumerated(EnumType.STRING)
    @Column(name = "interaction_level")
    private LanguageLevel speakingInteraction;

    @Enumerated(EnumType.STRING)
    @Column(name = "production_level")
    private LanguageLevel speakingProduction;

    @Enumerated(EnumType.STRING)
    @Column(name = "writing_level")
    private LanguageLevel writingProduction;

    public enum LanguageLevel {
        A1, A2, B1, B2, C1, C2
    }

}
