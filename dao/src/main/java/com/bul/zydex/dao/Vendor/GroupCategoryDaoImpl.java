/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class GroupCategoryDaoImpl<T> extends GenericsDAOImpl<T> implements GroupCategoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return GroupCategory.class;
    }

    @Override
    public List readAll() {
        String query = "select a.id,b.groupName,a.groupCatogryName";
        query += " FROM GroupCategory a, GroupMaster b"
                + " WHERE a.groupMasterId =b.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public GroupCategory readByIds(int id) {
        GroupCategory groupCategory = new GroupCategory();
        String query = "";
        query += " FROM GroupCategory a"
                + " WHERE a.id =" + id;
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            groupCategory = (GroupCategory) list.get(0);
        }
        return groupCategory;
    }

    @Override
    public List readByGroupMasterId(int groupMasterId) {
        String query = "select a";
        query += " FROM GroupCategory a"
                + " WHERE a.groupMasterId =" + groupMasterId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getGroupCategoryPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {

            String hql = "select a.id, b.groupName, a.groupCatogryName "
                    + " FROM GroupCategory a, GroupMaster b "
                    + "  WHERE a.groupMasterId = b.id ";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.groupCatogryName) LIKE :searchValue "
                        + " OR lower(b.groupName) LIKE :searchValue "
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
    public int getTotalGroupCategoryCount() {

        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from GroupCategory a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredGroupCategoryCount(String searchValue) {

        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(a.id) "
                    + " FROM GroupCategory a, GroupMaster b "
                    + "  WHERE a.groupMasterId = b.id ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                hql += " AND ("
                        + " lower(a.groupCatogryName) LIKE :searchValue "
                        + " OR lower(b.groupName) LIKE :searchValue "
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
