/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormAttachment;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Sumanth
 */
public class AocFormAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
	return AocFormAttachment.class;
    }

    @Override
    public List readByattach(String aocFormattach) {
	String query = " Select a.attachment ,b.documentName, a.id"
		+ " from AocFormAttachment a "
		+ " left join a.documentName b"
		+ " where  a.aocForm=" + aocFormattach;

	List list = getHibernateTemplate().find(query);
	return list;

    }

    @Override
    public List readByattachzip(String id1) {
	String query = " "
		+ " from AocFormAttachment a "
		+ " left join a.documentName b"
		+ " where  a.aocForm=" + id1;

	List list = getHibernateTemplate().find(query);
	return list;
	
    }

    @Override
    public void deleteByid(int id1) {
       String query = ""
		+ " delete from AocFormAttachment a "
		+ " where  a.aocForm.id=" + id1;
        
          Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate(); 
        
    }

}

