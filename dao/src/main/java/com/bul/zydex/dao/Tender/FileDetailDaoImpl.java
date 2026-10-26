/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.FileDetail;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class FileDetailDaoImpl<T> extends GenericsDAOImpl<T> implements FileDetailDao<T> {
 
    @Override
    protected Class getDomainClass() {
        return FileDetail.class;
    }

    @Override
    public List readRefNo(String ref_no) {
        String query = "";
        query += " FROM FileDetail a"
                + " WHERE a.refNo = '" + ref_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNo(String ref_no, String service_file1) {
        String query = "";
        query += " FROM FileDetail a"
                + " WHERE a.refNo = '" + ref_no + "' and a.fileName = '"+service_file1+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        String query = "";
            query += " delete from FileDetail a"
                + " WHERE a.refNo = '" + ref_no + "' and a.fileName = '"+file_name+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        String query = "";
            query += " update FileDetail a"
                + " set a.tenderNo = '"+refNo+"'"
                + " WHERE a.refNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readTenderNo(String refNo) {
        String query = "";
        query += " FROM FileDetail a"
                + " WHERE a.tenderNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByTenderNo(String ref_no, String service_file1) {
        String query = "";
        query += " FROM FileDetail a"
                + " WHERE a.tenderNo = '" + ref_no + "' and a.fileName = '"+service_file1+"'";
        return getHibernateTemplate().find(query);
    }
}
