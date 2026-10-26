
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class UserMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
UserMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return UserMaster.class;
    }

    @Override
    public List<?> readByUserName(T object) {
        UserMaster user = (UserMaster) object;
        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.loginName = '" + user.getLoginName() + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> read(T object) {
        UserMaster user2 = (UserMaster) object;
        String hqlString = "from UserMaster um where um.loginName='"
        + user2.getLoginName()
        + "'"
        + " AND um.password='"
        + user2.getPassword()
        + "'";
        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public UserMaster read(String loginname) {
        UserMaster userMaster = new UserMaster();
        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.loginName = '" + loginname + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            userMaster = (UserMaster) list.get(0);
        }
        return userMaster;
    }

    @Override
    public void deleteByLoginName(String loginName) {

        String query = "";
        query = " delete FROM UserMaster a"
        + " WHERE a.loginName = '" + loginName + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readByDrow() {

        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.dRow = 'N' ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByDrowDisable() {
        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.dRow = 'Y' ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readUser(String loginname) {
        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.loginName = '" + loginname + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public void updatepass(String user11, String password) {
        String query = "";
        query = " update UserMaster a set a.password='" + password + "', a.pwdChange='1' "
        + " WHERE a.loginName = '" + user11 + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateuser(String employeeCode, String name) {
        String query = "";
        query = " update UserMaster a set a.userFullName='" + name + "' "
        + " WHERE a.loginName = '" + employeeCode + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateLock(String loginName, int userTry) {
        String query = "";
        query = " update UserMaster a set a.userTry='" + userTry + "', lock1=1 "
        + " WHERE a.loginName = '" + loginName + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateUserTry(String loginName, int userTry) {
        String query = "";
        query = " update UserMaster a set a.userTry='" + userTry + "' "
        + " WHERE a.loginName = '" + loginName + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateUserTry1(String loginName) {
        String query = "";
        query = " update UserMaster a set a.userTry='0' "
        + " WHERE a.loginName = '" + loginName + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void unlockuser(String loginname, String password) {
        String query = "";
        query = " update UserMaster a set a.password='" + password + "', a.pwdChange='0', lock1=0 "
        + " WHERE a.loginName = '" + loginname + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List checkUser(String username1, String password1, String user_department1) {
        String query = "";
        query += " select a.loginName FROM UserMaster a, EmployeeMaster b"
        + " WHERE a.loginName = '" + username1 + "' and a.password = '" + password1 + "' and b.department = '" + user_department1 + "' and a.loginName = b.employeeCode";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readEmailId(String email_id) {
        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.loginName = '" + email_id + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByVendorCode(String email) {
        String query = "";
        query += " FROM UserMaster a"
        + " WHERE a.vendorCode = '" + email + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
