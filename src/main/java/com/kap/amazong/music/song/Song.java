package com.kap.amazong.music.song;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kap.amazong.music.artist.Artist;
import com.kap.amazong.music.genre.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Song {

    public Song(String chord, Genre genre, String name) {
        this.chord = chord;
        this.genre = genre;
        this.name = name;
    }

    protected Song() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "chord")
    private String chord;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE
    })
    private Set<Artist> artists = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    @JsonBackReference
    private Genre genre;

    public Long getId() {
        return id;
    }

    public String getChord() {
        return chord;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", chord='" + chord + '\'' +
                ", name='" + name + '\'' +
                ", genre=" + genre.getName() +
                '}';
    }
}
