/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ManagerialPerson;

import com.bul.zydex.dao.ManagerialPerson.ManagerialPersonDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ManagerialPersonServiceImpl<T> extends GenericsServiceImpl<T> implements ManagerialPersonService<T> {

    private ManagerialPersonDao<T> managerialPersonDao;

    public ManagerialPersonDao<T> getManagerialPersonDao() {
        return managerialPersonDao;
    }

    public void setManagerialPersonDao(ManagerialPersonDao<T> managerialPersonDao) {
        this.managerialPersonDao = managerialPersonDao;
        setGenericsDAO(managerialPersonDao);
    }

    @Override
    public List readInvitationId(int invitationId) {
        return managerialPersonDao.readInvitationId(invitationId);
    }
}
