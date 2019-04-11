package com.example.group8_finalproject_w2019_mad3125.Modal;

import java.io.Serializable;

public class Users implements Serializable {

    private  String name;
    private  String id;
    private  String password;
    private  String  address;

    public Users(String name, String id, String password, String address) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }




}
