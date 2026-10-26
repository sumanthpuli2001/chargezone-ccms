/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.IteamDetailsAttachments;

import com.bul.zydex.dao.IteamDetailsAttachments.IteamDetailsAttachmentsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class IteamDetailsAttachmentsServiceImpl<T> extends GenericsServiceImpl<T> implements IteamDetailsAttachmentsService<T> {

    private IteamDetailsAttachmentsDao<T> iteamDetailsAttachmentsDao;

    public IteamDetailsAttachmentsDao<T> getIteamDetailsAttachmentsDao() {
        return iteamDetailsAttachmentsDao;
    }

    public void setIteamDetailsAttachmentsDao(IteamDetailsAttachmentsDao<T> iteamDetailsAttachmentsDao) {
        this.iteamDetailsAttachmentsDao = iteamDetailsAttachmentsDao;
        setGenericsDAO(iteamDetailsAttachmentsDao);

    }

    @Override
    public List readByPRItemDesc(String id) {
        return iteamDetailsAttachmentsDao.readByPRItemDesc(id);

    }

    @Override
    public List readByPRItemDesc1(String id1) {
        return iteamDetailsAttachmentsDao.readByPRItemDesc1(id1);
    }

    @Override
    public List readBydeliverymultid(String id) {
        return iteamDetailsAttachmentsDao.readBydeliverymultid(id);
    }

    @Override
    public List readBydeleteAll(String id) {
        return iteamDetailsAttachmentsDao.readBydeleteAll(id);
    }

    @Override
    public List readBystatus(String status, String id) {
        return iteamDetailsAttachmentsDao.readBystatus(status, id);

    }

    @Override
    public List readBystatus2(int setValue, String id) {
        return iteamDetailsAttachmentsDao.readBystatus2(setValue, id);
    }

    @Override
    public List readBydeleteAll1(String id) {
        return iteamDetailsAttachmentsDao.readBydeleteAll1(id);
    }

    @Override
    public List readByPRItemDesc2(String id) {
        return iteamDetailsAttachmentsDao.readByPRItemDesc2(id);
    }

    @Override
    public void deleteByDeliMultiAndFlag(String id,int flag) {
        iteamDetailsAttachmentsDao.deleteByDeliMultiAndFlag(id,flag);
    }

}
