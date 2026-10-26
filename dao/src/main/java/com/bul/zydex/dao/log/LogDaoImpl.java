/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.log;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LogsMaster;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author aman.bahukhandi
 */
public class LogDaoImpl<T> extends GenericsDAOImpl<T> implements LogDao<T> {

    @Override
    protected Class getDomainClass() {
        return LogsMaster.class;
    }

    @Override
    public List readLogs(String dFrom, String eFrom) {

        String query = "";
        query = " select a "
                + " from LogsMaster a "
                + " where (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))"
                + " order by a.srNoValue desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readLog(String user_name, String open_from_date, String open_to_date) {
        String query = "";

        if (open_from_date.equals("")) {
            query = " select a "
                    + " from LogsMaster a "
                    + " where userName like '%" + user_name + "%' "
                    + " ";
        } else {
            query = " select a "
                    + " from LogsMaster a "
                    + " where userName like '%" + user_name + "%' and (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y') and STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))"
                    + " ";
        }

        return getHibernateTemplate().find(query);
    }

    @Override
    public List getActivityLogsPagination(int start, int length, String searchValue, String userName, String fromDate, String toDate, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {
            String hql = "FROM LogsMaster b "
                    + "WHERE 1=1 ";

            if (userName != null && !userName.equals("")) {
                hql += " AND lower(b.userName) LIKE :userName ";
            }

            if (fromDate != null && !fromDate.trim().equals("")) {
                hql += " AND STR_TO_DATE(CONCAT(b.lDate, ' ', b.time), '%Y-%m-%d') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            }

            if (toDate != null && !toDate.trim().equals("")) {
                hql += " AND STR_TO_DATE(CONCAT(b.lDate, ' ', b.time), '%Y-%m-%d') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.equals("")) {

                hql += " AND ("
                        + " lower(b.userName) LIKE :searchValue "
                        + " OR lower(b.ip) LIKE :searchValue "
                        + " OR lower(b.lDate) LIKE :searchValue "
                        + " OR lower(b.time) LIKE :searchValue "
                        + " OR lower(b.action) LIKE :searchValue "
                        + ")";
            }

            hql += " ORDER BY b." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (userName != null && !userName.equals("")) {
                query.setParameter("userName", "%" + userName.toLowerCase() + "%");
            }

            if (fromDate != null && !fromDate.trim().equals("")) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().equals("")) {
                query.setParameter("toDate", toDate);
            }

            if (searchValue != null && !searchValue.equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int getActivityLogsCount(String userName) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(b.srNoValue) "
                    + "FROM LogsMaster b "
                    + "WHERE 1 = 1";

            if (userName != null && !userName.equals("")) {
                hql += " AND lower(b.userName) LIKE :userName ";
            }

            Query query = session.createQuery(hql);

            if (userName != null && !userName.equals("")) {
                query.setParameter("userName", userName);
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public int getFilteredActivityLogsCount(String searchValue, String userName, String fromDate, String toDate) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {
            String hql = "SELECT COUNT(b.srNoValue) "
                    + "FROM LogsMaster b "
                    + "WHERE 1 = 1";

            if (userName != null && !userName.equals("")) {
                hql += " AND lower(b.userName) LIKE :userName ";
            }

            if (fromDate != null && !fromDate.trim().equals("")) {
                hql += " AND STR_TO_DATE(CONCAT(b.lDate, ' ', b.time), '%Y-%m-%d') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            }

            if (toDate != null && !toDate.trim().equals("")) {
                hql += " AND STR_TO_DATE(CONCAT(b.lDate, ' ', b.time), '%Y-%m-%d') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.equals("")) {

                hql += " AND ("
                        + " lower(b.userName) LIKE :searchValue "
                        + " OR lower(b.ip) LIKE :searchValue "
                        + " OR lower(b.lDate) LIKE :searchValue "
                        + " OR lower(b.time) LIKE :searchValue "
                        + " OR lower(b.action) LIKE :searchValue "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (userName != null && !userName.equals("")) {
                query.setParameter("userName", "%" + userName.toLowerCase() + "%");
            }

            if (fromDate != null && !fromDate.trim().equals("")) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().equals("")) {
                query.setParameter("toDate", toDate);
            }

            if (searchValue != null && !searchValue.equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return count.intValue();
    }

}
