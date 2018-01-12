/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public interface PayrollProvidentFundDAO<T> extends GenericsDAO<T> {
  public List<?> readPf(int zydexLocationId);
}
