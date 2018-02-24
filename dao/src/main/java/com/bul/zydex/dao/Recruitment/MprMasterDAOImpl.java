/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprMasterDAOImpl<T> extends GenericsDAOImpl<T> implements MprMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return MprMaster.class;
    }

    @Override
    public List<?> readMprList() {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.numberOfPosition, a.budget, a.experience, a.status"
                + " FROM MprMaster a "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readForMPRDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, b.location, c.departmentName, d.employeeCategory, e.employeeType, f.jobTypeName, a.name, a.numberOfPosition, a.budget, g.qulificationType, a.experience, a.description, h.designationName"
                + " FROM MprMaster a "
                + " LEFT JOIN a.locationMaster b "
                + " LEFT JOIN a.departmentMaster c "
                + " LEFT JOIN a.MprEmployeeCategory d "
                + " LEFT JOIN a.MprEmployeeTypeMaster e "
                + " LEFT JOIN a.jobtypeMaster f "
                + " LEFT JOIN a.QulificationMaster g "
                + " LEFT JOIN a.DesignationMaster h " 
                + " where (a.dateOfLeaving is null or a.dateOfLeaving = '') "
                + " or STR_TO_DATE(a.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()";
        
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
