package databasetest2;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datasource {

	public static final String DB_NAME = "music.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Drew/eclipse-workspace/DataBaseTestTwo/" + DB_NAME;
	public static final String TABLE_ALBUMS = "albums";
	public static final String TABLE_ARTISTS = "artists";
	public static final String TABLE_SONGS = "songs";

	
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_ARTIST = "artist";
	public static final String COLUMN_TRACK = "track";
	public static final String COLUMN_TITLE = "title";


	private Connection conn = null;
	private static Statement statement = null;
	private static ResultSet results = null;
	
	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void close() {
		try {
			//results.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static List<Artist> queryArtists(){
		try {
			results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS); // +" ORDER BY " + COLUMN_NAME  + " COLLATE NOCASE");
			
			List<Artist> artists = new ArrayList();
			
			while(results.next()) {
				artists.add(new Artist(results.getInt(COLUMN_ID), results.getString(COLUMN_NAME)));
			}
			
			return artists;
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println("OOF");
			return null;
		}
		
	}
	
	public static List<Albums> queryAlbums(){
		try {
			results = statement.executeQuery("SELECT * FROM " + TABLE_ALBUMS);  // + " ORDER BY " + COLUMN_NAME);//  + " COLLATE NOCASE");
			
			List<Albums> albums = new ArrayList();
			
			while(results.next()) {
				albums.add(new Albums(results.getInt(COLUMN_ID), results.getString(COLUMN_NAME), results.getInt(COLUMN_ARTIST)));
			}
			
			return albums;
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println("OOF");
			return null;
		}
		
	}
	
	public static List<Song> querySongs(){
		try {
			results = statement.executeQuery("SELECT * FROM " + TABLE_SONGS);// " ORDER BY " + COLUMN_NAME );// + " COLLATE NOCASE");
			
			List<Song> songs = new ArrayList();
			
			while(results.next()) {
				songs.add(new Song(results.getInt(COLUMN_ID), results.getInt(COLUMN_TRACK), results.getString(COLUMN_TITLE), results.getInt(COLUMN_ARTIST)));
			}
			
			return songs;
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println("OOF");
			return null;
		}
		
	}
}
