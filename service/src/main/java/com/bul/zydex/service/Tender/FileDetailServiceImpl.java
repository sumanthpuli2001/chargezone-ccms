/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.FileDetailDao;
import com.bul.zydex.model.FileDetail;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class FileDetailServiceImpl<T> extends GenericsServiceImpl<T> implements FileDetailService<T> {
    
    private FileDetailDao<T> fileDetailDao;

    public FileDetailDao<T> getFileDetailDao() {
        return fileDetailDao;
    }

    public void setFileDetailDao(FileDetailDao<T> fileDetailDao) {
        this.fileDetailDao = fileDetailDao;
        setGenericsDAO(fileDetailDao);
    }

    @Override
    public List readRefNo(String ref_no) {
        return fileDetailDao.readRefNo(ref_no);
    }

    @Override
    public List readByRefNo(String ref_no, String service_file1) {
        return fileDetailDao.readByRefNo(ref_no, service_file1);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        fileDetailDao.deleteFile(ref_no,file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        fileDetailDao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String refNo) {
        return fileDetailDao.readTenderNo(refNo);
    }

    @Override
    public List readByTenderNo(String ref_no, String service_file1) {
        return fileDetailDao.readByTenderNo(ref_no, service_file1);
    }
}
