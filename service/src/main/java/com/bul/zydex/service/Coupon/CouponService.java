/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Coupon;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface CouponService<T> extends GenericsService<T> {

    public List readByShiftType(String shiftType, String item);

    public List readCoupon(String item);

    public List readByName(String item);

    public List readAll();

    public List readByDrow();

    public List readByDrowDisable();

    public List readByCoupon(String parameter);

}
