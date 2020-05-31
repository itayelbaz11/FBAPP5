package com.example.fbapp5;

public class Grade {

    public String StuID;
    public String Subject;
    public String Grade;
    public String Gname;
    public String Quarter;

    public Grade(){}

    public Grade(String StuID, String Subject, String Gname, String Grade,String Quarter) {
        this.StuID = StuID;
        this.Subject = Subject;
        this.Gname = Gname;
        this.Grade= Grade;
        this.Quarter=Quarter;
    }
}
