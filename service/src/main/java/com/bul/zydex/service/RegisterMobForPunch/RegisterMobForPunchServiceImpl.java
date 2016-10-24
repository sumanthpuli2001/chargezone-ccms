/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RegisterMobForPunch;

import com.bul.zydex.dao.RegisterMobForPunch.RegisterMobForPunchDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public class RegisterMobForPunchServiceImpl<T> extends GenericsServiceImpl<T> implements RegisterMobForPunchService<T>{
     protected RegisterMobForPunchDAO<T> registerMobForPunchDAO;

    public RegisterMobForPunchDAO<T> getRegisterMobForPunchDAO() {
        return registerMobForPunchDAO;
    }

    public void setRegisterMobForPunchDAO(RegisterMobForPunchDAO<T> registerMobForPunchDAO) {
        this.registerMobForPunchDAO = registerMobForPunchDAO;
        setGenericsDAO(registerMobForPunchDAO);
    }

    @Override
    public List<?> readByEmpId(int id) {
        return registerMobForPunchDAO.readByEmpId(id);
    }
     
    
}
