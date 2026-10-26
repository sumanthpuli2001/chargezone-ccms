/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderTechnical;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderTechnicalDaoImpl<T> extends GenericsDAOImpl<T> implements TenderTechnicalDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderTechnical.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderTechnical a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateTechicalFile(String refNo, String technicalfile) {
        String query = "";
        query += " update TenderTechnical a"
                + " set a.technicalDoc='"+technicalfile+"', "
                + " a.technicalRefNo='"+refNo+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTermsConditionFile(String refNo, String technicalfile) {
        String query = "";
        query += " update TenderTechnical a"
                + " set a.termsConditionDoc='"+technicalfile+"', "
                + " a.termsRefNo='"+refNo+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateRequiredDocFile(String refNo, String technicalfile) {
        String query = "";
        query += " update TenderTechnical a"
                + " set a.document='"+technicalfile+"', "
                + " a.documentRefNo='"+refNo+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTechicalData(String refNo, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark) {
        String query = "";
        query += " update TenderTechnical a"
                + " set a.remark='"+technicalRemark+"', "
                + " a.technicalRemark='"+technicalSpecRemark+"', "
                + " a.termsConditionRemark='"+termsRemark+"', "
                + " a.documentRemark='"+docRemark+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateServiceTechicalData(String refNo, String refNo1, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark) {
        String query = "";
        query += " update TenderTechnical a"
                + " set a.remark='"+technicalRemark+"', "
                + " a.refNo='"+refNo+"', "
                + " a.technicalRemark='"+technicalSpecRemark+"', "
                + " a.termsConditionRemark='"+termsRemark+"', "
                + " a.documentRemark='"+docRemark+"' "
                + " WHERE a.refNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
