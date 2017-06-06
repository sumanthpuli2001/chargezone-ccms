 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.attendanceRegularization;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public interface AttendanceRegularizationMasterDAO<T> extends GenericsDAO<T> {

    public List<?> userWiseAttendanceRegularizationList(int id);

    public List<?> approvalLeval1WiseAttendanceRegularizationList(int id);

    public List<?> attendanceRegularizationApprivedList(int id);

    public List<?> userWiseAttendanceRegularizationApproveList(int id);

    public List<?> readByAttendanceRegularizationPendingList(int id);

    public List<?> readByAttendanceRegularizationApproverPendingList(T object);

    public List<?> readByAttendanceRegularizationApprover2PendingList(T object);

    public List<?> userReportingManager(int id);

    public List<?> searchLeaveApproveOfEmployeeByMonthWise(T object);

    public List<?> searchLeaveApproveOfEmployeeByPreviousMonthWise(T object);

    public List<?> powerAdminAttendanceRegularizationList();

    public List<?> readArCountList(T object);
}
