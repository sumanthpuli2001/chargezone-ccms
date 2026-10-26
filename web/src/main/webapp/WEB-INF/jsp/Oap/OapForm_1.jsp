
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Form Create</title>
    </head>
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
             <form:form action="oapForm.htm?act=oapFormSubmit" id="oapForm" method="post" enctype="multipart/form-data" commandName="vendorInformation1"
                   name='form1' onsubmit="return surveyValidate();"  class="form-horizontal" role="form">
           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">OAP Form Create</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <button type="button" onclick="history.back();" class="btn theme-btn light-btn mr-3">
                            Back
                        </button>
                        <button type="submit" id="submitButton" class="btn theme-btn mr-3"  title="" value="">SUBMIT</button>
                        <button type="submit" class="btn theme-btn" id="oapSavDraft"  formaction="oapForm.htm?act=oapSaveAsDraft" title="" value="Save As Draft">Save As Draft</button>

                    </div>


                </div>

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
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                        <br>
            <table class="table table-bordered mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->
                                                <thead>
                                                    <tr>
                                                        <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center;"><strong>PCS Order Details:</strong></td>
                                                    </tr>

                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                        <td  style="border: 1px solid black; width: 20%;"><input  class="input-field" name="documentNo" id="documentNo" readonly autocomplete="off"/> </td>                           
                                                        <td style="border: 1px solid black; "><strong>PCS Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;"><input  class="input-field" name="pcsName"  id="pcsName" required="required" autocomplete="off"/> </td>    
                                                    </tr>
                                                    <tr>
                                                        <td style="border: 1px solid black;"><strong>Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;">
                                                            <div class="input-group">
                                                                <input name="date"  style="width: 42vh; " type="text" placeholder="DD-MM-YYYY"  class="input-field" id="datetimepicker1" required="required" autocomplete="off" />
                                                            </div>
                                                        </td>
                                                        <td style="border: 1px solid black;"><strong>Document Revision No:</strong></td>
                                                        <td style="border: 1px solid black;">
                                                            <input type="text" class="input-field" name="documentRevisonNo" id="documentRevisonNo" required="required" readonly autocomplete="off"/>
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
<!--                                                    <td style="border: 1px solid black;"><input  class="input-field" name="projectName" id="projectName" required="required" autocomplete="off"/> </td>    -->
                                                   <td style="border: 1px solid black;"><select class="select-input" id="projectName" name="projectName" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list14" items="${list14}">
                                                                <option value="${list14.projectName}">${list14.projectName}</option>
                                                            </c:forEach>
                                                        </select>  
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>PCS City/Highway:</strong></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="city/highway" id="city/highway" autocomplete="off"/> </td>    
                                                </tr>

                                                <tr>

                                                <tr>
                                                    <td style="border: 1px solid black; width: 25%;"><strong>Country:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black; width: 25%;">
                                                        <select class="select-input" name="country" id="countryDropdown" required="required"></select>
                                                    </td>

                                                    <td style="border: 1px solid black;width: 25%;"><strong>State:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <select class="select-input" onchange="fetchDocumentList(this.value)" name="state" id="stateDropdown" required="required"></select>
                                                    </td>
                                                </tr>

                                                <script>
                          
                                                    function fetchDocumentList(state) {
                                                        // Alert to check the selected state
                                                        //    alert("Selected State: " + state);

                                                        // If you need to capture the state value directly from the dropdown:
                                                        var selectedState = document.getElementById("stateDropdown").value;

                                                        // Send AJAX request to fetch documents based on selected state
                                                        $.ajax({
                                                            data: 'state=' + state,
                                                            url: "oapForm.htm?act=selectAllDocumentByState",
                                                            success: function(content) {

                                                                var data1 = "";
                                                                var obj = JSON.parse(content);
                                                                var objLength = Object.keys(obj['discomCategory']).length;

                                                                var object = obj['discomCategory'];
                                                                for (var i = 0; i < objLength; i++) {
                                                                    if (i === 0) {
                                                                        data1 = "<option value=''>-- Select --</option><option value='" + object[i].id + "'>" + object[i].discomname + "</option>";
                                                                        document.getElementById('Discom').innerHTML = data1;
                                                                        console.log(data1);
                                                                    } else {
                                                                        data1 += "<option value='" + object[i].id + "'>" + object[i].discomname + "</option>";
                                                                        document.getElementById('Discom').innerHTML = data1;
                                                                        console.log(data1);
                                                                    }
                                                                }
                                                                //here new line added main
                                                                $('.select-input').selectpicker("refresh");
                                                            },
                                                            error: function(xhr, status, error) {
                                                                alert("Error fetching documents: " + error);
                                                            }
                                                        });
                                                    }

                                                </script>

                                                <script>
                                                    
                                                    document.addEventListener("change", function (event) {
                                                        if (event.target.type === "file") {
                                                            var file = event.target.files[0];
                                                            var inputId = event.target.id;
                                                            var warningId = "warning_" + inputId;
                                                            // Remove any existing warning message
                                                            var existingWarning = document.getElementById(warningId);
                                                            if (existingWarning) {
                                                                existingWarning.remove();
                                                            }

                                                            if (file && file.size > 5 * 1024 * 1024) { // 5MB in bytes
                                                                var warningMessage = document.createElement("div");
                                                                warningMessage.id = warningId;
                                                                warningMessage.style.color = "red";
                                                                warningMessage.style.fontSize = "12px";
                                                                warningMessage.innerText = "* File should not exceed 5MB";
                                                                // Append warning message below the file input
                                                                event.target.parentNode.appendChild(warningMessage);
                                                                // Clear the file input
                                                                event.target.value = "";
                                                            }
                                                        }
                                                    });
                                                    function fetchDocumentList1() {
                                                    // Alert to check the selected state
                                                    //    alert("Selected State: " + state);

                                                    // If you need to capture the state value directly from the dropdown:
                                                        var connectiontype = document.getElementById("connectiontype").value;

                                                        var Discom = document.getElementById("Discom").value;
                                                            // Send AJAX request to fetch documents based on selected state
                                                            $.ajax({
                                                                url: "oapForm.htm?act=selectAllDocumentByState1&Discom=" + Discom + "&connectiontype=" + connectiontype
                                                                    ,success: function(content) {

                                                                   var data1 = "";
                                                                            var obj = JSON.parse(content);
                                                                            var objLength = Object.keys(obj['documentCategory']).length;
                                                                            var object = obj['documentCategory'];
                                                                            var j = 1;
                                                                            // Loop through document categories and build HTML for table rows
                                                                            for (var i = 0; i < objLength; i++) {
                                                                                var requiredMark = object[i].compalsuary === "yes" ? " <span style='color:red;'>*</span>" : ""; // Add red star for required fields
                                                                                if (i === 0) {
                                                                                    data1 = "<tr style='clear:both;'>"
                                                                                            + "<td>" + j + "</td>"
                                                                                            + "<td>" + object[i].documentName + requiredMark + "" // Add star here
                                                                                            + "<input type=\"hidden\" name=\"id\" value='" + object[i].id + "' id=\"id" + j + "\">"
                                                                                            + "<input type=\"hidden\" name=\"compulsary\" id=\"compulsary" + j + "\" value='" + object[i].compalsuary + "'></td>"
                                                                                            + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptiones\" id=\"descriptiones" + j + "\"></td>"
                                                                                            + "<td id=\"uploadSection" + j + "\"><input type=\"file\" class=\"input-field\" placeholder=\"action\" name=\"attchment\" id=\"attchment" + j + "\"";
                                                                                            if (object[i].compalsuary === "yes") {
                                                                                    data1 += " required";
                                                                                    }
                                                                                    data1 += "></td></tr>";
                                                                                    } else {
                                                                    data1 += "<tr style='clear:both;'>"
                                                                            + "<td>" + j + "</td>"
                                                                            + "<td>" + object[i].documentName + requiredMark + "" // Add star here
                                                                            + "<input type=\"hidden\" name=\"id\" value='" + object[i].id + "' id=\"id" + j + "\">"
                                                                            + "<input type=\"hidden\" name=\"compulsary\" id=\"compulsary" + j + "\" value='" + object[i].compalsuary + "'></td>"
                                                                            + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptiones\" id=\"descriptiones" + j + "\"></td>"
                                                                            + "<td id=\"uploadSection" + j + "\"><input type=\"file\" class=\"input-field\" placeholder=\"action\" name=\"attchment\" id=\"attchment" + j + "\"";
                                                                            if (object[i].compalsuary === "yes") {
                                                                    data1 += " required";
                                                                    }
                                                                    data1 += "></td></tr>";
                                                                    }
                                                                    j++;
                                                                    }
                                                                    
 
                   // Inject the generated table rows into the table body
//                                                                    document.querySelector("#table_5 tbody").innerHTML = data1;
                                                                   
                                                                   if ($.fn.DataTable.isDataTable('#table_5')) {
    $('#table_5').DataTable().clear().destroy();
}

$('#table_5 tbody').html(data1); // your generated <tr> HTML

if ($("#table_5").length) {
    initNoPageTable("#table_5");
}
                                                                   //here new line added main
                                                                $('.select-input').selectpicker("refresh");
                                                                    },
                                                                    error: function(xhr, status, error) {

                                                                    }
                                                            });
                                                    }

                                                </script>

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>City:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="city" id="city" required="required" autocomplete="off"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Street:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="pcsAddress" id="pcsAddress" autocomplete="off" required="required"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>District:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="district" id="district" required="required" autocomplete="off"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>House No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="houseno" id="houseno" required="required" autocomplete="off"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Pcs Type</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsType1" id="pcsType1"> A. City
                                                        </div> 
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsType2" id="pcsType2"> B. Highway
                                                        </div>
                                                        <br>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsType3" id="pcsType3" onclick="toggleOtherField()"> C. Other
                                                        </div>
                                                        <div id="otherFieldContainer" style="display: none; margin-top: 5px;">
                                                            <textarea id="pcstypeother" class="textarea-field" name="pcstypeother" rows="3" cols="30" placeholder="Please specify..."></textarea>
                                                        </div>
                                                    </td>

                                                <script>
                                                    function toggleOtherField() {
                                                    const checkbox = document.getElementById('pcsType3');
                                                            const container = document.getElementById('otherFieldContainer');
                                                            container.style.display = checkbox.checked ? 'block' : 'none';
                                                    }
                                                </script>


                                                <td style="border: 1px solid black; width: 5vh;"><strong>PCS Model</strong></td>
                                                <td style="border: 1px solid black;padding: 4px;">
                                                    <div style="display: inline; ">
                                                        <input type="checkbox" name="pcsModel" id="pcsModel"> A.DOCO 
                                                    </div> 
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="pcsMode2" id="pcsMode2"> B.COCO
                                                    </div>
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="pcsMode3" id="pcsMode3"> C.DODO
                                                    </div>
                                                    <br>
                                                     <div style="display: inline;">
                                                        <input type="checkbox" name="pcsMode5" id="pcsMode5"> D.SAAS
                                                    </div>
                                                    <div style="display: inline; ">
                                                        <input type="checkbox" name="pcsMode4" id="pcsMode4" onclick="toggleModeOtherField()"> E.Other
                                                    </div>
                                                    <div id="modeOtherFieldContainer" style="display: none; margin-top: 5px;">
                                                        <textarea id="pcsModelother" class="textarea-field" name="pcsModelother" rows="3" cols="30" placeholder="Please specify..."></textarea>
                                                    </div>

                                                    <script>
                                                                function toggleModeOtherField() {
                                                                const checkbox = document.getElementById('pcsMode4');
                                                                        const container = document.getElementById('modeOtherFieldContainer');
                                                                        container.style.display = checkbox.checked ? 'block' : 'none';
                                                                }
                                                    </script>

                                                </td>                                               
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Pcs Co-ordinates:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;width: 20%;"><input  class="input-field" name="pcscoordinates" id="pcscoordinates" required="required"/> </td>    
                                                    <td style="border: 1px solid black;width: 20%;"><strong>Client Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="mobileNo" id="mobileNo" required="required" /> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Client E-mail:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="email" placeholder="abc@gmail.com" id="email" required="required" type="email"/></td>    
                                                    <td style="border: 1px solid black;"><strong>Client  Mobile No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="alternatemobileNo" id="alternatemobileNo" required="required"/> </td>    
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of work: <span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" class="textarea-field"  name="clientDetails" id="clientDetails" required="required"></textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Client scope of work: <span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" class="textarea-field" name="clientscope" id="clientscope" required="required"></textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Specific Requirements of Clients:<span style="color: red;font-size: 12px;">*</span></strong></td> 
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" class="textarea-field" name="clientRequiremts" id="clientRequiremts" required="required"></textarea>
                                                    </td>
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Name of the sales lead:</strong> <span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="salesName" id="salesName" required="required" autocomplete="off"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Department:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="department" id="department" required="required"autocomplete="off" /> </td> 

                                                </tr>      

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="designation" id="designation" required />
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group">
                                                            <input name="date1"  type="text" placeholder="DD-MM-YYYY" class="input-field form_datetime" id="datetimepickers" required maxlength="30" required="required" autocomplete="off"/>
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


                                                <!--                                                <tr>
                                                                                                    <td style="border: 1px solid black;"><strong>Signature</strong></td>
                                                                                                    <td colspan="3" style="border: 1px solid black;">
                                                                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="signature1" id="signature1" required="required"></textarea>
                                                                                                    </td>                                              
                                                                                                </tr>-->









                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>PCS Deliverable Details:</strong></td>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black; width:25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery1" id="pcsDelivery1"onclick="toggleAttachment(this, 'attachment1', 'attachment1File', 'notification1')"> 
                                                            Agreement/LOA
                                                        </div>
                                                        <div id="attachment1" style="display: none; margin-top: 5px;">
                                                            <input class="input-field" style="font-size: 13px !important;" type="file" name="attachment1File" id="attachment1File" onchange="checkAttachmentSize(this, 'notification1')">
                                                            <div id="notification1" style="color: red; display: none; margin-top: 5px;">
                                                                Please upload a file.
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black; width:25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery2" id="pcsDelivery2" onclick="toggleAttachment(this, 'attachment2')"> Ownership Document
                                                        </div>
                                                        <div id="attachment2" style="display: none; margin-top: 5px;">
                                                            <input class="input-field" style="font-size: 13px !important;" type="file" name="attachment2File" id="attachment2File" onchange="checkAttachmentSize(this, 'notification2')">
                                                            <div id="notification2" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black; width:25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery3" id="pcsDelivery3" onclick="toggleAttachment(this, 'attachment3')"> Preliminary Site Survey
                                                        </div>
                                                        <div id="attachment3" style="display: none; margin-top: 5px;">
                                                            <input class="input-field" style="font-size: 13px !important;" type="file" name="attachment3File" id="attachment3File" onchange="checkAttachmentSize(this, 'notification3')">
                                                            <div id="notification3" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black; width:25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery4" id="pcsDelivery4" onclick="toggleAttachment(this, 'attachment4')"> Consent Letter/NOC
                                                        </div>
                                                        <div id="attachment4" style="display: none; margin-top: 5px;">
                                                            <input class="input-field" style="font-size: 13px !important;" type="file" name="attachment4File" id="attachment4File" onchange="checkAttachmentSize(this, 'notification4')">
                                                            <div id="notification4" style="color: red; display: none; margin-top: 5px;">Please upload a file.</div>
                                                        </div>
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
                                        <th >Charger Type<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>Charger<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>Charger Capacity<br>(kW)<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>Charger model<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>Connector Type<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>No of connectors<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>No of chargers<span style="color: red;font-size: 12px;">*</span></th>
                                        <th>Charging rate per unit<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                <input type="hidden" name="policyCountCharger" id="policyCountCharger" value="1"/>
                                </tr>
                                </thead>
                                <tbody style="border: 1px solid black;">
                                    <tr  id="policyRow1Charger" >
                                        <td>
                                            <select class="select-input" id="chargerType" name="chargerType" style=" font-size: 12px;" required="true" >
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list17" items="${list17}">
                                                    <option value="${list17.chargerType}">${list17.chargerType}</option>
                                                </c:forEach>
                                            </select>
                                        </td> 
                                        
                                        
                                        <td>
                                            <select class="select-input" id="charger"name="charger"style="font-size:12px; width:100%;"required="true"onchange="toggleChargerOtherField()">
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
                                
                                <td><textarea id="chargerCapacityKW" name="chargerCapacityKW" placeholder="chargerCapacityKW" class="input-field" type="text" required></textarea> 
                                <td><textarea id="chargermodel" name="chargermodel" placeholder="charger Model" class="input-field" type="text" required></textarea> 
                                
                                <td>
                                    <select class="select-input" id="connectorType"name="connectorType" style="font-size: 12px;"  required="true"onchange="toggleConnectorOtherField()">
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
                                
                                <td><textarea id="noofconnectors" name="noofconnectors" placeholder="No Of Connectors" class="input-field" type="text" required></textarea> 
                                <td><textarea id="noofchargers" name="noofchargers" placeholder="No Of Chargers" class="input-field" type="text" required></textarea> 
                                <td><textarea id="chargingrateperunit" name="chargingrateperunit" placeholder="charging Rate Per Unit" class="input-field" type="text" required></textarea> 


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
                                                    <!--<td style="border: 1px solid black;"><strong>Charging Station Protocol:</strong><span style="color: red;font-size: 12px;">*</span></td>-->
                                                    <!--<td style="border: 1px solid black;"><input  class="input-field" name="guns" id="guns" required="required"/> </td>--> 
                                                    <td style="border: 1px solid black;"><strong>Total No of Chargers:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input type="text"  class="input-field" name="NoOfCharger" id="NoOfCharger" oninput="this.value = this.value.replace(/[^0-9]/g, '')" required="required"/> </td>
                                                <td style="border: 1px solid black;"><strong>Project Timeline Category:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                     <select class="select-input" name="projectTimelineCategory" id="projectTimelineCategory" required>
                                                            <option value="">-- Select--</option>
                                                            <option value="LT">LT</option>
                                                            <option value="HT">HT</option>
                                                            <option value="EQUATOR">EQUATOR</option>
                                                        </select>
                                                    
                                                    </td>
                                                
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;">
                                                        <strong>Time Line Of Project Completion: <br>From Date: <span style="color: red;font-size: 12px;">*</span></strong>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input 
                                                                name="Fromdate" type="text" style="width: 42vh;"placeholder="DD-MM-YYYY"class="input-field form_datetime" id="newDatepicker" required maxlength="30" required="required" autocomplete="off"/>

                                                        </div>
                                                    </td>


                                                <td style="border: 1px solid black;"><strong>To Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td style="border: 1px solid black;">
                                                    <div class="input-group date">
                                                        <input name="Todate" type="text"  placeholder="DD-MM-YYYY" class="input-field form_datetime" id="datetimepickers2" required maxlength="30" required="required" autocomplete="off"/>
                                                    </div>
                                                </td>
                                                </tr>

