/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisal;

import com.bul.zydex.dao.appraisal.Appraisal360DAO;
import com.bul.zydex.service.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class Appraisal360SeviceImpl<T> extends GenericsServiceImpl<T> implements Appraisal360Service<T> {

    private Appraisal360DAO<T> appraisal360DAO;

    public Appraisal360DAO<T> getAppraisal360DAO() {
        return appraisal360DAO;
    }

    public void setAppraisal360DAO(Appraisal360DAO<T> appraisal360DAO) {
        this.appraisal360DAO = appraisal360DAO;
        setGenericsDAO(appraisal360DAO);
    }

    @Override
    public List<?> readEmployeeAppraisalFeedback(int id) {
        return appraisal360DAO.readEmployeeAppraisalFeedback(id);
    }

    @Override
    public List<?> readHRAppraisalData(int id, int forId) {
        return appraisal360DAO.readHRAppraisalData(id, forId);
    }

    @Override
    public List<?> readAppraisalList() {
        return appraisal360DAO.readAppraisalList();
    }

    @Override
    public List<?> readAppraisalFeedbackView(int ForId, String Pdate, String Cdate) {
        return appraisal360DAO.readAppraisalFeedbackView(ForId, Pdate, Cdate);
    }

    @Override
    public List<?> searchAppraisalFeedback(int empId, String startD, String endD) {
        return appraisal360DAO.searchAppraisalFeedback(empId, startD, endD);
    }

    @Override
    public List<?> read360SearchByEmployee(T object) {
        return appraisal360DAO.read360SearchByEmployee(object);
    }

    @Override
    public List<?> read360SearchByFillingEmployee(T object) {  
        return appraisal360DAO.read360SearchByFillingEmployee(object);
    } 

    @Override
    public int countEmployeeAppraisalFeedback(int id) {
        return  appraisal360DAO.countEmployeeAppraisalFeedback(id);
    }

}   
