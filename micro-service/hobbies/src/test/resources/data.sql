CREATE TABLE IF NOT EXISTS music_artists (
	music_artists_id serial PRIMARY KEY, 
	name VARCHAR ( 50 ) NOT NULL
);

INSERT INTO music_artists (music_artists_id, name) VALUES (1, 'Unlike Pluto');