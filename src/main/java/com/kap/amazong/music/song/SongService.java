package com.kap.amazong.music.song;

import com.kap.amazong.music.genre.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final Logger logger = LoggerFactory.getLogger(SongService.class);

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @EntityGraph(attributePaths = {"genre"} , type = EntityGraph.EntityGraphType.FETCH)
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongByGenre(Genre genre) {
        return songRepository.findSongByGenre(genre);
    }
}
