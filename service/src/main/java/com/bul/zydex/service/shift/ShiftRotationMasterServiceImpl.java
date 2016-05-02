/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftRotationMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftRotationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ShiftRotationMasterService<T> {

    protected ShiftRotationMasterDAO<T> shiftRotationMasterDAO;

    public ShiftRotationMasterDAO<T> getShiftRotationMasterDAO() {
        return shiftRotationMasterDAO;
    }

    public void setShiftRotationMasterDAO(ShiftRotationMasterDAO<T> shiftRotationMasterDAO) {
        this.shiftRotationMasterDAO = shiftRotationMasterDAO;
        setGenericsDAO(shiftRotationMasterDAO);
    }

    @Override
    public List<?> readRotation(T object) {
        return shiftRotationMasterDAO.readRotation(object);
    }

    @Override
    public List<?> readByDuration(T object) {
        return shiftRotationMasterDAO.readByDuration(object);
    }
    @Override
       public List<?> checkByShiftRotationName(T object) {
        return shiftRotationMasterDAO.checkByShiftRotationName(object);
    }

    @Override
    public List<?> readByShiftRotationName(String shiftRotationTemp) {
        return shiftRotationMasterDAO.readByShiftRotationName(shiftRotationTemp);
    }

}
