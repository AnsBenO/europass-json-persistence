package com.nttdata.repositories;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nttdata.config.TestConfig;
import com.nttdata.entities.Resume;
import com.nttdata.entities.Skill;

import jakarta.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ActiveProfiles("sandbox")
@ContextConfiguration(classes = TestConfig.class)
public class ResumeRepositoryTest {
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private SkillRepository skillRepository;

    private Resume resume;

    @Before
    public void setUp() {
        resume = new Resume();
        resume.setGivenName("John");
        resume.setFamilyName("Doe");
        resume.setEmail("john.doe@example.com");
        resume.setBirthDate(LocalDate.of(1990, 1, 1));
        resume.setITCareerStartDate(LocalDate.of(2015, 1, 1));
        resume.setSummary("Experienced software engineer.");

        Skill skill = new Skill();
        skill.setDescription("Java programming");
        skill.setResume(resume);

        resume.getSkills().add(skill);

        resume = resumeRepository.save(resume);
    }

    @After
    public void tearDown() {
        resumeRepository.deleteAll();
        skillRepository.deleteAll();
    }

    @Test
    public void testCreateAndReadResume() {
        Resume foundResume = resumeRepository.findById(resume.getId()).orElse(null);
        assertNotNull(foundResume);
        assertEquals("John", foundResume.getGivenName());
        assertEquals(1, foundResume.getSkills().size());

        Iterator<Skill> skillIterator = foundResume.getSkills().iterator();
        assertTrue(skillIterator.hasNext());
        Skill foundSkill = skillIterator.next();
        assertEquals("Java programming", foundSkill.getDescription());
    }

    @Test
    public void testCascadeDelete() {
        resumeRepository.deleteById(resume.getId());
        Resume foundResume = resumeRepository.findById(resume.getId()).orElse(null);
        assertNull(foundResume);

        Iterator<Skill> skillIterator = resume.getSkills().iterator();
        assertTrue(skillIterator.hasNext());
        Skill foundSkill = skillRepository.findById(skillIterator.next().getId()).orElse(null);
        assertNull(foundSkill);
    }
}
