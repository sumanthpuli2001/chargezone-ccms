/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vacancy;

import com.bul.zydex.dao.Vacancy.VacancyApprovalHistoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class VacancyApprovalHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements VacancyApprovalHistoryService<T> {

    private VacancyApprovalHistoryDAO<T> vacancyApprovalHistoryDAO;

    public VacancyApprovalHistoryDAO<T> getVacancyApprovalHistoryDAO() {
        return vacancyApprovalHistoryDAO;
    }

    public void setVacancyApprovalHistoryDAO(VacancyApprovalHistoryDAO<T> vacancyApprovalHistoryDAO) {
        this.vacancyApprovalHistoryDAO = vacancyApprovalHistoryDAO;
        setGenericsDAO(vacancyApprovalHistoryDAO);
    }

    @Override
    public List<?> readByVacancyId(int id) {
        return vacancyApprovalHistoryDAO.readByVacancyId(id);
    }

    @Override
    public List<?> vacyId(String id) {
        return vacancyApprovalHistoryDAO.vacyId(id);
    }

}
