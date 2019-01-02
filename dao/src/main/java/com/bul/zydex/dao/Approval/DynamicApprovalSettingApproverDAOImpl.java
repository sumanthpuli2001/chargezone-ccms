/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DynamicApprovalSettingApprover;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingApproverDAOImpl<T> extends GenericsDAOImpl<T> implements DynamicApprovalSettingApproverDAO<T> {

    @Override
    protected Class getDomainClass() {
        return DynamicApprovalSettingApprover.class;
    }

    @Override
    public List<?> readByDnamicApprovalSettingId(int ApproverId) {
        String query = "";

        query += " Select d "
                + " from DynamicApprovalSettingApprover d "
                + " left join d.dynamicApprovalSettingId da "
                + " where d.dynamicApprovalSettingId.id = " + ApproverId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByApproverSettingId(int ApproverId) {
        String query = "";

        query += " Delete from DynamicApprovalSettingApprover d "
                + " Where d.dynamicApprovalSettingId.id =" + ApproverId;

        getHibernateTemplate().bulkUpdate(query);
    }

    @Override
    public List<?> getByApproverId(int ApproverId) {
        String query = "";
        //      0   1    2     3    4     5     6       7
        query += " Select d.id,e.id,m.id,da.id,dm.id"
                + " from DynamicApprovalSettingApprover d "
                + " left join d.dynamicApprovalSettingId da "
                + " left join d.employeeMaster e "
//                + " left join da.company c "
                + " left join da.modules m "
                + " left join da.departmentMaster dm "
//                + " left join da.locationMaster l "
                + " where e.id = " + ApproverId
                + " and m.moduleName ='kaizen'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByzyLocIdCompnameAndDesId(int desId, String module) {
        String query = "";
                      //      0   1    2     3    4     5     6       7           8
        query += " Select da.id,e.id"
                + " from DynamicApprovalSettingApprover d "
                + " left join d.dynamicApprovalSettingId da "
                + " left join d.employeeMaster e "
//                + " left join da.company c "
                + " left join da.modules m "
                + " left join da.departmentMaster dm "
//                + " left join da.locationMaster l "
//                + " where l.id = " + zlocId
                + " where m.moduleName like '" + module + "'"
                + " and dm.id =" + desId
//                + " and c.companyName like '" + ComName + "'"
                + " group by d.id";
        return getHibernateTemplate().find(query);
    }
}
