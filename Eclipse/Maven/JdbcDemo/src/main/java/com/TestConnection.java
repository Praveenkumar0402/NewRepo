package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");
		System.out.println(con.getClass());
		System.out.println("Connected to Sql");
		con.close();
	}
}
