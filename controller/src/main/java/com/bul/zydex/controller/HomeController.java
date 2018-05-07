/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.CorporateVideo;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.ThoughtMaster;
import com.bul.zydex.model.UserMaster;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
public class HomeController extends HomeAbstract {

    public ModelAndView openHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.DAY_OF_MONTH, -8);
        Date dateSet = cal6.getTime();

        DepartmentMaster departmentMaster = new DepartmentMaster();
        LevelMaster levelMaster = new LevelMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LocationMaster locationMaster = new LocationMaster();
//        employeeMaster.setUserMaster(user);

//        List<?> employeeList = employeeMasterService.readByUserName(employeeMaster);
//        if (!employeeList.isEmpty()) {
//            employeeMaster1 = (EmployeeMaster) employeeList.get(0);
//            departmentMaster = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
//            employeeMaster1.setDepartmentMaster(departmentMaster);
//            levelMaster = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());
//            employeeMaster1.setLevelMaster(levelMaster);
//            designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
//            employeeMaster1.setDesignationMaster(designationMaster);
//            locationMaster = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
//            employeeMaster1.setLocationMaster(locationMaster);
//
//        }
//        selectEmployee(request, response);
//        selectedEmployeeFor360Feedback(request, employeeMaster1);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String lastOldDate = sdf.format(dateSet);
        String CurrentDate = sdf.format(d);
        List<?> galleryList = galleryService.read();
        List<?> RRList = rAndRService.read();
        List<EmployeeMaster> TodaysBirthdays = (List<EmployeeMaster>) employeeMasterService.readEmployeeByBirthday(CurrentDate);
        List<List<?>> BirthdayList = new ArrayList<>();
        //////////////////today birthdays image/////////////
        for (EmployeeMaster em : TodaysBirthdays) {

            List data = new ArrayList<>();
            String userName = em.getEmployeeId();
            String profilePicturePath = "";
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            File profilePicture = new File(fileLocationURL);
            if (profilePicture.exists() && profilePicture.listFiles().length > 0) {
                File[] file = profilePicture.listFiles();
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName();
            } else {
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
            }
            data.add(em.getId());
            data.add(em.getEmployeeName());
            data.add(profilePicturePath);
            BirthdayList.add(data);
        }

        ThoughtMaster thoughtMaster = thoughtMasterService.readByCurrentDate(CurrentDate);
        List<EmployeeMaster> newJoiningList = (List<EmployeeMaster>) employeeMasterService.newJoiningEmployee(lastOldDate);

        List<List<?>> newjoineeList = new ArrayList<>();
        //////////////////today birthdays image/////////////
        for (EmployeeMaster em1 : newJoiningList) {

            List data = new ArrayList<>();
            String userName = em1.getEmployeeId();
            String profilePicturePath = "";
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            File profilePicture = new File(fileLocationURL);
            if (profilePicture.exists() && profilePicture.listFiles().length > 0) {
                File[] file = profilePicture.listFiles();
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName();
            } else {
                profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
            }
            data.add(em1.getId());
            data.add(em1.getEmployeeName());
            data.add(profilePicturePath);
            newjoineeList.add(data);
        }

        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
        request.setAttribute("videoList", l1);
        request.setAttribute("galleryList", galleryList);
        request.setAttribute("RRList", RRList);
        request.setAttribute("thoughtMaster", thoughtMaster);
        request.setAttribute("newJoiningList", newjoineeList);
        request.setAttribute("TodaysBirthdays", BirthdayList);
        mv.getModelMap().put("employeeMaster", employeeMaster1);
        mv.setViewName("Common/Home");
        return mv;
    }

//    public ModelAndView searchEmployeeDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        EmployeeMaster employeeMaster1 = new EmployeeMaster();
//        Calendar cal6 = Calendar.getInstance();
//        cal6.add(Calendar.DAY_OF_MONTH, -8);
//        Date dateSet = cal6.getTime();
//
//        DepartmentMaster departmentMaster = new DepartmentMaster();
//        LevelMaster levelMaster = new LevelMaster();
//        DesignationMaster designationMaster = new DesignationMaster();
//        LocationMaster locationMaster = new LocationMaster();
////        employeeMaster.setUserMaster(user);
//
////        List<?> employeeList = employeeMasterService.readByUserName(employeeMaster);
////        if (!employeeList.isEmpty()) {
////            employeeMaster1 = (EmployeeMaster) employeeList.get(0);
////            departmentMaster = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
////            employeeMaster1.setDepartmentMaster(departmentMaster);
////            levelMaster = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());
////            employeeMaster1.setLevelMaster(levelMaster);
////            designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
////            employeeMaster1.setDesignationMaster(designationMaster);
////            locationMaster = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
////            employeeMaster1.setLocationMaster(locationMaster);
////
////        }
//        selectEmployee(request, response);
////        selectedEmployeeFor360Feedback(request, employeeMaster1);
//
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String lastOldDate = sdf.format(dateSet);
//        String CurrentDate = sdf.format(d);
//        List<?> galleryList = galleryService.read();
//        List<?> RRList = rAndRService.read();
//
//        ThoughtMaster thoughtMaster = thoughtMasterService.readByCurrentDate(CurrentDate);
//        List<?> newJoiningList = employeeMasterService.newJoiningEmployee(lastOldDate);
//
//        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
//        request.setAttribute("videoList", l1);
//        request.setAttribute("galleryList", galleryList);
//        request.setAttribute("RRList", RRList);
//        request.setAttribute("thoughtMaster", thoughtMaster);
//        request.setAttribute("newJoiningList", newJoiningList);
//        request.setAttribute("TodaysBirthdays", BirthdayList);
//        mv.getModelMap().put("employeeMaster", employeeMaster1);
//        mv.setViewName("Common/Home");
//        return mv;
//    }
    public ModelAndView opanGallery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> galleryList = galleryService.read();
        request.setAttribute("galleryList", galleryList);
        mv.setViewName("Common/Gallery");
        return mv;
    }

    public ModelAndView opanRR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> RRList = rAndRService.read();
        request.setAttribute("RRList", RRList);
        mv.setViewName("Common/RewardAndRecognition");
        return mv;
    }

    public ModelAndView kaizen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> kaizenlist = kaizenMasterService.readKaizenList();
            int inc = kaizenlist.size();
            int inc1 = inc + 1;
             request.setAttribute("randomNumber", inc1);
        mv.setViewName( "Kaizen/Kaizen");
        return mv;
//        int index = 0;
//        int srNo = (index + 1);
//        Random random=new Random();   
//        int randomNumber=random.nextInt(10000000);
    }
      public ModelAndView report(HttpServletRequest request, HttpServletResponse response) throws Exception {
          ModelAndView mv = new ModelAndView();
          mv.setViewName("Common/reports");
          return mv;
      }

}
