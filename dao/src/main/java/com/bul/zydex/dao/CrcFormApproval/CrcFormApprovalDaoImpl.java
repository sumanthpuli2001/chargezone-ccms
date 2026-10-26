/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CrcFormApproval;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class CrcFormApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements CrcFormApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return CrcFormApproval.class;
    }

    @Override
    public List approvaList(String username) {
        String query = " Select a.id, b.crcForm, a.userId, a.approvalStatus, a.partiallyApproveDate, c.documentNo, c.deliverableReleaseDate,o.id,c.flagStatus";
        query += " FROM CrcFormApproval a, CrcFormApprovalUser b, CrcForm c,OapForm o";
        query += " WHERE c.id = a.crcForm and c.oapForm.id= o.id ";
        query += " AND a.id = b.crcFormApproval AND b.userId = '" + username + "'";
        query += " AND a.approvalStatus = 0 AND a.currentApproval = b.level";
        query += " ORDER BY a.id DESC";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readids(String id) {

        String query = "";
        query += " FROM CrcFormApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);

    }

    @Override
    public CrcFormApproval readByDeltecodes(String id) {
        CrcFormApproval crcFormApproval = new CrcFormApproval();
        String query = "";
        query += " FROM CrcFormApproval a"
                + " WHERE a.crcForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcFormApproval = (CrcFormApproval) list.get(0);
        }
        return crcFormApproval;
    }

    @Override
    public CrcFormApproval readBycrcid(String id) {
        CrcFormApproval crcFormApproval = new CrcFormApproval();
        String query = "";
        query += " FROM CrcFormApproval a"
                + " WHERE a.crcForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcFormApproval = (CrcFormApproval) list.get(0);
        }
        return crcFormApproval;
    }

    @Override
    public CrcFormApproval readBycrcFormid(int crcFormid) {

        CrcFormApproval crcFormApproval = new CrcFormApproval();
        String query = "";
        query += " FROM CrcFormApproval a"
                + " WHERE a.crcForm =  '" + crcFormid + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcFormApproval = (CrcFormApproval) list.get(0);
        }
        return crcFormApproval;

    }

    @Override
    public CrcFormApproval readBycrcids(int id1) {
        CrcFormApproval crcFormApproval = new CrcFormApproval();
        String query = "";
        query += " FROM CrcFormApproval a"
                + " WHERE a.crcForm =  '" + id1 + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcFormApproval = (CrcFormApproval) list.get(0);
        }
        return crcFormApproval;
    }

    @Override
    public List getCrcApprovaListPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "Select a.id, b.crcForm, a.userId, a.approvalStatus, a.partiallyApproveDate, c.documentNo, c.deliverableReleaseDate, o.id, c.flagStatus, c.pcsName "
                    + " FROM CrcFormApproval a, CrcFormApprovalUser b, CrcForm c, OapForm o"
                    + " WHERE c.id = a.crcForm AND c.oapForm.id = o.id "
                    + " AND a.id = b.crcFormApproval AND b.userId = :username"
                    + " AND a.approvalStatus = 0 AND a.currentApproval = b.level";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)                      LIKE :search "
                        + "OR lower(c.pcsName)                         LIKE :search "
                        + "OR lower(str(c.deliverableReleaseDate))      LIKE :search "
                        + "OR lower(a.userId)                          LIKE :search "
                        + "OR (c.flagStatus = 0  AND lower('pending')  LIKE :search) "
                        + "OR (c.flagStatus = 1  AND lower('approved') LIKE :search) "
                        + "OR (c.flagStatus = 2  AND lower('rework')   LIKE :search) "
                        + "OR (c.flagStatus = 3  AND lower('rejected') LIKE :search) "
                        + "OR (c.flagStatus = 800  AND lower('partially approved') LIKE :search) "
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
    public int getTotalCrcApprovaListCount(String username) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + " FROM CrcFormApproval a, CrcFormApprovalUser b, CrcForm c, OapForm o"
                    + " WHERE c.id = a.crcForm AND c.oapForm.id = o.id "
                    + " AND a.id = b.crcFormApproval AND b.userId = :username"
                    + " AND a.approvalStatus = 0 AND a.currentApproval = b.level";

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
    public int getFilteredCrcApprovaListCount(String username, String searchValue) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + " FROM CrcFormApproval a, CrcFormApprovalUser b, CrcForm c, OapForm o"
                    + " WHERE c.id = a.crcForm AND c.oapForm.id = o.id "
                    + " AND a.id = b.crcFormApproval AND b.userId = :username"
                    + " AND a.approvalStatus = 0 AND a.currentApproval = b.level";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)                      LIKE :search "
                        + "OR lower(c.pcsName)                         LIKE :search "
                        + "OR lower(str(c.deliverableReleaseDate))      LIKE :search "
                        + "OR lower(a.userId)                          LIKE :search "
                        + "OR (c.flagStatus = 0  AND lower('pending')  LIKE :search) "
                        + "OR (c.flagStatus = 1  AND lower('approved') LIKE :search) "
                        + "OR (c.flagStatus = 2  AND lower('rework')   LIKE :search) "
                        + "OR (c.flagStatus = 3  AND lower('rejected') LIKE :search) "
                        + "OR (c.flagStatus = 800  AND lower('partially approved') LIKE :search) "
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
