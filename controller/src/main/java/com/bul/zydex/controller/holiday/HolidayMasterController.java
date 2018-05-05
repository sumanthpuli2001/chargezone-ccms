/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.holiday;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan
 */
public class HolidayMasterController extends HolidayMasterAbstract {

    //    protected String createClick(Model model) throws Exception {
    //
    //        return "ListOfHoliday";
    //    }
    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<?> holidayList = holidayMasterService.readWithLocation();
        return new ModelAndView("Holiday/HolidayList", "holidayList", holidayList);
    }

    public ModelAndView createOrUpdateClick(HttpServletRequest request, HttpServletResponse response, HolidayMaster holidayMaster) throws Exception {
        if (holidayMaster.getId() != null) {
            holidayMaster = holidayMasterService.readById(holidayMaster.getId());
            holidayMaster.setLocationMaster(holidayMaster.getLocationMaster());
        } else {
            holidayMaster.setLocationMaster(new LocationMaster());
        }
        ModelAndView mv = new ModelAndView();
        Map<Integer, String> locationMap = readLocations();
        mv.addObject("locationMap", locationMap);
        mv.getModelMap().put("holidayMaster", holidayMaster);
        mv.setViewName("Holiday/HolidayCreateOrUpdate");
        return mv;
    }

    public ModelAndView createOrUpdateSubmit(HttpServletRequest request, HttpServletResponse response, HolidayMaster holidayMaster) throws Exception {
        BindException errors = new BindException(holidayMaster, "holidayMaster");
        bind(request, holidayMaster);
        ModelAndView mv = new ModelAndView();
        Map<Integer, String> locationMap = readLocations();
        mv.addObject("locationMap", locationMap);
        
        List<?> holidayMasterList = holidayMasterService.readHolidaysDateLocationWise(request.getParameter("holidayFromDate"),request.getParameter("holidayToDate"),Integer.parseInt(request.getParameter("locationMaster.id")));
        
        holidayMasterValidator.validate(holidayMaster, errors);
        
        if (errors.hasFieldErrors()) {
            mv.addObject("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Holiday/HolidayCreateOrUpdate");

        } else {
            if (null == holidayMaster.getId() && !holidayMasterList.isEmpty()) {
                mv.setViewName("Holiday/HolidayCreateOrUpdate");
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
            } else {
                holidayMasterService.createOrUpdate(holidayMaster);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                List<?> holidayList = holidayMasterService.readWithLocation();
                mv.addObject("holidayList", holidayList);
                mv.setViewName("Holiday/HolidayList");
            }
        }
        mv.getModelMap().put("holidayMaster", holidayMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, HolidayMaster holidayMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        boolean flag = false;
        int nonDeletedCount = 0;
        String nonDeletedcheckedStr = "";
        for (String checkedValues : checkId) {
            try {
                holidayMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    holidayMaster = holidayMasterService.readById(Integer.parseInt(checkedValues));
                    if (nonDeletedCount == 0) {
                        nonDeletedcheckedStr += holidayMaster.getHolidayFromDate();
                    } else {
                        nonDeletedcheckedStr += "," + holidayMaster.getHolidayFromDate();
                    }
                    nonDeletedCount++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            mv.addObject("failureMessage", "Error : In Use, Can't Be Deleted data From dates.....  " + "<b>" + nonDeletedcheckedStr + "</b> Is In Use.");
        } else {
            mv.addObject("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:holidayMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView holidayExcelUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Holiday/HolidayExcelUpload");
        return mv;
    }

    public void readHolidayUploadFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "HolidayExcelUpload" + File.separator + fileName;

        String appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView holidayExcelUploadSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file1");
        String holidayTitle = "";
        String zydexLocation = "";
        String fromDate = "";
        String toDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int count = 0;
        try {
            if (multipartFile.getSize() > 0) {
                InputStream file = multipartFile.getInputStream();
                Workbook workbook = WorkbookFactory.create(file);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    if (row.getRowNum() != 0) {
                        holidayTitle = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                        zydexLocation = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
//                        fromDate = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
                        toDate = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
                        Date sDate = row.getCell((short) 2).getDateCellValue();
                        Date eDate = row.getCell((short) 3).getDateCellValue();
                        if (sDate != null && eDate != null) {

                            fromDate = sdf.format(sDate);
                            toDate = sdf.format(eDate);
                            List<?> list = locationMasterService.readByName(zydexLocation);
                            LocationMaster locationMaster = new LocationMaster();
                            if (!list.isEmpty()) {
                                locationMaster = (LocationMaster) list.get(0);
                            } else {
                                locationMaster.setLocation(zydexLocation);
                                locationMasterService.create(locationMaster);
                            }
                            HolidayMaster holidayMaster = new HolidayMaster();
                            holidayMaster.setTitle(holidayTitle);
                            holidayMaster.setLocationMaster(locationMaster);
                            holidayMaster.setHolidayFromDate(fromDate);
                            holidayMaster.setHolidayToDate(toDate);
                            holidayMasterService.create(holidayMaster);
                        }
                    }
                }
            }
            request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
//            request.setAttribute("failureMessage", "Information : " + count + " Rcecords Not Inserted Due To Employe No Is Not Correct");
            mv = showList(request, response);
        } catch (Exception e) {
            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
            mv = holidayExcelUpload(request, response);
        }
        return mv;
    }
  
    public ModelAndView viewHolidaysLocationWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session1 = request.getSession(false);
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session1.getAttribute("employeeInfo");
        
        Calendar now = Calendar.getInstance();
          int year = now.get(Calendar.YEAR);
        List<?> holidayList = holidayMasterService.readHolidaysLocationWise(""+employeeMaster1.getLocationMaster().getId());
        request.setAttribute("holidayList", holidayList);
        request.setAttribute("currentYear", year);
        
        
        mv.setViewName("Holiday/HolidayListLocationwise");
        
     return mv;
    }
}
