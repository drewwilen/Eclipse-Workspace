package FourFinal;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datasource {

	public static final String DB_NAME = "sharktank.db";// creating all our favorite constants -- love to see it -- constants are public and final for easier access
	public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Drew/eclipse-workspace/CS4Final/" + DB_NAME; //connection address -- you may want to change																					// system
	public static final String TABLE_SHARKS = "sharks";
	public static final String TABLE_COMPANIES = "companies";
	public static final String TABLE_DEALS = "deals";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_NETWORTH = "networth";

	public static final String COLUMN_COMPANY = "company";
	public static final String COLUMN_PRODUCT = "product";
	public static final String COLUMN_VALUATION = "valuation";

	public static final String COLUMN_SHARK = "shark";
	public static final String COLUMN_DEAL = "deal";

	public static final String View1 = "SELECT " + TABLE_SHARKS + "." + COLUMN_NAME + ", " + TABLE_SHARKS + "."
			+ COLUMN_NETWORTH + ", " + TABLE_DEALS + "." + COLUMN_DEAL + ", " + TABLE_COMPANIES + "." + COLUMN_PRODUCT
			+ ", " + TABLE_COMPANIES + "." + COLUMN_VALUATION + " FROM " + TABLE_DEALS + " JOIN " + TABLE_SHARKS
			+ " ON " + TABLE_SHARKS + "." + COLUMN_ID + " = " + TABLE_DEALS + "." + COLUMN_SHARK + " JOIN "
			+ TABLE_COMPANIES + " ON " + TABLE_COMPANIES + "." + COLUMN_ID + " = " + TABLE_DEALS + "." + COLUMN_COMPANY;// Creates
																														// selection
																														// statement
																														// for
																														// the
																														// first
																														// view

	public static final String View2 = "SELECT " + TABLE_COMPANIES + "." + COLUMN_PRODUCT + ", " + TABLE_COMPANIES + "."
			+ COLUMN_VALUATION + ", " + TABLE_DEALS + "." + COLUMN_DEAL + " FROM " + TABLE_COMPANIES + " JOIN "
			+ TABLE_DEALS + " ON " + TABLE_COMPANIES + "." + COLUMN_ID + " = " + TABLE_DEALS + "." + COLUMN_COMPANY;// creates
																													// selection
																													// statement
																													// for
																													// second
																													// view

	private Connection conn = null;// creates connection, statment, and resultset
	private static Statement statement = null;
	private static ResultSet results = null;

	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);// opens connection
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void close() {// closes connection
		try {
			// results.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createSharks() {// creates all the data for the shark table
		try {

			statement.execute("DROP TABLE IF EXISTS " + TABLE_SHARKS);// drops it if it exists, and then creates it
																		// again (so i don't have to deal with other
																		// stuff)

			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_SHARKS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, "
					+ COLUMN_NAME + " text, " + COLUMN_NETWORTH + " INTEGER)");
			statement.execute("INSERT INTO " + TABLE_SHARKS + "(" + COLUMN_NAME + " , " + COLUMN_NETWORTH
					+ ") VALUES ('Kevin OLeary', 400000000)");
			statement.execute("INSERT INTO " + TABLE_SHARKS + "(" + COLUMN_NAME + " , " + COLUMN_NETWORTH
					+ ") VALUES ('Mark Cuban', 4400000000)");
			statement.execute("INSERT INTO " + TABLE_SHARKS + "(" + COLUMN_NAME + " , " + COLUMN_NETWORTH
					+ ") VALUES ('Lori Greiner', 150000000)");
			statement.execute("INSERT INTO " + TABLE_SHARKS + "(" + COLUMN_NAME + " , " + COLUMN_NETWORTH
					+ ") VALUES ('Daymond John', 350000000)");
			statement.execute("INSERT INTO " + TABLE_SHARKS + "(" + COLUMN_NAME + " , " + COLUMN_NETWORTH
					+ ") VALUES ('Robert Herjavec', 200000000)");
			statement.execute("INSERT INTO " + TABLE_SHARKS + "(" + COLUMN_NAME + " , " + COLUMN_NETWORTH
					+ ") VALUES ('Barbara Corcoran', 80000000)");

		} catch (SQLException e) {
			// In case of error
			e.printStackTrace();
			System.out.println("In Sharks");

		}

	}

	public void createCompanies() {// creates companies -- some comments were just for me to be able to remember as i entered
		try {
			statement.execute("DROP TABLE IF EXISTS " + TABLE_COMPANIES);// drops companies if it exists and then
																			// remakes it

			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_COMPANIES + " (" + COLUMN_ID
					+ " INTEGER PRIMARY KEY, " + COLUMN_PRODUCT + " text, " + COLUMN_VALUATION + " INTEGER)");
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Squatty Potty', 7000000)");// Lori
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('The Original Comfy', 250000)");// Barb
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Scrub Daddy', 1000000)");// Lori
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Adventure Hunt', 1500000)");// Robert
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Solsource', 16666667)");// Cubes
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Guzzle Buddy', 4000000)");// DJ
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('RounderBum', 1500000)");// KEVIN
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Coffee Meets Bagel', 10000000)");// KEVIN
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Bombas', 4000000)");// DJ
			statement.execute("INSERT INTO " + TABLE_COMPANIES + "(" + COLUMN_PRODUCT + " , " + COLUMN_VALUATION
					+ ") VALUES ('Ten Thirty One Haunted Hayrides', 2000000)");// Cubes

		} catch (SQLException e) {
			// In case of error
			e.printStackTrace();
			System.out.println("In Companies");

		}

	}

	public void createDeals() {// creates deals
		try {
			statement.execute("DROP TABLE IF EXISTS " + TABLE_DEALS);// drops it if it exists, and then creates it

			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_DEALS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, "// deals
																														// have
																														// an
																														// id,
																														// a
																														// deal
																														// (what
																														// was
																														// accepted)
																														// a
																														// company,
																														// and
																														// a
																														// corresponding
																														// shark
					+ COLUMN_DEAL + " text, " + COLUMN_SHARK + " INTEGER, " + COLUMN_COMPANY + " INTEGER, "
					+ "FOREIGN KEY(" + COLUMN_SHARK + ") REFERENCES " + TABLE_SHARKS + "(" + COLUMN_ID + "), "
					+ "FOREIGN KEY(" + COLUMN_COMPANY + ") REFERENCES " + TABLE_COMPANIES + "(" + COLUMN_ID + ")) ");
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('350,000 for 10%', 1, 3)");// Deal for Squatty
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('50,000 for 20%', 2, 6)");// Deal for Comfy
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('200,000 for 20%', 3, 3)");// Deal for Scrub
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('150,000 for 20%', 4, 5)");// Deal for Adventure
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('500,000 for 4%', 5, 2)");// Deal for Solsource
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('400,000 for 25%', 6, 4)");// Deal for Guzzle Buddy
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('150,000 for 5% with a Royalty of $2/unit', 7, 1)");// Deal for
																									// RounderBum
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('200,000 for 17.5%', 9, 4)");// Deal for Bombas
			statement.execute("INSERT INTO " + TABLE_DEALS + "(" + COLUMN_DEAL + " , " + COLUMN_COMPANY + ", "
					+ COLUMN_SHARK + ") VALUES ('2,000,000 for 20%', 10, 2)");// Deal for Ten Thirty One Haunted
																				// Hayrides

		} catch (SQLException e) {
			// in case of error:
			e.printStackTrace();
			System.out.println("In Deal");
		}
	}

	public static List<Shark> querySharks() {
		try {// gets all the sharks using sqlite, uses the resultset to get the data for each
				// shark, and uses the result set to create an arraylist and return it
			results = statement.executeQuery("SELECT * FROM " + TABLE_SHARKS);

			List<Shark> sharks = new ArrayList<Shark>();

			while (results.next()) {
				sharks.add(new Shark(results.getString(COLUMN_NAME), results.getDouble(COLUMN_NETWORTH)));
			}

			return sharks;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println("Error");
			return null;
		}

	}

	public static List<Company> queryCompanies() {
		try {// gets all the companies using sqlite, uses the resultset to get the data for
				// each shark, and uses the result set to create an arraylist and return it
			results = statement.executeQuery("SELECT * FROM " + TABLE_COMPANIES);

			List<Company> companies = new ArrayList<Company>();

			while (results.next()) {
				companies.add(new Company(results.getString(COLUMN_PRODUCT), results.getInt(COLUMN_VALUATION)));
			}

			return companies;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println("Error");
			return null;
		}

	}

	public static List<Deal> queryDeals() {
		try {// gets all the sharks using sqlite, uses the resultset to get the data for each
				// company, and uses the result set to create an arraylist and return it
			results = statement.executeQuery("SELECT * FROM " + TABLE_DEALS);
			List<Deal> deals = new ArrayList<Deal>();

			while (results.next()) {
				deals.add(new Deal(results.getString(COLUMN_DEAL), results.getInt(COLUMN_SHARK),
						results.getInt(COLUMN_COMPANY)));
			}

			return deals;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println("Error");
			return null;
		}

	}

	public void showView(String view, String order) {// paramaters -- which of the two views, and what the order should
														// be (order is made as an addition to the sql command when
														// called
		try {
			ResultSet r = statement.executeQuery("SELECT  * FROM " + view + " ORDER BY " + order);// Selects

			while (r.next()) {// displays the returned info using a resultset
				if (view == "fullView") {
					System.out.println(r.getString(COLUMN_NAME) + " | " + r.getString(COLUMN_NETWORTH) + " | "
							+ r.getString(COLUMN_DEAL) + " | " + r.getString(COLUMN_PRODUCT) + " | "
							+ r.getString(COLUMN_VALUATION));
				} else if (view == "otherView") {
					System.out.println(r.getString(COLUMN_PRODUCT) + " | " + r.getString(COLUMN_VALUATION) + " | "
							+ r.getString(COLUMN_DEAL));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void executeStatement(String line) {// simply an easy way to execute a statment through a datasource object
		try {
			statement.execute(line);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}
	}
}
