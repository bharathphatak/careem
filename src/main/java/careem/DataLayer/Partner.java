package careem.DataLayer;

/**
 * Created by bhara on 25-02-2017.
 */
public class Partner {

	private int id;
	private String name;
	private String transportType;
	private int quantity;
	private int cost;
	private String outCitySupport;
	private String location;

	public Partner(String name, String transportType, int quantity, int cost, String outCitySupport, String location) {
		super();
		this.name = name;
		this.transportType = transportType;
		this.quantity = quantity;
		this.cost = cost;
		this.outCitySupport = outCitySupport;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getOutCitySupport() {
		return outCitySupport;
	}

	public void setOutCitySupport(String outCitySupport) {
		this.outCitySupport = outCitySupport;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
