/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.LiveTender;
import com.bul.zydex.model.OmsMaster;
import com.bul.zydex.model.VendorMaster;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class LogInController extends LogInAbstract {

    public ModelAndView firstStep(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String PR_REDIRECT_NO = request.getParameter("prNo");
        if (PR_REDIRECT_NO != null) {
            PR_REDIRECT_NO = PR_REDIRECT_NO.trim();
        } else {
            PR_REDIRECT_NO = "";
        }
        request.setAttribute("PR_REDIRECT_NO", PR_REDIRECT_NO);

        mv = loginClick(request, response);
//        mv.setViewName("Common/BrowserDetail");
        return mv;
    }

    public ModelAndView browserDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = loginClick(request, response);
        return mv;
    }

    public ModelAndView loginClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        String PR_REDIRECT_NO = (String) request.getAttribute("PR_REDIRECT_NO");
        request.setAttribute("PR_REDIRECT_NO", PR_REDIRECT_NO);

        if (null == session) {
            mv = redirectToLogin(request, response);
        } else {
            mv = dashboard(request, response);
        }
        return mv;
    }

    private ModelAndView redirectToLogin(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        UserMaster user = new UserMaster();
        mv.getModelMap().put("userMaster", user);
//        request.setAttribute("lockCounter", 0);

        List list = tenderMasterService.readOpenLiveTender();
        mv.getModelMap().put("list", list);
       
        String PR_REDIRECT_NO = (String) request.getAttribute("PR_REDIRECT_NO");
        request.setAttribute("PR_REDIRECT_NO", PR_REDIRECT_NO);
      
        mv.setViewName(LOGIN_PAGE);
//         mv.setViewName("User/Login");
        return mv;
    }

    public ModelAndView dashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");

        if (null == user) {
            mv = redirectToLogin(request, response);
        } else {
            addUser(request, user);
//            mv.setViewName("forward:userMaster.htm?act=goToDashboard");
            mv.setViewName("forward:userMaster.htm?act=goToHomePage");
        }
        return mv;
    }

    public ModelAndView home(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        ModelAndView mv;
        if (null != session) {
            session.invalidate();
        }
        session = request.getSession(true);
        UserMaster user = (UserMaster) request.getAttribute("user");
        session.setAttribute("user", user);
//        if (request.getParameter("rememberMe") != null) {
//            setCookies(request, response);
//        }
        mv = dashboard(request, response);

//        log(request, ActionType.LOGIN.toString(),
//                "The user is log in to system.");
        return mv;
    }

    public ModelAndView loginSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster user = new UserMaster();
        BindException errors = new BindException(user, "userMaster");
        bind(request, user);
        user.setPassword(user.getPassword());

        UserMaster user3;
        String login_name = user.getLoginName();
        UserMaster user1 = userMasterService.read(login_name);
//   ===== reCAPTCHA v3 verification =====
        String recaptchaToken = request.getParameter("g-recaptcha-response");
        if (!isRecaptchaValid(recaptchaToken)) {
            request.setAttribute("faliureMessage", "Captcha verification failed. Please try again.");
            mv = redirectToLogin(request, response);
            return mv;
        }
