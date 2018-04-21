/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.FormateFullNdFinalLetter;

import com.bul.zydex.dao.FullAndFinalSetllement.FormateFullNdFinalLetterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class FormateFullNdFinalLetterServiceImpl<T> extends GenericsServiceImpl<T> implements FormateFullNdFinalLetterService<T>{

    private FormateFullNdFinalLetterDAO<T> formateFullNdFinalLetterDAO;

    public FormateFullNdFinalLetterDAO<T> getFormateFullNdFinalLetterDAO() {
        return formateFullNdFinalLetterDAO;
    }

    public void setFormateFullNdFinalLetterDAO(FormateFullNdFinalLetterDAO<T> formateFullNdFinalLetterDAO) {
        this.formateFullNdFinalLetterDAO = formateFullNdFinalLetterDAO;
        setGenericsDAO(formateFullNdFinalLetterDAO);
    }

    @Override
    public List<?> fetchFnFDate() {
        return formateFullNdFinalLetterDAO.fetchFnFDate();
    }
    
    
}
