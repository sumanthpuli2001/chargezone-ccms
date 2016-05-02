
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ShiftMasterService<T> {

    private ShiftMasterDAO<T> shiftMasterDAO;

    public ShiftMasterDAO<T> getShiftMasterDAO() {
        return shiftMasterDAO;
    }

    public void setShiftMasterDAO(ShiftMasterDAO<T> shiftMasterDAO) {
        this.shiftMasterDAO = shiftMasterDAO;
        setGenericsDAO(shiftMasterDAO);
    }

    @Override
    public List<?> readByShiftId(T object) {
        return shiftMasterDAO.readByShiftId(object);
    }

    @Override
    public List<?> readByShiftName() {
        return shiftMasterDAO.readByShiftName();
    }

    @Override
    public List<?> checkExistingShift(T object) {
        return shiftMasterDAO.checkExistingShift(object);
    }

    @Override
    public List<?> getByShiftName(final String shiftTempString) {
        return shiftMasterDAO.getByShiftName(shiftTempString);
    }

}
