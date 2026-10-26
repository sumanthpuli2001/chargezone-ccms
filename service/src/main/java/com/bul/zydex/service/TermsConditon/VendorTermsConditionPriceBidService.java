/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.model.VendorTermsConditionPriceBid;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface VendorTermsConditionPriceBidService <T> extends GenericsService<T> {

    public List readByRef(String ref, String username);

    public VendorTermsConditionPriceBid readByTerms(String refNo, String username, String termsCondition);
    
}
