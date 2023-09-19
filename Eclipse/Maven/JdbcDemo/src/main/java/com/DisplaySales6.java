package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplaySales6 {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data:");
		String CatCode = sc.next();
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;user=sa;password=Im@ginn0vate;database=msdb;encrypt=true;trustServerCertificate=true");
		PreparedStatement ps = con.prepareStatement(
				"select Invno,ProdName,Qty,Amount,convert(varchar(10),Transdate,103) from sales s JOIN products p on (s.Prodid=p.ProdId) WHERE CatCode=?");
		ps.setString(1, CatCode);
		var rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "   " + rs.getInt(3) + "   " + rs.getDouble(4)
					+ "    " + rs.getString(5));
		}
		sc.close();

	}

}
