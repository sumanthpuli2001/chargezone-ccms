/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.DeclarationLetter;

import com.bul.zydex.model.DeclarationLetter;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class DeclarationLetterController extends DeclarationLetterAbstract {

    public ModelAndView showlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = declarationLetterService.read();

        int valueFlag = 1;
        String storagePath = request.getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "DeclarationLetter" + File.separator;

        DeclarationLetter existingLetter = declarationLetterService.getSingle();
        if (existingLetter != null && existingLetter.getDeclarationLetter() != null) {
            File file = new File(storagePath + existingLetter.getDeclarationLetter());
            if (file.exists()) {
                valueFlag = 0;
            }
        }

        request.setAttribute("list", list);
        mv.getModelMap().put("Value", valueFlag);
        mv.setViewName("DeclarationLetter/DeclarationLetter");
        return mv;
    }

    public ModelAndView submitLetter(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        int valueFlag = 1;

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("decLetter");

            DeclarationLetter existingLetter = declarationLetterService.getSingle();

            if (multipartFile != null && !multipartFile.isEmpty()) {
                String fileLocationURL = request.getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "DeclarationLetter" + File.separator;

                File dir = new File(fileLocationURL);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String newFileName = multipartFile.getOriginalFilename().replaceAll(" ", "");
                File newFile = new File(fileLocationURL + newFileName);

                if (existingLetter != null && existingLetter.getDeclarationLetter() != null) {
                    File oldFile = new File(fileLocationURL + existingLetter.getDeclarationLetter());
                    if (oldFile.exists()) {
                        oldFile.delete();
                    }
                    
                    existingLetter.setDeclarationLetter(newFileName);
                    declarationLetterService.update(existingLetter);
                    valueFlag = 0;
                } else {
                    DeclarationLetter newLetter = new DeclarationLetter();
                    newLetter.setDeclarationLetter(newFileName);
                    declarationLetterService.create(newLetter);
                    valueFlag = 0;
                }

                multipartFile.transferTo(newFile);
            } else {
                mv.getModelMap().put("error", "No file selected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mv.getModelMap().put("error", "Exception occurred: " + e.getMessage());
        }
        mv.getModelMap().put("successMessage","Declaration Letter Uploded Successfully");
        List list = declarationLetterService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("Value", valueFlag);
        mv.setViewName("DeclarationLetter/DeclarationLetter");
        return mv;

    }

    public ModelAndView downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String fileName = request.getParameter("fileName");
        String id = request.getParameter("id");

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "DeclarationLetter"
                + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        int valueFlag = 1;
        DeclarationLetter existingLetter = declarationLetterService.getSingle();
        if (existingLetter != null && existingLetter.getDeclarationLetter() != null) {
            File file = new File(getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "DeclarationLetter"
                    + File.separator + existingLetter.getDeclarationLetter());
            if (file.exists()) {
                valueFlag = 0;
            }
        }

        List list = declarationLetterService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("Value", valueFlag);
        mv.setViewName("DeclarationLetter/DeclarationLetter");
        return mv;
    }

}
