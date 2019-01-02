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
 * @author Dell-1
 */
public interface TrainingMasterService<T> extends GenericsService<T> {

    public void deletetrainingSubMaster(final Integer id);

    public List<?> readTrainingMasterList();

    public List<?> fetchtrainingMaster(String date);

    public List<?> fetchtTrainingforFeedback(int traininigId, int user);

    public List<?> fetchtTrainingforFeedback1(int traininigId, int user);

    public List<?> fetchtTrainingforFeedback2(int traininigId);

    public List<?> readTrainingMasterSummaryList();
}
