/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcFormApprovalComment;

import com.bul.zydex.dao.CrcFormApprovalComment.CrcFormApprovalCommentDao;
import com.bul.zydex.model.CrcFormApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CrcFormApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements CrcFormApprovalCommentService<T> {

    private CrcFormApprovalCommentDao<T> crcFormApprovalCommentDao;

    public CrcFormApprovalCommentDao<T> getCrcFormApprovalCommentDao() {
	return crcFormApprovalCommentDao;
    }

    public void setCrcFormApprovalCommentDao(CrcFormApprovalCommentDao<T> crcFormApprovalCommentDao) {
	this.crcFormApprovalCommentDao = crcFormApprovalCommentDao;
	setGenericsDAO(crcFormApprovalCommentDao);

    }

    @Override
    public CrcFormApprovalComment readByApproveId(int approvalid) {

	return crcFormApprovalCommentDao.readByApproveId(approvalid);

    }

    @Override
    public List readBycrcformid(int crcformid) {
	return crcFormApprovalCommentDao.readBycrcformid(crcformid);

    }

    @Override
    public List readBycrcFormApprovalid(int crcFormApprovalid) {
	return crcFormApprovalCommentDao.readBycrcFormApprovalid(crcFormApprovalid);
    }

}
