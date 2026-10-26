/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapMasterUser;

import com.bul.zydex.dao.OapMasterUser.OapMasterUserDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapMasterUserServiceImpl<T> extends GenericsServiceImpl<T> implements OapMasterUserService<T> {

    private OapMasterUserDao<T> oapMasterUserDao;

    public OapMasterUserDao<T> getOapMasterUserDao() {
	return oapMasterUserDao;
    }

    public void setOapMasterUserDao(OapMasterUserDao<T> oapMasterUserDao) {
	this.oapMasterUserDao = oapMasterUserDao;
	setGenericsDAO(oapMasterUserDao);
    }

    @Override
    public List<?> readByIdToList1(String id) {
	return oapMasterUserDao.readByIdToList1(id);

    }

    @Override
    public List readByIdToList(String approvalName) {
	return oapMasterUserDao.readByIdToList(approvalName);
    }

}
