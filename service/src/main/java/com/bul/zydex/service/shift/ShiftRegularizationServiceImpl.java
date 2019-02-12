/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftRegularizationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class ShiftRegularizationServiceImpl<T> extends GenericsServiceImpl<T> implements ShiftRegularizationService<T> {

    protected ShiftRegularizationDAO<T> shiftRegularizationDAO;

    public ShiftRegularizationDAO<T> getShiftRegularizationDAO() {
        return shiftRegularizationDAO;
    }

    public void setShiftRegularizationDAO(ShiftRegularizationDAO<T> shiftRegularizationDAO) {
        this.shiftRegularizationDAO = shiftRegularizationDAO;
        setGenericsDAO(shiftRegularizationDAO);
    }

    @Override
    public List<?> userWiseShiftRegularizationList(int id) {
       return shiftRegularizationDAO.userWiseShiftRegularizationList(id);
    }

    @Override
    public List<?> userReportingManager(int id) {
       return shiftRegularizationDAO.userReportingManager(id);
    }

    @Override
    public List<?> approvalLeval1WiseShiftRegularizationList(int id) {
         return shiftRegularizationDAO.approvalLeval1WiseShiftRegularizationList(id);
    }

    @Override
    public String getShiftById(String shiftMasterCurrent) {
        return shiftRegularizationDAO.getShiftById(shiftMasterCurrent);
    }
    
}
