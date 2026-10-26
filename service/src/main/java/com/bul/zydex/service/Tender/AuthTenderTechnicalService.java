/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.AuthTenderTechnical;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuthTenderTechnicalService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo);

    public void updateTechicalFile(String refNo, String technicalfile);

    public void updateTermsConditionFile(String refNo, String technicalfile);

    public void updateRequiredDocFile(String refNo, String technicalfile);

    public void updateTechicalData(String refNo, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark);

    public void deleteRefNo(String refNo);
    
}
