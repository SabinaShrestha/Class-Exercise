package booksAndAuthors;


/**
 * This class contains all the methods and layout and the elements of the columns and data of the Author table.
 * @author Sabina Shrestha and Heberto Rodriguez
 *
 */
public class AuthorSql {
	
	/**
	 * This methods creates the author table and returns the the empty table
	 * @return
	 */
	public static String createTable() {
		return "CREATE TABLE Author ("
				   + "ID int not null primary key"
				   + " GENERATED ALWAYS AS IDENTITY"
				   + " (START WITH 1, INCREMENT BY 1),"
				   + "FirstName varchar(255)," 
				   + "LastName varchar(255),"
				   + "BirthYear int)";
	}
	
	/**
	 * This methods fill in the table that was last created with its respecting elements
	 * Returns the table filled with the elements.
	 * @return
	 */
	public static String fillTable() {
		return "INSERT INTO Author (FirstName, LastName, BirthYear) VALUES "
				+ "('J.K.', 'Rowling', 1965),"
				+ "('Lewis', 'Carroll', 1832),"
				+ "('Ellen', 'DeGeneres', 1958),"
				+ "('Gene', 'Zion', 1913),"
				+ "('E.B.', 'White', 1899),"
				+ "('Bill', 'Watterson', 1958),"
				+ "('Markus', 'Heitz', 1971),"
				+ "('Jeff', 'Kinney', 1971)";
	}
	
	/**
	 * Drops table
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE Author";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
	
	/**
	 * selects all of the elements in the table to display.
	 * @return
	 */
	public static String queryAll() {
		return "SELECT * FROM Author ";
	}
	
//	public static String queryAll() {
//		return "SELECT ID, State, Name FROM Author";
//	}
}