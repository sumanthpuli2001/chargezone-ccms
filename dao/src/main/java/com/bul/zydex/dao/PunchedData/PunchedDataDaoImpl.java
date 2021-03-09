/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PunchedData;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DeviceDetails;
import com.bul.zydex.model.PunchedDataMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Aman Bahukhandi
 */
public class PunchedDataDaoImpl<T> extends GenericsDAOImpl<T> implements PunchedDataDao<T> {

    @Override
    protected Class getDomainClass() {
        return PunchedDataMaster.class;
    }

    @Override
    public List readBy(String sFrom, String eFrom, String cardCode, String item) {
        List finalList = new ArrayList();
        String itemCode = Integer.parseInt(item) < 10 ? "0" + item : item;
        String condition = " and 1=1";
        if (cardCode != null && cardCode != "") {
            condition += " and a.empCode = '" + cardCode + "'";

        }

        String query = " Select a"
                + " from PunchedDataMaster a "
                + " Where a.item= '" + itemCode + "'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + sFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))"
                //                    + " and a.srNo > 283934918"
                + condition;
        List list = getHibernateTemplate().find(query);
        for (Object o : list) {
            List temp = new ArrayList();
            PunchedDataMaster pdm = (PunchedDataMaster) o;
            String query1 = " Select a.name "
                    + " from EmployeeMaster a where a.rfId = '" + pdm.getEmpCode() + "'";
            try {

                temp = getHibernateTemplate().find(query1);
                if (temp.isEmpty()) {
                    query1 = " Select a.name "
                            + " from ContractorMaster a where a.rfId = '" + pdm.getEmpCode() + "'";
                    temp = getHibernateTemplate().find(query1);
                    if (temp.isEmpty()) {
                        query1 = " Select a.name "
                                + " from ApprenticesMaster a where a.rfId = '" + pdm.getEmpCode() + "'";
                        temp = getHibernateTemplate().find(query1);
                    }
                }
                temp.add(pdm.getSrNo());
                temp.add(pdm.getEmpCode());
                temp.add(pdm.getlDate());
                temp.add(pdm.getlTime());
                temp.add(pdm.getItem());
                temp.add(pdm.getQuantity());
                temp.add(pdm.getPrice());
                finalList.add(temp);

            } catch (Exception e) {
                System.err.println("" + e.getMessage());
            }
        }

        return finalList;
    }

    @Override
    public List readBYId(int id) {
        List finalList = new ArrayList();

        String query = " Select a"
                + " from PunchedDataMaster a "
                + " Where a.srNo= '" + id + "'";
        List list = getHibernateTemplate().find(query);
        for (Object o : list) {
            List temp = new ArrayList();
            PunchedDataMaster pdm = (PunchedDataMaster) o;
            String query1 = " Select a.name "
                    + " from EmployeeMaster a where a.rfId  = '" + pdm.getEmpCode() + "'";
            temp = getHibernateTemplate().find(query1);
            if (temp.isEmpty()) {
                query1 = " Select a.name "
                        + " from ContractorMaster a where a.rfId = '" + pdm.getEmpCode() + "'";
                temp = getHibernateTemplate().find(query1);
                if (temp.isEmpty()) {
                    query1 = " Select a.name "
                            + " from ApprenticesMaster a where a.rfId = '" + pdm.getEmpCode() + "'";
                    temp = getHibernateTemplate().find(query1);
                }
            }
            temp.add(pdm.getSrNo());
            temp.add(pdm.getEmpCode());
            temp.add(pdm.getlDate());
            temp.add(pdm.getlTime());
            temp.add(pdm.getItem());
            temp.add(pdm.getQuantity());
            temp.add(pdm.getPrice());
            finalList.add(temp);
        }
        return finalList;
    }

