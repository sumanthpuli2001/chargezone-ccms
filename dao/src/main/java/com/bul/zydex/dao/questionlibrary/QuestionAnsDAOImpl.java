/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionAns;

/**
 *
 * @author Rishi
 */
public class QuestionAnsDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionAnsDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionAns.class;
    }

}
