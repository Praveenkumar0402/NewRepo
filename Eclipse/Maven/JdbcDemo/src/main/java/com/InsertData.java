package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data:");
		String ProdName = sc.next();
		double Price = sc.nextInt();
		int Qoh = sc.nextInt();
		String Remarks = sc.next();
		String CatCode = sc.next();

		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");

		PreparedStatement ps = con
				.prepareStatement("insert into products(ProdName,Price,Qoh,Remarks,CatCode) values (?,?,?,?,?)");
		// replace parameters with values
		ps.setString(1, ProdName);
		ps.setDouble(2, Price);
		ps.setInt(3, Qoh);
		ps.setString(4, Remarks);
		ps.setString(5, CatCode);

		int count = ps.executeUpdate();
		if (count == 1)
			System.out.println("Updated!");
		else
			System.out.println("Product Id Not Found!");
		ps.close();
		sc.close();
	}

}
