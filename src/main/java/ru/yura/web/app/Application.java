package ru.yura.web.app;
/*
 *
 *@Data 07.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.yura.web.service.PersonService;
import ru.yura.web.service.RoleService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = "ru")
@EnableJpaRepositories(basePackages = "ru")
@EntityScan(basePackages = "ru.yura")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    @Bean(initMethod = "init")
    @PostConstruct
    public TestDataInit initTestData() {
        return new TestDataInit();
    }
}
