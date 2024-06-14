package com.nttdata.loader;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.nttdata.dto.ResumeDTO;
import com.nttdata.services.ResumeService;
import com.nttdata.utils.JSON;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ResumeLoader {

    private final ResumeService resumeService;

    public void loadResume(String resumeString) throws IOException {
        JsonNode resumeNode = JSON.parse(resumeString);
        ResumeDTO resumeDTO = JSON.fromJson(resumeNode, ResumeDTO.class);
        resumeService.saveResume(resumeDTO);

    }
}
