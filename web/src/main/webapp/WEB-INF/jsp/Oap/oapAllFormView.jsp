<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Aman Bahukhandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OAP Details view</title>
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
                    max-width: 80ch; /* Limits to approximately 80 characters per line */
                }
            </style>

        </head>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">

                <div style="display: flex; height: 25px; justify-content: space-between; align-items: center;">
                    <h3 style="margin-top: 1px;">OAP Details View</h3>

                     <div style="display: flex; justify-content: flex-end;">
                        <div style="display: flex; gap: 10px; align-items: center;">
                            <a href="oapForm.htm?act=oapPrint&id=${id}" class="btn btn-primary" onclick="printCustom()" title="Print this page">
                                <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                            </a>
                            <input type="button" class="btn btn-primary" onclick="history.back();" title="Go back to the previous page" value="Back">
                        </div>
                    </div>
                </div>

                <script>
                    function printPage() {
                        window.print();
                    }
                </script>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab_1">
                                    <c:if test="${!empty successMessage}">
                                        <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                    </c:if>
                                    <c:if test="${!empty failureMessage}">
                                        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                    </c:if>
                                    <form:form action="oapForm.htm?act=OapApproveButton" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                               class="form-horizontal" role="form">
                                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                        <input type="hidden" name="id" value="${id}">
                                        <input type="hidden" name="oapFormId" value="${list55.id}">

                                        <c:forEach var="list" items="${list}" varStatus="status">

                                            <input type="hidden" name="id" value="${list[2]}">

                                        </c:forEach>

                                        <c:forEach var="list" items="${list33}" varStatus="status">

                                            <input type="hidden" name="id" value="${list[2]}">

                                        </c:forEach>

                                        <hr>
                                        <table class="table table-bordered" id="table_1" style="max-width: 95%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                            <tbody>
                                                <tr>
                                                    <td colspan="3" style="height: 20vh; border: 1px solid black; text-align: center; vertical-align: middle;">
                                                        <img src="StorageYard/Images/logo.png" style="background-color: white;">
                                                    </td>

                                                    <td colspan="4" style="border: 1px solid black; text-align: center; vertical-align: bottom; padding-bottom: 55px;  font-weight: bold; font-size: 3vh;">Order Aquatic Process Check List</td>

                                                    <!--<td colspan="1" style="border: 1px solid black;">Order Aquatic process checklist</td>-->
                                                </tr>
                                                <!--                                                <tr>
                                                                                                    <td style="border: 1px solid black;">Prepared By</td>
                                                                                                    <td style="border: 1px solid black;">Received By</td>
                                                                                                    <td style="border: 1px solid black;">Approved BY</td>
                                                                                                    <td colspan="4" style="border: 1px solid black;">Procedure No</td>
                                                
                                                                                                </tr>-->
                                                <!--                                                <tr>
                                                                                                    <td style="border: 1px solid black;"><input  class="form-control"/> </td>    
                                                
                                                                                                    <td style="border: 1px solid black;"><input  class="form-control"/> </td>    
                                                                                                    <td style="border: 1px solid black;"><input  class="form-control"/> </td>    
                                                                                                    <td style="border: 1px solid black;"><input  class="form-control"/> </td>    
                                                
                                                                                                </tr>-->
                                            </tbody>
                                        </table>
                                        <br>

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
                                                    <td style="border: 1px solid black;"><strong>PCS Address:</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"> <p class="break-after-80">${list55.pcsAddress}</p>
                                                    </td>

                                                </tr>



                                                <tr>
                                                    <td style="border: 1px solid black;">
                                                        <strong>Pcs Type</strong>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="pcsType1" id="pcsType1" value="on" disabled
                                                                   ${list55.pcsTypeCity == 'on' ? 'checked' : ''}> A. City
                                                        </label>
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="pcsType2" id="pcsType2" value="on" disabled
                                                                   ${list55.pcsTypeHighway == 'on' ? 'checked' : ''}> B. Highway
                                                        </label>
                                                        <label style="display: inline;">
                                                            <input type="checkbox" name="pcsType3" id="pcsType3" value="on" disabled
                                                                   ${list55.pcsTypeOtherCheck == 'on' ? 'checked' : ''}> C. Other
                                                        </label>
                                                        <div id="otherFieldContainer" style="display: ${list55.pcsTypeOtherCheck == 'on' ? 'block' : 'none'}; margin-top: 5px;">
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
                                                                   ${list55.pcsModelDoco == 'on' ? 'checked' : ''}> A. DOCO
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode2" id="pcsMode2" value="${list55.pcsModelCoco}" disabled 
                                                                   ${list55.pcsModelCoco == 'on' ? 'checked' : ''}> B. COCO
                                                        </div>
                                                        <div style="display: inline;">
                                                            <input type="checkbox" name="pcsMode3" id="pcsMode3" value="${list55.pcsModelDodo}" disabled 
                                                                   ${list55.pcsModelDodo == 'on' ? 'checked' : ''}> C. DODO
                                                        </div>
                                                        <div style="display: inline; ">
                                                            <input type="checkbox" name="pcsMode4" id="pcsMode4" value="on" disabled  ${list55.pcsModelOtherCheck == 'on' ? 'checked' : ''}> D. Other
                                                        </div>
                                                        <div id="modeOtherFieldContainer"  style="display: ${list55.pcsModelOtherCheck == 'on' ? 'block' : 'none'}; margin-top: 5px;">
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
                                                    <td style="border: 1px solid black;"><strong>Specific Requirements of Clients</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.specificRequriementsClients}</p>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong> Clients Scope: </strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.clientScope}</p>

                                                    </td>
                                                </tr>


                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Name of The Sales Lead:</strong></td>
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
                                                    <td style="border: 1px solid black;"><strong>Signature</strong></td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.signature}</p> </td>


                                                </tr>

                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>PCS Deliverable Details:</strong></td>
                                                </tr>
                                                 <tr>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input style="" type="checkbox" name="pcsDelivery1" id="pcsDelivery1" 
                                                                   value="${list55.agreementLoa}" 
                                                                   ${list55.agreementLoa == '1' ? 'checked' : ''} disabled> Agreement/LOA
                                                        </div>
                                                        <div id="attachment1" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment1File" id="attachment1File"  onchange="validateFileSize(this, 'notification1')">
                                                            <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${list55.aggrementAttach}">  <span>${list55.aggrementAttach}</span></a>




                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery2" id="pcsDelivery2" 
                                                                   value="${list55.ownerShipDocument}" 
                                                                   ${list55.ownerShipDocument == '1' ? 'checked' : ''} disabled> Ownership Document
                                                        </div>
                                                        <div id="attachment2" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment2File" id="attachment2File"  onchange="validateFileSize(this, 'notification2')">
                                                            <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${list55.ownershipAttach}"> <span>${list55.ownershipAttach}</span></a>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery3" id="pcsDelivery3" 
                                                                   value="${list55.preliminarySiteSurvey}" 
                                                                   ${list55.preliminarySiteSurvey == '1' ? 'checked' : ''} disabled> Preliminary Site Survey
                                                        </div>
                                                        <div id="attachment3" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment3File" id="attachment3File"  onchange="validateFileSize(this, 'notification3')">
                                                            <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${list55.preliminaryAttach}">  <span>${list55.preliminaryAttach}</span></a>

                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid black;">
                                                        <div>
                                                            <input type="checkbox" name="pcsDelivery4" id="pcsDelivery4" 
                                                                   value="${list55.consentLetterNoc}" 
                                                                   ${list55.consentLetterNoc == '1' ? 'checked' : ''} disabled> Consent Letter/NOC
                                                        </div>
                                                        <div id="attachment4" style=" margin-top: 5px;">
                                                            <input type="hidden" name="attachment4File" id="attachment4File"  onchange="validateFileSize(this, 'notification4')">
                                                            <a href="oapForm.htm?act=oapCheckBoxAttach&fileNames=${list55.consentAttach}">  <span>${list55.consentAttach}</span></a>
                                                        </div>
                                                    </td>
                                                </tr>

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
                                                    <td style="border: 1px solid black;"><strong>Others:</strong>
                                                        <span>${list55.others}</span>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Charging Station Protocol</strong></td>
                                                    <td style="border: 1px solid black;"> <span>${list55.noOfGuns}</span>

                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Time Line Of Project Completion: <br>From Date</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.timeLineFromDate}</span>

                                                    </td>
                                                    <td style="border: 1px solid black;"><strong>To Date:</strong></td>
                                                    <td style="border: 1px solid black;"><span>${list55.timeLineToDate}</span> </td>
                                                </tr>
                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Budget Allocated to Project:</strong></td>
                                                    <td style="border: 1px solid black;" ><span>${list55.projectBudgetAllocated}</span>

                                                </tr>

                                                <tr>
                                                    <td style="border: 1px solid black;"><strong>Others Details</td>
                                                    <td colspan="3" style="border: 1px solid black;"><p class="break-after-80">${list55.othersDetails}</p>
                                                    </td>
                                                </tr>


                                            <thead>
                                                <tr style=" background-color: skyblue;">
                                                    <th colspan="2" style="text-align: center; vertical-align: middle ; border: 1px solid black;">Document Name</th>
                                                    <th colspan="3" style="text-align: center; vertical-align: middle; border: 1px solid black;">Attachment</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <tr>

                                                        <td colspan="2" style="border: 1px solid black;">${list[1]}</td>
                                                        <td colspan="3" style="border: 1px solid black;">
                                                            <a href="oapForm.htm?act=oapDocxdownload&fileName=${list[0]}&id1=${id}" >${list[0]}</a>
                                                        </td>                                               
                                                    </tr>
                                                </c:forEach>

                                                <c:forEach var="list33" items="${list33}" varStatus="status">
                                                    <tr>


                                                        <td colspan="2" style="border: 1px solid black;">${list33[1]}</td>
                                                        <td colspan="3" style="border: 1px solid black;"><a href="oapForm.htm?act=oapDocxdownload&fileName=${list33[0]}&id1=${id}">${list33[0]}</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>





                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Approval Status</strong></td>
                                            </tr>
                                            <thead>
                                                <tr>
                                                    <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Sr.No</th>
                                                    <th style="text-align: center; vertical-align: middle ; border: 1px solid black;">User</th>
                                                    <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Comment</th>
                                                    <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Action</th>
                                                </tr>
                                            </thead>
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

                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>CRC APPROVAL Details</strong></td>
                                            </tr>
                                            <thead>
                                                <tr>
                                                    <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Sr.No</th>
                                                    <th style="text-align: center; vertical-align: middle;border: 1px solid black;">User</th>
                                                    <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Comment</th>
                                                    <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="list2" items="${list2}" varStatus="status">
                                                    <tr>
                                                        <td style="border: 1px solid black;">${status.count}</td> <!-- Serial Number -->
                                                        <td style="border: 1px solid black;">${list2.userId}</td> <!-- User ID -->
                                                        <td style="border: 1px solid black;">${list2.approvalComment}</td> <!-- Approval Comment -->
                                                        <td style="border: 1px solid black;">
                                                            <c:if test="${list2.approvalStatus == '1'}">
                                                                Approved
                                                            </c:if>           
                                                            <c:if test="${list2.approvalStatus == '2'}">
                                                                Recycle
                                                            </c:if>
                                                            <c:if test="${list2.approvalStatus == '3'}">
                                                                Rejected
                                                            </c:if>

                                                        </td> <!-- Approval Status -->
                                                    </tr>
                                                </c:forEach>
                                            </tbody>

                                        </table>     
                                        <br>
                                        <br>

                                    </form:form>

                                </div><!-- /.tab-pane -->
                            </div><!-- /.tab-content -->



                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>


            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->
        <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
        <!--datetime-->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
        <!--<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>-->

    </html>
