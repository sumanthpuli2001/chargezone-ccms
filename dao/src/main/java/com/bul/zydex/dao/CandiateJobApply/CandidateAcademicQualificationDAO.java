/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CandidateAcademicQualification;
import java.util.List;

/**
 *
 * @author DELL3
 */
public interface CandidateAcademicQualificationDAO<T> extends GenericsDAO<T> {

    public CandidateAcademicQualification readByApplyJobId(int id);

    public List<?> readListByApplyJobId(Integer id);
}
