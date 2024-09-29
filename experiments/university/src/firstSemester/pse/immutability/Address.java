package firstSemester.pse.immutability;

public class Address {
	public String city;
	public String street;
	public int houseNumber;
	
	public Address(final String city,final String street, final int houseNumber) {
		this.city= city;
		this.street = street;
		this.houseNumber = houseNumber;
	}
	
	
	public String getCity() {
		return city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public int getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}


	public String getAddress() {
		return "the Address is :" + city + ", " + street + ", " + houseNumber;
	}
	
	public void setCity(String city) {
		this.city =  city;
	}
}
