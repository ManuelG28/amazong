package com.kap.amazong.music.artist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("artist")
public class ArtistController {

    private final ArtistService artistService;

    ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("list")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }
}