//         ===== end reCAPTCHA v3 verification =====
        if (user1.getUserType() == 0) {
            EmployeeMaster employeeMaster = employeeMasterService.read(login_name);
            try {
                if (employeeMaster.getdRow().equals("Y")) {
                    request.setAttribute("faliureMessage",
                            "Username not exist.");
                    mv = redirectToLogin(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("faliureMessage",
                        "Username not exist.");
                mv = redirectToLogin(request, response);
                return mv;

            }
        }

        if (user1.getUserType() == 2) {
            login_name = user1.getVendorCode();
        }

        VendorMaster vendorMaster = vendorMasterService.readByRegNo(login_name);
        UserMaster u1 = userMasterService.read(login_name);

        int flag = vendorMaster.getFlag();
        String vendorId = u1.getLoginName();

        if (user.getLoginName().equals("") & user.getPassword().equals("")) {
            request.setAttribute("faliureMessage",
                    "Username or Password is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("user", user);
            mv = redirectToLogin(request, response);
        } else {
            List<?> tempList = userMasterService.read(user);

            if (null == tempList || tempList.isEmpty()) {
                request.setAttribute("faliureMessage", "Error : Username or Password is not valid or exist.");
                mv = redirectToLogin(request, response);

                int userTry = user.getUserTry();
                userTry++;
                if (userTry == 5) {
                    userMasterService.updateLock(user.getLoginName(), userTry);
                } else {
                    userMasterService.updateUserTry(user.getLoginName(), userTry);
                }
            } else if (u1.getUserType() == 0 || (u1.getLoginName().equals("Admin")) || (u1.getLoginName().equals("admin"))) {
                int lock = user.getLock1();

                if (lock == 0) {
                    userMasterService.updateUserTry1(user.getLoginName());

                    user3 = (UserMaster) tempList.get(0);
                    request.setAttribute("user", user3);
                    mv = home(request, response);
                } else {
                    request.setAttribute("faliureMessage",
                            "Error : You account is lock");
                    mv = redirectToLogin(request, response);

                }
            } else if ((vendorMaster.getFlag() == 1 || vendorMaster.getFlag() == 2)) {
                int lock = user.getLock1();

                if (lock == 0) {
                    userMasterService.updateUserTry1(user.getLoginName());

                    user3 = (UserMaster) tempList.get(0);
                    request.setAttribute("user", user3);
                    mv = home(request, response);
                } else {
                    request.setAttribute("faliureMessage",
                            "Error : You account is lock");
                    mv = redirectToLogin(request, response);

                }
            } else if (user1.getUserType() == 3) {

                userMasterService.updateUserTry1(user.getLoginName());

                user3 = (UserMaster) tempList.get(0);
                request.setAttribute("user", user3);
                mv = home(request, response);

            } else {
                request.setAttribute("faliureMessage",
                        "Error : Account is Not Activated..");
                mv = redirectToLogin(request, response);
            }

        }

        return mv;
    }

    private boolean isRecaptchaValid(String token) {
        if (token == null || token.trim().isEmpty()) {
            return true;
        }

        String secretKey = System.getenv("RECAPTCHA_SECRET_KEY");
        if (secretKey == null || secretKey.trim().isEmpty()) {
            secretKey = "6LcA1WwtAAAAAGDGD7gKz1rTBVUPeDwVG6hrClyN"; // TEMP fallback
        }

        java.io.BufferedReader reader = null;
        java.io.OutputStream os = null;
        try {
            String params = "secret=" + java.net.URLEncoder.encode(secretKey, "UTF-8")
                    + "&response=" + java.net.URLEncoder.encode(token, "UTF-8");

            java.net.URL url = new java.net.URL("https://www.google.com/recaptcha/api/siteverify");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            os = conn.getOutputStream();
            os.write(params.getBytes("UTF-8"));
            os.flush();

            int status = conn.getResponseCode();
            java.io.InputStream is = (status >= 200 && status < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            reader = new java.io.BufferedReader(new java.io.InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String body = sb.toString();
            System.out.println("[reCAPTCHA] Response: " + body);

            boolean success = body.contains("\"success\": true") || body.contains("\"success\":true");

            double score = 0.0;
            java.util.regex.Matcher scoreMatcher
                    = java.util.regex.Pattern.compile("\"score\"\\s*:\\s*([0-9.]+)").matcher(body);
            if (scoreMatcher.find()) {
                score = Double.parseDouble(scoreMatcher.group(1));
            }

            double MIN_SCORE = 0.5;
            return success && score >= MIN_SCORE;

        } catch (Exception e) {
            System.out.println("[reCAPTCHA] Verification exception: " + e.getMessage());
            return true;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception ignored) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    public ModelAndView saveOmsData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        response.setContentType("application/json");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        try {
            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.getWriter().write(
                        "{\"status\":\"FAILED\",\"message\":\"Missing or Invalid Authorization Header\"}"
                );
                return null;
            }

            String token = authHeader.substring("Bearer ".length()).trim();

            String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTc2OTc3MDExMiwianRpIjoiMTc1YzhlMTgtM2RkZC00ZDg4LTlkN2ItNzQ2MGUxOWFlZTFhIiwidHlwZSI6ImFjY2VzcyIsImlkZW50aXR5IjoiZGV2LnNhbWlyX2J1bHdvcmtzQHN1cmVwYXNzLmlvIiwibmJmIjoxNzY5NzcwMTEyLCJleHAiOjI0MDA0OTAxMTIsImVtYWlsIjoic2FtaXJfYnVsd29ya3NAc3VyZXBhc3MuaW8iLCJ0ZW5hbnRfaWQiOiJtYWluIiwidXNlcl9jbGFpbXMiOnsic2NvcGVzIjpbINvzZxIiXX19.oO-Vbw4-y1KsZt7aRdgCEYlcSMBxXOytBUHpxBCvMgc";
            if (!validToken.equals(token)) {
                response.getWriter().write(
                        "{\"status\":\"FAILED\",\"message\":\"Invalid Token\"}"
                );
                return null;
            }
            if (validToken.equals(token)) {
                StringBuilder sb = new StringBuilder();
                String line = null;
                BufferedReader reader = request.getReader();

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                String jsonString = sb.toString();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(jsonString);

                String omsTicketNo = rootNode.path("omsTicketNo").asText().trim();
                String omsPrId = rootNode.path("omsPrId").asText().trim();

                if (omsTicketNo == null || omsTicketNo.isEmpty()) {
                    response.getWriter().write(
                            "{\"status\":\"FAILED\",\"message\":\"Oms Ticket No Missing\"}"
                    );
                    return null;
                }

                OmsMaster omsMaster1 = omsMasterService.readByTickitNoAndPrId(omsTicketNo, omsPrId);

                if (omsMaster1 != null) {
                    response.getWriter().write(
                            "{\"status\":\"FAILED\",\"message\":\"Ticket ID: " + omsTicketNo + " with PR ID: " + omsPrId + " already exists\"}"
                    );
                    return null;
                }

                try {
                    OmsMaster omsMaster = new OmsMaster();
                    omsMaster.setTicketId(omsTicketNo);
                    omsMaster.setOmsPrId(omsPrId);
                    omsMaster.setDateTime(formattedDateTime);
                    omsMaster.setPrFlag(0);
                    omsMasterService.create(omsMaster);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.getWriter().write("{\"status\":\"SUCCESS\",\"message\":\"Ticket ID Generated Successfully\"}");
            } else {
                response.getWriter().write("{\"status\":\"FAILED\",\"message\":\"Username or Password Invalid\"}");
                return null;
            }
        } catch (Exception e) {
            response.getWriter().write("{\"status\":\"ERROR\",\"message\":\"Server Error\"}");
        }

        return null;
    }

}
