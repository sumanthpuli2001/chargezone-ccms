/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vacancy;

import com.bul.zydex.dao.Vacancy.VacancyApprovalDAO;
import com.bul.zydex.model.VacancyApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class VacancyApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements VacancyApprovalService<T> {

    private VacancyApprovalDAO<T> vacancyApprovalDAO;

    public VacancyApprovalDAO<T> getVacancyApprovalDAO() {
        return vacancyApprovalDAO;
    }

    public void setVacancyApprovalDAO(VacancyApprovalDAO<T> vacancyApprovalDAO) {
        this.vacancyApprovalDAO = vacancyApprovalDAO;
        setGenericsDAO(vacancyApprovalDAO);
    }

    @Override
    public VacancyApproval readEmpIdAndVaId(int empid, int id) {
        return vacancyApprovalDAO.readEmpIdAndVaId(empid, id);
    }

    @Override
    public List<?> vacancyId(String vacancyId) {
        return vacancyApprovalDAO.vacancyId(vacancyId);
    }

}
