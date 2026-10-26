/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class ServiceRights {
    
    private int id;
    private String department;
    private String location;
    private int sap;
    private int service1;
    private int service2;
    private int service3;
    private int service4;
    private int service5;
    private int service6;
    
    public ServiceRights() {
    }
    
    public ServiceRights(int id, String department, String location, int sap, int service1, int service2, int service3, int service4, int service5, int service6) {
        this.id = id;
        this.department = department;
        this.location = location;
        this.sap = sap;
        this.service1 = service1;
        this.service2 = service2;
        this.service3 = service3;
        this.service4 = service4;
        this.service5 = service5;
        this.service6 = service6;
    }

    public int getId() {
        return id;
    }

    public ServiceRights setId(int id) {
        this.id = id;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public ServiceRights setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ServiceRights setLocation(String location) {
        this.location = location;
        return this;
    }

    public int getSap() {
        return sap;
    }

    public ServiceRights setSap(int sap) {
        this.sap = sap;
        return this;
    }

    public int getService1() {
        return service1;
    }

    public ServiceRights setService1(int service1) {
        this.service1 = service1;
        return this;
    }

    public int getService2() {
        return service2;
    }

    public ServiceRights setService2(int service2) {
        this.service2 = service2;
        return this;
    }

    public int getService3() {
        return service3;
    }

    public ServiceRights setService3(int service3) {
        this.service3 = service3;
        return this;
    }

    public int getService4() {
        return service4;
    }

    public ServiceRights setService4(int service4) {
        this.service4 = service4;
        return this;
    }

    public int getService5() {
        return service5;
    }

    public ServiceRights setService5(int service5) {
        this.service5 = service5;
        return this;
    }

    public int getService6() {
        return service6;
    }

    public ServiceRights setService6(int service6) {
        this.service6 = service6;
        return this;
    }
    
    
}
