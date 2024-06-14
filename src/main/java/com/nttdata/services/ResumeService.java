package com.nttdata.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.nttdata.dto.ResumeDTO;
import com.nttdata.entities.Resume;
import com.nttdata.repositories.ResumeRepository;
import com.nttdata.utils.JSON;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public Resume saveResume(ResumeDTO resumeDTO) {
        // map to resume
        // save the resume to database
        return new Resume();
    }

}