<!--<script type="text/javascript">
$(document).ready(function () {

    let isAutoSet = false;
    let savedFromDate = '';
    let savedToDate = '';
    let isCategorySelected = false;
    let alertVisible = false;

    // ✅ COMMON ALERT FUNCTION
    function showAlert(message) {
        if (alertVisible) return;

        alertVisible = true;

        Swal.fire({
            icon: 'warning',
            title: 'Warning',
            text: message
        }).then(() => {
            alertVisible = false;
        });
    }

    // ✅ DATE FORMAT FUNCTION
    function formatDate(date) {
        return String(date.getDate()).padStart(2, '0') + "-" +
               String(date.getMonth() + 1).padStart(2, '0') + "-" +
               date.getFullYear();
    }

    // ✅ PREVENT CLICK BEFORE DROPDOWN (MAIN FIX 🚀)
    $("#newDatepicker, #datetimepickers2").on("click", function (e) {

        if (!isCategorySelected) {

            e.preventDefault(); // stop flatpickr

            showAlert('Please select Project Timeline Category first');

            return false;
        }
    });

    // ✅ FROM DATE PICKER
    let fromPicker = flatpickr("#newDatepicker", {
        dateFormat: "d-m-Y",
        minDate: "today",
        allowInput: false,

        onOpen: function (selectedDates, dateStr, instance) {
            if (!isCategorySelected) {
                instance.close();
                return false;
            }
        },

        onChange: function (selectedDates, dateStr, instance) {

            if (!isCategorySelected) {
                showAlert('Please select Project Timeline Category first');
                instance.clear();
                return false;
            }

            if (isAutoSet && dateStr !== savedFromDate) {
                showAlert('You cannot change auto-set dates');
                instance.setDate(savedFromDate, true);
            }
        }
    });

    // ✅ TO DATE PICKER
    let toPicker = flatpickr("#datetimepickers2", {
        dateFormat: "d-m-Y",
        minDate: "today",
        allowInput: false,

        onOpen: function (selectedDates, dateStr, instance) {
            if (!isCategorySelected) {
                instance.close();
                return false;
            }
        },

        onChange: function (selectedDates, dateStr, instance) {

            if (!isCategorySelected) {
                showAlert('Please select Project Timeline Category first');
                instance.clear();
                return false;
            }

            if (isAutoSet && dateStr !== savedToDate) {
                showAlert('You cannot change auto-set dates');
                instance.setDate(savedToDate, true);
            }
        }
    });

    // ✅ DROPDOWN LOGIC
    $('#projectTimelineCategory').on('change', function () {

        let selected = $(this).val();
        isCategorySelected = !!selected;

        let daysToAdd = 0;

        if (selected === 'LT') daysToAdd = 90;
        else if (selected === 'HT') daysToAdd = 120;
        else if (selected === 'EQUATOR') daysToAdd = 180;

        if (daysToAdd > 0) {

            let today = new Date();

            savedFromDate = formatDate(today);
            fromPicker.setDate(savedFromDate, true);

            let toDateObj = new Date();
            toDateObj.setDate(today.getDate() + daysToAdd);

            savedToDate = formatDate(toDateObj);
            toPicker.setDate(savedToDate, true);

            $('#chargingrate').val(daysToAdd);

            isAutoSet = true;
        }
    });

});
</script>                         -->

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
if (!selected) {
    $('#newDatepicker').val('');
    $('#datetimepickers2').val('');
    $('#chargingrate').val('');
    return;
}
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
                                                    <td style="border: 1px solid black;"><strong> Estimated budget:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;" ><input  class="input-field" name="budgetallocated" id="budgetallocated" required="required" required="required"/> </td> 
                                                    <td style="border: 1px solid black;"><strong> No.of days:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="chargingrate" id="chargingrate" required="required"/> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Others Details:<span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" class="textarea-field"  name="othersDetails" id="othersDetails" required="required"></textarea>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="select-input" id="ProjectProfile" name="ProjectProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list11" items="${list11}">
                                                                <option value="${list11.projectProfile}">${list11.projectProfile}</option>
                                                            </c:forEach>
                                                        </select>  




                                                    <td style="border: 1px solid black;"><strong>Profit Center:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black; ">
                                                        <select class="select-input" id="profitcenter" name="profitcenter" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list7" items="${list7}">
                                                                <option value="${list7.profitCenter}">${list7.profitCenter}</option>
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
                                                                <option value="${list8.companyCode}">${list8.companyCode}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>

                                                    <td style="border: 1px solid black;"><strong>Plant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" id="Plant" name="Plant" style="font-size: 12px; padding: 5px;" required="required">
                                                            <option value="">--SELECT--</option>
                                                        </select>
                                                </tr>

  <script>
     document.addEventListener("DOMContentLoaded", function () {
         var companyDropdown = document.getElementById("CompanyCode");
         var plantDropdown = document.getElementById("Plant");

         var data = [
  <c:forEach var="list8" items="${list8}" varStatus="status">
                 {
                     companyCode: "${list8.companyCode}",
                     plantName: "${list8.plantName}"
                 }<c:if test="${!status.last}">,</c:if>
  </c:forEach>
         ];

         companyDropdown.addEventListener("change", function () {
             var selectedCompany = this.value;
             plantDropdown.innerHTML = '<option value="">--SELECT--</option>'; // Reset options

             if (selectedCompany) {
                 data.forEach(function (item) {
                     if (item.companyCode === selectedCompany) {
                         var option = document.createElement("option");
                         option.value = item.plantName;
                         option.textContent = item.plantName;
                         plantDropdown.appendChild(option);
                     }
                      $('.select-input').selectpicker("refresh")
                 });
             }
         });
     });
 </script>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" id="ProjectType" name="ProjectType" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list4" items="${list4}">
                                                                <option value="${list4.projectType}">${list4.projectType}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>    
                                                    <td style="border: 1px solid black;"><strong>Project Currency:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="select-input" id="ProjectCurrency" name="ProjectCurrency" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list3" items="${list3}">
                                                                <option value="${list3.currencyCode}">${list3.currencyCode}</option>
                                                            </c:forEach>
                                                        </select>  




                                                </tr> 
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Investment Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="select-input" id="InvestmentProfile" name="InvestmentProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list6" items="${list6}">
                                                                <option value="${list6.investmentProfile}">${list6.investmentProfile}</option>
                                                            </c:forEach>
                                                        </select>  
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Capital:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select  class="select-input" onchange="fetchDocumentList1();" name="Discom" id="Discom" required="required" > 
                                                            <option value="">--SELECT--</option>
                                                        </select> </td> 
                                                </tr>





