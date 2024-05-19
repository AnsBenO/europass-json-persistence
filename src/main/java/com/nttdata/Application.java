package com.nttdata;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nttdata.config.AppConfig;
import com.nttdata.entities.Client;
import com.nttdata.services.ClientService;

public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class)) {
            ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
            List<Client> clients = clientService.findAll();
            logger.info("[ FOUND CLIENTS ] : {}", clients);
        }
    }
}
