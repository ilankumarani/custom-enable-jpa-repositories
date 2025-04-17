package org.ilan.config;


import org.ilan.annotation.AbdEnableJpaRepositories;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

import java.lang.annotation.Annotation;

/**
 * import org.springframework.data.jpa.repository.config.JpaRepositoriesRegistrar;
 */
public class AbdJpaRepositoriesRegistrar extends AbdRepositoryBeanDefinitionRegistrarSupport {


    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return AbdEnableJpaRepositories.class;
    }

    @Override
    protected RepositoryConfigurationExtension getExtension() {
        return new JpaRepositoryConfigExtension();
    }
}
