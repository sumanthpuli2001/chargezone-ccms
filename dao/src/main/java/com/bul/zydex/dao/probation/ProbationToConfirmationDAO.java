/*
 *
 * Author Vinita
 */
package com.bul.zydex.dao.probation;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Vinita
 */
public interface ProbationToConfirmationDAO<T> extends GenericsDAO<T> {

//    public List<?> readExistingEmployee(T object);
    public List<?> readForFunctionalHead(T object);

    public List<?> readForHr(T object);

    public List<?> readForRepeatedId(T object);

    public List<?> readForEmp(T object);

    public List<?> readForId(T object);

    public List<?> readProbationToConfirmationList();

    public List<?> readloginEmployeeData(int id);

    public List<?> readConfimationDateByTodayDateWise(T object);

    public List<?> readConfirmedEmployee();

    public List<?> readByAssessmentToDate(String date);

}
