package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TotalSales {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id:");
		int ProdId = sc.nextInt();

		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");

		PreparedStatement ps = con.prepareStatement("select sum(Amount) as totalsales from sales where Prodid=?");
		ps.setInt(1, ProdId);

		ResultSet rs = ps.executeQuery();
		rs.next();
		var amount = rs.getInt("totalsales");

		System.out.println(amount);
		con.close();
		sc.close();
	}
}
