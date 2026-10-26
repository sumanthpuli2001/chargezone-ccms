/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CountryCode;

import com.bul.zydex.model.CountryCode;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bulwarks-2
 */
public class CountryCodeController extends CountryCodeAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");

        if (session1 != null) {
            String successMessage = (String) session1.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session1.removeAttribute("successMessage"); // clean up after showing
            }
        }
        List list = countryCodeService.read();
        request.setAttribute("list", list);
        mv.setViewName("CountryCode/ShowList");
        return mv;
    }

    public ModelAndView createCountryCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("CountryCode/CreateCountryCode");
        return mv;
    }

    public ModelAndView submitCountryCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        String countryName = request.getParameter("countryName");
        String countryCode = request.getParameter("countryCode");

        CountryCode countryCode1 = new CountryCode();
        countryCode1.setCountryName(countryName);
        countryCode1.setCountryCode(Integer.parseInt(countryCode));
        countryCodeService.create(countryCode1);

        session1.setAttribute("successMessage",
                "Information: Country Code Created successfully");
        mv.setViewName("redirect:countryCode.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteCountryCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {

            countryCodeService.delete(Integer.parseInt(checkedValues));
        }
        session1.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv.setViewName("redirect:countryCode.htm?act=showList");
        return mv;
    }

    public ModelAndView editCountryCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        CountryCode countryCode = countryCodeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("countryCode", countryCode);
        mv.setViewName("CountryCode/EditCountryCode");
        return mv;
    }

    public ModelAndView editCountryCodeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session1 = request.getSession(false);
        String id = request.getParameter("id");
        String countryName = request.getParameter("countryName");
        String countryCode = request.getParameter("countryCode");
        CountryCode countryCode1 = countryCodeService.readById(Integer.parseInt(id));
        countryCode1.setCountryName(countryName);
        countryCode1.setCountryCode(Integer.parseInt(countryCode));
        countryCodeService.update(countryCode1);

        session1.setAttribute("successMessage", "Information: Country Code edit successfully");
        mv.setViewName("redirect:countryCode.htm?act=showList");
        return mv;
    }
}
