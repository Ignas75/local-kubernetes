CREATE TABLE music_artists (
	music_artists_id serial PRIMARY KEY, 
	name VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE song_genres (
	genre_id serial PRIMARY KEY,
	name VARCHAR (50) NOT NULL
);

CREATE TABLE songs (
	song_id serial PRIMARY KEY, 
	name VARCHAR ( 50 ) NOT NULL,
	music_artists_id INT NOT NULL, 
	FOREIGN KEY(music_artists_id)
		REFERENCES music_artists (music_artists_id)
);

CREATE TABLE genres_in_songs (
	genre_id INT,
	song_id INT,
	PRIMARY KEY (genre_id, song_id),
	FOREIGN KEY(genre_id)
		REFERENCES song_genres (genre_id),
	FOREIGN KEY(song_id) 
		REFERENCES songs (song_id)
);

CREATE TABLE song_feature (
	song_id INT,
	music_artists_id INT,
	PRIMARY KEY (song_id, music_artists_id),
	FOREIGN KEY (song_id)
		REFERENCES songs (song_id),
	FOREIGN KEY (music_artists_id) 
		REFERENCES music_artists(music_artists_id)
);

COPY music_artists(name)
FROM '/sample/music_artists.csv'
WITH (FORMAT csv);

COPY song_genres(name) 
FROM '/sample/song_genres.csv'
WITH (FORMAT csv);