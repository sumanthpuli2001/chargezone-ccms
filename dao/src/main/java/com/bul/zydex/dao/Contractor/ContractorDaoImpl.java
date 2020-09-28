/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Contractor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ContractorMaster;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Aman Bahukhandi
 */
public class ContractorDaoImpl<T> extends GenericsDAOImpl<T> implements ContractorDao<T> {

    @Override
    protected Class getDomainClass() {
        return ContractorMaster.class;
    }

    @Override
    public Boolean readByContractorCode(String contractorCode) {

        String query = "";
        query += " FROM ContractorMaster a"
                + " WHERE a.contractorCode = '" + contractorCode + "'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public ContractorMaster read(String ccCode) {
        ContractorMaster contractorMaster = new ContractorMaster();
        String query = "";
        query += " FROM ContractorMaster a"
                + " WHERE a.contractorCode = '" + ccCode + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            contractorMaster = (ContractorMaster) list.get(0);
        }
        return contractorMaster;
    }

    @Override
    public void deleteByContractorCode(String checkedValues) {
        String query = "";
        query += " delete FROM ContractorMaster a"
                + " WHERE a.contractorCode = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readShift(String code) {

        String query = "";
        query = " Select a.shiftType from ContractorMaster a where a.contractorCode='" + code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public ContractorMaster readByRfIdValue(String empCode) {
        ContractorMaster contractorMaster = null;

        String query = "";
        query += " FROM ContractorMaster a"
                + " WHERE a.rfId = '" + empCode + "'";

        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return contractorMaster;
        } else {
            contractorMaster = (ContractorMaster) list.get(0);
        }
        return contractorMaster;
    }

    @Override
    public List readContractor() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(sdf.format(d));

        LocalDate returnvalue = date.minusDays(60);

        String query = "";
        query = " Select a from ContractorMaster a where "
                + " (STR_TO_DATE(a.endDate,'%Y-%m-%d') <= STR_TO_DATE('" + date + "', '%Y-%m-%d')) "
                + " and (STR_TO_DATE('" + returnvalue + "', '%Y-%m-%d') <= STR_TO_DATE(a.endDate,'%Y-%m-%d')) "
                + " order by a.endDate DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readContractorLast60Days() {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(sdf.format(d));

        LocalDate returnvalue = date.minusDays(60);

        String query = "";
        query = " Select a from ContractorMaster a where "
                + " (STR_TO_DATE('" + returnvalue + "', '%Y-%m-%d') <= STR_TO_DATE(a.endDate,'%Y-%m-%d')) "
                + " order by a.endDate DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrow() {
        String query = "";
        query = " Select a from ContractorMaster a where a.dRow = 'N' ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrowDisable() {
        String query = "";
        query = " Select a from ContractorMaster a where a.dRow = 'Y' ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRfId(String rfId) {
        String query = "";
        query += " FROM ContractorMaster a"
                + " WHERE a.rfId = '" + rfId + "'";

        return getHibernateTemplate().find(query);

    }
}
