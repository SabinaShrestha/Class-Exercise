package booksAndAuthors;

public class BooksSql {
	
	public static String createTable() {
		return "CREATE TABLE Books ("
		+ "ID int not null primary key"
		+ " GENERATED ALWAYS AS IDENTITY"
		+ " (START WITH 123, INCREMENT BY 1),"
		+ "Title varchar(255)," 
		+ "PublishedYear int," 
		+ "Genre varchar(255)," 
		+ "Publisher varchar(255))";
	}

	public static String fillTable() {
		return "INSERT INTO Books (Title, PublishedYear, Genre, Publisher) VALUES "
		+ "('Harry Potter', 1997, 'Fantasy', 'Bloomsbury'),"
		+ "('Alice In Wonderland', 1871, 'Adventure', 'Macmillan'),"
		+ "('Seriously...Im Kidding', 2011, 'Autobiography', 'Grand Central Publishing'),"
		+ "('Calvin and Hobbes', 1985, 'Comic', 'Andrews McMeel Publishing'),"
		+ "('Diary of a Wimpy Kid', 2007, 'Comedy', 'Amulet Books')";
	}

	public static String dropTable() {
		return "DROP TABLE Books";
	}

		//- - - - - - - - - - -Query Statements - - - - - - - - - 

	public static String queryAll() {
		return "SELECT * FROM Books ";
	}


}
