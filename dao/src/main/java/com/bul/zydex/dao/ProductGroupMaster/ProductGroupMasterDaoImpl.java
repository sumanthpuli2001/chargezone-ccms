/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProductGroupMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.dao.PR.MultipleAddressDao;
import com.bul.zydex.model.ProductGroupMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bulwarks-2
 */
public class ProductGroupMasterDaoImpl<T> extends GenericsDAOImpl<T> implements ProductGroupMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return ProductGroupMaster.class;
    }

    @Override
    public List readAll() {
        String query = " Select a.id , a.productGroup , a.description ,a.Gl , b.valuationClass";
        query += " FROM ProductGroupMaster a , ValuationClassMaster b "
                + " where a.variationClassId = b.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getProGroupPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
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

            String hql = " Select a.id , a.productGroup , a.description ,a.Gl , b.valuationClass"
                    + " FROM ProductGroupMaster a , ValuationClassMaster b "
                    + " where a.variationClassId = b.id";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and ("
                        + "lower(a.productGroup) like :search "
                        + "or lower(a.description) like :search "
                        + "or lower(a.Gl) like :search "
                        + "or lower(b.valuationClass) like :search"
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
    public int getTotalProGroupCount() {
        Session session = getSessionFactory().openSession();

        try {

            Long count = (Long) session.createQuery(
                    "select count(a.id) "
                    + "from ProductGroupMaster a"
            ).uniqueResult();

            return count.intValue();

        } finally {
            session.close();
        }
    }

    @Override
    public int getFilteredProGroupCount(String search) {
        Session session = getSessionFactory().openSession();

        try {

            String hql = "select count(a.id) "
                    + " FROM ProductGroupMaster a , ValuationClassMaster b "
                    + " where a.variationClassId = b.id";

            if (search != null && !search.trim().equals("")) {
                hql += " and ("
                        + "lower(a.productGroup) like :search "
                        + "or lower(a.description) like :search "
                        + "or lower(a.Gl) like :search "
                        + "or lower(b.valuationClass) like :search"
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
