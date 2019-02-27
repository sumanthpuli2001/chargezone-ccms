/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.attendanceRegularization;

import com.bul.zydex.dao.attendanceRegularization.OTRegularizationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Success
 */
public class OTRegularizationServiceImpl<T> extends GenericsServiceImpl<T> implements OTRegularizationService<T> {

    protected OTRegularizationDAO<T> oTRegularizationDAO;

    public OTRegularizationDAO<T> getoTRegularizationDAO() {
        return oTRegularizationDAO;
    }

    public void setoTRegularizationDAO(OTRegularizationDAO<T> oTRegularizationDAO) {
        this.oTRegularizationDAO = oTRegularizationDAO;
        setGenericsDAO(oTRegularizationDAO);
    }

    @Override
    public List<?> userWiseOTRegularizationList(int id) {
        return oTRegularizationDAO.userWiseOTRegularizationList(id);
    }

    @Override
    public List<?> userReportingManager(int id) {
        return oTRegularizationDAO.userReportingManager(id);
    }

    @Override
    public List<?> approvalLeval1WiseOtRegularizationList(int id) {
     return oTRegularizationDAO.approvalLeval1WiseOtRegularizationList(id);
    }

    @Override
    public List<?> readOTDateWise(String date, int id) {
        return oTRegularizationDAO.readOTDateWise(date,id);
    }

}
