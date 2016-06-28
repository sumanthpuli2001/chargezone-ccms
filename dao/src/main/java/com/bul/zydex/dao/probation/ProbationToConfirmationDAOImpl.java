/*
 *
 * Author Vinita
 */
package com.bul.zydex.dao.probation;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ProbationToConfirmation;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Vinita
 */
public class ProbationToConfirmationDAOImpl<T> extends GenericsDAOImpl<T> implements ProbationToConfirmationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ProbationToConfirmation.class;
    }

    @Override
    public List<?> readForFunctionalHead(T object) {
        ProbationToConfirmation ptc = (ProbationToConfirmation) object;
        String query = "";
        query += "Select a.id,b.employeeId,b.employeeName,b.dateOfJoining,b.id"
                + " from ProbationToConfirmation a "
                + " left join a.employeeMasterByEmployeeMasterId b "
                + " where b.reportingManagerLevel5 = " + ptc.getFunctionalHeadId()
                + " and a.status in (1)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForHr(T object) {
        ProbationToConfirmation ptc = (ProbationToConfirmation) object;
        String query = "";
        query += "Select a.id,b.employeeId,b.employeeName,b.dateOfJoining,b.id,a.status"
                + " from ProbationToConfirmation a "
                + " left join a.employeeMasterByEmployeeMasterId b ";
//                + " where a.status in (2)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForRepeatedId(T object) {
        ProbationToConfirmation ptc = (ProbationToConfirmation) object;
        String query = "";
        query += ""
                + " from ProbationToConfirmation a "
                + " where a.employeeMasterByEmployeeMasterId = " + ptc.getEmployeeMasterByEmployeeMasterId().getId();
//              + " and a.status in (4,6)";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForEmp(T object) {
        ProbationToConfirmation ptc = (ProbationToConfirmation) object;
        String query = "";
        query += "Select a.id,b.employeeId,b.employeeName,b.dateOfJoining,b.id,a.status,a.assessmentFromDate,a.assessmentToDate,"
                + "a.reportingManagerId ,a.functionalHeadId,c.employeeName"
                + " from ProbationToConfirmation a "
                + " left join a.employeeMasterByEmployeeMasterId b "
                + " left join a.employeeMasterByHrId c "
                + " where a.employeeMasterByEmployeeMasterId = " + ptc.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status != 8"
                + " ORDER BY a.assessmentToDate desc limit 1 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForId(T object) {
        ProbationToConfirmation ptc = (ProbationToConfirmation) object;
        String query = "";
        query += " select a.id "
                + " from ProbationToConfirmation a "
                + " where a.employeeMasterByEmployeeMasterId = " + ptc.getEmployeeMasterByEmployeeMasterId().getId();
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readProbationToConfirmationList() {
//        String hqlQuery = "Select"
//                + " SUM(CASE WHEN ptc.status IN(1,2) THEN 1 ELSE 0 END) AS Pending,"
//                + " SUM(CASE WHEN ptc.status = 5 AND Str_To_date(concat(str(DAY(STR_TO_DATE(ptc.hrSubmitDate, '%d/%m/%Y'))),str('/'),str(MONTH(STR_TO_DATE(ptc.hrSubmitDate, '%d/%m/%Y'))+1),str('/'),str(YEAR(STR_TO_DATE(ptc.hrSubmitDate, '%d/%m/%Y')))),'%d/%m/%Y') > curdate() AND 1=1 THEN 1 ELSE 0 END) AS Completed"
//                + " FROM ProbationToConfirmation as ptc"
//                + "";
        String sqlString = "select SUM(CASE WHEN ptc.status IN(1,2) THEN 1 ELSE 0 END) AS Pending, SUM(CASE WHEN ptc.status = 5 AND"
                + " (Str_to_date(concat('31/03/',financial.startYear),'%d/%m/%Y')"
                + " <= Str_To_date(concat(DAY(STR_TO_DATE(ptc.hr_submit_date, '%d/%m/%Y')),"
                + " '/', (MONTH(STR_TO_DATE(ptc.hr_submit_date, '%d/%m/%Y'))), "
                + " '/', YEAR(STR_TO_DATE(ptc.hr_submit_date, '%d/%m/%Y'))),'%d/%m/%Y')) AND"
                + " (Str_To_date(concat(DAY(STR_TO_DATE(ptc.hr_submit_date, '%d/%m/%Y')),"
                + " '/', (MONTH(STR_TO_DATE(ptc.hr_submit_date, '%d/%m/%Y'))),"
                + " '/', YEAR(STR_TO_DATE(ptc.hr_submit_date, '%d/%m/%Y'))),'%d/%m/%Y')"
                + " <= Str_to_date(concat('31/03/',(financial.startYear+1)),'%d/%m/%Y'))  THEN 1 ELSE 0 END) AS Completed"
                + " from probation_to_confirmation as ptc,"
                + " (select case when MONTH(STR_TO_DATE(ptc2.hr_submit_date,'%d/%m/%Y'))>=4"
                + " then YEAR(STR_TO_DATE(ptc2.hr_submit_date,'%d/%m/%Y'))"
                + " else YEAR(STR_TO_DATE(ptc2.hr_submit_date,'%d/%m/%Y'))-1"
                + " end as startYear"
                + " from probation_to_confirmation as ptc2"
                + " where ptc2.status = 5) as financial";
        Query query = getSession().createSQLQuery(sqlString);
        List<?> probationToconfirmationRequestDataList = query.list();
        return probationToconfirmationRequestDataList;
    }

    public List<?> readloginEmployeeData(int id) {
        String query = "";
        query += " "
                + " from ProbationToConfirmation a "
                + " where a.employeeMasterByEmployeeMasterId = " + id
                + " and a.status != 8";
        return getHibernateTemplate().find(query);
    }

    public List<?> readConfimationDateByTodayDateWise(T object) {
        ProbationToConfirmation ptc = (ProbationToConfirmation) object;
        String query = "";
        query += " "
                + " from ProbationToConfirmation a "
                + " where a.status = 5"
                + " and STR_TO_DATE(a.assessmentToDate,'%d/%m/%Y') = STR_TO_DATE('" + ptc.getAssessmentFromDate() + "','%d/%m/%Y')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readConfirmedEmployee() {
        String query = "";
        query += "Select b.employeeId, b.employeeName,"
                + " c.departmentName,"
                + " d.designationName,"
                + " a.assessmentFromDate, a.assessmentToDate,a.status,"
                + " a.id, b.id"
                + " From ProbationToConfirmation a "
                + " Left Join a.employeeMasterByEmployeeMasterId b"
                + " Left Join b.departmentMaster c"
                + " Left Join b.designationMaster d"
                + " Where a.status=5";
        return getHibernateTemplate().find(query);
    }
}
