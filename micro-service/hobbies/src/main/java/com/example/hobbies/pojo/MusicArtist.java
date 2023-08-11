package com.example.hobbies.pojo;

import javax.persistence.*;

@Entity
@Table(name = "music_artists")
public class MusicArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_artists_id")
    private int id;

    @Column
    private String name;

    public MusicArtist(){
    }

    public MusicArtist(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getString(){
        return name;
    }

    public String toString() {
        return "music_artist{" +
                "name:=" + name + "}";
    }
}
