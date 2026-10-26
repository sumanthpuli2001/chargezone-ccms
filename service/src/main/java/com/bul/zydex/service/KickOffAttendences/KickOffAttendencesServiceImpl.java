/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffAttendences;

import com.bul.zydex.dao.KickOffAttendences.KickOffAttendencesDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffAttendencesServiceImpl<T> extends GenericsServiceImpl<T> implements KickOffAttendencesService<T> {

    private KickOffAttendencesDao<T> kickOffAttendencesDao;

    public KickOffAttendencesDao<T> getKickOffAttendencesDao() {
	return kickOffAttendencesDao;
    }

    public void setKickOffAttendencesDao(KickOffAttendencesDao<T> kickOffAttendencesDao) {
	this.kickOffAttendencesDao = kickOffAttendencesDao;
	setGenericsDAO(kickOffAttendencesDao);

    }

    @Override
    public List readByid(String kickoffFormId) {

	return kickOffAttendencesDao.readByid(kickoffFormId);
    }

    @Override
    public List readByids(String id) {
	return kickOffAttendencesDao.readByids(id);
    }

    @Override
    public List readBykickOffFormid(int id1) {
	return kickOffAttendencesDao.readBykickOffFormid(id1);
    }

}
