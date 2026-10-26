/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRApprovalComment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author tailo
 */
public class PRApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements PRApprovalCommentDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return PRApprovalComment.class;
    }

    @Override
    public List readByPrNumber(String prNo) {
        String query = "";
        query += " FROM PRApprovalComment a"
                + " WHERE a.prNo = '"+ prNo+"'";
        return getHibernateTemplate().find(query);
    }
}
