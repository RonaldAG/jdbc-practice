package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Parte2 {
	public static void main(String[] args) {
		Connection conn1 = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn1 = DB.getConnection();
			st = conn1.createStatement();
			
			rs = st.executeQuery("select * from department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + "," + rs.getString("Name"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
