package ua.boot.web;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Controller controller(){
        return new Controller();
    }
}
