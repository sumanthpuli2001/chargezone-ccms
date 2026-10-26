
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Details</title>
    </head>





    <style>
        p {
            word-wrap: break-word; /* Allows words to break if necessary */
            max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
        }
        .break-after-80 {
            word-wrap: break-word;
            overflow-wrap: break-word;
            max-width: 120ch; /* Limits to approximately 80 characters per line */
        }
        /*        @media print {
           .sidebar,.navbar ,
            .toggle-sidebar,
            .content-top{
                display: none !important;
            }
        }*/
        @media print {
            @page {
                margin: 0;
            }

            body {
                margin: 0;
                padding: 0;
            }
            #table_1 {
                margin-top: -75px;
            }
        }
        @media print {
            .no-print {
                display: none !important;
            }
        }


    </style>

    <style>
        .table-title td {
            font-size: 12px; /* Adjust as needed */
        }
    </style>

    <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
    <body>

        <main class="d-flex align-items-end justify-content-end " >
            <section class="main-content">
                <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                    <div id="contenop" class="content-top mb-0 d-flex align-items-center justify-content-between no-print sticky">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print">OAP Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                            <a href="#" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>  

                        </div>
                    </div>
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="oapFormId" value="${list55.id}">


                    <hr class="d-print-none">
                    <!--                        <div id="print-area">-->
                    <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                                    Order Acquisition Process checklist
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>

                        <tr class="table-title">
                            <td colspan="4" style="text-align: center; background-color: #e0e7ff; padding: 3px 5px;">PCS Order Details</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Document No:</strong></td>
                            <td style="padding: 3px 5px;">${list55.documentNo}</td>
                            <td style="padding: 3px 5px;"><strong>PCS Name:</strong></td>
                            <td style="padding: 3px 5px;">${list55.pcsName}</td>
                        </tr>

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Date:</strong></td>
                            <td style="padding: 3px 5px;">${list55.date}</td>
                            <td style="padding: 3px 5px;"><strong>Document Revision No:</strong></td>
                            <td style="padding: 3px 5px;">${list55.documentRevisionNo}</td>
                        </tr>



                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Project Name:</strong></td>
                            <td style="padding: 3px 5px;">${list55.projectName}</td>
                            <td style="padding: 3px 5px;"><strong>PCS City/Highway:</strong></td>
                            <td style="padding: 3px 5px;">${list55.pcsCityHighway}</td>
                        </tr>

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Country:</strong></td>
                            <td style="padding: 3px 5px;">${list55.country}</td>
                            <td style="padding: 3px 5px;"><strong>State	:</strong></td>
                            <td style="padding: 3px 5px;">${list55.state}</td>
                        </tr>

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>City:</strong></td>
                            <td style="padding: 3px 5px;">${list55.city}</td>
                            <td style="padding: 3px 5px;"><strong>Street:</strong></td>
                            <td style="padding: 3px 5px;">${list55.pcsAddress}</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>District:</strong></td>
                            <td style="padding: 3px 5px;">${list55.district}</td>
                            <td style="padding: 3px 5px;"><strong>House No:</strong></td>
                            <td style="padding: 3px 5px;">${list55.houseNo}</td>
                        </tr>

                        <tr style="font-size: 10px; height: 6px;">
                            <td style="padding: 2px 4px;"><strong>Pcs Type:</strong></td>
                            <td colspan="3" style="padding: 2px 3px;">
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsType1" id="pcsType1" value="1" disabled
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsTypeCity == '1' ? 'checked' : ''}> A. City
                                </div>
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsType2" id="pcsType2" value="1" disabled
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsTypeHighway == '1' ? 'checked' : ''}> B. Highway
                                </div>
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsType3" id="pcsType3" value="1" disabled
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsTypeOtherCheck == '1' ? 'checked' : ''}> C. Other
                                </div>
                                <div id="otherFieldContainer" style="display: ${list55.pcsTypeOtherCheck == '1' ? 'block' : 'none'}; margin-top: 3px; padding: 2px 4px;">
                                    <p style="margin: 0;">${list55.pcsTypeOther}</p>
                                </div>
                            </td>
                        </tr>




                        <tr style="font-size: 10px; height: 18px;">
                            <td style="padding: 2px 4px;"><strong>PCS Model</strong></td>
                            <td colspan="3" style="padding: 2px 4px;">
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsModel" id="pcsModel" value="${list55.pcsModelDoco}" disabled 
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsModelDoco == '1' ? 'checked' : ''}> A. DOCO
                                </div>
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsMode2" id="pcsMode2" value="${list55.pcsModelCoco}" disabled 
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsModelCoco == '1' ? 'checked' : ''}> B. COCO
                                </div>
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsMode3" id="pcsMode3" value="${list55.pcsModelDodo}" disabled 
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsModelDodo == '1' ? 'checked' : ''}> C. DODO
                                </div>
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsMode3" id="pcsMode3" value="${list55.pcsModelSaas}" disabled 
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsModelSaas == '1' ? 'checked' : ''}> D. SAAS
                                </div>
                                <div style="display: inline-block; padding: 2px 4px;">
                                    <input type="checkbox" name="pcsMode4" id="pcsMode4" value="1" disabled 
                                           style="transform: scale(0.8); margin-right: 4px;" 
                                           ${list55.pcsModelOtherCheck == '1' ? 'checked' : ''}> E. Other
                                </div>
                                <div id="modeOtherFieldContainer" style="display: ${list55.pcsModelOtherCheck == '1' ? 'block' : 'none'}; margin-top: 3px; padding: 2px 4px;">
                                    <p style="margin: 0;">${list55.pcsModelOther}</p>
                                </div>
                            </td>
                        </tr>

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Pcs Co-ordinates:</strong></td>
                            <td style="padding: 3px 5px;">${list55.pcsCoordinates}</td>
                            <td style="padding: 3px 5px;"><strong>Client Name:</strong></td>
                            <td style="padding: 3px 5px;">${list55.mobileNo}</td>
                        </tr>

                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Client E-mail:</strong></td>
                            <td style="padding: 3px 5px;">${list55.email}</td>
                            <td style="padding: 3px 5px;"><strong>Client Mobile No:</strong></td>
                            <td style="padding: 3px 5px;">${list55.alternateMobileNo}</td>
                        </tr>
                        <tr style="font-size: 11px; height: 18px; padding: 2px 4px;">
                            <td style="padding: 2px 4px;"><strong>Charge Zone Scope Of Work:</strong></td>
                            <td colspan="3" style="padding: 2px 4px;">
                                <p class="break-after-80" style="margin: 0;">${list55.clientDetails}</p>
                            </td>
                        </tr>



                        <tr style="font-size: 11px; height: 18px; padding: 2px 4px;">
                            <td style="padding: 2px 4px;"><strong>Clients Scope:</strong></td>
                            <td colspan="3" style="padding: 2px 4px;">
                                <p class="break-after-80" style="margin: 0;">${list55.clientScope}</p>
                            </td>
                        </tr>
                        <tr style="font-size: 11px; height: 18px; padding: 2px 4px;">
                            <td style="padding: 2px 4px;"><strong>Specific Requirements of Clients:</strong></td>
                            <td colspan="3" style="padding: 2px 4px;">
                                <p class="break-after-80" style="margin: 0;">${list55.specificRequriementsClients}</p>
                            </td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Name of the Sales Lead:</strong></td>
                            <td style="padding: 3px 5px;">${list55.salesLeadName}</td>
                            <td style="padding: 3px 5px;"><strong>Department:</strong></td>
                            <td style="padding: 3px 5px;">${list55.department}</td>
                        </tr>
                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                            <td style="padding: 3px 5px;"><strong>Designation:</strong></td>
                            <td style="padding: 3px 5px;">${list55.designation}</td>
                            <td style="padding: 3px 5px;"><strong>Date:</strong></td>
                            <td style="padding: 3px 5px;">${list55.salesDate}</td>
                        </tr>



                        <tr class="table-title">
                            <td colspan="4" style="text-align: center; background-color: #e0e7ff; text-align: center;padding: 3px 5px;">PCS Deliverable Details</td>
                        </tr>
                        <tr style="font-size: 9px; height: 18px; padding: 2px 4px;">
                            <td style="padding: 2px 4px;">
                                <div>
                                    <input type="checkbox" name="pcsDelivery1" id="pcsDelivery1" 
                                           value="${list55.agreementLoa}" 
                                           style="transform: scale(0.8);" 
                                           ${list55.agreementLoa == '1' ? 'checked' : ''} disabled> Agreement/LOA
                                </div>
                                <div id="attachment1" style=" margin-top: 5px;">
                                    <input type="hidden" name="attachment1File" id="attachment1File"  onchange="validateFileSize(this, 'notification1')">
                                    <a class="fw-600 text-break gradient-text"  href="oapForm.htm?act=oapDocxdownload&fileName=${list55.aggrementAttach}&id1=${id}">  <span>${list55.aggrementAttach}</span></a>
                                </div>
                            </td>
                            <td style="padding: 2px 4px;">
                                <div>
                                    <input type="checkbox" name="pcsDelivery2" id="pcsDelivery2" 
                                           value="${list55.ownerShipDocument}" 
                                           style="transform: scale(0.8);" 
                                           ${list55.ownerShipDocument == '1' ? 'checked' : ''} disabled> Ownership Document
                                </div>

                                <div id="attachment2" style=" margin-top: 5px;">
                                    <input type="hidden" name="attachment2File" id="attachment2File"  onchange="validateFileSize(this, 'notification2')">
                                    <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.ownershipAttach}&id1=${id}"> <span>${list55.ownershipAttach}</span></a>
                                </div> 


                            </td>
                            <td style="padding: 2px 4px;">
                                <div>
                                    <input type="checkbox" name="pcsDelivery3" id="pcsDelivery3" 
                                           value="${list55.preliminarySiteSurvey}" 
                                           style="transform: scale(0.8);" 
                                           ${list55.preliminarySiteSurvey == '1' ? 'checked' : ''} disabled> Preliminary Site Survey
                                </div>

                                <div id="attachment3" style=" margin-top: 5px;">
                                    <input type="hidden" name="attachment3File" id="attachment3File"  onchange="validateFileSize(this, 'notification3')">
                                    <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.preliminaryAttach}&id1=${id}"> <span>${list55.preliminaryAttach}</span></a>
                                </div>
                            </td>
                            <td style="padding: 2px 4px;">
                                <div>
                                    <input type="checkbox" name="pcsDelivery4" id="pcsDelivery4" 
                                           value="${list55.consentLetterNoc}" 
                                           style="transform: scale(0.8);" 
                                           ${list55.consentLetterNoc == '1' ? 'checked' : ''} disabled> Consent Letter/NOC
                                </div>
                                <div id="attachment4" style=" margin-top: 5px;">
                                    <input type="hidden" name="attachment4File" id="attachment4File"  onchange="validateFileSize(this, 'notification4')">
                                    <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55.consentAttach}&id1=${id}"> <span>${list55.consentAttach}</span></a>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <c:if test="${empty chargeInst}">
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                            <tr class="table-title">
                                <td colspan="4" style="text-align: center;background-color: #e0e7ff; padding: 3px 5px;">Charger Installation Details</td>
                            </tr>
                            <tr style="font-size: 8px; height: 18px; padding: 2px 3px;">
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall1" id="chargeInstall1" 
                                               value="${list55.kwAc77}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kwAc77 == '1' ? 'checked' : ''} disabled> 7.7KW AC
                                    </div>
                                    Quantity -- <span>${list55.kwAcQuatity77}</span>
                                </td>
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall2" id="chargeInstall2" 
                                               value="${list55.kwDc15}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kwDc15 == '1' ? 'checked' : ''} disabled> 15KW DC
                                    </div>
                                    Quantity -- <span>${list55.kwDcQuatity15}</span>
                                </td>
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall3" id="chargeInstall3" 
                                               value="${list55.kwDc30}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kwDc30 == '1' ? 'checked' : ''} disabled> 30KW DC
                                    </div>
                                    Quantity -- <span>${list55.kwDcQuatity30}</span>
                                </td>
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall4" id="chargeInstall4" 
                                               value="${list55.kwDc60}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kwDc60 == '1' ? 'checked' : ''} disabled> 60KW DC
                                    </div>
                                    Quantity -- <span>${list55.kwDcQuatity60}</span>
                                </td>
                            </tr>

                            <tr style="font-size: 8px; height: 18px; padding: 2px 3px;">
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall5" id="chargeInstall5" 
                                               value="${list55.kwDc120}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kwDc120 == '1' ? 'checked' : ''} disabled> 120KW DC
                                    </div>
                                    Quantity -- <span>${list55.kwDcQuatity120}</span>
                                </td>
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall6" id="chargeInstall6" 
                                               value="${list55.kwDc180}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kwDc180 == '1' ? 'checked' : ''} disabled> 180KW DC
                                    </div>
                                    Quantity -- <span>${list55.kwDcQuatity180}</span>
                                </td>
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall7" id="chargeInstall7" 
                                               value="${list55.kw240}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kw240 == '1' ? 'checked' : ''} disabled> 240KW
                                    </div>
                                    Quantity -- <span>${list55.kwQuatity240}</span>
                                </td>
                                <td style="padding: 2px 3px;">
                                    <div>
                                        <input type="checkbox" name="chargeInstall8" id="chargeInstall8" 
                                               value="${list55.kw360}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kw360 == '1' ? 'checked' : ''} disabled>360KW
                                    </div>
                                    Quantity -- <span>${list55.kwQuatity360}</span>
                                </td>

                            </tr>
                            <tr  style="font-size: 8px; height: 18px; padding: 2px 3px;">
                                <td style="padding: 2px 3px;" colspan="2">
                                    <div>
                                        <input type="checkbox" name="chargeInstall9" id="chargeInstall9" 
                                               value="${list55.kw720}" 
                                               style="transform: scale(0.8);" 
                                               ${list55.kw720 == '1' ? 'checked' : ''} disabled>720KW
                                    </div>
                                    Quantity -- <span>${list55.kwQuatity720}</span>
                                </td>
                                <td style="padding: 2px 3px;" colspan="2">
                                    <strong>Others:</strong> <span>${list55.others}</span>
                                </td>
                            </tr>
                        </table>
                    </c:if>
                    <c:if test="${not empty chargeInst}">
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="9" style="text-align: center;background-color: #e0e7ff; padding: 3px 5px;border: 1px solid black;">Charger Installation Details</td>
                            </tr>
                            <tr style="font-size: 8px; height: 18px; padding: 2px 3px;">
                                <th style="border: 1px solid black;padding: 2px 3px;">Sr No</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">Charger Type</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">Charger</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">Charger Capacity<br>(kW)</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">Charger model</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">Connector Type</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">No of connectors</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">No of chargers</th>
                                <th style="border: 1px solid black;padding: 2px 3px;">Charging rate per unit</th>

                            </tr>
