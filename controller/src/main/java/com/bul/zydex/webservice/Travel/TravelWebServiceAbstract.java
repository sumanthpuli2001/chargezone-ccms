/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice.Travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.HotelAccommodation;
import com.bul.zydex.model.PolicyDeviationForAir;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.model.TravelDetail;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.CurrencyMasterService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.travel.HotelAccommodationService;
import com.bul.zydex.service.travel.PolicyDeviationForAirService;
import com.bul.zydex.service.travel.TravelApproverHistoryService;
import com.bul.zydex.service.travel.TravelDetailService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jay
 */
public abstract class TravelWebServiceAbstract extends CustomAbstract {

    protected TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService;
    protected PolicyDeviationForAirService<PolicyDeviationForAir> policyDeviationForAirService;
    protected TravelDetailService<TravelDetail> travelDetailService;
    protected HotelAccommodationService<HotelAccommodation> hotelAccommodationService;
    protected CurrencyMasterService<CurrencyMaster> currencyMasterService;
    protected TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService;

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
    }

    public PolicyDeviationForAirService<PolicyDeviationForAir> getPolicyDeviationForAirService() {
        return policyDeviationForAirService;
    }

    public void setPolicyDeviationForAirService(PolicyDeviationForAirService<PolicyDeviationForAir> policyDeviationForAirService) {
        this.policyDeviationForAirService = policyDeviationForAirService;
    }

    public TravelDetailService<TravelDetail> getTravelDetailService() {
        return travelDetailService;
    }

    public void setTravelDetailService(TravelDetailService<TravelDetail> travelDetailService) {
        this.travelDetailService = travelDetailService;
    }

    public HotelAccommodationService<HotelAccommodation> getHotelAccommodationService() {
        return hotelAccommodationService;
    }

    public void setHotelAccommodationService(HotelAccommodationService<HotelAccommodation> hotelAccommodationService) {
        this.hotelAccommodationService = hotelAccommodationService;
    }

    public CurrencyMasterService<CurrencyMaster> getCurrencyMasterService() {
        return currencyMasterService;
    }

    public void setCurrencyMasterService(CurrencyMasterService<CurrencyMaster> currencyMasterService) {
        this.currencyMasterService = currencyMasterService;
    }

    public TravelApproverHistoryService<TravelApproverHistory> getTravelApproverHistoryService() {
        return travelApproverHistoryService;
    }

    public void setTravelApproverHistoryService(TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService) {
        this.travelApproverHistoryService = travelApproverHistoryService;
    }

    public JSONObject doPost(HttpServletRequest request)
            throws ServletException, IOException, JSONException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            /*report an error*/ }
        JSONObject jsonObject = new JSONObject(jb.toString());

//        try {
//            JSONObject jsonObject = new JSONObject(jb.toString());
//        } catch (Exception e) {
//            throw new IOException("Error parsing JSON request string");
//        }
        return jsonObject;

    }
}
