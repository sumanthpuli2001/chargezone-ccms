/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Employee;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.UserRights;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aman Bahukhandi
 */
public class EmployeeMasterDaoImpl<T> extends GenericsDAOImpl<T> implements EmployeeMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeMaster.class;
    }

    @Override
    public Boolean readByRifId(String rfId) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + rfId + "'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public EmployeeMaster read(String empCode) {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.employeeCode = '" + empCode + "'"
                + " and a.dRow='N'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;
    }

    @Override
    public void deleteByEmpCode(String checkedValues) {
        String query = "";
        query += " delete FROM EmployeeMaster a"
                + " WHERE a.employeeCode = '" + checkedValues + "'"
                + " and a.dRow='N'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readShift(String code) {
        String query = "";
        query = " Select a.shiftType from EmployeeMaster a where a.employeeCode='" + code + "'"
                + " and a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public EmployeeMaster readByRfIdValue(String empCode) {
        EmployeeMaster employeeMaster = null;

        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + empCode + "'"
                + " and a.dRow='N'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return null;
        } else {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;

    }

    @Override
    public List readByDrow() {
        String query = "";
        query = " Select a from EmployeeMaster a where a.dRow = 'N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrowDisable() {
        String query = "";
        query = " Select a from EmployeeMaster a where a.dRow = 'Y'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRfId(String rfId) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + rfId + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRFid(String rfId) {
        String query = "Select a.employeeCode,a.rfId";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + rfId + "'"
                + " and a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByEmailMobile(String emailid, String mobileNo) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE  a.dRow='N' and (a.emailId like '%" + emailid + "%' or a.mobileNo like '%" + mobileNo + "%')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public EmployeeMaster readUser(String username) {
        EmployeeMaster employeeMaster = null;

        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.employeeCode = '" + username + "'"
                + " and a.dRow='N'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return null;
        } else {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;

    }

    @Override
    public List readAuthorizserUser(String location, String department) {
        String query = "";
        query += "select a.emailId, a.name FROM EmployeeMaster a , UserRights b"
                + " WHERE a.location = '" + location + "' and a.department = '" + department + "' and a.employeeCode = b.username and b.authorizeTender='1'"
                + " and a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByEmployeeId(String user_id, String full_name) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE  a.dRow='N' and ( a.employeeCode like '" + user_id + "' or a.name like '" + full_name + "')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readTenderEmployee() {
        String query = "";
        query += "select a.emailId, a.name, a.employeeCode FROM EmployeeMaster a , UserRights b"
                + " WHERE  a.employeeCode = b.username and b.createTender='1'"
                + " and a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List radByUserName(String username1) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.employeeCode NOT IN ('" + username1 + "')"
                + " and a.dRow='N'";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public EmployeeMaster readByfullname(String employee_code) {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.name = '" + employee_code + "'"
                + " and a.dRow='N'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;
    }

    @Override
    public EmployeeMaster readByEmployeeName(String user1) {
        EmployeeMaster employeeMaster = null;

        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.name = '" + user1 + "'"
                + " and a.dRow='N'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return null;
        } else {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;
    }

    @Override
    public List readByDepartName(String departName) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.department='" + departName + "'"
                + " and a.dRow='N'";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByRightsName(String rigName) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rightsName = '" + rigName + "'"
                + " and a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getEmployeeMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "id";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = "from EmployeeMaster a where a.dRow = 'N'";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.employeeCode) LIKE :searchValue "
                        + " OR lower(a.name) LIKE :searchValue "
                        + " OR lower(a.emailId) LIKE :searchValue "
                        + " OR lower(a.department) LIKE :searchValue "
                        + " OR lower(a.designation) LIKE :searchValue "
                        + " OR lower(a.rightsName) LIKE :searchValue "
                        + ")";
            }

            hql += " order by a."
                    + orderColumn
                    + " "
                    + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            List list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        } finally {
            session.close();
        }
    }

    @Override
    public int getTotalEmployeeMasterCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from EmployeeMaster a "
                + "where a.dRow = 'N'"
        ).uniqueResult();

        session.close();
        return count.intValue();
    }

    @Override
    public int getFilteredEmployeeMasterCount(String searchValue) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(a.id) "
                    + "from EmployeeMaster a "
                    + " where a.dRow = 'N'";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + " lower(a.employeeCode) LIKE :searchValue "
                        + " OR lower(a.name) LIKE :searchValue "
                        + " OR lower(a.emailId) LIKE :searchValue "
                        + " OR lower(a.department) LIKE :searchValue "
                        + " OR lower(a.designation) LIKE :searchValue "
                        + " OR lower(a.rightsName) LIKE :searchValue "
                        + ")";
            }
            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

//    @Override
//    public List readByoapApproval() {
//
//        String query = "SELECT a.id, a.employeeCode, a.name"
//                + "FROM EmployeeMaster a, UserRights b "
//                + "WHERE a.employeeCode = b.username "
//                + "AND b.oapApproval = 1";
//
//        return getHibernateTemplate().find(query);
//    }

}
