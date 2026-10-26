<%-- 
    Document   : CreateDepartment
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Self Service</title>
       <style>
    /* Error Message Styling */
    .error-message {
        color: red;
        font-size: 0.85em;
        margin-top: 2px;
        width: 100%; /* Important: Takes full width to drop to next line */
        display: block;
    }

    /* Phone Wrapper Layout - Inputs Side-by-Side, Error Below */
    .phone-wrapper {
        display: flex;
        flex-wrap: wrap; /* Allows error message to wrap to next line */
        align-items: center;
        gap: 6px;
        width: 100%;
    }

    .phone-wrapper .select-input {
        flex: 0 0 25%;   /* 25% width */
        height: 38px;
    }

    .phone-wrapper .input-field {
        flex: 0 0 calc(75% - 6px);   /* Remaining width minus gap */
        height: 38px;
    }

    /* Ensure error message inside wrapper goes to new line */
    .phone-wrapper .error-message {
        order: 3; /* Ensures it appears last */
        flex-basis: 100%;
        margin-left: 0; /* Reset margin */
        text-align: left; /* Align text to left */
    }
    
    /* For other phone wrapper variations if needed */
    .phone-wrapper1 {
        display: flex;
        flex-wrap: wrap;
        gap: 8px;
        width: 100%;
    }
    .phone-wrapper1 .select-input { flex: 0 0 25%; height: 38px; }
    .phone-wrapper1 .input-field { flex: 0 0 calc(65% - 8px); height: 38px; } /* Adjusted for 65% logic */
    .phone-wrapper1 .error-message { width: 100%; order: 3; }

</style>
        
       <style>
        .file-actions {
        display: inline-block;
        vertical-align: middle;
        }

        .file-actions a {
        display: inline-block;
        vertical-align: middle;
        margin-left: 6px;
        }

        .delete-icon {
            vertical-align: middle;
        }
         </style>
         
         
         
      
<style>
       /* keep equal width */
.phone-equal .col-sm-4,
.phone-equal .col-sm-8 {
    flex: 36% 70%  !important;
    max-width: 63% !important;
     display: flex;
    gap: 2px; 
}

/* remove bootstrap gutter causing extra space */
.phone-equal > .col-sm-3,
.phone-equal > .col-sm-8 {
    padding-left: 2px !important;
    padding-right: 3px !important;
     margin-left: -6px;
}

/* inputs fill column fully */
.phone-equal .select-input,
.phone-equal .input-field {
    width: 93%;
    height: 38px;
    margin: 0;
    box-sizing: border-box;
   
}
        </style>    
<style>
       /* keep equal width */
.phone-equals .col-sm-4,
.phone-equals .col-sm-8 {
    flex: 36% 63%  !important;
    max-width: 63% !important;
     display: flex;
    gap: 2px; 
}

/* remove bootstrap gutter causing extra space */
.phone-equals > .col-sm-3,
.phone-equals > .col-sm-8 {
    padding-left: 2px !important;
    padding-right: 3px !important;
     margin-left: -6px;
}

