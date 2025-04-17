### How to use the Annotation in springBoot code

```java
import org.ilan.annotation.AbdEnableJpaRepositories;
import org.springframework.context.annotation.Configuration;

@AbdEnableJpaRepositories(basePackages = "${jpa.repositories.base-packages}")
@Configuration
public class DefaultDbConfig {
}
```

### How specify the repositories to scan from application.yml
```yaml
jpa:
  repositories:
    base-packages: com.ilan.repository,io.ilan.repository
```