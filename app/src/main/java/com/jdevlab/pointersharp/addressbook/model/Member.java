package com.jdevlab.pointersharp.addressbook.model;

/**
 * Created by Jaehyeong on 1/19/2017.
 */

public class Member {
    private String eName;
    private String kName;
    private String region;
    private String dob;
    private String dos;
    private String cell;
    private String address;
    private String city;
    private String zip;
    private String id;
    private String type;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    //Member(id, kName, eName, region, dob, dos, addr, city, zip, cell, gender, type);

    public Member(String id, String kName, String eName, String region, String dob, String dos, String address, String city, String zip, String cell, String gender, String type) {
        this.eName = eName;
        this.kName = kName;
        this.region = region;
        this.dob = dob;
        this.dos = dos;
        this.cell = cell;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.id = id;
        this.type = type;
        this.gender = gender;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
