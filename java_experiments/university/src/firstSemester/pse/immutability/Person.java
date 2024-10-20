package firstSemester.pse.immutability;

import java.util.Optional;

public final class Person {
	private final Address address;
	final String name;

	private final Optional<String> secondName;
	private final int age;
	private static int counter ;

	
	public Person(final Address address,final String name,final Optional<String> secondName,final int age) {
		if(address == null || name == null || age == 0 ){
			throw new IllegalArgumentException("Wrong arguments");
		}
		this.address = new Address(address.getCity(), address.getStreet(), address.getHouseNumber());
		this.name = name;
		this.age = age;
		this.secondName = secondName;

		counter++;

	}

	public Person(final Address address,final String name,final int age) {
		if(address == null || name == null || age == 0 ){
			throw new IllegalArgumentException("Wrong arguments");
		}
		this.address = address;
		this.name = name;
		this.age = age;
		counter++;

        secondName = null;
    }
	
	
	public String getAddress() {
		return "";
	}
	/*
	public void setAddress(Address address) {
		this.address = address;
	}
	*/
	public String getName() {
		return name;
	}
	
	/*
	public void setName(String name) {
		this.name = name;
	}
	*/
	
	public int getAge() {
		return age;
	}

	public Optional<String> getSecondName(){
		return secondName;
	}
	
	/*
	public void setAge(int age) {
		this.age = age;
	}
	*/
	

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	@Override
	public String toString() {
		return "Person{" +
				"address=" + address.getCity() +
				", name='" + name + '\'' +
				", secondName=" + secondName +

				'}';
	}
}
