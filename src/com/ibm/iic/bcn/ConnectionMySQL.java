package com.ibm.iic.bcn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMySQL {
    
    public Connection getConnection() {
        String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_ad1e8834d50cc1d?user=b2b2f9b7d13a7d&password=bf400fa9";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
		
	}
}
