/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Aman
 */
public class Modules  implements java.io.Serializable {


     private Integer id;
     private String moduleName;
     private int moduleStatus;
     private Set componentMasters = new HashSet(0);

    public Modules() {
    }

	
    public Modules(String moduleName, int moduleStatus) {
        this.moduleName = moduleName;
        this.moduleStatus = moduleStatus;
    }
    public Modules(String moduleName, int moduleStatus, Set componentMasters) {
       this.moduleName = moduleName;
       this.moduleStatus = moduleStatus;
       this.componentMasters = componentMasters;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getModuleName() {
        return this.moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    public int getModuleStatus() {
        return this.moduleStatus;
    }
    
    public void setModuleStatus(int moduleStatus) {
        this.moduleStatus = moduleStatus;
    }
    public Set getComponentMasters() {
        return this.componentMasters;
    }
    
    public void setComponentMasters(Set componentMasters) {
        this.componentMasters = componentMasters;
    }

}