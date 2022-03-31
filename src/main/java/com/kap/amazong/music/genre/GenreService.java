package com.kap.amazong.music.genre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Optional<Genre> getGenreByName(String name) {
        return Optional.ofNullable(genreRepository.findGenreByName(name));
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
}
