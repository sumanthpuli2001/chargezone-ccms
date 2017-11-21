/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisal;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalFeedback360;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class Appraisal360DAOImpl<T> extends GenericsDAOImpl<T> implements Appraisal360DAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalFeedback360.class;
    }

    @Override
    public List<?> readEmployeeAppraisalFeedback(int id) {

        String query = "";
        query += " "
                + " SELECT b.id as ID, b.employeeName as Name, c.departmentName as DeptName, d.id,"
                + " a.performedDateStr,a.completeDateStr,b.employeeId"
                + " FROM AppraisalFeedback360 a "
                + " left join a.employeeMasterByRefForEmpId b "
                + " left join a.employeeMasterByRefDoneEmpId d "
                + " left join b.departmentMaster c "
                + " WHERE d.id='" + id + "' and a.status=0";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public int countEmployeeAppraisalFeedback(int id) {

        int i = 0;

        String query = "";
        query += " "
                + " SELECT count(a.id)"
                + " FROM AppraisalFeedback360 a "
                + " left join a.employeeMasterByRefForEmpId b "
                + " left join a.employeeMasterByRefDoneEmpId d "
                + " left join b.departmentMaster c "
                + " WHERE d.id='" + id + "' and a.status=0";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
          long  l =   (long) list.get(0);
          i =(int) l;
        }
        return i;
    }

    @Override
    public List<?> readHRAppraisalData(int id, int forId) {
        String query = "";
        query += " "
                + " SELECT b.employeeName as ForName, d.employeeName as DoneName,"
                + " a.performedDateStr,a.completeDateStr,a.id,b.id as forId,d.id as doneId,c.id as hrId"
                + " FROM AppraisalFeedback360 a "
                + " left join a.employeeMasterByRefForEmpId b "
                + " left join a.employeeMasterByRefDoneEmpId d "
                + " left join a.employeeMasterByHrCreatorId c "
                + " WHERE b.id='" + forId + "' and d.id='" + id + "' and a.status=0";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readAppraisalList() {
        String query = "";
        query += " "
                + " FROM AppraisalFeedback360 a "
                + " GROUP BY a.employeeMasterByRefForEmpId,a.performedDateStr,a.completeDateStr";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readAppraisalFeedbackView(int ForId, String Pdate, String Cdate) {
        String query = "";
        query += " "
                + " Select b.employeeName as ForName,c.employeeName as DoneName,a.performedDateStr,a.completeDateStr, "
                + " a.wlb1,a.wlb2,a.wlb3,a.wlb4,a.wlb5,a.status,a.remarkEmp,a.wlb1Remark,a.wlb2Remark,a.wlb3Remark,a.wlb4Remark,a.wlb5Remark"
                + " FROM AppraisalFeedback360 a "
                + " left join a.employeeMasterByRefForEmpId b "
                + " left join a.employeeMasterByRefDoneEmpId c "
                + " WHERE b.id=" + ForId + " and a.performedDateStr='" + Pdate + "' and a.completeDateStr='" + Cdate + "'";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> searchAppraisalFeedback(int empId, String startD, String endD) {
        String query = "";
        query += " "
                + " Select b.employeeName as ForName,a.performedDateStr,a.completeDateStr,(case when a.status=1 then 'Completed' else 'Pending' end) "
                + " FROM AppraisalFeedback360 a "
                + " left join a.employeeMasterByRefForEmpId b "
                + " GROUP BY a.employeeMasterByRefForEmpId,a.performedDateStr,a.completeDateStr";
        if (!("" + empId).equals("")) {

        } else {
            query += " "
                    + " Select b.employeeName as ForName,a.performedDateStr,a.completeDateStr,(case when a.status=1 then 'Completed' else 'Pending' end) "
                    + " FROM AppraisalFeedback360 a "
                    + " left join a.employeeMasterByRefForEmpId b "
                    + " WHERE b.id=" + empId + " and (STR_TO_DATE(a.completeDateStr,'%d/%m/%Y') BETWEEN  STR_TO_DATE('" + startD + "','%d/%m/%Y') AND STR_TO_DATE('" + endD + "','%d/%m/%Y')) "
                    + " GROUP BY a.employeeMasterByRefForEmpId,a.performedDateStr,a.completeDateStr";
        }
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List<?> read360SearchByEmployee(T object) {
        AppraisalFeedback360 appraisalFeedback360 = (AppraisalFeedback360) object;
        String query = "";
//        String condition = "";
//
//        if (null != appraisalFeedback360.getEmployeeMasterByRefForEmpId().getId()) {
//            condition += " AND  b.id = " + appraisalFeedback360.getEmployeeMasterByRefForEmpId().getId();
//        }
//
//        if (null != appraisalFeedback360.getCompleteDateStr() && !"".equals(appraisalFeedback360.getCompleteDateStr())) {
//            condition += " AND  f.id = " + appraisalFeedback360.getCompleteDateStr();
//        }
//        if (null != appraisalFeedback360.getPerformedDateStr() && !"".equals(appraisalFeedback360.getPerformedDateStr())) {
//            condition += " AND  d.id = " + appraisalFeedback360.getPerformedDateStr();
//        }
        query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName,c.designationName,f.level,a.performedDateStr,a.wlb1,a.wlb2,a.wlb3,a.wlb4,a.wlb5,a.remarkEmp,a.remarkHr,g.id,g.employeeName"
                + " FROM AppraisalFeedback360 a "
                + " LEFT JOIN a.employeeMasterByRefDoneEmpId b "
                + " LEFT JOIN a.employeeMasterByRefForEmpId g "
                + " LEFT JOIN b.departmentMaster d "
                + " LEFT JOIN b.designationMaster c "
                + " LEFT JOIN b.userMaster e "
                + " LEFT JOIN b.levelMaster f "
                + " WHERE status=1 and a.employeeMasterByRefForEmpId=" + appraisalFeedback360.getEmployeeMasterByRefForEmpId().getId();

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> read360SearchByFillingEmployee(T object) {
        AppraisalFeedback360 appraisalFeedback360 = (AppraisalFeedback360) object;
        String query = "";
        String condition = "";

        if (null != appraisalFeedback360.getEmployeeMasterByRefForEmpId().getId()) {
            condition += " AND  b.id = " + appraisalFeedback360.getEmployeeMasterByRefForEmpId().getId();
        }

        if (null != appraisalFeedback360.getCompleteDateStr() && !"".equals(appraisalFeedback360.getCompleteDateStr())) {
            condition += " AND  f.id = " + appraisalFeedback360.getCompleteDateStr();
        }
        if (null != appraisalFeedback360.getPerformedDateStr() && !"".equals(appraisalFeedback360.getPerformedDateStr())) {
            condition += " AND  d.id = " + appraisalFeedback360.getPerformedDateStr();
        }
        query += " SELECT a.id,b.id, b.employeeId, b.employeeName, d.departmentName,c.designationName,f.level,a.performedDateStr"
                + " FROM AppraisalFeedback360 a "
                + " LEFT JOIN a.employeeMasterByRefForEmpId b "
                + " LEFT JOIN b.departmentMaster d "
                + " LEFT JOIN b.designationMaster c "
                + " LEFT JOIN b.userMaster e "
                + " LEFT JOIN b.levelMaster f "
                + " WHERE status=1" + condition
                + " Group By a.employeeMasterByRefForEmpId";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
