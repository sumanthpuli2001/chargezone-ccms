/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.questionlibrary;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface QuestionAnsService<T> extends GenericsService<T> {

    public List<?> readByQLId(int qlId);

    public void deleteByQlId(T object);

    public List<?> takeTestOnlineAssementCandidateAnswer(int questionLibraryID);

    public List<?> deleteqlibryId(String libraryId);

}
