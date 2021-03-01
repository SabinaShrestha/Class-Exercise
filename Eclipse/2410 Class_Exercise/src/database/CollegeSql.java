package database;

public class CollegeSql {
	public static String creatTable() {
		return "CREATE TABLE College ("
				   + "ID int not null primary key"
				   + " GENERATED ALWAYS AS IDENTITY"
				   + " (START WITH 10, INCREMENT BY 1),"
				   + "Name varchar(255)," 
				   + "State varchar(255))";
	}
	
	public static String fillTable() {
		return "INSERT INTO College (Name, State) VALUES "
				+ "('Salt Lake Community College', 'UT'),"
				+ "('Westminster College', 'UT'),"
				+ "('Utah State University', 'UT'),"
				+ "('Seattle University', 'WA'),"
				+ "('University of Washington', 'WA')";
	}
	
	public static String dropTable() {
		return "DROP TABLE College";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
	
//	public static String queryAll() {
//		return "SELECT * FROM College ";
//	}
	
	public static String queryAll() {
		return "SELECT ID, State, Name FROM College";
	}
}