    @Override
    public void updateQuery(int id, double price) {

        String query = " update PunchedDataMaster a "
                + " set a.price=" + price
                + " , a.disp=15"
                + " Where a.srNo= '" + id + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void deleteBySrNo(String checkedValues) {
        String query = "";
        query = " delete FROM PunchedDataMaster a"
                + " WHERE a.srNo = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readByEmpDateItem(String code, String date, int srNo) {
        String item = "";
        if (srNo < 10) {
            item = "0" + srNo;
        } else {
            item = "" + srNo;
        }

        String query = " Select a"
                + " from PunchedDataMaster a "
                + " Where a.item='" + item + "'"
                + " and a.empCode like '%" + code + "%'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d'))";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByMachineDetails(DeviceDetails deviceDetails, String date) {

        String query = " Select a.lDate,count(a.item),a.item,a.cid,c.couponType,c.srNo "
                + " from PunchedDataMaster a ,CouponMaster c"
                + " Where a.cid='" + deviceDetails.getDeviceId() + "'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d'))"
                + " and a.item = c.srNo"
                + " group by a.item";
        List list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List readByDateAndDeviceId(String date, String deviceId, String copounID) {
        String device = Integer.parseInt(deviceId) < 10 ? "0" + deviceId : deviceId;
        String itemCode = Integer.parseInt(copounID) < 10 ? "0" + copounID : copounID;
        String query = " Select a "
                + " from PunchedDataMaster a "
                + " Where a.cid='" + device + "'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d'))"
                + " and a.item='" + itemCode + "'";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readSumOfAmount(String date, String item) {
        String condition = " and 1 = 1";
        if (!item.equals("All")) {
            String itemCode = Integer.parseInt(item) < 10 ? "0" + item : item;
            condition += " and a.item='" + itemCode + "'";
        }
        String query = " Select a.item,sum(a.quantity),a.lDate "
                + " from PunchedDataMaster a "
                + " Where (STR_TO_DATE(a.lDate,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d')) "
                + condition
                + " group by a.item";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readSumOfPrice(String empCode, String dFrom, String eFrom) {

        String query = " Select a.empCode,sum(a.price) "
                + " from PunchedDataMaster a "
                + " where a.empCode like '%" + empCode + "%'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readPriceSum(String rfId, String date) {
        String query = " Select a.empCode,sum(a.price) "
                + " from PunchedDataMaster a "
                + " where a.empCode = '" + rfId + "'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') >= STR_TO_DATE('" + date + "', '%Y-%m-%d'))";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readEmp(String dFrom, String eFrom, String type) {
        String condition = " and 1=1 ";
        if (type.equals("E")) {
            condition += " and empCode like '001%' ";
        }
        if (type.equals("A")) {
            condition += " and empCode like '002%' ";
        }
        if (type.equals("C")) {
            condition += " and empCode not like '001%' and empCode not like '002%' ";
        }
        String query = " Select a "
                + " from PunchedDataMaster a "
                + " where (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))"
                + " and a.disp = 15 "
                + condition
                + " order by a.srNo";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readDistinct(String dFrom, String eFrom, String cardCode, String item) {
        String Condition = " and 1 = 1 ";
        if (cardCode != "" && cardCode != null) {
            Condition += " and a.empCode='" + cardCode + "' ";
        }
        if (!item.equals("All") && item != "") {
            String itemCode = Integer.parseInt(item) < 10 ? "0" + item : item;
            Condition += " and a.item='" + itemCode + "'";
        }

        String query = " Select distinct a.empCode "
                + " from PunchedDataMaster a "
                + " where STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d')"
                + Condition;

        return getHibernateTemplate().find(query);

    }
    
     @Override
    public List readDistinctforemp(String dFrom, String eFrom, String cardCode, String item,String emp) {
        String Condition = " and 1 = 1 ";
        if (cardCode != "" && cardCode != null) {
            Condition += " and a.empCode='" + cardCode + "' ";
        }
        if (!item.equals("All") && item != "") {
            String itemCode = Integer.parseInt(item) < 10 ? "0" + item : item;
            Condition += " and a.item='" + itemCode + "'";
        }

        String query = " Select distinct a.empCode "
                + " from PunchedDataMaster a "
                + " where STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d')"
                + "  and  a.empCode like '%" +emp +"'"
                + Condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByValues(String date, String empId, String item) {
        String Condition = " and 1 = 1 ";
        if (!item.equals("All") && item != "") {
            String itemCode = Integer.parseInt(item) < 10 ? "0" + item : item;
            Condition += " and a.item='" + itemCode + "'";
        }

        String query = " Select a.item,a.price,count(item),a.empCode  "
                + " from PunchedDataMaster a "
                + " Where a.empCode = '" + empId + "'"
                + " and (STR_TO_DATE(a.lDate,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d'))"
                + " " + Condition
                + " group by a.item ";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBySumValues(String sdate, String endDate, String empCd, String item) {
        String Condition = " and 1 = 1 ";
        if (!item.equals("All") && item != "") {
            String itemCode = Integer.parseInt(item) < 10 ? "0" + item : item;
            Condition += " and a.item='" + itemCode + "'";
        }

        String query = " Select a.item,a.price,count(item),a.empCode  "
                + " from PunchedDataMaster a "
                + " Where a.empCode = '" + empCd + "'"
                + " and STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + sdate + "', '%Y-%m-%d') and STR_TO_DATE('" + endDate + "', '%Y-%m-%d')"
                + " " + Condition
                + " group by a.item ";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDateDiff(String dFrom, String eFrom) {

        String query = " Select a"
                + " from PunchedDataMaster a "
                + " Where (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteBySrNo(long srNo) {

        String query = "";
        query += " delete FROM PunchedDataMaster a"
                + " WHERE a.srNo = " + srNo;

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
    @Override
    public List readByid(long id) {
        String query = " Select p.srNo, p.item,p.empCode,p.lDate,p.lTime,p.price"
                
                + " from PunchedDataMaster p "
                + " where p.srNo ='" + id + "'";
              

//                + " and (STR_TO_DATE(c.lDate,'%Y-%m-%d') >= STR_TO_DATE('" + date + "', '%Y-%m-%d'))";
        return getHibernateTemplate().find(query);

    }
    @Override
    public void deleteByDate(String dFrom, String eFrom) {
        String query = "";
        query = " delete FROM PunchedDataMaster a"
                //                + " WHERE a.srNo = '" + checkedValues + "'";
                + " Where (STR_TO_DATE(a.lDate,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + dFrom + "', '%Y-%m-%d') and STR_TO_DATE('" + eFrom + "', '%Y-%m-%d'))";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

}
        
        
