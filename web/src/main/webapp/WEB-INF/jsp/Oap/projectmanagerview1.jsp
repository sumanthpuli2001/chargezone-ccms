
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Approval Details</title>
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
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
<form:form action="aocForm.htm?act=aocKickOffFormAssignUser" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                 
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">AOC Approval Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn mr-3"  formaction="oapForm.htm?act=projectmanagerClose1" title="" value="" >Close</button>
                                            <button type="submit" class="btn theme-btn mr-3"  formaction="oapForm.htm?act=projectmanagerCancel1" title="" value="" >Cancel</button>
                                            <button type="submit" class="btn theme-btn"  formaction="oapForm.htm?act=projectmanagerReject1" title="" value="" >Reject</button>
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
                    
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="aocFormId" value="${list55.id}">  
                    <input type="hidden" name="id" value="${id}">
                    
                                <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->


                                        <thead>
                                            <tr>
                                                <td colspan="6" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>Hub / Depo Order details </strong></td>
                                            </tr>

                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Document No.:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.documentNo}</span>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Hub / Depo Name:</strong></td>
                                                <td colspan="2"  style="border: 1px solid black;"><span>${list55.hubDepoName}</span>
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>B2B: </strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.bb2}</span>
                                                <td style="border: 1px solid black;"><strong>B2B2C:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.bbc22}</span>

                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>B2C</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.bc2}</span>
                                                </td>
                                                <td style="border: 1px solid black;"><strong>Client / Project Name:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.clientProjectName}</span>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Country</strong></td>
                                                <td colspan="1" style="border: 1px solid black;"><span>${list55.country}</span>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;"><strong>State</strong></td>
                                                <td colspan="3" style="border: 1px solid black;"><span>${list55.state}</span>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>City</strong></td>
                                                <td colspan="1" style="border: 1px solid black;"><span>${list55.city}</span>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;"><strong>Street</strong></td>
                                                <td colspan="3" style="border: 1px solid black;"><span>${list55.hubDepoAddress}</span>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>District</strong></td>
                                                <td colspan="1" style="border: 1px solid black;"><span>${list55.district}</span>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;"><strong>House No</strong></td>
                                                <td colspan="3" style="border: 1px solid black;"><span>${list55.houseNo}</span>
                                            </tr>





                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Google Co-ordinates: </strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.googleCoordinates}</span>

                                            </tr>


                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Pcs Type</strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="car" disabled id="car" value="${list55.pcTypeCar}" ${list55.pcTypeCar == '1' ? 'checked' : ''}> A. Car
                                                    </label>
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="bus" disabled id="bus" value="${list55.pcTypeBus}" ${list55.pcTypeBus == '1' ? 'checked' : ''}> B. Bus
                                                    </label>
                                                    <br>
                                                    <label style="display: inline;" >
                                                        <input type="checkbox" name="truck"  disabled id="truck" value="${list55.pcTypeTruckLmv}" ${list55.pcTypeTruckLmv == '1' ? 'checked' : ''}> C. Truck / LMV
                                                    </label>
                                                </td>

                                                <td colspan="1" style="border: 1px solid black;"><strong>Others:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.other}</span>
                                                </td>
                                            </tr>
                                            <!--                                            <tr>
                                                                                            <td style="border: 1px solid black;"><strong>PCS Type</strong></td>
                                                                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.pcsType}</span>
                                                                                            </td>
                                                                                        </tr>-->

                                            <tr>
                                                <td colspan="1"  style="border: 1px solid black;"><strong>Financial Model :  </strong></td>
                                                <td colspan="2" style="border: 1px solid black;"> 
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="capex" disabled id="capex" value="${list55.finacialModelCapex}" 
                                                               ${list55.finacialModelCapex == '1' ? 'checked' : ''}> A. Capex
                                                    </label>
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="opex" disabled id="opex" value="${list55.finacialModelOpex}" 
                                                               ${list55.finacialModelOpex == '1' ? 'checked' : ''}> B. Opex
                                                    </label>

                                                <td colspan="1" style="border: 1px solid black;"><strong>Co-ordinates: </strong></td>

                                                <td colspan="3" style="border: 1px solid black;"><span>${list55.coOrdinates}</span>


                                                </td>                                                 

                                            </tr>


                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Details of Contact Person:  </strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.firstName}</span>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Client E-mail</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.email}</span>
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Client Name:  </strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.mobileNo}</span>
                                                <td style="border: 1px solid black;"><strong>Mobile Number:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.alternateMobileNo}</span>

                                            </tr>



                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Charge Zone Scope Of work:</strong></td>
                                                <td colspan="6" style="border: 1px solid black;"><p>${list55.chargeScope}</p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Client Scope: </strong></td>
                                                <td colspan="6" style="border: 1px solid black;"><p>${list55.clientScope}</p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Specific requirements of the Client:</strong></td>
                                                <td colspan="6" style="border: 1px solid black;"><p>${list55.specificReqClients}</p>

                                                </td>
                                            </tr>


                                        <thead>
                                            <tr>
                                                <td colspan="6" style="border: 1px solid black; background-color: skyblue;text-align: center"><strong>Hub Deliverable Details </strong></td>
                                            </tr>

                                        </thead>

                                        <thead>
                                            <tr>
                                                <th colspan="1" style="border: 1px solid black;">Document Name</th>
                                                <th colspan="2" style="border: 1px solid black;">Document Reference Number / Document Path</th>
                                                <th colspan="1" style="border: 1px solid black;">Date:</th>
                                                <th colspan="2" style="border: 1px solid black;">Attachment:</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                                <th colspan="1" style="border: 1px solid black;">
                                                    (i) Assumption Sheet 
                                                    <input type="checkbox" style="margin-left: 5px;" name="assumption" disabled id="assumption"  value="${list55.assumptionSheet}" 
                                                           ${list55.assumptionSheet == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'assumptionRefNo', 'Fromdate1', 'file1')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;"><span>${list55.assumptionRefNo}</span>
                                                </td>
                                                <td colspan="1" style="border: 1px solid black;"><span>${list55.assumptionDate}</span>
                                                    <div class="input-group date">
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${list55.assumptionAttach}"><span>${list55.assumptionAttach}</span></a>


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
                                                <input type="checkbox" style="margin-left: 5px;" disabled name="boq" id="boq"  value="${list55.estimatedBoq}" 
                                                       ${list55.estimatedBoq == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'boqRefNo', 'Fromdate2', 'file2')">
                                            </th>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.estimatedRefNo}</span>
                                            </td>
                                            <td colspan="1" style="border: 1px solid black;">
                                                <div class="input-group date" id="datetimepickers1"><span>${list55.estimatedDate}</span>
                                                </div>
                                            </td> 

                                            <td colspan="2" style="border: 1px solid black;">
                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${list55.estimatedAttach}"><span>${list55.estimatedAttach}</span></a>


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
                                                <input type="checkbox" style="margin-left: 5px;" disabled name="lao" id="lao"  value="${list55.loaLoi}" 
                                                       ${list55.loaLoi == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'laoRefNo', 'Fromdate3', 'file3')">
                                            </th>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.loaLoiRefNo}</span>
                                            </td>
                                            <td colspan="1" style="border: 1px solid black; ">
                                                <div class="input-group date" id="datetimepickers2"><span>${list55.loaLoiDate}</span>
                                                </div>
                                            </td> 
                                            <td colspan="2" style="border: 1px solid black;">

                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${list55.loaAttach}"><span>${list55.loaAttach}</span></a>

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
                                                <input type="checkbox" style="margin-left: 5px;" disabled name="agremment" id="agremment"   value="${list55.agreement}" 
                                                       ${list55.agreement == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'agremmentRefNo', 'Fromdate4', 'file4')">
                                            </th>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.agreementRefNo}</span>
                                            </td>
                                            <td colspan="1" style="border: 1px solid black;">
                                                <div class="input-group date" id="datetimepickers3"><span>${list55.agreementDate}</span>
                                                </div>
                                            </td>   
                                            <td colspan="2" style="border: 1px solid black;">
                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${list55.agreementAttach}"><span>${list55.agreementAttach}</span></a>

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
                                                <input type="checkbox" style="margin-left: 5px;" disabled name="drawings" id="drawings"  value="${list55.layoutDrawings}" 
                                                       ${list55.layoutDrawings == '1' ? 'checked' : ''}  onclick="toggleInputs(this, 'drawingsRefNo', 'Fromdate5', 'file5')">
                                            </th>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.layoutRefNo}</span>
                                            </td>
                                            <td colspan="1" style="border: 1px solid black;">
                                                <div class="input-group date" id="datetimepickers4"><span>${list55.layoutDate}</span>
                                                </div>
                                            </td> 
                                            <td colspan="2" style="border: 1px solid black;">
                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${list55.layoutAttach}"><span>${list55.layoutAttach}</span></a>

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
                                                            textField.focus();
                                                    } else {
                                                    // Clear values before disabling fields
                                                    textField.value = "";
                                                            dateField.value = "";
                                                            fileField.value = "";
                                                            textField.disabled = true;
                                                            dateField.disabled = true;
                                                            fileField.disabled = true;
                                                            textField.classList.remove('blinking');
                                                    }
                                                    }

                                        </script>




                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Manpower Details: (A) Operations</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.operations}</p>

                                            </td>    
                                            <td colspan="1" style="border: 1px solid black;"><strong>Sign: </strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.operationsSign}</p>

                                            </td>  
                                        </tr>



                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>(B) Maintenance</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.maintenance}</p>

                                            </td>  

                                            <td colspan="1" style="border: 1px solid black;"><strong>Sign: </strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.maintenanceSign}</p>

                                            </td> 
                                        </tr>

                                       <tr>
                                <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Charger Installation Details</strong></td>
                            </tr>

                            <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Project Timeline Category</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.projectTimelineCategory}</p>
                                        
                                            <td colspan="1" style="border: 1px solid black;"><strong>Zero Date</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.zeroDate}</p>
                                        
                                        </tr>
                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Completion Date</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.completionDate}</p>
                                        
                                            <td colspan="1" style="border: 1px solid black;"><strong>No.of Days</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.chargingRatePerUnit}</p>
                                        
                                        </tr>
                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Budget Allocated for Project</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${list55.projectBudgetAllocated}</p>
                                        </tr>


                                        <thead>
                                            <tr>
                                                <td colspan="6" style="border: 1px solid black; background-color: skyblue; text-align: center" ><strong>(Ordinance) Order Review details</strong></td>
                                            </tr>

                                        </thead>

                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Reviewing Authority Comment:</strong></td>
                                            <td colspan="5" style="border: 1px solid black;"><p>${list55.authorityComments}</p>

                                            </td>                                                  
                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Order Effective Date:</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.orderEffcectiveDate}</span>

                                            </td>


                                            <td colspan="1" style="border: 1px solid black;"><strong>New Revision No:</strong></td>

                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.newRevisionNo}</span>


                                        </tr>

                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;">
                                                <strong>Budget allocation Date:</strong>
                                            </td>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.budjectAllocationDate}</span>

                                            </td>
                                        </tr>



                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Reviewed By: </strong></td>
                                            <td colspan="2"  style="border: 1px solid black;"><span>${list55.reviewedBy}</span>
                                            <td colspan="1"  style="border: 1px solid black;"><strong>Designation:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><span>${list55.designation}</span>

                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Project Profile:</strong></td>
                                            <td colspan="2"style="border: 1px solid black;"><span>${list55.projectProfile}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Profit Center:</strong></td>
                                            <td colspan="3"style="border: 1px solid black;"><span>${list55.projectCenter}</span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Company Code:</strong></td>
                                            <td colspan="2"style="border: 1px solid black;"><span>${list55.companyCode}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Plant:</strong></td>
                                            <td colspan="3"style="border: 1px solid black;"><span>${list55.plant}</span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Project Type:</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><span>${list55.projectType}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Project Currency</strong></td>
                                            <td colspan="3"style="border: 1px solid black;"><span>${list55.projectCurrency}</span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Investment Profile:</strong></td>
                                            <td  colspan="2" style="border: 1px solid black;"><span>${list55.inverstmentProfile}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Discom:</strong></td>
                                            <td  colspan="3" style="border: 1px solid black;"><span>${Discom1}</span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong></td>
                                            <td  colspan="2" style="border: 1px solid black;"><span>${list55.noOfChargePoints}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>No Of Charger</strong></td>
                                            <td  colspan="3" style="border: 1px solid black;"><span>${list55.noOfCharger}</span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Overall Station Capacity (KW):</strong></td>
                                            <td  colspan="2" style="border: 1px solid black;"><span>${list55.overallStationCapacityKw}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Station AC Capacity (KW):</strong></td>
                                            <td  colspan="3" style="border: 1px solid black;"><span>${list55.stationAcCapacityKw} </span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Station DC Capacity (KW):</strong></td>
                                            <td  colspan="2" style="border: 1px solid black;"><span>${list55.stationDcCapacityKw}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Total MegaWatt(MW):</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><span>${list55.totalMegaWatt}</span> </td>
                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Station Type:</strong></td>
                                            <td  colspan="2" style="border: 1px solid black;"><span>${list55.stationType}</span>

                                            </td>
                                            <td style="border: 1px solid black;"><strong>Tenant:</strong></td>
                                            <td  colspan="3"  style="border: 1px solid black;"><span>${list55.tenant}</span> </td>
                                        </tr>
                                    <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Kw Rating:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.totalKwRating}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.specificDateFromClient}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Charger Capacity:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.totalChargerCapacity}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charger Station Access Type:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.chargerStationAccessType}</span> </td>
                                                </tr>
                                                
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.auxiliaryLoadOfStation}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.chargingRetePerUnit}</span> </td>
                                                </tr>
                                                 <tr>
                                                    <td style="border: 1px solid black;"><strong>No. of EVs to be Charged / No. of Parking:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.noOfEvsToBeChanged}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Station Name:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.stationName}</span> </td>
                                                </tr>
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Anchore Customer:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.anchoreCustomer}</span> </td>
                                                    
                                                <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${list55.scopeOfchargeZone == 1 ? 'YES' : 'NO'}</span> </td>
                                                </tr>
                                               <c:if test="${not empty list55.canopyVarient}">
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Canopy Varient:</strong></td>
                                                    <td  style="border: 1px solid black;"><span>${list55.canopyVarient}</span> </td>
                                                </tr>
                                                </c:if>     
                                        
                                        
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Connection Type:</strong></td>
                                            <td  colspan="2" style="border: 1px solid black;"><span>${connection}</span>
                        <td style="border: 1px solid black;"><strong>Site Survey</strong></td>
                                        <td colspan="3" style="border: 1px solid black;"><span>${list55.siteSurvey}</span>

                                        </td>
                                        </tr>
                


                                        </tr>
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Survey</strong></td>
                                            <td style="border: 1px solid black;">
                                                <c:if test="${list55.surveyRadio == '1'}">
                                                    Site Survey Created
                                                </c:if>  
                                                <c:if test="${list55.surveyRadio == '0'}">
                                                    Site Survey Not Created
                                                </c:if>


                                            </td>
                                        </tr>

                                        <c:if test="${list55.surveyRadio == '1'}">
                                            <thead>
                                                <tr style="background-color: skyblue;">
                                                    <th colspan="1" style="text-align: center; vertical-align: middle; border: 1px solid black;">Sr No</th>
                                                    <th colspan="2" style="text-align: center; vertical-align: middle; border: 1px solid black;">Survey No</th>
                                                    <th colspan="4" style="text-align: center; vertical-align: middle; border: 1px solid black;">Project Representative</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="aocsurveyattach" items="${aocsurveyattach}" varStatus="status">
                                                    <tr>
                                                        <td colspan="1" style="border: 1px solid black;">${status.count}</td>
                                                        <td colspan="2" style="border: 1px solid black;"><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${aocsurveyattach.surveyNo}">${aocsurveyattach.surveyNo}</a></td>
                                                        <td colspan="4" style="border: 1px solid black;">${aocsurveyattach.projectRepresentative}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:if>

                                        <thead>
                                            <tr style=" background-color: skyblue;">
                                                <th colspan="3" style="text-align: center; vertical-align: middle ; border: 1px solid black;">Document Name</th>
                                                <th colspan="3" style="text-align: center; vertical-align: middle; border: 1px solid black;">Attachment
                                                    <c:if test="${prdSize != 0}">
                                                        <a href="aocForm.htm?act=aocDocxdownloadzip&fileName=${list[0]}&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                        </a>
                                                    </c:if>
                                                </th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="list" items="${list}" varStatus="status">
                                            <tr>


                                                <td colspan="3" style="border: 1px solid black;">${list[1]}</td>
                                                <td colspan="3" style="border: 1px solid black;">
                                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list[0]}&id1=${list55.id}">${list[0]}</a>
                                                </td>
                                            </tr>
                                        </c:forEach>


                                        <c:forEach var="list33" items="${list33}" varStatus="status">
                                            <tr>


                                                <td colspan="3" style="border: 1px solid black;">${list33[1]}</td>


                                                <td colspan="3" style="border: 1px solid black;"><a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list33[0]}&id1=${list55.id}">${list33[0]}</a></td>

                                            </tr>
                                        </c:forEach>

                                        <tr>
                                            <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Approval Status</strong></td>
                                        </tr>
                                        <thead>
                                            <tr>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Sr. No</th>
                                                <th colspan="2" style="text-align: center; vertical-align: middle;border: 1px solid black;">User</th>
                                                <th colspan="2" style="text-align: center; vertical-align: middle;border: 1px solid black;">Comment</th>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                                <tr>
                                                    <td style="border: 1px solid black;">${status.count}</td> <!-- Serial Number -->
                                                    <td colspan="2" style="border: 1px solid black;">${list0.userId}</td> <!-- User ID -->
                                                    <td colspan="2" style="border: 1px solid black;">${list0.approvalComment}</td> <!-- Approval Comment -->
                                                    <td style="border: 1px solid black;">
                                                        <c:if test="${list0.approvalStatus == '1'}">
                                                            Approved
                                                        </c:if>           
                                                        <c:if test="${list0.approvalStatus == '2'}">
                                                            Recycle
                                                        </c:if>
                                                        <c:if test="${list0.approvalStatus == '3'}">
                                                            Rejected
                                                        </c:if>
                                                    </td> <!-- Approval Status -->
                                                </tr>
                                            </c:forEach>
                                        </tbody>




                                        <!--                                            <thead>
                                                                                        <tr>
                                                                                            <td colspan="6" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Order Approved details { MARKETING }</strong></td>
                                                                                        </tr>
                                        
                                                                                    </thead>
                                        
                                        
                                                                                    <tr>
                                                                                        <td colspan="1" style="border: 1px solid black;"><strong>Approving Authority Comment: </strong></td>
                                                                                        <td colspan="6" style="border: 1px solid black;">
                                                                                            <textarea style="width: 100%; height: 100px; border: none; resize: none;"></textarea>
                                                                                        </td>
                                                                                    </tr>-->


                                    </table>



                                        <h6>Activity Milestone</h6>
                                    <table id="commonTable" class="table  table-striped bg-white" align="center" style="max-width:100%;">
                                        <thead>
                                          
                                            <tr>
                                                <th>Sr No</th>
                                                <th >Activity</th>
                                                <th >Activity By</th>
                                                <th >Date</th>
                                                <th >Status</th>
                                                <th>Comments</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="aoclogmaster" items="${aoclogmaster}" varStatus="status">
                                                <tr>
                                                    <td>${status.count}</td>
                                                    <td >${aoclogmaster.activity}</td>
                                                    <td >${aoclogmaster.activityBy}</td>
                                                    <td>${aoclogmaster.date}</td>
                                                    <td>${aoclogmaster.status}</td>
                                                    <td >${aoclogmaster.comments}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>      
                                        <div class="col-12 p-0">
                                            <div class="form-group comment-box">
                                                <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                                <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                                            </div>
                                        </div> 
                                        <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <button type="submit" class="btn theme-btn mr-3"  formaction="oapForm.htm?act=projectmanagerClose1" title="" value="" >Close</button>
                                            <button type="submit" class="btn theme-btn mr-3"  formaction="oapForm.htm?act=projectmanagerCancel1" title="" value="" >Cancel</button>
                                            <button type="submit" class="btn theme-btn"  formaction="oapForm.htm?act=projectmanagerReject1" title="" value="" >Reject</button>

                                        </div>
                                    </div>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
