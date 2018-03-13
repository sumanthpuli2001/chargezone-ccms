package com.bul.zydex.dao.ClassifiedBox;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ClassifiedBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hussain
 */
public class ClassifiedBoxDAOImpl<T> extends GenericsDAOImpl<T> implements ClassifiedBoxDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ClassifiedBox.class;
    }

}
