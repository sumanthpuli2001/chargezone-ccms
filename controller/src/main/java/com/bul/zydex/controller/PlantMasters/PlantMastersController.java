/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PlantMasters;

import com.bul.zydex.model.PlantMasters;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sumanth
 */
public class PlantMastersController extends PlantMastersAbstract {

    public ModelAndView showlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("plantMasters/showlist");
        return mv;
    }

    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        
        List list10 = companyMasterService.read();
        List list11 = purchasingOrganisationService.read();
        request.setAttribute("list11", list11);
        request.setAttribute("list10", list10);

        mv.setViewName("plantMasters/create");
        return mv;
    }

    public ModelAndView createsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        PlantMasters plantMasters = new PlantMasters();

        String comapnycode = request.getParameter("companycode");
        String purchasing = request.getParameter("purchasing");
        String plantcode = request.getParameter("plantcode");
        String plantname = request.getParameter("plantname");
        String address = request.getParameter("address");
        String gst = request.getParameter("gst");
        String postalcode = request.getParameter("postalcode");
        String country = request.getParameter("country");
        String region = request.getParameter("region");
        String language = request.getParameter("language");

        plantMasters.setCompanyCode(comapnycode);
        plantMasters.setPurchasingOrganisation(purchasing);
        plantMasters.setPlantCode(plantcode);
        plantMasters.setPlantName(plantname);
        plantMasters.setAddress(address);
        plantMasters.setGst(gst);
        plantMasters.setPostalCode(postalcode);
        plantMasters.setCountry(country);
        plantMasters.setRegion(region);
        plantMasters.setLanguage(language);

        if (plantMastersService.isExist(plantMasters)) {
            plantMastersService.create(plantMasters);
            session.setAttribute("successMessage", "Plant Created successfully.");
            mv.setViewName("redirect:plantMasters.htm?act=showlist");
        } else {

            session.setAttribute("failureMessage", "Plant Detail Already Exist. Please enter new Plant Details");
            mv.setViewName("redirect:plantMasters.htm?act=create");
        }

        return mv;
    }

    public ModelAndView plantedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        PlantMasters plantMasters = plantMastersService.readById(Integer.parseInt(id));

        String companymaster = plantMasters.getCompanyCode();

        String purchase = plantMasters.getPurchasingOrganisation();

        List list10 = companyMasterService.read();
        List list11 = purchasingOrganisationService.read();

        request.setAttribute("list11", list11);
        request.setAttribute("list10", list10);
        request.setAttribute("companymaster", companymaster);
        request.setAttribute("purchase", purchase);
        mv.getModelMap().put("plantMasters", plantMasters);

        mv.setViewName("plantMasters/edit");
        return mv;
    }

    public ModelAndView plantseditssubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");

        String comapnycode = request.getParameter("comapnycode");
        String purchasing = request.getParameter("purchasing");
        String plantcode = request.getParameter("plantcode");
        String plantname = request.getParameter("plantname");
        String address = request.getParameter("address");
        String gst = request.getParameter("gst");
        String postalcode = request.getParameter("postalcode");
        String country = request.getParameter("country");
        String region = request.getParameter("region");
        String language = request.getParameter("language");
        PlantMasters plantMasters = plantMastersService.readById(Integer.parseInt(id));
        plantMasters.setCompanyCode(comapnycode);
        plantMasters.setPurchasingOrganisation(purchasing);
        plantMasters.setPlantCode(plantcode);
        plantMasters.setPlantName(plantname);
        plantMasters.setAddress(address);
        plantMasters.setGst(gst);
        plantMasters.setPostalCode(postalcode);
        plantMasters.setCountry(country);
        plantMasters.setRegion(region);
        plantMasters.setLanguage(language);
        plantMastersService.update(plantMasters);

        session.setAttribute("successMessage", "Information: Plant Updated successfully");
        mv.setViewName("redirect:plantMasters.htm?act=showlist");
        return mv;
    }

    public ModelAndView plantdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            plantMastersService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage", "Information: One or more data deleted successfully");
        mv.setViewName("forward:plantMasters.htm?act=showlist");
        return mv;
    }

    public ModelAndView deletePlantMastersById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            plantMastersService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }
        mv.setViewName("forward:plantMasters.htm?act=showlist");
        return mv;
    }

    public ModelAndView plantMastersAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "companyCode";
                    break;
                case "3":
                    orderColumn = "plantCode";
                    break;
                case "4":
                    orderColumn = "plantName";
                    break;
                case "5":
                    orderColumn = "address";
                    break;
                case "6":
                    orderColumn = "gst";
                    break;
                case "7":
                    orderColumn = "purchasingOrganisation";
                    break;
                case "8":
                    orderColumn = "postalCode";
                    break;
                case "9":
                    orderColumn = "country";
                    break;
                case "10":
                    orderColumn = "region";
                    break;
                case "11":
                    orderColumn = "language";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = plantMastersService.getPlantMastersPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = plantMastersService.getTotalPlantMastersCount();
        int filteredRecords = plantMastersService.getFilteredPlantMastersCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            PlantMasters plantMasters = (PlantMasters) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + plantMasters.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("companyCode", plantMasters.getCompanyCode());
            json.put("plantCode", plantMasters.getPlantCode());
            json.put("plantName", plantMasters.getPlantName());
            json.put("address", plantMasters.getAddress());
            json.put("gst", plantMasters.getGst());
            json.put("purchasingOrganisation", plantMasters.getPurchasingOrganisation());
            json.put("postalCode", plantMasters.getPostalCode());
            json.put("country", plantMasters.getCountry());
            json.put("region", plantMasters.getRegion());
            json.put("language", plantMasters.getLanguage());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='plantMasters.htm?act=plantedit&id="
                    + plantMasters.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + plantMasters.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );
            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

}
