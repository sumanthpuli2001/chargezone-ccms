/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceVendorTenderBidItem2Dao;
import com.bul.zydex.model.ServiceVendorTenderBidItem2;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem2ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceVendorTenderBidItem2Service<T> {
    
    private ServiceVendorTenderBidItem2Dao<T> serviceVendorTenderBidItem2Dao;

    public ServiceVendorTenderBidItem2Dao<T> getServiceVendorTenderBidItem2Dao() {
        return serviceVendorTenderBidItem2Dao;
    }

    public void setServiceVendorTenderBidItem2Dao(ServiceVendorTenderBidItem2Dao<T> serviceVendorTenderBidItem2Dao) {
        this.serviceVendorTenderBidItem2Dao = serviceVendorTenderBidItem2Dao;
        setGenericsDAO(serviceVendorTenderBidItem2Dao);
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        return serviceVendorTenderBidItem2Dao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        return serviceVendorTenderBidItem2Dao.readItemVendorRefNo(refNo, username, file_name, sr_no);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String item_description, String onlyBearing1, String onlyBearing2, String onlyBearing3, String onlyBearing4, String onlyBearing5, String onlyBearing6, String onlyBearing7, String onlyBearing8, String onlyBearing9, String onlyBearing10) {
        serviceVendorTenderBidItem2Dao.updateItemVendorRefNo(refNo, username, file_name, sr_no, item_description, onlyBearing1, onlyBearing2, onlyBearing3, onlyBearing4, onlyBearing5, onlyBearing6, onlyBearing7, onlyBearing8, onlyBearing9, onlyBearing10);
    }
}
