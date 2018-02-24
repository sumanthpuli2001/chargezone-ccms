/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.thought;

import com.bul.zydex.dao.thought.GalleryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class GalleryServiceImpl<T> extends GenericsServiceImpl<T>
        implements GalleryService<T> {
    protected GalleryDAO<T> GalleryDAO;

    public GalleryDAO<T> getGalleryDAO() {
        return GalleryDAO;
    }

    public void setGalleryDAO(GalleryDAO<T> GalleryDAO) {
        this.GalleryDAO = GalleryDAO;
        setGenericsDAO(GalleryDAO);
    }

    @Override
    public List<?> readgalleryDetail() {
        return GalleryDAO.readgalleryDetail();
    }

    @Override
    public boolean isExist(String name) {
        return GalleryDAO.isExist(name);
    }

}
