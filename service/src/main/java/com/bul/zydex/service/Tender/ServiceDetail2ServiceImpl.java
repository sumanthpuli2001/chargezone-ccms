/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceDetail2Dao;
import com.bul.zydex.model.ServiceDetail2;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceDetail2ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceDetail2Service<T> {
    
    private ServiceDetail2Dao<T> serviceDetail2Dao;

    public ServiceDetail2Dao<T> getServiceDetail2Dao() {
        return serviceDetail2Dao;
    }

    public void setServiceDetail2Dao(ServiceDetail2Dao<T> serviceDetail2Dao) {
        this.serviceDetail2Dao = serviceDetail2Dao;
        setGenericsDAO(serviceDetail2Dao);
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        return serviceDetail2Dao.readRefNo(file_name, ref_no);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        serviceDetail2Dao.deleteFile(ref_no, file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        serviceDetail2Dao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        return serviceDetail2Dao.readTenderNo(file_name, refNo);
    }
}
