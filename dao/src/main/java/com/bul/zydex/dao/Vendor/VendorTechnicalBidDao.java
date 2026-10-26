/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorTechnicalBid;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorTechnicalBidDao<T> extends GenericsDAO<T> {

    public VendorTechnicalBid readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username);

    public void updateVendorRefNo(String refNo, String username, String technicalBidDeviation, String technicalBidRemark);

    public List vendorList(String refNo);

    public List techBidList(String refNo);

    public List techBidOpenList(String refNo);

    public void openTechBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate);

    public void approveTechBid(String refNo, String checkedValues, String employee_name, String username, String formattedDate);

    public List techBidOpenList1(String refNo);

    public List checkBidOpen(String refNo);

    public List readByVendorRefNo1(String refNo);

    public void readByDelete(String refNo, String username);

    public boolean readByRefNO(String refNo);

    public List techBidOpenListPrSummary(String refNo);

}
