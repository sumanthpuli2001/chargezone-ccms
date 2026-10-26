/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormMultiAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormMultiAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormMultiAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormMultiAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
	return AocFormMultiAttachment.class;
    }

    @Override
    public List readByMulti(String aocFormmulti) {
	String query = " Select  a.attachment ,a.description, a.id"
		+ " from AocFormMultiAttachment a "
		+ " where  a.aocForm=" + aocFormmulti;
	List list = getHibernateTemplate().find(query);
	return list;
    }

    @Override
    public List readByattachzip(String id1) {
	String query = ""
		+ " from AocFormMultiAttachment a "
		+ " where  a.aocForm=" + id1;
	List list = getHibernateTemplate().find(query);
	return list;
    }

}
//String query = " Select a.attachment ,b.documentName, a.id"
//		+ " from AocFormAttachment a "
//		+ " left join a.documentName b"
//		+ " where  a.aocForm=" + aocFormattach;
//
//	List list = getHibernateTemplate().find(query);
//	return list;
