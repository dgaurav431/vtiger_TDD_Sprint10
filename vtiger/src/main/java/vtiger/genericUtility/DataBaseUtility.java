package vtiger.genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtility {
	
	public String  fetchDataFromDataBase(Connection connection, String querry, int index) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(querry);

		if(result.next()) {
			
			return result.getString(index);
			
		}
		
		return "";
		
	}
	
	public void  updateDataToDataBase(Connection connection, String querry) throws SQLException {
		int result = connection.createStatement().executeUpdate(querry);

		if (result == 1) {
			System.out.println("Data base has been updated");
		}

		else
			System.out.println("Data base has not been updated");

		
	}


}
