
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Form Recycle Edit</title>
    </head>
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
       <script>
        function initDocTable(selector, obj = {}) {
            return $(selector).DataTable({
                paging: false,
                lengthChange: false,
                searching: false,
                info: false,
                autoWidth: true,
                ordering: false,
                scrollX: false,
                ...obj,
            });
        }
    </script>
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
    <body>
       
    <main class="d-flex align-items-end justify-content-end">
         <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
         <section class="main-content">
              <form:form action="oapForm.htm?act=oapFormRecycleEditsubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation1"
                         name='form1' id="form1" onsubmit="return surveyValidate();"  class="form-horizontal" role="form">
            <input type="hidden" name="id" value="${oapForm.id}">
           <input type="hidden" name="size" id="size" value="${size}">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">OAP Form Recycle Edit</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        <c:choose>
                            <c:when test="${oapForm.flagStatus == '2'}">
                                <button type="submit" id="submitBtn1" class="btn theme-btn"  title="" value=""> Recycle Submit</button>
                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn theme-btn" id="submitBtn1" formaction="oapForm.htm?act=oapFormReverseEditsubmit" title="" value="">Reverse Submit</button>
                            </c:otherwise>

                        </c:choose>
                    </div>
                </div>
           <input type="hidden" id="chargeInstcount" value="${chargeInstcount}">
                <hr>

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
                                                            <input class="input-field" name="documentNo" id="documentNo" value="${oapForm.documentNo}" readonly />
                                                        </td>

                                                        <td style="border: 1px solid black;"><strong>PCS Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;"><input  class="input-field" name="pcsName"  id="pcsName" value="${oapForm.pcsName}" required="true"/> </td>    
                                                    </tr>







                                                    <tr>
                                                        <td style="border: 1px solid black;"><strong>Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;">
                                                            <div class="input-group date">
                                                                <input name="date" type="text" style="width: 42vh; " class="input-field form_datetime" id="datetimepicker1" value="${oapForm.date}" maxlength="30" required="true"/>
                                                            </div>
                                                        </td>
                                                        <td style="border: 1px solid black;"><strong>Document Revision No:</strong></td>
                                                        <td style="border: 1px solid black;">
                                                            <input type="text" class="input-field" name="documentRevisonNo" id="documentRevisonNo" value="${oapForm.documentRevisionNo}" readonly/>
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
                                                    <!--<td style="border: 1px solid black;"><input  class="input-field" name="projectName" id="projectName" value="${oapForm. projectName}" required="true"/> </td>-->    
                                                   
                                                   <td   style="border: 1px solid black; ">
                                                        <select class="select-input" id="projectName" name="projectName" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list13" items="${list13}">
                                                                 <c:choose>
                                                                    <c:when test="${list13.projectName eq projectname}">
                                                                        <option selected="true" value="${list13.projectName}">${list13.projectName}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                <option value="${list13.projectName}">${list13.projectName}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </td>  
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    <td style="border: 1px solid black;"><strong>PCS City/Highway:</strong></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="city/highway" id="city/highway"  value="${oapForm. pcsCityHighway}" /> </td>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;width: 25%;"><strong>Country:</strong> </td>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <input  class="input-field" name="country" id="country" value="${oapForm.country}"  readonly="true"/> 



                                                    </td>    
                                                    <td style="border: 1px solid black;width: 25%;"><strong>State:</strong></td>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <input  class="input-field" name="state5" id="state5" value="${oapForm.state}"  readonly="true"/> 


                                                    </td>



                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>City:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="city" id="city" value="${oapForm.city}" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Street:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="pcsAddress" id="pcsAddress" value="${oapForm.pcsAddress}" required="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>District:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="district" id="district"  value="${oapForm.district}" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>House No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="houseno" id="houseno" value="${oapForm.houseNo}" required="required"/> </td>    
                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>PCS Type:</strong></td>
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
                                                            <textarea id="pcstypeother" name="pcstypeother" class="textarea-field" > ${oapForm.pcsTypeOther.trim()}</textarea>
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
                                                                   ${oapForm.pcsModelDoco == '1' ? 'checked' : ''}> A.DOCO
                                                        </div> 
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode2" id="pcsMode2" 
                                                                   value="${oapForm.pcsModelCoco}" 
                                                                   ${oapForm.pcsModelCoco == '1' ? 'checked' : ''}> B.COCO
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode3" id="pcsMode3" 
                                                                   value="${oapForm.pcsModelDodo}" 
                                                                   ${oapForm.pcsModelDodo == '1' ? 'checked' : ''}> C.DODO
                                                        </div>
                                                        <br>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode5" id="pcsMode5" value="${oapForm.pcsModelSaas}" ${oapForm.pcsModelSaas == '1' ? 'checked' : ''}> D.SAAS
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode4" id="pcsMode4" value="1"
                                                                   ${oapForm.pcsModelOtherCheck == '1' ? 'checked' : ''} 
                                                                   onclick="toggleModeOtherField()"> E.Other
                                                        </div>
                                                        <div id="modeOtherFieldContainer" 
                                                             style="display: ${oapForm.pcsModelOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                            <textarea id="pcsModelother" name="pcsModelother" class="textarea-field" >${oapForm.pcsModelOther.trim()}</textarea>
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
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="pcscoordinates" id="pcscoordinates" value="${oapForm. pcsCoordinates}" required="true"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Client Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="mobileNo" id="mobileNo" value="${oapForm. mobileNo}" required="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Client E-mail:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="email" id="email" type="email" value="${oapForm. email}" required="true"/></td>    
                                                    <td style="border: 1px solid black;"><strong>Client  mobile No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="alternatemobileNo" id="alternatemobileNo" value="${oapForm. alternateMobileNo}" required="true"/> </td>    
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of Work: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea  class="textarea-field"style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="clientDetails" required="true"
                                                                  id="clientDetails">${oapForm.clientDetails}</textarea>
                                                    </td>
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Specific Requirements of Clients:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea class="textarea-field" style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="clientRequiremts" required="true"
                                                                  id="clientRequiremts">${oapForm.specificRequriementsClients}</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Clients Scope: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea  class="textarea-field"style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="scope" required="true"
                                                                  id="scope">${oapForm.clientScope}</textarea>
                                                    </td>
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Name of the Sales Lead:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="salesName" id="salesName" value="${oapForm. salesLeadName}" required="true"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Department:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="department" id="department" value="${oapForm. department}" required="true"/> </td> 

                                                </tr>      

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="designation" id="designation" value="${oapForm.designation}" required="true"/>
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input name="date1" type="text" style="width: 42vh; " class="input-field form_datetime" id="datetimepickers" value="${oapForm.salesDate}" maxlength="30" required="true"/>
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
                                                    <tr>
                                                    <td style="border: 1px solid black;  width:25%;">
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
                                                                <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment1File" id="attachment1File" onchange="checkAttachmentSize(this, 'notification1')">
                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.aggrementAttach}&id1=${id}">
                                                                    <span>${oapForm.aggrementAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment1File1" value="${oapForm.aggrementAttach}" id="attachment1File1">
                                                                <div id="notification1" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                            </div>
                                                        </c:if>

                                                        <c:if test="${oapForm.agreementLoa=='0'}">
                                                            <div id="attachment1" style="margin-top: 5px; display: none;">
                                                                <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment1File" id="attachment1File" onchange="checkAttachmentSize(this, 'notification1')">
                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.aggrementAttach}&id1=${id}">
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

                                                    <td style="border: 1px solid black;  width:25%;">
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
                                                                <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment2File" id="attachment2File"  onchange="checkAttachmentSize(this, 'notification2')">
                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.ownershipAttach}&id1=${id}">   <span>${oapForm.ownershipAttach}</span></a>
                                                                <input type="hidden" name="attachment2File2" value="${oapForm.ownershipAttach}" id="attachment2File2">
                                                                <div id="notification2" style="color: red; display: none; margin-top: 5px;">Please Upload a File.</div>
                                                            </div>
                                                        </c:if> 

                                                        <c:if test="${oapForm.ownerShipDocument=='0'}">
                                                            <div id="attachment2" style="margin-top: 5px; display: none;">
                                                                <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment2File" id="attachment2File" onchange="checkAttachmentSize(this, 'notification2')">
                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.ownershipAttach}&id1=${id}"> 
                                                                    <span>${oapForm.ownershipAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment2File2" value="${oapForm.ownershipAttach}" id="attachment2File2">
                                                                <div id="notification2" style="color: red; display: none; margin-top: 5px;">Please Upload a File.</div>
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

                                                    <td style="border: 1px solid black;  width:25%;">
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
                                                                <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment3File" id="attachment3File" onchange="checkAttachmentSize(this, 'notification3')">
                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.preliminaryAttach}&id1=${id}">
                                                                    <span>${oapForm.preliminaryAttach}</span>
                                                                </a>
                                                                <input type="hidden" name="attachment3File3" value="${oapForm.preliminaryAttach}" id="attachment3File3">
                                                                <div id="notification3" style="color: red; display: none; margin-top: 5px;">Please Upload a File.</div>
                                                            </div>
                                                        </c:if>

                                                        <c:if test="${oapForm.preliminarySiteSurvey=='0'}">
                                                            <div id="attachment3" style="margin-top: 5px; display: none;">
                                                                <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment3File" id="attachment3File" onchange="checkAttachmentSize(this, 'notification3')">
                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.preliminaryAttach}&id1=${id}">
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


                                                <td style="border: 1px solid black;  width:25%;">
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
                                                        <input type="file" class="input-field" style="font-size: 13px !important;" name="attachment4File" id="attachment4File" onchange="checkAttachmentSize(this, 'notification4')">
                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${oapForm.consentAttach}&id1=${id}">
                                                            <span>${oapForm.consentAttach}</span>
                                                        </a>
                                                        <input type="hidden" name="attachment4File4" value="${oapForm.consentAttach}" id="attachment4File4">
                                                        <div id="notification4" style="color: red; display: none; margin-top: 5px;">Please Upload a File.</div>
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
        alertBox.textContent = "File size should not exceed 5MB.";
        alertBox.style.display = 'block';
        fileElement.value = ''; // Clear the file input
    } else {
        alertBox.style.display = 'none';
    }
}

                                                    </script>
                                                </td>

                                                </tr>




                                                </table>
                                                
                                              
