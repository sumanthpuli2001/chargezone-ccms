/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Device;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DeviceDetails;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class DeviceController extends CustomAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceDetails deviceDetails = new DeviceDetails();
        List list = deviceService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("deviceDetails", deviceDetails);
        mv.setViewName("Device/DeviceList");
        return mv;
    }

    public ModelAndView createDevice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceDetails deviceDetails = new DeviceDetails();
        mv.getModelMap().put("deviceDetails", deviceDetails);
        mv.setViewName("Device/DeviceCreate");
        return mv;
    }

    public ModelAndView submitDeviceDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceDetails deviceDetails = new DeviceDetails();
        bind(request, deviceDetails);
        deviceService.create(deviceDetails);
        request.setAttribute("successMessage",
                "Information: User Created successfully");
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView deleteDeviceDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            deviceService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv = showList(request, response);
        return mv;
    }

}
