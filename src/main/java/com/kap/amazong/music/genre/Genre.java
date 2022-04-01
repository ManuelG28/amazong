package com.kap.amazong.music.genre;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kap.amazong.music.song.Song;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    public Genre(String name) {
        this.name = name;
    }

    protected Genre() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Song> songs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
