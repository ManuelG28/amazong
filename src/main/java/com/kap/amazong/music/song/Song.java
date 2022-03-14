package com.kap.amazong.music.song;


import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "chord")
    private String chord;

    @Column(name = "genre")
    private String genre;

    public Song(String chord, String genre) {
        this.chord = chord;
        this.genre = genre;
    }

    protected Song() {
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", chord='" + chord + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
