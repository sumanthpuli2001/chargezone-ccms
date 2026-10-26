
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Form Recycle Edit</title>
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
<form:form action="aocForm.htm?act=aocFormRecycleEditsubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation1"
                   name='form1'  onsubmit="return surveyValidate();" class="form-horizontal" role="form">           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">AOC Form Recycle Edit</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                         <button type="submit" class="btn theme-btn"   title="" value="">SUBMIT</button>
                    </div>
                </div>
            <input type="hidden" name="size" id="size" value="${size}">
            <input type="hidden" name="id" value="${aocForm.id}">
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
                    <div style=" max-width: 100%; margin: auto; border: 0px solid black;">
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                                <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                            </div>
                        </div>
                    </div>
                    <br>
            <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->


                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black; background-color: skyblue"><strong>Hub / Depo Order details </strong></td>
                                                </tr>

                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Document No.:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black; width: 26%;"><input  class="input-field" name="documentNo" id="documentNo" value="${aocForm.documentNo}"  readonly /> </td>                                                   
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Hub / Depo Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"  style="border: 1px solid black;"><input  class="input-field" name="depoName" id="depoName" value="${aocForm.hubDepoName}"/> </td>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>B2B: </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="b2b" id="b2b" value="${aocForm.bb2}"/> </td>                                                   
                                                    <td style="border: 1px solid black;"><strong>B2B2C:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="b2b2c" id="b2b2c" value="${aocForm.bbc22}"/> </td>

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>B2C</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="b2c" id="b2c" value="${aocForm.bc2}" required />
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Client / Project Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <!--<td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="projectName" id="projectName" value="${aocForm.clientProjectName}"/> </td>-->    
                                                <td colspan="2"  style="border: 1px solid black; ">
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
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Country:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="country" id="country" value="${aocForm.country}"   readonly="true"/>
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>State</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="state" id="state" value="${aocForm.state}"  readonly="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>City:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="city" id="city" value="${aocForm.city}" required />
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Street:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="depoAddress" id="depoAddress" value="${aocForm.hubDepoAddress}"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>District:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="district" id="district" value="${aocForm.district}" required />
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>House No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="houseno" id="houseno" value="${aocForm.houseNo}"/> </td>    
                                                </tr>



                                                <tr>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Google Co-ordinates: </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="googleCoordinates" id="googleCoordinates" value="${aocForm.googleCoordinates}"/> </td>                                                   

                                                </tr>


                                                <tr>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Pcs Type</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="car" id="car" value="${aocForm.pcTypeCar}" ${aocForm.pcTypeCar == '1' ? 'checked' : ''}> A.Car
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="bus" id="bus" value="${aocForm.pcTypeBus}" ${aocForm.pcTypeBus == '1' ? 'checked' : ''}> B.Bus
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="truck" id="truck" value="${aocForm.pcTypeTruckLmv}" ${aocForm.pcTypeTruckLmv == '1' ? 'checked' : ''}> C.Truck / LMV
                                                        </div>
                                                    </td>

                                                    <td colspan="1" style="border: 1px solid black;"><strong>Others:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input class="input-field" name="others" id="others" value="${aocForm.other}"/>
                                                    </td>
                                                </tr>
