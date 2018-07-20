/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Kaizen;

import com.bul.zydex.dao.Kaizen.KaizenApprovalHistoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class KaizenApprovalHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements KaizenApprovalHistoryService<T>{
    
    private KaizenApprovalHistoryDAO<T> kaizenApprovalHistoryDAO;

    public KaizenApprovalHistoryDAO<T> getKaizenApprovalHistoryDAO() {
        return kaizenApprovalHistoryDAO;
    }

    public void setKaizenApprovalHistoryDAO(KaizenApprovalHistoryDAO<T> kaizenApprovalHistoryDAO) {
        this.kaizenApprovalHistoryDAO = kaizenApprovalHistoryDAO;
        setGenericsDAO(kaizenApprovalHistoryDAO);
    }

    @Override
    public List<?> readByKaizenId(int id) {
        return kaizenApprovalHistoryDAO.readByKaizenId(id);
    }
    
    

}
