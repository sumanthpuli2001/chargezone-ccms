/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vacancy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VacancyMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class VacancyMasterDAOImpl<T> extends GenericsDAOImpl<T> implements VacancyMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return VacancyMaster.class;
    }

    @Override
    public List<?> fetchVacancyDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.numberOfPosition, a.salaryRange, a.experience, a.status, a.fromDate, a.toDate"
                + " FROM VacancyMaster a ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
