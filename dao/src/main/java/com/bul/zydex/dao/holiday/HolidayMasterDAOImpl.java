/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.holiday;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.HolidayMaster;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Irfan
 */
public class HolidayMasterDAOImpl<T> extends GenericsDAOImpl<T> implements HolidayMasterDAO<T> {

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        HolidayMaster holidayMaster = (HolidayMaster) object;
        List holidayList = getHibernateTemplate().find("from HolidayMaster h where  STR_To_DATE('" + holidayMaster.getHolidayFromDate() + "','%d/%m/%Y') between STR_TO_DATE(h.holidayFromDate,'%d/%m/%Y') and STR_TO_DATE(h.holidayToDate,'%d/%m/%Y')");
//        List holidayList = getHibernateTemplate().find("from HolidayMaster where" + holidayMaster.getHolidayFromDate() + "or" + holidayMaster.getHolidayToDate() + "between holidayFromDate and holidayToDate");
        if (holidayList.isEmpty()) {
            flag = true;

        }
        return flag;
    }

    @Override
    public List<?> readWithLocation() {
//        return getHibernateTemplate().find("select h , l.zydexLocationMaster from HolidayMaster h left join h.zydexLocationMaster l");
        String query = "";
        query += " select a , b.location"
                + " From HolidayMaster a,"
                + " LocationMaster b "
                + " Where b.id=a.locationMaster.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    protected Class getDomainClass() {
        return HolidayMaster.class;
    }

    @Override
    public List<?> checkHoliday(String date,String locationId) {
        String query = "";
        query += " From HolidayMaster a "
                + "Where STR_TO_DATE('" + date + "','%d/%m/%Y') BETWEEN STR_TO_DATE(a.holidayFromDate,'%d/%m/%Y') AND STR_TO_DATE(a.holidayToDate,'%d/%m/%Y')"
                + " AND a.locationMaster="+locationId;

        return getHibernateTemplate().find(query);
    }

    public int searchMonthWiseHoliday(T object) {

        HolidayMaster holidayMaster = (HolidayMaster) object;
        String query = "select"
                + "    case"
                + "                when"
                + "            (select"
                + "                    sm.weekof"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + holidayMaster.getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    'WO' as sunday"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + holidayMaster.getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1)"
                + "      "
                + "        when"
                + "            (select"
                + "                    d.title"
                + "                from"
                + "                    holiday_master d,"
                + "                    employee_master emp"
                + "                where"
                + "                    emp.id = " + holidayMaster.getId() + " and emp.company_location = d.location_id and DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                            '%d/%m/%Y') between DATE_FORMAT(STR_TO_DATE(d.holiday_from_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y') and DATE_FORMAT(STR_TO_DATE(d.holiday_to_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    concat(d.title)"
                + "                from"
                + "                    holiday_master d,"
                + "                    employee_master emp"
                + "                where"
                + "                    emp.id = " + holidayMaster.getId() + " and emp.company_location = d.location_id and DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                            '%d/%m/%Y') between DATE_FORMAT(STR_TO_DATE(d.holiday_from_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y') and DATE_FORMAT(STR_TO_DATE(d.holiday_to_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y')"
                + "                limit 1)"
                + " else 'AB'"
                + "    end"
                + " from"
                + "    (select"
                + "        adddate('1970-01-01', t4 * 10000 + t3 * 1000 + t2 * 100 + t1 * 10 + t0) selected_date"
                + "    from"
                + "        (select 0 t0 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0, (select 0 t1 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1, (select 0 t2 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2, (select 0 t3 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3, (select 0 t4 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v"
                + " where selected_date between '" + holidayMaster.getHolidayFromDate() + "' and '" + holidayMaster.getHolidayToDate() + "'";

        Query query1 = getSession().createSQLQuery(query);
        List results = query1.list();
        Iterator<String> iterator = results.iterator();
        int count=0;
        while (iterator.hasNext()) {
            String value = iterator.next();
            if ("AB".equals(value) || "WO".equals(value)) {
                iterator.remove();
            }else{
                count++;
            }
        }
        return  count;
    }

    
     @Override
    public List<?> readHolidaysLocationWise(String locationId) {
//        return getHibernateTemplate().find("select h , l.zydexLocationMaster from HolidayMaster h left join h.zydexLocationMaster l");
        String query = "";
         Calendar now = Calendar.getInstance();
          int year = now.get(Calendar.YEAR);
        query += " select a.title , a.holidayFromDate, a.holidayToDate, b.location"
                + " From HolidayMaster a"
                + " Left join a.locationMaster b "
                + " Where b.id="+locationId
                 + " AND DATE_FORMAT(STR_TO_DATE(a.holidayFromDate, '%d/%m/%Y'),'%Y')="+year;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readHolidaysDateLocationWise(String holidayFrom, String holidayTo, int locationId) {
        
        String query = " SELECT a "
                + " FROM HolidayMaster a "
                + " left join a.locationMaster b "
                + " where a.holidayFromDate = '"+ holidayFrom +"'"
                + " and a.holidayToDate = '" + holidayTo +"'"
                + " and b.location.id = " + locationId ;
        
        List list = getHibernateTemplate().find(query);
        return list;
    }

    
}
