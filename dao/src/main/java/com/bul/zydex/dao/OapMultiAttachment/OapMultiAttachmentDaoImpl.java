/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapMultiAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapMultiAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapMultiAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements OapMultiAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
	return OapMultiAttachment.class;
    }

    @Override
    public List readByMulti(String oapFormmulti) {
	String query = " Select  a.attachment ,a.description, a.id, a.oapForm"
		+ " from OapMultiAttachment a "
		+ " where  a.oapForm=" + oapFormmulti;
	List list = getHibernateTemplate().find(query);
	return list;

    }

    @Override
    public List readByattachzip(String id1) {
	String query = " "
		+ " from OapMultiAttachment a "
		+ " where  a.oapForm=" + id1;
	List list = getHibernateTemplate().find(query);
	return list;

    }

  

}
//String query = " Select  a.attachment ,a.description, a.id"
//		+ " from AocFormMultiAttachment a "
//		+ " where  a.aocForm=" + aocFormmulti;
//	List list = getHibernateTemplate().find(query);
//	return list;
