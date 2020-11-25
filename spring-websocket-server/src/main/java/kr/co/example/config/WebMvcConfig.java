package kr.co.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc 설정
 *
 * @author EDA
 * @since 2020-11-25
 * @see {@link WebMvcConfigurer}
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "*")
                .allowedHeaders("x-token")
                .allowCredentials(false)
                .maxAge(6000);
    }
}
