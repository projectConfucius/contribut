/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author Makosi
 */
public class Application extends HttpServlet {
    private String fname;
    private String lname;
    private String choice;
    private String gender;
    private String regNo;
    
    public Application()
    {
        fname = "";
        lname = "";
        choice = "";
        gender = "";
        regNo = "";
    }
    
    public Application(String fname, String lname, String choice, String gender, String regNo)
    {
        this.fname = fname;
        this.lname = lname;
        this.choice = choice;
        this.gender = gender;
        this.regNo = regNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
