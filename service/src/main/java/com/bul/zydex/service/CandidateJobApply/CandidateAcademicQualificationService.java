/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author DELL3
 */
public interface CandidateAcademicQualificationService<T> extends GenericsService<T> {

    public CandidateAcademicQualification readByApplyJobId(int id);

    public List<?> readListByApplyJobId(Integer id);
}
