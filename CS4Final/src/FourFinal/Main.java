package FourFinal;

import java.util.*;

public class Main {
	Datasource data = new Datasource();// creates the datasource, scanner, and arraylists for tables
	Scanner drew = new Scanner(System.in);
	List<Shark> sharks;
	List<Company> companies;
	List<Deal> deals;

	public Main() {
		if (!data.open()) {// opens up the data (unless it doesnt work and if so then it's over

			System.out.println("Can't open datasounrce.");
			return;
		}

		data.createSharks();// creates sharks
		data.createCompanies();// creates companies
		data.createDeals();// creates deals

		// executes a statment to create both views and gives them names fullView and
		// otherView
		data.executeStatement("CREATE VIEW IF NOT EXISTS fullView AS " + Datasource.View1);
		data.executeStatement("CREATE VIEW IF NOT EXISTS otherView AS " + Datasource.View2);

		sharks = Datasource.querySharks();// gets the sharks from the database (as an arraylist)
		companies = Datasource.queryCompanies();// gets the companies from the database (as an arraylist)
		deals = Datasource.queryDeals();// gets the deals from the database (as an arraylist)
		int ans = 0;
		System.out.println(
				"Welcome to the Shark Tank Database! This is the menu to browse/add/edit/view/update the data.");

		while (true) {// gives you choice of menu and depending on what you chose, corresponding thing
						// occurs
			ans = 0;// resets ans
			System.out.println("Menu:" + "\n 1)View Sharks" + "\n 2)View Companies" + "\n 3)View Deals"
					+ "\n 4)View of Sharks, Companies, and Deals" + "\n 5)View of Sharks and Deals" + "\n 6)Add Record"
					+ "\n 7)Remove Record" + "\n 8)Update a Record" + "\n 9)Leave");
			ans = drew.nextInt();
			drew.nextLine();
			if (ans == 1) {// 1 -shows you the sharks
				viewSharks();
			} else if (ans == 2) {// 2 -shows you the companies
				viewCompanies();
			} else if (ans == 3) {// 3 - shows you the deals
				viewDeals();
			} else if (ans == 4) {// shows you the first view -- also allows you to chose what secondary order the
									// view will be in
				System.out.println("Select secondary order (primary is sharks name):");
				String order = Datasource.COLUMN_NAME + ", " + selectOrder();
				data.showView("fullView", order);// shows you the view
			} else if (ans == 5) {
				System.out.println("Select primary order:");// allows choice of order and displays

				String order = selectOrder();
				data.showView("otherView", order);
			} else if (ans == 6) {
				System.out.println("What would you like to add?" + "\n1)Shark" + "\n2)Company" + "\n3)Deal");
				ans = drew.nextInt();// you chose what to add
				drew.nextLine();

				// selects corresponding data type and adds it (see add methods)
				if (ans == 1) {//
					addShark();
				} else if (ans == 2) {
					addCompany();
				} else if (ans == 3) {
					addDeal();
				}

			} else if (ans == 7) {
				System.out.println("What would you like to remove?" + "\n1)Shark" + "\n2)Company" + "\n3)Deal");
				int id = 0;// allows you to chose which table to remove from
				String table = "";
				ans = drew.nextInt();
				drew.nextLine();
				if (ans == 1) {// allows you to decide the id to remove, and removes it (here only from
								// Arraylist and later from sql)
					table = Datasource.TABLE_SHARKS;
					System.out.println("Enter ID of the shark you would like to remove");
					viewSharks();
					id = drew.nextInt();
					drew.nextLine();
					int removeNum = 0;
					for (int i = 0; i < sharks.size(); i++) {
						if (sharks.get(i).get_id() == id) {
							removeNum = i;
							break;
						}
					}
					sharks.remove(removeNum);
				} else if (ans == 2) {// allows you to decide the id to remove, and removes it (here only from
										// Arraylist and later from sql)
					table = Datasource.TABLE_COMPANIES;
					System.out.println("Enter ID of the company you would like to remove");
					viewCompanies();
					id = drew.nextInt();
					drew.nextLine();
					int removeNum = 0;
					for (int i = 0; i < companies.size(); i++) {
						if (companies.get(i).get_id() == id) {
							removeNum = i;
							break;
						}
					}
					companies.remove(removeNum);
				} else if (ans == 3) {// allows you to decide the id to remove, and removes it (here only from
										// Arraylist and later from sql)
					table = Datasource.TABLE_DEALS;
					System.out.println("Enter ID of the deal you would like to remove");
					viewDeals();
					id = drew.nextInt();
					drew.nextLine();
					int removeNum = 0;
					for (int i = 0; i < deals.size(); i++) {
						if (deals.get(i).get_id() == id) {
							removeNum = i;
							break;
						}
					}
					deals.remove(removeNum);
				}
				data.executeStatement("DELETE FROM " + table + " WHERE " + Datasource.COLUMN_ID + " = " + id);// deletes
																												// the
																												// actual
																												// record
																												// that
																												// you
																												// selected
																												// using
																												// SQL
																												// //
																												// database
			} else if (ans == 8) {
				update();// sends you to an update method for updating
			} else if (ans == 9) {
				break;// you get to leave
			}
		}
		data.close();

	}

