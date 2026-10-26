<%-- 
    Document   : Profile
    Created on : 18 Oct, 2023, 10:52:38 AM
    Author     : Bulwarks-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    <head onload="rrshowSlides(1);">
        <title>Profile</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Profile</h1>
            <ol class="breadcrumb">
                <li> ${CurrentDate}</li>
                <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
                <li class="active">Profile</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="userMaster.htm?act=updateProfile" method="post" enctype="multipart/form-data"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="container">
                <!-- Custom Tabs -->
                <div class="nav-tabs-custom">
                    <div class=" offset-md-4 rounded-3">
                        <div class="box-body no-padding">

                            <div class="col-md-12 col-sm-12 text-center">
                                <div class="form-group">
                                    <h1>${user_name}</h1> 
                                    <img src="StorageYard/UserProfile/User/default.png" class="img-circle" alt="User Image" style="  max-width: 10%; height: auto; display:block;margin-left: auto; margin-right: auto;"> 
                                    <h3>Profile Details</h3> 
                                    <div class="form-group ">
                                        <input type="hidden" name="vendor_id" value="${vendorMaster.id}" class="form-control"   maxlength="100" readonly/>
                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Name <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="vendor_name" value="${vendorMaster.vendorName}" class="form-control"   maxlength="100" readonly/>
                                        </div>

                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Address <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="vendor_address" value="${vendorMaster.vendorAddressLine1}" class="form-control"   maxlength="100" readonly/>
                                        </div>
                                    </div>
                                    <div class="form-group ">

                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Email Id <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="vendor_email_id" value="${vendorMaster.vendorEmailID}" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor CC </label>
                                        </div>

                                        <div class="col-sm-3">
                                            <input type="text" name="vendor_cc" value="${vendorMaster.vendorcc}" class="form-control"  />
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Company Name  :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInvitation.companyName}" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Type of Concern :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.typeOfConcern}" required="required"   readonly="true"/>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Type Of Vendors  :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                <c:forEach var="list" items="${list7}" varStatus="status">

                                                    <tr>
                                                    <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list[2]}<" />
                                                    <td>${list[2]}</td>
                                                    <td>${list[3]}</td>
                                                    <td>${list[4]}</td>
                                                    </tr>
                                                </c:forEach>

                                            </table>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label class="control-label">Country :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeCountry}" required="required"   readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">State :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeState}" required="required"   readonly="true"/>
                                        </div>
                                    </div>   
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label class="control-label">City :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeCity}" required="required"   readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Address Line 1 :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeAddressLine1}" required="required"   readonly="true"/>
                                        </div>
                                    </div> 
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Address Line 2 :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeAddressLine2}" required="required"   readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Address Line 3 :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeAddressLine3}" required="required"   readonly="true"/>
                                        </div>
                                    </div>    

                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">PIN/ZIP Code:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officePin}" required="required"   readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Year of Establishment of Company :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeWebsite}" required="required"   readonly="true"/>
                                        </div>
                                    </div>    

                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">PIN/ZIP Code:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officePin}" required="required"   readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Year of Establishment of Company :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.establishment}" required="required"   readonly="true"/>
                                        </div>
                                    </div> 
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Company Website :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeWebsite}" required="required"   readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Telephone (With STD Code) :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.officeTelephone}" required="required"   readonly="true"/>
                                        </div>
                                    </div>   
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label class="control-label">Business Tel No :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" name="groupName" id="groupName" value="${vendorInformation.sales_phone}" required="required"   readonly="true"/>
                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">External Provider Contacts</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Name</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Job Title</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Phone No. / Email</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label"> Email</label>
                                        </div>

                                    </div> 
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Sales/Commercial Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.sales_name}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.sales_job}"  class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.sales_phone}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.saleEmail}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>

                                    </div>  
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Technical Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.technical_name}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.technical_job}"  class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.technical_phone}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input   value="${vendorInformation.technicalContactEmail}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                    </div>     
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Quality/Health & Safety Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input  path="quality_name" value="${vendorInformation.quality_name}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input  path="quality_job" value="${vendorInformation.quality_job}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input  path="quality_phone" value="${vendorInformation.quality_phone}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <input  path="qualityEmail" value="${vendorInformation.qualityEmail}" class="form-control"   maxlength="100" required="required" readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Company registration details:</label>
                                        </div>
                                    </div>   
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">GST No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  value="${vendorInformation.gstinNo}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  value="${vendorInformation.gstinFile}"class="form-control" id="gstinFile" name="gstinFile" accept="" onchange="checkFileSize();" readonly="true">
                                        </div>

                                    </div>   

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">PAN No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  value="${vendorInformation.panNo}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  value="${vendorInformation.panFile}" class="form-control" id="panFile" name="panFile" accept="" onchange="checkFileSize();" readonly="true">
                                        </div>
                                    </div> 

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">MSME APPLICABLE<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input   value="${vendorInformation.service_tax}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${vendorInformation.service_file}" class="form-control" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="checkFileSize();" readonly="true">
                                        </div>
                                    </div>    

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">PF No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input    value="${vendorInformation.pfNo}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${vendorInformation.pfAttachment}" class="form-control" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="checkFileSize();" readonly="true">
                                        </div>
                                    </div>  


                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">CIC No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input   value="${vendorInformation.cicNo}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${vendorInformation.cicAttachment}" class="form-control" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="checkFileSize();" readonly="true">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">IEC<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-3" style="flex: 1;">
                                            <input value="${vendorInformation.ecc_file}" class="form-control" id="eccNoFile" name="eccNoFile" accept="" onchange="checkFileSize();" readonly="true" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <label class="control-label">Payment/Banking Information</label>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label class="control-label">Account Number.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input    value="${vendorInformation.accountNumber}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Bank Name <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input   value="${vendorInformation.bankName}"  class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                    </div>   


                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label class="control-label">Branch<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input   value="${vendorInformation.branch}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">IFSC Code<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input   value="${vendorInformation.ifscCode}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label class="control-label">Swift Code (if any)<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input   value="${vendorInformation.branch}" class="form-control"   maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label"> Cancel cheque <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${vendorInformation.cancelCheck}" class="form-control" id="cancelcheck" name="cancelcheck" accept="" onchange="checkFileSize();" readonly="true">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Balance Sheet For 3 Years</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Finical Year</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Finical Amount</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Finical Attachment</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">1st Year . <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input readonly="true"  value="${vendorInformation.finical1}"  class="form-control"   maxlength="30" />
                                        </div>
                                        <div class="col-sm-3">
                                            <input  readonly="true"  value="${vendorInformation.finicalAmount1}"  class="form-control"   maxlength="30" />
                                        </div>

                                        <div class="col-sm-3">
                                            <input readonly="true" value="${vendorInformation.finicalAttachment1}" class="form-control" id="cancelcheck" name="finicalAttachment1" accept="" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">2nd Year .<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input readonly="true" value="${vendorInformation.finical2}" class="form-control"   maxlength="30" />
                                        </div>
                                        <div class="col-sm-3">
                                            <input readonly="true"  value="${vendorInformation.finicalAmount2}"  class="form-control"   maxlength="30" />
                                        </div>

                                        <div class="col-sm-3">
                                            <input readonly="true" value="${vendorInformation.finicalAttachment2}" class="form-control" id="cancelcheck" name="finicalAttachment2" accept="">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">3rd Year . <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input readonly="true"  value="${vendorInformation.finical3}"  class="form-control"   maxlength="30" />
                                        </div>
                                        <div class="col-sm-3">
                                            <input readonly="true"  value="${vendorInformation.finicalAmount3}" class="form-control"   maxlength="30" />
                                        </div>

                                        <div class="col-sm-3">
                                            <input readonly="true" value="${vendorInformation.finicalAttachment3}" class="form-control" id="cancelcheck" name="finicalAttachment3" accept="" >
                                        </div>
                                    </div>    

                                    <h5>General Criteria</h5>
                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="width: 130vh;" align="Center" >
                                        <tr style="background: gainsboro">

                                            <th>Criteria</th>
                                            <th>Selection Criteria</th>
                                            <th>Comment</th>
                                            <th>Attachment</th>
                                        </tr>
                                        <c:forEach var="list4" items="${list4}">

                                            <tr>
                                                <td>${list4.criteria}</td>
                                                <td>${list4.selectionCriteria}</td>
                                                <td>${list4.comment}</td>
                                                <td>${list4.attachment}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>

                                    <h5>HR Criteria</h5>
                                    <table id="table_2" class="table table-bordered table-striped table-hover" style="width: 130vh;" align="Center" >
                                        <tr style="background: gainsboro">

                                            <th>Criteria</th>
                                            <th>Selection Criteria</th>
                                            <th>Comment</th>
                                            <th>Attachment</th>
                                        </tr>
                                        <c:forEach var="list5" items="${list5}">

                                            <tr>
                                                <td>${list5.criteriaName}</td>
                                                <td>${list5.criteriaDescription}</td>
                                                <td>${list5.comment}</td>
                                                <td>${list5.attachement}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>

                                    <h5>Safety Criteria</h5>
                                    <table id="table_2" class="table table-bordered table-striped table-hover" style="width: 130vh;" align="Center">
                                        <tr style="background: gainsboro">

                                            <th>Criteria</th>
                                            <th>Selection Criteria</th>
                                            <th>Comment</th>
                                            <th>Attachment</th>
                                        </tr>
                                        <c:forEach var="list6" items="${list6}">

                                            <tr>
                                                <td>${list6.criteriaName}</td>
                                                <td>${list6.criteriaDescription}</td>
                                                <td>${list6.comment}</td>
                                                <td>${list6.attachement}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>












                                    <div class="form-group ">

                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Mobile No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="vendor_mobile_no" value="${vendorMaster.vendorMobNo}" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">

                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Stamp </label>
                                        </div>
                                        <div class="col-sm-3">
                                            <c:if test="${vendorMaster.vendorStamp != ''  && vendorMaster.vendorStamp != null}">
                                                <img src="StorageYard/Vendor/${vendorMaster.id}/${vendorMaster.vendorStamp}" style="height:50px; background-color: white;">
                                            </c:if>
                                            <input type="file" name="vendor_stamp" value="" class="form-control" />
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Sign </label>
                                        </div>

                                        <div class="col-sm-3">
                                            <c:if test="${vendorMaster.vendorSign != ''  && vendorMaster.vendorSign != null}">
                                                <img src="StorageYard/Vendor/${vendorMaster.id}/${vendorMaster.vendorSign}" style="height:50px; background-color: white;">
                                            </c:if>
                                            <input type="file" name="vendor_sign" value="" class="form-control" />
                                        </div>

                                    </div>

                                    <div class="form-group "></div>
                                    <div class="col-sm-4 col-sm-offset-4">
                                        <input type="submit" class="btn btn-primary" id="submit1" title="submit1" value="SUBMIT" >
                                        &nbsp;
                                        <button class="btn btn-danger" id="submit2" onclick="backToHome()" >CANCEL</button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->

            </section>
        </form:form><!-- /.content -->

        <script>
            function backToHome() {
                window.location = "homeController.htm?act=openHomePage"
            }
        </script>

    </div>
    <!--</div>
    </div>-->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
