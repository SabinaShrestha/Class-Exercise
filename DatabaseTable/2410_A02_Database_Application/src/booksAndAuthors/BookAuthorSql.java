package booksAndAuthors;
//Association table/ A many-to-many table.

public class BookAuthorSql {
	public static String createTable() {
		return "CREATE TABLE BookAuthor ("
				   + "BooksID int," 
				   + "AuthorID int)";
	}
	
	public static String fillTable() {
		return "INSERT INTO BookAuthor (BooksID , AuthorID) VALUES "
				+ "(123, 1),"
				+ "(124, 2),"
				+ "(125, 3),"
				+ "(126, 4),"
				+ "(127, 5)";
	}
	
	public static String dropTable() {
		return "DROP TABLE BookAuthor";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
		
	public static String queryAll() {
//		return "SELECT * FROM BookAuthor ";
		return "SELECT Author.FirstName FROM BookAuthor INNER JOIN Author ON BookAuthor.AuthorID=Author.ID UNION "
				+ "SELECT Books.Title FROM BookAuthor INNER JOIN Books ON BookAuthor.BooksID=Books.ID";
	}
	
}