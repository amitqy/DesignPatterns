package com.cpc.dp.builder2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import com.cpc.dp.builder.Address;

//Product class
//We want to create objects of this class
//We also don't have constructor, which need so much arguments
//And we'll still able to create instance of this class
//Setter methods are not visible outside this class
//That keeps UserDTO instances immuatble
//Even if the requirement is not to keep class immutable, still
//this method is prefered.
//Builder resides in the class whose object has to be built
//Abstract builder is also not required if "product" itself is not 
//a part of any inheritance hierarchy. You can directlty create
//concrete builder
public class UserDTO {

	private String name;
	
	private String address;
	
	private String age;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	private void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\nage=" + age + "\naddress=" + address ;
	}
	//Get builder instance
	public static UserDTOBuilder getBuilder() {
		return new UserDTOBuilder();
	}
	//Builder is decalred as inner static class of class who instance is to be created
	//The builder can also use private setter methods also.
	//This way we can build instances without using a complex constructor
	public static class UserDTOBuilder {
		
		private String firstName;
		
		private String lastName;
		
		private String age;
		
		private String address;
		
		// instance will be build here
		private UserDTO userDTO;
		
		public UserDTOBuilder withFirstName(String fname) {
			this.firstName = fname;
			return this;
		}
		
		public UserDTOBuilder withLastName(String lname) {
			this.lastName = lname;
			return this;
		}
		
		public UserDTOBuilder withBirthday(LocalDate date) {
			age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
			return this;
		}
		
		public UserDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + " " +address.getStreet()
						+ "\n"+address.getCity()+", "+address.getState()+" "+address.getZipcode(); 

			return this;
		}
		
		public UserDTO build() {
			//we are setter method on our final object
			this.userDTO = new UserDTO();
			userDTO.setName(firstName+" " + lastName);
			userDTO.setAddress(address);
			userDTO.setAge(age);
			// we return this instance to the outside world
			return this.userDTO;
		}
		
		public UserDTO getUserDTO() {
			return this.userDTO;
		}
	}
}
