/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.empreferral;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeReferral;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class EmployeeReferralDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeReferralDAO<T> {

    @Override//this method is alse used in method createViewReferral
    public List<?> readEmpForReferral(T object) {
        EmployeeReferral employeeReferral = (EmployeeReferral) object;
        StringBuilder sb = new StringBuilder();

        sb.append("select er, em.id, em.employeeId, em.employeeName, dgm.id, dgm.designationName, lev.level, dm.id, dm.departmentName, lm.id, zlm.zydexLocation, (Select a.employeeName From EmployeeMaster a where cast(a.id as string) = em.reportingManagerLevel1) As reportingManager, lm.location,")
                .append(" prm.positionName, prm.positionCode")
                .append(" from  EmployeeReferral AS er ,PositionReferMaster as prm  left join er.employeeMaster AS em")
                .append(" left join em.departmentMaster as dm left join em.designationMaster as dgm")
                .append(" left join em.levelMaster lev")
                .append(" left join em.locationMaster as lm")
                .append(" left join em.zydexLocationMaster as zlm");
        if (employeeReferral.getId() != null) {
            sb.append(" where er.id=").append(employeeReferral.getId());

        } else {
            sb.append(" where er.status IN (0,1,2,3,4,5)");
        }
        sb.append(" and (er.candidatePositionReferredFor=prm.id) order By er.id desc");

        String hqlQryString = sb.toString();
//        String qryString = getSessionFactory().getCurrentSession().createQuery(hqlQryString).getQueryString();
        List<?> employeeRefList = getHibernateTemplate().find(hqlQryString);
//        List<?> employeeRefList = ;

        return employeeRefList;
    }

    public int updateEmployeeReferralById(final T object) {

        EmployeeReferral employeeReferral = (EmployeeReferral) object;
        StringBuilder sb = new StringBuilder();
        sb.append("update EmployeeReferral set status =")
                .append(employeeReferral.getStatus())
                .append(", statusRemark='")
                .append(employeeReferral.getStatusRemark())
                .append("', hrRemark='")
                .append(employeeReferral.getHrRemark())
                .append("' where id=")
                .append(employeeReferral.getId());
        String hqlQryString = sb.toString();

        return getHibernateTemplate().bulkUpdate(hqlQryString);
    }

    @Override
    protected Class getDomainClass() {
        return EmployeeReferral.class;
    }

    @Override
    public boolean isExist(T object) {
        return false;
    }

    @Override
    public List<?> getReportingManagerOfEmpRefAdmin() {

        StringBuilder sb = new StringBuilder();
        sb.append("select em.reportingManagerLevel1")
                .append(" from  EmployeeMaster AS em left join em.employeeReferrals AS er")
                .append(" left join em.userMaster as um left join um.userRightMasters as urm")
                .append(" where urm.employeeReferral is true")
                .append(" and urm.travelExpenseAdmin is not true")//this is for trick work for get only single useer of employeeReferral
                .append(" and urm.employeeManagement is not true")//this is for trick work for get only single useer of employeeReferral
                .append(" order by er.id desc");//this is for trick work for get only single useer of employeeReferral
        String hqlQryString = sb.toString();
//        String qryString = getSessionFactory().getCurrentSession().createQuery(hqlQryString).getQueryString();
        List<?> list = getHibernateTemplate().find(hqlQryString);
        return list;
    }

    @Override
    public List<?> checkPositionReferd(final T object) {
        EmployeeReferral employeeReferral = (EmployeeReferral) object;
        String query = "";

        query += " FROM EmployeeReferral a"
                + " WHERE a.candidatePositionReferredFor='" + employeeReferral.getCandidatePositionReferredFor() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> finalApproveByHrHead() {
        String query = "";

        query += " SELECT a FROM EmployeeMaster a"
                + " WHERE a.departmentMaster.id=" + 59
                + " and a.designationMaster.id=" + 114;

        return getHibernateTemplate().find(query);
    }

    public List<?> finalApproveList(T object) {
        EmployeeReferral employeeReferral = (EmployeeReferral) object;
        StringBuilder sb = new StringBuilder();

        sb.append("select er, em.id, em.employeeId, em.employeeName, dgm.id,"
                + " dgm.designationName, lev.level, dm.id, dm.departmentName, lm.id, zlm.zydexLocation,"
                + " (Select a.employeeName From EmployeeMaster a where cast(a.id as string) = em.reportingManagerLevel1) As reportingManager, lm.location,")
                .append(" prm.positionName, prm.positionCode")
                .append(" from  EmployeeReferral AS er ,PositionReferMaster as prm  left join er.employeeMaster AS em")
                .append(" left join em.departmentMaster as dm left join em.designationMaster as dgm")
                .append(" left join em.levelMaster lev")
                .append(" left join em.locationMaster as lm")
                .append(" left join em.zydexLocationMaster as zlm");

        sb.append(" where er.status=2");

        sb.append(" and (er.candidatePositionReferredFor=prm.id) order By er.id desc");

        String hqlQryString = sb.toString();
//        String qryString = getSessionFactory().getCurrentSession().createQuery(hqlQryString).getQueryString();
        List<?> employeeRefList = getHibernateTemplate().find(hqlQryString);
//        List<?> employeeRefList = ;

        return employeeRefList;
    }
}
