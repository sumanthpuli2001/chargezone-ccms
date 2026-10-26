/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorCriteriaMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorCriteriaMaster;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.mapping.Set;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterDaoImpl<T> extends GenericsDAOImpl<T> implements VendorCriteriaMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorCriteriaMaster.class;
    }

    @Override
    public List readByAll(int vendorInvtId, String groupId, String groupCategoryId, String groupSubCategoryId, String departCategory) {

        String query
                = "select v.id, c.groupName, b.criteriaName, b.criteriaDescription, "
                + "b.mandatory, b.compulsaryFlag, d.groupCatogryName, e.subCategoryName, a.id, b.id "
                + "from VendorInvitationCategory v, VendorCriteriaMaster a, VendorCriteriaMasterDetails b, "
                + "GroupMaster c, GroupCategory d, GroupSubCategory e "
                + "where v.vendorId = " + vendorInvtId + " "
                + "and v.groupId = a.groupMasterId "
                + "and v.groupCategoryId = a.groupCategoryId "
                + "and v.groupSubCategoryId = a.groupSubCategoryId "
                + "and a.id = b.vendorCriteriaMasterId "
                + "and v.groupId = c.id "
                + "and v.groupCategoryId = d.id "
                + "and v.groupSubCategoryId = e.id "
                + "and a.departmentCategory = '" + departCategory + "' "
                + "order by c.groupName, d.groupCatogryName, e.subCategoryName, b.id";

        List originalList = getHibernateTemplate().find(query);

        ArrayList finalList = new ArrayList();
        java.util.HashSet uniqueSet = new java.util.HashSet();

        for (int i = 0; i < originalList.size(); i++) {

            Object[] row = (Object[]) originalList.get(i);

            String groupName = row[1] == null ? "" : row[1].toString();
            String categoryName = row[6] == null ? "" : row[6].toString();
            String subCategoryName = row[7] == null ? "" : row[7].toString();
            String criteriaName = row[2] == null ? "" : row[2].toString();
            String criteriaDesc = row[3] == null ? "" : row[3].toString();

            String key = groupName + "|" + categoryName + "|" + subCategoryName + "|" + criteriaName + "|" + criteriaDesc;

            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                finalList.add(row);
            }
        }

        return finalList;

    }

    @Override
    public List readByFirstTwo(int vendorInvtId, String groupId, String groupCategoryId, String departCategory) {

        String hql
                = "select v.id, "
                + "c.groupName, "
                + "b.criteriaName, "
                + "b.criteriaDescription, "
                + "b.mandatory, "
                + "b.compulsaryFlag, "
                + "d.groupCatogryName, "
                + "0, "
                + "a.id, "
                + "b.id "
                + "from VendorInvitationCategory v, "
                + "VendorCriteriaMaster a, "
                + "VendorCriteriaMasterDetails b, "
                + "GroupMaster c, "
                + "GroupCategory d "
                + "where v.vendorId = " + vendorInvtId + " "
                + "and v.groupId = a.groupMasterId "
                + "and v.groupCategoryId = a.groupCategoryId "
                + "and a.groupSubCategoryId = 0 "
                + "and a.id = b.vendorCriteriaMasterId "
                + "and v.groupId = c.id "
                + "and v.groupCategoryId = d.id "
                + "and a.departmentCategory = '" + departCategory + "' "
                + "order by c.groupName, d.groupCatogryName, b.id";

        List originalList = getHibernateTemplate().find(hql);

        ArrayList finalList = new ArrayList();
        java.util.HashSet uniqueSet = new java.util.HashSet();

        for (int i = 0; i < originalList.size(); i++) {

            Object[] row = (Object[]) originalList.get(i);

            String groupName = row[1] == null ? "" : row[1].toString();
            String categoryName = row[6] == null ? "" : row[6].toString();
            String criteriaName = row[2] == null ? "" : row[2].toString();
            String criteriaDesc = row[3] == null ? "" : row[3].toString();

            String key = groupName + "|" + categoryName + "|" + criteriaName + "|" + criteriaDesc;

            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                finalList.add(row);
            }
        }

        return finalList;

    }

    @Override
    public List readByFirstOne(int vendorInvtId, String groupId, String departCategory) {

        String query
                = "select v.id, c.groupName, b.criteriaName, b.criteriaDescription, "
                + "b.mandatory, b.compulsaryFlag, 0, 0, a.id "
                + "from VendorInvitationCategory v, VendorCriteriaMaster a, VendorCriteriaMasterDetails b, GroupMaster c "
                + "where v.vendorId = " + vendorInvtId + " "
                + "and v.groupId = a.groupMasterId "
                + "and a.groupCategoryId = 0 "
                + "and a.groupSubCategoryId = 0 "
                + "and a.id = b.vendorCriteriaMasterId "
                + "and v.groupId = c.id "
                + "and a.departmentCategory = '" + departCategory + "' "
                + "order by c.groupName, b.id";

        List originalList = getHibernateTemplate().find(query);

        ArrayList finalList = new ArrayList();
        HashSet uniqueSet = new HashSet();

        for (int i = 0; i < originalList.size(); i++) {

            Object[] row = (Object[]) originalList.get(i);

            String groupName = row[1] == null ? "" : row[1].toString();
            String criteriaName = row[2] == null ? "" : row[2].toString();
            String criteriaDesc = row[3] == null ? "" : row[3].toString();

            String key = groupName + "|" + criteriaName + "|" + criteriaDesc;

            if (!uniqueSet.contains(key)) {
                uniqueSet.add(key);
                finalList.add(row);
            }
        }

        return finalList;
    }

    @Override
    public List getVendorCriteriaPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ")
                    .append(" a.id, b.group_name, c.group_category_name, d.sub_category_name, a.department_category  ")
                    .append("FROM vendor_criteria_master a ")
                    .append("LEFT JOIN group_master b ON a.group_master_id = b.id ")
                    .append("LEFT JOIN group_category c ON a.group_category_id = c.id ")
                    .append("LEFT JOIN group_sub_category d ON a.group_sub_category_id = d.id ")
                    .append("WHERE 1=1 ");

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" AND (")
                        .append("LOWER(a.department_category) LIKE :searchValue ")
                        .append("OR LOWER(b.group_name) LIKE :searchValue ")
                        .append("OR LOWER(c.group_category_name) LIKE :searchValue ")
                        .append("OR LOWER(d.sub_category_name) LIKE :searchValue ")
                        .append(")");
            }

            sql.append(" ORDER BY ")
                    .append(orderColumn)
                    .append(" ")
                    .append(orderDir);

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            List list = query.list();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public int getTotalVendorCriteriaCount() {

        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from VendorCriteriaMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public int getFilteredVendorCriteriaCount(String searchValue) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT COUNT(a.id) ")
                    .append("FROM vendor_criteria_master a ")
                    .append("LEFT JOIN group_master b ON a.group_master_id = b.id ")
                    .append("LEFT JOIN group_category c ON a.group_category_id = c.id ")
                    .append("LEFT JOIN group_sub_category d ON a.group_sub_category_id = d.id ")
                    .append("WHERE 1=1 ");

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" AND (")
                        .append("LOWER(a.department_category) LIKE :searchValue ")
                        .append("OR LOWER(b.group_name) LIKE :searchValue ")
                        .append("OR LOWER(c.group_category_name) LIKE :searchValue ")
                        .append("OR LOWER(d.sub_category_name) LIKE :searchValue ")
                        .append(")");
            }

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Number count = (Number) query.uniqueResult();
            return count.intValue();

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            session.close();
        }

    }

}
