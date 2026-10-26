<%-- 
    Document   : 
    Created on : Jun 11, 2020, 2:38:52 PM
    Author     : Samir Tailor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>OAP Form Approved Edit</title>
        <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <title>Order Acquisition Process Checklist</title>
        <!--        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" />

        <!-- Include Flatpickr JS -->
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

        <style>
            @keyframes blink {
                50% {
                    border-color: red;
                }
            }

            .blinking {
                animation: blink 1s linear infinite;
            }
        </style>
        <style>
            textarea{
                width: 100%;
            }

            input[type="checkbox"]:disabled + label::before{
                background: gray;
            }
            input[type="checkbox"]:disabled + label:hover::before{
                background: gray;
                border: 1px solid #d4d4d5;
            }
            /*            @media print {
                            a[href]:after {
                                content: none !important;
            
                            }*/
        </style>
        <style>
        #table_1 td {
    height: auto !important;
}

#table_1 img {
    width: auto;
    display: block;
    margin: 0 auto;
}
    </style>
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">OAP Form Approved Edit</h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="oapForm.htm?act=approvedEditSubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation1"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

            <input type="hidden" name="id" value="${oapForm.id}">
            <c:forEach var="list" items="${list}" varStatus="status">

                <input type="hidden" name="id" value="${list[2]}">

            </c:forEach>

            <c:forEach var="list" items="${list33}" varStatus="status">

                <input type="hidden" name="id" value="${list[2]}">

            </c:forEach>


            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">

                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">
                                         <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                    <tbody>
                        <tr>
                            <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                <img src="StorageYard/Images/logo.png" style="background-color: white; max-height: 8vh;">
                            </td>

                            <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                                Order Acquisition Process checklist
                            </td>
                        </tr>
                    </tbody>
                </table>



                                        <div style="overflow-x: auto; max-width: 95%; margin: auto; border: 0px solid black;">
                                            <br>
                                            <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden;">
                                                <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                                                <div>
                                                    <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                                                    <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                                                </div>
                                            </div>



                                            <br>
                                            <table class="table table-bordered mb-3" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                                <thead>
                                                    <tr>
                                                        <td colspan="4" style="border: 1px solid black; background-color: skyblue"><strong>PCS Order Details:</strong></td>
                                                    </tr>

                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                        <td style="border: 1px solid black;">
                                                            <input class="form-control" name="documentNo" id="documentNo" value="${oapForm.documentNo}" readonly />
                                                        </td>

                                                        <td style="border: 1px solid black;"><strong>PCS Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;"><input  class="form-control" name="pcsName"  id="pcsName" value="${oapForm.pcsName}" required="true"/> </td>    
                                                    </tr>







                                                    <tr>
                                                        <td style="border: 1px solid black;"><strong>Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;">
                                                            <div class="input-group date">
                                                                <input name="date" type="text" style="width: 42vh; " class="form-control form_datetime" id="datetimepicker1" value="${oapForm.date}" maxlength="30" required="true"/>
                                                            </div>
                                                        </td>
                                                        <td style="border: 1px solid black;"><strong>Document Revision No:</strong></td>
                                                        <td style="border: 1px solid black;">
                                                            <input type="text" class="form-control" name="documentRevisonNo" id="documentRevisonNo" value="${oapForm.documentRevisionNo}" readonly />
                                                        </td>
                                                    </tr>

                                                <script>
