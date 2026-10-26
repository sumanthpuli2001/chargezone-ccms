/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SiteSurveyCategoryDetails;

import com.bul.zydex.dao.SiteSurveyCategoryDetails.SiteSurveyCategoryDetailsDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Sumanth
 */
public class SiteSurveyCategoryDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements SiteSurveyCategoryDetailsService<T> {

    private SiteSurveyCategoryDetailsDao<T> siteSurveyCategoryDetailsDao;

    public SiteSurveyCategoryDetailsDao<T> getSiteSurveyCategoryDetailsDao() {
        return siteSurveyCategoryDetailsDao;
    }

    public void setSiteSurveyCategoryDetailsDao(SiteSurveyCategoryDetailsDao<T> siteSurveyCategoryDetailsDao) {
        this.siteSurveyCategoryDetailsDao = siteSurveyCategoryDetailsDao;
        setGenericsDAO(siteSurveyCategoryDetailsDao);

    }

}
