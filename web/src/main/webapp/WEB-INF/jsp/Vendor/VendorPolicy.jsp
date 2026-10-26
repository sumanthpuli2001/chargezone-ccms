<%-- 
    Document   : VendorPolicy
    Created on : 28 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Vendor Self Service</title>

        <style>
            .textarea-field:disabled {
                background-color: #d6d8db !important;
                color: #495057 !important;           
                border: 1px solid #6c757d !important;
                opacity: 1;                          
            }
            
        </style>
        <style>           
            input[type="text"], textarea {
                text-transform: uppercase;
            }
        </style>

        <script>
            document.addEventListener("input", function (e) {
                const el = e.target;

                if (
                    el.matches("input:not([type='hidden']):not([type='checkbox']):not([type='radio']), textarea")
                ) {
                    if (el.type === "email") {
                        el.value = el.value.toLowerCase();
                    } else {
                        el.value = el.value.toUpperCase();
                    }
                }
            });
        </script>
       
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=policyVendorInformation"  enctype="multipart/form-data" method="post" name='form' class="form-horizontal" role="form">                    
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Vendor Self Service</h5>
                        </div>
                        <div class="cta d-flex align-items-center" style="gap: 15px;">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                            
                            <!--<button type="submit" class="btn theme-btn">Save & Continue</button>-->                                          
                            <c:if test="${vendorInformation3.status1 != 3 && vendorInformation3.status1 != 4 && vendorInformation3.status1 != 5}">
                                <button type="submit" id="vendopolicy1" class="btn theme-btn" formaction="vendorInformation.htm?act=vendorBasicInformationShow">Next</button>
                            </c:if>
                        </div>
                    </div>
                    <hr>
                    

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <c:if test="${vendorInformation3.status1 == 3}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Rework from Buyer.</strong> <br>
                            </c:if>
                            <c:if test="${vendorInformation3.status1 == 4}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Rework from Auditor. </strong><br>
                            </c:if>
                            <c:if test="${vendorInformation3.status1 == 5}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Rework from Procurement Head. </strong><br>
                            </c:if>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                        </div>
                    </div>
                    <c:if test="${!empty failureMessage}">
                        <br>
                        <div class="fadeOutEffect alert alert-danger" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">
                        <br>
                        <div class="fadeOutEffect alert alert-info" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                                
                        <div class="rounded-4 mt-4">
                            <div class="row mb-3">
                                <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label class="control-label">Company Name :</label>
                                        <input type="text" name="companyName"  class="input-field" readonly="true" value="${vendorInvitation.companyName}" required="required"/>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-4">
                                    <div class="form-group">
                                        <label class="control-label">Email ID :</label>
                                        <input type="email" name="vendorEmailId"  class="input-field" readonly="true" value="${vendorInvitation.vendorEmailId}" required="required"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->

                            <thead>
                                <tr>
                                    <td colspan="4" style=" background-color: skyblue; text-align: center;"><strong>TYPES OF VENDOR</strong></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>                                    
                                    <th>Group Name</th>
                                    <th>Group Category Name</th>
                                    <th colspan="2">Group Sub Category Name</th>
                                </tr>
                                <c:forEach var="list" items="${list}" varStatus="status">
                                    <tr>
                                <input type="hidden" class="input-field" id="groupId" name="groupId" value="${list[2]}<" />
                                <td>${list[2]}</td>
                                <td>${list[3]}</td>
                                <td colspan="2">${list[4]}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <br>
                                
                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                            <tbody>
                             
                                <tr>                                   
                                    <td style=" vertical-align: top;">
                                        <label class="control-label">Standard Policy :</label><br>
                                        TCZL-SCM-002_Supplier Code of Conduct.pdf
                                        <a class="text-break gradient-text fw-600" href="StorageYard/TCZL-SCM-002_Supplier Code of Conduct.pdf">&nbsp;<span class="fa fa-download"></span></a>
                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/TCZL-SCM-002_Supplier Code of Conduct.pdf"><span class="fa fa-solid fa-eye"></span></a>
                                    </td>

                                    <!-- Policy Acceptance -->
                                    <td style=" vertical-align: top;">
                                        <label class="control-label">Policy Acceptance :<span class="text-danger"> *</span></label><br />
                                        <input type="radio" id="accept" name="e" value="1" onchange="updateLabel(true)" 
                                               <c:if test="${vendorInformation3.policyAccept=='1' || empty vendorInformation3.policyAccept}">checked="true"</c:if> required />
                                               <label for="accept" class="control-label" >Accept</label>&nbsp;&nbsp;&nbsp;

                                               <input type="radio" id="notAccept" name="e" value="0" onchange="updateLabel(false)"

                                               <c:if test="${vendorInformation3.policyAccept=='0'}">checked="true"</c:if> required />
                                               <label for="notAccept" class="control-label">Not Accept</label>
                                        </td>

                                        <!-- File Upload -->
                                        <td style=" vertical-align: top;">
                                            <label class="control-label" id="policyLabel">Upload Code of Conduct (With Sign & Stamp on all Pages):<span class="text-danger">*</span></label><br />
                                            <div id="policy">                                            
                                            <c:if test="${vendorInformation3.policy1File!= null && not empty vendorInformation3.policy1File}">                                                
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation3.policy1File}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation3.policy1File}&id=${vendorInformation3.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation3.id}/${vendorInformation3.policy1File}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </div>
                                        <br>
                                        <input type="hidden" id="policyFiles"  class="input-field"name="policyFiles" value="${vendorInformation3.policy1File}">                                                        
                                        <c:choose>
                                            <c:when test="${vendorInformation3.status1 == 3}">
                                                <c:if test="${vendorBuyerApproval.cocStatuss == 'reject'}">
                                                    <input type="file"  class="input-field"id="policyFile1" name="policyFile1" required onchange="validateFileSize(this, 'fileErrorPolicyFile');" />
                                                </c:if>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="file"  class="input-field"id="policyFile1" name="policyFile1" <c:if test="${empty vendorInformation3.policy1File}">required</c:if> onchange="validateFileSize(this, 'fileErrorPolicyFile');" />
                                            </c:otherwise>
                                        </c:choose>
                                        <span id="fileErrorPolicyFile" style="color:red;font-size:11px;display:none;">
                                            * File should not exceed 5MB
                                        </span>
                                    </td>
                                    <c:if test="${vendorInformation3.status1 == 3}">
                                        <td>                                                            
                                            <c:if test="${vendorBuyerApproval.cocStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.cocStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea  class="textarea-field comment" style="text-transform: uppercase;" name="cocRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.cocRemarkk}</textarea>
                                                </div>
                                            </c:if> 
                                            <c:if test="${vendorBuyerApproval.cocStatuss == 'reject'}">
                                                <div>
                                                    <textarea  class="textarea-field comment" style="text-transform: uppercase;" name="cocResponse" rows="2" cols="30" required>${vendorBuyerApproval.cocResponse}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                    </c:if>
                                </tr>

                                <!-- Row 2: NDA Policy -->
                                <tr>
                                    <!-- NDA Document -->
                                    <td style=" vertical-align: top;">
                                        <label class="control-label">NDA Policy :</label><br />
                                        TCZL-SCM-003 Non Disclosure Agreement_16 10 2025.docx   <a class="text-break gradient-text fw-600" href="StorageYard/TCZL-SCM-003 Non Disclosure Agreement_16 10 2025.docx"> <span class="fa fa-download"></span>  </a>                
                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/TCZL-SCM-003 Non Disclosure Agreement_16 10 2025.docx"><span class="fa fa-solid fa-eye"></span></a>
                                    </td>

                                    <!-- NDA Acceptance -->
                                    <td style=" vertical-align: top;">
                                        <label class="control-label">NDA Policy Acceptance : <span class="text-danger">*</span></label><br />
                                        <input type="radio" id="AcceptNda" name="ndaPolicyAccept" value="1" onchange="updateLabelNda(true)"
                                               <c:if test="${vendorInformation3.ndaPolicyAccept=='1' || empty vendorInformation3.ndaPolicyAccept}">checked="true"</c:if> required />     
                                               <label for="AcceptNda" class="control-label">Accept</label>&nbsp;&nbsp;&nbsp;

                                               <input type="radio" id="notAcceptNda" name="ndaPolicyAccept" value="0" onchange="updateLabelNda(false)"
                                               <c:if test="${vendorInformation3.ndaPolicyAccept=='0'}">checked="true"</c:if> required />
                                               <label for="notAcceptNda" class="control-label">Not Accept</label>
                                        </td>

                                        <!-- NDA File Upload -->
                                        <td style=" vertical-align: top;">
                                            <label class="control-label" id="policyLabel2">NDA (Sign & Stamp on all Pages):<span class="text-danger">*</span></label><br />
                                            <div id="policy">
                                            <c:if test="${vendorInformation3.ndaPolicyFile!= null && not empty vendorInformation3.ndaPolicyFile}">                                                
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${vendorInformation3.ndaPolicyFile}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation3.ndaPolicyFile}&id=${vendorInformation3.id}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation3.id}/${vendorInformation3.ndaPolicyFile}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>
                                        </div>                                        
                                            <br />

                                        <input type="hidden" id="ndaPolicyFileHidden"  class="input-field" name="ndaPolicyFiles" value="${vendorInformation3.ndaPolicyFile}">
                                        <c:choose>
                                            <c:when test="${vendorInformation3.status1 == 3}">
                                                <c:if test="${vendorBuyerApproval.ndaStatuss == 'reject'}">
                                                    <input type="file"  class="input-field"id="ndaPolicyFile" name="ndaPolicyFile" required onchange="validateFileSize(this, 'fileErrorNdaFile');" />
                                                </c:if>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="file"  class="input-field"id="ndaPolicyFile" name="ndaPolicyFile" <c:if test="${empty vendorInformation3.ndaPolicyFile}">required</c:if> onchange="validateFileSize(this, 'fileErrorNdaFile');" />
                                            </c:otherwise>
                                        </c:choose>
                                        <span id="fileErrorNdaFile" style="color:red;font-size:11px;display:none;">
                                            * File should not exceed 5MB
                                        </span>

                                    </td>
                                    <c:if test="${vendorInformation3.status1 == 3}">
                                        <td>                                                            
                                            <c:if test="${vendorBuyerApproval.ndaStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.ndaStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea style="text-transform: uppercase;"  class="textarea-field comment" name="ndaRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.ndaRemarkk}</textarea>
                                                </div>
                                            </c:if> 
                                            <c:if test="${vendorBuyerApproval.ndaStatuss == 'reject'}">
                                                <div>                                                            
                                                    <textarea style="text-transform: uppercase;"  class="textarea-field comment" name="ndaResponse" rows="2" cols="30" required>${vendorBuyerApproval.ndaResponse}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                    </c:if>
                                </tr>
                            </tbody>
                        </table>

                                      
                            <script>
                                        // JavaScript function for Deviation Policy label update
                                                function updateLabel(isAccepted) {
                                                var label = document.getElementById("policyLabel");
                                                        if (isAccepted) {
                                                label.innerHTML = 'Upload Code of Conduct (With Sign & Stamp on all Pages):<span class="text-danger">*</span>';
                                                } else {
                                                label.innerHTML = 'Upload Deviation Policy (With Sign & Stamp on all Pages): <span class="text-danger">*</span>';
                                                }
                                                }

                                        // ✅ Initialize Deviation Policy label safely
                                        window.addEventListener('load', function() {
                                        var policyValue = '<c:out value="${vendorInformation3.policyAccept}" default="1" />';
                                                console.log("Loaded Policy Accept Value:", policyValue);
                                                if (policyValue === '1') {
                                        updateLabel(true);
                                        } else {
                                        updateLabel(false);
                                        }
                                        });</script>

                            <script>
                                                // Function to update NDA label dynamically
                                                        function updateLabelNda(isAccepted) {
                                                        var label = document.getElementById("policyLabel2");
                                                                if (isAccepted) {
                                                        label.innerHTML = 'Upload NDA (WIth Sign & Stamp on all Pages): <span class="text-danger">*</span>';
                                                        } else {
                                                        label.innerHTML = 'Upload NDA Deviation Policy (With Sign & Stamp on all Pages): <span class="text-danger">*</span>';
                                                        }
                                                        }

                                                // ✅ Initialize NDA label safely (separate event listener)
                                                window.addEventListener('load', function() {
                                                var ndapolicyValue = '<c:out value="${vendorInformation3.ndaPolicyAccept}" default="1" />';
                                                        console.log("Loaded NDA policy value:", ndapolicyValue);
                                                        if (ndapolicyValue === '1') {
                                                updateLabelNda(true);
                                                } else {
                                                updateLabelNda(false);
                                                }
                                                });</script>




                          <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                        <thead>
                                            <tr>
                                                <th id="policyTableHeader" colspan="3" style=" text-align: center; background-color: skyblue"><strong>
                                                              
                                                   SELF DECLARATION FORM</strong></th>
                                            </tr>                                        
                                    
    </thead>
    <tbody>
        <tr>
            <th>Question</th>
            <th>Vendor Response</th>
            <th>Comments</th>
        </tr>
        <!-- Q1 -->
        <tr>
              <td style="width: 50%;">
        <b>1. Is the organization publicly listed company with shares being traded on any Stock Exchange? If yes, then please fill out the details. </b><span style="color:red">*</span> 
    </td>

    <td style="width: 15%;">
        <label class="radio-inline">
            <input type="radio" value="1" name="desDecOneFlag" 
                   onclick="toggleTextarea('q1-details', true)"
            <c:if test="${declaration.desDecOneFlag==1}">checked="true"</c:if> required> Yes
        </label>

        <label class="radio-inline">
            <input type="radio" value="0" name="desDecOneFlag" 
                   onclick="toggleTextarea('q1-details', false)"
            <c:if test="${declaration.desDecOneFlag==0}">checked="true"</c:if> required> No
        </label>
    </td>

    <td style="width: 35%;">
        <textarea class="textarea-field" maxlength="250" id="q1-details" name="desDecOne"<c:if test="${declaration.desDecOneFlag==0}">disabled</c:if>>${declaration.desDecOne}</textarea>

        <!-- ❗ ADDED ERROR MESSAGE HERE -->
        <span id="q1-error" style="color:red; font-size:12px;"></span>

        <c:if test="${declaration.desDecOneFlag!=0}">
            <small id="charCount_q1-details" style="font-size: 12px; color: green;"></small>
        </c:if>

        <script type="text/javascript">

    //char count
    document.addEventListener("DOMContentLoaded", function () {
        var textarea = document.getElementById("q1-details");
        var charCount = document.getElementById("charCount_q1-details");
        var maxChars = 250;
//
//// FIX BACK-BUTTON GLITCH: force re-disable AFTER browser restores history
//window.onload = function () {
//    var flag = "${declaration.desDecOneFlag}";
//    if (flag == "0") {
//        var textarea = document.getElementById("q1-details");
//        textarea.disabled = true;
//    }
//};

        function updateCharCount() {
            var count = textarea.value.trim().length;
            var remaining = maxChars - count;
            charCount.textContent = remaining + " characters remaining";
            charCount.style.color = (remaining <= 20) ? "red" : "green";
        }

        updateCharCount();
        textarea.addEventListener("input", updateCharCount);
    });

    //toggle enable/disable + required
    function toggleTextarea(id, enable) {
        var textarea = document.getElementById(id);

        if (enable) {
            textarea.removeAttribute("disabled");
            textarea.setAttribute("required", "true");
        } else {
            textarea.setAttribute("disabled", "true");
            textarea.removeAttribute("required");
            textarea.value = "";
        }

        //clear old error message
        document.getElementById("q1-error").textContent = "";
    }

    //submit validation
    function fileValidation1() {
        var selected = document.querySelector('input[name="desDecOneFlag"]:checked');
        var textarea = document.getElementById('q1-details');
        var errorBox = document.getElementById('q1-error');

        errorBox.textContent = "";

        if (!selected) {
            errorBox.textContent = "Please select Yes or No.";
            return false;
        }

        if (selected.value === "1") {
            textarea.removeAttribute("disabled");
            textarea.setAttribute("required", "true");

            if (textarea.value.trim() === "") {
                errorBox.textContent = "";
                textarea.focus();
                return false;
            }
        }

        return true;
    }

