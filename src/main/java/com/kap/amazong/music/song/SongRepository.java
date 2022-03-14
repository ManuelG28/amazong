package com.kap.amazong.music.song;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    Song findSongById(Long id);
}
