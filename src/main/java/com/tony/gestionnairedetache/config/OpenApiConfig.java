package com.tony.gestionnairedetache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        OpenAPI openAPI = new OpenAPI();
        Info info = new Info();
        Contact contact = new Contact();
    

        info.setTitle("API de gestion de tâche");
        info.setDescription("Ceci est une API de gestion de tâches. Elle permet de consulter, créer, supprimer et mettre à jour des tâches.");
        
        contact.setName("Tony MBOUZEKO");
        contact.setEmail("tony-bonnel.mbouzeko-mouafo.1@ens.etsmtl.ca");
        contact.setUrl("https://github.com/TonyMbouzeko/Gestionnaire-de-t-che-java");
        info.setContact(contact);

        info.setVersion("1.0");
        
        openAPI.setInfo(info);

        return openAPI;
    }  
}
