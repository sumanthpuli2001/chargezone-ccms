/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalkraActivityDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author HRINTRA
 */
public class AppraisalkraActivityServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalkraActivityService<T> {
    
    protected AppraisalkraActivityDAO<T> appraisalkraActivityDAO;

    public AppraisalkraActivityDAO<T> getAppraisalkraActivityDAO() {
        return appraisalkraActivityDAO;
    }

    public void setAppraisalkraActivityDAO(AppraisalkraActivityDAO<T> appraisalkraActivityDAO) {
        this.appraisalkraActivityDAO = appraisalkraActivityDAO;
        setGenericsDAO(appraisalkraActivityDAO);
    }
    
    public List<?> readByKraGoalName(T object){
        return  appraisalkraActivityDAO.readByKraGoalName(object);
    }
    public List<?> readByActivitiesName(T object){
        return  appraisalkraActivityDAO.readByActivitiesName(object);
    }
    
     
}
