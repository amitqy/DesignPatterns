package com.cpc.dp.builder;

//The concrete builder for UserWebDTO

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {


    // In UserWebDto we have only name field
    // so we create firstName and LastName
    private String firstName;
    private String lastName;
    private String age;
    private String address;

    private UserWebDTO dto;

    @Override
    public UserDTOBuilder withFirstName(String fname) {
         firstName =fname;
         return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lname) {
        lastName =lname;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate date) {
        // In UserWebDto we have age field
        // so we need to calculate age
        Period ageInYears = Period.between(date,LocalDate.now());
        age = Integer.toString(ageInYears.getYears());
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        // In UserWebDto we have address as string so we need to build
        // address string
        this.address = address.getHouseNumber() +", " + address.getStreet()
                +"\n"+address.getCity() +  "\n" +address.getState()+" "+
                address.getZipcode();
        return this;

    }

    @Override
    public UserDTO build() {
        // This method creates UserWebDto
        dto = new UserWebDTO(firstName + " " + lastName, address,age );
        return dto;
    }

    @Override
    public UserDTO getUserDTO() {
        // return what we have already built
        return dto;
    }
}
