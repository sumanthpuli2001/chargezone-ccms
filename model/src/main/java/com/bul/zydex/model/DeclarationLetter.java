/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class DeclarationLetter {

    private int id;
    private String declarationLetter;

    public DeclarationLetter() {

    }

    public DeclarationLetter(int id, String declarationLetter) {
        this.id = id;
        this.declarationLetter = declarationLetter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeclarationLetter() {
        return declarationLetter;
    }

    public void setDeclarationLetter(String declarationLetter) {
        this.declarationLetter = declarationLetter;
    }
    
    
}
