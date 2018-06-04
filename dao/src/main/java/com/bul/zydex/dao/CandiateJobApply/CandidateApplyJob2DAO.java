/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CandidateApplyJob2;

/**
 *
 * @author DELL3
 */
public interface CandidateApplyJob2DAO<T> extends GenericsDAO<T> {
    public CandidateApplyJob2 readByApplyJobId(int id);
}
