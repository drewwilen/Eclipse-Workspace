package databasetest2;

import java.util.*;

public class Main {

	Datasource data = new Datasource();

	// public List<Artist> artists;
	public Main() {

		if (!data.open()) {

			System.out.println("Can't open datasounrce.");
			return;
		}

		List<Artist> artists = data.queryArtists();
		List<Albums> albums = data.queryAlbums();
		List<Song> songs = data.querySongs();

		if (artists == null) {
			System.out.println("No Artists Found.");
			return;
		}

		for (Artist artist : artists) {
			System.out.println(artist);
		}
		for (Albums album : albums) {
			System.out.println(album);
		}
		data.close();
	}

	public static void main(String[] args) {
		new Main();
	}

}
