package dbtest;

import java.sql.*;

public class Main {

	public static final String DB_NAME = "test.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Drew/eclipse-workspace/DatabaseTest/" + DB_NAME;
	public static final String TABLE_CONTACTS = "contacts";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_EMAIL = "email";
	static Connection conn = null;
	static Statement statement = null;
	static ResultSet results = null;

	public Main() {
		try {
			// conn =
			// DriverManager.getConnection("jdbc:sqlite:/Users/Drew/eclipse-workspace/DatabaseTest/test.db");
			conn = DriverManager.getConnection(CONNECTION_STRING);

			statement = conn.createStatement();

			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" + COLUMN_NAME + " TEXT, "
					+ COLUMN_PHONE + "INTEGER, " + COLUMN_EMAIL + " TEXT)");
			// statement.execute("INSERT INTO contacts (name, phone, email)" + "
			// VALUES('brutha', 13432, 'jfadd@gmail.com')");
			// statement.execute("UPDATE contacts SET email = 'jimmothyneutron@gmail.gov'
			// WHERE name = 'jimbo'");
			// statement.execute("DELETE FROM contacts where name = 'paulina'");
			// statement.execute("SELECT * FROM contacts ORDER BY name COLLATE NOCASE");
			insertContact("'UR MOM'", 912364323, "'mom@gmail.com'");
			results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
			while (results.next()) {
				System.out.println(results.getString(COLUMN_NAME) + " " + results.getInt(COLUMN_PHONE) + " "
						+ results.getString(COLUMN_EMAIL));
			}

		} catch (Exception e) {
			System.out.println("Bad thing " + e.getMessage());
		} finally {
			try {
				results.close();
				statement.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Bad thing!");

			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

	public static void insertContact(String name, int phone, String email) {
		try {
			statement.execute("INSERT INTO " + TABLE_CONTACTS + " VALUES ( " + name + ", " + phone + ", " + email + ");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
