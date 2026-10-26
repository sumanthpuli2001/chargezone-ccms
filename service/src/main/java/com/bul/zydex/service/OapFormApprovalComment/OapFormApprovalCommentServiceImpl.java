/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapFormApprovalComment;

import com.bul.zydex.dao.OapFormApprovalComment.OapFormApprovalCommentDao;
import com.bul.zydex.model.OapFormApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapFormApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements OapFormApprovalCommentService<T> {

    private OapFormApprovalCommentDao<T> oapFormApprovalCommentDao;

    public OapFormApprovalCommentDao<T> getOapFormApprovalCommentDao() {
	return oapFormApprovalCommentDao;
    }

    public void setOapFormApprovalCommentDao(OapFormApprovalCommentDao<T> oapFormApprovalCommentDao) {
	this.oapFormApprovalCommentDao = oapFormApprovalCommentDao;
	setGenericsDAO(oapFormApprovalCommentDao);
    }

   

    @Override
    public OapFormApprovalComment readByApproveId(int approvalid) {
	return oapFormApprovalCommentDao.readByApproveId(approvalid);
    }

    @Override
    public List readByIds(String id) {
	return oapFormApprovalCommentDao.readByIds(id);
    }

}
