/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.IteamDetailsAttachments;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.IteamDetailsAttachments;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Sumanth
 */
public class IteamDetailsAttachmentsDaoImpl<T> extends GenericsDAOImpl<T> implements IteamDetailsAttachmentsDao<T> {

    @Override
    protected Class getDomainClass() {
        return IteamDetailsAttachments.class;
    }

    @Override
    public List readByPRItemDesc(String id) {
        String query = "";
        query += " FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'"
                + " AND a.flagStatus IN (0,3)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByPRItemDesc1(String id1) {
        String query = "";
        query += " FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id1 + "'"
                + " And a.flagStatus=1";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readBydeliverymultid(String id) {
        String query = "";
        query += " FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBydeleteAll(String id) {
        String query = "";
        query += " FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'"
                + " And a.flagStatus=0";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readBystatus(String status, String id) {
        String query = "FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'"
                + " AND a.flagStatus = '" + status + "'";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBystatus2(int setValue, String id) {
        String query = "FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'"
                + " AND a.flagStatus = '" + setValue + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readBydeleteAll1(String id) {
        String query = "";
        query += " FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'"
                + " And a.flagStatus=3";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByPRItemDesc2(String id) {
        String query = "";
        query += " FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = '" + id + "'"
                + " And a.flagStatus=4";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByDeliMultiAndFlag(String id,int flag) {
        String query = "";
        query += " delete FROM IteamDetailsAttachments a"
                + " WHERE a.deliverableMultiId = " + id 
                + " And a.flagStatus="+flag;
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}

//}
//String query = "";
//	query += " FROM OapFormApprovalUser a"
//		+ " WHERE a.oapFormApproval = '" + formid + "'";
//	return getHibernateTemplate().find(query);
//    }
