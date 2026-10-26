/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormApprovalUser;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormApprovalUser;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Sumanth
 */
public class AocFormApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocFormApprovalUser.class;
    }

    @Override
    public AocFormApprovalUser appval(String username) {
        String query = "";
        AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
        query += "SELECT b FROM AocFormApproval a, AocFormApprovalUser b WHERE  a.id =b.aocFormApproval and b.userId = '" + username + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            aocFormApprovalUser = (AocFormApprovalUser) list.get(0);
        }
        return aocFormApprovalUser;
    }

    @Override
    public AocFormApprovalUser readLevel(String level, int aocFormid) {
        String query = "";
        AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
        query += " FROM AocFormApprovalUser a"
                + " WHERE a.aocFormApproval = '" + aocFormid + "'"
                + " and a.level = " + level + "";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            aocFormApprovalUser = (AocFormApprovalUser) list.get(0);
        }
        return aocFormApprovalUser;
    }

    @Override
    public List readByDleteCode(int formid) {
        String query = "";
        query += " FROM AocFormApprovalUser a"
                + " WHERE a.aocFormApproval = '" + formid + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByApprovalStatus(String id) {

        String query = "";
        query += " FROM AocFormApprovalUser a"
                + " WHERE a.aocForm = '" + id + "'"
                + " AND a.approvalStatus IN (0)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AocFormApprovalUser appvals(String username, String id) {

        String query = "";
        AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();
        query += "SELECT b FROM AocFormApproval a, AocFormApprovalUser b WHERE  a.id =b.aocFormApproval and b.userId = '" + username + "' and b.aocFormApproval= " + id;
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            aocFormApprovalUser = (AocFormApprovalUser) list.get(0);
        }
        return aocFormApprovalUser;

    }

    @Override
    public List readByaocId(String id) {

        String query = "";
        query += " from  AocFormApprovalUser a "
                + "where a.aocForm = '" + id + "'";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByaocId(int aocformid) {
        String query = "";
        query += " from  AocFormApprovalUser a "
                + "where a.aocForm = '" + aocformid + "'";

        return getHibernateTemplate().find(query);

    }

    @Override
    public AocFormApprovalUser readByIdAndUsername(String id, String username) {

        AocFormApprovalUser aocFormApprovalUser = new AocFormApprovalUser();

        String query = "";
        query += " FROM AocFormApprovalUser a"
                + " WHERE a.aocFormApproval =  '" + id + "'"
                + " And a.userId =  '" + username + "'";
        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            aocFormApprovalUser = (AocFormApprovalUser) list.get(0);

        }
        return aocFormApprovalUser;

    }

}
