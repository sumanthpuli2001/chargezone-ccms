/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DocumentMasterId;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DocumentMasterId;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DocumentMasterIdDaoImpl<T> extends GenericsDAOImpl<T> implements DocumentMasterIdDao<T> {

    @Override
    protected Class getDomainClass() {
	return DocumentMasterId.class;
    }

    @Override
    public DocumentMasterId readByDocumentNo() {
	DocumentMasterId documentMasterId = new DocumentMasterId();
	String query = "";
	query += " FROM DocumentMasterId a order by a.documentId desc limit 1"
		+ " ";
	List<?> list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    documentMasterId = (DocumentMasterId) list.get(0);
	}
	return documentMasterId;
    }

}

