/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.QueryType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinita
 */
public class QueryTypeController extends QueryTypeAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        QueryType queryType = new QueryType();
        List<?> list = queryTypeService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("queryType", queryType);
        mv.setViewName("QueryType/QueryTypeResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        QueryType queryType = new QueryType();
        mv.getModelMap().put("queryType", queryType);
        mv.setViewName("QueryType/QueryTypeCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        QueryType queryType = new QueryType();
        BindException errors = new BindException(queryType, "queryType");
        bind(request, queryType);
        boolean flag = false;
        queryTypeValidator.validate(queryType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("queryType", queryType);
            mv.setViewName("QueryType/QueryTypeCreate");
        } else {
            if (!queryTypeService.isExist(queryType)) {
                queryTypeService.create(queryType);
                request.setAttribute("successMessage",
                        "Information : Query Created Successfully.");
            } else {
                flag = true;
                request.setAttribute("failureMessage",
                        "Error : Query Type Already Exists");
            }
            mv = searchSubmit(request, response);
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response, QueryType queryType) throws Exception {
        ModelAndView mv = new ModelAndView();
//        QueryType queryType = new QueryType();
        String deleteIds[] = request.getParameterValues("checkId");
        boolean flag = false;
        int count = 0;
        String unDeletedQuery = "";
        for (String queryId : deleteIds) {
            try {
                queryTypeService.delete(Integer.parseInt(queryId));
                flag = true;
            } catch (Exception e) {
                try {
                    queryType = queryTypeService.readById(Integer.parseInt(queryId));
                    if (count == 0) {
                        unDeletedQuery += queryType.getText();
                    } else {
                        unDeletedQuery += ", " + queryType.getText();
                    }
                } catch (Exception e2) {
                }
            }
            count++;
        }
        if (flag) {
            request.setAttribute("successMessage",
                    "Info : One Or More Records Are Deleted Successfully.");
        }
        if (!flag && unDeletedQuery.isEmpty()) {
            request.setAttribute("failureMessage",
                    "Error :Data Already Deleted.");
        }
        if (!unDeletedQuery.isEmpty()) {
            request.setAttribute("failureMessage", "Error : <strong>" + unDeletedQuery + "</strong> Can't Be Deleted, In Use.");
        }
        mv = searchSubmit(request, response);
        return mv;
    }
}
