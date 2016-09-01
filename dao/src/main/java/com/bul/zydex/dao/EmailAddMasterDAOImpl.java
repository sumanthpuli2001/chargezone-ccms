/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.EmailAddMaster;



/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailAddMasterDAOImpl<T> extends GenericsDAOImpl<T> implements EmailAddMasterDAO<T> {

    public Class getDomainClass() {
        return EmailAddMaster.class;
    }
}
