
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP APPROVAL Details</title>
    </head>
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
    <style>
        p {
            word-wrap: break-word; /* Allows words to break if necessary */
            max-width: 30ch; /* Restricts the paragraph to 20 characters wide */
        }
        .break-after-80 {
            word-wrap: break-word;
            overflow-wrap: break-word;
            max-width: 100ch; /* Limits to approximately 80 characters per line */
        }

    </style>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=oapKickOffFormAssignUser" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">OAP APPROVAL Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="oapForm.htm?act=oapKickOffForm" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn"  title="" value=" ">Assign</button>

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

                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">

                    <div style="max-width: 100%; margin: auto; border: 0px solid black;">
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.

                        </div>
                    </div>


                    <br>

                        <table class="table table-bordered mb-3" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>PCS Order Details:</strong></td>
                                            </tr>

                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                <td style="border: 1px solid black;">
                                                    <span>${list55.documentNo}</span>
                                                </td>

                                                <td style="border: 1px solid black;"><strong>PCS Name:</strong></td>
                                                <td style="border: 1px solid black;">
                                                    <span>${list55.pcsName} </span>    
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Date:</strong></td>
                                                <td style="border: 1px solid black;">
                                                    <div class="input-group date">
                                                        <span>${list55.date}</span>
                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black;"><strong>Document Revision No:</strong></td>
                                                <td style="border: 1px solid black;">
                                                    <span>${list55.documentRevisionNo}</span>
                                                </td>
                                            </tr>





                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Project Name:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.projectName}</span>
                                                <td style="border: 1px solid black;"><strong>PCS City/Highway:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.pcsCityHighway}</span>
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Country:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.country}</span>
                                                <td style="border: 1px solid black;"><strong>State:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.state}</span>
                                                </td>


                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>City:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.city}</span>
                                                <td style="border: 1px solid black;"><strong>Street:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.pcsAddress}</span>
                                                </td>


                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>District:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.district}</span>
                                                <td style="border: 1px solid black;"><strong>House No:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.houseNo}</span>
                                                </td>


                                            </tr>



                                            <tr>
                                                <td style="border: 1px solid black;">
                                                    <strong>Pcs Type</strong>
                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="pcsType1" id="pcsType1" value="1" disabled
                                                               ${list55.pcsTypeCity == '1' ? 'checked' : ''}> A. City
                                                    </label>
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="pcsType2" id="pcsType2" value="1" disabled
                                                               ${list55.pcsTypeHighway == '1' ? 'checked' : ''}> B. Highway
                                                    </label>
                                                    <br>
                                                    <label style="display: inline;">
                                                        <input type="checkbox" name="pcsType3" id="pcsType3" value="1" disabled
                                                               ${list55.pcsTypeOtherCheck == '1' ? 'checked' : ''}> C. Other
                                                    </label>
                                                    <div id="otherFieldContainer" style="display: ${list55.pcsTypeOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                        <p>${list55.pcsTypeOther}</p>

                                                    </div>
                                                </td>

                                                <!-- Column 2: PCS Model -->
                                                <td style="border: 1px solid black; vertical-align: top;">
                                                    <strong>PCS Model</strong>
                                                </td>
                                                <td style="border: 1px solid black; padding: 5px;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="pcsModel" id="pcsModel" value="${list55.pcsModelDoco}" disabled 
                                                               ${list55.pcsModelDoco == '1' ? 'checked' : ''}> A. DOCO
                                                    </div>
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="pcsMode2" id="pcsMode2" value="${list55.pcsModelCoco}" disabled 
                                                               ${list55.pcsModelCoco == '1' ? 'checked' : ''}> B. COCO
                                                    </div>
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="pcsMode3" id="pcsMode3" value="${list55.pcsModelDodo}" disabled 
                                                               ${list55.pcsModelDodo == '1' ? 'checked' : ''}> C. DODO
                                                    </div>
                                                    <br>
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="pcsMode5" id="pcsMode5" value="${list55.pcsModelSaas}" disabled 
                                                               ${list55.pcsModelSaas == '1' ? 'checked' : ''}> D. SAAS
                                                    </div>
                                                    <div style="display: inline; ">
                                                        <input type="checkbox" name="pcsMode4" id="pcsMode4" value="1" disabled  ${list55.pcsModelOtherCheck == '1' ? 'checked' : ''}> D. Other
                                                    </div>
                                                    <div id="modeOtherFieldContainer"  style="display: ${list55.pcsModelOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                        <p>${list55.pcsModelOther}</p>
                                                    </div>
                                                </td>
                                            </tr>

                                            </td>

                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Pcs Co-ordinates:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.pcsCoordinates}</span>

                                                <td style="border: 1px solid black;"><strong>Client Name:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.mobileNo}</span>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong> Client E-mail:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.email}</span>
                                                <td style="border: 1px solid black;"><strong>Client  Mobile No:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.alternateMobileNo}</span>
                                            </tr>


                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Charge Zone Scope Of Work:</strong></td>
                                                <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.clientDetails}</p>

                                                </td>
                                            </tr>



                                            <tr>
                                                <td style="border: 1px solid black;"><strong> Clients Scope :</strong></td>
                                                <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.clientScope}</p>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Specific Requirements of Clients:</strong></td>
                                                <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.specificRequriementsClients}</p>

                                                </td>
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Name of the Sales Lead:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.salesLeadName}</span>
                                                <td style="border: 1px solid black;"><strong>Department:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.department}</span>

                                            </tr>      

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Designation:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.designation}</span></td>

                                                <td style="border: 1px solid black;"><strong>Date:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.salesDate}</span></td>
                                            </tr>






                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>PCS Deliverable Details:</strong></td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black; width: 25%;">
                                                    <div>
                                                        <input style="" type="checkbox" name="pcsDelivery1" id="pcsDelivery1" 
                                                               value="${list55.agreementLoa}" 
                                                               ${list55.agreementLoa == '1' ? 'checked' : ''} disabled> Agreement/LOA
                                                    </div>
                                                    <div id="attachment1" style=" margin-top: 5px;">
                                                        <input type="hidden" name="attachment1File" id="attachment1File"  onchange="validateFileSize(this, 'notification1')">
                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.aggrementAttach}&id1=${id}"> <span>${list55.aggrementAttach}</span></a>



                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black; width: 25%;">
                                                    <div>
                                                        <input type="checkbox" name="pcsDelivery2" id="pcsDelivery2" 
                                                               value="${list55.ownerShipDocument}" 
                                                               ${list55.ownerShipDocument == '1' ? 'checked' : ''} disabled> Ownership Document
                                                    </div>
                                                    <div id="attachment2" style=" margin-top: 5px;">
                                                        <input type="hidden" name="attachment2File" id="attachment2File"  onchange="validateFileSize(this, 'notification2')">
                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.ownershipAttach}&id1=${id}"> <span>${list55.ownershipAttach}</span></a>
                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black; width: 25%;">
                                                    <div>
                                                        <input type="checkbox" name="pcsDelivery3" id="pcsDelivery3" 
                                                               value="${list55.preliminarySiteSurvey}" 
                                                               ${list55.preliminarySiteSurvey == '1' ? 'checked' : ''} disabled> Preliminary Site Survey
                                                    </div>
                                                    <div id="attachment3" style=" margin-top: 5px;">
                                                        <input type="hidden" name="attachment3File" id="attachment3File"  onchange="validateFileSize(this, 'notification3')">
                                                        <a  class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.preliminaryAttach}&id1=${id}">  <span>${list55.preliminaryAttach}</span></a>

                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black; width: 25%;">
                                                    <div>
                                                        <input type="checkbox" name="pcsDelivery4" id="pcsDelivery4" 
                                                               value="${list55.consentLetterNoc}" 
                                                               ${list55.consentLetterNoc == '1' ? 'checked' : ''} disabled> Consent Letter/NOC
                                                    </div>
                                                    <div id="attachment4" style=" margin-top: 5px;">
                                                        <input type="hidden" name="attachment4File" id="attachment4File"  onchange="validateFileSize(this, 'notification4')">
                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.consentAttach}&id1=${id}">   <span>${list55.consentAttach}</span></a>
                                                    </div>
                                                </td>
                                            </tr>
