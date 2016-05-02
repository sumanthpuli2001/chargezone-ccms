package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ProbationPeriod;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class TimeAttandanceFlaxibleMasterController extends TimeAttandanceFlaxibleMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = new TimeAttandanceFlaxibleMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        setZydexLocationList(request);
        timeAttandanceFlaxibleMaster.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("timeAttandanceFlaxibleMaster", timeAttandanceFlaxibleMaster);
        mv.setViewName("AttendanceRegularization/timeAttandanceFlaxibleCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = new TimeAttandanceFlaxibleMaster();
        BindException errors = new BindException(timeAttandanceFlaxibleMaster, "timeAttandanceFlaxibleMaster");
        setZydexLocationList(request);
        bind(request, timeAttandanceFlaxibleMaster);

        timeAttendanceFlexibleValidator.validate(timeAttandanceFlaxibleMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("timeAttandanceFlaxibleMaster", timeAttandanceFlaxibleMaster);
            mv.setViewName("AttendanceRegularization/timeAttandanceFlaxibleCreate");
        } else {
            boolean isExist = timeAttandanceFlaxibleMasterService.isExist(timeAttandanceFlaxibleMaster);
            if (isExist) {
                timeAttandanceFlaxibleMasterService.create(timeAttandanceFlaxibleMaster);
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
            } else {
                request.setAttribute("failureMessage",
                        "Error : Information Is Already Exist.");
            }
            mv = showList(request, response);
        }
        return mv;
    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = new TimeAttandanceFlaxibleMaster();
        List timeAttendanceList = timeAttandanceFlaxibleMasterService.readFlexibleTimeList();
        request.setAttribute("timeAttendanceList", timeAttendanceList);
        mv.getModelMap().put("timeAttandanceFlaxibleMaster", timeAttandanceFlaxibleMaster);
        mv.setViewName("AttendanceRegularization/AttendanceTimeFlexibleList");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String checkId[] = request.getParameterValues("checkId");
        for (String z : checkId) {
            try {
                timeAttandanceFlaxibleMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = new TimeAttandanceFlaxibleMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        String id = request.getParameter("id");
        setZydexLocationList(request);
        timeAttandanceFlaxibleMaster = timeAttandanceFlaxibleMasterService.readById(Integer.parseInt(id));
        zydexLocationMaster = zydexLocationMasterService.readById(timeAttandanceFlaxibleMaster.getZydexLocationMaster().getId());
        timeAttandanceFlaxibleMaster.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("timeAttandanceFlaxibleMaster", timeAttandanceFlaxibleMaster);
        mv.setViewName("AttendanceRegularization/AttendanceFlexibleTimeView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = new TimeAttandanceFlaxibleMaster();
        BindException errors = new BindException(timeAttandanceFlaxibleMaster, "timeAttandanceFlaxibleMaster");
        setZydexLocationList(request);
        bind(request, timeAttandanceFlaxibleMaster);

        timeAttendanceFlexibleValidator.validate(timeAttandanceFlaxibleMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("timeAttandanceFlaxibleMaster", timeAttandanceFlaxibleMaster);
            mv.setViewName("AttendanceRegularization/timeAttandanceFlaxibleCreate");
        } else {
//            boolean isExist = timeAttandanceFlaxibleMasterService.isExist(timeAttandanceFlaxibleMaster);
//            if (isExist) {
            timeAttandanceFlaxibleMasterService.update(timeAttandanceFlaxibleMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
//            } else {
//                request.setAttribute("failureMessage",
//                        "Error : Information Is Already Exist.");
//            }
            mv = showList(request, response);
        }
        return mv;
    }

}
