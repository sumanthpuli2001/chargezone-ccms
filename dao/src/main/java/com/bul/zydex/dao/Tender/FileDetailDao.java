/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.FileDetail;
import java.util.List;
/**
 *
 * @author admin
 */
public interface FileDetailDao<T> extends GenericsDAO<T> {

    public List readRefNo(String ref_no);

    public List readByRefNo(String ref_no, String service_file1);

    public void deleteFile(String ref_no, String file_name);

    public void updateTenderNo(String refNo1, String refNo);

    public List readTenderNo(String refNo);

    public List readByTenderNo(String ref_no, String service_file1);
    
}
