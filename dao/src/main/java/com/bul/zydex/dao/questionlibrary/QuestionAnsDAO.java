/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface QuestionAnsDAO<T> extends GenericsDAO<T> {

    public List<?> readByQLId(int qlId);

    public void deleteByQlId(T object);

}
