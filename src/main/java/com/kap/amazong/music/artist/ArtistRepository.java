package com.kap.amazong.music.artist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository <Artist, Long>{
    Artist findArtistById(Long id);

    List<Artist> findArtistsByName(String name);
}
