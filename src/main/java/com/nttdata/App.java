package com.nttdata;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonNode;
import com.nttdata.repositories.LanguageRepository;
import com.nttdata.utils.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        final LanguageRepository languageRepository = new LanguageRepository();

        try (InputStream inputStream = App.class.getResourceAsStream("/CV.json")) {
            String cvString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            JsonNode rootNode = JSON.parse(cvString);
            JsonNode educationNode = rootNode.get("education");

        }
    }
}
