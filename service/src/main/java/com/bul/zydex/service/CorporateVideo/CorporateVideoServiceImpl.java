/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.CorporateVideo;

import com.bul.zydex.dao.CorporateVideo.CorporateVideoDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class CorporateVideoServiceImpl<T> extends GenericsServiceImpl<T>
        implements CorporateVideoService<T> {
    protected CorporateVideoDAO<T> corporateVideoDAO;

    public CorporateVideoDAO<T> getCorporateVideoDAO() {
        return corporateVideoDAO;
    }

    public void setCorporateVideoDAO(CorporateVideoDAO<T> corporateVideoDAO) {
        this.corporateVideoDAO = corporateVideoDAO;
        setGenericsDAO(corporateVideoDAO);
    }

    @Override
    public List<?> readCorporateVideoDetail() {
         return corporateVideoDAO.readCorporateVideoDetail();
    }

}
