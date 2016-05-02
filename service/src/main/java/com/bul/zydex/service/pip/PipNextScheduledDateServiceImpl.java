/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.PipNextScheduledDateDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PipNextScheduledDateServiceImpl<T> extends GenericsServiceImpl<T> implements PipNextScheduledDateService<T> {

    protected PipNextScheduledDateDAO<T> pipNextScheduledDateDAO;

    public PipNextScheduledDateDAO<T> getPipNextScheduledDateDAO() {
        return pipNextScheduledDateDAO;
    }

    public void setPipNextScheduledDateDAO(PipNextScheduledDateDAO<T> pipNextScheduledDateDAO) {
        this.pipNextScheduledDateDAO = pipNextScheduledDateDAO;
        setGenericsDAO(pipNextScheduledDateDAO);
    }

    public List<?> readPipNextScheduledDateByPipMaster(T object) {
        return pipNextScheduledDateDAO.readPipNextScheduledDateByPipMaster(object);
    }

}
