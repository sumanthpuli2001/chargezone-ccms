/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionLibrary;

/**
 *
 * @author Rishi
 */
public class QuestionLibraryDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionLibraryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionLibrary.class;
    }

}
