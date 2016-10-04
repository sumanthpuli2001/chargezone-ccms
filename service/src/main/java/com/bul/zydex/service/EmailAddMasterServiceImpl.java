/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.EmailAddMasterDAO;
import com.bul.zydex.dao.EmailTemplateDAO;
import java.util.List;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailAddMasterServiceImpl<T> extends GenericsServiceImpl<T> implements EmailAddMasterService<T> {

    protected EmailAddMasterDAO<T> emailAddMasterDAO;

    public EmailAddMasterDAO<T> getEmailAddMasterDAO() {
        return emailAddMasterDAO;
    }

    public void setEmailAddMasterDAO(EmailAddMasterDAO<T> emailAddMasterDAO) {
        this.emailAddMasterDAO = emailAddMasterDAO;
                 setGenericsDAO(emailAddMasterDAO);
    }
     public List<?> readByName(T object){
         return emailAddMasterDAO.readByName(object);
     }

    @Override
    public List<?> readAllDept(String modulename) {
         return emailAddMasterDAO. readAllDept(modulename); 
    }
    
}
