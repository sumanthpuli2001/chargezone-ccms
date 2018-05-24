/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.ModulesDAO;

/**
 *
 * @author Aman
 */
public class ModulesServiceImpl<T> extends GenericsServiceImpl<T> implements ModulesService<T>{
    protected ModulesDAO<T> modulesDAO;

    public ModulesDAO<T> getModulesDAO() {
        return modulesDAO;
    }

    public void setModulesDAO(ModulesDAO<T> modulesDAO) {
        this.modulesDAO = modulesDAO;
        setGenericsDAO(modulesDAO);
    }
    
    
}
