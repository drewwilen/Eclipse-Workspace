package associationTest;

import java.util.*;

public class Album {
	private String title, artist;
	private int year;
	ArrayList<Song> songList = new ArrayList<Song>();

	public Album(String title, String artist, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	public void songAdd(String title, String min, String sec) {
		songList.add(new Song(title, min, sec));
	}

	public void displayTrackList() {
		for (int i = 0; i < songList.size(); i++) {
			int index = i + 1;
			System.out.println(index + ") " + songList.get(i).displayTrack());
		}
	}

	public void display() {
		System.out.println(title + "\n" + artist + " (" + year + ")");
		displayTrackList();
		int totalTime = 0;
		for (Song s : songList) {
			totalTime += s.getTotSecond();
		}
		int totalMin = totalTime / 60;
		int totalSec = totalTime % 60;
		System.out.println("Total Time: " + totalMin + ":" + totalSec);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public class Song {
		String title;
		String min, sec;

		public Song(String title, String min, String sec) {
			super();
			this.title = title;
			this.min = min;
			this.sec = sec;
		}

		public int getTotSecond() {
			return Integer.parseInt(min) * 60 + Integer.parseInt(sec);
		}

		public String displayTrack() {
			return title + " - " + min + ":" + sec;
		}

	}
}
