package com.kap.amazong.music.song;

import com.kap.amazong.music.genre.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongByGenre(Genre genre) {
        return songRepository.findSongByGenre(genre);
    }
}
