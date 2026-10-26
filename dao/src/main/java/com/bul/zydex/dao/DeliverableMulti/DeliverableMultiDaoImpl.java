package com.bul.zydex.dao.DeliverableMulti;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DeliverableMulti;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sumanth
 */
public class DeliverableMultiDaoImpl<T> extends GenericsDAOImpl<T> implements DeliverableMultiDao<T> {

    @Override
    protected Class getDomainClass() {
        return DeliverableMulti.class;
    }

    @Override
    public List readByDeliveryId(String id) {
        String query = "";
        query += " FROM DeliverableMulti a"
                + " WHERE a.deliverableId = '" + id + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readBydesignCoordinator(String username) {
        String query = "SELECT a.id, a.description, a.designCoordinator, a.flagStatus, b.flagStatus,c.flagStatus,b.id,c.id, "
                + "CASE "
                + "WHEN a.oapId != 0 AND b.id IS NOT NULL THEN b.documentNo "
                + "WHEN a.aocId != 0 AND c.id IS NOT NULL THEN c.documentNo "
                + "ELSE NULL END AS documentNo, "
                + "a.aocId, a.oapId "
                + "FROM DeliverableMulti a, OapForm b, AocForm c "
                + "WHERE a.designCoordinator = '" + username + "' "
                + "AND (a.oapId = b.id OR a.aocId = c.id) "
                + "GROUP BY a.id"
                + " order by a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDesignAssign(String username) {

        String query = "SELECT a.id, a.description, a.designCoordinator, a.flagStatus,b.id,c.id,b.flagStatus,c.flagStatus, "
                + "CASE "
                + "WHEN a.oapId != 0 AND b.id IS NOT NULL THEN b.documentNo "
                + "WHEN a.aocId != 0 AND c.id IS NOT NULL THEN c.documentNo "
                + "ELSE NULL END AS documentNo, "
                + "a.aocId, a.oapId "
                + "FROM DeliverableMulti a, OapForm b, AocForm c "
                + "WHERE a.designAssign = '" + username + "' "
                + "AND (a.oapId = b.id OR a.aocId = c.id) "
                + "AND a.flagStatus = 4 "
                + "GROUP BY a.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByAocId(String aocid) {
        String query = "";
        query += " FROM DeliverableMulti a"
                + " WHERE a.aocId = '" + aocid + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByOapid(String oapid) {
        String query = "";
        query += " FROM DeliverableMulti a"
                + " WHERE a.oapId = '" + oapid + "'";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByDeliveryId(int deliverableid) {
        String query = "";
        query += " FROM DeliverableMulti a"
                + " WHERE a.deliverableId = '" + deliverableid + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByoapid(int oapformid) {
        String query = "";
        query += " FROM DeliverableMulti a,IteamDetailsAttachments b"
                + " WHERE a.oapId = '" + oapformid + "'"
                + " AND a.id = b.deliverableMultiId"
                + " AND a.flagStatus=5"
                + " GROUP BY b.deliverableMultiId";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByaocId(int aocformid) {
        String query = "";
        query += " FROM DeliverableMulti a,IteamDetailsAttachments b"
                + " WHERE a.aocId = '" + aocformid + "'"
                + " AND a.id = b.deliverableMultiId"
                + " AND a.flagStatus=5"
                + " GROUP BY b.deliverableMultiId";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByoapidflag(int oapformid) {
        String query = "";
        query += " FROM DeliverableMulti a "
                + " WHERE a.oapId = '" + oapformid + "'"
                + "And a.flagStatus=5";

        return getHibernateTemplate().find(query);
    }

    @Override
    public int countAllDesignCoorOap() {
        String query = "SELECT COUNT(*)";
        query += " FROM DeliverableMulti a"
                + " WHERE a.oapId != 0";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByFlagOneOap() {
        String query = "SELECT COUNT(*)";
        query += " FROM DeliverableMulti a"
                + " WHERE a.oapId != 0"
                + " AND a.flagStatus=1";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int countAllDesignCoorAoc() {
        String query = "SELECT COUNT(*)";
        query += " FROM DeliverableMulti a"
                + " WHERE a.aocId != 0";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagOneAoc() {
        String query = "SELECT COUNT(*)";
        query += " FROM DeliverableMulti a"
                + " WHERE a.aocId != 0"
                + " AND a.flagStatus=1";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int countAllDesignCoorOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from DeliverableMulti a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.oapId != 0";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.oapId != 0";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.oapId != 0";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByFlagOneOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from DeliverableMulti a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.oapId != 0"
                    + " AND a.flagStatus=1";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.oapId != 0"
                        + " AND a.flagStatus=1";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.oapId != 0"
                        + " AND a.flagStatus=1";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int countAllDesignCoorAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from DeliverableMulti a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.aocId != 0";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.aocId != 0";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.aocId != 0";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByFlagOneAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a) from DeliverableMulti a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.aocId != 0"
                    + " AND a.flagStatus=1";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.aocId != 0"
                        + " AND a.flagStatus=1";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.aocId != 0"
                        + " AND a.flagStatus=1";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List readByOapIdAndZeroFlag(int oapformid) {
        String query = "";
        query += " FROM DeliverableMulti a "
                + " WHERE a.oapId = '" + oapformid + "'"
                + " And a.flagStatus=0";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByAocIdAndZeroFlag(int aocFormid) {

        String query = "";
        query += " FROM DeliverableMulti a "
                + " WHERE a.aocId = '" + aocFormid + "'"
                + " And a.flagStatus=0";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List getDesignCoordinatorPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String sql = "SELECT a.id, a.description, a.design_coordinator, a.flag_status, "
                    + "b.flag_status, c.flag_status, b.id, c.id, "
                    + "CASE "
                    + "  WHEN a.oap_id != 0 AND b.id IS NOT NULL THEN b.document_no "
                    + "  WHEN a.aoc_id != 0 AND c.id IS NOT NULL THEN c.document_no "
                    + "  ELSE NULL END, "
                    + "a.aoc_id, a.oap_id "
                    + "FROM deliverable_multi a "
                    + "LEFT JOIN oap_form b ON a.oap_id = b.id "
                    + "LEFT JOIN aoc_form c ON a.aoc_id = c.id "
                    + "WHERE a.design_coordinator = :username "
                    + "AND a.flag_status != 6 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql += "AND ("
                        + "  lower(CASE "
                        + "    WHEN a.oap_id != 0 AND b.id IS NOT NULL THEN b.document_no "
                        + "    WHEN a.aoc_id != 0 AND c.id IS NOT NULL THEN c.document_no "
                        + "    ELSE NULL END) LIKE :search "
                        + "OR lower(a.description)          LIKE :search "
                        + "OR lower(a.design_coordinator)   LIKE :search "
                        + "OR (a.flag_status IN (0,4) AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flag_status IN (1,5) AND lower('approved')           LIKE :search) "
                        + "OR (a.flag_status = 3      AND lower('rejected')           LIKE :search) "
                        + "OR (a.flag_status = 2      AND lower('recycle')            LIKE :search) "
                        + ") ";
            }

            sql += "GROUP BY a.id, a.description, a.design_coordinator, a.flag_status, "
                    + "b.flag_status, c.flag_status, b.id, c.id, a.aoc_id, a.oap_id, "
                    + "b.document_no, c.document_no ";

            sql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            SQLQuery query = session.createSQLQuery(sql);
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
    public int getTotalDesignCoordinatorCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM deliverable_multi a "
                    + "LEFT JOIN oap_form b ON a.oap_id = b.id "
                    + "LEFT JOIN aoc_form c ON a.aoc_id = c.id "
                    + "WHERE a.design_coordinator = :username "
                    + "AND a.flag_status != 6 ";

            SQLQuery query = session.createSQLQuery(sql);
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
    public int getFilteredDesignCoordinatorCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM deliverable_multi a "
                    + "LEFT JOIN oap_form b ON a.oap_id = b.id "
                    + "LEFT JOIN aoc_form c ON a.aoc_id = c.id "
                    + "WHERE a.design_coordinator = :username "
                    + "AND a.flag_status != 6 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql += "AND ("
                        + "  lower(CASE "
                        + "    WHEN a.oap_id != 0 AND b.id IS NOT NULL THEN b.document_no "
                        + "    WHEN a.aoc_id != 0 AND c.id IS NOT NULL THEN c.document_no "
                        + "    ELSE NULL END) LIKE :search "
                        + "OR lower(a.description)          LIKE :search "
                        + "OR lower(a.design_coordinator)   LIKE :search "
                        + "OR (a.flag_status IN (0,4) AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flag_status IN (1,5) AND lower('approved')           LIKE :search) "
                        + "OR (a.flag_status = 3      AND lower('rejected')           LIKE :search) "
                        + "OR (a.flag_status = 2      AND lower('recycle')            LIKE :search) "
                        + ") ";
            }

            SQLQuery query = session.createSQLQuery(sql);
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
    public List getDesignAssignPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String sql = "SELECT a.id, a.description, a.design_assign, a.flag_status, "
                    + "b.id, c.id, b.flag_status, c.flag_status, "
                    + "CASE "
                    + "  WHEN a.oap_id != 0 AND b.id IS NOT NULL THEN b.document_no "
                    + "  WHEN a.aoc_id != 0 AND c.id IS NOT NULL THEN c.document_no "
                    + "  ELSE NULL END, "
                    + "a.aoc_id, a.oap_id "
                    + "FROM deliverable_multi a "
                    + "LEFT JOIN oap_form b ON a.oap_id = b.id "
                    + "LEFT JOIN aoc_form c ON a.aoc_id = c.id "
                    + "WHERE a.design_assign = :username "
                    + "AND a.flag_status = 4 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql += "AND ("
                        + "  lower(CASE "
                        + "    WHEN a.oap_id != 0 AND b.id IS NOT NULL THEN b.document_no "
                        + "    WHEN a.aoc_id != 0 AND c.id IS NOT NULL THEN c.document_no "
                        + "    ELSE NULL END) LIKE :search "
                        + "OR lower(a.description)    LIKE :search "
                        + "OR lower(a.design_assign)  LIKE :search "
                        + ") ";
            }

            sql += "GROUP BY a.id, a.description, a.design_assign, a.flag_status, "
                    + "b.id, c.id, b.flag_status, c.flag_status, "
                    + "a.aoc_id, a.oap_id, b.document_no, c.document_no ";

            sql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            SQLQuery query = session.createSQLQuery(sql);
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
    public int getTotalDesignAssignCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM deliverable_multi a "
                    + "LEFT JOIN oap_form b ON a.oap_id = b.id "
                    + "LEFT JOIN aoc_form c ON a.aoc_id = c.id "
                    + "WHERE a.design_assign = :username "
                    + "AND a.flag_status = 4 ";

            SQLQuery query = session.createSQLQuery(sql);
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
    public int getFilteredDesignAssignCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM deliverable_multi a "
                    + "LEFT JOIN oap_form b ON a.oap_id = b.id "
                    + "LEFT JOIN aoc_form c ON a.aoc_id = c.id "
                    + "WHERE a.design_assign = :username "
                    + "AND a.flag_status = 4 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql += "AND ("
                        + "  lower(CASE "
                        + "    WHEN a.oap_id != 0 AND b.id IS NOT NULL THEN b.document_no "
                        + "    WHEN a.aoc_id != 0 AND c.id IS NOT NULL THEN c.document_no "
                        + "    ELSE NULL END) LIKE :search "
                        + "OR lower(a.description)    LIKE :search "
                        + "OR lower(a.design_assign)  LIKE :search "
                        + ") ";
            }

            SQLQuery query = session.createSQLQuery(sql);
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
}
