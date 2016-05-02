/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class GenericsServiceImpl<T> implements GenericsService<T>{
     private GenericsDAO<T> genericsDAO;

    @Override
    public int count() {
        return genericsDAO.count();
    }

    @Override
    public void create(T object) {
        genericsDAO.create(object);
    }

    @Override
    public void createOrUpdate(T object) {
        genericsDAO.createOrUpdate(object);
    }

    @Override
    public void delete(final Integer id) {
        genericsDAO.delete(id);
    }

    public GenericsDAO<T> getGenericsDAO() {
        return genericsDAO;
    }

    @Override
    public List<?> read() {
        return genericsDAO.read();
    }

    @Override
    public T readById(final Integer id) {
        return genericsDAO.readById(id);
    }

    public void setGenericsDAO(GenericsDAO<T> genericsDAO) {
        this.genericsDAO = genericsDAO;
    }

    @Override
    public void update(T object) {
        genericsDAO.update(object);
    }



}
