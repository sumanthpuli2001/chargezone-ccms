/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceDetail4;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceDetail4DaoImpl<T> extends GenericsDAOImpl<T> implements ServiceDetail4Dao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ServiceDetail4.class;
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        String query = "";
        query += " FROM ServiceDetail4 a"
                + " WHERE a.refNo = '" + ref_no + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        String query = "";
            query += " delete from ServiceDetail4 a"
                + " WHERE a.refNo = '" + ref_no + "' and a.fileName = '"+file_name+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        String query = "";
            query += " update ServiceDetail4 a"
                + " set a.tenderNo = '"+refNo+"'"
                + " WHERE a.refNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        String query = "";
        query += " FROM ServiceDetail4 a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }
}
