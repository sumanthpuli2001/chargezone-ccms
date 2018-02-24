/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vacancy;

import com.bul.zydex.dao.Vacancy.VacancyMasterDAO;
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
    
}
