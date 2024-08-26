package lern.spring.users.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCofiguration implements WebMvcConfigurer {

    public void addCorsMapping(CorsRegistry corsRegistry) {corsRegistry.addMapping("/**").allowedMethods("*");}
}
