/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalFillingDataDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalFillingDataServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalFillingDataService<T>{
    private AppraisalFillingDataDAO<T> appraisalFillingDataDAO;

    public AppraisalFillingDataDAO<T> getAppraisalFillingDataDAO() {
        return appraisalFillingDataDAO;
    }

    public void setAppraisalFillingDataDAO(AppraisalFillingDataDAO<T> appraisalFillingDataDAO) {
        this.appraisalFillingDataDAO = appraisalFillingDataDAO;
        setGenericsDAO(appraisalFillingDataDAO); 
    }

    @Override
    public boolean isExist(String year) {
        return appraisalFillingDataDAO.isExist(year); 
    }

    @Override
    public List<?> readByCurrentYear(String cyear) {
       return appraisalFillingDataDAO.readByCurrentYear(cyear);
    }

    @Override
    public List<?> getCurrentAndPreviousYear() {
        return appraisalFillingDataDAO.getCurrentAndPreviousYear();
    }

    @Override
    public List<?> getappraisalDate() {
        return appraisalFillingDataDAO.getappraisalDate();
    }
}
