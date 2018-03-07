/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.thought;

import com.bul.zydex.model.CorporateVideo;
import com.bul.zydex.model.Gallery;
import com.bul.zydex.model.RAndR;
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
public class ThoughtMasterController extends ThoughtMasterAbstract {

    public ModelAndView createthought(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> thoughtMasterList = thoughtMasterService.readthoughtmasterDetail();
        mv.getModelMap().put("list", thoughtMasterList);
        mv.setViewName("Thought/deshbordsetting");
        return mv;
    }

    public ModelAndView createthought0(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Thought/createthourgt");
        return mv;
    }

    public ModelAndView createthought1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
        mv.getModelMap().put("videoList", l1);
        mv.setViewName("Thought/deshbordsetting1");
        return mv;
    }

    public ModelAndView createthought2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> l1 = (List<?>) galleryService.readgalleryDetail();
        mv.getModelMap().put("list", l1);
        mv.setViewName("Thought/deshbordsetting2");
        return mv;
    }

    public ModelAndView createthought3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> l1 = (List<?>) rAndRService.readrandrDetail();
        mv.getModelMap().put("list", l1);
        mv.setViewName("Thought/deshbordsetting3");
        return mv;
    }

    public ModelAndView creategallery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Thought/createGallery");
        return mv;
    }

    public ModelAndView createrandr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Thought/createrandr");
        return mv;
    }

    public ModelAndView editthought(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ThoughtMaster thoughtMaster = new ThoughtMaster();
        String id = request.getParameter("id");
        thoughtMaster = thoughtMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("thoughtMaster", thoughtMaster);
        mv.setViewName("Thought/editthourgt");
        return mv;
    }

    public ModelAndView Submitthought(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        String thought = request.getParameter("thought");
        String date = request.getParameter("date");
        ThoughtMaster thoughtMaster = new ThoughtMaster();
        thoughtMaster.setCreatedBy(user.getId());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        thoughtMaster.setCreatedDate(dtf.format(localDate));
        thoughtMaster.setThought(thought);
        thoughtMaster.setDate(date);
        thoughtMasterService.create(thoughtMaster);
        request.setAttribute("successMessage",
                "Info :Record is Created successfully.");
        mv = createthought(request, response);
        return mv;
    }

    public ModelAndView editsubmitthought(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ThoughtMaster thoughtMaster = new ThoughtMaster();
        HttpSession session = request.getSession();
        BindException errors = new BindException(thoughtMaster, "thoughtMaster");
        bind(request, thoughtMaster);
        UserMaster user = (UserMaster) session.getAttribute("user");
        thoughtMaster.setUpdatedBy(user.getId());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        thoughtMaster.setUpdatedDate(dtf.format(localDate));
        thoughtMasterService.update(thoughtMaster);
        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");
        mv = createthought(request, response);
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {

                thoughtMasterService.delete(Integer.parseInt(z));
            } catch (Exception e) {

            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = createthought(request, response);

        return mv;
    }
    
    public ModelAndView submitgallery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Gallery gallery = new Gallery();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
         if(rAndRService.isExist( multipartFile.getOriginalFilename())){
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "galleryimage" + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "galleryimage" + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                gallery.setDisc(request.getParameter("Des"));
                gallery.setImagesPath(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
        gallery.setCreatedBy(user.getId());
        gallery.setCreatedDate(dtf.format(localDate));
        galleryService.create(gallery);
//        List<CorporateVideo> l1 = (List<CorporateVideo>) corporateVideoService.readCorporateVideoDetail();
//        mv.getModelMap().put("list", l1);
        request.setAttribute(
                "successMessage",
                "Information : Image is Uploaded Successfully.");
        }
        else{
        request.setAttribute(
                "successMessage",
                "Information : Image is Already Exist.");
        }
        mv=createthought2(request, response);
        return mv;
    }

    public ModelAndView submitrandr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RAndR gallery = new RAndR();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
        if(rAndRService.isExist( multipartFile.getOriginalFilename())){
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "RandRimage" + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "RandRimage" + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_")                                    );
                multipartFile.transferTo(file2);
                gallery.setDisc(request.getParameter("Des"));
                gallery.setImagesPath(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
        gallery.setCreatedBy(user.getId());
        gallery.setCreatedDate(dtf.format(localDate));
        rAndRService.create(gallery);
        request.setAttribute(
                "successMessage",
                "Information : Image is Uploaded Successfully.");
//       mv.setViewName("Thought/createGallery");
        }
        else{
        request.setAttribute(
                "successMessage",
                "Information : Image is Already Exist.");
        }
        mv = createthought3(request, response);
        return mv;
    }
    public ModelAndView deletegallerySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                Gallery Gallery = galleryService.readById(Integer.parseInt(z));
                String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "galleryimage" + File.separator +""+Gallery.getImagesPath();
            File File = new File(fileLocationURL);
                File.delete();
                galleryService.delete(Integer.parseInt(z));
            } catch (Exception e) {

            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv =createthought2(request, response);

        return mv;
    }
    public ModelAndView deleteeandrSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                 RAndR RAndR = rAndRService.readById(Integer.parseInt(z));
                String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "RandRimage" + File.separator +""+RAndR.getImagesPath();
            File File = new File(fileLocationURL);
                File.delete();
                rAndRService.delete(Integer.parseInt(z));
            } catch (Exception e) {

            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv =createthought3(request, response);

        return mv;
    }

}
