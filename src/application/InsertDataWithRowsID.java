package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class InsertDataWithRowsID {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
				"INSERT INTO SELLER "
				+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
				+ "VALUES"
				+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Carl Blue");
			st.setString(2, "calls@gmal.com");
			st.setDate(3, new java.sql.Date(sdf.parse("15/04/2003").getTime()));
			st.setDouble(4, 3000);
			st.setInt(5, 4);
			
			
			// Insert data and receive rows id
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Id:" + id);
				}
			}
			else {
				System.out.println("No rows affected!");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ParseException a) {
			a.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