<div class="col-md-12 p-0">
                            <table id="policyTableCharger" class="table  mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse; border: 1px solid black;"  align="center">
                                <thead style="border: 1px solid black;">
                                    <tr>
                                        <td colspan="9" 
                                            style="text-align: center; border: 1px solid black; background-color: skyblue;white-space: normal;word-wrap: break-word;overflow-wrap: break-word; padding: 8px;">

                                            <strong>
                                                Charger Installation Details:
                                                <br>

                                            </strong>

                                        </td>
                                    </tr>
                                    <tr style="text-align: center;border: 1px solid black;">
                                        <th style="border: 1px solid black;">Charger Type<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">Charger<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">Charger Capacity<br>(kW)<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">Charger model<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">Connector Type<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">No of connectors<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">No of chargers<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="border: 1px solid black;">Charging rate per unit<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Add New</th>
                                <input type="hidden" name="policyCountCharger" id="policyCountCharger" value="1"/>
                                </tr>
                                </thead>
                                <tbody style="border: 1px solid black;">
                                   
                                    <c:forEach var="chargeInst" items="${chargeInst}" varStatus="status">
                                        <tr  style="border: 1px solid black;">
                                            <td style="border: 1px solid black;">${chargeInst.chargerType}</td>
                                            <td style="border: 1px solid black;">
                                                ${chargeInst.charger}
                                                <br>
                                                <c:if test="${chargeInst.charger eq 'Other'}">
                                                      ${chargeInst.chargerOther}
                                                </c:if>
                                            </td>
                                            <td style="border: 1px solid black;">${chargeInst.chargerCapacityKW}</td>
                                            <td style="border: 1px solid black;">${chargeInst.chargermodel}</td>
                                            <td style="border: 1px solid black;">
                                                ${chargeInst.connectorType}
                                            <br>
                                                <c:if test="${chargeInst.connectorType eq 'Other'}">
                                                      ${chargeInst.connectorTypeOther}
                                                </c:if>
                                            </td>
                                            <td style="border: 1px solid black;">${chargeInst.noofconnectors}</td>
                                            <td style="border: 1px solid black;">${chargeInst.noofchargers}</td>
                                            <td style="border: 1px solid black;">${chargeInst.chargingrateperunit}</td>
                                       <td style="text-align: center; border: 1px solid black;">
                                             <div class="text-center">
                                                            <a data-id="${chargeInst.id}"
                                                               data-id1="${oapForm.id}"
                                                               class="d-inline-block text-danger p-1 mx-1 chargerIns-delete-btn"
                                                               data-toggle="tooltip"
                                                               data-placement="left"
                                                               title="Delete">
                                                                <img src="StorageYard/assets/images/delete-icon.svg"
                                                                     onload="SVGInject(this)"
                                                                     alt="Delete Icon"
                                                                     style="width: 22px; height: 22px;">
                                                            </a>
                                                        </div>
                                                    </td>
                                        
                                        </tr>
                                    </c:forEach>
                                
                                        
          <script>
