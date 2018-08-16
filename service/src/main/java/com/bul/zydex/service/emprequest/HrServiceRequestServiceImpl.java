/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.HrServiceRequestDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class HrServiceRequestServiceImpl<T> extends GenericsServiceImpl<T> implements HrServiceRequestService<T>{

      private HrServiceRequestDAO hrServiceRequestDAO;

    public HrServiceRequestDAO getHrServiceRequestDAO() {
        return hrServiceRequestDAO;
    }

    public void setHrServiceRequestDAO(HrServiceRequestDAO hrServiceRequestDAO) {
        this.hrServiceRequestDAO = hrServiceRequestDAO;
        setGenericsDAO(hrServiceRequestDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return hrServiceRequestDAO.readByEmpId(object);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
                return hrServiceRequestDAO.readByrequesteeId(object);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
          return hrServiceRequestDAO.readSearchEmpRequest(object);
    }

    @Override
    public List<?> readSearchRequest(T object) {
          return hrServiceRequestDAO.readSearchRequest(object);

    }

    @Override
    public boolean isExist(T object) {
        return hrServiceRequestDAO.isExist(object);
    }
    
    @Override
        public List<?> readHrServicePendingRequest(T object) {
          return hrServiceRequestDAO.readHrServicePendingRequest(object);

    }
    
    @Override
      public List<?> readHrServiceApproverPendingRequest(T object) {
          return hrServiceRequestDAO.readHrServiceApproverPendingRequest(object);

    }

    @Override
    public int countHrServicePendingRequest(T object) {
        return hrServiceRequestDAO.countHrServicePendingRequest(object);
    }

    @Override
    public int countHrServiceApproverPendingRequest(T object) {
        return hrServiceRequestDAO.countHrServiceApproverPendingRequest(object);
    }

    @Override
    public List<?> readByrequesteeIdHrDesktop() {
        return hrServiceRequestDAO.readByrequesteeIdHrDesktop();
    }
    
}
