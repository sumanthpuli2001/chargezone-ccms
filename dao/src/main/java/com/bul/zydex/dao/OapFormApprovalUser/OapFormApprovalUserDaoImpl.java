/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormApprovalUser;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapFormApprovalUser;
import java.util.List;
import static net.sf.dynamicreports.report.builder.DynamicReports.query;

/**
 *
 * @author Sumanth
 */
public class OapFormApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements OapFormApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapFormApprovalUser.class;
    }

    @Override
    public OapFormApprovalUser appval(String username) {
        String query = "";
        OapFormApprovalUser oapFormApprovalUser = new OapFormApprovalUser();
        query += "SELECT b FROM  OapFormApproval a, OapFormApprovalUser b WHERE  a.id = b.oapFormApproval and b.userId = '" + username + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            oapFormApprovalUser = (OapFormApprovalUser) list.get(0);

        }
        return oapFormApprovalUser;
    }

    @Override
    public OapFormApprovalUser readLevel(String level, int oapFormid) {
        String query = "";

        OapFormApprovalUser oapFormApprovalUser = new OapFormApprovalUser();
        query += " FROM OapFormApprovalUser a"
                + " WHERE a.oapFormApproval = '" + oapFormid + "'"
                + " and a.level = " + level + "";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            oapFormApprovalUser = (OapFormApprovalUser) list.get(0);
        }
        return oapFormApprovalUser;
    }

    @Override
    public List readByDleteCode(int formid) {
        String query = "";
        query += " FROM OapFormApprovalUser a"
                + " WHERE a.oapFormApproval = '" + formid + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByapprovalStatus(String id) {
        String query = "";
        query += " FROM OapFormApprovalUser a"
                + " WHERE a.oapForm = '" + id + "'"
                + " AND a.approvalStatus IN (0)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public OapFormApprovalUser appvals(String username, String id) {
        String query = "";
        OapFormApprovalUser oapFormApprovalUser = new OapFormApprovalUser();
        query += "SELECT b FROM  OapFormApproval a, OapFormApprovalUser b WHERE  a.id = b.oapFormApproval and b.userId = '" + username + "' and b.oapFormApproval= " + id;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            oapFormApprovalUser = (OapFormApprovalUser) list.get(0);

        }
        return oapFormApprovalUser;
    }

    @Override
    public List readByoapid(int oapid) {
        String query = "";
        query += " FROM OapFormApprovalUser a"
                + " WHERE a.oapForm = '" + oapid + "'";
        return getHibernateTemplate().find(query);

    }

    @Override
    public OapFormApprovalUser readByIdAndUsername(String username, String id) {
        OapFormApprovalUser oapFormApprovalUser = new OapFormApprovalUser();

        String query = "";
        query += " FROM OapFormApprovalUser a"
                + " WHERE a.oapFormApproval =  '" + id + "'"
                + " And a.userId =  '" + username + "'";
        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            oapFormApprovalUser = (OapFormApprovalUser) list.get(0);

        }
        return oapFormApprovalUser;
    }

}
