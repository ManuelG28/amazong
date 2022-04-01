package com.kap.amazong.music.song;

import com.kap.amazong.music.genre.Genre;
import com.kap.amazong.music.genre.GenreService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration
public class GenreServiceTest {

    @Configuration
    public static class TestConfiguration {
        @Bean
        @Primary
        public GenreService genreService() {
            return Mockito.mock(GenreService.class);
        }
    }

    @MockBean
    private GenreService genreService;

    @BeforeEach
    public void contextLoaded() {
        assertNotNull(genreService);
    }

    @Test
    public void foundGenreByName() {
        Mockito.when(genreService.getGenreByName("tiny")).thenReturn(Optional.of(new Genre("tiny")));
        Optional<Genre> optionalGenre = genreService.getGenreByName("tiny");
        assertTrue(optionalGenre.isPresent());
    }

    @Test
    public void notFoundGenreByName() {
        assertFalse(genreService.getGenreByName("tiny").isPresent());
    }

    @Test
    public void getSongsInGenre() {
        Genre newGenre = new Genre("new random gender");
        Song harrysSong = new Song("#45A", newGenre, "As it was");
        Song bobsSong = new Song("#45B", newGenre, "As it is");
        Set<Song> newSongs = Set.of(harrysSong, bobsSong);
        newGenre.getSongs().addAll(newSongs);
        Mockito.when(genreService.getSongs(0L)).thenReturn(newSongs);
        assertTrue(CollectionUtils.isEqualCollection(genreService.getSongs(0L), newSongs));
    }

}
