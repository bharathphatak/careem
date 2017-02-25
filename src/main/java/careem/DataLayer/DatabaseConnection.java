package careem.DataLayer;

import java.sql.*;

public class DatabaseConnection {

	public void removePartner(String name) {

		JDBCClient client = new JDBCClient();
		Connection con = client.getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery("delete from partner where name=" + name);
		} catch (Exception e) {

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
			stmt.executeQuery(
					"insert into partner(Name, transport_type, quantity, cost, out_of_city_support, location) values("
							+ partner.getName() + "," + partner.getTransportType() + "," + partner.getQuantity() + ","
							+ partner.getCost() + "," + partner.getOutCitySupport() + "," + partner.getLocation()
							+ ")");

		} catch (Exception e) {

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