<tbody>
                                    <c:forEach var="chargeInst" items="${chargeInst}" varStatus="status">
                                        <tr  style="font-size: 8px; height: 18px; padding: 2px 3px;">
                                            <td style="border: 1px solid black;padding: 2px 3px;">${status.count}</td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">${chargeInst.chargerType}</td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">
                                                ${chargeInst.charger}
                                                <br>
                                                <c:if test="${chargeInst.charger eq 'Other'}">
                                                      ${chargeInst.chargerOther}
                                                </c:if>
                                            </td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">${chargeInst.chargerCapacityKW}</td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">${chargeInst.chargermodel}</td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">
                                                ${chargeInst.connectorType}
                                            <br>
                                                <c:if test="${chargeInst.connectorType eq 'Other'}">
                                                      ${chargeInst.connectorTypeOther}
                                                </c:if>
                                            </td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">${chargeInst.noofconnectors}</td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">${chargeInst.noofchargers}</td>
                                            <td style="border: 1px solid black;padding: 2px 3px;">${chargeInst.chargingrateperunit}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                        </table>   
                    </c:if>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                        <tr>
                            <!--                            <td style="font-size: 10px; padding: 3px 5px;"><strong>Charging Station Protocol:</strong></td>
                                                        <td  style="font-size: 10px; padding: 3px 5px;"> <span>${list55.noOfGuns}</span> </td>
                            -->
                            <td style="font-size: 9px; padding: 3px 4px;"><strong> Total No Of Chargers:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.noOfCharger}</span> </td>
                            <td style="font-size: 10px; padding: 3px 5px;"><strong>Project Timeline Category:</strong></td>
                            <td  style="font-size: 10px; padding: 3px 5px;"> <span>${list55.projectTimelineCategory}</span> </td>

                        </tr>
                        <tr>
                            <td style="font-size: 10px; padding: 3px 5px;"><strong>Time Line Of Project Completion :From Date</strong></td>
                            <td style="font-size: 10px; padding: 3px 5px;"><span>${list55.timeLineFromDate}</span>
                            </td>
                            <td style="font-size: 10px; padding: 3px 5px;"><strong>To Date:</strong></td>
                            <td style="font-size: 10px; padding: 3px 5px;"><span>${list55.timeLineToDate}</span></td>
                        </tr>
                        <tr>
                            <td style="font-size: 10px; padding: 3px 5px;"><strong>Estimated Budget:</strong></td>
                            <td  style="font-size: 10px; padding: 3px 5px;"><span>${list55.projectBudgetAllocated}</span>
                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>No.of Days:</strong></td>
                            <td colspan="5" style="font-size: 9px; padding: 3px 4px;"><span>${list55.chargingRatePerUnit}</span>

                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Others Details:</strong></td>
                            <td colspan="3" style="font-size: 9px; padding: 3px 4px;"><p class="break-after-80">${list55.othersDetails}</p>
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Project Profile:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectProfile}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Profit Center:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectCenter}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Company Code:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.companyCode}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Plant:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.plant}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Project Type:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectType}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Project Currency:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectCurrency}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Investment Profile:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.inverstmentProfile}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Capital:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${Discom1}</span> </td>
                        </tr>
                        <!--                        <tr>
                                                    <td style="font-size: 9px; padding: 3px 4px;"><strong>No Of Charge Points:</strong></td>
                                                    <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.noOfChargePoints}</span>
                        
                                                    </td>-->

                        <!--</tr>-->
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Overall Station Capacity (kW):</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.overallStationCapacityKw}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station AC Capacity (kW):</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationAcCapacityKw} </span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station DC Capacity (kW):</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationDcCapacityKw}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Total MegaWatt(MW):</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.totalMegaWatt}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station Type:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationType}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Tenant:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.tenant}</span> </td>
                        </tr>


                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Total kw Rating:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.totalKwRating}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Specific Date From Client:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.specificDateFromClient}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Total Charger Capacity:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.totalChargerCapacity}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Charger Station Access Type:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.chargerStationAccessType}</span> </td>
                        </tr>

                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Auxiliary Load Of Station:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.auxiliaryLoadOfStation}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Charging Rate Per Unit:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.chargingRetePerUnit}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>No Of Evs To Be Changed:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.noOfEvsToBeChanged}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station Name:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationName}</span> </td>
                        </tr>   
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Anchore Customer:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.anchoreCustomer}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Scope of ChargeZone:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.scopeOfchargeZone == 1 ? 'YES' : 'NO'}</span> </td>
                        </tr>   

                        <c:if test="${not empty list55.canopyVarient}">
                            <tr>
                                <td style="font-size: 9px; padding: 3px 4px;" ><strong>Canopy Varient:</strong></td>
                                <td style="font-size: 9px; padding: 3px 4px;"colspan="3"><span>${list55.canopyVarient}</span> </td>
                            </tr>
                        </c:if>


                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Connection Type:</strong></td>
                            <td  style="font-size: 9px; padding: 3px 4px;"><span>${connection}</span>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Site Survey:</strong></td>
                            <td  style="font-size: 9px; padding: 3px 4px;"><span>${list55.siteSurvey}</span>

                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Survey:</strong></td>
                            <td  colspan="5" style="font-size: 9px; padding: 3px 4px;">
                                <c:if test="${list55.surveyRadio == '1'}">
                                    Site Survey Created
                                </c:if>  
                                <c:if test="${list55.surveyRadio == '0'}">
                                    Site Survey Not Created
                                </c:if>



                        </tr>
                        <c:if test="${list55.surveyRadio == '1'}">
                            <tr class="table-title">
                                <th colspan="1" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Sr No</th>
                                <th colspan="2" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Survey No</th>
                                <th colspan="2" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Project Representative</th>


                            </tr>
                            <tbody>
                                <c:forEach var="oapSurveyAttch" items="${oapSurveyAttch}" varStatus="status">
                                    <tr style="font-size: 10px; padding: 3px 5px;">
                                        <td colspan="1" style="font-size: 10px; padding: 3px 5px;">${status.count}</td>
                                        <td colspan="2" style="font-size: 10px; padding: 3px 5px;">${oapSurveyAttch.surveyNo}</td>
                                        <td colspan="2" style="font-size: 10px; padding: 3px 5px;">${oapSurveyAttch.projectRepresentative}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>
                        <tr class="table-title">
                            <th colspan="2" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Document Name</th>
                            <th colspan="3" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Attachment

                            </th>
                        </tr>

                        <tbody>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <tr style="font-size: 10px; padding: 3px 5px;">
                                    <td colspan="2" style="font-size: 10px; padding: 3px 5px;">${list[1]}</td>
                                    <td colspan="3" style="font-size: 10px; padding: 3px 5px;">
                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list[0]}&id1=${id}">${list[0]}</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            <c:forEach var="list33" items="${list33}" varStatus="status">
                                <tr style="font-size: 10px; padding: 3px 5px;">
                                    <td colspan="2"style="font-size: 10px; padding: 3px 5px;">${list33[1]}</td>
                                    <td colspan="3"style="font-size: 10px; padding: 3px 5px;">
                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                        <tr class="table-title">
                            <td colspan="4" style=" font-size: 11px; padding: 3px 4px; background-color: #e0e7ff; text-align: center;"><strong>Approval Status</strong></td>
                        </tr>

                        <tr>
                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr. No</th>
                            <th style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">User</th>
                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Comment</th>
                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Action</th>
                        </tr>

                        <tbody>
                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                <tr style="" >
                                    <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.userId}</td> <!-- User ID -->
                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.approvalComment}</td> <!-- Approval Comment -->
                                    <td style="font-size: 9px; padding: 3px 5px;">
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
                    <!--</div>-->

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
