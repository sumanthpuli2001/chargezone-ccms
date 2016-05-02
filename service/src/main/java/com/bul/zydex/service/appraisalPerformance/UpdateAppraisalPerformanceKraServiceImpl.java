/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.UpdateAppraisalPerformanceKraDAO;
import com.bul.zydex.model.UpdateAppraisalPerformanceKra;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class UpdateAppraisalPerformanceKraServiceImpl<T> extends GenericsServiceImpl<T> implements UpdateAppraisalPerformanceKraService<T>{
    private UpdateAppraisalPerformanceKraDAO<T> updateAppraisalPerformanceKraDAO;

    public UpdateAppraisalPerformanceKraDAO<T> getUpdateAppraisalPerformanceKraDAO() {
        return updateAppraisalPerformanceKraDAO;
    }

    public void setUpdateAppraisalPerformanceKraDAO(UpdateAppraisalPerformanceKraDAO<T> updateAppraisalPerformanceKraDAO) {
        this.updateAppraisalPerformanceKraDAO = updateAppraisalPerformanceKraDAO;
        setGenericsDAO(updateAppraisalPerformanceKraDAO);
    }

    @Override
    public List<?> readByUpdateKragoal(T object) { 
      return updateAppraisalPerformanceKraDAO.readByUpdateKragoal(object);
    }

    @Override
    public List<?> readByUserUpdateKra(T object) {
        return updateAppraisalPerformanceKraDAO.readByUserUpdateKra(object);
    }
    @Override
   public List<?> readByKraIdForDelete(T object){
        return updateAppraisalPerformanceKraDAO.readByKraIdForDelete(object);
    }
     
}
