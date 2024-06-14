package com.nttdata;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nttdata.config.AppConfig;
import com.nttdata.loader.ResumeLoader;

public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class)) {
            ResumeLoader resumeLoader = applicationContext.getBean(ResumeLoader.class);
            resumeLoader.loadResume(" ");
            logger.info("[ APPLICATION STARTED ]");
        }
    }
}
