/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.model.SapTenderItem;
import com.bul.zydex.model.TenderItemMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class PRItemMasterDaoImpl<T> extends GenericsDAOImpl<T> implements PRItemMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return PRItemMaster.class;
    }

    @Override
    public List readByRefNo(String refNo, int item_type) {
        String query = "";
        query += " FROM PRItemMaster a"
                + " WHERE a.prNo = '" + refNo + "' and a.itemType=" + item_type + "";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String ref_no, int item_type) {
        String query = "";
        query += " delete from PRItemMaster a"
                + " WHERE a.prNo = '" + ref_no + "' and a.itemType=" + item_type + "";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public PRItemMaster readId(int id) {
        PRItemMaster pRItemMaster = new PRItemMaster();
        String query = "";
        query += " FROM PRItemMaster a"
                + " WHERE a.id = " + id + "";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            pRItemMaster = (PRItemMaster) list.get(0);
        }
        return pRItemMaster;
    }

    @Override
    public void updatePRNo(String refNo1, String refNo) {
        String query = "";
        query += " update PRItemMaster a"
                + " set a.prNo = '" + refNo + "'"
                + " WHERE a.prNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByPRItemDesc(String ref_no, String item_desc, int i) {
        String query = "";
        query += " FROM PRItemMaster a"
                + " WHERE a.prNo = '" + ref_no + "' and a.itemDescription = '" + item_desc + "' and a.itemType=" + i + "";
        return getHibernateTemplate().find(query);
    }

    @Override
    public int countByRefNo(String pr_no1, int itemType) {

        String hql = "select count(*) "
                + "from PRItemMaster a "
                + "where a.prNo = ? "
                + "and a.itemType = ?";

        List list = getHibernateTemplate().find(hql, pr_no1, itemType);

        if (list != null && !list.isEmpty()) {
            return ((Long) list.get(0)).intValue();
        }

        return 0;
    }
}
