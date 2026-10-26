/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AuditorMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuditorMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bulwarks-2
 */
public class AuditorMasterDaoImpl<T> extends GenericsDAOImpl<T> implements AuditorMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return AuditorMaster.class;
    }

    @Override
    public List readByCategoryHigh() {
        String query = "";
        query += " FROM AuditorMaster a"
                + " WHERE a.auditorRole = 'Risk Evaluator'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByCategoryMedium() {
        String query = "";
        query += " FROM AuditorMaster a"
                + " WHERE a.auditorRole = 'Internal Auditor'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AuditorMaster readByAuditorCode(String auditor) {
        AuditorMaster auditorMaster = new AuditorMaster();
        String query = "";
        query += " FROM AuditorMaster a"
                + " WHERE a.auditorCode = '" + auditor + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auditorMaster = (AuditorMaster) list.get(0);
        }
        return auditorMaster;
    }

    @Override
    public List getAuditorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        try {

            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "id";
            }

            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc")
                    && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = "from AuditorMaster a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and ("
                        + "lower(a.auditorCode) like :search "
                        + "or lower(a.auditorName) like :search "
                        + "or lower(a.auditorAddress) like :search "
                        + "or lower(a.auditorEmail) like :search "
                        + "or str(a.auditorMobileNo) like :search"
                        + "or str(a.auditorStatus) like :search"
                        + "or str(a.auditorRemark) like :search"
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
        }

    }

    @Override
    public int getTotalAuditorCount() {

        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from AuditorMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public int getFilteredAuditorCount(String search) {

        Session session = getSessionFactory().openSession();

        try {

            String hql = "select count(*) "
                    + "from AuditorMaster a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {

                hql += " and ("
                        + "lower(a.auditorCode) like :search "
                        + "or lower(a.auditorName) like :search "
                        + "or lower(a.auditorAddress) like :search "
                        + "or lower(a.auditorEmail) like :search "
                        + "or str(a.auditorMobileNo) like :search"
                        + "or str(a.auditorStatus) like :search"
                        + "or str(a.auditorRemark) like :search"
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
        }

    }
}
