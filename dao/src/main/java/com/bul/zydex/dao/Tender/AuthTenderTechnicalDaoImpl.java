/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderTechnical;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuthTenderTechnicalDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderTechnicalDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderTechnical.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderTechnical a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateTechicalFile(String refNo, String technicalfile) {
        String query = "";
        query += " update AuthTenderTechnical a"
                + " set a.technicalDoc='"+technicalfile+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTermsConditionFile(String refNo, String technicalfile) {
        String query = "";
        query += " update AuthTenderTechnical a"
                + " set a.termsConditionDoc='"+technicalfile+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateRequiredDocFile(String refNo, String technicalfile) {
        String query = "";
        query += " update AuthTenderTechnical a"
                + " set a.document='"+technicalfile+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTechicalData(String refNo, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark) {
        String query = "";
        query += " update AuthTenderTechnical a"
                + " set a.remark='"+technicalRemark+"', "
                + " a.technicalRemark='"+technicalSpecRemark+"', "
                + " a.termsConditionRemark='"+termsRemark+"', "
                + " a.documentRemark='"+docRemark+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderTechnical a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
