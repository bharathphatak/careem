package careem.DataLayer;

public class Shipment {
	private int id;
	private String name;
	private String pickupAddress;
	private String deliveryAddress;
	private String shipmentType;
	private String requestDate;
	private int quantity;

	public Shipment(String name, String pickupAddress, String deliveryAddress, String shipmentType, String requestDate,
			int quantity) {
		super();
		this.name = name;
		this.pickupAddress = pickupAddress;
		this.deliveryAddress = deliveryAddress;
		this.shipmentType = shipmentType;
		this.requestDate = requestDate;
		this.quantity = quantity;
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

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
