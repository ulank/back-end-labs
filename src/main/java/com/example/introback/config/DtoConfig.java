package com.example.introback.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ulan on 2/25/2023
 */
@Configuration
public class DtoConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
