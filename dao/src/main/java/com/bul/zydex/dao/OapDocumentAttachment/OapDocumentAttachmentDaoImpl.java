/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapDocumentAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapDocumentAttachment;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Sumanth
 */
public class OapDocumentAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements OapDocumentAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
	return OapDocumentAttachment.class;
    }

    @Override
    public List readByattach(String oapFormattach) {
	String query = " Select a.attachment ,b.documentName, a.id, a.oapForm"
		+ " from OapDocumentAttachment a "
		+ " left join a.documentName b"
		+ " where  a.oapForm=" + oapFormattach;

	List list = getHibernateTemplate().find(query);
	return list;
    }

    @Override
    public OapDocumentAttachment readByattach1(String id1) {
	String query = "";
	OapDocumentAttachment oapDocumentAttachment = new OapDocumentAttachment();

	List list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    oapDocumentAttachment = (OapDocumentAttachment) list.get(0);

	}
	return oapDocumentAttachment;

    }

    @Override
    public List readByattachzip(String id1) {
	String query = ""
		+ " from OapDocumentAttachment a "
		+ " left join a.documentName b"
		+ " where  a.oapForm=" + id1;

	List list = getHibernateTemplate().find(query);
	return list;
    }

    @Override
    public void deleteByid(String id) {
        String query = ""
		+ " delete from OapDocumentAttachment a "
		+ " where  a.oapForm.id=" + id;
        
          Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

}
//String query = "";
//	OapFormApprovalUser oapFormApprovalUser = new OapFormApprovalUser();
//	query += "SELECT b FROM  OapFormApproval a, OapFormApprovalUser b WHERE  a.id = b.oapFormApproval and b.userId = '" + username + "'" + " and a.approvalStatus =0 and a.currentApproval = b.level ";
//	List list = getHibernateTemplate().find(query);
//	if (!list.isEmpty()) {
//	    oapFormApprovalUser = (OapFormApprovalUser) list.get(0);
//
//	}
//	return oapFormApprovalUser;
