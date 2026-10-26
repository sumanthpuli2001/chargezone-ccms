/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRDocDao;
import com.bul.zydex.model.PRDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public class PRDocServiceImpl<T> extends GenericsServiceImpl<T> implements PRDocService<T> {
    
    private PRDocDao<T> prDocDao;

    public PRDocDao<T> getPrDocDao() {
        return prDocDao;
    }

    public void setPrDocDao(PRDocDao<T> prDocDao) {
        this.prDocDao = prDocDao;
         setGenericsDAO(prDocDao);
    }

    @Override
    public List readByRefNo(String ref_no) {
        return prDocDao.readByRefNo(ref_no);
    }

    @Override
    public void updatePRNo(String refNo1, String refNo) {
        prDocDao.updatePRNo(refNo1,refNo);
    }
}
