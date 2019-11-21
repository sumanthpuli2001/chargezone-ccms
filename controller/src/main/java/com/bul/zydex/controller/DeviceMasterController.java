/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.DeviceMaster;
import com.bul.zydex.model.DeviceMasterNotification;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class DeviceMasterController extends DeviceMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceMaster deviceMaster = new DeviceMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        deviceMaster.setZydexLocationMaster(zydexLocationMaster);
        zydexLocationList(request);
        mv.getModelMap().put("deviceMaster", deviceMaster);
        mv.setViewName("User/Device");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceMaster deviceMaster = new DeviceMaster();
        DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
        BindException errors = new BindException(deviceMaster, "deviceMaster");
        bind(request, deviceMaster);
        deviceMasterValidator.validate(deviceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            zydexLocationList(request);
//            mv = createClick(request, response);
            mv.setViewName("User/Device");
        } else {
            String location = request.getParameter("zydexLocationMaster.id");
            ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
            zydexLocationMaster = zydexLocationMasterService.readById(Integer.parseInt(location));
            deviceMasterService.create(deviceMaster);
            BeanUtils.copyProperties(deviceMaster, deviceMasterNotification);
            deviceMasterNotification.setCountConnectionOut(0);
            deviceMasterNotificationService.create(deviceMasterNotification);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv.setViewName("redirect:deviceMaster.htm?act=searchSubmit");
//            mv.setViewName("User/Device");
        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceMaster deviceMaster = new DeviceMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
        List<?> deviceMasterList = deviceMasterService.read();

        mv.getModelMap().put("list", deviceMasterList);
        mv.getModelMap().put("deviceMaster", deviceMaster);
        mv.setViewName("User/DeviceResult");

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceMaster deviceMaster = new DeviceMaster();
        String id = request.getParameter("id");
        deviceMaster = deviceMasterService.readById(Integer.parseInt(id));
        deviceMaster.setId(Integer.parseInt(id));
        zydexLocationList(request);
        deviceMaster.setZydexLocationMaster(zydexLocationMasterService.readById(deviceMaster.getZydexLocationMaster().getId()));
        mv.getModelMap().put("deviceMaster", deviceMaster);
        mv.setViewName("User/EditDevice1");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DeviceMaster deviceMaster = new DeviceMaster();
        DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
        BindException errors = new BindException(deviceMaster, "deviceMaster");
        deviceMaster.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, deviceMaster);
        deviceMasterValidator.validate(deviceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = editClick(request, response);
            mv.addAllObjects(errors.getModel());
        } else {
            deviceMasterService.update(deviceMaster);
            BeanUtils.copyProperties(deviceMaster, deviceMasterNotification);
            List<DeviceMasterNotification> l = (List<DeviceMasterNotification>) deviceMasterNotificationService.readByIpAddress(deviceMasterNotification);
            if (!l.isEmpty()) {
                deviceMasterNotification.setId(((DeviceMasterNotification) l.get(0)).getId());
                deviceMasterNotification.setCountConnectionOut(0);
                deviceMasterNotificationService.update(deviceMasterNotification);
            }
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);

        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String deviceMasterId[] = request.getParameterValues("checkId");
        for (String z : deviceMasterId) {
            try {
                try {

                    DeviceMaster deviceMaster = deviceMasterService.readById(Integer.parseInt(z));
                    DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
                    BeanUtils.copyProperties(deviceMaster, deviceMasterNotification);
                    List<DeviceMasterNotification> l = (List<DeviceMasterNotification>) deviceMasterNotificationService.readByIpAddress(deviceMasterNotification);
                    for (DeviceMasterNotification l1 : l) {
                        deviceMasterNotificationService.delete(l1.getId());
                    }
                } catch (Exception e) {

                }
                deviceMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);

        return mv;
    }

    private synchronized void deviceManagement() throws Exception {
        EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List<?> l1 = deviceMasterService.read();
        for (Object o : l1) {
            try {

                DeviceMaster deviceMaster = (DeviceMaster) o;
                int deviceId = deviceMaster.getId();
                String deviceip = deviceMaster.getIpAddress();
                int deviceport = deviceMaster.getPortNo();
                int seq_number = deviceMaster.getSeqNumber();
                if (seq_number == 50000) {
                    seq_number = 1;
                    deviceMaster.setSeqNumber(seq_number);
                    DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
                    BeanUtils.copyProperties(deviceMaster, deviceMasterNotification);
                    List<DeviceMasterNotification> l = (List<DeviceMasterNotification>) deviceMasterNotificationService.readByIpAddress(deviceMasterNotification);
                    if (!l.isEmpty()) {
                        deviceMasterNotification.setId(((DeviceMasterNotification) l.get(0)).getId());
                        deviceMasterNotification = deviceMasterNotificationService.readById(deviceMasterNotification.getId());
                        deviceMasterNotification.setCountConnectionOut(0);
                        deviceMasterNotificationService.update(deviceMasterNotification);
                    }
                    deviceMasterService.update(deviceMaster);
                }
                int seqNoCounter = seq_number;
                String authkey = "96791AmDFaeasE15635c0b7";
//Multiple mobiles numbers separated by comma
                String vendor_mob_no = "";
                String p_message = "";
                String mobiles = "91" + vendor_mob_no;
                System.out.println(mobiles);
//Sender ID,While using route4 sender id should be 6 characters long.
                String senderId = "102234";
//Your message to send, Add URL encoding here.
                String message = p_message;
//define route
                String route = "1";

//Prepare Url
                URLConnection myURLConnection = null;
                URLConnection myURLConnection1 = null;
                URL myURL = null;
                URL myURL1 = null;
                BufferedReader reader = null;
                BufferedReader reader1 = null;

                String sequenceNoUrl = "http://" + deviceip + ":" + deviceport + "/device.cgi/command?action=geteventcount&format=xml";
                StringBuilder sbPostData1 = new StringBuilder(sequenceNoUrl);
                sequenceNoUrl = sbPostData1.toString();
                myURL1 = new URL(sequenceNoUrl);
                int response1LineCounter = 0;
                String loginPassword1 = "admin" + ":" + "1234";
                String encoded1 = new sun.misc.BASE64Encoder().encode(loginPassword1.getBytes());
                myURLConnection1 = myURL1.openConnection();
                myURLConnection1.setRequestProperty("Authorization", "Basic " + encoded1);
                myURLConnection1.setConnectTimeout(15000);
                myURLConnection1.setReadTimeout(20000);
                try {
                    myURLConnection1.connect();
                    if (myURLConnection1.getInputStream().available() > 0) {
                        reader1 = new BufferedReader(new InputStreamReader(myURLConnection1.getInputStream()));
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String response;
                String rollOverCount = "";
                String urlSeqNo = "";
                if (null == reader1) {
                    DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
                    deviceMasterNotification.setIpAddress(deviceip);
                    List<DeviceMasterNotification> l = (List<DeviceMasterNotification>) deviceMasterNotificationService.readByIpAddress(deviceMasterNotification);
                    for (DeviceMasterNotification l2 : l) {
                        if ((null != l2.getReceipt() || !"".equals(l2.getReceipt())) && deviceMaster.getCountConnectionOut() == l2.getCountConnectionOut()) {
                            for (String empId : l2.getReceipt().split(",")) {
                                if (!"".equals(empId)) {

                                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                                    EmailTemplate emailTemplate = new EmailTemplate();
                                    employeeMaster2 = (EmployeeMaster) employeeMasterService.readEmId(empId);
                                    String To = employeeMaster2.getOfficeEmailId();
                                    emailTemplate = emailTemplateService.readById(141);
                                    String Subject = emailTemplate.getSubject();
                                    String msg = emailTemplate.getBodytext();
                                    sendMail.sendMail("pooja@vaderanco.com", To, Subject, msg);
                                    l2.setCountConnectionOut(0);

                                } else {
                                    l2.setCountConnectionOut((l2.getCountConnectionOut() + 1));

                                }
                                deviceMasterNotificationService.update(l2);
                            }
                        } else {

                        }
                    }
                }
                if (null != reader1) {
                    while ((response = reader1.readLine()) != null) {
                        System.out.println(response);
                        if (response1LineCounter == 3) {
                            urlSeqNo = response;
                            String[] aa = urlSeqNo.split(">");
                            String zz = aa[1];
                            String[] xx = zz.split("<");
                            urlSeqNo = xx[0].trim();
                        }
                        if (response1LineCounter == 2) {
                            rollOverCount = response;
                            String[] aa = rollOverCount.split(">");
                            String zz = aa[1];
                            String[] xx = zz.split("<");
                            rollOverCount = xx[0].trim();
                        }
                        response1LineCounter++;
                    }
                    int curSeqNo = Integer.parseInt(urlSeqNo);
                    int rollOverCountInUrl = Integer.parseInt(rollOverCount);
//encoding message
                    String encoded_message = URLEncoder.encode(message);
                    while (seq_number <= curSeqNo) //-1 is for make this condition alwayts true. and we will termi9nate thisa loop while we get the null response from server using the sequence no.
                    {

//Send SMS API
//            String mainUrl = "http://deviceip:deviceport/device.cgi/events?action=getevent&roll-over-count=1&seq-number=1&no-of-event=1";
                        String mainUrl = "http://" + deviceip + ":" + deviceport + "/device.cgi/events?action=getevent&roll-over-count=" + rollOverCountInUrl + "&seq-number=" + seq_number + "&no-of-events=1";

//Prepare parameter string
                        StringBuilder sbPostData = new StringBuilder(mainUrl);
//            StringBuilder sbPostData = new StringBuilder(mainUrl);
//            StringBuffer sbPostData = new StringBuffer(mainUrl);
//                   sbPostData.append("&action=" + authkey);
                        //       sbPostData.append("&mobiles=" + mobiles);
                        //       sbPostData.append("&message=" + encoded_message);
                        //       sbPostData.append("&route=" + route);
                        //       sbPostData.append("&sender=" + senderId);

//final string
                        mainUrl = sbPostData.toString();
                        try {
                            myURL = new URL(mainUrl);
                            String loginPassword = "admin" + ":" + "1234";
                            String encoded = new sun.misc.BASE64Encoder().encode(loginPassword.getBytes());
                            myURLConnection = myURL.openConnection();
                            myURLConnection.setRequestProperty("Authorization", "Basic " + encoded);
                            myURLConnection.setConnectTimeout(15000);
                            myURLConnection.setReadTimeout(20000);
                            try {
                                myURLConnection.connect();
                                if (myURLConnection.getInputStream().available() > 0) {
                                    reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //reading response
                            String response1;
                            int responseLineCounter = 1;
                            String punchInDate = "";
                            String punchInTime = "";
                            String punchInEmployeeId = "";
                            if (null == reader) {
                                DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
                                deviceMasterNotification.setIpAddress(deviceip);
                                List<DeviceMasterNotification> l = (List<DeviceMasterNotification>) deviceMasterNotificationService.readByIpAddress(deviceMasterNotification);
                                for (DeviceMasterNotification l2 : l) {
                                    if ((null != l2.getReceipt() || !"".equals(l2.getReceipt())) && deviceMaster.getCountConnectionOut() == l2.getCountConnectionOut()) {
                                        for (String empId : l2.getReceipt().split(",")) {
                                            if (!"".equals(empId)) {

                                                EmployeeMaster employeeMaster2 = new EmployeeMaster();
                                                EmailTemplate emailTemplate = new EmailTemplate();
                                                employeeMaster2 = (EmployeeMaster) employeeMasterService.readEmId(empId);
                                                String To = employeeMaster2.getOfficeEmailId();
                                                emailTemplate = emailTemplateService.readById(141);
                                                String Subject = emailTemplate.getSubject();
                                                String msg = emailTemplate.getBodytext();
                                                sendMail.sendMail("pooja@vaderanco.com", To, Subject, msg);
                                                l2.setCountConnectionOut(0);

                                            } else {
                                                l2.setCountConnectionOut((l2.getCountConnectionOut() + 1));

                                            }
                                            deviceMasterNotificationService.update(l2);
                                        }
                                    } else {

                                    }
                                }

                                break;
                            } else {
                                String temp = reader.readLine();
                                while ((response1 = reader.readLine()) != null) //print response
                                {
                                    System.out.println(response1);
                                    if (responseLineCounter == 2) {
                                        punchInDate = response1.replace("date=", "").trim();
                                    }
                                    if (responseLineCounter == 3) {
                                        punchInTime = response1.replace("time=", "").trim();
                                    }
                                    if (responseLineCounter == 5) {
                                        punchInEmployeeId = response1.replace("detail-1=", "").trim();
                                    }
                                    responseLineCounter++;
                                }

                                DeviceMaster deviceMaster1 = new DeviceMaster();
                                deviceMaster1 = deviceMasterService.readById(deviceId);
                                deviceMaster1.setSeqNumber(seq_number);
                                employeeMaster.setEmployeeId(punchInEmployeeId);
                                List<?> empDataList = employeeMasterService.readEmployeeId(punchInEmployeeId);
                                if (!empDataList.isEmpty()) {
                                    employeeMaster = (EmployeeMaster) empDataList.get(0);
                                    employeeDatetimeData.setEmployeeMaster(employeeMaster);
                                    employeeDatetimeData.setDateTime(punchInDate + " " + punchInTime);
                                    employeeDatetimeData.setDeviceMaster(deviceMaster1);
                                    employeeDatetimeDataService.create(employeeDatetimeData);
                                }
                                //deviceMaster1.setSeqNumber(Integer.parseInt(sequenceNoUrl));
                                DeviceMasterNotification deviceMasterNotification = new DeviceMasterNotification();
                                BeanUtils.copyProperties(deviceMaster, deviceMasterNotification);
                                List<DeviceMasterNotification> l = (List<DeviceMasterNotification>) deviceMasterNotificationService.readByIpAddress(deviceMasterNotification);
                                if (!l.isEmpty()) {
                                    deviceMasterNotification.setId(((DeviceMasterNotification) l.get(0)).getId());
                                    deviceMasterNotification = deviceMasterNotificationService.readById(deviceMasterNotification.getId());
                                    deviceMasterNotification.setCountConnectionOut(0);
                                    deviceMasterNotificationService.update(deviceMasterNotification);
                                }
                                deviceMasterService.update(deviceMaster1);
                                seq_number++;
                                if (seq_number == 50000) {
                                    seq_number = 1;
                                }
                            }

                            //finally close connection`
                            reader.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } catch (Exception ex) {
                System.out.println("Deveice Exception" + ex);
            }

        }
    }

    public void deviceManagementUsingThread() {
        class myThread extends Thread {

            @Override
            public void run() {
                try {
                    deviceManagement();
                } catch (Exception e) {

                }
            }
        }

        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
        for (Thread t : threadArray) {
            if (t.getName().contains("deviceManagement")) {
                t.interrupt();
            }
        }
        myThread m = new myThread();
        m.setName("deviceManagement");
        m.start();

    }
}
