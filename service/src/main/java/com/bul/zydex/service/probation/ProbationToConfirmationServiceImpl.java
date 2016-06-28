/*
 *
 * Author Vinita
 */
package com.bul.zydex.service.probation;

import com.bul.zydex.dao.probation.ProbationToConfirmationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class ProbationToConfirmationServiceImpl<T> extends GenericsServiceImpl<T>
        implements ProbationToConfirmationService<T> {

    private ProbationToConfirmationDAO probationToConfirmationDAO;

    public ProbationToConfirmationDAO getProbationToConfirmationDAO() {
        return probationToConfirmationDAO;
    }

    public void setProbationToConfirmationDAO(ProbationToConfirmationDAO probationToConfirmationDAO) {
        this.probationToConfirmationDAO = probationToConfirmationDAO;
        setGenericsDAO(probationToConfirmationDAO);
    }

    @Override
    public List<?> readForFunctionalHead(T object) {
        return probationToConfirmationDAO.readForFunctionalHead(object);
    }

    @Override
    public List<?> readForHr(T object) {
        return probationToConfirmationDAO.readForHr(object);
    }

    @Override
    public List<?> readForRepeatedId(T object) {
        return probationToConfirmationDAO.readForRepeatedId(object);
    }

    @Override
    public List<?> readForId(T object) {
        return probationToConfirmationDAO.readForId(object);
    }

    @Override
    public List<?> readProbationToConfirmationList() {
        return probationToConfirmationDAO.readProbationToConfirmationList();
    }

    @Override
    public List<?> readForEmp(T object) {
        return probationToConfirmationDAO.readForEmp(object);
    }

    @Override
    public List<?> readloginEmployeeData(int id) {
        return probationToConfirmationDAO.readloginEmployeeData(id);
    }

    @Override
    public List<?> readConfimationDateByTodayDateWise(T object) {
        return probationToConfirmationDAO.readConfimationDateByTodayDateWise(object);
    }

    @Override
    public List<?> readConfirmedEmployee() {
        return probationToConfirmationDAO.readConfirmedEmployee();
    }

}
