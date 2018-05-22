/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vacancy;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface VacancyMasterDAO<T> extends GenericsDAO<T> {

    public List<?> fetchVacancyDetail();

    public List<?> fetchCreatedVacancy(int empId);

    public List<?> fetchVacancyBydate(String date);

    public List<?> fetchDateWiseData(String startDate, String endDate);

}
