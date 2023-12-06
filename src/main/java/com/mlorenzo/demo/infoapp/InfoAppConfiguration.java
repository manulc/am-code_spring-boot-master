package com.mlorenzo.demo.infoapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class InfoAppConfiguration {
    private final String companyName;
    private final Environment env;

    public InfoAppConfiguration(@Value("${info.company.name}") String companyName, Environment env) {
        this.companyName = companyName;
        this.env = env;
    }

    @Bean("infoAppRunner")
    public CommandLineRunner runner(InfoApp infoApp) {
        return args -> {
            System.out.println(infoApp);
            System.out.println(companyName);
            System.out.println(env.getProperty("info.company.name"));
        };
    }
}
