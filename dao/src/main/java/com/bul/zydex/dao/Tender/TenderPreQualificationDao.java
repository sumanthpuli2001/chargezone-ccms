/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderPreQualification;
import java.util.List;


/**
 *
 * @author admin
 */
public interface TenderPreQualificationDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo);

    public void updatRefNo(String refNo, String technicalfile);

    public void updatePreData(String refNo, String preRemark, String preDocRemark);

    public void updateServicePreData(String refNo, String refNo1, String preRemark, String preDocRemark);
    
}
