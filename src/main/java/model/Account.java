package model;

public class Account {
    String firstname;
    String lastname;
    String address;
    String postcode;
    String city;
    String country;
    String state;
    String email;
    String phone;
    String password;

    public Account() {
    }

    public String getFirstname() {
        return firstname;
    }

    public Account setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Account setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Account setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public Account setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Account setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Account setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public Account setState(String state) {
        this.state = state;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Account setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }
}
