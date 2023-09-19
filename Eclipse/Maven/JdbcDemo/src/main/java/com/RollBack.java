package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RollBack {
	public static void main(String[] args) throws SQLException {
		int[] n = { 101, 105, 106 };
		int c = 0;

		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");
		con.setAutoCommit(false);
		for (int i = 0; i < n.length; i++) {
			PreparedStatement ps = con.prepareStatement("update products set Price=(price+(Price*0.1)) where ProdId=?");
			ps.setInt(1, n[i]);
			int count = ps.executeUpdate();
			if (count == 0) {
				con.rollback();
				System.out.println("Roll Back");
				break;
			} else {
				c++;
				continue;
			}
		}
		if (c == 3) {
			con.commit();
			System.out.println("Updated");
		}
		con.close();
	}
}