/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Deliverable;

import com.bul.zydex.dao.Deliverable.DeliverableDao;
import com.bul.zydex.model.Deliverable;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Sumanth
 */
public class DeliverableServiceImpl<T> extends GenericsServiceImpl<T> implements DeliverableService<T> {

    private DeliverableDao<T> deliverableDao;

    public DeliverableDao<T> getDeliverableDao() {
	return deliverableDao;
    }

    public void setDeliverableDao(DeliverableDao<T> deliverableDao) {
	this.deliverableDao = deliverableDao;
	setGenericsDAO(deliverableDao);

    }

    @Override
    public Deliverable readByoapid(String id) {
	return deliverableDao.readByoapid(id);

    }

    @Override
    public Deliverable readByAOcid(String id) {
	return deliverableDao.readByAOcid(id);
    }

}
