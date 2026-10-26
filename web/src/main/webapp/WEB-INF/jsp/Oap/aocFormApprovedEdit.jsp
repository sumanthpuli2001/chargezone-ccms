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
        <title>AOC Form Approved Edit</title>
        <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <title>Order Acquisition Process Checklist</title>
        <!--        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

        <!-- Include Flatpickr JS -->
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
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
    <script>
                function viewClick(id) {
                window.location = 'vendorInformation.htm?act=technicalApprovalView&id=' + id;
                }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1></h1>
            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">AOC Form Approved Edit</h3>
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
        <form:form action="aocForm.htm?act=aocFormEditApprovedsubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation1"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

            <input type="hidden" name="id" value="${aocForm.id}">
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
                             Acquired Order Checklist
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
                                        <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->


                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black; background-color: skyblue"><strong>Hub / Depo Order details </strong></td>
                                                </tr>

                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Document No:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black; width: 26%;"><input  class="form-control" name="documentNo" id="documentNo" value="${aocForm.documentNo}"  readonly /> </td>                                                   
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Hub / Depo Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"  style="border: 1px solid black;"><input  class="form-control" name="depoName" id="depoName" value="${aocForm.hubDepoName}"required="true"/> </td>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>B2B: </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="b2b" id="b2b" value="${aocForm.bb2}" required="true"/> </td>                                                   
                                                    <td style="border: 1px solid black;"><strong>B2B2C:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;"><input  class="form-control" name="b2b2c" id="b2b2c" value="${aocForm.bbc22}" required="true"/> </td>

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>B2C</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="form-control" name="b2c" id="b2c" value="${aocForm.bc2}" required="true"  />
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Client / Project Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="projectName" id="projectName" value="${aocForm.clientProjectName}" required="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Country:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="form-control" name="country" id="country" value="${aocForm.country}" required readonly="true"/>
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>State:</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="form-control" name="state" id="state" value="${aocForm.state}" readonly="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>City:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="form-control" name="city" id="city" value="${aocForm.city}" required="true" />
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Street:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="form-control" name="depoAddress" id="depoAddress" value="${aocForm.hubDepoAddress}" required="true"/> </td>    
                                                </tr>
                                                <tr>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>District:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="form-control" name="district" id="district" value="${aocForm.district}" required="true" />
                                                    </td>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>House No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><input  class="form-control" name="houseno" id="houseno" value="${aocForm.houseNo}" required="true"/> </td>    
                                                </tr>




                                                <tr>
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Google Co-ordinates: </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="googleCoordinates" id="googleCoordinates" value="${aocForm.googleCoordinates}" required="true"/> </td>                                                   

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
                                                            <input type="checkbox" name="truck" id="truck" value="${aocForm.pcTypeTruckLmv}" ${aocForm.pcTypeTruckLmv == '1' ? 'checked' : ''}> C.Truck/ LMV
                                                        </div>
                                                    </td>

                                                    <td colspan="1" style="border: 1px solid black;"><strong>Others:</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input class="form-control" name="others" id="others" value="${aocForm.other}"/>
                                                    </td>
                                                </tr>
                                                <!--                                                <tr>
                                                                                                    <td style="border: 1px solid black;"><strong>PCS Type</strong></td>
                                                                                                    <td colspan="2" style="border: 1px solid black;">
                                                                                                        <input type="text" class="form-control" name="pcs" id="pcs" value="${aocForm.pcsType}" required />
                                                                                                    </td>
                                                                                                </tr>-->

                                                <tr>
                                                    <td colspan="1"  style="border: 1px solid black;"><strong>Financial Model :  </strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"> 
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="capex" id="capex" value="${aocForm.finacialModelCapex}" 
                                                                   ${aocForm.finacialModelCapex == '1' ? 'checked' : ''}> A. Capex
                                                        </label>
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="opex" id="opex" value="${aocForm.finacialModelOpex}" 
                                                                   ${aocForm.finacialModelOpex == '1' ? 'checked' : ''}> B. Opex
                                                        </label>

                                                    <td colspan="1" style="border: 1px solid black;"><strong>Co-ordinates: </strong><span style="color: red;font-size: 12px;">*</span></td>

                                                    <td colspan="3" style="border: 1px solid black;"><input  class="form-control" name="coordinates" id="coordinates" value="${aocForm.coOrdinates}" required="true"/> </td>                                                   


                                                    </td>                                                 

                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Details of Contact Person:  </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input placeholder="FisrtName" class="form-control" name="firstName" id="firstName" value="${aocForm.firstName}"required="true"/> </td>                                                   
                                                    <td style="border: 1px solid black;"><strong>Client E-mail:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2"  style="border: 1px solid black;"><input  class="form-control" name="email" id="email"type="email" value="${aocForm.email}" required="true"/> </td>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Client Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2"  style="border: 1px solid black;"><input  class="form-control" name="mobileNo" id="mobileNo" value="${aocForm.mobileNo}" required="true"/> </td>                                                   
                                                    <td style="border: 1px solid black;"><strong>Mobile Number:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2"  style="border: 1px solid black;"><input  class="form-control" name="altNo" id="altNo" value="${aocForm.alternateMobileNo}" required="true"/> </td>

                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of work</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="6" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="scopework" id="scopework" required="true">${aocForm.chargeScope}</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Client Scope: </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="6" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="scope" id="scope" required="true">${aocForm.clientScope}</textarea>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Specific requirements of the Client:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                    <td colspan="6" style="border: 1px solid black;">
                                                        <textarea style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                  name="reqClients" id="reqClients" required="true">${aocForm.specificReqClients}</textarea>
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
                                                    <th colspan="2" style="border: 1px solid black;">Date:</th>
                                                    <th colspan="2" style="border: 1px solid black;">Attachment</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th colspan="1" style="border: 1px solid black;">
                                                        (i) Assumption Sheet
                                                        <input type="checkbox" style="margin-left: 5px;" name="assumption" id="assumption" value="${aocForm.assumptionSheet}" 
                                                               ${aocForm.assumptionSheet == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'assumptionRefNo', 'Fromdate1', 'file1', 'assumptionAttach')">
                                                    </th>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <input type="text" class="form-control" id="assumptionRefNo" ${aocForm.assumptionSheet != '1' ? 'disabled' : ''} name="assumptionRefNo" value="${aocForm.assumptionRefNo}"/>
                                                    </td>
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <div class="input-group date"  style="width: 100%;">
                                                            <input placeholder="DD/MM/YYYY" name="Fromdate1" ${aocForm.assumptionSheet != '1' ? 'disabled' : ''} id="Fromdate1" type="text" class="form-control form_datetime" maxlength="30" value="${aocForm.assumptionDate}"  style="width: 100%;"/>
                                                        </div>
                                                    </td> 
                                                    <td colspan="2" style="border: 1px solid black;">
                                                        <a href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${aocForm.assumptionAttach}"><span id="assumptionAttach">${aocForm.assumptionAttach}</span></a>
                                                        <input type="hidden" name="file11" value="${aocForm.assumptionAttach}" id="file11">
                                                        <input type="file" class="form-control" id="file1" name="file1" ${aocForm.assumptionSheet != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" style="margin-left: 5px;" name="boq" id="boq" value="${aocForm.estimatedBoq}" 
                                                           ${aocForm.estimatedBoq == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'boqRefNo', 'Fromdate2', 'file2', 'estimatedAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="form-control" id="boqRefNo" ${aocForm.estimatedBoq != '1' ? 'disabled' : ''} name="boqRefNo" value="${aocForm.estimatedRefNo}" />
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers1"  style="width: 100%;">
                                                        <input placeholder="DD/MM/YYYY" name="Fromdate2" ${aocForm.estimatedBoq != '1' ? 'disabled' : ''} id="Fromdate2" type="text" class="form-control form_datetime" value="${aocForm.estimatedDate}" maxlength="30"  style="width: 100%;"/>
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${aocForm.estimatedAttach}"><span id="estimatedAttach">${aocForm.estimatedAttach}</span></a>
                                                    <input type="hidden" name="file12" value="${aocForm.estimatedAttach}" id="file12">
                                                    <input type="file" class="form-control" id="file2" name="file2" ${aocForm.estimatedBoq != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" style="margin-left: 5px;" name="lao" id="lao" value="${aocForm.loaLoi}" 
                                                           ${aocForm.loaLoi == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'laoRefNo', 'Fromdate3', 'file3', 'loaAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="form-control" id="laoRefNo" ${aocForm.loaLoi != '1' ? 'disabled' : ''} name="laoRefNo" value="${aocForm.loaLoiRefNo}" />
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers2"  style="width: 100%;">
                                                        <input placeholder="DD/MM/YYYY" name="Fromdate3" ${aocForm.loaLoi != '1' ? 'disabled' : ''} id="Fromdate3" type="text" class="form-control form_datetime" value="${aocForm.loaLoiDate}" maxlength="30"  style="width: 100%;"/>
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${aocForm.loaAttach}">  <span id="loaAttach">${aocForm.loaAttach}</span></a>
                                                    <input type="hidden" name="file13" value="${aocForm.loaAttach}" id="file13">
                                                    <input type="file" class="form-control" id="file3" name="file3" ${aocForm.loaLoi != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" style="margin-left: 5px;" name="agremment" id="agremment" value="${aocForm.agreement}" 
                                                           ${aocForm.agreement == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'agremmentRefNo', 'Fromdate4', 'file4', 'agreementAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="form-control" id="agremmentRefNo" ${aocForm.agreement != '1' ? 'disabled' : ''} name="agremmentRefNo" value="${aocForm.agreementRefNo}"/>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers3" style="width: 100%;">
                                                        <input  style="width: 100%;" placeholder="DD/MM/YYYY" name="Fromdate4" ${aocForm.agreement != '1' ? 'disabled' : ''} id="Fromdate4" type="text" class="form-control form_datetime" value="${aocForm.agreementDate}" maxlength="30" />
                                                    </div>
                                                </td> 
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${aocForm.agreementAttach}"><span id="agreementAttach">${aocForm.agreementAttach}</span></a>
                                                    <input type="hidden" name="file14" value="${aocForm.agreementAttach}" id="file14">
                                                    <input type="file" class="form-control" id="file4" name="file4" ${aocForm.agreement != '1' ? 'disabled' : ''} />
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
                                                    <input type="checkbox" style="margin-left: 5px;" name="drawings" id="drawings" value="${aocForm.layoutDrawings}" 
                                                           ${aocForm.layoutDrawings == '1' ? 'checked' : ''} onclick="toggleInputs(this, 'drawingsRefNo', 'Fromdate5', 'file5', 'layoutAttach')">
                                                </th>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <input type="text" class="form-control" id="drawingsRefNo" ${aocForm.layoutDrawings != '1' ? 'disabled' : ''} name="drawingsRefNo" value="${aocForm.layoutRefNo}" />
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers4"  style="width: 100%;">
                                                        <input style="width: 100%;" placeholder="DD/MM/YYYY" name="Fromdate5" ${aocForm.layoutDrawings != '1' ? 'disabled' : ''} id="Fromdate5" type="text" class="form-control form_datetime" value="${aocForm.layoutDate}" maxlength="30" />
                                                    </div>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <a href="aocForm.htm?act=aocCheckBoxAttach&fileNames=${aocForm.layoutAttach}"><span id="layoutAttach">${aocForm.layoutAttach}</span></a>
                                                    <input type="hidden" name="file15" value="${aocForm.layoutAttach}" id="file15">
                                                    <input type="file" class="form-control" id="file5" name="file5" ${aocForm.layoutDrawings != '1' ? 'disabled' : ''} />
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
                                                    <textarea style="width: 100%; height: 50px; border: none; resize: none;" 
                                                              name="operations" id="operations" required="true">${aocForm.operations}</textarea>
                                                </td>    
                                                <td colspan="1" style="border: 1px solid black;"><strong>Sign: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 50px; border: none; resize: none;" 
                                                              placeholder="Note: Mention the Nos. & Competency of Person Required" 
                                                              name="operationsSign" id="operationsSign" required="true">${aocForm.operationsSign}</textarea>
                                                </td>  
                                            </tr>



                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>(B) Maintenance<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 50px; border: none; resize: none;" 
                                                              name="maintenance" id="maintenance" required="true">${aocForm.maintenance}</textarea>
                                                </td>  

                                                <td colspan="1" style="border: 1px solid black;"><strong>Sign: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 50px; border: none; resize: none;" 
                                                              placeholder="Note: Ensure Signature of Director(RM Sir) if No Manpower is Required On Site" 
                                                              name="maintenancesign" id="maintenancesign" required="true">${aocForm.maintenanceSign}</textarea>
                                                </td> 
                                            </tr>







                                            <tr>
                                                <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Charger Installation Details</strong></td>
                                            </tr>


                                           <thead>
    <tr>
        <th colspan="1" style="border: 1px solid black;">Zero Date<span style="color: red;font-size: 12px;">*</span></th>
        <td colspan="1" style="border: 1px solid black;">
            <div class="input-group date" id="datetimepickers6" style="width: 100%;">
                <input style="width: 100%;" placeholder="DD/MM/YYYY" name="Fromdate6" type="text" class="form-control form_datetime" id="Fromdate6" value="${aocForm.zeroDate}" maxlength="30" required="true"/>
            </div>
        </td>

        <script type="text/javascript">
            document.addEventListener("DOMContentLoaded", function() {
                flatpickr("#Fromdate6", {
                    dateFormat: "d-m-Y", // Set your desired format
                    allowInput: true, // Allow manual input if required
                    minDate: "today" // Disable past dates
                });
            });
        </script>

        <th colspan="2" style="border: 1px solid black;">Completion Date<span style="color: red;font-size: 12px;">*</span></th>
        <td colspan="2" style="border: 1px solid black;">
            <div class="input-group date" id="datetimepickers5" style="width: 100%;">
                <input placeholder="DD/MM/YYYY" name="Fromdate7" type="text" class="form-control form_datetime" id="Fromdate7" value="${aocForm.completionDate}" maxlength="30" style="width: 100%;" required="true"/>
            </div>
        </td>

        <script type="text/javascript">
            document.addEventListener("DOMContentLoaded", function() {
                flatpickr("#Fromdate7", {
                    dateFormat: "d-m-Y", // Set your desired format
                    allowInput: true, // Allow manual input if required
                    minDate: "today" // Set minimum date to today
                });
            });
        </script>
    </tr>
</thead>

                                            <tr>

                                               


                                           
                                                    <th colspan="1" style="border: 1px solid black;">Budget Allocated for Project<span style="color: red;font-size: 12px;">*</span></th>


                                            <td colspan="2" style="border: 1px solid black;">
                                                <input type="text" placeholder="INR" class="form-control" id="inr" name="inr" value="${aocForm.projectBudgetAllocated}"required="true" />
                                            </td>
                                            </tr>


                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black; background-color: skyblue; text-align: center" ><strong>(Ordinance) Order Review details</strong></td>
                                                </tr>

                                            </thead>

                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Reviewing Authority Comment:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" 
                                                              name="comments" id="comments" required="true">${aocForm.authorityComments}</textarea>
                                                </td>                                                  
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Order Effective Date:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers7" style="width: 100%;">
                                                        <input 
                                                            placeholder="DD/MM/YYYY" 
                                                            name="Fromdate8" 
                                                            type="text" required="true"
                                                            class="form-control form_datetime" 
                                                            id="Fromdate7" 
                                                            value="${aocForm.orderEffcectiveDate}" 
                                                            maxlength="30" style="width: 100%;"
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



                                            <td colspan="1" style="border: 1px solid black;"><strong>New Revision No.:</strong><span style="color: red;font-size: 12px;">*</span></td>

                                            <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="revisionNo" id="revisionNo" value="${aocForm.newRevisionNo}" required="true"/> </td>


                                            </tr>







                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;">
                                                    <strong>Budget Allocation Date:<span style="color: red;font-size: 12px;">*</span></strong>
                                                </td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers9" style="width: 100%;">
                                                        <input 
                                                            placeholder="DD/MM/YYYY" 
                                                            name="Fromdate9" 
                                                            type="text" required="true"
                                                            class="form-control form_datetime" 
                                                            id="Fromdate9" 
                                                            value="${aocForm.budjectAllocationDate}" 
                                                            maxlength="30" style="width: 100%;"
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
                                                <td colspan="2"  style="border: 1px solid black;"><input  class="form-control" name="reviewed" id="reviewed" value="${aocForm.reviewedBy}" required="true"/> </td>                                                   
                                                <td colspan="1"  style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="3" style="border: 1px solid black;"><input  class="form-control"name="designation" id="designation" value="${aocForm.designation}"required="true" /> </td>

                                            </tr>
                                             <tr>
                                                 <td style="border: 1px solid black;"><strong>Project Profile:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;"><select class="form-control" id="ProjectProfile" name="ProjectProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                   <td style="border: 1px solid black;"><strong>Company Code:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                   <td colspan="2" style="border: 1px solid black;">
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
                                                   <td colspan="3" style="border: 1px solid black;">
                                                 
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
                                                    <td colspan="2" style="border: 1px solid black;">
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
                                                    <td colspan="1" style="border: 1px solid black;"><strong>Project Currency:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3" style="border: 1px solid black;"><select class="form-control" id="ProjectCurrency" name="ProjectCurrency" style=" font-size: 12px; padding: 5px;" required="required"   >
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
                                                    <td  colspan="2" style="border: 1px solid black;"><select class="form-control" id="InvestmentProfile" name="InvestmentProfile" style=" font-size: 12px; padding: 5px;" required="required"   >
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

                                                    <td  colspan="1" style="border: 1px solid black;"><strong>Discom:</strong></td>
                                                    <td  colspan="3" style="border: 1px solid black;">
                                                   
                                                        <input type="text" class="form-control" name="Discom" id="Discom"  value="${Discom1}" readonly="true"/>
                                                    </td>

                                                </tr>

 <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"style="border: 1px solid black;"><input  class="form-control" name="ChargePoints" id="ChargePoints" value="${aocForm.noOfChargePoints}" required="required"/> </td>    
                                                    <td colspan="1"style="border: 1px solid black;"><strong>No Of Charger</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3"style="border: 1px solid black;"><input  class="form-control" name="NoOfCharger" id="NoOfCharger" value="${aocForm.noOfCharger}" required="required"/> </td> 

                                                </tr>
 <tr>
                                                    <td style="border: 1px solid black;"><strong>Overall Station Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2"style="border: 1px solid black;"><input  class="form-control" name="overallstations" id="overallstations" value="${aocForm.overallStationCapacityKw}" required="required"/> </td>    
                                                    <td  colspan="1" style="border: 1px solid black;"><strong>Station AC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3"style="border: 1px solid black;"><input  class="form-control" name="stationAc" id="stationAc" required="required" value="${aocForm.stationAcCapacityKw}" /> </td> 

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station DC Capacity (KW):</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2" style="border: 1px solid black;"><input  class="form-control" name="stationDc" id="stationDc" required="required" value="${aocForm.stationDcCapacityKw}"/> </td>    
                                                    <td  colspan="1 "style="border: 1px solid black;"><strong>Station Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3" style="border: 1px solid black;"><input  class="form-control" name="stationname" id="stationname" required="required" value="${aocForm.stationName}"/> </td> 

                                                </tr>
 <tr>
                                                    <td style="border: 1px solid black;"><strong>Station Type:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2"style="border: 1px solid black;">
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


                                                    <td colspan="1"style="border: 1px solid black;"><strong>Tenant:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="3"style="border: 1px solid black;">
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
                                                      <td  colspan="1 "style="border: 1px solid black;"><strong>Connection Type:</strong></td>
                                                      <td  colspan="2" style="border: 1px solid black;"><input  class="form-control" name="" id="" value="${connection}" readonly="true"/> </td> 
 <td  colspan="1 "style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="3" style="border: 1px solid black;"><input  class="form-control" name="chargingrate" id="chargingrate" required="required" value="${aocForm.chargingRatePerUnit}"/> </td> 

                                                </tr>
                                            <!--                                            <tr>
                                                                                            <td colspan="1" style="border: 1px solid black;"><strong>Signature & Date: </strong></td>
                                                                                            <td colspan="6" style="border: 1px solid black;">
                                                                                                <textarea style="width: 100%; height: 100px; border: none; resize: none;" 
                                                                                                          name="signatureDate" id="signatureDate">${aocForm.signatureDate}</textarea>
                                                                                            </td>
                                                                                        </tr>-->



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
                                                                <!--                                            <div class="table">-->

                                                                <table id="table_1" class="table table-bordered table-striped table-hover" align="Center">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Document Name</th>
                                                                            <th>Attachment
                                                                             <a href="aocForm.htm?act=aocDocxdownloadzip&fileName=${list[0]}&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                        </a>
                                                                            </th>
                                                                            <th>Action</th>
                                                                        </tr>
                                                                    </thead>

                                                                    <c:forEach var="list" items="${list}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list[1]}</td>
                                                                            <td>
                                                                                <a href="aocForm.htm?act=AocDocxdownload&fileName=${list[0]}&id1=${id}">${list[0]}</a>
                                                                            </td>


                                                                            <td style="text-align: center;">
                                                                                <button type="button" style="border: none;color: red;" class="fa fa-trash" onclick="window.location = 'aocForm.htm?act=aocFormdocuDelete&id1=${list[2]}&id=${aocForm.id}'"></button>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>

                                                                    <c:forEach var="list33" items="${list33}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list33[1]}</td>
                                                                            <td><a href="aocForm.htm?act=AocDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>
                                                                            <td style="text-align: center;">
                                                                                <button type="button" style="border: none;color: red;" class="fa fa-trash" onclick="window.location = 'aocForm.htm?act=aocFormdocuDelete1&id1=${list33[2]}&id=${aocForm.id}'"></button>
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
                                                        //                                                        + "<td id='policyId" + tempCount3 + "'><input type='text' class='form-control' name='srNo" + tempCount3 + "' value='" + tempCount3 + "' readonly></td>"
                                                        //                                                            + "<td><input type =\"text\" class=\"form-control\" placeholder=\"description\" name=\"description" + "\" id=\"description" + tempCount3 + "\"></td>"

                                                        //                                                                                    + "<td id='attachment1" + tempCount3 + "'><input type='file' class='form-control' name='attachment" + "' required></td>"

                                                        + "<td><input type =\"file\" class=\"form-control\" placeholder=\"action\" name=\"attach" + "" + "\" id=\"attachment" + tempCount3 + "\"></td>"
                                                        + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"

                                                        //                                                            + "<td><input type =\"text\" class=\"form-control\" placeholder=\"remark\" name=\"remark" + "\" id=\"remark" + tempCount3 + "\"></td>"


                                                        + "<td >"
                                                        + "<span style='margin-top: 5px;'>"
                                                        + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;'   onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
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
















                                    <br>
                                    <br>

                                    <div class="form-group">
                                        <div class="col-sm-3 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>






                                </div>















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

</html>