document.querySelectorAll('.chargerIns-delete-btn').forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();

        var $row = $(this).closest('tr');
        var id  = $(this).data('id');
        var id1 = $(this).data('id1');

        Swal.fire({
            title: 'Are you sure?',
            text: 'Do you really want to delete this Charger Installation Details?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#6c757d',
            confirmButtonText: 'Yes, delete it!',
            reverseButtons: true,
            customClass: {
                confirmButton: 'confirm-delete',
                cancelButton: 'theme-btn light-btn'
            }
        }).then((result) => {
            if (!result.isConfirmed) return;

            $.ajax({
                url: 'aocForm.htm?act=ChargerInstallationdelete&id=' + id + '&id1=' + id1,
                type: 'POST',
                contentType: 'application/json',
                success: function (response) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Deleted!',
                        text: response.message || 'Record has been deleted.'
                    }).then(() => {
                       
                        window.location.href =
                            'oapForm.htm?act=oaprecycleEdit&id=' + id1;
                    });
                },
                error: function (xhr) {
                    Swal.fire(
                        'Error!',
                        'Error deleting record: ' + xhr.responseText,
                        'error'
                    );
                }
            });
        });
    });
});
</script>                              
                                        
                                        
                                        
                                        
                                        
                                    <tr  id="policyRow1Charger" >
                                        <td>
                                            <select class="select-input" id="chargerType" name="chargerType" style=" font-size: 12px;" >
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list17" items="${list17}">
                                                    <option value="${list17.chargerType}">${list17.chargerType}</option>
                                                </c:forEach>
                                            </select>
                                        </td> 
                                        
                                        
                                        <td>
                                            <select class="select-input" id="charger"name="charger"style="font-size:12px; width:100%;" onchange="toggleChargerOtherField()">
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list18" items="${list18}">
                                                    <option value="${list18.chargerMaster}">
                                                        ${list18.chargerMaster}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <div id="otherTextDiv" style="display:none; margin-top:8px; width:100%;">
                                                <textarea id="otherText" class="input-field" name="chargerOther" placeholder="Please specify" rows="3"style="width:100%; box-sizing:border-box; resize:vertical;"></textarea>
                                            </div>
                                        </td>

                                <script>
                                    function toggleChargerOtherField() {
                                        const chargerValue = document.getElementById("charger").value;
                                        const otherDiv = document.getElementById("otherTextDiv");

                                        if (chargerValue === "Other") {
                                            otherDiv.style.display = "block";
                                        } else {
                                            otherDiv.style.display = "none";
                                            document.getElementById("otherText").value = "";
                                        }
                                    }
                                </script>
                                
                                <td><textarea id="chargerCapacityKW" name="chargerCapacityKW" placeholder="chargerCapacityKW" class="input-field" type="text"></textarea> 
                                <td><textarea id="chargermodel" name="chargermodel" placeholder="charger Model" class="input-field" type="text"></textarea> 
                                
                                <td>
                                    <select class="select-input" id="connectorType"name="connectorType" style="font-size: 12px;"  onchange="toggleConnectorOtherField()">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list19" items="${list19}">
                                            <option value="${list19.connectorType}">
                                                ${list19.connectorType}
                                            </option>
                                        </c:forEach>
                                    </select>

                                    <div id="connectorOtherTextDiv" style="display:none; margin-top:8px; width:100%;">
                                        <textarea id="connectorOtherText"class="input-field" name="connectorOther"placeholder="Please specify" rows="3" style="width:100%; box-sizing:border-box; resize:vertical;"></textarea>
                                    </div>
                                </td> 
                                <script>
                                    function toggleConnectorOtherField() {
                                    document.getElementById("connectorOtherTextDiv").style.display =
                                        document.getElementById("connectorType").value === "Other"
                                        ? "block"
                                        : "none";

                                    if (document.getElementById("connectorType").value !== "Other") {
                                        document.getElementById("connectorOtherText").value = "";
                                    }
                                    }
                                </script>
                                
                                <td><textarea id="noofconnectors" name="noofconnectors" placeholder="No Of Connectors" class="input-field" type="text" ></textarea> 
                                <td><textarea id="noofchargers" name="noofchargers" placeholder="No Of Chargers" class="input-field" type="text" ></textarea> 
                                <td><textarea id="chargingrateperunit" name="chargingrateperunit" placeholder="charging Rate Per Unit" class="input-field" type="text" ></textarea> 


                                <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                    <div class="clone-action clone-new-field mb-2" id="policyCloneidCharger" style="cursor:pointer;">
                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                    </div>
                                </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
            <script>
    if ($("#policyTableCharger").length) {
        const table1 = initDocTable("#policyTableCharger");
    }

    var tempCount0 = 1;
    $(function () {
        $("#policyCloneidCharger").on("click", function () {
            tempCount0++;

            var clone = "<tr id='addmoreFileCharger" + tempCount0 + "' style='clear:both;'>"

                + "<td style='text-align: center '><div>"
                + "<select id='chargerType" + tempCount0 + "' name='chargerType' class='select-input'>"
                + "<option value=''>--Select--</option>"
                + "<c:forEach var='list17' items='${list17}'>"
                + "<option value='${list17.chargerType}'>${list17.chargerType}</option>"
                + "</c:forEach>"
                + "</select>"
                + "</div></td>" 
        
               + "<td style='text-align:center;'>"
                + "<div>"

                + "<select id='charger" + tempCount0 + "' "
                + "name='charger' "
                + "class='select-input' "
                + "onchange='toggleChargerScriptOtherField(" + tempCount0 + ")'>"

                + "<option value=''>--Select--</option>"
                + "<c:forEach var='list18' items='${list18}'>"
                + "<option value='${list18.chargerMaster}'>${list18.chargerMaster}</option>"
                + "</c:forEach>"
                + "</select>"

                + "<div id='otherTextDiv" + tempCount0 + "' "
                + "style='display:none; margin-top:8px; width:100%;'>"

                + "<textarea id='otherText" + tempCount0 + "' "
                + "name='chargerOther' "
                + "class='input-field' "
                + "placeholder='Please specify' "
                + "rows='3' "
                + "style='width:100%; box-sizing:border-box; resize:vertical;'>"
                + "</textarea>"

                + "</div>"
                + "</div>"
                + "</td>" 
        
                + "<td><textarea type =\"text\" class=\"input-field\" placeholder=\"charge rCapacity KW\" name=\"chargerCapacityKW" + "" + "\" id=\"chargerCapacityKW" + tempCount0 + "\"></textarea>"
                + "<td><textarea type =\"text\" class=\"input-field\" placeholder=\"charger Model\" name=\"chargermodel" + "" + "\" id=\"chargermodel" + tempCount0 + "\"></textarea>"
                 
               + "<td style='text-align:center;'>"
                + "<div>"

                + "<select id='connectorType" + tempCount0 + "' "
                + "name='connectorType' "
                + "class='select-input' "
                + "onchange='toggleScriptConnectorOtherField(" + tempCount0 + ")'>"

                + "<option value=''>--Select--</option>"
                + "<c:forEach var='list19' items='${list19}'>"
                + "<option value='${list19.connectorType}'>${list19.connectorType}</option>"
                + "</c:forEach>"
                + "</select>"

                + "<div id='connectorOtherTextDiv" + tempCount0 + "' "
                + "style='display:none; margin-top:8px; width:100%;'>"

                + "<textarea id='connectorOtherText" + tempCount0 + "' "
                + "name='connectorOther' "
                + "class='input-field' "
                + "placeholder='Please specify' "
                + "rows='3' "
                + "style='width:100%; box-sizing:border-box; resize:vertical;'>"
                + "</textarea>"

                + "</div>"
                + "</div>"
                + "</td>"
            
            
                + "<td><textarea type =\"text\" class=\"input-field\" placeholder=\"no Of Connectors\" name=\"noofconnectors" + "" + "\" id=\"noofconnectors" + tempCount0 + "\"></textarea>"
                + "<td><textarea type =\"text\" class=\"input-field\" placeholder=\"no Of Chargers\" name=\"noofchargers" + "" + "\" id=\"noofchargers" + tempCount0 + "\"></textarea>"
                + "<td><textarea type =\"text\" class=\"input-field\" placeholder=\"charging Rate Per Unit\" name=\"chargingrateperunit" + "" + "\" id=\"chargingrateperunit" + tempCount0 + "\"></textarea>"

                + "<td class=\"d-flex justify-content-center align-items-center\">"
                + "<span style='margin-top: 5px;'>"
                + "  &nbsp;&nbsp;&nbsp;"
                + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removePolicyCharger('addmoreFileCharger" + tempCount0 + "');\">"
                + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                + "</div>"
                + "</span>"
                + "</td>"
                + "</tr>";

            $("#policyTableCharger").append(clone);
            $('.select-input').selectpicker("refresh");
            document.getElementById('policyCountCharger').value = tempCount0;
        });
    });

    function removePolicyCharger(policyDivCharger) {
        try {
            var element1 = document.getElementById(policyDivCharger);
            element1.parentNode.removeChild(element1);

            updateSerialNumbersCharger();

            var policyCountCharger = document.getElementById('policyTableCharger').rows.length - 1;

            document.getElementById('policyCountCharger').value = policyCountCharger;

        } catch (e) {
            console.log(e);
        }
    }

    function updateSerialNumbersCharger() {
        var table = document.getElementById('policyTableCharger');
        var rowCount = table.rows.length;
        var srNo = 1;

        for (var i = 1; i < rowCount; i++) {
            if (table.rows[i].id !== '') {
                table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
            }
        }
    }