</script>

    </td>
</tr>




                                            <tr>
                                                <td style="width: 50%;">
                                                    <b>2. Has the Supplier ever conducted business under any alias...? </b><span style="color:red">*</span>
                                                </td>
                                                <td>
                                                    <label class="radio-inline"><input value="1" type="radio" name="desDecTwoFlag" onclick="toggleTextarea('q2-details', true)" <c:if test="${declaration.desDecTwoFlag==1}">checked="true"</c:if> required >  Yes</label>
                                                    <label class="radio-inline"><input value="0" type="radio" name="desDecTwoFlag" onclick="toggleTextarea('q2-details', false)" <c:if test="${declaration.desDecTwoFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="q2-details" name="desDecTwo" maxlength="250" <c:if test="${declaration.desDecTwoFlag==0}">disabled</c:if>>${declaration.desDecTwo}</textarea>

                                                    <c:if test="${declaration.desDecTwoFlag!=0}">
                                                        <small id="charCount_q2-details" style="font-size: 12px; color: green;">250 characters remaining</small>
                                                    </c:if>

  <script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
        var textarea = document.getElementById("q2-details");
        var charCount = document.getElementById("charCount_q2-details");
        var maxChars = 250;

  

        function updateCharCount() {
            var count = textarea.value.trim().length;
            var remaining = maxChars - count;
            charCount.textContent = remaining + " characters remaining";
            charCount.style.color = (remaining <= 20) ? "red" : "green";
        }

        updateCharCount();

        textarea.addEventListener("input", updateCharCount);
    });

    //submit validation
    function fileValidation2() {
        var selected = document.querySelector('input[name="desDecTwoFlag"]:checked');
        var textarea = document.getElementById('q2-details');

        if (selected.value === "1") {
            textarea.removeAttribute("disabled");
            textarea.setAttribute("required", "true");

            if (textarea.value.trim() === "") {
                errorBox.textContent = "";
                textarea.focus();
                return false;
            }
        }

        return true;
    }
