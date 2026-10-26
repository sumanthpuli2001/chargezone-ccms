/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.sap.rfc.helper;

/**
 *
 * @author admin
 */
import com.sap.conn.jco.JCoTable;

public class TableAdapterReader
{
    protected JCoTable table;
    
    public TableAdapterReader(final JCoTable table) {
        this.table = table;
    }
    
    public String get(final String s) {
        return this.table.getValue(s).toString();
    }
    
    public Boolean getBoolean(final String s) {
        final String value = this.table.getValue(s).toString();
        return value.equals("X");
    }
    
    public String getMessage() {
        return this.table.getString("MESSAGE");
    }
    
    public int size() {
        return this.table.getNumRows();
    }
    
    public void next() {
        this.table.nextRow();
    }
}
