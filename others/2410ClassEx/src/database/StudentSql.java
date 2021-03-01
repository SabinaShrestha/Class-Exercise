package database;

public class StudentSql {
	public static String creatTable() {
		return "CREATE TABLE Student ("
				   + "ID int not null primary key"
				   + " GENERATED ALWAYS AS IDENTITY"
				   + " (START WITH 123, INCREMENT BY 1),"
				   + "LastName varchar(255)," 
				   + "FirstName varchar(255)," 
				   + "GradYear int," 
				   + "Major varchar(255))";
	}
	
	public static String fillTable() {
		return "INSERT INTO Student (Lastname, Firstname, GradYear, Major) VALUES "
				+ "('West', 'John', 2020, 'CS'),"
				+ "('East', 'Mari', 2021, 'CS'),"
				+ "('Kahn', 'Jami', 2020, 'EE'),"
				+ "('Dope', 'Kent', 2022, 'FA'),"
				+ "('West', 'Rita', 2022, 'CS')";
	}
	
	public static String dropTable() {
		return "DROP TABLE Student";
	}
	
	//- - - - - - - - - - -Query Statements - - - - - - - - - 
	
	public static String queryAll() {
		return "SELECT * FROM Student ";
	}
	
	public static String query_NameMajorCS() {
		return "SELECT ID, Lastname, Firstname, Major FROM Student " 
		+ "WHERE Major='CS'";
	}
}
