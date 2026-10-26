/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.dao.Employee.DesignationMasterDao;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public class DesignationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements DesignationMasterService<T> {
    
    private DesignationMasterDao<T> designationMasterDao;

    public DesignationMasterDao<T> getDesignationMasterDao() {
        return designationMasterDao;
    }

    public void setDesignationMasterDao(DesignationMasterDao<T> designationMasterDao) {
        this.designationMasterDao = designationMasterDao;
        setGenericsDAO(designationMasterDao);
    }

    @Override
    public List getDesignationPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return designationMasterDao.getDesignationPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalDesignationCount() {
        return designationMasterDao.getTotalDesignationCount();
    }

    @Override
    public int getFilteredDesignationCount(String search) {
        return designationMasterDao.getFilteredDesignationCount(search);
    }
}
