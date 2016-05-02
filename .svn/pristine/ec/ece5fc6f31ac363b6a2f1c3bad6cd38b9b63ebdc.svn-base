/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.TemporaryShiftAssignDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TemporaryShiftAssignServiceImpl<T> extends GenericsServiceImpl<T> implements TemporaryShiftAssignService<T> {

            private TemporaryShiftAssignDAO<T> temporaryShiftAssignDAO;

    public TemporaryShiftAssignDAO<T> getTemporaryShiftAssignDAO() {
        return temporaryShiftAssignDAO;
    }

    public void setTemporaryShiftAssignDAO(TemporaryShiftAssignDAO<T> temporaryShiftAssignDAO) {
        this.temporaryShiftAssignDAO = temporaryShiftAssignDAO;
        setGenericsDAO(temporaryShiftAssignDAO);
    }
            
    @Override
    public List<?> temporaryShiftAssignResult() {
        return temporaryShiftAssignDAO.temporaryShiftAssignResult();
    }
    @Override
    public T temporaryShiftAssignResultByDaysWise(T object){
        return temporaryShiftAssignDAO.temporaryShiftAssignResultByDaysWise(object);
    }
}
