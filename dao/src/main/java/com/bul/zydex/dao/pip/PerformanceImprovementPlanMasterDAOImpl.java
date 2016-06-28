/*
 *
 * Author Dhaval
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PerformanceImprovementPlanMaster;
import java.util.List;

/**
 *
 * @author Dhaval
 */
public class PerformanceImprovementPlanMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PerformanceImprovementPlanMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PerformanceImprovementPlanMaster.class;
    }

    @Override
    public List<?> readPipByEmployeeMaster(T object) {
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = (PerformanceImprovementPlanMaster) object;
        String query = "";

        query += ""
                + " FROM PerformanceImprovementPlanMaster a"
                + " Where a.employeeMasterByPipEmployeeId=" + performanceImprovementPlanMaster.getEmployeeMasterByPipEmployeeId().getId();
//                + " and a.status=5";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> viewPipListByManager(String managerId) {
        String query = "";

        query += "Select b.employeeId,b.employeeName,c.level,d.departmentName,e.designationName,b.id,a.id"
                + " FROM PerformanceImprovementPlanMaster a"
                + " left join a.employeeMasterByPipEmployeeId b"
                + " left join b.levelMaster c"
                + " left join b.departmentMaster d "
                + " left join b.designationMaster e"
                + " where (b.reportingManagerLevel1=" + managerId
                + " or b.reportingManagerLevel2=" + managerId
                + " or b.reportingManagerLevel3=" + managerId
                + " or b.reportingManagerLevel4=" + managerId
                + " or b.reportingManagerLevel5=" + managerId + ")"
                + " and ((b.dateOfLeaving is null or b.dateOfLeaving = '') "
                + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())"
                + " order By a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> viewPipListByAdmin() {
        String query = "";

        query += "Select b.employeeId,b.employeeName,c.level,d.departmentName,e.designationName,b.id,a.id"
                + " FROM PerformanceImprovementPlanMaster a"
                + " left join a.employeeMasterByPipEmployeeId b"
                + " left join b.levelMaster c"
                + " left join b.departmentMaster d "
                + " left join b.designationMaster e"
                + " Where (b.dateOfLeaving is null or b.dateOfLeaving = '') "
                + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()"
                + " order by a.id desc group by a.employeeMasterByPipEmployeeId";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readOwnPipPending(T object) {
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = (PerformanceImprovementPlanMaster) object;
        String query = "";

        query += ""
                + " FROM PerformanceImprovementPlanMaster a"
                + " Where a.employeeMasterByPipEmployeeId=" + performanceImprovementPlanMaster.getEmployeeMasterByPipEmployeeId().getId()
                + " and a.status=1";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeePipPending(String managerId) {
        String query = "";

        query += "Select b.employeeId,b.employeeName,c.level,d.departmentName,e.designationName,b.id,a.id"
                + " FROM PerformanceImprovementPlanMaster a"
                + " left join a.employeeMasterByPipEmployeeId b"
                + " left join b.levelMaster c"
                + " left join b.departmentMaster d "
                + " left join b.designationMaster e"
                + " where b.reportingManagerLevel1=" + managerId
                + " and ((b.dateOfLeaving is null or b.dateOfLeaving = '') "
                + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";

        return getHibernateTemplate().find(query);
    }

}
