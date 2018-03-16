/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.QuestionAnswerSubmit;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface QuestionAnswerSubmitService<T> extends GenericsService<T> {

    public List<?> readByCandidateApplicationId(int appId);
}
