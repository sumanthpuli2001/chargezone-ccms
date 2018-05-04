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
    public List<?> readForStatusOne() {
        String query = "SELECT a.amountTaxDecaration, b.component, c.section"
                + " FROM TaxDeductionDeclarationSubmit a "
                + " LEFT JOIN a.payrollTaxDeductionComponent b "
                + " LEFT JOIN a.payrollTaxDeductionMaster c "
                + " WHERE a.status = 1";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSectionBySubmitSectionId(Integer tddsId) {
        String query = " SELECT b.id, b.section"
                + " FROM TaxDeductionDecarationSubmit a "
                + " LEFT JOIN a.payrollTaxDeductionMaster b "
                + " WHERE a.taxSavingSubmit.id = " + tddsId
                + " GROUP BY b.section";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readComponentByTaxSavingSubmitId(Integer taxSavingSubmitId, Integer tdmId) {
        String query = "";
        query += "SELECT a.amountTaxDecaration, a.id, a.actionStatus, a.attachment,b.id, b.component "
                + " FROM TaxDeductionDecarationSubmit a"
                + " LEFT JOIN a.payrollTaxDeductionComponent b "
                + " WHERE a.taxSavingSubmit.id = " + taxSavingSubmitId
                + " and a.payrollTaxDeductionMaster.id = " + tdmId;
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSectionByDeclarationId(Integer tssId, Integer tdmId, Integer tdcId) {
        String query = "";
        query += " SELECT a.amountTaxDecaration, a.id, a.actionStatus, a.attachment "
                + " FROM TaxDeductionDecarationSubmit a "
                + " WHERE a.taxSavingSubmit.id = " + tssId + " and a.payrollTaxDeductionMaster = " + tdmId + " and a.payrollTaxDeductionComponent = " + tdcId;
        List list = getHibernateTemplate().find(query);
        return list;
    }


    @Override
    public List<?> readPendingByEmployeeId(int eid) {
        String query = " SELECT a.id, a.actionStatus, b.id, c.id "
                     + " FROM TaxDeductionDecarationSubmit a "
                     + " LEFT JOIN a.taxSavingSubmit b "
                     + " LEFT JOIN b.employeeMaster c "
                     + " WHERE a.actionStatus = 0 and c.id = " + eid;
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApproveByTaxSavingId(int savingid) {
        String query = " SELECT a.actionStatus "
                     + " FROM TaxDeductionDecarationSubmit a "
                     + " LEFT JOIN a.taxSavingSubmit b "
                     + " WHERE a.actionStatus in(0,2,3) and b.id = " + savingid;
        List list = getHibernateTemplate().find(query);
        return list;
    }


}

