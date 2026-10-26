/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ChargerMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ChargerMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class ChargerMasterDaoImpl<T> extends GenericsDAOImpl<T> implements ChargerMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return ChargerMaster.class;
    }

    @Override
    public List getChargerMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "chargerMaster";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "asc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "asc";
            }

            String hql = "from ChargerMaster a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and lower(a.chargerMaster)"
                        + " like :search";
            }

            hql += " order by a."
                    + orderColumn
                    + " "
                    + orderDir;

            System.out.println("HQL : " + hql);
            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
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
    public int getTotalChargerMasterCount() {

        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from ChargerMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public int getFilteredChargerMasterCount(String searchValue) {

        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(*) "
                    + "from ChargerMaster a "
                    + "where 1 = 1";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " and lower(a.chargerMaster) like :search";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
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
