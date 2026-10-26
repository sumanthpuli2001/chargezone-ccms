<%-- 	
Document   : NavbarCmss	
Created on : 25-May-2020, 14:40:47	
Author     : Aman Bahukhandi 	
--%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>	
<!DOCTYPE html>	
<html>	
    <head>	
        <style>
            body{
                margin: 0;
                padding: 0;
                height:100vh;
                overflow-y: auto
            }

            .main-sidebar{
                height: 50vh;
                overflow-y: auto;
            }

            .treeview-menu{
                max-height: calc(60vh - 50px);
                overflow-y: auto;
            }
            .fa-angle-left {
                transition: transform 0.2s ease-in-out;
                transform: rotate(0deg);
            }

            .fa-angle-left.rotated {
                transform: rotate(-90deg);
            }

        </style>


    </head>	
    <!-- Left side column. contains the logo and sidebar -->	
    <aside class="main-sidebar">	
        <!-- sidebar: style can be found in sidebar.less -->	
        <section class="sidebar" style="background-color: #fff;height: 100%;">	
            <ul class="sidebar-menu">	
                <li class="treeview">	
                    <a href="homeController.htm?act=openHomePage">	
                        <i class="fa fa-home fa-lg" style="color: #424242;"></i> <span style="color: #424242;">Homepage</span>	
                    </a>	
                </li>


                <c:if test="${fn:contains(sessionScope.userRights.createTender,'1')}">
                    <li class="treeview">	
                        <a href="dashboard.htm?act=tenderDashboard">	
                            <i class="fa fa-dashboard" style="color: #424242;"></i> <span style="color: #424242;">Dashboard</span>	
                        </a>	
                    </li>
                </c:if>



                <c:if test="${fn:contains(sessionScope.userRights.createTender,'0')}">

                    <li class="treeview">	
                        <a href="dashboard.htm?act=tendernoRightsDashboard">	
                            <i class="fa fa-dashboard" style="color: #424242;"></i> <span style="color: #424242;">Dashboard</span>	
                        </a>	
                    </li>
                    
                </c:if>

                <li class="treeview">	
                    <a href="#" class="dropdown-btn">	
                        <i class="fa fa-folder-open" style="color: #585858;"></i>

                        <span style="color: #585858;">Forms</span>	
                        <i class="fa fa-angle-left pull-right"></i>	
                    </a>	
                    <ul class="treeview-menu">	
                        <c:if test="${fn:contains(sessionScope.userRights.siteSurvey,'1')}">
                            <li> <a href="oapForm.htm?act=Sitesurvey">	
                                    <i class="fa fa-circle-o" ></i> <span>Site Survey</span>	
                                </a>
                            </li> 
                            <li> <a href="oapForm.htm?act=SiteSurveyReport">	
                                    <i class="fa fa-circle-o" ></i> <span>Site Survey Report</span>	
                                </a>
                            </li>  


                        </c:if>
                        <c:if test="${fn:contains(sessionScope.userRights.oapCreater,'1')}">	

                            <li class="treeview">	
                                <a href="oapForm.htm?act=oapseachReport">	
                                    <i class="fa fa-circle-o" ></i> <span >OAP Search</span>	
                                </a>	
                            </li>
                            <li class="treeview">	
                                <a href="oapForm.htm?act=oapFormAppovalList">	
                                    <i class="fa fa-circle-o" ></i> <span >OAP Form List</span>	
                                </a>	
                            </li>
                            <li class="treeview">	
                                <a href="oapForm.htm?act=SaveAsDraftList">	
                                    <i class="fa fa-circle-o" ></i> <span >OAP Save As Draft</span>	
                                </a>	
                            </li> 
                        </c:if>
                        <!--                        <li class="treeview">	
                                                    <a href="oapForm.htm?act=oapForm">	
                                                        <i class="fa fa-circle-o" ></i> <span >OAP Form Create</span>	
                                                    </a>	
                                                </li>-->

                        <c:if test="${fn:contains(sessionScope.userRights.oapApproval,'1')}">
                            <li class="treeview">	
                                <a href="oapForm.htm?act=OapApproval">	
                                    <i class="fa fa-circle-o" ></i> <span >OAP Approval</span>	
                                </a>	
                            </li>
                        </c:if>
                        <!--                        <li class="treeview">	
                                                    <a href="oapForm.htm?act=oapKickOffForm">	
                                                        <i class="fa fa-circle-o" ></i> <span >OAP Assign </span>	
                                                    </a>	
                                                </li>-->
                        <li class="treeview">
                            <c:if test="${fn:contains(sessionScope.userRights.executiveHead,'1')}">
                                <a href="oapForm.htm?act=oapKickOffForm">	
                                    <i class="fa fa-circle-o" ></i> <span > OAP Executive Head </span>	
                                </a>	
                            </li>
                        </c:if>




                        <li class="treeview">	
                            <c:if test="${fn:contains(sessionScope.userRights.projectCordinator,'1')}">	

                                <a href="oapForm.htm?act=CrcFormApproveList">	
                                    <i class="fa fa-circle-o" ></i> <span >CRC Form</span>	
                                </a>



                                <a href="oapForm.htm?act=CrcFormList">	
                                    <i class="fa fa-circle-o" ></i> <span >CRC Form List</span>	
                                </a>	




                            </li>
                        </c:if>
                        <!--                        <li class="treeview">	
                                                    <a href="oapForm.htm?act=oapKickOffForm">	
                                                        <i class="fa fa-circle-o" ></i> <span >OAP  Assign </span>	
                                                    </a>	
                                                </li>-->


                        <li class="treeview">	
                            <a href="oapForm.htm?act=CrcFormApprovalUser">	
                                <i class="fa fa-circle-o" ></i> <span >CRC Form Approval</span>	
                            </a>	
                        </li>

                        <c:if test="${fn:contains(sessionScope.userRights.aocCreater,'1')}">
                            <li class="treeview">	
                                <a href="oapForm.htm?act=aocseachReport">	
                                    <i class="fa fa-circle-o" ></i> <span >AOC Search</span>	
                                </a>	
                            </li>
                            <li class="treeview">	
                                <a href="aocForm.htm?act=aocFormAppovalList">	
                                    <i class="fa fa-circle-o" ></i> <span >AOC Form List </span>	
                                </a>	
                            </li>
                            <li class="treeview">	
                                <a href="aocForm.htm?act=AocSaveAsDraftList">	
                                    <i class="fa fa-circle-o" ></i> <span >AOC Save As Draft</span>	
                                </a>	
                            </li> 
                        </c:if>
                        <!--                        <li class="treeview">	
                                                    <a href="aocForm.htm?act=aocForm">	
                                                        <i class="fa fa-circle-o" ></i> <span >AOC Form Create</span>	
                                                    </a>	
                                                </li>-->
                        <c:if test="${fn:contains(sessionScope.userRights.aocApproval,'1')}">
                            <li class="treeview">	
                                <a href="aocForm.htm?act=AocApproval">	
                                    <i class="fa fa-circle-o" ></i> <span >AOC Approval</span>	
                                </a>	
                            </li>
                        </c:if>
                        <li class="treeview">
                            <c:if test="${fn:contains(sessionScope.userRights.executiveHead,'1')}">

                                <a href="aocForm.htm?act=aocKickOffForm">	
                                    <i class="fa fa-circle-o" ></i> <span >AOC Executive Head </span>	
                                </a>	
                            </li>
                        </c:if>

                        <li class="treeview">


                            <c:if test="${fn:contains(sessionScope.userRights.projectCordinator,'1')}">
                                <a href="aocForm.htm?act=kickoffFormApproveList">	
                                    <i class="fa fa-circle-o" ></i> <span >Kickoff Form Create</span>	
                                </a>	

                                <a href="aocForm.htm?act=KickOffFormList">	
                                    <i class="fa fa-circle-o" ></i> <span >Kickoff Form List</span>	
                                </a>	



                            </li>
                        </c:if>


                        <li class="treeview">	
                            <a href="aocForm.htm?act=KickOffFormApprovalUser">	
                                <i class="fa fa-circle-o" ></i> <span>Kickoff Form Approval</span>	
                            </a>	
                        </li>  
                        <c:if test="${fn:contains(sessionScope.userRights.oapApprovalCreater,'1')}">
                            <li class="treeview">	
                                <a href="oapForm.htm?act=DesignTeam">	
                                    <i class="fa fa-circle-o" ></i> <span>Design Manager</span>	
                                </a>	
                            </li>
                        </c:if>   
                        <c:if test="${fn:contains(sessionScope.userRights.projectManager,'1')}">
                            <li> <a href="oapForm.htm?act=projectmanager">	
                                    <i class="fa fa-circle-o" ></i> <span >Project Manager</span>	
                                </a></li> 

                        </c:if>  
                        <c:if test="${fn:contains(sessionScope.userRights.aocApprovalCreater,'1')}">
                            <li> <a href="oapForm.htm?act=Designcordinator">	
                                    <i class="fa fa-circle-o" ></i> <span >Design Co-Ordinator</span>	
                                </a></li> 

                        </c:if>
                        <li class="treeview">	
                            <a href="oapForm.htm?act=DesigncoordinatorApproval">	
                                <i class="fa fa-circle-o" ></i> <span >Design Co-Ordinator Approval</span>	
                            </a>	
                        </li>

                        <c:if test="${fn:contains(sessionScope.userRights.networkTeam,'1')}">
                            <li> <a href="oapForm.htm?act=NetworkTeam">	
                                    <i class="fa fa-circle-o" ></i> <span >Network Team</span>	
                                </a></li> 

                        </c:if>
                        <c:if test="${fn:contains(sessionScope.userRights.financeTeam,'1')}">
                            <li> <a href="oapForm.htm?act=FinanceTeam">	
                                    <i class="fa fa-circle-o" ></i> <span >Finance Team</span>	
                                </a></li> 

                        </c:if>
                        <c:if test="${fn:contains(sessionScope.userRights.oapaocReport,'1')}">
                            <li> <a href="oapForm.htm?act=oapRightsReport">	
                                    <i class="fa fa-circle-o" ></i> <span >OAP  Report</span>	
                                </a></li> 

                        </c:if>
                        <c:if test="${fn:contains(sessionScope.userRights.oapaocReport,'1')}">
                            <li> <a href="oapForm.htm?act=aocRightsReport">	
                                    <i class="fa fa-circle-o" ></i> <span >AOC  Report</span>	
                                </a></li> 

                        </c:if>
                        <li> 
                            <a href="oapForm.htm?act=oapprojectmanagerApprovemulti">	
                                <i class="fa fa-circle-o" ></i> <span>Deliverable By Project Manager</span>	
                            </a>
                        </li> 

                        <li> <a href="oapForm.htm?act=deliverableView">	
                                <i class="fa fa-circle-o" ></i> <span>Create PR</span>	
                            </a></li> 



                        <%--<c:if test="${fn:contains(sessionScope.userRights.oapApprovalCreater,'1')}">--%>
                        <!--                            <li> <a href="oapForm.htm?act=CreatePrFromOap">	
                                                            <i class="fa fa-circle-o" ></i> <span >Create PR From Oap</span>	
                                                        </a></li> -->

                        <%--</c:if>--%>   

                        <%--<c:if test="${fn:contains(sessionScope.userRights.aocApprovalCreater,'1')}">--%>
                        <!--                            <li> <a href="aocForm.htm?act=CreatePrFromAoc">	
                                                            <i class="fa fa-circle-o" ></i> <span >Create PR From Aoc</span>	
                                                        </a></li> -->

                        <%--</c:if>--%> 








                    </ul>	
                </li>







                <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	
                    <li class="treeview">	
                        <a href="#" class="dropdown-btn" >	
                            <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>	
                            <span style="color: #585858;">Master</span>	
                            <i class="fa fa-angle-left pull-right"></i>	
                        </a>	
                        <ul class="treeview-menu">
                            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	
                                <li><a href="employeeMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Employee</a></li>	
                                </c:if>

                            <li><a href="auditorMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Auditor</a></li>	



                            <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">
                                <li><a href="right.htm?act=showList"><i class="fa fa-circle-o"></i>Add Right</a></li>

                            </c:if>
                            
                                                        <li><a href="employeeMaster.htm?act=showDepartmentList"><i class="fa fa-circle-o"></i>Department</a></li>	
                                                        <li><a href="employeeMaster.htm?act=showDesignationList"><i class="fa fa-circle-o"></i>Designation</a></li>	
                                                        <li><a href="employeeMaster.htm?act=showCompanyLocationList"><i class="fa fa-circle-o"></i>Company Location</a></li>	
                                                        <li><a href="plantMaster.htm?act=showPlantList"><i class="fa fa-circle-o"></i>Plant</a></li>
                                                        <li><a href="sapConnection.htm?act=sapList"><i class="fa fa-circle-o"></i>SAP Connection</a></li> 	
                                                        <li><a href="smtpDetails.htm?act=showSmtpDetailsList"><i class="fa fa-circle-o"></i>SMTP Details</a></li>
                                                        <li><a href="materialGroupMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Material Group Master</a></li> 	
                            <li><a href="materialTypeMaster.htm?act=showMaterial"><i class="fa fa-circle-o"></i>Material Type Master</a></li>
                            <li><a href="materialMaster.htm?act=searchPage"><i class="fa fa-circle-o"></i>Material Master</a></li>  
                                <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	
                                <li><a href="tenderApproval.htm?act=showList"><i class="fa fa-circle-o"></i>Tender Approval</a></li>
                                <li><a href="vendorApprovalSetting.htm?act=showList"><i class="fa fa-circle-o"></i>Vendor Approval</a></li>
                                <li><a href="tenderApproval.htm?act=showList1"><i class="fa fa-circle-o"></i>Committee Approval</a></li>
                                <li><a href="approvalSetting.htm?act=showList"><i class="fa fa-circle-o"></i>Vendor Approval Setting</a></li>
                                <li><a href="termsCondition.htm?act=showList"><i class="fa fa-circle-o"></i>Terms Condition</a></li>
                                <li><a href="termsConditionParameter.htm?act=showList"><i class="fa fa-circle-o"></i>Terms Condition Parameter</a></li>

                            </c:if>
                            <li><a href="group.htm?act=showVendorTechnicalCriteriaList"><i class="fa fa-circle-o"></i>Vendor Technical Criteria</a></li>
                            <li><a href="group.htm?act=showGroupMasterList"><i class="fa fa-circle-o"></i>Group Master</a></li>
                            <li><a href="group.htm?act=showGroupCategoryList"><i class="fa fa-circle-o"></i>Group Category</a></li>
                            <li><a href="group.htm?act=showGroupSubCategoryList"><i class="fa fa-circle-o"></i>Group Sub Category</a></li>
                            <li><a href="group.htm?act=showList"><i class="fa fa-circle-o"></i>HR Criteria Master</a></li> 	
                            <li><a href="group.htm?act=showList1"><i class="fa fa-circle-o"></i>Safety Criteria Master</a></li> 
                            <li><a href="productTypeMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Product Master</a></li>
                            <li><a href="valuationClassMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Valuation Master</a></li>
                            <li><a href="productGroupMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Product Group Master</a></li>
                            <li><a href="companyMaster.htm?act=showlist"><i class="fa fa-circle-o"></i>Company Master</a></li>

                            <li><a href="vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList"><i class="fa fa-circle-o"></i>Department Wise Approval</a></li>

                            <li><a href="employeeMaster.htm?act=showCompanyLocationList"><i class="fa fa-circle-o"></i>Company Location</a></li>
                            <li><a href="oapForm.htm?act=DocumentList"><i class="fa fa-circle-o"></i>Document</a></li>
                            <li><a href="oapMaster.htm?act=showList"><i class="fa fa-circle-o"></i>OAP Master/work flow</a></li>
                            <li><a href="profitCenter.htm?act=profitCenterList"><i class="fa fa-circle-o"></i>Profit Center</a></li>	
                            <li><a href="companyMaster.htm?act=showlist"><i class="fa fa-circle-o"></i>Company Master</a></li>
                            <li><a href="projectType.htm?act=ProjectTypeList"><i class="fa fa-circle-o"></i>Project Type</a></li>
                            <li><a href="currencyMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Currency Master</a></li>
                            <li><a href="stationType.htm?act=StationTypeList"><i class="fa fa-circle-o"></i>Station Type Master</a></li>
                            <li><a href="tenant.htm?act=TenantList"><i class="fa fa-circle-o"></i>Tenant Master</a></li>
                            <li><a href="investmentProfile.htm?act=InvestmentProfileList"><i class="fa fa-circle-o"></i>Investment Profile</a></li>
                            <li><a href="projectProfile.htm?act=ProjectProfileList"><i class="fa fa-circle-o"></i>Project Profile</a></li>

                            <li><a href="employeeMasteroa.htm?act=emailMasterList"><i class="fa fa-circle-o"></i>Email Master</a></li>


                            <li>
                                <a href="discomMaster.htm?act=showlist">	
                                    <i class="fa fa-circle-o" ></i> <span>Discom Master</span>	
                                </a>
                            </li>
                            <li><a href="projectNameMaster.htm?act=ProjectNameMasterList"><i class="fa fa-circle-o"></i>Project Name Master</a></li>

                            <li><a href="connectionType.htm?act=ConnectionTypeList"><i class="fa fa-circle-o"></i>Connection Type</a></li>

                            <li>
                                <a href="purchasingOrganisation.htm?act=showlist">	
                                    <i class="fa fa-circle-o" ></i> <span>Purchasing Organisation</span>	
                                </a>
                            </li>
                            <li>
                                <a href="plantMasters.htm?act=showlist">	
                                    <i class="fa fa-circle-o" ></i> <span>Plant Masters</span>	
                                </a>
                            </li>
                            <li>
                                <a href="locationMasters.htm?act=showlist">	
                                    <i class="fa fa-circle-o" ></i> <span>Location Masters</span>	
                                </a>
                            </li>
                            <li>
                                <a href="bpGroupMasters.htm?act=showList">	
                                    <i class="fa fa-circle-o" ></i> <span>BP Group Masters</span>	
                                </a>
                            </li>
                            <li>
                                <a href="vendor.htm?act=showList">	
                                    <i class="fa fa-circle-o" ></i> <span>Vendor Percentage</span>	
                                </a>
                            </li>
                            <li><a href="vendorInformation.htm?act=showTaxCategoryMasterList"><i class="fa fa-circle-o"></i>Tax Category Master</a></li>
                            <li><a href="vendorInformation.htm?act=showGroupForCalMasterList"><i class="fa fa-circle-o"></i>Group Calculation Master</a></li>
                            <li><a href="riskCategory.htm?act=showRiskCategoryList"><i class="fa fa-circle-o"></i>Risk Category Master</a></li>
                            <li><a href="vendorInviteSource.htm?act=showVendorInviteSourceList"><i class="fa fa-circle-o"></i>Vendor Invite Source Master</a></li>

                            <li><a href="declarationLetter.htm?act=showlist"><i class="fa fa-circle-o"></i>Declaration Letter</a></li>

                        </ul>	

                    </li>	
                </c:if>	
                    
                    
                    
                    
                    
                <c:if test="${fn:contains(sessionScope.userRights.employeeMgt,'1')}">	
                    <li class="treeview">	
                        <a href="#" class="dropdown-btn" >	
                            <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>	
                            <span style="color: #585858;">Vendor Registration Master</span>	
                            <i class="fa fa-angle-left pull-right"></i>	
                        </a>	
                        <ul class="treeview-menu">

                            <li><a href="vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList"><i class="fa fa-circle-o"></i>Department Wise Approval</a></li>

                            <li><a href="auditorMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Auditor</a></li>	

                            <li><a href="vendorCriteriaMaster.htm?act=showVendorCriteriaList"><i class="fa fa-circle-o"></i>Vendor Criteria Master</a></li>
                            <!--<li><a href="group.htm?act=showItCriteriaList"><i class="fa fa-circle-o"></i>Vendor IT Criteria</a></li>-->
                            <li><a href="group.htm?act=showGroupMasterList"><i class="fa fa-circle-o"></i>Group Master</a></li>
                            <li><a href="group.htm?act=showGroupCategoryList"><i class="fa fa-circle-o"></i>Group Category</a></li>
                            <li><a href="group.htm?act=showGroupSubCategoryList"><i class="fa fa-circle-o"></i>Group Sub Category</a></li>
                            <li><a href="declarationLetter.htm?act=showlist"><i class="fa fa-circle-o"></i>Declaration Letter</a></li>

                            <li><a href="riskCategory.htm?act=showRiskCategoryList"><i class="fa fa-circle-o"></i>Risk Category Master</a></li>
                            <li><a href="vendorInviteSource.htm?act=showVendorInviteSourceList"><i class="fa fa-circle-o"></i>Vendor Invite Source Master</a></li>

                        </ul>	

                    </li>	
                </c:if>	
                <c:if test="${fn:contains(sessionScope.userRights.vendorMgt,'1')||fn:contains(sessionScope.userRights.venderInvite,'1') || fn:contains(sessionScope.userRights.venderInformation,'1') ||fn:contains(sessionScope.userRights.venderRequest,'1') ||fn:contains(sessionScope.userRights.buyerApproval,'1')||fn:contains(sessionScope.userRights.financialApproval,'1') ||fn:contains(sessionScope.userRights.technicalApproval,'1') ||fn:contains(sessionScope.userRights.hrApproval,'1') ||fn:contains(sessionScope.userRights.safetyApproval,'1') ||fn:contains(sessionScope.userRights.activeVendor,'1') ||fn:contains(sessionScope.userRights.allVendor,'1') ||fn:contains(sessionScope.userRights.vendorTechnicalCriteriaMaster,'1') ||fn:contains(sessionScope.userRights.hrCriteriaMaster,'1') ||fn:contains(sessionScope.userRights.safetyCriteriaMaster,'1') ||fn:contains(sessionScope.userRights.itApproval,'1')}">	
                    <li class="treeview">	
                        <a href="#" class="dropdown-btn">	
                            <i class="fa fa-folder-open" style="color: #585858;"></i>	
                            <span style="color: #585858;">Vendor Management</span>	
                            <i class="fa fa-angle-left pull-right"></i>	
                        </a>	
                        <ul class="treeview-menu">
                            <c:if test="${fn:contains(sessionScope.userRights.venderInvite,'1')}">
                                <li><a href="vendorInvitation.htm?act=addVendorInvitation"><i class="fa fa-circle-o"></i>Invite Vendor</a></li>
                                <li><a href="vendorInvitation.htm?act=requestVendor"><i class="fa fa-circle-o"></i>Requested Vendor</a></li> 

                            </c:if>


                            <li><a href="vendorInformation.htm?act=newVendor"><i class="fa fa-circle-o"></i>Vendor Information</a></li> 

                            <c:if test="${fn:contains(sessionScope.userRights.complianceOfficer,'1')}">
                                <li><a href="vendorInformation.htm?act=ComplianceOfficer"><i class="fa fa-circle-o"></i>Compliance Officer</a></li>

                            </c:if>



                            <c:if test="${fn:contains(sessionScope.userRights.venderRequest,'1')}">
                                <li><a href="vendorInvitation.htm?act=showInviteList"><i class="fa fa-circle-o"></i>New Vendor Recommendation</a></li>

                            </c:if>

                            <li><a href="vendorInvitation.htm?act=vendorRequestApproval"><i class="fa fa-circle-o"></i>Vendor Request Approval</a></li> 

                            <li><a href="vendorInformation.htm?act=addVendor"><i class="fa fa-circle-o"></i>Permanent Vendor</a></li>
                            <li><a href="vendorInformation.htm?act=tempVendor"><i class="fa fa-circle-o"></i>Temporary Vendor</a></li>
                            <li><a href="vendorInformation.htm?act=searchVendor"><i class="fa fa-circle-o"></i>Search Vendor</a></li>
                            <!--<li><a href="tenderMaster.htm?act=retrieveVendor"><i class="fa fa-circle-o"></i>Retrieve Vendor</a></li>--> 
                            <li><a href="vendorInformation.htm?act=activeVendor"><i class="fa fa-circle-o"></i>Active Vendor</a></li>

                            <li><a href="vendor.htm?act=uploadVendor"><i class="fa fa-circle-o"></i>Upload Vendor</a></li>
                        </ul>	
                    </li>
                </c:if>
                <c:if test="${fn:contains(sessionScope.userRights.prManagement,'1')}">	

                    <li class="treeview">	
                        <a href="#" class="dropdown-btn">	
                            <i class="fa fa-folder-open" style="color: #585858;"></i>	
                            <span style="color: #585858;">PR Management</span>	
                            <i class="fa fa-angle-left pull-right"></i>	
                        </a>	
                        <ul class="treeview-menu">	

                            <li><a href="prMaster.htm?act=selectPR"><i class="fa fa-circle-o"></i>Create PR</a></li>
                            <li><a href="prMaster.htm?act=listPRList"><i class="fa fa-circle-o"></i>PR List</a></li>
                            <li><a href="prMaster.htm?act=approvePRList"><i class="fa fa-circle-o"></i>Approve PR</a></li>
                            <li><a href="prMaster.htm?act=searchPR"><i class="fa fa-circle-o"></i>Search PR</a></li>
                            <li><a href="prMaster.htm?act=closePrNavbar"><i class="fa fa-circle-o"></i>Close PR By Force</a></li>

                        </ul>	
                    </li>
                </c:if>



                <li class="treeview">	
                    <a href="#" class="dropdown-btn">	
                        <i class="fa fa-folder-open" style="color: #585858;"></i>	
                        <span style="color: #585858;">Tender Management</span>	
                        <i class="fa fa-angle-left pull-right"></i>	
                    </a>	
                    <ul class="treeview-menu">	
                        <c:if test="${fn:contains(sessionScope.userRights.createTender,'1')}">

                            <li><a href="tenderMaster.htm?act=selectTypeTender"><i class="fa fa-circle-o"></i>Create Tender</a></li>
                                <c:if test="${fn:contains(sessionScope.userRights.authorizeTender,'1')}">
                                <li><a href="prMaster.htm?act=pendingPRList"><i class="fa fa-circle-o"></i>Create Tender From PR</a></li>
                                </c:if>
                                <c:if test="${fn:contains(sessionScope.userRights.authorizeTender,'0')}">
                                <li><a href="prMaster.htm?act=pendingPRList1"><i class="fa fa-circle-o"></i>Create Tender From PR</a></li>
                                </c:if>    
                            <li><a href="tenderMaster.htm?act=liveTenderList"><i class="fa fa-circle-o"></i>Corrigendum</a></li>
                            </c:if>


                        <li><a href="tenderMaster.htm?act=receiveBidList"><i class="fa fa-circle-o"></i>Receive Bids</a></li>
                        <li><a href="tenderMaster.htm?act=receiveBidListBuyer"><i class="fa fa-circle-o"></i>Technical Bid Approve</a></li>

                        <li><a href="tenderMaster.htm?act=receiveCommercialBidList"><i class="fa fa-circle-o"></i>Receive Commercial Bids</a></li>

                        <li><a href="tenderMaster.htm?act=pastTechnicalBid"><i class="fa fa-circle-o"></i>Past Technical Bid</a></li>

                        <!-- <c:if test="${fn:contains(sessionScope.userRights.tenderBidOpen,'1')  || fn:contains(sessionScope.userRights.createTender,'1')}">
                             <li><a href="tenderMaster.htm?act=receiveAdminBidList"><i class="fa fa-circle-o"></i>Receive Committee Bids</a></li>
                        </c:if>     -->

                        <li><a href="tenderMaster.htm?act=pastTenderSearch"><i class="fa fa-circle-o"></i>Bid Open Tender</a></li>
                        <li><a href="tenderMaster.htm?act=approvedTechnicalBidList"><i class="fa fa-circle-o"></i>Approved Technical Bid</a></li>

                        <li><a href="tenderMaster.htm?act=approvePriceBid"><i class="fa fa-circle-o"></i>Approve Price Bid</a></li>
                        <li><a href="tenderMaster.htm?act=approveTechnicalPriceBid"><i class="fa fa-circle-o"></i>Approve Technical Price Bid</a></li>

                        <li><a href="tenderMaster.htm?act=finalTenderSearch"><i class="fa fa-circle-o"></i>Final Close Tender</a></li>

                                                <li><a href="dashboard.htm?act=tenderClosedByForce"><i class="fa fa-circle-o"></i>Tender Close By Force</a></li>

                        <c:if test="${fn:contains(sessionScope.userRights.authorizeTender,'1')}">
                            <li><a href="tenderMaster.htm?act=searchTenderSubmit"><i class="fa fa-circle-o"></i>Tender Prepone Date</a></li>
                            </c:if>

                    </ul>	
                </li>


                <li class="treeview">	
                    <a href="#" class="dropdown-btn">	
                        <i class="fa fa-folder-open" style="color: #585858;"></i>	
                        <span style="color: #585858;">Report</span>	
                        <i class="fa fa-angle-left pull-right"></i>	
                    </a>	
                    <ul class="treeview-menu">	
                        <li><a href="tenderMaster.htm?act=activityLog"><i class="fa fa-circle-o"></i>Activity Logs</a></li>
                        <!--  <li><a href="tenderMaster.htm?act=vendorEvaluation"><i class="fa fa-circle-o"></i>Vendor Evaluation</a></li> -->
                        <li><a href="tenderMaster.htm?act=tenderReport"><i class="fa fa-circle-o"></i>Tender Report</a></li>
                        <li><a href="tenderMaster.htm?act=tenderDailyReport"><i class="fa fa-circle-o"></i>Tender Daily Report</a></li>
                        <li><a href="tenderMaster.htm?act=searchByItem"><i class="fa fa-circle-o"></i>Search By Item Code</a></li>

                        <!--  <li><a href="tenderMaster.htm?act=attachmentReport"><i class="fa fa-circle-o"></i>Attachment Report</a></li> -->
                        <!--  <li><a href="tenderMaster.htm?act=leadTimeReport"><i class="fa fa-circle-o"></i>Lead Time Report</a></li> -->
                        <!--    <li><a href="tenderMaster.htm?act=tenderFollowupReport"><i class="fa fa-circle-o"></i>Tender Follow Up Report</a></li> -->
                        <!--    <li><a href="employeeMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Indenter Conversation</a></li> -->
                    </ul>	
                </li>

                <!--     <li class="treeview">
                         <a href="StorageYard/Admin_Guide.pdf" target="blank">	
                             <i class="glyphicon glyphicon-gift" style="color: #585858;"></i> <span style="color: #424242;">User Help File</span>	
                         </a>	
                     </li>	
                     <li class="treeview">
                         <a href="StorageYard/Vendor_Guide.pdf" target="blank">	
                             <i class="glyphicon glyphicon-gift" style="color: #585858;"></i> <span style="color: #424242;">Vendor Help File</span>	
                         </a>	
                     </li>	
                             
                -->    	

            </ul>	
        </section>	
        <!-- /.sidebar -->	
    </aside>	
</html>