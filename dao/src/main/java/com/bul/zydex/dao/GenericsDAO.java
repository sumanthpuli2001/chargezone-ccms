/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import java.util.List;

/**
 *
 * @author dhruv
 */
public interface GenericsDAO<T> {

    public int count();

    public void create(T object);

    public void createOrUpdate(T object);

    public void delete(final Integer id);

    public List<?> read();

    public T readById(final Integer id);

    public void update(T object);

    boolean isExist(T object);
}
