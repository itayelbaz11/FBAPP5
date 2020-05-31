package com.example.fbapp5;

public class Grade {


    public String stuid;
    public String subject;
    public String grade;
    public String gname;
    public String quarter;

    public Grade(){}

    public Grade(String stuid, String subject, String gname, String grade, String quarter) {
        this.stuid = stuid;
        this.subject = subject;
        this.gname = gname;
        this.grade= grade;
        this.quarter=quarter;
    }


    public String getStuid() {
        return stuid;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public String getGname() {
        return gname;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setStuid(String Stuid) {
        stuid = Stuid;
    }

    public void setSubject(String Subject) {
        subject = Subject;
    }

    public void setGrade(String Grade) {
        grade = Grade;
    }

    public void setGname(String Gname) {
        gname = Gname;
    }

    public void setQuarter(String Quarter) {
        quarter = Quarter;
    }
}
