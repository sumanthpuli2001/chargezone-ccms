/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionMasterDaoImpl<T> extends GenericsDAOImpl<T> implements PayrollTaxDeductionMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollTaxDeductionMaster.class;
    }

    @Override
    public List<?> readTaxDeduction() {

        String query = "SELECT a "
                + " FROM PayrollTaxDeductionMaster a";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readByComponentId(int parseInt) {
        String query = "SELECT a "
                + " FROM PayrollTaxDeductionComponent a";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readSection() {
        String query = "SELECT a.id,a.section "
                + " FROM PayrollTaxDeductionMaster a";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTaxDeductionForFormSixteen() {
        String query = "SELECT a.id,a.section,a.description "
                + " FROM PayrollTaxDeductionMaster a";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSectionByName(String sectionName) {
        String query = "SELECT a.section "
                + " FROM PayrollTaxDeductionMaster a "
                + " WHERE a.section = " + "'" + sectionName + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTaxDeductionForFormSixteenFetch(int taxMasterid) {
        String query = "SELECT a.id,a.section,a.description "
                + " FROM PayrollTaxDeductionMaster a"
                + " where a.id = " + taxMasterid;

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }
}
