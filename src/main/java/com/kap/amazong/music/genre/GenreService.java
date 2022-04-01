package com.kap.amazong.music.genre;

import com.kap.amazong.music.song.Song;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Optional<Genre> getGenreByName(String name) {
        return Optional.ofNullable(genreRepository.findGenreByName(name));
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Set<Song> getSongs(Long id) {
        return genreRepository.getById(id).getSongs();
    }
}
