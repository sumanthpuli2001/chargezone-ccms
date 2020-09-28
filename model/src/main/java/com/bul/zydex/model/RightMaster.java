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
public class RightMaster {

    private String rightName;
    private String right;
    private String dRow;

    public RightMaster() {
    }

    public RightMaster(String rightName, String right, String dRow) {
        this.rightName = rightName;
        this.right = right;
        this.dRow = dRow;
    }

    public String getRightName() {
        return rightName;
    }

    public RightMaster setRightName(String rightName) {
        this.rightName = rightName;
        return this;
    }

    public String getRight() {
        return right;
    }

    public RightMaster setRight(String right) {
        this.right = right;
        return this;
    }

    public String getdRow() {
        return dRow;
    }

    public RightMaster setdRow(String dRow) {
        this.dRow = dRow;
        return this;
    }

}
