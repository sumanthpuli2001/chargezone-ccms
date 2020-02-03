package com.bul.zydex.dao.resignation;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserRightMaster;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dhruv
 */
public class ResignationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ResignationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ResignationMaster.class;
    }

    @Override
    public List<?> readByEmpID(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id=" + id + " "
                + " and a.status in (0,1,2,3,4,5,6,7,8,10,11)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readRegStatusList(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " "
                + " SELECT a.status "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id= '" + resignationMaster.getEmployeeMaster().getId() + "'"
                + " and a.status != 9 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApprovedList(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id=" + id + " and a.status=2 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByResignationPendingRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " Select a.id,a.effectiveDatetime,a.status, a.employeeMaster.id, a.relievingDate"
                + " FROM ResignationMaster a"
                + " WHERE a.employeeMaster.id=" + resignationMaster.getEmployeeMaster().getId()
                + " and a.status in (0,1,2,3,4,5,6,7,8,10,11)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readforapprover(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " Select a.id,a.effectiveDatetime,a.status, b.id, b.employeeId,b.employeeName"
                + " FROM ResignationMaster a"
                + " left join a.employeeMaster b"
                + " WHERE b.reportingManagerLevel1 = " + resignationMaster.getEmployeeMaster().getId()
                + " and a.status in (0,3,5)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readforHR(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " Select a.id,a.effectiveDatetime,a.status, b.id, b.employeeId,b.employeeName, a.attrition,b.employeeTypeMaster.typeOfEmployee,b.employeeSubType.subType"
                + " FROM ResignationMaster a"
                + " left join a.employeeMaster b"
                + " WHERE a.status in (2,7,10,4)"
                + " and  (b.dateOfLeaving is null or b.dateOfLeaving = '') "
                + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()"
                + " order by a.id desc GROUP BY b.id";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExistingList(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " WHERE a.employeeMaster.id=" + id
                + " and a.status != 9";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readmanager1(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b"
                + " WHERE b.reportingManagerLevel1= " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSearchRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        String condition = "";

        if (null != resignationMaster.getEmployeeMaster().getId()) {
            condition += " AND  a.id = " + resignationMaster.getEmployeeMaster().getId();
        }
        if (!"".equals(resignationMaster.getReason()) && null != resignationMaster.getReason()) {
            condition += " AND e.id = " + resignationMaster.getReason();
        }
        if (!"".equals(resignationMaster.getManagerComment()) && null != resignationMaster.getManagerComment()) {
            condition += " AND f.id = " + resignationMaster.getManagerComment();
        }

        query += " Select  a.employeeId, a.employeeName , b.status ,c.status,d.status,a.id,b.id,c.id ,d.id"
                //                + " (select em.employeeName from EmployeeMaster em where em.id = g.employeeMasterByApproverId)"
                + " From EmployeeMaster a "
                //                + " ExitInterviewMaster g "
                + " LEFT JOIN  a.resignationMasters b"
                + " LEFT JOIN  a.exitInterviewMastersForEmpId c"
                + " LEFT JOIN  a.noDueMastersForEmpId d"
                + " LEFT JOIN a.departmentMaster e"
                + " LEFT JOIN a.designationMaster f"
                + " Where (d.status in (0,1,2,3,4,5,6,7)"
                + " or c.status in (0,1,2) "
                + " or b.status in (0,1,2,3,4,5,6,7,9,10,11))" + condition
                + " order By b.id desc"
                + " group by d.id ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readmanagerSearchRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        String condition = "";

        query += " Select  a.employeeId,a.employeeName,b.status,c.status,b.effectiveDatetime,a.id,b.id,c.id "
                + " From EmployeeMaster  a "
                + " LEFT JOIN  a.resignationMasters b"
                + " LEFT JOIN  a.exitInterviewMastersForEmpId c"
                + " Where a.reportingManagerLevel1 = " + resignationMaster.getEmployeeMaster().getId()
                + " and (c.status in (0,1,2) "
                + " or b.status in (0,1,2,3,4,5,6,7,9,10,11))" + condition;

//                + " and (c.status in (0,1,2,3,4,5,6,7) "
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readresignationApproverPendingRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += "Select a.id,b.employeeName"
                + " From resignationMasters a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + resignationMaster.getEmployeeMaster().getId()
                + " and a.status in (0)";
        return getHibernateTemplate().find(query);
    }

    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMaster"
                + " From ResignationMaster a"
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readResignedEmployees() {
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role"
                + " From ResignationMaster r"
                + " LEFT JOIN r.employeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " WHERE r.status = 4 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> getFinallyResignedEmployees() {
        String query = "";
        query += " "
                + " From ResignationMaster R"
                + " where R.status = '4'"
                + " Order by R.id desc ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> getFinallyResignedEmployeesForDashBoard(String employeeId, boolean employeeExit, boolean itAdmin, boolean travelAdmin) {

        String query = "";
        query += " Select ";
        if (employeeExit) {
            query += " count(*)";
        } else if (itAdmin) {
            query += " count(*)";
        } else if (travelAdmin) {
            query += " count(*)";
        } else {
            query += " count(*)";
        }
        query += " From ResignationMaster r"
                + " left join r.employeeMaster e"
                + " left join e.noDueMastersForEmpId ndm"
                + " where r.status = '4'";
        if (employeeExit) {
            query += " and ndm.carProvided IS NULL OR ndm.carProvided = ''";
        } else if (itAdmin) {
            query += " and ndm.computerChecked IS NULL OR ndm.computerChecked = ''";
        } else if (travelAdmin) {
            query += " and ndm.salaryAdvanceOrLoan IS NULL OR ndm.salaryAdvanceOrLoan = ''";
        } else {
            query += " and e.reportingManagerLevel1=" + employeeId + " and ndm.equipments IS NULL OR ndm.equipments = '' ";
        }

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public ResignationMaster readByEmpId(int EmpId) {
        ResignationMaster resignationMaster = new ResignationMaster();
        String query = "SELECT a"
                + " FROM ResignationMaster a "
                + " WHERE a.employeeMaster=" + EmpId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            resignationMaster = (ResignationMaster) list.get(0);
        } else {
            resignationMaster = null;
        }
        return resignationMaster;
    }

    @Override
    public List<?> fetchBWdate(int empId, String eftDate, String relivDate) {
        Session s = getSessionFactory().openSession();
        String sqlString = "SELECT"
                + "  b.id, b.gross_total, b.month, b.year"
                + " FROM"
                + " hr_power_gipcl.resignation_master a"
                + " LEFT JOIN"
                + " hr_power_gipcl.employee_salary_process b"
                + " ON a.emp_master_id = b.employee_master_id"
                + " WHERE"
                + " month BETWEEN DATE_FORMAT(STR_TO_DATE('" + eftDate + "' , '%d/%m/%Y - %H:%i'),'%m')"
                + " AND DATE_FORMAT(STR_TO_DATE( '" + relivDate + "' , '%d/%m/%Y - %H:%i'),'%m')"
                + " AND  b.employee_master_id =" + empId
                + " group by b.id";
        SQLQuery query = s.createSQLQuery(sqlString);
        List<?> list = query.list();
        s.close();
        return list;
    }

    @Override
    public List<?> readByApprovedEmpID(Integer id) {
        String query = "";
        query += "Select a"
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id=" + id + " "
                + " and a.status = 4";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
