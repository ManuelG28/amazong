package com.kap.amazong;

import com.kap.amazong.music.genre.GenreService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    public GenreService genreService() {
        return Mockito.mock(GenreService.class);
    }
}