</table>
                                         <c:if test="${empty chargeInst}">
                        <table class="table table-bordered mb-3" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                           
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue;">
                                                    <strong>Charger Installation Details:</strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall1" id="chargeInstall1" 
                                                               value="${list55.kwAc77}"   
                                                               ${list55.kwAc77 == '1' ? 'checked' : ''} disabled> 7.7KW AC
                                                    </div>
                                                    Quantity -- <span>${list55.kwAcQuatity77}</span>

                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall2" id="chargeInstall2" 
                                                               value="${list55.kwDc15}"   
                                                               ${list55.kwDc15 == '1' ? 'checked' : ''} disabled> 15KW DC
                                                    </div>
                                                    Quantity -- <span>${list55.kwDcQuatity15}</span>

                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall3" id="chargeInstall3" 
                                                               value="${list55.kwDc30}"   
                                                               ${list55.kwDc30 == '1' ? 'checked' : ''} disabled> 30KW DC
                                                    </div>
                                                    Quantity -- <span>${list55.kwDcQuatity30}</span>

                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall4" id="chargeInstall4" 
                                                               value="${list55.kwDc60}"   
                                                               ${list55.kwDc60 == '1' ? 'checked' : ''} disabled> 60KW DC
                                                    </div>
                                                    Quantity -- <span>${list55.kwDcQuatity60}</span>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall5" id="chargeInstall5" 
                                                               value="${list55.kwDc120}"   
                                                               ${list55.kwDc120 == '1' ? 'checked' : ''} disabled> 120KW DC
                                                    </div>
                                                    Quantity -- <span>${list55.kwDcQuatity120}</span>

                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall6" id="chargeInstall6" 
                                                               value="${list55.kwDc180}"   
                                                               ${list55.kwDc180 == '1' ? 'checked' : ''} disabled> 180KW DC
                                                    </div>
                                                    Quantity -- <span>${list55.kwDcQuatity180}</span>

                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <div>
                                                        <input type="checkbox" name="chargeInstall7" id="chargeInstall7" 
                                                               value="${list55.kw240}"   
                                                               ${list55.kw240 == '1' ? 'checked' : ''} disabled> 240KW
                                                    </div>
                                                    Quantity -- <span>${list55.kwQuatity240}</span>
                                                </td>
                                                <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall8" id="chargeInstall8" 
                                                                   onclick="toggleBlink(this, 'chargeInstall8qua')" 
                                                                   value="${list55.kw360}"   
                                                                   ${list55.kw360 == '1' ? 'checked' : ''} disabled>
                                                            360kW
                                                        </div>
                                                            Quantity -- <span>${list55.kwQuatity360}</span>
                                                    </td>


                                                    
                                                </tr>
