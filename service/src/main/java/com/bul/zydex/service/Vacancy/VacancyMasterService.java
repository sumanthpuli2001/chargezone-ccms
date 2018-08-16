/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vacancy;

import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface VacancyMasterService<T> extends GenericsService<T> {

    public List<?> fetchVacancyDetail();

    public List<?> fetchCreatedVacancy(int empId);

    public List<?> fetchVacancyBydate(String date);

    public List<?> fetchDateWiseData(String startDate, String endDate);

    public List<?> fetchApprovVacancy(int empId);

    public VacancyMaster readByVacancyId(int vacancyId);

}
