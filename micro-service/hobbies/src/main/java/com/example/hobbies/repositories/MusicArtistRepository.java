package com.example.hobbies.repositories;

import com.example.hobbies.pojo.MusicArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicArtistRepository extends JpaRepository<MusicArtist, Integer>{
    boolean existsByName(String name);
    MusicArtist getByName(String name);
}
