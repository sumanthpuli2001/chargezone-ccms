
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP History View</title>
    </head>
    <style>
        textarea{
            width: 100%;
            text-transform: capitalize;

        }
        .nav-tabs-custom {
            border-top: 0px solid #00a65a;

        }

        input[type="checkbox"]:disabled + label::before{
            background: gray;
        }
        input[type="checkbox"]:disabled + label:hover::before{
            background: gray;
            border: 1px solid #d4d4d5;
        }
        @media print {
            a[href]:after {
                content: none !important;

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
                text-transform: capitalize;

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
                    <form:form action=".htm?act=" commandName="departmentMaster" method="post">

                        <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                            <div class="page-title d-flex align-items-center">
                                <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                    <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                    <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                         alt="Menu collapse">
                                </div>

                                <h5 class="fw-600 mb-0">OAP History View</h5>
                            </div>

                            <div class="cta d-flex align-items-center">
                                <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                                <a href="oapForm.htm?act=oapPrint&id=${id}" class="btn theme-btn mr-3" onclick="printCustom()" title="Print this page">
                                    <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                                </a>
                                <a href="oapForm.htm?act=oapexcel&id=${id}"  class="btn theme-btn" title="Export data to Excel">
                                    <i class="fa fa-file-excel-o"></i>&nbsp;&nbsp;Excel
                                </a>
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
                             Contract Review Checklist
                            </td>
                        </tr>
                    </tbody>
                </table>

                        <br>
                                         <input type="hidden" name="id" value="${id}">
                                        <input type="hidden" name="oapFormId" value="${list55[0].id}">
                                          <table class="table table-bordered mb-3" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                            <thead>
                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; background-color: skyblue"><strong>PCS Order Details:</strong></td>
                                                </tr>

                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <span>${list55[0].documentNo}</span>
                                                    </td>

                                                    <td style="border: 1px solid black;"><strong>PCS Name:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <span>${list55[0].pcsName} </span>    
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Date:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <span>${list55[0].date}</span>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Document Revision No:</strong></td>
                                                    <td style="border: 1px solid black;">
                                                        <span>${list55[0].documentRevisionNo}</span>
                                                    </td>
                                                </tr>





                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Name:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].projectName}</span>
                                                    <td style="border: 1px solid black;"><strong>PCS City/Highway:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].pcsCityHighway}</span>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Country:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].country}</span>
                                                    <td style="border: 1px solid black;"><strong>State:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].state}</span>
                                                    </td>


                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>City:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].city}</span>
                                                    <td style="border: 1px solid black;"><strong>Street:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].pcsAddress}</span>
                                                    </td>


                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>District:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].district}</span>
                                                    <td style="border: 1px solid black;"><strong>House No:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].houseNo}</span>
                                                    </td>


                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;">
                                                        <strong>Pcs Type:</strong>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="pcsType1" id="pcsType1" value="1" disabled
                                                                   ${list55[0].pcsTypeCity == '1' ? 'checked' : ''}> A. City
                                                        </label>
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="pcsType2" id="pcsType2" value="1" disabled
                                                                   ${list55[0].pcsTypeHighway == '1' ? 'checked' : ''}> B. Highway
                                                        </label>
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="pcsType3" id="pcsType3" value="1" disabled
                                                                   ${list55[0].pcsTypeOtherCheck == '1' ? 'checked' : ''}> C. Other
                                                        </label>
                                                        <div id="otherFieldContainer" style="display: ${list55[0].pcsTypeOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                            <p>${list55[0].pcsTypeOther}</p>

                                                        </div>
                                                    </td>

                                                    <!-- Column 2: PCS Model -->
                                                    <td style="border: 1px solid black; vertical-align: top;">
                                                        <strong>PCS Model</strong>
                                                    </td>
                                                    <td style="border: 1px solid black; padding: 5px;">
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsModel" id="pcsModel" value="${list55[0].pcsModelDoco}" disabled 
                                                                   ${list55[0].pcsModelDoco == '1' ? 'checked' : ''}> A. DOCO
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode2" id="pcsMode2" value="${list55[0].pcsModelCoco}" disabled 
                                                                   ${list55[0].pcsModelCoco == '1' ? 'checked' : ''}> B. COCO
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode3" id="pcsMode3" value="${list55[0].pcsModelDodo}" disabled 
                                                                   ${list55[0].pcsModelDodo == '1' ? 'checked' : ''}> C. DODO
                                                        </div>
                                                         <br>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode5" id="pcsMode5" value="${list55[0].pcsModelSaas}" disabled 
                                                                   ${list55[0].pcsModelSaas == '1' ? 'checked' : ''}> D. SAAS
                                                        </div>
                                                       
                                                        <div style="display: inline; ">
                                                            <input type="checkbox" name="pcsMode4" id="pcsMode4" value="1" disabled  ${list55[0].pcsModelOtherCheck == '1' ? 'checked' : ''}> D. Other
                                                        </div>
                                                        <div id="modeOtherFieldContainer"  style="display: ${list55[0].pcsModelOtherCheck == '1' ? 'block' : 'none'}; margin-top: 5px;">
                                                            <p>${list55[0].pcsModelOther}</p>
                                                        </div>
                                                    </td>
                                                </tr>

                                                </td>

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Pcs Co-ordinates:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].pcsCoordinates}</span>

                                                    <td style="border: 1px solid black;"><strong>Client Name:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].mobileNo}</span>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Client E-mail:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].email}</span>
                                                    <td style="border: 1px solid black;"><strong>Client  mobile No:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].alternateMobileNo}</span>
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charge Zone Scope Of work:</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55[0].clientDetails}</p>

                                                    </td>
                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Clients Scope: </strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55[0].clientScope}</p>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Specific Requirements of Clients:</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55[0].specificRequriementsClients}</p>

                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Name of the sales lead:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].salesLeadName}</span>
                                                    <td style="border: 1px solid black;"><strong>Department:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].department}</span>

                                                </tr>      

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Designation:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].designation}</span></td>

                                                    <td style="border: 1px solid black;"><strong>Date:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].salesDate}</span></td>
                                                </tr>






                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>PCS Deliverable Details:</strong></td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <div>
                                                            <input style="" type="checkbox" name="pcsDelivery1" id="pcsDelivery1" 
                                                                   value="${list55[0].agreementLoa}" 
                                                                   ${list55[0].agreementLoa == '1' ? 'checked' : ''} disabled> Agreement/LOA
                                                        </div>
                                                        <div id="attachment1" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment1File" id="attachment1File"  onchange="validateFileSize(this, 'notification1')">
                                                            <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55[0].aggrementAttach}&id1=${id}">  <span>${list55[0].aggrementAttach}</span></a>




                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery2" id="pcsDelivery2" 
                                                                   value="${list55[0].ownerShipDocument}" 
                                                                   ${list55[0].ownerShipDocument == '1' ? 'checked' : ''} disabled> Ownership Document
                                                        </div>
                                                        <div id="attachment2" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment2File" id="attachment2File"  onchange="validateFileSize(this, 'notification2')">
                                                            <a class="fw-600 text-break gradient-text"  href="oapForm.htm?act=oapDocxdownload&fileName=${list55[0].ownershipAttach}&id1=${id}"><span>${list55[0].ownershipAttach}</span></a>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery3" id="pcsDelivery3" 
                                                                   value="${list55[0].preliminarySiteSurvey}" 
                                                                   ${list55[0].preliminarySiteSurvey == '1' ? 'checked' : ''} disabled> Preliminary Site Survey
                                                        </div>
                                                        <div id="attachment3" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment3File" id="attachment3File"  onchange="validateFileSize(this, 'notification3')">
                                                            <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55[0].preliminaryAttach}&id1=${id}"><span>${list55[0].preliminaryAttach}</span></a>

                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;width: 25%;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery4" id="pcsDelivery4" 
                                                                   value="${list55[0].consentLetterNoc}" 
                                                                   ${list55[0].consentLetterNoc == '1' ? 'checked' : ''} disabled> Consent Letter/NOC
                                                        </div>
                                                        <div id="attachment4" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment4File" id="attachment4File"  onchange="validateFileSize(this, 'notification4')">
                                                            <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=oapDocxdownload&fileName=${list55[0].consentAttach}&id1=${id}">  <span>${list55[0].consentAttach}</span></a>
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
                                                                   value="${list55[0].kwAc77}"   
                                                                   ${list55[0].kwAc77 == '1' ? 'checked' : ''} disabled> 7.7KW AC
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwAcQuatity77}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall2" id="chargeInstall2" 
                                                                   value="${list55[0].kwDc15}"   
                                                                   ${list55[0].kwDc15 == '1' ? 'checked' : ''} disabled> 15KW DC
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwDcQuatity15}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall3" id="chargeInstall3" 
                                                                   value="${list55[0].kwDc30}"   
                                                                   ${list55[0].kwDc30 == '1' ? 'checked' : ''} disabled> 30KW DC
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwDcQuatity30}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall4" id="chargeInstall4" 
                                                                   value="${list55[0].kwDc60}"   
                                                                   ${list55[0].kwDc60 == '1' ? 'checked' : ''} disabled> 60KW DC
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwDcQuatity60}</span>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall5" id="chargeInstall5" 
                                                                   value="${list55[0].kwDc120}"   
                                                                   ${list55[0].kwDc120 == '1' ? 'checked' : ''} disabled> 120KW DC
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwDcQuatity120}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall6" id="chargeInstall6" 
                                                                   value="${list55[0].kwDc180}"   
                                                                   ${list55[0].kwDc180 == '1' ? 'checked' : ''} disabled> 180KW DC
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwDcQuatity180}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall7" id="chargeInstall7" 
                                                                   value="${list55[0].kw240}"   
                                                                   ${list55[0].kw240 == '1' ? 'checked' : ''} disabled> 240KW
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwQuatity240}</span>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall8" id="chargeInstall8" 
                                                                   value="${list55[0].kw360}"   
                                                                   ${list55[0].kw360 == '1' ? 'checked' : ''} disabled>360KW 
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwQuatity360}</span>

                                                    </td> 
                                                </tr>
                                                
                                               <tr>
                                                <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="chargeInstall9" id="chargeInstall9" 
                                                                   value="${list55[0].kw720}"   
                                                                   ${list55[0].kw720 == '1' ? 'checked' : ''} disabled>720KW 
                                                        </div>
                                                        Quantity -- <span>${list55[0].kwQuatity720}</span>

                                                    </td>    
                                                   
                                                    <td style="border: 1px solid black;"><strong>Others:</strong>
                                                        <span>${list55[0].others}</span>
                                                    </td>
                                                    
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
<!--                                                    <td style="border: 1px solid black;"><strong>Charging Station Protocol:</strong></td>
                                                    <td style="border: 1px solid black;"> <span>${list55[0].noOfGuns}</span>-->
                                                    <td style="border: 1px solid black;"><strong>No Of Charger:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].noOfCharger}</span> </td>
                                                    <td style="border: 1px solid black;"><strong>Project Timeline Category:</strong></td>
                                                    <td style="border: 1px solid black;"> <span>${list55[0].projectTimelineCategory}</span>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Time Line Of Project Completion: <br>From Date</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].timeLineFromDate}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>To Date:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].timeLineToDate}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Estimated Budget:</strong></td>
                                                    <td style="border: 1px solid black;" ><span>${list55[0].projectBudgetAllocated}</span>
                                                    <td style="border: 1px solid black;"><strong>No.of Days:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].chargingRatePerUnit}</span>

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Others Details:</td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55[0].othersDetails}</p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Profile:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].projectProfile}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Profit Center:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].projectCenter}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Company Code:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].companyCode}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Plant:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].plant}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Project Type:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].projectType}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Project Currency</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].projectCurrency}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Investment Profile</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].inverstmentProfile}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Capital</strong></td>
                                                    <td style="border: 1px solid black;"><span>${Discom1}</span> </td>
                                                </tr>
