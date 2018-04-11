/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman
 */
public class ComponentMaster  implements java.io.Serializable {


     private Integer id;
     private Modules modules;
     private String componentName;
     private Integer status;

    public ComponentMaster() {
    }

	
    public ComponentMaster(Modules modules) {
        this.modules = modules;
    }
    public ComponentMaster(Modules modules, String componentName, Integer status) {
       this.modules = modules;
       this.componentName = componentName;
       this.status = status;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Modules getModules() {
        return this.modules;
    }
    
    public void setModules(Modules modules) {
        this.modules = modules;
    }
    public String getComponentName() {
        return this.componentName;
    }
    
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
}
