package database;

public class StudentCollegeSql {
	public static String creatTable() {
		return "CREATE TABLE StudentCollege ("
				   + "StudentID int," 
				   + "CollegeID int)";
	}
	
	public static String fillTable() {
		return "INSERT INTO StudentCollege (StudentID , CollegeID) VALUES "
				+ "(123, 11),"
				+ "(124, 10),"
				+ "(125, 13),"
				+ "(126, 10),"
				+ "(127, 12)";
	}
	
	public static String dropTable() {
		return "DROP TABLE StudentCollege";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
		
	public static String queryAll() {
		return "SELECT * FROM StudentCollege ";
	}
	
}
