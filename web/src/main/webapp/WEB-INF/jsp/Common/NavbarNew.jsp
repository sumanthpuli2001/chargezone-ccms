<%-- 
    Document   : NavbarNew
    Created on : 28 Mar, 2025, 4:37:21 PM
    Author     : Prachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

    <section class="sidebar">
        <ul class="side-nav list-unstyled">
            <li class="side-nav-item mb-2">
                <a href="dashboard.htm?act=tenderDashboard" class="nav-link">
                    <i class="fa-solid fa-house fa-fw mr-3"></i>
                    Dashboard
                </a>
            </li>

            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">
                <li class="side-nav-item has-children mb-2 ">
                    <a href="javascript:void(0)" class="nav-link ">
                        <i class="fa-solid fa-medal fa-fw mr-3"></i>
                        OAP And AOC Masters
                    </a>

                    <div class="drop-down transition-0" style="display: none;">

                        <ul class="sub-menu list-unstyled pt-2 pb-1">

                            <li class="sub-nav-item mb-1">
                                <a href="anchorCustomer.htm?act=anchorCustomerList" class="nav-link ">
                                    Anchor Customer
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="canopyVarient.htm?act=canopyVarientList" class="nav-link ">
                                    Canopy Varient
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="chargerMaster.htm?act=ChargerMasterList" class="nav-link ">
                                    Charger Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="chargerType.htm?act=ChargerTypeList" class="nav-link ">
                                    Charger Type
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="connectionType.htm?act=ConnectionTypeList" class="nav-link">
                                    Connection Type
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="connectorType.htm?act=ConnectorTypeList" class="nav-link ">
                                    Connector Type
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="discomMaster.htm?act=showlist" class="nav-link">
                                    Discom Master
                                </a>
                            </li>
                            
                             <li class="sub-nav-item mb-1">
                                <a href="ehMail.htm?act=ehMailList" class="nav-link">
                                    EH Mail 
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="investmentProfile.htm?act=InvestmentProfileList" class="nav-link">
                                    Investment Profile
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="oapMaster.htm?act=showList" class="nav-link">
                                    OAP Master/work flow
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="profitCenter.htm?act=profitCenterList" class="nav-link">
                                    Profit Center
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="projectNameMaster.htm?act=ProjectNameMasterList" class="nav-link">
                                    Project Name Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="projectProfile.htm?act=ProjectProfileList" class="nav-link">
                                    Project Profile
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="projectType.htm?act=ProjectTypeList" class="nav-link">
                                    Project Type
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="stationType.htm?act=StationTypeList" class="nav-link">
                                    Station Type Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="tenant.htm?act=TenantList" class="nav-link">
                                    Tenant Master
                                </a>
                            </li>

                        </ul>
                    </div>
                </li>
            </c:if>
                
            <li class="side-nav-item has-children mb-2 ">
                <a href="javascript:void(0)" class="nav-link ">
                    <i class="fa-solid fa-file-alt fa-fw mr-3"></i>

                    Forms
                </a>  
                <div class="drop-down transition-0" style="display: none;">
                    <ul class="sub-menu list-unstyled pt-2 pb-1">
                        <c:if test="${fn:contains(sessionScope.userRights.siteSurvey,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=Sitesurvey" class="nav-link">
                                    Site Survey
                                </a>
                            </li>    
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=SiteSurveyReport" class="nav-link">
                                    Site Survey Report
                                </a>
                            </li>    
                        </c:if>    
                        <c:if test="${fn:contains(sessionScope.userRights.oapCreater,'1')}">  
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=oapseachReport" class="nav-link">
                                    OAP Search
                                </a>
                            </li>  
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=oapFormAppovalList" class="nav-link">
                                    OAP Form List
                                </a>
                            </li>  
                            <!--                            <li class="sub-nav-item mb-1">
                                                            <a href="oapForm.htm?act=SaveAsDraftList" class="nav-link">
                                                                OAP Save As Draft
                                                            </a>
                                                        </li>  -->



                        </c:if> 

                        <c:if test="${fn:contains(sessionScope.userRights.oapApproval,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=OapApproval" class="nav-link">
                                    OAP Approval
                                </a>
                            </li>  

                        </c:if>     



                        <c:if test="${fn:contains(sessionScope.userRights.executiveHead,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=oapKickOffForm" class="nav-link">
                                    OAP Executive Head 
                                </a>
                            </li>  
                        </c:if>             

                        <c:if test="${fn:contains(sessionScope.userRights.projectCordinator,'1')}">	
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=CrcFormApproveList" class="nav-link">
                                    CRC Form
                                </a>
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=CrcFormList" class="nav-link">
                                    CRC Form List
                                </a>

                            </li>  
                        </c:if>   

                        <li class="sub-nav-item mb-1">
                            <a href="oapForm.htm?act=CrcFormApprovalUser" class="nav-link">
                                CRC Form Approval
                            </a>

                        </li>  

                        <c:if test="${fn:contains(sessionScope.userRights.aocCreater,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=aocseachReport" class="nav-link">
                                    AOC Search
                                </a>

                            </li>     
                            <li class="sub-nav-item mb-1">
                                <a href="aocForm.htm?act=aocFormAppovalList" class="nav-link">
                                    AOC Form List
                                </a>

                            </li> 
                            <!--                            <li class="sub-nav-item mb-1">
                                                            <a href="aocForm.htm?act=AocSaveAsDraftList" class="nav-link">
                                                                AOC Save As Draft
                                                            </a>
                            
                                                        </li> -->

                        </c:if>               
                        <c:if test="${fn:contains(sessionScope.userRights.aocApproval,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="aocForm.htm?act=AocApproval" class="nav-link">
                                    AOC Approval
                                </a>

                            </li> 


                        </c:if>
                        <c:if test="${fn:contains(sessionScope.userRights.executiveHead,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="aocForm.htm?act=aocKickOffForm" class="nav-link">
                                    AOC Executive Head
                                </a>

                            </li>
                        </c:if>   

                        <c:if test="${fn:contains(sessionScope.userRights.projectCordinator,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="aocForm.htm?act=kickoffFormApproveList" class="nav-link">
                                    Kickoff Form Create
                                </a>

                            </li>  
                            <li class="sub-nav-item mb-1">
                                <a href="aocForm.htm?act=KickOffFormList" class="nav-link">
                                    Kickoff Form List
                                </a>

                            </li>  
                        </c:if>

                        <li class="sub-nav-item mb-1">
                            <a href="aocForm.htm?act=KickOffFormApprovalUser" class="nav-link">
                                Kickoff Form Approval
                            </a>

                        </li>       
                        <c:if test="${fn:contains(sessionScope.userRights.oapApprovalCreater,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=DesignTeam" class="nav-link">
                                    Design Manager
                                </a>

                            </li>  

                        </c:if>

                        <c:if test="${fn:contains(sessionScope.userRights.projectManager,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=projectmanager" class="nav-link">
                                    Project Manager
                                </a>

                            </li>  

                        </c:if>
                        <c:if test="${fn:contains(sessionScope.userRights.aocApprovalCreater,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=Designcordinator" class="nav-link">
                                    Design Co-Ordinator
                                </a>

                            </li>  

                        </c:if>

                        <li class="sub-nav-item mb-1">
                            <a href="oapForm.htm?act=DesigncoordinatorApproval" class="nav-link">
                                Design Co-Ordinator Approval
                            </a>

                        </li>  

                        <c:if test="${fn:contains(sessionScope.userRights.networkTeam,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=NetworkTeam" class="nav-link">
                                    Network Team
                                </a>

                            </li>  
                        </c:if>            
                        <c:if test="${fn:contains(sessionScope.userRights.financeTeam,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=FinanceTeam" class="nav-link">
                                    Finance Team
                                </a>

                            </li> 
                        </c:if>            

                        <c:if test="${fn:contains(sessionScope.userRights.oapaocReport,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=oapRightsReport" class="nav-link">
                                    OAP  Report
                                </a>

                            </li> 

                        </c:if>   

                        <c:if test="${fn:contains(sessionScope.userRights.oapaocReport,'1')}">
                            <li class="sub-nav-item mb-1">
                                <a href="oapForm.htm?act=aocRightsReport" class="nav-link">
                                    AOC  Report
                                </a>

                            </li> 
                        </c:if>   


                        <li class="sub-nav-item mb-1">
                            <a href="oapForm.htm?act=oapprojectmanagerApprovemulti" class="nav-link">
                                Deliverable By Project Manager
                            </a>

                        </li>
                        <li class="sub-nav-item mb-1">
                            <a href="oapForm.htm?act=deliverableView" class="nav-link">
                                Create PR
                            </a>

                        </li>




                    </ul>
                </div>
            </li>

            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	
                <li class="side-nav-item has-children mb-2 ">
                    <a href="javascript:void(0)" class="nav-link ">
                        <i class="fa-solid fa-layer-group fa-fw mr-3"></i>
                        Masters
                    </a>
                    <div class="drop-down transition-0" style="display: none;">

                        <ul class="sub-menu list-unstyled pt-2 pb-1">
                            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">
                                <li class="sub-nav-item mb-1">
                                    <a href="employeeMaster.htm?act=showList" class="nav-link">
                                        Manage Employees
                                    </a>
                                </li> 

                            </c:if>   

                            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">
                                <li class="sub-nav-item mb-1">
                                    <a href="right.htm?act=showList" class="nav-link ">
                                        Add Right
                                    </a>
                                </li>    
                            </c:if>

                            <li class="sub-nav-item mb-1">
                                <a href="employeeMaster.htm?act=showDepartmentList" class="nav-link ">
                                    Departments
                                </a>
                            </li>



                            <li class="sub-nav-item mb-1">
                                <a href="employeeMaster.htm?act=showDesignationList" class="nav-link">
                                    Designation
                                </a>
                            </li>
                            <li class="sub-nav-item mb-1">
                                <a href="poDetails.htm?act=documentTypeList" class="nav-link">
                                    Document Type
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="employeeMaster.htm?act=showCompanyLocationList" class="nav-link">
                                    Company Location
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="plantMaster.htm?act=showPlantList" class="nav-link">
                                    Plant
                                </a>
                            </li>
                            <li class="sub-nav-item mb-1">
                                <a href="sapConnection.htm?act=sapList" class="nav-link">
                                    SAP Connection
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="smtpDetails.htm?act=showSmtpDetailsList"class="nav-link">
                                    SMTP Details
                                </a>
                            </li>
                            <li class="sub-nav-item mb-1">
                                <a href="materialGroupMaster.htm?act=showList" class="nav-link">
                                    Material Group Master
                                </a>
                            </li>                              




                            <li class="sub-nav-item mb-1">
                                <a href="materialTypeMaster.htm?act=showMaterial" class="nav-link">
                                    Material Type Master
                                </a>
                            </li>  


                            <li class="sub-nav-item mb-1">
                                <a href="materialMaster.htm?act=searchPage" class="nav-link">
                                    Material Master
                                </a>
                            </li>




                            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	
                                <li class="sub-nav-item mb-1">
                                    <a href="approvalSetting.htm?act=showList" class="nav-link">
                                        Vendor Approval Setting
                                    </a>
                                </li>

                                <li class="sub-nav-item mb-1">
                                    <a href="termsCondition.htm?act=showList" class="nav-link">
                                        Terms Condition
                                    </a>
                                </li>
                            </c:if>         


                            <li class="sub-nav-item mb-1">
                                <a href="tenderApproval.htm?act=showList" class="nav-link">
                                    Tender Approval
                                </a>
                            </li>  

                            <li class="sub-nav-item mb-1">
                                <a href="vendorApprovalSetting.htm?act=showList" class="nav-link">
                                    Vendor Approval
                                </a>
                            </li>  

                            <li class="sub-nav-item mb-1">
                                <a href="tenderApproval.htm?act=showList1" class="nav-link">
                                    Committee Approval
                                </a>
                            </li>  

                            <li class="sub-nav-item mb-1">
                                <a href="termsConditionParameter.htm?act=showList" class="nav-link">
                                    Terms Condition Parameter
                                </a>
                            </li> 
                            <li class="sub-nav-item mb-1">
                                <a href="productTypeMaster.htm?act=showList" class="nav-link">
                                    Product Master
                                </a>
                            </li>
                            <li class="sub-nav-item mb-1">
                                <a href="valuationClassMaster.htm?act=showList" class="nav-link">
                                    Valuation Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="productGroupMaster.htm?act=showList" class="nav-link">
                                    Product Group Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="companyMaster.htm?act=showlist" class="nav-link">
                                    Company Master
                                </a>
                            </li>






                            <li class="sub-nav-item mb-1">
                                <a href="currencyMaster.htm?act=showList" class="nav-link">
                                    Currency Master
                                </a>
                            </li>





                            <li class="sub-nav-item mb-1">
                                <a href="purchasingOrganisation.htm?act=showlist" class="nav-link">
                                    Purchasing Organisation
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="plantMasters.htm?act=showlist" class="nav-link">
                                    Plant Masters
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="locationMasters.htm?act=showlist" class="nav-link">
                                    Location Masters
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="bpGroupMasters.htm?act=showList" class="nav-link">
                                    BP Group Masters
                                </a>
                            </li>



                            <li class="sub-nav-item mb-1">
                                <a href="vendorInformation.htm?act=showTaxCategoryMasterList" class="nav-link">
                                    Tax Category Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="vendorInformation.htm?act=showGroupForCalMasterList" class="nav-link">
                                    Group Calculation Master
                                </a>
                            </li>

                        </ul>
                    </div>
                </li>
            </c:if> 

            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	

                <li class="side-nav-item has-children mb-2 ">
                    <a href="javascript:void(0)" class="nav-link ">
                        <i class="fa-solid fa-wrench fa-fw mr-3"></i>
                        Vendor Registration Master
                    </a>

                    <div class="drop-down transition-0" style="display: none;">
                        <ul class="sub-menu list-unstyled pt-2 pb-1">

                            <li class="sub-nav-item mb-1">
                                <a href="vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList" class="nav-link">
                                    Department Wise Approval
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="auditorMaster.htm?act=showList" class="nav-link">
                                    Manage Auditor
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="vendorCriteriaMaster.htm?act=showVendorCriteriaList" class="nav-link">
                                    Vendor Criteria Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="group.htm?act=showGroupMasterList" class="nav-link">
                                    Group Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="group.htm?act=showGroupCategoryList" class="nav-link">
                                    Group Category
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="group.htm?act=showGroupSubCategoryList" class="nav-link">
                                    Group Sub Category
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="declarationLetter.htm?act=showlist" class="nav-link">
                                    Declaration Letter
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="riskCategory.htm?act=showRiskCategoryList" class="nav-link">
                                    Risk Category Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="vendorInviteSource.htm?act=showVendorInviteSourceList" class="nav-link">
                                    Vendor Invite Source Master
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="vendor.htm?act=showList" class="nav-link">
                                    Vendor Percentage
                                </a>
                            </li>

                        </ul>
                    </div>
                </li>
            </c:if>	


            <c:if test="${fn:contains(sessionScope.userRights.vendorMgt,'1') || fn:contains(sessionScope.userRights.venderRequest,'1')|| fn:contains(sessionScope.userRights.venderInvite,'1')
                          || fn:contains(sessionScope.userRights.venderInformation,'1')|| fn:contains(sessionScope.userRights.activeVendor,'1') || fn:contains(sessionScope.userRights.allVendor,'1')
                          || fn:contains(sessionScope.userRights.complianceOfficer,'1')|| fn:contains(sessionScope.userRights.procurementHead,'1')|| fn:contains(sessionScope.userRights.buyerApproval,'1')
                          || fn:contains(sessionScope.userRights.financialApproval,'1')|| fn:contains(sessionScope.userRights.technicalApproval,'1')|| fn:contains(sessionScope.userRights.hrApproval,'1')
                          || fn:contains(sessionScope.userRights.safetyApproval,'1')|| fn:contains(sessionScope.userRights.itApproval,'1')}">                 
                  <li class="side-nav-item has-children mb-2 ">
                      <a href="javascript:void(0)" class="nav-link ">
                          <i class="fa-solid fa-user-tie fa-fw mr-3"></i>
                          Vendor Management
                      </a>
                      <div class="drop-down transition-0" style="display: none;">
                          <ul class="sub-menu list-unstyled pt-2 pb-1">

                              <li class="sub-nav-item mb-1">
                                  <a href="vendorInformation.htm?act=newVendor" class="nav-link">
                                      Vendor Information
                                  </a>
                              </li>
                              <c:if test="${fn:contains(sessionScope.userRights.complianceOfficer,'1')}"> 
                                  <li class="sub-nav-item mb-1">
                                      <a href="vendorInformation.htm?act=ComplianceOfficer" class="nav-link">
                                          Compliance Officer
                                      </a>
                                  </li>
                              </c:if>
                              <c:if test="${fn:contains(sessionScope.userRights.vendorMgt,'1') && fn:contains(sessionScope.userRights.activeVendor,'1')}"> 

                                  <li class="sub-nav-item mb-1">
                                      <a href="vendorInformation.htm?act=activeVendor" class="nav-link">
                                          Active Vendor
                                      </a>
                                  </li>
                              </c:if>

                                <li class="sub-nav-item mb-1">
                                      <a href="vendorInformation.htm?act=vendorBlockList" class="nav-link">
                                        Block Vendor
                                      </a>
                                  </li>   
                                  
                                  
                          </ul>
                      </div>
                  </li>
            </c:if>







            <c:if test="${fn:contains(sessionScope.userRights.prManagement,'1')}">	
                <li class="side-nav-item has-children mb-2">
                    <a href="javascript:void(0)" class="nav-link">
                        <i class="fa-solid fa-clipboard-list fa-fw mr-3"></i>
                        PR Management
                    </a>

                    <div class="drop-down transition-0" style="display: none;">
                        <ul class="sub-menu list-unstyled pt-2 pb-1">

                            <!--                <li class="sub-nav-item mb-1">
                                                <a href="prMaster.htm?act=selectPR" class="nav-link">
                                                    Create PR
                                                </a>
                                            </li>-->

                            <li class="sub-nav-item mb-1">
                                <a href="prMaster.htm?act=listPRList" class="nav-link">
                                    PR List
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="prMaster.htm?act=approvePRList" class="nav-link">
                                    Approve PR
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="prMaster.htm?act=searchPR" class="nav-link">
                                    Search PR
                                </a>
                            </li>

                            <li class="sub-nav-item mb-1">
                                <a href="prMaster.htm?act=closePrNavbar" class="nav-link">
                                    Close PR By Force
                                </a>
                            </li>
                            <c:if test="${fn:contains(sessionScope.userRights.omsCreator,'1')}">
                                <li class="sub-nav-item mb-1"><a href="omsMaster.htm?act=omsMasterList" class="nav-link">OMS Data</a></li>
                            </c:if>
                        </ul>
                    </div>
                </li>
            </c:if>

            <li class="side-nav-item has-children mb-2 ">	
                <a href="javascript:void(0)" class="nav-link ">	
                    <i class="fa-solid fa-handshake fa-fw mr-3"></i>
                    Tender Management
                </a>
                <div class="drop-down transition-0" style="display: none;">

                    <ul class="sub-menu list-unstyled pt-2 pb-1">


                        <c:if test="${fn:contains(sessionScope.userRights.createTender,'1')}">
                            <!--<li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=selectTypeTender" class="nav-link">Create Tender</a></li>-->
                            <c:if test="${fn:contains(sessionScope.userRights.authorizeTender,'1')}">
                                <li class="sub-nav-item mb-1"><a href="prMaster.htm?act=pendingPRList" class="nav-link">Create Tender From PR</a></li>
                                </c:if>
                                <c:if test="${fn:contains(sessionScope.userRights.authorizeTender,'0')}">
                                <li class="sub-nav-item mb-1"><a href="prMaster.htm?act=pendingPRList1" class="nav-link">Create Tender From PR</a></li>

                            </c:if>
                            <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=liveTenderList" class="nav-link">Corrigendum</a></li>
                            </c:if>  
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=receiveBidList" class="nav-link">Receive Bids</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=receiveBidListBuyer" class="nav-link">Technical Bid Approve</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=receiveCommercialBidList" class="nav-link">Receive Commercial Bids</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=pastTechnicalBid" class="nav-link">Past Technical Bid</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=pastTenderSearch" class="nav-link"> Bid Open Tender</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=approvedTechnicalBidList" class="nav-link">Approved Technical Bid</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=approvePriceBid" class="nav-link">Approve Price Bid</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=approveTechnicalPriceBid" class="nav-link">Approve Technical Price Bid</a></li>
                        <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=finalTenderSearch" class="nav-link">Final Close Tender</a></li>
                        <li class="sub-nav-item mb-1"><a href="dashboard.htm?act=tenderClosedByForce" class="nav-link"> Tender Close By Force</a></li>
                            <c:if test="${fn:contains(sessionScope.userRights.authorizeTender,'1')}">
                            <li class="sub-nav-item mb-1"><a href="tenderMaster.htm?act=searchTenderSubmit" class="nav-link">Tender Prepone Date</a></li>

                        </c:if>
                            <c:if test="${fn:contains(sessionScope.userRights.grnExecutive,'1')}">
                            <li class="sub-nav-item mb-1"><a href="poDetails.htm?act=grnExecutiveApprovalList" class="nav-link">GRN Executive Approval</a></li>

                        </c:if>
                            <c:if test="${fn:contains(sessionScope.userRights.financialApproval,'1')}">
                            <li class="sub-nav-item mb-1"><a href="poDetails.htm?act=financialExecutiveApprovalList" class="nav-link">Financial Executive Approval</a></li>

                        </c:if>

                    </ul>	
                </div>
            </li>



            <li class="side-nav-item has-children mb-2 ">
                <a href="javascript:void(0)" class="nav-link ">
                    <i class="fa-solid fa-chart-column fa-fw mr-3"></i>
                    Report
                </a>
                <div class="drop-down transition-0" style="display: none;">
                    <ul class="sub-menu list-unstyled pt-2 pb-1">

                        <li class="sub-nav-item mb-1">
                            <a href="tenderMaster.htm?act=activityLog" class="nav-link">
                                Activity Logs
                            </a>
                        </li>

                        <li class="sub-nav-item mb-1">
                            <a href="prMaster.htm?act=prSummaryReport" class="nav-link">
                                PR Summary Report
                            </a>
                        </li>
                        <li class="sub-nav-item mb-1">
                            <a href="tenderMaster.htm?act=tenderReport" class="nav-link">
                                Tender Report
                            </a>
                        </li>


                        <li class="sub-nav-item mb-1">
                            <a href="tenderMaster.htm?act=tenderDailyReport" class="nav-link">
                                Tender Daily Report
                            </a>
                        </li>

                        <li class="sub-nav-item mb-1">
                            <a href="tenderMaster.htm?act=searchByItem" class="nav-link">
                                Search By Item Code
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
    </section>


</html>
