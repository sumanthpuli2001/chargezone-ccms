/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceVendorTenderBidItem6Dao;
import com.bul.zydex.model.ServiceVendorTenderBidItem6;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem6ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceVendorTenderBidItem6Service<T> {
    
    private ServiceVendorTenderBidItem6Dao<T> serviceVendorTenderBidItem6Dao;

    public ServiceVendorTenderBidItem6Dao<T> getServiceVendorTenderBidItem6Dao() {
        return serviceVendorTenderBidItem6Dao;
    }

    public void setServiceVendorTenderBidItem6Dao(ServiceVendorTenderBidItem6Dao<T> serviceVendorTenderBidItem6Dao) {
        this.serviceVendorTenderBidItem6Dao = serviceVendorTenderBidItem6Dao;
        setGenericsDAO(serviceVendorTenderBidItem6Dao);
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        return serviceVendorTenderBidItem6Dao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        return serviceVendorTenderBidItem6Dao.readItemVendorRefNo(refNo, username, file_name, sr_no);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String pc_type, String item_description, String uom, String qty, String amc_required_day, String rate, String net_rate, String vendor_remark, String item_regret) {
        serviceVendorTenderBidItem6Dao.updateItemVendorRefNo(refNo, username, file_name, sr_no, pc_type, item_description, uom, qty, amc_required_day, rate, net_rate, vendor_remark, item_regret);
    }
}
