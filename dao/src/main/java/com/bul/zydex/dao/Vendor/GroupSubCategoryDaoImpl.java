/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.GroupSubCategory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class GroupSubCategoryDaoImpl<T> extends GenericsDAOImpl<T> implements GroupSubCategoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return GroupSubCategory.class;
    }

    @Override
    public List readAll() {
        String query = "select a.id, b.groupName, c.groupCatogryName, a.subCategoryName, "
                + "a.hr, a.hsc, a.it, a.technical, a.riskCategory "
                + "FROM GroupSubCategory a, GroupCategory c, GroupMaster b "
                + "WHERE a.groupMasterId = b.id "
                + "and a.groupCategoryId = c.id";
        return getHibernateTemplate().find(query);

    }

    @Override
    public GroupSubCategory readByIds(int id) {
        GroupSubCategory groupSubCategory = new GroupSubCategory();
        String query = "";
        query += " FROM GroupSubCategory a"
                + " WHERE a.id =" + id;
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            groupSubCategory = (GroupSubCategory) list.get(0);
        }
        return groupSubCategory;
    }

    @Override
    public List readByGroupMasterId(int id) {
        String query = "select a";
        query += " FROM GroupSubCategory a"
                + " WHERE a.groupCategoryId =" + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByCategoryId(int id) {
        String query = "select a";
        query += " FROM GroupSubCategory a"
                + " WHERE a.groupCategoryId =" + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getGroupSubCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {

            String hql = "select a.id, b.groupName, c.groupCatogryName, a.subCategoryName, "
                    + "a.hr, a.hsc, a.it, a.technical, a.riskCategory "
                    + "FROM GroupSubCategory a, GroupCategory c, GroupMaster b "
                    + "WHERE a.groupMasterId = b.id "
                    + "and a.groupCategoryId = c.id";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.subCategoryName) LIKE :searchValue "
                        + " OR lower(b.groupName) LIKE :searchValue "
                        + " OR lower(c.groupCatogryName) LIKE :searchValue "
                        + " OR lower(a.hr) LIKE :searchValue "
                        + " OR lower(a.hsc) LIKE :searchValue "
                        + " OR lower(a.it) LIKE :searchValue "
                        + " OR lower(a.technical) LIKE :searchValue "
                        + " OR lower(a.riskCategory) LIKE :searchValue "
                        + ")";

            }

            hql += " order by " + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
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
    public int getTotalGroupSubCategoryCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from GroupSubCategory a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredGroupSubCategoryCount(String searchValue) {
        Session session = getSessionFactory().openSession();

        try {
           String hql = "select COUNT(a.id) "
                    + "FROM GroupSubCategory a, GroupCategory c, GroupMaster b "
                    + "WHERE a.groupMasterId = b.id "
                    + "and a.groupCategoryId = c.id";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.subCategoryName) LIKE :searchValue "
                        + " OR lower(b.groupName) LIKE :searchValue "
                        + " OR lower(c.groupCatogryName) LIKE :searchValue "
                        + " OR lower(a.hr) LIKE :searchValue "
                        + " OR lower(a.hsc) LIKE :searchValue "
                        + " OR lower(a.it) LIKE :searchValue "
                        + " OR lower(a.technical) LIKE :searchValue "
                        + " OR lower(a.riskCategory) LIKE :searchValue "
                        + ")";

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
