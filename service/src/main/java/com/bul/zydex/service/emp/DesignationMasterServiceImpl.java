/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.DesignationMasterDAO;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.service.*;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class DesignationMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements DesignationMasterService<T> {

    @Override
    public boolean isExist(T t) {
        return designationMasterDAO.isExist(t); //To change body of generated methods, choose Tools | Templates.
    }

    private DesignationMasterDAO<T> designationMasterDAO;

    public DesignationMasterDAO<T> getDesignationMasterDAO() {
        return designationMasterDAO;
    }

    public void setDesignationMasterDAO(DesignationMasterDAO<T> designationMasterDAO) {
        this.designationMasterDAO = designationMasterDAO;
        setGenericsDAO(designationMasterDAO);
    }

    @Override
    public List<?> readByName(String designation) {
        return designationMasterDAO.readByName(designation);
    }

    @Override
    public List<?> readDesignationAndLevel() {
        return designationMasterDAO.readDesignationAndLevel();
    }

    @Override
    public List<?> readDesignationsOfLevel(final int levelMasterId) {
        return designationMasterDAO.readDesignationsOfLevel(levelMasterId);
    }

    @Override
    public List<?> readByID(int empdesig) {
        return designationMasterDAO.readByID(empdesig);
    }

}