</script>

                                                                                                        
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        3. Litigation History
                                                    </strong>
                                                    <br>
                                                    Whether your organization is involved in any legal proceedings?<br>
                                                    - For Proprietorship organization the Proprietor to declare if he / she is involved in any legal proceedings.<br>
                                                    - For Partnership organization all or any Partners are involved in any legal proceedings.
                                                    If yes, then please fill out the details.<span style="color:red">*</span>
                                                </td>
                                                <td>
                                                    <label class="radio-inline"><input type="radio" value="1" name="litigationHistoryFlag" onclick="toggleTextarea('litigationHistoryDes', true)" <c:if test="${declaration.litigationHistoryDesFlag==1}">checked="true"</c:if> required > Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="litigationHistoryFlag" onclick="toggleTextarea('litigationHistoryDes', false)" <c:if test="${declaration.litigationHistoryDesFlag==0}">checked="true"</c:if> required > No</label>
                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="litigationHistoryDes" name="litigationHistoryDes" maxlength="250" <c:if test="${declaration.litigationHistoryDesFlag==0}">disabled</c:if>>${declaration.litigationHistoryDes}</textarea>

                                                    <c:if test="${declaration.litigationHistoryDesFlag!=0}">
                                                        <small id="charCount_litigationHistoryDes" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("litigationHistoryDes");
                                                            var charCount = document.getElementById("charCount_litigationHistoryDes");
                                                            var maxChars = 250;









                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            // Run once when page loads (for prefilled text)
                                                            updateCharCount();

                                                            // Update dynamically as user types
                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                                        
                                                        
                                                                          
                                                          //submit validation
            function fileValidation3() {
                var selected = document.querySelector('input[name="litigationHistoryFlag"]:checked');
                var textarea = document.getElementById('litigationHistoryDes');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }
                                                    </script>
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <strong>
                                                        4. Political Contributions
                                                    </strong>
                                                    <br>
                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has made any contributions / donations (either of a charitable or political nature), in the past or at present, to a political party / organization affiliated with a political party or a political leader, on behalf of the Third Party / Supplier or in their personal capacity?
                                                    If yes, then please fill out the details. <span style="color:red">*</span> 
                                                </td>
                                                <td> <label class="radio-inline"><input type="radio" value="1" name="politicalContributionFlag" onclick="toggleTextarea('politicalContributionDes', true)" <c:if test="${declaration.politicalContributionDesFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="politicalContributionFlag" onclick="toggleTextarea('politicalContributionDes', false)" <c:if test="${declaration.politicalContributionDesFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>   
                                                        <textarea class="textarea-field" id="politicalContributionDes" name="politicalContributionDes" maxlength="250" <c:if test="${declaration.politicalContributionDesFlag==0}">disabled</c:if>>${declaration.politicalContributionDes}</textarea>

                                                    <c:if test="${declaration.politicalContributionDesFlag!=0}">
                                                        <small id="charCount_politicalContributionDes" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("politicalContributionDes");
                                                            var charCount = document.getElementById("charCount_politicalContributionDes");
                                                            var maxChars = 250;









                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                                        
                                   //submit validation
            function fileValidation4() {
                var selected = document.querySelector('input[name="politicalContributionFlag"]:checked');
                var textarea = document.getElementById('politicalContributionDes');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }                     
                                                        
                                                        
                                                        
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        5. Conflict of Interest
                                                    </strong>
                                                    <br>
                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) have any financial interests, personal or familial relationships, or affiliations with Tecso Charge Zone Limited or any of its Directors or employees?
                                                    If yes, then please fill out the details.<span style="color:red">*</span>
                                                </td>
                                                <td>  <label class="radio-inline"><input type="radio" value="1" name="conflictInterestFlag" onclick="toggleTextarea('conflictInterestDes', true)" <c:if test="${declaration.conflictInsterestDesFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="conflictInterestFlag" onclick="toggleTextarea('conflictInterestDes', false)" <c:if test="${declaration.conflictInsterestDesFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="conflictInterestDes" name="conflictInterestDes" maxlength="250" <c:if test="${declaration.conflictInsterestDesFlag==0}">disabled</c:if>>${declaration.conflictInsterestDes}</textarea>

                                                    <c:if test="${declaration.conflictInsterestDesFlag!=0}">
                                                        <small id="charCount_conflictInterestDes" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("conflictInterestDes");
                                                            var charCount = document.getElementById("charCount_conflictInterestDes");
                                                            var maxChars = 250;





                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                                         //submit validation
            function fileValidation5() {
                var selected = document.querySelector('input[name="conflictInterestFlag"]:checked');
                var textarea = document.getElementById('conflictInterestDes');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            } 
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        6.  Use of Executive/Judicial (Public Official) Influence
                                                    </strong>
                                                    <br>
                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has sought or obtained the assistance of a Public Official in connection with providing goods / services to CZ?
                                                    If yes, then please fill out the details. <span style="color:red">*</span>
                                                </td>
                                                <td>  <label class="radio-inline"><input type="radio" value="1" name="executiveJudicialFlag" onclick="toggleTextarea('executiveJudicialDes', true)" <c:if test="${declaration.executiveJudicialDesFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="executiveJudicialFlag" onclick="toggleTextarea('executiveJudicialDes', false)" <c:if test="${declaration.executiveJudicialDesFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="executiveJudicialDes" name="executiveJudicialDes" maxlength="250" <c:if test="${declaration.executiveJudicialDesFlag==0}">disabled</c:if>>${declaration.executiveJudicialDes}</textarea>

                                                    <c:if test="${declaration.executiveJudicialDesFlag!=0}">
                                                        <small id="charCount_executiveJudicialDes" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("executiveJudicialDes");
                                                            var charCount = document.getElementById("charCount_executiveJudicialDes");
                                                            var maxChars = 250;

                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                                        
                                   //submit validation
            function fileValidation6() {
                var selected = document.querySelector('input[name="executiveJudicialFlag"]:checked');
                var textarea = document.getElementById('executiveJudicialDes');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }                      
                                                        
                                                        
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        7. Politically Exposed Personnel
                                                    </strong><br>
                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party is or has been associated with any political party/ political leader / organization affiliated with a political party or a political leader?
                                                    <br><i>[For illustrative purposes, ‘Y’ is an employee / proprietor of the Third Party entity and ‘K’, his maternal uncle is a local MLA in Raigad. Herein, ‘Y’ shall be considered as politically exposed for the purposes of disclosure to CZ]</i>
                                                    If yes, then please fill out the details.<span style="color:red">*</span>
                                                </td>
                                                <td>  
                                                    <label class="radio-inline"><input type="radio" value="1" name="politicallyExposedOneFlag" onclick="toggleTextarea('politicallyExposedDesOne', true)" <c:if test="${declaration.politicallyExposedDesOneFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="politicallyExposedOneFlag" onclick="toggleTextarea('politicallyExposedDesOne', false)" <c:if test="${declaration.politicallyExposedDesOneFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>       
                                                        <textarea class="textarea-field" id="politicallyExposedDesOne" name="politicallyExposedDesOne" maxlength="250" <c:if test="${declaration.politicallyExposedDesOneFlag==0}">disabled</c:if>>${declaration.politicallyExposedDesOne}</textarea>

                                                    <c:if test="${declaration.politicallyExposedDesOneFlag!=0}">
                                                        <small id="charCount_politicallyExposedDesOne" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("politicallyExposedDesOne");
                                                            var charCount = document.getElementById("charCount_politicallyExposedDesOne");
                                                            var maxChars = 250;

                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                              //submit validation
            function fileValidation7() {
                var selected = document.querySelector('input[name="politicallyExposedOneFlag"]:checked');
                var textarea = document.getElementById('politicallyExposedDesOne');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }                      
                          
                                                        
                                                        
                                                        
                                                        
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        7.1
                                                    </strong><br>
                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party will seek / has sought or obtained the assistance of any political party / political leader / organization affiliated with a political party or a political leader in connection with providing goods / services to CZ?
                                                    If yes, then please fill out the details. <span style="color:red">*</span>
                                                </td>
                                                <td>
                                                    <label class="radio-inline"><input type="radio" value="1" name="politicallyExposedTwoFlag" id="politicallyExposedTwoFlagId" onclick="toggleTextarea('politicallyExposedDesTwo', true)" <c:if test="${declaration.politicallyExposedDesTwoFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="politicallyExposedTwoFlag" id="politicallyExposedTwoFlagId" onclick="toggleTextarea('politicallyExposedDesTwo', false)" <c:if test="${declaration.politicallyExposedDesTwoFlag==0}">checked="true"</c:if> required> No</label>

                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="politicallyExposedDesTwo" name="politicallyExposedDesTwo" maxlength="250" <c:if test="${declaration.politicallyExposedDesTwoFlag==0}">disabled</c:if>>${declaration.politicallyExposedDesTwo}</textarea>

                                                    <c:if test="${declaration.politicallyExposedDesTwoFlag!=0}">
                                                        <small id="charCount_politicallyExposedDesTwo" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                     <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("politicallyExposedDesTwo");
                                                            var charCount = document.getElementById("charCount_politicallyExposedDesTwo");
                                                            var maxChars = 250;

                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                              //submit validation
            function fileValidation8() {
                var selected = document.querySelector('input[name="politicallyExposedTwoFlag"]:checked');
                var textarea = document.getElementById('politicallyExposedDesTwo');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }                      
                          
                                                        
                                                        
                                                        
                                                        
                                                    </script>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><strong>
                                                        7.2
                                                    </strong><br>
                                                    Whether any assistance has been sought from a political party / political leader / an organization affiliated with a political party, or a political leader for resolution of any issues / concerns related to the functioning / management / regulatory compliance of the Third Party?
                                                    If yes, then please fill out the details.<span style="color:red">*</span>
                                                </td>
                                                <td>
                                                    <label class="radio-inline"><input type="radio" value="1" name="politicallyExposedThreeFlag" onclick="toggleTextarea('politicallyExposedDesThree', true)" <c:if test="${declaration.politicallyExposedDesThreeFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="politicallyExposedThreeFlag" onclick="toggleTextarea('politicallyExposedDesThree', false)" <c:if test="${declaration.politicallyExposedDesThreeFlag==0}">checked="true"</c:if> required> No</label>

                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="politicallyExposedDesThree" name="politicallyExposedDesThree" maxlength="250" <c:if test="${declaration.politicallyExposedDesThreeFlag==0}">disabled</c:if>>${declaration.politicallyExposedDesThree}</textarea>

                                                    <c:if test="${declaration.politicallyExposedDesThreeFlag!=0}">
                                                        <small id="charCount_politicallyExposedDesThree" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("politicallyExposedDesThree");
                                                            var charCount = document.getElementById("charCount_politicallyExposedDesThree");
                                                            var maxChars = 250;

                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                                        
                                                        
                                                        //submit validation
            function fileValidation9() {
                var selected = document.querySelector('input[name="politicallyExposedThreeFlag"]:checked');
                var textarea = document.getElementById('politicallyExposedDesThree');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        8. Nature of Services
                                                    </strong>
                                                    <br>
                                                    Whether the Scope of Work to be carried out by the Third Party will involve providing any form of liaising or facilitation services with Government Departments?
                                                    If yes, then please fill out the details.<span style="color:red">*</span> 
                                                </td>
                                                <td> <label class="radio-inline"><input type="radio" value="1" name="natureServicesOneFlag" onclick="toggleTextarea('natureServicesOneDes', true)" <c:if test="${declaration.natureServicesOneFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="natureServicesOneFlag" onclick="toggleTextarea('natureServicesOneDes', false)" <c:if test="${declaration.natureServicesOneFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>    
                                                        <textarea class="textarea-field" id="natureServicesOneDes" name="natureServicesOneDes" maxlength="250" <c:if test="${declaration.natureServicesOneFlag==0}">disabled</c:if>>${declaration.natureServicesOne}</textarea>

                                                    <c:if test="${declaration.natureServicesOneFlag!=0}">
                                                        <small id="charCount_natureServicesOneDes" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("natureServicesOneDes");
                                                            var charCount = document.getElementById("charCount_natureServicesOneDes");
                                                            var maxChars = 250;

                                                            function updateCharCount() {
                                                                var count = textarea.value.trim().length;
                                                                var remaining = maxChars - count;
                                                                charCount.textContent = remaining + " characters remaining";
                                                                charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                            }

                                                            updateCharCount();

                                                            textarea.addEventListener("input", updateCharCount);
                                                        });
                                                        
                     //submit validation
            function fileValidation10() {
                var selected = document.querySelector('input[name="natureServicesOneFlag"]:checked');
                var textarea = document.getElementById('natureServicesOneDes');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }                                   
                                                        
                                                        
                                                    </script>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        8.1
                                                    </strong>
                                                    <br>
                                                    Whether the Scope of Work to be carried out by the Third Party will involve interacting with Public Officials (Government officials/Judges/Public Sector Companies, etc.) on behalf of Chargezone?
                                                    If yes, then please fill out the details. <span style="color:red">*</span>
                                                </td>
                                                <td> 
                                                    <label class="radio-inline"><input type="radio" value="1" name="natureServicesTwoFlag" onclick="toggleTextarea('natureServicesTwoDes', true)" <c:if test="${declaration.natureServicesTwoFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="natureServicesTwoFlag" onclick="toggleTextarea('natureServicesTwoDes', false)" <c:if test="${declaration.natureServicesTwoFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>
                                                        <textarea class="textarea-field" id="natureServicesTwoDes" name="natureServicesTwoDes" maxlength="250" <c:if test="${declaration.natureServicesTwoFlag==0}">disabled</c:if>>${declaration.natureServicesTwo}</textarea>

                                                    <c:if test="${declaration.natureServicesTwoFlag!=0}">
                                                        <small id="charCount_natureServicesTwoDes" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("natureServicesTwoDes");
                                                            var charCount = document.getElementById("charCount_natureServicesTwoDes");
                                                            var maxChars = 250;

                                                            if (textarea && charCount) {
                                                                function updateCharCount() {
                                                                    var count = textarea.value.trim().length;
                                                                    var remaining = maxChars - count;
                                                                    charCount.textContent = remaining + " characters remaining";
                                                                    charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                                }

                                                                updateCharCount();

                                                                textarea.addEventListener("input", updateCharCount);
                                                            }
                                                        });
                                                        
                                                                  
                                    //submit validation
            function fileValidation11() {
                var selected = document.querySelector('input[name="natureServicesTwoFlag"]:checked');
                var textarea = document.getElementById('natureServicesTwoDes');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }    
                                                        
                                                        
                                                        
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        9.  Acknowledgment of understanding and NDA
                                                    </strong><br>
                                                    Has the Procurement team explained to you the Supplier Registration process especially the Code of Conduct document? Please answer in Yes or No
                                                    If yes, then please fill out the details. <span style="color:red">*</span> 
                                                </td>
                                                <td> 
                                                    <label class="radio-inline"><input type="radio" value="1" name="ndaOneFlag" onclick="toggleTextarea('ndaOneInput', true)" <c:if test="${declaration.ndaOneFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="ndaOneFlag" onclick="toggleTextarea('ndaOneInput', false)" <c:if test="${declaration.ndaOneFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>            
                                                        <textarea class="textarea-field" id="ndaOneInput" name="ndaOne" maxlength="250" <c:if test="${declaration.ndaOneFlag==0}">disabled</c:if>>${declaration.ndaOne}</textarea>

                                                    <c:if test="${declaration.ndaOneFlag!=0}">
                                                        <small id="charCount_ndaOneInput" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("ndaOneInput");
                                                            var charCount = document.getElementById("charCount_ndaOneInput");
                                                            var maxChars = 250;

                                                            if (textarea && charCount) {
                                                                function updateCharCount() {
                                                                    var count = textarea.value.trim().length;
                                                                    var remaining = maxChars - count;
                                                                    charCount.textContent = remaining + " characters remaining";
                                                                    charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                                }

                                                                updateCharCount();

                                                                textarea.addEventListener("input", updateCharCount);
                                                            }
                                                        });
                                                        
              //submit validation
            function fileValidation12() {
                var selected = document.querySelector('input[name="ndaOneFlag"]:checked');
                var textarea = document.getElementById('ndaOneInput');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }                                            
                                                        
                                                        
                                                    </script>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    <strong>
                                                        9.1
                                                    </strong>
                                                    <br>
                                                    Has the Procurement team explained to you about the applicability of Non-Disclosure Agreement to your case? If yes have they shared NDA with you. Please answer in Yes or No.
                                                    If yes, then please fill out the details.<span style="color:red">*</span> 

                                                </td>
                                                <td>
                                                    <label class="radio-inline"><input type="radio" value="1" name="ndaTwoFlag"  onclick="toggleTextarea('ndaTwoInput', true)" <c:if test="${declaration.ndaTwoFlag==1}">checked="true"</c:if> required> Yes</label>
                                                    <label class="radio-inline"><input type="radio" value="0" name="ndaTwoFlag" onclick="toggleTextarea('ndaTwoInput', false)" <c:if test="${declaration.ndaTwoFlag==0}">checked="true"</c:if> required> No</label>
                                                    </td>
                                                    <td>    
                                                        <textarea class="textarea-field" id="ndaTwoInput" name="ndaTwo" maxlength="250" <c:if test="${declaration.ndaTwoFlag==0}">disabled</c:if>>${declaration.ndaTwo}</textarea>

                                                    <c:if test="${declaration.ndaTwoFlag!=0}">
                                                        <small id="charCount_ndaTwoInput" style="font-size: 12px; color: green;">
                                                            250 characters remaining
                                                        </small>
                                                    </c:if>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("ndaTwoInput");
                                                            var charCount = document.getElementById("charCount_ndaTwoInput");
                                                            var maxChars = 250;

                                                            if (textarea && charCount) {
                                                                function updateCharCount() {
                                                                    var count = textarea.value.trim().length;
                                                                    var remaining = maxChars - count;
                                                                    charCount.textContent = remaining + " characters remaining";
                                                                    charCount.style.color = (remaining <= 20) ? "red" : "green";
                                                                }

                                                                updateCharCount();

                                                                textarea.addEventListener("input", updateCharCount);
                                                            }
                                                        });
                                                        
                                                        //submit validation
            function fileValidation13() {
                var selected = document.querySelector('input[name="ndaTwoFlag"]:checked');
                var textarea = document.getElementById('ndaTwoInput');
               

                if (selected.value === "1") {
                    textarea.removeAttribute("disabled");
                    textarea.setAttribute("required", "true");

                    if (textarea.value.trim() === "") {
                        errorBox.textContent = "";
                        textarea.focus();
                        return false;
                    }
                }

                return true;
            }
                                                    </script>
                                                </td>

                                            </tr>
                                        </tbody>
                                    </table>
                                                    
                                     <script language="javascript">

                                        function one()
                                        {
                                            if (document.getElementById("e").checked == true && document.getElementById("e1").checked == true)
                                            {
                                                document.getElementById("submit1").disabled = false;
                                                document.form.submit1.disabled = false;
                                            } else {
                                                document.getElementById("submit1").disabled = true;
                                                document.form.submit1.disabled = true;
                                            }

                                        }



                                    </script>  

                                    
                    <c:if test="${vendorInformation3.status1 == 3 || vendorInformation3.status1 == 4 || vendorInformation3.status1 == 5}">
                        <div class="rounded-4 mt-4">
                            <div class="row mb-3 m-0">

                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                    <thead>
                                        <tr>
                                            <th id="policyTableHeader" colspan="6" style=" text-align: center; background-color: skyblue"><strong>

                                                    APPROVAL HISTORY</strong></th>
                                        </tr>                                        
                                    </thead>
                                    <tbody>                                   
                                        <tr>
                                            <th>Sr No.</th>
                                            <th>User Name</th>
                                            <th>User Role</th>
                                            <th>Date Time</th>
                                            <th>Status</th>
                                            <th>Comment</th>
                                        </tr>
                                        <c:set var="srNo" value="1"/>
                                        <tr>
                                            <td>${srNo}</td>
                                            <td>${vendorInvitation.invitedBy}</td>
                                            <td>Buyer</td>
                                            <td>${vendorInvitation.invitedDateTime}</td>
                                            <td>Vendor Invited</td>
                                            <td></td>
                                        </tr>
                                        <c:set var="srNo" value="${srNo + 1}"/>
                                        <c:forEach var="vendorApproval" items="${vendorApproval}">
                                            <tr>
                                                <td>${srNo}</td>
                                                <td>${vendorApproval.userId}</td>
                                                <td>${vendorApproval.userRole}</td>
                                                <td>${vendorApproval.dateTime}</td>
                                                <td>${vendorApproval.activity}</td>
                                                <td>${vendorApproval.description}</td>
                                            </tr>
                                            <c:set var="srNo" value="${srNo + 1}"/>
                                        </c:forEach>
                                    </tbody>                                
                                </table>
                                </div>
                            </div>
                        </c:if>
                                    
                        <div class="form-group">
                            <div style="display: flex; justify-content: center; gap: 15px;">

                                <button type="submit" class="btn theme-btn" style="min-width: 180px;">
                                    Save & Continue
                                </button>
                                <%--<c:if test="${vendorInformation3.status1 != 3 && vendorInformation3.status1 != 4 && vendorInformation3.status1 != 5}">
                                    <button type="submit" id="vendopolicy" class="btn theme-btn" formaction="vendorInformation.htm?act=vendorBasicInformationShow">Next</button>
                                </c:if>--%>

                                

                            </div>
                        </div>
                   
                <script>
                    document.getElementById("vendopolicy1").addEventListener('click', function () {

                        const requiredFields = document.querySelectorAll('input[required], textarea[required], select[required]');

                        requiredFields.forEach(function(field) {
                            field.removeAttribute('required');
                        });

                    });
                </script>
                                    
                                    
                </form:form>
            </section>
        </main>
        <script>

                                    function checkFileSize1(input) {
                                    const file = input.files[0];
                                            const maxSize = 5 * 1024 * 1024; // 5MB

                                            // Find the related error span in the same form-group
                                            const errorMessage = input.closest('.form-group').querySelector('span[id^="cancelCheckError"]');
                                            if (file && file.size > maxSize) {
                                    errorMessage.style.display = 'block'; input.value = ''; // Clear the input
                                    } else {
                                    errorMessage.style.display = 'none';
                                    }
                                    }


                            function toggleTextarea(textareaId, enable) {
                            const textarea = document.getElementById(textareaId);
                                    if (!textarea) return;
                                    // Enable if "Yes" selected, disable and clear if "No"
                                    if (enable) {
                            textarea.disabled = false;
                            } else {
                            textarea.disabled = true;
                                    textarea.value = ''; // optional: clear text when disabled
                            }
                            }


        </script>
        <script>
            function validateFileSize(input, errorId) {
                const file = input.files[0]; 
                const maxSize = 5 * 1024 * 1024; 

                if (file && file.size > maxSize) {
                    document.getElementById(errorId).style.display = 'block';
                    input.value = ''; 
                } else {
                    document.getElementById(errorId).style.display = 'none';
                }
            }
        </script>
    </body>


    <!--<script src="StorageYard/assets/js/TableScript/commonTableScript.js" type="text/javascript"></script>-->

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


