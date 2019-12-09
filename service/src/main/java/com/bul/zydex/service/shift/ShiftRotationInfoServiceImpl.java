/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftRotationInfoDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftRotationInfoServiceImpl<T> extends GenericsServiceImpl<T> implements ShiftRotationInfoService<T> {

    protected ShiftRotationInfoDAO<T> shiftRotationInfoDAO;

    public ShiftRotationInfoDAO<T> getShiftRotationInfoDAO() {
        return shiftRotationInfoDAO;
    }

    public void setShiftRotationInfoDAO(ShiftRotationInfoDAO<T> shiftRotationInfoDAO) {
        this.shiftRotationInfoDAO = shiftRotationInfoDAO;
        setGenericsDAO(shiftRotationInfoDAO);
    }

    @Override
    public List<?> readRotaionDetail(T object) {
        return shiftRotationInfoDAO.readRotaionDetail(object);
    }

    @Override
    public String readFirstShfitId(String userId, String roationId) {
        return shiftRotationInfoDAO.readFirstShfitId(userId, roationId);
    }

    @Override
    public List<?> readByUserId(int usermasterid) {
        return shiftRotationInfoDAO.readByUserId(usermasterid);
    }
    
    @Override
    public List<?> readShiftRotationMaster() {
        return shiftRotationInfoDAO.readShiftRotationMaster();
    }
}
