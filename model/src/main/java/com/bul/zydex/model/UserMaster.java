package com.bul.zydex.model;
// Generated Apr 21, 2016 3:33:08 PM by Hibernate Tools 3.2.1.GA

/**
 * @Aman Bahukhandi
 */
public class UserMaster implements java.io.Serializable {

    private String loginName;
    private String password;
    private String userFullName;
    private int userType;
    private int pwdChange;
    private int userTry;
    private int lock1;
     private String vendorCode;
    
    public UserMaster() {
    }

    public UserMaster(String loginName, String password, String userFullName, int userType, int pwdChange, int userTry, int lock1,String vendorCode) {
        this.loginName = loginName;
        this.password = password;
        this.userFullName = userFullName;
        this.userType = userType;
        this.pwdChange = pwdChange;
        this.userTry = userTry;
        this.lock1 = lock1;
         this.vendorCode = vendorCode;
        
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

    public int getUserType() {
        return userType;
    }

    public UserMaster setUserType(int userType) {
        this.userType = userType;
        return this;
    }

    public int getPwdChange() {
        return pwdChange;
    }

    public UserMaster setPwdChange(int pwdChange) {
        this.pwdChange = pwdChange;
        return this;
    }

    public int getUserTry() {
        return userTry;
    }

    public UserMaster setUserTry(int userTry) {
        this.userTry = userTry;
        return this;
    }

    public int getLock1() {
        return lock1;
    }

    public UserMaster setLock1(int lock1) {
        this.lock1 = lock1;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    
}
