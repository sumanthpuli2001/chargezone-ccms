/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapFormApproval;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class OapFormApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements OapFormApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapFormApproval.class;
    }

    @Override
    public List approvaList(String username) {
        String query = " Select a.id, b.oapForm, a.userId, b.approvalStatus,c.documentNo,c.date,c.flagStatus,c.createdDate,c.pcsName";
        query += " FROM OapFormApproval a, OapFormApprovalUser b, OapForm c"
                + " WHERE a.id = b.oapFormApproval"
                + " AND b.userId = '" + username + "'"
                + " AND c.id = a.oapForm"
                + " AND b.approvalStatus = 0  and  a.approvalStatus NOT IN (2, 3)"
                + " AND a.currentApproval = b.level"
                + " AND c.flagStatus NOT IN (0,100)"
                + " ORDER BY a.id DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByIds(String id) {

        String query = "";
        query += " FROM OapFormApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDeltecode(String id) {
//	OapFormApproval oapFormApproval = new OapFormApproval();

        String query = "SELECT a.id,b.id";
        query += " FROM OapFormApproval a,OapFormApprovalUser b"
                + " WHERE a.oapForm = '" + id + "'"
                + " AND a.id=b.oapFormApproval";

        List list = getHibernateTemplate().find(query);

        return list;

    }

    @Override
    public OapFormApproval readByDeltecodes(String id) {
        OapFormApproval oapFormApproval = new OapFormApproval();
        String query = "";
        query += " FROM OapFormApproval a"
                + " WHERE a.oapForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            oapFormApproval = (OapFormApproval) list.get(0);

        }
        return oapFormApproval;
    }

    @Override
    public OapFormApproval readByoapappid(String id) {
        OapFormApproval oapFormApproval = new OapFormApproval();

        String query = "";
        query += " FROM OapFormApproval a"
                + " WHERE a.oapForm =  '" + id + "'";
        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            oapFormApproval = (OapFormApproval) list.get(0);

        }
        return oapFormApproval;

    }

    @Override
    public OapFormApproval readByIdAndUsername(String id, String userName) {
        OapFormApproval oapFormApproval = new OapFormApproval();

        String query = "";
        query += " FROM OapFormApproval a"
                + " WHERE a.oapForm =  '" + id + "'"
                + " And a.userId =  '" + userName + "'";
        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            oapFormApproval = (OapFormApproval) list.get(0);

        }
        return oapFormApproval;

    }

    @Override
    public List getOapApprovaListPagination(int start, int length, String searchValue,
            String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "Select  c.id, c.documentNo, c.pcsName, c.projectName, c.department, c.createdDate, c.flagStatus, a.id, b.oapForm, b.approvalStatus, a.userId "
                    + " FROM OapFormApproval a, OapFormApprovalUser b, OapForm c"
                    + " WHERE a.id = b.oapFormApproval"
                    + " AND b.userId = :username"
                    + " AND c.id = a.oapForm"
                    + " AND b.approvalStatus = 0  and  a.approvalStatus NOT IN (2, 3)"
                    + " AND a.currentApproval = b.level"
                    + " AND c.flagStatus NOT IN (0,100)";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)    LIKE :search "
                        + "OR lower(c.pcsName)       LIKE :search "
                        + "OR lower(c.projectName)   LIKE :search "
                        + "OR lower(c.department)    LIKE :search "
                        + "OR str(c.createdDate)     LIKE :search "
                        + "OR (c.flagStatus = 0  AND lower('pending')      LIKE :search) "
                        + "OR (c.flagStatus = 1  AND lower('approved')     LIKE :search) "
                        + "OR (c.flagStatus = 2  AND lower('rework')       LIKE :search) "
                        + "OR (c.flagStatus = 3  AND lower('rejected')     LIKE :search) "
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
    public int getTotalOapApprovaListCount(String username) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + " FROM OapFormApproval a, OapFormApprovalUser b, OapForm c"
                    + " WHERE a.id = b.oapFormApproval"
                    + " AND b.userId = :username"
                    + " AND c.id = a.oapForm"
                    + " AND b.approvalStatus = 0  and  a.approvalStatus NOT IN (2, 3)"
                    + " AND a.currentApproval = b.level"
                    + " AND c.flagStatus NOT IN (0,100)";

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
    public int getFilteredOapApprovaListCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(c.id) "
                    + " FROM OapFormApproval a, OapFormApprovalUser b, OapForm c"
                    + " WHERE a.id = b.oapFormApproval"
                    + " AND b.userId = :username"
                    + " AND c.id = a.oapForm"
                    + " AND b.approvalStatus = 0  and  a.approvalStatus NOT IN (2, 3)"
                    + " AND a.currentApproval = b.level"
                    + " AND c.flagStatus NOT IN (0,100)";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(c.documentNo)    LIKE :search "
                        + "OR lower(c.pcsName)       LIKE :search "
                        + "OR lower(c.projectName)   LIKE :search "
                        + "OR lower(c.department)    LIKE :search "
                        + "OR str(c.createdDate)     LIKE :search "
                        + "OR (c.flagStatus = 0  AND lower('pending')      LIKE :search) "
                        + "OR (c.flagStatus = 1  AND lower('approved')     LIKE :search) "
                        + "OR (c.flagStatus = 2  AND lower('rework')       LIKE :search) "
                        + "OR (c.flagStatus = 3  AND lower('rejected')     LIKE :search) "
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
