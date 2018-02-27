/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.thought;

import com.bul.zydex.dao.thought.RAndRDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class RAndRServiceImpl<T> extends GenericsServiceImpl<T>
        implements RAndRService<T> {
    protected RAndRDAO<T> rAndRDAO;

    public RAndRDAO<T> getrAndRDAO() {
        return rAndRDAO;
    }

    public void setrAndRDAO(RAndRDAO<T> rAndRDAO) {
        this.rAndRDAO = rAndRDAO;
        setGenericsDAO(rAndRDAO);
    }

    @Override
    public List<?> readrandrDetail() {
        return rAndRDAO.readrandrDetail();
    }

    @Override
    public boolean isExist(String name) {
        return rAndRDAO.isExist(name);
    }

}
