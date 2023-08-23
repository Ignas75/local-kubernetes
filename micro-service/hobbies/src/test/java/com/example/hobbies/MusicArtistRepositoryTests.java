package com.example.hobbies;

import com.example.hobbies.pojo.MusicArtist;
import com.example.hobbies.repositories.MusicArtistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import javax.transaction.Transactional;


@DataJpaTest
@ActiveProfiles("test")
public class MusicArtistRepositoryTests {
    @Autowired
    private MusicArtistRepository musicArtistRepository;

    private final MusicArtist artistToFind = new MusicArtist("John Doe");

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @Transactional
    public void testH2Usage() {
        // Create and persist a test entity;
        System.out.println("\n\n\n\nPOJO to string: " + artistToFind);
        testEntityManager.persistAndFlush(artistToFind);
        System.out.println("\n\n\n\nrepository find all: " + musicArtistRepository.findAll());
        // Query the entity from the database
        MusicArtist found = musicArtistRepository.getByName("John Doe");

        // Assert that the entity was found
        assertThat(found.getName()).isEqualTo(artistToFind.getName());
    }

    @Test
    public void testGetByName() {
        musicArtistRepository.save(artistToFind);
        System.out.println("\n\n\n\nPOJO to string: " + artistToFind);
        System.out.println("\n\n\n\nrepository find all: " + musicArtistRepository.findAll());
        MusicArtist found = musicArtistRepository.getByName("John Doe");
        assertThat(found.getName()).isEqualTo(artistToFind.getName());
    }

    // @Test
    // public void testFindById() {
    //     entityManager.persist(artist);
    //     entityManager.flush();

    //     MusicArtist found = musicArtistRepository.getReferenceById(1);
    //     assertThat(found.getName()).isEqualTo(artist.getName());
    // }
}