function toggleChargerScriptOtherField(index) {
    const chargerValue = document.getElementById("charger" + index).value;
    const otherDiv = document.getElementById("otherTextDiv" + index);

    if (chargerValue === "Other") {
        otherDiv.style.display = "block";
    } else {
        otherDiv.style.display = "none";
        document.getElementById("otherText" + index).value = "";
    }
}
function toggleScriptConnectorOtherField(index) {
    const connectorValue =
        document.getElementById("connectorType" + index).value;

    const otherDiv =
        document.getElementById("connectorOtherTextDiv" + index);

    if (connectorValue === "Other") {
        otherDiv.style.display = "block";
    } else {
        otherDiv.style.display = "none";
        document.getElementById("connectorOtherText" + index).value = "";
    }
}

</script>  







            <table class="table table-bordered mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->

                                              


  

                                                <tr>
<!--                                                    <td style="border: 1px solid black;"><strong>Charging Station Protocol:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="guns" id="guns" value="${oapForm. noOfGuns}" required="true"/> </td> -->
                                                    <td style="border: 1px solid black;"><strong>Total No Of Chargers:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="NoOfCharger" id="NoOfCharger" value="${oapForm.noOfCharger}" required="required"/> </td>                   
                                                    <td style="border: 1px solid black;"><strong>Project Timeline Category:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="projectTimelineCategory" id="projectTimelineCategory" required>
                                                            <option value="">-- Select--</option>
                                                            <option value="LT" ${oapForm.projectTimelineCategory == 'LT' ? 'selected' : ''}>LT</option>
                                                            <option value="HT" ${oapForm.projectTimelineCategory == 'HT' ? 'selected' : ''}>HT</option>
                                                            <option value="EQUATOR" ${oapForm.projectTimelineCategory == 'EQUATOR' ? 'selected' : ''}>EQUATOR</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Time Line Of Project Completion: <br>From Date<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                   <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input 
                                                                name="Fromdate" type="text" style="width: 42vh;"placeholder="DD-MM-YYYY"class="input-field form_datetime" id="newDatepicker" value="${oapForm.timeLineFromDate}" required maxlength="30" required="required" />

                                                        </div>
                                                    </td>


                                                    <td style="border: 1px solid black;"><strong>To Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input name="Todate" type="text" style="width: 44vh; " class="input-field form_datetime" id="datetimepickers2" value="${oapForm.timeLineToDate}" maxlength="30" required="true"/>

                                                        </div>
                                                    </td>
                                                </tr>


