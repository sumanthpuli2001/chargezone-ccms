/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CorporateVideo;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CorporateVideo;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class CorporateVideoDAOImpl<T> extends GenericsDAOImpl<T> implements CorporateVideoDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CorporateVideo.class;
    }

    @Override
    public List<?> readCorporateVideoDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.corporateVideoPath, a.disc"
                + " FROM CorporateVideo a ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
