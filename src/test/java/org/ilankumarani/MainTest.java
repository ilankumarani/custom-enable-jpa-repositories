package org.ilankumarani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.ilan.entity", "io.ilan.entity"})
public class MainTest {

    public static void main(String[] args) {
        SpringApplication.run(MainTest.class, args);
    }
}