/* inputs fill column fully */
.phone-equals .select-input,
.phone-equals .input-field {
    width: 93%;
    height: 38px;
    margin: 0;
    box-sizing: border-box;
   
}
        </style> 

    </head>
    <body>   
        <style>
            .error-message {
  color: red;
  font-size: 0.85em;
  margin-top: 2px;
  position: relative; /* avoid pushing layout too much */
  min-height: 18px; /* reserve some space so layout doesn’t jump */
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
        <script>
            
            if (field.next(".error-message").length === 0) {
    field.after('<div class="error-message"></div>');
}
field.next(".error-message").text("This field is required");
            </script>
       
      
        <main class="d-flex align-items-end justify-content-end">
       <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
       <%@include file="/WEB-INF/jsp/Common/country.jsp"%>
            <section class="main-content">
                <form:form action="vendorInformation.htm?act=basicVendorInformation" id="myform" commandName="vendorInformation" enctype="multipart/form-data"  method="post">

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

                        <div class="cta d-flex align-items-center" style="gap:15px;">
                            <a onclick="window.location='vendorInformation.htm?act=vendorpolicy&id=${vendorInformation.vendorEmailId}'" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--<button type="submit" id="submit1" title="submit1" class="btn theme-btn">Save And Continue</button>-->
                            <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                <button type="submit" id="vendbasic1" class="btn theme-btn" formaction="vendorInformation.htm?act=vendorCriteriaShow" onclick="return Validate()">Next</button>                                
                            </c:if>
                        </div>
                    </div>

                    <hr>
          
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <c:if test="${vendorInformation.status1 == 3}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Rework from Buyer.</strong> <br>
                            </c:if>
                            <c:if test="${vendorInformation.status1 == 4}">
                                <strong>Note:</strong> <strong class="text-danger fs-15">Rework from Auditor. </strong><br>
                            </c:if>
                            <c:if test="${vendorInformation.status1 == 5}">
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
                    <input type="hidden" id="VInformationId" name="VInformationId" value="${vendorInformation.id}"/>
                    <br>
                    <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->
                        <thead>
                            <tr>
                                <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center;"><strong>VENDOR DETAILS</strong></td>
                            </tr>

                        </thead>
                        <tbody>
                            <tr>
                                <td><strong>Company Name :</strong></td>
                                <td  style="width: 20%;">
                                    <input type="text" name="companyName"  class="input-field" readonly="true" value="${vendorInformation.companyName}" required="required"/>
                                </td>                           
                                <td style=" "><strong>Email ID :</strong></td>
                                <td>
                                    <input type="email" name="vendorEmailId"  class="input-field" readonly="true" value="${vendorInformation.vendorEmailId}" required="required"/>
                                </td>    
                            </tr>
                            <tr>    
                                <td><strong>Year of Establishment of Company:</strong>
                                    <span class="text-danger">*</span>
                                </td>
                                <td>
                                    <input type="text" name="establishment" value="${vendorInformation.establishment}" name="establishment" class="input-field form_datetime" required="required"/>
                                </td>
              <script type="text/javascript">
            $(function () {
                const input = document.querySelector(".form_datetime");
                const fp = flatpickr(input, {
                    enableTime: false,
                    dateFormat: "m-Y",  
                    allowInput: true,
                    defaultDate: new Date(),
                    clickOpens: true,
                    defaultDate: input.value && input.value.trim() !== "" 
                                ? input.value 
                                : new Date(),
                    onChange: function(selectedDates, dateStr, instance) {
                        document.getElementById("selectedDateCell").innerText = dateStr;
                    }
                });

                document.getElementById("selectedDateCell").innerText = fp.input.value;
            });
            </script>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                                
                            
                            <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->
                       
                        <tbody>                            
                            <tr>
                                <td><strong>Type of Company : <span class="text-danger">*</span></strong></td>
                                <td  style=" width: 20%;">
                                    <select class="select-input" id="typeOfConcern" name="typeOfConcern" style="font-size: 12px; padding: 5px;" ${(vendorBuyerApproval.tocStatuss == 'accept' && vendorBuyerApproval.tocStatuss1 == 'accept') && vendorInformation.status1 == 3 ? 'disabled' : 'required'}>
                                        <option value="Sole Proprietorship" <c:if test="${vendorInformation.typeOfConcern == 'Sole Proprietorship'}">selected</c:if>>Sole Proprietorship</option>
                                        <option value="Hindu Undivided Family (HUF)" <c:if test="${vendorInformation.typeOfConcern == 'Hindu Undivided Family (HUF)'}">selected</c:if>>Hindu Undivided Family (HUF)</option>
                                        <option value="Partnership Firm" <c:if test="${vendorInformation.typeOfConcern == 'Partnership Firm'}">selected</c:if>>Partnership Firm</option>
                                        <option value="Limited Liability Partnership (LLP)" <c:if test="${vendorInformation.typeOfConcern == 'Limited Liability Partnership (LLP)'}">selected</c:if>>Limited Liability Partnership (LLP)</option>
                                        <option value="Private" <c:if test="${vendorInformation.typeOfConcern == 'Private'}">selected</c:if>>Private Company</option>
                                        <option value="Public Company" <c:if test="${vendorInformation.typeOfConcern == 'Public Company'}">selected</c:if>>Public Company</option>
                                        <option value="Free Lancer" <c:if test="${vendorInformation.typeOfConcern == 'Free Lancer'}">selected</c:if>>Free Lancer</option>
                                    </select>
                                    <c:if test="${vendorBuyerApproval.tocStatuss == 'accept'}">
                                        <input type="hidden" class="radio-inline" id="typeOfConcern" name="typeOfConcern" value="${vendorInformation.typeOfConcern}" />                                                    
                                    </c:if>
                                        
                                </td>
                                <script>
                                    document.addEventListener("DOMContentLoaded", function () {

                                        var proofData = {
                                            "Sole Proprietorship": [
                                                "Shop or Establishment License"
                                            ],
                                            "Hindu Undivided Family (HUF)": [
                                                "Shop or Establishment License and HUF Deed"
                                            ],
                                            "Partnership Firm": [
                                                "Shop or Establishment License and Partnership Deed"
                                            ],
                                            "Limited Liability Partnership (LLP)": [
                                                "Shop or Establishment License and LP Agreement"
                                            ],
                                            "Private": [
                                                "Certificate of Incorporation (MCA)"
                                            ],
                                            "Public Company": [
                                                "Certificate of Incorporation (MCA)"
                                            ],
                                            "Free Lancer": [
                                                "Professional Profile / Resume"
                                            ]
                                        };

                                        var typeSelect = document.getElementById("typeOfConcern");
                                        var proofList = document.getElementById("proofList");

                                        function loadProofs() {

                                            if (!typeSelect || !proofList) {
                                                return;
                                            }

                                            proofList.innerHTML = "";

                                            var selectedValue = typeSelect.value;

                                            if (proofData[selectedValue]) {

                                                proofData[selectedValue].forEach(function (proof) {
                                                    var li = document.createElement("li");
                                                    li.textContent = "⇒ " + proof;
                                                    proofList.appendChild(li);
                                                });

                                            }
                                        }

                                        typeSelect.addEventListener("change", loadProofs);

                                        loadProofs();
                                    });
                                </script>
                                <td>
                                    <strong class="control-label" id="proofLabel">Proof Of Attachment : <span class="text-danger">*</span></strong> 
                                    <ul id="proofList"></ul>
                                </td>
                                
                                <td><strong>Mandatory :</strong><br>                                
                                    <c:if test="${vendorInformation.companyProof!=null && not empty vendorInformation.companyProof}">
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation.companyProof}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.companyProof}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.companyProof}"><span class="fa fa-solid fa-eye"></span></a>

                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.companyProof}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                </c:if>
                                            </span>
                                        </span>
                                    </c:if>
                                    <input type="hidden" class="input-field" id="companyProof1" name="companyProof1" accept="" value="${vendorInformation.companyProof}">
                                    <c:choose>
                                        <c:when test="${vendorInformation.status1 == 3}">
                                            <c:if test="${vendorBuyerApproval.tocStatuss == 'reject'}">
                                                <input type="file" class="input-field"id="companyProof" name="companyProof" accept="" onchange="validateFileSize(this, 'fileErrorToc1');" required="required">                                                            
                                            </c:if>
                                        </c:when>                                                       
                                        <c:otherwise>
                                            <input type="file" class="input-field"id="companyProof" name="companyProof" accept="" onchange="validateFileSize(this, 'fileErrorToc1');"  <c:if test="${empty vendorInformation.companyProof}">required="required"</c:if> >                                                            
                                        </c:otherwise>
                                    </c:choose>
                                    <span id="fileErrorToc1" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span> 
                                    <br>
                                    <strong>Optional :</strong><br>   
                                    <c:if test="${vendorInformation.companyProof2!=null && not empty vendorInformation.companyProof2}">
                                        <span class="file-wrapper">
                                            <span class="file-name text-break">${vendorInformation.companyProof2}</span>
                                            <span class="file-actions">
                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.companyProof2}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.companyProof2}"><span class="fa fa-solid fa-eye"></span></a>

                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.companyProof2}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                </c:if>
                                            </span>
                                        </span>
                                    </c:if>
                                    <input type="hidden" class="input-field"  id="companyProof21" name="companyProof21" accept="" value="${vendorInformation.companyProof2}">
                                    <c:choose>
                                        <c:when test="${vendorInformation.status1 == 3}">
                                            <c:if test="${vendorBuyerApproval.tocStatuss1 == 'reject'}">
                                                <input type="file" style="margin-top:10px;" class="input-field"id="companyProof2" name="companyProof2" accept="" onchange="validateFileSize(this, 'fileErrorToc2');">                                                            
                                            </c:if>
                                        </c:when>                                                       
                                        <c:otherwise>
                                            <input type="file"  style="margin-top:10px;" class="input-field"id="companyProof2" name="companyProof2" accept="" onchange="validateFileSize(this, 'fileErrorToc2');">                                                            
                                        </c:otherwise>
                                    </c:choose>                                                            
                                    <span id="fileErrorToc2" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span> 
                                </td>
                                    
                                    <c:if test="${vendorInformation.status1 == 3}">
                                        <td colspan="2">                                                            
                                            <c:if test="${vendorBuyerApproval.tocStatuss == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.tocStatuss == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field" name="tocRemarkk" readonly rows="2" cols="30">${vendorBuyerApproval.tocRemarkk}</textarea>
                                                </div>
                                            </c:if> 
                                            <c:if test="${vendorBuyerApproval.tocStatuss == 'reject'}">
                                                <div>                                                            
                                                    <textarea class="textarea-field" name="tocResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.tocResponse}</textarea>
                                                </div>
                                            </c:if>
                                            <br>
                                            <c:if test="${vendorBuyerApproval.tocStatuss1 == 'accept'}">
                                                <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                            </c:if>
                                            <c:if test="${vendorBuyerApproval.tocStatuss1 == 'reject'}">
                                                <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                <div>
                                                    <textarea class="textarea-field" name="tocRemarkk1" readonly rows="2" cols="30">${vendorBuyerApproval.tocRemarkk1}</textarea>
                                                </div>
                                            </c:if> 
                                            <c:if test="${vendorBuyerApproval.tocStatuss1 == 'reject'}">
                                                <div>                                                            
                                                    <textarea class="textarea-field" name="tocResponse1" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.tocResponse1}</textarea>
                                                </div>
                                            </c:if>
                                        </td>
                                    </c:if>
                            </tr>
                            
                         
                        </tbody>
                    </table>
                   

                       
                 <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->
                         <thead>
                            <tr>
                                <td colspan="4" style=" background-color: skyblue; text-align: center;"><strong>REGISTER ADDRESS</strong></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>Street / House No : <span class="text-danger">*</span></th>
                                <td>
                                    <textarea class="textarea-field"  maxlength="100" id="officeAddressLine1" name="officeAddressLine1" required>${vendorInformation.officeAddressLine1}</textarea>
                                </td>
                                <th>Street 1: <span class="text-danger">*</span></th>
                                <td>
                                    <textarea class="textarea-field"  maxlength="100" id="officeAddressLine2" name="officeAddressLine2" required>${vendorInformation.officeAddressLine2}</textarea>
                                </td>
                            </tr>
                            
                            <tr>
                                <th>Street 2:</th>
                                <td>
                                    <textarea class="textarea-field"   maxlength="100" id="officeAddressLine3" name="officeAddressLine3">${vendorInformation.officeAddressLine3}</textarea>
                                </td>
                                <th>Postal Code :<span class="text-danger">*</span></th>
                                <td> <form:input path="officePin" id="officePin" class="input-field" maxlength="6" required="required" pattern="[0-9]{6}" inputmode="numeric"  oninput="this.value=this.value.replace(/[^0-9]/g,'');"/></td>
                            </tr>
                            <script>
                                document.addEventListener("DOMContentLoaded", function () {

                                    const pinInput = document.getElementById("officePin");
                                    const cityInput = document.getElementById("officeCity");
                                    const districtInput = document.getElementById("officeDistrict");
                                    const stateInput = document.getElementById("officeState");
                                    const countryInput = document.getElementById("officeCountry");

                                    pinInput.addEventListener("blur", function () {
                                        const pincode = pinInput.value.trim();

                                        if (/^[1-9][0-9]{5}$/.test(pincode)) {

                                            fetch("https://api.postalpincode.in/pincode/" + pincode)
                                                .then(response => response.json())
                                                .then(data => {

                                                    if (data[0].Status === "Success") {
                                                        const postOffice = data[0].PostOffice[0];

                                                        cityInput.value = postOffice.Block || postOffice.Name;
                                                        districtInput.value = postOffice.District;
                                                        stateInput.value = postOffice.State;
                                                        countryInput.value = postOffice.Country;

                                                    } else {
                                                        Swal.fire({
                                                icon: 'warning',
                                                title: 'Failed',
                                                text: 'Invalid PIN Code'
                                              });
                                                        cityInput.value = "";
                                                        districtInput.value = "";
                                                        stateInput.value = "";
                                                        countryInput.value = "";
                                                    }
                                                })
                                                .catch(error => {
                                                    console.error("Error fetching PIN details:", error);
                                            Swal.fire({
                                                icon: 'warning',
                                                title: 'Failed',
                                                text: 'Unable to fetch details. Try again.'
                                              });
                                                });

                                        } else {
                                            Swal.fire({
                                                icon: 'warning',
                                                title: 'Failed',
                                                text: 'Please enter a valid 6-digit Indian PIN code'
                                              });
                                           
                                            cityInput.value = "";
                                            districtInput.value = "";
                                            stateInput.value = "";
                                            countryInput.value = "";
                                        }
                                    });

                                });
                            </script>
                            <tr>
                                <th>City :<span class="text-danger">*</span></th>
                                <td>
                                    <form:input id="officeCity" path="officeCity" class="input-field" required="required" placeholder="Enter city"/>
                                </td>
                                <th>District :<span class="text-danger">*</span></th>
                                <td>
                                    <form:input id="officeDistrict" path="officeDistrict" class="input-field" required="true" placeholder="Enter District"/>
                                </td>
                            </tr>
                            
                            <tr>
                                <th>State :<span class="text-danger">*</span> </th>
                                <td> 
                                    <form:input id="officeState" path="officeState" class="input-field" required="true" readonly="true" placeholder=" State"/>
                                    
                                    <%--<input type="hidden" value="${vendorInformation.officeState}" name="officeState1" id="officeState1">

                                    <form:select id="stateDropdown" name="state" path="officeState" class="select-input" required="required">
                                        <form:option value="">Select a state</form:option>
                                    </form:select>--%>
                                </td>
                                <th> Country : <span class="text-danger">*</span></th>
                                <td> 
                                    <form:input id="officeCountry" path="officeCountry" class="input-field" required="true" readonly="true" placeholder=" Country"/>
                                    
                                    <%--<input type="hidden" value="${vendorInformation.officeCountry}" name="officeCountry1" id="officeCountry1">

                                    <form:select id="countryDropdown" name="country" path="officeCountry" class="select-input" required="required">
                                        <form:option value="INDIA">INDIA</form:option>
                                    </form:select>--%>
                                </td>                                        
                            </tr>
                            
                            <tr>
                                <th>Mobile No :<span class="text-danger">*</span></th>
                                <td>
                                    <div class="phone-wrapper">
                                        <select name="countryCodeoffTele" id="countryCodeoffTele" class="select-input">
                                            <c:forEach var="cc" items="${countryCode}">
                                                <c:choose>
                                                    <c:when test="${cc.countryCode eq countryCodeOffTel}">
                                                        <option value="${cc.countryCode}" selected="selected">
                                                            +${cc.countryCode}
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${cc.countryCode}">
                                                            + ${cc.countryCode}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>

                                        <input name="officeTelephone" id="officeTelephone" onchange="checkMobile()" value="${vendorInvitation.vendorContactNo}" placeholder="Ex: 9876543210" type="text" id="officeTelephone" class="input-field" minlength="10" maxlength="10" pattern="^\d{10,}$" required="required" inputmode="numeric" oninput="this.value = this.value.replace(/\D/g,'')" />
                                    </div>
                                    <div id="mobileError" style="color:red;"></div>
                                </td>
                                <th>Email: <span class="text-danger">*</span></th>
                               <td>                                    
                                <form:input    path="officeEmail"    id="officeEmail"    placeholder="Ex: abc@gmail.com"    type="text" class="input-field email-field" required="required" style="text-transform: lowercase;" /> 
                                <span id="emailError1" style="color:red;font-size:12px;margin-top:3px;"></span>
                                </td>
                            
                            <tr>
                                <th>Website :</th>
                                <td> <form:input path="officeWebsite" id="officeWebsite" class="input-field"/></td>
                                <th></th>
                                <td></td>
                            </tr>

                        </tbody>                        
                        
                        <thead>
                            <tr>
                                <td colspan="4" style=" background-color: skyblue; text-align: center;"><strong>COMMUNICATION ADDRESS</strong></td>
                            </tr>

                        </thead>
                        <tbody>
                            <tr>
                                <th> Same As Register Address :</th>
                                <td colspan="3"><input type="checkbox" onchange="copyAddress(this);" /></td>
                            </tr>
                            <script>
                                function copyAddress(checkbox) {
                                let officeAddressLine1 = document.getElementById("officeAddressLine1").value.toUpperCase();
                                        let officeAddressLine2 = document.getElementById("officeAddressLine2").value.toUpperCase();
                                        let officeAddressLine3 = document.getElementById("officeAddressLine3").value.toUpperCase();
                                        let officeCity = document.getElementById("officeCity").value.toUpperCase();
                                        let officeDistrict = document.getElementById("officeDistrict").value.toUpperCase();
                                        let countryDropdown = document.getElementById("officeCountry").value.toUpperCase();
                                        let officeState1 = document.getElementById("officeState").value.toUpperCase();
                                        let officePin = document.getElementById("officePin").value.toUpperCase();
                                        let officeTelephone = document.getElementById("officeTelephone").value.toUpperCase();
                                        let officeEmail = document.getElementById("officeEmail").value.toUpperCase();
                                        let officeWebsite = document.getElementById("officeWebsite").value.toUpperCase();
                                        let altLocalAddress = document.getElementById("altLocalAddress");
                                        let altLocalAddress1 = document.getElementById("altLocalAddress1");
                                        let altLocalAddress2 = document.getElementById("altLocalAddress2");
                                        let altCity = document.getElementById("altCity");
                                        let altDistrict = document.getElementById("altDistrict");
                                        let altState = document.getElementById("altState");
                                        let altCountry = document.getElementById("altCountry");
                                        let altPostalCode = document.getElementById("altPostalCode");
                                        let altTelephone = document.getElementById("altTelephone");
                                        let altWebsite = document.getElementById("altWebsite");
                                        if (checkbox.checked) {
                                altLocalAddress.value = officeAddressLine1;
                                        altLocalAddress1.value = officeAddressLine2;
                                        altLocalAddress2.value = officeAddressLine3;
                                        altCity.value = officeCity;
                                        altDistrict.value = officeDistrict;
                                        altState.value = officeState1;
                                        altCountry.value = countryDropdown;
                                        altPostalCode.value = officePin;
                                        altTelephone.value = officeTelephone;
                                        altWebsite.value = officeWebsite;
                                        altEmail.value = officeEmail;
                                } else {
                                altLocalAddress.value = "";
                                        altLocalAddress1.value = "";
                                        altLocalAddress2.value = "";
                                        altCity.value = "";
                                        altDistrict.value = "";
                                        altState.value = "";
                                        altCountry.value = "";
                                        altPostalCode.value = "";
                                        altTelephone.value = "";
                                        altWebsite.value = "";
                                }
                                }
                            </script>
                            <script>
                                    function checkMobile() {
                                        var mobile = document.getElementById("officeTelephone").value;
                                        var error = document.getElementById("mobileError");
                                        var input = document.getElementById("officeTelephone");

                                        if (mobile.length != 10) {
                                            error.innerText = "Mobile number must be 10 digits";
                                            input.style.border = "1px solid red";
                                        } else {
                                            error.innerText = "";
                                            input.style.border = "1px solid #ccc";
                                        }
                                    }

                                    function validateMobile() {
                                        var mobile = document.getElementById("officeTelephone").value;

                                        if (mobile.length != 10) {
                                            checkMobile();
                                            return false;
                                        }
                                        return true;
                                    }
                                </script>
                            
                                  <script>
                        document.addEventListener("DOMContentLoaded", function () {

                            const emailInput = document.getElementById("officeEmail");
                            const emailError = document.getElementById("emailError1");

                            function validateEmail() {
                                const email = emailInput.value.trim().toLowerCase();
                                const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

                                if (email === "") {
                                    emailError.innerHTML = "Email is required";
                                    emailInput.style.border = "1px solid red";
                                    return false;
                                } 
                                else if (!pattern.test(email)) {
                                    emailError.innerHTML = "Enter valid email (example: abc@gmail.com)";
                                    emailInput.style.border = "1px solid red";
                                    return false;
                                } 
                                else {
                                    emailError.innerHTML = "";
                                    emailInput.style.border = "1px solid #ced4da";
                                    return true;
                                }
                            }

                            emailInput.addEventListener("blur", validateEmail);
                            emailInput.addEventListener("input", validateEmail);

                        });
                        </script>
                                
                                
                            
                                    
                            <tr>
                                <th>Street / House No : <span class="text-danger">*</span></th>
                                <td><textarea class="textarea-field"   maxlength="100" id="altLocalAddress" name="altLocalAddress" required>${declaration.altLocalAddress}</textarea></td>
                                <th>Street 1: <span class="text-danger">*</span></th>
                                <td><textarea class="textarea-field"   maxlength="100" id="altLocalAddress1" name="altLocalAddress1" required>${declaration.altLocalAddress1}</textarea></td>
                            </tr>
                            <tr>
                                <th>Street 2:</th>
                                <td><textarea class="textarea-field"   maxlength="100" id="altLocalAddress2" name="altLocalAddress2">${declaration.altLocalAddress2}</textarea></td>
                                <th>Postal Code :  <span class="text-danger">*</span> </th>
                                <td> <input class="input-field" name="altPostalCode" required="true" id="altPostalCode" value="${not empty declaration.altPostalCode ? declaration.altPostalCode : ''}" maxlength="6" pattern="[0-9]{6}" inputmode="numeric"  oninput="this.value=this.value.replace(/[^0-9]/g,'');"/> </td>
                            </tr>
                             <script>
                                document.addEventListener("DOMContentLoaded", function () {

                                    const pinInput = document.getElementById("altPostalCode");
                                    const cityInput = document.getElementById("altCity");
                                    const districtInput = document.getElementById("altDistrict");
                                    const stateInput = document.getElementById("altState");
                                    const countryInput = document.getElementById("altCountry");

                                    pinInput.addEventListener("blur", function () {
                                        const pincode = pinInput.value.trim();

                                        if (/^[1-9][0-9]{5}$/.test(pincode)) {

                                            fetch("https://api.postalpincode.in/pincode/" + pincode)
                                                .then(response => response.json())
                                                .then(data => {

                                                    if (data[0].Status === "Success") {
                                                        const postOffice = data[0].PostOffice[0];

                                                        cityInput.value = postOffice.Block || postOffice.Name;
                                                        districtInput.value = postOffice.District;
                                                        stateInput.value = postOffice.State;
                                                        countryInput.value = postOffice.Country;

                                                    } else {
                                                         Swal.fire({
                                                icon: 'warning',
                                                title: 'Failed',
                                                text: 'Invalid PIN Code'
                                              });
                                                        
                                                        cityInput.value = "";
                                                        districtInput.value = "";
                                                        countryInput.value = "";
                                                    }
                                                })
                                                .catch(error => {
                                                    console.error("Error fetching PIN details:", error);
                                            
                                            Swal.fire({
                                                icon: 'warning',
                                                title: 'Failed',
                                                text: 'Unable to fetch details. Try again.'
                                              });
                                                    
                                                });

                                        } else {
                                            
                                            Swal.fire({
                                                icon: 'warning',
                                                title: 'Failed',
                                                text: 'Please enter a valid 6-digit Indian PIN code'
                                              });

                                            cityInput.value = "";
                                            districtInput.value = "";
                                            stateInput.value = "";
                                            countryInput.value = "";
                                        }
                                    });

                                });
                            </script>
                            <tr>
                                <th>City : <span class="text-danger">*</span></th>
                                <td><input class="input-field" id="altCity" name="altCity" required="true" value="${not empty declaration.altCity ? declaration.altCity : ''}"/> </td>
                                <th>District : <span class="text-danger">*</span></th>
                                <td> <input class="input-field" id="altDistrict" name="altDistrict" required="true" value="${not empty declaration.altDistrict ? declaration.altDistrict : ''}"/> </td>
                            </tr>

                            <tr>
                                <th>Country : <span class="text-danger">*</span> </th>
                                <td> <input class="input-field" required="true" id="altCountry" readonly="true" name="altCountry" value="${not empty declaration.altCountry ? declaration.altCountry : ''}"/></td>
                                <th>State : <span class="text-danger">*</span></th>
                                <td> <input class="input-field" name="altState" id="altState" readonly="true" required="true" value="${not empty declaration.altState ? declaration.altState : ''}"/></td>
                            </tr>
                            <tr>
                                <th>Mobile No : <span class="text-danger">*</span></th>
                                <td> 
                                    <div class="phone-wrapper">
                                        <select name="countryCodeNewMobiles" id="countryCodeNewMobiles" class="select-input">
                                            <c:forEach var="cc" items="${countryCode}">
                                                <c:choose>
                                                    <c:when test="${cc.countryCode eq countryCodeNewMobiles}">
                                                        <option value="${cc.countryCode}" selected="selected">
                                                            +${cc.countryCode}
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${cc.countryCode}">
                                                            + ${cc.countryCode}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>   
                                        <input class="input-field" name="altTelephone" onchange="checkMobileAlt();" required="true" id="altTelephone" minlength="10" maxlength="10"  pattern="^\d{10,}$"    inputmode="numeric" oninput="this.value = this.value.replace(/\D/g,'')" onchange="checkMobile()" value="${not empty declaration.altTelephone ? declaration.altTelephone : ''}"/>
                                    </div>
                                    <span id="altMobileError" style="color:red;"></span>
                                </td>
                                <th>Email: <span class="text-danger">*</span> </th>
                                <td> <input class="input-field email-field" type="email" onchange="checkAltEmail();" required="true" name="altEmail" id="altEmail" style="text-transform: lowercase;"
                                            value="${not empty declaration.altEmail ? declaration.altEmail : ''}"/>
                                <span id="altEmailError" style="color:red;"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>Website: </th>
                                <td> <input class="input-field" name="altWebsite" id="altWebsite"
                                            value="${not empty declaration.altWebsite ? declaration.altWebsite : ''}"/></td>
                            </tr>
                        </tbody>
                    </table>
                              <script>
                                            function checkMobileAlt() {
                                                var mobile = document.getElementById("altTelephone").value;
                                                var error = document.getElementById("altMobileError");
                                                var input = document.getElementById("altTelephone");

                                                if (mobile.length < 10) {
                                                    error.innerText = "Mobile number must be 10 digits";
                                                    input.style.border = "1px solid red";
                                                } else {
                                                    error.innerText = "";
                                                    input.style.border = "1px solid #ccc";
                                                }
                                            }
                                            </script>
                                            <script>
                        function checkAltEmail() {

                            var email = document.getElementById("altEmail").value.trim().toLowerCase();
                            var error = document.getElementById("altEmailError");
                            var input = document.getElementById("altEmail");

                            // general email regex
                            var emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;

                            if (!emailPattern.test(email)) {
                                error.innerText = "Enter valid email (example: abc@gmail.com)";
                                input.style.border = "1px solid red";
                            } else {
                                error.innerText = "";
                                input.style.border = "1px solid #ccc";
                            }
                        }
                    </script>
                            
                            
                            
                            
            
                                <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed;">
                                <thead>
                                    <tr>
                                        <th colspan="5" style=" background-color: skyblue; text-align: center;">
                                            VENDOR CONTACT
                                        </th>
                                    </tr>
                                    <tr>
                                        <th> </th>
                                        <th>Name</th>
                                        <th>Designation</th>
                                        <th>Phone No.</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><strong>Sales/Commercial Contact(s) :<span class="text-danger">*</span></strong></td>
                                    <td><input type="text" name="sales_name" class="input-field" value="${vendorInformation.sales_name}" required="required"/></td>
                                    <td><input type="text" name="sales_job" class="input-field" value="${vendorInformation.sales_job}" required="required"/></td>
                                    <td style="padding-left:7px;">
                                        <div class="phone-wrapper">
                                            <select  name="countryCodeVendorContact" id="countryCodeVendorContact" class="select-input">
                                            <c:forEach var="cc" items="${countryCode}">
                                                <c:choose>
                                                    <c:when test="${cc.countryCode eq countryCodeVendorContact}">
                                                        <option value="${cc.countryCode}" selected="selected">
                                                            +${cc.countryCode}
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${cc.countryCode}">
                                                            + ${cc.countryCode}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>    
                                        
                                            <input type="text" name="sales_phone" class="input-field" id="sales_phone" onchange="checkSalesPhone()" placeholder="Ex: 9876543210"  minlength="10"  maxlength="10"  pattern="^\d{10,}$" inputmode="numeric"   oninput="this.value = this.value.replace(/\D/g,'')" value="${vendorInformation.sales_phone}" required="required"/>
                                        </div>
                                        <span id="salesPhoneError" style="color:red; "></span>
                                    </td>
                                    <td><input type="email" name="saleEmail" class="input-field email-field" id="saleEmail" onchange=" checkSaleEmail()" placeholder="Ex: abc@gmail.com" value="${vendorInformation.saleEmail}" required="required"/>
                                    <span id="saleEmailError" style="color:red; "></span>
                                    </td>
                                </tr>
                                
                                <script>
                                    function checkSaleEmail() {

                                        var email = document.getElementById("saleEmail").value.trim().toLowerCase();
                                        var error = document.getElementById("saleEmailError");
                                        var input = document.getElementById("saleEmail");

                                        var emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;

                                        if (!emailPattern.test(email)) {
                                            error.innerText = "Enter valid email (example: abc@gmail.com)";
                                            input.style.border = "1px solid red";
                                        } else {
                                            error.innerText = "";
                                            input.style.border = "1px solid #ccc";
                                        }
                                    }
                                    </script>
                                <script>
                                        function checkSalesPhone() {
                                            var phone = document.getElementById("sales_phone").value;
                                            var error = document.getElementById("salesPhoneError");
                                            var input = document.getElementById("sales_phone");

                                            if (phone.length < 10) {
                                                error.innerText = "Phone number must be 10 digits";
                                                input.style.border = "1px solid red";
                                            } else {
                                                error.innerText = "";
                                                input.style.border = "1px solid #ccc";
                                            }
                                        }
                                        </script>
                                
                                
                                
                                        <script>
                                                    document.addEventListener("DOMContentLoaded", function() {
                                                    const input = document.getElementById('sales_name');
                                                            input.addEventListener('input', function() {
                                                            // Replace everything except letters and spaces
                                                            this.value = this.value.replace(/[^A-Za-z\s]/g, '');
                                                            });
                                                    });
                                       </script>
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const input = document.getElementById('sales_job');
                                                                    input.addEventListener('input', function() {
                                                                    // Replace everything except letters and spaces
                                                                    this.value = this.value.replace(/[^A-Za-z\s]/g, '');
                                                                    });
                                                            });
                                         </script>
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const phoneInput = document.getElementById('sales_phone');
                                                                    phoneInput.addEventListener('input', function() {
                                                                    // Remove anything that's not a digit
                                                                    this.value = this.value.replace(/[^0-9]/g, '');
                                                                    });
                                                            });
                                   </script>
                                   
                              <tr>
                                <td><strong>Technical Contact(s) :<span class="text-danger">*</span></strong></td>
                                <td><input type="text" name="technical_name" class="input-field" value="${vendorInformation.technical_name}" required="required"/></td>
                                <td><input type="text" name="technical_job" class="input-field" value="${vendorInformation.technical_job}" required="required"/></td>
                                <td  style="padding-left:7px;"> 
                                    <div class="phone-wrapper">
                                           
                                        
                                        <select name="countryCodeVendorContact1" id="countryCodeVendorContact1" class="select-input">
                                            <c:forEach var="cc" items="${countryCode}">
                                                <c:choose>
                                                    <c:when test="${cc.countryCode eq countryCodeVendorContact1}">
                                                        <option value="${cc.countryCode}" selected="selected">
                                                            +${cc.countryCode}
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${cc.countryCode}">
                                                            + ${cc.countryCode}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                        
                                        
                                        
                                        <input type="text" name="technical_phone" onchange="checkTechnicalPhone(this)" placeholder="Ex: 9876543210" class="input-field" minlength="10"  maxlength="10"  pattern="^\d{10,}$" inputmode="numeric"   oninput="this.value = this.value.replace(/\D/g,'')" value="${vendorInformation.technical_phone}" required="required"/>
                                    </div>
                                    <span id="technicalPhoneError" style="color:red;"></span>
                                </td>
                                <td><input type="email" name="technicalContactEmail" id="technicalContactEmail" onchange="checkTechnicalEmail()" placeholder="Ex: abc@gmail.com" class="input-field email-field" value="${vendorInformation.technicalContactEmail}" required="required"/>
                                 <span id="technicalEmailError" style="color:red;"></span>
                                </td>
                            </tr>
                            
                              <script>
                        function checkTechnicalEmail() {

                            var email = document.getElementById("technicalContactEmail").value.trim().toLowerCase();
                            var error = document.getElementById("technicalEmailError");
                            var input = document.getElementById("technicalContactEmail");

                            var emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;

                            if (!emailPattern.test(email)) {
                                error.innerText = "Enter valid email (example: abc@gmail.com)";
                                input.style.border = "1px solid red";
                            } else {
                                error.innerText = "";
                                input.style.border = "1px solid #ccc";
                            }
                        }
                        </script>
                            <script>
                                            function checkTechnicalPhone(input) {

                                                var phone = input.value;
                                                var error = document.getElementById("technicalPhoneError");

                                                if (phone.length < 10) {
                                                    error.innerText = "Phone number must be 10 digits";
                                                    input.style.border = "1px solid red";
                                                } else {
                                                    error.innerText = "";
                                                    input.style.border = "1px solid #ccc";
                                                }
                                            }
                            </script>
                            
                            
                            
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const input = document.getElementById('technical_name');
                                                                    input.addEventListener('input', function() {
                                                                    // Replace everything except letters and spaces
                                                                    this.value = this.value.replace(/[^A-Za-z\s]/g, '');
                                                                    });
                                                            });</script>
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const input = document.getElementById('technical_job');
                                                                    input.addEventListener('input', function() {
                                                                    // Replace everything except letters and spaces
                                                                    this.value = this.value.replace(/[^A-Za-z\s]/g, '');
                                                                    });
                                                            });</script>
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const phoneInput = document.getElementById('technical_phone');
                                                                    phoneInput.addEventListener('input', function() {
                                                                    // Remove anything that's not a digit
                                                                    this.value = this.value.replace(/[^0-9]/g, '');
                                                                    });
                                                            });</script>
                                        
                              <tr>
                                <td><strong>Finance and Accounts : <span class="text-danger">*</span></strong></td>
                                <td><input type="text" name="quality_name" class="input-field" value="${vendorInformation.quality_name}" required="required"/></td>
                                <td><input type="text" name="quality_job" class="input-field" value="${vendorInformation.quality_job}" required="required"/></td>
                                <td  style="padding-left:7px;">
                                    <div class="phone-wrapper" style="margin:0;">
                                        
                                        
                                        <select name="countryCodeVendorContact2" id="countryCodeVendorContact2" class="select-input">
                                            <c:forEach var="cc" items="${countryCode}">
                                                <c:choose>
                                                    <c:when test="${cc.countryCode eq countryCodeVendorContact2}">
                                                        <option value="${cc.countryCode}" selected="selected">
                                                            +${cc.countryCode}
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${cc.countryCode}">
                                                            + ${cc.countryCode}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>    
                                      
                                           
                                        <input type="text" name="quality_phone" id="quality_phone" onchange="checkQualityPhone()"  placeholder="Ex: 9876543210" class="input-field" minlength="10"  maxlength="10"  pattern="^\d{10,}$" inputmode="numeric"   oninput="this.value = this.value.replace(/\D/g,'')" value="${vendorInformation.quality_phone}" required="required"/>
                                    </div>
                                    <span id="qualityPhoneError" style="color:red;"></span>
                                </td>
                                <td><input type="email" name="qualityEmail" id="qualityEmail" onchange="checkQualityEmail()" placeholder="Ex: abc@gmail.com" class="input-field email-field" value="${vendorInformation.qualityEmail}" required="required"/>
                                <span id="qualityEmailError" style="color:red;"></span>
                                </td>
                            </tr>
                            
                            <script>
                            function checkQualityEmail() {

                                var email = document.getElementById("qualityEmail").value.trim().toLowerCase();
                                var error = document.getElementById("qualityEmailError");
                                var input = document.getElementById("qualityEmail");

                                var emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;

                                if (!emailPattern.test(email)) {
                                    error.innerText = "Enter valid email (example: abc@gmail.com)";
                                    input.style.border = "1px solid red";
                                } else {
                                    error.innerText = "";
                                    input.style.border = "1px solid #ccc";
                                }
                            }
                            </script>
                            <script>
                                    function checkQualityPhone() {

                                        var phone = document.getElementById("quality_phone").value;
                                        var error = document.getElementById("qualityPhoneError");
                                        var input = document.getElementById("quality_phone");

                                        if (phone.length < 10) {
                                            error.innerText = "Phone number must be 10 digits";
                                            input.style.border = "1px solid red";
                                        } else {
                                            error.innerText = "";
                                            input.style.border = "1px solid #ccc";
                                        }
                                    }
                            </script>
                            
                            
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const input = document.getElementById('quality_name');
                                                                    input.addEventListener('input', function() {
                                                                    // Replace everything except letters and spaces
                                                                    this.value = this.value.replace(/[^A-Za-z\s]/g, '');
                                                                    });
                                                            });</script>
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const input = document.getElementById('quality_job');
                                                                    input.addEventListener('input', function() {
                                                                    // Replace everything except letters and spaces
                                                                    this.value = this.value.replace(/[^A-Za-z\s]/g, '');
                                                                    });
                                                            });</script>
                                        <script>
                                                            document.addEventListener("DOMContentLoaded", function() {
                                                            const phoneInput = document.getElementById('quality_phone');
                                                                    phoneInput.addEventListener('input', function() {
                                                                    // Remove anything that's not a digit
                                                                    this.value = this.value.replace(/[^0-9]/g, '');
                                                                    });
                                                            });</script>
                                    </tbody>
                                </table>
                            <style>
                                .phone-wrapper {
                                display: flex;
                                gap: 6px;
                                width: 100%;
                            }

                            .phone-wrapper .col-sm-4 {
                                flex: 0 0 30%;   /* your custom width */
                                max-width: 30%;
                                padding: 0;
                            }

                            .phone-wrapper .col-sm-8 {
                                flex: 0 0 63%;   /* remaining width */
                                max-width: 63%;
                                padding: 0;
                            }

                            .phone-wrapper .select-input,
                            .phone-wrapper .input-field {
                                width: 70%;
                                height: 38px;
                            }


                            </style>
                            
                            
                            
                            
                                <table class="table table-bordered custom-table mb-3" id="policyTable" style="width:100%;  ">
                                    <thead>
                                        <tr>
                                            <th id="policyTableHeader" colspan="6" style=" text-align: center; background-color: skyblue"><strong>MANAGERIAL PERSON DETAILS</strong></th>
                                        </tr>

                                        <tr>
                                            <th>Name<span class="text-danger">*</span></th>
                                            <th>Designation<span class="text-danger">*</span></th>
                                            <th>phone No<span class="text-danger">*</span></th>
                                            <th>Email<span class="text-danger">*</span></th>                                                   
                                            <th>Action</th>
                                        </tr>
                                        <c:forEach var="mplist" items="${managerialPersonList}">
                                            <tr>
                                        <input type="hidden" name="mpId" value="${mplist.id}"/>
                                        <td>${mplist.name}</td> 
                                        <td>${mplist.designation}</td> 
                                        <td>+${mplist.countryCode}-${mplist.phoneNo}</td> 
                                        <td style=" max-width: 200px; word-break: break-all;  overflow-wrap: break-word;white-space: normal">${mplist.emailId}</td> 
                                        <td>                                                        
                                            <div class="text-center">
                                                <a href="vendorInformation.htm?act=deleteManagerialPerson&id=${mplist.id}&id1=${vendorInformation.vendorInvitationId}&companyName=${vendorInformation.companyName}&vendorEmailId=${vendorInformation.vendorEmailId}" class="d-inline-block text-danger p-1 mx-1" data-toggle="tooltip" data-placement="left" title="Delete">
                                                    <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 22px; height: 22px;"/>
                                                </a>                     
                                            </div>                                                            
                                        </td>
                                        </tr>
                                    </c:forEach>
                                    </thead>

                                    <tbody id="policyBody">
                                        <tr id="policyRowNew">
                                            <td><input type="text" placeholder="Name" class="input-field" id="mNameNew" name="mName"/> </td> 
                                            <td><input type="text" class="input-field" name="designation" id="designationNew" placeholder="Designation"/> </td> 
                                            <td>
                                               <div class="phone-wrapper">
                                                    
                                                        <select name="countryCode" id="countryCodeNew" class="select-input" style="width:100%;">
                                                            <c:forEach var="cc" items="${countryCode}">
                                                                <option value="${cc.countryCode}"
                                                                        <c:if test="${cc.countryName eq 'india'}">selected="selected"</c:if>>
                                                                    + ${cc.countryCode}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    
                                                        <input type="text" class="input-field" name="phoneNo" onchange="checkPhone(this)" minlength="10"  maxlength="10"  pattern="^\d{10,}$" inputmode="numeric"   oninput="this.value = this.value.replace(/\D/g,'')" id="phoneNoNew" placeholder="Phone No" style="width:100%;" />
                                                        <span class="phoneError" style="color:red;"></span>
                                                    
                                                </div>
                                            </td>
                                            <td><input type="email"  class="input-field email-field"  onchange="checkEmail(this)" name="emailId" id="emailIdNew" placeholder="Email Id"/>
                                                <span class="emailError" style="color:red;font-size:12px;display:block;"></span> 
                                            </td>  
                                            <td style=" text-align: center">
                                                <div class="d-flex justify-content-center align-items-center">
                                                    <div class="clone-action clone-new-field d-flex justify-content-center align-items-center mb-2" id="policyClonemanger" style="cursor:pointer;">
                                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                                    </div>
                                                </div>
                                            </td>      
                                        </tr>
                                    </tbody>
                                    <c:if test="${empty managerialPersonList}">
                                        <script>
                                                            $(document).ready(function() {
                                                    $("#policyRowNew").show();
                                                    });</script>
                                        </c:if>
                                </table>
                            
    <script>
                $(function () {
                    var tempCount3 = $("#policyTable tr[id^='policyRow']").length || 1;
                    var countryCodeOptions = $("select[name='countryCode']").first().html();

                    // ✅ Add new row dynamically
                    $(document).on("click", "#policyClonemanger", function () {
                        tempCount3++;

                        var clone = "<tr id='policyRow" + tempCount3 + "'>" 
                        +"<input type='hidden' name='mpId' value=''/>" 
                        + "<td style=''><input type='text' class='input-field' name='mName' id='mName" + tempCount3 + "' placeholder='Name'/></td>" 
                        +"<td style=''><input type='text' class='input-field' name='designation' id='designation" + tempCount3 + "' placeholder='Designation'/></td>" 
                        +"<td style=''><div class='phone-wrapper'>" 
                        +"<select name='countryCode' id='countryCode" + tempCount3 + "' class='select-input'>" + countryCodeOptions + "</select>"
                        +"<input type='text' class='input-field' name='phoneNo' minlength='10' maxlength='10'"
                        +" pattern='^\\d{10}$' inputmode='numeric'"
                        +" oninput='this.value=this.value.replace(/\\D/g,\"\")'"
                        +" onchange='checkPhone(this)' placeholder='Phone No' style='width:100%;'>"
                        +"<span class='phoneError' style='color:red;font-size:12px;display:block;margin-top:2px;'></span>"
                        +"</div>"
                        + "</td>" 
                        +"<td style='text-align:center; vertical-align:middle;'>"
                        +"<input type='email' class='input-field email-field'"
                        +" name='emailId' id='emailId" + tempCount3 + "'"
                        +" placeholder='Email Id'"
                        +" onchange='checkEmail(this)'"
                        +" style='text-transform: lowercase;'>"
                        +"<span class='emailError' style='color:red; font-size:12px; display:block;'></span>"
                        +"</td>"
                        +"<td style=' text-align: center; vertical-align: middle;'>" 
                        +"<span style='margin-top: 5px; display: inline-block;'>" 
                        +"<div class='clone-action delete-parent-field removeRowBtn' title='Remove' style='cursor: pointer; display:inline-flex; align-items: center; justify-content: center;'>" 
                        + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove' style='width: 300%;'>" 
                        +"</div>" 
                        +"</span>"
                        + "</td>" 
                        +"</tr>";

                        $("#policyTable").append(clone);
                        $('#policyTable .select-input').selectpicker('refresh');
                        $("#policyCount").val(tempCount3);
                    });

                    // ✅ Remove row
                    $(document).on("click", ".removeRowBtn", function () {
                        $(this).closest("tr").remove();
                        updatePolicyCount();
                    });

                    function updatePolicyCount() {
                        var totalRows = $("#policyTable tr[id^='policyRow']").length;
                        $("#policyCount").val(totalRows);
                    }
                });
                </script>

  <script>
                        function checkEmail(input){

                            var email = input.value.trim().toLowerCase();
                            var error = input.parentElement.querySelector(".emailError");

                            var pattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;

                            if(email !== "" && !pattern.test(email)){
                                error.innerHTML = "Enter valid email (example: abc@gmail.com)";
                                input.style.border = "1px solid red";
                            }else{
                                error.innerHTML = "";
                                input.style.border = "1px solid #ccc";
                            }
                        }
                        </script>
                          <script>
                            function checkPhone(input){

                                var phone = input.value;
                                var error = input.parentElement.querySelector(".phoneError");

                                if(phone.length != 10){
                                    error.innerText = "Phone number must be 10 digits";
                                    input.style.border = "1px solid red";
                                }else{
                                    error.innerText = "";
                                    input.style.border = "1px solid #ccc";
                                }
                            }
                            </script>     
                                    
                                    
                              

                                   


                            <div style="overflow-x:auto; width:100%;">                             
                                <table class="table table-bordered custom-table dt-scroll mb-3" id="policyTable9" style="width: 120%">
                                    <thead>
                                        <tr>
                                            <th id="policyTableHeader" colspan="${vendorInformation.status1 == 3 ? '8' : '7'}" style=" text-align: center; background-color: skyblue"><strong>PAST WORKING EXPERIENCE DETAILS(MINIMUM 3 REQUIRED)</strong></th>
                                        </tr>
                                    </thead>                                                 
                                    <tr>
                                        <th>Company Name<span class="text-danger">*</span></th>
                                        <th>Contact Person Name<span class="text-danger">*</span></th>
                                        <th style="min-width:300px;">phone No<span class="text-danger">*</span></th>
                                        <th>Email<span class="text-danger">*</span></th>
                                        <th>Designation<span class="text-danger">*</span></th>
                                        <th>UnPriced PO / Work Complition Certificate <span class="text-danger">*</span></th>
                                        <c:if test="${vendorInformation.status1 == 3}">
                                            <th>Response</th>
                                        </c:if>
                                        <th>Action</th>
                                    <input type="hidden" id="policyCount9" name="policyCount9" value="1"/>
                                    </tr>
                                    <input type="hidden"  name="lstworkcount" value="${lstworkcount}"/>

                                    <c:forEach var="lstwork" items="${lstwork}" varStatus="st">
                                        <tr id="policyRowL${st.index + 1}">
                                        <input type="hidden" name="lwId" value="${lstwork.id}"/>

                                        <td>${lstwork.companyName}</td>
                                        <td>${lstwork.contactPersonName}</td>
                                        <td>+${lstwork.countryCode}-${lstwork.mobileNumber}</td>
                                        <td>${lstwork.email}</td>
                                        <td>${lstwork.designation}</td>
                                        <td>
                                            <c:if test="${lstwork.attchment!=null && not empty lstwork.attchment}">                                        
                                                <span class="file-wrapper">
                                                    <span class="file-name text-break">${lstwork.attchment}</span>
                                                    <span class="file-actions">
                                                        <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadLastWorkingFileAprrove&fileName=${lstwork.attchment}&id=${lstwork.vendorInformationId}"><span class="fa fa-download"></span></a>
                                                        <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${lstwork.vendorInformationId}/LAST/${lstwork.attchment}"><span class="fa fa-solid fa-eye"></span></a>
                                                    </span>
                                                </span>
                                            </c:if>

                                            <c:if test="${vendorInformation.status1 == 3 && lstwork.statuss == 'reject'}">
                                                <input type="file" class="input-field" name="rAttchment${lstwork.id}" id="rAttchment" required/>
                                            </c:if>                                                                        
                                        </td>

                                        <c:if test="${vendorInformation.status1 == 3}">
                                            <td style="width: 230px;">                                                            
                                                <c:if test="${not empty lstwork.attchment}">
                                                    <c:if test="${lstwork.statuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                        <input type="hidden" class="input-field"  name="response" rows="2" cols="30"/>
                                                    </c:if>
                                                    <c:if test="${lstwork.statuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="remarkk" readonly rows="2" cols="30" >${lstwork.remarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${lstwork.statuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="response" rows="2" cols="30" maxlength="250" required>${lstwork.response}</textarea>
                                                        </div>
                                                    </c:if>
                                                </c:if>                                                                                
                                                <c:if test="${empty lstwork.attchment}">
                                                    <input type="hidden" class="input-field"  name="response" rows="2" cols="30"/>                                                                            
                                                </c:if>
                                            </td>
                                        </c:if>

                                        <td style="text-align:center;">
                                            <div class="text-center">
                                                <a href="vendorInformation.htm?act=deleteLastwork&id=${lstwork.id}&id1=${vendorInformation.vendorInvitationId}" class="d-inline-block text-danger p-1 mx-1" data-toggle="tooltip" data-placement="left" title="Delete">
                                                    <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 22px; height: 22px;"/>
                                                </a>                     
                                            </div> 

                                        </td>                                                   

                                        </tr>
                                    </c:forEach>


                                    <tr id="policyRowNew9">
                                        <td><input type="text" class="input-field" name="companyNames" id="companyNames" placeholder="Company Name" /></td>
                                        <td><input type="text" class="input-field" name="contactPerson" id="contactPerson" placeholder="Contact Person" /></td>

                                    <td>
                                        <div class="phone-wrapper">

                                            <select name="countryCode1" id="countryCodeNew1" class="select-input">
                                                <c:forEach var="cc" items="${countryCode}">
                                                    <option value="${cc.countryCode}"
                                                            <c:if test="${cc.countryName eq 'india'}">selected</c:if>>
                                                        +${cc.countryCode}
                                                    </option>
                                                </c:forEach>
                                            </select>

                                            <input type="tel"class="input-field" minlength="10" maxlength="10" pattern="^[6-9][0-9]{9}$" inputmode="numeric" oninput="this.value=this.value.replace(/\D/g,'')" name="mobileNo"  id="mobileNo" placeholder="Phone No" />

                                        </div>
                                    </td>



                                    <td><input type="email" class="input-field email-field" name="emailes" id="emailes" placeholder="Email" /></td>
                                    <td><input type="text" class="input-field" name="designationes" id="designationes" placeholder="Designation" /></td>
                                    <td <c:if test="${vendorInformation.status1 == 3}">colspan="2"</c:if>><input type="file" class="input-field" name="attachmentes" id="attachmentes"/></td>


                                    <td style=" text-align: center">
                                        <div class="d-flex justify-content-center align-items-center">
                                            <div class="clone-action clone-new-field d-flex justify-content-center align-items-center mb-2" id="policyCloneid9" style="cursor:pointer;">
                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                            </div>
                                        </div>
                                    </td>
                                    </tr>
                                </table>
                            </div>                                                               
                            <style>
                                .phone-wrapper {
                                    display: flex;
                                    gap: 8px;
                                    width: 95%;
                                }

                                .phone-wrapper .select-input {
                                    flex: 0 0 25%;   /* 25% width */
                                    height: 38px;



                                }

                                .phone-wrapper .input-field {
                                    flex: 1;         /* take remaining width */
                                    height: 38px;

                                    padding: 0 10px;
                                }
                            </style>
                                       
                                  <script>
                                     
                                        $(function () {

                                            var lstworkcount = $("input[name='lstworkcount']").val();
                                            lstworkcount = lstworkcount === "" ? 0 : parseInt(lstworkcount);

                                            var staticRows = $("#policyTable9 tr[id^='policyRow9']").length || 1; // static row count
                                            var totalNeeded = 3; // minimum rows to show
                                            var countryCodeOptions = $("select[name='countryCode1']").first().html();

                                            // Only add default rows if lstworkcount < 3
                                            if (lstworkcount < totalNeeded) {

                                                var defaultRowsToAdd = totalNeeded - staticRows - lstworkcount; // calculate rows to reach total 3
                                                var tempCount3 = staticRows;

                                                for (var i = 1; i <= defaultRowsToAdd; i++) {
                                                    tempCount3++;

                                                    var clone =
                                                        "<tr id='policyRow9" + tempCount3 + "'>" +
                                                        "<input type='hidden' name='lwId' value=''/>" +
                                                        "<td><input type='text' class='input-field' name='companyNames' id='companyNames" + tempCount3 + "' placeholder='Company Name'/></td>" +
                                                        "<td><input type='text' class='input-field' name='contactPerson' id='contactPerson" + tempCount3 + "' placeholder='Contact Person'/></td>" +
                                                        "<td><div class='phone-wrapper'>" +
                                                        "<select name='countryCode1' id='countryCode1" + tempCount3 + "' class='select-input'>" + countryCodeOptions + "</select>" +
                                                        "<input type='tel' class='input-field' " +
                                                        "name='mobileNo' " +
                                                        "minlength='10' maxlength='10' " +
                                                        "pattern='^[6-9][0-9]{9}$' " +
                                                        "inputmode='numeric' " +
                                                        "id='mobileNo" + tempCount3 + "' " +
                                                        "placeholder='Phone No' />" +
                                                        "</div></td>" +
                                                        "<td><input type='email' class='input-field email-field' name='emailes' id='emailes" + tempCount3 + "' placeholder='Email Id'/></td>" +
                                                        "<td><input type='text' class='input-field' name='designationes' id='designationes" + tempCount3 + "' placeholder='Designation'/></td>" +
                                                        "<td colspan='${vendorInformation.status1 == 3 ? '2' : ''}'><input type='file' class='input-field' name='attachmentes' id='attachmentes" + tempCount3 + "' /></td>" +
                                                        "<td style=' text-align: center; vertical-align: middle;'>" +
                                                        "<span style='margin-top: 5px; display: inline-block;'>" +
                                                        "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-flex; align-items: center; justify-content: center;' onclick=\"removePolicy('policyRow9" + tempCount3 + "');\">" +
                                                        "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove' style='width: 70px; height: 70px;'>" +
                                                        "</div>" +
                                                        "</span>" +
                                                        "</td>" +                
                                                        "</tr>";

                                                    $("#policyTable9").append(clone);
                                                    $('#policyTable9 .select-input').selectpicker('refresh');
                                                    $(document).on("input", "input[name='mobileNo']", function () {
                                                        this.value = this.value.replace(/\D/g, '');
                                                    });
                                                }

                                                $("#policyCount9").val(tempCount3);
                                            }

                                        });
                                        $(document).on("change", "input[type='file'][name='attachmentes']", function () {

                                            var file = this.files[0];
                                            var maxSize = 5 * 1024 * 1024; // 5 MB

                                            $(this).next(".file-error").remove();

                                            if (file && file.size > maxSize) {

                                                $(this).after(
                                                    "<small class='text-danger file-error'>File size must be less than 5 MB</small>"
                                                );

                                                $(this).val("");
                                            }
                                        });
                                        </script>



                                        <script>
                                        $(function () {

                                            var tempCount3 = $("#policyTable9 tr[id^='policyRow9']").length || 1;
                                            var countryCodeOptions = $("select[name='countryCode1']").first().html();

                                            $(document).on("click", "#policyCloneid9", function () {
                                                tempCount3++;

                                                var clone =
                                                    "<tr id='policyRow9" + tempCount3 + "'>" +
                                                    "<input type='hidden' name='lwId' value=''/>" +
                                                    "<td><input type='text' class='input-field' name='companyNames' id='companyNames" + tempCount3 + "' placeholder='Company Name'/></td>" +
                                                    "<td><input type='text' class='input-field' name='contactPerson' id='contactPerson" + tempCount3 + "' placeholder='Contact Person'/></td>" +
                                                    "<td><div class='phone-wrapper'>" +
                                                    "<select name='countryCode1' id='countryCode1" + tempCount3 + "' class='select-input'>" + countryCodeOptions + "</select>" +
                                                    "<input type='tel' class='input-field' " +
                                                    "name='mobileNo' " +
                                                    "minlength='10' maxlength='10' " +
                                                    "pattern='^[6-9][0-9]{9}$' " +
                                                    "inputmode='numeric' " +
                                                    "id='mobileNo" + tempCount3 + "' " +
                                                    "placeholder='Phone No' />" +
                                                    "</div></td>" +
                                                    "<td><input type='email' class='input-field email-field' name='emailes' id='emailes" + tempCount3 + "' placeholder='Email Id' style='text-transform: lowercase;'/></td>" +
                                                    "<td><input type='text' class='input-field' name='designationes' id='designationes" + tempCount3 + "' placeholder='Designation'/></td>" +
                                                    "<td colspan='${vendorInformation.status1 == 3 ? '2' : ''}'><input type='file' class='input-field' name='attachmentes' id='attachmentes" + tempCount3 + "' /></td>" +
                                                    "<td style=' text-align: center; vertical-align: middle;'>" +
                                                    "<span style='margin-top: 5px; display: inline-block;'>" +
                                                    "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-flex; align-items: center; justify-content: center;' onclick=\"removePolicy('policyRow9" + tempCount3 + "');\">" +
                                                    "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove' style='width: 70px; height: 70px;'>" +
                                                    "</div>" +
                                                    "</span>" +
                                                    "</td>" +
                                                    "</tr>";

                                                    $("#policyTable9").append(clone);
                                                    $('#policyTable9 .select-input').selectpicker('refresh');
                                                    $("#policyCount9").val(tempCount3);
                                                    $(document).on("input", "input[name='mobileNo']", function () {
                                                        this.value = this.value.replace(/\D/g, '');
                                                    });

                                            });

                                            $(document).on("click", ".removeRowBtn9", function () {
                                                $(this).closest("tr").remove();
                                                updatePolicyCount9();
                                            });

                                            function updatePolicyCount9() {
                                                var totalRows = $("#policyTable9 tr[id^='policyRow9']").length;
                                                $("#policyCount9").val(totalRows);
                                            }

                                        });

                                        $(document).on("input", "input[type='text']", function () {
                                            this.value = this.value.toUpperCase();
                                        });
                                        </script>

                                        <script>
                                                $(function () {

                                                    $("#submit1").click(function (e) {

                                                        var valid = true;
                                                        var totalCompleteRows = 0;

                                                        $("#policyTable9 tr").each(function () {

                                                            var row = $(this);

                                                            if (row.find("th").length > 0) return;

                                                            var isNewRow = row.find("input[name='companyNames']").length > 0;

                                                            if (isNewRow) {

                                                                var company = row.find("input[name='companyNames']");
                                                                var contact = row.find("input[name='contactPerson']");
                                                                var mobile  = row.find("input[name='mobileNo']");
                                                                var email   = row.find("input[name='emailes']");
                                                                var desig   = row.find("input[name='designationes']");
                                                                var fileInp = row.find("input[type='file']");

                                                                var companyVal = $.trim(company.val());
                                                                var contactVal = $.trim(contact.val());
                                                                var mobileVal  = $.trim(mobile.val());
                                                                var emailVal   = $.trim(email.val());
                                                                var desigVal   = $.trim(desig.val());
                                                                var fileVal    = $.trim(fileInp.val());

                                                                company.css("border", "");
                                                                contact.css("border", "");
                                                                mobile.css("border", "");
                                                                email.css("border", "");
                                                                desig.css("border", "");
                                                                fileInp.css("border", "");

                                                                var anyFilled = companyVal || contactVal || mobileVal || emailVal || desigVal || fileVal;
                                                                var allFilled = companyVal && contactVal && mobileVal && emailVal && desigVal && fileVal;

                                                                if (anyFilled && !allFilled) {

                                                                    var firstEmptyField = null;

                                                                    if (!companyVal) {
                                                                        company.css("border", "1px solid red");
                                                                        firstEmptyField = firstEmptyField || company;
                                                                    }

                                                                    if (!contactVal) {
                                                                        contact.css("border", "1px solid red");
                                                                        firstEmptyField = firstEmptyField || contact;
                                                                    }

                                                                    if (!mobileVal) {
                                                                        mobile.css("border", "1px solid red");
                                                                        firstEmptyField = firstEmptyField || mobile;
                                                                    }

                                                                    if (!emailVal) {
                                                                        email.css("border", "1px solid red");
                                                                        firstEmptyField = firstEmptyField || email;
                                                                    }

                                                                    if (!desigVal) {
                                                                        desig.css("border", "1px solid red");
                                                                        firstEmptyField = firstEmptyField || desig;
                                                                    }

                                                                    if (!fileVal) {
                                                                        fileInp.css("border", "1px solid red");
                                                                        firstEmptyField = firstEmptyField || fileInp;
                                                                    }

                                                                    Swal.fire({
                                                                        icon: 'warning',
                                                                        title: 'Incomplete Data',
                                                                        text: 'Please complete all fields in each row of the Past Working Data table.'
                                                                    }).then(() => {

                                                                        if (firstEmptyField) {

                                                                            $('html, body').animate({
                                                                                scrollTop: firstEmptyField.offset().top - 100
                                                                            }, 300);

                                                                            setTimeout(function () {
                                                                                firstEmptyField.focus();
                                                                            }, 350);
                                                                        }

                                                                    });

                                                                    valid = false;
                                                                    return false;
                                                                }

                                                                if (allFilled) {
                                                                    totalCompleteRows++;
                                                                }
                                                            } else {

                                                                var tds = row.find("td");

                                                                var company = $(tds[0]).text().trim();
                                                                var contact = $(tds[1]).text().trim();
                                                                var mobile  = $(tds[2]).text().trim();
                                                                var email   = $(tds[3]).text().trim();
                                                                var desig   = $(tds[4]).text().trim();

                                                                if (company && contact && mobile && email && desig) {
                                                                    totalCompleteRows++;
                                                                }
                                                            }

                                                        });

                                                        if (!valid) {
                                                            e.preventDefault();
                                                            return false;
                                                        }

                                                        if (totalCompleteRows < 3) {
                                                            Swal.fire({
                                                                icon: 'warning',
                                                                title: 'Incomplete Entries',
                                                                text: 'PAST WORKING EXPERIENCE DETAILS NEED MINIMUM 3 COMPLETE ENTRIES'
                                                            });
                                                            e.preventDefault();
                                                            return false;
                                                        }

                                                        return true;
                                                    });

                                                });
                                            </script>
                            
                            
                                                         <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                    <thead>
                                        <tr>
                                            <th colspan="${vendorInformation.status1 == 3 ? '4' : '3'}" style=" background-color: skyblue; text-align: center;">
                                               COMPANY REGISTRATION DETAILS
                                            </th>
                                        </tr>

                                    </thead>
                                        <tr>
                                            <th>GST No.<span class="text-danger">*</span></th>
                                            <td>                                                
                                               <input name="gstinNo" id="gstinNo"  onchange="checkGST()"  placeholder="Ex: 27ABCDE1234F1Z5" class="gst-field input-field" maxlength="15" title="Enter valid GSTIN (e.g. 27ABCDE1234F1Z5)" value="${vendorInformation.gstinNo}" ${vendorBuyerApproval.gstStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'}  oninput="this.value=this.value.toUpperCase();"/>
                                               <span id="gstError" style="color:red;"></span>
                                            </td>
                                            <td>
                                                <c:if test="${vendorInformation.gstinFile!='' &&  vendorInformation.gstinFile!=null}">
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${vendorInformation.gstinFile}</span>
                                                        <span class="file-actions">
                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.gstinFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.gstinFile}"><span class="fa fa-solid fa-eye"></span></a>

                                                            <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.gstinFile}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                            </c:if>
                                                        </span>
                                                    </span>
                                                </c:if>
                                                
                                                <input type="hidden" class="input-field" id="gstinFile1" name="gstinFile1" value="${vendorInformation.gstinFile}">
                                                <c:choose>
                                                    <c:when test="${vendorInformation.status1 == 3}">
                                                        <c:if test="${vendorBuyerApproval.gstStatuss == 'reject'}">
                                                            <input type="file" class="input-field" id="gstinFile" name="gstinFile"required onchange="validateFileSize(this, 'fileErrorGstin');">                                                            
                                                        </c:if>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="file" class="input-field" id="gstinFile" name="gstinFile" <c:if test="${empty vendorInformation.gstinFile}">required="required"</c:if> onchange="validateFileSize(this, 'fileErrorGstin');">
                                                    </c:otherwise>
                                                </c:choose>
                                                <span id="fileErrorGstin" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>                                                
                                            </td>
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td>                                                            
                                                    <c:if test="${vendorBuyerApproval.gstStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.gstStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="gstRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.gstRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.gstStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="gstResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.gstResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>
                                        </tr>
                                        <script>
                                            function checkGST() {

                                                var input = document.getElementById("gstinNo");
                                                var gst = input.value.trim().toUpperCase();
                                                var error = document.getElementById("gstError");

                                                var pattern = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z][1-9A-Z]Z[0-9A-Z]$/;

                                                if (gst === "") {
                                                    error.innerText = "GST Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (gst.length !== 15) {
                                                    error.innerText = "GST Number must be 15 characters";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!pattern.test(gst)) {
                                                    error.innerText = "Enter valid GSTIN (Ex: 27ABCDE1234F1Z5)";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerText = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                            }
                                        </script>
                                        <script>                                                

                                                function toggleGST(showInput) {
                                                const inputField = document.getElementById("gstinNo");
                                                        const declarationLetterSection0 = document.getElementById("declarationLetterSection0");
                                                        const gstLabel = document.getElementById("gstLabel");
                                                        if (gstLabel) {
                                                gstLabel.textContent = showInput ? "GST No." : "";
                                                }

                                                document.getElementById("gstInputWrapper").style.display = showInput ? "block" : "none";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                        declarationLetterSection0.style.display = "none";
                                                } else {
                                                inputField.removeAttribute("required");
                                                        declarationLetterSection0.style.display = "block";
                                                }
                                                }

                                                document.addEventListener('DOMContentLoaded', function () {

                                                var gstStatus = '<c:out value="${vendorInformation.gstStatus}" default="0" />';
                                                        var hasGST = gstStatus === '1';
                                                        var yesRadio = document.getElementById('gstOptionYes');
                                                        var noRadio = document.getElementById('gstOptionNo');
                                                        if (yesRadio) yesRadio.checked = hasGST;
                                                        if (noRadio) noRadio.checked = !hasGST;
                                                        toggleGST(hasGST);
                                                });</script>                                        

                                        <tr>
                                            <th id="panLabel" style="">PAN No.<span class="text-danger">*</span></th>
                                            
                                            <td>                                                
                                                <input name="panNo" id="panNo" onchange="checkPAN()" placeholder="Example: ABCDE1234F" class="input-field pan-field" maxlength="10" value="${vendorInformation.panNo}" ${vendorBuyerApproval.panStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'} oninput="this.value=this.value.toUpperCase();"/>
                                            <span id="panError" style="color:red;"></span>
                                            </td>
                                            
                                            <td>
                                                <c:if test="${vendorInformation.panFile!='' &&  vendorInformation.panFile!=null}">
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${vendorInformation.panFile}</span>
                                                        <span class="file-actions">
                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.panFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.panFile}"><span class="fa fa-solid fa-eye"></span></a>

                                                            <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.panFile}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                            </c:if>
                                                        </span>
                                                    </span>
                                                </c:if>
                                                <input type="hidden" class="input-field" id="panFile1" name="panFile1" accept="" value="${vendorInformation.panFile}">
                                                <c:choose>
                                                    <c:when test="${vendorInformation.status1 == 3}">
                                                        <c:if test="${vendorBuyerApproval.panStatuss == 'reject'}">
                                                            <input type="file" class="input-field" id="panFile" name="panFile" accept="" onchange="validateFileSize(this, 'fileErrorPan');" required>                                                            
                                                        </c:if>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="file" class="input-field" id="panFile" name="panFile" accept="" onchange="validateFileSize(this, 'fileErrorPan');"  <c:if test="${empty vendorInformation.panFile}">required="required"</c:if> >                                                            
                                                    </c:otherwise>
                                                </c:choose>
                                                <span id="fileErrorPan" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td>
                                            
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td>                                                            
                                                    <c:if test="${vendorBuyerApproval.panStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.panStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="panRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.panRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.panStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="panResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.panResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>
                                        </tr>
                                        
                                        <script>
                                            function checkPAN() {

                                                var input = document.getElementById("panNo");
                                                var pan = input.value.trim().toUpperCase();
                                                var error = document.getElementById("panError");

                                                var pattern = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;

                                                if (pan === "") {
                                                    error.innerText = "PAN Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (pan.length !== 10) {
                                                    error.innerText = "PAN Number must be 10 characters";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!pattern.test(pan)) {
                                                    error.innerText = "Enter valid PAN Number (Ex: ABCDE1234F)";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerText = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                            }
                                        </script>


                                        <tr>
                                            <th style="">Do you have MSME No? <span style="color: red;font-size: 12px;">*</span></th>
                                            <td colspan="2">
                                                <input type="radio" class="radio-inline" id="msmeOptionYes" name="msmeOption" ${(vendorBuyerApproval.msmeStatuss == 'accept' && vendorInformation.status1 == '3') ? 'disabled' : ''} <c:if test="${vendorInformation.msmeStatus == '1'}"> checked="true"</c:if> value="1" onchange="toggleMSME(true)"> <label for="msmeOptionYes">Yes</label>
                                                <input type="radio" class="radio-inline" id="msmeOptionNo" name="msmeOption" value="0" ${(vendorBuyerApproval.msmeStatuss == 'accept' && vendorInformation.status1 == '3') ? 'disabled' : ''}  <c:if test="${vendorInformation.msmeStatus == '0'}"> checked="true"</c:if> onchange="toggleMSME(false)"> <label for="msmeOptionNo">No</label>    
                                                <c:if test="${vendorBuyerApproval.msmeStatuss == 'accept'}">
                                                    <input type="hidden" class="radio-inline" id="msmeOption" name="msmeOption" value="${vendorInformation.msmeStatus}" />                                                    
                                                </c:if>
                                            </td>
                                        </tr>

                                        <tr>
                                            <th id="msmeLabel" style="">MSME No<span class="text-danger">*</span> </th>
                                            <td>
                                                <div id="msmeInputWrapper" style="display: none;">
                                                    <input name="service_tax" id="service_tax" placeholder="Ex: UDYAM-GJ-12-0001234" onchange="checkMSME();"  class="msme-field input-field" maxlength="19" value="${vendorInformation.service_tax}" ${(vendorBuyerApproval.msmeStatuss == 'accept' && vendorInformation.status1 == 3) ? 'readonly' : 'required'} oninput="this.value=this.value.toUpperCase();" />
                                                <div id="msmeError" style="color:red; font-size:13px; margin-top:5px;"></div>
                                            </div>
                                                <div id="declarationLetterSectionM">
                                                    MSME Declaration Letter<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileDeviation&amp;fileName=msmeDeclarationFormat.docx">&nbsp;<span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/msmeDeclarationFormat.docx"><span class="fa fa-solid fa-eye"></span></a><br>
                                                    <span><b>(Kindly download the document, Fill all required details and upload it once finished.)</b></span>
                                                </div>
                                            </td>
                                            <td>
                                                <div id="policy">
                                                    <c:if test="${not empty vendorInformation.service_file}">
                                                        <span class="file-wrapper">
                                                            <span class="file-name text-break">${vendorInformation.service_file}</span>
                                                            <span class="file-actions">
                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.service_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.service_file}"><span class="fa fa-solid fa-eye"></span></a>

                                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.service_file}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                </c:if>
                                                            </span>
                                                        </span>
                                                     </c:if>
                                                </div>
                                                <input type="hidden" class="input-field" id="serviceTaxFile1" name="serviceTaxFile1" accept="" value="${vendorInformation.service_file}">
                                                <c:choose>
                                                    <c:when test="${vendorInformation.status1 == 3}">
                                                        <c:if test="${vendorBuyerApproval.msmeStatuss == 'reject'}">
                                                            <input type="file" class="input-field" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="validateFileSize(this,'fileErrorMsme');"  required>
                                                        </c:if>
                                                    </c:when>
                                                        <c:otherwise>
                                                            <input type="file" class="input-field" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="validateFileSize(this,'fileErrorMsme');"  <c:if test="${empty vendorInformation.service_file}">required="required"</c:if> >                                                            
                                                        </c:otherwise>
                                                </c:choose>
                                                <div id="udyamLabel">
                                                    <strong><span style="font-size: 12px; ">(Udyam certificate)</span></strong>
                                                </div>
                                                <span id="fileErrorMsme" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td>
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td>                                                            
                                                    <c:if test="${vendorBuyerApproval.msmeStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.msmeStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="msmeRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.msmeRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.msmeStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="msmeResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.msmeResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>
                                        </tr>
                                         <script>
                                    function checkMSME() {

                                        var input = document.getElementById("service_tax");
                                        var msme = input.value.trim().toUpperCase();
                                        var error = document.getElementById("msmeError");

                                        var pattern = /^UDYAM-[A-Z]{2}-[0-9]{2}-[0-9]{7}$/;

                                        if (msme === "") {
                                            error.innerText = "MSME Number is required";
                                            input.style.border = "1px solid red";
                                            return false;
                                        }

                                        if (msme.length !== 19) {
                                            error.innerText = "MSME Number must be 19 characters";
                                            input.style.border = "1px solid red";
                                            return false;
                                        }

                                        if (!pattern.test(msme)) {
                                            error.innerText = "Enter valid MSME No (Ex: UDYAM-GJ-12-0001234)";
                                            input.style.border = "1px solid red";
                                            return false;
                                        }

                                        // valid hoy to
                                        error.innerText = "";
                                        input.style.border = "1px solid #ccc";
                                        return true;
                                    }
                                    </script>
                                            <script>                                              
                                                function toggleMSME(showInput) {
                                                    const inputField = document.getElementById("service_tax");
                                                    const msmeLabel = document.getElementById("msmeLabel");
                                                    const udyamLabel = document.getElementById("udyamLabel");
                                                    if (msmeLabel) {
                                                        msmeLabel.textContent = showInput ? "MSME No." : "MSME Deviation Policy";
                                                    }

                                                    document.getElementById("msmeInputWrapper").style.display = showInput ? "block" : "none";
                                                    document.getElementById("declarationLetterSectionM").style.display = showInput ? "none" : "block";
                                                    document.getElementById("udyamLabel").style.display = showInput ? "block" : "none";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                } else {
                                                inputField.removeAttribute("required");
//                                                inputField.value = "";
                                                }
                                                }
                                                document.addEventListener('DOMContentLoaded', function () {

                                                var msmeStatus = '<c:out value="${vendorInformation.msmeStatus}" default="0" />';
                                                        var hasMSME = msmeStatus === '1';
                                                        var yesMSMERadio = document.getElementById('msmeOptionYes');
                                                        var noMSMERadio = document.getElementById('msmeOptionNo');
                                                        if (yesMSMERadio) yesMSMERadio.checked = hasMSME;
                                                        if (noMSMERadio) noMSMERadio.checked = !hasMSME;
                                                        toggleMSME(hasMSME);
                                                });
                                                </script>

                                        <tr>
                                            <th style="">Do you have ESIC No? <span style="color: red;font-size: 12px;">*</span></th>
                                            <td colspan="2">
                                                <input type="radio" class="radio-inline" id="esicOptionYes" name="esicOption" ${(vendorBuyerApproval.esicStatuss == 'accept' && vendorInformation.status1 == '3') ? 'disabled' : ''} <c:if test="${vendorInformation.esicStatus == '1'}"> checked</c:if> value="1" onchange="toggleESIC(true)"> <label for="esicOptionYes">Yes</label>
                                                <input type="radio" class="radio-inline" id="esicOptionNo" name="esicOption" value="0" ${(vendorBuyerApproval.esicStatuss == 'accept' && vendorInformation.status1 == '3') ? 'disabled' : ''}  <c:if test="${vendorInformation.esicStatus == '0'}"> checked</c:if> onchange="toggleESIC(false)"> <label for="esicOptionNo">No</label>    
                                                <c:if test="${vendorBuyerApproval.esicStatuss == 'accept'}">
                                                    <input type="hidden" class="radio-inline" id="esicOption" name="esicOption" value="${vendorInformation.esicStatus}" />                                                    
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th id="esicLabel" style="">ESIC No.<span style="color: red;font-size: 12px;">*</span></th>
                                            <td>
                                                <div id="esicInputWrapper" style="display: none;">                                                    
                                                    <input name="esicNo" id="esicNo"  placeholder="Ex: 12345678901234567"  onchange="checkESIC();"   class="input-field" value="${vendorInformation.esicNo}" ${(vendorBuyerApproval.esicStatuss == 'accept' && vendorInformation.status1 == 3) ? 'readonly' : 'required'}/>
                                                 <div id="esicError" style="color:red; font-size:13px; margin-top:5px;"></div>
                                            </div>
                                                <div id="declarationLetterSectionE">
                                                    ESIC Declaration Letter<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileDeviation&amp;fileName=epfoEsicDeclarationFormate.docx">&nbsp;<span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/epfoEsicDeclarationFormate.docx"><span class="fa fa-solid fa-eye"></span></a><br>
                                                    <span><b>(Kindly download the document, Fill all required details and upload it once finished.)</b></span>
                                                </div>
                                            </td>

                                            <td>
                                                <c:if test="${vendorInformation.esicFile!='' &&  vendorInformation.esicFile!=null}">
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${vendorInformation.esicFile}</span>
                                                        <span class="file-actions">
                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.esicFile}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.esicFile}"><span class="fa fa-solid fa-eye"></span></a>

                                                            <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.esicFile}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                            </c:if>
                                                        </span>
                                                    </span>
                                                </c:if>
                                                <input type="hidden" class="input-field" id="esicFile1" name="esicFile1" accept="" value="${vendorInformation.esicFile}">
                                                <c:choose>
                                                    <c:when test="${vendorInformation.status1 == 3}">
                                                        <c:if test="${vendorBuyerApproval.esicStatuss == 'reject'}">
                                                            <input type="file" class="input-field" id="esicFile" name="esicFile" accept="" onchange="validateFileSize(this, 'fileErrorEsic');" required />                                                            
                                                        </c:if>
                                                    </c:when>
                                                        <c:otherwise>
                                                            <input type="file" class="input-field" id="esicFile" name="esicFile" accept="" onchange="validateFileSize(this, 'fileErrorEsic');"  <c:if test="${empty vendorInformation.esicFile}">required="required"</c:if> />                                                            
                                                        </c:otherwise>
                                                </c:choose>
                                                <span id="fileErrorEsic" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td>
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td>                                                            
                                                    <c:if test="${vendorBuyerApproval.esicStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.esicStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="esicRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.esicRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.esicStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="esicResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.esicResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>
                                        </tr>
                                        <script>
                                            function checkESIC() {

                                            var input = document.getElementById("esicNo");
                                            var esic = input.value.trim();
                                            var error = document.getElementById("esicError");

                                            var esicPattern = /^\d{17}$/;

                                            if (esic === "") {
                                                error.innerHTML = "ESIC Number is required";
                                                input.style.border = "1px solid red";
                                                return false;
                                            }

                                            if (!esicPattern.test(esic)) {
                                                error.innerHTML = "Enter valid 17 digit ESIC No";
                                                input.style.border = "1px solid red";
                                                return false;
                                            }

                                            error.innerHTML = "";
                                            input.style.border = "1px solid #ccc";
                                            return true;
                                            }
                                        </script>

                                        <script>
                                            function toggleESIC(showInput) {
                                                const inputField = document.getElementById("esicNo");
                                                const esicLabel = document.getElementById("esicLabel");
                                                if (esicLabel) {
                                                    esicLabel.textContent = showInput ? "ESIC No." : "ESIC Deviation Policy";
                                                }
                                                    document.getElementById("esicInputWrapper").style.display = showInput ? "block" : "none";
                                                    document.getElementById("declarationLetterSectionE").style.display = showInput ? "none" : "block";
                                                if (showInput) {
                                                    inputField.setAttribute("required", "required");
                                                } else {
                                                    inputField.removeAttribute("required");
//                                                    inputField.value = "";
                                                }
                                            }
                                                document.addEventListener('DOMContentLoaded', function () {

                                                    var esicStatus = '<c:out value="${vendorInformation.esicStatus}" default="0" />';
                                                    var hasESIC= esicStatus === '1';
                                                    var yesESICRadio = document.getElementById('esicOptionYes');
                                                    var noESICRadio = document.getElementById('esicOptionNo');
                                                    if (yesESICRadio) yesESICRadio.checked = hasESIC;
                                                    if (noESICRadio) noESICRadio.checked = !hasESIC;
                                                    toggleESIC(hasESIC);
                                                });
                                        </script>

                                        <tr>
                                            <th style="">Do you have EPFO No? <span style="color: red;font-size: 12px;">*</span></th>
                                            <td colspan="2">
                                                <input type="radio" class="radio-inline" id="epfoOptionYes" name="epfoOption"  value="1" ${(vendorBuyerApproval.epfoStatuss == 'accept' && vendorInformation.status1 == '3') ? 'disabled' : ''} <c:if test="${vendorInformation.epfoStatus == '1'}"> checked="true"</c:if> onchange="toggleEPFO(true)"> <label for="epfoOptionYes">Yes</label>
                                                <input type="radio" class="radio-inline" id="epfoOptionNo" name="epfoOption" value="0" ${(vendorBuyerApproval.epfoStatuss == 'accept' && vendorInformation.status1 == '3') ? 'disabled' : ''} <c:if test="${vendorInformation.epfoStatus == '0'}"> checked="true"</c:if> onchange="toggleEPFO(false)"> <label for="epfoOptionNo">No</label> 
                                                <c:if test="${vendorBuyerApproval.epfoStatuss == 'accept'}">
                                                    <input type="hidden" class="radio-inline" id="epfoOption" name="epfoOption" value="${vendorInformation.epfoStatus}" />                                                    
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th id="epfoLabel" style="">EPFO No.</th>
                                            <td>
                                                <div id="epfoInputWrapper" style="display: none;">
                                                    <input type="text" id="epfoNo" name="pfNo" placeholder="Ex: GJ/SRT/1234567/000/0001" class="input-field" value="${vendorInformation.pfNo}" ${(vendorBuyerApproval.epfoStatuss == 'accept' && vendorInformation.status1 == '3') ? 'readonly' : 'required'} onchange="checkEPFO()" />
                                                    <span id="epfoError" style="color:red;font-size:12px;"></span>
                                            </div>
                                                <div id="declarationLetterSectionP">
                                                    EPFO Declaration Letter<a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileDeviation&amp;fileName=epfoEsicDeclarationFormate.docx">&nbsp;<span class="fa fa-download"></span></a>
                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/epfoEsicDeclarationFormate.docx"><span class="fa fa-solid fa-eye"></span></a><br>
                                                    <span><b>(Kindly download the document, Fill all required details and upload it once finished.)</b></span>
                                                </div>
                                            </td>
                                            <td>
                                                <div id="policy">
                                                    <c:if test="${not empty vendorInformation.pfAttachment}">
                                                        <span class="file-wrapper">
                                                            <span class="file-name text-break">${vendorInformation.pfAttachment}</span>
                                                            <span class="file-actions">
                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.pfAttachment}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.pfAttachment}"><span class="fa fa-solid fa-eye"></span></a>

                                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.pfAttachment}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                </c:if>
                                                            </span>
                                                        </span>
                                                    </c:if>
                                                </div>
                                                <span id="cancelCheckError5" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                <input type="hidden" class="input-field" id="pfAttachment1" name="pfAttachment1" accept="" value="${vendorInformation.pfAttachment}">
                                                <c:choose>
                                                    <c:when test="${vendorInformation.status1 == 3}">
                                                        <c:if test="${vendorBuyerApproval.epfoStatuss == 'reject'}">
                                                            <input type="file" class="input-field" id="pfAttachment" name="pfAttachment" accept="" onchange="validateFileSize(this,'fileErrorEpfo');" required/>                                                            
                                                        </c:if>
                                                    </c:when>
                                                        <c:otherwise>
                                                            <input type="file" class="input-field" id="pfAttachment" name="pfAttachment" accept="" onchange="validateFileSize(this,'fileErrorEpfo');"  <c:if test="${empty vendorInformation.pfAttachment}">required="required"</c:if> />                                                            
                                                        </c:otherwise>
                                                </c:choose>
                                                <span id="fileErrorEpfo" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td>
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td>                                                            
                                                    <c:if test="${vendorBuyerApproval.epfoStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.epfoStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="epfoRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.epfoRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.epfoStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="epfoResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.epfoResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>
                                        </tr>
                                        <script>
                                            function checkEPFO() {

                                                var input = document.getElementById("epfoNo");
                                                var epfo = input.value.trim().toUpperCase();
                                                var error = document.getElementById("epfoError");

                                                var epfoPattern = /^[A-Z]{2}\\/[A-Z]{2,5}\\/[0-9]{1,7}\\/[0-9]{4}$/;

                                                if (epfo === "") {
                                                    error.innerHTML = "EPFO Number is required";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                if (!epfoPattern.test(epfo)) {
                                                    error.innerHTML = "Enter valid EPFO No (Ex: GJ/SRT/1234567/000/0001)";
                                                    input.style.border = "1px solid red";
                                                    return false;
                                                }

                                                error.innerHTML = "";
                                                input.style.border = "1px solid #ccc";
                                                return true;
                                            }
                                        </script>
                                        <script>
                                            
                                            function toggleEPFO(showInput) {
                                                const inputField = document.getElementById("epfoNo");
                                                        const declarationLetterSection0 = document.getElementById("declarationLetterSection0");
                                                        const epfoLabel = document.getElementById("epfoLabel");
                                                        if (epfoLabel) {
                                                epfoLabel.textContent = showInput ? "EPFO No." : "EPFO Deviation Policy";
                                                }

                                                document.getElementById("epfoInputWrapper").style.display = showInput ? "block" : "none";
                                                document.getElementById("declarationLetterSectionP").style.display = showInput ? "none" : "block";
                                                        if (showInput) {
                                                inputField.setAttribute("required", "required");
                                                        declarationLetterSection0.style.display = "none";
                                                } else {
                                                inputField.removeAttribute("required");
//                                                inputField.value = "";
                                                        declarationLetterSection0.style.display = "block";
                                                }
                                                }
                                            document.addEventListener('DOMContentLoaded', function () {
                                                var epfoStatus = '<c:out value="${vendorInformation.epfoStatus}" default="0" />';
                                                        var hasEPFO = epfoStatus === '1';
                                                        var yesEPFORadio = document.getElementById('epfoOptionYes');
                                                        var noEPFORadio = document.getElementById('epfoOptionNo');
                                                        if (yesEPFORadio) yesEPFORadio.checked = hasEPFO;
                                                        if (noEPFORadio) noEPFORadio.checked = !hasEPFO;
                                                        toggleEPFO(hasEPFO);
                                                });
                                        </script>

                                        <tr>
                                            <th style="">Do you Have Import Export Code? <span style="color: red;font-size: 12px;">*</span></th>
                                            <td colspan="2">
                                                <input type="radio" class="radio-inline" id="iecOptionYes" name="eccOption"  value="1"  <c:if test="${vendorInformation.eccStatus=='1'}"> checked="true"</c:if> onchange="toggleIEC(true);"> <label for="iecOptionYes">Yes</label>
                                                <input type="radio" class="radio-inline" id="iecOptionNo" name="eccOption" value="0" <c:if test="${vendorInformation.eccStatus=='0'}"> checked="true"</c:if> onchange="toggleIEC(false);"> <label for="iecOptionNo">No</label>
                                            </td>
                                        </tr>
                                        <tr id="iecRow">
                                            <th style="">Import Export Code.</th>
                                            <td>
                                                <input name="ecc_no" id="ecc_no" class="input-field" value="${vendorInformation.ecc_no}" ${vendorBuyerApproval.eccStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'} maxlength="10"/>
                                            </td>
                                            <td>
                                                <c:if test="${not empty vendorInformation.ecc_file}">
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${vendorInformation.ecc_file}</span>
                                                        <span class="file-actions">
                                                            <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.ecc_file}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.ecc_file}"><span class="fa fa-solid fa-eye"></span></a>

                                                            <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.ecc_file}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                </c:if>
                                                        </span>
                                                    </span>
                                                </c:if>
                                                
                                                <input type="hidden" class="input-field" id="eccNoFile1" name="eccNoFile1" accept="" value="${vendorInformation.ecc_file}">
                                                <c:choose>
                                                    <c:when test="${vendorInformation.status1 == 3}">
                                                        <c:if test="${vendorBuyerApproval.eccStatuss == 'reject'}">
                                                            <input type="file" class="input-field" id="eccNoFile" name="eccNoFile" accept="" onchange="validateFileSize(this,'fileErrorEcc');" required/>                                                            
                                                        </c:if>
                                                    </c:when>
                                                        <c:otherwise>
                                                            <input type="file" class="input-field" id="eccNoFile" name="eccNoFile" accept="" onchange="validateFileSize(this,'fileErrorEcc');"  <c:if test="${empty vendorInformation.ecc_file}">required="required"</c:if> />                                                            
                                                        </c:otherwise>
                                                </c:choose>
                                                <span id="fileErrorEcc" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                            </td>
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td>                                                            
                                                    <c:if test="${vendorBuyerApproval.eccStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.eccStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="eccRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.eccRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.eccStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="eccResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.eccResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>
                                        </tr>
                                        <script>
                                            function toggleIEC(isYes) {
                                                const iecRow = document.getElementById("iecRow");
                                                const eccNo = document.getElementById("ecc_no");
                                                const eccFile = document.getElementById("eccNoFile");
                                                const existingFile = document.getElementById("eccNoFile1");

                                                if (isYes) {
                                                    iecRow.style.display = "table-row";
                                                    eccNo.setAttribute("required", "required");
                                                    if (!existingFile || existingFile.value === "") {
                                                        eccFile.setAttribute("required", "required");
                                                    } else {
                                                        eccFile.removeAttribute("required");
                                                        inputField.value = "";
                                                    }
                                                } else {
                                                    iecRow.style.display = "none";
                                                    eccNo.removeAttribute("required");
                                                    eccFile.removeAttribute("required");
//                                                    eccNo.value = "";
//                                                    eccFile.value = "";
                                                }
                                            } 

                                            document.addEventListener('DOMContentLoaded', function () {

                                            var eccStatus = '<c:out value="${vendorInformation.eccStatus}" default="0" />';
                                                    var hasIEC = eccStatus === '1';
                                                    var yesIECRadio = document.getElementById('iecOptionYes');
                                                    var noIECRadio = document.getElementById('iecOptionNo');
                                                    if (yesIECRadio) yesIECRadio.checked = hasIEC;
                                                    if (noIECRadio) noIECRadio.checked = !hasIEC;
                                                    toggleIEC(hasIEC);
                                            });
                                        </script>
                                        <br>
                      
                                                    
                                       <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                                <thead>
                                                    <tr>
                                                        <th colspan="4" style=" background-color: skyblue; text-align: center;">
                                                            PAYMENT / BANKING DETAILS
                                                        </th>
                                                    </tr>
                                                </thead>
                                        <tr>
                                            <th>
                                                Account Number.<span style="color: red;font-size: 12px;">*</span>
                                            </th>
                                            <td>
                                                <input name="accountNumber" class="input-field" oninput="this.value = this.value.replace(/\D/g, '')" value="${vendorInformation.accountNumber}" ${vendorBuyerApproval.cancelChequeStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'}/>
                                            </td>
                                            <th>
                                                Bank Name<span style="color: red;font-size: 12px;">*</span>
                                            </th>
                                            <td>
                                                <input name="bankName" class="input-field" value="${vendorInformation.bankName}" ${vendorBuyerApproval.cancelChequeStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'}/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Branch<span style="color: red;font-size: 12px;">*</span>
                                            </th>
                                            <td>
                                                <input name="branch" class="input-field" value="${vendorInformation.branch}" ${vendorBuyerApproval.cancelChequeStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'}/>
                                            </td>
                                            <th>
                                                IFSC Code<span style="color: red;font-size: 12px;">*</span>
                                            </th>
                                            <td>
                                                <input  name="ifscCode"  class="input-field" value="${vendorInformation.ifscCode}" ${vendorBuyerApproval.cancelChequeStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : 'required'} />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Swift Code (if any)
                                            </th>
                                            <td>
                                                <input  name="swiftCode"  class="input-field" value="${vendorInformation.swiftCode}" ${vendorBuyerApproval.cancelChequeStatuss == 'accept' && vendorInformation.status1 == 3 ? 'readonly' : ''}/>
                                            </td>
                                            <th></th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Cancel Cheque<span style="color: red;font-size: 12px;">*</span>
                                            </th>
                                            <td>
                                                <input type="hidden" name="cancelcheck1" id="cancelcheck1" value="${vendorInformation.cancelCheck}">
                                                <div class="">
                                                    <c:if test="${vendorInformation.cancelCheck!='' && vendorInformation.cancelCheck!=null}">
                                                            
                                                        <span class="file-wrapper">
                                                            <span class="file-name text-break">${vendorInformation.cancelCheck}</span>
                                                            <span class="file-actions">
                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.cancelCheck}"><span class="fa fa-solid fa-eye"></span></a>

                                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.cancelCheck}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                </c:if>
                                                            </span>
                                                        </span>
            
                                                    </c:if>
                                                    
                                                    
                                                    <c:choose>
                                                        <c:when test="${vendorInformation.status1 == 3}">
                                                            <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'reject'}">
                                                                <input type="file" class="input-field" id="cancelcheck" name="cancelcheck" required onchange="validateFileSize(this, 'fileErrorCancleCheck');">                                                            
                                                            </c:if>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="file" class="input-field" id="cancelcheck" name="cancelcheck" <c:if test="${empty vendorInformation.cancelCheck}">required="true"</c:if>  onchange="validateFileSize(this, 'fileErrorCancleCheck');">                                                            
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <span id="fileErrorCancleCheck" style="color:red;font-size:11px;display:none;">
                                                        * File should not exceed 5MB
                                                    </span>
                                                </div>                                                
                                            </td>
                                            <c:if test="${vendorInformation.status1 != 3}">
                                                <th style=""></th>                                                
                                                <td></td>                                                
                                            </c:if>
                                            <c:if test="${vendorInformation.status1 == 3}">
                                                <td colspan="2">                                                            
                                                    <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'accept'}">
                                                        <span style="color:green; font-weight:bold;">&#10004; Accepted</span>
                                                    </c:if>
                                                    <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'reject'}">
                                                        <span style="color:red; font-weight:bold;">&#10008; Rejected</span>
                                                        <div>
                                                            <textarea class="textarea-field"  name="cancelChequeRemarkk" readonly rows="2" cols="30" >${vendorBuyerApproval.cancelChequeRemarkk}</textarea>
                                                        </div>
                                                    </c:if> 
                                                    <c:if test="${vendorBuyerApproval.cancelChequeStatuss == 'reject'}">
                                                        <div>                                                            
                                                            <textarea class="textarea-field"  name="cancelChequeResponse" rows="2" cols="30" maxlength="250" required>${vendorBuyerApproval.cancelChequeResponse}</textarea>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </c:if>                                            
                                        </tr>
                                        </table>
                                        <br>
                                                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; ">
                                                            <thead>
                                                                <tr>
                                                                    <th colspan="4" style=" background-color: skyblue; text-align: center;">
                                                                        FINANCIAL STATEMENT FOR LAST THREEE YEARS
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th>Select year<span class="text-danger">*</span> </th>
                                                                    <th> Financial Year<span class="text-danger">*</span> </th>
                                                                    <th> Financial Amount(Turnover)<span class="text-danger">*</span></th>
                                                                    <th> Financial Attachment<span class="text-danger">*</span></th>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <select id="finicals1" class="select-input" required>
                                                                            <option>--Select--</option>
                                                                            <option value="Current Financial Year">Current Financial Year</option>
                                                                            <option value="Last Financial Year">Last Financial Year</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <input name="finical1" required="true" id="finicalInput1" value="${vendorInformation.finical1}" class="input-field" maxlength="30" />
                                                                </td>
                                                                <td> <input name="finicalAmount1" required="true" value="${vendorInformation.finicalAmount1}" oninput="formatNumber(this)" class="input-field" maxlength="30" /></td>
                                                                <td>
                                                                    <c:if test="${vendorInformation.finicalAttachment1!='' && vendorInformation.finicalAttachment1!=null}">
                                                                        
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation.finicalAttachment1}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment1}"><span class="fa fa-solid fa-eye"></span></a>

                                                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                                </c:if>
                                                                            </span>
                                                                        </span>
                                                                        
                                                                    </c:if>
                                                                    <input type="hidden" class="input-field" id="finicalAttachment11" value="${vendorInformation.finicalAttachment1}" name="finicalAttachment11" accept="" />
                                                                    <input type="file" <c:if test="${empty vendorInformation.finicalAttachment1}">required="true"</c:if> class="input-field" onchange="validateFileSize(this, 'fileErrorFinicalAttachment1');" id="finicalAttachment1" name="finicalAttachment1" accept="" />
                                                                    <span id="fileErrorFinicalAttachment1" style="color:red;font-size:11px;display:none;">
                                                                        * File should not exceed 5MB
                                                                    </span>                                                                    
                                                                </td>
                                                                </tr>
                                                                
                                                                
                                                                
                                                                <tr>
                                                                    <td></td>
                                                                    <td><input name="finical2" required="true" id="finicalInput2" value="${vendorInformation.finical2}" class="input-field" maxlength="30" /></td>
                                                                <td><input name="finicalAmount2" required="true" oninput="formatNumber(this)" value="${vendorInformation.finicalAmount2}" class="input-field" maxlength="30" /></td>
                                                                
                                                                <td> 
                                                                    <c:if test="${vendorInformation.finicalAttachment2!='' && vendorInformation.finicalAttachment2!=null}">
                                                                      
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation.finicalAttachment2}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment2}"><span class="fa fa-solid fa-eye"></span></a>

                                                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                                </c:if>
                                                                            </span>
                                                                        </span>                                                                        
                                                                    </c:if>
                                                                    <input type="hidden" class="input-field" id="finicalAttachment22" value="${vendorInformation.finicalAttachment2}" name="finicalAttachment22" accept="" />
                                                                    <input type="file" <c:if test="${empty vendorInformation.finicalAttachment2}">required="true"</c:if> class="input-field" onchange="validateFileSize(this, 'fileErrorFinicalAttachment2');" id="finicalAttachment2" name="finicalAttachment2" />
                                                                    <span id="fileErrorFinicalAttachment2" style="color:red;font-size:11px;display:none;">
                                                                        * File should not exceed 5MB
                                                                    </span>
                                                                </td>
                                                                </tr>
                                                                <tr>
                                                                    <td></td>
                                                                    <td><input name="finical3" required="true" id="finicalInput3"  value="${vendorInformation.finical3}" class="input-field" maxlength="30" /></td>
                                                                <td><input name="finicalAmount3" required="true" oninput="formatNumber(this)" value="${vendorInformation.finicalAmount3}" class="input-field" maxlength="30" /></td>
                                                                <td> 
                                                                    <c:if test="${vendorInformation.finicalAttachment3!='' && vendorInformation.finicalAttachment3!=null}">
                                                                       
                                                                        <span class="file-wrapper">
                                                                            <span class="file-name text-break">${vendorInformation.finicalAttachment3}</span>
                                                                            <span class="file-actions">
                                                                                <a class="text-break gradient-text fw-600" href="vendorInformation.htm?act=downloadFileAllAprrove&amp;fileName=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}"><span class="fa fa-download"></span></a>
                                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/${vendorInformation.finicalAttachment3}"><span class="fa fa-solid fa-eye"></span></a>

                                                                                <c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                                                                    <a href="vendorInformation.htm?act=venderinfoAttachmentDelete&fileNameAttch=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}">  <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 15px; height: 15px;  cursor:pointer;" /></a>
                                                                                </c:if>
                                                                            </span>
                                                                        </span>     
                                                           
                                                                    </c:if>
                                                                    <input type="hidden" class="input-field" id="finicalAttachment33" value="${vendorInformation.finicalAttachment3}" name="finicalAttachment33" accept="" />
                                                                    <input type="file" <c:if test="${empty vendorInformation.finicalAttachment3}">required="true"</c:if> onchange="validateFileSize(this, 'fileErrorFinicalAttachment3');" class="input-field" id="finicalAttachment3" name="finicalAttachment3" /></td>
                                                                    <span id="fileErrorFinicalAttachment3" style="color:red;font-size:11px;display:none;">
                                                                        * File should not exceed 5MB
                                                                    </span>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    <script>
                                                        document.addEventListener("DOMContentLoaded", function () {

                                                            const finicalInput1 = document.getElementById("finicalInput1");
                                                            const finicals1 = document.getElementById("finicals1");

                                                            if (!finicalInput1 || !finicals1) {
                                                                console.log("Element not found");
                                                                return;
                                                            }

                                                            const inputValue = finicalInput1.value.trim();

                                                            const currentDate = new Date();
                                                            const currentYear = currentDate.getFullYear();

                                                            let startYear, endYear;

                                                            if (currentDate.getMonth() >= 3) {
                                                                startYear = currentYear;
                                                                endYear = currentYear + 1;
                                                            } else {
                                                                startYear = currentYear - 1;
                                                                endYear = currentYear;
                                                            }

                                                            const currentFY = startYear + " - " + endYear;
                                                            const lastFY = (startYear - 1) + " - " + startYear;

                                                            console.log("Input Value:", inputValue);
                                                            console.log("Current FY:", currentFY);
                                                            console.log("Last FY:", lastFY);

                                                            if (inputValue === currentFY) {
                                                                finicals1.value = "Current Financial Year";
                                                            } else if (inputValue === lastFY) {
                                                                finicals1.value = "Last Financial Year";
                                                            } else {
                                                                finicals1.value = "--Select--";
                                                            }
                                                        });
                                                    </script>

                                        <br>
                             
                                        <table class="table table-bordered custom-table mb-3" id="policyTable5" style="width:100%; table-layout:fixed; ">
                                            <thead> 
                                                <tr>
                                                    <th colspan="3" style="background-color: skyblue; text-align: center;">
                                                         ALTERNATIVE EMAIL ADDRESS
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th >Sr.No</th>
                                                    <th >Email</th>
                                                    <th >Action</th>
                                                </tr>
                                            </thead>
                                            <c:set var="c" value="0"/>
                                                    <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>

                                                    <c:if test="${vendorInformation.email1 != '' && !empty vendorInformation.email1}">
                                                        <tr>
                                                            <td style="width: 15vh;">
                                                                <input style="width: 15vh;" type="text" class="input-field" name="srNo1" value="${c + 1}" readonly />
                                                            </td>
                                                            <td>
                                                                <input name="emails" type="email" value="${vendorInformation.email1}" class="input-field email-field" maxlength="30" />
                                                            </td>
                                                            <td>
                                                              <div class="text-center">
                                                                <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email1}&a=1" class="d-inline-block text-danger p-1 mx-1" data-toggle="tooltip" data-placement="left" title="Delete">
                                                                    <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 22px; height: 22px;"/>
                                                                </a>                     
                                                            </div>
                                                            </td>
                                                        </tr>
                                                        <c:set var="c" value="${c + 1}" />
                                                    </c:if>

                                                    <c:if test="${vendorInformation.email2 != '' && !empty vendorInformation.email2}">
                                                        <tr>
                                                            <td style="width: 15vh;">
                                                                <input style="width: 15vh;" type="text" class="input-field" name="srNo2" value="${c + 1}" readonly />
                                                            </td>
                                                            <td>
                                                                <input type="email" name="emails" value="${vendorInformation.email2}" class="input-field email-field" maxlength="30" />
                                                            </td>
                                                            <td>
                                                             <div class="text-center">
                                                                <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email2}&a=2" class="d-inline-block text-danger p-1 mx-1" data-toggle="tooltip" data-placement="left" title="Delete">
                                                                    <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 22px; height: 22px;"/>
                                                                </a>                     
                                                            </div>   
                                                                
                                                                
