/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffForm;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KickOffForm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class KickOffFormDaoImpl<T> extends GenericsDAOImpl<T> implements KickOffFormDao<T> {

    @Override
    protected Class getDomainClass() {

        return KickOffForm.class;
    }

    @Override
    public List readbyApprove(String username) {

        String query = "";
        query += " FROM KickOffForm a"
                + " WHERE a.userId = '" + username + "'"
                + " order by a.id desc";
//		+ " and a.flagStatus=1";
        return getHibernateTemplate().find(query);

    }

    @Override
    public KickOffForm readByaocId(String id) {
        String query = "";
        KickOffForm kickOffForm = new KickOffForm();
        query += " FROM KickOffForm a"
                + " WHERE a.aocForm = '" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kickOffForm = (KickOffForm) list.get(0);
        }
        return kickOffForm;
    }

    @Override
    public KickOffForm readByaocIds(int aocformid) {
        String query = "";
        KickOffForm kickOffForm = new KickOffForm();
        query += " FROM KickOffForm a"
                + " WHERE a.aocForm = '" + aocformid + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kickOffForm = (KickOffForm) list.get(0);
        }
        return kickOffForm;
    }

    @Override
    public List readDeliverableList(String username) {
        String query = "SELECT a.id,a.documentNo,a.aocForm.hubDepoName,a.userId,a.designation,a.flagStatus,a.aocForm.id";

        query += " FROM KickOffForm a,DeliverableMulti b"
                + " WHERE a.userId = '" + username + "'"
                + " and b.flagStatus=5 "
                + " and a.aocForm.id=b.aocId"
                + " Group by b.aocId"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByFlagoneDashBoard() {
        String query = "";
        query += " FROM KickOffForm a"
                + " WHERE a.flagStatus IN (1,4)";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByFlagThreeDashBoard() {

        String query = "";
        query += " FROM KickOffForm a"
                + " WHERE a.flagStatus IN (3)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByPendingKom() {

        String query = "";
        query += " FROM KickOffForm a"
                + " WHERE a.flagStatus NOT IN (1,4,3)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getusernamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList<>();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubLocation, a.projectName, a.designation, a.dateTime,a.flagStatus, a.aocForm.id "
                    + "FROM KickOffForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (5, 6, 7) ";

            boolean hasSearch = searchValue != null && !searchValue.trim().isEmpty();
            if (hasSearch) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.hubLocation)     LIKE :search "
                        + "OR lower(a.projectName)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR lower(a.dateTime) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            Set<String> allowedColumns = new HashSet<>(Arrays.asList(
                    "id", "documentNo", "hubLocation", "projectName", "designation", "dateTime", "flagStatus", "aocForm.id"
            ));
            String safeOrderColumn = (orderColumn != null && allowedColumns.contains(orderColumn.trim()))
                    ? orderColumn.trim()
                    : "id";
            String safeOrderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "desc";

            hql += " ORDER BY a." + safeOrderColumn + " " + safeOrderDir;

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (hasSearch) {
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
    public int getTotalusernameCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (5, 6, 7) ";

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
    public int getFilteredusernameCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (5, 6, 7) ";

            boolean hasSearch = searchValue != null && !searchValue.trim().isEmpty();
            if (hasSearch) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.hubLocation)     LIKE :search "
                        + "OR lower(a.projectName)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR lower(a.dateTime) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (hasSearch) {
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
    public List getkomDeliverableViewPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.aocForm.hubDepoName, a.userId, a.designation, a.flagStatus, a.aocForm.id "
                    + "FROM KickOffForm a, DeliverableMulti b "
                    + "WHERE a.userId = :username "
                    + "AND b.flagStatus = 5 "
                    + "AND a.aocForm.id = b.aocId ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)            LIKE :search "
                        + "OR lower(a.aocForm.hubDepoName)  LIKE :search "
                        + "OR lower(a.userId)               LIKE :search "
                        + "OR lower(a.designation)          LIKE :search "
                        + ") ";
            }

            hql += "GROUP BY b.aocId ";
            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
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
    public int getTotalkomDeliverableViewCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(DISTINCT a.id) "
                    + "FROM KickOffForm a, DeliverableMulti b "
                    + "WHERE a.userId = :username "
                    + "AND b.flagStatus = 5 "
                    + "AND a.aocForm.id = b.aocId ";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredkomDeliverableViewCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(DISTINCT a.id) "
                    + "FROM KickOffForm a, DeliverableMulti b "
                    + "WHERE a.userId = :username "
                    + "AND b.flagStatus = 5 "
                    + "AND a.aocForm.id = b.aocId ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)            LIKE :search "
                        + "OR lower(a.aocForm.hubDepoName)  LIKE :search "
                        + "OR lower(a.userId)               LIKE :search "
                        + "OR lower(a.designation)          LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int countAllKom() {
        String query = "SELECT COUNT(*) FROM KickOffForm a ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int countAllKomDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM KickOffForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))";
            } else {
                query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List getTotalKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubLocation, a.projectName, a.designation,a.dateTime, a.flagStatus "
                    + "FROM KickOffForm a "
                    + "WHERE 1=1 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR lower(a.dateTime) LIKE :search "
                        + " OR (a.flagStatus = 0 AND 'pending to approve' LIKE :search) "
                        + " OR (a.flagStatus = 1 AND 'approved' LIKE :search) "
                        + " OR (a.flagStatus = 2 AND 'recycle' LIKE :search) "
                        + " OR (a.flagStatus = 3 AND 'reject' LIKE :search) "
                        + " OR (a.flagStatus = 4 AND 'approved' LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

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
    public int getTotalKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE 1=1 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredTotalKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE 1=1 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR lower(a.dateTime) LIKE :search "
                        + " OR (a.flagStatus = 0 AND 'pending to approve' LIKE :search) "
                        + " OR (a.flagStatus = 1 AND 'approved' LIKE :search) "
                        + " OR (a.flagStatus = 2 AND 'recycle' LIKE :search) "
                        + " OR (a.flagStatus = 3 AND 'reject' LIKE :search) "
                        + " OR (a.flagStatus = 4 AND 'approved' LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readByFlagone() {
        String query = "SELECT COUNT(a.id)";
        query += " FROM KickOffForm a"
                + " WHERE a.flagStatus IN (1,4)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagoneDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM KickOffForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus IN (1,4) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (1,4) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (1,4) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getTotalApproveKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubLocation, a.projectName, a.designation,a.dateTime, a.flagStatus "
                    + " FROM KickOffForm a"
                    + " WHERE a.flagStatus IN (1,4)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR lower(a.dateTime) LIKE :search "
                        + " OR (a.flagStatus = 0 AND 'pending to approve' LIKE :search) "
                        + " OR (a.flagStatus = 1 AND 'approved' LIKE :search) "
                        + " OR (a.flagStatus = 2 AND 'recycle' LIKE :search) "
                        + " OR (a.flagStatus = 3 AND 'reject' LIKE :search) "
                        + " OR (a.flagStatus = 4 AND 'approved' LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

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
    public int getTotalApproveKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE a.flagStatus IN (1,4)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredTotalApproveKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE a.flagStatus IN (1,4)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR lower(a.dateTime) LIKE :search "
                        + " OR (a.flagStatus = 0 AND 'pending to approve' LIKE :search) "
                        + " OR (a.flagStatus = 1 AND 'approved' LIKE :search) "
                        + " OR (a.flagStatus = 2 AND 'recycle' LIKE :search) "
                        + " OR (a.flagStatus = 3 AND 'reject' LIKE :search) "
                        + " OR (a.flagStatus = 4 AND 'approved' LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readByPendingKOM() {

        String query = "SELECT COUNT(a.id)";
        query += " FROM KickOffForm a"
                + " WHERE a.flagStatus NOT IN (1,4,3)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByPendingKOMDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM KickOffForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus IN (1,4,3) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (1,4,3) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (1,4,3) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getPendingKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubLocation, a.projectName, a.designation,a.dateTime, a.flagStatus "
                    + " FROM KickOffForm a"
                    + " WHERE a.flagStatus NOT IN (1,4,3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR str(a.dateTime) LIKE :search "
                        + " OR (a.flagStatus NOT IN (1,4) AND 'pending' LIKE :search) "
                        + " OR (a.flagStatus IN (1,4) AND 'approved' LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

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
    public int getPendingKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE a.flagStatus IN (1,4,3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredPendingKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM KickOffForm a "
                    + "WHERE a.flagStatus IN (1,4,3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR str(a.dateTime) LIKE :search "
                        + " OR (a.flagStatus NOT IN (1,4) AND 'pending' LIKE :search) "
                        + " OR (a.flagStatus IN (1,4) AND 'approved' LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readByFlagThree() {
        String query = "SELECT COUNT(a.id)";
        query += " FROM KickOffForm a"
                + " WHERE a.flagStatus IN (3)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagThreeDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM KickOffForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus IN (3) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (3) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (3) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getRejectedKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubLocation, a.projectName, a.designation,a.dateTime, a.flagStatus "
                    + " FROM KickOffForm a"
                    + " WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR str(a.dateTime) LIKE :search "
                        + " OR 'reject' LIKE :search "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

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
    public int getRejectedKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM KickOffForm a"
                    + " WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredRejectedKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM KickOffForm a"
                    + " WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.aocForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.hubLocation) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR str(a.dateTime) LIKE :search "
                        + " OR 'reject' LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

}
