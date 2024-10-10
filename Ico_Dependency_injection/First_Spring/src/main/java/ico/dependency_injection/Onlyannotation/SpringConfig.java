package ico.dependency_injection.Onlyannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("ico.dependency_injection.AnotationValue")
@PropertySource("classpath:musicPlayer.properties") //откуда считываем значения
public class SpringConfig {
}
