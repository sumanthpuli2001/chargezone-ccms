/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormApprovalComment;

import com.bul.zydex.dao.KickOffFormApprovalComment.KickOffFormApprovalCommentDao;
import com.bul.zydex.model.KickOffFormApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffFormApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements KickOffFormApprovalCommentService<T> {

    private KickOffFormApprovalCommentDao<T> kickOffFormApprovalCommentDao;

    public KickOffFormApprovalCommentDao<T> getKickOffFormApprovalCommentDao() {
	return kickOffFormApprovalCommentDao;
    }

    public void setKickOffFormApprovalCommentDao(KickOffFormApprovalCommentDao<T> kickOffFormApprovalCommentDao) {
	this.kickOffFormApprovalCommentDao = kickOffFormApprovalCommentDao;
	setGenericsDAO(kickOffFormApprovalCommentDao);

    }

    @Override
    public KickOffFormApprovalComment readByApproveId(int approvalid) {

	return kickOffFormApprovalCommentDao.readByApproveId(approvalid);

    }

    @Override
    public List readByapproveId(int approvalid) {
	return kickOffFormApprovalCommentDao.readByapproveId(approvalid);
    }

}
