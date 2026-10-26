/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuthTenderMaster;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuthTenderMasterDao<T> extends GenericsDAO<T> {
    
    public List readByRefNo(String refNo);

    public List vendorLiveTender(String username);

    public AuthTenderMaster readByVendorRefNo(String refNo, String username);
    
    public AuthTenderMaster readByRefNo1(String refNo);

    public List unauthorizeTender(String username, String location, String department);

    public void authorizeTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void recycleTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void rejectTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void updateTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public List recycleTenderList(String username, String location, String department);

    public List rejectTenderList(String username, String location, String department);

    public void recycleTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void updateTenderData(String refNo, String title1, String category_id1, String value1, String emd1, String doc_cost1, String type1, String contact_person1, String location1, String announce_date1, String collection_lastdate1, String submit_lastdate1, String work_desc1, String tender_remark1, String tender_admin1, String tender_admin_contact_number1, String tender_authorize_person1, String tender_authorize_contact_no1, int authorize_flag1, String tender_authorize_user_name1, int re_autho_flag1, int _in_autho_table1, int vendor_flag1, int item_flag1, int email_flag1, String authorize_date1, int return_flag1, int delete_flag1, int tender_phase1, int open_bid_flag1, String department1, String pr_no1);

    public void authTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);

    public void deleteRefNo(String refNo);

    public void authTenderSave(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark);
    
}
