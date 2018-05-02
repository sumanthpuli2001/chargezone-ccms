/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollFinancialYear;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFinancialYearDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollFinancialYearDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollFinancialYear.class;
    }

//    public PayrollFinancialYear readByFinancialId(int parseInt) {
//        String query = "SELECT a from "
//                + " PayrollFinancialYear a "
//                + " WHERE a.id = "+parseInt;
//        return (PayrollFinancialYear) getHibernateTemplate().find(query);
//    }
    @Override
    public List<?> readDayFinancialYear(int locationId, String month, String year) {
        String query = "";
        String condition = "";
        String date = "01/" + month + "/" + year;

        query += " select a.id,a.startDate,a.endDate"
                + " From PayrollFinancialYear a"
                + " where a.zydexLocationMaster.id=" + locationId
                + " and (str_to_date('" + date + "','%d/%m/%Y') between str_to_date(a.startDate,'%d/%m/%Y')"
                + " and str_to_date(a.endDate,'%d/%m/%Y'))";
//               + " and DATE_FORMAT(STR_TO_DATE('01/" + month + "/" + year + "', '%d/%m/%Y'),'%m/%Y')"
//                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.startDate, '%d/%m/%Y'),'%m/%Y') AND DATE_FORMAT(STR_TO_DATE(a.endDate, '%d/%m/%Y'),'%m/%Y')";
//                + " and DATE_FORMAT(STR_TO_DATE('" + month + "/" + year + "', '%m/%Y'),'%m/%Y')"
//                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.startDate, '%d/%m/%Y'),'%m/%Y') AND DATE_FORMAT(STR_TO_DATE(a.endDate, '%d/%m/%Y'),'%m/%Y')";
//                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);
    }

}
