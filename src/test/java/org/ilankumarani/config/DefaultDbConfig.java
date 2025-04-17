package org.ilankumarani.config;

import org.ilan.annotation.AbdEnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AbdEnableJpaRepositories(basePackages = "${jpa.repositories.base-packages}")
//@EnableJpaRepositories(basePackages = {"com.ilan.repository", "io.ilan.repository"})
@EntityScan({"com.ilan.entity", "io.ilan.entity"})
@Configuration
public class DefaultDbConfig {
}
