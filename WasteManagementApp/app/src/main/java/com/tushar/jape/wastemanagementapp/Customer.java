package com.tushar.jape.wastemanagementapp;

class Customer {
    private String name, aadhar, address, email;
    private double latitute, longitude;

    Customer(String name, String email, String aadhar, String address, double latitute, double longitude){
        this.name = name;
        this.email = email;
        this.aadhar = aadhar;
        this.address = address;
        this.latitute = latitute;
        this.longitude = longitude;
    }

    String getEmail(){return email;}

    String getName(){
        return name;
    }

    String getAadhar(){
        return aadhar;
    }

    String getAddress(){
        return address;
    }

    double getLatitute(){
        return latitute;
    }

    double getLongitude(){
        return longitude;
    }
}
