/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public abstract class UserMasterAbstract extends CustomAbstract {

//    protected static final Logger logger = Logger.getLogger(UserMasterAbstract.class);
    protected static final String PATH = "User" + File.separator;
    protected static final String HOME_PAGE = PATH + "Dashboard";
    protected static final String Direectory = "Dashboard" + File.separator;
    protected static final String HOME_PAGE_2 = Direectory + "HrDashBoard";

    protected void showUserImage(HttpServletRequest request, HttpSession session, UserMaster user) {

        String userName = user.getLoginName();//user name for get userDirectory.
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
        session.setAttribute("profilePicturePath", profilePicturePath);

    }

    public void getRights(HttpServletRequest request, HttpSession session, UserMaster user) throws Exception {
        RightMaster rightMaster = rightService.read(user.getLoginName());
        int count = 0;
        ArrayList arr = new ArrayList();
        StringTokenizer st = new StringTokenizer(rightMaster.getRight(), "  ");
        while (st.hasMoreTokens()) {
            arr.add(count, st.nextToken());
            count++;
        }
        request.setAttribute("wright", arr);
        session.setAttribute("wright", arr);

    }
    
    public void addUserRight(HttpServletRequest request, UserMaster user) {
        HttpSession session = request.getSession();
      //  UserRights userRights = new UserRights();
      //  userRights.setUsername(user.getLoginName());
        List list = userRightsService.readByUserRight(user.getLoginName());
        if (!list.isEmpty()) {
            session.setAttribute("userRight", list.get(0));
        }
    }

    public String getCurrentIp(HttpServletRequest request, HttpSession session) throws Exception {
        InetAddress myIPvlaue = InetAddress.getLocalHost();
        myIp = (String)request.getRemoteAddr();
        //myIp = "" + myIPvlaue;
        return myIp;
    }

}
