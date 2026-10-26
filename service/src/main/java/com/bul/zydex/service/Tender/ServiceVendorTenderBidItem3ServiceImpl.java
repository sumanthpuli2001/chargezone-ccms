/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceVendorTenderBidItem3Dao;
import com.bul.zydex.model.ServiceVendorTenderBidItem3;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem3ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceVendorTenderBidItem3Service<T> {
    
    private ServiceVendorTenderBidItem3Dao<T> serviceVendorTenderBidItem3Dao;

    public ServiceVendorTenderBidItem3Dao<T> getServiceVendorTenderBidItem3Dao() {
        return serviceVendorTenderBidItem3Dao;
    }

    public void setServiceVendorTenderBidItem3Dao(ServiceVendorTenderBidItem3Dao<T> serviceVendorTenderBidItem3Dao) {
        this.serviceVendorTenderBidItem3Dao = serviceVendorTenderBidItem3Dao;
        setGenericsDAO(serviceVendorTenderBidItem3Dao);
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        return serviceVendorTenderBidItem3Dao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        return serviceVendorTenderBidItem3Dao.readItemVendorRefNo(refNo, username, file_name, sr_no);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String particular, String scheduled_amount, String percentage, String percentage_amount, String net_rate, String vendor_remark, String item_regret) {
        serviceVendorTenderBidItem3Dao.updateItemVendorRefNo(refNo, username, file_name, sr_no, particular, scheduled_amount, percentage, percentage_amount, net_rate, vendor_remark, item_regret);
    }
}
