package com.example.hobbies.controllers;

import com.example.hobbies.repositories.MusicArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {
    @Autowired
    MusicArtistRepository musicArtistRepository;

    @GetMapping("/music/artists/{name}")
    public ResponseEntity<String> getMusicArtist(@PathVariable String name){
        if(musicArtistRepository.existsByName(name)){
            return new ResponseEntity<>(musicArtistRepository.getByName(name).toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("No music artist was found. Try a different name.", HttpStatus.OK);
    }

    @GetMapping("/music/artists/get/{id}")
    public ResponseEntity<String> getMusicArtistById(@PathVariable int id){
        if(musicArtistRepository.existsById(id)){
            return new ResponseEntity<>(musicArtistRepository.getReferenceById(id).toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("No music artist was found. Try a different id.", HttpStatus.OK);
    }
}
