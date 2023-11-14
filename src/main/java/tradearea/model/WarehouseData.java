package tradearea.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class WarehouseData {
	
	private UUID warehouseID;
	private String warehouseName;

	private String warehouseAddress;

	private int warehousePostalCode;

	private String warehouseCity;

	private String warehouseCountry;

	private String timestamp;

	private Product[] productData;

	/**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}
	
	/**
	 * Setter and Getter Methods
	 */
	public UUID getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(UUID warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public int getWarehousePostalCode() {
		return warehousePostalCode;
	}

	public void setWarehousePostalCode(int warehousePostalCode) {
		this.warehousePostalCode = warehousePostalCode;
	}

	public String getWarehouseCity() {
		return warehouseCity;
	}

	public void setWarehouseCity(String warehouseCity) {
		this.warehouseCity = warehouseCity;
	}

	public String getWarehouseCountry() {
		return warehouseCountry;
	}

	public void setWarehouseCountry(String warehouseCountry) {
		this.warehouseCountry = warehouseCountry;
	}

	public Product[] getProductData() {
		return productData;
	}

	public void setProductData(Product[] productData) {
		this.productData = productData;
	}

	@Override
	public String toString() {
		return "WarehouseData{" +
				"warehouseID=" + warehouseID +
				", warehouseName='" + warehouseName + '\'' +
				", warehouseAddress='" + warehouseAddress + '\'' +
				", warehousePostalCode=" + warehousePostalCode +
				", warehouseCity='" + warehouseCity + '\'' +
				", warehouseCountry='" + warehouseCountry + '\'' +
				", timestamp='" + timestamp + '\'' +
				", productData=" + Arrays.toString(productData) +
				'}';
	}
}
