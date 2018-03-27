/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OnlineAssessmentDAO<T> extends GenericsDAO<T> {

    public List<?> readOnlineAssementCandidateList(int candidateJobApplicationID);

    public List<?> getOnlineAssementCandidateList(int candidateJobApplicationID);
}
