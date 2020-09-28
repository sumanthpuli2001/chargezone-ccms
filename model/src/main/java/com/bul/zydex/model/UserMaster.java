package com.bul.zydex.model;
// Generated Apr 21, 2016 3:33:08 PM by Hibernate Tools 3.2.1.GA

/**
 * @Aman Bahukhandi
 */
public class UserMaster implements java.io.Serializable {

    private String loginName;
    private String password;
    private String userFullName;
    private String rights;
    private String department;
    private String designation;
    private String emailId;
    private String dRow;

    public UserMaster() {
    }

    public UserMaster(String loginName, String password, String userFullName, String rights, String department, String designation, String emailId, String dRow) {
        this.loginName = loginName;
        this.password = password;
        this.userFullName = userFullName;
        this.rights = rights;
        this.department = department;
        this.designation = designation;
        this.emailId = emailId;
        this.dRow = dRow;
    }

    public String getLoginName() {
        return loginName;
    }

    public UserMaster setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserMaster setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public UserMaster setUserFullName(String userFullName) {
        this.userFullName = userFullName;
        return this;
    }

    public String getRights() {
        return rights;
    }

    public UserMaster setRights(String rights) {
        this.rights = rights;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public UserMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public UserMaster setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserMaster setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public UserMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

}
