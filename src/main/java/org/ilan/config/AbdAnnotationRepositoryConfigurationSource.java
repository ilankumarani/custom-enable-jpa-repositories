package org.ilan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.data.util.Streamable;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.StringValueResolver;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;


/**
 * @See import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
 */
public class AbdAnnotationRepositoryConfigurationSource extends AnnotationRepositoryConfigurationSource implements EmbeddedValueResolverAware {

    private static final Logger logger = Logger.getLogger(AbdAnnotationRepositoryConfigurationSource.class.getName());

    private static final String BASE_PACKAGES = "basePackages";
    private final AnnotationAttributes attributes;
    private final AnnotationMetadata configMetadata;
    private final Environment environment;
    private StringValueResolver stringValueResolver;


    public AbdAnnotationRepositoryConfigurationSource(AnnotationMetadata metadata, Class<? extends Annotation> annotation, ResourceLoader resourceLoader, Environment environment, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        super(metadata, annotation, resourceLoader, environment, registry, importBeanNameGenerator);

        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(annotation.getName());
        if (annotationAttributes == null) {
            throw new IllegalStateException(String.format("Unable to obtain annotation attributes for %s", annotation));
        } else {
            this.attributes = new AnnotationAttributes(annotationAttributes);
            this.configMetadata = metadata;
            this.environment = environment;
        }
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        logger.info("StringValueResolverProvider is loaded");
        this.stringValueResolver = stringValueResolver;
    }

    public Streamable<String> getBasePackages() {
        String[] value = this.attributes.getStringArray("value");
        String[] basePackages = this.attributes.getStringArray(BASE_PACKAGES);

        String[] packagesFromValue = parsePackagesSpell(value[0]);
        String[] packagesFromBasePackages = parsePackagesSpell(basePackages[0]);

        Class<?>[] basePackageClasses = this.attributes.getClassArray("basePackageClasses");
        if (value.length == 0 && basePackages.length == 0 && basePackageClasses.length == 0) {
            String className = this.configMetadata.getClassName();
            return Streamable.of(new String[]{ClassUtils.getPackageName(className)});
        } else {
            Set<String> packages = new HashSet(value.length + basePackages.length + basePackageClasses.length);
            packages.addAll(Arrays.asList(packagesFromValue));
            packages.addAll(Arrays.asList(packagesFromBasePackages));

            for (Class<?> c : basePackageClasses) {
                packages.add(ClassUtils.getPackageName(c));
            }

            return Streamable.of(packages);
        }
    }


    private String[] parsePackagesSpell(String raw) {
        if (!raw.trim().startsWith("$")) {
            if (StringUtils.isEmpty(raw)) {
                return new String[]{};
            }
            return raw.split(",");
        } else {
            raw = raw.trim();
            String packages = stringValueResolver.resolveStringValue(raw);
            return packages.split(",");
        }
    }
}
