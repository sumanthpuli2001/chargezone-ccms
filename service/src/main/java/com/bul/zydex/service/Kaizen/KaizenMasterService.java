/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Kaizen;

import com.bul.zydex.model.KaizenMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface KaizenMasterService<T> extends GenericsService<T> {

    public List<?> readKaizenMaster();

    public List<?> readKaizenMaster(Integer id);

    public List<?> readKaizenMasterList(Integer id);

    public List<?> readKaizenList();

    public List<?> readKaizenMasterapprovalList(Integer id);

    public List<?> readPastKaizenMaster();

}
