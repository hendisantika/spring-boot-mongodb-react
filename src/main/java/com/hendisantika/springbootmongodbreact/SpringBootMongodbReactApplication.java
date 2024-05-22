package com.hendisantika.springbootmongodbreact;

import com.hendisantika.springbootmongodbreact.model.Contact;
import com.hendisantika.springbootmongodbreact.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootMongodbReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbReactApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ContactRepository contactRepository) {
        return args -> {
            contactRepository.save(new Contact("Itadori Yuji", "Tokyo", "Tokyo", "+6281321411801", "yuji@yopmail.com"));
            contactRepository.save(new Contact("Fushiguro Megumi", "Tokyo", "Tokyo", "+6281321411802", "megumi@yopmail.com"));
            contactRepository.save(new Contact("Satoru Gojo", "Tokyo", "Tokyo", "+6281321411803", "gojo@yopmail.com"));
            contactRepository.save(new Contact("Todo Aoi", "Tokyo", "Tokyo", "+6281321411804", "aoi@yopmail.com"));
            contactRepository.save(new Contact("Masamichi Yaga", "Tokyo", "Tokyo", "+6281321411805", "yaga@yopmail.com"));
        };
    }
}
