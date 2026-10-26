/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ServiceDetail4;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceDetail4Dao<T> extends GenericsDAO<T> {

    public List readRefNo(String file_name, String ref_no);

    public void deleteFile(String ref_no, String file_name);

    public void updateTenderNo(String refNo1, String refNo);

    public List readTenderNo(String file_name, String refNo);
    
}
