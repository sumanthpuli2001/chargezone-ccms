package com.bul.zydex.controller.OapForm;

import com.bul.zydex.model.Deliverable;
import com.bul.zydex.model.SiteSurvey;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public class FormsCommonController extends FormsCommonAbstract {

    public ModelAndView sitesurveyPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "surveyDocumentNo";
                    break;
                case "3":
                    orderColumn = "siteName";
                    break;
                case "4":
                    orderColumn = "siteAddress";
                    break;
                case "5":
                    orderColumn = "description";
                    break;
                case "6":
                    orderColumn = "startDate";
                    break;
                case "7":
                    orderColumn = "endDate";
                    break;
                case "8":
                    orderColumn = "createdBy";
                    break;
                case "9":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = siteSurveyService.getSitesurveyPagination(start, length, searchValue, username, orderColumn, orderDir);

        int totalRecords = siteSurveyService.getTotalSitesurveyCount(username);

        int filteredRecords = siteSurveyService.getFilteredSitesurveyCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }
        for (Object obj : list) {

            SiteSurvey siteSurvey = (SiteSurvey) obj;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("surveyDocumentNo", siteSurvey.getSurveyDocumentNo() != null ? siteSurvey.getSurveyDocumentNo() : "");
            json.put("siteName", siteSurvey.getSiteName() != null ? siteSurvey.getSiteName() : "");
            json.put("siteAddress", siteSurvey.getSiteAddress() != null ? siteSurvey.getSiteAddress() : "");
            json.put("description", siteSurvey.getDescription() != null ? siteSurvey.getDescription() : "");
            json.put("startDate", siteSurvey.getStartDate() != null ? siteSurvey.getStartDate() : "");
            json.put("endDate", siteSurvey.getEndDate() != null ? siteSurvey.getEndDate() : "");
            json.put("createdBy", siteSurvey.getCreatedBy() != null ? siteSurvey.getCreatedBy() : "");
            json.put("flagStatus", siteSurvey.getFlagStatus() == 100 ? "Site Survey Closed" : "Site Survey Created");

            String actionButtons = "";

            if (siteSurvey.getFlagStatus() == 100) {
                actionButtons = "<a href='oapForm.htm?act=siteSurveyViewClose&id="
                        + siteSurvey.getId()
                        + "' class='btn theme-btn light-btn mx-1'>"
                        + "View"
                        + "</a>";
            } else {

                actionButtons = "<a href='oapForm.htm?act=Sitesurveyedit&id="
                        + siteSurvey.getId()
                        + "' class='d-block text-info p-1 mx-1'>"
                        + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                        + "style='width:18px;height:18px;'>"
                        + "</a>"
                        + "<a href='javascript:void(0);' "
                        + "onclick=\"loadClosesite('" + siteSurvey.getId() + "')\" "
                        + "class='btn theme-btn light-btn mx-1' "
                        + "data-toggle='modal' "
                        + "data-target='#closeSiteSurvey'>"
                        + "Close Site"
                        + "</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons
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

    public ModelAndView oapFormListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";
        if (orderColumnIndex != null) {

            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "pcsName";
                    break;
                case "4":
                    orderColumn = "projectName";
                    break;
                case "5":
                    orderColumn = "department";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getOapCretedUserPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalOapCretedUserCount(username);
        int filteredRecords = oapFormService.getFilteredOapCretedUserCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }
        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel;
            if (flagStatus == 0) {
                statusLabel = "Save As Draft";
            } else if (flagStatus == 1) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            } else if (flagStatus == 5) {
                statusLabel = "Rejected CRC";
            } else if (flagStatus == 14) {
                statusLabel = " Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            if (flagStatus == 3) {
                actionButtons += "<a href='oapForm.htm?act=rejectview&id=" + id
                        + "&oapFormattach=" + id + "&oapFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Rejected View</a>";

            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                actionButtons += "<a href='oapForm.htm?act=rejectview&id=" + id
                        + "&oapFormattach=" + id + "&oapFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Approved View</a>";

            } else if (flagStatus == 14) {
                actionButtons += "<a href='oapForm.htm?act=rejectview&id=" + id
                        + "&oapFormattach=" + id + "&oapFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Approved View</a>";
                actionButtons += "<a href='oapForm.htm?act=oaprecycleEdit&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Reverse Edit</a>";

            } else if (flagStatus == 5) {
                actionButtons += "<a href='oapForm.htm?act=AllFormView&id=" + id
                        + "&oapFormattach=" + id + "&oapFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Total Reject View</a>";

            } else if (flagStatus == 1) {
                actionButtons += "<a href='oapForm.htm?act=oapFormApprovalMatrixview&id=" + id
                        + "&oapFormattach=" + id + "&oapFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">View</a>";

            } else if (flagStatus == 2) {
                actionButtons += "<a href='oapForm.htm?act=oapRecycleView&id=" + id
                        + "&oapFormattach=" + id + "&oapFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">ReCycle View</a>";
                actionButtons += "<a href='oapForm.htm?act=oaprecycleEdit&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">ReCycle Edit</a>";

            } else if (flagStatus == 0) {
                actionButtons += "<a href='oapForm.htm?act=SaveAsDraftView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Save As Draft Edit</a>";
            }

            if (flagStatus == 0 || flagStatus == 1 || flagStatus == 2 || flagStatus == 3) {
                actionButtons += "<a href='javascript:void(0);' "
                        + "class='delete-btn1 d-block text-danger p-1 mx-1 action-link' "
                        + "data-id='" + id + "' "
                        + "data-toggle='tooltip' data-placement='left' title='Delete'>"
                        + "<img src='StorageYard/assets/images/delete-icon.svg' style='width:18px;height:18px;'>"
                        + "</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapEHAssignPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        UserRights userRights = userRightsService.readByUser(username);
        int executive = userRights.getExecutiveHead();

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "pcsName";
                    break;
                case "4":
                    orderColumn = "projectName";
                    break;
                case "5":
                    orderColumn = "department";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getOAPExectiveHeadPagination(start, length, searchValue, executive, orderColumn, orderDir);

        int totalRecords = oapFormService.getTotalOAPExectiveHeadCount(executive);

        int filteredRecords = oapFormService.getFilteredOAPExectiveHeadCount(executive, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel;
            if (flagStatus == 4) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            if (flagStatus == 4) {
                actionButtons += "<a href='oapForm.htm?act=oapKickOffFormAssign&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' "
                        + btnStyle + ">Assign</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView CrcFormApproveListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }
        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "pcsName";
                    break;
                case "4":
                    orderColumn = "projectName";
                    break;
                case "5":
                    orderColumn = "department";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getassignedNamePagination(start, length, searchValue, username, orderColumn, orderDir);

        int totalRecords = oapFormService.getTotalassignedNameCount(username);

        int filteredRecords = oapFormService.getFilteredassignedNameCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            actionButtons += "<a href='oapForm.htm?act=CrcForm&oapId=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle + ">Create CRC Form</a>";

            actionButtons += "<a href='oapForm.htm?act=rejectview&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle + ">OAP View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView CrcFormListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "pcsName";
                    break;
                case "4":
                    orderColumn = "userid";
                    break;
                case "5":
                    orderColumn = "designation";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = crcFormService.getusernamePagination(start, length, searchValue, username, orderColumn, orderDir);

        int totalRecords = crcFormService.getTotalusernameCount(username);

        int filteredRecords = crcFormService.getFilteredusernameCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String createdBy = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int oapid = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", createdBy);
            json.put("designation", designation);
            String statusLabel;

            if (flagStatus == 0) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2 || flagStatus == 800) {
                statusLabel = "Partially Approved";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 10) {
                statusLabel = "Recycle";
            } else if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);
            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";
            if (flagStatus == 1 || flagStatus == 4 || flagStatus == 8) {
                actionButtons += "<a href='oapForm.htm?act=CrcFormListview&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + "&nbsp;Approved View</a>";
                actionButtons += "<a href='oapForm.htm?act=AllFormsView&id=" + oapid
                        + "' class='btn theme-btn light-btn mx-1'>"
                        + "OAP View</a>";
            }

            if (flagStatus == 3) {
                actionButtons += "<a href='oapForm.htm?act=CrcFormListview&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + "&nbsp;View</a>";
            }

            if (flagStatus == 2 || flagStatus == 800) {
                actionButtons += "<a href='oapForm.htm?act=CrcFormApprovalMatrixView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='viewName" + id + "' " + btnStyle + ">"
                        + "&nbsp;View</a>";
            }

            if (flagStatus == 10) {
                actionButtons += "<a href='oapForm.htm?act=CrcFormListEdit&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + "&nbsp;Recycle Edit</a>";
                actionButtons += "<a href='oapForm.htm?act=CrcFormApprovalMatrixView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='viewName" + id + "' " + btnStyle + ">"
                        + "&nbsp;View</a>";
            }

            if (flagStatus == 0) {
                actionButtons += "<a href='oapForm.htm?act=CrcFormApprovalMatrixView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='viewName" + id + "' " + btnStyle + ">"
                        + "&nbsp;View</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");
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

    public ModelAndView aocFormAppovalListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";
        if (orderColumnIndex != null) {

            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "hubDepoName";
                    break;
                case "4":
                    orderColumn = "clientProjectName";
                    break;
                case "5":
                    orderColumn = "userId";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = aocFormService.getAocCretedUserPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocCretedUserCount(username);
        int filteredRecords = aocFormService.getFilteredAocCretedUserCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }
        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String CreatedBy = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", CreatedBy);
            json.put("createdDate", createdDate);

            String statusLabel;
            if (flagStatus == 0) {
                statusLabel = "Save As Draft";
            } else if (flagStatus == 1) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            if (flagStatus == 3) {
                actionButtons += "<a href='aocForm.htm?act=rejectview&id=" + id
                        + "&aocFormattach=" + id + "&aocFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Reject View</a>";
            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                actionButtons += "<a href='aocForm.htm?act=rejectview&id=" + id
                        + "&aocFormattach=" + id + "&aocFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Approved View</a>";
            } else if (flagStatus == 1) {
                actionButtons += "<a href='aocForm.htm?act=aocFormAprovalMatrixView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">&nbsp;View</a>";
            } else if (flagStatus == 2) {
                actionButtons += "<a href='aocForm.htm?act=aocFormRecycleEdit&id=" + id
                        + "&aocFormattach=" + id + "&aocFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Recycle Edit</a>";
                actionButtons += "<a href='aocForm.htm?act=aocRecycleView&id=" + id
                        + "&aocFormattach=" + id + "&aocFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Recycle View</a>";
            }
            if (flagStatus == 0) {
                actionButtons += "<a href='aocForm.htm?act=AocSaveAsDraftView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Save As Draft Edit</a>";
            }
            if (flagStatus == 0 || flagStatus == 1 || flagStatus == 2 || flagStatus == 3) {
                actionButtons += "<a href='javascript:void(0);' "
                        + "class='delete-btn1 d-block text-danger p-1 mx-1 action-link' "
                        + "data-id='" + id + "' "
                        + "data-toggle='tooltip' data-placement='left' title='Delete'>"
                        + "<img src='StorageYard/assets/images/delete-icon.svg' style='width:18px;height:18px;'>"
                        + "</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView aocEHAssignPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        UserRights userRights = userRightsService.readByUser(username);
        int executive = userRights.getExecutiveHead();

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "hubDepoName";
                    break;
                case "4":
                    orderColumn = "clientProjectName";
                    break;
                case "5":
                    orderColumn = "userId";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = aocFormService.getAOCExectiveHeadPagination(start, length, searchValue, executive, orderColumn, orderDir);

        int totalRecords = aocFormService.getTotalAOCExectiveHeadCount(executive);

        int filteredRecords = aocFormService.getFilteredAOCExectiveHeadCount(executive, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }
        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("createdDate", createdDate);

            String statusLabel;
            if (flagStatus == 4) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            if (flagStatus == 4) {
                actionButtons += "<a href='aocForm.htm?act=aocKickOffFormAssign&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' "
                        + btnStyle + ">Assign</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView komFormApproveListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "documentNo";
                    break;
                case "3":
                    orderColumn = "userId";
                    break;
                case "4":
                    orderColumn = "createdDate";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = aocFormService.getassignedNamePagination(start, length, searchValue, username, orderColumn, orderDir);

        int totalRecords = aocFormService.getTotalassignedNameCount(username);

        int filteredRecords = aocFormService.getFilteredassignedNameCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String userId = row[2] != null ? row[2].toString() : "";
            String createdDate = row[3] != null ? row[3].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("userId", userId);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            actionButtons += "<a href='aocForm.htm?act=kickoffForm&aocId=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle + ">Create KOM Form</a>";

            actionButtons += "<a href='aocForm.htm?act=rejectview&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle + ">AOC View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView komFormListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");
        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "desc";

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubLocation";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;
                case "5":
                    orderColumn = "dateTime";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = kickOffFormService.getusernamePagination(start, length, searchValue, username, orderColumn, orderDir);

        int totalRecords = kickOffFormService.getTotalusernameCount(username);

        int filteredRecords = kickOffFormService.getFilteredusernameCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            String dateTime = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;
            int aocid = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("projectName", projectName);
            json.put("designation", designation);
            json.put("dateTime", dateTime);

            String statusLabel;

            if (flagStatus == 0) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 1 || flagStatus == 4 || flagStatus == 8) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";
            if (flagStatus == 0) {
                actionButtons += "<a href='aocForm.htm?act=KickOffFormApprovalMatrixview&id=" + id
                        + "&aocFormattach=" + id + "&aocFormmulti=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + "> View</a>";

            } else if (flagStatus == 1 || flagStatus == 4 || flagStatus == 8) {
                actionButtons += "<a href='aocForm.htm?act=KickOffFormListview&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + "View</a>";
                actionButtons += "<a href='aocForm.htm?act=AllFormsView2&id=" + aocid
                        + "' class='btn theme-btn light-btn mx-1'>"
                        + "AOC View</a>";

            } else if (flagStatus == 3) {
                actionButtons += "<a href='aocForm.htm?act=KickOffFormApprovalMatrixview&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + " View</a>";

            } else if (flagStatus == 2) {
                actionButtons += "<a href='aocForm.htm?act=KickOffListEdit&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + "Recycle Edit</a>";

                actionButtons += "<a href='aocForm.htm?act=KickOffFormApprovalMatrixview&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' id='rightName" + id + "'>"
                        + "View</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");
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

    public ModelAndView OapApprovalListPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {

            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "c.documentNo";
                    break;
                case "3":
                    orderColumn = "c.pcsName";
                    break;
                case "4":
                    orderColumn = "c.createdDate";
                    break;
                case "5":
                    orderColumn = "a.userId";
                    break;

                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormApprovalService.getOapApprovaListPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = oapFormApprovalService.getTotalOapApprovaListCount(username);
        int filteredRecords = oapFormApprovalService.getFilteredOapApprovaListCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            String ApprvalId = row[7] != null ? row[7].toString() : "";
            String userId = row[10] != null ? row[10].toString() : "";

            String flagStatus = row[9] != null ? row[9].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("userId", userId);

            String statusLabel;
            if ("0".equals(flagStatus)) {
                statusLabel = "Pending";
            } else if ("1".equals(flagStatus)) {
                statusLabel = "Approve";
            } else if ("2".equals(flagStatus)) {
                statusLabel = "Rework";
            } else if ("3".equals(flagStatus)) {
                statusLabel = "Reject";
            } else {
                statusLabel = "";
            }

            json.put("approvalStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            actionButtons += "<a href='oapForm.htm?act=OapApprovalView&id=" + ApprvalId
                    + "&oapFormId=" + id + "&oapFormattach=" + id + "&oapFormmulti=" + id
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + "> View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView crcFormApprovalUserPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "c.documentNo";
                    break;
                case "3":
                    orderColumn = "c.pcsName";
                    break;

                case "4":
                    orderColumn = "a.userId";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = crcFormApprovalService.getCrcApprovaListPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = crcFormApprovalService.getTotalCrcApprovaListCount(username);
        int filteredRecords = crcFormApprovalService.getFilteredCrcApprovaListCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (filteredRecords - start) : (start + 1);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            int crcId = row[1] != null ? ((Number) row[1]).intValue() : 0;
            String userId = row[2] != null ? row[2].toString() : "";
            String flagStatus = row[8] != null ? row[8].toString() : "";
            String documentNo = row[5] != null ? row[5].toString() : "";
            int oapId = row[7] != null ? ((Number) row[7]).intValue() : 0;
            String pcsName = row[9] != null ? row[9].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userId", userId);

            String statusLabel;
            switch (flagStatus) {
                case "0":
                    statusLabel = "Pending";
                    break;
                case "1":
                    statusLabel = "Approve";
                    break;
                case "2":
                    statusLabel = "Rework";
                    break;
                case "3":
                    statusLabel = "Reject";
                    break;
                case "800":
                    statusLabel = "Partially Approved";
                    break;
                default:
                    statusLabel = "";
                    break;
            }
            json.put("approvalStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String actionButtons
                    = "<a href='oapForm.htm?act=CrcFormApprovalUserView&id=" + id
                    + "&crcFormId=" + crcId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">View</a>"
                    + "<a href='oapForm.htm?act=AllFormsView&id=" + oapId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapExitedDetailsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "a.documentNo";
                    break;
                case "3":
                    orderColumn = "a.pcsName";
                    break;
                case "4":
                    orderColumn = "a.projectName";
                    break;
                case "5":
                    orderColumn = "a.department";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormService.getCrcPartiallyApprovePagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalCrcPartiallyApproveCount(username);
        int filteredRecords = oapFormService.getFilteredCrcPartiallyApproveCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int crcId = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String actionButtons
                    = "<a href='oapForm.htm?act=CrcFormListEdit&id=" + crcId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Edit</a>"
                    + "<a href='oapForm.htm?act=OpaLastestData&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView aocApprovalPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "c.documentNo";
                    break;
                case "3":
                    orderColumn = "c.createdDate";
                    break;
                case "4":
                    orderColumn = "a.userId";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = aocFormApprovalService.getAocApprovalPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = aocFormApprovalService.getTotalAocApprovalCount(username);
        int filteredRecords = aocFormApprovalService.getFilteredAocApprovalCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            int aocId = row[1] != null ? ((Number) row[1]).intValue() : 0;
            String userId = row[2] != null ? row[2].toString() : "";
            String flagStatus = row[3] != null ? row[3].toString() : "";
            String documentNo = row[4] != null ? row[4].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("createdDate", createdDate);
            json.put("userId", userId);

            String statusLabel;
            switch (flagStatus) {
                case "0":
                    statusLabel = "Pending";
                    break;
                case "1":
                    statusLabel = "Approve";
                    break;
                case "2":
                    statusLabel = "Rework";
                    break;
                case "3":
                    statusLabel = "Reject";
                    break;
                default:
                    statusLabel = "";
                    break;
            }
            json.put("approvalStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String actionButtons
                    = "<a href='aocForm.htm?act=AocApprovalView&id=" + id
                    + "&aocFormId=" + aocId
                    + "&aocFormattach=" + aocId
                    + "&aocFormmulti=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView kickOffFormApprovalUserPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "c.documentNo";
                    break;
                case "3":
                    orderColumn = "c.dateTime";
                    break;

                case "4":
                    orderColumn = "a.userId";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = kickOffFormApprovalService.getKomApprovalUserPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = kickOffFormApprovalService.getTotalKomApprovalUserCount(username);
        int filteredRecords = kickOffFormApprovalService.getFilteredKomApprovalUserCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (filteredRecords - start) : (start + 1);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            int komId = row[1] != null ? ((Number) row[1]).intValue() : 0;
            String userId = row[2] != null ? row[2].toString() : "";
            String flagStatus = row[3] != null ? row[3].toString() : "";
            String documentNo = row[4] != null ? row[4].toString() : "";
            String dateTime = row[5] != null ? row[5].toString() : "";
            int aocId = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("dateTime", dateTime);
            json.put("userId", userId);

            String statusLabel;
            switch (flagStatus) {
                case "0":
                    statusLabel = "Pending";
                    break;
                case "1":
                    statusLabel = "Approve";
                    break;
                case "2":
                    statusLabel = "Rework";
                    break;
                case "3":
                    statusLabel = "Reject";
                    break;

                default:
                    statusLabel = "";
                    break;
            }
            json.put("approvalStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String actionButtons
                    = "<a href='aocForm.htm?act=KickOffApprovalUserView&id=" + id
                    + "&kickoffFormId=" + komId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">View</a>"
                    + "<a href='aocForm.htm?act=AllFormsView2&id=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapDesignTeamPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        List list33 = deliverableService.read();

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userId";
                    break;
                case "4":
                    orderColumn = "createdDate";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getOapDesignTeamPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalOapDesignTeamCount(username);
        int filteredRecords = oapFormService.getFilteredOapDesignTeamCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;
            int partiallyApproveFlag = row[7] != null ? ((Number) row[7]).intValue() : -1;
            int surveyRadio = row[8] != null ? ((Number) row[8]).intValue() : -1;
            String userId = row[9] != null ? row[9].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userId", userId);
            json.put("createdDate", createdDate);

            String statusLabel;
            if ((flagStatus == 7 && (partiallyApproveFlag == 1 || partiallyApproveFlag == 11 || partiallyApproveFlag == 12))
                    || (flagStatus == 14 && (partiallyApproveFlag == 1 || partiallyApproveFlag == 12))
                    || (flagStatus == 3 && partiallyApproveFlag == 12)
                    || (flagStatus == 4 && partiallyApproveFlag == 12)) {
                statusLabel = "Approved";
            } else if (partiallyApproveFlag == 13) {
                statusLabel = "Deliverable Rejected";
            } else {
                statusLabel = "";
            }
            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String viewButtons
                    = "<a href='oapForm.htm?act=AllFormsView&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>"
                    + "<a href='oapForm.htm?act=AllFormsView1&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>"
                    + "<a href='oapForm.htm?act=AllDeliverableViewOap&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">All Deliverable</a>";

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>" + viewButtons + "</div>");

            String statusMsg = "";
            String actionButtons = "";

            if (partiallyApproveFlag == 1 && surveyRadio == 1) {
                statusMsg = "<div class='text-success mb-1'>Site Survey Completed</div>";
            }

            actionButtons += "<a href='oapForm.htm?act=SiteSurveyCreateDeliverable&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Site Survey Create</a>";

            if (partiallyApproveFlag == 1 && surveyRadio == 1) {
                actionButtons += "<a href='oapForm.htm?act=Deliverable&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Deliverable</a>";
            }

            if (partiallyApproveFlag == 12) {
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorRejectView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Deliverable View</a>";
            }

            if (partiallyApproveFlag == 13) {
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorRejectView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Rejected View</a>";
            }

            if (partiallyApproveFlag == 11) {
                for (Object item : list33) {
                    Deliverable deliverable = (Deliverable) item;
                    if (deliverable.getAocId() == 0 && deliverable.getOapId() == id) {
                        actionButtons += "<a href='oapForm.htm?act=DeliverableEdit&id=" + deliverable.getId()
                                + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Deliverable Edit</a>";
                        break;
                    }
                }
            }

            json.put("action",
                    "<div class='d-flex flex-column align-items-center'>"
                    + statusMsg
                    + "<div class='d-flex flex-row flex-wrap justify-content-center align-items-center gap-2'>"
                    + actionButtons
                    + "</div></div>");

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

    public ModelAndView aocDesignTeamPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        List list33 = deliverableService.read();

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "userId";
                    break;
                case "4":
                    orderColumn = "createdDate";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = aocFormService.getAocDesignTeamPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocDesignTeamCount(username);
        int filteredRecords = aocFormService.getFilteredAocDesignTeamCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String userId = row[3] != null ? row[3].toString() : "";
            String createdDate = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int surveyRadio = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("userId", userId);
            json.put("createdDate", createdDate);

            String statusLabel;
            if (flagStatus == 7 || flagStatus == 11 || flagStatus == 12) {
                statusLabel = "Approved";
            } else if (flagStatus == 13) {
                statusLabel = "Deliverable Rejected";
            } else {
                statusLabel = "";
            }
            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String viewButtons
                    = "<a href='aocForm.htm?act=AllFormsView2&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>"
                    + "<a href='aocForm.htm?act=AllFormsView3&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">KOM View</a>"
                    + "<a href='oapForm.htm?act=AllDeliverableViewAoc&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">All Deliverable</a>";

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>" + viewButtons + "</div>");

            String statusMsg = "";
            String actionButtons = "";

            if (flagStatus == 7 && surveyRadio == 1) {
                statusMsg = "<div style='color: #00ca6d; margin-bottom: 5px;'>Site Survey Completed</div>";
            }

            actionButtons += "<div class='btn-group' style='display: flex; gap: 12px;'>";

            actionButtons += "<a href='oapForm.htm?act=SiteSurveyCreateDeliverableAoc&id=" + id
                    + "' class='btn theme-btn light-btn'>Site Survey Create</a>";

            if (flagStatus == 7 && surveyRadio == 1) {
                actionButtons += "<a href='oapForm.htm?act=DeliverableAoc&id=" + id
                        + "' class='btn theme-btn light-btn'>Deliverable</a>";
            }

            if (flagStatus == 12) {
                actionButtons += "<a href='oapForm.htm?act=DeliverableAocView&id=" + id
                        + "' class='btn theme-btn light-btn'>Deliverable View</a>";
            }

            if (flagStatus == 13) {
                actionButtons += "<a href='oapForm.htm?act=DeliverableAocView&id=" + id
                        + "' class='btn theme-btn light-btn'>Rejected View</a>";
            }

            if (flagStatus == 11) {
                for (Object item : list33) {
                    Deliverable deliverable = (Deliverable) item;
                    if (deliverable.getOapId() == 0 && deliverable.getAocId() == id) {
                        actionButtons += "<a href='oapForm.htm?act=DeliverableAocEdit&id=" + deliverable.getId()
                                + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Deliverable Edit</a>";
                        break;
                    }
                }
            }

            json.put("action",
                    "<div class='d-flex flex-column align-items-center'>"
                    + statusMsg
                    + "<div class='d-flex flex-row flex-wrap justify-content-center align-items-center gap-2'>"
                    + actionButtons
                    + "</div></div>");

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

    public ModelAndView oapProjectmanagerPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }
        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormService.getOapProjectmanagerPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalOapProjectmanagerCount(username);
        int filteredRecords = oapFormService.getFilteredOapProjectmanagerCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String createdDate = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int crcId = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String viewButtons = "<a href='oapForm.htm?act=AllFormsView&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle + ">OAP View</a>";

            if (flagStatus == 6 || flagStatus == 7 || flagStatus == 11 || flagStatus == 12 || flagStatus == 13 || flagStatus == 14) {
                viewButtons += "<a href='oapForm.htm?act=AllFormsView4&id=" + crcId
                        + "' class='btn theme-btn light-btn mx-1' "
                        + btnStyle + ">CRC View</a>";
            }
            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>" + viewButtons + "</div>");

            String btnStyle1 = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            actionButtons += "<a href='oapForm.htm?act=projectmanagerview&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle1 + ">View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView aocProjectmanagerPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }
        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;
                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = aocFormService.getAocProjectmanagerPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocProjectmanagerCount(username);
        int filteredRecords = aocFormService.getFilteredAocProjectmanagerCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String createdDate = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int komId = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String viewButtons = "<a href='aocForm.htm?act=AllFormsView2&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle + ">OAP View</a>";

            if (flagStatus == 6 || flagStatus == 7 || flagStatus == 11 || flagStatus == 12 || flagStatus == 13 || flagStatus == 14) {
                viewButtons += "<a href='aocForm.htm?act=AllFormsView5&id=" + komId
                        + "' class='btn theme-btn light-btn mx-1' "
                        + btnStyle + ">KOM View</a>";
            }
            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>" + viewButtons + "</div>");

            String btnStyle1 = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "";

            actionButtons += "<a href='oapForm.htm?act=projectmanagerview1&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' "
                    + btnStyle1 + ">View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapAndaocDesigncordinatorPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "a.description";
                    break;
                case "3":
                    orderColumn = "a.design_Coordinator";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = deliverableMultiService.getDesignCoordinatorPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = deliverableMultiService.getTotalDesignCoordinatorCount(username);
        int filteredRecords = deliverableMultiService.getFilteredDesignCoordinatorCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String description = row[1] != null ? row[1].toString() : "";
            String designCoord = row[2] != null ? row[2].toString() : "";
            int flagStatus = row[3] != null ? ((Number) row[3]).intValue() : -1;
            String documentNo = row[8] != null ? row[8].toString() : "";
            int aocId = row[9] != null ? ((Number) row[9]).intValue() : 0;
            int oapId = row[10] != null ? ((Number) row[10]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("description", description);
            json.put("designCoord", designCoord);

            // Status label
            String statusLabel;
            if (flagStatus == 0 || flagStatus == 4) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 1 || flagStatus == 5) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }
            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String viewButtons = "";

            if (aocId == 0) {
                viewButtons += "<a href='oapForm.htm?act=AllFormsView&id=" + oapId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";
                viewButtons += "<a href='oapForm.htm?act=AllFormsView1&id=" + oapId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";
            }

            if (oapId == 0) {
                viewButtons += "<a href='aocForm.htm?act=AllFormsView2&id=" + aocId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>";
                viewButtons += "<a href='aocForm.htm?act=AllFormsView3&id=" + aocId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">KOM View</a>";
            }

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

            String actionButtons = "";

            if (flagStatus == 1 || flagStatus == 5) {
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorApprovedView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Approved View</a>";
            } else if (flagStatus == 2) {
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorRecycleView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Rework Edit</a>";
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorApprovedView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Rework View</a>";
            } else if (flagStatus == 3) {
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorApprovedView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Reject View</a>";
            } else if (flagStatus == 4) {
                actionButtons += "<a href='oapForm.htm?act=DesigncordinatorRecycleView&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Edit</a>";
            } else {
                actionButtons += "<a href='oapForm.htm?act=Designcordinatorview&id=" + id
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Create Deliverable</a>";
            }

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapAndaocDesigncoordApprovalPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "a.description";
                    break;
                case "3":
                    orderColumn = "a.assigned_by";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = deliverableMultiService.getDesignAssignPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = deliverableMultiService.getTotalDesignAssignCount(username);
        int filteredRecords = deliverableMultiService.getFilteredDesignAssignCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String description = row[1] != null ? row[1].toString() : "";
            String assignedBy = row[2] != null ? row[2].toString() : "";
            int flagStatus = row[3] != null ? ((Number) row[3]).intValue() : -1;
            int oapId_ref = row[4] != null ? ((Number) row[4]).intValue() : -1;
            int aocId_ref = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int oapFlagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;
            int aocFlagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;
            String documentNo = row[8] != null ? row[8].toString() : "";
            int aocId = row[9] != null ? ((Number) row[9]).intValue() : 0;
            int oapId = row[10] != null ? ((Number) row[10]).intValue() : 0;

            if ((oapFlagStatus == 8 || oapFlagStatus == 9 || oapFlagStatus == 10)
                    || (aocFlagStatus == 8 || aocFlagStatus == 9 || aocFlagStatus == 10)) {
                continue;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("description", description);
            json.put("assignedBy", assignedBy);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String viewButtons = "";

            if (aocId == 0) {
                viewButtons += "<a href='oapForm.htm?act=AllFormsView&id=" + oapId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";
                viewButtons += "<a href='oapForm.htm?act=AllFormsView1&id=" + oapId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";
            }

            if (oapId == 0) {
                viewButtons += "<a href='aocForm.htm?act=AllFormsView2&id=" + aocId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>";
                viewButtons += "<a href='aocForm.htm?act=AllFormsView3&id=" + aocId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Kick-Off View</a>";
            }

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

            String actionButtons = "<a href='oapForm.htm?act=DesigncoordinatorApprovalView"
                    + "&id=" + id
                    + "&id1=" + oapId
                    + "&id2=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapprojmanaApprmultiPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "c.documentNo";
                    break;
                case "3":
                    orderColumn = "a.pcsName";
                    break;
                case "4":
                    orderColumn = "a.projectName";
                    break;
                case "5":
                    orderColumn = "a.mobileNo";
                    break;
                case "6":
                    orderColumn = "a.department";
                    break;
                case "7":
                    orderColumn = "a.createdDate";
                    break;
                case "8":
                    orderColumn = "a.userId";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormService.getUserprojectPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalUserprojectCount(username);
        int filteredRecords = oapFormService.getFilteredUserprojectCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int oapId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String oapDocumentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String mobileNo = row[4] != null ? row[4].toString() : "";
            String department = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            String userId = row[7] != null ? row[7].toString() : "";
            int oapFlagStatus = row[8] != null ? ((Number) row[8]).intValue() : -1;
            int delivId = row[9] != null ? ((Number) row[9]).intValue() : 0;
            int delivFlagStatus = row[10] != null ? ((Number) row[10]).intValue() : -1;
            int crcId = row[11] != null ? ((Number) row[11]).intValue() : 0;
            String crcDocumentNo = row[12] != null ? row[12].toString() : "";

            if (oapFlagStatus == 8 || oapFlagStatus == 9 || oapFlagStatus == 10) {
                continue;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("oapDocumentNo", oapDocumentNo);
            json.put("crcDocumentNo", crcDocumentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("mobileNo", mobileNo);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("userId", userId);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButtons = "";
            if (!oapDocumentNo.equals("0") && !oapDocumentNo.isEmpty()) {
                viewButtons += "<a href='oapForm.htm?act=AllFormsView&id=" + oapId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";
                viewButtons += "<a href='oapForm.htm?act=AllFormsView1&id=" + oapId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";
            }

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

            String actionButtons = "<a href='oapForm.htm?act=projectmanagerApprove1&id=" + delivId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Approve</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView aocprojmanaApprmultiPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "c.documentNo";
                    break;
                case "3":
                    orderColumn = "a.hubDepoName";
                    break;
                case "4":
                    orderColumn = "a.clientProjectName";
                    break;
                case "5":
                    orderColumn = "a.userId";
                    break;
                case "6":
                    orderColumn = "a.designation";
                    break;
                case "7":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = aocFormService.getUserprojectPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalUserprojectCount(username);
        int filteredRecords = aocFormService.getFilteredUserprojectCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int aocId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String aocDocumentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String designation = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            int aocFlagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;
            int delivId = row[8] != null ? ((Number) row[8]).intValue() : 0;
            int delivFlagStatus = row[9] != null ? ((Number) row[9]).intValue() : -1;
            int kickOffId = row[10] != null ? ((Number) row[10]).intValue() : 0;
            String kickOffDocumentNo = row[11] != null ? row[11].toString() : "";

            if (aocFlagStatus == 8 || aocFlagStatus == 9 || aocFlagStatus == 10) {
                continue;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("aocDocumentNo", aocDocumentNo);
            json.put("kickOffDocumentNo", kickOffDocumentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("designation", designation);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButtons = "";
            if (!kickOffDocumentNo.equals("0") && !kickOffDocumentNo.isEmpty()) {
                viewButtons += "<a href='aocForm.htm?act=AllFormsView2&id=" + aocId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>";
                viewButtons += "<a href='aocForm.htm?act=AllFormsView3&id=" + aocId
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Kick-Off View</a>";
            }

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

            String actionButtons = "<a href='oapForm.htm?act=projectmanagerApprove1&id=" + delivId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Approve</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

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

    public ModelAndView oapDeliverableViewPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.userid";
                    break;
                case "4":
                    orderColumn = "a.designation";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = crcFormService.getoapDeliverableViewPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = crcFormService.getTotaloapDeliverableViewCount(username);
        int filteredRecords = crcFormService.getFilteredoapDeliverableViewCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int crcId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int oapId = row[6] != null ? ((Number) row[6]).intValue() : 0;

            String statusLabel = "";
            if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            } else if (flagStatus == 0) {
                statusLabel = "Pending to Approved";
            } else if (flagStatus == 2) {
                statusLabel = "Partially Approved";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            }

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButton = "<a href='oapForm.htm?act=CreatePrFromOap&id=" + crcId + "&oapid=" + oapId
                    + "' class='btn theme-btn light-btn' " + btnStyle + ">Deliverable View</a>";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);
            json.put("status", statusLabel);
            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + viewButton + "</div>");

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

    public ModelAndView aocDeliverableViewPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        UserMaster user1 = (UserMaster) session.getAttribute("user");
        String username = user1.getLoginName();

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break; // Sr.No
                case "1":
                    orderColumn = "a.documentNo";
                    break; // Document No
                case "2":
                    orderColumn = "a.aocForm.hubDepoName";
                    break; // Hub Depo Name
                case "3":
                    orderColumn = "a.userId";
                    break; // Created By
                case "4":
                    orderColumn = "a.designation";
                    break; // Designation
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = kickOffFormService.getkomDeliverableViewPagination(start, length, searchValue, username, orderColumn, orderDir);
        int totalRecords = kickOffFormService.getTotalkomDeliverableViewCount(username);
        int filteredRecords = kickOffFormService.getFilteredkomDeliverableViewCount(username, searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int kickOffId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String userId = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;
            int aocId = row[6] != null ? ((Number) row[6]).intValue() : 0;

            // Status label — mirrors JSP c:if conditions
            String statusLabel = "";
            if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            } else if (flagStatus == 0) {
                statusLabel = "Pending to Approved";
            } else if (flagStatus == 2) {
                statusLabel = "Partially Approved";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            }

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButton = "<a href='aocForm.htm?act=CreatePrFromAoc&id=" + kickOffId + "&aocid=" + aocId
                    + "' class='btn theme-btn light-btn' " + btnStyle + ">Deliverable View</a>";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("userId", userId);
            json.put("designation", designation);
            json.put("status", statusLabel);
            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + viewButton + "</div>");

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

    public ModelAndView networkTeamPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.mobileNo";
                    break;
                case "5":
                    orderColumn = "a.department";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                case "7":
                    orderColumn = "a.userId";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormService.getNetworkTeamPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalNetworkTeamCount();
        int filteredRecords = oapFormService.getFilteredNetworkTeamCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int oapId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String mobileNo = row[4] != null ? row[4].toString() : "";
            String department = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            String userId = row[7] != null ? row[7].toString() : "";
            int flagStatus = row[8] != null ? ((Number) row[8]).intValue() : -1;

            if (flagStatus == 8 || flagStatus == 9 || flagStatus == 10) {
                continue;
            }

            String statusLabel = "";
            if (flagStatus == 7 || flagStatus == 11 || flagStatus == 12) {
                statusLabel = "Approved";
            } else if (flagStatus == 13) {
                statusLabel = "Deliverable Rejected";
            }

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButtons
                    = "<a href='oapForm.htm?act=AllFormsView&id=" + oapId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>"
                    + "<a href='oapForm.htm?act=AllFormsView1&id=" + oapId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("mobileNo", mobileNo);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("userId", userId);
            json.put("status", statusLabel);

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

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

    public ModelAndView aocnetworkTeamPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;
                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.userId";
                    break;
                case "5":
                    orderColumn = "a.designation";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = aocFormService.getAocNetworkTeamPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocNetworkTeamCount();
        int filteredRecords = aocFormService.getFilteredAocNetworkTeamCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int aocId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String designation = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            int flagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;

            if (flagStatus == 8 || flagStatus == 9 || flagStatus == 10) {
                continue;
            }

            String statusLabel = "";
            if (flagStatus == 7 || flagStatus == 11 || flagStatus == 12) {
                statusLabel = "Approved";
            } else if (flagStatus == 13) {
                statusLabel = "Deliverable Rejected";
            }

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButtons
                    = "<a href='aocForm.htm?act=AllFormsView2&id=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>"
                    + "<a href='aocForm.htm?act=AllFormsView3&id=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Kick-Off View</a>";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("designation", designation);
            json.put("createdDate", createdDate);
            json.put("status", statusLabel);
            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

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

    public ModelAndView financeTeamPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.mobileNo";
                    break;
                case "5":
                    orderColumn = "a.department";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                case "7":
                    orderColumn = "a.userId";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormService.getNetworkTeamPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalNetworkTeamCount();
        int filteredRecords = oapFormService.getFilteredNetworkTeamCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int oapId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String mobileNo = row[4] != null ? row[4].toString() : "";
            String department = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            String userId = row[7] != null ? row[7].toString() : "";
            int flagStatus = row[8] != null ? ((Number) row[8]).intValue() : -1;

            if (flagStatus == 8 || flagStatus == 9 || flagStatus == 10) {
                continue;
            }

            String statusLabel = "";
            if (flagStatus == 7 || flagStatus == 11 || flagStatus == 12) {
                statusLabel = "Approved";
            } else if (flagStatus == 13) {
                statusLabel = "Deliverable Rejected";
            }

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButtons
                    = "<a href='oapForm.htm?act=AllFormsView&id=" + oapId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>"
                    + "<a href='oapForm.htm?act=AllFormsView1&id=" + oapId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("mobileNo", mobileNo);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("userId", userId);
            json.put("status", statusLabel);

            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

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

    public ModelAndView aocFinanceTeamPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;
                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.userId";
                    break;
                case "5":
                    orderColumn = "a.designation";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = aocFormService.getAocNetworkTeamPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocNetworkTeamCount();
        int filteredRecords = aocFormService.getFilteredAocNetworkTeamCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int aocId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String designation = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            int flagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;

            if (flagStatus == 8 || flagStatus == 9 || flagStatus == 10) {
                continue;
            }

            String statusLabel = "";
            if (flagStatus == 7 || flagStatus == 11 || flagStatus == 12) {
                statusLabel = "Approved";
            } else if (flagStatus == 13) {
                statusLabel = "Deliverable Rejected";
            }

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";

            String viewButtons
                    = "<a href='aocForm.htm?act=AllFormsView2&id=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>"
                    + "<a href='aocForm.htm?act=AllFormsView3&id=" + aocId
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Kick-Off View</a>";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("designation", designation);
            json.put("createdDate", createdDate);
            json.put("status", statusLabel);
            json.put("view",
                    "<div class='d-flex align-items-center justify-content-center gap-2'>"
                    + viewButtons + "</div>");

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

    public ModelAndView siteSurveyReportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String SiteSurveyNumber = request.getParameter("SiteSurveyNumber");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");
        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        switch (orderColumnIndex) {

            case "0":
                orderColumn = "id";
                break;

            case "1":
                orderColumn = "surveyDocumentNo";
                break;

            case "2":
                orderColumn = "siteName";
                break;

            case "3":
                orderColumn = "siteAddress";
                break;

            case "4":
                orderColumn = "createdBy";
                break;

            case "5":
                orderColumn = "description";
                break;

            default:
                orderColumn = "id";
                break;
        }

        List list = siteSurveyService.getSiteSurveyReportPagination(start, length, searchValue, SiteSurveyNumber, fromDate, toDate, orderColumn, orderDir);
        int totalRecords = siteSurveyService.getTotalSiteSurveyReportCount();
        int filteredRecords = siteSurveyService.getFilteredSiteSurveyReportCount(searchValue, SiteSurveyNumber, fromDate, toDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            JSONObject json = new JSONObject();

            if (isDesc) {
                json.put("srNo", srNo++);
            } else {
                json.put("srNo", srNo--);
            }

            json.put(
                    "surveyDocumentNo",
                    "<a href='oapForm.htm?act=SiteSurveyDetails&id="
                    + (row[0] != null ? row[0] : "")
                    + "' class='fw-600 text-break gradient-text'>"
                    + (row[1] != null ? row[1] : "")
                    + "</a>"
            );

            json.put("siteName", row[2] != null ? row[2].toString() : "");
            json.put("siteAddress", row[3] != null ? row[3].toString() : "");
            json.put("createdBy", row[4] != null ? row[4].toString() : "");
            json.put("description", row[5] != null ? row[5].toString() : "");

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

    public ModelAndView oapseachReportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String oapdocumentNumber = request.getParameter("oapdocumentNumber");
        String projectName = request.getParameter("projectName");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");
        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "a.id";

        switch (orderColumnIndex) {
            case "0":
                orderColumn = "a.id";
                break;
            case "1":
                orderColumn = "a.document_no";
                break;
            case "2":
                orderColumn = "a.pcs_name";
                break;
            case "3":
                orderColumn = "a.project_name";
                break;
            case "4":
                orderColumn = "a.department";
                break;
            case "5":
                orderColumn = "a.created_date";
                break;
            case "6":
                orderColumn = "a.created_date";
                break;
            default:
                orderColumn = "a.id";
                break;
        }

        List list = oapFormService.getOapReportPagination(start, length, searchValue, oapdocumentNumber, projectName, fromDate, toDate, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalOapReportCount();
        int filteredRecords = oapFormService.getFilteredOapReportCount(searchValue, oapdocumentNumber, projectName, fromDate, toDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            try {
                Object[] row = (Object[]) obj;

                JSONObject json = new JSONObject();

                if (isDesc) {
                    json.put("srNo", srNo++);
                } else {
                    json.put("srNo", srNo--);
                }

                json.put(
                        "documentNo",
                        "<a href='oapForm.htm?act=oapStatus&id="
                        + (row[0] != null ? row[0] : "")
                        + "' class='fw-600 text-break gradient-text'>"
                        + (row[1] != null ? row[1] : "")
                        + "</a>"
                );

                json.put("pcsName", row[2] != null ? row[2].toString() : "");
                json.put("projectName", row[3] != null ? row[3].toString() : "");
                json.put("department", row[4] != null ? row[4].toString() : "");
                json.put("createdDate", row[5] != null ? row[5].toString() : "");

                // ── OAP flag status ──────────────────────────────────────────
                int flagStatusOAP = 0;
                try {
                    if (row[6] != null && !row[6].toString().trim().isEmpty()) {
                        flagStatusOAP = Integer.parseInt(row[6].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusOAP = 0;
                }

                // ── CRC flag status ──────────────────────────────────────────
                int flagStatusCRC = -1;
                try {
                    if (row[7] != null && !row[7].toString().trim().isEmpty()) {
                        flagStatusCRC = Integer.parseInt(row[7].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusCRC = -1;
                }

                // ── Partially approve flag ───────────────────────────────────
                int flagStatusparta = 0;
                try {
                    if (row[8] != null && !row[8].toString().trim().isEmpty()) {
                        flagStatusparta = Integer.parseInt(row[8].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusparta = 0;
                }

                // ── OAP Status Label ─────────────────────────────────────────
                String statusLabel;
                if (flagStatusOAP == 0) {
                    statusLabel = "Save As Draft";
                } else if (flagStatusOAP == 1) {
                    statusLabel = "Pending to Approve";
                } else if (flagStatusOAP == 2) {
                    statusLabel = "Recycle";
                } else if (flagStatusOAP == 3) {
                    statusLabel = "Rejected";
                } else if (flagStatusOAP == 4 || flagStatusOAP == 6 || flagStatusOAP == 7
                        || flagStatusOAP == 11 || flagStatusOAP == 12 || flagStatusOAP == 13) {
                    statusLabel = "Approved";
                } else if (flagStatusOAP == 5) {
                    statusLabel = "Rejected CRC";
                } else if (flagStatusOAP == 14) {
                    statusLabel = "Approved";
                } else if (flagStatusOAP == 100) {
                    statusLabel = "OAP Deleted";
                } else {
                    statusLabel = "";
                }
                json.put("flagStatusOAP", statusLabel);

                // ── CRC Status Label ─────────────────────────────────────────
                String statusLabelCRC;
                if (flagStatusCRC == 0) {
                    statusLabelCRC = "Pending to Approve";
                } else if (flagStatusCRC == 10) {
                    statusLabelCRC = "ReWork";
                } else if (flagStatusCRC == 3) {
                    statusLabelCRC = "Rejected";
                } else if (flagStatusCRC == 4 || flagStatusCRC == 1) {
                    statusLabelCRC = "Approved";
                } else if (flagStatusCRC == 2 || flagStatusCRC == 800) {
                    statusLabelCRC = "Partially Approved";
                } else {
                    statusLabelCRC = "";
                }
                json.put("flagStatusCRC", statusLabelCRC);

                // ── Action Buttons ───────────────────────────────────────────
                String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
                String actionButtons = "";

                actionButtons += "<a href='oapForm.htm?act=AllFormsView&id=" + (row[0] != null ? row[0] : "")
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";

                if (flagStatusOAP == 6 || flagStatusOAP == 7 || flagStatusOAP == 11
                        || flagStatusOAP == 12 || flagStatusOAP == 13 || flagStatusCRC == 2 || flagStatusCRC == 800) {
                    actionButtons += "<a href='oapForm.htm?act=AllFormsView1&id=" + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";
                }

                if (flagStatusparta == 12 || flagStatusparta == 13) {
                    actionButtons += "<a href='oapForm.htm?act=DesigncordinatorRejectView&id=" + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Deliverable View</a>";
                }

                json.put("action",
                        "<div class='d-flex align-items-center justify-content-center'>"
                        + actionButtons + "</div>");

                dataArray.put(json);

            } catch (Exception rowEx) {
                rowEx.printStackTrace();
            }
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

    public ModelAndView aocSearchReportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String aocdocumentNumber = request.getParameter("aocdocumentNumber");
        String projectName = request.getParameter("projectName");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "a.id";
        switch (orderColumnIndex) {
            case "0":
                orderColumn = "a.id";
                break;
            case "1":
                orderColumn = "a.document_no";
                break;
            case "2":
                orderColumn = "a.hub_depo_name";
                break;
            case "3":
                orderColumn = "a.client_project_name";
                break;
            case "4":
                orderColumn = "a.user_id";
                break;
            case "5":
                orderColumn = "a.created_date";
                break;
            case "6":
                orderColumn = "a.flag_status";
                break;
            default:
                orderColumn = "a.id";
                break;
        }

        List list = aocFormService.getAocReportPagination(start, length, searchValue, aocdocumentNumber, projectName, fromDate, toDate, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocReportCount();
        int filteredRecords = aocFormService.getFilteredAocReportCount(searchValue, aocdocumentNumber, projectName, fromDate, toDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            try {
                Object[] row = (Object[]) obj;

                JSONObject json = new JSONObject();

                // Sr No
                if (isDesc) {
                    json.put("srNo", srNo++);
                } else {
                    json.put("srNo", srNo--);
                }

                // row[0]=id, row[1]=document_no, row[2]=hub_depo_name,
                // row[3]=client_project_name, row[4]=user_id,
                // row[5]=created_date, row[6]=flag_status(AOC), row[7]=flag_status(KOM)
                json.put("documentNo",
                        "<a href='oapForm.htm?act=aocStatus&id=" + (row[0] != null ? row[0] : "")
                        + "' class='fw-600 text-break gradient-text'>"
                        + (row[1] != null ? row[1] : "") + "</a>");

                json.put("hubDepoName", row[2] != null ? row[2].toString() : "");
                json.put("clientProjectName", row[3] != null ? row[3].toString() : "");
                json.put("userId", row[4] != null ? row[4].toString() : "");
                json.put("createdDate", row[5] != null ? row[5].toString() : "");

                // AOC flag status
                int flagStatusAOC = 0;
                try {
                    if (row[6] != null && !row[6].toString().trim().isEmpty()) {
                        flagStatusAOC = Integer.parseInt(row[6].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusAOC = 0;
                }

                // KOM flag status
                int flagStatusKOM = -1;
                try {
                    if (row[7] != null && !row[7].toString().trim().isEmpty()) {
                        flagStatusKOM = Integer.parseInt(row[7].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusKOM = -1;
                }

                // AOC Status Label
                String aocStatusLabel;
                if (flagStatusAOC == 0) {
                    aocStatusLabel = "Save As Draft";
                } else if (flagStatusAOC == 1) {
                    aocStatusLabel = "Pending to Approve";
                } else if (flagStatusAOC == 2) {
                    aocStatusLabel = "Recycle";
                } else if (flagStatusAOC == 3) {
                    aocStatusLabel = "Rejected";
                } else if (flagStatusAOC == 100) {
                    aocStatusLabel = "AOC Deleted";
                } else if (flagStatusAOC == 4 || flagStatusAOC == 6 || flagStatusAOC == 7
                        || flagStatusAOC == 11 || flagStatusAOC == 12 || flagStatusAOC == 13) {
                    aocStatusLabel = "Approved";
                } else {
                    aocStatusLabel = "";
                }
                json.put("flagStatusAOC", aocStatusLabel);

                // KOM Status Label
                String komStatusLabel;
                if (flagStatusKOM == 0) {
                    komStatusLabel = "Pending To Approve";
                } else if (flagStatusKOM == 1 || flagStatusKOM == 4) {
                    komStatusLabel = "Approved";
                } else if (flagStatusKOM == 2) {
                    komStatusLabel = "Recycle";
                } else if (flagStatusKOM == 3) {
                    komStatusLabel = "Reject";
                } else {
                    komStatusLabel = "";
                }
                json.put("flagStatusKOM", komStatusLabel);

                // Action Buttons
                String btnStyle = "style='min-width:120px; white-space:nowrap; text-align:center;'";
                String actionButtons = "";

                // AOC View — always shown
                actionButtons += "<a href='aocForm.htm?act=AllFormsView2&id="
                        + (row[0] != null ? row[0] : "")
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>";

                // Kick-Off View
                if (flagStatusAOC == 6 || flagStatusAOC == 7 || flagStatusAOC == 11
                        || flagStatusAOC == 12 || flagStatusAOC == 13 || flagStatusAOC == 14) {
                    actionButtons += "<a href='aocForm.htm?act=AllFormsView3&id="
                            + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Kick-Off View</a>";
                }

                // Deliverable View
                if (flagStatusAOC == 12) {
                    actionButtons += "<a href='oapForm.htm?act=DeliverableAocView&id="
                            + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' "
                            + "style='min-width:160px; white-space:nowrap; text-align:center;'"
                            + ">Deliverable View</a>";
                }

                // Rejected View
                if (flagStatusAOC == 13) {
                    actionButtons += "<a href='oapForm.htm?act=DeliverableAocView&id="
                            + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' "
                            + "style='min-width:140px; white-space:nowrap; text-align:center;'"
                            + ">Rejected View</a>";
                }

                json.put("action",
                        "<div class='d-flex align-items-center justify-content-center'>"
                        + actionButtons + "</div>");

                dataArray.put(json);

            } catch (Exception rowEx) {
                rowEx.printStackTrace();
            }
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

    public ModelAndView oapRightsReportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String oapdocumentNumber = request.getParameter("oapdocumentNumber");
        String projectName = request.getParameter("projectName");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");
        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "a.id";

        switch (orderColumnIndex) {
            case "0":
                orderColumn = "a.id";
                break;
            case "1":
                orderColumn = "a.document_no";
                break;
            case "2":
                orderColumn = "a.pcs_name";
                break;
            case "3":
                orderColumn = "a.project_name";
                break;
            case "4":
                orderColumn = "a.time_line_from_date";
                break;
            case "5":
                orderColumn = "a.time_line_to_date";
                break;
            case "6":
                orderColumn = "a.charging_rate_per_unit";
                break;
            case "7":
                orderColumn = "a.no_of_charger";
                break;
            case "8":
                orderColumn = "a.no_of_charge_points";
                break;
            case "10":
                orderColumn = "a.overall_station_capacity_kw ";
                break;
            case "11":
                orderColumn = "a.department";
                break;
            case "12":
                orderColumn = "a.created_date";
                break;
            case "13":
                orderColumn = "a.created_date";
                break;
            default:
                orderColumn = "a.id";
                break;
        }

        List list = oapFormService.getOapReportPagination(start, length, searchValue, oapdocumentNumber, projectName, fromDate, toDate, orderColumn, orderDir);
        int totalRecords = oapFormService.getTotalOapReportCount();
        int filteredRecords = oapFormService.getFilteredOapReportCount(searchValue, oapdocumentNumber, projectName, fromDate, toDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {

            try {
                Object[] row = (Object[]) obj;

                JSONObject json = new JSONObject();

                if (isDesc) {
                    json.put("srNo", srNo++);
                } else {
                    json.put("srNo", srNo--);
                }

                json.put(
                        "documentNo",
                        "<a href='oapForm.htm?act=oapStatus&id="
                        + (row[0] != null ? row[0] : "")
                        + "' class='fw-600 text-break gradient-text'>"
                        + (row[1] != null ? row[1] : "")
                        + "</a>"
                );

                json.put("pcsName", row[2] != null ? row[2].toString() : "");
                json.put("projectName", row[3] != null ? row[3].toString() : "");
                json.put("department", row[4] != null ? row[4].toString() : "");
                json.put("createdDate", row[5] != null ? row[5].toString() : "");
                json.put("timeLineFromDate", row[9] != null ? row[9].toString() : "");
                json.put("timeLineToDate", row[10] != null ? row[10].toString() : "");
                json.put("chargingRatePerUnit", row[11] != null ? row[11].toString() : "");
                json.put("noOfCharger", row[12] != null ? row[12].toString() : "");
                json.put("noOfChargePoints", row[13] != null ? row[13].toString() : "");
                json.put("overallStationCapacityKw", row[14] != null ? row[14].toString() : "");

                // ── OAP flag status ──────────────────────────────────────────
                int flagStatusOAP = 0;
                try {
                    if (row[6] != null && !row[6].toString().trim().isEmpty()) {
                        flagStatusOAP = Integer.parseInt(row[6].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusOAP = 0;
                }

                // ── CRC flag status ──────────────────────────────────────────
                int flagStatusCRC = -1;
                try {
                    if (row[7] != null && !row[7].toString().trim().isEmpty()) {
                        flagStatusCRC = Integer.parseInt(row[7].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusCRC = -1;
                }

                // ── Partially approve flag ───────────────────────────────────
                int flagStatusparta = 0;
                try {
                    if (row[8] != null && !row[8].toString().trim().isEmpty()) {
                        flagStatusparta = Integer.parseInt(row[8].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusparta = 0;
                }

                // ── OAP Status Label ─────────────────────────────────────────
                String statusLabel;
                if (flagStatusOAP == 0) {
                    statusLabel = "Save As Draft";
                } else if (flagStatusOAP == 1) {
                    statusLabel = "Pending to Approve";
                } else if (flagStatusOAP == 2) {
                    statusLabel = "Recycle";
                } else if (flagStatusOAP == 3) {
                    statusLabel = "Rejected";
                } else if (flagStatusOAP == 4 || flagStatusOAP == 6 || flagStatusOAP == 7
                        || flagStatusOAP == 11 || flagStatusOAP == 12 || flagStatusOAP == 13) {
                    statusLabel = "Approved";
                } else if (flagStatusOAP == 5) {
                    statusLabel = "Rejected CRC";
                } else if (flagStatusOAP == 14) {
                    statusLabel = "Approved";
                } else if (flagStatusOAP == 100) {
                    statusLabel = "OAP Deleted";
                } else {
                    statusLabel = "";
                }
                json.put("flagStatusOAP", statusLabel);

                // ── CRC Status Label ─────────────────────────────────────────
                String statusLabelCRC;
                if (flagStatusCRC == 0) {
                    statusLabelCRC = "Pending to Approve";
                } else if (flagStatusCRC == 10) {
                    statusLabelCRC = "ReWork";
                } else if (flagStatusCRC == 3) {
                    statusLabelCRC = "Rejected";
                } else if (flagStatusCRC == 4 || flagStatusCRC == 1) {
                    statusLabelCRC = "Approved";
                } else if (flagStatusCRC == 2 || flagStatusCRC == 800) {
                    statusLabelCRC = "Partially Approved";
                } else {
                    statusLabelCRC = "";
                }
                json.put("flagStatusCRC", statusLabelCRC);

                // ── Action Buttons ───────────────────────────────────────────
                String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
                String actionButtons = "";

                actionButtons += "<a href='oapForm.htm?act=AllFormsView&id=" + (row[0] != null ? row[0] : "")
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>";

                if (flagStatusOAP == 6 || flagStatusOAP == 7 || flagStatusOAP == 11
                        || flagStatusOAP == 12 || flagStatusOAP == 13 || flagStatusCRC == 2 || flagStatusCRC == 800) {
                    actionButtons += "<a href='oapForm.htm?act=AllFormsView1&id=" + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";
                }

                if (flagStatusparta == 12 || flagStatusparta == 13) {
                    actionButtons += "<a href='oapForm.htm?act=DesigncordinatorRejectView&id=" + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Deliverable View</a>";
                }

                json.put("action",
                        "<div class='d-flex align-items-center justify-content-center'>"
                        + actionButtons + "</div>");

                dataArray.put(json);

            } catch (Exception rowEx) {
                rowEx.printStackTrace();
            }
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

    public ModelAndView aocRightsReportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String aocdocumentNumber = request.getParameter("aocdocumentNumber");
        String projectName = request.getParameter("projectName");
        String fromDate = request.getParameter("open_from_date");
        String toDate = request.getParameter("open_to_date");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

// Column index mapping (matches the 15-column table after removing the duplicate header):
// 0  = Sr.No              -> a.id
// 1  = Document ID        -> a.document_no
// 2  = Hub Depo Name      -> a.hub_depo_name
// 3  = Project Name       -> a.client_project_name
// 4  = AOC From Date      -> a.zero_date
// 5  = AOC To Date        -> a.completion_date
// 6  = Time Period (Days) -> a.charging_rate_per_unit
// 7  = No Of Charger      -> a.no_of_charger
// 8  = No of Charge Points-> a.no_of_charge_points
// 9  = Overall Cap (kW)   -> a.overall_capacity
// 10 = Created By         -> a.user_id
// 11 = Created Date       -> a.created_date
// 12 = AOC Status         -> a.flag_status
// 13 = KOM Status         -> b.flag_status  (non-sortable by DB column; fallback to a.id)
// 14 = Action             -> non-sortable
        String orderColumn = "a.id";
        switch (orderColumnIndex) {
            case "0":
                orderColumn = "a.id";
                break;
            case "1":
                orderColumn = "a.document_no";
                break;
            case "2":
                orderColumn = "a.hub_depo_name";
                break;
            case "3":
                orderColumn = "a.client_project_name";
                break;
            case "4":
                orderColumn = "a.zero_date";
                break;
            case "5":
                orderColumn = "a.completion_date";
                break;
            case "6":
                orderColumn = "a.charging_rate_per_unit";
                break;
            case "7":
                orderColumn = "a.no_of_charger";
                break;
            case "8":
                orderColumn = "a.no_of_charge_points";
                break;
            case "9":
                orderColumn = "a.overall_capacity";
                break;
            case "10":
                orderColumn = "a.user_id";
                break;
            case "11":
                orderColumn = "a.created_date";
                break;
            case "12":
                orderColumn = "a.flag_status";
                break;
            default:
                orderColumn = "a.id";
                break;
        }

        List list = aocFormService.getAocReportPagination(start, length, searchValue, aocdocumentNumber, projectName, fromDate, toDate, orderColumn, orderDir);
        int totalRecords = aocFormService.getTotalAocReportCount();
        int filteredRecords = aocFormService.getFilteredAocReportCount(searchValue, aocdocumentNumber, projectName, fromDate, toDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            try {
                Object[] row = (Object[]) obj;

                // SQL column order:
                // row[0]  = a.id
                // row[1]  = a.document_no
                // row[2]  = a.hub_depo_name
                // row[3]  = a.client_project_name
                // row[4]  = a.user_id
                // row[5]  = a.created_date
                // row[6]  = a.flag_status
                // row[7]  = kom_flag_status  (IFNULL(b.flag_status,''))
                // row[8]  = a.zero_date
                // row[9]  = a.completion_date
                // row[10] = a.charging_rate_per_unit
                // row[11] = a.no_of_charger
                // row[12] = a.no_of_charge_points   <-- FIXED (was being skipped)
                // row[13] = a.overall_capacity       <-- FIXED (was reading row[12])
                JSONObject json = new JSONObject();

                if (isDesc) {
                    json.put("srNo", srNo++);
                } else {
                    json.put("srNo", srNo--);
                }

                json.put("documentNo",
                        "<a href='oapForm.htm?act=aocStatus&id=" + (row[0] != null ? row[0] : "")
                        + "' class='fw-600 text-break gradient-text'>"
                        + (row[1] != null ? row[1] : "") + "</a>");

                json.put("hubDepoName", row[2] != null ? row[2].toString() : "");
                json.put("clientProjectName", row[3] != null ? row[3].toString() : "");
                json.put("userId", row[4] != null ? row[4].toString() : "");
                json.put("createdDate", row[5] != null ? row[5].toString() : "");
                json.put("zeroDate", row[8] != null ? row[8].toString() : "");
                json.put("completionDate", row[9] != null ? row[9].toString() : "");
                json.put("chargingRatePerUnit", row[10] != null ? row[10].toString() : "");
                json.put("noOfCharger", row[11] != null ? row[11].toString() : "");
                json.put("noOfChargePoints", row[12] != null ? row[12].toString() : ""); // FIXED
                json.put("overallStationCapacityKw", row[13] != null ? row[13].toString() : ""); // FIXED

                // AOC Status
                int flagStatusAOC = 0;
                try {
                    if (row[6] != null && !row[6].toString().trim().isEmpty()) {
                        flagStatusAOC = Integer.parseInt(row[6].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusAOC = 0;
                }

                // KOM Status
                int flagStatusKOM = -1;
                try {
                    if (row[7] != null && !row[7].toString().trim().isEmpty()) {
                        flagStatusKOM = Integer.parseInt(row[7].toString().trim());
                    }
                } catch (NumberFormatException e) {
                    flagStatusKOM = -1;
                }

                String aocStatusLabel;
                if (flagStatusAOC == 0) {
                    aocStatusLabel = "Save As Draft";
                } else if (flagStatusAOC == 1) {
                    aocStatusLabel = "Pending to Approve";
                } else if (flagStatusAOC == 2) {
                    aocStatusLabel = "Recycle";
                } else if (flagStatusAOC == 3) {
                    aocStatusLabel = "Rejected";
                } else if (flagStatusAOC == 100) {
                    aocStatusLabel = "AOC Deleted";
                } else if (flagStatusAOC == 4 || flagStatusAOC == 6 || flagStatusAOC == 7
                        || flagStatusAOC == 11 || flagStatusAOC == 12 || flagStatusAOC == 13) {
                    aocStatusLabel = "Approved";
                } else {
                    aocStatusLabel = "";
                }
                json.put("flagStatusAOC", aocStatusLabel);

                String komStatusLabel;
                if (flagStatusKOM == 0) {
                    komStatusLabel = "Pending To Approve";
                } else if (flagStatusKOM == 1 || flagStatusKOM == 4) {
                    komStatusLabel = "Approved";
                } else if (flagStatusKOM == 2) {
                    komStatusLabel = "Recycle";
                } else if (flagStatusKOM == 3) {
                    komStatusLabel = "Reject";
                } else {
                    komStatusLabel = "";
                }
                json.put("flagStatusKOM", komStatusLabel);

                // Action buttons
                String btnStyle = "style='min-width:120px; white-space:nowrap; text-align:center;'";
                String actionButtons = "";

                actionButtons += "<a href='aocForm.htm?act=AllFormsView2&id="
                        + (row[0] != null ? row[0] : "")
                        + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">AOC View</a>";

                if (flagStatusAOC == 6 || flagStatusAOC == 7 || flagStatusAOC == 11
                        || flagStatusAOC == 12 || flagStatusAOC == 13 || flagStatusAOC == 14) {
                    actionButtons += "<a href='aocForm.htm?act=AllFormsView3&id="
                            + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">Kick-Off View</a>";
                }

                if (flagStatusAOC == 12) {
                    actionButtons += "<a href='oapForm.htm?act=DeliverableAocView&id="
                            + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' "
                            + "style='min-width:160px; white-space:nowrap; text-align:center;'"
                            + ">Deliverable View</a>";
                }

                if (flagStatusAOC == 13) {
                    actionButtons += "<a href='oapForm.htm?act=DeliverableAocView&id="
                            + (row[0] != null ? row[0] : "")
                            + "' class='btn theme-btn light-btn mx-1' "
                            + "style='min-width:140px; white-space:nowrap; text-align:center;'"
                            + ">Rejected View</a>";
                }

                json.put("action",
                        "<div class='d-flex align-items-center justify-content-center'>"
                        + actionButtons + "</div>");

                dataArray.put(json);

            } catch (Exception rowEx) {
                rowEx.printStackTrace();
            }
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

    public ModelAndView totalOapDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        if (Filter.equals("--select--")) {
            Filter = "";
        }
        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "department";
                    break;
                case "5":
                    orderColumn = "createdDate";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getOapPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalOapCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredOapCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel;
            if (flagStatus == 1) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            } else if (flagStatus == 5) {
                statusLabel = "Rejected CRC";
            } else if (flagStatus == 14) {
                statusLabel = " Approved";
            } else if (flagStatus == 8) {
                statusLabel = "Cancel Project Manager";
            } else if (flagStatus == 9) {
                statusLabel = "Reject Project Manager";
            } else if (flagStatus == 10) {
                statusLabel = "Close Project Manager";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView approvedOapDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        if (Filter.equals("--select--")) {
            Filter = "";
        }
        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "department";
                    break;
                case "5":
                    orderColumn = "createdDate";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getApprovedOapDashboadPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalApprovedOapDashboadCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredApprovedOapDashboadCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;
            int flagStatus1 = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7 || flagStatus == 5 || flagStatus == 8 || flagStatus == 9 || flagStatus == 10 || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            } else if (flagStatus1 == 1 || flagStatus1 == 12) {
                statusLabel = "Approved";
            } else {
                statusLabel = "";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView pendingOapDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        if (Filter.equals("--select--")) {
            Filter = "";
        }
        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "department";
                    break;
                case "5":
                    orderColumn = "createdDate";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getPendingOapPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalPendingOapDashboadCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredPendingOapDashboadCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;
            int flagStatus1 = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            if (flagStatus != 4 || flagStatus != 5 || flagStatus != 6
                    || flagStatus != 7 || flagStatus != 8
                    || flagStatus != 9 || flagStatus != 10
                    || flagStatus != 11 || flagStatus != 12
                    || flagStatus != 13 || flagStatus != 14 || flagStatus1 != 1 || flagStatus1 != 12) {

                statusLabel = "Pending";
            }

            System.out.println(statusLabel);

            json.put("flagStatus", statusLabel);
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

    public ModelAndView rejectedOapDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        if (Filter.equals("--select--")) {
            Filter = "";
        }
        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "department";
                    break;
                case "5":
                    orderColumn = "createdDate";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getRejectedOapPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalRejectedOapDashboadCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredRejectedOapDashboadCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            if (flagStatus == 3) {
                statusLabel = "Rejected";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView unfilledCrcPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        if (Filter.equals("--select--")) {
            Filter = "";
        }
        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "department";
                    break;
                case "5":
                    orderColumn = "createdDate";
                    break;
                case "6":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = oapFormService.getUnfilledCrcPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalUnfilledCrcCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredUnfilledCrcCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;
            int flagStatus1 = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            statusLabel = "UnfilLed CRC";

            json.put("flagStatus", statusLabel);
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

    public ModelAndView totalCRCtablePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userid";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;

                case "5":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = crcFormService.getTotalCrcPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = crcFormService.getTotalCrcCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = crcFormService.getFilteredTotalCrcCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

            String statusLabel = "";

            if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            } else if (flagStatus == 0) {
                statusLabel = "Pending to Approved";
            } else if (flagStatus == 2) {
                statusLabel = "Partially Approved";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 10) {
                statusLabel = "Recycle";
            } else if (flagStatus == 5) {
                statusLabel = "Cancel Project Manger";
            } else if (flagStatus == 6) {
                statusLabel = "Close Project Manger";
            } else if (flagStatus == 7) {
                statusLabel = "Rejected Project Manger";
            } else if (flagStatus == 800) {
                statusLabel = "Partially Approved";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView totalApprovedCrcPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userid";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;

                case "5":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = crcFormService.getTotalApprovedCrcPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = crcFormService.getTotalApprovedCrcCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = crcFormService.getFilteredTotalApprovedCrcCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

            String statusLabel = "";

            if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView pendingCRCDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userid";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;

                case "5":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = crcFormService.getPendingCRCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = crcFormService.getPendingCRCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = crcFormService.getFilteredPendingCRCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

            String statusLabel = "";

            if (flagStatus != 1 || flagStatus != 4) {
                statusLabel = "Pending";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView revisionCRCDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userid";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;

                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = crcFormService.getRevisionCRCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = crcFormService.getTotalRevisionCRCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = crcFormService.getFilterdRevisionCRCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

            String statusLabel = "";

            statusLabel = "Revision CRC";

            json.put("flagStatus", statusLabel);
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

    public ModelAndView particiallyDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userid";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;

                case "5":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = crcFormService.getParticiallyPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = crcFormService.getParticiallyCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = crcFormService.getFilteredParticiallyCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

            String statusLabel = "";

            if (flagStatus == 2 || flagStatus == 800) {
                statusLabel = "Partially Approved";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView rejecedCRCDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "userid";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;

                case "5":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = crcFormService.getRejectedPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = crcFormService.getRejectedCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = crcFormService.getFilteredRejectedCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            int flagStatus = row[5] != null ? ((Number) row[5]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

            String statusLabel = "";

            if (flagStatus == 3) {
                statusLabel = "CRC Rejected";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView totalAocDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "clientProjectName";
                    break;
                case "4":
                    orderColumn = "userId";
                    break;

                case "5":
                    orderColumn = "mobileNo";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = aocFormService.getTotalAocPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getTotalAocCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredTotalAocCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            int flagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            if (flagStatus == 1) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 3) {
                statusLabel = "Save As Draft";
            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView approvedAocDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "clientProjectName";
                    break;
                case "4":
                    orderColumn = "userId";
                    break;

                case "5":
                    orderColumn = "mobileNo";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = aocFormService.getTotalApprovedPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getTotalApprovedAocCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredTotalApprovedAocCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            int flagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView pendingAOCDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "clientProjectName";
                    break;
                case "4":
                    orderColumn = "userId";
                    break;

                case "5":
                    orderColumn = "mobileNo";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;

                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = aocFormService.getTotalPendingAOCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getTotalPendingAOCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredTotalPendingAOCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            statusLabel = "Pending";

            json.put("pending", statusLabel);
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

    public ModelAndView rejectedAOCDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "clientProjectName";
                    break;
                case "4":
                    orderColumn = "userId";
                    break;

                case "5":
                    orderColumn = "mobileNo";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;

                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = aocFormService.getRejectedAOCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getRejectedAOCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredRejectedAOCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            statusLabel = "Rejected";

            json.put("Rejected", statusLabel);
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

    public ModelAndView unfieldKOMDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "clientProjectName";
                    break;
                case "4":
                    orderColumn = "userId";
                    break;

                case "5":
                    orderColumn = "mobileNo";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;

                default:
                    orderColumn = "id";
                    break;

            }
        }
        List list = aocFormService.getUnfieldKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getUnfieldKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredUnfieldKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            statusLabel = "Unfielled KOM";

            json.put("status", statusLabel);
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

    public ModelAndView totalKomDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubLocation";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;
                case "5":
                    orderColumn = "dateTime";
                    break;
                case "6":
                    orderColumn = "projectName";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        List list = kickOffFormService.getTotalKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = kickOffFormService.getTotalKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = kickOffFormService.getFilteredTotalKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            String dateTime = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("projectName", projectName);
            json.put("designation", designation);
            json.put("dateTime", dateTime);

            String statusLabel = "";

            if (flagStatus == 0) {
                statusLabel = "Pending To Approve";
            } else if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Reject";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView totalApprovalDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubLocation";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;
                case "5":
                    orderColumn = "dateTime";
                    break;
                case "6":
                    orderColumn = "projectName";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        List list = kickOffFormService.getTotalApproveKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = kickOffFormService.getTotalApproveKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = kickOffFormService.getFilteredTotalApproveKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            String dateTime = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("projectName", projectName);
            json.put("designation", designation);
            json.put("dateTime", dateTime);

            String statusLabel = "";

            if (flagStatus == 1 || flagStatus == 4) {
                statusLabel = "Approved";
            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView pendingKOMDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubLocation";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;
                case "5":
                    orderColumn = "dateTime";
                    break;
                case "6":
                    orderColumn = "projectName";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        
        List list = kickOffFormService.getPendingKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = kickOffFormService.getPendingKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = kickOffFormService.getFilteredPendingKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            String dateTime = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("projectName", projectName);
            json.put("designation", designation);
            json.put("dateTime", dateTime);

            String statusLabel = "";

            if (flagStatus != 1 && flagStatus != 4) {
                statusLabel = "pending";
            } else {
                statusLabel = "approved";
            }

            json.put("flagStatus", statusLabel);
            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();

        responseJson.put(
                "draw", draw);
        responseJson.put(
                "recordsTotal", totalRecords);
        responseJson.put(
                "recordsFiltered", filteredRecords);
        responseJson.put(
                "data", dataArray);
        response.setContentType(
                "application/json");
        response.setCharacterEncoding(
                "UTF-8");
        response.getWriter()
                .write(responseJson.toString());

        return null;

    }

    public ModelAndView rejectedKOMDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubLocation";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "designation";
                    break;
                case "5":
                    orderColumn = "dateTime";
                    break;
                case "6":
                    orderColumn = "projectName";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        List list = kickOffFormService.getRejectedKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = kickOffFormService.getRejectedKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = kickOffFormService.getFilteredRejectedKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            String dateTime = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("projectName", projectName);
            json.put("designation", designation);
            json.put("dateTime", dateTime);

            String statusLabel = "";

            if (flagStatus == 3) {
                statusLabel = "Reject";

            }

            json.put("flagStatus", statusLabel);
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

    public ModelAndView monthWiseGraphOapDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

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
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "pcsName";
                    break;
                case "3":
                    orderColumn = "projectName";
                    break;
                case "4":
                    orderColumn = "department";
                    break;
                case "5":
                    orderColumn = "createdDate";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        String StartDate = "";
        String EndDate = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        if (MonthName1 != null && !MonthName1.trim().isEmpty()) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

                YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
                MonthName = yearMonth.format(outputFormatter);

                SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
                Date date = sdf.parse(MonthName);

                Calendar startCal = Calendar.getInstance();
                startCal.setTime(date);
                startCal.set(Calendar.DAY_OF_MONTH, 1);
                StartDate = new SimpleDateFormat("dd/MM/yyyy").format(startCal.getTime());

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(date);
                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                EndDate = new SimpleDateFormat("dd/MM/yyyy").format(endCal.getTime());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List list = oapFormService.getMonthWiseGraphPagination(start, length, searchValue, StartDate, EndDate, orderColumn, orderDir);

        int totalRecords = oapFormService.getMonthWiseGraphCount(StartDate, EndDate);
        int filteredRecords = oapFormService.getFilteredMonthWiseGraphCount(searchValue, StartDate, EndDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons
                    = "<a href='oapForm.htm?act=AllFormsView&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">OAP View</a>"
                    + "<a href='oapForm.htm?act=AllFormsView1&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">CRC View</a>";

            json.put("action", "<div class='d-flex align-items-center justify-content-center'>" + actionButtons + "</div>");

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

    public ModelAndView monthWiseGraphAOCPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

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
                case "0":
                    orderColumn = "id";
                    break;
                case "1":
                    orderColumn = "documentNo";
                    break;
                case "2":
                    orderColumn = "hubDepoName";
                    break;
                case "3":
                    orderColumn = "clientProjectName";
                    break;
                case "4":
                    orderColumn = "userId";
                    break;
                case "5":
                    orderColumn = "mobileNo";
                    break;
                case "6":
                    orderColumn = "createdDate";
                    break;
                case "7":
                    orderColumn = "flagStatus";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        String StartDate = "";
        String EndDate = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        if (MonthName1 != null && !MonthName1.trim().isEmpty()) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);

                YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
                MonthName = yearMonth.format(outputFormatter);

                SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
                Date date = sdf.parse(MonthName);

                Calendar startCal = Calendar.getInstance();
                startCal.setTime(date);
                startCal.set(Calendar.DAY_OF_MONTH, 1);
                StartDate = new SimpleDateFormat("dd/MM/yyyy").format(startCal.getTime());

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(date);
                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                EndDate = new SimpleDateFormat("dd/MM/yyyy").format(endCal.getTime());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List list = aocFormService.getMonthWiseGraphAOCPagination(start, length, searchValue, StartDate, EndDate, orderColumn, orderDir);
        int totalRecords = aocFormService.getMonthWiseGraphAOCCount(StartDate, EndDate);
        int filteredRecords = aocFormService.getFilteredMonthWiseGraphAOCCount(searchValue, StartDate, EndDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "asc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (filteredRecords - start) : (start + 1);

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String userId = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";
            int flagStatus = row[7] != null ? ((Number) row[7]).intValue() : -1;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo-- : srNo++);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("userId", userId);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

            String statusLabel = "";

            if (flagStatus == 1) {
                statusLabel = "Pending to Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Recycle";
            } else if (flagStatus == 3) {
                statusLabel = "Rejected";
            } else if (flagStatus == 3) {
                statusLabel = "Save As Draft";
            } else if (flagStatus == 4 || flagStatus == 6 || flagStatus == 7
                    || flagStatus == 11 || flagStatus == 12 || flagStatus == 13) {
                statusLabel = "Approved";
            }

            json.put("flagStatus", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons
                    = "<a href='aocForm.htm?act=AllFormsView2&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + "> AOC View</a>"
                    + "<a href='aocForm.htm?act=AllFormsView3&id=" + id + "' class='btn theme-btn light-btn mx-1' " + btnStyle + "> Kick-Off View</a>";

            json.put("action", "<div class='d-flex align-items-center justify-content-center'>" + actionButtons + "</div>");

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

    public ModelAndView projectcordTotalPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "b.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "b.id";
                    break;
                case "1":
                    orderColumn = "b.documentNo";
                    break;
                case "2":
                    orderColumn = "b.pcsName";
                    break;
                case "3":
                    orderColumn = "b.userid";
                    break;
                case "4":
                    orderColumn = "b.designation";
                    break;
                default:
                    orderColumn = "b.id";
                    break;
            }
        }

        List list = oapFormService.getProjectCoordinatorGraphUserPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getProjectCoordinatorGraphUserCount(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getProjectCoordinatorGraphUserCount(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int crcId = row[1] != null ? ((Number) row[1]).intValue() : 0;
            String documentNo = row[2] != null ? row[2].toString() : "";
            String pcsName = row[3] != null ? row[3].toString() : "";
            String userid = row[4] != null ? row[4].toString() : "";
            String designation = row[5] != null ? row[5].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);

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

    public ModelAndView projectcordTotalPagination1Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = myDateObj.minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "d.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "d.id";
                    break;
                case "1":
                    orderColumn = "d.documentNo";
                    break;
                case "2":
                    orderColumn = "d.hubLocation";
                    break;
                case "3":
                    orderColumn = "d.userId";
                    break;
                case "4":
                    orderColumn = "d.designation";
                    break;
                default:
                    orderColumn = "d.id";
                    break;
            }
        }

        List list = oapFormService.getProjectCoordinatorGraphUser1Pagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getProjectCoordinatorGraphUser1Count(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getProjectCoordinatorGraphUser1Count(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int komId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String userId = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("userId", userId);
            json.put("designation", designation);

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

    public ModelAndView projectcordPendingCRCPagination1Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        String ContactPerson = request.getParameter("contact");
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.department";
                    break;
                case "5":
                    orderColumn = "a.createdDate";
                    break;
                case "6":
                    orderColumn = "a.designation";
                    break;

                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = oapFormService.getProjectCoorGraphUserPendingCRCPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getProjectCoorGraphUserPendingCRCCount(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getProjectCoorGraphUserPendingCRCCount(searchValue, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int oapId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            String designation = row[7] != null ? row[7].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("designation", designation);

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

    public ModelAndView projectcordPendingKOMPagination1Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        String ContactPerson = request.getParameter("contact");
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;

                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.createdDate";
                    break;
                case "5":
                    orderColumn = "a.designation";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = aocFormService.getProjectCoorGraphUserPendingKOMPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getProjectCoorGraphUserPendingKOMCount(ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getProjectCoorGraphUserPendingKOMCount(searchValue, ContactPerson, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int aocId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String createdDate = row[4] != null ? row[4].toString() : "";
            String designation = row[5] != null ? row[5].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("createdDate", createdDate);
            json.put("designation", designation);

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

    public ModelAndView projectManagerTotalCRCPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "b.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "b.id";
                    break;
                case "1":
                    orderColumn = "b.documentNo";
                    break;
                case "2":
                    orderColumn = "b.pcsName";
                    break;
                case "3":
                    orderColumn = "b.userid";
                    break;
                case "4":
                    orderColumn = "b.designation";
                    break;
                case "5":
                    orderColumn = "b.projectEngineer";
                    break;
                default:
                    orderColumn = "b.id";
                    break;
            }
        }

        List list = oapFormService.getProjectManagerTotalGraphUserPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getProjectManagerTotalGraphUserCount(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getProjectManagerTotalGraphUserCount(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int crcId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String userid = row[3] != null ? row[3].toString() : "";
            String designation = row[4] != null ? row[4].toString() : "";
            String projectEngineer = row[5] != null ? row[5].toString() : "";
            int oapId = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("userid", userid);
            json.put("designation", designation);
            json.put("projectEngineer", projectEngineer);

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

    public ModelAndView projectManagerTotalKOMPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "d.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "d.id";
                    break;
                case "1":
                    orderColumn = "d.documentNo";
                    break;
                case "2":
                    orderColumn = "d.hubLocation";
                    break;
                case "3":
                    orderColumn = "d.userId";
                    break;
                case "4":
                    orderColumn = "d.projectName";
                    break;
                default:
                    orderColumn = "d.id";
                    break;
            }
        }

        List list = aocFormService.getProjectManagerTotalGraphUser1Pagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getProjectManagerTotalGraphUser1Count(ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getProjectManagerTotalGraphUser1Count(searchValue, ContactPerson, Value, Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int kickId = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubLocation = row[2] != null ? row[2].toString() : "";
            String userId = row[3] != null ? row[3].toString() : "";
            String projectName = row[4] != null ? row[4].toString() : "";
            int aocId = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubLocation", hubLocation);
            json.put("userId", userId);
            json.put("projectName", projectName);

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

    public ModelAndView monthWiseClickNoOfChargerDetailsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.department";
                    break;
                case "5":
                    orderColumn = "a.createdDate";
                    break;
                case "6":
                    orderColumn = "a.noOfCharger";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String startDatee = "";
        String endDatee = "";
        String MonthName = "";

        String MonthName1 = request.getParameter("label");

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
            YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
            MonthName = yearMonth.format(outputFormatter);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String StartDate = startDatee;
        String EndDate = endDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = oapFormService.getNoOfChargerDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getNoOfChargerDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredNoOfChargerDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            String noOfChargers = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("noofchargers", noOfChargers);

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

    public ModelAndView ClickTotalChargerCapacityDetailsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.department";
                    break;
                case "5":
                    orderColumn = "a.createdDate";
                    break;
                case "6":
                    orderColumn = "a.totalChargerCapacity";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String startDatee = "";
        String endDatee = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
            YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
            MonthName = yearMonth.format(outputFormatter);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String StartDate = startDatee;
        String EndDate = endDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = oapFormService.getTotalChargerCapacityDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalChargerCapacityDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredTotalChargerCapacityDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            String totalChargerCapacity = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("totalChargerCapacity", totalChargerCapacity);

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

    public ModelAndView monthWiseClickTotalKwRatingDetailsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.pcsName";
                    break;
                case "3":
                    orderColumn = "a.projectName";
                    break;
                case "4":
                    orderColumn = "a.department";
                    break;
                case "5":
                    orderColumn = "a.createdDate";
                    break;
                case "6":
                    orderColumn = "a.totalKwRating";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String startDatee = "";
        String endDatee = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
            YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
            MonthName = yearMonth.format(outputFormatter);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String StartDate = startDatee;
        String EndDate = endDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = oapFormService.getTotalKwRatingDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int totalRecords = oapFormService.getTotalKwRatingDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = oapFormService.getFilteredTotalKwRatingDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String pcsName = row[2] != null ? row[2].toString() : "";
            String projectName = row[3] != null ? row[3].toString() : "";
            String department = row[4] != null ? row[4].toString() : "";
            String createdDate = row[5] != null ? row[5].toString() : "";
            String totalKwRating = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("pcsName", pcsName);
            json.put("projectName", projectName);
            json.put("department", department);
            json.put("createdDate", createdDate);
            json.put("totalKwRating", totalKwRating);

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

    public ModelAndView monthWiseClickAocNoOfChargerDetailsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;
                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.noOfCharger";
                    break;
                case "5":
                    orderColumn = "a.mobileNo";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String startDatee = "";
        String endDatee = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
            YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
            MonthName = yearMonth.format(outputFormatter);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String StartDate = startDatee;
        String EndDate = endDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = aocFormService.getAocNoOfChargerDetailsOapPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getAocNoOfChargerDetailsOapCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredAocNoOfChargerDetailsOapCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String noOfCharger = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("noOfCharger", noOfCharger);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

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

    public ModelAndView monthWiseClickAocTotalChargerCapacityPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;
                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.totalChargerCapacity";
                    break;
                case "5":
                    orderColumn = "a.mobileNo";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String startDatee = "";
        String endDatee = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
            YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
            MonthName = yearMonth.format(outputFormatter);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String StartDate = startDatee;
        String EndDate = endDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = aocFormService.getAocTotalChargerCapacityPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getAocTotalChargerCapacityCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredAocTotalChargerCapacityCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String totalChargerCapacity = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("totalChargerCapacity", totalChargerCapacity);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

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

    public ModelAndView monthWiseClickAocTotalKwRatingPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        String orderColumn = "a.id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "0":
                    orderColumn = "a.id";
                    break;
                case "1":
                    orderColumn = "a.documentNo";
                    break;
                case "2":
                    orderColumn = "a.hubDepoName";
                    break;
                case "3":
                    orderColumn = "a.clientProjectName";
                    break;
                case "4":
                    orderColumn = "a.totalKwRating";
                    break;
                case "5":
                    orderColumn = "a.mobileNo";
                    break;
                case "6":
                    orderColumn = "a.createdDate";
                    break;
                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Fromdate = outputFormat.format(inputFormat.parse(Fromdate));
            }
            if (!Todate.isEmpty()) {
                Todate = outputFormat.format(inputFormat.parse(Todate));
            }
        } catch (Exception e) {
        }

        String startDatee = "";
        String endDatee = "";
        String MonthName = "";
        String MonthName1 = request.getParameter("label");

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
            YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
            MonthName = yearMonth.format(outputFormatter);

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
            Date date = sdf.parse(MonthName);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(date);
            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
            startDatee = new SimpleDateFormat("dd/MM/yyyy").format(startCalendar.getTime());

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(date);
            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDatee = new SimpleDateFormat("dd/MM/yyyy").format(endCalendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        String StartDate = startDatee;
        String EndDate = endDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }

        try {
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (Filter.equals("last-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(30).format(myFormatObj);
            } else if (Filter.equals("last-week")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(7).format(myFormatObj);
            } else if (Filter.equals("last-year")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(365).format(myFormatObj);
            } else if (Filter.equals("last-6-month")) {
                formattedDate = LocalDateTime.now().format(myFormatObj);
                formattedStartDate = LocalDateTime.now().minusDays(183).format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = aocFormService.getAocTotalKwRatingPagination(start, length, searchValue, orderColumn, orderDir, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int totalRecords = aocFormService.getAocTotalKwRatingCount(StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        int filteredRecords = aocFormService.getFilteredAocTotalKwRatingCount(searchValue, StartDate, EndDate, Filter, formattedDate, formattedStartDate);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo = 0;
        if (filteredRecords > 0) {
            srNo = isDesc ? (start + 1) : (filteredRecords - start);
        }

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String documentNo = row[1] != null ? row[1].toString() : "";
            String hubDepoName = row[2] != null ? row[2].toString() : "";
            String clientProjectName = row[3] != null ? row[3].toString() : "";
            String totalKwRating = row[4] != null ? row[4].toString() : "";
            String mobileNo = row[5] != null ? row[5].toString() : "";
            String createdDate = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("documentNo", documentNo);
            json.put("hubDepoName", hubDepoName);
            json.put("clientProjectName", clientProjectName);
            json.put("totalKwRating", totalKwRating);
            json.put("mobileNo", mobileNo);
            json.put("createdDate", createdDate);

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
