package com.buutcamp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.buutcamp")
@PropertySource("classpath:webconfig.properties")
public class WebMvcConfig {

    @Value("${prefix}")
    private String prefix;
    @Value("${suffix}")
    private String suffix;

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBVR = new UrlBasedViewResolver();
        urlBVR.setPrefix(prefix);
        urlBVR.setSuffix(suffix);
        urlBVR.setViewClass(JstlView.class);

        return urlBVR;
    }
}