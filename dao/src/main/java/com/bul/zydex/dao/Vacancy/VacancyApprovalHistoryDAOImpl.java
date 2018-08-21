/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vacancy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VacancyApprovalHistory;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class VacancyApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements VacancyApprovalHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return VacancyApprovalHistory.class;
    }

    @Override
    public List<?> readByVacancyId(int id) {
        String query = "";
        query += " "
                + " SELECT a.id, a.comment, a.status, a.statusMessage, a.createdDate, a.createdBy "
                + " FROM VacancyApprovalHistory a "
                + " WHERE a.vacancyMaster.id = " + id
                + " order by a.id ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
