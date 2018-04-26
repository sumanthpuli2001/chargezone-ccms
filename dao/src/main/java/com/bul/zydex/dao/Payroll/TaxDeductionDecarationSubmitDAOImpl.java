/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class TaxDeductionDecarationSubmitDAOImpl<T> extends GenericsDAOImpl<T> implements TaxDeductionDecarationSubmitDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TaxDeductionDecarationSubmit.class;
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmit(int taxSavingSubmitID) {
        String query = "";
        query += " select a.payrollTaxDeductionMaster.id "
                + " From TaxDeductionDecarationSubmit a "
                + " where a.taxSavingSubmit = " + taxSavingSubmitID
                + " GROUP BY a.payrollTaxDeductionMaster.id";

//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitAmount(int taxSavingSubmitID, int taxDeductionMaster, int taxDeductioncomponent) {
        String query = "";
        query += " select a.amountTaxDecaration,a.attachment "
                + " From TaxDeductionDecarationSubmit a "
                + " where a.taxSavingSubmit = " + taxSavingSubmitID
                + " and a.payrollTaxDeductionMaster = " + taxDeductionMaster
                + " and a.payrollTaxDeductionComponent = " + taxDeductioncomponent;

//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByTaxDeductionDecarationDelete(int taxSavingSubmit) {
        String query = "";
        String condition = "";
//        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " select a "
                + "From TaxDeductionDecarationSubmit a"
                + " left join a.taxSavingSubmit b"
                + " where b.id= " + taxSavingSubmit;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByTaxDeductionDecarationFetchRead(int taxSavingSubmit, int taxDeductionMaster, int taxDeductioncomponent) {
        String query = "";
        query += " select a "
                + " From TaxDeductionDecarationSubmit a "
                + " where a.taxSavingSubmit = " + taxSavingSubmit
                + " and a.payrollTaxDeductionMaster = " + taxDeductionMaster
                + " and a.payrollTaxDeductionComponent = " + taxDeductioncomponent;

//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitSalaryGenerate(int taxSavingSubmitID) {
        String query = "";
        query += " select SUM(a.amountTaxDecaration)"
                + " From TaxDeductionDecarationSubmit a "
                + " where a.taxSavingSubmit = " + taxSavingSubmitID;

//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitSalaryGenerateAfterDate(int taxSavingSubmitID) {
        String query = "";
        query += " select SUM(a.amountTaxDecaration)"
                + " From TaxDeductionDecarationSubmit a "
                + " where a.taxSavingSubmit = " + taxSavingSubmitID
                + " and a.actionStatus = " + 2;

//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(int taxSavingSubmitID) {
        String query = "";
        query += " select SUM(a.amountTaxDecaration),a.payrollTaxDeductionMaster.id,a.payrollTaxDeductionMaster.taxSavingLimit,a.payrollTaxDeductionMaster.additionalTaxBenefit"
                + " From TaxDeductionDecarationSubmit a "
                + " where a.taxSavingSubmit = " + taxSavingSubmitID
                + " Group by a.payrollTaxDeductionMaster.id";

//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

}
