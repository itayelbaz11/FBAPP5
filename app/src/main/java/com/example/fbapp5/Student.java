package com.example.fbapp5;

public class Student {



    public String name;
    public String adress;
    public String phone;
    public String id;
    public String fphone;
    public String fname;
    public String mphone;
    public String mname;
    public String hphone;

    public Student() {}
    public Student (String name, String adress, String phone, String id,String hphone, String fphone, String fname, String mphone,String mname) {
        this.name=name;
        this.adress=adress;
        this.phone=phone;
        this.id=id;
        this.fname=fname;
        this.fphone=fphone;
        this.mname=mname;
        this.mphone=mphone;
        this.hphone=hphone;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getFphone() {
        return fphone;
    }

    public String getFname() {
        return fname;
    }

    public String getMphone() {
        return mphone;
    }

    public String getMname() {
        return mname;
    }

    public String getHphone() {
        return hphone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFphone(String fphone) {
        this.fphone = fphone;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }



}
