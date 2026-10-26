/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman Bahukhandi
 */
public class EmployeeMaster {

    private String employeeCode;
    private String name;
    private String department;
    private String designation;
    private String rightsName;
    private String emailId;
    private String phNo;
    private String mobileNo;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String pincode;
    private int userType;
    private int userStatus;
    private int flag;
    private int userTry;
    private String location;
    private String dRow;
    
    public EmployeeMaster() {
    }

    public EmployeeMaster(String employeeCode, String name, String department, String designation, String rightsName, String emailId, String phNo, String mobileNo, String addressLine1, String addressLine2, String addressLine3, String city, String pincode, int userType, int userStatus, int flag, int userTry, String location, String dRow) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.rightsName = rightsName;
        this.emailId = emailId;
        this.phNo = phNo;
        this.mobileNo = mobileNo;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.pincode = pincode;
        this.userType = userType;
        this.userStatus = userStatus;
        this.flag = flag;
        this.userTry = flag;
        this.location = location;
        this.dRow = dRow;

    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public EmployeeMaster setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeMaster setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeMaster setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public EmployeeMaster setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getRightsName() {
        return rightsName;
    }

    public EmployeeMaster setRightsName(String rightsName) {
        this.rightsName = rightsName;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public EmployeeMaster setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getPhNo() {
        return phNo;
    }

    public EmployeeMaster setPhNo(String phNo) {
        this.phNo = phNo;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public EmployeeMaster setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public EmployeeMaster setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public EmployeeMaster setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public EmployeeMaster setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    public String getCity() {
        return city;
    }

    public EmployeeMaster setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPincode() {
        return pincode;
    }

    public EmployeeMaster setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public int getUserType() {
        return userType;
    }

    public EmployeeMaster setUserType(int userType) {
        this.userType = userType;
        return this;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public EmployeeMaster setUserStatus(int userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    public EmployeeMaster setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public int getUserTry() {
        return userTry;
    }

    public EmployeeMaster setUserTry(int userTry) {
        this.userTry = userTry;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public EmployeeMaster setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public EmployeeMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

    

}
