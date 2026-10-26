/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderPreQualification;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderPreQualificationDaoImpl<T> extends GenericsDAOImpl<T> implements TenderPreQualificationDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderPreQualification.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderPreQualification a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updatRefNo(String refNo, String technicalfile) {
        String query = "";
        query += " update TenderPreQualification a"
                + " set a.document='"+technicalfile+"', "
                + " a.documentRefNo='"+refNo+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updatePreData(String refNo, String preRemark, String preDocRemark) {
        String query = "";
        query += " update TenderPreQualification a"
                + " set a.remark='"+preRemark+"', "
                + " a.documentRemark='"+preDocRemark+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateServicePreData(String refNo, String refNo1, String preRemark, String preDocRemark) {
        String query = "";
        query += " update TenderPreQualification a"
                + " set a.remark='"+preRemark+"', "
                + " a.refNo='"+refNo+"', "
                + " a.documentRemark='"+preDocRemark+"' "
                + " WHERE a.refNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
