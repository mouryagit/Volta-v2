package com.volta.voltav2;

import com.volta.voltav2.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class VoltaV2Application {

    public static void main(String[] args) {

        SpringApplication.run(VoltaV2Application.class, args);
    }

}
