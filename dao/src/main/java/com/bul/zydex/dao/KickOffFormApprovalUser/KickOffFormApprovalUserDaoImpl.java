/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffFormApprovalUser;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KickOffFormApprovalUser;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffFormApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements KickOffFormApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
	return KickOffFormApprovalUser.class;
    }

    @Override
    public KickOffFormApprovalUser appval(String username) {
	String query = "";
	KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
	query += "SELECT b FROM  KickOffFormApproval a, KickOffFormApprovalUser b WHERE  a.id = b.kickOffFormApproval and b.userId = '" + username + "'" + " and a.approvalStatus =0 and a.currentApproval = b.level ";
	List list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    kickOffFormApprovalUser = (KickOffFormApprovalUser) list.get(0);
	}
	return kickOffFormApprovalUser;
    }

    @Override
    public List readByDleteCode(int formid) {

	String query = "";
	query += " FROM KickOffFormApprovalUser a"
		+ " WHERE a.kickOffFormApproval = '" + formid + "'";
	return getHibernateTemplate().find(query);

    }

    @Override
    public List readByApprovestatus(String id) {
	
	String query = "";
	query += " FROM KickOffFormApprovalUser a"
		+ " WHERE a.kickOffForm = '" + id + "'"
		+ " AND a.approvalStatus IN (0)";
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readBykomid(int komid) {
        String query = "";
    query += " FROM KickOffFormApprovalUser a"
           + " WHERE a.kickOffForm = " + komid;
    return getHibernateTemplate().find(query); 
        
        
    }

    @Override
    public KickOffFormApprovalUser appvals(String username, int kickOffFormid) {
  String query = "";
	KickOffFormApprovalUser kickOffFormApprovalUser = new KickOffFormApprovalUser();
        query += "SELECT b FROM  KickOffFormApproval a, KickOffFormApprovalUser b "
                + "WHERE  a.id = b.kickOffFormApproval "
                + "and b.userId = '" + username + "'"
                + "and b.kickOffForm = '" + kickOffFormid + "'";
//               
               
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kickOffFormApprovalUser = (KickOffFormApprovalUser) list.get(0);

        }
        return kickOffFormApprovalUser;
    
    }

}
//String query = "";
//	CrcFormApprovalUser crcFormApprovalUser = new CrcFormApprovalUser();
//	query += "SELECT b FROM  CrcFormApproval a, CrcFormApprovalUser b WHERE  a.id = b.crcFormApproval and b.userId = '" + username + "'" + " and a.approvalStatus =0 and a.currentApproval = b.level ";
//	List list = getHibernateTemplate().find(query);
//	if (!list.isEmpty()) {
//	    crcFormApprovalUser = (CrcFormApprovalUser) list.get(0);
//
//	}
//	return crcFormApprovalUser;
