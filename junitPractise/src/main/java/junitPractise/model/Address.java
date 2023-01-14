package junitPractise.model;

public class Address {

	private int pincode;
	private String streetName;
	private String cityName;

	public Address(int pincode, String streetName, String cityName) {
		super();
		this.pincode = pincode;
		this.streetName = streetName;
		this.cityName = cityName;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPincode() {
		return 1201;
	}

	public String getStreetName() {
		return "Street1";
	}

	public String getCityName() {
		return "TVm";
	}

	public Address getAddress() {
		return new Address(1, "Street1", "TVm");
	}

	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", streetName=" + streetName + ", cityName=" + cityName + "]";
	}

}
