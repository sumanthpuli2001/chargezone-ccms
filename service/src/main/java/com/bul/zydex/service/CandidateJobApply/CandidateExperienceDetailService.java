/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.model.CandidateExperienceDetail;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author DELL3
 */
public interface CandidateExperienceDetailService<T> extends GenericsService<T> {

    public CandidateExperienceDetail readByApplyJobId(int id);

    public List<?> readListByApplyJobId(Integer id);

}
