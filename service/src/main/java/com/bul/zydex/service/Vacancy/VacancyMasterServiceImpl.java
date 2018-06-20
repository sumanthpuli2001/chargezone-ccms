/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vacancy;

import com.bul.zydex.dao.Vacancy.VacancyMasterDAO;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class VacancyMasterServiceImpl<T> extends GenericsServiceImpl<T> implements VacancyMasterService<T> {

    private VacancyMasterDAO<T> vacancyMasterDAO;

    public VacancyMasterDAO<T> getVacancyMasterDAO() {
        return vacancyMasterDAO;
    }

    public void setVacancyMasterDAO(VacancyMasterDAO<T> vacancyMasterDAO) {
        this.vacancyMasterDAO = vacancyMasterDAO;
        setGenericsDAO(vacancyMasterDAO);
    }

    @Override
    public List<?> fetchVacancyDetail() {
        return vacancyMasterDAO.fetchVacancyDetail();
    }

    @Override
    public List<?> fetchCreatedVacancy(int empId) {
        return vacancyMasterDAO.fetchCreatedVacancy(empId);
    }

    @Override
    public List<?> fetchVacancyBydate(String date) {
           return vacancyMasterDAO.fetchVacancyBydate(date);
    }

    @Override
    public List<?> fetchDateWiseData(String startDate, String endDate) {
        return vacancyMasterDAO.fetchDateWiseData(startDate, endDate);
    }

    @Override
    public VacancyMaster readByVacancyId(int vacancyId) {
        return vacancyMasterDAO.readByVacancyId(vacancyId);
    }

}
