/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ClassifiedBox;

import com.bul.zydex.dao.ClassifiedBox.ClassifiedBoxDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Hussain
 */
public class ClassifiedBoxServiceImpl<T> extends GenericsServiceImpl<T> implements ClassifiedBoxService<T> {
   private ClassifiedBoxDAO<T> classifiedBoxDAO; 

    public ClassifiedBoxDAO<T> getClassifiedBoxDAO() {
        return classifiedBoxDAO;
    }

    public void setClassifiedBoxDAO(ClassifiedBoxDAO<T> classifiedBoxDAO) {
        this.classifiedBoxDAO = classifiedBoxDAO;
        setGenericsDAO(classifiedBoxDAO);
    }
   
}
