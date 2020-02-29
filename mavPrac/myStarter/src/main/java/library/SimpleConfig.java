package library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
public class SimpleConfig {

    @Bean
    @ConditionalOnProperty(value = "my.property", havingValue = "custom")
    SimpleS custom() {
        return new SimpleSC();
    }

    @Bean
    @ConditionalOnProperty(value = "my.property", havingValue = "default", matchIfMissing = true)
    SimpleS defaultComponent() {
        return new SimplesSD();
    }
}
