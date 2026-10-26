/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderItemMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderItemMasterDaoImpl<T> extends GenericsDAOImpl<T> implements TenderItemMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return TenderItemMaster.class;
    }

    @Override
    public List readByItemNo(String refNo, String pur_no, String item_no) {
        String query = "";
        query += " FROM TenderItemMaster a"
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '" + pur_no + "' and a.itemNo = '" + item_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderItemMaster a"
                + " WHERE a.refNo = '" + refNo + "' order by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId) {
        String query = "";
        query += " update TenderItemMaster a"
                + " set a.remark='" + item_remark + "', "
                + " a.qty='" + qty + "', "
                + " a.attachmentRequired='" + checkId + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '" + pur_no + "' and a.itemNo = '" + item_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        String query = "";
        query += " update TenderItemMaster a"
                + " set a.refNo = '" + refNo + "'"
                + " WHERE a.refNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void deleteRefNo(String ref_no, int item_type) {
        String query = "";
        query += " delete from TenderItemMaster a"
                + " WHERE a.refNo = '" + ref_no + "' and a.itemType=" + item_type + "";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateItemDetail(String refNo, String sr_no, String item_detail) {
        String query = "";
        query += " update TenderItemMaster a"
                + " set a.deliveryScheduleDate = '" + item_detail + "'"
                + " WHERE a.refNo = '" + refNo + "' and a.srNo = '" + sr_no + "' ";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByItemCode(String itemCode) {
        String query = "";
        query += " FROM TenderItemMaster a"
                + " WHERE a.itemCode = '" + itemCode + "' order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNoAndItemType(String ref_no, int item_type) {
        String query = "";
        query += " FROM TenderItemMaster a"
                + " WHERE a.refNo = '" + ref_no + "' and a.itemType=" + item_type + " order by a.id";
        return getHibernateTemplate().find(query);
    }

    public int countByRefNo(String pr_no1, int itemType) {

        String hql = "select count(*) "
                + "from TenderItemMaster a "
                + "where a.refNo = ? "
                + "and a.itemType = ?";

        List list = getHibernateTemplate().find(hql, pr_no1, itemType);

        if (list != null && !list.isEmpty()) {
            return ((Long) list.get(0)).intValue();
        }

        return 0;
    }

    @Override
    public int getMaxSrNo(String ref_no, int item_type) {
        String hql = "select max(cast(a.srNo as integer)) "
                + "from TenderItemMaster a "
                + "where a.refNo = ? and a.itemType = ?";

        List list = getHibernateTemplate().find(hql, ref_no, item_type);

        if (list != null && !list.isEmpty() && list.get(0) != null) {
            return ((Number) list.get(0)).intValue();
        }

        return 0;
    }

}
