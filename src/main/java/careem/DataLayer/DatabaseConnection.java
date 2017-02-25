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
	
	public void addShipment(Shipment shipment){
		JDBCClient client = new JDBCClient();
		Connection con = client.getConnection();
		try {
			Statement stmt = con.createStatement();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("insert into shipment(Name, Pickup_address, Delivery_address, Shipment_type, Request_date, Customer_name) values(");
			stringBuffer.append("'" + shipment.getName() + "'" + "," + "'"+shipment.getPickupAddress() +"'"+ "," + "'" + shipment.getDeliveryAddress() + "'" + ",");
			stringBuffer.append("'" + shipment.getShipmentType() + "'" + "," +"'"+ shipment.getRequestDate()+"'" + "," + shipment.getQuantity()+ ")");
			stmt.executeUpdate(stringBuffer.toString());

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

	public int getRateForPartner(String partnerName){
		JDBCClient client = new JDBCClient();
		Connection con = client.getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "select cost from partner where name = " + "'" + partnerName + "'";

			ResultSet rs = stmt.executeQuery(query);
			int rate = rs.getInt(1);
			return rate;
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
		return 0;
	}
}