<!--                                                                <span style="margin-top: 5px;">
                                                                    &nbsp;&nbsp;
                                                                    <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email2}&a=2">
                                                                        <i class="fa fa-trash"></i>
                                                                    </a>
                                                                </span>-->

                                                            </td>
                                                        </tr>
                                                        <c:set var="c" value="${c + 1}" />
                                                    </c:if>

                                                    <c:if test="${vendorInformation.email3 != '' && !empty vendorInformation.email3}">
                                                        <tr>
                                                            <td style="width: 15vh;">
                                                                <input style="width: 15vh;" type="text" class="input-field" name="srNo3" value="${c + 1}" readonly />
                                                            </td>
                                                            <td>
                                                                <input type="email" name="emails" value="${vendorInformation.email3}" class="input-field email-field" maxlength="30" />
                                                            </td>
                                                            <td>
                                                                <div class="text-center">
                                                                <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email3}&a=3" class="d-inline-block text-danger p-1 mx-1" data-toggle="tooltip" data-placement="left" title="Delete">
                                                                    <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon" style="width: 22px; height: 22px;"/>
                                                                </a>                     
                                                            </div> 
                                                                
                                                                
                                                                
<!--                                                                <span style="margin-top: 5px;">
                                                                    &nbsp;&nbsp;
                                                                    <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email3}&a=3">
                                                                        <i class="fa fa-trash"></i>
                                                                    </a>
                                                                </span>-->

                                                            </td>
                                                        </tr>
                                                        <c:set var="c" value="${c + 1}" />
                                                    </c:if>
                                                    <!-- Add new email row -->
                                                    
                                                    <tr id="policyRow1">
                                                        <td id="policyId1" style="width: 15vh;">
                                                            <input style="width: 15vh;" type="text" id="sr" class="input-field" name="srNo1" value="${c + 1}" readonly />
                                                        </td>
                                                        <td id="name1">
                                                            <input type="email" class="input-field email-field"  onchange="checkEmails(this)" name="emails"  placeholder="Vendor Email" id="email1" />
                                                            <span class="emailsError" style="color:red;"></span>
                                                        </td>
                                                        <script>
                                                            function checkEmails(input) {

                                                                var email = input.value.trim().toLowerCase();
                                                                var error = input.nextElementSibling;

                                                                var emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;

                                                                if (email !== "" && !emailPattern.test(email)) {
                                                                    error.innerText = "Enter valid email (example: abc@gmail.com)";
                                                                    input.style.border = "1px solid red";
                                                                } else {
                                                                    error.innerText = "";
                                                                    input.style.border = "1px solid #ccc";
                                                                }
                                                            }
                                                        </script>
                                                        <td style="text-align: center">
                                                            <div class="d-flex justify-content-center align-items-center">
                                                                <div class="clone-action clone-new-field d-flex justify-content-center align-items-center mb-2" id="policyCloneid5" style="cursor:pointer;">
                                                                    <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                                                </div>
                                                            </div>
                                                        </td> 
                                                    </tr>
                                                </table>
                                     
                                                <script>                                                           
                                                    var tempCount5 = 1;
                                                    $(function () {
                                                    $("#policyCloneid5").on("click", function () {
                                                    var currentRows = $("#policyTable5 tr").length - 1; // Subtract 1 for the header row
                                                                      if (currentRows >= 4) {
                                                            Swal.fire({
                                                                icon: 'warning',
                                                                title: 'Limit Reached',
                                                                text: 'You can only add up to 3 emails.',
                                                                confirmButtonText: 'OK'
                                                            });
                                                            return;
                                                        }

                                                     tempCount5++;
                                                    var clone = "<tr id='addmoreFile" + tempCount5 + "' style='clear:both;'>"
                                                    + "<td style=\"\"width: 15vh;\" id=\"policyId" + tempCount5 + "\"><input style=\"width: 15vh; \" type=\"text\" class=\"input-field\" name=\"srNo" + tempCount5 + "\" value=\"" + tempCount5 + "\" readonly></td>"
                                                    + "<td>"
                                                    + "<input type=\"email\" class=\"email-field input-field\" placeholder=\"Vendor Email\" name=\"emails\" id=\"email" + tempCount5 + "\" onchange=\"checkEmails(this)\" style=\"text-transform: lowercase;\">"
                                                    + "<span class='emailsError' style='color:red;'></span>"+ "</td>"
                                                    + "<td style='text-align:center; vertical-align:middle;'>"
                                                    + "<span style='margin-top:5px; display:inline-block;'>"
                                                    + "<div class='clone-action delete-parent-field' title='Remove' style='cursor:pointer; display:inline-flex; align-items:center; justify-content:center;' onclick=\"removePolicy('addmoreFile" + tempCount5 + "');\">"
                                                    + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove' style='width:30px; height:30px;'>"
                                                    + "</div>"
                                                    + "</span>"
                                                    + "</td style=''>"
                                                    + "</tr>";
                                                    $("#policyTable5").append(clone);
                                                    document.getElementById('policyCount5').value = tempCount5;

                                                    });
                                                    });
                                                    function removePolicy(policyDiv) {
                                                    try {
                                                    var element1 = document.getElementById(policyDiv);
                                                            element1.parentNode.removeChild(element1);
                                                            // Update the serial numbers
                                                            updateSerialNumbers();
                                                            // Update policyCount5
                                                            var policyCount5 = document.getElementById('policyTable5').rows.length - 1; // subtract 1 for header row
                                                            document.getElementById('policyCount5').value = policyCount5;
                                                    } catch (e) {
                                                    console.log(e);
                                                    }
                                                    }

                                                function updateSerialNumbers() {
                                                var table = document.getElementById('policyTable5');
                                                        var rowCount = table.rows.length;
                                                        var srNo = 1;
                                                        for (var i = 1; i < rowCount; i++) {
                                                if (table.rows[i].id !== '') { // Skip the header row
                                                table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
                                                }
                                                }
                                                }
                                            </script>   

                                            <script>
                                                document.getElementById('finicals1').addEventListener('change', function () {
                                                var selectedValue = this.value;
                                                        var currentDate = new Date();
                                                        var currentYear = currentDate.getFullYear();
                                                        var startYear, endYear;
                                                        if (currentDate.getMonth() >= 3) {
                                                startYear = currentYear;
                                                        endYear = currentYear + 1;
                                                } else {
                                                startYear = currentYear - 1;
                                                        endYear = currentYear;
                                                }

                                                var finicalInput1 = document.getElementById('finicalInput1');
                                                        var finicalInput2 = document.getElementById('finicalInput2');
                                                        var finicalInput3 = document.getElementById('finicalInput3');
                                                        if (selectedValue === "Current Financial Year") {
                                                finicalInput1.value = startYear + " - " + endYear;
                                                        finicalInput2.value = (startYear - 1) + " - " + startYear;
                                                        finicalInput3.value = (startYear - 2) + " - " + (startYear - 1);
                                                } else if (selectedValue === "Last Financial Year") {
                                                finicalInput1.value = (startYear - 1) + " - " + startYear;
                                                        finicalInput2.value = (startYear - 2) + " - " + (startYear - 1);
                                                        finicalInput3.value = (startYear - 3) + " - " + (startYear - 2);
                                                } else {
                                                finicalInput1.value = ""; // Clear the inputs if no valid selection
                                                        finicalInput2.value = "";
                                                        finicalInput3.value = "";
                                                }
                                                });
                                                        function formatNumber(input) {
                                                        // Remove all non-digit characters except the decimal point
                                                        let value = input.value.replace(/,/g, '').replace(/[^\d.]/g, '');
                                                                // Format number with commas
                                                                let parts = value.split('.');
                                                                parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                                                                input.value = parts.join('.');
                                                        }
                                            </script>                                  
 
                                        
                                        
                                    <div class="cta d-flex align-items-center justify-content-center" style="gap:15px;">
                                        <button type="submit" class="btn theme-btn" id="submit1" title="submit1">Save & Continue</button> 
                                        <%--<c:if test="${vendorInformation.status1 != 3 && vendorInformation.status1 != 4 && vendorInformation.status1 != 5}">
                                            <button type="submit" id="vendbasic" class="btn theme-btn" formaction="vendorInformation.htm?act=vendorCriteriaShow" onclick="return Validate()">Next</button>                                            
                                        </c:if>--%>
                                    </div>
                                    
                                    <script>
                                        document.getElementById("vendbasic1").addEventListener('click', function () {

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
      document.getElementById("myform").addEventListener("submit", function(e) {

    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,24}$/;
    var panPattern = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;
    var gstPattern = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$/;
    var msmePattern = /^UDYAM-[A-Z]{2}-[0-9]{2}-[0-9]{7}$/;

    // Email validation
    var emailFields = document.querySelectorAll(".email-field");
    for (var i = 0; i < emailFields.length; i++) {
        var field = emailFields[i];
        var email = field.value.trim();
        if (email !== "" && !emailPattern.test(email)) {
            e.preventDefault();
            Bootoast.toast({
                message: 'Please enter a valid email format',
                type: 'warn',
//                timeout: 2000,
                position: 'top-center'
            });
            field.focus();
            return;
        }
    }

    // PAN validation
    var panFields = document.querySelectorAll(".pan-field");
    for (var i = 0; i < panFields.length; i++) {
        var field = panFields[i];
        var pan = field.value.trim().toUpperCase();
        if (pan !== "" && !panPattern.test(pan)) {
            e.preventDefault();
            Bootoast.toast({
                message: 'Please enter a valid PAN number',
                type: 'warn',
                timeout: 2000,
                position: 'top-center'
            });
            field.focus();
            return;
        }
    }

    // GST validation
    var gstFields = document.querySelectorAll(".gst-field");
    for (var i = 0; i < gstFields.length; i++) {
        var field = gstFields[i];
        var gst = field.value.trim().toUpperCase();
        if (gst !== "" && !gstPattern.test(gst)) {
            e.preventDefault();
            Bootoast.toast({
                message: 'Please enter a valid GST number',
                type: 'warn',
                timeout: 2000,
                position: 'top-center'
            });
            field.focus();
            return;
        }
    }

    // MSME validation
    var msmeFields = document.querySelectorAll(".msme-field");
    for (var i = 0; i < msmeFields.length; i++) {
        var field = msmeFields[i];
        var msme = field.value.trim().toUpperCase();
        if (msme !== "" && !msmePattern.test(msme)) {
            e.preventDefault();
            Bootoast.toast({
                message: 'Please enter a valid MSME/Udyam number (UDYAM-XX-YY-ZZZZZZZ)',
                type: 'warn',
                timeout: 2000,
                position: 'top-center'
            });
            field.focus();
            return;
        }
    }

});

</script>
<script>
 $(document).ready(function () {

    // Common Validation Function for Both Buttons
    function validateForm(e) {

        var isValid = true;
        var firstInvalidElement = null;

        // Select all required fields (input, textarea, select)
        var requiredFields = $("input[required], textarea[required], select[required]");

        // Clear previous errors
        requiredFields.css("border", "");
        $(".error-message").remove(); // remove previous messages

        requiredFields.each(function () {
            var field = $(this);

            // Skip hidden fields
            if (field.is(':hidden') || field.parents(':hidden').length) {
                return true; // continue to next
            }

            // Check if empty
            if (field.val() === "" || field.val() === null || $.trim(field.val()) === "") {
                isValid = false;

                if (firstInvalidElement === null) {
                    firstInvalidElement = field;
                }

                // Add red border
                field.css("border", "1px solid red");

                // Logic to place error message correctly for phone fields
                var parentWrapper = field.closest('.phone-wrapper, .phone-wrapper1, .phone-equal, .phone-equals');

                if (parentWrapper.length > 0) {
                    // If it's a phone field, append error to the wrapper (so it goes below)
                    if (parentWrapper.find(".error-message").length === 0) {
                        parentWrapper.append('<div class="error-message">This field is required</div>');
                    }
                } else {
                    // For normal fields, append right after the field
                    if (field.next(".error-message").length === 0) {
                        field.after('<div class="error-message">This field is required</div>');
                    }
                }
            }
        });

        if (!isValid) {
            e.preventDefault(); // Stop form submit / redirect

            // Scroll and focus the first invalid field smoothly
            if (firstInvalidElement) {
                $('html, body').animate({
                    scrollTop: firstInvalidElement.offset().top - 150
                }, 500, function () {
                    firstInvalidElement.focus();
                });
            }
            
           
        }
    }

    // Bind validation to BOTH buttons
    $("#submit1").click(function (e) {
        validateForm(e);
    });

    $("#submit2").click(function (e) {
        validateForm(e);
    });

});
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
      
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
   
</html>
