package booksAndAuthors;

public class AuthorSql {
	public static String createTable() {
		return "CREATE TABLE Author ("
		+ "ID int not null primary key"
		+ " GENERATED ALWAYS AS IDENTITY"
		+ " (START WITH 1, INCREMENT BY 1),"
		+ "FirstName varchar(255)," 
		+ "LastName varchar(255),"
		+ "BirthYear int)";
	}
	
	public static String fillTable() {
		return "INSERT INTO Author (FirstName, LastName, BirthYear) VALUES "
		+ "('J.K.', 'Rowling', 1965),"
		+ "('Lewis', 'Carroll', 1832),"
		+ "('Ellen', 'DeGeneres', 1958),"
		+ "('Bill', 'Watterson', 1958),"
		+ "('Jeff', 'Kinney', 1971)";
	}
	
	public static String dropTable() {
		return "DROP TABLE Author";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
	
	public static String queryAll() {
		return "SELECT * FROM Author ";
	}
	
	//	public static String queryAll() {
	//	return "SELECT ID, State, Name FROM Author";
	//	}
}