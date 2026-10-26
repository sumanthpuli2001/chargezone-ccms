/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprovalSetting;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class ApprovalSettingDaoImpl<T> extends GenericsDAOImpl<T> implements ApprovalSettingDao<T> {

     @Override
    protected Class getDomainClass() {
        return ApprovalSetting.class;
    }
    
    @Override
    public List readByrow() {
        String query = "";
        query = " Select a from ApprovalSetting a";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public ApprovalSetting read(String Code) {

        ApprovalSetting approvalSetting = new ApprovalSetting();
        String query = "";
        query += " FROM ApprovalSetting a"
                + " WHERE a.id = '" + Code + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            approvalSetting = (ApprovalSetting) list.get(0);
        }
        return approvalSetting;
    }
    
    @Override
    public List readOne(String rone) {
        String query = "";
        query += " FROM ApprovalSetting a"
                + " WHERE a.approvalOne = '" + rone + "'";
        return getHibernateTemplate().find(query);
    }
    
    
    @Override
    public void deleteByCode(String checkedValues) {
        String query = "";
        query += " delete FROM ApprovalSetting a"
                + " WHERE a.id = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }
    
    @Override
    public ApprovalSetting readUserId(String user) {

        ApprovalSetting approvalSetting = new ApprovalSetting();
        String query = "";
        query += " FROM ApprovalSetting a"
                + " WHERE a.approvalOne = '" + user + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            approvalSetting = (ApprovalSetting) list.get(0);
        }
        return approvalSetting;
    }

    @Override
    public List getApprovalPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
  Session session = getSessionFactory().openSession();
        try {

            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "approvalOne";
            }

            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc")
                    && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = "from ApprovalSetting a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and ("
                        + "lower(a.approvalOne) like :search "
                        + "or lower(a.approvalTwo) like :search "
                        + "or str(a.approvalThree) like :search"
                        + ")";
            }

            hql += " order by a." + orderColumn + " " + orderDir;

            System.out.println("HQL : " + hql);

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search",
                        "%" + searchValue.toLowerCase() + "%");
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
        }    }

    @Override
    public int getApprovalCount() {
Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from ApprovalSetting a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();    }

    @Override
    public int getFilteredApprovalCount(String search) {
 Session session = getSessionFactory().openSession();

    try {

        String hql = "select count(*) "
                + "from ApprovalSetting a "
                + "where 1 = 1";

        if (search != null && !search.trim().isEmpty()) {

            hql += " and ("
                    + "lower(a.approvalOne) like :search "
                    + "or lower(a.approvalTwo) like :search "
                    + "or str(a.approvalThree) like :search"
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (search != null && !search.trim().isEmpty()) {
            query.setParameter(
                    "search",
                    "%" + search.toLowerCase() + "%"
            );
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();

    } catch (Exception e) {

        e.printStackTrace();
        return 0;

    } finally {

        session.close();
    }    }
    
}
