/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SmtpDetails;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.SmtpDetails;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface SmtpDetailsDao<T> extends GenericsDAO<T>{

    public List readAllDetails();
    
    
      public List getSmtpPagination(int start, int length, String searchValue, String orderColumn, String orderDir);


    public int getFilteredSmtpCount(String search);

    public int getTotalSmtpCount();
    
}
