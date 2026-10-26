/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceVendorTenderBidItemDao;
import com.bul.zydex.model.ServiceVendorTenderBidItem;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItemServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceVendorTenderBidItemService<T> {

    private ServiceVendorTenderBidItemDao<T> serviceVendorTenderBidItemDao;

    public ServiceVendorTenderBidItemDao<T> getServiceVendorTenderBidItemDao() {
        return serviceVendorTenderBidItemDao;
    }

    public void setServiceVendorTenderBidItemDao(ServiceVendorTenderBidItemDao<T> serviceVendorTenderBidItemDao) {
        this.serviceVendorTenderBidItemDao = serviceVendorTenderBidItemDao;
        setGenericsDAO(serviceVendorTenderBidItemDao);
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        return serviceVendorTenderBidItemDao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        return serviceVendorTenderBidItemDao.readItemVendorRefNo(refNo, username, file_name, sr_no);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String item_description, String item_remark, String uom, String qty, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret) {
        serviceVendorTenderBidItemDao.updateItemVendorRefNo(refNo, username, file_name, sr_no, item_description, item_remark, uom, qty, unit_rate, net_rate, hsn_no, vendor_remark, item_discount_val, item_discount, item_packing_val, item_packing, item_freight_val, item_freight, item_errection, item_other_charge, item_igst, item_cgst, item_sgst, item_insurance_value, item_total, item_regret);
    }

    @Override
    public ServiceVendorTenderBidItem readByVendorRefNo(String refNo, String username, String file_name, String sr_no1) {
        return serviceVendorTenderBidItemDao.readByVendorRefNo(refNo,username, file_name,sr_no1);
    }

    @Override
    public void updateItemVendorRefNo1(String refNo, String username, String file_name, String sr_no1, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value1, String grand_total1) {
        serviceVendorTenderBidItemDao.updateItemVendorRefNo1(refNo, username, file_name, sr_no1, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value1, grand_total1);
    }
}
