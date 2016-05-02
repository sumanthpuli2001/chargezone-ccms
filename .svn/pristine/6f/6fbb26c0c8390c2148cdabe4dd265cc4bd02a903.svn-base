/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.PipMeetingDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PipMeetingServiceImpl<T> extends GenericsServiceImpl<T> implements PipMeetingService<T> {

    protected PipMeetingDAO<T> pipMeetingDAO;

    public PipMeetingDAO<T> getPipMeetingDAO() {
        return pipMeetingDAO;
    }

    public void setPipMeetingDAO(PipMeetingDAO<T> pipMeetingDAO) {
        this.pipMeetingDAO = pipMeetingDAO;
        setGenericsDAO(pipMeetingDAO);
    }

    @Override
    public List<?> readPipMeetingByPipMaster(T object) {
        return pipMeetingDAO.readPipMeetingByPipMaster(object);
    }

}
