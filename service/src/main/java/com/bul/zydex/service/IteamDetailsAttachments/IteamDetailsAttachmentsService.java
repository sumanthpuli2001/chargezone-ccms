/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.IteamDetailsAttachments;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface IteamDetailsAttachmentsService<T> extends GenericsService<T>  {

    public List readByPRItemDesc(String id);

    public List readByPRItemDesc1(String id1);

    public List readBydeliverymultid(String id);

    public List readBydeleteAll(String id);

    public List readBystatus(String status, String id);

    public List readBystatus2(int setValue, String id);

    public List readBydeleteAll1(String id);

    public List readByPRItemDesc2(String id);

    public void deleteByDeliMultiAndFlag(String id,int flag);

   

    
}
