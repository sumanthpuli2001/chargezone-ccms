/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface TrainingAssessmentService<T> extends GenericsService<T> {

    public List<?> readOnlineAssementCandidateTraningList(int empid);

    public List<?> readTrainingAssementList(int trainerId);
}
