package com.nttdata.mappers;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.nttdata.dto.ResumeDTO;
import com.nttdata.utils.JSON;

public class ResumeMapper {

    private ResumeMapper() {
    }

    public static ResumeDTO fromJsonToResumeDto(String resumeString) throws IOException {
        JsonNode resumeNode = JSON.parse(resumeString);
        return JSON.fromJson(resumeNode, ResumeDTO.class);
    }

    

}
