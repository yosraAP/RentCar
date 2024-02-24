package com.example.projectgestionlocationvoiture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan({"com.example.projectgestionlocationvoiture.controlleur", "com.example.projectgestionlocationvoiture.service"})
//@EnableJpaRepositories("com.example.projectgestionlocationvoiture.repository")
@SpringBootApplication
public class ProjectGestionLocationVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectGestionLocationVoitureApplication.class, args);
    }

}
