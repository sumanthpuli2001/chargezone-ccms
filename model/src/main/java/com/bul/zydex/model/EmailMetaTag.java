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
public class EmailMetaTag  implements java.io.Serializable {


     private Integer id;
     private Modules modules;
     private String name;

    public EmailMetaTag() {
    }

    public EmailMetaTag(Modules modules, String name) {
       this.modules = modules;
       this.name = name;
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
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}
