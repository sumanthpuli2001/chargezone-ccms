/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Punch;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.TimeAttendanceMaster;
import com.bul.zydex.model.UserMaster;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PunchController extends PunchAbstract {

    private void punchDetail() throws ParseException {
        System.out.println("ajay");
        Punch punchmodel = new Punch();
        Punch punchmodel1 = new Punch();
        TimeAttendanceMaster timeAttendanceMaster = new TimeAttendanceMaster();
        UserMaster userMaster = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        List userLisr = userMasterService.read();
        for (Object o : userLisr) {
            userMaster = (UserMaster) o;
            timeAttendanceMaster.setUserMaster(userMaster);
            List<?> list = timeAttendanceMasterService.readByUserId(timeAttendanceMaster);
            Iterator i = list.iterator();
            while (i.hasNext()) {
                Object[] next = (Object[]) i.next();
                String aa = "" + next[0];
                String bb = "" + next[1];
                System.out.println("aaaaaaa" + aa);
                System.out.println("bbbbbbb" + bb);
                punchmodel.setUserMaster(userMaster);
//                punchmodel.setPunchInDateTime(aa);
//                punchmodel.setPunchOutDateTime(bb);
                List punchList = punchService.readByPunchUserId(punchmodel);
                employeeMaster.setUserMaster(userMaster);

                List emplyeeList = employeeMasterService.readByEmployeeUserId(employeeMaster);

                for (Object empList : emplyeeList) {
                    employeeMaster = (EmployeeMaster) empList;

                    if (employeeMaster.getShiftType().equals("Shiftwise")) {
                        shiftMaster.setId(employeeMaster.getShiftHoursId());

                        List<?> shiftDetailList = shiftMasterService.readByShiftId(shiftMaster);

                        if (!shiftDetailList.isEmpty()) {
                            shiftMaster = (ShiftMaster) shiftDetailList.get(0);
                        }

                        Date strTime = timeFormat.parse(shiftMaster.getStartTime());
                        Date eTime = timeFormat.parse(shiftMaster.getEndTime());
                        Time startTime = new Time(strTime.getTime());
                        Time endTime = new Time(eTime.getTime());
                        if (startTime.after(endTime)) {
                            System.out.println("iiiiiiiiiiiiiiiii");
                        }

//                        for (Object timeList : shiftDetailList) {
//                        }
                        if (punchList.isEmpty()) {
                            punchService.create(punchmodel);
                        } else {
                            for (Object punchList1 : punchList) {
                                punchmodel1 = (Punch) punchList1;

                                punchmodel.setId(punchmodel1.getId());
                                punchService.update(punchmodel);
                            }
                        }

                    }
                }

            }
        }
    }

}
