/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.TempShiftAssignMaster;
import com.bul.zydex.service.shift.ShiftMasterService;
import com.bul.zydex.service.shift.TemporaryShiftAssignService;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.Validate;
import org.springframework.validation.Validator;



/**
 *
 * @author Dhaval Patel
 */
public class TemporaryShiftAssignAbstract extends CustomAbstract {

    protected TemporaryShiftAssignService<TempShiftAssignMaster> temporaryShiftAssignService;
    protected ShiftMasterService<ShiftMaster> ShiftMasterService;
    protected Validator temporaryShiftAssignValidator;

    public Validator getTemporaryShiftAssignValidator() {
        return temporaryShiftAssignValidator;
    }

    public void setTemporaryShiftAssignValidator(Validator temporaryShiftAssignValidator) {
        this.temporaryShiftAssignValidator = temporaryShiftAssignValidator;
    }
    
    public TemporaryShiftAssignService<TempShiftAssignMaster> getTemporaryShiftAssignService() {
        return temporaryShiftAssignService;
    }

    public void setTemporaryShiftAssignService(TemporaryShiftAssignService<TempShiftAssignMaster> temporaryShiftAssignService) {
        this.temporaryShiftAssignService = temporaryShiftAssignService;
    }

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return ShiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> ShiftMasterService) {
        this.ShiftMasterService = ShiftMasterService;
    }
    
    
    
    public void selectEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = employeeMasterService.readForAliveEmployeesNew();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]
                    + "  /" + arrayOfObject[4]
                    + "  /" + arrayOfObject[5] + "\"}";

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }
        public void selectShift(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = ShiftMasterService.readByShiftName();
        String tempStr = "[";
        Object[] arrayOfObject;

        ShiftMaster shiftMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("list1", tempStr);
    }

}
