/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SiteSurvey;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SiteSurvey;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class SiteSurveyDaoImpl<T> extends GenericsDAOImpl<T> implements SiteSurveyDao<T> {

    @Override
    protected Class getDomainClass() {
        return SiteSurvey.class;

    }

    @Override
    public List readbyusername(String SiteSurvey) {
        String query = "";
        query += " FROM SiteSurvey a"
                + " WHERE a.createdBy = '" + SiteSurvey + "'"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendor(String username1) {
        String query = "";
        query += " FROM SiteSurvey a"
                + " WHERE a.vendor = '" + username1 + "'"
                + " And a.flagStatus =0 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public SiteSurvey readBySurveyNo(String id) {
        String query = "";
        SiteSurvey siteSurvey = new SiteSurvey();
        query += " FROM SiteSurvey a"
                + " WHERE a.surveyDocumentNo = '" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            siteSurvey = (SiteSurvey) list.get(0);
        }
        return siteSurvey;
    }

    @Override
    public List readSiteSurveySearch(String siteSurveyNumber, String open_from_date, String open_to_date) {

        String query = "SELECT a "
                + " FROM SiteSurvey a "
                + " WHERE 1=1"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.startDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
        }

        if (!siteSurveyNumber.equals("")) {
            query += " AND a.surveyDocumentNo='" + siteSurveyNumber + "'";
        }

// Apply ORDER BY clause
        query += " ORDER BY a.surveyDocumentNo desc, a.startDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List getSitesurveyPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {

            String hql = "FROM SiteSurvey p WHERE p.createdBy = :username ";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(p.surveyDocumentNo) LIKE :search "
                        + " OR lower(p.siteName) LIKE :search "
                        + " OR lower(p.siteAddress) LIKE :search "
                        + " OR lower(p.description) LIKE :search "
                        + " OR lower(p.startDate) LIKE :search "
                        + " OR lower(p.endDate) LIKE :search "
                        + " OR lower(p.createdBy) LIKE :search "
                        + " OR lower(p.flagStatus) LIKE :search "
                        + ")";
            }

            hql += " ORDER BY p." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            query.setParameter("username", username);

            if (searchValue != null && !searchValue.trim().equals("")) {

                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);

            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return list;

    }

    @Override
    public int getTotalSitesurveyCount(String username) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(p.id) "
                    + "FROM SiteSurvey p "
                    + "WHERE p.createdBy = :username ";

            Query query = session.createQuery(hql);

            query.setParameter("username", username);

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public int getFilteredSitesurveyCount(String username, String searchValue) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(p.id) "
                    + "FROM SiteSurvey p "
                    + "WHERE p.createdBy = :username ";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(p.surveyDocumentNo) LIKE :search "
                        + " OR lower(p.siteName) LIKE :search "
                        + " OR lower(p.siteAddress) LIKE :search "
                        + " OR lower(p.description) LIKE :search "
                        + " OR lower(p.startDate) LIKE :search "
                        + " OR lower(p.endDate) LIKE :search "
                        + " OR lower(p.createdBy) LIKE :search "
                        + " OR lower(p.flagStatus) LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);

            query.setParameter("username", username);

            if (searchValue != null && !searchValue.trim().equals("")) {

                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();

    }

    @Override
    public List getSiteSurveyReportPagination(int start, int length, String searchValue, String SiteSurveyNumber, String fromDate, String toDate, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {

            String hql = "SELECT a.id, a.surveyDocumentNo, a.siteName, a.siteAddress, a.createdBy, a.description "
                    + "FROM SiteSurvey a "
                    + "WHERE 1 = 1";

            if (SiteSurveyNumber != null && !SiteSurveyNumber.trim().equals("")) {
                hql += " AND lower(a.surveyDocumentNo) LIKE :surveyDocumentNo ";
            }

            if (fromDate != null && !fromDate.trim().equals("")
                    && toDate != null && !toDate.trim().equals("")) {

                hql += " AND STR_TO_DATE(a.startDate,'%d-%m-%Y') "
                        + " BETWEEN STR_TO_DATE(:fromDate,'%d-%m-%Y') "
                        + " AND STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            } else if (fromDate != null && !fromDate.trim().equals("")) {

                hql += " AND STR_TO_DATE(a.startDate,'%d-%m-%Y') "
                        + " >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            } else if (toDate != null && !toDate.trim().equals("")) {

                hql += " AND STR_TO_DATE(a.startDate,'%d-%m-%Y') "
                        + " <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.surveyDocumentNo) LIKE :search "
                        + " OR lower(a.siteName) LIKE :search "
                        + " OR lower(a.siteAddress) LIKE :search "
                        + " OR lower(a.createdBy) LIKE :search "
                        + " OR lower(a.description) LIKE :search "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {

                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            if (SiteSurveyNumber != null && !SiteSurveyNumber.equals("")) {
                query.setParameter("surveyDocumentNo", "%" + SiteSurveyNumber.toLowerCase() + "%");
            }

            if (fromDate != null && !fromDate.trim().equals("")) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().equals("")) {
                query.setParameter("toDate", toDate);
            }

            query.setFirstResult(start);

            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return list;
    }

    @Override
    public int getTotalSiteSurveyReportCount() {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM SiteSurvey a ";

            Query query = session.createQuery(hql);

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

    @Override
    public int getFilteredSiteSurveyReportCount(String searchValue, String SiteSurveyNumber, String fromDate, String toDate) {
        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM SiteSurvey a "
                    + "WHERE 1 = 1";

            if (SiteSurveyNumber != null && !SiteSurveyNumber.trim().equals("")) {
                hql += " AND lower(a.surveyDocumentNo) LIKE :surveyDocumentNo ";
            }

            if (fromDate != null && !fromDate.trim().equals("")
                    && toDate != null && !toDate.trim().equals("")) {

                hql += " AND STR_TO_DATE(a.startDate,'%d-%m-%Y') "
                        + " BETWEEN STR_TO_DATE(:fromDate,'%d-%m-%Y') "
                        + " AND STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            } else if (fromDate != null && !fromDate.trim().equals("")) {

                hql += " AND STR_TO_DATE(a.startDate,'%d-%m-%Y') "
                        + " >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            } else if (toDate != null && !toDate.trim().equals("")) {

                hql += " AND STR_TO_DATE(a.startDate,'%d-%m-%Y') "
                        + " <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.surveyDocumentNo) LIKE :search "
                        + " OR lower(a.siteName) LIKE :search "
                        + " OR lower(a.siteAddress) LIKE :search "
                        + " OR lower(a.createdBy) LIKE :search "
                        + " OR lower(a.description) LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {

                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            if (SiteSurveyNumber != null && !SiteSurveyNumber.equals("")) {
                query.setParameter("surveyDocumentNo", "%" + SiteSurveyNumber.toLowerCase() + "%");
            }

            if (fromDate != null && !fromDate.trim().equals("")) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().equals("")) {
                query.setParameter("toDate", toDate);
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();
        }

        return count.intValue();
    }

}
