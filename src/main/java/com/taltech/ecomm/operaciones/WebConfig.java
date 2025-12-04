package com.taltech.ecomm.operaciones;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todas las URLs
                .allowedOrigins("*") // Permite TODOS los orígenes (incluido 127.0.0.1 y localhost)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite todos los métodos
                .allowedHeaders("*"); // Permite todas las cabeceras
    }
}
