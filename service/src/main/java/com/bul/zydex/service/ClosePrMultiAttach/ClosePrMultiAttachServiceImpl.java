/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ClosePrMultiAttach;

import com.bul.zydex.dao.ClosePrMultiAttach.ClosePrMultiAttachDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ClosePrMultiAttachServiceImpl<T> extends GenericsServiceImpl<T> implements ClosePrMultiAttachService<T> {
    
      private ClosePrMultiAttachDao<T> closePrMultiAttachDao;

    public ClosePrMultiAttachDao<T> getClosePrMultiAttachDao() {
        return closePrMultiAttachDao;
    }

    public void setClosePrMultiAttachDao(ClosePrMultiAttachDao<T> closePrMultiAttachDao) {
        this.closePrMultiAttachDao = closePrMultiAttachDao;
        setGenericsDAO(closePrMultiAttachDao);
        
    }

    @Override
    public List readByprNo(String prno) {
         return closePrMultiAttachDao.readByprNo(prno);
    }
      
      
      
      
      
}