<!--                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>PCS Type</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="input-field" name="pcs" id="pcs" value="${aocForm.pcsType}" required />
                                                    </td>
                                                </tr>-->

                                                <tr>
                                                    <td colspan="1"  style="border: 1px solid black;"><strong>Financial Model :  </strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"> 
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="capex" id="capex" value="${aocForm.finacialModelCapex}" 
                                                                   ${aocForm.finacialModelCapex == '1' ? 'checked' : ''}> A. Capex
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="opex" id="opex" value="${aocForm.finacialModelOpex}" 
                                                                   ${aocForm.finacialModelOpex == '1' ? 'checked' : ''}> B. Opex
                                                        </div>

                                                    <td colspan="1" style="border: 1px solid black;"><strong>Co-ordinates: </strong><span style="color: red;font-size: 12px;">*</span></td>

                                                    <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="coordinates" id="coordinates" value="${aocForm.coOrdinates}"/> </td>                                                   


                                                    </td>                                                 

                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Details of Contact Person:  </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input placeholder="FisrtName" class="input-field" name="firstName" id="firstName" value="${aocForm.firstName}"/> </td>                                                   
                                                    <td style="border: 1px solid black;"><strong>Client E-mail:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="email" id="email"type="email" value="${aocForm.email}"/> </td>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Client Name:  </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="mobileNo" id="mobileNo" value="${aocForm.mobileNo}" /> </td>                                                   
                                                    <td style="border: 1px solid black;"><strong>Mobile Number:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="altNo" id="altNo" value="${aocForm.alternateMobileNo}"/> </td>

                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of work<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="6" style="border: 1px solid black;">
                                                        <textarea class="textarea-field" style=" height: 100px; border: none; resize: none;" name="scopework" id="scopework">${aocForm.chargeScope}</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Client Scope <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="6" style="border: 1px solid black;">
                                                        <textarea class="textarea-field" style=" height: 100px; border: none; resize: none;" name="scope" id="scope">${aocForm.clientScope}</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Specific Requirements of The Client:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="6" style="border: 1px solid black;">
                                                        <textarea class="textarea-field" style=" height: 100px; border: none; resize: none;" 
                                                                  name="reqClients" id="reqClients">${aocForm.specificReqClients}</textarea>
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
                                                    <th colspan="2" style="border: 1px solid black;">Document Ref No / Document Path</th>
                                                    <th colspan="1" style="border: 1px solid black;">Date:</th>
                                                    <th colspan="2" style="border: 1px solid black;">Attachment</th>

                                                </tr>
                                            </thead>
                                                <tbody>
                                                <tr>
                                                    <th colspan="1" style="border: 1px solid black;">
                                                        (i) Assumption Sheet
                                                        <input type="checkbox" name="assumption" id="assumption" value="${aocForm.assumptionSheet}" 
                                                               ${aocForm.assumptionSheet == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'assumptionRefNo', 'Fromdate1', 'file1', 'assumptionAttach')">
                                                    </th>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="input-field" ${aocForm.assumptionSheet != '1' ? 'disabled' : ''} id="assumptionRefNo" name="assumptionRefNo" value="${aocForm.assumptionRefNo}"/>
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input placeholder="DD/MM/YYYY" ${aocForm.assumptionSheet != '1' ? 'disabled' : ''} name="Fromdate1" id="Fromdate1" type="text" class="input-field form_datetime" maxlength="30" value="${aocForm.assumptionDate}"/>
                                                        </div>
                                                    </td> 
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm.assumptionAttach}&id1=${aocForm.id}"> <span id="assumptionAttach">${aocForm.assumptionAttach}</span></a>
                                                        <input type="hidden" name="file11" value="${aocForm.assumptionAttach}" id="file11">
                                                        <input type="file" class="input-field" id="file1" name="file1" ${aocForm.assumptionSheet != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" name="boq" id="boq" value="${aocForm.estimatedBoq}" 
                                                           ${aocForm.estimatedBoq == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'boqRefNo', 'Fromdate2', 'file2', 'estimatedAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="input-field" ${aocForm.estimatedBoq != '1' ? 'disabled' : ''} id="boqRefNo" name="boqRefNo" value="${aocForm.estimatedRefNo}" />
                                                </td>
                                                <td colspan="1" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers1"  >
                                                        <input placeholder="DD/MM/YYYY" ${aocForm.estimatedBoq != '1' ? 'disabled' : ''} name="Fromdate2" id="Fromdate2" type="text" class="input-field form_datetime" value="${aocForm.estimatedDate}" maxlength="30" />
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm.estimatedAttach}&id1=${aocForm.id}"><span id="estimatedAttach">${aocForm.estimatedAttach}</span></a>
                                                    <input type="hidden" name="file12" value="${aocForm.estimatedAttach}" id="file12">
                                                    <input type="file" class="input-field" id="file2" name="file2" ${aocForm.estimatedBoq != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" name="lao" id="lao" value="${aocForm.loaLoi}" 
                                                           ${aocForm.loaLoi == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'laoRefNo', 'Fromdate3', 'file3', 'loaAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="input-field" ${aocForm.loaLoi != '1' ? 'disabled' : ''} id="laoRefNo" name="laoRefNo" value="${aocForm.loaLoiRefNo}" />
                                                </td>
                                                <td colspan="1" style="border: 1px solid black;min-width: 25%;">
                                                    <div class="input-group date" id="datetimepickers2"  > 
                                                        <input placeholder="DD/MM/YYYY" ${aocForm.loaLoi != '1' ? 'disabled' : ''} name="Fromdate3" id="Fromdate3" type="text" class="input-field form_datetime" value="${aocForm.loaLoiDate}" maxlength="30"  />
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm.loaAttach}&id1=${aocForm.id}"> <span id="loaAttach">${aocForm.loaAttach}</span></a>
                                                    <input type="hidden" name="file13" value="${aocForm.loaAttach}" id="file13">
                                                    <input type="file" class="input-field" id="file3" name="file3" ${aocForm.loaLoi != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" name="agremment" id="agremment" value="${aocForm.agreement}" 
                                                           ${aocForm.agreement == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'agremmentRefNo', 'Fromdate4', 'file4', 'agreementAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="input-field" id="agremmentRefNo" ${aocForm.agreement != '1' ? 'disabled' : ''} name="agremmentRefNo" value="${aocForm.agreementRefNo}"/>
                                                </td>
                                                <td colspan="1" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers3"  >
                                                        <input placeholder="DD/MM/YYYY" name="Fromdate4" ${aocForm.agreement != '1' ? 'disabled' : ''} id="Fromdate4" type="text" class="input-field form_datetime" value="${aocForm.agreementDate}" maxlength="30"  />
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm.agreementAttach}&id1=${aocForm.id}">  <span id="agreementAttach">${aocForm.agreementAttach}</span></a>
                                                    <input type="hidden" name="file14" value="${aocForm.agreementAttach}" id="file14">
                                                    <input type="file" class="input-field" id="file4" name="file4" ${aocForm.agreement != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" name="drawings" id="drawings" value="${aocForm.layoutDrawings}" 
                                                           ${aocForm.layoutDrawings == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'drawingsRefNo', 'Fromdate5', 'file5', 'layoutAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="input-field" id="drawingsRefNo" ${aocForm.layoutDrawings != '1' ? 'disabled' : ''} name="drawingsRefNo" value="${aocForm.layoutRefNo}" />
                                                </td>
                                                <td colspan="1" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers4"  >
                                                        <input placeholder="DD/MM/YYYY" name="Fromdate5" ${aocForm.layoutDrawings != '1' ? 'disabled' : ''} id="Fromdate5" type="text" class="input-field form_datetime" value="${aocForm.layoutDate}" maxlength="30"  />
                                                    </div>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${aocForm.layoutAttach}&id1=${aocForm.id}">  <span id="layoutAttach">${aocForm.layoutAttach}</span></a>
                                                    <input type="hidden" name="file15" value="${aocForm.layoutAttach}" id="file15">
                                                    <input type="file" class="input-field" id="file5" name="file5" ${aocForm.layoutDrawings != '1' ? 'disabled' : ''} />
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
                                                        function toggleInputs(checkbox, textId, dateId, fileId, spanId) {
                                                        const textField = document.getElementById(textId);
                                                                const dateField = document.getElementById(dateId);
                                                                const fileField = document.getElementById(fileId);
                                                                const spanElement = document.getElementById(spanId);
                                                                if (checkbox.checked) {
                                                        textField.disabled = false;
                                                                dateField.disabled = false;
                                                                fileField.disabled = false; // Enable file field
                                                                textField.classList.add('blinking');
                                                                textField.focus(); // Focus on the text field
                                                        } else {
                                                        textField.disabled = true;
                                                                dateField.disabled = true;
                                                                fileField.disabled = true; // Disable file field
                                                                textField.classList.remove('blinking');
                                                                textField.value = ""; // Clear the text field
                                                                dateField.value = ""; // Clear the date field
                                                                spanElement.textContent = ""; // Clear the span content
                                                                fileField.value = ""; // Clear the file input value
                                                        }
                                                        }
                                            </script>





                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Manpower Details: (A) Operations<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style=" height: 50px; border: none; resize: none;" 
                                                              name="operations" id="operations">${aocForm.operations}</textarea>
                                                </td>    
                                                <td colspan="1" style="border: 1px solid black;"><strong>Sign: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea  class="textarea-field" style=" height: 50px; border: none; resize: none;" 
                                                              placeholder="Note: Mention the Nos. & Competency of Person Required" 
                                                              name="operationsSign" id="operationsSign">${aocForm.operationsSign}</textarea>
                                                </td>  
                                            </tr>



                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>(B) Maintenance<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style=" height: 50px; border: none; resize: none;" 
                                                              name="maintenance" id="maintenance">${aocForm.maintenance}</textarea>
                                                </td>  

                                                <td colspan="1" style="border: 1px solid black;"><strong>Sign: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style=" height: 50px; border: none; resize: none;" 
                                                              placeholder="Note: Ensure signature of Director(RM Sir) if NO Manpower is Required on Site" 
                                                              name="maintenancesign" id="maintenancesign">${aocForm.maintenanceSign}</textarea>
                                                </td> 
                                            </tr>







                                            <tr>
                                                <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Charger Installation Details</strong></td>
                                            </tr>


                                           <thead>
                                                 <tr>
                                                                                   <td  style="border: 1px solid black;"><strong>Project Timeline Category:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <select class="select-input" name="projectTimelineCategory" id="projectTimelineCategory" required>
                                                            <option value="">-- Select--</option>
                                                           
                                                            <option value="LT" ${aocForm.projectTimelineCategory == 'LT' ? 'selected' : ''}>LT</option>
                                                            <option value="HT" ${aocForm.projectTimelineCategory == 'HT' ? 'selected' : ''}>HT</option>
                                                            <option value="EQUATOR" ${aocForm.projectTimelineCategory == 'EQUATOR' ? 'selected' : ''}>EQUATOR</option>

                                                        </select>




                                                    </td>
                                                    <th colspan="1" style="border: 1px solid black;">Budget Allocated for Project<span style="color: red;font-size: 12px;">*</span></th>
                                                    <td colspan="2"  style="border: 1px solid black;">
                                                <input type="text" placeholder="INR" class="input-field" id="inr" name="inr" value="${aocForm.projectBudgetAllocated}" required="true"/>
                                                    </tr>
                                                <tr>
                                                    <th colspan="1" style="border: 1px solid black;">Zero Date:<span style="color: red;font-size: 12px;">*</span></th>
                                                     <td colspan="1" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers6">
                                                        <input placeholder="DD/MM/YYYY" name="Fromdate6" type="text" class="input-field form_datetime" id="Fromdate6"  style="width: 250px; " value="${aocForm.zeroDate}" maxlength="30" required="true"/>
                                                    </div>
                                                </td>

<!--                                            <script type="text/javascript">
                                                flatpickr("#Fromdate6", {
                                                dateFormat: "d-m-Y", // Set your desired format
                                                        allowInput: true, // Allow manual input if required
                                                        minDate: "today"     // Disable past dates
                                                });</script>-->


                                                    <th colspan="2" style="border: 1px solid black;">Completion Date:<span style="color: red;font-size: 12px;">*</span></th>
                                                     <td colspan="3" style="border: 1px solid black;">
                                                <div class="input-group date" id="datetimepickers5" style="width: 100%;">
                                                    <input 
                                                        placeholder="DD/MM/YYYY" 
                                                        name="Fromdate7" 
                                                        type="text" 
                                                        class="input-field form_datetime" 
                                                        id="Fromdate7" 
                                                        value="${aocForm.completionDate}" 
                                                        maxlength="30"  style="width: 100%;"required="true"
                                                        />
                                                </div>
                                            </td>

<!--                                            <script type="text/javascript">
                                                        flatpickr("#Fromdate7", {
                                                        dateFormat: "d-m-Y", // Set your desired format
                                                                allowInput: true // Allow manual input if required
                                                        });</script>-->

                                                </tr>
                                                <tr>
                                              
                                             <td  colspan="1" style="border: 1px solid black;"><strong>No.of Days</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="input-field" name="chargingrate" id="chargingrate"  value="${aocForm.chargingRatePerUnit}" required="required"/>
                                                    </td> 
                                                    
                                                    
                                                    </td>
                                                </tr>

                                            </thead>
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


                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black; background-color: skyblue; text-align: center" ><strong>(Ordinance) Order Review details</strong></td>
                                                </tr>

                                            </thead>

                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Reviewing Authority Comment:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style=" height: 100px; border: none; resize: none;" 
                                                              name="comments" id="comments">${aocForm.authorityComments}</textarea>
                                                </td>                                                  
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Order Effective Date:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers7"  style="width: 100%;">
                                                        <input 
                                                            placeholder="DD/MM/YYYY" 
                                                            name="Fromdate8" 
                                                            type="text" 
                                                            class="input-field form_datetime" 
                                                            id="Fromdate7" 
                                                            value="${aocForm.orderEffcectiveDate}" 
                                                            maxlength="30"  style="width: 100%;"
                                                            />
                                                    </div>
                                                </td>

                                            <script>
$(function () {

                                                        flatpickr("#Fromdate7", {
                                                        dateFormat: "d-m-Y", // Set your desired format
                                                                allowInput: true // Allow manual input if required
                                                        });
                                                        });
                                                                                                        </script>



                                            <td colspan="1" style="border: 1px solid black;"><strong>New Revision No:</strong></td>

                                            <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="revisionNo" id="revisionNo" value="${aocForm.newRevisionNo}"/> </td>


                                            </tr>







                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;">
                                                    <strong>Budget Allocation Date:<span style="color: red;font-size: 12px;">*</span></strong>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers9"  style="width: 100%;">
                                                        <input 
                                                            placeholder="DD/MM/YYYY" 
                                                            name="Fromdate9" 
                                                            type="text" 
                                                            class="input-field form_datetime" 
                                                            id="Fromdate9" 
                                                            value="${aocForm.budjectAllocationDate}" 
                                                            maxlength="30"  style="width: 100%;"
                                                            />
                                                    </div>
                                                </td>
                                            </tr>

                                            <script>
$(function () {

                                                        flatpickr("#Fromdate9", {
                                                        dateFormat: "d-m-Y", // Set your desired format
                                                                allowInput: true // Allow manual input if required
                                                        });
                                                        });
                                                                                                        </script>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Reviewed By: </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2"  style="border: 1px solid black;"><input  class="input-field" name="reviewed" id="reviewed" value="${aocForm.reviewedBy}"/> </td>                                                   
                                                <td colspan="1"  style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="3" style="border: 1px solid black;"><input  class="input-field"name="designation" id="designation" value="${aocForm.designation}" /> </td>

                                            </tr>
                                              <tr>
                                                 <td style="border: 1px solid black;"><strong>Project Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;"><select class="select-input" id="ProjectProfile" name="ProjectProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                           <td colspan="1" style="border: 1px solid black;"><strong>Profit Center:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3" style="border: 1px solid black; ">
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
                                                 <tr>
                                              <td style="border: 1px solid black;"><strong>Company Code:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                   <td colspan="2" style="border: 1px solid black;">
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
                                                   <td colspan="3" style="border: 1px solid black;">
                                                 
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
                     $('.select-input').selectpicker("refresh")

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
                                                    <td colspan="2" style="border: 1px solid black;">
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
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Project Currency:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><select class="select-input" id="ProjectCurrency" name="ProjectCurrency" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                    <td style="border: 1px solid black;width: 25%;"><strong>Investment Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;width: 25%;"><select class="select-input" id="InvestmentProfile" name="InvestmentProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
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

                                                    <td  colspan="1" style="border: 1px solid black;width: 25%;"><strong>Discom:</strong></td>
                                                    <td  colspan="3" style="border: 1px solid black;width: 25%;">
                                                   
                                                        <input type="text" class="input-field" name="Discom" id="Discom"  value="${Discom1}"  readonly="true"/>
                                                    </td>

                                                </tr>

                                                 <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="ChargePoints" id="ChargePoints" value="${aocForm.noOfChargePoints}" required="required"/> </td>    
                                                    <td colspan="1"style="border: 1px solid black;"><strong>No Of Charger:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3"style="border: 1px solid black;"><input  class="input-field" name="NoOfCharger" id="NoOfCharger" value="${aocForm.noOfCharger}" required="required"/> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Overall Station Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2"style="border: 1px solid black;"><input  class="input-field" name="overallstations" id="overallstations" value="${aocForm.overallStationCapacityKw}" required="required"/> </td>    
                                                    <td  colspan="1" style="border: 1px solid black;"><strong>Station AC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3"style="border: 1px solid black;"><input  class="input-field" name="stationAc" id="stationAc" required="required" value="${aocForm.stationAcCapacityKw}" /> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station DC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;"><input  class="input-field" name="stationDc" id="stationDc" required="required" value="${aocForm.stationDcCapacityKw}"/> </td>    
<!--                                                    <td  colspan="1 "style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3" style="border: 1px solid black;"><input  class="input-field" name="stationname" id="stationname" required="required" value="${aocForm.stationName}"/> </td> -->
<td style="border: 1px solid black;" colspan="1 "><strong>Total MegaWatt(MW):</strong><span style="color: red;font-size: 12px;">*</span></td>
<td style="border: 1px solid black;" colspan="3"><input  class="input-field" name="totalMW" id="totalMW" readonly value="${aocForm.totalMegaWatt}" onkeydown="return false;"/> </td> 
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
                                                    <td colspan="2"style="border: 1px solid black;">
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


                                                    <td colspan="1"style="border: 1px solid black;"><strong>Tenant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3"style="border: 1px solid black;">
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
                                                        
                                           <td style="border: 1px solid black;"><strong>Total Kw Rating:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" value="${aocForm.totalKwRating}" name="totalKwRating" id="totalKwRating" required="required"/> </td> 
                                                   <td colspan="1" style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                       <div class="form-group date" id="datetimepickers6"> 
                                                        <input  class="input-field" style="background: white;" placeholder="DD/MM/YYYY" maxlength="30"autocomplete="off" value="${aocForm.specificDateFromClient}" name="specificDateFromClient" id="specificDateFromClient" />
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
                                                    <td  style="border: 1px solid black;"><strong>Total Charger Capacity:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="totalChargerCapacity" value="${aocForm.totalChargerCapacity}" id="totalChargerCapacity" required="required"/> </td>    
                                                     <td colspan="1" style="border: 1px solid black;"><strong>Charger Station Access Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                     <select class="select-input" name="chargerStationAccessType" id="chargerStationAccessType" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="public" ${aocForm.chargerStationAccessType == 'public' ? 'selected' : ''}>Public</option>
                                                            <option value="private" ${aocForm.chargerStationAccessType == 'private' ? 'selected' : ''}>Private</option>
                                                            
                                                        </select>
                                                    </td>
                                                </tr> 
                                               <tr>
                                                    <td  style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="auxiliaryLoadOfStation" value="${aocForm.auxiliaryLoadOfStation}" id="auxiliaryLoadOfStation" /> </td>    
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="input-field" name="chargingRetePerUnit" value="${aocForm.chargingRetePerUnit}" id="chargingRetePerUnit" required="required"/> </td> 

                                                </tr> 
                                               <tr>
                                                    <td  style="border: 1px solid black;"><strong>No Of Evs To Be Charged / No. of Parking:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="noOfEvsToBeChanged" value="${aocForm.noOfEvsToBeChanged}" id="noOfEvsToBeChanged" required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/> </td>    
<!--                                                    <td colspan="1" style="border: 1px solid black;"><strong>Addition Of New Charger Capacity:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <select class="select-input" name="additionOfNewChargerCapacity" id="additionOfNewChargerCapacity" required>
                                                          <option value="">-- Select--</option>
                                                            <option value="360kW" ${aocForm.additionOfNewChargerCapacity == '360kW' ? 'selected' : ''}>360kW</option>
                                                            <option value="720kW" ${aocForm.additionOfNewChargerCapacity == '720kW' ? 'selected' : ''}>720kW</option>
                                                        </select>
                                                    </td> -->
                                                    <td  colspan="1 "style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3" style="border: 1px solid black;"><input  class="input-field" name="stationname" id="stationname" required="required" value="${aocForm.stationName}"/> </td>
                                                </tr> 
                                               
                                                
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Anchore Customer</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                  
                                                    <td  style="border: 1px solid black;" colspan="2">
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
                                                     <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                     <td style="border: 1px solid black;" colspan="2">
                                                        <select class="select-input" name="scopeofChargeZone" id="scopeofChargeZone" required >
                                                            <option value="">-- Select--</option>
                                                            <option value="1" ${aocForm.scopeOfchargeZone == '1' ? 'selected' : ''}>YES</option>
                                                            <option value="0" ${aocForm.scopeOfchargeZone == '0' ? 'selected' : ''}>NO</option>
                                                            
                                                        </select>
                                                    </td>
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
                                                     <td  colspan="1" style="border: 1px solid black;"><strong>Connection Type:</strong></td>
                                                    <td  colspan="2" style="border: 1px solid black;">
                                                   
                                                        <input type="text" class="input-field" name="conn" id="conn"  value="${connection}" readonly="true"/>
                                                    </td>
                                                     
                                                    <td  colspan="1" style="border: 1px solid black;"><strong>Site Survey:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3"style="border: 1px solid black;"><input  class="input-field" name="sitesurvey" id="sitesurvey" required="required" value="${aocForm.siteSurvey}" /> </td> 
   
                                                    
                                                       
                                                    
                                                </tr>
                                          

 <tr>
                                                    <td style="border: 1px solid black;"><strong>Survey</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;">
                                                        <input type="radio" name="Survey" onclick="return toggleDisplay();" id="Survey" value="siteSurveycreated" required="true"
                                                               <c:if test="${aocForm.surveyRadio == '1'}">checked="checked"</c:if> /> <b>Site Survey Created</b> &nbsp;&nbsp;

                                                               <input type="radio" name="Survey" onclick="return toggleDisplay();" id="Survey" value="siteSurveynotcreated"
                                                               <c:if test="${aocForm.surveyRadio == '0'}">checked="checked"</c:if> /> <b>Site Survey Not Created</b>
                                                        </td>
                                                    </tr>
                                                    
            </table>
                                                      <c:if test="${aocForm.surveyRadio == '1'}">
                                                          <table id="commonTable" class="table table-striped bg-white" style="max-width: 100%" align="center">
                                                        <thead>

                                                            <tr>
                                                                <th  >Sr No</th>
                                                                <th  >Survey No</th>
                                                                <th >Project Representative</th>
                                                                <th data-dt-order="disable" >Action</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach var="aocsurveyattach" items="${aocsurveyattach}" varStatus="status">
                                                            <tr>
                                                                <td ><span>${status.count}</span>
                                                                </td> 
                                                                <td ><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${aocsurveyattach.surveyNo}">${aocsurveyattach.surveyNo}</a>
                                                                </td> 
                                                                <td ><span>${aocsurveyattach.projectRepresentative}</span>
                                                                </td> 
                                                                
                                                                <td style="text-align: center;">
                                                                    <a href="aocForm.htm?act=aocSurveyDelete&id1=${aocsurveyattach.id}&id=${aocForm.id}'"class="d-block text-danger p-1 mx-1"data-toggle="tooltip" data-placement="left"  title="Delete"><img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"alt="Delete Icon" style="width: 22px; height: 22px;">
                                                            </a>
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    <!--<button type="button" class="fa fa-trash" onclick="window.location = 'aocForm.htm?act=aocSurveyDelete&id1=${aocsurveyattach.id}&id=${aocForm.id}'"></button>-->
                                                                </td>


                                                               

                                                            </tr>
                                                        </c:forEach>  
</tbody>



                                                    </table>
                                                          <hr>
                                                </c:if>

 <script>
                                                        function toggleDisplay()
                                                        {
                                                            var survey=document.getElementById("Survey").checked;
                                                            var toggleId=document.getElementById("toggleId");
                                                             var surveyNo=document.getElementsByName("surveyNo");
//                                                           alert(surveyNo.length)
                                                          
                                                            if(survey)
                                                            {
                                                                 if ($.fn.DataTable.isDataTable("#toggleId")) {
        $("#toggleId").DataTable().destroy();
//        $("#toggleId").empty(); // optional but recommended
    }

    const table1 = initDocTable("#toggleId");
                                                               toggleId.style.display="block"; 
                                                            }
                                                            
                                                            else{
                                                                for (var i = 0; i < surveyNo.length; i++) {
                                                                       surveyNo[i].value="";
                                                                                }
                                                                toggleId.style.display="none"; 
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

   Swal.fire({
  title: 'Survey',
  text: survey,
  icon: 'info',
  confirmButtonText: 'OK'
});


    var size = sizeElements.length > 0 ? sizeElements[0].value : "";

    if (survey === "siteSurveycreated") {
        return true;
    } else {
       if (size !== '0') {
    Swal.fire({
        icon: 'warning',
        title: 'Warning',
        text: 'Delete Survey No',
        confirmButtonText: 'OK'
    });
    return false;
} else {
    return true;
}

    }
}
</script>


                                      <table id="toggleId" style="display: none;max-width: 100%" class="table  table-striped bg-white dt-scroll"  align="Center">
                                            <thead>
                                                <tr>

                                                    <th >Survey No</th>
                                                       <th >Project Representative </th>
                                                    <th >Action</th>
                                                </tr>
                                            </thead>
                                            <tbody id="Table">
                                                <tr>
                                            <input type="hidden" name="policy" id="policy" value="1"/>

                                            <td style="width: 50%;">
                                                <input id="siteradio" name="surveyNo" placeholder="Survey No" class="input-field" type="text" maxlength="10" minlenght="10">
                                            </td>
                                               <td style="width: 50%;">
                                                    <input id="projectRepresentative" name="projectRepresentative" placeholder="Project Representative" class="input-field" type="text">
                                                </td>
                                                
                                         <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                            <div class="clone-action clone-new-field mb-2" id="Cloneids" style="cursor:pointer;">
                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                            </div>
                                        </td>       
                                                
                                                
<!--                                            <td style="text-align: center;width: 50%;">
                                                <span style="margin-top: 5px;">
                                                    <input type="button" value="+" id="Cloneids"/>
                                                </span>
                                            </td>-->
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





                                                                <table id="commonTable1" class="table  table-striped bg-white" align="Center">
                                                                    <thead>
                                                                        <tr>
                                                                            <th >Document Name</th>
                                                                            <th data-dt-order="disable"> Attachment
                                                                             <a href="aocForm.htm?act=aocDocxdownloadzip&fileName=${list[0]}&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                        </a>
                                                                            </th>
                                                                            <th data-dt-order="disable">Action</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    <c:forEach var="list" items="${list}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list[1]}</td>
                                                                            <td>
                                                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list[0]}&id1=${id}">${list[0]}</a>
                                                                            </td>


                                                                            <td style="text-align: center;">
                                                                                
                                                                        <a href="aocForm.htm?act=aocFormdocuDelete&id1=${list[2]}&id=${aocForm.id}'"class="d-block text-danger p-1 mx-1"data-toggle="tooltip" data-placement="left"  title="Delete"><img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"alt="Delete Icon" style="width: 22px; height: 22px;">
                                                                        </a>
                                                                                
                                                                                <!--<button type="button" class="fa fa-trash" onclick="window.location = 'aocForm.htm?act=aocFormdocuDelete&id1=${list[2]}&id=${aocForm.id}'"></button>-->
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>

                                                                    <c:forEach var="list33" items="${list33}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list33[1]}</td>
                                                                            <td><a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>
                                                                            <td style="text-align: center;">
                                                                            <a href="aocForm.htm?act=aocFormdocuDelete1&id1=${list33[2]}&id=${aocForm.id}'"class="d-block text-danger p-1 mx-1"data-toggle="tooltip" data-placement="left"  title="Delete"><img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"alt="Delete Icon" style="width: 22px; height: 22px;">
                                                                        </a>     
                                                                                
                                                                                <!--<button type="button" class="fa fa-trash" onclick="window.location = 'aocForm.htm?act=aocFormdocuDelete1&id1=${list33[2]}&id=${aocForm.id}'"></button>-->
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                        </tbody>
                                                                </table>

                                                            <br>
                                                            


                                                            <h6>Additional Attachment</h6>
                                  
                                                <table id="policyTable" class="table  table-striped bg-white dt-scroll" style="max-width: 100%" align="center">
                                                    <thead>
                                                    <tr>

                                                        <th >Attachment</th>
                                                        <th >Description</th>

                                                        <!--                                                            <th style="text-align: center; vertical-align: middle">Document name</th>-->

                                                        <th >Add New</th>
                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr id="policyRow1">
                                                        <!--                                                        <td id="policyId1">
                                                                                                                    <input type="text" class="input-field" name="srNo1" value="1" readonly>
                                                                                                                </td>                                                           -->
                                                        <td>
                                                            <input id="attachment1" name="attach" class="input-field" type="file" onchange="validateFileSize(this)">
                                                            <span id="fileError" style="color: red; font-size: 11px; display: none;">* File Should Not Exceed 5MB</span>
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
                                                        //                                                        + "<td id='policyId" + tempCount3 + "'><input type='text' class='input-field' name='srNo" + tempCount3 + "' value='" + tempCount3 + "' readonly></td>"
                                                        //                                                            + "<td><input type =\"text\" class=\"input-field\" placeholder=\"description\" name=\"description" + "\" id=\"description" + tempCount3 + "\"></td>"

                                                        //                                                                                    + "<td id='attachment1" + tempCount3 + "'><input type='file' class='input-field' name='attachment" + "' required></td>"

                                                        + "<td><input type =\"file\" class=\"input-field\" placeholder=\"action\" name=\"attach" + "" + "\" id=\"attachment" + tempCount3 + "\"></td>"
                                                        + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"

                                                        //                                                            + "<td><input type =\"text\" class=\"input-field\" placeholder=\"remark\" name=\"remark" + "\" id=\"remark" + tempCount3 + "\"></td>"


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
$(document).on("change", "input[type='file']", function () {
    var file = this.files[0];
    var errorContainer = $(this).next(".file-error");

    if (errorContainer.length === 0) {
        errorContainer = $("<div class='file-error' style='color: red; font-size: 12px;'></div>");
        $(this).after(errorContainer);
    }

    if (file) {
        var fileSizeMB = file.size / (1024 * 1024); // Convert bytes to MB
        if (fileSizeMB > 5) {
            errorContainer.text("* File should not exceed 5MB.");
            $(this).val(""); // Clear the file input
        } else {
            errorContainer.text(""); // Clear the error message if valid
        }
    } else {
        errorContainer.text(""); // Clear the error if no file is selected
    }
});

                                    </script>

     <div class="rounded-4 mt-4">
                            <div class="row mb-3">
                            <div class="col-lg-6 col-md-9">
                                <div class="form-group">
                                    <label  class="label" for="approvalName">Approval Name: <span style="color: red; font-size: 12px;">*</span></label>

                                        <select class="select-input" id="approvalName" name="approvalName" 
                    style="width: 225px; font-size: 12px; padding: 5px; ">
                <option value="">--SELECT--</option>
                <c:forEach var="list10" items="${list10}">
                    <c:choose>
                        <c:when test="${list10.id eq aocmasterId}">
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
                                    
                       
                                    <br>
                                    <br>

                                     <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <button type="submit" class="btn theme-btn"   title="" value="">SUBMIT</button>
                                        </div>
                                    </div>     
                
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
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
    Swal.fire({
        icon: 'warning',
        title: 'Delete Survey No',
        text: 'You cannot delete this survey.',
        confirmButtonText: 'OK'
    });
    return false;
} else {
    return true;
}

    }
}
</script>
<body onload="toggleDisplay();">
    
</body>
</html>
