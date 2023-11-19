package model;

import enums.PhoneType;

import java.time.LocalDateTime;

public class PhoneNumber extends BaseEntity {
    private String countryCode;
    private String number;
    private PhoneType label;


    public PhoneNumber(long id, String countryCode, String number, PhoneType label) {
        super(id);
        this.countryCode = countryCode;
        this.number = number;
        this.label = label;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getNumber() {
        return this.number;

    }
    public PhoneType getLabel(){
        return this.label;
    }

    @Override
    public String toString() {
        return "PhoneNumber" +"\n"+
                "countryCode = '" + countryCode + "'\n" +
                "number = '" + number + "'\n" +
                "label = '" + label + "'\n" ;
    }
}
