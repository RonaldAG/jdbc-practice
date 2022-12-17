package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DB;

public class ConnectionDB {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();
	}

}
