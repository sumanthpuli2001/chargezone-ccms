/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.thought;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Gallery;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class GalleryDAOImpl<T> extends GenericsDAOImpl<T> implements GalleryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return Gallery.class;
    }

    @Override
    public List<?> readgalleryDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.imagesPath, a.disc"
                + " FROM Gallery a "
                + " ORDER BY a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public boolean isExist(String name) {
        boolean flag = false;
        List list = getHibernateTemplate().find("from Gallery where disc='" + name + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }
}
