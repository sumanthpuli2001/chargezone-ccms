/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormApproval;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class AocFormApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocFormApproval.class;
    }

    @Override
    public List approvaList(String username) {
        String query = "SELECT a.id, b.aocForm, a.userId, b.approvalStatus, c.zeroDate, c.documentNo, c.flagStatus ";
        query += "FROM AocFormApproval a, AocFormApprovalUser b, AocForm c "
                + "WHERE a.id = b.aocFormApproval "
                + "AND c.id = a.aocForm "
                + "AND b.userId = '" + username + "' "
                + "AND b.approvalStatus = 0  and  a.approvalStatus NOT IN (2, 3) "
                + "AND a.currentApproval = b.level "
                + "ORDER BY a.id DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByIds(String id) {
        String query = "";
        query += " FROM AocFormApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);

    }

    @Override
    public AocFormApproval readByDeltecodes(String id) {
        AocFormApproval aocFormApproval = new AocFormApproval();
        String query = "";
        query += " FROM AocFormApproval a"
                + " WHERE a.aocForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            aocFormApproval = (AocFormApproval) list.get(0);
        }
        return aocFormApproval;
    }

    @Override
    public List getAocApprovalPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String hql = "SELECT a.id, b.aocForm, a.userId, b.approvalStatus, c.documentNo, c.flagStatus, c.createdDate "
                    + "FROM AocFormApproval a, AocFormApprovalUser b, AocForm c "
                    + "WHERE a.id = b.aocFormApproval "
                    + "AND c.id = a.aocForm "
                    + "AND b.userId = :username "
                    + "AND b.approvalStatus = 0 AND a.approvalStatus NOT IN (2, 3) "
                    + "AND a.currentApproval = b.level ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)                        LIKE :search "
                        + "OR lower(str(c.createdDate))                   LIKE :search "
                        + "OR lower(a.userId)                             LIKE :search "
                        + "OR (b.approvalStatus = 0  AND lower('pending')    LIKE :search) "
                        + "OR (b.approvalStatus = 1  AND lower('approve')    LIKE :search) "
                        + "OR (b.approvalStatus = 2  AND lower('rework')     LIKE :search) "
                        + "OR (b.approvalStatus = 3  AND lower('rejected')   LIKE :search) "
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
    public int getTotalAocApprovalCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + "FROM AocFormApproval a, AocFormApprovalUser b, AocForm c "
                    + "WHERE a.id = b.aocFormApproval "
                    + "AND c.id = a.aocForm "
                    + "AND b.userId = :username "
                    + "AND b.approvalStatus = 0 AND a.approvalStatus NOT IN (2, 3) "
                    + "AND a.currentApproval = b.level ";

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
    public int getFilteredAocApprovalCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + "FROM AocFormApproval a, AocFormApprovalUser b, AocForm c "
                    + "WHERE a.id = b.aocFormApproval "
                    + "AND c.id = a.aocForm "
                    + "AND b.userId = :username "
                    + "AND b.approvalStatus = 0 AND a.approvalStatus NOT IN (2, 3) "
                    + "AND a.currentApproval = b.level ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)                        LIKE :search "
                        + "OR lower(str(c.createdDate))                   LIKE :search "
                        + "OR lower(a.userId)                             LIKE :search "
                        + "OR (b.approvalStatus = 0  AND lower('pending')    LIKE :search) "
                        + "OR (b.approvalStatus = 1  AND lower('approve')    LIKE :search) "
                        + "OR (b.approvalStatus = 2  AND lower('rework')     LIKE :search) "
                        + "OR (b.approvalStatus = 3  AND lower('rejected')   LIKE :search) "
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