	public static void main(String[] args) {
		new Main();
	}

	public String selectOrder() {
		System.out.println("Enter what to order by:" + "\n1)Product Name" + "\n2)Valuation" + "\n3)Deal");
		String order = "";// you select what to order by (primary for second view, secondary for first
							// view)
		int ans = drew.nextInt();

		if (ans == 3) {// sets corresponding answer properly
			order = Datasource.COLUMN_DEAL;
		} else if (ans == 2) {
			order = Datasource.COLUMN_VALUATION;
		} else if (ans == 1) {
			order = Datasource.COLUMN_PRODUCT;
		}
		return order;// returns corresponding collumn
	}

	public String selectTable(int table) {// allows you to select table to use in diff cases (sometimes also coded out
											// because implemented mid-project
		if (table == 1) {
			return Datasource.TABLE_SHARKS;
		} else if (table == 2) {
			return Datasource.TABLE_COMPANIES;
		} else {
			return Datasource.TABLE_DEALS;
		}
	}

	public void viewSharks() {// displays all sharks
		for (Shark s : sharks) {
			System.out.println(s);
		}
	}

	public void viewCompanies() {// displays all companies
		for (Company c : companies) {
			System.out.println(c);
		}
	}

	public void viewDeals() {// displays all deals
		System.out.println();
		for (Deal d : deals) {
			System.out.println(d);
		}
	}

	public void addShark() {
		System.out.println("Enter Name");// gets necessary information to add a shark
		String name = drew.nextLine();
		System.out.println("Enter Net Worth");
		int networth = drew.nextInt();
		drew.nextLine();// under this, adds that shark to the data
		data.executeStatement("INSERT INTO " + Datasource.TABLE_SHARKS + "(" + Datasource.COLUMN_NAME + " , " + Datasource.COLUMN_NETWORTH
				+ ") VALUES ('" + name + "', " + networth + ")");
		sharks.add(new Shark(name, networth));// adds that shark to shark arraylist
	}

	public void addCompany() {
		System.out.println("Enter Product");// gets info for company
		String product = drew.nextLine();
		System.out.println("Enter Company Valuation");
		int valuation = drew.nextInt();
		drew.nextLine();// Inserts this new company into the database
		data.executeStatement("INSERT INTO " + Datasource.TABLE_COMPANIES + "(" + Datasource.COLUMN_PRODUCT + " , "
				+ Datasource.COLUMN_VALUATION + ") VALUES ('" + product + "', " + valuation + ")");
		companies.add(new Company(product, valuation));// adds that company to company arraylist
	}

