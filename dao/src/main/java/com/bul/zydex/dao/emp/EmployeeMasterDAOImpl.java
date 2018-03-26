/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeMaster;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class EmployeeMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
        EmployeeMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeMaster.class;
    }

    @Override
    public List<?> readByUserName(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " FROM EmployeeMaster a"
                + " WHERE a.userMaster.id = " + employeeMaster.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeeUserId(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " FROM EmployeeMaster a"
                + " WHERE a.userMaster.id = " + employeeMaster.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeDetailUserIdWise(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " Select a.employeeId, a.employeeName, b.designationName, d.level, c.departmentName, lm.location ,a.reportingManagerLevel1, a.company, a.contactNo2,zl.zydexLocation "
                + "FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b"
                + " LEFT JOIN a.departmentMaster c"
                + " LEFT JOIN a.levelMaster d"
                + " LEFT JOIN a.locationMaster lm"
                + " LEFT JOIN a.zydexLocationMaster zl"
                + " WHERE a.userMaster.id = " + employeeMaster.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForAliveEmployeesNew() {
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " where (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readEmployeesDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " where (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";
//                + " or STR_TO_DATE(,'%d/%m/%Y - %h:%i') > now()";
//                + " or a.dateOfLeaving > DATE_FORMAT(now(),'%d/%m/%Y - %h:%i')";
//        STR_TO_DATE(,'%d/%m/%Y - %h:%i') < now()
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeLevelId(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        List<?> list = new ArrayList();
        if (null != employeeMaster.getReportingManagerLevel1()) {
            String query = "";
            query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                    + " FROM EmployeeMaster a"
                    + " LEFT JOIN a.designationMaster b "
                    + " LEFT JOIN a.departmentMaster c "
                    + " LEFT JOIN a.userMaster d "
                    + " WHERE a.reportingManagerLevel1= '" + employeeMaster.getReportingManagerLevel1() + "'"
                    + " and ((a.dateOfLeaving is null or a.dateOfLeaving = '') "
                    + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

            list = getHibernateTemplate().find(query);
        }
        return list;
    }

    @Override
    public List<?> readByEmployeeLevel1Id(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        List<?> list = new ArrayList();
        if (null != employeeMaster.getReportingManagerLevel1() && !"".equals(employeeMaster.getReportingManagerLevel1())) {
            String query = "";
            query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                    + " FROM EmployeeMaster a"
                    + " LEFT JOIN a.designationMaster b "
                    + " LEFT JOIN a.departmentMaster c "
                    + " LEFT JOIN a.userMaster d "
                    + " WHERE a.reportingManagerLevel1= " + employeeMaster.getReportingManagerLevel1() + "";

            list = getHibernateTemplate().find(query);
        }
        return list;
    }

    @Override
    public List<?> readByEmployeeLevel2Id(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " WHERE a.reportingManagerLevel1.id = " + employeeMaster.getReportingManagerLevel2();
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeLevel3Id(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " WHERE a.reportingManagerLevel1.id = " + employeeMaster.getReportingManagerLevel3();
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeLevel4Id(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " WHERE a.reportingManagerLevel1.id = " + employeeMaster.getReportingManagerLevel4();
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeLevel5Id(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " WHERE a.reportingManagerLevel1.id = " + employeeMaster.getReportingManagerLevel5();
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeLevel6Id(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " WHERE a.reportingManagerLevel1.id = " + employeeMaster.getReportingManagerLevel6();
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeSearch() {
        String query = "";
        query += " "
                + " SELECT a.id,a.employeeId,a.employeeName, b.departmentName"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.departmentMaster b ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeAjax(int id) {
        String query = "";
        query += " "
                + "SELECT a.id,a.employeeName,b.departmentName,c.designationName,d.level,"
                + "a.reportingManagerLevel1 as repotingManger,lm.location,a.employeeId "
                + "FROM EmployeeMaster a  "
                + "left join a.departmentMaster b  "
                + "left join a.designationMaster c  "
                + "LEFT JOIN a.locationMaster lm "
                + "left join a.levelMaster d  WHERE a.id='" + id + "' ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByReportManager(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += ""
                + "FROM EmployeeMaster a"
                + " WHERE a.id =" + employeeMaster.getId();
        //+ " a.userMaster.id = " + employeeMaster.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readManagerLevel1(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " Select a.employeeName"
                + " FROM EmployeeMaster a"
                + " WHERE a.id =" + employeeMaster.getReportingManagerLevel1();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForAprove(int id) {
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " WHERE a.reportingManagerLevel1= " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeDetail(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " "
                + "Select em.employeeId,em.employeeName,dgm.designationName,lm.level,dm.departmentName,lom.location,"
                + "(Select a.employeeName From EmployeeMaster a where cast(a.id as string) = em.reportingManagerLevel1) As reportingManager,em.id"
                + " From EmployeeMaster em"
                + " Left Join em.designationMaster dgm"
                + " Left Join em.levelMaster lm"
                + " Left Join em.departmentMaster dm"
                + " Left Join em.userMaster um"
                + " LEFT JOIN em.locationMaster lom"
                + " where um.id = " + employeeMaster.getUserMaster().getId();

        List employeeDetail = getHibernateTemplate().find(query);
        return employeeDetail;
    }

    @Override
    public List<?> readForEmployeeType(int id) {
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " WHERE a.employeeType like '%Probation%'"
                + " and ((a.dateOfLeaving is null or a.dateOfLeaving = '')"
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()) "
                + " AND (a.reportingManagerLevel1= " + id
                + " Or a.reportingManagerLevel2= " + id
                + " Or a.reportingManagerLevel3= " + id
                + " Or a.reportingManagerLevel4= " + id + ")";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForProbation(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += ""
                + " FROM EmployeeMaster a "
                + " WHERE a.id = " + employeeMaster.getId()
                + " and a.employeeType like '%Probation%'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForProbationForManager(String reportingManagerId, String employeeId) {
        String query = "";
        query += ""
                + " FROM EmployeeMaster a "
                + " left join a.probationToConfirmationsForEmployeeMasterId b"
                + " WHERE a.id = " + employeeId
                + " and a.employeeType like '%Probation%'"
                + " and a.reportingManagerLevel1 =" + reportingManagerId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForProbationlevel2(String reportingManagerId, String employeeId) {
        String query = "";
        query += ""
                + " FROM EmployeeMaster a "
                + " WHERE a.id = " + employeeId
                + " and a.employeeType like '%Probation%'"
                + " and a.reportingManagerLevel2 =" + reportingManagerId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForProbationlevel3(String reportingManagerId, String employeeId) {
        String query = "";
        query += ""
                + " FROM EmployeeMaster a "
                + " WHERE a.id = " + employeeId
                + " and a.employeeType like '%Probation%'"
                + " and a.reportingManagerLevel3 =" + reportingManagerId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForProbationlevel4(String reportingManagerId, String employeeId) {
        String query = "";
        query += ""
                + " FROM EmployeeMaster a "
                + " WHERE a.id = " + employeeId
                + " and a.employeeType like '%Probation%'"
                + " and a.reportingManagerLevel4 =" + reportingManagerId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readfunctionalhead(int id) {
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " WHERE a.reportingManagerLevel5= " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readAttendanceData(final String today) {
        String hqryString = "select"
                + " (select count(esd.employeeMaster.id) from EmployeeShiftData esd"
                + " where STR_TO_DATE(concat(str(DAY(STR_TO_DATE(in_date_time, '%d/%m/%Y %H:%i:%s'))),str('/'),str(MONTH(STR_TO_DATE(in_date_time, '%d/%m/%Y %H:%i:%s'))),str('/'),str(YEAR (STR_TO_DATE(esd.inDateTime, '%d/%m/%Y %H:%i:%s')))), '%d/%m/%Y') = STR_TO_DATE('" + today + "', '%d/%m/%Y')) as present,"
                + " (select count(led.employeeMaster.id) from LeaveEmployeeDetail led"
                + " where (STR_TO_DATE('" + today + "', '%d/%m/%Y') BETWEEN STR_TO_DATE(led.startDate, '%d/%m/%Y') AND STR_TO_DATE(led.endDate, '%d/%m/%Y')) And led.status = 5) as approvedLeave,"
                + " count(em.id) as total"
                + " from EmployeeMaster em"
                + " where (em.dateOfLeaving is null or em.dateOfLeaving = '') "
                + " or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";

        return getHibernateTemplate().find(hqryString);
    }

    @Override
    public List<?> readReportingHierarchyList(final int reportingManagerId) {
        String hqlString = "select em.reportingManagerLevel1,"
                + " em.reportingManagerLevel2,"
                + " em.reportingManagerLevel3,"
                + " em.reportingManagerLevel4,"
                + " em.reportingManagerLevel5,"
                + " em.reportingManagerLevel6,"
                + " (select e.employeeName from EmployeeMaster e where e.id=em.reportingManagerLevel1),"
                + " (select e.employeeName from EmployeeMaster e where e.id=em.reportingManagerLevel2),"
                + " (select e.employeeName from EmployeeMaster e where e.id=em.reportingManagerLevel3),"
                + " (select e.employeeName from EmployeeMaster e where e.id=em.reportingManagerLevel4),"
                + " (select e.employeeName from EmployeeMaster e where e.id=em.reportingManagerLevel5),"
                + " (select e.employeeName from EmployeeMaster e where e.id=em.reportingManagerLevel6),"
                + " em.employeeName"
                + " from EmployeeMaster em where em.id="
                + reportingManagerId;

        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readEmployeeForParticularManager(int id) {
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " WHERE (a.reportingManagerLevel1= " + id
                + " Or a.reportingManagerLevel2= " + id
                + " Or a.reportingManagerLevel3= " + id
                + " Or a.reportingManagerLevel4= " + id + ")";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> searchEmployeeDetail(final String searchString) {
        String hqlString = " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " where"
                + " (a.employeeName like '%" + searchString + "%'"
                + " OR"
                + " b.designationName like '%" + searchString + "%'"
                + " OR"
                + " c.departmentName like '%" + searchString + "%'"
                + " OR"
                + " d.userName like '%" + searchString + "%'"
                + ")"
                + " and (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                //                + " STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y') <= CURDATE()";
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";

        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readByName(String empName) {
        String query = "";
        query += "From EmployeeMaster a "
                + " Where a.employeeName = '" + empName + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByReportingManager(final String oldReportingManagerId) {
        String hqlString = "from EmployeeMaster em"
                + " where '" + oldReportingManagerId + "' IN"
                + " (em.reportingManagerLevel1, em.reportingManagerLevel2, em.reportingManagerLevel3,"
                + " em.reportingManagerLevel4, em.reportingManagerLevel5, em.reportingManagerLevel6)";
        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readByEmployeeNo(int employeeNo) {
        String query = "";
        query += "From EmployeeMaster a "
                + " Where a.employeeId = '" + employeeNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> getLastYearPerformanceRatingOfEmployee(final int EmployeePrimaryId) {
        String hqlString = "select CASE WHEN apm.behaviorsFinalscore = NULL then '' else apm.behaviorsFinalscore End from EmployeeMaster em"
                + " left join em.appraisalPerformanceMasters apm"
                + " where apm.behaviorsYear = YEAR(CURRENT_DATE())-1 AND em.id=" + EmployeePrimaryId;
        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readEmployeeDataForexportToExcel(final String searchEmployeeString) {
        String hqlString = " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName,"
                + " lm.level, a.company, zlm.zydexLocation, locm.location,"
                + " (select CASE WHEN apm.behaviorsFinalscore = NULL then '' else apm.behaviorsFinalscore End from EmployeeMaster em"
                + " left join em.appraisalPerformanceMasters apm"
                + " where apm.behaviorsYear = YEAR(CURRENT_DATE())-1 AND em.id= "
                + " a.id),"
                + " a.emailAddress, a.contactNo1,"
                + " CASE WHEN a.gender = 1 then 'Female' else 'Male' End,"
                + " a.maritalStatus, a.presentAddress, a.permanentAddress, d.id"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " LEFT JOIN a.levelMaster lm "
                + " LEFT JOIN a.zydexLocationMaster zlm "
                + " LEFT JOIN a.locationMaster locm "
                + " where"
                + " (a.employeeName like '%" + searchEmployeeString + "%'"
                + " OR"
                + " b.designationName like '%" + searchEmployeeString + "%'"
                + " OR"
                + " c.departmentName like '%" + searchEmployeeString + "%'"
                + " OR"
                + " d.userName like '%" + searchEmployeeString + "%'"
                + ")"
                + " and (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";

        return getHibernateTemplate().find(hqlString);
    }

    public List<?> isEmailExist(String email) {
        String query = "";
        query = "FROM EmployeeMaster a "
                + " Where a.emailAddress = '" + email + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readAllEmail() {
        String query = "";
        query = "SELECT a.emailAddress FROM EmployeeMaster a ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> updatePwdAfterSubmit(int id, String Email) {
        String query = "";
        query = "UPDATE UserMaster u set u.password='" + Email + "' where u.id='" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> updatePwdBeforeSubmit(int id) {
        String query = "";
        query = "UPDATE UserMaster u set u.password = ''  where u.id='" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForCommonList() {
        String query = "";
        query += "Select a.id,a.employeeId,a.employeeName,a.dateOfJoining,c.departmentName,d.designationName,b.id,b.assessmentToDate"
                + " from EmployeeMaster a "
                + " left join a.probationToConfirmationsForEmployeeMasterId b "
                + " left join a.departmentMaster c "
                + " left join a.designationMaster d "
                + " WHERE a.employeeType like '%Probation%'"
                + " or b.status !=8";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeId(final String employeeId) {
        String query = "";
        query += "From EmployeeMaster a "
                + " Where a.employeeId = '" + employeeId + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> empOrDateWiseSearch(EmployeeAdvanceSearch employeeAdvanceSearch) {
        String query = "";
        String condition = "";

        if (null != employeeAdvanceSearch.getId() && !employeeAdvanceSearch.getId().equals("")) {
            condition += " a.id = " + employeeAdvanceSearch.getId();
        } else {
            // single condition
            if (null != employeeAdvanceSearch.getDepartmentId() && !employeeAdvanceSearch.getDepartmentId().equals("")) {
                condition += "  a.departmentMaster.id = " + employeeAdvanceSearch.getDepartmentId();
            } else {
                condition += " 1= 1";
            }
            // two condition
            if (null != employeeAdvanceSearch.getZydexLocationId() && !employeeAdvanceSearch.getZydexLocationId().equals("")) {
                condition += " and a.zydexLocationMaster.id = " + employeeAdvanceSearch.getZydexLocationId();
            } else {
                condition += " and 1 = 1";
            }
            // three condition
            if (null != employeeAdvanceSearch.getLevelID() && !employeeAdvanceSearch.getLevelID().equals("")) {
                condition += " and a.levelMaster.id = " + employeeAdvanceSearch.getLevelID();
            } else {
                condition += " and 1 = 1";
            }
        }
        if (null != employeeAdvanceSearch.getDojStartDate() && !employeeAdvanceSearch.getDojStartDate().equals("")
                && null != employeeAdvanceSearch.getDojEndDate() && !employeeAdvanceSearch.getDojEndDate().equals("")) {
            condition += " and STR_TO_DATE(a.dateOfJoining,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + employeeAdvanceSearch.getDojStartDate() + "','%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + employeeAdvanceSearch.getDojEndDate() + "','%d/%m/%Y')";
        } else {
            condition += " and 1 = 1";
        }

        ///// Create Employee Advance search Query
        query += " Select ";
        if (employeeAdvanceSearch.getEmployeeId()) {
            query += " a.employeeId ,";
        } else {
            query += " '' as nonval ,";

        }
        if (employeeAdvanceSearch.getEmployeeName()) {
            query += " a.employeeName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getFatherName()) {
            query += " a.fatherName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getMotherName()) {
            query += " a.motherName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getGender()) {
            query += " case when a.gender = 0 then 'Male' else 'Female' end as gender,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getMaritalStatus()) {
            query += " a.maritalStatus,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getSpouseName()) {
            query += " a.spouseName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirth()) {
            query += " a.dateOfBirth,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPresentAddress()) {
            query += " a.presentAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPermanentAddress()) {
            query += " a.permanentAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBloodGroups()) {
            query += " a.bloodGroups,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmailAddress()) {
            query += " a.emailAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getContactNo1()) {
            query += " a.contactNo1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getContactNo2()) {
            query += " a.contactNo2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmergencyContactPerson()) {
            query += " a.emergencyContactPerson,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmergencyContactNo()) {
            query += " a.emergencyContactNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPanCard()) {
            query += " a.panCard,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportNo()) {
            query += " a.passportNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportIssueDate()) {
            query += " a.passportIssueDate,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportExpiryDate()) {
            query += " a.passportExpiryDate,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getAdharCard()) {
            query += " a.adharCard,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getOfficeEmailId()) {
            query += " a.officeEmailId,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getHighestEducationDetails()) {
            query += " a.highestEducationDetails,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getExperienceYearOnDoj()) {
            query += " a.experienceYearOnDoj,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getExperienceMonthOnDoj()) {
            query += " a.experienceMonthOnDoj,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getCompany()) {
            query += " a.company,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getZydexLocation()) {
            query += " e.zydexLocation,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getWorkLocation()) {
            query += " f.location,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getLevel()) {
            query += " d.level,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getDepartment()) {
            query += " b.departmentName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDesignation()) {
            query += " c.designationName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getRole()) {
            query += " a.role,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfJoining()) {
            query += " a.dateOfJoining,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmployeeType()) {
            query += " a.employeeType,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankName()) {
            query += " a.bankName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankAccountNo()) {
            query += " a.bankAccountNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankIfscCode()) {
            query += " a.bankIfscCode,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getReportingManager()) {
            query += " (Select g.employeeName From  EmployeeMaster g where g.id=a.reportingManagerLevel1) as reportingManagerLevel ,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getCityOfEmployee()) {
            query += " a.cityOfEmployee,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getChild1()) {
            query += " a.child1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getChild2()) {
            query += " a.child2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpFather()) {
            query += " a.dateOfBirthOfEmpFather,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpMother()) {
            query += " a.dateOfBirthOfEmpMother,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous()) {
            query += " a.dateOfBirthOfEmpSpous,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1()) {
            query += " a.dateOfBirthOfEmpChilld1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2()) {
            query += " a.dateOfBirthOfEmpChild2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfTransferOfEntity()) {
            query += " a.dateOfTransferOfEntity,";
        } else {
            query += " '' as nonval ,";
        }

        query += " '' as nonval1,a.id From  EmployeeMaster  a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + " LEFT JOIN a.levelMaster d "
                + " LEFT JOIN a.zydexLocationMaster e "
                + " LEFT JOIN a.locationMaster f ";
        if (condition != "") {
//            query += " Where 1=1 AND " + condition;
            query += " Where  " + condition;
        }
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> empAttendanceDataSearch(EmployeeAdvanceSearch employeeAdvanceSearch) {
        String query = "";
        String condition = "";

        if (null != employeeAdvanceSearch.getId() && !employeeAdvanceSearch.getId().equals("")) {
            condition += " a.id = " + employeeAdvanceSearch.getId();
        } else {
            // single condition
            if (null != employeeAdvanceSearch.getDepartmentId() && !employeeAdvanceSearch.getDepartmentId().equals("")) {
                condition += "  a.departmentMaster.id = " + employeeAdvanceSearch.getDepartmentId();
            } else {
                condition += " 1= 1";
            }
            // two condition
            if (null != employeeAdvanceSearch.getZydexLocationId() && !employeeAdvanceSearch.getZydexLocationId().equals("")) {
                condition += " and a.zydexLocationMaster.id = " + employeeAdvanceSearch.getZydexLocationId();
            } else {
                condition += " and 1 = 1";
            }
            // three condition
            if (null != employeeAdvanceSearch.getLevelID() && !employeeAdvanceSearch.getLevelID().equals("")) {
                condition += " and a.levelMaster.id = " + employeeAdvanceSearch.getLevelID();
            } else {
                condition += " and 1 = 1";
            }
        }
        ///// Create Employee Advance search Query
        query += " Select  a.employeeId , a.employeeName, b.departmentName, a.dateOfJoining,a.id From  EmployeeMaster  a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + " LEFT JOIN a.levelMaster d "
                + " LEFT JOIN a.zydexLocationMaster e "
                + " LEFT JOIN a.locationMaster f ";
        if (condition != "") {
//            query += " Where 1=1 AND " + condition;
            query += " Where  " + condition;
        }
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> pswdExist(String password, String id) {
        String query = "";
        query = "Select password from UserMaster u where u.password='" + password + "' and u.id='" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readDateOfLeaving(int id) {
        String query = "";
        query += " Select a.dateOfLeaving"
                + " FROM EmployeeMaster a "
                + " where a.userMaster =" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeesDetail1() {
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " where (a.dateOfLeaving is not null and a.dateOfLeaving != '') "
                + " and  STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') < now()";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readFormerEmployeeDataForexportToExcel() {
        String hqlString = " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName,"
                + " lm.level, a.company, zlm.zydexLocation, locm.location,"
                + " a.emailAddress, a.contactNo1,"
                + " CASE WHEN a.gender = 1 then 'Female' else 'Male' End,"
                + " a.maritalStatus, a.presentAddress, a.permanentAddress, d.id"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " LEFT JOIN a.levelMaster lm "
                + " LEFT JOIN a.zydexLocationMaster zlm "
                + " LEFT JOIN a.locationMaster locm "
                + " where (a.dateOfLeaving is not null and a.dateOfLeaving != '') "
                + " and STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') < now()";

        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readByEmployeeReportingManagerId(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        List<?> list = new ArrayList();
        if (null != employeeMaster.getReportingManagerLevel1() && !"".equals(employeeMaster.getReportingManagerLevel1())) {
            String query = "";
            query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                    + " FROM EmployeeMaster a"
                    + " LEFT JOIN a.designationMaster b "
                    + " LEFT JOIN a.departmentMaster c "
                    + " LEFT JOIN a.userMaster d "
                    + " WHERE a.id= " + employeeMaster.getReportingManagerLevel1() + "";

            list = getHibernateTemplate().find(query);
        }
        return list;
    }

    @Override
    public List<?> getEmployeeDetatilByEmp_Id(final int id) {
        String query = "";

        query += " Select a.id,a.employeeId, a.employeeName, c.departmentName, b.designationName, d.level,  lm.location, a.reportingManagerLevel1,"
                + " case When (ndm.equipments IS NULL OR ndm.equipments = '' )  THEN  'false' ELSE 'true' END AS isReportingManagerFilled,"
                + " case When (ndm.carProvided IS NULL OR ndm.carProvided = '' )  THEN  'false' ELSE 'true' END AS isNoDueAdminFilled,"
                + " case When (ndm.computerChecked IS NULL OR ndm.computerChecked = '' )  THEN  'false' ELSE 'true' END AS isTravelAdminFilled,"
                + " case When (ndm.salaryAdvanceOrLoan IS NULL OR ndm.salaryAdvanceOrLoan = '')  THEN  'false' ELSE 'true' END AS istravelExpenseAdminFilled,"
                + " res.relievingDate,res.effectiveDatetime,res.attrition"
                //                + " case When (ndm.equipments IS NULL OR ndm.equipments = '')  THEN  'pendingAtReportingManager' ELSE 'Completed' END AS isReportingManagerFilled,"
                //                + " case When (ndm.carProvided IS NULL OR ndm.carProvided = '')  THEN  'pendingAtNoDueAdmin' ELSE 'Completed' END AS isNoDueAdminFilled,"
                //                + " case When (ndm.computerChecked IS NULL OR ndm.computerChecked = '')  THEN  'pendingAtTravelAdmin' ELSE 'Completed' END AS isTravelAdminFilled,"
                //                + " case When (ndm.salaryAdvanceOrLoan IS NULL OR ndm.salaryAdvanceOrLoan = '')  THEN  'pendingAtTravelExpenseAdmin' ELSE 'Completed' END AS istravelExpenseAdminFilled"
                + " FROM EmployeeMaster a"
                + " LEFT JOIN a.designationMaster b"
                + " LEFT JOIN a.departmentMaster c"
                + " LEFT JOIN a.levelMaster d"
                + " LEFT JOIN a.locationMaster lm"
                + " LEFT JOIN a.noDueMastersForEmpId ndm"
                + " LEFT JOIN a.resignationMasters res"
                + " WHERE a.id = " + id;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> empOrDateWiseSearchforActive(EmployeeAdvanceSearch employeeAdvanceSearch) {
        String query = "";
        String condition = "";

        if (null != employeeAdvanceSearch.getId() && !employeeAdvanceSearch.getId().equals("")) {
            condition += " a.id = " + employeeAdvanceSearch.getId();
        } else {
            // single condition
            if (null != employeeAdvanceSearch.getDepartmentId() && !employeeAdvanceSearch.getDepartmentId().equals("")) {
                condition += "  a.departmentMaster.id = " + employeeAdvanceSearch.getDepartmentId();
            } else {
                condition += " 1= 1";
            }
            // two condition
            if (null != employeeAdvanceSearch.getZydexLocationId() && !employeeAdvanceSearch.getZydexLocationId().equals("")) {
                condition += " and a.zydexLocationMaster.id = " + employeeAdvanceSearch.getZydexLocationId();
            } else {
                condition += " and 1 = 1";
            }
            // three condition
            if (null != employeeAdvanceSearch.getLevelID() && !employeeAdvanceSearch.getLevelID().equals("")) {
                condition += " and a.levelMaster.id = " + employeeAdvanceSearch.getLevelID();
            } else {
                condition += " and 1 = 1";
            }
        }

        if (null != employeeAdvanceSearch.getDojStartDate() && !employeeAdvanceSearch.getDojStartDate().equals("")
                && null != employeeAdvanceSearch.getDojEndDate() && !employeeAdvanceSearch.getDojEndDate().equals("")) {
            condition += " and STR_TO_DATE(a.dateOfJoining,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + employeeAdvanceSearch.getDojStartDate() + "','%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + employeeAdvanceSearch.getDojEndDate() + "','%d/%m/%Y')";
        } else {
            condition += " and 1 = 1";
        }
        ///// Create Employee Advance search Query
        query += " Select ";
        if (employeeAdvanceSearch.getEmployeeId()) {
            query += " a.employeeId ,";
        } else {
            query += " '' as nonval ,";

        }
        if (employeeAdvanceSearch.getEmployeeName()) {
            query += " a.employeeName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getFatherName()) {
            query += " a.fatherName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getMotherName()) {
            query += " a.motherName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getGender()) {
            query += " case when a.gender = 0 then 'Male' else 'Female' end as gender,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getMaritalStatus()) {
            query += " a.maritalStatus,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getSpouseName()) {
            query += " a.spouseName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirth()) {
            query += " a.dateOfBirth,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPresentAddress()) {
            query += " a.presentAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPermanentAddress()) {
            query += " a.permanentAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBloodGroups()) {
            query += " a.bloodGroups,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmailAddress()) {
            query += " a.emailAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getContactNo1()) {
            query += " a.contactNo1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getContactNo2()) {
            query += " a.contactNo2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmergencyContactPerson()) {
            query += " a.emergencyContactPerson,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmergencyContactNo()) {
            query += " a.emergencyContactNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPanCard()) {
            query += " a.panCard,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportNo()) {
            query += " a.passportNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportIssueDate()) {
            query += " a.passportIssueDate,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportExpiryDate()) {
            query += " a.passportExpiryDate,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getAdharCard()) {
            query += " a.adharCard,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getOfficeEmailId()) {
            query += " a.officeEmailId,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getHighestEducationDetails()) {
            query += " a.highestEducationDetails,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getExperienceYearOnDoj()) {
            query += " a.experienceYearOnDoj,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getExperienceMonthOnDoj()) {
            query += " a.experienceMonthOnDoj,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getCompany()) {
            query += " a.company,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getZydexLocation()) {
            query += " e.zydexLocation,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getWorkLocation()) {
            query += " f.location,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getLevel()) {
            query += " d.level,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getDepartment()) {
            query += " b.departmentName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDesignation()) {
            query += " c.designationName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getRole()) {
            query += " a.role,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfJoining()) {
            query += " a.dateOfJoining,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmployeeType()) {
            query += " a.employeeType,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankName()) {
            query += " a.bankName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankAccountNo()) {
            query += " a.bankAccountNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankIfscCode()) {
            query += " a.bankIfscCode,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getReportingManager()) {
            query += " (Select g.employeeName From  EmployeeMaster g where g.id=a.reportingManagerLevel1) as reportingManagerLevel ,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getCityOfEmployee()) {
            query += " a.cityOfEmployee,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getChild1()) {
            query += " a.child1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getChild2()) {
            query += " a.child2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpFather()) {
            query += " a.dateOfBirthOfEmpFather,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpMother()) {
            query += " a.dateOfBirthOfEmpMother,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous()) {
            query += " a.dateOfBirthOfEmpSpous,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1()) {
            query += " a.dateOfBirthOfEmpChilld1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2()) {
            query += " a.dateOfBirthOfEmpChild2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfTransferOfEntity()) {
            query += " a.dateOfTransferOfEntity,";
        } else {
            query += " '' as nonval ,";
        }

        query += " '' as nonval1,a.id From  EmployeeMaster  a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + " LEFT JOIN a.levelMaster d "
                + " LEFT JOIN a.zydexLocationMaster e "
                + " LEFT JOIN a.locationMaster f "
                + " Where ((a.dateOfLeaving is null or a.dateOfLeaving = '')"
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()) ";
        if (null != condition && !"".equals(condition)) {
            query += " and" + condition;
        }
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> empOrDateWiseSearchforInActive(EmployeeAdvanceSearch employeeAdvanceSearch) {
        String query = "";
        String condition = "";

        if (null != employeeAdvanceSearch.getId() && !employeeAdvanceSearch.getId().equals("")) {
            condition += " a.id = " + employeeAdvanceSearch.getId();
        } else {
            // single condition
            if (null != employeeAdvanceSearch.getDepartmentId() && !employeeAdvanceSearch.getDepartmentId().equals("")) {
                condition += "  a.departmentMaster.id = " + employeeAdvanceSearch.getDepartmentId();
            } else {
                condition += " 1= 1";
            }
            // two condition
            if (null != employeeAdvanceSearch.getZydexLocationId() && !employeeAdvanceSearch.getZydexLocationId().equals("")) {
                condition += " and a.zydexLocationMaster.id = " + employeeAdvanceSearch.getZydexLocationId();
            } else {
                condition += " and 1 = 1";
            }
            // three condition
            if (null != employeeAdvanceSearch.getLevelID() && !employeeAdvanceSearch.getLevelID().equals("")) {
                condition += " and a.levelMaster.id = " + employeeAdvanceSearch.getLevelID();
            } else {
                condition += " and 1 = 1";
            }
        }
        if (null != employeeAdvanceSearch.getDojStartDate() && !employeeAdvanceSearch.getDojStartDate().equals("")
                && null != employeeAdvanceSearch.getDojEndDate() && !employeeAdvanceSearch.getDojEndDate().equals("")) {
            condition += " and STR_TO_DATE(a.dateOfJoining,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + employeeAdvanceSearch.getDojStartDate() + "','%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + employeeAdvanceSearch.getDojEndDate() + "','%d/%m/%Y')";
        } else {
            condition += " and 1 = 1";
        }
        ///// Create Employee Advance search Query
        query += " Select ";
        if (employeeAdvanceSearch.getEmployeeId()) {
            query += " a.employeeId ,";
        } else {
            query += " '' as nonval ,";

        }
        if (employeeAdvanceSearch.getEmployeeName()) {
            query += " a.employeeName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getFatherName()) {
            query += " a.fatherName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getMotherName()) {
            query += " a.motherName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getGender()) {
            query += " case when a.gender = 0 then 'Male' else 'Female' end as gender,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getMaritalStatus()) {
            query += " a.maritalStatus,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getSpouseName()) {
            query += " a.spouseName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirth()) {
            query += " a.dateOfBirth,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPresentAddress()) {
            query += " a.presentAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPermanentAddress()) {
            query += " a.permanentAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBloodGroups()) {
            query += " a.bloodGroups,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmailAddress()) {
            query += " a.emailAddress,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getContactNo1()) {
            query += " a.contactNo1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getContactNo2()) {
            query += " a.contactNo2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmergencyContactPerson()) {
            query += " a.emergencyContactPerson,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmergencyContactNo()) {
            query += " a.emergencyContactNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPanCard()) {
            query += " a.panCard,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportNo()) {
            query += " a.passportNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportIssueDate()) {
            query += " a.passportIssueDate,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getPassportExpiryDate()) {
            query += " a.passportExpiryDate,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getAdharCard()) {
            query += " a.adharCard,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getOfficeEmailId()) {
            query += " a.officeEmailId,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getHighestEducationDetails()) {
            query += " a.highestEducationDetails,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getExperienceYearOnDoj()) {
            query += " a.experienceYearOnDoj,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getExperienceMonthOnDoj()) {
            query += " a.experienceMonthOnDoj,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getCompany()) {
            query += " a.company,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getZydexLocation()) {
            query += " e.zydexLocation,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getWorkLocation()) {
            query += " f.location,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getLevel()) {
            query += " d.level,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getDepartment()) {
            query += " b.departmentName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDesignation()) {
            query += " c.designationName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getRole()) {
            query += " a.role,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfJoining()) {
            query += " a.dateOfJoining,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getEmployeeType()) {
            query += " a.employeeType,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankName()) {
            query += " a.bankName,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankAccountNo()) {
            query += " a.bankAccountNo,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getBankIfscCode()) {
            query += " a.bankIfscCode,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getReportingManager()) {
            query += " (Select g.employeeName From  EmployeeMaster g where g.id=a.reportingManagerLevel1) as reportingManagerLevel ,";
        } else {
            query += " '' as nonval ,";
        }

        if (employeeAdvanceSearch.getCityOfEmployee()) {
            query += " a.cityOfEmployee,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getChild1()) {
            query += " a.child1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getChild2()) {
            query += " a.child2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpFather()) {
            query += " a.dateOfBirthOfEmpFather,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpMother()) {
            query += " a.dateOfBirthOfEmpMother,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous()) {
            query += " a.dateOfBirthOfEmpSpous,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1()) {
            query += " a.dateOfBirthOfEmpChilld1,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2()) {
            query += " a.dateOfBirthOfEmpChild2,";
        } else {
            query += " '' as nonval ,";
        }
        if (employeeAdvanceSearch.getDateOfTransferOfEntity()) {
            query += " a.dateOfTransferOfEntity,";
        } else {
            query += " '' as nonval ,";
        }

        query += " '' as nonval1,a.id From  EmployeeMaster  a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + " LEFT JOIN a.levelMaster d "
                + " LEFT JOIN a.zydexLocationMaster e "
                + " LEFT JOIN a.locationMaster f "
                + " where (a.dateOfLeaving is not null and a.dateOfLeaving != '') "
                + " and  STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') < now()";
        if (null != condition && !"".equals(condition)) {
            query += " and" + condition;
        }
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readProbationByAdmin() {
        String query = "";
        query += ""
                + " Select a.id,a.employeeId,a.employeeName,a.dateOfJoining,d.id,"
                + " b.id,b.status,b.assessmentToDate"
                + " FROM EmployeeMaster a "
                + " left join a.probationToConfirmationsForEmployeeMasterId b "
                + " left join a.designationMaster d "
                + " WHERE a.employeeType like '%Probation%'"
                + " and (b.id is null or b.status !=8)"
                + " and ((a.dateOfLeaving is null or a.dateOfLeaving = '')"
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()) "
                + " order By b.id desc";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForProbationToConfirmation() {
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " WHERE a.employeeType like '%Probation%'";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeForLeaveBalance(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        String condition = "Where 1=1";
        if (!"".equals(employeeMaster.getId()) && null != employeeMaster.getId()) {
            condition += " AND a.id = " + employeeMaster.getId();
        }
        if (!"".equals(employeeMaster.getChild1()) && null != employeeMaster.getChild1()) {
            condition += " AND b.id = " + employeeMaster.getChild1();
        }
        if (!"".equals(employeeMaster.getChild2()) && null != employeeMaster.getChild2()) {
            condition += " AND c.id = " + employeeMaster.getChild2();
        }
        query += " Select a.id, a.employeeId, a.employeeName"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + condition;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeForLeaveBalanceForActiveUser(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        String condition = " and 1=1";
        if (!"".equals(employeeMaster.getId()) && null != employeeMaster.getId()) {
            condition += " AND a.id = " + employeeMaster.getId();
        }
        if (!"".equals(employeeMaster.getChild1()) && null != employeeMaster.getChild1()) {
            condition += " AND b.id = " + employeeMaster.getChild1();
        }
        if (!"".equals(employeeMaster.getChild2()) && null != employeeMaster.getChild2()) {
            condition += " AND c.id = " + employeeMaster.getChild2();
        }
        query += " Select a.id, a.employeeId, a.employeeName"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + " Where ((a.dateOfLeaving is null or a.dateOfLeaving = '')"
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()) "
                + condition;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeForLeaveBalanceForInActiveUser(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        String condition = " and 1=1";
        if (!"".equals(employeeMaster.getId()) && null != employeeMaster.getId()) {
            condition += " AND a.id = " + employeeMaster.getId();
        }
        if (!"".equals(employeeMaster.getChild1()) && null != employeeMaster.getChild1()) {
            condition += " AND b.id = " + employeeMaster.getChild1();
        }
        if (!"".equals(employeeMaster.getChild2()) && null != employeeMaster.getChild2()) {
            condition += " AND c.id = " + employeeMaster.getChild2();
        }
        query += " Select a.id, a.employeeId, a.employeeName"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.departmentMaster b "
                + " LEFT JOIN a.designationMaster c "
                + " where (a.dateOfLeaving is not null and a.dateOfLeaving != '') "
                + " and  STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') < now()"
                + condition;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> listOfCEO() {
        String query = "";
        query = " "
                + " From EmployeeMaster "
                + " where reportingManagerLevel1=''";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeForPlant() {
        String query = "";
        query += " "
                + " SELECT a.id,a.employeeId,a.employeeName,b.zydexLocation "
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.zydexLocationMaster b ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmpUserIdWise(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " Select a.locationMaster.id "
                + " FROM EmployeeMaster a "
                + " WHERE a.userMaster.id= " + employeeMaster.getUserMaster().getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readAllSubordinate(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " Where ((a.dateOfLeaving is null or a.dateOfLeaving = '')"
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()) "
                + " AND (a.reportingManagerLevel1= " + employeeMaster.getId()
                + " Or a.reportingManagerLevel2= " + employeeMaster.getId()
                + " Or a.reportingManagerLevel3= " + employeeMaster.getId()
                + " Or a.reportingManagerLevel4= " + employeeMaster.getId()
                + " Or a.reportingManagerLevel5= " + employeeMaster.getId()
                + " Or a.reportingManagerLevel6= " + employeeMaster.getId()
                + ")";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForSendMailToAll(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT "
                + " (Select a1.emailAddress "
                + " From  EmployeeMaster a1 "
                + " left join a1.levelMaster b1 "
                + " where a1.id=a.reportingManagerLevel2"
                + " and a.reportingManagerLevel2 != a.reportingManagerLevel3"
                + " and a.reportingManagerLevel2 != a.reportingManagerLevel4"
                + " and a.reportingManagerLevel2 != a.reportingManagerLevel5"
                + " and b1.level in ('2D','3A','3B','3C','4A','4B','4C','5A','5B','5C','5D')),"
                + " (Select a2.emailAddress "
                + " From  EmployeeMaster a2 "
                + " left join a2.levelMaster b2 "
                + " where a2.id=a.reportingManagerLevel3"
                + " and a.reportingManagerLevel3 != a.reportingManagerLevel4"
                + " and a.reportingManagerLevel3 != a.reportingManagerLevel5"
                + " and b2.level in ('2D','3A','3B','3C','4A','4B','4C','5A','5B','5C','5D')),"
                + " (Select a3.emailAddress "
                + " From  EmployeeMaster a3 "
                + " left join a3.levelMaster b3 "
                + " where a3.id=a.reportingManagerLevel4"
                + " and a.reportingManagerLevel4 != a.reportingManagerLevel5"
                + " and b3.level in ('2D','3A','3B','3C','4A','4B','4C','5A','5B','5C','5D')),"
                + " (Select a4.emailAddress "
                + " From  EmployeeMaster a4 "
                + " left join a4.levelMaster b4 "
                + " where a4.id=a.reportingManagerLevel5"
                + " and b4.level in ('2D','3A','3B','3C','4A','4B','4C','5A','5B','5C','5D'))"
                //                + " (Select a5.emailAddress "
                //                + " From  EmployeeMaster a5 "
                //                + " left join a5.levelMaster b5 "
                //                + " where a5.id=a.reportingManagerLevel2"
                //                + " and b5.level in ('2D','3A','3B','3C','4A','4B','4C','5A','5B','5C','5D'))"
                ////               
                + " FROM EmployeeMaster a "
                + " Where a.id=" + employeeMaster.getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readDepartmentWiseEmployee(T object) {
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        query += " SELECT a"
                + " FROM EmployeeMaster a "
                + " left join a.departmentMaster b"
                + " Where ((a.dateOfLeaving is null or a.dateOfLeaving = '')"
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()) "
                + " AND b.id=" + employeeMaster.getDepartmentMaster().getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByJoinDate(String date) {
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " Where STR_TO_DATE(a.dateOfJoining,'%d/%m/%Y')= STR_TO_DATE('" + date + "','%d/%m/%Y')";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeId(String empid) {
        String query = "";

        query += " FROM EmployeeMaster a"
                + " WHERE a.employeeId = '" + empid + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public Boolean checkLevel1AndLevel6FunctionheadByEmployeeMasterId(int empId) {
        boolean flag = false;
        List<?> list = getHibernateTemplate().find("from EmployeeMaster where reportingManagerLevel5 = ''"
                + " and reportingManagerLevel1=reportingManagerLevel6"
                + " and id =" + empId);
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean checkLevel1AndLevel5FunctionheadByEmployeeMasterId(int empId) {
        boolean flag = false;
        List<?> list = getHibernateTemplate().find("from EmployeeMaster where reportingManagerLevel1=reportingManagerLevel5"
                + " and id =" + empId);
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readLevel1AndLevel5FunctionheadByEmployeeMasterId(int id) {
        String query = "";
        query += " "
                + " FROM EmployeeMaster a "
                + " WHERE a.reportingManagerLevel1= a.reportingManagerLevel5"
                + " AND a.reportingManagerLevel1= " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeByBirthday(String date) {

        String query = "";

        query += "SELECT a FROM EmployeeMaster a"
                + " WHERE STR_TO_DATE(a.dateOfBirth,'%d/%m') = STR_TO_DATE('" + date + "','%d/%m')";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> newJoiningEmployee(String date) {
        String query = "";

        query += "SELECT a FROM EmployeeMaster a"
                + " WHERE STR_TO_DATE(a.dateOfJoining,'%d/%m/%Y') > STR_TO_DATE('" + date + "','%d/%m/%Y')";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> searchEmployeeDetailForContactInfo(final String searchString) {
        String hqlString = " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id,a.emailAddress,a.officeEmailId,a.contactNo1"
                + " FROM EmployeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.userMaster d "
                + " where"
                + " (a.employeeName like '%" + searchString + "%'"
                + " OR"
                + " b.designationName like '%" + searchString + "%'"
                + " OR"
                + " c.departmentName like '%" + searchString + "%'"
                + " OR"
                + " d.userName like '%" + searchString + "%'"
                + ")"
                + " and (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                //                + " STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y') <= CURDATE()";
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";

        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readEmployeeList(int id) {
       String query1 = "  "
                + "FROM UserRightMaster a "
                + " WHERE a.userMaster.id = " + id
                + " and a.hr =1";

         List<?> list1 = getHibernateTemplate().find(query1);
         if(list1.isEmpty()){
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeName, b.departmentName, c.designationName "
                + " FROM EmployeeMaster a "
                + " left join a.departmentMaster b "
                + " left join a.designationMaster c "
                + " WHERE a.reportingManagerLevel1  like '%" + id + "%'";

        return getHibernateTemplate().find(query);}
         else{
             String query = "";
         query += " "
                + " SELECT a.id, a.employeeName, b.departmentName, c.designationName "
                + " FROM EmployeeMaster a "
                + " left join a.departmentMaster b "
                + " left join a.designationMaster c ";
              

        return getHibernateTemplate().find(query);
         }
    }

}
