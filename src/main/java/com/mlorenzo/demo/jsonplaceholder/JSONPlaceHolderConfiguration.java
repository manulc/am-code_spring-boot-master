package com.mlorenzo.demo.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfiguration {

    @Bean("jsonPlaceHolderRunner")
    public CommandLineRunner runner(JSONPlaceHolderClient client) {
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/posts");
            System.out.println(client.getPosts().size());
            System.out.println();
            System.out.println("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println(client.getPost(1));
        };
    }
}
