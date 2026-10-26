/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TenderPreQualificationService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo);

    public void updatRefNo(String refNo, String technicalfile);

    public void updatePreData(String refNo, String preRemark, String preDocRemark);

    public void updateServicePreData(String refNo, String refNo1, String preRemark, String preDocRemark);
    
}
