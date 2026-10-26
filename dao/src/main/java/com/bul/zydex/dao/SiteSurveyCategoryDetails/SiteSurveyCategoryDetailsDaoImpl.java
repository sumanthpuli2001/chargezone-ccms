/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SiteSurveyCategoryDetails;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SiteSurveyCategoryDetails;

/**
 *
 * @author Sumanth
 */
public class SiteSurveyCategoryDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements SiteSurveyCategoryDetailsDao<T> {

    @Override
    protected Class getDomainClass() {
        return SiteSurveyCategoryDetails.class;
    }
    
}
