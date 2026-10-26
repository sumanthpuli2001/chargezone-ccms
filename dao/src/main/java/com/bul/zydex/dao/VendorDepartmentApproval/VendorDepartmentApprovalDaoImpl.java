/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorDepartmentApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorDepartmentApproval;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bulwarks-2
 */
public class VendorDepartmentApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements VendorDepartmentApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorDepartmentApproval.class;
    }

    @Override
    public List readByAll() {
        String query = "select a.id,a.approvalName , c.departmentName , c.id";
        query += " FROM VendorDepartmentApproval a,DepartmentMaster c"
                + " WHERE a.departmentId =c.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readFinancialApproval() {
        String query = "select a";
        query += " FROM VendorDepartmentApproval a"
                + " WHERE a.approvalName ='Financial Approval'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readTehnicalApproval() {
        String query = "select a";
        query += " FROM VendorDepartmentApproval a"
                + " WHERE a.approvalName ='Technical Approval'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readHrApproval() {
        String query = "select a";
        query += " FROM VendorDepartmentApproval a"
                + " WHERE a.approvalName ='HR Approval'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readSafetyApproval() {
        String query = "select a";
        query += " FROM VendorDepartmentApproval a"
                + " WHERE a.approvalName ='Safety Approval'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readITApproval() {
        String query = "select a";
        query += " FROM VendorDepartmentApproval a"
                + " WHERE a.approvalName ='IT Approval'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getVenDeptPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
 Session session = getSessionFactory().openSession();
        try {

            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "departmentId";
            }

            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc")
                    && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = "from VendorDepartmentApproval a where 1 = 1 ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " and ("
                        + "lower(a.departmentId) like :search "
                        + "or str(a.approvalName) like :search"
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
            session.close();    } }

    @Override
    public int getTotalVenDeptCount() {
Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from VendorDepartmentApproval a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();    }

    @Override
    public int getFilteredVenDeptCount(String search) {
Session session = getSessionFactory().openSession();

    try {

        String hql = "select count(*) "
                + "from VendorDepartmentApproval a "
                + "where 1 = 1";

        if (search != null && !search.trim().isEmpty()) {

            hql += " and ("
                    + "lower(a.departmentId) like :search "
                    + "or str(a.approvalName) like :search"
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
 


   
       


        


