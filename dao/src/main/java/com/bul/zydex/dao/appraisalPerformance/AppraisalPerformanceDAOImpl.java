/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.model.AppraisalPerformanceKra;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.EmployeeMaster;
import java.sql.SQLException;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;
import org.apache.commons.collections.ListUtils;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalPerformanceDAO<T> {

    private Object HibernateUtil;

    @Override
    protected Class getDomainClass() {
        return AppraisalPerformanceMaster.class;
    }

    @Override
    public List<?> readEmployeesAppraisalPerformance(EmployeeMaster employeeMaster, boolean hr, int year) {
        String query = "";
        String condition = "";
        if (!hr) {
            query += " "
                    + " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName, c.designationName, b.role,e.id,a.behaviorsYear"
                    + " FROM AppraisalPerformanceMaster a "
                    //+ " FROM EmployeeMaster a "
                    + " LEFT JOIN a.employeeMaster b "
                    + " LEFT JOIN b.designationMaster c "
                    + " LEFT JOIN b.departmentMaster d "
                    + " LEFT JOIN b.userMaster e "
                    + " WHERE status=1 and "
                    //                + condition
                    + "(b.reportingManagerLevel1='" + employeeMaster.getId() + "')"
//                    + "(b.reportingManagerLevel1='" + employeeMaster.getId() + "'"
//                    + " or b.reportingManagerLevel2='" + employeeMaster.getId() + "'"
//                    + " or b.reportingManagerLevel3='" + employeeMaster.getId() + "'"
//                    + " or b.reportingManagerLevel4='" + employeeMaster.getId() + "'"
//                    + " or b.reportingManagerLevel5='" + employeeMaster.getId() + "')"
                    + " and a.behaviorsYear='" + year + "'"
                    + " and ((b.dateOfLeaving is null or b.dateOfLeaving = '') "
                    + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())"
                    + " order by a.behaviorsYear desc";
//            condition += " b.reportingManagerLevel1='" + employeeMaster.getId() + "'";

        } else {
            query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName, c.designationName, b.role,e.id,a.behaviorsYear,f.id"
                    + " FROM AppraisalPerformanceMaster a "
                    + " LEFT JOIN a.appraisalPerformanceKras f"
                    //+ " FROM EmployeeMaster a "
                    + " LEFT JOIN a.employeeMaster b "
                    + " LEFT JOIN b.designationMaster c "
                    + " LEFT JOIN b.departmentMaster d "
                    + " LEFT JOIN b.userMaster e "
                    + " WHERE status=1 "
                    + " and a.behaviorsYear='" + year + "'"
                    + " group By a.id order by a.behaviorsYear desc";

        }
//        query += " "
//                + " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName, c.designationName, b.role,e.id,a.behaviorsYear"
//                + " FROM AppraisalPerformanceMaster a "
//                //+ " FROM EmployeeMaster a "
//                + " LEFT JOIN a.employeeMaster b "
//                + " LEFT JOIN b.designationMaster c "
//                + " LEFT JOIN b.departmentMaster d "
//                + " LEFT JOIN b.userMaster e "
//                + " WHERE status=1 and "
////                + condition
//                + " b.reportingManagerLevel1='" + employeeMaster.getId() + "'"
//                + " order by a.behaviorsYear desc";
        //+ " LEFT JOIN a.appraisalPerformanceMaster e ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByAppraisalPerformanceId(String employeeId, int year) {

        String query = "";
        int cyear = Calendar.getInstance().get(Calendar.YEAR);
        query += "  "
                + "FROM AppraisalPerformanceMaster a "
                + " WHERE a.behaviorsYear =" + year
                //                + " WHERE (a.behaviorsYear =" + year + " or a.behaviorsYear =" + cyear + ")"
                // + " or a.behaviorsYear =" + year + 1
                + " and a.employeeMaster = " + employeeId;
//                + "FROM AppraisalPerformanceMaster a "
//                + " WHERE a.employeeMaster = " + employeeId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByAppraisalPerformanceIdAndYearWise(String employeeId, int year) {

        String query = "";
        int cyear = Calendar.getInstance().get(Calendar.YEAR);
        query += "  "
                + " FROM AppraisalPerformanceMaster a "
                + " WHERE (a.behaviorsYear =" + year + " or a.behaviorsYear =" + cyear + ")"
                + " and a.employeeMaster = " + employeeId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public int readperformanceByHr(final int currentYear) {
//        String hqlQuery = "select"
//                + " (Select count(*) from EmployeeMaster em where ((em.dateOfLeaving is null or em.dateOfLeaving = '') or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and status=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and apm1.weightageScore is not null and status=1 and managerStatus=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and apm1.empMidyearSelfassOtheractivty is not null and status=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and apm1.managerMidyearReviewevalOtheractivity is not null and status=1 and managerStatus=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and apm1.empEndyearSelfassOtheractivty is not null and status=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and apm1.managerEndyearReviewevalOtheractivity is not null and status=1 and managerStatus=1)"
//                + " from AppraisalPerformanceMaster";
//test queary///
//        String hqlQuery = "select"
//                + " (Select count(*) from EmployeeMaster em where ((em.dateOfLeaving is null or em.dateOfLeaving = '') or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and status=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and apm1.weightageScore is not null and status=1 and managerStatus=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and status=1 and midYearEmployeeStatus=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and status=1 and managerStatus=1 and midYearManagerStatus=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and status=1 and endYearEmployeeStatus=1),"
//                + " (select count(Distinct apm1.employeeMaster.id) from AppraisalPerformanceMaster apm1 where apm1.behaviorsYear=" + currentYear + " and status=1 and managerStatus=1 and endYearManagerStatus=1)"
//                + " from AppraisalPerformanceMaster";
////                + " LEFT JOIN apm1.appraisalPerformanceKras b";

        //Employee’s Mid Year Self Assessment/////
        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceKra a"
                + " LEFT JOIN a.appraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and (a.empMidyearSelfassessmentGoal is not null or"
                + " a.empMidyearSelfassessmentGoal !='') and b.managerStatus=1 "
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = ''"
                + " or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (Integer) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public int readperformanceByHr1(final int currentYear) {
//KRA Setting By Employee
        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and ((c.dateOfLeaving is null or c.dateOfLeaving = '')"
                + "or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (int) (long) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public int readperformanceByHr2(final int currentYear) {
        //KRA Approval By Manager
        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and b.managerStatus=1 and ((c.dateOfLeaving is null or c.dateOfLeaving = '')"
                + "or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (int) (long) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public int readperformanceByHr3(final int currentYear) {
        //Employee’s Mid Year Self Assessment

        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceKra a"
                + " LEFT JOIN a.appraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and (a.empMidyearSelfassessmentGoal is not null or"
                + " a.empMidyearSelfassessmentGoal !='') and b.managerStatus=1 "
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = ''"
                + " or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (int) (long) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public int readperformanceByHr4(final int currentYear) {
        //Manager’s Mid Year Review

        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceKra a"
                + " LEFT JOIN a.appraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and (a.managerMidyearReviewEvaluation is not null or"
                + " a.managerMidyearReviewEvaluation !='') and b.managerStatus=1 "
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = ''"
                + " or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (int) (long) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public int readperformanceByHr5(final int currentYear) {
//       Employee’s End Year Self Assessment

        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceKra a"
                + " LEFT JOIN a.appraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and (a.empEndyearSelfassessmentGoal is not null or"
                + " a.empEndyearSelfassessmentGoal !='') and b.managerStatus=1 "
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = ''"
                + " or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (int) (long) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public int readperformanceByHr6(final int currentYear) {
//       Manager’s End Year Review

        String hqlQuery = "SELECT count(Distinct b.employeeMaster.id) from AppraisalPerformanceKra a"
                + " LEFT JOIN a.appraisalPerformanceMaster b"
                + " LEFT JOIN b.employeeMaster c"
                + " where b.behaviorsYear=" + currentYear + " and b.status=1 and (a.managerEndyearReviewEvaluation is not null or"
                + " a.managerEndyearReviewEvaluation !='') and b.managerStatus=1 "
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = ''"
                + " or STR_TO_DATE(c.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return (int) (long) getHibernateTemplate().find(hqlQuery).get(0);
    }

    @Override
    public List<?> readperformanceByHr() {

        String hqlQuery = "Select count(*) from EmployeeMaster em where ((em.dateOfLeaving is null or em.dateOfLeaving = '') or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";
//        String hqlQuery = "select count(Distinct em1.id) from EmployeeMaster em1 where em1.dateOfLeaving is null or em1.dateOfLeaving is ''  or em1.dateOfLeaving > DATE_FORMAT(now(),'%d/%m/%Y - %h:%m')";

        return getHibernateTemplate().find(hqlQuery);
    }

    @Override
    public List<?> readOwnAppraisalPerformance(EmployeeMaster employeeMaster, int cyear) {
        String query = "";
        String condition = "";

        query += " "
                + " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName, c.designationName, b.role,e.id,a.behaviorsYear,"
                + " (SELECT  afd.year from AppraisalFillingData afd where afd.id=a.behaviorsYear)as cycleName,"
                + " (SELECT  afd.cycleyear from AppraisalFillingData afd where afd.id=a.behaviorsYear)as cycleYear"
                + " FROM AppraisalPerformanceMaster a "
                //+ " FROM EmployeeMaster a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN b.designationMaster c "
                + " LEFT JOIN b.departmentMaster d "
                + " LEFT JOIN b.userMaster e "
                //+ " WHERE status=1 "
                // + " a.behaviorsYear !="+ cyear
                + " WHERE a.employeeMaster=" + employeeMaster.getId();
        // + " b.reportingManagerLevel1='" + employeeMaster.getId() + "'"
//                + " order by a.behaviorsYear desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readOwnAppraisalPerformanceTimeLine(EmployeeMaster employeeMaster, int cyear) {
        String query = "";
        String condition = "";

//        query += " "
//                + " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName, c.designationName, b.role,e.id,a.behaviorsYear"
//                + " FROM AppraisalPerformanceMaster a "
//                //+ " FROM EmployeeMaster a "
//                + " LEFT JOIN a.employeeMaster b "
//                + " LEFT JOIN b.designationMaster c "
//                + " LEFT JOIN b.departmentMaster d "
//                + " LEFT JOIN b.userMaster e "
//                //+ " WHERE status=1 "
//                + " a.behaviorsYear =" + cyear
//                + " WHERE a.employeeMaster=" + employeeMaster.getId() + ""
//                + " order by a.behaviorsYear desc";
//
        // + " b.reportingManagerLevel1='" + employeeMaster.getId() + "'"
//                + " order by a.behaviorsYear desc";
        query += "  "
                + "FROM AppraisalPerformanceMaster a "
                + " WHERE a.behaviorsYear =" + cyear
                + " and a.employeeMaster = " + employeeMaster.getId();
//                + "and a.employeeStatus=1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readPMPSearchByEmployee(T object, int pyear) {
        AppraisalPerformanceMaster appraisalPerformanceMaster = (AppraisalPerformanceMaster) object;
        String query = "";
        String condition = "";

        if (null != appraisalPerformanceMaster.getEmployeeMaster().getId()) {
            condition += " AND  b.id = " + appraisalPerformanceMaster.getEmployeeMaster().getId();
        }

        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark() && !"".equals(appraisalPerformanceMaster.getBehaviorsMidyearOtherremark())) {
            condition += " AND  d.id = " + appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
        }
        query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName,c.designationName,a.behaviorsYear,a.behaviorsFinalscore,f.level,a.totalScore,"
                + "a.behaviorsEndyearTotalscore,(SELECT employeeName from EmployeeMaster Where id=b.reportingManagerLevel1),a.empActivityScore"
                + " FROM AppraisalPerformanceMaster a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN b.departmentMaster d "
                + " LEFT JOIN b.designationMaster c "
                + " LEFT JOIN b.userMaster e "
                + " LEFT JOIN b.levelMaster f "
                + " WHERE a.behaviorsYear='" + pyear + "' and a.status=1 " + condition
                + " and (b.dateOfLeaving is null or b.dateOfLeaving = '' ) "
                // + " a.behaviorsYear !="+ cyear
                //                + " WHERE a.employeeMaster=" + employeeMaster.getId() + ""
                // + " b.reportingManagerLevel1='" + employeeMaster.getId() + "'"
                + " order by a.behaviorsYear desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readIDPSearchByEmployee(T object) {
        AppraisalPerformanceMaster appraisalPerformanceMaster = (AppraisalPerformanceMaster) object;
        String query = "";
        String condition = "";

        if (null != appraisalPerformanceMaster.getEmployeeMaster().getId()) {
            condition += " AND  b.id = " + appraisalPerformanceMaster.getEmployeeMaster().getId();
        }

        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark() && !"".equals(appraisalPerformanceMaster.getBehaviorsMidyearOtherremark())) {
            condition += " AND  d.id = " + appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
        }

//        query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName,c.designationName,a.behaviorsYear,f.level,e.text1,e.text2,e.text3,e.remark,e.midYearRemark,e.endYearRemark,e.managerMidYearRemark,e.managerEndYearRemark "
//                + " FROM AppraisalPerformanceMaster a "
//                + " LEFT JOIN a.appraisalPerformanceIndividualDevelopmentPlans e "
//                + " LEFT JOIN a.employeeMaster b "
//                + " LEFT JOIN b.departmentMaster d "
//                + " LEFT JOIN b.designationMaster c "
//                + " LEFT JOIN b.levelMaster f "
//                + " WHERE status=1 " + condition
//                + " order by a.behaviorsYear desc";
        query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName,c.designationName,a.behaviorsYear,f.level "
                + " FROM AppraisalPerformanceMaster a "
                //                + " LEFT JOIN a.appraisalPerformanceIndividualDevelopmentPlans e "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN b.departmentMaster d "
                + " LEFT JOIN b.designationMaster c "
                + " LEFT JOIN b.levelMaster f "
                + " WHERE status=1 " + condition
                + " order by a.behaviorsYear desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readIDPSearchByEmployeeWise(T object) {
        AppraisalPerformanceMaster appraisalPerformanceMaster = (AppraisalPerformanceMaster) object;
        String query = "";
        String condition = "";

//        if (null != appraisalPerformanceMaster.getEmployeeMaster().getId()) {
//            condition += " AND  b.id = " + appraisalPerformanceMaster.getEmployeeMaster().getId();
//        }
//
//        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark() && !"".equals(appraisalPerformanceMaster.getBehaviorsMidyearOtherremark())) {
//            condition += " AND  d.id = " + appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
//        }
        query += " SELECT a.id, e.text1,e.text2,e.text3,e.remark,e.midYearRemark,e.endYearRemark,e.managerMidYearRemark,e.managerEndYearRemark "
                + " FROM AppraisalPerformanceMaster a "
                + " LEFT JOIN a.appraisalPerformanceIndividualDevelopmentPlans e "
                + " LEFT JOIN a.employeeMaster b "
                //                + " LEFT JOIN b.departmentMaster d "
                //                + " LEFT JOIN b.designationMaster c "
                //                + " LEFT JOIN b.levelMaster f "
                + " WHERE status=1 and e.appraisalPerformanceMaster=" + appraisalPerformanceMaster.getId()
                + " and (b.dateOfLeaving is null or b.dateOfLeaving = '' ) ";
//                + " order by a.behaviorsYear desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readcompetencySearchByEmployee(T object) {
        AppraisalPerformanceMaster appraisalPerformanceMaster = (AppraisalPerformanceMaster) object;
        String query = "";
        String condition = "";

        if (null != appraisalPerformanceMaster.getEmployeeMaster().getId()) {
            condition += " AND  b.id = " + appraisalPerformanceMaster.getEmployeeMaster().getId();
        }

        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark() && !"".equals(appraisalPerformanceMaster.getBehaviorsMidyearOtherremark())) {
            condition += " AND  d.id = " + appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark() && !"".equals(appraisalPerformanceMaster.getBehaviorsEndyearOtherremark())) {
            condition += " AND  f.id = " + appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
        }

        query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName,c.designationName,a.behaviorsYear,f.title,g.infoText,e.competencyStartYear,e.startyearRemark,e.competencyMidYear,e.midyearRemark,e.competencyEndYear,e.endyearRemark "
                + " FROM AppraisalPerformanceMaster a "
                + " LEFT JOIN a.appraisalPerformanceCompetencyEvaluations e "
                + " LEFT JOIN e.competencyEvaluationMaster f "
                + " LEFT JOIN e.competencyEvaluationTextmaster g "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN b.departmentMaster d "
                + " LEFT JOIN b.designationMaster c "
                + " WHERE status=1 " + condition
                + " and (b.dateOfLeaving is null or b.dateOfLeaving = '' ) "
                + " order by a.behaviorsYear desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readstageWiseSearchByEmployee(T object, AppraisalFillingData appraisalFillingData, int pyear) {
        AppraisalPerformanceMaster appraisalPerformanceMaster = (AppraisalPerformanceMaster) object;

        String query = "";
        String query1 = "";
        String condition = "";

//        if (null != appraisalPerformanceMaster.getEmployeeMaster().getId()) {
//            condition += " AND  b.id = " + appraisalPerformanceMaster.getEmployeeMaster().getId();
//        }
        if (null != appraisalPerformanceMaster.getEmployeeMaster().getId()) {
            condition += " AND  c.id = " + appraisalPerformanceMaster.getEmployeeMaster().getId();
        }

        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark() && !"".equals(appraisalPerformanceMaster.getBehaviorsMidyearOtherremark())) {
            condition += " AND  d.id = " + appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
        }

        query += ""
                + " select "
                + " c.employeeId,"
                + " c.employeeName,"
                + " d.departmentName,"
                + " e.designationName,"
                + " f.level,"
                //+" (select employeeId from EmployeeMaster where id=c.employeeId) as abc,"
                //+ " c.id NOT IN (select employeeId from EmployeeMaster),"
                //+ "" + appraisalFillingData.getYear() + ","
                + " (SELECT  afd.year from AppraisalFillingData afd where afd.id=a.behaviorsYear)as cycleName,"
                //                + "" + pyear + ","
                + " case when (b.kraGoal is null or b.kraGoal ='') or (b.metric is null or b.metric ='') then 'KRA Setting By Employee' "
                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=0 then 'KRA Setting By Employee' "
                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and  a.managerStatus=0 then 'KRA Approval By Manager' "
                //                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and a.managerStatus=1 and (b.empMidyearSelfassessmentGoal is null or b.empMidyearSelfassessmentGoal ='') then 'Employees Mid Year Self Assessment' "
                //                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and (b.empMidyearSelfassessmentGoal is not null and b.empMidyearSelfassessmentGoal != '') and a.managerStatus=1 and (b.managerMidyearReviewEvaluation is null or b.managerMidyearReviewEvaluation ='') then 'Managers Mid Year Review' "
                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 "
                + " and (b.empEndyearSelfassessmentGoal is null or b.empEndyearSelfassessmentGoal ='') and a.managerStatus=1 then 'Employees End Year Self Assessment' "
                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 "
                + " and (b.empEndyearSelfassessmentGoal is not null and b.empEndyearSelfassessmentGoal !='') and (b.managerEndyearReviewEvaluation is null or b.managerEndyearReviewEvaluation ='') and a.managerStatus=1 then 'Managers End Year Review' "
                + " when a.status=1 "
                + " and (b.empEndyearSelfassessmentGoal is not null and b.empEndyearSelfassessmentGoal !='') and (b.managerEndyearReviewEvaluation is not null and b.managerEndyearReviewEvaluation !='') and a.managerStatus=1 then 'All stages are Completed' "
                + " end as result "
                + " FROM "
                + " EmployeeMaster c "
                + "  LEFT JOIN "
                + "  c.appraisalPerformanceMasters a "
                + " LEFT JOIN "
                + " a.appraisalPerformanceKras b"
                + " LEFT JOIN "
                + " c.departmentMaster d "
                + " LEFT JOIN "
                + " c.designationMaster e"
                + " LEFT JOIN "
                + " c.levelMaster f"
                + " where (STR_TO_DATE(b.startDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + appraisalFillingData.getStartDate() + "','%d/%m/%Y') AND STR_TO_DATE('"
                + appraisalFillingData.getManagerYearEndEndDate() + "','%d/%m/%Y') or b.startDate is null)" + condition
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = '') "
                + " and a.behaviorsYear='" + pyear + "'"
                //+ " and c.id NOT IN (select employeeId from EmployeeMaster) "
                + " group by c.id ";

        query1 += ""
                + " select "
                + " c.employeeId,"
                + " c.employeeName,"
                + " d.departmentName,"
                + " e.designationName,"
                + " f.level,"
                //+" (select employeeId from EmployeeMaster where id=c.employeeId) as abc,"
                //+ " c.id NOT IN (select employeeId from EmployeeMaster),"
                + "(SELECT  afd.year from AppraisalFillingData afd where afd.id=a.behaviorsYear)as cycleName ,"
