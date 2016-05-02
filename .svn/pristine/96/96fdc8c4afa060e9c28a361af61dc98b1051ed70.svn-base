/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.PunchDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PunchServiceImpl<T> extends GenericsServiceImpl<T> implements PunchService<T> {

    protected PunchDAO<T> punchDAO;

    public PunchDAO<T> getPunchDAO() {
        return punchDAO;
    }

    public void setPunchDAO(PunchDAO<T> punchDAO) {
        this.punchDAO = punchDAO;
        setGenericsDAO(punchDAO);
    }

    @Override
    public List<?> readByPunchUserId(T object) {
        return punchDAO.readByPunchUserId(object);
    }

}
