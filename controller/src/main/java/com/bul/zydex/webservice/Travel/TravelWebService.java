/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice.Travel;

import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HotelAccommodation;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.model.TravelDetail;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jay
 */
public class TravelWebService extends TravelWebServiceAbstract {

    public void newRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
//        JSONArray jSONArray = new JSONArray();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        String empCompany = "";
        String empNo = "";
        String empLevel = "";
        List<?> userList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!userList.isEmpty()) {

            Object[] obj = (Object[]) userList.get(0);
            empNo = "" + obj[0];
            empCompany = "" + obj[7];
            empLevel = "" + obj[3];
            List<?> emplist = employeeMasterService.readByUserName(employeeMaster);
            if (!emplist.isEmpty()) {
                for (Object o : emplist) {
                    employeeMaster = (EmployeeMaster) o;
                }
            }
            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster);
            List<?> totalList = travelRequestMasterService.readTotalRequest(travelRequestMaster);
            rcode = "1";
            message = "Success";
            int count = totalList.size() + 1;
            Calendar now = Calendar.getInstance();

            String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
            int year = now.get(Calendar.YEAR);
            String name = monthName[now.get(Calendar.MONTH)];
            if ((empCompany.equals("Zydex Industries") || empCompany.equalsIgnoreCase("ZydexIndustries")) && !empCompany.equals("")) {
                empCompany = "ZI";
            } else {
                empCompany = "ZIPL";
            }
            String requestNo = empCompany + "/" + year + "/" + name + "/" + empNo + "/" + count + "";
            data.put("requestNo", requestNo);
            List<?> list = policyDeviationForAirService.readlevelWise(empLevel);
            String deviation = "";
            if (!list.isEmpty()) {
                list.get(0);
                deviation = "" + list.get(0);
            }
            if (deviation.equals("No")) {
                deviation = "Yes";
                data.put("deviation", deviation);
            } else {
                deviation = "No";
                data.put("deviation", deviation);
            }
        } else {
            rcode = "0";
            message = "Error";
        }
        List<?> currencyList = currencyMasterService.read();
        if (!currencyList.isEmpty()) {
            JSONArray currencyDetail = new JSONArray();
            for (Object o : currencyList) {
                CurrencyMaster currencyMaster = (CurrencyMaster) o;
                JSONObject currency = new JSONObject();
                currency.put("currencyId", currencyMaster.getId().toString());
                currency.put("currencyName", currencyMaster.getCurrencyName().toString());
                currencyDetail.put(currency);
                data.put("currencyDetail", currencyDetail);
            }
        } else {
            rcode = "3";
            message = "Currency Detail Not Found.";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void travelRequestList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        UserMaster user = new UserMaster();
        String rcode = "";
        String empid = "";
        String message = "";
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<EmployeeMaster> empDetailList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
        if (!empDetailList.isEmpty()) {
            EmployeeMaster employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> showRequest = travelRequestMasterService.requestDetail(travelRequestMaster);

            if (!showRequest.isEmpty()) {

                for (int i = 0; i < showRequest.size(); i++) {
                    Object[] arrayObj = (Object[]) showRequest.get(i);
                    JSONObject obj = new JSONObject();
                    String statusMessage = "";
                    String ApproveName;
                    if (null == arrayObj[6]) {
                        ApproveName = "";
                    } else {
                        ApproveName = arrayObj[6].toString();
                    }
                    if (arrayObj[4].equals(0)) {
                        statusMessage = "Pending";
                    }
                    if (arrayObj[4].equals(1)) {
                        statusMessage = "Reworked By " + ApproveName;
                    }
                    if (arrayObj[4].equals(2)) {
                        statusMessage = "Rejected By " + ApproveName;
                    }
                    if (arrayObj[4].equals(3)) {
                        statusMessage = "Approved By " + ApproveName;
                    }
                    if (arrayObj[4].equals(4)) {
                        statusMessage = "WithDraw";
                    }
                    if (arrayObj[4].equals(5)) {
                        statusMessage = "Final Approved By " + ApproveName;
                    }
                    if (arrayObj[4].equals(6)) {
                        statusMessage = "Approved By " + ApproveName;
                    }
                    if (arrayObj[4].equals(8)) {
                        statusMessage = "Approved By " + ApproveName;
                    }
                    if (arrayObj[4].equals(10)) {
                        statusMessage = "Pending";
                    }
                    obj.put("employeeId", arrayObj[7].toString());
                    obj.put("employeeName", arrayObj[8].toString());
                    obj.put("travelId", arrayObj[5].toString());
                    obj.put("travelType", arrayObj[0].toString());
                    obj.put("travelRequestNo", arrayObj[1].toString());
                    if (!arrayObj[0].toString().contains("Local")) {
                        obj.put("startDate", arrayObj[2].toString());
                        obj.put("endDate", arrayObj[3].toString());
                    }
                    obj.put("statusId", arrayObj[4].toString());
                    obj.put("statusMessage", statusMessage);
                    jSONArray.put(obj);
                }
                data.put("travelRequestList", jSONArray);
                rcode = "1";
                message = "Success";
            } else {
                data.put("travelRequestList", jSONArray);
                rcode = "1";
                message = "Success";
            }

        } else {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void viewTravelRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        String travelRequestId = request.getParameter("travelId");
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelRequestId));
        if (null == travelRequestMaster) {
            rcode = "0";
            message = "TravelRequestId not found";
        } else {
            int employeeId = travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            employeeMaster = employeeMasterService.readById(employeeId);
            data.put("travelRequestApplicationNo", travelRequestMaster.getTravelRequestNo());
            data.put("travelType", travelRequestMaster.getTravelType());
            if (!travelRequestMaster.getTravelType().contains("Local")) {
                data.put("startDateTime", travelRequestMaster.getStartDateTime());
                data.put("endDateTime", travelRequestMaster.getEndDateTime());
            }
            rcode = "1";
            message = "Success";
            data.put("dateOfSubmit", travelRequestMaster.getDateOfSubmit());
            data.put("advancedRequired", travelRequestMaster.getCashRequired());
            if (travelRequestMaster.getCashRequired().contains("Yes")) {

                data.put("amount", travelRequestMaster.getAmount());
                data.put("reasonOfAdvanced", travelRequestMaster.getReasonForAdvance());
            }
            data.put("reasonForTravel", travelRequestMaster.getPurpose());
            CurrencyMaster currencyMaster = new CurrencyMaster();
            if (travelRequestMaster.getTravelType().toString().contains("International")
                    && travelRequestMaster.getCashRequired().contains("Yes")) {
                String currencyId = travelRequestMaster.getCurrency();
                currencyMaster = currencyMasterService.readById(Integer.parseInt(currencyId));
                String currency = currencyMaster.getCurrencyName();
                String currencyCode = currencyMaster.getCurrencyCode();
                String currencyName = currency + "(" + currencyCode + ")";
                data.put("currencyId", currencyId);
                data.put("currencyName", currencyName);
            }
            TravelDetail travelDetail = new TravelDetail();
            travelDetail.setTravelRequestMaster(travelRequestMaster);
            List<?> travelDetail1 = travelDetailService.readTravelDetail(travelDetail);
            if (!travelDetail1.isEmpty()) {
                JSONArray travelDetails = new JSONArray();
                for (Object o : travelDetail1) {
                    JSONObject travel = new JSONObject();
                    TravelDetail travelDetail2 = (TravelDetail) o;
                    travel.put("travelDetailId", travelDetail2.getId().toString());
                    travel.put("date", travelDetail2.getDate());
                    travel.put("fromLocation", travelDetail2.getFromLocation());
                    travel.put("toLocation", travelDetail2.getToLocation());
                    travel.put("modeOfTravel", travelDetail2.getModeOfTravel());
                    travel.put("policyDeviation", travelDetail2.getPolicyDeviation());
                    travel.put("remarks", travelDetail2.getComments());
                    travelDetails.put(travel);
                    rcode = "1";
                    message = "Success";
                }
                data.put("travelDetails", travelDetails);
            }
            HotelAccommodation hotelAccommodation = new HotelAccommodation();
            hotelAccommodation.setTravelRequestMaster(travelRequestMaster);
            List<?> hotel1 = hotelAccommodationService.readAccommodationDetail(hotelAccommodation);
            if (!hotel1.isEmpty()) {
                JSONArray hotelDetails = new JSONArray();
                for (Object hotels : hotel1) {
                    JSONObject hotel = new JSONObject();
                    HotelAccommodation hotelAccommodation1 = (HotelAccommodation) hotels;
                    hotel.put("hotelDetailId", hotelAccommodation1.getId());
                    hotel.put("hotelBookingRequired", hotelAccommodation1.getHotelBookingRequired());
                    hotel.put("location", hotelAccommodation1.getLocation());
                    hotel.put("preferredHotels", hotelAccommodation1.getPreferredHotel());
                    hotel.put("checkInDate", hotelAccommodation1.getCheckInDate());
                    hotel.put("checkOutDate", hotelAccommodation1.getCheckOutDate());
                    hotel.put("remarks", hotelAccommodation1.getComments());
                    hotelDetails.put(hotel);
                    rcode = "1";
                    message = "Success";
                }
                data.put("hotelDetails", hotelDetails);
            }
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void CreateTravelRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = doPost(request);
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
        if (!empDetailList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
        }
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
        travelRequestMaster.setTravelRequestNo(data.get("travelRequestApplicationNo").toString());
        travelRequestMaster.setTravelType(data.get("travelType").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
        Date date1 = new Date();
        String dateOfSubmit = sdf.format(date1);
        travelRequestMaster.setDateOfSubmit(dateOfSubmit);
        travelRequestMaster.setCashRequired(data.get("advancedRequired").toString());
        if (data.getString("advancedRequired").contains("Yes")) {
            travelRequestMaster.setAmount(Float.parseFloat(data.get("amount").toString()));
            travelRequestMaster.setReasonForAdvance(data.get("reasonOfAdvanced").toString());
        }
        travelRequestMaster.setPurpose(data.get("reasonForTravel").toString());
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
        if (!travelRequestMaster.getTravelType().contains("Local")) {
            travelRequestMaster.setStartDateTime(data.get("startDateTime").toString());
            travelRequestMaster.setEndDateTime(data.get("endDateTime").toString());
            if (data.getString("travelType").contains("International") && data.getString("advancedRequired").contains("Yes")) {
                travelRequestMaster.setCurrency(data.get("currencyId").toString());
            }
            Date startDate = sd.parse(travelRequestMaster.getStartDateTime());
            Date endDate = sd.parse(travelRequestMaster.getEndDateTime());
            if (!startDate.after(endDate)) {
                boolean flag = false;
                TravelRequestMaster travelRequestMaster1 = new TravelRequestMaster();
                travelRequestMaster1.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                List<?> travelEmployeePast = travelRequestMasterService.readTravelEmployeePastRequest(travelRequestMaster1);
                for (Object o : travelEmployeePast) {
                    try {
                        travelRequestMaster1 = (TravelRequestMaster) o;
                        Date pastSDate = sd.parse(travelRequestMaster1.getStartDateTime());
                        Date pastEDate = sd.parse(travelRequestMaster1.getEndDateTime());
                        if (startDate.equals(pastSDate) || (startDate.after(pastSDate) && startDate.before(pastEDate)) || (endDate.after(pastSDate) && endDate.before(pastEDate)) || (endDate.equals(pastEDate))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    } catch (Exception e) {

                    }
                }
                if (flag) {
                    rcode = "0";
                    message = "Error : You can't Apply Request on Same Day..";
                } else {
                    travelRequestMasterService.create(travelRequestMaster);
                    JSONArray jaTravelDeatails = data.getJSONArray("travelDetails");
                    JSONArray jaHotelDetails = data.getJSONArray("hotelDetails");
                    for (int i = 0; i < jaTravelDeatails.length(); i++) {
                        TravelDetail travelDetail = new TravelDetail();
                        travelDetail.setTravelRequestMaster(travelRequestMaster);
                        JSONObject joTravelDetail = jaTravelDeatails.getJSONObject(i);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date11 = formatter.parse(joTravelDetail.get("date").toString());
                        String date = formatter.format(date11);
//                        sd.parse(date);
                        String fromLocation = joTravelDetail.get("fromLocation").toString();
                        String toLocation = joTravelDetail.get("toLocation").toString();
                        String travelMode = joTravelDetail.get("modeOfTravel").toString();
                        String policyDeviation = joTravelDetail.get("policyDeviation").toString();
                        String comments = joTravelDetail.get("remarks").toString();
                        if (!"".equals(date) && null != date && !"".equals(fromLocation) && null != fromLocation && !"".equals(toLocation) && null != toLocation && !"".equals(travelMode) && null != travelMode) {
                            travelDetail.setDate(date.toString());
                            travelDetail.setFromLocation(fromLocation);
                            travelDetail.setToLocation(toLocation);
                            travelDetail.setModeOfTravel(travelMode);
                            travelDetail.setPolicyDeviation(policyDeviation);
                            travelDetail.setComments(comments);
                            travelDetailService.create(travelDetail);
                        } else {
                            rcode = "0";
                            message = "Error : Please Enter the valid data.";
                        }
                    }
                    for (int j = 0; j < jaHotelDetails.length(); j++) {
                        HotelAccommodation hotelAccommodation = new HotelAccommodation();
                        hotelAccommodation.setTravelRequestMaster(travelRequestMaster);
                        JSONObject joHotelDetails = jaHotelDetails.getJSONObject(j);
                        hotelAccommodation.setHotelBookingRequired(joHotelDetails.getString("bookingRequired").toString());
                        if (joHotelDetails.getString("bookingRequired").toString().contains("Yes")) {
                            hotelAccommodation.setCheckInDate(joHotelDetails.get("checkInDate").toString());
                            hotelAccommodation.setCheckOutDate(joHotelDetails.getString("checkOutDate").toString());
                            hotelAccommodation.setPreferredHotel(joHotelDetails.getString("preferredHotels").toString());

                        }
                        hotelAccommodation.setLocation(joHotelDetails.get("location").toString());
                        hotelAccommodation.setComments(joHotelDetails.get("remarks").toString());
                        hotelAccommodationService.create(hotelAccommodation);
                    }
                    rcode = "1";
                    message = "Success";
                }
            } else {
                rcode = "0";
                message = "Error : Please Insert Start Date Before End Date.";
            }
        } else {

            travelRequestMasterService.create(travelRequestMaster);
            rcode = "1";
            message = "Success";
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void withDraw(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        JSONObject data = doPost(request);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        String travelRequestId = request.getParameter("travelId");
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        TravelDetail travelDetail = new TravelDetail();
        HotelAccommodation hotelAccommodation = new HotelAccommodation();
        TravelApproverHistory travelApproverHistory1 = new TravelApproverHistory();
        travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelRequestId));
        if (null == travelRequestMaster) {
            rcode = "0";
            message = "TravelId Not Found";
        } else {
            String withDrawRemark = data.getString("withDrawRemark");
            travelRequestMaster.setEmpRemark(withDrawRemark);
            int employeeId = travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            employeeMaster = employeeMasterService.readById(employeeId);
            if (travelRequestMaster.getStatus() == 0 || travelRequestMaster.getStatus() == 1) {
                if (travelRequestMaster.getStatus() == 1) {
                    TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                    travelApproverHistory.setTravelRequestMaster(travelRequestMaster);
                    List travelHistory = travelApproverHistoryService.readSameTravelId(travelApproverHistory);
                    for (Object o : travelHistory) {
                        travelApproverHistory = (TravelApproverHistory) o;
                        travelApproverHistoryService.delete(travelApproverHistory.getId());

                    }
                }

                travelDetail.setTravelRequestMaster(travelRequestMaster);
                hotelAccommodation.setTravelRequestMaster(travelRequestMaster);
                travelApproverHistory1.setTravelRequestMaster(travelRequestMaster);
                List<?> TravelDetailsList = travelDetailService.readTravelDetail(travelDetail);
                if (!TravelDetailsList.isEmpty()) {
                    for (Object o : TravelDetailsList) {
                        travelDetail = (TravelDetail) o;
                        travelDetailService.delete(travelDetail.getId());
                    }
                }
                List<?> Hotellist = hotelAccommodationService.readAccommodationDetail(hotelAccommodation);
                if (!Hotellist.isEmpty()) {
                    for (Object o : Hotellist) {
                        hotelAccommodation = (HotelAccommodation) o;
                        hotelAccommodationService.delete(hotelAccommodation.getId());
                    }
                }
                List<?> TravelApproverlist = travelApproverHistoryService.readSameTravelId(travelApproverHistory1);
                if (!TravelApproverlist.isEmpty()) {
                    for (Object o : TravelApproverlist) {
                        travelApproverHistory1 = (TravelApproverHistory) o;
                        travelApproverHistoryService.delete(travelApproverHistory1.getId());
                    }
                }

                travelRequestMasterService.delete(travelRequestMaster.getId());
                rcode = "1";
                message = "Sucess";
            } else if (travelRequestMaster.getStatus() == 3 || travelRequestMaster.getStatus() == 10) {
                travelRequestMaster.setStatus(4);
                travelRequestMasterService.update(travelRequestMaster);
                rcode = "1";
                message = "Sucess";
            }
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void updateRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();

        try {
            JSONObject data = doPost(request);
            String travelRequestId = request.getParameter("travelId");
            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            List<?> travelDetailList = new ArrayList<Object>();
            List<?> hotelAccommodationList = new ArrayList<Object>();

            travelDetailList = travelDetailService.readByTravelId(Integer.parseInt(travelRequestId));
            if (!travelDetailList.isEmpty()) {
                for (Object o : travelDetailList) {
                    TravelDetail td = (TravelDetail) o;
                    int travelDetailId = td.getId();
                    travelDetailService.delete(travelDetailId);
                }
            }

            hotelAccommodationList = hotelAccommodationService.readByTravelId(Integer.parseInt(travelRequestId));
            if (!hotelAccommodationList.isEmpty()) {
                for (Object o : hotelAccommodationList) {
                    HotelAccommodation ha = (HotelAccommodation) o;
                    int hotelAccId = ha.getId();
                    hotelAccommodationService.delete(hotelAccId);
                }
            }
            travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelRequestId));
            int employeeId = travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            employeeMaster = employeeMasterService.readById(employeeId);
            if (data.getString("statusId") == "1") {
                travelRequestMaster.setStatus(10);
//            travelRequestMaster.setDateOfSubmit(data.getString("dateOfSubmit"));
                TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                travelApproverHistory.setTravelRequestMaster(travelRequestMaster);
                List list = travelApproverHistoryService.readSameTravelId(travelApproverHistory);
                for (Object o : list) {
                    travelApproverHistory = (TravelApproverHistory) o;
                    travelApproverHistory.setReturnFlag(1);
                    travelApproverHistoryService.update(travelApproverHistory);
                }
            } else {
                travelRequestMaster.setStatus(0);
            }
            travelRequestMaster.setTravelRequestNo(data.getString("travelRequestApplicationNo"));
            travelRequestMaster.setTravelType(data.getString("travelType"));
            if (!data.getString("travelType").contains("Local")) {
                travelRequestMaster.setStartDateTime(data.getString("startDateTime"));
                travelRequestMaster.setEndDateTime(data.getString("endDateTime"));
            }
            travelRequestMaster.setDateOfSubmit(data.getString("dateOfSubmit"));
            travelRequestMaster.setCashRequired(data.getString("advancedRequired"));
            if (data.getString("advancedRequired").contains("Yes")) {
                travelRequestMaster.setAmount(Float.parseFloat(data.getString("amount")));
                travelRequestMaster.setReasonForAdvance(data.getString("reasonOfAdvanced"));
            }
            //Reason for travel is reason for request
            travelRequestMaster.setPurpose(data.getString("reasonForTravel"));
            CurrencyMaster currencyMaster = new CurrencyMaster();
            if (travelRequestMaster.getTravelType().toString().contains("International")) {
                travelRequestMaster.setCurrency(data.getString("currencyId"));
            }
            travelRequestMasterService.update(travelRequestMaster);
            if (!data.getString("travelType").contains("Local")) {
                JSONArray travelDetails1 = data.getJSONArray("travelDetails");
                JSONArray hotelDetails1 = data.getJSONArray("hotelDetails");
                for (int i = 0; i < travelDetails1.length(); i++) {
                    TravelDetail travelDetail = new TravelDetail();
                    travelDetail.setTravelRequestMaster(travelRequestMaster);
                    JSONObject travelDetailobj = travelDetails1.getJSONObject(i);
                    travelDetail.setDate(travelDetailobj.getString("date"));
                    travelDetail.setFromLocation(travelDetailobj.getString("fromLocation"));
                    travelDetail.setToLocation(travelDetailobj.getString("toLocation"));
                    travelDetail.setModeOfTravel(travelDetailobj.getString("modeOfTravel"));
                    travelDetail.setPolicyDeviation(travelDetailobj.getString("policyDeviation"));
                    travelDetail.setComments(travelDetailobj.getString("remarks"));
                    String travelDetailID = travelDetailobj.getString("travelDetailId");
                    if (!travelDetailID.equals("")) {
                        travelDetailService.create(travelDetail);
                    } else {
                        travelDetailService.create(travelDetail);
                    }
                }
                for (int j = 0; j < hotelDetails1.length(); j++) {
                    HotelAccommodation hotelAccommodation = new HotelAccommodation();
                    hotelAccommodation.setTravelRequestMaster(travelRequestMaster);
                    JSONObject hotelDetailObj = hotelDetails1.getJSONObject(j);
                    hotelAccommodation.setHotelBookingRequired(hotelDetailObj.getString("bookingRequired"));
                    if (hotelDetailObj.getString("bookingRequired").contains("Yes")) {
                        hotelAccommodation.setLocation(hotelDetailObj.getString("location"));
                        hotelAccommodation.setPreferredHotel(hotelDetailObj.getString("preferredHotels"));
                        hotelAccommodation.setCheckInDate(hotelDetailObj.getString("checkInDate"));
                        hotelAccommodation.setCheckOutDate(hotelDetailObj.getString("checkOutDate"));
                    }
                    hotelAccommodation.setComments(hotelDetailObj.getString("remarks"));
                    String hotelDetailId = hotelDetailObj.getString("hotelDetailId");
                    if (!hotelDetailId.equals("")) {
                        hotelAccommodationService.create(hotelAccommodation);
                    } else {
                        hotelAccommodationService.create(hotelAccommodation);
                    }
                }
                rcode = "1";
                message = "Sucess";
            }
        } catch (Exception exception) {
            rcode = "0";
            message = "Something Wrong";

        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public boolean managercheck(int tabId, String MangerId, int i, int j) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean flag = false;
        List l1 = travelApproverHistoryService.readpreviousmanagerdata(tabId, MangerId);
        String lastApproveDateString = (String) l1.get(0);
        Date lastApproveDate = sdf.parse(lastApproveDateString);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(lastApproveDate);
        c1.add(Calendar.DATE, i);
        Date managerapprove1 = c1.getTime();

        c1.setTime(managerapprove1);
        c1.add(Calendar.DATE, j);
        Date managerapprove2 = c1.getTime();

        String today = sdf.format(new Date());
        Date tDate = sdf.parse(today);

        if ((DateUtils.isSameDay(managerapprove1, tDate) || tDate.after(managerapprove1)) && (DateUtils.isSameDay(managerapprove2, tDate) || tDate.before(managerapprove2))) {
            flag = true;
        }

        return flag;
    }

    public void travelApproverList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ParseException, Exception {
        PrintWriter out = null;
        out = response.getWriter();
        UserMaster user = new UserMaster();
        String rcode = "";
        String empid = "";
        String message = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray finalList = new JSONArray();
        JSONArray finalList1 = new JSONArray();
        try {
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            List<EmployeeMaster> empDetailList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
            }
            String loginId = employeeMaster1.getId().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            boolean flag = false;

            List list = travelRequestMasterService.readListForApprover(travelRequestMaster, employeeMaster1.getId());
            if (!list.isEmpty()) {
                for (Object obj : list) {
                    Object[] o1 = (Object[]) obj;
                    JSONObject dataOfEmp = new JSONObject();
                    String statusMessage = "";
                    String ApproveName;
                    if (null == o1[11]) {
                        ApproveName = "";
                    } else {
                        ApproveName = o1[11].toString();
                    }
                    if (o1[8].equals(0)) {
                        statusMessage = "Pending";
                    }
                    if (o1[8].equals(1)) {
                        statusMessage = "Reworked By " + ApproveName;
                    }
                    if (o1[8].equals(2)) {
                        statusMessage = "Rejected By " + ApproveName;
                    }
                    if (o1[8].equals(3)) {
                        statusMessage = "Pending";
                    }
                    if (o1[8].equals(4)) {
                        statusMessage = "WithDraw";
                    }
                    if (o1[8].equals(5)) {
                        statusMessage = "Final Approved By " + ApproveName;
                    }
                    if (o1[8].equals(6)) {
                        statusMessage = "Approved By " + ApproveName;
                    }
                    if (o1[8].equals(8)) {
                        statusMessage = "Approved By " + ApproveName;
                    }
                    if (o1[8].equals(10)) {
                        statusMessage = "Return Request Pending";
                    }

                    dataOfEmp.put("employeeId", o1[2]);
                    dataOfEmp.put("employeeName", o1[3]);
                    dataOfEmp.put("travelType", o1[4]);
                    dataOfEmp.put("travelRequestNo", o1[5]);
                    dataOfEmp.put("startDate", o1[6]);
                    dataOfEmp.put("endDate", o1[7]);
                    dataOfEmp.put("status", o1[8]);
                    dataOfEmp.put("statusMessage", statusMessage);
                    dataOfEmp.put("empMasterId", o1[0]);
                    dataOfEmp.put("travelId", o1[1]);

//                travelRequestMaster = (TravelRequestMaster) obj;
                    int employeeId = (int) o1[0];
                    int tabId = (int) o1[1];
                    int status = (int) o1[8];
                    employeeMaster2 = employeeMasterService.readById(employeeId);
                    String manager1 = employeeMaster2.getReportingManagerLevel1();
                    String manager2 = employeeMaster2.getReportingManagerLevel2();
                    String manager3 = employeeMaster2.getReportingManagerLevel3();
                    String manager4 = employeeMaster2.getReportingManagerLevel4();
                    String manager5 = employeeMaster2.getReportingManagerLevel5();
                    String aprroverid = "";
                    int ReturnFlag = 0;
                    int historyappid = 0;
                    int historyappid1 = 0;
                    if (status != 0) {
                        if (status != 10) {
//                        int aprroverid1 = (int) o1[10];
                            if (o1[10] == null) {

                                aprroverid = "";
                            } else {
                                aprroverid = (String) o1[10].toString();
                            }

//                        System.out.println("Ajay" + aprroverid1);
                        }
                    }
                    List<?> approverList = travelApproverHistoryService.readapproverlist(tabId, loginId);
                    for (Object o : approverList) {
                        TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                        travelApproverHistory = (TravelApproverHistory) o;
                        ReturnFlag = travelApproverHistory.getReturnFlag();
                        if (ReturnFlag == 0) {
                            historyappid = travelApproverHistory.getEmployeeMasterByTravelApproverId().getId();
                        }
                        if (ReturnFlag == 1) {
                            historyappid1 = travelApproverHistory.getEmployeeMasterByTravelApproverId().getId();
                        }
                    }
                    if ((status == 3 && ReturnFlag == 0) || status == 0 || status == 10 || status == 1) {
                        String dos1 = o1[9].toString();
                        Date dos = sdf.parse(dos1);
                        String today = sdf.format(new Date());
                        Date tDate = sdf.parse(today);
                        Calendar c = Calendar.getInstance();
                        c.setTime(dos);
                        c.add(Calendar.DATE, 7);
                        Date Date7 = c.getTime();
                        c.setTime(Date7);
                        c.add(Calendar.DATE, 7);
                        Date Date14 = c.getTime();
                        c.setTime(Date14);
                        c.add(Calendar.DATE, 7);
                        Date Date21 = c.getTime();
                        c.setTime(Date21);
                        c.add(Calendar.DATE, 7);
                        Date Date28 = c.getTime();
                        c.setTime(Date28);
                        c.add(Calendar.DATE, 7);
                        Date Date35 = c.getTime();

                        if (Integer.parseInt(manager1) == Integer.parseInt(loginId)) {
                            if ((DateUtils.isSameDay(dos, tDate) || tDate.after(dos)) && tDate.before(Date7)) {
                                finalList.put(dataOfEmp);
                            }
                        }
                        if (!manager2.isEmpty() && !manager1.isEmpty()) {
                            if (Integer.parseInt(manager2) == Integer.parseInt(loginId)) {
                                if (historyappid != 0) {
                                    if (Integer.parseInt(loginId) == historyappid) {
                                        finalList.put(dataOfEmp);
                                    }
                                }
                                if (aprroverid == null || aprroverid == "") {
                                    if ((DateUtils.isSameDay(Date7, tDate) || tDate.after(Date7)) && tDate.before(Date14)) {
                                        finalList.put(dataOfEmp);
                                    }
                                } else if (status != 1) {
                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                        finalList.put(dataOfEmp);
                                    }
                                }
                            }
                        }
                        if (!manager3.isEmpty() && !manager2.isEmpty() && !manager1.isEmpty()) {
                            if (Integer.parseInt(manager3) == Integer.parseInt(loginId)) {
                                if (historyappid != 0) {
                                    if (Integer.parseInt(loginId) == historyappid) {
                                        finalList.put(dataOfEmp);
                                    }
                                }
                                if (aprroverid == null || aprroverid == "") {
                                    if ((DateUtils.isSameDay(Date14, tDate) || tDate.after(Date14)) && tDate.before(Date21)) {
                                        finalList.put(dataOfEmp);
                                    }
                                } else if (status != 1) {
                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                        finalList.put(dataOfEmp);
                                    } else if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                        boolean checklastapprovedateflag = managercheck(tabId, manager1, 7, 7);
                                        if (tDate.before(Date21) && checklastapprovedateflag == true) {
                                            finalList.put(dataOfEmp);
                                        }
                                    }
                                }
                            }
                        }
                        if (!manager4.isEmpty() && !manager3.isEmpty() && !manager2.isEmpty() && !manager1.isEmpty()) {
                            if (Integer.parseInt(manager4) == Integer.parseInt(loginId)) {
                                if (historyappid != 0) {
                                    if (Integer.parseInt(loginId) == historyappid) {
                                        finalList.put(dataOfEmp);
                                    }
                                }
                                if (aprroverid == null || aprroverid == "") {
                                    if ((DateUtils.isSameDay(Date21, tDate) || tDate.after(Date21)) && tDate.before(Date28)) {
                                        finalList.put(dataOfEmp);
                                    }
                                } else if (status != 1) {
                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager3)) {
                                        finalList.put(dataOfEmp);
                                    } else if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                        boolean checklastapprovedateflag = managercheck(tabId, manager2, 7, 7);
                                        if (tDate.before(Date28) && checklastapprovedateflag == true) {
                                            finalList.put(dataOfEmp);
                                        }
                                    } else if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                        boolean checklastapprovedateflag1 = managercheck(tabId, manager1, 14, 7);
                                        if (tDate.before(Date28) && checklastapprovedateflag1 == true) {
                                            finalList.put(dataOfEmp);
                                        }
                                    }
                                }
                            }
                        }
                        if (!manager5.isEmpty()) {
                            if (Integer.parseInt(manager5) == Integer.parseInt(loginId)) {
                                if (historyappid != 0 || status == 8) {
                                    if (Integer.parseInt(loginId) == historyappid) {
                                        finalList.put(dataOfEmp);
                                    }
                                }
                                if (aprroverid == null || aprroverid == "") {
                                    if ((DateUtils.isSameDay(Date28, tDate) || tDate.after(Date28)) && tDate.before(Date35)) {
                                        finalList.put(dataOfEmp);
                                    }
                                } else if (!manager4.isEmpty()) {
                                    if (status != 1) {
                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager4)) {
                                            finalList.put(dataOfEmp);
                                        }
                                    }
                                    if (!manager3.isEmpty()) {
                                        if (status != 1) {
                                            if (Integer.parseInt(aprroverid) == Integer.parseInt(manager3)) {
                                                boolean checklastapprovedateflag = managercheck(tabId, manager3, 7, 7);
                                                if (tDate.before(Date21) && checklastapprovedateflag == true) {
                                                    finalList.put(dataOfEmp);
                                                }
                                            } else if (!manager2.isEmpty()) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager2, 14, 7);
                                                    if (checklastapprovedateflag == true) {
                                                        finalList.put(dataOfEmp);
                                                    }
                                                }
                                            } else if (!manager1.isEmpty()) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager1, 21, 7);
                                                    if (checklastapprovedateflag == true) {
                                                        finalList.put(dataOfEmp);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (manager4 == null || manager4 == "") {
                                    if (!manager3.isEmpty()) {
                                        if (status != 1) {
                                            if (Integer.parseInt(aprroverid) == Integer.parseInt(manager3)) {
                                                boolean checklastapprovedateflag = managercheck(tabId, manager3, 0, 7);
                                                if (tDate.before(Date21) && checklastapprovedateflag == true) {
                                                    finalList.put(dataOfEmp);
                                                }
                                            } else if (!manager2.isEmpty()) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager2, 7, 7);
                                                    if (checklastapprovedateflag == true) {
                                                        finalList.put(dataOfEmp);
                                                    }
                                                }
                                            } else if (!manager1.isEmpty()) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager1, 14, 7);
                                                    if (checklastapprovedateflag == true) {
                                                        finalList.put(dataOfEmp);
                                                    }
                                                }
                                            }
                                        }
                                    } else if (manager3 == null || manager3 == "") {
                                        if (!manager2.isEmpty()) {
                                            if (status != 1) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager2, 0, 7);
                                                    if (checklastapprovedateflag == true) {
                                                        finalList.put(dataOfEmp);
                                                    }
                                                } else if (!manager1.isEmpty()) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                        boolean checklastapprovedateflag = managercheck(tabId, manager1, 7, 7);
                                                        if (checklastapprovedateflag == true) {
                                                            finalList.put(dataOfEmp);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (manager2 == null || manager2 == "") {
                                            if (!manager1.isEmpty()) {
                                                if (status != 1) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                            boolean checklastapprovedateflag = managercheck(tabId, manager1, 0, 7);
                                                            finalList.put(dataOfEmp);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (status == 6 || status == 5) {

                        if (Integer.parseInt(loginId) == Integer.parseInt(manager1)) {
                            finalList.put(dataOfEmp);
                        } else if (!manager2.isEmpty()) {
                            if (Integer.parseInt(loginId) == Integer.parseInt(manager2)) {
                                finalList.put(dataOfEmp);
                            }
                        } else if (!manager3.isEmpty()) {
                            if (Integer.parseInt(loginId) == Integer.parseInt(manager3)) {
                                finalList.put(dataOfEmp);
                            }
                        } else if (!manager4.isEmpty()) {
                            if (Integer.parseInt(loginId) == Integer.parseInt(manager4)) {
                                finalList.put(dataOfEmp);
                            }
                        } else if (!manager5.isEmpty()) {
                            if (Integer.parseInt(loginId) == Integer.parseInt(manager5)) {
                                finalList.put(dataOfEmp);
                            }
                        }
                    }
                }
                if (null != finalList && finalList.length() != 0) {

                    for (int i = 0; i < finalList.length(); i++) {
                        JSONObject object = finalList.getJSONObject(i);

                        int employeeId = (int) object.get("empMasterId");
                        int tabId = (int) object.get("travelId");
                        int status = (int) object.get("status");

                        if (status == 3) {
                            List approverList = travelApproverHistoryService.readapproverlist(tabId, loginId);
                            for (Object o : approverList) {
                                TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                                travelApproverHistory = (TravelApproverHistory) o;
                                int prevStatus = travelApproverHistory.getTravelApproveStatus();
                                int prevflag = travelApproverHistory.getReturnFlag();
                                int tbId = travelApproverHistory.getTravelRequestMaster().getId();
//                          in both take list[10] as approverid list[11] appname
                                if (prevflag == 0) {
                                    List<?> newfinallist = travelRequestMasterService.readlastapprove(tbId, loginId);

                                    Object[] Obj = (Object[]) newfinallist.get(0);
                                    String statusMessage = "";
                                    String ApproveName;
                                    if (null == Obj[11]) {
                                        ApproveName = "";
                                    } else {
                                        ApproveName = Obj[11].toString();
                                    }
                                    if (Obj[8].equals(0)) {
                                        statusMessage = "Pending";
                                    }
                                    if (Obj[8].equals(1)) {
                                        statusMessage = "Reworked By " + ApproveName;
                                    }
                                    if (Obj[8].equals(2)) {
                                        statusMessage = "Rejected By " + ApproveName;
                                    }
                                    if (Obj[8].equals(3)) {
                                        if (Obj[13].equals(0)) {
                                            Obj[8] = 11;
                                            statusMessage = "Approved By " + ApproveName;
                                        } else {

                                            statusMessage = "Pending";
                                        }
                                    }
                                    if (Obj[8].equals(4)) {
                                        statusMessage = "WithDraw";
                                    }
                                    if (Obj[8].equals(5)) {
                                        statusMessage = "Final Approved By " + ApproveName;
                                    }
                                    if (Obj[8].equals(6)) {
                                        statusMessage = "Approved By " + ApproveName;
                                    }
                                    if (Obj[8].equals(8)) {
                                        statusMessage = "Approved By " + ApproveName;
                                    }
                                    if (Obj[8].equals(10)) {
                                        statusMessage = "Return Request Pending";
                                    }

                                    flag = true;

                                    JSONObject jsono = new JSONObject();
                                    jsono.put("employeeId", Obj[2]);
                                    jsono.put("employeeName", Obj[3]);
                                    jsono.put("travelType", Obj[4]);
                                    jsono.put("travelRequestNo", Obj[5]);
                                    jsono.put("startDate", Obj[6]);
                                    jsono.put("endDate", Obj[7]);
                                    jsono.put("status", Obj[8]);
                                    jsono.put("statusMessage", statusMessage);
                                    jsono.put("empMasterId", Obj[0]);
                                    jsono.put("travelId", Obj[1]);

                                    finalList1.put(jsono);
                                    break;
                                }
                            }
                            if (approverList.size() == 0) {
//                                    List<Object> l1 = new ArrayList<>();
//                                    l1.add(obj);
                                finalList1.put(object);
                            }
                        } else {
//                                    List<Object> l1 = new ArrayList<>();
//                                    l1.add(obj);
                            finalList1.put(object);
                        }
                    }
                    message = "Success";
                    rcode = "1";
                    userData.put("data", finalList1);
                } else {
                    message = "No Record Found";
                    rcode = "2";
                }

            } else {
                message = "No Record Found";
                rcode = "2";
            }

            userData.put("responseMessage", message);

            userData.put("responseCode", rcode);
            out.print(userData);
        } catch (Exception e) {

        }

    }

    public void TravelRequestview(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        EmployeeMaster em = new EmployeeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            String userId = request.getParameter("id");
            UserMaster user = new UserMaster();

            user.setId(Integer.parseInt(userId));
            JSONObject Data = doPost(request);
            String travelId = Data.get("travelId").toString();
            String empMasterId = Data.get("empMasterId").toString();

            em = employeeMasterService.readById(Integer.parseInt(empMasterId));
            List<?> Listemp = employeeMasterService.readEmployeeDetailUserIdWise(em);
            if (!Listemp.isEmpty()) {

                Object[] objects = (Object[]) Listemp.get(0);

                String empId = "";
                String empName = "";
                String Designation = "";
                String Level = "";
                String Departmenet = "";
                String Location = "";
                String ContacNo = "";
                String ReportingMagager = "";

                JSONArray EmployeeDetail = new JSONArray();
                JSONObject Detail = new JSONObject();
                for (int i = 0; i < Listemp.size(); i++) {
                    Object[] o = (Object[]) Listemp.get(i);
                    empId = (String) o[0];
                    empName = (String) o[1];
                    Designation = (String) o[2];
                    Level = (String) o[3];
                    Departmenet = (String) o[4];
                    Location = (String) o[5];
                    ContacNo = (String) o[8];
                    String ReportingMagager1 = (String) o[6];
                    EmployeeMaster em1 = employeeMasterService.readById(Integer.parseInt(ReportingMagager1));
                    Detail.put("empId", empId);
                    Detail.put("empName", empName);
                    Detail.put("Departmenet", Departmenet);
                    Detail.put("Designation", Designation);
                    Detail.put("Level", Level);
                    Detail.put("Location", Location);
                    Detail.put("ContacNo", ContacNo);
                    Detail.put("ReportingMagager", em1.getEmployeeName());
                    EmployeeDetail.put(Detail);
                    rcode = "1";
                    message = "Success";

                }

                data.put("EmployeeDetail", EmployeeDetail);

            }

            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelId));
            if (null == travelRequestMaster) {
                rcode = "0";
                message = "TravelRequestId not found";
            } else {
                int employeeId = travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
                employeeMaster = employeeMasterService.readById(employeeId);
                data.put("travelRequestApplicationNo", travelRequestMaster.getTravelRequestNo());
                data.put("travelType", travelRequestMaster.getTravelType());
                if (!travelRequestMaster.getTravelType().contains("Local")) {
                    data.put("startDateTime", travelRequestMaster.getStartDateTime());
                    data.put("endDateTime", travelRequestMaster.getEndDateTime());
                }
                rcode = "1";
                message = "Success";
                data.put("dateOfSubmit", travelRequestMaster.getDateOfSubmit());
                data.put("advancedRequired", travelRequestMaster.getCashRequired());
                if (travelRequestMaster.getCashRequired().contains("Yes")) {

                    data.put("amount", travelRequestMaster.getAmount());
                    data.put("reasonOfAdvanced", travelRequestMaster.getReasonForAdvance());
                }
                data.put("reasonForTravel", travelRequestMaster.getPurpose());
                data.put("managerRemark", travelRequestMaster.getManagerRemark());
                CurrencyMaster currencyMaster = new CurrencyMaster();
                if (travelRequestMaster.getTravelType().toString().contains("International")
                        && travelRequestMaster.getCashRequired().contains("Yes")) {
                    if (null != travelRequestMaster.getCurrency() && !travelRequestMaster.getCurrency().equals("")) {
                        String currencyId = travelRequestMaster.getCurrency();
                        currencyMaster = currencyMasterService.readById(Integer.parseInt(currencyId));
                        String currency = currencyMaster.getCurrencyName();
                        String currencyCode = currencyMaster.getCurrencyCode();
                        String currencyName = currency + "(" + currencyCode + ")";
                        data.put("currencyId", currencyId);
                        data.put("currencyName", currencyName);
                    }
                }
                TravelDetail travelDetail = new TravelDetail();
                travelDetail.setTravelRequestMaster(travelRequestMaster);
                List<?> travelDetail1 = travelDetailService.readTravelDetail(travelDetail);
                if (!travelDetail1.isEmpty()) {
                    JSONArray travelDetails = new JSONArray();
                    for (Object o : travelDetail1) {
                        JSONObject travel = new JSONObject();
                        TravelDetail travelDetail2 = (TravelDetail) o;
                        travel.put("travelDetailId", travelDetail2.getId().toString());
                        travel.put("date", travelDetail2.getDate());
                        travel.put("fromLocation", travelDetail2.getFromLocation());
                        travel.put("toLocation", travelDetail2.getToLocation());
                        travel.put("modeOfTravel", travelDetail2.getModeOfTravel());
                        travel.put("policyDeviation", travelDetail2.getPolicyDeviation());
                        travel.put("remarks", travelDetail2.getComments());
                        travelDetails.put(travel);
                        rcode = "1";
                        message = "Success";
                    }
                    data.put("travelDetails", travelDetails);
                }
                HotelAccommodation hotelAccommodation = new HotelAccommodation();
                hotelAccommodation.setTravelRequestMaster(travelRequestMaster);
                List<?> hotel1 = hotelAccommodationService.readAccommodationDetail(hotelAccommodation);
                if (!hotel1.isEmpty()) {
                    JSONArray hotelDetails = new JSONArray();
                    for (Object hotels : hotel1) {
                        JSONObject hotel = new JSONObject();
                        HotelAccommodation hotelAccommodation1 = (HotelAccommodation) hotels;
                        hotel.put("hotelDetailId", hotelAccommodation1.getId());
                        hotel.put("hotelBookingRequired", hotelAccommodation1.getHotelBookingRequired());
                        hotel.put("location", hotelAccommodation1.getLocation());
                        hotel.put("preferredHotels", hotelAccommodation1.getPreferredHotel());
                        hotel.put("checkInDate", hotelAccommodation1.getCheckInDate());
                        hotel.put("checkOutDate", hotelAccommodation1.getCheckOutDate());
                        hotel.put("remarks", hotelAccommodation1.getComments());
                        hotelDetails.put(hotel);
                        rcode = "1";
                        message = "Success";
                    }
                    data.put("hotelDetails", hotelDetails);
                }
            }
            userData.put("data", data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } catch (Exception e) {

        }

    }

    public void TravelRequestManagerSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();

        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        String userId = request.getParameter("id");
        UserMaster user = new UserMaster();
        user.setId(Integer.parseInt(userId));
        EmployeeMaster empManager = new EmployeeMaster();
        EmployeeMaster empManager1 = new EmployeeMaster();
        empManager.setUserMaster(user);

        List<EmployeeMaster> empDetailList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(empManager);
        if (!empDetailList.isEmpty()) {
            empManager1 = (EmployeeMaster) empDetailList.get(0);
        }
        try {
            JSONObject Data = doPost(request);
            String travelId = Data.getString("travelId");
            String empMasterId = Data.getString("empMasterId");
            String managerRemark = Data.getString("managerRemark");

            String btnSubmit = Data.getString("btnSubmit");

            travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelId));
            HttpSession session = request.getSession();
            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empMasterId));
            String loginId = employeeMaster.getId().toString();
            LevelMaster levelMaster = new LevelMaster();
            levelMaster = levelMasterService.readById(employeeMaster.getLevelMaster().getId());

            DesignationMaster designationMaster1 = new DesignationMaster();
            designationMaster1 = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());

            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            int employeeId = travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            employeeMaster1 = employeeMasterService.readById(employeeId);
            String manager5 = employeeMaster1.getReportingManagerLevel5();
            String manager6 = employeeMaster1.getReportingManagerLevel6();
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            if (btnSubmit.equals("approve")) {
                if (travelRequestMaster.getStatus() == 0 || travelRequestMaster.getStatus() == 3 || travelRequestMaster.getStatus() == 10) {
                    travelRequestMaster.setManagerRemark(managerRemark);
//                if (Integer.parseInt(loginId) == Integer.parseInt(manager6)) {
//                    travelRequestMaster.setStatus(5);
//                } elsetry
                    try {

//                    if (Integer.parseInt(loginId) == Integer.parseInt(manager5)) {
                        if (levelMaster.getLevel().equals("3A") || levelMaster.getLevel().equals("3B") || levelMaster.getLevel().equals("2D")
                                || levelMaster.getLevel().equals("2C") || levelMaster.getLevel().equals("2E") || levelMaster.getLevel().equals("2B") || levelMaster.getLevel().equals("2A")
                                || (levelMaster.getLevel().equals("0") && (designationMaster1.getDesignationName().equals("Proprietor") || designationMaster1.getDesignationName().equals("Project Cordinator")))) {
                            if (travelRequestMaster.getTravelType().equals("Domestic") || travelRequestMaster.getTravelType().equals("Local")) {
                                travelRequestMaster.setEmployeeMasterByApprover1Id(empManager1);
                                travelRequestMaster.setStatus(5);

                                // add c-off balance in employee leave balance when day is sunday
                                String startDate = travelRequestMaster.getStartDateTime();
                                String endDate = travelRequestMaster.getEndDateTime();
                                Date startDate1 = sdf1.parse(startDate);
                                Date endDate1 = sdf1.parse(endDate);
                                long diff = endDate1.getTime() - startDate1.getTime();
                                int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                for (int i = 0; i <= days + 1; i++) {
                                    String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
                                    if (dayOfWeek.equals("Sunday")) {
                                        String time = "0.8";

                                        OverTimeMaster overTimeMaster = new OverTimeMaster();
                                        String overTimeDate = sdf1.format(startDate1);
                                        overTimeMaster.setDate(overTimeDate);
                                        overTimeMaster.setTime(time);
                                        overTimeMaster.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());

                                        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                                        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                                        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                                        leaveTypeMaster.setId(11);
                                        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                        employeeLeaveBalance.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());
                                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                                        employeeMaster2 = employeeMasterService.readById(travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId());
                                        int levelId = employeeMaster.getLevelMaster().getId();
                                        LevelMaster levelMaster1 = new LevelMaster();
                                        levelMaster1 = levelMasterService.readById(levelId);
                                        if (levelMaster.getLevel().contains("4") || levelMaster.getLevel().contains("5")) {
                                            List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (!empBalList.isEmpty()) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                                                float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                time1 = time1 + Float.parseFloat(time);
                                                employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                            } else {
                                                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                                                employeeLeaveBalance1.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());
                                                employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
                                                employeeLeaveBalanceService.create(employeeLeaveBalance1);
                                            }
                                            overTimeMasterService.create(overTimeMaster);
                                        }

                                    }
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(startDate1);
                                    c.add(Calendar.DATE, 1);
                                    startDate1 = c.getTime();
                                }
                                // add c-off balance in employee leave balance when day is sunday

                            } else {
                                travelRequestMaster.setEmployeeMasterByApprover1Id(empManager1);
                                travelRequestMaster.setStatus(6);
                            }
                        } else if (Integer.parseInt(loginId) == Integer.parseInt(manager6)) {
                            if (travelRequestMaster.getTravelType().equals("Domestic") || travelRequestMaster.getTravelType().equals("Local")) {

                                travelRequestMaster.setEmployeeMasterByApprover1Id(empManager1);
                                travelRequestMaster.setStatus(5);
                                // add c-off balance in employee leave balance when day is sunday
                                String startDate = travelRequestMaster.getStartDateTime();
                                String endDate = travelRequestMaster.getEndDateTime();
                                Date startDate1 = sdf1.parse(startDate);
                                Date endDate1 = sdf1.parse(endDate);
                                long diff = endDate1.getTime() - startDate1.getTime();
                                int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                for (int i = 0; i <= days + 1; i++) {
                                    String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
                                    if (dayOfWeek.equals("Sunday")) {
                                        String time = "0.8";

                                        OverTimeMaster overTimeMaster = new OverTimeMaster();
                                        String overTimeDate = sdf1.format(startDate1);
                                        overTimeMaster.setDate(overTimeDate);
                                        overTimeMaster.setTime(time);
                                        overTimeMaster.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());

                                        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                                        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                                        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                                        leaveTypeMaster.setId(11);
                                        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                        employeeLeaveBalance.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());
                                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                                        employeeMaster2 = employeeMasterService.readById(travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId());
                                        int levelId = employeeMaster.getLevelMaster().getId();
                                        LevelMaster levelMaster1 = new LevelMaster();
                                        levelMaster1 = levelMasterService.readById(levelId);
                                        if (levelMaster.getLevel().contains("4") || levelMaster.getLevel().contains("5")) {
                                            List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (!empBalList.isEmpty()) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                                                float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                time1 = time1 + Float.parseFloat(time);
                                                employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                            } else {
                                                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                                                employeeLeaveBalance1.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());
                                                employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
                                                employeeLeaveBalanceService.create(employeeLeaveBalance1);
                                            }
                                            overTimeMasterService.create(overTimeMaster);
                                        }

                                    }
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(startDate1);
                                    c.add(Calendar.DATE, 1);
                                    startDate1 = c.getTime();
                                }
                                // add c-off balance in employee leave balance when day is sunday

                            } else {
                                travelRequestMaster.setEmployeeMasterByApprover2Id(employeeMaster);
                                travelRequestMaster.setStatus(5);
                                // add c-off balance in employee leave balance when day is sunday
                                String startDate = travelRequestMaster.getStartDateTime();
                                String endDate = travelRequestMaster.getEndDateTime();
                                Date startDate1 = sdf1.parse(startDate);
                                Date endDate1 = sdf1.parse(endDate);
                                long diff = endDate1.getTime() - startDate1.getTime();
                                int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                for (int i = 0; i <= days + 1; i++) {
                                    String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
                                    if (dayOfWeek.equals("Sunday")) {
                                        String time = "0.8";

                                        OverTimeMaster overTimeMaster = new OverTimeMaster();
                                        String overTimeDate = sdf1.format(startDate1);
                                        overTimeMaster.setDate(overTimeDate);
                                        overTimeMaster.setTime(time);
                                        overTimeMaster.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());

                                        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                                        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                                        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                                        leaveTypeMaster.setId(11);
                                        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                        employeeLeaveBalance.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());
                                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                                        employeeMaster2 = employeeMasterService.readById(travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId());
                                        int levelId = employeeMaster.getLevelMaster().getId();
                                        LevelMaster levelMaster1 = new LevelMaster();
                                        levelMaster1 = levelMasterService.readById(levelId);
                                        if (levelMaster.getLevel().contains("4") || levelMaster.getLevel().contains("5")) {
                                            List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (!empBalList.isEmpty()) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                                                float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                time1 = time1 + Float.parseFloat(time);
                                                employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                            } else {
                                                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                                                employeeLeaveBalance1.setEmployeeMaster(travelRequestMaster.getEmployeeMasterByEmployeeMasterId());
                                                employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
                                                employeeLeaveBalanceService.create(employeeLeaveBalance1);
                                            }
                                            overTimeMasterService.create(overTimeMaster);
                                        }

                                    }
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(startDate1);
                                    c.add(Calendar.DATE, 1);
                                    startDate1 = c.getTime();
                                }
                                // add c-off balance in employee leave balance when day is sunday

                            }

                        } else {
                            travelRequestMaster.setEmployeeMasterByApprover1Id(empManager1);
                            travelRequestMaster.setStatus(3);
                        }
                    } catch (Exception e) {

                    }
                    travelRequestMasterService.update(travelRequestMaster);
                    TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                    travelApproverHistory.setTravelRequestMaster(travelRequestMaster);
                    travelApproverHistory.setEmployeeMasterByEmployeeMasterId(employeeMaster);
                    travelApproverHistory.setEmployeeMasterByTravelApproverId(empManager1);
                    travelApproverHistory.setTravelApproveStatus(travelRequestMaster.getStatus());
                    travelApproverHistory.setTravelApproverRemark(managerRemark);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String requestdate = sdf.format(new Date());
                    travelApproverHistory.setTravelApproveHistoryDate(requestdate);
                    travelApproverHistory.setReturnFlag(0);
                    travelApproverHistoryService.create(travelApproverHistory);

                    if (travelRequestMaster.getStatus() != 5) {

//                    Travel Request Approve
                    }

                    if (travelRequestMaster.getStatus() == 5) {
                        //            Send To TravelAdmin

                    }

                }
                rcode = "1";
                message = "Success";

            } else if (btnSubmit.equals("reject")) {
                travelRequestMaster.setStatus(2);
                travelRequestMaster.setManagerRemark(managerRemark);
                travelRequestMaster.setEmployeeMasterByApprover1Id(empManager1);
                travelRequestMasterService.update(travelRequestMaster);
                TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                travelApproverHistory.setTravelRequestMaster(travelRequestMaster);
                travelApproverHistory.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                travelApproverHistory.setEmployeeMasterByTravelApproverId(empManager1);
                travelApproverHistory.setTravelApproveStatus(travelRequestMaster.getStatus());
                travelApproverHistory.setTravelApproverRemark(managerRemark);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String requestdate = sdf.format(new Date());
                travelApproverHistory.setTravelApproveHistoryDate(requestdate);
                travelApproverHistory.setReturnFlag(0);
                travelApproverHistoryService.create(travelApproverHistory);
                rcode = "1";
                message = "Success";

            } else if (btnSubmit.equals("rework")) {
                travelRequestMaster.setStatus(1);
                travelRequestMaster.setManagerRemark(managerRemark);
                travelRequestMaster.setEmployeeMasterByApprover1Id(empManager1);
                travelRequestMasterService.update(travelRequestMaster);
                TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                travelApproverHistory.setTravelRequestMaster(travelRequestMaster);
                travelApproverHistory.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                travelApproverHistory.setEmployeeMasterByTravelApproverId(empManager1);
                travelApproverHistory.setTravelApproveStatus(travelRequestMaster.getStatus());
                travelApproverHistory.setTravelApproverRemark(managerRemark);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String requestdate = sdf.format(new Date());
                travelApproverHistory.setTravelApproveHistoryDate(requestdate);
                travelApproverHistory.setReturnFlag(0);
                travelApproverHistoryService.create(travelApproverHistory);
                rcode = "1";
                message = "Success";
            }

        } catch (Exception e) {
            rcode = "1";
            message = "Something went wrong";
            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }
}
