/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DesignCordinatorComments;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DesignCordinatorComments;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DesignCordinatorCommentsDaoImpl <T> extends GenericsDAOImpl<T> implements DesignCordinatorCommentsDao<T>{

    @Override
    protected Class getDomainClass() {
	return DesignCordinatorComments.class;
    }

    @Override
    public List readybydelivid(String id) {
	String query = " Select a.id,a.comments,a.userId,b.flagStatus,a.flagStatus,a.dateTime";
	query += " FROM DesignCordinatorComments a,DeliverableMulti b"
		+ " WHERE a.deliverableId = '" + id + "'"
		+ "And a.deliverableId=b.id";
//		+ "And b.flagStatus";
	return getHibernateTemplate().find(query);
	
    }

   

}
