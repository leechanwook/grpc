package com.cu.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
public class WebConfigure implements WebMvcConfigurer {

    @Bean
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }

}
