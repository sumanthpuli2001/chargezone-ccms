/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderPreQualification;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuthTenderPreQualificationDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderPreQualificationDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderPreQualification.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderPreQualification a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updatRefNo(String refNo, String technicalfile) {
        String query = "";
        query += " update AuthTenderPreQualification a"
                + " set a.document='"+technicalfile+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updatePreData(String refNo, String preRemark, String preDocRemark) {
        String query = "";
        query += " update AuthTenderPreQualification a"
                + " set a.remark='"+preRemark+"', "
                + " a.documentRemark='"+preDocRemark+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderPreQualification a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