//                + "" + pyear + ","
                + " case when (b.kraGoal is null or b.kraGoal ='') or (b.metric is null or b.metric ='') then 'KRA Setting By Employee' "
                + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=0 then 'KRA Setting By Employee' "
                //+ " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and  a.managerStatus=0 then 'KRA Approval By Manager' "
                // + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and a.managerStatus=1 and (b.empMidyearSelfassessmentGoal is null or b.empMidyearSelfassessmentGoal ='') then 'Employees Mid Year Self Assessment' "
                // + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and (b.empMidyearSelfassessmentGoal is not null and b.empMidyearSelfassessmentGoal != '') and a.managerStatus=1 and (b.managerMidyearReviewEvaluation is null or b.managerMidyearReviewEvaluation ='') then 'Managers Mid Year Review' "
                // + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and (b.empMidyearSelfassessmentGoal is not null and b.empMidyearSelfassessmentGoal !='') and (b.managerMidyearReviewEvaluation is not null and b.managerMidyearReviewEvaluation !='') "
                // + " and (b.empEndyearSelfassessmentGoal is null or b.empEndyearSelfassessmentGoal ='') and a.managerStatus=1 then 'Employees End Year Self Assessment' "
                // + " when (b.kraGoal is not null and b.kraGoal !='') and (b.metric is not null and b.metric !='') and a.status=1 and b.empMidyearSelfassessmentGoal is not null and b.managerMidyearReviewEvaluation is not null "
                //+ " and (b.empEndyearSelfassessmentGoal is not null and b.empEndyearSelfassessmentGoal !='') and (b.managerEndyearReviewEvaluation is null or b.managerEndyearReviewEvaluation ='') and a.managerStatus=1 then 'Managers End Year Review' "
                // + " when a.status=1 and (b.empMidyearSelfassessmentGoal is not null and b.empMidyearSelfassessmentGoal !='') and (b.managerMidyearReviewEvaluation is not null and b.managerMidyearReviewEvaluation !='') "
                // + " and (b.empEndyearSelfassessmentGoal is not null and b.empEndyearSelfassessmentGoal !='') and (b.managerEndyearReviewEvaluation is not null and b.managerEndyearReviewEvaluation !='') and a.managerStatus=1 then 'All stages are Completed' "
                + " end as result "
                + " FROM "
                + " EmployeeMaster c "
                + "  LEFT JOIN "
                + "  c.appraisalPerformanceMasters a "
                + " LEFT JOIN "
                + " a.appraisalPerformanceKras b"
                + " LEFT JOIN "
                + " c.departmentMaster d "
                + " LEFT JOIN "
                + " c.designationMaster e"
                + " LEFT JOIN "
                + " c.levelMaster f"
                + " where  c.id NOT IN (select employeeMaster FROM AppraisalPerformanceMaster  WHERE behaviorsYear = '" + pyear + "' ) "
                //+ "and (STR_TO_DATE(b.startDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + appraisalFillingData.getStartDate() + "','%d/%m/%Y') AND STR_TO_DATE('"
                //+ appraisalFillingData.getManagerYearEndEndDate() + "','%d/%m/%Y') or b.startDate is null)" + condition
                + " and (c.dateOfLeaving is null or c.dateOfLeaving = '')" + condition
                //+ " and a.behaviorsYear=2017"
                //+ " "
                + " group by c.id ";

        //List finalAppraisalPerformanceList1 = new LinkedList<List<?>>();
        List<?> list = getHibernateTemplate().find(query);

        List<?> list1 = getHibernateTemplate().find(query1);
        //List<?> nonUnique = list.add(list1);
        List<?> newList = ListUtils.union(list, list1);
        //finalAppraisalPerformanceList1.add(list);
        //finalAppraisalPerformanceList1.add(list1);

        return newList;

    }

    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMaster"
                + " FROM AppraisalPerformanceMaster a "
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPendingEmployeePmp(int employeeId, int year) {

        String query = "";

        query += "  "
                + "FROM AppraisalPerformanceMaster a "
                + " WHERE a.behaviorsYear =" + year
                + " and a.employeeMaster = " + employeeId
                + "and a.employeeStatus=1 and a.managerStatus != 1";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPendingEmployeePmpByManager(String employeeId, int year) {

        String query = "";

        query += "  "
                + "FROM AppraisalPerformanceMaster a "
                + " left join a.employeeMaster b "
                + " WHERE a.behaviorsYear =" + year
                + " and b.reportingManagerLevel1 = " + employeeId
                + " and a.employeeStatus=1 and a.managerStatus != 1";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpIdByAppraisalPerformanceId() {

        String query = "";

        query += "  SELECT b.employeeMaster.id,a.competencyEvaluationMaster.id"
                + " FROM AppraisalPerformanceCompetencyEvaluation a "
                + " left join a.appraisalPerformanceMaster b "
                + " GROUP BY b.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmpID(int id) {
        String query = "";

        query += "  "
                + "FROM AppraisalPerformanceMaster a "
                + " WHERE a.employeeMaster = " + id;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByAppraisalPerformanceIdNew(String employeeId, String yearId) {

        String query = "";
        int id = Integer.parseInt(yearId);
        query += "  "
                + "FROM AppraisalPerformanceMaster a "
                + " WHERE a.behaviorsYear =" + id
                //                + " WHERE (a.behaviorsYear =" + year + " or a.behaviorsYear =" + cyear + ")"
                // + " or a.behaviorsYear =" + year + 1
                + " and a.employeeMaster = " + employeeId;
//                + "FROM AppraisalPerformanceMaster a "
//                + " WHERE a.employeeMaster = " + employeeId;

        return getHibernateTemplate().find(query);

    }

}
//                *******************************************Main Queary**************************************************
//                + " (select concat(start_date,'-',end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "') as FirstTimeLine_Employee, "
//                + "    (select concat(mid_year_start_date,'-',mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "') as MidyearTimeLineEmployee, "
//                + " (select concat(year_end_start_date,'-',year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "') as EndyearTimeLineEmployee, "
//                + " (select concat(manager_start_date,'-',manager_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "') as FirstTimeLineManager, "
//                + " (select concat(manager_mid_year_start_date,'-',manager_mid_year_start_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "') as MidTimeLineManager, "
//                + "(select concat(manager_year_end_start_date,'-',manager_year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "') as EndyearTimeLineManager,"
//                + "    Case "
//                + " when (select concat(start_date,'-',end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(start_date, '%d/%m/%Y') "
//                + " AND str_to_date(end_date, '%d/%m/%Y') "
//                + " AND b.kra_goal is null) then  'Pending' "
//                + " when (select concat(start_date,'-',end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(start_date, '%d/%m/%Y') "
//                + " AND str_to_date(end_date, '%d/%m/%Y') "
//                + " AND b.kra_goal is not null) then  'approve' "
//                + " when (select concat(start_date,'-',end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(start_date, '%d/%m/%Y') "
//                + " AND b.kra_goal is not null) then 'approve' "
//                + " when (select concat(start_date,'-',end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(end_date, '%d/%m/%Y') "
//                + " AND b.kra_goal is null) then  'Expired' "
//                + " ELSE 'Time Is Not Arrived' "
//                + "    END as GoalSettingByEmployee, "
//                + " Case "
//                + " when (select concat(manager_start_date,'-',manager_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(manager_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(manager_end_date, '%d/%m/%Y') "
//                + " AND b.weightage is null) then  'Pending' "
//                + " when (select concat(manager_start_date,'-',manager_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(manager_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(manager_end_date, '%d/%m/%Y') "
//                + " AND b.weightage is not null) then  'approve' "
//                + " when (select concat(manager_start_date,'-',manager_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(manager_start_date, '%d/%m/%Y') "
//                + " AND b.weightage is not null limit 1) then 'approve' "
//                + " when (select concat(start_date,'-',end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(manager_end_date, '%d/%m/%Y') "
//                + " AND b.weightage is null limit 1) then  'Expired' "
//                + " ELSE 'Time Is Not Arrived' "
//                + "    END as GoalApprovalByManager, "
//                + " Case "
//                + " when (select concat(mid_year_start_date,'-',mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(mid_year_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(mid_year_end_date, '%d/%m/%Y') "
//                + " AND b.emp_midyear_selfassessment_goal is null limit 1) then  'Pending' "
//                + " when (select concat(mid_year_start_date,'-',mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(mid_year_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(mid_year_end_date, '%d/%m/%Y') "
//                + " AND b.emp_midyear_selfassessment_goal is not null limit 1) then  'approve' "
//                + " when (select concat(mid_year_start_date,'-',mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(mid_year_start_date, '%d/%m/%Y') "
//                + " AND b.emp_midyear_selfassessment_goal is not null limit 1) then 'approve' "
//                + " when (select concat(mid_year_start_date,'-',mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(mid_year_end_date, '%d/%m/%Y') "
//                + " AND b.emp_midyear_selfassessment_goal is null limit 1) then  'Expired' "
//                + " ELSE 'Time Is Not Arrived' "
//                + "    END as EmployeesMidYearSelfAssessment, "
//                + " Case "
//                + " when (select concat(manager_mid_year_start_date,'-',manager_mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(manager_mid_year_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(manager_mid_year_end_date, '%d/%m/%Y') "
//                + " AND b.manager_midyear_review_evaluation is null limit 1) then  'Pending' "
//                + " when (select concat(manager_mid_year_start_date,'-',manager_mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(manager_mid_year_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(manager_mid_year_end_date, '%d/%m/%Y') "
//                + " AND b.manager_midyear_review_evaluation is not null limit 1) then  'approve' "
//                + " when (select concat(manager_mid_year_start_date,'-',manager_mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(manager_mid_year_start_date, '%d/%m/%Y') "
//                + " AND b.manager_midyear_review_evaluation is not null limit 1) then 'approve' "
//                + " when (select concat(manager_mid_year_start_date,'-',manager_mid_year_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(manager_mid_year_end_date, '%d/%m/%Y') "
//                + " AND b.manager_midyear_review_evaluation is null limit 1) then  'Expired' "
//                + " ELSE 'Time Is Not Arrived' "
//                + "    END as ManagersMidYearReview, "
//                + " Case "
//                + " when (select concat(year_end_start_date,'-',year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(year_end_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(year_end_end_date, '%d/%m/%Y') "
//                + " AND b.emp_endyear_selfassessment_goal is null limit 1) then  'Pending' "
//                + " when (select concat(year_end_start_date,'-',year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(year_end_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(year_end_end_date, '%d/%m/%Y') "
//                + " AND b.emp_endyear_selfassessment_goal is not null limit 1) then  'approve' "
//                + " when (select concat(year_end_start_date,'-',year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(year_end_start_date, '%d/%m/%Y') "
//                + " AND b.emp_endyear_selfassessment_goal is not null limit 1) then 'approve' "
//                + " when (select concat(year_end_start_date,'-',year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(year_end_end_date, '%d/%m/%Y') "
//                + " AND b.emp_endyear_selfassessment_goal is null limit 1) then  'Expired' "
//                + " ELSE 'Time Is Not Arrived' "
//                + "  END as EmployeesEndYearSelfAssessment, "
//                + " Case "
//                + " when (select concat(manager_year_end_start_date,'-',manager_year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(manager_year_end_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(manager_year_end_end_date, '%d/%m/%Y') "
//                + " AND b.manager_endyear_review_evaluation is null limit 1) then  'Pending' "
//                + " when (select concat(manager_year_end_start_date,'-',manager_year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND  current_date BETWEEN str_to_date(manager_year_end_start_date, '%d/%m/%Y') "
//                + " AND str_to_date(manager_year_end_end_date, '%d/%m/%Y') "
//                + " AND b.manager_endyear_review_evaluation is not null limit 1) then  'approve' "
//                + " when (select concat(manager_year_end_start_date,'-',manager_year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(manager_year_end_start_date, '%d/%m/%Y') "
//                + " AND b.manager_endyear_review_evaluation is not null limit 1) then 'approve' "
//                + " when (select concat(manager_year_end_start_date,'-',manager_year_end_end_date) "
//                + "   from appraisal_filling_data "
//                + "   WHERE year='" + cyear + "' AND current_date >= str_to_date(manager_year_end_end_date, '%d/%m/%Y') "
//                + " AND b.manager_endyear_review_evaluation is null limit 1) then  'Expired' "
//                + " ELSE 'Time Is Not Arrived' "
//                + "  END as ManagerEndYearReview "
//                + " from appraisal_performance_master a "
//                + "left join appraisal_performance_kra b ON a.id = b.appraisal_performance_id"
//                + " left join employee_master c ON c.id = a.employee_id"
//                + " left join department_master d on d.id = c.department_id"
//                + " left join designation_master e on e.id = c.designation_id"
//                + " left join level_master f on f.id = c.level_master_id where 1=1 "
//                + condition;

//   + " Select c.employee_id "
