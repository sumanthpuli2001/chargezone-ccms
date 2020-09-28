/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Report;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ReportMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Aman Bahukhandi
 */
public class ReportDaoImpl<T> extends GenericsDAOImpl<T> implements ReportDao<T> {

    @Override
    protected Class getDomainClass() {
        return ReportMaster.class;
    }

    @Override
    public List read(String dFrom, String eFrom, String type, String name, String cardCode, String item) {
        String Condition = " and 1 = 1 ";
        if (name != "" && name != null) {
            Condition += "and a.name='" + name + "'";
        }
        if (cardCode != "" && cardCode != null) {
            Condition += " and a.code='" + cardCode + "'";
        }
        if (!item.equals("All") && item != "") {
            Condition += " and a.item='" + item + "'";
        }

        String query = " Select distinct a.name,a.code ,a.id"
                + " from ReportMaster a "
                + " where (STR_TO_DATE(a.tdate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))"
                + " " + Condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByValues(String date, String name, String code, String id, String item) {
        String Condition = " and 1 = 1 ";
        if (name != "" && name != null) {
            Condition += " and a.name='" + name + "'";
        }
        if (code != "" && code != null) {
            Condition += " and a.code='" + code + "'";
        }
        if (!item.equals("All")) {
            Condition += " and a.item='" + item + "'";
        }

        String query = " Select distinct a.item, a.code,a.id "
                + " from ReportMaster a "
                + " where a.id='" + id + "'"
                + " and (STR_TO_DATE(a.tdate,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d')) "
                + Condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDateDiff(String dFrom, String eFrom) {

        String query = " Select a"
                + " from ReportMaster a "
                + " Where (STR_TO_DATE(a.tdate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void delteDataByCodeDate(String code, String tdate) {

        String query = "";
        query += " delete FROM ReportMaster a"
                + " WHERE a.code = '" + code + "'"
                + " and (STR_TO_DATE(a.tdate,'%Y-%m-%d') = STR_TO_DATE('" + tdate + "', '%Y-%m-%d')) ";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

}