$(function () {

                                                            // Initialize Flatpickr
                                                            flatpickr("#datetimepicker1", {
                                                            dateFormat: "d-m-Y", // Set your desired format
                                                                    allowInput: true // Allow manual input if required
                                                            });
                                                            });
                                                                                                                </script>



                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="projectName" id="projectName" value="${oapForm. projectName}" required="true"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>PCS City/Highway:</strong></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="city/highway" id="city/highway"  value="${oapForm. pcsCityHighway}" /> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Country:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <input  class="form-control" name="country" id="country" value="${oapForm.country}"  readonly="true"/> 



                                                    </td>    
                                                    <td style="border: 1px solid black;"><strong>State:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <input  class="form-control" name="state5" id="state5" value="${oapForm.state}"  readonly="true"/> 


                                                    </td>



                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>City:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="city" id="city" value="${oapForm.city}" required="required" /> </td>    
                                                    <td style="border: 1px solid black;"><strong>Street:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="pcsAddress" id="pcsAddress" value="${oapForm.pcsAddress}" required="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>District:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="district" id="district"  value="${oapForm.district}" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>House No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="houseno" id="houseno" value="${oapForm.houseNo}" required="required"/> </td>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Pcs Type:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsType1" id="pcsType1" 
                                                                   value="1" 
                                                                   ${oapForm.pcsTypeCity == '1' ? 'checked' : ''}> A. City
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsType2" id="pcsType2" 
                                                                   value="1" 
                                                                   ${oapForm.pcsTypeHighway == '1' ? 'checked' : ''}> B. Highway
                                                        </div>

                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsType3" id="pcsType3" value="1"
                                                                   ${oapForm.pcsTypeOtherCheck == '1' ? 'checked' : ''} 
                                                                   onclick="toggleOtherField()"> C. Other
                                                        </div>
                                                        <div id="otherFieldContainer" style="display: ${oapForm.pcsTypeOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                            <textarea id="pcstypeother" name="pcstypeother" rows="4" cols="30" style="width: 100%; padding: 0px; margin: 0; line-height: 1.1;"> ${oapForm.pcsTypeOther.trim()}</textarea>
                                                        </div>

                                                        <script>
                                                                    function toggleOtherField() {
                                                                    const checkbox = document.getElementById('pcsType3');
                                                                            const container = document.getElementById('otherFieldContainer');
                                                                            const textarea = document.getElementById('pcstypeother');
                                                                            container.style.display = checkbox.checked ? 'block' : 'none';
                                                                            if (checkbox.checked) {
                                                                    textarea.value = ""; // Clear the content
                                                                    } else {
                                                                    textarea.value = ""; // Ensure it's reset if needed
                                                                    }
                                                                    }
                                                        </script>













                                                    </td>

                                                    <td style="border: 1px solid black;"><strong>PCS Model</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsModel" id="pcsModel" 
                                                                   value="${oapForm.pcsModelDoco}" 
                                                                   ${oapForm.pcsModelDoco == '1' ? 'checked' : ''}> A. DOCO
                                                        </div> 
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode2" id="pcsMode2" 
                                                                   value="${oapForm.pcsModelCoco}" 
                                                                   ${oapForm.pcsModelCoco == '1' ? 'checked' : ''}> B. COCO
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode3" id="pcsMode3" 
                                                                   value="${oapForm.pcsModelDodo}" 
                                                                   ${oapForm.pcsModelDodo == '1' ? 'checked' : ''}> C. DODO
                                                        </div>


                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode4" id="pcsMode4" value="1"
                                                                   ${oapForm.pcsModelOtherCheck == '1' ? 'checked' : ''} 
                                                                   onclick="toggleModeOtherField()"> D. Other
                                                        </div>
                                                        <div id="modeOtherFieldContainer" 
                                                             style="display: ${oapForm.pcsModelOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                            <textarea id="pcsModelother" name="pcsModelother" rows="3" cols="20" style="width: 100%; padding: 5px; margin: 0; line-height: 1.2;">${oapForm.pcsModelOther.trim()}</textarea>
                                                        </div>

                                                        <script>
                                                                    function toggleModeOtherField() {
                                                                    const checkbox = document.getElementById('pcsMode4');
                                                                            const container = document.getElementById('modeOtherFieldContainer');
                                                                            const textarea = document.getElementById('pcsModelother');
                                                                            container.style.display = checkbox.checked ? 'block' : 'none';
                                                                            if (checkbox.checked) {
                                                                    textarea.value = ""; // Clear the content
                                                                    } else {
                                                                    textarea.value = ""; // Ensure it's reset if needed
                                                                    }
                                                                    }
                                                        </script>

                                                    </td>

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Pcs Co-ordinates:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="pcscoordinates" id="pcscoordinates" value="${oapForm. pcsCoordinates}" required="true"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Client Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="mobileNo" id="mobileNo" value="${oapForm. mobileNo}" required="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Client E-mail:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="email" id="email" type="email" value="${oapForm. email}" required="true"/></td>    
                                                    <td style="border: 1px solid black;"><strong>Client  Mobile No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="alternatemobileNo" id="alternatemobileNo" value="${oapForm. alternateMobileNo}" required="true"/> </td>    
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of Work:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="clientDetails" required="true"
                                                                  id="clientDetails">${oapForm.clientDetails}</textarea>
                                                    </td>
                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Client Scope of Work:<span style="color: red;font-size: 12px;">*</span> </strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="scope" required="true"
                                                                  id="scope">${oapForm.clientScope}</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Specific Requirements of Clients:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="clientRequiremts" required="true"
                                                                  id="clientRequiremts">${oapForm.specificRequriementsClients}</textarea>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Name of the Sales Lead:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="salesName" id="salesName" value="${oapForm. salesLeadName}"  required="true"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Department:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="department" id="department" value="${oapForm. department}"  required="true"/> </td> 

                                                </tr>      

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <input type="text" class="form-control" name="designation" id="designation" value="${oapForm.designation}" required="true"/>
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input name="date1" type="text" style="width: 42vh; " class="form-control form_datetime" id="datetimepickers" value="${oapForm.salesDate}" maxlength="30"  required="true"/>
                                                        </div>
                                                    </td>
                                                </tr>

                                                <script>
