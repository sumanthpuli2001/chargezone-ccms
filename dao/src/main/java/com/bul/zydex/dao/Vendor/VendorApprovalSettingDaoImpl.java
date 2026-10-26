/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorApprovalSetting;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bulwarks-2
 */
public class VendorApprovalSettingDaoImpl<T> extends GenericsDAOImpl<T> implements VendorApprovalSettingDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorApprovalSetting.class;
    }

    @Override
    public List getVendorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "approvalName";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "asc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "asc";
            }

            String hql = "from VendorApprovalSetting a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and lower(a.approvalName)"
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
        }    }      

    @Override
    public int getTotalVendorCount() {
 Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from VendorApprovalSetting a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();    }    

    @Override
    public int getFilteredVendorCount(String search) {
Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(*) "
                    + "from VendorApprovalSetting a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {
                hql += " and lower(a.approvalName) like :search";
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
        }    }    }


