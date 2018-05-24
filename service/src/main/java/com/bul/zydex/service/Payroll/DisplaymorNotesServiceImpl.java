/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.DisplaymorNotesDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Hussain
 */
public class DisplaymorNotesServiceImpl<T> extends GenericsServiceImpl<T> implements DisplaymorNotesService<T> {
    private DisplaymorNotesDAO<T> displaymorNotesDAO;

    public DisplaymorNotesDAO<T> getDisplaymorNotesDAO() {
        return displaymorNotesDAO;
    }

    public void setDisplaymorNotesDAO(DisplaymorNotesDAO<T> displaymorNotesDAO) {
        this.displaymorNotesDAO = displaymorNotesDAO;
        setGenericsDAO(displaymorNotesDAO);
    }
    
}
