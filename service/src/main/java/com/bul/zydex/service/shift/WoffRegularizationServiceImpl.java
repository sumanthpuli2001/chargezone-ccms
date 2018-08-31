/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.WoffRegularizationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class WoffRegularizationServiceImpl<T> extends GenericsServiceImpl<T> implements WoffRegularizationService<T> {

    protected WoffRegularizationDAO<T> woffRegularizationDAO;

    public WoffRegularizationDAO<T> getWoffRegularizationDAO() {
        return woffRegularizationDAO;
    }

    public void setWoffRegularizationDAO(WoffRegularizationDAO<T> woffRegularizationDAO) {
        this.woffRegularizationDAO = woffRegularizationDAO;
        setGenericsDAO(woffRegularizationDAO);
    }

    @Override
    public List<?> userReportingManager(int id) {
        return woffRegularizationDAO.userReportingManager(id);
    }

    @Override
    public List<?> approvalLeval1WiseShiftRegularizationList(int id) {
        return woffRegularizationDAO.approvalLeval1WiseShiftRegularizationList(id);
    }

}
