/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CorporateVideo;

import com.bul.zydex.model.CorporateVideo;
import com.bul.zydex.model.ThoughtMaster;
import com.bul.zydex.model.UserMaster;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishi
 */
public class CorporateVideoController extends CorporateVideoAbstract {

    public ModelAndView submitCorporateUploadVideo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        String desc = request.getParameter("videoDesc");
        CorporateVideo corporateVideo = new CorporateVideo();
        corporateVideo.setCreatedBy(user.getId());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        corporateVideo.setCreatedDate(dtf.format(localDate));
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("uploadVideo");
        String fileLocationURL =  getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CorporateVideo" + File.separator;
        String fileLocationURL1 =   "StorageYard"
                + File.separator + "CorporateVideo" + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            File corporateVideoFile = new File(fileLocationURL);
            if (corporateVideoFile.exists() && corporateVideoFile.listFiles().length > 0) {
                File[] corporateVideoArray = corporateVideoFile.listFiles();
                corporateVideoArray[0].delete();
            }
            try {
                File file2 = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                corporateVideo.setCorporateVideoPath("" + file2);
            } catch (Exception e) {

            }
        }
        corporateVideo.setCreatedBy(user.getId());
        corporateVideo.setCreatedDate(dtf.format(localDate));
        corporateVideo.setDisc(desc);
        List<CorporateVideo> l = (List<CorporateVideo>) corporateVideoService.read();
        if (l.size() > 0 && !l.isEmpty()) {
            for (int i = 0; i < l.size(); i++) {
                CorporateVideo cv = l.get(i);
                corporateVideoService.delete(cv.getId());
            }
        }
        corporateVideoService.create(corporateVideo);
        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
        mv.getModelMap().put("videoList", l1);
        request.setAttribute(
                "successMessage",
                "Information : Video is Uploaded Successfully.");
        mv.setViewName(
                "Thought/deshbordsetting1");
        return mv;
    }

}
