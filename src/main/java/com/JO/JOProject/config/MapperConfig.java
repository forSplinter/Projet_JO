package com.JO.JOProject.config;

import com.JO.JOProject.domain.dto.EventDto;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import com.JO.JOProject.domain.entity.EventEntity;
import com.JO.JOProject.domain.entity.SiteEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  MapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        return modelMapper;
    }
}
