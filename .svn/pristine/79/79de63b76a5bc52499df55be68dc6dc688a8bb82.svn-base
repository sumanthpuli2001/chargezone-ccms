/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.PerformanceImprovementPlanMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PerformanceImprovementPlanMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements PerformanceImprovementPlanMasterService<T> {

    protected PerformanceImprovementPlanMasterDAO<T> performanceImprovementPlanMasterDAO;

    public PerformanceImprovementPlanMasterDAO<T> getPerformanceImprovementPlanMasterDAO() {
        return performanceImprovementPlanMasterDAO;
    }

    public void setPerformanceImprovementPlanMasterDAO(PerformanceImprovementPlanMasterDAO<T> performanceImprovementPlanMasterDAO) {
        this.performanceImprovementPlanMasterDAO = performanceImprovementPlanMasterDAO;
        setGenericsDAO(performanceImprovementPlanMasterDAO);
    }

    @Override
    public List<?> readPipByEmployeeMaster(T object) {
        return performanceImprovementPlanMasterDAO.readPipByEmployeeMaster(object);
    }

    @Override
    public List<?> viewPipListByManager(String managerId) {
        return performanceImprovementPlanMasterDAO.viewPipListByManager(managerId);
    }

    @Override
    public List<?> viewPipListByAdmin() {
        return performanceImprovementPlanMasterDAO.viewPipListByAdmin();

    }

    @Override
    public List<?> readOwnPipPending(T object) {
        return performanceImprovementPlanMasterDAO.readOwnPipPending(object);
    }

    @Override
    public List<?> readEmployeePipPending(String managerId) {
        return performanceImprovementPlanMasterDAO.readEmployeePipPending(managerId);
    }

}
