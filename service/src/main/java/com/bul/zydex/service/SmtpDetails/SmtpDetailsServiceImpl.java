/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SmtpDetails;

import com.bul.zydex.dao.SmtpDetails.SmtpDetailsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.model.SmtpDetails;
import java.util.List;
/**
 *
 * @author Admin
 */
public class SmtpDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements SmtpDetailsService <T>{
    
    private SmtpDetailsDao<T> smtpDetailsDao;

    public SmtpDetailsDao<T> getSmtpDetailsDao() {
        return smtpDetailsDao;
    }

    public void setSmtpDetailsDao(SmtpDetailsDao<T> smtpDetailsDao) {
        this.smtpDetailsDao = smtpDetailsDao;
        setGenericsDAO(smtpDetailsDao);
    }

    @Override
    public List readAllDetails() {
       return smtpDetailsDao.readAllDetails();
    }

    @Override
    public int getTotalSmtpCount() {
        return smtpDetailsDao.getTotalSmtpCount();
    }

    @Override
    public int getFilteredSmtpCount(String search) {
        return smtpDetailsDao.getFilteredSmtpCount(search);
    }

    @Override
    public List getSmtpPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return smtpDetailsDao.getSmtpPagination(start, length, searchValue, orderColumn, orderDir);
    }
    
    
}
