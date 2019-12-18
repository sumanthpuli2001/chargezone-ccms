/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprovalMaster;
import com.bul.zydex.model.ApprovalUser;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Vikas
 */
public class ApprovalUserDAOImpl<T> extends GenericsDAOImpl<T> implements ApprovalUserDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ApprovalUser.class;
    }

    @Override
    public List<?> readByApprovalId(int id) {

        String query = "SELECT a"
                + " FROM ApprovalUser a "
                + " left join a.employeeMaster c"
                + " left join a.approvalMaster b"
                + " WHERE a.approvalMaster.id = " + id;

        List<?> list = getHibernateTemplate().find(query);
//        Session s = getSessionFactory().openSession();
//        String sqlString = "SELECT"
//                + " b.id, b.approval_id, b.level, c.id"
//                + " from"
//                + " hr_power_vnc.approval_master a"
//                + " left join"
//                + " hr_power_vnc.approval_user b on a.id = b.approval_id"
//                + " left join"
//                + " hr_power_vnc.employee_master c on b.employee_master_id = c.id"
//                + " where a.id =" + id;
//
//        SQLQuery query = s.createSQLQuery(sqlString);
//        List<?> list = query.list();
//        s.close();

        return list;
    }

    @Override
    public List<?> readapprovalempId() {
        String query = "SELECT a.id, b.name, c.employeeName, a.level, b.id"
                + " FROM ApprovalUser a "
                + " left join a.approvalMaster b"
                + " left join a.employeeMaster c"
                + " group by a.approvalMaster.id";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> reademyId(int emid) {

        String query = "SELECT a"
                + " FROM ApprovalUser a "
                + " left join a.employeeMaster b"
                + " where a.approvalMaster.id =" + emid;

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readByApprovalFetch(int apid) {
        Session s = getSessionFactory().openSession();
        String sqlString = "SELECT"
                + " b.id, b.approval_id, b.level, c.id"
                + " from"
                + " hr_power_vnc.approval_master a"
                + " left join"
                + " hr_power_vnc.approval_user b on a.id = b.approval_id"
                + " left join"
                + " hr_power_vnc.employee_master c on b.employee_master_id = c.id"
                + " where a.id =" + apid;

        SQLQuery query = s.createSQLQuery(sqlString);
        List<?> list = query.list();
        s.close();
        return list;
    }

    @Override
    public List<?> approvaldelete(String apid) {

        String query = "";
        query += "  "
                + " select a"
                + " FROM ApprovalUser a "
                + " WHERE a.approvalMaster.id = " + apid;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByApId(int id) {
        String query = "SELECT a"
                + " FROM ApprovalUser a "
                + " WHERE a.approvalMaster.id = " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApprovalUser(String approvalMasterId) {
        String query = "";
        query = " Select a.id,e.employeeName"
                + " From ApprovalUser a  "
                + " left join a.employeeMaster e"
                + " Where a.approvalMaster =" + approvalMasterId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByapprovalId(int id) {
        String query = "";
        query = "SELECT a.id, b.employeeName, a.level"
                + " FROM ApprovalUser a "
                + " left join a.employeeMaster b"
                + " WHERE a.approvalMaster.id = " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
