package day3_day4.q3;

import java.io.Serial;
import java.io.Serializable;

public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String street;
    String city;
    String state;
    String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + zipCode;
    }
}
