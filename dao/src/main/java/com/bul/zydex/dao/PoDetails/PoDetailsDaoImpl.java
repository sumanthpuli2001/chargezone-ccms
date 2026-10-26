/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PoDetails;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PoDetails;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class PoDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements PoDetailsDao<T> {

    @Override
    protected Class getDomainClass() {

        return PoDetails.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = " "
                + " from PoDetails a "
                + " where  a.tenderNo = '" + refNo + "'";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List getPoDetailsPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username) {
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

            String hql = " Select a "
                    + " FROM PoDetails a "
                    + " where  a.vendorCode = '" + username + "'";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " and lower(a.poNo) like :search"
                        + " or lower(a.tenderNo) like :search "
                        + "  "
                        + " or lower(a.poDate) like :search "
                        + " or lower(a.poValue) like :search "
                        + " or lower(a.noDocumentAttached) like :search "
                        + " or lower(a.status) like :search";
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
    public int getTotalPoDetailsCount(String username) {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from PoDetails a "
                + "where  a.vendorCode = '" + username + "'"
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredPoDetailsCount(String searchValue, String username) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(*) "
                    + "from PoDetails a "
                    + " where  a.vendorCode = '" + username + "'";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " and lower(a.poNo) like :search"
                        + " or lower(a.tenderNo) like :search "
                        + "  "
                        + " or lower(a.poDate) like :search "
                        + " or lower(a.poValue) like :search "
                        + " or lower(a.noDocumentAttached) like :search "
                        + " or lower(a.status) like :search";
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

    @Override
    public List readByGrnExecutive(String username) {
        String query = "select b.poNumber, a.tenderNo, a.poDate, a.poValue, "
                + "a.vendorName, a.noDocumentAttached, a.status, "
                + "b.status, b.grnFlag, a.vendorCode, a.id "
                + "from PoDetails a, InvoiceMaster b, UserRights c "
                + "where a.poNo = b.poNumber "
                + "and a.tenderNo = b.tenderNo "
                + " and a.id=b.poId"
                + " and c.grnExecutive = 1 "
                + "and c.username = ? "
                + "and (b.buyerStatus = 1 or b.grnFlag = 1 or b.grnFlag=3)";

        List list = getHibernateTemplate().find(query, username);

        return list;
    }

    @Override
    public List readByfinancailExecutive(String username) {
        String query = "select a.poNo, a.tenderNo, a.poDate, a.poValue, "
                + "a.vendorName, a.noDocumentAttached, a.status, "
                + "b.status, b.grnFlag, a.vendorCode, a.id ,b.financialFlag "
                + "from PoDetails a, InvoiceMaster b, UserRights c "
                + " where a.poNo = b.poNumber "
                + " and a.tenderNo = b.tenderNo "
                + " and a.id=b.poId"
                + " and c.grnExecutive = 1 "
                + " and c.financialApproval=1"
                + "and c.username = ? "
                + "and (b.buyerStatus = 1 or b.grnFlag = 1 or b.financialFlag=1 or b.financialFlag=3)";

        List list = getHibernateTemplate().find(query, username);

        return list;
    }

}
