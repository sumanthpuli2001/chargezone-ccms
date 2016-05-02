/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisal;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface Appraisal360DAO<T> extends GenericsDAO<T> {

    public List<?> readEmployeeAppraisalFeedback(int id);

    public List<?> readHRAppraisalData(int id, int forId);

    public List<?> readAppraisalList();

    public List<?> readAppraisalFeedbackView(int ForId, String Pdate, String Cdate);

    public List<?> searchAppraisalFeedback(int empId, String startD, String endD);
    public List<?> read360SearchByEmployee(T object);
    public List<?> read360SearchByFillingEmployee(T object);
}
