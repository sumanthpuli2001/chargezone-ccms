/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vacancy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VacancyApproval;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class VacancyApprovalDAOImpl<T> extends GenericsDAOImpl<T> implements VacancyApprovalDAO<T> {

    @Override
    protected Class getDomainClass() {
        return VacancyApproval.class;
    }

    @Override
    public VacancyApproval readEmpIdAndVaId(int empid, int id) {
        VacancyApproval vacancyApproval = new VacancyApproval();
        String query = "SELECT a"
                + " FROM VacancyApproval a "
                + " WHERE a.vacancyMaster.id = " + id
                + " and a.employeeMaster.id = " + empid;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vacancyApproval = (VacancyApproval) list.get(0);
        } else {
            vacancyApproval = null;
        }
        return vacancyApproval;
    }

}