<!--                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="ChargePoints" id="ChargePoints" oninput="this.value = this.value.replace(/[^0-9]/g, '')" required="required"/> </td>    
                                                     

                                                </tr>-->
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Overall Station Capacity (kW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="overallstations" id="overallstations" required="required" /> </td>    
                                                    <td style="border: 1px solid black;"><strong>Station AC Capacity (kW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="stationAc" id="stationAc" required="required" /> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station DC Capacity (kW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <input  class="input-field" name="stationDc" id="stationDc" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Total MegaWatt(MW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="totalMW" id="totalMW" readonly onkeydown="return false;"/> </td> 
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
                                                                <option value="${list2.stationType}">${list2.stationType}</option>
                                                            </c:forEach>
                                                        </select>  


                                                    <td style="border: 1px solid black;"><strong>Tenant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><select class="select-input" id="tenant" name="tenant" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list0" items="${list0}">
                                                                <option value="${list0.tenant}">${list0.tenant}</option>
                                                            </c:forEach>
                                                        </select>  


                                                </tr>
                                                
                                                
                                               <tr>
                                                        
                                                    <td style="border: 1px solid black;"><strong>Total kw Rating:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="totalKwRating" id="totalKwRating" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td> 
                                                   <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                       <div class="form-group date" id="datetimepickers6"> 
                                                        <input  class="input-field" style="background: white;" placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" name="specificDateFromClient" id="specificDateFromClient" />
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
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="totalChargerCapacity" id="totalChargerCapacity" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td>    
                                                    <td style="border: 1px solid black;"><strong>Charger Station Access Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="chargerStationAccessType" id="chargerStationAccessType" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="public">Public</option>
                                                            <option value="private">Private</option>
                                                            <option value="hybrid">Hybrid</option>
                                                        </select>

                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="auxiliaryLoadOfStation" id="auxiliaryLoadOfStation" /> </td>    
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="chargingRetePerUnit" id="chargingRetePerUnit" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td> 

                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Evs To Be Charged / No. of Parking:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="noOfEvsToBeChanged" id="noOfEvsToBeChanged" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td>    
<!--                                                    <td style="border: 1px solid black;"><strong>Addition Of New Charger Capacity:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="additionOfNewChargerCapacity" id="additionOfNewChargerCapacity" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="360kW">360 KW</option>
                                                            <option value="720kW">720 KW</option>
                                                        </select>
                                                    </td> -->
                                                     <td style="border: 1px solid black;"><strong>Anchore Customer:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                  
                                                  <td  style="border: 1px solid black;">
                                                       <select class="select-input" id="anchoreCustomer" name="anchoreCustomer" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list15" items="${list15}">
                                                                <option value="${list15.name}">${list15.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                </tr> 
                                                
                                                <tr>
                                               <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="scopeofChargeZone" id="scopeofChargeZone" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="1">YES</option>
                                                            <option value="0">NO</option>
                                                        </select>
                                                    </td>   
                                                     <td style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="stationname" id="stationname" required="required"/> </td>                                               
                                                  
                                                </tr>
                                                <tr id="canopyRow" style="display:none;">
                                                    <td style="border: 1px solid black;">
                                                        <strong>Canopy Varient</strong>
                                                        <span style="color: red;font-size: 12px;">*</span>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" id="canopyVarient" name="canopyVarient">
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list16" items="${list16}">
                                                                <option value="${list16.name}">${list16.name}</option>
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
                                                
                                                
                                                
                                               <tr >
                                                  <td style="border: 1px solid black;"><strong>Connection Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  style="border: 1px solid black;">
                                                        <select class="select-input" id="connectiontype" name="connectiontype" onchange="fetchDocumentList1(this);" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list13" items="${list13}">
                                                                <option value="${list13.id}">${list13.connectionType}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Site Survey:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input     class="input-field" name="sitesurvey" id="sitesurvey"   required="required"/> </td> 
      
                                                    
                                                  
                                                </tr>   
                                                <tr>
                                                    
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Survey</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3"style="border: 1px solid black;">
                                                        <input  type="radio"  name="Survey" onclick="return toggleDisplay();" id="Survey" value="siteSurveycreated" required="true" /> <b>Site Survey Created</b> &nbsp;&nbsp;
                                                        <input  type="radio"  name="Survey" id="Survey" onclick="return toggleDisplay();" value="siteSurveynotcreated" /> <b>Site Survey Not Created</b>
                                                    </td> 
                                                  
                                                </tr>

      
                                            </table>
                                                  <script>
                        function toggleDisplay() {
                            var surveys = document.getElementsByName("Survey");
                            var toggleId = document.getElementById("toggleId");
                            var surveyNo = document.getElementsByName("surveyNo");
                                    var projectRepresentative = document.getElementsByName("projectRepresentative");


                            if (surveys[0].checked) {
                                toggleId.style.display = "block";
                                for (var i = 0; i < surveyNo.length; i++) {
                                    surveyNo[i].setAttribute("required", "true");
                                    projectRepresentative[i].setAttribute("required", "true");
                                }
                                if ($("#toggleId").length) {

                                if ($.fn.DataTable.isDataTable("#toggleId")) {
                                    $("#toggleId").DataTable().destroy();
//                                    $("#toggleId").empty(); // optional but recommended
                                }

                                const table1 = initDocTable("#toggleId");
                            }

                            } else {
                                toggleId.style.display = "none";
                                for (var i = 0; i < surveyNo.length; i++) {
                                    surveyNo[i].removeAttribute("required");
                                    surveyNo[i].value = "";
                                     projectRepresentative[i].removeAttribute("required");
                                    projectRepresentative[i].value = "";
                                }
                            }
                        }
                    </script>

                                                       <script>
function surveyValidate() {
    alert()
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
<script>
    var rowCounter = 1; // Initial row count

    $(function () {
        // Event handler for "+" button to add new rows
        $("#Cloneids").on("click", function () {
            rowCounter++; // Increment the row counter
            var newRow = "<tr id='addRow" + rowCounter + "' style='clear:both;'>"
                + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Survey No\" name=\"surveyNo\" maxlength=\"10\" minlength=\"10\" id=\"surveyNo" + rowCounter + "\"></td>"
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
                        
                        <div class="col-md-12 p-0">
                          
                                <table id="toggleId"  class="table table-striped bg-white dt-scroll"   style="width:100%;"  align="center">
                                    <thead>
                                                    <tr style="text-align: center;">

                                                        <th style="width: 50%;">Survey No</th>
                                                        <th style="width: 100%;">Project Representative </th>
                                                        <th style="width: 100%;">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="Table">
                                                    <tr>
                                                <input type="hidden" name="policy" id="policy" value="1"/>

                                                <td style="width: 50%;">
                                                    <input id="siteradio" name="surveyNo" placeholder="Survey No" class="input-field" maxlength="10" minlength="10" type="text">
                                                </td>
                                                <td style="width: 50%;">
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
                                          

                                        </div>
                                        <hr>
                                        <section class="content" style="min-height: 133px;">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <table id="table_5" class="table table-striped bg-white" align="Center"  >
                                                        <thead>
                                                            <tr>
                                                                <th data-dt-order="disable">Sr.No</th>
                                                                <th>Document Name</th>
                                                                <th data-dt-order="disable">Description</th>
                                                                <th data-dt-order="disable">Attachment</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                           
                                                        </tbody>
                                                    </table>
                                                    <!-- Custom Tabs -->
                                                    
                                                </div><!-- nav-tabs-custom -->
                                            </div><!-- /.col -->

                                    
<!--                                    <style>
                        #policyTable td {
    padding: 10px 15px;
}
                    </style> -->
                                    
                              <hr> 
                              <h6>Additional Attachment:</h6>
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
<div class="rounded-4 mt-4">
                            <div class="row mb-3">
                            <div class="col-lg-6 col-md-9">
                                <div class="form-group">
                                    <label  class="label" for="approvalName">Approval Name: <span style="color: red; font-size: 12px;">*</span></label>

                                        <select class="select-input" id="approvalName" name="approvalName" 
                                                         required="required">
                                                    <!--<option value="">--SELECT--</option>-->
                                                    <c:forEach var="list10" items="${list10}">
                                                        <option value="${list10.id}">${list10.approvalName}</option>
                                                    </c:forEach>
                                                </select>
                                </div>   
                                    </div>

                                     </div>
                                        </div>

                                    <br>
                                    <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <button type="submit" id="submitButton" class="btn theme-btn mr-3"  title="" value="">SUBMIT</button>
                                            <button type="submit" class="btn theme-btn" id="oapSavDraft1"  formaction="oapForm.htm?act=oapSaveAsDraft" title="" value="Save As Draft">Save As Draft</button>

                                        </div>
                                    </div>
                <script>
                document.getElementById("oapSavDraft").addEventListener('click', function () {
        var requiredFields = document.querySelectorAll('input[required], textarea[required], file[required], select[required]');
        
                requiredFields.forEach(function (field) {
                field.removeAttribute('required');
                });
        });</script>
                <script>
                document.getElementById("oapSavDraft1").addEventListener('click', function () {
        var requiredFields = document.querySelectorAll('input[required], textarea[required], file[required], select[required]');
        
                requiredFields.forEach(function (field) {
                field.removeAttribute('required');
                });
        });</script>
                
                
                
              </form:form>
        </section>
    </main>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    <script>
        if ($("#table_5").length) {
            const table1 = initTable("#table_5");
        }
                                                function populateStates(countryElementId, stateElementId) {
                                                const countrySelect = document.getElementById(countryElementId);
                                                        const stateSelect = document.getElementById(stateElementId);
                                                        const selectedCountryIndex = countrySelect.selectedIndex;
                                                        // Reset states dropdown
                                                        stateSelect.innerHTML = '<option value="">Select State</option>';
                                                        // Populate states based on selected country
                                                        if (selectedCountryIndex > 0 && s_a[selectedCountryIndex]) {
                                                const states = s_a[selectedCountryIndex].split("|");
                                                        states.forEach(state => {
                                                        const option = new Option(state, state);
                                                                stateSelect.appendChild(option);
                                                        });
                                                }
                                                }

                                        function populateCountries(countryElementId, stateElementId) {
                                        const countrySelect = document.getElementById(countryElementId);
                                                // Reset countries dropdown
                                                countrySelect.innerHTML = '<option value="">Select Country</option>';
                                                // Populate countries and set India as default
                                                country_arr.forEach((country, index) => {
                                                const option = new Option(country, country);
                                                        countrySelect.appendChild(option);
                                                });
                                                countrySelect.value = "India";
                                                // Populate states for India by default
                                                if (stateElementId) {
                                        populateStates(countryElementId, stateElementId);
                                                countrySelect.onchange = () => populateStates(countryElementId, stateElementId);
                                        }
                                        }

// Initialize the dropdowns when the page loads
                                        document.addEventListener('DOMContentLoaded', function() {
                                        populateCountries('countryDropdown', 'stateDropdown');
                                        });
                                                $('#submitButton').on('click', function() {
                                        var allValid = true;
                                                var rows = document.querySelectorAll("#table_5 tbody");
                                                rows.forEach(function(row, index) {
                                                var uploadSection = row.querySelector("td[id^='uploadSection']");
                                                        var attachmentInput = uploadSection.querySelector("input[type='file']");
                                                        var errorSpan = document.createElement('span');
                                                        errorSpan.style.color = 'red';
                                                        errorSpan.id = 'error' + index;
                                                        if (attachmentInput.hasAttribute('required') && !attachmentInput.value) {
                                                allValid = false;
                                                        errorSpan.textContent = "Please upload a file for this document.";
                                                        uploadSection.appendChild(errorSpan);
                                                } else {
                                                // Remove error message if exists
                                                var existingError = document.getElementById('error' + index);
                                                        if (existingError) {
                                                uploadSection.removeChild(existingError);
                                                }
                                                }
                                                });
                                                if (allValid) {
                                        // Submit the form or perform the required action
//                                        alert('Form submitted successfully.');
                                        }
                                        });</script>
<script src="StorageYard/JS/countries.js" type="text/javascript"></script>
<script src="StorageYard/JS/states.js" type="text/javascript"></script>
<script src="StorageYard/JS/cities.js" type="text/javascript"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<!--PCS Deliverable Details: script data-->
<script>
   function toggleAttachment(checkbox, attachmentId) {
       const attachmentDiv = document.getElementById(attachmentId);
       if (checkbox.checked) {
           attachmentDiv.style.display = 'block'; // Show the attachment input
           const fileInput = attachmentDiv.querySelector("input[type='file']");
           if (fileInput) fileInput.setAttribute("required", "required"); // Add required attribute
       } else {
           attachmentDiv.style.display = 'none'; // Hide the attachment input
           const fileInput = attachmentDiv.querySelector("input[type='file']");
           const notificationId = attachmentId.replace('attachment', 'notification');
           const notificationDiv = document.getElementById(notificationId);
           // Clear file input and notification when unchecked
           if (fileInput) {
               fileInput.value = "";
               fileInput.removeAttribute("required"); // Remove required attribute
           }
           if (notificationDiv) notificationDiv.style.display = 'none';
       }
   }

   function validateFormOnSubmit() {
       const checkboxes = document.querySelectorAll("input[type='checkbox']");
       let isValid = true;
       checkboxes.forEach(checkbox => {
           if (checkbox.checked) {
               const attachmentId = checkbox.getAttribute('onclick').match(/'([^']+)'/)[1];
               const fileInput = document.getElementById(attachmentId).querySelector("input[type='file']");
               const notificationDiv = document.getElementById(attachmentId.replace('attachment', 'notification'));
               if (!fileInput.value) {
                   notificationDiv.textContent = "Attachment is required for the selected option.";
                   notificationDiv.style.display = 'block';
                   isValid = false;
               } else {
                   notificationDiv.style.display = 'none';
               }
           }
       });
       return isValid;
   }

   document.querySelector("form").onsubmit = function (e) {
       if (!validateFormOnSubmit()) {
           e.preventDefault(); // Prevent form submission if validation fails
       }
   };

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
<!--Save As Draft Script-->

<script>
  // List only the fields you want to toggle required
  var fieldsToToggle = [
  document.getElementById('pcsName'),
  document.getElementById('datetimepicker1'),
  document.getElementById('projectName'),
  document.getElementById('countryDropdown'),
  document.getElementById('stateDropdown'),
  document.getElementById('city'),
  document.getElementById('pcsAddress'),
  document.getElementById('district'),
  document.getElementById('houseno'),
  document.getElementById('pcscoordinates'),
  document.getElementById('mobileNo'),
  document.getElementById('email'),
  document.getElementById('alternatemobileNo'),
  document.getElementById('clientDetails'),
  document.getElementById('clientscope'),
  document.getElementById('clientRequiremts'),
  document.getElementById('salesName'),
  document.getElementById('department'),
  document.getElementById('designation'),
  document.getElementById('datetimepickers'),
  document.getElementById('guns'),
  document.getElementById('newDatepicker'),
  document.getElementById('datetimepickers2'),
  document.getElementById('budgetallocated'),
  document.getElementById('chargingrate'),
  document.getElementById('othersDetails'),
  document.getElementById('ProjectProfile'),
  document.getElementById('profitcenter'),
  document.getElementById('CompanyCode'),
  document.getElementById('Plant'),
  document.getElementById('ProjectType'),
  document.getElementById('ProjectCurrency'),
  document.getElementById('InvestmentProfile'),
  document.getElementById('Discom'),
  document.getElementById('ChargePoints'),
  document.getElementById('NoOfCharger'),
  document.getElementById('overallstations'),
  document.getElementById('stationAc'),
  document.getElementById('stationDc'),
  document.getElementById('stationname'),
  document.getElementById('stationtype'),
  document.getElementById('tenant'),
  document.getElementById('connectiontype'),
  document.getElementById('sitesurvey'),
  document.getElementById('Survey'),
  document.getElementById('approvalName'),
  document.getElementById('projectTimelineCategory'),
  document.getElementById('totalKwRating'),
  document.getElementById('specificDateFromClient'),
  document.getElementById('totalChargerCapacity'),
  document.getElementById('chargerStationAccessType'),
  document.getElementById('chargingRetePerUnit'),
  document.getElementById('noOfEvsToBeChanged'),
  document.getElementById('additionOfNewChargerCapacity'),
  document.getElementById('attchment')
];

// On Submit: make fields required
  document.getElementById('submitButton').addEventListener('click', function () {
   
    for (var i = 0; i < fieldsToToggle.length; i++) {
      if (fieldsToToggle[i]) {
        fieldsToToggle[i].setAttribute('required', 'required');
      }
    }
    // No need to touch dynamic attachments here – they're already set by AJAX
  });

  // On Save As Draft: remove required from listed and dynamic fields
  document.querySelector('input[value="Save As Draft"]').addEventListener('click', function () {
    for (var i = 0; i < fieldsToToggle.length; i++) {
      if (fieldsToToggle[i]) {
        fieldsToToggle[i].removeAttribute('required');
      }
    }

    // Also remove required from dynamically generated attachment fields
    var attachmentInputs = document.querySelectorAll('input[type="file"][name="attchment"]');
    for (var i = 0; i < attachmentInputs.length; i++) {
      attachmentInputs[i].removeAttribute('required');
    }
  });

</script>








<body onload="toggleDisplay();">     
         
</body>
</html>
