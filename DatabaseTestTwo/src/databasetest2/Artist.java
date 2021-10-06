package databasetest2;

public class Artist {
	private int _id;
	private String name;
	public Artist(int _id, String name) {
		super();
		this._id = _id;
		this.name = name;
	}
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ID: " + _id + ", Name: " + name;
	}
	
	
}
