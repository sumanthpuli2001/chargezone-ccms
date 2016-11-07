/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice.Travel;

import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HotelAccommodation;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.model.TravelDetail;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            if (travelRequestMaster.getTravelType().toString().contains("International")) {
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
                        travelDetail.setId(Integer.parseInt(travelDetailID));
                        travelDetailService.update(travelDetail);
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
                        hotelAccommodation.setId(Integer.parseInt(hotelDetailObj.getString("hotelDetailId")));
                        hotelAccommodationService.update(hotelAccommodation);
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
}
