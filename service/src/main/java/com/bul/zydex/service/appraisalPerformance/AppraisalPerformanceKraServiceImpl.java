/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalPerformanceKraDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceKraServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalPerformanceKraService<T> {

    private AppraisalPerformanceKraDAO<T> appraisalPerformanceKraDAO;

    public AppraisalPerformanceKraDAO<T> getAppraisalPerformanceKraDAO() {
        return appraisalPerformanceKraDAO;
    }

    public void setAppraisalPerformanceKraDAO(AppraisalPerformanceKraDAO<T> appraisalPerformanceKraDAO) {
        this.appraisalPerformanceKraDAO = appraisalPerformanceKraDAO;
        setGenericsDAO(appraisalPerformanceKraDAO);
    }

    @Override
    public List<?> readByAppraisalKraGoal(T object) {
        return appraisalPerformanceKraDAO.readByAppraisalKraGoal(object);
    }

    @Override
    public List<?> readByAppraisalPerformancekraId(T object) {
        return appraisalPerformanceKraDAO.readByAppraisalPerformancekraId(object);
    }

    @Override
    public void delete1(T object) {
        appraisalPerformanceKraDAO.delete1(object);
    }
}
