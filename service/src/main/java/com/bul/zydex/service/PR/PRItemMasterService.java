/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRItemMasterService<T> extends GenericsService<T> {

    public List readByRefNo(String ref_no, int item_type);

    public void deleteRefNo(String ref_no, int item_type);

    public PRItemMaster readId(int parseInt);

    public void updatePRNo(String refNo1, String refNo);

    public List readByPRItemDesc(String ref_no, String item_desc, int i);

    public int countByRefNo(String pr_no1, int i);

}