<script type="text/javascript">
    $(document).ready(function () {

        flatpickr("#newDatepicker, #datetimepickers2", {
            dateFormat: "d-m-Y",
            minDate: "today",
            allowInput: true
        });

        // ✅ Dropdown change logic
        $('#projectTimelineCategory').on('change', function () {
            var selected = $(this).val();

            var daysToAdd = 0;

            if (selected === 'LT') {
                daysToAdd = 90;
            } else if (selected === 'HT') {
                daysToAdd = 120;
            } else if (selected === 'EQUATOR') {
                daysToAdd = 180;
            }

            if (daysToAdd > 0) {

                // 👉 Set From Date = Today
                var today = new Date();

                var from_dd = String(today.getDate()).padStart(2, '0');
                var from_mm = String(today.getMonth() + 1).padStart(2, '0');
                var from_yyyy = today.getFullYear();

                var fromDateFormatted = from_dd + "-" + from_mm + "-" + from_yyyy;

                $('#newDatepicker').val(fromDateFormatted);

                // 👉 Calculate To Date
                var toDateObj = new Date();
                toDateObj.setDate(toDateObj.getDate() + daysToAdd);

                var to_dd = String(toDateObj.getDate()).padStart(2, '0');
                var to_mm = String(toDateObj.getMonth() + 1).padStart(2, '0');
                var to_yyyy = toDateObj.getFullYear();

                var toDateFormatted = to_dd + "-" + to_mm + "-" + to_yyyy;

                $('#datetimepickers2').val(toDateFormatted);

                // 👉 Set No. of Days
                $('#chargingrate').val(daysToAdd);
            }
        });

    });
</script>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Estimated Budget:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;" ><input  class="input-field" name="budgetallocated" id="budgetallocated" value="${oapForm. projectBudgetAllocated}" required="true"/> </td> 
                                                    <td style="border: 1px solid black;"><strong>No.Of Days:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="chargingrate" id="chargingrate" value="${oapForm.chargingRatePerUnit}"  /> </td> 

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Others Details:<span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea class="textarea-field" style="width: 100%; height: 100px; border: none; resize: none;" name="othersDetails" id="othersDetails" required="true">${oapForm.othersDetails}</textarea>
                                                    </td>
                                                </tr>

                                                    <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="select-input" id="ProjectProfile" name="ProjectProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                        <select class="select-input" id="profitcenter" name="profitcenter" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                    <td style="border: 1px solid black;"><strong>Company Code:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" id="CompanyCode" name="CompanyCode" style="font-size: 12px; padding: 5px;" required="required">
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
                                                 
<select class="select-input" id="plant" name="plant" style="font-size: 12px; padding: 5px;" required="required">
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
                                                        <select class="select-input" id="ProjectType" name="ProjectType" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                    <td style="border: 1px solid black;"><select class="select-input" id="ProjectCurrency" name="ProjectCurrency" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                    <td style="border: 1px solid black;"><select class="select-input" id="InvestmentProfile" name="InvestmentProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
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

                                                    <td style="border: 1px solid black;"><strong>Capital:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                   
                                                        <input type="text" class="input-field" name="Discom" id="Discom"  value="${Discom1}" readonly="true"/>
                                                    </td>

                                                </tr>





