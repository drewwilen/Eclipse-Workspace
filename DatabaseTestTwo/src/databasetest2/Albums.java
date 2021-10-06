package databasetest2;

public class Albums {

	public int _id, artist;
	public String name;

	public Albums(int _id, String name, int artist) {
		super();
		this._id = _id;
		this.artist = artist;
		this.name = name;
	}
	
	public String toString() {
		return "ID: " + _id + ", Artist: " + artist + ", Name: " + name ;
	}
}