<tr>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall9" id="chargeInstall9" 
                                                                   onclick="toggleBlink(this, 'chargeInstall9qua')" 
                                                                   value="${list55.kw720}"   
                                                                   ${list55.kw720 == '1' ? 'checked' : ''} disabled>
                                                            720kW
                                                        </div>
                                                        Quantity -- <span>${list55.kwQuatity720}</span>
                                                    </td>

                                                     <td style="border: 1px solid black;"><strong>Others:</strong>
                                                        <span>${list55.others}</span>
                                                    </td>
    
                                            
                                            <td style="border: 1px solid black;"> </td>
                                           
                                                    

                                                        </tr>
</table>
</c:if>
                        <c:if test="${not empty chargeInst}">
                            <table class="table table-bordered mb-3" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->

                                <tr style="border: 1px solid black;">
                                    <td colspan="9" style="border: 1px solid black; text-align: center; background-color: skyblue;">
                                        <strong>Charger Installation Details:</strong>
                                    </td>
                                </tr>
                                <tr style="border: 1px solid black;">
                                    <th style="border: 1px solid black;">Sr No</th>
                                    <th style="border: 1px solid black;">Charger Type</th>
                                    <th style="border: 1px solid black;">Charger</th>
                                    <th style="border: 1px solid black;">Charger Capacity<br>(kW)</th>
                                    <th style="border: 1px solid black;">Charger model</th>
                                    <th style="border: 1px solid black;">Connector Type</th>
                                    <th style="border: 1px solid black;">No of connectors</th>
                                    <th style="border: 1px solid black;">No of chargers</th>
                                    <th style="border: 1px solid black;">Charging rate per unit</th>

                                </tr>

                                <tbody>
                                    <c:forEach var="chargeInst" items="${chargeInst}" varStatus="status">
                                        <tr  style="border: 1px solid black;">
                                            <td style="border: 1px solid black;">${status.count}</td>
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
                                        </tr>
                                    </c:forEach>
                                </tbody>



                            </table> 
                        </c:if>


                        <table class="table table-bordered mb-3" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->

                                                        <tr>
                                                            <!--                                                <td style="border: 1px solid black;"><strong>Charging Station Protocol:</strong></td>
                                                                                                            <td style="border: 1px solid black;"> <span>${list55.noOfGuns}</span>-->
                                                            <td style="border: 1px solid black;"><strong> Total No Of Chargers:</strong></td>
                                                            <td style="border: 1px solid black;"><span>${list55.noOfCharger}</span> </td>
                                                            <td style="border: 1px solid black;"><strong>Project Timeline Category:</strong></td>
                                                            <td style="border: 1px solid black;"> <span>${list55.projectTimelineCategory}</span>

                                                        </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Time Line Of Project Completion: <br>From Date</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.timeLineFromDate}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>To Date:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.timeLineToDate}</span> </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Estimated Budget:</strong></td>
                                                <td style="border: 1px solid black;" ><span>${list55.projectBudgetAllocated}</span>

                                                <td style="border: 1px solid black;"><strong>No.of Days:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.chargingRatePerUnit}</span>

                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Others Details:</td>
                                                <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.othersDetails}</p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Project Profile:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.projectProfile}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>Profit Center:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.projectCenter}</span> </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Company Code:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.companyCode}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>Plant:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.plant}</span> </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Project Type:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.projectType}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>Project Currency:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.projectCurrency}</span> </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Investment Profile:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.inverstmentProfile}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>Capital:</strong></td>
                                                <td style="border: 1px solid black;"><span>${Discom1}</span> </td>
                                            </tr>
