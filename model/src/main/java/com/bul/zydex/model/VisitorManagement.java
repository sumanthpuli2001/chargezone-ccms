package com.bul.zydex.model;

public class VisitorManagement implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMasterByEmployeeMasterId;
    private EmployeeMaster employeeMasterByApproverId;
    private VisitorVisitedLocation visitorVisitedLocation;
    private ZydexLocationMaster zydexLocationMaster;
    private EmployeeMaster employeeMasterBySecurityApproveId;
    private EmployeeMaster visitorVisitsToEmployeeId;
    private Company company;
    private String visitorName;
    private String visitorOrganization;
    private String incomingDateTime;
    private String outgoingDateTime;
    private String visitorComingFrom;
    private String meetingOffDate;
    private String visitorContactDetail;
    private String accesories;
    private String reason;
    private String requestDate;
    private Integer status;
    private String approverDate;
    private String rejectRemark;
    private String securityRemark;
    private String visitorPhotograph;

    public VisitorManagement() {
    }

    public VisitorManagement(EmployeeMaster employeeMasterByEmployeeMasterId, EmployeeMaster employeeMasterByApproverId, ZydexLocationMaster zydexLocationMaster, EmployeeMaster visitorVisitsToEmployeeId, Company company) {
        this.employeeMasterByEmployeeMasterId = employeeMasterByEmployeeMasterId;
        this.employeeMasterByApproverId = employeeMasterByApproverId;
        this.zydexLocationMaster = zydexLocationMaster;
        this.visitorVisitsToEmployeeId = visitorVisitsToEmployeeId;
        this.company = company;
    }

    public VisitorManagement(EmployeeMaster employeeMasterByEmployeeMasterId, EmployeeMaster employeeMasterByApproverId, VisitorVisitedLocation visitorVisitedLocation, ZydexLocationMaster zydexLocationMaster, EmployeeMaster employeeMasterBySecurityApproveId, EmployeeMaster visitorVisitsToEmployeeId, Company company, String visitorName, String visitorOrganization, String incomingDateTime, String outgoingDateTime, String visitorComingFrom, String meetingOffDate, String visitorContactDetail, String accesories, String reason, String requestDate, Integer status, String approverDate, String rejectRemark, String securityRemark, String visitorPhotograph) {
        this.employeeMasterByEmployeeMasterId = employeeMasterByEmployeeMasterId;
        this.employeeMasterByApproverId = employeeMasterByApproverId;
        this.visitorVisitedLocation = visitorVisitedLocation;
        this.zydexLocationMaster = zydexLocationMaster;
        this.employeeMasterBySecurityApproveId = employeeMasterBySecurityApproveId;
        this.visitorVisitsToEmployeeId = visitorVisitsToEmployeeId;
        this.company = company;
        this.visitorName = visitorName;
        this.visitorOrganization = visitorOrganization;
        this.incomingDateTime = incomingDateTime;
        this.outgoingDateTime = outgoingDateTime;
        this.visitorComingFrom = visitorComingFrom;
        this.meetingOffDate = meetingOffDate;
        this.visitorContactDetail = visitorContactDetail;
        this.accesories = accesories;
        this.reason = reason;
        this.requestDate = requestDate;
        this.status = status;
        this.approverDate = approverDate;
        this.rejectRemark = rejectRemark;
        this.securityRemark = securityRemark;
        this.visitorPhotograph = visitorPhotograph;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeMaster getEmployeeMasterByEmployeeMasterId() {
        return this.employeeMasterByEmployeeMasterId;
    }

    public void setEmployeeMasterByEmployeeMasterId(EmployeeMaster employeeMasterByEmployeeMasterId) {
        this.employeeMasterByEmployeeMasterId = employeeMasterByEmployeeMasterId;
    }

    public EmployeeMaster getEmployeeMasterByApproverId() {
        return this.employeeMasterByApproverId;
    }

    public void setEmployeeMasterByApproverId(EmployeeMaster employeeMasterByApproverId) {
        this.employeeMasterByApproverId = employeeMasterByApproverId;
    }

    public VisitorVisitedLocation getVisitorVisitedLocation() {
        return this.visitorVisitedLocation;
    }

    public void setVisitorVisitedLocation(VisitorVisitedLocation visitorVisitedLocation) {
        this.visitorVisitedLocation = visitorVisitedLocation;
    }

    public EmployeeMaster getEmployeeMasterBySecurityApproveId() {
        return this.employeeMasterBySecurityApproveId;
    }

    public void setEmployeeMasterBySecurityApproveId(EmployeeMaster employeeMasterBySecurityApproveId) {
        this.employeeMasterBySecurityApproveId = employeeMasterBySecurityApproveId;
    }

    public String getVisitorName() {
        return this.visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorOrganization() {
        return this.visitorOrganization;
    }

    public void setVisitorOrganization(String visitorOrganization) {
        this.visitorOrganization = visitorOrganization;
    }

    public String getIncomingDateTime() {
        return this.incomingDateTime;
    }

    public void setIncomingDateTime(String incomingDateTime) {
        this.incomingDateTime = incomingDateTime;
    }

    public String getVisitorComingFrom() {
        return this.visitorComingFrom;
    }

    public void setVisitorComingFrom(String visitorComingFrom) {
        this.visitorComingFrom = visitorComingFrom;
    }

    public String getVisitorContactDetail() {
        return this.visitorContactDetail;
    }

    public void setVisitorContactDetail(String visitorContactDetail) {
        this.visitorContactDetail = visitorContactDetail;
    }

    public String getAccesories() {
        return this.accesories;
    }

    public void setAccesories(String accesories) {
        this.accesories = accesories;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApproverDate() {
        return this.approverDate;
    }

    public void setApproverDate(String approverDate) {
        this.approverDate = approverDate;
    }

    public String getRejectRemark() {
        return this.rejectRemark;
    }

    public void setRejectRemark(String rejectRemark) {
        this.rejectRemark = rejectRemark;
    }

    public String getSecurityRemark() {
        return this.securityRemark;
    }

    public void setSecurityRemark(String securityRemark) {
        this.securityRemark = securityRemark;
    }

    public String getVisitorPhotograph() {
        return visitorPhotograph;
    }

    public void setVisitorPhotograph(String visitorPhotograph) {
        this.visitorPhotograph = visitorPhotograph;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public EmployeeMaster getVisitorVisitsToEmployeeId() {
        return visitorVisitsToEmployeeId;
    }

    public void setVisitorVisitsToEmployeeId(EmployeeMaster visitorVisitsToEmployeeId) {
        this.visitorVisitsToEmployeeId = visitorVisitsToEmployeeId;
    }

    public String getOutgoingDateTime() {
        return outgoingDateTime;
    }

    public void setOutgoingDateTime(String outgoingDateTime) {
        this.outgoingDateTime = outgoingDateTime;
    }

    public ZydexLocationMaster getZydexLocationMaster() {
        return zydexLocationMaster;
    }

    public void setZydexLocationMaster(ZydexLocationMaster zydexLocationMaster) {
        this.zydexLocationMaster = zydexLocationMaster;
    }

    public String getMeetingOffDate() {
        return meetingOffDate;
    }

    public void setMeetingOffDate(String meetingOffDate) {
        this.meetingOffDate = meetingOffDate;
    }
    
}

