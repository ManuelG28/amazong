package com.kap.amazong;

import com.github.javafaker.Faker;
import com.kap.amazong.music.artist.Artist;
import com.kap.amazong.music.artist.ArtistRepository;
import com.kap.amazong.music.genre.Genre;
import com.kap.amazong.music.genre.GenreRepository;
import com.kap.amazong.music.song.Song;
import com.kap.amazong.music.song.SongRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class DatabaseSeeder {

    private final SongRepository songRepository;

    private final ArtistRepository artistRepository;

    private final GenreRepository genreRepository;

    public DatabaseSeeder(SongRepository songRepository, ArtistRepository artistRepository, GenreRepository genreRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.genreRepository = genreRepository;
    }

    @EventListener
    public void seedDatabase(ContextRefreshedEvent refreshedEvent) {
        if (songRepository.findAll().isEmpty() && artistRepository.findAll().isEmpty()) {
            seedArtistTable();
            seedGenreTable();
            seedSongTable();
        }
    }

    private void seedArtistTable() {
        for (int i = 0; i < 70; i++) {
            Faker faker = new Faker();
            Artist artist = new Artist(faker.rockBand().name());
            artistRepository.save(artist);
        }
    }

    private void seedGenreTable() {
        Set<String> genresFaker = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Faker faker = new Faker();
            genresFaker.add(faker.music().genre());
        }

        genresFaker.forEach((genreName) -> {
            Genre genre = new Genre(genreName);
            genreRepository.save(genre);
        });
    }

    private void seedSongTable() {
        for (int i = 0; i < 50; i++) {
            Faker faker = new Faker();
            List<Genre> genres = genreRepository.findAll();
            Genre genre = genres.get(new Random().nextInt(genres.size() - 1));
            Song song = new Song(faker.music().chord(), genre, faker.funnyName().name());
            songRepository.save(song);
        }
    }

}