<!--                                            <tr>
                                                <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.noOfChargePoints}</span>

                                                </td>
                                                
                                            </tr>-->
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Overall Station Capacity (kW):</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.overallStationCapacityKw}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>Station AC Capacity(kW):</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.stationAcCapacityKw} </span> </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Station DC Capacity (kW):</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.stationDcCapacityKw}</span>

                                                </td>
                                               <td style="border: 1px solid black;"><strong>Total MegaWatt(MW):</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.totalMegaWatt}</span> </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Station Type:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.stationType}</span>

                                                </td>
                                                <td style="border: 1px solid black;"><strong>Tenant:</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.tenant}</span> </td>
                                            </tr>
                                            
                                            <tr>
                                                    <td style="border: 1px solid black;"><strong>Total kw Rating:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.totalKwRating}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.specificDateFromClient}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Charger Capacity:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.totalChargerCapacity}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charger Station Access Type:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.chargerStationAccessType}</span> </td>
                                                </tr>
                                                
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.auxiliaryLoadOfStation}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.chargingRetePerUnit}</span> </td>
                                                </tr>
                                                 <tr>
                                                    <td style="border: 1px solid black;"><strong>No. of EVs to be Charged / No. of Parking:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.noOfEvsToBeChanged}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Station Name:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.stationName}</span> </td>
                                                </tr>
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Anchore Customer:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.anchoreCustomer}</span> </td>
                                                    
                                                <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.scopeOfchargeZone == 1 ? 'YES' : 'NO'}</span> </td>
                                                </tr>
                                               <c:if test="${not empty list55.canopyVarient}">
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Canopy Varient:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.canopyVarient}</span> </td>
                                                </tr>
                                                </c:if> 
                                            
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Connection Type:</strong></td>
                                                <td style="border: 1px solid black;"><span>${connection}</span>
                                                <td style="border: 1px solid black;"><strong>Site Survey</strong></td>
                                                <td style="border: 1px solid black;"><span>${list55.siteSurvey}</span>

                                                </td>


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

                                                <c:if test="${list55.surveyRadio == '1'}">
                                                <tr style="background-color: skyblue;">
                                                    <th colspan="1" style="text-align: center; vertical-align: middle; border: 1px solid black;">Sr No</th>
                                                    <th colspan="1" style="text-align: center; vertical-align: middle; border: 1px solid black;">Survey No</th>
                                                    <th colspan="2" style="text-align: center; vertical-align: middle; border: 1px solid black;">Project Representative</th>

                                                </tr>
                                            <tbody>
                                                <c:forEach var="oapSurveyAttch" items="${oapSurveyAttch}" varStatus="status">
                                                    <tr>
                                                        <td colspan="1" style="border: 1px solid black;">${status.count}</td>
                                                        <td colspan="1" style="border: 1px solid black;"><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${oapSurveyAttch.surveyNo}">${oapSurveyAttch.surveyNo}</a></td>
                                                        <td colspan="2" style="border: 1px solid black;">${oapSurveyAttch.projectRepresentative}</td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:if>


                                            <tr style=" background-color: skyblue;">
                                                <th colspan="2" style="text-align: center; vertical-align: middle ; border: 1px solid black;">Document Name</th>
                                                <th colspan="3" style="text-align: center; vertical-align: middle; border: 1px solid black;">Attachment
                                                    <c:if test="${prdSize != 0}">
                                                        <a href="oapForm.htm?act=oapDocxdownloadzip&fileName=${list[0]}&id1=${id}" style="text-decoration: none; color: black; font-size: 16px;">
                                                            &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                        </a>
                                                    </c:if>
                                                </th>
                                            </tr>
                                        <tbody>
                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                <tr>

                                                    <td colspan="2" style="border: 1px solid black;">${list[1]}</td>
                                                    <td colspan="3" style="border: 1px solid black;">

                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list[0]}&id1=${id}" >${list[0]}</a>

                                                    </td>                                               
                                                </tr>
                                            </c:forEach>

                                            <c:forEach var="list33" items="${list33}" varStatus="status">
                                                <tr>


                                                    <td colspan="2" style="border: 1px solid black;">${list33[1]}</td>

                                                    <td colspan="3" style="border: 1px solid black;"><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>

                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>





                                        <tr>
                                            <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Approval Status</strong></td>
                                        </tr>
                                            <tr>
                                                <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Sr.No</th>
                                                <th style="text-align: center; vertical-align: middle ; border: 1px solid black;">User</th>
                                                <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Comment</th>
                                                <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Action</th>
                                            </tr>
                                        <tbody>
                                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                                <tr style="border: 1px solid black;" >
                                                    <td style="border: 1px solid black;">${status.count}</td> <!-- Serial Number -->
                                                    <td style="border: 1px solid black;">${list0.userId}</td> <!-- User ID -->
                                                    <td style="border: 1px solid black;">${list0.approvalComment}</td> <!-- Approval Comment -->
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
                    </label>
                    <select id="employee_code" name="employee_code" class="select-input" required="required" >
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
                    <select id="projectcoordinator" name="projectcoordinator" class="select-input" required="required">
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

                                            <button type="submit" class="btn theme-btn"  title="" value=" ">Assign</button>

                                        </div>
                                    </div>



                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
