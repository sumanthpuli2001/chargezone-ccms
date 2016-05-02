/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.ShortLeaveDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Khurshid Khokhar <Khokharkhurshid123@gmail.com>
 */
public class ShortLeaveServiceImpl<T> extends GenericsServiceImpl<T> implements ShortLeaveService<T> {
    
    protected ShortLeaveDAO<T> ShortLeaveDAO;
    
    public ShortLeaveDAO<T> getShortLeaveDAO() {
        return ShortLeaveDAO;
    }
    
    public void setShortLeaveDAO(ShortLeaveDAO<T> ShortLeaveDAO) {
        this.ShortLeaveDAO = ShortLeaveDAO;
        setGenericsDAO(ShortLeaveDAO);
    }
    
    @Override
    public boolean isExist(T object) {
        return ShortLeaveDAO.isExist(object);
    }

    @Override
    public List<?> readByDept(T object) {
        return ShortLeaveDAO.readByDept(object);
    }
    
}
