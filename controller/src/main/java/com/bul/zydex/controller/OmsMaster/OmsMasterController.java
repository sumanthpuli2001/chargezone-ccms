/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OmsMaster;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bulwarks-2
 */
public class OmsMasterController extends OmsMasterAbstract {

    public ModelAndView omsMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List omsMasterList = omsMasterService.read();
        mv.getModelMap().put("omsMasterList", omsMasterList);

        mv.setViewName("OmsMaster/OmsMasterList");
        return mv;
    }

    public void deleteOms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String omsid = request.getParameter("omsid");
        try {
//            omsMasterService.delete(Integer.parseInt(omsid));
            response.getWriter().write("{\"status\":\"success\",\"message\":\"Deleted successfully\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\",\"message\":\"Delete failed\"}");
        }
    }

    public void deleteMultipleOms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            String ids = request.getParameter("ids");
            if (ids != null && !ids.trim().isEmpty()) {
                String[] idArray = ids.split(",");
                for (String id : idArray) {
//                    omsMasterService.delete(Integer.parseInt(id));
                }
                response.getWriter().write("{\"status\":\"success\",\"message\":\"Records deleted successfully\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"status\":\"error\",\"message\":\"No IDs provided\"}");
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\",\"message\":\"Delete failed\"}");
        }
    }

}
