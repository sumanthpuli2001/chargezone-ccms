/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcForm;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CrcForm;
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
public class CrcFormDaoImpl<T> extends GenericsDAOImpl<T> implements CrcFormDao<T> {

    @Override
    protected Class getDomainClass() {
        return CrcForm.class;
    }

    @Override
    public List readByusername(String username) {
        String query = "SELECT a.id,a.documentNo,a.pcsName,a.userid,a.designation,a.flagStatus,a.oapForm.id";

        query += " FROM CrcForm a"
                + " WHERE a.userid = '" + username + "'"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public CrcForm readByoapId(String id) {
        String query = "";
        CrcForm crcForm = new CrcForm();
        query += " FROM CrcForm a"
                + " WHERE a.oapForm = '" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcForm = (CrcForm) list.get(0);
        }
        return crcForm;

    }

    @Override
    public List readByoapid(String id) {
        String query = "";

        query += " FROM CrcForm a"
                + " WHERE a.oapForm = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List ApprovalStatus() {
        String query = "";
        query += " FROM CrcForm a"
                + " WHERE a.flagStatus =1";
        return getHibernateTemplate().find(query);
    }

    @Override
    public CrcForm readByoapIds(int oapformid) {
        String query = "";
        CrcForm crcForm = new CrcForm();
        query += " FROM CrcForm a"
                + " WHERE a.oapForm = '" + oapformid + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcForm = (CrcForm) list.get(0);
        }
        return crcForm;

    }

    @Override
    public List readDeliverableList(String username) {
        String query = "SELECT a.id,a.documentNo,a.pcsName,a.userid,a.designation,a.flagStatus,a.oapForm.id";

        query += " FROM CrcForm a,DeliverableMulti b"
                + " WHERE a.userid = '" + username + "'"
                + " and b.flagStatus=5 "
                + " and a.oapForm.id=b.oapId"
                + " Group by b.oapId"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByFlagTwoDashBoard() {

        String query = "";
        query += " FROM CrcForm a"
                + " WHERE a.flagStatus IN (2,800)";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByFlagThreeDashBoard() {

        String query = "";
        query += " FROM CrcForm a"
                + " WHERE a.flagStatus IN (3)";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByPendingCRC() {

        String query = "FROM CrcForm a "
                + "WHERE a.flagStatus NOT IN (1,4,3,2,800)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByrevisionCrcDashBorad() {

        String query = "FROM CrcForm a, CrcFormHistory b "
                + "WHERE b.crcId = a.id "
                + "AND a.flagStatus IN (2, 800) ";

        return getHibernateTemplate().find(query);
    }

    @Override
    public CrcForm readByoapdDocumentNo(String oapDocumentNo) {
        CrcForm crcForm = new CrcForm();

        String query = "";
        query += " FROM CrcForm a"
                + " WHERE a.oapNumber =  '" + oapDocumentNo + "'";

        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            crcForm = (CrcForm) list.get(0);

        }
        return crcForm;

    }

    @Override
    public List getusernamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList<>();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id "
                    + "FROM CrcForm a "
                    + "WHERE a.userid = :username "
                    + "AND a.flagStatus NOT IN (5, 6, 7) ";

            boolean hasSearch = searchValue != null && !searchValue.trim().isEmpty();
            if (hasSearch) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 2   AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 800 AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 10  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            Set<String> allowedColumns = new HashSet<>(Arrays.asList(
                    "id", "documentNo", "pcsName", "userid", "designation", "flagStatus"
            ));

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
                    + "FROM CrcForm a "
                    + " WHERE a.userid = '" + username + "'"
                    + "AND a.flagStatus NOT IN (5, 6, 7) ";

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
    public int getFilteredusernameCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM CrcForm a "
                    + " WHERE a.userid = '" + username + "'"
                    + "AND a.flagStatus NOT IN (5, 6, 7) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 2   AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 800 AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 10  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);
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
    public List getoapDeliverableViewPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id "
                    + "FROM CrcForm a, DeliverableMulti b "
                    + "WHERE a.userid = :username "
                    + "AND b.flagStatus = 5 "
                    + "AND a.oapForm.id = b.oapId ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)    LIKE :search "
                        + "OR lower(a.userid)     LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + ") ";
            }

            hql += "GROUP BY a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id ";
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
    public int getTotaloapDeliverableViewCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(DISTINCT a.id) "
                    + "FROM CrcForm a, DeliverableMulti b "
                    + "WHERE a.userid = :username "
                    + "AND b.flagStatus = 5 "
                    + "AND a.oapForm.id = b.oapId ";

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
    public int getFilteredoapDeliverableViewCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(DISTINCT a.id) "
                    + "FROM CrcForm a, DeliverableMulti b "
                    + "WHERE a.userid = :username "
                    + "AND b.flagStatus = 5 "
                    + "AND a.oapForm.id = b.oapId ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
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
    public int countAllCrc() {

        String query = "SELECT COUNT(DISTINCT a.oapForm.id) FROM CrcForm a";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int countAllCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.oapForm.id) FROM CrcForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))";
            } else {
                query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getTotalCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id "
                    + "FROM CrcForm a "
                    + "WHERE 1=1 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 2   AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 800 AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 5   AND lower('cancel project manger') LIKE :search) "
                        + "OR (a.flagStatus = 6   AND lower('close project manger') LIKE :search) "
                        + "OR (a.flagStatus = 7   AND lower('rejected project manger') LIKE :search) "
                        + "OR (a.flagStatus = 10  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
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
    public int getTotalCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) FROM CrcForm a "
                    + " WHERE 1=1 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
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
    public int getFilteredTotalCrcCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) FROM CrcForm a "
                    + " WHERE 1=1 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 2   AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 800 AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 5   AND lower('cancel project manger') LIKE :search) "
                        + "OR (a.flagStatus = 6   AND lower('close project manger') LIKE :search) "
                        + "OR (a.flagStatus = 7   AND lower('rejected project manger') LIKE :search) "
                        + "OR (a.flagStatus = 10  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
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
    public int readByFlagFour() {
        String query = "SELECT COUNT(*)";
        query += " FROM CrcForm a"
                + " WHERE a.flagStatus IN (1,4)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM CrcForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y')) "
                    + " AND a.flagStatus IN (1,4) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus IN (1,4) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus IN (1,4) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getTotalApprovedCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus =1";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 2   AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 800 AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 5   AND lower('cancel project manger') LIKE :search) "
                        + "OR (a.flagStatus = 6   AND lower('close project manger') LIKE :search) "
                        + "OR (a.flagStatus = 7   AND lower('rejected project manger') LIKE :search) "
                        + "OR (a.flagStatus = 10  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
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
    public int getTotalApprovedCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM CrcForm a "
                    + " WHERE a.flagStatus =1";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
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
    public int getFilteredTotalApprovedCrcCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM CrcForm a "
                    + " WHERE a.flagStatus = 1";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR (a.flagStatus = 0   AND lower('pending to approved') LIKE :search) "
                        + "OR (a.flagStatus = 2   AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 800 AND lower('partially approved') LIKE :search) "
                        + "OR (a.flagStatus = 3   AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 5   AND lower('cancel project manger') LIKE :search) "
                        + "OR (a.flagStatus = 6   AND lower('close project manger') LIKE :search) "
                        + "OR (a.flagStatus = 7   AND lower('rejected project manger') LIKE :search) "
                        + "OR (a.flagStatus = 10  AND lower('recycle') LIKE :search) "
                        + "OR ((a.flagStatus = 1 OR a.flagStatus = 4) "
                        + "     AND lower('approved') LIKE :search) "
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
    public int readBypendingCrc() {

        String query = "SELECT COUNT(a.id) "
                + "FROM CrcForm a "
                + "WHERE a.flagStatus NOT IN (1,4,3,2,800) ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readBypendingCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM CrcForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y')) "
                    + " AND a.flagStatus NOT IN (1,4,3,2,800) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus NOT IN (1,4,3,2,800) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus NOT IN (1,4,3,2,800) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getPendingCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id "
                    + "FROM CrcForm a "
                    + "WHERE a.flagStatus NOT IN (1,4,3,2,800) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR ((a.flagStatus != 1 OR a.flagStatus != 4) "
                        + "    AND lower('pending') LIKE :search) "
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
    public int getPendingCRCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM CrcForm a "
                    + "WHERE a.flagStatus NOT IN (1,4,3,2,800) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
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
    public int getFilteredPendingCRCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM CrcForm a "
                    + "WHERE a.flagStatus NOT IN (1,4,3,2,800) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.userid)      LIKE :search "
                        + "OR lower(a.designation) LIKE :search "
                        + "OR ((a.flagStatus != 1 OR a.flagStatus != 4) "
                        + "    AND lower('pending') LIKE :search) "
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
    public int readByrevisionCrc() {

        String query
                = "SELECT COUNT(b.id) "
                + "FROM CrcForm a, CrcFormHistory b "
                + "WHERE b.crcId = a.id "
                + "AND a.flagStatus IN (2, 800) ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByrevisionCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(b.id) FROM CrcForm a, CrcFormHistory b ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y')) "
                    + " AND b.crcId = a.id "
                    + " AND a.flagStatus IN (2, 800) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND b.crcId = a.id "
                        + " AND a.flagStatus IN (2, 800) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND b.crcId = a.id "
                        + " AND a.flagStatus IN (2, 800) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getRevisionCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm "
                    + "FROM CrcForm a, CrcFormHistory b "
                    + "WHERE b.crcId = a.id "
                    + "AND a.flagStatus IN (2, 800) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.userid) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + ") ";
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
    public int getTotalRevisionCRCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(b.id) "
                    + "FROM CrcForm a, CrcFormHistory b "
                    + "WHERE b.crcId = a.id "
                    + "AND a.flagStatus IN (2, 800) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
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
    public int getFilterdRevisionCRCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(b.id) "
                    + "FROM CrcForm a, CrcFormHistory b "
                    + "WHERE b.crcId = a.id "
                    + "AND a.flagStatus IN (2, 800) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.userid) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + ") ";
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
    public int readByFlagTwo() {
        String query = "SELECT COUNT(*)";
        query += " FROM CrcForm a"
                + " WHERE a.flagStatus IN (2,800)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagTwoDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "SELECT COUNT(a.id) FROM CrcForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y')) "
                    + " AND a.flagStatus IN (2,800) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus IN (2,800) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus IN (2,800) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getParticiallyPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus, a.oapForm.id "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus IN (2,800)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.userid) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR ((a.flagStatus = 2 OR a.flagStatus = 800) "
                        + "     AND lower('partially approved') LIKE :search) "
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
    public int getParticiallyCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus IN (2,800)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
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
    public int getFilteredParticiallyCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus IN (2,800)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.userid) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR ((a.flagStatus = 2 OR a.flagStatus = 800) "
                        + "     AND lower('partially approved') LIKE :search) "
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
        String query = "SELECT COUNT(*)";
        query += " FROM CrcForm a"
                + " WHERE a.flagStatus IN (3)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagThreeDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "SELECT COUNT(a.id) FROM CrcForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y')) "
                    + " AND a.flagStatus IN (3) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus IN (3) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus IN (3) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getRejectedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.userid, a.designation, a.flagStatus "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.userid) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR a.flagStatus = 3 AND lower('CRC Rejected') LIKE :search) "
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
    public int getRejectedCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
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
    public int getFilteredRejectedCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM CrcForm a"
                    + " WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.oapForm.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.userid) LIKE :search "
                        + " OR lower(a.designation) LIKE :search "
                        + " OR a.flagStatus = 3 AND lower('CRC Rejected') LIKE :search) "
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
