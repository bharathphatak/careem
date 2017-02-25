package careem.DataLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	public String generateReport(){
		String reportDetails="";
		
		JDBCClient client = new JDBCClient();
		Connection con = client.getConnection();
		try {
			Statement stmt = con.createStatement();
			StringBuffer stringBuffer = new StringBuffer();
			
			displayHeader(stringBuffer);
			
			reportDetails = getPartnerDetails(stringBuffer, stmt).toString();
			
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
		
		return reportDetails;
	}
	
	public StringBuffer getPartnerDetails(StringBuffer sb, Statement stmt){
		try{
			ResultSet rs = stmt.executeQuery("select * from partner");
			while(rs.next()){
				sb.append(rs.getString("Name")).append(" ");
				sb.append(rs.getString("transport_type")).append(" ");
				sb.append(rs.getInt("quantity")).append(" ");
				sb.append(rs.getInt("cost")).append(" ");
				sb.append(rs.getString("out_of_city_support")).append(" ");
				sb.append(rs.getString("location")).append(" ");
			}
			
			getShipmentDetails(sb, stmt);
		}catch(Exception e){
			System.out.print(e);
		}
		return sb;
		
	}
	
	public void getShipmentDetails(StringBuffer sb, Statement stmt){
		try{
			ResultSet rs = stmt.executeQuery("select * from shipment");
			while(rs.next()){
				sb.append(rs.getString("Name")).append(" ");
				sb.append(rs.getString("Pickup_address")).append(" ");
				sb.append(rs.getString("Delivery_address")).append(" ");
				sb.append(rs.getString("Shipment_type")).append(" ");
				sb.append(rs.getString("Request_date")).append(" ");
				sb.append(rs.getString("quantity")).append(" ");
			}
		}catch(Exception e){
			System.out.print(e);
		}
	}
	
	public void displayHeader(StringBuffer sb){
		sb.append("PName").append(" ");
		sb.append("Ttype").append(" ");
		sb.append("quantity").append(" ");
		sb.append("cost").append(" ");
		sb.append("OCSupport").append(" ");
		sb.append("location").append(" ");
		
		sb.append("SName").append(" ");
		sb.append("Pickadd").append(" ");
		sb.append("Deliadd").append(" ");
		sb.append("Shiptype").append(" ");
		sb.append("Reqdate").append(" ");
		sb.append("quantity").append(" ");
		
		sb.append("-------------------------------------------------");
		sb.append("\n");
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
