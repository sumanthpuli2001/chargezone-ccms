/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRVendorDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderVendorDao;
import com.bul.zydex.model.PRVendor;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class PRVendorServiceImpl<T> extends GenericsServiceImpl<T> implements PRVendorService<T> {

    private PRVendorDao<T> prVendorDao;

    public PRVendorDao<T> getPrVendorDao() {
        return prVendorDao;
    }

    public void setPrVendorDao(PRVendorDao<T> prVendorDao) {
        this.prVendorDao = prVendorDao;
        setGenericsDAO(prVendorDao);
    }

    @Override
    public List readByRfqNo(String ref_no) {
        return prVendorDao.readByRfqNo(ref_no);
    }

    @Override
    public void delete1(int id) {
        prVendorDao.delete1(id);
    }

    @Override
    public PRVendor readId(int id) {
        return prVendorDao.readId(id);
    }

    @Override
    public void updatePRNo(String refNo1, String refNo) {
        prVendorDao.updatePRNo(refNo1, refNo);
    }

    @Override
    public List readByRfqVendor(String ref_no, String vendor_code) {
        return prVendorDao.readByRfqVendor(ref_no, vendor_code);

    }

}
