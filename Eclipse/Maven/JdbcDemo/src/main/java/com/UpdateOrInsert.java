package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOrInsert {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		// BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the data:");
		int Prodid = sc.nextInt();
		String ProdName = sc.next();

		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");

		PreparedStatement ps = con.prepareStatement("update products set ProdName=? where ProdId=?");
		ps.setString(1, ProdName);
		ps.setInt(2, Prodid);

		int count = ps.executeUpdate();
		if (count == 1) {
			System.out.println("Updated!");
		} else {
			System.out.println("Not Found");

			System.out.println("Enter the new Data:");
			double Price = sc.nextInt();
			int Qoh = sc.nextInt();
			String Remarks = sc.next();
			String CatCode = sc.next();

			PreparedStatement ps2 = con
					.prepareStatement("insert into products(ProdName,Price,Qoh,Remarks,CatCode) values (?,?,?,?,?)");
			ps2.setString(1, ProdName);
			ps2.setDouble(2, Price);
			ps2.setInt(3, Qoh);
			ps2.setString(4, Remarks);
			ps2.setString(5, CatCode);

			int count2 = ps2.executeUpdate();
			if (count2 == 1) {
				System.out.println("Updated!");
			}
		}
		con.close();
		sc.close();
	}

}