<!--                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>No Of Charge Points:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].noOfChargePoints}</span>

                                                    </td>
                                                    
                                                </tr>-->
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Overall Station Capacity (kW):</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].overallStationCapacityKw}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Station AC Capacity (kW):</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].stationAcCapacityKw} </span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station DC Capacity (kW):</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].stationDcCapacityKw}</span>

                                                    </td>
                                                     <td style="border: 1px solid black;"><strong>Total MegaWatt(MW):</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].totalMegaWatt}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Station Type:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].stationType}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Tenant:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].tenant}</span> </td>
                                                </tr>
                                                
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Total kw Rating:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].totalKwRating}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Specific Date From Client:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].specificDateFromClient}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Total Charger Capacity:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].totalChargerCapacity}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charger Station Access Type:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].chargerStationAccessType}</span> </td>
                                                </tr>
                                                
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Auxiliary Load Of Station:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].auxiliaryLoadOfStation}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Charging Rate Per Unit:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].chargingRetePerUnit}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>No. of EVs to be Charged / No. of Parking:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].noOfEvsToBeChanged}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>Station Name:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].stationName}</span> </td>
                                                </tr>
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Anchore Customer:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].anchoreCustomer}</span> </td>
                                                    
                                                <td style="border: 1px solid black;"><strong>Scope of ChargeZone:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].scopeOfchargeZone == 1 ? 'YES' : 'NO'}</span> </td>
                                                </tr>
                                               <c:if test="${not empty list55[0].canopyVarient}">
                                                 <tr>
                                                <td style="border: 1px solid black;"><strong>Canopy Varient:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].canopyVarient}</span> </td>
                                                </tr>
                                                </c:if>
                                               
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Connection Type:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${connection}</span>
                                                    <td style="border: 1px solid black;"><strong>Site Survey</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55[0].siteSurvey}</span>

                                                    </td>
                                                </tr>

                                                
                                            <c:if test="${list55[0].surveyRadio == '1' and not empty oapSurveyAttch}">
                                                    <tr style="background-color: skyblue;">
                                                        <th colspan="2" style="text-align: center; vertical-align: middle; border: 1px solid black;">Sr No</th>
                                                        <th colspan="2" style="text-align: center; vertical-align: middle; border: 1px solid black;">Survey No</th>

                                                    </tr>
                                                <tbody>
                                                    <c:forEach var="oapSurveyAttch" items="${oapSurveyAttch}" varStatus="status">
                                                        <tr>
                                                            <td colspan="2" style="border: 1px solid black;">${status.count}</td>
                                                            <td colspan="2" style="border: 1px solid black;"><a href="oapForm.htm?act=siteSurveyView&id=${oapSurveyAttch.surveyNo}">${oapSurveyAttch.surveyNo}</a></td>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </c:if>
                                                 
                                           <c:if test="${not empty list33}">
        <tr style="background-color: skyblue;">
            <th colspan="2" style="text-align: center; vertical-align: middle; border: 1px solid black;">
                Document Name
            </th>
            <th colspan="3" style="text-align: center; vertical-align: middle; border: 1px solid black;">
                Attachment
                <c:if test="${prdSize != 0}">
                    <a href="oapForm.htm?act=oapDocxdownloadzip&fileName=${list[0]}&id1=${id}"
                       style="text-decoration: none; color: black; font-size: 16px;">
                        &nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-download"></i>
                    </a>
                </c:if>
            </th>
        </tr>

    <tbody>
        <c:forEach var="list33" items="${list33}">
            <tr>
                <td colspan="2" style="border: 1px solid black;">
                    ${list33.description}
                </td>
                <td colspan="3" style="border: 1px solid black;">
                    <a href="oapForm.htm?act=oapDocxdownload&fileName=${list33.attachment}&id1=${id}">
                        ${list33.attachment}
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</c:if>

                                            
                                            
                                             <tbody style="border: 1px solid black;">
                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Approval Status</strong></td>
                                                </tr>
                                            </tbody>
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
                                                    <h6>Activity Milestone</h6>
                                                    <table id="commonTable" class="table  table-striped bg-white" style="max-width: 100%;" align="center">
                                                        <thead>

                                                            <tr>
                                                                <th >Sr No</th>
                                                                <th >Activity</th>
                                                                <th >Activity By</th>
                                                                <th >Date</th>
                                                                <th >Status</th>
                                                                <th >Comments</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="oaplogmaster" items="${oaplogmaster}" varStatus="status">
                                                                <tr>
                                                                    <td>${status.count}</td>
                                                                    <td >${oaplogmaster.activity}</td>
                                                                    <td >${oaplogmaster.activityBy}</td>
                                                                    <td>${oaplogmaster.date}</td>
                                                                    <td >${oaplogmaster.status}</td>
                                                                    <td >${oaplogmaster.comments}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table> 

                    </form:form>
                </section>
            </main>
        </body>
        <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    </html>
