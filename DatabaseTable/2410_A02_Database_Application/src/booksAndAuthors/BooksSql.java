package booksAndAuthors;

/**
 * This class contains all the methods and layout and the elements of the columns and data of the Book table.
 * @author Sabina Shrestha and Heberto Rodriguez
 *
 */

public class BooksSql {
	
	/**
	 * This methods creates the books tables and returns the the empty table
	 * @return
	 */
	public static String createTable() {
		return "CREATE TABLE Books ("
				   + "ID int not null primary key"
				   + " GENERATED ALWAYS AS IDENTITY"
				   + " (START WITH 123, INCREMENT BY 1),"
				   + "Title varchar(255)," 
				   + "Publisher varchar(255),"
				   + "Genre varchar(255)," 
				   + "PublishedYear int)";
	}
	
	/**
	 * This methods fill in the table that was last created with its respecting elements
	 * Returns the table filled with the elements.
	 * @return
	 */
	public static String fillTable() {
		return "INSERT INTO Books (Title, Publisher, Genre, PublishedYear) VALUES "
				+ "('Harry Potter', 'Bloomsbury','Fantasy', 1997),"
				+ "('Alice In Wonderland', 'Macmillan', 'Adventure', 1871),"
				+ "('Seriously...Im Kidding', 'Grand Central Publishing', 'Autobiography', 2011),"
				+ "('Calvin and Hobbes', 'Andrews McMeel Publishing', 'Comic', 1985),"
				+ "('The Dwarves', 'Orbit', 'Fantasy', 2003),"
				+ "('Charlottes Web', 'HarperCollinsPublishers', 'Childrens', 2001),"
				+ "('Harry The Dirty Dog', 'Harper & Row','Childrens', 1956),"
				+ "('Fantastic Beasts and Where to Find Them', 'Bloomsbury','Fantasy', 2001),"
				+ "('The Tales Of Beedle The Bard', 'Childrens High Level Group', 'Fantasy', 2007),"
				+ "('Diary of a Wimpy Kid', 'Amulet Books', 'Comedy', 2007)";
	}
	
	/**
	 * Drops the table 
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE Books";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
	
	/**
	 * selects all of the elements in the table to display.
	 * @return
	 */
	public static String queryAll() {
		return "SELECT * FROM Books ";
	}

}
