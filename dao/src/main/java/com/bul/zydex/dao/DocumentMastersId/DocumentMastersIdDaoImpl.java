/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DocumentMastersId;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DocumentMastersId;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DocumentMastersIdDaoImpl<T> extends GenericsDAOImpl<T> implements DocumentMastersIdDao<T> {

    @Override
    protected Class getDomainClass() {
	return DocumentMastersId.class;
    }

    @Override
    public DocumentMastersId readByDocumentNo() {
	DocumentMastersId documentMastersId = new DocumentMastersId();
	String query = "";
	query += " FROM DocumentMastersId a order by a.documentId desc limit 1"
		+ " ";
	List<?> list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    documentMastersId = (DocumentMastersId) list.get(0);
	}
	return documentMastersId;
    }

}
