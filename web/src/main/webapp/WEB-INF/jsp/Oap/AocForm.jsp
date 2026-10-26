<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/countryjs.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Form</title>
    </head>
    <style>
        @keyframes blink {
            50% {
                border-color: red;
            }
        }
        .nav-tabs-custom {
            border-top: 0px solid #00a65a;

        }
        textarea{
            width: 100%;

        }
        /*    .blinking {
                animation: blink 1s linear infinite;
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
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="aocForm.htm?act=aocFormSubmit " method="post" enctype="multipart/form-data" commandName="vendorInformation1"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">        
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">AOC Form</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" id="submitButton" class="btn theme-btn mr-3" title="" value="">SUBMIT</button>
                            <button type="submit" class="btn theme-btn" id="aocSavDraft"  formaction="aocForm.htm?act=AocSaveAsDraft" title="" value="Save As Draft">Save As Draft</button>
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
                             Acquired Order Checklist
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
                    <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                        <thead>
                            <tr>
                                <td colspan="6" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>Hub / Depo Order details </strong></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                <td colspan="1" style="border: 1px solid black;"><input  class="input-field" name="documentNo" id="documentNo" readonly/> </td>                                                   
                                <td colspan="1" style="border: 1px solid black;"><strong>Hub / Depo Name</strong><span style="color: red;font-size: 12px;">*</span></td>
                                <td colspan="2"  style="border: 1px solid black;"><input  class="input-field" name="depoName" id="depoName" required="true"/> </td>    
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>B2B </strong><span style="color: red;font-size: 12px;">*</span></td>
                                <td style="border: 1px solid black;"><input  class="input-field" name="b2b" id="b2b"  required="true"/> </td>                                                   
                                <td style="border: 1px solid black;"><strong>B2B2C</strong><span style="color: red;font-size: 12px;">*</span></td>
                                <td  colspan="3"style="border: 1px solid black;"><input  class="input-field" name="b2b2c" id="b2b2c"  required="true"/> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>B2C</strong><span style="color: red;font-size: 12px;">*</span></td>
                                <td colspan="1" style="border: 1px solid black;">
                                    <input type="text" class="input-field" name="b2c" id="b2c"  required="true" />
                                </td>
                                <td style="border: 1px solid black;"><strong>Client / Project Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                <!--<td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="projectName" id="projectName"  required="true"/> </td>-->    
                                <td colspan="2" style="border: 1px solid black;"><select class="select-input" id="projectName" name="projectName"  required="required"   >
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list14" items="${list14}">
                                            <option value="${list14.projectName}">${list14.projectName}</option>
                                        </c:forEach>
                                    </select>  
                                </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Country:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                <td style="border: 1px solid black;">
                                    <select class="select-input" name="country" id="countryDropdown" required="required"></select>
                                </td>

                                <td style="border: 1px solid black;"><strong>State:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                <td colspan="3" style="border: 1px solid black;">
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
                                                    } else {
                                                    data1 += "<option value='" + object[i].id + "'>" + object[i].discomname + "</option>";
                                                            document.getElementById('Discom').innerHTML = data1;
                                                    }
                                                    }





                                                    //here new line added main
                                                    $('.select-input').selectpicker("refresh");
                                                            // Inject the generated table rows into the table body
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
                                                    , success: function(content) {

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
                                                            + "<td>" + object[i].documentName + requiredMark + "</td>" // Add star here
                                                            + "<input type=\"hidden\" name=\"id\" value='" + object[i].id + "' id=\"id" + j + "\">"
                                                            + "<input type=\"hidden\" name=\"compulsary\" id=\"compulsary" + j + "\" value='" + object[i].compalsuary + "'>"
                                                            + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptiones\" id=\"descriptiones" + j + "\"></td>"
                                                            + "<td id=\"uploadSection" + j + "\"><input type=\"file\" class=\"input-field\" placeholder=\"action\" name=\"attchment\" id=\"attchment" + j + "\"";
                                                            if (object[i].compalsuary === "yes") {
                                                    data1 += " required";
                                                    }
                                                    data1 += "></td></tr>";
                                                    } else {
                                                    data1 += "<tr style='clear:both;'>"
                                                            + "<td>" + j + "</td>"
                                                            + "<td>" + object[i].documentName + requiredMark + "</td>" // Add star here
                                                            + "<input type=\"hidden\" name=\"id\" value='" + object[i].id + "' id=\"id" + j + "\">"
                                                            + "<input type=\"hidden\" name=\"compulsary\" id=\"compulsary" + j + "\" value='" + object[i].compalsuary + "'>"
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
                        <tr>
                            <td style="border: 1px solid black;"><strong>City:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;"><input  class="input-field" name="city" id="city" required="required"/> </td>    
                            <td style="border: 1px solid black;"><strong>Street:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="depoAddress" id="depoAddress"  required="true"/> </td>    
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>District:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;"><input  class="input-field" name="district" id="district" required="required"/> </td>    
                            <td style="border: 1px solid black;"><strong>House No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="houseno" id="houseno" required="required"/> </td>    
                        </tr>
                        <tr>
                            <td colspan="1" style="border: 1px solid black;"><strong>Google Co-ordinates: </strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="1" style="border: 1px solid black;"><input  class="input-field" name="googleCoordinates" id="googleCoordinates"  required="true"/> </td>                                                   

                        </tr>
                        <tr>
                            <td colspan="1" style="border: 1px solid black;"><strong>Pcs Type:</strong></td>
                            <td colspan="1" style="border: 1px solid black;">
                                <label style="display: inline;">
                                    <input type="checkbox" name="car" id="car"> A. Car
                                </label>
                                <label style="display: inline;">
                                    <input type="checkbox" name="bus" id="bus"> B. Bus
                                </label>
                                <br>
                                <label style="display: inline;">
                                    <input type="checkbox" name="truck" id="truck"> C. Truck / LMV
                                </label>
                            </td>
                            <td colspan="1" style="border: 1px solid black;"><strong>Others:</strong></td>
                            <td colspan="2" style="border: 1px solid black;">
                                <input class="input-field" name="others" id="others" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1"  style="border: 1px solid black;"><strong>Financial Model :  </strong></td>
                            <td colspan="1" style="border: 1px solid black;"> 
                                <label style="display: inline;">
                                    <input type="checkbox" name="capex" id="capex"> A. Capex
                                </label> 
                                <label style="display: inline;">
                                    <input type="checkbox" name="opex" id="opex"> B. Opex
                                </label>
                            <td colspan="1" style="border: 1px solid black;"><strong>Co-ordinates: </strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="coordinates" id="coordinates"  required="true"/> </td>                                                   
                            </td>                                                 
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Details of Contact Person:  </strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="1" style="border: 1px solid black;"><input  class="input-field" name="firstName" id="firstName" required="true"/> </td>                                                   
                            <!--                                                    <td colspan="2" style="border: 1px solid black;"><input placeholder="Middlename" class="input-field" name="middleName" id="middleName"/> </td>-->
                            <!--<td colspan="2"style="border: 1px solid black;"><input placeholder="LastName"  class="input-field" name="lastName" id="lastName"/> </td>-->    
                            <td style="border: 1px solid black;"><strong>Client E-mail:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="email" type="email" id="email"  required="true"/> </td>    
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Client Name:  </strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="1" style="border: 1px solid black;"><input  class="input-field" name="mobileNo" id="mobileNo"  required="true"/> </td>                                                   
                            <td style="border: 1px solid black;"><strong>Mobile No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="altNo" id="altNo"  required="true"/> </td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Charge Zone Scope Of work:<span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="6" style="border: 1px solid black;">
                                <textarea style="width: 100%; height: 100px; border: none; resize: none;" class="textarea-field" name="scopework" id="scopework"  required="true"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Client Scope: <span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="6" style="border: 1px solid black;">
                                <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="scope" id="scope" class="textarea-field" required="true"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Specific requirements of the Client:<span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="6" style="border: 1px solid black;">
                                <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="reqClients" class="textarea-field" id="reqClients"  required="true"></textarea>
                            </td>
                        </tr>
                        
                        <thead>
                            <tr>
                                <td colspan="6" style="border: 1px solid black; background-color: skyblue;text-align: center"><strong>Hub Deliverable Details </strong></td>
                            </tr>
                        <thead>
                            <tr>
                                <th colspan="1" style="border: 1px solid black; ">Document Name</th>
                                <th colspan="1" style="border: 1px solid black; ">Document Ref No / Document Path</th>
                                <th colspan="1" style="border: 1px solid black;">Date:</th>
                                <th colspan="2" style="border: 1px solid black; ">Attachment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- (i) Assumption Sheet -->
                            <tr>
                                <th colspan="1" style="border: 1px solid black; ">
                                    (i) Assumption Sheet
                                    <input type="checkbox"  name="assumption" id="assumption" onclick="toggleInputs(this, 'assumptionRefNo', 'Fromdate1', 'file1')">
                                </th>
                                <td colspan="1" style="border: 1px solid black;">
                                    <input type="text" class="input-field" id="assumptionRefNo" name="assumptionRefNo" disabled />
                                </td>
                                <td colspan="1" style="border: 1px solid black;">
                                    <div class="input-group date" >
                                        <input  placeholder="DD/MM/YYYY" name="Fromdate1" id="Fromdate1" type="text" class="input-field form_datetime" maxlength="30" disabled autocomplete="off" />
                                    </div>
                                </td>
                                <td colspan="2" style="border: 1px solid black;">
                                    <input type="file" class="input-field" id="file1" name="file1" disabled />
                                </td>
                            </tr>
                        <script>
$(function () {

                                    flatpickr("#Fromdate1", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>

                        <!-- (ii) Estimated BOQ -->
                        <tr>
                            <th colspan="1" style="border: 1px solid black;">
                                (ii) Estimated BOQ: 
                                <input type="checkbox"  name="boq" id="boq" onclick="toggleInputs(this, 'boqRefNo', 'Fromdate2', 'file2')">
                            </th>
                            <td colspan="1" style="border: 1px solid black;">
                                <input type="text" class="input-field" id="boqRefNo" name="boqRefNo" disabled />
                            </td>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers1" >
                                    <input placeholder="DD/MM/YYYY" name="Fromdate2" id="Fromdate2" type="text" class="input-field form_datetime" value="" maxlength="30" disabled autocomplete="off" />
                                </div>
                            </td>   
                            <td colspan="2" style="border: 1px solid black;">
                                <input type="file" class="input-field" id="file2" name="file2" disabled />
                            </td>
                        </tr>
                        <script>
$(function () {

                                    flatpickr("#Fromdate2", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>

                        <!-- (iii) LOA / LOI -->
                        <tr>
                            <th colspan="1" style="border: 1px solid black;">
                                (iii) LOA / LOI: 
                                <input type="checkbox" name="lao" id="lao" onclick="toggleInputs(this, 'laoRefNo', 'Fromdate3', 'file3')">
                            </th>
                            <td colspan="1" style="border: 1px solid black;">
                                <input type="text" class="input-field" id="laoRefNo" name="laoRefNo" disabled />
                            </td>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers2">
                                    <input placeholder="DD/MM/YYYY" name="Fromdate3" id="Fromdate3" type="text" class="input-field form_datetime" value="" maxlength="30" disabled autocomplete="off" />
                                </div>
                            </td>    
                            <td colspan="2" style="border: 1px solid black;">
                                <input type="file" class="input-field" id="file3" name="file3" disabled />
                            </td>
                        </tr>
                        <script>
$(function () {

                                    flatpickr("#Fromdate3", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>

                        <!-- (iv) Agreement -->
                        <tr>
                            <th colspan="1" style="border: 1px solid black;">
                                (iv) Agreement: 
                                <input type="checkbox" name="agremment" id="agremment" onclick="toggleInputs(this, 'agremmentRefNo', 'Fromdate4', 'file4')">
                            </th>
                            <td colspan="1" style="border: 1px solid black;">
                                <input type="text" class="input-field" id="agremmentRefNo" name="agremmentRefNo" disabled />
                            </td>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers3">
                                    <input placeholder="DD/MM/YYYY" name="Fromdate4" id="Fromdate4" type="text" class="input-field form_datetime" value="" maxlength="30" disabled autocomplete="off" />
                                </div>
                            </td>    
                            <td colspan="2" style="border: 1px solid black;">
                                <input type="file" class="input-field" id="file4" name="file4" disabled />
                            </td>
                        </tr>
                        <script>
$(function () {

                                    flatpickr("#Fromdate4", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>

                        <!-- (v) Layout Drawings -->
                        <tr>
                            <th colspan="1" style="border: 1px solid black;">
                                (v) Layout Drawings: 
                                <input type="checkbox"  name="drawings" id="drawings" onclick="toggleInputs(this, 'drawingsRefNo', 'Fromdate5', 'file5')">
                            </th>
                            <td colspan="1" style="border: 1px solid black;">
                                <input type="text" class="input-field" id="drawingsRefNo" name="drawingsRefNo" disabled />
                            </td>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers4">
                                    <input placeholder="DD/MM/YYYY" name="Fromdate5" id="Fromdate5" type="text" class="input-field form_datetime" value="" maxlength="30" disabled autocomplete="off" />
                                </div>
                            </td>    
                            <td colspan="2" style="border: 1px solid black;">
                                <input type="file" class="input-field" id="file5" name="file5" disabled />
                            </td>
                        </tr>
                        <script>
$(function () {

                                    flatpickr("#Fromdate5", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>
                        </tbody>
                        <script>
                                    function toggleInputs(checkbox, textId, dateId, fileId) {
                                    const textField = document.getElementById(textId);
                                            const dateField = document.getElementById(dateId);
                                            const fileField = document.getElementById(fileId);
                                            if (checkbox.checked) {
                                    textField.disabled = false;
                                            dateField.disabled = false;
                                            fileField.disabled = false;
                                            textField.classList.add('blinking');
                                            textField.focus(); // Focus on the text field
                                    } else {
                                    textField.disabled = true;
                                            dateField.disabled = true;
                                            fileField.disabled = true;
                                            textField.classList.remove('blinking');
                                            textField.value = ""; // Clear the text field
                                            dateField.value = ""; // Clear the date field
                                            fileField.value = ""; // Clear the file field
                                    }
                                    }
                        </script>
                        <tr>
                            <td colspan="1" style="border: 1px solid black;"><strong>Manpower Details: (A) Operations<span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="1" style="border: 1px solid black;">
                                <textarea class="textarea-field" style="width: 100%; height: 50px; border: none; resize: none;" name="operations" id="operations" class="textarea-field"  required="true"></textarea>
                            </td>    
                            <td colspan="1" style="border: 1px solid black;"><strong>Sign: <span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="2" style="border: 1px solid black;"><textarea  class="textarea-field" style="width: 100%; height: 50px; border: none; resize: none;"placeholder="Note: Mention the Nos. & competency of person required"  class="textarea-field" name="operationsSign" id="operationsSign"  required="true"></textarea>
                            </td>  
                        </tr>
                        <tr>
                            <td colspan="1" style="border: 1px solid black;"><strong>(B) Maintenance<span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="1" style="border: 1px solid black;">
                                <textarea  class="textarea-field" style="width: 100%; height: 50px; border: none; resize: none;" name="maintenance" id="maintenance"  required="true"></textarea>
                            </td>  

                            <td colspan="1" style="border: 1px solid black;"><strong>Sign:<span style="color: red;font-size: 12px;">*</span> </strong></td>
                            <td colspan="2" style="border: 1px solid black;"><textarea class="textarea-field" style="width: 100%; height: 50px; border: none; resize: none;"placeholder=" Note: Ensure signature of Director(RM Sir) if NO manpower is required on Site" name="maintenancesign" id="maintenancesign"  required="true"></textarea>
                            </td> 
                        </tr>
                        <tr>
                            <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Charger Installation Details</strong></td>
                        </tr>
                        <tr>
                        <td style="border: 1px solid black;"><strong>Project Timeline Category:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                     <select class="select-input" name="projectTimelineCategory" id="projectTimelineCategory" required>
                                                            <option value="">-- Select--</option>
                                                            <option value="LT">LT</option>
                                                            <option value="HT">HT</option>
                                                            <option value="EQUATOR">EQUATOR</option>
                                                        </select>
                                                    
                                                    </td>
                                            <th colspan="1" style="border: 1px solid black;">Budget Allocated for Project<span style="color: red;font-size: 12px;">*</span></th>
                            <td colspan="1" style="border: 1px solid black;">
                                <input type="text" placeholder="INR" class="input-field" id="inr" name="inr"  required="true"/>
                            </td>         
                                                    </tr>
                        <tr>
                            <th colspan="1" style="border: 1px solid black;">Zero Date<span style="color: red;font-size: 12px;">*</span></th>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers6" style="width: 100%;">
                                    <input placeholder="DD/MM/YYYY" name="Fromdate6" id="Fromdate6" type="text" 
                                           class="input-field form_datetime" maxlength="30" autocomplete="off" required="true" 
                                           style="width: 100%;" />
                                </div>
                            </td>
                            <th colspan="1" style="border: 1px solid black;">Completion Date<span style="color: red;font-size: 12px;">*</span></th>
                            <td colspan="3" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers5" style="width: 100%;">
                                    <input placeholder="DD/MM/YYYY" name="Fromdate7" id="Fromdate7"  type="text" class="input-field form_datetime"  maxlength="30" autocomplete="off"  style="width: 100%;"  required="true"/>
                                </div>
                            </td>    
                        <script>
$(function () {

    $(document).ready(function () {

        flatpickr("#Fromdate6, #Fromdate7", {
            dateFormat: "d-m-Y",
            minDate: "today",
            allowInput: true
        });

        // ✅ Dropdown change logic
        $('#projectTimelineCategory').on('change', function () {
            var selected = $(this).val();

if (!selected) {
    $('#Fromdate6').val('');
    $('#Fromdate7').val('');
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

                $('#Fromdate6').val(fromDateFormatted);

                // 👉 Calculate To Date
                var toDateObj = new Date();
                toDateObj.setDate(toDateObj.getDate() + daysToAdd);

                var to_dd = String(toDateObj.getDate()).padStart(2, '0');
                var to_mm = String(toDateObj.getMonth() + 1).padStart(2, '0');
                var to_yyyy = toDateObj.getFullYear();

                var toDateFormatted = to_dd + "-" + to_mm + "-" + to_yyyy;

                $('#Fromdate7').val(toDateFormatted);

                // 👉 Set No. of Days
                $('#chargingrate').val(daysToAdd);
            }
        });

    });
    });
</script>


                        </tr>
                        <tr>
                            
                            <td style="border: 1px solid black;"><strong>No.Of Days:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td   style="border: 1px solid black;"><input  class="input-field" name="chargingrate" id="chargingrate" required="required"/> </td> 

                        </tr>

                        <thead>
                            <tr>
                                <td colspan="6" style="border: 1px solid black; background-color: skyblue; text-align: center" ><strong>(Ordinance) Order Review details</strong></td>
                            </tr>
                        </thead>
                        <tr>
                            <td colspan="1" style="border: 1px solid black;"><strong>Reviewing Authority Comment:<span style="color: red;font-size: 12px;">*</span></strong></td>
                            <td colspan="5" style="border: 1px solid black;">
                                <textarea class="textarea-field" style="width: 100%; height: 100px; border: none; resize: none;" name="comments" id="comments"  required="true"></textarea>
                            </td>                                                  
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Order Effective Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers7"style="width: 100%;">
                                    <input id="Fromdate8" placeholder="DD/MM/YYYY" name="Fromdate8" type="text" class="input-field form_datetime" style="width: 100%;" value="" maxlength="30" autocomplete="off"  required="true"/>
                                </div>
                            </td>
                        <script>
$(function () {

                                    flatpickr("#Fromdate8", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>
                        <td colspan="1" style="border: 1px solid black;"><strong>New Revision No.:</strong></td>
                        <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="revisionNo" id="revisionNo" /> </td>
                        </tr>
                        <tr>
                            <td colspan="1" style="border: 1px solid black;"><strong>Budget allocation Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="1" style="border: 1px solid black;">
                                <div class="input-group date" id="datetimepickers9" style="width: 100%;">
                                    <input id="Fromdate9" placeholder="DD/MM/YYYY" name="Fromdate9" type="text" class="input-field form_datetime" style="width: 100%;" value="" maxlength="30" autocomplete="off"  required="true"/>
                                </div>
                            </td>
                        <script>
$(function () {

                                    flatpickr("#Fromdate9", {
                                    dateFormat: "d-m-Y", // Set your desired format
                                            allowInput: true // Allow manual input if required
                                    });
                                    });
                                                                </script>

                        </tr>      

                        <tr>
                            <td style="border: 1px solid black;"><strong>Reviewed By: </strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="1"  style="border: 1px solid black;"><input  class="input-field" name="reviewed" id="reviewed"  required="true"/> </td>                                                   
                            <td colspan="1"  style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2" style="border: 1px solid black;"><input  class="input-field"name="designation" id="designation"  required="true"/> </td>

                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Project Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td  style="border: 1px solid black;"><select class="select-input" id="ProjectProfile" name="ProjectProfile"  required="required"     >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list11" items="${list11}">
                                        <option value="${list11.projectProfile}">${list11.projectProfile}</option>
                                    </c:forEach>
                                </select>  




                            <td style="border: 1px solid black;"><strong>Profit Center:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2"style="border: 1px solid black; ">
                                <select class="select-input" id="profitcenter" name="profitcenter" required="required"   >
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
                                <select class="select-input" id="CompanyCode" name="CompanyCode" required="required">
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list8" items="${list9}">
                                        <option value="${list8.companyCode}">${list8.companyCode}</option>
                                    </c:forEach>
                                </select>
                            </td>

                            <td style="border: 1px solid black;"><strong>Plant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2" style="border: 1px solid black;">
                                <select class="select-input" id="Plant" name="Plant" required="required">
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
                                    }); </script>                                             </script>


                        <tr>
                            <td style="border: 1px solid black;"><strong>Project Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;">
                                <select class="select-input" id="ProjectType" name="ProjectType"  required="required"   >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list4" items="${list4}">
                                        <option value="${list4.projectType}">${list4.projectType}</option>
                                    </c:forEach>
                                </select>
                            </td>    
                            <td style="border: 1px solid black;"><strong>Project Currency:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2" style="border: 1px solid black;"><select class="select-input" id="ProjectCurrency" name="ProjectCurrency"  required="required"   >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list3" items="${list3}">
                                        <option value="${list3.currencyCode}">${list3.currencyCode}</option>
                                    </c:forEach>
                                </select>  
                        </tr> 
                        <tr>
                            <td style="border: 1px solid black;width: 25%;"><strong>Investment Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;width: 25%;"><select class="select-input" id="InvestmentProfile" name="InvestmentProfile"  required="required"   >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list6" items="${list6}">
                                        <option value="${list6.investmentProfile}">${list6.investmentProfile}</option>
                                    </c:forEach>
                                </select>  

                            <td style="border: 1px solid black;width: 25%;"><strong>Discom:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td  colspan="2" style="border: 1px solid black;width: 25%;">
                                <select  class="select-input" name="Discom" onchange="fetchDocumentList1();" id="Discom" required="required" > 
                                    <option value="">--SELECT--</option>
                                </select> 
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;"><input  class="input-field" name="ChargePoints" id="ChargePoints" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td>    
                            <td style="border: 1px solid black;"><strong>No Of Charger:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="NoOfCharger" id="NoOfCharger" oninput="this.value = this.value.replace(/[^0-9]/g, '')" required="required"/> </td> 
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Overall Station Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;"><input  class="input-field" name="overallstations" id="overallstations" required="required"/> </td>    
                            <td style="border: 1px solid black;"><strong>Station AC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="stationAc" id="stationAc" required="required"/> </td> 
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Station DC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;"><input  class="input-field" name="stationDc" id="stationDc" required="required"/> </td>    

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
                                <select class="select-input" id="stationtype" name="stationtype"  required="required"   >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list2" items="${list2}">
                                        <option value="${list2.stationType}">${list2.stationType}</option>
                                    </c:forEach>
                                </select>  
                            <td style="border: 1px solid black;"><strong>Tenant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2" style="border: 1px solid black;"><select class="select-input" id="tenant" name="tenant"  required="required"   >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list0" items="${list0}">
                                        <option value="${list0.tenant}">${list0.tenant}</option>
                                    </c:forEach>
                                </select>  
                        </tr>
                        
                     <tr>
                                                        
                                                    <td style="border: 1px solid black;"><strong>Total Kw Rating:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="totalKwRating" id="totalKwRating" oninput="this.value = this.value.replace(/[^0-9]/g, '')" required="required"/> </td> 
                                                   <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                       <div class="form-group date" id="datetimepickers6"> 
                                                        <input  class="input-field" style="background: white;" placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" name="specificDateFromClient" id="specificDateFromClient" />
                                                       </div>
                                                    </td>
                                                    <script>
$(function () {

                                                $(function () {
                                                    flatpickr("#specificDateFromClient", {
                                                        dateFormat: "d-m-Y"
                                                    });
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
                                                        </select>
                                                    </td> 

                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="auxiliaryLoadOfStation" id="auxiliaryLoadOfStation"oninput="this.value = this.value.replace(/[^0-9]/g, '')" /> </td>    
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="chargingRetePerUnit" id="chargingRetePerUnit" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td> 

                                                </tr> 
                                               <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Evs To Be Charged / No. of Parking</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;"><input  class="input-field" name="noOfEvsToBeChanged" id="noOfEvsToBeChanged" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td>    
<!--                                                    <td style="border: 1px solid black;"><strong>Addition Of New Charger Capacity:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="additionOfNewChargerCapacity" id="additionOfNewChargerCapacity" required>
                                                            <option value="">-- Select--</option>
                                                            <option value="360kW">360 KW</option>
                                                            <option value="720kW">720 KW</option>
                                                        </select>
                                                    </td> -->

                           <td style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="stationname" id="stationname" required="required"/> </td> 
                                                </tr>    
                        <tr>
                        <td style="border: 1px solid black;"><strong>Anchore Customer:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                  
                                                  <td  style="border: 1px solid black;">
                                                       <select class="select-input" id="anchoreCustomer" name="anchoreCustomer" style=" font-size: 12px; padding: 5px;" required="required"   >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="list15" items="${list15}">
                                                                <option value="${list15.name}">${list15.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                     <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <select class="select-input" name="scopeofChargeZone" id="scopeofChargeZone" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="1">YES</option>
                                                            <option value="0">NO</option>
                                                        </select>
                                                    </td>
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
                        <tr>
                            <td style="border: 1px solid black;"><strong>Connection Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td style="border: 1px solid black;">
                                <select class="select-input" id="connectiontype" name="connectiontype" onchange="fetchDocumentList1(this);" required="required"   >
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="list13" items="${list13}">
                                        <option value="${list13.id}">${list13.connectionType}</option>
                                    </c:forEach>
                                </select>  
                            </td>   
                            <td style="border: 1px solid black;"><strong>Site Survey:</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td  colspan="2"style="border: 1px solid black;"><input  class="input-field" name="sitesurvey" id="sitesurvey" required="required"/> </td> 
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Survey</strong><span style="color: red;font-size: 12px;">*</span></td>
                            <td  colspan="2"style="border: 1px solid black;">
                                <input  type="radio"  name="Survey" onclick="return toggleDisplay();" id="Survey" value="siteSurveycreated" required="true" /> <b>Site Survey Created</b> &nbsp;&nbsp;
                                <input  type="radio"  name="Survey" id="Survey" onclick="return toggleDisplay();" value="siteSurveynotcreated" /> <b>Site Survey Not Created</b>
                            </td> 
                        </tr>
                        <script>
                                    function toggleDisplay() {
                                    var surveys = document.getElementsByName("Survey");
                                            var toggleId = document.getElementById("toggleId");
                                            var surveyNo = document.getElementsByName("surveyNo");
                                            if (surveys[0].checked) {
                                    toggleId.style.display = "block";
                                            for (var i = 0; i < surveyNo.length; i++) {
                                    surveyNo[i].setAttribute("required", "true");
                                    }
                                    if ($("#toggleId").length) {

                                    if ($.fn.DataTable.isDataTable("#toggleId")) {
                                    $("#toggleId").DataTable().destroy();
//        $("#toggleId").empty(); // optional but recommended
                                    }

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
                            alert()
                                    var surveyElements = document.getElementsByName("Survey");
                                    var sizeElements = document.getElementsByName("size");
                                    alert()
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
                    <div class="col-md-12 p-0">

                        <table id="toggleId"  class="table table-striped bg-white dt-scroll"   style="width:100%;"  align="center">                                            <thead>
                                <tr>
                                    <th >Survey No</th>
                                    <th>Project Representative </th>
                                    <th >Action</th>
                                </tr>
                            </thead>
                            <tbody id="Table">
                                <tr>
                            <input type="hidden" name="policy" id="policy" value="1"/>
                            <td style="width: 50%;">
                                <input id="siteradio" name="surveyNo" placeholder="Survey No" maxlength="10" minlength="10" class="input-field" type="text">
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
                        <script>
                                    var rowCounter = 1; // Initial row count

                                    $(function () {
                                    // Event handler for "+" button to add new rows
                                    $("#Cloneids").on("click", function () {
                                    rowCounter++; // Increment the row counter
                                            var newRow = "<tr id='addRow" + rowCounter + "' style='clear:both;'>"
                                            + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Survey No\" name=\"surveyNo\" maxlenght=\"10\" name=\"10\" id=\"surveyNo" + rowCounter + "\"></td>"
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
                        <hr>
                        <div class="row">
                            <div class="col-md-12">
                                <table id="table_5" class="table table-striped bg-white " align="Center"  >
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
                            </div>
                        </div>
                        <hr>            
                        <h6>Additional Attachment:</h6>
                        <div class="col-md-12 p-0">
                            <div class="">
                                <table id="policyTable" class="table table-striped bg-white dt-scroll"  style="width:100%;"  align="center">
                                    <thead>
                                    <th style="text-align: center; vertical-align: middle">Attachment</th>
                                    <th style="text-align: center; vertical-align: middle">Description</th>
                                    <th style="text-align: center; vertical-align: middle">Add New</th>
                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                    </thead>
                                    <tbody>
                                        <tr id="policyRow1">
                                            <td>
                                                <input id="attachment1" name="attach" class="input-field" type="file" onchange="validateFileSize(this)">
                                                <span id="fileError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                            </td>

                                            <td>
                                                <input id="description1" name="descriptions" placeholder="Description" class="input-field" type="text">
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
                                                + "<td><input type =\"file\" class=\"input-field\" placeholder=\"action\" name=\"attach" + "" + "\" id=\"attachment" + tempCount3 + "\"></td>"
                                                + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"
                                                + "<td class=\"d-flex justify-content-center align-items-center\">"
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
                                                // Update the serial numbers
                                                updateSerialNumbers();
                                                // Update policyCount
                                                var policyCount = document.getElementById('policyTable').rows.length - 1; // subtract 1 for header row
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
                                if (table.rows[i].id !== '') { // Skip the header row
                                table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
                                }
                                }
                                }
                    </script>    

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-6 col-md-9">
                                <div class="form-group">
                                    <label  class="label" for="approvalName">Approval Name: <span style="color: red; font-size: 12px;">*</span></label>

                                    <select class="select-input" id="approvalName" name="approvalName" 
                                            style="width: 225px; font-size: 12px; padding: 5px;" required="required">
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
                            <button type="submit" id="submitButton" class="btn theme-btn mr-3" title="" value="">SUBMIT</button>
                            <button type="submit" class="btn theme-btn" id="aocSavDraft1"  formaction="aocForm.htm?act=AocSaveAsDraft" title="" value="Save As Draft">Save As Draft</button>

                        </div>
                    </div>

                    <script>
                                document.getElementById("aocSavDraft").addEventListener('click', function () {
                                var requiredFields = document.querySelectorAll('input[required], textarea[required], file[required], select[required]');
                                        requiredFields.forEach(function (field) {
                                        field.removeAttribute('required');
                                        });
                                });</script>                                      
                    <script>
                                        document.getElementById("aocSavDraft1").addEventListener('click', function () {
                                var requiredFields = document.querySelectorAll('input[required], textarea[required], file[required], select[required]');
                                        requiredFields.forEach(function (field) {
                                        field.removeAttribute('required');
                                        });
                                });</script>                                      



                </section>
            </form:form><!-- /.content -->
        </div><!-- /.content-wrapper -->
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

        <script>
                            // List only the fields you want to toggle required
                            var fieldsToToggle = [
                                    document.getElementById('depoName'),
                                    document.getElementById('b2b'),
                                    document.getElementById('b2b2c'),
                                    document.getElementById('b2c'),
                                    document.getElementById('projectName'),
                                    document.getElementById('countryDropdown'),
                                    document.getElementById('stateDropdown'),
                                    document.getElementById('city'),
                                    document.getElementById('depoAddress'),
                                    document.getElementById('district'),
                                    document.getElementById('houseno'),
                                    document.getElementById('googleCoordinates'),
                                    document.getElementById('coordinates'),
                                    document.getElementById('firstName'),
                                    document.getElementById('email'),
                                    document.getElementById('mobileNo'),
                                    document.getElementById('altNo'),
                                    document.getElementById('scopework'),
                                    document.getElementById('scope'),
                                    document.getElementById('reqClients'),
                                    document.getElementById('operations'),
                                    document.getElementById('operationsSign'),
                                    document.getElementById('maintenance'),
                                    document.getElementById('maintenancesign'),
                                    document.getElementById('Fromdate6'),
                                    document.getElementById('Fromdate7'),
                                    document.getElementById('inr'),
                                    document.getElementById('chargingrate'),
                                    document.getElementById('comments'),
                                    document.getElementById('Fromdate8'),
                                    document.getElementById('revisionNo'),
                                    document.getElementById('Fromdate9'),
                                    document.getElementById('reviewed'),
                                    document.getElementById('designation'),
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
                                    document.getElementById('projectTimelineCategory'),
                                    document.getElementById('totalKwRating'),
                                    document.getElementById('specificDateFromClient'),
                                    document.getElementById('totalChargerCapacity'),
                                    document.getElementById('chargerStationAccessType'),
                                    document.getElementById('chargingRetePerUnit'),
                                    document.getElementById('noOfEvsToBeChanged'),
                                    document.getElementById('additionOfNewChargerCapacity'),
                                    document.getElementById('approvalName')


                            ];
        // / On Submit: make fields required
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
                    });</script>



    </section>
</main>
</body>
<%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

<script src="StorageYard/JS/countries.js" type="text/javascript"></script>
<script src="StorageYard/JS/states.js" type="text/javascript"></script>
<script src="StorageYard/JS/cities.js" type="text/javascript"></script>
<body onload="toggleDisplay();">

</body>
</html>
