package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class demoDatabase {

	public static void main(String[] args) throws SQLException {
		//Be careful will code/ method you run.
		
		//executeSqlStatement(StudentSql.dropTable());
		//executeSqlStatement(StudentSql.creatTable(), StudentSql.fillTable());
		//executeQueries(StudentSql.queryAll(), StudentSql.query_NameMajorCS());
		
		//executeSqlStatement(StudentCollegeSql.dropTable(),StudentCollegeSql.creatTable(), StudentCollegeSql.fillTable());
		executeQueries(StudentSql.queryAll(), CollegeSql.queryAll(), StudentCollegeSql.queryAll());
		System.out.println("Done.");
	}

	/**Executes all the queries in the order passed by the user. Each of those 
	 * queries returns data and the method executeQueries displays 
	 * the data.
	 *  
	 * @throws SQLException
	 */
	private static void executeQueries(String... sqlQueries) throws SQLException {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
				Statement statement = connection.createStatement();){
			
			for(String query : sqlQueries) {
				ResultSet results = statement.executeQuery(query);
				
				printData(results);
				System.out.println();
			}
			
		}
	}

	@SuppressWarnings("unused")
	private static void printData(ResultSet results) throws SQLException {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
				Statement statement = connection.createStatement();){

			ResultSetMetaData metaData = results.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			printHeader(metaData);
			
			//Print data
			while(results.next()) {
				for (int i=1; i <= columnCount; i++)
				System.out.printf("%-" + metaData.getColumnLabel(i).length() + "s  ", 
						results.getObject(i));
				
				System.out.println();
			}
			
		}
	}

	/**
	 * Prints the column headers separates then by two spaces.
	 * It also prints a line of dashes below the column headers.
	 * @param metaData
	 * @throws SQLException
	 */
	private static void printHeader(ResultSetMetaData metaData) throws SQLException {
		int columnCount = metaData.getColumnCount();
		
		//print column header
		for(int i = 1; i <= columnCount; i++) {
			System.out.print(metaData.getColumnLabel(i) + "  ");
		}
		System.out.println();
		
		// print dashed line 
		for (int i = 1; i <= columnCount; i++) {
			for(int j = 0; j < metaData.getColumnLabel(i).length(); j++) {
				System.out.print('-');
			}
			if(i != columnCount)System.out.print("--");

		}
		System.out.println();
	}
	
	/**
	 * Executes the sql statements in the order passed by the user.
	 * The sql statements that are passed as arguments change the database
	 * but do not return an data.
	 * @param sqlStatements
	 * @throws SQLException
	 */
	@SuppressWarnings("unused")
	private static void executeSqlStatement(String... sqlStatements) throws SQLException {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
				Statement statement = connection.createStatement();){
			
			for(String sqlStatement : sqlStatements) {
				statement.execute(sqlStatement);
			}

		}
	}
}
