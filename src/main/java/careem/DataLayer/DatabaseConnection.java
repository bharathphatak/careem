package careem.DataLayer;

import java.sql.*;

public class DatabaseConnection {

	public void removePartner(String name) {

		JDBCClient client = new JDBCClient();
		Connection con = client.getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("delete from partner where name=" + "'" + name + "'");
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addPartner(Partner partner) {

		JDBCClient client = new JDBCClient();
		Connection con = client.getConnection();
		try {
			Statement stmt = con.createStatement();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("insert into partner(Name, transport_type, quantity, cost, out_of_city_support, location) values(");
			stringBuffer.append("'" + partner.getName() + "'" + "," + "'"+partner.getTransportType() +"'"+ "," + partner.getQuantity() + ",");
			stringBuffer.append(partner.getCost() + "," +"'"+ partner.getOutCitySupport()+"'" + "," + "'"+partner.getLocation()+"'"+ ")");
			stmt.executeUpdate(stringBuffer.toString());
			System.out.print("HELLLLLLLLLLLLLL");

		} catch (Exception e) {
			System.out.print(e);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
