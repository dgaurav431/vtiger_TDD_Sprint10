package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ToFetchData {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		
		ResultSet result = connection.createStatement().executeQuery("select * from lead where companyname='ca';");

		if(result.next()) {
			
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			
		}
		
		connection.close();
	}

}
