/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffFormApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KickOffFormApproval;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class KickOffFormApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements KickOffFormApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return KickOffFormApproval.class;
    }

    @Override
    public List approvaList(String username) {
        String query = "SELECT a.id, b.kickOffForm, a.userId, a.approvalStatus, c.documentNo, c.dateTime, o.id , c.flagStatus ";
        query += "FROM KickOffFormApproval a, KickOffFormApprovalUser b, KickOffForm c, AocForm o "
                + "WHERE a.id = b.kickOffFormApproval "
                + "And c.aocForm.id= o.id "
                + "AND c.id = a.kickOffForm "
                + "AND b.userId = '" + username + "' "
                + "AND a.approvalStatus = 0 "
                + "AND a.currentApproval = b.level "
                + "ORDER BY a.id DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readids(String id) {
        String query = "";
        query += " FROM KickOffFormApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);

    }

    @Override
    public KickOffFormApproval readBykickapprid(String id) {
        KickOffFormApproval kickOffFormApproval = new KickOffFormApproval();
        String query = "";
        query += " FROM KickOffFormApproval a"
                + " WHERE a.kickOffForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kickOffFormApproval = (KickOffFormApproval) list.get(0);
        }
        return kickOffFormApproval;

    }

    @Override
    public KickOffFormApproval readByDeltecodes(String id) {
        KickOffFormApproval kickOffFormApproval = new KickOffFormApproval();
        String query = "";
        query += " FROM KickOffFormApproval a"
                + " WHERE a.kickOffForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kickOffFormApproval = (KickOffFormApproval) list.get(0);
        }
        return kickOffFormApproval;

    }

    @Override
    public KickOffFormApproval readBykickid(int id1) {
        KickOffFormApproval kickOffFormApproval = new KickOffFormApproval();
        String query = "";
        query += " FROM KickOffFormApproval a"
                + " WHERE a.kickOffForm =  '" + id1 + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kickOffFormApproval = (KickOffFormApproval) list.get(0);
        }
        return kickOffFormApproval;

    }

    @Override
    public List getKomApprovalUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, b.kickOffForm, a.userId, a.approvalStatus, c.documentNo, c.dateTime, o.id, c.flagStatus "
                    + " FROM KickOffFormApproval a, KickOffFormApprovalUser b, KickOffForm c, AocForm o "
                    + " WHERE a.id = b.kickOffFormApproval "
                    + " AND c.id = a.kickOffForm "
                    + " AND c.aocForm.id = o.id "
                    + " AND b.userId = :username "
                    + " AND a.approvalStatus = 0 "
                    + " AND a.currentApproval = b.level "
                    + " AND c.flagStatus NOT IN (5,6,7)";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)                       LIKE :search "
                        + "OR lower(str(c.dateTime))                     LIKE :search "
                        + "OR lower(a.userId)                            LIKE :search "
                        + "OR (c.flagStatus = 0  AND lower('pending')   LIKE :search) "
                        + "OR (c.flagStatus = 1  AND lower('approved')  LIKE :search) "
                        + "OR (c.flagStatus = 2  AND lower('rework')    LIKE :search) "
                        + "OR (c.flagStatus = 3  AND lower('rejected')  LIKE :search) "
                        + ")";
            }

            if (orderColumn != null && !orderColumn.trim().isEmpty()) {
                hql += " ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "asc");
            } else {
                hql += " ORDER BY a.id desc";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getTotalKomApprovalUserCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + " FROM KickOffFormApproval a, KickOffFormApprovalUser b, KickOffForm c, AocForm o "
                    + " WHERE a.id = b.kickOffFormApproval "
                    + " AND c.id = a.kickOffForm "
                    + " AND c.aocForm.id = o.id "
                    + " AND b.userId = :username "
                    + " AND a.approvalStatus = 0 "
                    + " AND a.currentApproval = b.level "
                    + " AND c.flagStatus NOT IN (5,6,7)";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredKomApprovalUserCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + " FROM KickOffFormApproval a, KickOffFormApprovalUser b, KickOffForm c, AocForm o "
                    + " WHERE a.id = b.kickOffFormApproval "
                    + " AND c.id = a.kickOffForm "
                    + " AND c.aocForm.id = o.id "
                    + " AND b.userId = :username "
                    + " AND a.approvalStatus = 0 "
                    + " AND a.currentApproval = b.level "
                    + " AND c.flagStatus NOT IN (5,6,7)";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)                       LIKE :search "
                        + "OR lower(str(c.dateTime))                     LIKE :search "
                        + "OR lower(a.userId)                            LIKE :search "
                        + "OR (c.flagStatus = 0  AND lower('pending')   LIKE :search) "
                        + "OR (c.flagStatus = 1  AND lower('approved')  LIKE :search) "
                        + "OR (c.flagStatus = 2  AND lower('rework')    LIKE :search) "
                        + "OR (c.flagStatus = 3  AND lower('rejected')  LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

}
