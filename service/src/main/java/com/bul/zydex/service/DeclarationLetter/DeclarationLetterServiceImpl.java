/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DeclarationLetter;

import com.bul.zydex.dao.DeclarationLetter.DeclarationLetterDao;
import com.bul.zydex.model.DeclarationLetter;
import com.bul.zydex.service.GenericsServiceImpl;


/**
 *
 * @author Admin
 */
public class DeclarationLetterServiceImpl<T> extends GenericsServiceImpl<T> implements DeclarationLetterService<T>{
    private DeclarationLetterDao<T> declarationLetterDao;

    public DeclarationLetterDao<T> getDeclarationLetterDao() {
        return declarationLetterDao;
    }

    public void setDeclarationLetterDao(DeclarationLetterDao<T> declarationLetterDao) {
        this.declarationLetterDao = declarationLetterDao;
        setGenericsDAO(declarationLetterDao);
    }

    @Override
    public DeclarationLetter getSingle() {
        return declarationLetterDao.getSingle();
    }

}
