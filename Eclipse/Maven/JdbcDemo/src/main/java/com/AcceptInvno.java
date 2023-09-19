package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AcceptInvno {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Invno:");
		int invno = sc.nextInt();

		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");

		PreparedStatement ps = con.prepareStatement("delete from sales where Invno=?");
		ps.setInt(1, invno);

		int count = ps.executeUpdate();
		if (count == 1) {
			System.out.println("Deleted!");
		} else {
			System.out.println("Not found invno");
		}
		ps.close();
		sc.close();

	}

}
