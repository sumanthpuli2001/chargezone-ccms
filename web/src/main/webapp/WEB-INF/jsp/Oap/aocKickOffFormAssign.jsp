
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Approval Details</title>
    </head>
    <style>
        p {
            word-wrap: break-word; /* Allows words to break if necessary */
            max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
        }
        .break-after-20 {
            word-wrap: break-word;
            overflow-wrap: break-word;
            max-width: 50ch; /* Approximately 20 characters per line */
        }
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
                            <button type="submit" class="btn theme-btn"   title="" value="">Assign</button>

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

                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">
                    <div style=" max-width: 100%; margin: auto; border: 0px solid black;">
                        <br>
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
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
                                    <td style="border: 1px solid black;"><strong>Document No.:</strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.documentNo}</span>
                                    <td colspan="1" style="border: 1px solid black;"><strong>Hub / Depo Name:</strong></td>
                                    <td colspan="2"  style="border: 1px solid black;"><span>${aocForm1.hubDepoName}</span>
                                </tr>

                                <tr>
                                    <td style="border: 1px solid black;"><strong>B2B: </strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.bb2}</span>
                                    <td colspan="1" style="border: 1px solid black;"><strong>B2B2C:</strong></td>
                                    <td colspan="3"style="border: 1px solid black;"><span>${aocForm1.bbc22}</span>

                                </tr>

                                <tr>
                                    <td style="border: 1px solid black;"><strong>B2C</strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.bc2}</span>
                                    </td>
                                    <td style="border: 1px solid black;"><strong>Client / Project Name:</strong></td>
                                    <td colspan="2"style="border: 1px solid black;"><span>${aocForm1.clientProjectName}</span>
                                </tr>
                                <tr>
                                    <td style="border: 1px solid black;"><strong>Country:</strong></td>
                                    <td colspan="1" style="border: 1px solid black;"><span>${aocForm1.country}</span>
                                    </td>
                                    <td colspan="2" style="border: 1px solid black;"><strong>State:</strong></td>
                                    <td colspan="3" style="border: 1px solid black;"><span>${aocForm1.state}</span>
                                </tr>
                                <tr>
                                    <td style="border: 1px solid black;"><strong>City</strong></td>
                                    <td colspan="1" style="border: 1px solid black;"><span>${aocForm1.city}</span>
                                    </td>
                                    <td colspan="2" style="border: 1px solid black;"><strong>Street</strong></td>
                                    <td colspan="3" style="border: 1px solid black;"><span>${aocForm1.hubDepoAddress}</span>
                                </tr>
                                <tr>
                                    <td style="border: 1px solid black;"><strong>District:</strong></td>
                                    <td colspan="1" style="border: 1px solid black;"><span>${aocForm1.district}</span>
                                    </td>
                                    <td colspan="2" style="border: 1px solid black;"><strong>House No:</strong></td>
                                    <td colspan="3" style="border: 1px solid black;"><span>${aocForm1.houseNo}</span>
                                </tr>





                                <tr>
                                    <td colspan="1" style="border: 1px solid black;"><strong>Google Co-ordinates: </strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.googleCoordinates}</span>

                                </tr>



                                <tr>
                                    <td colspan="1" style="border: 1px solid black;"><strong>Pcs Type</strong></td>
                                    <td colspan="2" style="border: 1px solid black;">
                                        <label style="display: inline;">
                                            <input type="checkbox" name="car" disabled id="car" value="${aocForm1.pcTypeCar}" ${aocForm1.pcTypeCar == '1' ? 'checked' : ''}> A. Car
                                        </label>
                                        <label style="display: inline;">
                                            <input type="checkbox" name="bus" disabled id="bus" value="${aocForm1.pcTypeBus}" ${aocForm1.pcTypeBus == '1' ? 'checked' : ''}> B. Bus
                                        </label>
                                        <label style="display: inline;" >
                                            <input type="checkbox" name="truck"  disabled id="truck" value="${aocForm1.pcTypeTruckLmv}" ${aocForm1.pcTypeTruckLmv == '1' ? 'checked' : ''}> C. Truck / LMV
                                        </label>
                                    </td>

                                    <td colspan="1" style="border: 1px solid black;"><strong>Others:</strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.other}</span>
                                    </td>
                                </tr>
                                <!--                                            <tr>
                                                                                <td style="border: 1px solid black;"><strong>PCS Type</strong></td>
                                                                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.pcsType}</span>
                                                                                </td>
                                                                            </tr>-->

                                <tr>
                                    <td colspan="1"  style="border: 1px solid black;"><strong>Financial Model :  </strong></td>
                                    <td colspan="2" style="border: 1px solid black;"> 
                                        <label style="display: inline;">
                                            <input type="checkbox" name="capex" disabled id="capex" value="${aocForm1.finacialModelCapex}" 
                                                   ${aocForm1.finacialModelCapex == '1' ? 'checked' : ''}> A. Capex
                                        </label>
                                        <label style="display: inline;">
                                            <input type="checkbox" name="opex" disabled id="opex" value="${aocForm1.finacialModelOpex}" 
                                                   ${aocForm1.finacialModelOpex == '1' ? 'checked' : ''}> B. Opex
                                        </label>

                                    <td colspan="1" style="border: 1px solid black;"><strong>Co-ordinates: </strong></td>

                                    <td colspan="3" style="border: 1px solid black;"><span>${aocForm1.coOrdinates}</span>


                                    </td>                                                 

                                </tr>


                                <tr>
                                    <td style="border: 1px solid black;"><strong>Details of Contact Person:  </strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.firstName}</span>
                                    <td colspan="1" style="border: 1px solid black;"><strong>Client E-mail:</strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.email}</span>
                                </tr>

                                <tr>
                                    <td style="border: 1px solid black;"><strong>Client Name:  </strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.mobileNo}</span>
                                    <td style="border: 1px solid black;"><strong>Mobile Number:</strong></td>
                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.alternateMobileNo}</span>

                                </tr>


                                <tr>
                                    <td style="border: 1px solid black;"><strong>Specific Requirements of the Client:</strong></td>
                                    <td colspan="6" style="border: 1px solid black;"><p>${aocForm1.specificReqClients}</p>

                                    </td>
                                </tr>
                                <tr>
                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of Work:</strong></td>
                                    <td colspan="6" style="border: 1px solid black;"><p>${aocForm1.chargeScope}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="border: 1px solid black;"><strong>Client Scope: </strong></td>
                                    <td colspan="6" style="border: 1px solid black;"><p>${aocForm1.clientScope}</p>
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
                                    <th colspan="2" style="border: 1px solid black;">Date</th>
                                    <th colspan="2" style="border: 1px solid black;">Attachment</th>

                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <th colspan="1" style="border: 1px solid black;">
                                        (i) Assumption Sheet 
                                        <input type="checkbox" style="margin-left: 5px;" name="assumption" disabled id="assumption"  value="${aocForm1.assumptionSheet}" 
                                               ${aocForm1.assumptionSheet == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'assumptionRefNo', 'Fromdate1', 'file1')">
                                    </th>
                                    <td colspan="2" style="border: 1px solid black;">
                                        <span>${aocForm1.assumptionRefNo}</span>
                                    </td>
                                    <td colspan="1" style="border: 1px solid black;">
                                        <div class="input-group date">  <span>${aocForm1.assumptionDate}</span>
                                        </div>
                                    </td> 
                                    <td colspan="2" style="border: 1px solid black;">

                                        <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm1.assumptionAttach}&id1=${id}"><span>${aocForm1.assumptionAttach}</span></a>
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
                                    <input type="checkbox" style="margin-left: 5px;" disabled name="boq" id="boq"  value="${aocForm1.estimatedBoq}" 
                                           ${aocForm1.estimatedBoq == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'boqRefNo', 'Fromdate2', 'file2')">
                                </th>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.estimatedRefNo}</span>
                                </td>
                                <td colspan="1" style="border: 1px solid black;">
                                    <div class="input-group date" id="datetimepickers1"><span>${aocForm1.estimatedDate}</span>
                                    </div>
                                </td> 

                                <td colspan="2" style="border: 1px solid black;">
                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm1.estimatedAttach}&id1=${id}"><span>${aocForm1.estimatedAttach}</span></a>


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
                                    <input type="checkbox" style="margin-left: 5px;" disabled name="lao" id="lao"  value="${aocForm1.loaLoi}" 
                                           ${aocForm1.loaLoi == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'laoRefNo', 'Fromdate3', 'file3')">
                                </th>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.loaLoiRefNo}</span>
                                </td>
                                <td colspan="1" style="border: 1px solid black; ">
                                    <div class="input-group date" id="datetimepickers2"><span>${aocForm1.loaLoiDate}</span>
                                    </div>
                                </td> 
                                <td colspan="2" style="border: 1px solid black;">
                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm1.loaAttach}&id1=${id}"><span>${aocForm1.loaAttach}</span></a>


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
                                           ${aocForm1.agreement == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'agremmentRefNo', 'Fromdate4', 'file4')">
                                </th>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.agreementRefNo}</span>
                                </td>
                                <td colspan="1" style="border: 1px solid black;">
                                    <div class="input-group date" id="datetimepickers3"><span>${aocForm1.agreementDate}</span>
                                    </div>
                                </td>   
                                <td colspan="2" style="border: 1px solid black;">
                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm1.agreementAttach}&id1=${id}"><span>${aocForm1.agreementAttach}</span></a>

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
                                    <input type="checkbox" style="margin-left: 5px;" disabled name="drawings" id="drawings"  value="${aocForm1.layoutDrawings}" 
                                           ${aocForm1.layoutDrawings == '1' ? 'checked' : ''}  onclick="toggleInputs(this, 'drawingsRefNo', 'Fromdate5', 'file5')">
                                </th>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.layoutRefNo}</span>
                                </td>
                                <td colspan="1" style="border: 1px solid black;">
                                    <div class="input-group date" id="datetimepickers4"><span>${aocForm1.layoutDate}</span>
                                    </div>
                                </td> 
                                <td colspan="2" style="border: 1px solid black;">
                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm1.layoutAttach}&id1=${id}"><span>${aocForm1.layoutAttach}</span></a>

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
                                <td colspan="1" style="border: 1px solid black; font-weight: bold;">
                                    Manpower Details: (A) Operations
                                </td>
                                <td colspan="2" style="border: 1px solid black;">
                                    <p class="break-after-20" style="margin: 0; padding: 2px;">${aocForm1.operations}</p>
                                </td>    
                                <td colspan="1" style="border: 1px solid black; font-weight: bold;">
                                    Sign:
                                </td>
                                <td colspan="2" style="border: 1px solid black;">
                                    <p class="break-after-20" style="margin: 0; padding: 2px;">${aocForm1.operationsSign}</p>
                                </td>  
                            </tr>




                            <tr>
                                <td colspan="1" style="border: 1px solid black;"><strong>(B) Maintenance:</strong></td>
                                <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.maintenance}</p>

                                </td>  

                                <td colspan="1" style="border: 1px solid black;"><strong>Sign: </strong></td>
                                <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.maintenanceSign}</p>

                                </td> 
                            </tr>

                            <tr>
                                <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Charger Installation Details</strong></td>
                            </tr>

                            <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Project Timeline Category</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.projectTimelineCategory}</p>
                                        
                                            <td colspan="1" style="border: 1px solid black;"><strong>Zero Date</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.zeroDate}</p>
                                        
                                        </tr>
                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Completion Date</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.completionDate}</p>
                                        
                                            <td colspan="1" style="border: 1px solid black;"><strong>No.of Days</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.chargingRatePerUnit}</p>
                                        
                                        </tr>
                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;"><strong>Budget Allocated for Project</strong></td>
                                            <td colspan="2" style="border: 1px solid black;"><p class="break-after-20">${aocForm1.projectBudgetAllocated}</p>
                                        </tr>


                            <thead>
                                <tr>
                                    <td colspan="6" style="border: 1px solid black; background-color: skyblue; text-align: center" ><strong>(Ordinance) Order Review details</strong></td>
                                </tr>

                            </thead>

                            <tr>
                                <td colspan="1" style="border: 1px solid black;"><strong>Reviewing Authority Comment:</strong></td>
                                <td colspan="5" style="border: 1px solid black;"><p>${aocForm1.authorityComments}</p>

                                </td>                                                  
                            </tr>

                            <tr>
                                <td style="border: 1px solid black;"><strong>Order Effective Date:</strong></td>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.orderEffcectiveDate}</span>

                                </td>


                                <td colspan="1" style="border: 1px solid black;"><strong>New Revision No.:</strong></td>

                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.newRevisionNo}</span>


                            </tr>

                            <tr>
                                <td colspan="1" style="border: 1px solid black;">
                                    <strong>Budget Allocation Date:</strong>
                                </td>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.budjectAllocationDate}</span>

                                </td>
                            </tr>



                            <tr>
                                <td style="border: 1px solid black;"><strong>Reviewed By: </strong></td>
                                <td colspan="2"  style="border: 1px solid black;"><span>${aocForm1.reviewedBy}</span>
                                <td colspan="2"  style="border: 1px solid black;"><strong>Designation:</strong></td>
                                <td colspan="3" style="border: 1px solid black;"><span>${aocForm1.designation}</span>

                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Project Profile:</strong></td>
                                <td colspan="2"style="border: 1px solid black;"><span>${aocForm1.projectProfile}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>Profit Center:</strong></td>
                                <td colspan="3"style="border: 1px solid black;"><span>${aocForm1.projectCenter}</span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Company Code:</strong></td>
                                <td colspan="2"style="border: 1px solid black;"><span>${aocForm1.companyCode}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>Plant:</strong></td>
                                <td colspan="3"style="border: 1px solid black;"><span>${aocForm1.plant}</span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Project Type:</strong></td>
                                <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.projectType}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>Project Currency:</strong></td>
                                <td colspan="3"style="border: 1px solid black;"><span>${aocForm1.projectCurrency}</span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Investment Profile:</strong></td>
                                <td  colspan="2" style="border: 1px solid black;"><span>${aocForm1.inverstmentProfile}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>Discom:</strong></td>
                                <td  colspan="3" style="border: 1px solid black;"><span>${Discom1}</span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong></td>
                                <td  colspan="2" style="border: 1px solid black;"><span>${aocForm1.noOfChargePoints}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>No Of Charger:</strong></td>
                                <td  colspan="3" style="border: 1px solid black;"><span>${aocForm1.noOfCharger}</span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Overall Station Capacity (KW):</strong></td>
                                <td  colspan="2" style="border: 1px solid black;"><span>${aocForm1.overallStationCapacityKw}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>Station AC Capacity (KW):</strong></td>
                                <td  colspan="3" style="border: 1px solid black;"><span>${aocForm1.stationAcCapacityKw} </span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Station DC Capacity (KW):</strong></td>
                                <td  colspan="2" style="border: 1px solid black;"><span>${aocForm1.stationDcCapacityKw}</span>

                                </td>
                               <td style="border: 1px solid black;"><strong>Total MegaWatt(MW):</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><span>${aocForm1.totalMegaWatt}</span> </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Station Type:</strong></td>
                                <td  colspan="2" style="border: 1px solid black;"><span>${aocForm1.stationType}</span>

                                </td>
                                <td style="border: 1px solid black;"><strong>Tenant:</strong></td>
                                <td  colspan="3"  style="border: 1px solid black;"><span>${aocForm1.tenant}</span> </td>
                            </tr>
                            
                           <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Kw Rating:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.totalKwRating}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.specificDateFromClient}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Charger Capacity:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.totalChargerCapacity}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charger Station Access Type:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.chargerStationAccessType}</span> </td>
                                                </tr>
                                                
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.auxiliaryLoadOfStation}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.chargingRetePerUnit}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>No. of EVs to be Charged / No. of Parking:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.noOfEvsToBeChanged}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Station Name:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.stationName}</span> </td>
                                                </tr>
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Anchore Customer:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.anchoreCustomer}</span> </td>
                                                    
                                                <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><span>${aocForm1.scopeOfchargeZone == 1 ? 'YES' : 'NO'}</span> </td>
                                                </tr>
                                               <c:if test="${not empty aocForm1.canopyVarient}">
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Canopy Varient:</strong></td>
                                                    <td  style="border: 1px solid black;"><span>${aocForm1.canopyVarient}</span> </td>
                                                </tr>
                                                </c:if>
                            
                            
                            <tr>
                                <td style="border: 1px solid black;"><strong>Connection Type</strong></td>
                                <td  colspan="2" style="border: 1px solid black;"><span>${connection}</span>
                                <td style="border: 1px solid black;"><strong>Site Survey</strong></td>
                                <td colspan="3"style="border: 1px solid black;"><span>${aocForm1.siteSurvey}</span>

                                </td>  


                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><strong>Survey</strong></td>
                                <td style="border: 1px solid black;">
                                    <c:if test="${aocForm1.surveyRadio == '1'}">
                                        Site Survey Created
                                    </c:if>  
                                    <c:if test="${aocForm1.surveyRadio == '0'}">
                                        Site Survey Not Created
                                    </c:if>


                                </td>
                            </tr>
                            <!--                                        <tr>
                                                                        <td colspan="1" style="border: 1px solid black;"><strong>Signature & Date: </strong></td>
                                                                        <td colspan="6" style="border: 1px solid black;"><p>${aocForm1.signatureDate}</p>
                            
                                                                        </td>
                                                                    </tr>      
                            
                            <thead>-->

                            <c:if test="${aocForm1.surveyRadio == '1'}">
                                <thead>
                                    <tr style="background-color: skyblue;">
                                        <th colspan="1" style="text-align: center; vertical-align: middle; border: 1px solid black;">Sr No</th>
                                        <th colspan="2" style="text-align: center; vertical-align: middle; border: 1px solid black;">Survey No</th>
                                        <th colspan="3" style="text-align: center; vertical-align: middle; border: 1px solid black;">Project Representative</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="aocsurveyattach" items="${aocsurveyattach}" varStatus="status">
                                        <tr>
                                            <td colspan="1" style="border: 1px solid black;">${status.count}</td>
                                            <td colspan="2" style="border: 1px solid black;"><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${aocsurveyattach.surveyNo}">${aocsurveyattach.surveyNo}</a></td>
                                            <td colspan="3" style="border: 1px solid black;">${aocsurveyattach.projectRepresentative}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </c:if>
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
                                        <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list[0]}&id1=${id}">${list[0]}</a>
                                    </td>
                                </tr>
                            </c:forEach>


                            <c:forEach var="list33" items="${list33}" varStatus="status">
                                <tr>


                                    <td colspan="3" style="border: 1px solid black;">${list33[1]}</td>


                                    <td colspan="3" style="border: 1px solid black;"><a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>

                                </tr>
                            </c:forEach>


                            <tr>
                                <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Approval Status</strong></td>
                            </tr>
                            <thead>
                                <tr>
                                    <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Sr. No.</th>
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

                        </table>
                        <table>
                            <div class="rounded-4 mt-4">
                                <div class="row mb-3">
                                    <div class="col-lg-6 col-md-9">
                                        <div class="form-group">
                                            <label  class="label"> Project Co-ordinator:<span style="color: red; font-size: 12px;">*</span></label>

                                            <select id="employee_code" name="employee_code" class="select-input" required>
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list31" items="${list31}" varStatus="status">
                                                    <option value="${list31[1]}">${list31[0]}</option>
                                                </c:forEach>
                                            </select>   
                                        </div>   
                                    </div>
                                    <div class="col-lg-6 col-md-9">
                                        <div class="form-group">
                                            <label  class="label"> Project Manager:<span style="color: red; font-size: 12px;">*</span></label>
                                            </label>
                                            <select id="projectcoordinator" name="projectcoordinator" class="select-input" required>
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list30" items="${list30}" varStatus="status">
                                                    <option value="${list30[1]}">${list30[0]}</option>
                                                </c:forEach>
                                            </select>  
                                        </div>   
                                    </div>
                                </div>
                            </div>     
                        </table>  

                        <div class="form-group">
                            <div style="display: flex;  justify-content: center;">
                                <button type="submit" class="btn theme-btn"   title="" value="">Assign</button>
                            </div>
                        </div>


                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