<!--                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="ChargePoints" id="ChargePoints" value="${oapForm.noOfChargePoints}" required="required"/> </td>    
                                                     

                                                </tr>-->
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Overall Station Capacity (kW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="overallstations" id="overallstations" value="${oapForm.overallStationCapacityKw}" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Station AC Capacity (kW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="stationAc" id="stationAc" required="required" value="${oapForm.stationAcCapacityKw}" /> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station DC Capacity (kW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="stationDc" id="stationDc" required="required" value="${oapForm.stationDcCapacityKw}"/> </td>    
                                                     <td style="border: 1px solid black;"><strong>Total MegaWatt(MW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                     <td style="border: 1px solid black;"><input  class="input-field" name="totalMW" id="totalMW" value="${oapForm.totalMegaWatt}" onkeydown="return false;" readonly/> </td> 
<script>
function calculateTotalMW() {

    let stationAc = document.getElementById("stationAc").value;
    let overallstations = document.getElementById("overallstations").value;

    stationAc = stationAc.replace(/[^0-9.]/g, '');

    overallstations = overallstations.replace(/[^0-9]/g, '');

    document.getElementById("stationAc").value = stationAc;
    document.getElementById("overallstations").value = overallstations;

    let stationAcValue = parseFloat(stationAc) || 0;
    let overallstationsValue = parseFloat(overallstations) || 0;

    let totalKW = stationAcValue + overallstationsValue;

    let totalMW = totalKW / 1000;

    document.getElementById("totalMW").value =
        totalKW > 0 ? totalMW.toFixed(3) : "";
}

document.getElementById("stationAc")
    .addEventListener("input", calculateTotalMW);

document.getElementById("overallstations")
    .addEventListener("input", calculateTotalMW);
</script>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" id="stationtype" name="stationtype" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                        <select class="select-input" id="tenant" name="tenant" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                        
                                                    <td style="border: 1px solid black;"><strong>Total kw Rating:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" value="${oapForm.totalKwRating}" name="totalKwRating" id="totalKwRating" required="required"/> </td> 
                                                   <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                       <div class="form-group date" id="datetimepickers6"> 
                                                        <input  class="input-field" style="background: white;" placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" value="${oapForm.specificDateFromClient}" name="specificDateFromClient" id="specificDateFromClient" />
                                                       </div>
                                                    </td>
                                                    <script >
                                                $(function () {
                                                    flatpickr("#specificDateFromClient", {
                                                        dateFormat: "d-m-Y"
                                                    });
                                                });
                                               </script>  
                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Charger Capacity:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="totalChargerCapacity" value="${oapForm.totalChargerCapacity}" id="totalChargerCapacity" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Charger Station Access Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="chargerStationAccessType" id="chargerStationAccessType" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="public" ${oapForm.chargerStationAccessType == 'public' ? 'selected' : ''}>Public</option>
                                                            <option value="private" ${oapForm.chargerStationAccessType == 'private' ? 'selected' : ''}>Private</option>
                                                            <option value="hybrid" ${oapForm.chargerStationAccessType == 'hybrid' ? 'selected' : ''}>Hybrid</option>

                                                        </select>
                                                    
                                                    
                                                    </td>
                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="auxiliaryLoadOfStation" value="${oapForm.auxiliaryLoadOfStation}" id="auxiliaryLoadOfStation" /> </td>    
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="chargingRetePerUnit" value="${oapForm.chargingRetePerUnit}" id="chargingRetePerUnit" required="required"/> </td> 

                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Evs To Be Charged / No. of Parking:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="noOfEvsToBeChanged" value="${oapForm.noOfEvsToBeChanged}" id="noOfEvsToBeChanged" required="required"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Anchore Customer</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                  
                                                  <td  style="border: 1px solid black;">
                                                       <select class="select-input" id="anchoreCustomer" name="anchoreCustomer" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list15" items="${list15}">
                                                                <c:choose>
                                                                    <c:when test="${list15.name eq name}">
                                                                        <option selected="true" value="${list15.name}">${list15.name}</option>
                                                                    </c:when>  

                                                                    <c:otherwise>
                                                                        <option value="${list15.name}">${list15.name}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select> 
                                                     </td> 

                                                </tr>    
                                                <tr>
                                               <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="scopeofChargeZone" id="scopeofChargeZone" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="1" ${oapForm.scopeOfchargeZone == '1' ? 'selected' : ''}>YES</option>
                                                            <option value="0" ${oapForm.scopeOfchargeZone == '0' ? 'selected' : ''}>NO</option>
                                                            
                                                        </select>
                                                    </td> 
                                                    
                                                    
                                                     <td style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="stationname" id="stationname" required="required" value="${oapForm.stationName}"/> </td> 
                                                  
                                                </tr>
                                                <tr id="canopyRow" style="display:none;">
                                                    <td style="border: 1px solid black;">
                                                        <strong>Canopy Varient</strong>
                                                        <span style="color: red;font-size: 12px;">*</span>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                            <select class="select-input" id="canopyVarient" name="canopyVarient">                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list16" items="${list16}">
                                                                <c:choose>
                                                                    <c:when test="${list16.name eq names}">
                                                                        <option selected="true" value="${list16.name}">${list16.name}</option>
                                                                    </c:when>  
                                                                    <c:otherwise>
                                                                        <option value="${list16.name}">${list16.name}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                     
                                                    <td style="border: 1px solid black;"></td>
                                                    <td style="border: 1px solid black;"> </td>
                                                </tr>
<script>
function toggleCanopy() {
    var value = document.getElementById("scopeofChargeZone").value;
    var row = document.getElementById("canopyRow");
var canopy = document.getElementById("canopyVarient");
    if (value === "1") {
        row.style.display = "";
    } else {
        row.style.display = "none";
        canopy.value = ""; 
    }
}

document.addEventListener("DOMContentLoaded", function () {

    // dropdown change
    document.getElementById("scopeofChargeZone")
        .addEventListener("change", toggleCanopy);

    // run on load
    toggleCanopy();

    // ✅ ADD VALIDATION HERE (same block)
    document.getElementById("submitButton")
        .addEventListener("click", function(e) {

        var scope = document.getElementById("scopeofChargeZone").value;
        var canopy = document.getElementById("canopyVarient").value;

        if (scope === "1" && canopy === "") {

            e.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Please select Canopy Variant'
            });

            return false;
        }
    });

});
</script>
                                                <tr>
                                                 <td style="border: 1px solid black;"><strong>Connection Type:</strong></td>

                                                     <td style="border: 1px solid black;">
                                                   
                                                         <input type="text" class="input-field" name="" id=""  value="${connection}" readonly="true"/>
                                                    </td>
                                                  <td style="border: 1px solid black;"><strong>Site Survey</strong></td>
                                                 <td style="border: 1px solid black;"><input  class="input-field" name="sitesurvey" id="sitesurvey" required="required" value="${oapForm.siteSurvey}"/> </td> 


                                                    
                                                    
                                                </tr>
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>Survey</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <input type="radio" name="Survey" onclick="return toggleDisplay();" id="Survey" value="siteSurveycreated" required="true"
                                                               <c:if test="${oapForm.surveyRadio == '1'}">checked="checked"</c:if> /> <b>Site Survey Created</b> &nbsp;&nbsp;

                                                               <input type="radio" name="Survey" onclick="return toggleDisplay();" id="Survey" value="siteSurveynotcreated"
                                                               <c:if test="${oapForm.surveyRadio == '0'}">checked="checked"</c:if> /> <b>Site Survey Not Created</b>
                                                        </td>
                                                    </tr>
                                                   
                                                    
                                                    
                                                <c:if test="${oapForm.surveyRadio == '1'}">
                                                    <table id="SurveyList" class="table table-striped bg-white dt-scroll" style="width: 100%" align="center">
                                                        <thead>

                                                            <tr>
                                                                <th  >Sr No</th>
                                                                <th >Survey No</th>
                                                                <th  >Project Representative</th>
                                                                <th  >Action</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            
                                                            <c:forEach var="oapSurveyAttch" items="${oapSurveyAttch}" varStatus="status">
                                                                <tr>
                                                                    <td ><span>${status.count}</span>
                                                                    </td> 
                                                                    <td><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${oapSurveyAttch.surveyNo}">${oapSurveyAttch.surveyNo}</a></td>

                                                                    <td ><span>${oapSurveyAttch.projectRepresentative}</span>
                                                                    </td> 
                                                                    <td style="text-align: center;">

                                                                        <a href="oapForm.htm?act=oapSurveyDelete&id1=${oapSurveyAttch.id}&id=${oapForm.id}" class="d-block text-danger p-1 mx-1 action-link" data-toggle="tooltip"
                                                                           data-placement="left" title="Delete">
                                                                            <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"
                                                                                 alt="Delete Icon">
                                                                        </a>
                                                                    </td>


                                                                </tr>
                                                            </c:forEach>  

                                                        </tbody>


                                                    </table>
                                                    <hr>
                                                </c:if>
                                                    
                                                    <script>
                                                 var table = $('#SurveyList').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "info": true,
        "autoWidth": false,
        "ordering": true,
        "columnDefs": [
            { "orderable": false, "targets": [3] }
        ],
        "order": [[1, 'asc']],
        "dom": 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'
    });         
                                                    </script>                                                    
                                                    
                                                    