	public void addDeal() {
		System.out.println("Select Shark that made the deal (Enter the number of the shark):");
		viewSharks();// gets info for deal
		int shark = drew.nextInt();
		drew.nextLine();
		int ans = -1;
		while (ans <= 0 && ans < companies.size()) {// hear it allows you to actually create a new company if it doesn't
													// already exist for the deal
			System.out.println(
					"Select Company that made the deal (Enter the number of the company). If the company is not here and you would like to add a company, type -1:");
			viewCompanies();
			ans = drew.nextInt();
			drew.nextLine();
			if (ans == -1) {
				addCompany();
			}
		}
		System.out.println(
				"Enter the Deal, including equity, price, and any other relevant information (like a royalty)");
		String deal = drew.nextLine();
		// inserts the new deal into the database, and then the deals arraylist
		data.executeStatement("INSERT INTO " + Datasource.TABLE_DEALS + "(" + Datasource.COLUMN_DEAL + " , " + Datasource.COLUMN_SHARK
				+ ", " + Datasource.COLUMN_COMPANY + ") VALUES ('" + deal + "', " + shark + ", " + ans + ")");
		deals.add(new Deal(deal, shark, ans));

	}

	public void update() {
		System.out.println("Select what table to update:" + "\n1)Shark" + "\n2)Company" + "\n3)Deal");
		int choice = drew.nextInt();// you get to chose what you want to update
		drew.nextLine();
		String table = selectTable(choice);
		int id = 0;
		String updateString = "UPDATE " + table + " SET ";// starts creating the sql statment you will use to update it
		System.out.println("Select id to update");
		if (table == "sharks") {// depending on table, allows you to update that one
			viewSharks();
			id = drew.nextInt();
			drew.nextLine();
			System.out.println("Enter name to update for the shark");// you enter the updated info
			String name = drew.nextLine();

			System.out.println("Enter net worth to update for the shark");
			Double networth = drew.nextDouble();
			// drew.nextLine();
			updateString += Datasource.COLUMN_NAME + " = '" + name + "' , " + Datasource.COLUMN_NETWORTH + " = "
					+ networth + " WHERE " + Datasource.COLUMN_ID + " = " + id;// updates the info in the database
			for (int i = 0; i < sharks.size(); i++) {// enters the data in the arraylist
				if (sharks.get(i).get_id() == id) {
					sharks.get(i).setName(name);
					sharks.get(i).setNetWorth(networth);
					break;

				}
			}
		} else if (table == "companies") {
			viewCompanies();
			id = drew.nextInt();
			drew.nextLine();// you enter the updated info
			System.out.println("Enter product to update for the comp");
			String product = drew.nextLine();
			System.out.println("Enter valuation to update for the comp");
			int valuation = drew.nextInt();
			drew.nextLine();
			updateString += Datasource.COLUMN_PRODUCT + " = '" + product + "' , " + Datasource.COLUMN_VALUATION + " = "
					+ valuation + " WHERE " + Datasource.COLUMN_ID + " = " + id;// updated in database
			for (int i = 0; i < companies.size(); i++) {
				if (companies.get(i).get_id() == id) {// updates in the arraylist
					companies.get(i).setProduct(product);
					companies.get(i).setValuation(valuation);
					break;

				}
			}
		} else if (table == "deals") {
			viewDeals();
			id = drew.nextInt();// same thing -- you enter info here
			drew.nextLine();
			System.out.println("Enter new deal (equity, price, whatever the deal is)");
			String deal = drew.nextLine();
			System.out.println("Enter company for the deal");
			viewCompanies();
			int companyID = drew.nextInt();
			drew.nextLine();
			System.out.println("Enter shark for the deal");
			viewSharks();
			int sharkID = drew.nextInt();
			drew.nextLine();
			// updates info in the db
			updateString += Datasource.COLUMN_DEAL + " = '" + deal + "' , " + Datasource.COLUMN_COMPANY + " = "
					+ companyID + ", " + Datasource.COLUMN_SHARK + " = " + sharkID + " WHERE " + Datasource.COLUMN_ID
					+ " = " + id;
			for (int i = 0; i < deals.size(); i++) {// updates corresponding object in deals
				if (deals.get(i).get_id() == id) {
					deals.get(i).setDeal(deal);
					deals.get(i).setShark(sharkID);
					deals.get(i).setCompany(companyID);
					break;

				}
			}
		}
		System.out.println(updateString);
		data.executeStatement(updateString);

	}

}
