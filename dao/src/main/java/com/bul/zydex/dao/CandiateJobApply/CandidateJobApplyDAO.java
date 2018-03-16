/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CandidateApplyJob;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface CandidateJobApplyDAO<T> extends GenericsDAO<T> {

    public List<?> fetchcandidatelist();

    public List<?> readProfileByCandidateUserID(int userId);

    public List<?> readOnlineAssementCandidate(int userMaster);

    public CandidateApplyJob readByapplayjobusermasterid(int id);
    
    public boolean isExist(String name);
    
     public boolean isExistCertificateAttach(String name);

}
