package com.kap.amazong;

import com.github.javafaker.Faker;
import com.kap.amazong.music.song.Song;
import com.kap.amazong.music.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    private SongRepository songRepository;

    @Autowired
    public DatabaseSeeder(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @EventListener
    public void seedDatabase(ContextRefreshedEvent refreshedEvent){
        seedSongTable();
    }

    public void seedSongTable(){
        for(int i = 0; i < 50; i++){
            Faker faker = new Faker();
            Song song = new Song(faker.music().chord(), faker.music().genre());
            songRepository.save(song);
        }
    }

}
