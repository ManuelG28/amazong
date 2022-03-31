package com.kap.amazong.music.song;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    Song findSongById(Long id);

    List<Song> findSongByGenre(String genre);
}