<script>
    function toggleDisplay() {
        var surveys = document.getElementsByName("Survey");
        var toggleId = document.getElementById("toggleId");
        var surveyNo = document.getElementsByName("surveyNo");
        

        if (surveys[0].checked) {
            toggleId.style.display = "block";
            if(${size == 0}){
            for (var i = 0; i < surveyNo.length; i++) {
                surveyNo[i].setAttribute("required", "true");
            }
        }
         if ($("#toggleId").length) {
                                    const table1 = initDocTable("#toggleId");
                                }
        } else {
            toggleId.style.display = "none";
            for (var i = 0; i < surveyNo.length; i++) {
                surveyNo[i].removeAttribute("required");
                surveyNo[i].value = "";
            }
        }
    }
</script>
                                                                     
                                                    
                                                    <script>
function surveyValidate() {

    var surveyElements = document.getElementsByName("Survey");
    var sizeElements = document.getElementsByName("size");

    var survey = "";
    for (var i = 0; i < surveyElements.length; i++) {
        if (surveyElements[i].checked) {
            survey = surveyElements[i].value;
            break;
        }
    }

//    alert(survey);

    var size = sizeElements.length > 0 ? sizeElements[0].value : "";

    if (survey === "siteSurveycreated") {
        return true;
    } else {
        if (size !== '0') {
            alert("Delete Survey No");
            return false;
        } else {
            return true;
        }
    }
}
</script>

                                                        
                                            </table>
                                <table id="toggleId"  class="table table-striped bg-white dt-scroll"   style="width:100%;"  align="center">
                                                <thead>
                                                    <tr>

                                                        <th style="width: 50%;">Survey No</th>
                                                        <th style="width: 100%;">Project Representative</th>
                                                        <th style="width: 100%;">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="Table">
                                                    <tr>
                                                <input type="hidden" name="policy" id="policy" value="1"/>

                                                <td style="width: 40%;">
                                                    <input id="siteradio" name="surveyNo" placeholder="Survey No" maxlength="10" minlength="10" class="input-field" type="text">
                                                </td>
                                                <td style="width: 40%;">
                                                    <input id="projectRepresentative" name="projectRepresentative" placeholder="Project Representative" class="input-field" type="text">
                                                </td>
                                                <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                            <div class="clone-action clone-new-field mb-2" id="Cloneids" style="cursor:pointer;">
                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                            </div>
                                        </td>
                                                </tr>
                                                </tbody>
                                            </table>
            <hr>
<script>
    var rowCounter = 1; // Initial row count

    $(function () {
        // Event handler for "+" button to add new rows
        $("#Cloneids").on("click", function () {
            rowCounter++; // Increment the row counter
            var newRow = "<tr id='addRow" + rowCounter + "' style='clear:both;'>"
                + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Survey No\" minlength=\"10\" maxlength=\"10\" name=\"surveyNo\" id=\"surveyNo" + rowCounter + "\"></td>"
                + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Project Representative\" name=\"projectRepresentative\" id=\"projectRepresentative" + rowCounter + "\"></td>"

                + "<td>"
                + "<span style='margin-top: 5px;'>"
                + "  <div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removeRow('addRow" + rowCounter + "');\">"
                + "    <img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                + "  </div>"
                + "</span>"
                + "</td>" + "</tr>";
            $("#Table").append(newRow); // Add the new row to the table
            document.getElementById('policy').value = rowCounter; // Update the hidden input field with the row count
        });
    });

    // Function to remove a row
    function removeRow(rowId) {
        try {
            var rowToRemove = document.getElementById(rowId); // Get the row by its ID
            rowToRemove.parentNode.removeChild(rowToRemove); // Remove the row from the table
            // Update the policy count in the hidden input field
            var rowCount = document.getElementById('Table').rows.length;
            document.getElementById('policy').value = rowCount;
        } catch (e) {
            console.log(e);
        }
    }
