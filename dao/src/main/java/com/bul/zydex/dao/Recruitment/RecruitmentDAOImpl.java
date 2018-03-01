/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RecruitmentMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class RecruitmentDAOImpl<T> extends GenericsDAOImpl<T> implements RecruitmentDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RecruitmentMaster.class;
    }

    @Override
    public List<?> readBudgetDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.numberOfPosition, a.budget, a.date, b.location, c.departmentName, d.jobTypeName, a.mppStatus"
                + " FROM RecruitmentMaster a "
                + " LEFT JOIN a.locationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.jobtypeMaster d "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForBudgetDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.numberOfPosition, a.budget, b.location, c.departmentName, d.jobTypeName"
                + " FROM RecruitmentMaster a "
                + " LEFT JOIN a.locationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.jobtypeMaster d "
                + " where (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
