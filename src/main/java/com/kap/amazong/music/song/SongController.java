package com.kap.amazong.music.song;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/list")
    public List<Song>getAllSongs(){
        return songService.getAllSongs();
    }

}
