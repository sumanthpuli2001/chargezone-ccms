<%-- 
    Document   : AuditorApprovalView
    Created on : 12 Dec, 2024, 3:18:14 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Risk Evaluator Approval</title>
        <script>
            function recycle() {
                var id = document.getElementsByName('id1');
                y = id[0].value;
                var comment = document.getElementsByName('comment');
                comment1 = comment[0].value;
                window.location = 'vendorInformation.htm?act=RecycleAuditorApproval&id=' + y + '&comment=' + comment1;
            }

            function reject() {
                var id = document.getElementsByName('id1');
                y = id[0].value;
                var comment = document.getElementsByName('comment');
                comment1 = comment[0].value;
                window.location = 'vendorInformation.htm?act=rejectvendor&id=' + y + '&comment=' + comment1;
            }
            
        </script>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewAuditor.jsp"%>

            <section class="main-content">
                <form:form action="vendorInformation.htm?act=ButtonAuditorApprovals1"  enctype="multipart/form-data" method="post"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Risk Evaluator Approval</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn recycle-btn mr-3" formaction="vendorInformation.htm?act=RecycleAuditorApproval&id=${vendorInformation1.id}">Recycle</button>
                            <button type="submit" class="btn theme-btn" id="submit1"  title="submit1" value="Approve" >Submit</button>
                        </div>
                    </div>
                    <hr>
                    <c:if test="${!empty successMessage}">
                        <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty failureMessage}">
                        <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                    </c:if>

                    <c:forEach var="list" items="${list}" varStatus="status">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <input type="hidden" id="id1" name="id1" value="${list.id}">

                                    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">VENDOR DETAILS</td>
                                                                <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a href="vendorInformation.htm?act=vendorDetailsDocxdownloadzip&id1=${list.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                            <tr >
                                                                <th style="width: 25%;">Company Name</th>
                                                                <td style="width: 25%;">${list.companyName}</td>
                                                                <th style="width: 25%;">Email Id </th>
                                                                <td style="width: 25%;">${list.vendorEmailId}</td>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <th style="">   <c:if test="${list.policyAccept=='1'}">Code of Conduct (Sign & Stamp in all Pages)</c:if>
                                                                    <c:if test="${list.policyAccept=='0'}">Deviation Policy</c:if></th>
                                                                <td><c:if test="${list.policyAccept=='1'}">Accept</c:if>
                                                                    <c:if test="${list.policyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                                                    <c:if test="${list.policy1File!='' &&  list.policy1File!=null}">
                                                                        ${list.policy1File}<a class="fw-600 gradient-text" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}">
                                                                            &nbsp;<span class="fa fa-download"></span></a>
                                                                       <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${list.id}/${list.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
     
                                                                    </c:if></td>
                                                                <th style="">    <c:if test="${list.ndaPolicyAccept=='1'}">NDA (Sign & Stamp in all Pages)</c:if>
                                                                    <c:if test="${list.ndaPolicyAccept=='0'}">NDA Policy</c:if></th> 
                                                                <td><c:if test="${list.ndaPolicyAccept=='1'}">Accept</c:if>
                                                                    <c:if test="${list.ndaPolicyAccept=='0'}"><span style="color: red;">Not Accept</span></c:if><br>
                                                                    <c:if test="${list.ndaPolicyFile!='' &&  list.ndaPolicyFile!=null}">
                                                                        ${list.ndaPolicyFile}<a class="fw-600 gradient-text" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.ndaPolicyFile}&id=${list.id}">
                                                                            &nbsp;<span class="fa fa-download"></span></a> 
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${list.id}/${list.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>

                                                                        </c:if>
                                                                </td>



                                                            </tr>
                                                            <tr>
                                                                <th  style="">Type of Company</th>
                                                                <td>${list.typeOfConcern}</td>
                                                                <c:choose>
                                                                    <c:when test="${list.typeOfConcern == 'Sole Proprietorship'}">
                                                                        <th  style="">
                                                                            Shop & Establishment License
                                                                        </th>
                                                                    </c:when>

                                                                    <c:when test="${list.typeOfConcern == 'Hindu Undivided Family ( HUF)'}">
                                                                        <th  style="">
                                                                            Shop & Establishment License and HUF Deed
                                                                        </th>
                                                                    </c:when>

                                                                    <c:when test="${list.typeOfConcern == 'Partnership Firm'}">
                                                                        <th  style="">
                                                                            1. Shop & Establishment License and Partnership Deed
                                                                        </th>
                                                                    </c:when>

                                                                    <c:when test="${list.typeOfConcern == 'Limited Liability Partnership ( LLP)'}">
                                                                        <th  style="">
                                                                            1. Shop & Establishment License and LLP Agreement
                                                                        </th>
                                                                    </c:when>

                                                                    <c:when test="${list.typeOfConcern == 'Private/Public Company'}">
                                                                        <th  style="">
                                                                            Certificate of Incorporation (MCA)
                                                                        </th>
                                                                    </c:when>

                                                                    <c:otherwise>
                                                                        <th  style="">Proof Of Attachment</th>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                <td> ${list.panFile}<a class="fw-600 gradient-text" href="vendorInformation.htm?act=downloadcompanyProof&amp;fileName=${list.companyProof}&amp;id=${list.id}">
                                                                        &nbsp;<span class="fa fa-download"></span>
                                                                    </a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${list.id}/${list.companyProof}"><span class="fa fa-solid fa-eye"></span></a>
                                                                
                                                                <br>
                                                                ${list.panFile}<a class="fw-600 gradient-text" href="vendorInformation.htm?act=downloadcompanyProof&amp;fileName=${list.companyProof2}&amp;id=${list.id}">
                                                                        &nbsp;<span class="fa fa-download"></span>
                                                                    </a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${list.id}/${list.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>

                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <th  style="">Year of Establishment of Company</th>
                                                                <td>${list.establishment}</td>
                                                                <th></th>
                                                               <td></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>

                                   <div class="table-responsive">
                                    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">

                                                            <thead>

                                                                <tr class="table-title">
                                                                    <td colspan="8" style="font-weight: bold; background-color: skyblue; text-align: center;">REGISTER ADDRESS</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">Street / House No.</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${list.officeAddressLine1}</span></td>
                                                                    <th style="width: 25%;">Street-1</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${list.officeAddressLine2}</span></td>
                                                                </tr>

                                                            </thead>

                                                            <tbody>

                                                                <tr>
                                                                    <th style="width: 25%;">Street-2</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${list.officeAddressLine3}</span></td>
                                                                    <th style="width: 25%;">Country</th>
                                                                    <td style="width: 25%;">${list.officeCountry}</td>

                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">State</th>
                                                                    <td>${list.officeState}</td>
                                                                    <th style="width: 25%;">District</th>
                                                                    <td>${list.officeDistrict}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">City</th>
                                                                    <td>${list.officeCity}</td>
                                                                    <th style="">Postal Code</th>
                                                                    <td>${list.officePin}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">Mobile No</th>
                                                                    <td>+${list.countryCodeoffTele}-${list.officeTelephone}</td>
                                                                    <th style="">Website</th> 
                                                                    <td>${list.officeWebsite}</td>
                                                                </tr>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                                           <div class="table-responsive">
                                    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">

                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="8" style="font-weight: bold; background-color: skyblue; text-align: center;">COMMUNICATION ADDRESS </td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">Street / House No.</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${declaration.altLocalAddress}</span></td>
                                                                    <th style="width: 25%;">Street-1</th>
                                                                    <td style="width: 25%;"><span class="wrap-text">${declaration.altLocalAddress1}</span></td>
                                                                </tr>

                                                                <tr>                                                                
                                                                    <th style="width: 25%;">Street-2</th>
                                                                    <td style="width: 25%;"> <span class="wrap-text">${declaration.altLocalAddress2}</span></td>
                                                                    <th style="width: 25%;">Country</th>
                                                                    <td style="width: 25%;">${declaration.altCountry}</td>
                                                                </tr>

                                                            </thead>

                                                            <tbody>

                                                                <tr>
                                                                    <th style="width: 25%;">State</th>
                                                                    <td>${declaration.altState}</td>
                                                                    <th style="width: 25%;">City</th>
                                                                    <td>${declaration.altCity}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="width: 25%;">District</th>
                                                                    <td>${declaration.altDistrict}</td>
                                                                    <th style="">Postal Code</th>
                                                                    <td>${declaration.altPostalCode}</td>
                                                                </tr>

                                                                <tr>
                                                                    <th style="">Mobile No</th>
                                                                    <td>+${list.countryCodeNewMobiles}-${declaration.altTelephone}</td>
                                                                    <th style="">Email</th>
                                                                    <td>${declaration.altEmail}</td>
                                                                </tr>

                                                                <tr>                                                                    
                                                                    <th style="">Website</th>
                                                                    <td>${declaration.altWebsite}</td>
                                                                    <th style=""></th>
                                                                    <td></td>
                                                                </tr>

                                                            </tbody>
                                                        </table>
                                                    </div>

           <div class="form-group">
    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
        <tr class="table-title">
            <td colspan="3" style="font-weight: bold; background-color: skyblue; text-align: center;">TYPES OF VENDORS</td>
        </tr>
        <c:forEach var="list222" items="${list222}" varStatus="status">
            <tr>
                <!-- Hidden input should be inside a td or outside the table -->
                <td style="display:none;">
                    <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list222[2]}" />
                </td>

                <!-- Display values in visible cells -->
                <td>${list222[2]}</td>
                <td>${list222[3]}</td>
                <td>${list222[4]}</td>
            </tr>
        </c:forEach>
    </table>
</div>
                        <div class="table-responsive">
    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                                                            <thead ><tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue;">Vendor Contacts</td>
                                                                </tr>
                                                                <tr style="">
                                                                    <th>Type</th>
                                                                    <th>Name</th>
                                                                    <th>Job Title</th>
                                                                    <th>Phone No.</th>
                                                                    <th>Email</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>Sales/Commercial Contact(s) </td>
                                                                    <td>${list.sales_name}</td>
                                                                    <td>${list.sales_job}</td>
                                                                    <td>+${list.countryCodeVendorContact}-${list.sales_phone}</td>
                                                                    <td>${list.saleEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Technical Contact(s) </td>
                                                                    <td>${list.technical_name}</td>
                                                                    <td>${list.technical_job}</td>
                                                                    <td>+${list.countryCodeVendorContact1}-${list.technical_phone}</td>
                                                                    <td>${list.technicalContactEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Finance and Accounts </td>
                                                                    <td>${list.quality_name}</td>
                                                                    <td>${list.quality_job}</td>
                                                                    <td>+${list.countryCodeVendorContact2}-${list.quality_phone}</td>
                                                                    <td>${list.qualityEmail}</td>

                                                                </tr>                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                                    <div class="table-responsive">
    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                                                            <thead>
                                                                <tr class="table-title">
                                                                    <td colspan="7" style="font-weight: bold; background-color: skyblue; text-align: center;">MANAGERIAL PERSON DETAILS</td>
                                                                </tr>
                                                                <tr style="">
                                                                    <th>Sr No.</th>
                                                                    <th>Name</th>
                                                                    <th>Designation</th>
                                                                    <th>Phone No.</th>
                                                                    <th>Email</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach items="${mplist}" var="mplist" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td>${mplist.name}</td>
                                                                        <td>${mplist.designation}</td>
                                                                        <td>+${mplist.countryCode}-${mplist.phoneNo}</td>
                                                                        <td>${mplist.emailId}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>
                    </c:forEach>
                          <div class="table-responsive">
    <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="5" style="font-weight: bold; background-color: skyblue;">  PAST WORKING EXPERIENCE DETAILS </td>
                                                                <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a  href="vendorInformation.htm?act=pastWorkingExpDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        <th >Company Name</th>
                                                        <th >Contact Person Name</th>
                                                        <th >Phone No.</th>
                                                        <th >Email</th>
                                                        <th >Designation</th>
                                                        <th >Attachment</th>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="lstwork" items="${lstwork}">
                                                                <tr>
                                                                    <td ><span>${lstwork.companyName}</span> </td> 
                                                                    <td ><span>${lstwork.contactPersonName}</span> </td>

                                                                    <td ><span>+${lstwork.countryCode}-${lstwork.mobileNumber}</span> </td> 
                                                                    <td ><span>${lstwork.email}</span> </td> 
                                                                    <td ><span>${lstwork.designation}</span></td> 

                                                                    <td >
                                                                        <c:if test="${not empty lstwork.attchment}">
                                                                        ${lstwork.attchment}   <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadFileAprrove1&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}">
                                                                            &nbsp;<span class="fa fa-download"></span>    
                                                                        </a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${lstwork.vendorInformationId}/${lstwork.attchment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                        </c:if>
                                                                    </td>




                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>      
                    <h6 class="fw-600">Self Declaration Form</h6>

                    <div >
                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label"><strong>1. Is the organization publicly listed company with shares being traded on any Stock Exchange? <span style="color:red">*</span></strong></label>

                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input type="radio" name="desDecOneFlag" value="1" disabled
                                           ${declaration.desDecOneFlag == 1 ? "checked" : ""}> Yes
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="desDecOneFlag" value="0" disabled
                                           ${declaration.desDecOneFlag == 0 ? "checked" : ""}> No
                                </label>
                            </div>

                            <div class="col-lg-4">
                                <textarea class="textarea-field" id="desDecOne" name="desDecOne" readonly>${declaration.desDecOne}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label"><strong>2. Has the Supplier ever conducted business under any alias..?<span style="color:red">*</span></strong></label>
                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="desDecTwoFlag"
                                           <c:if test="${declaration.desDecTwoFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="desDecTwoFlag" 
                                        <c:if test="${declaration.desDecTwoFlag == 0}">checked</c:if>> No
                                    </label>
                                </div>

                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="desDecTwo" name="desDecTwo" readonly>${declaration.desDecTwo}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    <i class="fas fa-gavel" style="margin-right: 8px;"></i>
                                    3. Litigation History
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether your organization is involved in any legal proceedings?<br>
                                - For Proprietorship organization the Proprietor to declare if he / she is involved in any legal proceedings.<br>
                                - For Partnership organization all or any Partners are involved in any legal proceedings
                            </label>

                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="litigationHistoryDesFlag"
                                           <c:if test="${declaration.litigationHistoryDesFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="litigationHistoryDesFlag" 
                                        <c:if test="${declaration.litigationHistoryDesFlag == 0}">checked</c:if>> No
                                    </label>
                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="litigationHistoryDes" name="litigationHistoryDes" readonly>${declaration.litigationHistoryDes}</textarea>
                            </div>
                        </div>

                        <!-- Political Contributions -->
                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    <i class="fas fa-donate" style="margin-right: 8px;"></i>
                                    4. Political Contributions
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has made any contributions / donations (either of a charitable or political nature), in the past or at present, to a political party / organization affiliated with a political party or a political leader, on behalf of the Third Party / Supplier or in their personal capacity?
                            </label>
                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="politicalContributionDesFlag"
                                           <c:if test="${declaration.politicalContributionDesFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="politicalContributionDesFlag" 
                                        <c:if test="${declaration.politicalContributionDesFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="politicalContributionDes" name="politicalContributionDes" readonly>${declaration.politicalContributionDes}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    <i class="fas fa-exclamation-triangle" style="margin-right: 8px;"></i>
                                    5. Conflict of Interest
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) have any financial interests, personal or familial relationships, or affiliations with Tecso Charge Zone Limited or any of its Directors or employees?
                            </label>
                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="conflictInterestFlag"
                                           <c:if test="${declaration.conflictInsterestDesFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="conflictInterestFlag" 
                                        <c:if test="${declaration.conflictInsterestDesFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="conflictInterestDes" name="conflictInterestDes" readonly>${declaration.conflictInsterestDes}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    <i class="fas fa-gavel" style="margin-right: 8px;"></i>
                                    6.  Use of Executive/Judicial (Public Official) Influence
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has sought or obtained the assistance of a Public Official in connection with providing goods / services to CZ?
                            </label>
                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="executiveJudicialFlag"
                                           <c:if test="${declaration.executiveJudicialDesFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="executiveJudicialFlag" 
                                        <c:if test="${declaration.executiveJudicialDesFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="executiveJudicialDes" name="executiveJudicialDes" readonly>${declaration.executiveJudicialDes}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    <i class="fas fa-user-shield" style="margin-right: 8px;"></i>
                                    7. Politically Exposed Personnel
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Third Party or any person directly or indirectly connected to the Third Party is or has been associated with any political party/ political leader / organization affiliated with a political party or a political leader?
                                <br><i>[For illustrative purposes, ‘Y’ is an employee / proprietor of the Third Party entity and ‘K’, his maternal uncle is a local MLA in Raigad. Herein, ‘Y’ shall be considered as politically exposed for the purposes of disclosure to CZ]</i>
                            </label>
                            <div class="col-lg-2">

                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="politicallyExposedOneFlag"
                                           <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="politicallyExposedOneFlag" 
                                        <c:if test="${declaration.politicallyExposedDesOneFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="politicallyExposedDesOne" name="politicallyExposedDesOne" readonly>${declaration.politicallyExposedDesOne}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Third Party or any person directly or indirectly connected to the Third Party will seek / has sought or obtained the assistance of any political party / political leader / organization affiliated with a political party or a political leader in connection with providing goods / services to CZ?
                            </label>
                            <div class="col-lg-2">

                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="politicallyExposedTwoFlag"
                                           <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="politicallyExposedTwoFlag" 
                                        <c:if test="${declaration.politicallyExposedDesTwoFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="politicallyExposedDesTwo" name="politicallyExposedDesTwo" readonly>${declaration.politicallyExposedDesTwo}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether any assistance has been sought from a political party / political leader / an organization affiliated with a political party, or a political leader for resolution of any issues / concerns related to the functioning / management / regulatory compliance of the Third Party?
                            </label>
                            <div class="col-lg-2">

                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="politicallyExposedThreeFlag"
                                           <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="politicallyExposedThreeFlag" 
                                        <c:if test="${declaration.politicallyExposedDesThreeFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="politicallyExposedDesThree" name="politicallyExposedDesThree" readonly>${declaration.politicallyExposedDesThree}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    8. Nature of Services
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Scope of Work to be carried out by the Third Party will involve providing any form of liaising or facilitation services with Government Departments?
                            </label>
                            <div class="col-lg-2">

                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="natureServicesOneFlag"
                                           <c:if test="${declaration.natureServicesOneFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="natureServicesOneFlag" 
                                        <c:if test="${declaration.natureServicesOneFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="natureServicesOneDes" name="natureServicesOneDes" readonly>${declaration.natureServicesOne}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Whether the Scope of Work to be carried out by the Third Party will involve interacting with Public Officials (Government officials/Judges/Public Sector Companies, etc.) on behalf of Chargezone?
                            </label>
                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="natureServicesTwoFlag"
                                           <c:if test="${declaration.natureServicesTwoFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="natureServicesTwoFlag" 
                                        <c:if test="${declaration.natureServicesTwoFlag == 0}">checked</c:if>> No
                                    </label>

                                </div>
                                <div class="col-lg-4">
                                    <textarea class="textarea-field" id="natureServicesTwoDes" name="natureServicesTwoDes" readonly>${declaration.natureServicesTwo}</textarea>
                            </div>
                        </div>

                        <div class="form-group row m-0">
                            <label class="col-lg-12 control-label">
                                <strong>
                                    <i class="fas fa-file-signature" style="margin-right: 8px;"></i>
                                    9.  Acknowledgment of understanding and NDA
                                </strong>
                            </label>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Has the Procurement team explained to you the Supplier Registration process especially the Code of Conduct document? Please answer in Yes or No
                            </label>
                            <div class="col-lg-2">

                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="ndaOneFlag"
                                           <c:if test="${declaration.ndaOneFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="ndaOneFlag" 
                                        <c:if test="${declaration.ndaOneFlag == 0}">checked</c:if>> No
                                    </label>
                                </div>
                                <div class="col-lg-4">
                                    <input class="input-field" id="ndaOneInput" name="ndaOne" value="${declaration.ndaOne}" readonly />
                            </div>
                        </div>

                        <div class="form-group row m-0 mb-1">
                            <label class="col-lg-6 control-label">
                                Has the Procurement team explained to you about the applicability of Non-Disclosure Agreement to your case? If yes have they shared NDA with you. Please answer in Yes or No.
                            </label>
                            <div class="col-lg-2">
                                <label class="radio-inline">
                                    <input disabled type="radio" value="1" name="ndaTwoFlag"
                                           <c:if test="${declaration.ndaTwoFlag == 1}">checked</c:if>> Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input disabled type="radio" value="0" name="ndaTwoFlag" 
                                        <c:if test="${declaration.ndaTwoFlag == 0}">checked</c:if>> No
                                    </label>      </div>
                                <div class="col-lg-4">
                                    <input class="input-field" id="ndaTwoInput" name="ndaTwo" value="${declaration.ndaTwo}" readonly />
                            </div>
                        </div>
                    </div>
                                         <div class="table-responsive">
                                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        <thead> 
                                                        <thead> 
                                                            <tr class="table-title">
                                                                <td colspan="3" style="font-weight: bold; background-color: skyblue;">Company Registration Details</td>
                                                                <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a href="vendorInformation.htm?act=companyRegDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>                                                            
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <th style="width: 20%;">GST No.</th>
                                                                <td>                                                        
                                                                    ${vendorInformation1.gstinNo}<br>
                                                                    <c:if test="${vendorInformation1.gstinFile!='' &&  vendorInformation1.gstinFile!=null}">
                                                                        ${vendorInformation1.gstinFile}
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.gstinFile}&amp;id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a> 
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </c:if>

                                                                </td>                                                    
                                                                <th style="width: 20%;">PAN No</th>
                                                                <td>                                                    
                                                                    ${vendorInformation1.panNo}<br>
                                                                    <c:if test="${vendorInformation1.panFile!='' &&  vendorInformation1.panFile!=null}">
                                                                        ${vendorInformation1.panFile} 
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.panFile}&amp;id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.panFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <th style="width: 20%;">MSME No</th>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.msmeStatus=='0'}"><strong>MSME Not
                                                                            Available</strong></c:if>
                                                                    ${vendorInformation1.service_tax}<br>
                                                                    <c:if test="${vendorInformation1.service_file!='' &&  vendorInformation1.service_file!=null}">
                                                                        ${vendorInformation1.service_file}
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.service_file}&amp;id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.service_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </c:if>
                                                                </td>
                                                                <th style="width: 20%;">ESIC No</th>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.esicStatus=='0'}"><strong>ESIC Not
                                                                            Available</strong></c:if>
                                                                    ${vendorInformation1.esicNo}<br>
                                                                    <c:if test="${vendorInformation1.esicFile!='' &&  vendorInformation1.esicFile!=null}">
                                                                        ${vendorInformation1.esicFile}
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.esicFile}&amp;id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.esicFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <th style="width: 20%;">EPFO No.</th>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.epfoStatus=='0'}"><strong>EPFO Not
                                                                            Available</strong></c:if>
                                                                    ${vendorInformation1.pfNo}<br>
                                                                    <c:if test="${vendorInformation1.pfAttachment!='' &&  vendorInformation1.pfAttachment!=null}">
                                                                        ${vendorInformation1.pfAttachment} 
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.pfAttachment}&amp;id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </c:if>
                                                                </td>
                                                                <th style="width: 20%;">Import Export Code </th>
                                                                <td> 
                                                                    <c:if test="${vendorInformation1.eccStatus == '0'}"><strong>ECC Not
                                                                            Available</strong></c:if>
                                                                    ${vendorInformation1.ecc_no}<br>
                                                                    <c:if test="${vendorInformation1.ecc_file!='' &&  vendorInformation1.ecc_file!=null}">
                                                                        ${vendorInformation1.ecc_file}
                                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.ecc_file}&amp;id=${vendorInformation1.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>
                                                                    </c:if>
                                                                </td>                                                    
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>

                                             <div class="table-responsive">
                                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        <thead> 
                                                        <thead>
                                                            <tr class="table-title">
                                                                <td colspan="3" style="font-weight: bold; background-color: skyblue;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                                                <td style="font-weight: bold; background-color: skyblue;">
                                                                    All Attachments <a href="vendorInformation.htm?act=financialStatementDetailsDocxdownloadzip&id1=${vendorInformation1.id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                        &nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                            <tr style="">
                                                                <th>Year</th>
                                                                <th>Financial Year</th>
                                                                <th>Financial Amount</th>
                                                                <th>Financial Attachment</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <!-- 1st Year -->
                                                            <tr>
                                                                <td>1st Year </td>
                                                                <td>${vendorInformation1.finical1}</td>
                                                                <td>${vendorInformation1.finicalAmount1}</td>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.finicalAttachment1!='' &&  vendorInformation1.finicalAttachment1!=null}">
                                                                        ${vendorInformation1.finicalAttachment1}
                                                                        <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.finicalAttachment1}&amp;id=${vendorInformation1.id}">
                                                                            &nbsp;<span class="fa fa-download"></span>
                                                                        </a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>

                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <!-- 2nd Year -->
                                                            <tr>
                                                                <td>2nd Year </td>
                                                                <td>${vendorInformation1.finical2}</td>
                                                                <td>${vendorInformation1.finicalAmount2}</td>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.finicalAttachment2!='' &&  vendorInformation1.finicalAttachment2!=null}">
                                                                        ${vendorInformation1.finicalAttachment2} 
                                                                        <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.finicalAttachment2}&amp;id=${vendorInformation1.id}">
                                                                            &nbsp;<span class="fa fa-download"></span>
                                                                        </a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>

                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <!-- 3rd Year -->
                                                            <tr>
                                                                <td>3rd Year </td>
                                                                <td>${vendorInformation1.finical3}</td>
                                                                <td>${vendorInformation1.finicalAmount3}</td>
                                                                <td>
                                                                    <c:if test="${vendorInformation1.finicalAttachment3!='' &&  vendorInformation1.finicalAttachment3!=null}">
                                                                        ${vendorInformation1.finicalAttachment3}<a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation1.finicalAttachment3}&amp;id=${vendorInformation1.id}">
                                                                            &nbsp;<span class="fa fa-download"></span>
                                                                        </a>
                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/${vendorInformation1.id}/${vendorInformation1.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>

                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    <br>
                                                </div>

                  
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-12">
                                <div class="form-group">
                                    <label class="control-label">Attachment<span style="color:red">*</span></label>
                                    <input type= "file" required name="attachment" class="input-field"/>
                                </div>
                            </div>

                            <div class="col-lg-6 col-md-12">
                                <div class="form-group">
                                    <label class="control-label">Risk Band<span style="color:red">*</span></label>
                                    <select name="myList" required="true" id="riskSelect" class="select-input">
                                        <option value="Normal">Normal</option>
                                        <option value="AbNormal">AbNormal</option>
                                        <option value="High">High</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="control-label">Vendor Developer Comment :<span style="color:red">*</span></label>
                                    <textarea class="textarea-field" readonly="true">${vendorInformation1.auditorRemark}</textarea>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="control-label">Risk Evaluator's Comment :<span style="color:red">*</span></label>
                                    <textarea name="comment" required id="comment" class="textarea-field comment" maxlength="250"></textarea>
                                    <small id="charCount_comment" style="font-size: 12px; color: green;">250 characters remaining</small>
                                         <c:if test="${!empty vendorApproval}">
                                        <div class="form-group" style="display: flex; justify-content: center; gap: 10px; margin-top: 20px;">
                                            <button type="submit" class="btn theme-btn" title="" 
                                                    style="background-color: orange; color: white; border-color: orange; width: 100px;" 
                                                    formaction="vendorInformation.htm?act=RecycleAuditorApproval&id=${vendorInformation1.id}">
                                                REWORK
                                            </button>
                                            <input type="submit" class="btn theme-btn" id="submit1" title="submit1" value="APPROVE" 
                                                   style="background-color: #28a745; color: white; border-color: #28a745; width: 100px;">
                                        </div>


                                                        <br>
                                            <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;">                                                        
                                              
                                                <thead> 
                                                    
                                                            <tr style="font-weight: bold; background-color: skyblue;">
                                                                <th colspan="6">Approval History</th>
                                                            </tr>

                                                            <tr style="">
                                                                <th >Sr. No.</th>
                                                                <th >Date Time</th>
                                                                <th>User</th>
                                                                <th >User Role</th>
                                                                <th >Action</th>
                                                                <th >Comment</th>
                                                            </tr>
                                                            <c:forEach var="vendorApproval" items="${vendorApproval}" varStatus="status">
                                                                <tr>
                                                                    <td>
                                                                        ${status.count}
                                                                    </td>
                                                                    <td>
                                                                        ${vendorApproval.dateTime}
                                                                    </td>
                                                                    <td>
                                                                        ${vendorApproval.userId}
                                                                    </td>
                                                                    <td>
                                                                        ${vendorApproval.userRole}
                                                                    </td>
                                                                    <td>
                                                                        ${vendorApproval.activity}
                                                                    </td>
                                                                    <td>
                                                                        ${vendorApproval.description}
                                                                    </td>

                                                                </tr>
                                                            </c:forEach>
                                                        </table>
                                                    </c:if>


                                          
                                    <script type="text/javascript">
                                        document.addEventListener("DOMContentLoaded", function () {
                                            var textarea = document.getElementById("comment");
                                            var counter = document.getElementById("charCount_comment");
                                            var maxChars = 250;
                                            function updateCounter() {
                                                var count = textarea.value.length;
                                                var remaining = maxChars - count;
                                                counter.textContent = remaining + " characters remaining";
                                                if (remaining <= 20) {
                                                    counter.style.color = "red";
                                                } else {
                                                    counter.style.color = "green";
                                                }
                                            }

                                            updateCounter();
                                            textarea.addEventListener("input", updateCounter);
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $('#riskSelect').on('change', function () {
                                var selected = $(this).val();
                                if (selected === 'High') {
                                    $('#submit1').prop('disabled', true);
                                } else {
                                    $('#submit1').prop('disabled', false);
                                }
                            }).trigger('change');
                        });
                    </script>



                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
