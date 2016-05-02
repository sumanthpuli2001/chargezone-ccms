/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.ItRequestType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinita
 */
public class ItRequestTypeController extends ItRequestTypeAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItRequestType itRequestType = new ItRequestType();
        List<?> list = itRequestTypeService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("itRequestType", itRequestType);
        mv.setViewName("ItRequestType/ItRequestTypeResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItRequestType itRequestType = new ItRequestType();
        mv.getModelMap().put("itRequestType", itRequestType);
        mv.setViewName("ItRequestType/ItRequestTypeCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItRequestType itRequestType = new ItRequestType();
        BindException errors = new BindException(itRequestType, "itRequestType");
        bind(request, itRequestType);
        boolean flag = false;
        itRequestTypeValidator.validate(itRequestType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("itRequestType", itRequestType);
            mv.setViewName("ItRequestType/ItRequestTypeCreate");
        } else {
            if (!itRequestTypeService.isExist(itRequestType)) {
                itRequestTypeService.create(itRequestType);
                request.setAttribute("successMessage",
                        "Information : Request Type Created Successfully.");
            } else {
                flag = true;
                request.setAttribute("failureMessage",
                        "Error : Request Type Already Exists");
            }
            mv = searchSubmit(request, response);
        }
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, ItRequestType itRequestType) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkBoxes = request.getParameterValues("checkId");
        boolean flag = false;
        int count = 0;
        String nonDeletedValue = "";
        for (String checkBoxe : checkBoxes) {
            try {
                itRequestTypeService.delete(Integer.parseInt(checkBoxe));
                flag = true;
            } catch (Exception e) {
                try {
                    itRequestType = itRequestTypeService.readById(Integer.parseInt(checkBoxe));
                    if (count == 0) {
                        nonDeletedValue += itRequestType.getText();
                    } else {
                        nonDeletedValue += ", " + itRequestType.getText();
                    }
                } catch (Exception e2) {
                }
                count++;
            }
        }
        if (flag) {
            mv.addObject("successMessage", "Info : One Or More Records Are Deleted Successfully.");
        } else {
            mv.addObject("failureMessage", "Error : Can't Be Deleted, In Use Or Already Deleted.....<strong>" + nonDeletedValue
                    + "</strong>");
        }
        //below code will display all records from database and list out it.
        List<?> list = itRequestTypeService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("itRequestType", itRequestType);
        mv.setViewName("ItRequestType/ItRequestTypeResult");
        return mv;
    }
}
