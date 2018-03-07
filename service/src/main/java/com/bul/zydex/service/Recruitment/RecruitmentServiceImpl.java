/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.RecruitmentDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class RecruitmentServiceImpl<T> extends GenericsServiceImpl<T> implements RecruitmentService<T> {

    private RecruitmentDAO<T> recruitmentDAO;

    public RecruitmentDAO<T> getRecruitmentDAO() {
        return recruitmentDAO;
    }

    public void setRecruitmentDAO(RecruitmentDAO<T> recruitmentDAO) {
        this.recruitmentDAO = recruitmentDAO;
        setGenericsDAO(recruitmentDAO);
    }

    @Override
    public List<?> readBudgetDetail() {
        return recruitmentDAO.readBudgetDetail();
    }
    @Override
    public List<?> readForBudgetDetail() {
        return recruitmentDAO.readForBudgetDetail();
    }
    @Override
    public List<?> searchMppApproval() {
        return recruitmentDAO.searchMppApproval();
    }

}