$(function () {

                                                    // Initialize Flatpickr
                                                    flatpickr("#datetimepickers", {
                                                    dateFormat: "d-m-Y", // Set your desired format
                                                            allowInput: true // Allow manual input if required
                                                    });
                                                    });
                                                                                                </script>


                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>PCS Deliverable Details:</strong></td>
                                                </tr>
                                             
                                             <tr>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <c:if test="${oapForm.agreementLoa=='1'}">
                                                                <input type="checkbox" checked="true" onclick="change1();" value="1" name="pcsDelivery1" id="pcsDelivery1">
                                                                Agreement/LOA
                                                            </c:if>
                                                            <c:if test="${oapForm.agreementLoa=='0'}">
                                                                <input type="checkbox" onclick="change1();" value="0" name="pcsDelivery1" id="pcsDelivery1">
                                                                Agreement/LOA
                                                            </c:if> 

                                                        </div>

                                                        <c:if test="${oapForm.agreementLoa=='1'}">
                                                            <div id="attachment1" style="margin-top: 5px;">
                                                                <input type="file" name="attachment1File" id="attachment1File" onchange="checkAttachmentSize(this, 'notification1')">
                                                                <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.aggrementAttach}">
                                                                    <span>${oapForm.aggrementAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment1File1" value="${oapForm.aggrementAttach}" id="attachment1File1">
                                                                <div id="notification1" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if>

                                                        <c:if test="${oapForm.agreementLoa=='0'}">
                                                            <div id="attachment1" style="margin-top: 5px; display: none;">
                                                                <input type="file" name="attachment1File" id="attachment1File" onchange="checkAttachmentSize(this, 'notification1')">
                                                                <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.aggrementAttach}">
                                                                    <span>${oapForm.aggrementAttach}</span>
                                                                </a>
                                                                <div id="notification1" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if>  
                                                        <script>
                                                                    function change1() {
                                                                    var checkbox = document.getElementById("pcsDelivery1");
                                                                            var attach1 = document.getElementById("attachment1");
                                                                            // Update checkbox value based on its checked state
                                                                            checkbox.value = checkbox.checked ? "1" : "0";
                                                                            // Show or hide the attachment section
                                                                            if (checkbox.checked) {
                                                                    attach1.style.display = 'block';
                                                                    } else {
                                                                    attach1.style.display = 'none';
                                                                    }
                                                                    }
                                                        </script>  

                                                    </td>

                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <c:if test="${oapForm.ownerShipDocument=='1'}">
                                                                <input type="checkbox" checked="true" onclick="change2();" value="1" name="pcsDelivery2" id="pcsDelivery2" >
                                                                Ownership Document
                                                            </c:if>
                                                            <c:if test="${oapForm.ownerShipDocument=='0'}">
                                                                <input type="checkbox" onclick="change22();" value="0" name="pcsDelivery2" id="pcsDelivery2">
                                                                Ownership Document
                                                            </c:if>

                                                        </div>

                                                        <c:if test="${oapForm.ownerShipDocument=='1'}">
                                                            <div id="attachment2" style=" margin-top: 5px;">
                                                                <input type="file" name="attachment2File" id="attachment2File"  onchange="checkAttachmentSize(this, 'notification2')">
                                                                <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.ownershipAttach}">   <span>${oapForm.ownershipAttach}</span></a>
                                                                <input type="hidden" name="attachment2File2" value="${oapForm.ownershipAttach}" id="attachment2File2">
                                                                <div id="notification2" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if> 

                                                        <c:if test="${oapForm.ownerShipDocument=='0'}">
                                                            <div id="attachment2" style="margin-top: 5px; display: none;">
                                                                <input type="file" name="attachment2File" id="attachment2File" onchange="checkAttachmentSize(this, 'notification2')">
                                                                <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.ownershipAttach}"> 
                                                                    <span>${oapForm.ownershipAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment2File2" value="${oapForm.ownershipAttach}" id="attachment2File2">
                                                                <div id="notification2" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if>  


                                                        <script>
                                                                    function change2() {
                                                                    var checkbox = document.getElementById("pcsDelivery2");
                                                                            var attach2 = document.getElementById("attachment2");
                                                                            var fileInput = document.getElementById("attachment2File");
                                                                            // Update checkbox value based on its checked state
                                                                            checkbox.value = checkbox.checked ? "1" : "0";
                                                                            // Show or hide the attachment section
                                                                            if (checkbox.checked) {
                                                                    attach2.style.display = 'block';
                                                                            if (fileInput) fileInput.setAttribute("required", "required"); // Add required
                                                                    } else {
                                                                    attach2.style.display = 'none';
                                                                            if (fileInput) {
                                                                    fileInput.value = ""; // Clear file input
                                                                            fileInput.removeAttribute("required"); // Remove required
                                                                    }
                                                                    }
                                                                    }

                                                            function change22() {
                                                            var checkbox = document.getElementById("pcsDelivery2");
                                                                    var attach2 = document.getElementById("attachment2");
                                                                    var fileInput = document.getElementById("attachment2File");
                                                                    // Update checkbox value based on its checked state
                                                                    checkbox.value = checkbox.checked ? "1" : "0";
                                                                    // Show or hide the attachment section
                                                                    if (checkbox.checked) {
                                                            attach2.style.display = 'block';
                                                                    if (fileInput) fileInput.setAttribute("required", "required"); // Add required
                                                            } else {
                                                            attach2.style.display = 'none';
                                                                    if (fileInput) {
                                                            fileInput.value = ""; // Clear file input
                                                                    fileInput.removeAttribute("required"); // Remove required
                                                            }
                                                            }
                                                            }



                                                        </script>

                                                    </td>

                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <c:if test="${oapForm.preliminarySiteSurvey=='1'}">
                                                                <input type="checkbox" checked="true" onclick="change3();" value="1" name="pcsDelivery3" id="pcsDelivery3">
                                                                Preliminary Site Survey
                                                            </c:if>
                                                            <c:if test="${oapForm.preliminarySiteSurvey=='0'}">
                                                                <input type="checkbox" onclick="change3();" value="0" name="pcsDelivery3" id="pcsDelivery3">
                                                                Preliminary Site Survey
                                                            </c:if>
                                                        </div>

                                                        <c:if test="${oapForm.preliminarySiteSurvey=='1'}">
                                                            <div id="attachment3" style="margin-top: 5px;">
                                                                <input type="file" name="attachment3File" id="attachment3File" onchange="checkAttachmentSize(this, 'notification3')">
                                                                <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.preliminaryAttach}">
                                                                    <span>${oapForm.preliminaryAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment3File3" value="${oapForm.preliminaryAttach}" id="attachment3File3">
                                                                <div id="notification3" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if>

                                                        <c:if test="${oapForm.preliminarySiteSurvey=='0'}">
                                                            <div id="attachment3" style="margin-top: 5px; display: none;">
                                                                <input type="file" name="attachment3File" id="attachment3File" onchange="checkAttachmentSize(this, 'notification3')">
                                                                <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.preliminaryAttach}">
                                                                    <span>${oapForm.preliminaryAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment3File3" value="${oapForm.preliminaryAttach}" id="attachment3File3">
                                                                <div id="notification3" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if>
                                                    </td>

                                                <script>
                                                            function change3() {
                                                            var checkbox = document.getElementById("pcsDelivery3");
                                                                    var attach3 = document.getElementById("attachment3");
                                                                    var fileInput = document.getElementById("attachment3File");
                                                                    // Update checkbox value based on its checked state
                                                                    checkbox.value = checkbox.checked ? "1" : "0";
                                                                    // Show or hide the attachment section
                                                                    if (checkbox.checked) {
                                                            attach3.style.display = 'block';
                                                                    if (fileInput) fileInput.setAttribute("required", "required"); // Add required
                                                            } else {
                                                            attach3.style.display = 'none';
                                                                    if (fileInput) {
                                                            fileInput.value = ""; // Clear file input
                                                                    fileInput.removeAttribute("required"); // Remove required
                                                            }
                                                            }
                                                            }

                                                </script>


                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <c:if test="${oapForm.consentLetterNoc=='1'}">
                                                            <input type="checkbox" checked="true" onclick="change4();" value="1" name="pcsDelivery4" id="pcsDelivery4">
                                                            Consent Letter/NOC
                                                        </c:if>
                                                        <c:if test="${oapForm.consentLetterNoc=='0'}">
                                                            <input type="checkbox" onclick="change4();" value="0" name="pcsDelivery4" id="pcsDelivery4">
                                                            Consent Letter/NOC
                                                        </c:if>
                                                    </div>

                                                    <div id="attachment4" style="margin-top: 5px; display: ${oapForm.consentLetterNoc=='1' ? 'block' : 'none'};">
                                                        <input type="file" name="attachment4File" id="attachment4File" onchange="checkAttachmentSize(this, 'notification4')">
                                                        <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${oapForm.consentAttach}">
                                                            <span>${oapForm.consentAttach}</span>
                                                        </a>
                                                        <input type="hidden" name="attachment4File4" value="${oapForm.consentAttach}" id="attachment4File4">
                                                        <div id="notification4" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                    </div>

                                                    <script>
                                                             function change4() {
    var checkbox = document.getElementById("pcsDelivery4");
    var attach4 = document.getElementById("attachment4");
    var fileInput = document.getElementById("attachment4File");

    // Update checkbox value based on its checked state
    checkbox.value = checkbox.checked ? "1" : "0";

    // Show or hide the attachment section
    attach4.style.display = checkbox.checked ? 'block' : 'none';

    // Add or remove the required attribute
    if (fileInput) {
        if (checkbox.checked) {
            fileInput.setAttribute("required", "required"); // Add required
        } else {
            fileInput.value = ""; // Clear file input
            fileInput.removeAttribute("required"); // Remove required
        }
    }
}
function checkAttachmentSize(fileElement, alertBoxId) {
    const selectedFile = fileElement.files[0];
    const maxFileLimit = 5 * 1024 * 1024; // 5MB
    const alertBox = document.getElementById(alertBoxId);

    if (selectedFile && selectedFile.size > maxFileLimit) {
        alertBox.textContent = "File  should not exceed 5MB.";
        alertBox.style.display = 'block';
        fileElement.value = ''; // Clear the file input
    } else {
        alertBox.style.display = 'none';
    }
}

                                                    </script>
                                                </td>

                                                </tr>

                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue;">
                                                        <strong>Charger Installation Details:</strong>
                                                    </td>
                                                </tr>
                                             
                                               
                                                <tr>
                                                    <td style="border: 1px solid black;">
                                                        <div> <input type="checkbox" name="chargeInstall1" id="chargeInstall1"  onclick="toggleBlink(this, 'chargeInstall1qua')" value="${oapForm.kwAc77}"${oapForm.kwAc77 == '1' ? 'checked' : ''}> 7.7KW AC </div>
                                                        <textarea name="chargeInstall1qua" id="chargeInstall1qua" rows="3" cols="20"  placeholder="Add Quantity"   ${oapForm.kwAc77 == '1' ? '' : 'disabled'}>${oapForm.kwAcQuatity77}</textarea>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall2" id="chargeInstall2" 
                                                                   onclick="toggleBlink(this, 'chargeInstall2qua')" 
                                                                   value="${oapForm.kwDc15}"   
                                                                   ${oapForm.kwDc15 == '1' ? 'checked' : ''}>
                                                            15KW DC
                                                        </div>
                                                        <textarea name="chargeInstall2qua" id="chargeInstall2qua" rows="3" cols="20"  placeholder="Add Quantity"  ${oapForm.kwDc15 == '1' ? '' : 'disabled'}>${oapForm.kwDcQuatity15}</textarea>

                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall3" id="chargeInstall3" 
                                                                   onclick="toggleBlink(this, 'chargeInstall3qua')" 
                                                                   value="${oapForm.kwDc30}"   
                                                                   ${oapForm.kwDc30 == '1' ? 'checked' : ''}>
                                                            30KW DC
                                                        </div>
                                                        <textarea name="chargeInstall3qua" id="chargeInstall3qua" rows="3" cols="20"    placeholder="Add Quantity"   ${oapForm.kwDc30 == '1' ? '' : 'disabled'}>${oapForm.kwDcQuatity30}</textarea>  </td>




                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall4" id="chargeInstall4" 
                                                                   onclick="toggleBlink(this, 'chargeInstall4qua')" 
                                                                   value="${oapForm.kwDc60}"   
                                                                   ${oapForm.kwDc60 == '1' ? 'checked' : ''}>
                                                            60KW DC
                                                        </div>
                                                        <textarea name="chargeInstall4qua" id="chargeInstall4qua" rows="3" cols="20"   placeholder="Add Quantity"    ${oapForm.kwDc60 == '1' ? '' : 'disabled'}>${oapForm.kwDcQuatity60}</textarea>  </td>




                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall5" id="chargeInstall5" 
                                                                   onclick="toggleBlink(this, 'chargeInstall5qua')" 
                                                                   value="${oapForm.kwDc120}"   
                                                                   ${oapForm.kwDc120 == '1' ? 'checked' : ''}>
                                                            120KW DC
                                                        </div>
                                                        <textarea name="chargeInstall5qua" id="chargeInstall5qua" rows="3" cols="20"    placeholder="Add Quantity"   ${oapForm.kwDc120 == '1' ? '' : 'disabled'}>${oapForm.kwDcQuatity120}</textarea>



                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall6" id="chargeInstall6" 
                                                                   onclick="toggleBlink(this, 'chargeInstall6qua')" 
                                                                   value="${oapForm.kwDc180}"   
                                                                   ${oapForm.kwDc180 == '1' ? 'checked' : ''}>
                                                            180KW DC
                                                        </div>
                                                        <textarea name="chargeInstall6qua" id="chargeInstall6qua" rows="3" cols="20"  placeholder="Add Quantity"   ${oapForm.kwDc180 == '1' ? '' : 'disabled'}>${oapForm.kwDcQuatity180}</textarea>   </td>




                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall7" id="chargeInstall7" 
                                                                   onclick="toggleBlink(this, 'chargeInstall7qua')" 
                                                                   value="${oapForm.kw240}"   
                                                                   ${oapForm.kw240 == '1' ? 'checked' : ''}>
                                                            240KW
                                                        </div>
                                                        <textarea name="chargeInstall7qua" id="chargeInstall7qua" rows="3" cols="20"   placeholder="Add Quantity"  ${oapForm.kw240 == '1' ? '' : 'disabled'}>${oapForm.kwQuatity240}</textarea>  </td>




                                                    <td style="border: 1px solid black;">
                                                        <strong>Others</strong>
                                                        <textarea name="others" id="others" rows="3" cols="20">${oapForm.others}</textarea>
                                                    </td>
                                                </tr>


                                                <script>
                                                            function toggleBlink(checkbox, textareaId) {
                                                            const textarea = document.getElementById(textareaId);
                                                                    if (checkbox.checked) {
                                                            textarea.disabled = false;
                                                                    textarea.classList.add('blinking');
                                                                    textarea.focus(); // Focus on the textarea
                                                            } else {
                                                            textarea.disabled = true;
                                                                    textarea.classList.remove('blinking');
                                                                    textarea.value = ""; // Clear the textarea content
                                                            }
                                                            }
                                                </script>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charging Station Protocol</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="guns" id="guns" value="${oapForm. noOfGuns}"  required="true"/> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Time Line Of Project Completion: <br>From Date<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                     <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input 
                                                                name="Fromdate" type="text" style="width: 42vh;"placeholder="DD-MM-YYYY"class="form-control form_datetime" id="newDatepicker" value="${oapForm.timeLineFromDate}"  required="true" maxlength="30" required="required" />

                                                        </div>
                                                    </td>
                                                <script>
                                                    $(document).ready(function () {
                                                    // Initialize the datepicker
                                                    $('#newDatepicker').datepicker({
                                                    format: "dd-mm-yyyy",
                                                            startDate: new Date(), // Disable past dates
                                                            autoclose: true,
                                                            todayHighlight: true
                                                    });
                                                    });</script>
                                                    <td style="border: 1px solid black;"><strong>To Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input name="Todate" type="text" style="width: 44vh; " class="form-control form_datetime" id="datetimepickers2" value="${oapForm.timeLineToDate}" maxlength="30"  required="true"/>

                                                        </div>
                                                    </td>
                                                </tr>

                                                <script >
                                                    // Initialize Flatpickr for From Date
                                                   $(document).ready(function () {
                                                    // Initialize the datepicker
                                                    $('#datetimepickers2').datepicker({
                                                    format: "dd-mm-yyyy",
                                                            startDate: new Date(), // Disable past dates
                                                            autoclose: true,
                                                            todayHighlight: true
                                                    });
                                                    });</script>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Estimated Budget</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;" ><input  class="form-control" name="budgetallocated" id="budgetallocated" value="${oapForm. projectBudgetAllocated}"  required="true"/> </td> 

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Others Details:<span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="othersDetails" id="othersDetails"  required="true">${oapForm.othersDetails}</textarea>
                                                    </td>
                                                </tr>
                                                         <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="form-control" id="ProjectProfile" name="ProjectProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list11" items="${list11}">
                                                                <c:choose>
                                                                    <c:when test="${list11.projectProfile eq ProjectProfile}">
                                                                        <option selected="true" value="${list11.projectProfile}">${list11.projectProfile}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                <option value="${list11.projectProfile}">${list11.projectProfile}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>  




                                                    <td style="border: 1px solid black;"><strong>Profit Center:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black; ">
                                                        <select class="form-control" id="profitcenter" name="profitcenter" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list7" items="${list7}">
                                                                 <c:choose>
                                                                    <c:when test="${list7.profitCenter eq ProjectCenter}">
                                                                        <option selected="true" value="${list7.profitCenter}">${list7.profitCenter}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                <option value="${list7.profitCenter}">${list7.profitCenter}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </td>


                                                </tr> 
                                               <tr>
                                              <tr>
                                                  <td style="border: 1px solid black;"><strong>Company Code:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                  <td style="border: 1px solid black;">
                                                      <select class="form-control" id="CompanyCode" name="CompanyCode" style="font-size: 12px; padding: 5px;" required="required">
                                                          <option value="">--SELECT--</option>
                                                          <c:forEach var="list8" items="${list9}">
                                                              <c:choose>
                                                                  <c:when test="${list8.companyCode eq CompanyCode}">
                                                                      <option selected="true" value="${list8.companyCode}">${list8.companyCode}</option>
                                                                  </c:when>
                                                                  <c:otherwise>
                                                                      <option value="${list8.companyCode}">${list8.companyCode}</option>
                                                                  </c:otherwise>
                                                              </c:choose>
                                                          </c:forEach>
                                                      </select>
                                                           
                                                           
                                                           
                                                           
                                                           
                                                           
                                                        
                                                   </td>
                                                   <td style="border: 1px solid black;"><strong>Plant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                   <td style="border: 1px solid black;">
                                                 
<select class="form-control" id="plant" name="plant" style="font-size: 12px; padding: 5px;" required="required">
    <option value="">--SELECT--</option>
</select>
                                               </tr>

                        <script>
    document.addEventListener("DOMContentLoaded", function () {
        var companyDropdown = document.getElementById("CompanyCode");
        var plantDropdown = document.getElementById("plant");

        var selectedPlant = "${plant}"; // Pre-selected plant in edit mode

        var data = [
            <c:forEach var="list8" items="${list8}" varStatus="status">
                {
                    companyCode: "${list8.companyCode}",
                    plantName: "${list8.plantName}"
                }<c:if test="${!status.last}">,</c:if>
            </c:forEach>
        ];

        function updatePlantDropdown(selectedCompany) {
            plantDropdown.innerHTML = '<option value="">--SELECT--</option>'; // Reset dropdown

            if (selectedCompany) {
                data.forEach(function (item) {
                    if (item.companyCode === selectedCompany) {
                        var option = document.createElement("option");
                        option.value = item.plantName;
                        option.textContent = item.plantName;
                        if (item.plantName === selectedPlant) {
                            option.selected = true; // Keep pre-selected plant in edit mode
                        }
                        plantDropdown.appendChild(option);
                    }
                });
            }
        }

        // Initial load for edit mode
        updatePlantDropdown(companyDropdown.value);

        // Update plant dropdown on company selection change
        companyDropdown.addEventListener("change", function () {
            updatePlantDropdown(this.value);
        });
    });
</script>                      


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="form-control" id="ProjectType" name="ProjectType" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list4" items="${list4}">
                                                                <c:choose>
                                                                    <c:when test="${list4.projectType eq ProjectType}">
                                                                        <option selected="true" value="${list4.projectType}">${list4.projectType}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                <option value="${list4.projectType}">${list4.projectType}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </td>    
                                                    <td style="border: 1px solid black;"><strong>Project Currency:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="form-control" id="ProjectCurrency" name="ProjectCurrency" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list3" items="${list3}">
                                                                 <c:choose>
                                                                    <c:when test="${list3.currencyCode eq Currency}">
                                                                        <option selected="true" value="${list3.currencyCode}">${list3.currencyCode}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                <option value="${list3.currencyCode}">${list3.currencyCode}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>  




                                                </tr> 
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Investment Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="form-control" id="InvestmentProfile" name="InvestmentProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list6" items="${list6}">
                                                                <c:choose>
                                                                    <c:when test="${list6.investmentProfile eq Ivestmentprofile}">
                                                                        <option selected="true" value="${list6.investmentProfile}">${list6.investmentProfile}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                <option value="${list6.investmentProfile}">${list6.investmentProfile}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                               
                                                            </c:forEach>
                                                        </select>  

                                                    <td style="border: 1px solid black;"><strong>Discom:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                   
                                                        <input type="text" class="form-control" name="Discom" id="Discom"  value="${Discom1}"  readonly="true"/>
                                                    </td>

                                                </tr>





                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="ChargePoints" id="ChargePoints" value="${oapForm.noOfChargePoints}" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>No Of Charger:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="NoOfCharger" id="NoOfCharger" value="${oapForm.noOfCharger}" required="required"/> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Overall Station Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="overallstations" id="overallstations" value="${oapForm.overallStationCapacityKw}" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Station AC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="stationAc" id="stationAc" required="required" value="${oapForm.stationAcCapacityKw}" /> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station DC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="stationDc" id="stationDc" required="required" value="${oapForm.stationDcCapacityKw}"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="stationname" id="stationname" required="required" value="${oapForm.stationName}"/> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="form-control" id="stationtype" name="stationtype" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list2" items="${list2}">
                                                                <c:choose>
                                                                    <c:when test="${list2.stationType eq StationType}">
                                                                        <option selected="true" value="${list2.stationType}">${list2.stationType}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                        <option value="${list2.stationType}">${list2.stationType}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                               
                                                            </c:forEach>
                                                        </select>  


                                                    <td style="border: 1px solid black;"><strong>Tenant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="form-control" id="tenant" name="tenant" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list0" items="${list0}">
                                                                <c:choose>
                                                                    <c:when test="${list0.tenant eq Tenant}">
                                                                        <option selected="true" value="${list0.tenant}">${list0.tenant}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                        <option value="${list0.tenant}">${list0.tenant}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>  


                                                </tr>
                                                <tr>
                                                 <td style="border: 1px solid black;"><strong>Connection Type:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                   
                                                        <input type="text" class="form-control" name="" id=""  value="${connection}"  readonly="true"/>
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="form-control" name="chargingrate" id="chargingrate" value="${oapForm.chargingRatePerUnit}"  /> </td> 
                                                    </tr>
                                            </table>
                                        </div>
                                        <br>
                                        <br>

                                        <div class="col-md-12">
                                            <!-- Custom Tabs -->
                                            <div class="nav-tabs-custom">
                                                <div class="tab-content">

                                                    <div class="box-header">
                                                    </div>
                                                    <div class="box-body no-padding">
                                                        <div class="row">

                                                            <div class="col-md-12 col-sm-12">
                                                                <div class="table table-bordered"></div>
                                                                <!--                                            <div class="table">-->

                                                                <table id="table_1" class="table table-bordered table-striped table-hover" align="Center">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Document Name</th>
                                                                            <th>Attachment
                                                                                <c:if test="${prdSize != 0}">
                                                                            <a href="oapForm.htm?act=oapDocxdownloadzip&fileName=${list[0]}&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                                    &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                                </a>
                                                                                </c:if> 
                                                                                </th>
                                                                            <th>Action</th>
                                                                        </tr>
                                                                    </thead>

                                                                    <c:forEach var="list" items="${list}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list[1]}</td>
                                                                            <td>
                                                                                <a href="oapForm.htm?act=oapDocxdownload&fileName=${list[0]}&id1=${id}">${list[0]}</a>
                                                                            </td>


                                                                            <td style="text-align: center;">
                                                                                <button type="button" style="border: none;color: red;" class="fa fa-trash" onclick="window.location = 'oapForm.htm?act=oapFormdocuDelete&id1=${list[2]}&id=${oapForm.id}'"></button>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>

                                                                    <c:forEach var="list33" items="${list33}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list33[1]}</td>
                                                                            <td><a href="oapForm.htm?act=oapDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>
                                                                            <td style="text-align: center;">
                                                                                <button type="button" style="border: none;color: red;" class="fa fa-trash" onclick="window.location = 'oapForm.htm?act=oapFormdocuDelete1&id1=${list33[2]}&id=${oapForm.id}'"></button>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </table>


                                                            </div>
                                                        </div>

                                                    </div><!-- /.tab-pane -->
                                                </div>
                                            </div><!-- /.tab-content -->
                                        </div><!-- nav-tabs-custom -->

                                    </div>



                                    <div class="form-group">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="policyTable" class="table table-bordered table-striped table-hover" style="max-width: 98%" align="center">
                                                    <tr>
                                                        <!--<th style="text-align: center; vertical-align: middle">Sr. No.</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                        <th style="text-align: center; vertical-align: middle">Description</th>

                                                        <!--                                                            <th style="text-align: center; vertical-align: middle">Document name</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                                    <tr id="policyRow1">
                                                        <!--                                                        <td id="policyId1">
                                                                                                                    <input type="text" class="form-control" name="srNo1" value="1" readonly>
                                                                                                                </td>                                                           -->



                                                        <td>
                                                            <input id="attachment1" name="attach" class="form-control" type="file" onchange="validateFileSize(this)">
                                                            <span id="fileError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>

                                                        </td> 
                                                        <td>
                                                            <input id="description1" name="descriptions" placeholder="Description" class="form-control" type="text">

                                                        </td>
                                                        <td style="text-align: center">
                                                            <span style='margin-top: 5px;'>
                                                                <input type="button" value="+" id="policyCloneid"/>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <script>
                                                function validateFileSize(input) {
                                                const file = input.files[0];
                                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                                        if (file && file.size > maxSize) {
                                                document.getElementById('fileError').style.display = 'block';
                                                        input.value = ''; // Clear the file input
                                                } else {
                                                document.getElementById('fileError').style.display = 'none';
                                                }
                                                }

                                       var tempCount3 = 1;
    $(function () {
        $("#policyCloneid").on("click", function () {
            tempCount3++;
            var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                + "<td><input type =\"file\" class=\"form-control\" placeholder=\"action\" name=\"attach" + "" + "\" id=\"attachment" + tempCount3 + "\" onchange=\"checkFileSize(this, 'fileError" + tempCount3 + "')\">\n\
                   <span id='fileError" + tempCount3 + "' style='display:none; color:red; font-size:12px;'>* File should not exceed 5MB</span></td>"
                + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"
                + "<td >"
                + "<span style='margin-top: 5px;'>"
                + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\" value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                + "</span>"
                + "</td>" + "</tr>";
            $("#policyTable").append(clone);
            document.getElementById('policyCount').value = tempCount3;
        });
    });

    function removePolicy(policyDiv) {
        try {
            var element1 = document.getElementById(policyDiv);
            element1.parentNode.removeChild(element1);
            updateSerialNumbers();
            var policyCount = document.getElementById('policyTable').rows.length - 1;
            document.getElementById('policyCount').value = policyCount;
        } catch (e) {
            console.log(e);
        }
    }

    function updateSerialNumbers() {
        var table = document.getElementById('policyTable');
        var rowCount = table.rows.length;
        var srNo = 1;
        for (var i = 1; i < rowCount; i++) {
            if (table.rows[i].id !== '') { 
                table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
            }
        }
    }

    function checkFileSize(input, errorId) {
        if (input.files.length > 0) {
            var fileSize = input.files[0].size / (1024 * 1024); 
            var errorMsg = document.getElementById(errorId);

            if (fileSize > 5) {
                errorMsg.style.display = "block";
                input.value = ""; 
            } else {
                errorMsg.style.display = "none";
            }
        }
    }

                                    </script>









                                    <div class="form-group">
                                        <div class="col-sm-3 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>

                                    </section>




                                </div><!-- /.tab-pane -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
        </div>
    </section>
</form:form><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<!--<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>-->
<!--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</html>

