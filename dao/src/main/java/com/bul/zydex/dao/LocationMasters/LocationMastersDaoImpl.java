/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.LocationMasters;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LocationMasters;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class LocationMastersDaoImpl<T> extends GenericsDAOImpl<T> implements LocationMastersDao<T> {

    @Override
    protected Class getDomainClass() {
        return LocationMasters.class;
    }

    @Override
    public List readByPlantCode(String plantCode) {
        String query = "";
        query += " FROM LocationMasters a"
                + " WHERE a.plantCode = '" + plantCode + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getLocationMastersPagination(int start, int length, String search, String orderColumn, String orderDir) {
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

            String hql = "from LocationMasters a where 1 = 1 ";

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.companyCode) LIKE :search "
                        + " OR lower(a.plantCode) LIKE :search "
                        + " OR lower(a.loactionCode) LIKE :search "
                        + " OR lower(a.loactionName) LIKE :search "
                        + " OR lower(a.address) LIKE :search "
                        + ")";
            }

            hql += " order by a."
                    + orderColumn
                    + " "
                    + orderDir;

            System.out.println("HQL : " + hql);
            Query query = session.createQuery(hql);

            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
    public int getTotalLocationMastersCount() {
        Session session = getSessionFactory().openSession();
        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from LocationMasters a "
                + "where 1=1"
        ).uniqueResult();

        session.close();
        return count.intValue();
    }

    @Override
    public int getFilteredLocationMastersCount(String search) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(a.id) "
                    + "from LocationMasters a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {
                hql += " AND ("
                        + " lower(a.companyCode) LIKE :search "
                        + " OR lower(a.plantCode) LIKE :search "
                        + " OR lower(a.loactionCode) LIKE :search "
                        + " OR lower(a.loactionName) LIKE :search "
                        + " OR lower(a.address) LIKE :search "
                        + ")";

            }

            Query query = session.createQuery(hql);
            if (search != null && !search.trim().isEmpty()) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
