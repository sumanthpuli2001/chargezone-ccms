/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Coupon;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CouponMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class CouponController extends CustomAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CouponMaster couponMaster = new CouponMaster();
        List list = couponService.readByDrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("couponMaster", couponMaster);
        mv.setViewName("Coupon/CouponList");
        return mv;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CouponMaster couponMaster = new CouponMaster();
        List list = couponService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("couponMaster", couponMaster);
        mv.setViewName("Coupon/CouponDisableList");
        return mv;
    }

    public ModelAndView createCouponMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CouponMaster couponMaster = new CouponMaster();
        mv.getModelMap().put("couponMaster", couponMaster);
        mv.setViewName("Coupon/CouponCreate");
        return mv;
    }

    public ModelAndView submitCouponMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CouponMaster couponMaster = new CouponMaster();
        bind(request, couponMaster);
        couponMaster.setdRow("N");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (couponMaster.getSrNo() == 0) {
            couponMaster.setLimitDay(100).setLimitMonth(100);
            couponService.create(couponMaster);
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Coupon created").setDrow("Y");
            logService.create(lm);

            request.setAttribute("successMessage",
                    "Information: Coupon Created successfully");
        } else {
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Coupon Edited").setDrow("Y");
            logService.create(lm);

            request.setAttribute("successMessage",
                    "Information: Coupon Updated successfully");
            couponService.update(couponMaster);
        }
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int couponId = Integer.parseInt(request.getParameter("id"));
        CouponMaster couponMaster = couponService.readById(couponId);
        mv.getModelMap().put("couponMaster", couponMaster);
        mv.setViewName("Coupon/CouponCreate");
        return mv;
    }

    public ModelAndView disableCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            CouponMaster couponMaster = couponService.readById(Integer.parseInt(checkedValues));
            couponMaster.setdRow("Y");
            couponService.update(couponMaster);
        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Coupon Deleted ").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: One or more Coupon deleted successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView deleteCouponMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                couponService.delete(Integer.parseInt(checkedValues));
            }
            //------for Log entry---------

            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Coupon Deleted Permanent").setDrow("Y");
            logService.create(lm);

            request.setAttribute("successMessage",
                    "Information: One or more Coupon deleted successfully");
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                CouponMaster couponMaster = couponService.readById(Integer.parseInt(checkedValues));
                couponMaster.setdRow("N");
                couponService.update(couponMaster);
            }
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Coupon Restore ").setDrow("Y");
            logService.create(lm);

            request.setAttribute("successMessage",
                    "Information: One or more Coupon Restore successfully");
        }

        mv = showList(request, response);
        return mv;
    }
}
