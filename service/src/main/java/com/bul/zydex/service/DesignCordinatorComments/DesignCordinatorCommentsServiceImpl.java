/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DesignCordinatorComments;

import com.bul.zydex.dao.DesignCordinatorComments.DesignCordinatorCommentsDao;
import com.bul.zydex.model.DesignCordinatorComments;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DesignCordinatorCommentsServiceImpl<T> extends GenericsServiceImpl<T> implements DesignCordinatorCommentsService<T> {
    private DesignCordinatorCommentsDao<T> designCordinatorCommentsDao;

    public DesignCordinatorCommentsDao<T> getDesignCordinatorCommentsDao() {
	return designCordinatorCommentsDao;
    }

    public void setDesignCordinatorCommentsDao(DesignCordinatorCommentsDao<T> designCordinatorCommentsDao) {
	this.designCordinatorCommentsDao = designCordinatorCommentsDao;
	setGenericsDAO(designCordinatorCommentsDao);
    }

    @Override
    public List readybydelivid(String id) {
	
		return designCordinatorCommentsDao.readybydelivid(id);

    }

   
    
}
