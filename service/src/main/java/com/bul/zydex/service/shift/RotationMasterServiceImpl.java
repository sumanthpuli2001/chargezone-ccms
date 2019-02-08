/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.RotationMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class RotationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements RotationMasterService<T> {

    protected RotationMasterDAO<T> rotationMasterDAO;

    public RotationMasterDAO<T> getRotationMasterDAO() {
        return rotationMasterDAO;
    }

    public void setRotationMasterDAO(RotationMasterDAO<T> rotationMasterDAO) {
        this.rotationMasterDAO = rotationMasterDAO;
        setGenericsDAO(rotationMasterDAO);
    }

    @Override
    public List<?> readFromRotation(T object) {
        return rotationMasterDAO.readFromRotation(object);
    }

    @Override
    public List<?> readForShift(int object) {
        return rotationMasterDAO.readForShift(object);
    }

    @Override
    public List<?> isRotationExist(T object) {
        return rotationMasterDAO.isRotationExist(object);
    }

    @Override
    public List<?> readForShiftValue(int shiftId1) {
        return rotationMasterDAO.readForShiftValue(shiftId1);
    }

}
