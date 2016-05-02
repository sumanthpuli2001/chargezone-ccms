/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.UserLoginLog;
import com.bul.zydex.model.support.UserActivityLog;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class UserLoginLogDAOImpl<T> extends GenericsDAOImpl<T> implements
        UserLoginLogDAO<T> {

    @Override
    protected Class getDomainClass() {
        return UserLoginLog.class;
    }

    @Override
    public List<?> read(T object) {
        UserActivityLog userActivityLog = (UserActivityLog) object;
        String queryStr = "";

        if (!(null == userActivityLog.getUserName() || ""
                .equals(userActivityLog.getUserName()))) {
            queryStr = "c.id = " + userActivityLog.getUserName()
                    + " and ";
        }
        if (!(null == userActivityLog.getIpAddress() || ""
                .equals(userActivityLog.getIpAddress()))) {
            queryStr += "a.ipAddress like '" + userActivityLog.getIpAddress()
                    + "' and ";
        }
        if (!(null == userActivityLog.getDateTimeFrom() || ""
                .equals(userActivityLog.getDateTimeFrom()))) {
            queryStr += "STR_TO_DATE(a.dateTime,'%m/%d/%Y %H:%i') >= STR_TO_DATE('"
                    + userActivityLog.getDateTimeFrom()
                    + "','%m/%d/%Y %h:%i %p')  and ";
        }
        if (!(null == userActivityLog.getDateTimeTo() || ""
                .equals(userActivityLog.getDateTimeTo()))) {
            queryStr += "STR_TO_DATE(a.dateTime,'%m/%d/%Y %H:%i') <= STR_TO_DATE('"
                    + userActivityLog.getDateTimeTo()
                    + "','%m/%d/%Y %h:%i %p')  and ";
        }
        if (!(null == userActivityLog.getActionType()
                || "".equals(userActivityLog.getActionType())
                || "Select".equals(userActivityLog.getActionType()) || "LoginLogout"
                .equals(userActivityLog.getActionType()))) {
            queryStr += "a.actionType like '" + userActivityLog.getActionType()
                    + "' and ";
        }

        queryStr += " 1 = 1 order by a.id desc";

        return getHibernateTemplate()
                .find(""
                        + "select a.id, b.email, b.username, a.ipAddress, "
                        + "a.dateTime, a.actionType, a.actionDescription, "
                        + "CONCAT(d.firstName,' ' ,d.middleName,' ' ,d.lastName) AS employeeName, "
                        + "e.orgName AS stationTitle, f.departmentName AS departmentTitle, g.name AS desigantionTitle "
                        + "from UserActivityLog a "
                        + "left join a.user b "
                        + "left join b.employeeMaster c "
                        + "left join c.employeePersonals d "
                        + "left join d.organizationInformation e "
                        + "left join d.organizationDepartment f "
                        + "left join d.designation g "
                        + "where "
                        + queryStr);
    }
}
