package com.example.foodizone.chefFoodPanel;

public class Chef {

    private String Area, City, ConfirmPassword, Emailid, Fname, House, Lname, Mobile, Password, Pincode, State;

    public Chef(String area, String city, String confirmPassword, String emailid, String fname, String house, String lname, String mobile, String password, String pincode, String state) {
        this.Area = area;
        City = city;
        ConfirmPassword = confirmPassword;
        Emailid = emailid;
        Fname = fname;
        House = house;
        Lname = lname;
        Mobile = mobile;
        Password = password;
        Pincode = pincode;
        State = state;
    }

    public Chef() {

    }

    public String getArea() {
        return Area;
    }

    public String getCity() {
        return City;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public String getEmailid() {
        return Emailid;
    }

    public String getFname() {
        return Fname;
    }

    public String getHouse() {
        return House;
    }

    public String getLname() {
        return Lname;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getPassword() {
        return Password;
    }

    public String getPincode() {
        return Pincode;
    }

    public String getState() {
        return State;
    }
}