package com.cpc.dp.builder;

import java.time.LocalDate;

//Abstract builder
public interface UserDTOBuilder {
	// builder provides methods to build "parts" of product at a time
	// These methods return reference to UserDTOBuilder itself
	// It allows us to do method chaining
	UserDTOBuilder withFirstName(String fname) ;

	UserDTOBuilder withLastName(String lname);

	UserDTOBuilder withBirthday(LocalDate date);

	UserDTOBuilder withAddress(Address address);
	//method to "assemble" final product, return the object
	//it has to build
	UserDTO build();
	//(optional) method to fetch already built object
	UserDTO getUserDTO();
}