</script>




                                       
                                      

        
                                                                <!--                                            <div class="table">-->

                                                                <table id="commonNoPageTable" class="table table-striped " align="Center">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Document Name</th>
                                                                            <th >Attachment
                                                                           <c:if test="${prdSize != 0}">
                                                                                <a  href="oapForm.htm?act=oapDocxdownloadzip&fileName=${list[0]}&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                                                    &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                                                </a>
                                                                            </c:if>
                                                                           </th>
                                                                            <th data-dt-order="disable">Action</th>
                                                                        </tr>
                                                                    </thead>

                                                                    <c:forEach var="list" items="${list}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list[1]}</td>
                                                                            <td>
                                                                                <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list[0]}&id1=${id}">${list[0]}</a>
                                                                            </td>


                                                                            <td style="text-align: center;">
                                                                                <a href="oapForm.htm?act=oapFormdocuDelete&id1=${list[2]}&id=${oapForm.id}" 
                                                                                   class="d-block text-danger p-1 mx-1 action-link delete-btn1" 
                                                                                   data-toggle="tooltip"
                                                                                   data-placement="left" 
                                                                                   title="Delete">

                                                                                    <img src="StorageYard/assets/images/delete-icon.svg" 
                                                                                         onload="SVGInject(this)"
                                                                                         alt="Delete Icon">
                                                                                </a>                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>

                                                                    <c:forEach var="list33" items="${list33}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list33[1]}</td>
                                                                            <td><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>
                                                                            <td style="text-align: center;">
                                                                                <a href="oapForm.htm?act=oapFormdocuDelete1&id1=${list33[2]}&id=${oapForm.id}" 
                                                                                   class="d-block text-danger p-1 mx-1 action-link delete-btn1" 
                                                                                   data-toggle="tooltip"
                                                                                   data-placement="left" 
                                                                                   title="Delete">

                                                                                    <img src="StorageYard/assets/images/delete-icon.svg" 
                                                                                         onload="SVGInject(this)"
                                                                                         alt="Delete Icon">
                                                                                </a>                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </table>





                                    <div class="col-md-12 p-0">
                            <div class="">
                                <table id="policyTable" class="table table-striped bg-white dt-scroll"  style="width:100%;"  align="center">
                                    <thead>

                                    <tr style="text-align: center;">
                                                        <th >Attachment</th>
                                                        <th >Description</th>

                                                        <!--                                                            <th style="text-align: center; vertical-align: middle">Document name</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                    </thead>
                                    <tbody>
                                                    <tr id="policyRow1">
                                                        <!--                                                        <td id="policyId1">
                                                                                                                    <input type="text" class="input-field" name="srNo1" value="1" readonly>
                                                                                                                </td>                                                           -->
                                                        <td>
                                                            <input id="attachment1" name="attach" class="input-field" type="file"onchange="validateFileSize(this)">
                                                            <span id="fileError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>

                                                        </td> 



                                                        <td>
                                                            <input id="description1" name="descriptions" placeholder="Description" class="input-field" type="text" >
                                                        </td> 

                                                <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                                <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                                    <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                                </div>
                                            </td>
                                                    </tr>
                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                   


                  
                                    <script>
                                        if ($("#policyTable").length) {
                                            const table1 = initDocTable("#policyTable");
                                        }
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
                + "<td><input type=\"file\" class=\"input-field\" placeholder=\"action\" name=\"attach\" id=\"attachment" + tempCount3 + "\">\n\
                    <span id='fileError" + tempCount3 + "' style='display:none; color:red; font-size:12px;'>* File should not exceed 5MB</span></td>"

                + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"

                + "<td >"
                + "<span style='margin-top: 5px;'>"
                + "  &nbsp;&nbsp;&nbsp;"
                + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                + "</div>"
                + "</span>"
                + "</td>"
                + "</tr>";

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

</script>

                                    <hr>

                                    
                                    
                                    
                                    
                                                                   
                                    <c:choose>
                                        <c:when test="${oapForm.flagStatus == '2'}">
                                            <table>

                                                <div class="rounded-4 mt-4">
                                                    <div class="row mb-3">
                                                        <div class="col-lg-6 col-md-9">
                                                            <div class="form-group">
                                                              <label  class="label" for="approvalName">Approval Name: <span style="color: red; font-size: 12px;">*</span></label>
                                                                </label>
                                                                <select class="select-input" id="approvalName" name="approvalName" style="width: 225px; font-size: 12px; padding: 5px;" required="true">
                                                                    <option value="">--SELECT--</option>
                                                                    <c:forEach var="list10" items="${list10}">
                                                                        <c:choose>
                                                                            <c:when test="${list10.id eq oapmasterId}">
                                                                                <option selected="true" value="${list10.id}">${list10.approvalName}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${list10.id}">${list10.approvalName}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>   
                                                        </div>

                                                    </div>
                                                </div>     




                                            </table>
                                        </c:when>

                                        <c:otherwise>
                                            <table style="margin-left: 5vh;">

                                                <div class="rounded-4 mt-4">
                                                    <div class="row mb-3">
                                                        <div class="col-lg-6 col-md-9">
                                                            <div class="form-group">
                                                                <label for="approvalName">CRC Creator</label>

                                                                </label>
                                                                <input class="input-field" name="" readonly="true" value="${crcCreator}">

                                                            </div>   
                                                        </div>

                                                    </div>
                                                </div>   



                                            </table>
                                        </c:otherwise>
                                    </c:choose>









                                    <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <c:choose>
                                                <c:when test="${oapForm.flagStatus == '2'}">
                                                    <button type="submit" id="submitBtn" class="btn theme-btn"  title="" value="">Recycle Submit</button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button type="submit" class="btn theme-btn" id="submitBtn" formaction="oapForm.htm?act=oapFormReverseEditsubmit" title="" value="">Reverse Submit</button>
                                                </c:otherwise>
                                                    
                                            </c:choose>
                                        </div>

                                    </div>
                
                
              </form:form>
        </section>
    </main>
         <script>
document.addEventListener("DOMContentLoaded", function () {

    document.getElementById("form1")
        .addEventListener("submit", validateForm);

});

function validateForm(e) {

    var chargeInstcount =
        parseInt(document.getElementById("chargeInstcount").value) || 0;

    console.log("chargeInstcount:", chargeInstcount);

    // validate only when DB count = 0
    if (chargeInstcount === 0) {

        var fields = [
            { id: "chargerType", name: "Charger Type" },
            { id: "charger", name: "Charger" },
            { id: "chargerCapacityKW", name: "Charger Capacity" },
            { id: "chargermodel", name: "Charger Model" },
            { id: "connectorType", name: "Connector Type" },
            { id: "noofconnectors", name: "No Of Connectors" },
            { id: "noofchargers", name: "No Of Chargers" },
            { id: "chargingrateperunit", name: "Charging Rate Per Unit" }
        ];

        for (var i = 0; i < fields.length; i++) {

            var field =
                document.getElementById(fields[i].id);

            if (!field || field.value.trim() === "") {

                e.preventDefault(); // stop submit

                Swal.fire({
                    icon: 'warning',
                    title: 'Required Field Missing',
                    text: fields[i].name + ' is required.'
                });

                if (field) {
                    field.focus();
                }

                return false;
            }
        }
    }

    // form submits automatically if validation passes
    return true;
}
</script>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
 
<body onload="toggleDisplay();">
    
</body>
</html>
