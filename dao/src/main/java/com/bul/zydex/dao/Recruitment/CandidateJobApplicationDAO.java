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
 * @author Vikas
 */
public interface CandidateJobApplicationDAO<T> extends GenericsDAO<T> {

    public List<?> readByCandidateId(int candidateId);

    public List<?> readOnlineAssementCandidate(int userMaster);

}
