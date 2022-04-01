package com.kap.amazong.music.artist;

import com.kap.amazong.music.song.Song;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {

    public Artist(String name) {
        this.name = name;
    }

    protected Artist() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch =  FetchType.LAZY)
    @JoinTable(
            name = "Artist_Song",
            joinColumns = {@JoinColumn(name = "artist_id", referencedColumnName ="id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id", referencedColumnName ="id")}
    )
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
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }
}
