/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.OnlineAssessmentDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OnlineAssessmentServiceImpl<T> extends GenericsServiceImpl<T> implements OnlineAssessmentService<T> {

    protected OnlineAssessmentDAO<T> onlineAssessmentDAO;

    public OnlineAssessmentDAO<T> getOnlineAssessmentDAO() {
        return onlineAssessmentDAO;
    }

    public void setOnlineAssessmentDAO(OnlineAssessmentDAO<T> onlineAssessmentDAO) {
        this.onlineAssessmentDAO = onlineAssessmentDAO;
        setGenericsDAO(onlineAssessmentDAO);
    }

    @Override
    public List<?> readOnlineAssementCandidateList(int candidateJobApplicationID) {
      return onlineAssessmentDAO.readOnlineAssementCandidateList(candidateJobApplicationID);
    }
    
    

}
