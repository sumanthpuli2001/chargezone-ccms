/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormApprovalComment;

import com.bul.zydex.dao.AocFormApprovalComment.AocFormApprovalCommentDao;
import com.bul.zydex.model.AocFormApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormApprovalCommentService<T> {

    private AocFormApprovalCommentDao<T> aocFormApprovalCommentDao;

    public AocFormApprovalCommentDao<T> getAocFormApprovalCommentDao() {
	return aocFormApprovalCommentDao;
    }

    public void setAocFormApprovalCommentDao(AocFormApprovalCommentDao<T> aocFormApprovalCommentDao) {
	this.aocFormApprovalCommentDao = aocFormApprovalCommentDao;
	setGenericsDAO(aocFormApprovalCommentDao);
    }

    @Override
    public AocFormApprovalComment readByApprovalId(int approvalid) {
	return aocFormApprovalCommentDao.readByApproveId(approvalid);
    }

    @Override
    public List readByIds( String id) {
	return aocFormApprovalCommentDao.readByIds(id);

    }

}
