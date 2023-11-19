package model;

public class Address extends BaseEntity {
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String postalCode;


    public Address(long id, String street, String city, String state, String country, String postalCode) {
        super(id);
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }


    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    @Override
    public String toString() {
        return
                "\n"+
                "street = '" + street + "' \n" +
                "city = '" + city + "' \n" +
                "state = '" + state + "' \n" +
                "country = '" + country + "' \n" +
                "postalCode = '" + postalCode+ "'\n";
    }
}
