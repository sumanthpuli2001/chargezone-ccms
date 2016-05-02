/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalPerformanceIndividualDevelopmentPlanDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceIndividualDevelopmentPlanServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalPerformanceIndividualDevelopmentPlanService<T> {

    private AppraisalPerformanceIndividualDevelopmentPlanDAO<T> appraisalPerformanceIndividualDevelopmentPlanDAO;

    public AppraisalPerformanceIndividualDevelopmentPlanDAO<T> getAppraisalPerformanceIndividualDevelopmentPlanDAO() {
        return appraisalPerformanceIndividualDevelopmentPlanDAO;
    }

    public void setAppraisalPerformanceIndividualDevelopmentPlanDAO(AppraisalPerformanceIndividualDevelopmentPlanDAO<T> appraisalPerformanceIndividualDevelopmentPlanDAO) {
        this.appraisalPerformanceIndividualDevelopmentPlanDAO = appraisalPerformanceIndividualDevelopmentPlanDAO;
        setGenericsDAO(appraisalPerformanceIndividualDevelopmentPlanDAO);
    }

    @Override
    public List<?> readIndividualDevelopmentPlanDetail(T object) {
        return appraisalPerformanceIndividualDevelopmentPlanDAO.readIndividualDevelopmentPlanDetail(object);
    }

    @Override
    public void delete1(T object) {
        appraisalPerformanceIndividualDevelopmentPlanDAO.delete1(object);
    }
}
