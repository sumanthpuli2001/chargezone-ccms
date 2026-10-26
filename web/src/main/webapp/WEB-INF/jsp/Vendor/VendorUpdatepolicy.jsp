<%-- 
    Document   : VendorUpdatepolicy
    Created on : 3 Jan, 2025, 1:59:36 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vendor Registration</title>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/country.jsp"%>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    </head>
    <body>
        <div class="content-wrapper container-fluid" style="min-height: 720px;">
            <!-- Content Header (Page header) -->

            <section class="content-header">
                <div style="display: flex; height: 25px;
                     justify-content: space-between;
                     align-items: center;">
                    <h4 style="margin-top: 1px;">Vendor Registration</h4>
                    <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
                </div>
            </section>
            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-12">

                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">

                            <div class="tab-content">


                                <c:if test="${vendorInformation.status1=='3' or vendorInformation.finacialFlag=='3' or vendorInformation.technicalFlag=='3' or vendorInformation.hrApprovalFlag=='3' or vendorInformation.auditorFlag=='3' or vendorInformation.safteyApprovalFlag=='3' or vendorInformation.status1=='9' or vendorInformation.status1=='11'}">
                                    <div style="border: 1px solid; padding: 10px; border-radius: 5px; margin: 6px;">
                                        <c:if test="${vendorInformation.status1=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Buyer Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.finacialFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Financial Approval Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.technicalFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Technical Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.hrApprovalFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By HR Approval Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Safety Approval Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.itApprovalFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By IT Approval Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.auditorFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Auditor Approval Team</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.status1=='9'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Changes For Account Details Rejected By Buyer</p>
                                        </c:if>
                                        <c:if test="${vendorInformation.status1=='11'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Changes For Account Details Accepted By Buyer</p>
                                        </c:if>
                                    </div>
                                </c:if>





                                <!--<div class="form-bottom contact-form">-->

                                <form:form action="vendorInformation.htm?act=basicUpdateVendorInformation1" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                                           class="form-horizontal" role="form">


                                    <section class="content">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <!-- Custom Tabs -->
                                                <div class="nav-tabs-custom">
                                                    <div id="exTab" class="">	
                                                        <ul class="nav nav-pills nav-tabs ">
                                                            <li class="active"><a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" <c:if test="${vendorInformation.status1=='3'} || ${vendorInformation.auditorFlag=='3'}">style=""</c:if>><i class="fa fa-circle-o"></i>1 <sup>st</sup> Level Approve</a></li>
                                                            <li><a href="vendorInformation.htm?act=policyUpdateVendorInformation" <c:if test="${vendorInformation.finacialFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Financial Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=electricTechnicalRecycle" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Technical Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=hrCriteriaRecycleView" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>HR Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=safetyCriteriaRecycleView" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Safety Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=itCriteriaRecycleView" <c:if test="${vendorInformation.itApprovalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>IT Approval</a></li>
                                                                <li ><a href="vendorInformation.htm?act=activeVenderProfileView"><i class="fa fa-circle-o"></i>Active Vendor</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>


                                                <c:if test="${(vendorInformation.status1 == '10' 
                                                              || vendorInformation.status1 == '9' 
                                                              || vendorInformation.status1 == '11' 
                                                              || vendorInformation.status1 == '8' 
                                                              || vendorInformation.status1 == '1' 
                                                              || vendorInformation.status1 == '2') 
                                                              && vendorInformation.auditorFlag != '3'}">


                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Standard Policy:</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <a target="#" href="StorageYard/Policy.pdf">policy1.pdf</a>
                                                          </div>

                                                      </div>
                                                      <div class="form-group">
                                                          <c:if test="${vendorInformation.policyAccept=='1'}">

                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Sign & Stamp in all Pages:</label>
                                                              </div>

                                                          </c:if>
                                                          <c:if test="${vendorInformation.policyAccept=='0'}">


                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Deviation Policy:</label>
                                                              </div>
                                                          </c:if>



                                                          <div class="col-sm-1">
                                                              <input type="radio" id="accept" name="e" disabled="true" onchange="toggleFileUpload(true)" value="1" <c:if test="${vendorInformation.policyAccept=='1'}">checked="true"</c:if> required="required"/> Accept
                                                              </div>
                                                              <div class="col-sm-2 ">
                                                                  <input type="radio" id="notAccept" disabled="true" name="e" onchange="toggleFileUpload(false)" value="0" <c:if test="${vendorInformation.policyAccept=='0'}">checked="true"</c:if> required="required"/> Not Accept
                                                              </div>

                                                              <div class="col-sm-2">
                                                                  <a style="margin-top: 5px;" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.policy1File}&id=${vendorInformation.id}">
                                                                  ${vendorInformation.policy1File}
                                                              </a>                                                    
                                                          </div>

                                                      </div>



                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">NDA Policy:</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <a target="#" href="StorageYard/Policy.pdf">policy1.pdf</a>
                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <c:if test="${vendorInformation.ndaPolicyAccept=='1'}">

                                                              <div class="col-sm-3">
                                                                  <label class="control-label">NDA Sign & Stamp in all Pages:</label>
                                                              </div>

                                                          </c:if>
                                                          <c:if test="${vendorInformation.ndaPolicyAccept=='0'}">

                                                              <div class="col-sm-3">
                                                                  <label class="control-label">NDA Deviation Policy:</label>
                                                              </div>

                                                          </c:if>


                                                          <div class="col-sm-1">
                                                              <input type="radio"   disabled="true" value="1" <c:if test="${vendorInformation.ndaPolicyAccept=='1'}">checked="true"</c:if> required="required"/> Accept
                                                              </div>
                                                              <div class="col-sm-2">
                                                                  <input type="radio"  disabled="true"  value="0" <c:if test="${vendorInformation.ndaPolicyAccept=='0'}">checked="true"</c:if> required="required"/> Not Accept
                                                              </div>

                                                              <div class="col-sm-2">
                                                                  <a style="margin-top: 5px;" href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.ndaPolicyFile}&id=${vendorInformation.id}">
                                                                  ${vendorInformation.ndaPolicyFile}
                                                              </a>                                                    
                                                          </div>

                                                      </div>





                                                      <!-- Collapsible Form Section -->
                                                      <div  style=" padding: 20px; border: 1px solid #ddd; border-radius: 8px; margin-bottom: 20px;">
                                                          <!-- Q1 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-4 control-label">1. Is the organization publicly listed company with shares being traded on any Stock Exchange? <span style="color:red">*</span></label>

                                                              <div class="col-sm-2">
                                                                  <label class="radio-inline">
                                                                      <input type="radio" name="desDecOneFlag" value="1" disabled
                                                                             ${declaration.desDecOneFlag == 1 ? "checked" : ""}> Yes
                                                                  </label>
                                                                  <label class="radio-inline">
                                                                      <input type="radio" name="desDecOneFlag" value="0" disabled
                                                                             ${declaration.desDecOneFlag == 0 ? "checked" : ""}> No
                                                                  </label>
                                                              </div>


                                                              <div class="col-sm-6">
                                                                  <textarea class="form-control" id="desDecOne" name="desDecOne" disabled>${declaration.desDecOne}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Q2 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-4 control-label">2. Has the Supplier ever conducted business under any alias...? <span style="color:red">*</span></label>
                                                              <div class="col-sm-2">
                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="desDecTwoFlag"
                                                                             <c:if test="${declaration.desDecTwoFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="desDecTwoFlag" 
                                                                          <c:if test="${declaration.desDecTwoFlag == 0}">checked</c:if>> No
                                                                      </label>
                                                                  </div>

                                                                  <div class="col-sm-6">
                                                                      <textarea class="form-control" id="desDecTwo" name="desDecTwo" disabled>${declaration.desDecTwo}</textarea>
                                                              </div>
                                                          </div>
                                                          <!-- 3. Alternate Business Location Fields -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-map-marker-alt"></i> <!-- map marker icon -->
                                                                      3. Alternate places of business of the third party:
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Location Address</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altLocalAddress"  disabled value="${declaration.altLocalAddress}"/></div>
                                                              <label class="col-sm-2 control-label">City</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altCity"  disabled value="${declaration.altCity}"/></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">State</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altState"  disabled value="${declaration.altState}"/></div>
                                                              <label class="col-sm-2 control-label">Country</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altCountry"  disabled value="${declaration.altCountry}"/></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Postal Code</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altPostalCode"  disabled value="${declaration.altPostalCode}"/></div>
                                                              <label class="col-sm-2 control-label">Telephone</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altTelephone"  disabled value="${declaration.altTelephone}"/></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Email</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altEmail"  disabled value="${declaration.altEmail}"/></div>
                                                              <label class="col-sm-2 control-label">Website</label>
                                                              <div class="col-sm-4"><input class="form-control" name="altWebsite"  disabled value="${declaration.altWebsite}"/></div>
                                                          </div>

                                                          <!-- 4. Information of person (authorized representative) -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-user-check"></i> 
                                                                      4. Information of person (authorized representative) attending to this form for or on behalf of third party /supplier:
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Name</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infName"  disabled value="${declaration.infName}"/></div>
                                                              <label class="col-sm-2 control-label">Designation</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infDesignatoin"  disabled value="${declaration.infDesignatoin}"/></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Contact No</label>
                                                              <div class="col-sm-4"><input type="number" class="form-control" name="infContactNo"  disabled value="${declaration.infContactNo}"/></div>
                                                              <label class="col-sm-2 control-label">Email</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infEmail"  disabled value="${declaration.infEmail}" /></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">DOB</label>
                                                              <div class="col-sm-4"><input type="date" class="form-control" name="infDob"  disabled value="${declaration.infDob}" /></div>
                                                              <label class="col-sm-2 control-label">Nationality</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infNationality"  disabled value="${declaration.infNationality}" /></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Postal Address</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infPostalAddress"  disabled value="${declaration.infPostalAddress}" /></div>
                                                              <label class="col-sm-2 control-label">City</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infCity"   disabled value="${declaration.infCity}" /></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">State</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infState"  disabled value="${declaration.infState}" /></div>
                                                              <label class="col-sm-2 control-label">Country</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infCountry"  disabled value="${declaration.infCountry}" /></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Postal Code</label>
                                                              <div class="col-sm-4"><input class="form-control" name="infPostalCode"  disabled value="${declaration.infPostalCode}" /></div>
                                                          </div>

                                                          <!-- 5. Contact information of person or people employed by the Third Party -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fa fa-user-circle" aria-hidden="true" style="margin-right: 8px;"></i>
                                                                      5. Please list the contact information of the person or people employed by the Third Party.
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Name</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdName"  disabled value="${declaration.thirdName}" /></div>
                                                              <label class="col-sm-2 control-label">Email</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdEmail"  disabled value="${declaration.thirdEmail}" /></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Contact No</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdTelephone"   disabled value="${declaration.thirdTelephone}"  /></div>
                                                              <label class="col-sm-2 control-label">Country</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdCountry"  disabled value="${declaration.thirdCountry}" /></div>
                                                          </div>

                                                          <!-- 6. Supplier that it considers as primary contacts -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-handshake" style="margin-right: 8px;"></i>
                                                                      6. Supplier that it considers as primary contacts for this business relationship with TecSo Charge Zone
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Name</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdNameTwo"  disabled value="${declaration.thirdNameTwo}" /></div>
                                                              <label class="col-sm-2 control-label">Email</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdEmailTwo"  disabled value="${declaration.thirdEmailTwo}" /></div>
                                                          </div>
                                                          <div class="form-group">
                                                              <label class="col-sm-2 control-label">Telephone</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdTelephoneTwo"  disabled value="${declaration.thirdTelephoneTwo}" /></div>
                                                              <label class="col-sm-2 control-label">Country</label>
                                                              <div class="col-sm-4"><input class="form-control" name="thirdCountryTwo" disabled value="${declaration.thirdCountryTwo}"/></div>
                                                          </div>

                                                          <!-- 7. Litigation History -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-gavel" style="margin-right: 8px;"></i>
                                                                      7. Litigation History
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether your organization is involved in any legal proceedings?<br>
                                                                  - For Proprietorship organization the Proprietor to declare if he / she is involved in any legal proceedings.<br>
                                                                  - For Partnership organization all or any Partners are involved in any legal proceedings
                                                              </label>






                                                              <div class="col-sm-2">
                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="litigationHistoryDesFlag"
                                                                             <c:if test="${declaration.litigationHistoryDesFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="litigationHistoryDesFlag" 
                                                                          <c:if test="${declaration.litigationHistoryDesFlag == 0}">checked</c:if>> No
                                                                      </label>
                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="litigationHistoryDes" name="litigationHistoryDes" disabled>${declaration.litigationHistoryDes}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Political Contributions -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-donate" style="margin-right: 8px;"></i>
                                                                      8. Political Contributions
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has made any contributions / donations (either of a charitable or political nature), in the past or at present, to a political party / organization affiliated with a political party or a political leader, on behalf of the Third Party / Supplier or in their personal capacity?
                                                              </label>
                                                              <div class="col-sm-2">
                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="politicalContributionDesFlag"
                                                                             <c:if test="${declaration.politicalContributionDesFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="politicalContributionDesFlag" 
                                                                          <c:if test="${declaration.politicalContributionDesFlag == 0}">checked</c:if>> No
                                                                      </label>

                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="politicalContributionDes" name="politicalContributionDes" disabled>${declaration.politicalContributionDes}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Conflict of Interest -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-exclamation-triangle" style="margin-right: 8px;"></i>
                                                                      9. Conflict of Interest
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) have any financial interests, personal or familial relationships, or affiliations with Tecso Charge Zone Limited or any of its Directors or employees?
                                                              </label>
                                                              <div class="col-sm-2">
                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="conflictInterestFlag"
                                                                             <c:if test="${declaration.conflictInsterestDesFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="conflictInterestFlag" 
                                                                          <c:if test="${declaration.conflictInsterestDesFlag == 0}">checked</c:if>> No
                                                                      </label>

                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="conflictInterestDes" name="conflictInterestDes" disabled>${declaration.conflictInsterestDes}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Use of Executive/Judicial (Public Official) Influence -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-gavel" style="margin-right: 8px;"></i>
                                                                      10.  Use of Executive/Judicial (Public Official) Influence
                                                                  </strong>
                                                              </label>
                                                          </div>

                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has sought or obtained the assistance of a Public Official in connection with providing goods / services to CZ?
                                                              </label>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="executiveJudicialFlag"
                                                                             <c:if test="${declaration.executiveJudicialDesFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="executiveJudicialFlag" 
                                                                          <c:if test="${declaration.executiveJudicialDesFlag == 0}">checked</c:if>> No
                                                                      </label>


                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="executiveJudicialDes" name="executiveJudicialDes" disabled>${declaration.executiveJudicialDes}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Politically Exposed Personnel -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-user-shield" style="margin-right: 8px;"></i>
                                                                      11. Politically Exposed Personnel
                                                                  </strong>
                                                              </label>
                                                          </div>


                                                          <!-- Q1 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether the Third Party or any person directly or indirectly connected to the Third Party is or has been associated with any political party/ political leader / organization affiliated with a political party or a political leader?
                                                                  <br><i>[For illustrative purposes, ‘Y’ is an employee / proprietor of the Third Party entity and ‘K’, his maternal uncle is a local MLA in Raigad. Herein, ‘Y’ shall be considered as politically exposed for the purposes of disclosure to CZ]</i>
                                                              </label>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="politicallyExposedOneFlag"
                                                                             <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="politicallyExposedOneFlag" 
                                                                          <c:if test="${declaration.politicallyExposedDesOneFlag == 0}">checked</c:if>> No
                                                                      </label>


                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="politicallyExposedDesOne" name="politicallyExposedDesOne" disabled>${declaration.politicallyExposedDesOne}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Q2 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether the Third Party or any person directly or indirectly connected to the Third Party will seek / has sought or obtained the assistance of any political party / political leader / organization affiliated with a political party or a political leader in connection with providing goods / services to CZ?
                                                              </label>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="politicallyExposedTwoFlag"
                                                                             <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="politicallyExposedTwoFlag" 
                                                                          <c:if test="${declaration.politicallyExposedDesTwoFlag == 0}">checked</c:if>> No
                                                                      </label>


                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="politicallyExposedDesTwo" name="politicallyExposedDesTwo" disabled>${declaration.politicallyExposedDesTwo}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Q3 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether any assistance has been sought from a political party / political leader / an organization affiliated with a political party, or a political leader for resolution of any issues / concerns related to the functioning / management / regulatory compliance of the Third Party?
                                                              </label>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="politicallyExposedThreeFlag"
                                                                             <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="politicallyExposedThreeFlag" 
                                                                          <c:if test="${declaration.politicallyExposedDesThreeFlag == 0}">checked</c:if>> No
                                                                      </label>


                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="politicallyExposedDesThree" name="politicallyExposedDesThree" disabled>${declaration.politicallyExposedDesThree}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Nature of Services -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-briefcase" style="margin-right: 8px;"></i>
                                                                      12. Nature of Services
                                                                  </strong>
                                                              </label>
                                                          </div>


                                                          <!-- Q1 -->
                                                          <div class="form-group">
                                                              <div class="col-sm-6 control-label">
                                                                  Whether the Scope of Work to be carried out by the Third Party will involve providing any form of liaising or facilitation services with Government Departments?
                                                              </div>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="natureServicesOneFlag"
                                                                             <c:if test="${declaration.natureServicesOneFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="natureServicesOneFlag" 
                                                                          <c:if test="${declaration.natureServicesOneFlag == 0}">checked</c:if>> No
                                                                      </label>


                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="natureServicesOneDes" name="natureServicesOneDes" disabled>${declaration.natureServicesOne}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- Q2 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Whether the Scope of Work to be carried out by the Third Party will involve interacting with Public Officials (Government officials/Judges/Public Sector Companies, etc.) on behalf of Chargezone?
                                                              </label>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="natureServicesTwoFlag"
                                                                             <c:if test="${declaration.natureServicesTwoFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="natureServicesTwoFlag" 
                                                                          <c:if test="${declaration.natureServicesTwoFlag == 0}">checked</c:if>> No
                                                                      </label>


                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <textarea class="form-control" id="natureServicesTwoDes" name="natureServicesTwoDes" disabled>${declaration.natureServicesTwo}</textarea>
                                                              </div>
                                                          </div>

                                                          <!-- NDA and Code of Conduct -->
                                                          <div class="form-group">
                                                              <label class="col-sm-12 control-label">
                                                                  <strong>
                                                                      <i class="fas fa-file-signature" style="margin-right: 8px;"></i>
                                                                      13.  Acknowledgment of understanding and NDA
                                                                  </strong>
                                                              </label>
                                                          </div>


                                                          <!-- Q1 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Has the Procurement team explained to you the Supplier Registration process especially the Code of Conduct document? Please answer in Yes or No
                                                              </label>
                                                              <div class="col-sm-2">

                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="ndaOneFlag"
                                                                             <c:if test="${declaration.ndaOneFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="ndaOneFlag" 
                                                                          <c:if test="${declaration.ndaOneFlag == 0}">checked</c:if>> No
                                                                      </label>
                                                                  </div>
                                                                  <div class="col-sm-4">
                                                                      <input class="form-control" id="ndaOneInput" name="ndaOne" value="${declaration.ndaOne}" disabled />
                                                              </div>
                                                          </div>

                                                          <!-- Q2 -->
                                                          <div class="form-group">
                                                              <label class="col-sm-6 control-label">
                                                                  Has the Procurement team explained to you about the applicability of Non-Disclosure Agreement to your case? If yes have they shared NDA with you. Please answer in Yes or No.
                                                              </label>
                                                              <div class="col-sm-2">
                                                                  <label class="radio-inline">
                                                                      <input disabled type="radio" value="1" name="ndaTwoFlag"
                                                                             <c:if test="${declaration.ndaTwoFlag == 1}">checked</c:if>> Yes
                                                                      </label>
                                                                      <label class="radio-inline">
                                                                          <input disabled type="radio" value="0" name="ndaTwoFlag" 
                                                                          <c:if test="${declaration.ndaTwoFlag == 0}">checked</c:if>> No
                                                                      </label>      </div>
                                                                  <div class="col-sm-4">
                                                                      <input class="form-control" id="ndaTwoInput" name="ndaTwo" value="${declaration.ndaTwo}" disabled />
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <!-- Toggle Script -->
                                                      <script>
                                                                  $(document).ready(function () {
                                                          $('#toggleForm').click(function () {
                                                          $('#selfDeclarationForm').slideToggle();
                                                                  $(this).toggleClass('bi-eye bi-eye-slash');
                                                          });
                                                          });</script>


                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Company Name :</label>
                                                          </div>
                                                          <div class="col-sm-3"><h5>${vendorInformation.companyName}</h5>
                                                                  <form:input readonly="true" type="hidden" path="companyName" class="form-control"   maxlength="30" required="required"/>
                                                          </div>
                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Email ID :</label>
                                                          </div>
                                                          <div class="col-sm-3"><h5>${vendorInformation.vendorEmailId}</h5>
                                                                  <form:input type="hidden" path="vendorEmailId" class="form-control"   maxlength="30" required="required"/>
                                                          </div>
                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Type of Company :<span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:select path="typeOfConcern" disabled="true"  class="form-control " required="required">
                                                                  <form:option value="Proprietary">Proprietary</form:option>
                                                                  <form:option value="Partnership">Partnership</form:option>
                                                                  <form:option value="Private Ltd">Private Ltd</form:option>
                                                                  <form:option value="Public Ltd">Public Ltd</form:option>
                                                                  <form:option value="Multinational">Multinational</form:option>
                                                                  <form:option value="Public Sector">Public Sector</form:option>
                                                              </form:select>
                                                          </div>
                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Type of Vendor :<span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                  <c:forEach var="list" items="${list}" varStatus="status">

                                                                      <tr>
                                                                      <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list[2]}<" />
                                                                      <td>${list[2]}</td>
                                                                      <td>${list[3]}</td>
                                                                      <td>${list[4]}</td>
                                                                      </tr>
                                                                  </c:forEach>

                                                              </table>
                                                          </div>


                                                      </div>





                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Country</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <input type="hidden" value="${vendorInformation.officeCountry}" name="officeCountry1" id="officeCountry1">
                                                              <form:select disabled="true" id="countryDropdown" name="country" path="officeCountry" class="form-control" required="required">
                                                                  <!-- Set India as default -->
                                                                  <!-- Other countries will be dynamically populated by JavaScript -->
                                                              </form:select>
                                                          </div>
                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">State</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <input type="hidden" value="${vendorInformation.officeState}" name="officeState1" id="officeState1">

                                                              <form:select disabled="true" id="stateDropdown" name="state" path="officeState" class="form-control" required="required">
                                                                  <!-- States of India will be populated dynamically based on the country selection -->
                                                                  <form:option value="">Select a state</form:option>
                                                              </form:select>
                                                          </div>
                                                      </div>


                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">City <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input id="cityDropdown" disabled="true" name="city" path="officeCity" class="form-control" required="required" placeholder="Enter city"/>
                                                          </div>
                                                      </div>





                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label"></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <label class="control-label">External Provider Details</label>
                                                          </div>

                                                      </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">House No : <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="officeAddressLine2" disabled="true" class="form-control"   maxlength="10" required="required"/>
                                                          </div>

                                                      </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Street: <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="officeAddressLine1" disabled="true" class="form-control"   maxlength="60" required="required"/>
                                                          </div>

                                                      </div>



                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">District<span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="officeAddressLine3" disabled="true" class="form-control"   maxlength="200" required="required"/>
                                                          </div>

                                                      </div>






                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">PIN / ZIP Code <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="officePin" disabled="true" class="form-control"   maxlength="30" required="required"/>
                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Year of Establishment of Company <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="establishment" disabled="true" class="form-control"   maxlength="30" required="required"/>

                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Company Website </label>

                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="officeWebsite" disabled="true" class="form-control"   maxlength="40"  />
                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Primary Mobile No <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="officeTelephone" disabled="true" class="form-control" pattern="[0-9]{10}$" required="required"  maxlength="30" />
                                                          </div>

                                                      </div>



                                                      <div class="form-group">
                                                          <label class="col-sm-3 control-label">Secondary Mobile No</label>
                                                          <div class="col-sm-3">
                                                              <form:input path="secoundMobile" disabled="true" pattern="[0-9]{10}$" title="Mobile number should contain exactly 10 digits" class="form-control" maxlength="10" />
                                                          </div>
                                                      </div>




                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Vendor Contact</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Name</label>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <label class="control-label">Job Title</label>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <label class="control-label">Phone No.</label>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <label class="control-label">Email</label>
                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Sales/Commercial Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>

                                                          <div class="col-sm-3">
                                                              <form:input  path="sales_name"  disabled="true" class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="sales_job" disabled="true"  class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="sales_phone" disabled="true" pattern="[0-9]{10}$" class="form-control"   maxlength="10" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="saleEmail" disabled="true"  class="form-control" type="email"   maxlength="100" required="required"/>
                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Technical Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>

                                                          <div class="col-sm-3">
                                                              <form:input  path="technical_name" disabled="true"  class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="technical_job"  disabled="true" class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="technical_phone" disabled="true" pattern="[0-9]{10}$" class="form-control"   maxlength="10" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="technicalContactEmail" disabled="true" type="email"  class="form-control"   maxlength="100" required="required"/>
                                                          </div>

                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Finance and Accounts <span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>

                                                          <div class="col-sm-3">
                                                              <form:input  path="quality_name" disabled="true"  class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="quality_job" disabled="true"  class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="quality_phone" disabled="true" pattern="[0-9]{10}$" class="form-control"   maxlength="10" required="required"/>
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="qualityEmail" disabled="true" type="email" class="form-control"   maxlength="100" required="required"/>
                                                          </div>
                                                      </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Managerial Person Details -1</label>
                                                          </div>

                                                          <div class="col-sm-3">
                                                              <form:input  path="managerialPersonDetails" readonly="true"  class="form-control"   maxlength="100" />
                                                          </div>



                                                          <div class="col-sm-2">
                                                              <form:input  path="managerialPersonJob" readonly="true"  class="form-control"   maxlength="100" />
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="managerialPersonPhone" readonly="true"  class="form-control"   maxlength="100" />
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="managerialPersonEmail" readonly="true"  class="form-control"   maxlength="100" />
                                                          </div>

                                                      </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Managerial Person Details -2</label>
                                                          </div>

                                                          <div class="col-sm-3">
                                                              <form:input  path="managerialPersonDetails2" readonly="true"  class="form-control"   maxlength="100" />
                                                          </div>



                                                          <div class="col-sm-2">
                                                              <form:input  path="managerialPersonJob2"  readonly="true" class="form-control"   maxlength="100" />
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="managerialPersonPhone2"  readonly="true" class="form-control"   maxlength="100" />
                                                          </div>
                                                          <div class="col-sm-2">
                                                              <form:input  path="managerialPersonEmail2" readonly="true"  class="form-control"   maxlength="100" />
                                                          </div>
                                                      </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Company Registration Details:</label>
                                                          </div>


                                                      </div>


                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">GST<span style="color: red;font-size: 12px;"></span></label>

                                                          </div>

                                                          <div class="col-sm-3">
                                                              <label class="control-label">GST Applicable</label>&nbsp;&nbsp;
                                                              <c:choose>
                                                                  <c:when test="${vendorInformation.gstStatus=='1'}">
                                                                      <input style="margin-top: 5px;" disabled="true" checked="true" type="radio"  id="gstApplicable" name="gstStatus" value="1" onclick="toggleGSTFields()">

                                                                  </c:when>
                                                                  <c:otherwise>
                                                                      <input style="margin-top: 5px;" disabled="true"  type="radio"  id="gstApplicable" name="gstStatus" value="1" onclick="toggleGSTFields()">

                                                                  </c:otherwise>
                                                              </c:choose>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <label class="control-label">GST Not Applicable</label>&nbsp;&nbsp;
                                                              <c:choose>
                                                                  <c:when test="${vendorInformation.gstStatus=='0'}">
                                                                      <input style="margin-top: 5px;" disabled="true" checked="true" type="radio" id="gstNotApplicable" name="gstStatus" value="0" onclick="toggleGSTFields()">

                                                                  </c:when>
                                                                  <c:otherwise>
                                                                      <input style="margin-top: 5px;" disabled="true" type="radio" id="gstNotApplicable" name="gstStatus" value="0" onclick="toggleGSTFields()">

                                                                  </c:otherwise>
                                                              </c:choose>

                                                          </div>
                                                      </div>

                                                      <div id="gstFields" style="display: none;">
                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">GST No.<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input path="gstinNo" disabled="true" class="form-control" maxlength="15" required="required"/>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <span>
                                                                      <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.gstinFile}&id=${vendorInformation.id}">${vendorInformation.gstinFile}</a>
                                                                  </span>
                                                                  <input type="hidden" class="form-control" id="gstinFile1" name="gstinFile1" value="${vendorInformation.gstinFile}">
                                                                  <input type="file" class="form-control" disabled="true" id="gstinFile" name="gstinFile" onchange="checkFileSizeg(this, 'fileErrorGstin');">
                                                                  <span id="fileErrorGstin" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <div id="commentField" style="display: none;">
                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Comment<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-6">
                                                                  <textarea id="gstComment" disabled="true" name="gstComment" class="form-control" rows="3" required>${vendorInformation.gstRemark}</textarea>
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <script>
                                                                  function toggleGSTFields() {
                                                                  var gstApplicable = document.getElementById("gstApplicable");
                                                                          var gstNotApplicable = document.getElementById("gstNotApplicable");
                                                                          var gstFields = document.getElementById("gstFields");
                                                                          var commentField = document.getElementById("commentField");
                                                                          var gstNo = document.getElementById("gstinNo");
                                                                          var gstFile = document.getElementById("gstinFile");
                                                                          var gstComment = document.getElementById("gstComment");
                                                                          if (gstApplicable.checked) {
                                                                  gstFields.style.display = "block";
                                                                          commentField.style.display = "none";
                                                                          gstNotApplicable.checked = false;
                                                                          gstComment.value = "";
                                                                          // Required for GST Applicable
                                                                          gstNo.setAttribute("required", "required");
                                                                          gstFile.setAttribute("required", "required");
                                                                          gstComment.removeAttribute("required");
                                                                  } else if (gstNotApplicable.checked) {
                                                                  gstFields.style.display = "none";
                                                                          commentField.style.display = "block";
                                                                          gstApplicable.checked = false;
                                                                          gstNo.value = "";
                                                                          gstFile.value = "";
                                                                          // Required for GST Not Applicable
                                                                          gstNo.removeAttribute("required");
                                                                          gstFile.removeAttribute("required");
                                                                          gstComment.setAttribute("required", "required");
                                                                  } else {
                                                                  gstFields.style.display = "none";
                                                                          commentField.style.display = "none";
                                                                          // Remove all required attributes when neither is selected
                                                                          gstNo.removeAttribute("required");
                                                                          gstFile.removeAttribute("required");
                                                                          gstComment.removeAttribute("required");
                                                                  }
                                                                  }
                                                      </script>

                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">PAN No.<span style="color: red;font-size: 12px;">*</span></label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="panNo" class="form-control" disabled="true" maxlength="30" required="required"/>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.panFile}&id=${vendorInformation.id}">${vendorInformation.panFile}</a>
                                                              </span>
                                                              <input type="hidden" class="form-control" id="panFile1" name="panFile1" accept="" value="${vendorInformation.panFile}">
                                                              <input type="file" class="form-control" disabled="true" id="panFile" name="panFile" accept="" onchange="checkFileSizep(this, 'fileErrorPan');">
                                                              <span id="fileErrorPan" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                          </div>
                                                      </div>


                                                      <!-- MSME Section -->
                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Do you have MSME No?</label>
                                                          </div>
                                                          <div class="col-sm-1">
                                                              <input type="radio" name="msmeOption" value="yes" disabled 
                                                                     <c:if test="${vendorInformation.msmeResponse eq 'yes'}">checked</c:if>> Yes
                                                              </div>
                                                              <div class="col-sm-1">
                                                                  <input type="radio" name="msmeOption" value="no" disabled 
                                                                  <c:if test="${vendorInformation.msmeResponse eq 'no'}">checked</c:if>> No
                                                              </div>
                                                          </div>

                                                          <div class="form-group" id="msmeSection">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">MSME No</label>
                                                              </div>

                                                              <!-- MSME Input Field -->
                                                              <div class="col-sm-3" id="msmeInputWrapper" 
                                                                   style="<c:if test='${vendorInformation.msmeResponse eq "no"}'>display: none;</c:if>">
                                                              <form:input path="service_tax" class="form-control" maxlength="30" disabled="true" />
                                                          </div>

                                                          <!-- MSME File Upload -->
                                                          <div class="col-sm-3">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.service_file}&id=${vendorInformation.id}">
                                                                      ${vendorInformation.service_file}
                                                                  </a>
                                                              </span>
                                                              <input type="hidden" class="form-control" id="serviceTaxFile1" name="serviceTaxFile1" 
                                                                     value="${vendorInformation.service_file}">
                                                              <input type="file" class="form-control" id="serviceTaxFile" name="serviceTaxFile" disabled="true"
                                                                     onchange="checkFileSizem(this, 'fileErrorServiceTax');">
                                                              <span id="fileErrorServiceTax" style="color: red; font-size: 11px; display: none;">
                                                                  * File should not exceed 5MB
                                                              </span>
                                                          </div>

                                                          <strong>
                                                              <span id="udyamText" style="font-size: 12px; 
                                                                    <c:if test='${vendorInformation.msmeResponse eq "no"}'>display: none;</c:if>">
                                                                        (Udyam certificate)
                                                                    </span>
                                                              </strong>
                                                          </div>

                                                          <!-- EPFO Section -->
                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Do you have EPFO No?</label>
                                                              </div>
                                                              <div class="col-sm-1">
                                                                  <input type="radio" name="epfoOption" value="yes" disabled 
                                                                  <c:if test="${vendorInformation.epfoResponse eq 'yes'}">checked</c:if>> Yes
                                                              </div>
                                                              <div class="col-sm-1">
                                                                  <input type="radio" name="epfoOption" value="no" disabled 
                                                                  <c:if test="${vendorInformation.epfoResponse eq 'no'}">checked</c:if>> No
                                                              </div>
                                                          </div>

                                                          <div class="form-group" id="epfoSection">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">EPFO No.</label>
                                                              </div>

                                                              <!-- EPFO Input Field -->
                                                              <div class="col-sm-3" id="epfoInputWrapper" 
                                                                   style="<c:if test='${vendorInformation.epfoResponse eq "no"}'>display: none;</c:if>">
                                                              <form:input path="pfNo" class="form-control" maxlength="30" disabled="true" />
                                                          </div>

                                                          <!-- EPFO File Upload -->
                                                          <div class="col-sm-3">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.pfAttachment}&id=${vendorInformation.id}">
                                                                      ${vendorInformation.pfAttachment}
                                                                  </a>
                                                              </span>
                                                              <input type="hidden" class="form-control" id="pfAttachment1" name="pfAttachment1" 
                                                                     value="${vendorInformation.pfAttachment}">
                                                              <input type="file" class="form-control" id="pfAttachment" name="pfAttachment" disabled="true"
                                                                     onchange="checkFileSizepf(this, 'fileErrorPfAttachment');">
                                                              <span id="fileErrorPfAttachment" style="color: red; font-size: 11px; display: none;">
                                                                  * File should not exceed 5MB
                                                              </span>
                                                          </div>
                                                      </div>





                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Import Export Code</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <c:choose>
                                                                  <c:when test="${vendorInformation.ecc_no!=''}">
                                                                      <input type="checkbox" id="toggleInput" disabled="true" checked="true" onchange="toggleInputs();">

                                                                  </c:when>
                                                                  <c:otherwise>
                                                                      <input type="checkbox" id="toggleInput" disabled="true" onchange="toggleInputs();">

                                                                  </c:otherwise>
                                                              </c:choose>
                                                              <label for="toggleInput">Show Import Export Code Input</label>
                                                          </div>
                                                      </div>

                                                      <div class="form-group" id="inputFields" style="display: none;">
                                                          <div class="col-sm-3"></div>
                                                          <div class="col-sm-3">


                                                              <input type="text" disabled="true" id="ecc_no" name="ecc_no" class="form-control" maxlength="30" 
                                                                     value="${vendorInformation.ecc_no}"  placeholder="Enter ECC No.">
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <input type="hidden" class="form-control" id="eccNoFile1" name="eccNoFile1" accept="" value="${vendorInformation.ecc_file}">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.ecc_file}&id=${vendorInformation.id}">${vendorInformation.ecc_file}</a>
                                                              </span>
                                                              <input type="file" disabled="true" class="form-control" id="eccNoFile" name="eccNoFile" 
                                                                     accept=".pdf,.jpg,.jpeg,.png" 
                                                                     onchange="checkFileSizeIc(this, 'eccNoFileError');" 
                                                                     >
                                                              <span id="eccNoFileError" style="color: red; font-size: 11px; display: none;">
                                                                  * File should not exceed 5MB
                                                              </span>
                                                          </div>
                                                      </div>
                                                      <script>
                                                                  function toggleInputs() {
                                                                  const checkbox = document.getElementById('toggleInput');
                                                                          const inputFields = document.getElementById('inputFields');
                                                                          inputFields.style.display = checkbox.checked ? 'block' : 'none';
                                                                  }

                                                      </script>
                                                      <script>
                                                          // Function to check file size
                                                          function checkFileSizeg(input, fileErrorGstin) {
                                                          const file = input.files[0]; // Get the selected file
                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                  if (file && file.size > maxSize) {
                                                          document.getElementById(fileErrorGstin).style.display = 'block'; // Show error message
                                                                  input.value = ''; // Clear the file input
                                                          } else {
                                                          document.getElementById(fileErrorGstin).style.display = 'none'; // Hide error message
                                                          }
                                                          }
                                                      </script>
                                                      <script>
                                                          // Function to check file size
                                                          function checkFileSizep(input, fileErrorPan) {
                                                          const file = input.files[0]; // Get the selected file
                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                  if (file && file.size > maxSize) {
                                                          document.getElementById(fileErrorPan).style.display = 'block'; // Show error message
                                                                  input.value = ''; // Clear the file input
                                                          } else {
                                                          document.getElementById(fileErrorPan).style.display = 'none'; // Hide error message
                                                          }
                                                          }
                                                      </script>
                                                      <script>
                                                          // Function to check file size
                                                          function checkFileSizem(input, fileErrorServiceTax) {
                                                          const file = input.files[0]; // Get the selected file
                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                  if (file && file.size > maxSize) {
                                                          document.getElementById(fileErrorServiceTax).style.display = 'block'; // Show error message
                                                                  input.value = ''; // Clear the file input
                                                          } else {
                                                          document.getElementById(fileErrorServiceTax).style.display = 'none'; // Hide error message
                                                          }
                                                          }
                                                      </script>
                                                      <script>
                                                          // Function to check file size
                                                          function checkFileSizepf(input, fileErrorPfAttachment) {
                                                          const file = input.files[0]; // Get the selected file
                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                  if (file && file.size > maxSize) {
                                                          document.getElementById(fileErrorPfAttachment).style.display = 'block'; // Show error message
                                                                  input.value = ''; // Clear the file input
                                                          } else {
                                                          document.getElementById(fileErrorPfAttachment).style.display = 'none'; // Hide error message
                                                          }
                                                          }
                                                      </script>
                                                      <script>
                                                          // Function to check file size
                                                          function checkFileSizeIc(input, eccNoFileError) {
                                                          const file = input.files[0]; // Get the selected file
                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                  if (file && file.size > maxSize) {
                                                          document.getElementById(eccNoFileError).style.display = 'block'; // Show error message
                                                                  input.value = ''; // Clear the file input
                                                          } else {
                                                          document.getElementById(eccNoFileError).style.display = 'none'; // Hide error message
                                                          }
                                                          }
                                                      </script>
                                                      <br>


                                                      <c:if test="${vendorInformation.status1=='9'|| vendorInformation.status1=='10'}">
                                                          <div class="form-group">
                                                              <div class="col-sm-12">
                                                                  <label class="control-label">Payment/Banking Information</label>
                                                              </div>
                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Account Number.<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input   path="accountNumber" disabled="true" class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>


                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Bank Name <span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="bankName" disabled="true"  class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Branch<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="branch" disabled="true"  class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">IFSC Code<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="ifscCode" disabled="true" class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Swift Code (if any)<span style="color: red;font-size: 12px;"></span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="swiftCode" disabled="true"   class="form-control"   maxlength="30" />
                                                              </div>

                                                          </div>


                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Cancel Cheque <span style="color: red; font-size: 12px;">*</span></label>
                                                              </div>

                                                              <div class="col-sm-3">
                                                                  <span>
                                                                      <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}">${vendorInformation.cancelCheck}</a>
                                                                  </span>
                                                                  <input type="hidden" name="cancelcheck1" id="cancelcheck1" value="${vendorInformation.cancelCheck}">
                                                                  <input type="file" disabled="true"  class="form-control" id="cancelcheck" name="cancelcheck"  onchange="checkFileSize1(this, 'fileErrorCancelCheck');">
                                                                  <span id="fileErrorCancelCheck" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                              </div>
                                                          </div> 
                                                      </c:if>

                                                      <c:if test="${vendorInformation.status1=='11'}">
                                                          <div class="form-group">
                                                              <div class="col-sm-12">
                                                                  <label class="control-label">Payment/Banking Information</label>
                                                              </div>
                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Account Number.<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input   path="accountNumber"  class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>


                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Bank Name <span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="bankName"   class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Branch<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="branch"   class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">IFSC Code<span style="color: red;font-size: 12px;">*</span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="ifscCode" class="form-control"   maxlength="30" required="required"/>
                                                              </div>

                                                          </div>

                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Swift Code (if any)<span style="color: red;font-size: 12px;"></span></label>
                                                              </div>
                                                              <div class="col-sm-3">
                                                                  <form:input  path="swiftCode"   class="form-control"   maxlength="30" />
                                                              </div>

                                                          </div>


                                                          <div class="form-group">
                                                              <div class="col-sm-3">
                                                                  <label class="control-label">Cancel Cheque <span style="color: red; font-size: 12px;">*</span></label>
                                                              </div>

                                                              <div class="col-sm-3">
                                                                  <span>
                                                                      <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}">${vendorInformation.cancelCheck}</a>
                                                                  </span>
                                                                  <input type="hidden" name="cancelcheck1" id="cancelcheck1" value="${vendorInformation.cancelCheck}">
                                                                  <input type="file"  class="form-control" id="cancelcheck" name="cancelcheck"  onchange="checkFileSize1(this, 'fileErrorCancelCheck');">
                                                                  <span id="fileErrorCancelCheck" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                              </div>
                                                          </div> 
                                                      </c:if> 





                                                      <script>
                                                                  // Function to check file size
                                                                          function checkFileSize1(input, cancelCheckError) {
                                                                          const file = input.files[0]; // Get the selected file
                                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                  if (file && file.size > maxSize) {
                                                                          document.getElementById(cancelCheckError).style.display = 'block'; // Show error message
                                                                                  input.value = ''; // Clear the file input
                                                                          } else {
                                                                          document.getElementById(cancelCheckError).style.display = 'none'; // Hide error message
                                                                          }
                                                                          }
                                                      </script>








                                                      <div class="form-group">
                                                          <div class="col-sm-3">
                                                              <label class="control-label">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Financial Year</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Financial Amount</label>
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <label class="control-label">Financial Attachment</label>
                                                          </div>
                                                      </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-3"></div>
                                                          <div class="col-sm-3">
                                                              <form:input path="finical1" disabled="true" id="finicalInput1" class="form-control" maxlength="30" />
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="finicalAmount1" disabled="true" oninput="formatNumber(this)" class="form-control" maxlength="30" />
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}">${vendorInformation.finicalAttachment1}</a>
                                                              </span>
                                                              <input type="hidden" class="form-control" id="finicalAttachment11" value="${vendorInformation.finicalAttachment1}" name="finicalAttachment11" accept="" />
                                                              <input type="file" disabled="true" class="form-control" onchange="checkFileSizef1(this, 'fileError1');" id="finicalAttachment1" name="finicalAttachment1" accept="" />
                                                              <span id="fileError1" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                          </div>
                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3"></div>
                                                          <div class="col-sm-3">
                                                              <form:input path="finical2" disabled="true" id="finicalInput2" class="form-control" maxlength="30" />
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="finicalAmount2" disabled="true" oninput="formatNumber(this)" class="form-control" maxlength="30" />
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}">${vendorInformation.finicalAttachment2}</a>
                                                              </span>
                                                              <input type="hidden" class="form-control" id="finicalAttachment22" value="${vendorInformation.finicalAttachment2}" name="finicalAttachment22" accept="" />
                                                              <input type="file" disabled="true" class="form-control" onchange="checkFileSizef2(this, 'fileError2');" id="finicalAttachment2" name="finicalAttachment2" />
                                                              <span id="fileError2" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                          </div>
                                                      </div>

                                                      <div class="form-group">
                                                          <div class="col-sm-3"></div>
                                                          <div class="col-sm-3">
                                                              <form:input path="finical3" id="finicalInput3" disabled="true" class="form-control" maxlength="30" />
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <form:input path="finicalAmount3" disabled="true" oninput="formatNumber(this)" class="form-control" maxlength="30" />
                                                          </div>
                                                          <div class="col-sm-3">
                                                              <span>
                                                                  <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}">${vendorInformation.finicalAttachment3}</a>
                                                              </span>
                                                              <input type="hidden" class="form-control" id="finicalAttachment33" value="${vendorInformation.finicalAttachment3}" name="finicalAttachment33" accept="" />
                                                              <span id="fileError3" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                              <input type="file" disabled="true" onchange="checkFileSizef3(this, 'fileError3');" class="form-control" id="finicalAttachment3" name="finicalAttachment3" />
                                                          </div>
                                                      </div>

                                                      <script>
                                                                          // Function to check file size
                                                                                  function checkFileSizef1(input, fileError1) {

                                                                                  const file = input.files[0]; // Get the selected file
                                                                                          const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                          if (file && file.size > maxSize) {
                                                                                  document.getElementById(fileError1).style.display = 'block'; // Show error message
                                                                                          input.value = ''; // Clear the file input
                                                                                  } else {
                                                                                  document.getElementById(fileError1).style.display = 'none'; // Hide error message
                                                                                  }
                                                                                  }
                                                      </script>
                                                      <script>
                                                                          // Function to check file size
                                                                          function checkFileSizef2(input, fileError2) {

                                                                          const file = input.files[0]; // Get the selected file
                                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                  if (file && file.size > maxSize) {
                                                                          document.getElementById(fileError2).style.display = 'block'; // Show error message
                                                                                  input.value = ''; // Clear the file input
                                                                          } else {
                                                                          document.getElementById(fileError2).style.display = 'none'; // Hide error message
                                                                          }
                                                                          }
                                                      </script>
                                                      <script>
                                                                          // Function to check file size
                                                                          function checkFileSizef3(input, fileError3) {

                                                                          const file = input.files[0]; // Get the selected file
                                                                                  const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                  if (file && file.size > maxSize) {
                                                                          document.getElementById(fileError3).style.display = 'block'; // Show error message
                                                                                  input.value = ''; // Clear the file input
                                                                          } else {
                                                                          document.getElementById(fileError3).style.display = 'none'; // Hide error message
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
                                                                          });</script>
                                                      <script>
                                                                                  function formatNumber(input) {
                                                                                  // Remove all non-digit characters except the decimal point
                                                                                  let value = input.value.replace(/,/g, '').replace(/[^\d.]/g, '');
                                                                                          // Format number with commas
                                                                                          let parts = value.split('.');
                                                                                          parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                                                                                          input.value = parts.join('.');
                                                                                  }
                                                      </script>









                                                      <h5>Add External Vendor Email</h5>
                                                      <div class="form-group">
                                                          <div class="col-md-12 col-sm-12">
                                                              <div class="table-responsive">
                                                                  <table id="policyTable5" class="table table-bordered table-striped table-hover" style="" align="center">
                                                                      <tr>
                                                                          <th>Sr. No.</th>
                                                                          <th>Vendor Email</th>

                                                                      </tr>
                                                                      <c:set var="c" value="0"/>
                                                                      <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>

                                                                      <c:if test="${vendorInformation.email1 != ''}">
                                                                          <tr>
                                                                              <td style="width: 15vh;">
                                                                                  <input style="width: 15vh;" type="text" class="form-control" name="srNo1" value="${c + 1}" readonly />
                                                                              </td>
                                                                              <td>
                                                                                  <input name="emails" disabled="true" value="${vendorInformation.email1}" class="form-control" maxlength="30" />
                                                                              </td>

                                                                          </tr>
                                                                          <c:set var="c" value="${c + 1}" />
                                                                      </c:if>

                                                                      <c:if test="${vendorInformation.email2 != ''}">
                                                                          <tr>
                                                                              <td style="width: 15vh;">
                                                                                  <input style="width: 15vh;" type="text" class="form-control" name="srNo2" value="${c + 1}" readonly />
                                                                              </td>
                                                                              <td>
                                                                                  <input name="emails" disabled="true" value="${vendorInformation.email2}" class="form-control" maxlength="30" />
                                                                              </td>

                                                                          </tr>
                                                                          <c:set var="c" value="${c + 1}" />
                                                                      </c:if>

                                                                      <c:if test="${vendorInformation.email3 != ''}">
                                                                          <tr>
                                                                              <td style="width: 15vh;">
                                                                                  <input style="width: 15vh;" type="text" class="form-control" name="srNo3" value="${c + 1}" readonly />
                                                                              </td>
                                                                              <td>
                                                                                  <input name="emails" disabled="true" value="${vendorInformation.email3}" class="form-control" maxlength="30" />
                                                                              </td>

                                                                          </tr>
                                                                          <c:set var="c" value="${c + 1}" />
                                                                      </c:if>
                                                                      <!-- Add new email row -->

                                                                  </table>
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <script>

                                                                          var tempCount5 = document.getElementById("sr").value;
                                                                                  $(function () {
                                                                                  $("#policyCloneid5").on("click", function () {
                                                                                  var currentRows = $("#policyTable5 tr").length - 1; // Subtract 1 for the header row
                                                                                          if (currentRows >= 3) {
                                                                                  alert("You can only add up to 3 emails.");
                                                                                          return;
                                                                                  }
                                                                                  tempCount5++;
                                                                                          var clone = "<tr id='addmoreFile" + tempCount5 + "' style='clear:both;'>"
                                                                                          + "<td style=\"width: 15vh;\" id=\"policyId" + tempCount5 + "\"><input style=\"width: 15vh; \" type=\"text\" class=\"form-control\" name=\"srNo" + tempCount5 + "\" value=\"" + tempCount5 + "\" readonly></td>"
                                                                                          + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Vendor Email\" name=\"email" + "\" id=\"email" + tempCount5 + "\"></td>"
                                                                                          + "<td >"
                                                                                          + "<span style='margin-top: 5px;'>"
                                                                                          + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;'   onclick=\"removePolicy('addmoreFile" + tempCount5 + "');\"/>"
                                                                                          + "</span>"
                                                                                          + "</td>" + "</tr>";
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
                                                      <c:if test="${vendorInformation.status1=='10' || vendorInformation.status1=='11'}">
                                                          <div class="form-group" style="margin-top: 10px;">
                                                              <div class="col-sm-3">
                                                                  <label>Comment</label>
                                                              </div>
                                                              <div class="col-sm-6">
                                                                  <textarea name="comments" class="form-control "></textarea>
                                                              </div>
                                                          </div>
                                                      </c:if>


                                                      <c:if test="${vendorInformation.status1=='10'}">
                                                          <div class="form-group">
                                                              <div class="col-sm-6 col-sm-offset-5">
                                                                  <input type="submit" class="btn btn1" id="submit1" formaction="vendorInformation.htm?act=sendForAccountChange&id=${vendorInformation.id}" style="width:250px;" value="Send To Buyer For Account Change">
                                                              </div>
                                                          </div>
                                                      </c:if>
                                                      <c:if test="${vendorInformation.status1=='11'}">
                                                          <div class="form-group">
                                                              <div class="col-sm-6 col-sm-offset-5">
                                                                  <input type="submit" class="btn btn1" id="submit1" formaction="vendorInformation.htm?act=changeAccountChange&id=${vendorInformation.id}" style="width:250px;" value="Submit">
                                                              </div>
                                                          </div>
                                                      </c:if>



                                                </c:if>

                                                <c:if test="${vendorInformation.status1=='3'  || vendorInformation.auditorFlag=='3'  }">


                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Standard Policy:</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <a target="#" href="StorageYard/Policy.pdf">policy1.pdf</a>
                                                        </div>


                                                    </div>
                                                    <c:if test="${vendorInformation.status1=='3'  || vendorInformation.auditorFlag==3}}">
                                                        <div class="form-group">
                                                            <div class="col-sm-3">
                                                                <label class="control-label" for="accept"> Policy Acceptance :<span style="color: red;font-size: 12px;">*</span></label>
                                                            </div>
                                                            <div class="col-sm-1">
                                                                <input type="radio" id="accept" name="e" onchange="toggleFileUpload(true)" value="1" <c:if test="${vendorInformation.policyAccept=='1'}">checked="true"</c:if> required="required"/> Accept
                                                                </div>
                                                                <div class="col-sm-2">
                                                                    <input type="radio" id="notAccept" name="e" onchange="toggleFileUpload(false)" value="0" <c:if test="${vendorInformation.policyAccept=='0'}">checked="true"</c:if> required="required"/> Not Accept
                                                                </div>
                                                            </div>

                                                            <div class="form-group" id="uploadSection" >
                                                                <div class="col-sm-3">
                                                                    <label class="control-label">Deviation Policy:<span style="color: red;font-size: 12px;">*</span></label>
                                                                </div>
                                                                <div class="col-sm-3">
                                                                    <span id="policy">
                                                                    <c:choose>
                                                                        <c:when test="${not empty vendorInformation.policy1File}" >
                                                                            <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.policy1File}&id=${vendorInformation.id}">
                                                                                ${vendorInformation.policy1File}
                                                                            </a>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <!-- No file available -->
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </span>
                                                                <span id="cancelCheckError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>

                                                                <input 
                                                                    type="file" 
                                                                    class="form-control" 
                                                                    id="policyFile1" 
                                                                    name="policyFile1" 
                                                                    accept="" 
                                                                    <c:if test="${empty vendorInformation.policy1File}">required="required"</c:if>
                                                                        onchange="checkFileSize1(this);">
                                                                    <span>
                                                                        <input type="hidden" name="policyFiles" value="${vendorInformation.policy1File}">
                                                                </span>
                                                            </div>
                                                        </div>


                                                        <!--NDA Policy Started--> 
                                                        <div class="form-group">
                                                            <div class="col-sm-3">
                                                                <label class="control-label">NDA Policy :</label>
                                                            </div>
                                                            <div class="col-sm-3">
                                                                <a target="#" href="StorageYard/TCZL-SCM-002_Supplier Code of Conduct.pdf">TCZL-SCM-002_Supplier Code of Conduct.pdf</a>
                                                            </div>


                                                        </div>

                                                        <div class="form-group">
                                                            <div class="col-sm-3">
                                                                <label class="control-label" for="accept"> NDA Policy Acceptance :
                                                                    <span style="color: red;font-size: 12px;">*</span>
                                                                </label>
                                                            </div>
                                                            <div class="col-sm-1">
                                                                <input type="radio"  name="ndaPolicyAccept"  value="1"
                                                                       <c:if test="${vendorInformation3.ndaPolicyAccept=='1'}">checked="true"</c:if> required /> Accept
                                                                </div>
                                                                <div class="col-sm-1">
                                                                    <input type="radio" name="ndaPolicyAccept"  value="0"
                                                                    <c:if test="${vendorInformation3.ndaPolicyAccept=='0'}">checked="true"</c:if> required /> Not Accept
                                                                </div>
                                                            </div>

                                                            <div class="form-group" id="uploadSection">
                                                                <div class="col-sm-3">
                                                                    <label class="control-label" id="policyLabel">
                                                                        Sign & Stamp on all Pages: *<span style="color: red;font-size: 12px;">*</span>
                                                                    </label>
                                                                </div>



                                                                <div class="col-sm-3">
                                                                    <span id="policy">
                                                                    <c:choose>
                                                                        <c:when test="${not empty vendorInformation3.ndaPolicyFile}">
                                                                            <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation3.ndaPolicyFile}&id=${vendorInformation3.id}">
                                                                                ${vendorInformation3.ndaPolicyFile}
                                                                            </a>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <!-- No file available -->
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </span>
                                                                <span id="cancelCheckError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>


                                                                <c:choose>
                                                                    <c:when test="${empty vendorInformation3.ndaPolicyFile || vendorInformation3.ndaPolicyFile==''}">
                                                                        <input type="file" class="form-control" id="ndaPolicyFile" name="ndaPolicyFile" required="true" onchange="checkFileSize1(this);" />


                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <input type="file" class="form-control" id="ndaPolicyFile" name="ndaPolicyFile"

                                                                               onchange="checkFileSize1(this);" />
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <input type="hidden" id="policyFiles" name="ndaPolicyFile" value="${vendorInformation3.ndaPolicyFile}">
                                                            </div>
                                                        </div>


                                                    </c:if>





                                                    <div  style="padding: 20px; border: 1px solid #ddd; border-radius: 8px; margin-bottom: 20px;">

                                                        <div class="form-horizontal">
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong><i class="fa fa-file-signature" aria-hidden="true"></i> Self Declaration Form</strong>
                                                                </label>
                                                            </div>

                                                            <!-- Q1 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-4 control-label">1. Is the organization publicly listed company with shares being traded on any Stock Exchange? <span style="color:red">*</span></label>
                                                                <div class="col-sm-2">




                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="desDecOneFlag" onclick="toggleTextarea('q1-details', true)"
                                                                               <c:if test="${declaration.desDecOneFlag == 1}">checked</c:if>
                                                                                   > Yes
                                                                        </label>
                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="desDecOneFlag" onclick="toggleTextarea('q1-details', false)"
                                                                            <c:if test="${declaration.desDecOneFlag == 0}">checked</c:if>
                                                                                > No
                                                                        </label>     </div>
                                                                    <div class="col-sm-6">
                                                                        <textarea class="form-control" id="q1-details" value="" name="desDecOne" disabled>${declaration.desDecOne}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Q2 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-4 control-label">2. Has the Supplier ever conducted business under any alias...? <span style="color:red">*</span></label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input value="1" type="radio" name="desDecTwoFlag" onclick="toggleTextarea('q2-details', true)"
                                                                               <c:if test="${declaration.desDecTwoFlag == 1}">checked</c:if>
                                                                                   > Yes
                                                                        </label>
                                                                        <label class="radio-inline">
                                                                            <input value="0" type="radio" name="desDecTwoFlag" onclick="toggleTextarea('q2-details', false)"
                                                                            <c:if test="${declaration.desDecTwoFlag == 0}">checked</c:if>
                                                                                > No
                                                                        </label>  </div>
                                                                    <div class="col-sm-6">
                                                                        <textarea class="form-control" id="q2-details" name="desDecTwo" disabled>${declaration.desDecTwo}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- 3. Alternate Business Location Fields -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-map-marker-alt"></i> <!-- map marker icon -->
                                                                        3. Alternate places of business of the third party:
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Location Address</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altLocalAddress" value="${declaration.altLocalAddress}" /></div>
                                                                <label class="col-sm-2 control-label">City</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altCity" value="${declaration.altCity}" /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">State</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altState" value="${declaration.altState}"  /></div>
                                                                <label class="col-sm-2 control-label">Country</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altCountry" value="${declaration.altCountry}"  /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Postal Code</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altPostalCode" value="${declaration.altPostalCode}"  /></div>
                                                                <label class="col-sm-2 control-label">Telephone</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altTelephone" value="${declaration.altTelephone}"  /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Email</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altEmail"  value="${declaration.altEmail}" /></div>
                                                                <label class="col-sm-2 control-label">Website</label>
                                                                <div class="col-sm-4"><input class="form-control" name="altWebsite"  value="${declaration.altWebsite}" /></div>
                                                            </div>

                                                            <!-- 4. Information of person (authorized representative) -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-user-check"></i> 
                                                                        4. Information of person (authorized representative) attending to this form for or on behalf of third party /supplier:
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Name</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infName"  value="${declaration.infName}"/></div>
                                                                <label class="col-sm-2 control-label">Designation</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infDesignatoin" value="${declaration.infDesignatoin}" /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Contact No</label>
                                                                <div class="col-sm-4"><input type="number" class="form-control" name="infContactNo"  value="${declaration.infContactNo}" /></div>
                                                                <label class="col-sm-2 control-label">Email</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infEmail" value="${declaration.infEmail}"  /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">DOB</label>
                                                                <div class="col-sm-4"><input type="date" class="form-control" name="infDob" value="${declaration.infDob}"  /></div>
                                                                <label class="col-sm-2 control-label">Nationality</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infNationality" value="${declaration.infNationality}"  /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Postal Address</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infPostalAddress" value="${declaration.infPostalAddress}" /></div>
                                                                <label class="col-sm-2 control-label">City</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infCity" value="${declaration.infCity}"  /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">State</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infState" value="${declaration.infState}"  /></div>
                                                                <label class="col-sm-2 control-label">Country</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infCountry" value="${declaration.infCountry}"  /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Postal Code</label>
                                                                <div class="col-sm-4"><input class="form-control" name="infPostalCode" value="${declaration.infPostalCode}"  /></div>
                                                            </div>

                                                            <!-- 5. Contact information of person or people employed by the Third Party -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fa fa-user-circle" aria-hidden="true" style="margin-right: 8px;"></i>
                                                                        5. Please list the contact information of the person or people employed by the Third Party.
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Name</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdName"  value="${declaration.thirdName}" /></div>
                                                                <label class="col-sm-2 control-label">Email</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdEmail"  value="${declaration.thirdEmail}" /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Contact No</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdTelephone"  value="${declaration.thirdTelephone}" /></div>
                                                                <label class="col-sm-2 control-label">Country</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdCountry" value="${declaration.thirdCountry}"  /></div>
                                                            </div>

                                                            <!-- 6. Supplier that it considers as primary contacts -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-handshake" style="margin-right: 8px;"></i>
                                                                        6. Supplier that it considers as primary contacts for this business relationship with TecSo Charge Zone
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Name</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdNameTwo"  value="${declaration.thirdNameTwo}" /></div>
                                                                <label class="col-sm-2 control-label">Email</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdEmailTwo"  value="${declaration.thirdEmailTwo}" /></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">Telephone</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdTelephoneTwo" value="${declaration.thirdTelephoneTwo}"  /></div>
                                                                <label class="col-sm-2 control-label">Country</label>
                                                                <div class="col-sm-4"><input class="form-control" name="thirdCountryTwo" value="${declaration.thirdCountryTwo}"  /></div>
                                                            </div>

                                                            <!-- 7. Litigation History -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-gavel" style="margin-right: 8px;"></i>
                                                                        7. Litigation History
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether your organization is involved in any legal proceedings?<br>
                                                                    - For Proprietorship organization the Proprietor to declare if he / she is involved in any legal proceedings.<br>
                                                                    - For Partnership organization all or any Partners are involved in any legal proceedings
                                                                </label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="litigationHistoryFlag"
                                                                               onclick="toggleTextarea('litigationHistoryDes', true)"
                                                                               <c:if test="${declaration.litigationHistoryDesFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="litigationHistoryFlag"
                                                                                   onclick="toggleTextarea('litigationHistoryDes', false)"
                                                                            <c:if test="${declaration.litigationHistoryDesFlag == 0}">checked</c:if>> No
                                                                        </label>  </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="litigationHistoryDes" name="litigationHistoryDes" disabled>${declaration.litigationHistoryDes}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Political Contributions -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-donate" style="margin-right: 8px;"></i>
                                                                        8. Political Contributions
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has made any contributions / donations (either of a charitable or political nature), in the past or at present, to a political party / organization affiliated with a political party or a political leader, on behalf of the Third Party / Supplier or in their personal capacity?
                                                                </label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="politicalContributionFlag"
                                                                               onclick="toggleTextarea('politicalContributionDes', true)"
                                                                               <c:if test="${declaration.politicalContributionDesFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="politicalContributionFlag"
                                                                                   onclick="toggleTextarea('politicalContributionDes', false)"
                                                                            <c:if test="${declaration.politicalContributionDesFlag == 0}">checked</c:if>> No
                                                                        </label>  </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="politicalContributionDes" name="politicalContributionDes" disabled>${declaration.politicalContributionDes}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Conflict of Interest -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-exclamation-triangle" style="margin-right: 8px;"></i>
                                                                        9. Conflict of Interest
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) have any financial interests, personal or familial relationships, or affiliations with Tecso Charge Zone Limited or any of its Directors or employees?
                                                                </label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="conflictInterestFlag"
                                                                               onclick="toggleTextarea('conflictInterestDes', true)"
                                                                               <c:if test="${declaration.conflictInsterestDesFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="conflictInterestFlag"
                                                                                   onclick="toggleTextarea('conflictInterestDes', false)"
                                                                            <c:if test="${declaration.conflictInsterestDesFlag == 0}">checked</c:if>> No
                                                                        </label>    </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="conflictInterestDes" name="conflictInterestDes" disabled>${declaration.conflictInsterestDes}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Use of Executive/Judicial (Public Official) Influence -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-gavel" style="margin-right: 8px;"></i>
                                                                        10.  Use of Executive/Judicial (Public Official) Influence
                                                                    </strong>
                                                                </label>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party (Employees, Directors, and their personal relations) has sought or obtained the assistance of a Public Official in connection with providing goods / services to CZ?
                                                                </label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="executiveJudicialFlag"
                                                                               onclick="toggleTextarea('executiveJudicialDes', true)"
                                                                               <c:if test="${declaration.executiveJudicialDesFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="executiveJudicialFlag"
                                                                                   onclick="toggleTextarea('executiveJudicialDes', false)"
                                                                            <c:if test="${declaration.executiveJudicialDesFlag == 0}">checked</c:if>> No
                                                                        </label>  </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="executiveJudicialDes" name="executiveJudicialDes" disabled>${declaration.executiveJudicialDes}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Politically Exposed Personnel -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-user-shield" style="margin-right: 8px;"></i>
                                                                        11. Politically Exposed Personnel
                                                                    </strong>
                                                                </label>
                                                            </div>


                                                            <!-- Q1 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party is or has been associated with any political party/ political leader / organization affiliated with a political party or a political leader?
                                                                    <br><i>[For illustrative purposes, ‘Y’ is an employee / proprietor of the Third Party entity and ‘K’, his maternal uncle is a local MLA in Raigad. Herein, ‘Y’ shall be considered as politically exposed for the purposes of disclosure to CZ]</i>
                                                                </label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="politicallyExposedOneFlag"
                                                                               onclick="toggleTextarea('politicallyExposedDesOne', true)"
                                                                               <c:if test="${declaration.politicallyExposedDesOneFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="politicallyExposedOneFlag"
                                                                                   onclick="toggleTextarea('politicallyExposedDesOne', false)"
                                                                            <c:if test="${declaration.politicallyExposedDesOneFlag == 0}">checked</c:if>> No
                                                                        </label>    </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="politicallyExposedDesOne" name="politicallyExposedDesOne" disabled>${declaration.politicallyExposedDesOne}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Q2 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether the Third Party or any person directly or indirectly connected to the Third Party will seek / has sought or obtained the assistance of any political party / political leader / organization affiliated with a political party or a political leader in connection with providing goods / services to CZ?
                                                                </label>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="politicallyExposedTwoFlag"
                                                                               onclick="toggleTextarea('politicallyExposedDesTwo', true)"
                                                                               <c:if test="${declaration.politicallyExposedDesTwoFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="politicallyExposedTwoFlag"
                                                                                   onclick="toggleTextarea('politicallyExposedDesTwo', false)"
                                                                            <c:if test="${declaration.politicallyExposedDesTwoFlag == 0}">checked</c:if>> No
                                                                        </label> </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="politicallyExposedDesTwo" name="politicallyExposedDesTwo" disabled>${declaration.politicallyExposedDesTwo}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Q3 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether any assistance has been sought from a political party / political leader / an organization affiliated with a political party, or a political leader for resolution of any issues / concerns related to the functioning / management / regulatory compliance of the Third Party?
                                                                </label>
                                                                <div class="col-sm-2">

                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="politicallyExposedThreeFlag"
                                                                               onclick="toggleTextarea('politicallyExposedDesThree', true)"
                                                                               <c:if test="${declaration.politicallyExposedDesThreeFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="politicallyExposedThreeFlag"
                                                                                   onclick="toggleTextarea('politicallyExposedDesThree', false)"
                                                                            <c:if test="${declaration.politicallyExposedDesThreeFlag == 0}">checked</c:if>> No
                                                                        </label> </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="politicallyExposedDesThree" name="politicallyExposedDesThree" disabled>${declaration.politicallyExposedDesThree}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Nature of Services -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-briefcase" style="margin-right: 8px;"></i>
                                                                        12. Nature of Services
                                                                    </strong>
                                                                </label>
                                                            </div>


                                                            <!-- Q1 -->
                                                            <div class="form-group">
                                                                <div class="col-sm-6 control-label">
                                                                    Whether the Scope of Work to be carried out by the Third Party will involve providing any form of liaising or facilitation services with Government Departments?
                                                                </div>
                                                                <div class="col-sm-2">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="natureServicesOneFlag"
                                                                               onclick="toggleTextarea('natureServicesOneDes', true)"
                                                                               <c:if test="${declaration.natureServicesOneFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="natureServicesOneFlag"
                                                                                   onclick="toggleTextarea('natureServicesOneDes', false)"
                                                                            <c:if test="${declaration.natureServicesOneFlag == 0}">checked</c:if>> No
                                                                        </label> </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="natureServicesOneDes" name="natureServicesOneDes" disabled>${declaration.natureServicesOne}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- Q2 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Whether the Scope of Work to be carried out by the Third Party will involve interacting with Public Officials (Government officials/Judges/Public Sector Companies, etc.) on behalf of Chargezone?
                                                                </label>
                                                                <div class="col-sm-2">

                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="natureServicesTwoFlag"
                                                                               onclick="toggleTextarea('natureServicesTwoDes', true)"
                                                                               <c:if test="${declaration.natureServicesTwoFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="natureServicesTwoFlag"
                                                                                   onclick="toggleTextarea('natureServicesTwoDes', false)"
                                                                            <c:if test="${declaration.natureServicesTwoFlag == 0}">checked</c:if>> No
                                                                        </label>
                                                                    </div>
                                                                    <div class="col-sm-4">
                                                                        <textarea class="form-control" id="natureServicesTwoDes" name="natureServicesTwoDes" disabled>${declaration.natureServicesTwo}</textarea>
                                                                </div>
                                                            </div>

                                                            <!-- NDA and Code of Conduct -->
                                                            <div class="form-group">
                                                                <label class="col-sm-12 control-label">
                                                                    <strong>
                                                                        <i class="fas fa-file-signature" style="margin-right: 8px;"></i>
                                                                        13.  Acknowledgment of understanding and NDA
                                                                    </strong>
                                                                </label>
                                                            </div>


                                                            <!-- Q1 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Has the Procurement team explained to you the Supplier Registration process especially the Code of Conduct document? Please answer in Yes or No
                                                                </label>
                                                                <div class="col-sm-2">

                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="ndaOneFlag"
                                                                               onclick="toggleTextarea('ndaOneInput', true)"
                                                                               <c:if test="${declaration.ndaOneFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="ndaOneFlag"
                                                                                   onclick="toggleTextarea('ndaOneInput', false)"
                                                                            <c:if test="${declaration.ndaOneFlag == 0}">checked</c:if>> No
                                                                        </label>  </div>
                                                                    <div class="col-sm-4">
                                                                        <input class="form-control" id="ndaOneInput" value="${declaration.ndaOne}" name="ndaOne" disabled />
                                                                </div>
                                                            </div>

                                                            <!-- Q2 -->
                                                            <div class="form-group">
                                                                <label class="col-sm-6 control-label">
                                                                    Has the Procurement team explained to you about the applicability of Non-Disclosure Agreement to your case? If yes have they shared NDA with you. Please answer in Yes or No.
                                                                </label>
                                                                <div class="col-sm-2">



                                                                    <label class="radio-inline">
                                                                        <input type="radio" value="1" name="ndaTwoFlag" 
                                                                               onclick="toggleTextarea('ndaTwoInput', true)"
                                                                               <c:if test="${declaration.ndaTwoFlag == 1}">checked</c:if>> Yes
                                                                        </label>

                                                                        <label class="radio-inline">
                                                                            <input type="radio" value="0" name="ndaTwoFlag" 
                                                                                   onclick="toggleTextarea('ndaTwoInput', false)"
                                                                            <c:if test="${declaration.ndaTwoFlag == 0}">checked</c:if>> No
                                                                        </label>
                                                                    </div>
                                                                    <div class="col-sm-4">
                                                                        <input class="form-control" id="ndaTwoInput" value="${declaration.ndaTwo}" name="ndaTwo" disabled />
                                                                </div>
                                                            </div>


                                                        </div>

                                                        <script>
                                                                                    function toggleTextarea(id, enable) {
                                                                                    var el = document.getElementById(id);
                                                                                            el.disabled = !enable;
                                                                                            if (!enable) el.value = '';
                                                                                    }
                                                        </script>

                                                    </div>




                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Company Name :</label>
                                                        </div>
                                                        <div class="col-sm-3"><h5>${vendorInformation.companyName}</h5>
                                                                <form:input type="hidden" path="companyName" class="form-control"   maxlength="30" required="required"/>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Email ID :</label>
                                                        </div>
                                                        <div class="col-sm-3"><h5>${vendorInformation.vendorEmailId}</h5>
                                                                <form:input type="hidden" path="vendorEmailId" class="form-control"   maxlength="30" required="required"/>
                                                        </div>
                                                    </div>



                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Type of Company :<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:select path="typeOfConcern"  class="form-control " required="required">
                                                                <form:option value="Proprietary">Proprietary</form:option>
                                                                <form:option value="Partnership">Partnership</form:option>
                                                                <form:option value="Private Ltd">Private Ltd</form:option>
                                                                <form:option value="Public Ltd">Public Ltd</form:option>
                                                                <form:option value="Multinational">Multinational</form:option>
                                                                <form:option value="Public Sector">Public Sector</form:option>
                                                            </form:select>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Type of Vendor :<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                <c:forEach var="list" items="${list}" varStatus="status">

                                                                    <tr>
                                                                    <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list[2]}<" />
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <td>${list[4]}</td>
                                                                    </tr>
                                                                </c:forEach>

                                                            </table>
                                                        </div>


                                                    </div>





                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Country</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="hidden" value="${vendorInformation.officeCountry}" name="officeCountry1" id="officeCountry1">

                                                            <form:select id="countryDropdown" name="country" path="officeCountry" class="form-control" required="required">
                                                                <!-- Set India as default -->
                                                            </form:select>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">State</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="hidden" value="${vendorInformation.officeState}" name="officeState1" id="officeState1">

                                                            <form:select id="stateDropdown" name="state" path="officeState" class="form-control" required="required">
                                                                <!-- States of India will be populated dynamically based on the country selection -->
                                                                <form:option value="">Select a state</form:option>
                                                            </form:select>
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">City <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input id="cityDropdown" name="city" path="officeCity" class="form-control" required="required" placeholder="Enter city"/>
                                                        </div>
                                                    </div>





                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label"></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label class="control-label">External Provider Details</label>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">House No : <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="officeAddressLine2" class="form-control"   maxlength="10" required="required"/>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Street: <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="officeAddressLine1" class="form-control"   maxlength="60" required="required"/>
                                                        </div>

                                                    </div>



                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">District<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="officeAddressLine3" class="form-control"   maxlength="200" required="required"/>
                                                        </div>

                                                    </div>






                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">PIN / ZIP Code <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="officePin" class="form-control"   maxlength="30" required="required"/>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Year of Establishment of Company <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="establishment" class="form-control"   maxlength="30" required="required"/>

                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Company Website </label>

                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="officeWebsite" class="form-control"   maxlength="40"  />
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Primary Mobile No <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="officeTelephone" class="form-control" pattern="[0-9]{10}$" title="Telephone (With STD Code eg. 91-79-98989890)"  maxlength="30" />
                                                        </div>

                                                    </div>



                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Secondary Mobile No</label>
                                                        <div class="col-sm-3">
                                                            <form:input path="secoundMobile" pattern="[0-9]{10}$" title="Mobile number should contain exactly 10 digits" class="form-control" maxlength="10" />
                                                        </div>
                                                    </div>




                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Vendor Contact</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Name</label>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label class="control-label">Job Title</label>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label class="control-label">Phone No.</label>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label class="control-label">Email</label>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Sales/Commercial Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="sales_name"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="sales_job"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="sales_phone" pattern="[0-9]{10}$" class="form-control"   maxlength="10" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="saleEmail"  class="form-control" type="email"   maxlength="100" required="required"/>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Technical Contact(s) <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="technical_name"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="technical_job"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="technical_phone" pattern="[0-9]{10}$" class="form-control"   maxlength="10" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="technicalContactEmail" type="email"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Finance and Accounts<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="quality_name"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="quality_job"  class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="quality_phone" pattern="[0-9]{10}$" class="form-control"   maxlength="10" required="required"/>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="qualityEmail" type="email" class="form-control"   maxlength="100" required="required"/>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Managerial Person Details -1</label>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="managerialPersonDetails"  class="form-control"   maxlength="100" />
                                                        </div>



                                                        <div class="col-sm-2">
                                                            <form:input  path="managerialPersonJob"  class="form-control"   maxlength="100" />
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="managerialPersonPhone"  class="form-control"   maxlength="100" />
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="managerialPersonEmail"  class="form-control"   maxlength="100" />
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Managerial Person Details -2</label>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="managerialPersonDetails2"  class="form-control"   maxlength="100" />
                                                        </div>



                                                        <div class="col-sm-2">
                                                            <form:input  path="managerialPersonJob2"  class="form-control"   maxlength="100" />
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="managerialPersonPhone2"  class="form-control"   maxlength="100" />
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <form:input  path="managerialPersonEmail2"  class="form-control"   maxlength="100" />
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Company registration details:</label>
                                                        </div>


                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">GST<span style="color: red;font-size: 12px;"></span></label>

                                                        </div>

                                                        <div class="col-sm-3">
                                                            <label class="control-label">GST Applicable</label>&nbsp;&nbsp;
                                                            <c:choose>
                                                                <c:when test="${vendorInformation.gstStatus=='1'}">
                                                                    <input style="margin-top: 5px;" checked="true" type="radio"  id="gstApplicable" name="gstStatus" value="1" onclick="toggleGSTFields()">

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input style="margin-top: 5px;"  type="radio"  id="gstApplicable" name="gstStatus" value="1" onclick="toggleGSTFields()">

                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label class="control-label">GST Not Applicable</label>&nbsp;&nbsp;
                                                            <c:choose>
                                                                <c:when test="${vendorInformation.gstStatus=='0'}">
                                                                    <input style="margin-top: 5px;" checked="true" type="radio" id="gstNotApplicable" name="gstStatus" value="0" onclick="toggleGSTFields()">

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input style="margin-top: 5px;" type="radio" id="gstNotApplicable" name="gstStatus" value="0" onclick="toggleGSTFields()">

                                                                </c:otherwise>
                                                            </c:choose>

                                                        </div>
                                                    </div>

                                                    <div id="gstFields" style="display: none;">
                                                        <div class="form-group">
                                                            <div class="col-sm-3">
                                                                <label class="control-label">GST No.<span style="color: red;font-size: 12px;">*</span></label>
                                                            </div>
                                                            <div class="col-sm-3">
                                                                <form:input path="gstinNo" class="form-control" maxlength="15" />
                                                            </div>
                                                            <div class="col-sm-3">
                                                                <span>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.gstinFile}&id=${vendorInformation.id}">${vendorInformation.gstinFile}</a>
                                                                </span>
                                                                <input type="hidden" class="form-control" id="gstinFile1" name="gstinFile1" value="${vendorInformation.gstinFile}">
                                                                <input type="file" class="form-control" id="gstinFile" name="gstinFile" <c:if test="${vendorInformation.gstinFile==''}">requited="true"</c:if> onchange="checkFileSizeg(this, 'fileErrorGstin');">
                                                                    <span id="fileErrorGstin" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div id="commentField" style="display: none;">
                                                            <div class="form-group">
                                                                <div class="col-sm-3">
                                                                    <label class="control-label">Comment<span style="color: red;font-size: 12px;">*</span></label>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <textarea id="gstComment" name="gstComment" class="form-control" rows="3" <c:if test="${vendorInformation.gstRemark==''}">requited="true"</c:if> >${vendorInformation.gstRemark}</textarea>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <script>
                                                                                    function toggleGSTFields() {
                                                                                    var gstApplicable = document.getElementById("gstApplicable");
                                                                                            var gstNotApplicable = document.getElementById("gstNotApplicable");
                                                                                            var gstFields = document.getElementById("gstFields");
                                                                                            var commentField = document.getElementById("commentField");
                                                                                            var gstNo = document.getElementById("gstinNo");
                                                                                            var gstFile = document.getElementById("gstinFile");
                                                                                            var gstComment = document.getElementById("gstComment");
                                                                                            if (gstApplicable.checked) {
                                                                                    gstFields.style.display = "block";
                                                                                            commentField.style.display = "none";
                                                                                            gstNotApplicable.checked = false;
                                                                                            // Required for GST Applicable
                                                                                            //                                                                                        gstNo.setAttribute("required", "required");
                                                                                            //                                                                                        gstFile.setAttribute("required", "required");
                                                                                            //                                                                                        gstComment.removeAttribute("required");
                                                                                    } else if (gstNotApplicable.checked) {
                                                                                    gstFields.style.display = "none";
                                                                                            commentField.style.display = "block";
                                                                                            gstApplicable.checked = false;
                                                                                            // Required for GST Not Applicable
                                                                                            //                                                                                        gstNo.removeAttribute("required");
                                                                                            //                                                                                        gstFile.removeAttribute("required");
                                                                                            //                                                                                        gstComment.setAttribute("required", "required");
                                                                                    } else {
                                                                                    gstFields.style.display = "none";
                                                                                            commentField.style.display = "none";
                                                                                            // Remove all required attributes when neither is selected
                                                                                            //                                                                                        gstNo.removeAttribute("required");
                                                                                            //                                                                                        gstFile.removeAttribute("required");
                                                                                            //                                                                                        gstComment.removeAttribute("required");
                                                                                    }
                                                                                    }

                                                        </script>


                                                        <div class="form-group">
                                                            <div class="col-sm-3">
                                                                <label class="control-label">PAN No.<span style="color: red;font-size: 12px;">*</span></label>
                                                            </div>
                                                            <div class="col-sm-3">
                                                            <form:input path="panNo" class="form-control"   maxlength="30" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.panFile}&id=${vendorInformation.id}">${vendorInformation.panFile}</a>

                                                            </span>
                                                            <input type="hidden" class="form-control" id="panFile1" name="panFile1" accept="" value="${vendorInformation.panFile}" onchange="checkFileSize();">

                                                            <input type="file" class="form-control" id="panFile" name="panFile" accept="" onchange="checkFileSize();">
                                                        </div>
                                                    </div>
                                                    <!-- MSME Section -->
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Do you have MSME No?</label>
                                                        </div>
                                                        <div class="col-sm-1">
                                                            <input type="radio" name="msmeOption" value="yes"
                                                                   onchange="toggleMSME(true)"
                                                                   <c:if test="${vendorInformation.msmeResponse eq 'yes'}">checked</c:if>> Yes
                                                            </div>
                                                            <div class="col-sm-1">
                                                                <input type="radio" name="msmeOption" value="no"
                                                                       onchange="toggleMSME(false)"
                                                                <c:if test="${vendorInformation.msmeResponse eq 'no'}">checked</c:if>> No
                                                            </div>
                                                        </div>

                                                        <div class="form-group" id="msmeSection">
                                                            <div class="col-sm-3">
                                                                <label class="control-label">MSME No</label>
                                                            </div>

                                                            <!-- MSME Input Field -->
                                                            <div class="col-sm-3" id="msmeInputWrapper">
                                                            <form:input path="service_tax" class="form-control" maxlength="30" />
                                                        </div>

                                                        <!-- MSME File Upload -->
                                                        <div class="col-sm-3">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.service_file}&id=${vendorInformation.id}">
                                                                    ${vendorInformation.service_file}
                                                                </a>
                                                            </span>
                                                            <input type="hidden" class="form-control" id="serviceTaxFile1" name="serviceTaxFile1"
                                                                   value="${vendorInformation.service_file}">
                                                            <input type="file" class="form-control" id="serviceTaxFile" name="serviceTaxFile"
                                                                   onchange="checkFileSizem(this, 'fileErrorServiceTax');">
                                                            <span id="fileErrorServiceTax" style="color: red; font-size: 11px; display: none;">
                                                                * File should not exceed 5MB
                                                            </span>
                                                        </div>

                                                        <strong>
                                                            <span id="udyamText" style="font-size: 12px;">(Udyam certificate)</span>
                                                        </strong>
                                                    </div>

                                                    <!-- EPFO Section -->
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Do you have EPFO No?</label>
                                                        </div>
                                                        <div class="col-sm-1">
                                                            <input type="radio" name="epfoOption" value="yes"
                                                                   onchange="toggleEPFO(true)"
                                                                   <c:if test="${vendorInformation.epfoResponse eq 'yes'}">checked</c:if>> Yes
                                                            </div>
                                                            <div class="col-sm-1">
                                                                <input type="radio" name="epfoOption" value="no"
                                                                       onchange="toggleEPFO(false)"
                                                                <c:if test="${vendorInformation.epfoResponse eq 'no'}">checked</c:if>> No
                                                            </div>
                                                        </div>

                                                        <div class="form-group" id="epfoSection">
                                                            <div class="col-sm-3">
                                                                <label class="control-label">EPFO No.</label>
                                                            </div>

                                                            <!-- EPFO Input Field -->
                                                            <div class="col-sm-3" id="epfoInputWrapper">
                                                            <form:input path="pfNo" class="form-control" maxlength="30" />
                                                        </div>

                                                        <!-- EPFO File Upload -->
                                                        <div class="col-sm-3">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.pfAttachment}&id=${vendorInformation.id}">
                                                                    ${vendorInformation.pfAttachment}
                                                                </a>
                                                            </span>
                                                            <input type="hidden" class="form-control" id="pfAttachment1" name="pfAttachment1"
                                                                   value="${vendorInformation.pfAttachment}">
                                                            <input type="file" class="form-control" id="pfAttachment" name="pfAttachment"
                                                                   onchange="checkFileSizepf(this, 'fileErrorPfAttachment');">
                                                            <span id="fileErrorPfAttachment" style="color: red; font-size: 11px; display: none;">
                                                                * File should not exceed 5MB
                                                            </span>
                                                        </div>
                                                    </div>

                                                    <!-- JavaScript for dynamic show/hide -->
                                                    <script>
                                                                                function toggleMSME(showInput) {
                                                                                const msmeInputWrapper = document.getElementById("msmeInputWrapper");
                                                                                        const udyamText = document.getElementById("udyamText");
                                                                                        if (showInput) {
                                                                                msmeInputWrapper.style.display = "block";
                                                                                        udyamText.style.display = "inline";
                                                                                } else {
                                                                                msmeInputWrapper.style.display = "none";
                                                                                        udyamText.style.display = "none";
                                                                                }
                                                                                }

                                                                        function toggleEPFO(showInput) {
                                                                        const epfoInputWrapper = document.getElementById("epfoInputWrapper");
                                                                                if (showInput) {
                                                                        epfoInputWrapper.style.display = "block";
                                                                        } else {
                                                                        epfoInputWrapper.style.display = "none";
                                                                        }
                                                                        }

                                                                        // Initial load: reflect current db values
                                                                        window.onload = function () {
                                                                        toggleMSME("${vendorInformation.msmeResponse}" === "yes");
                                                                                toggleEPFO("${vendorInformation.epfoResponse}" === "yes");
                                                                        };</script>





                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Import Export Code</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <c:choose>
                                                                <c:when test="${vendorInformation.ecc_no!=''}">
                                                                    <input type="checkbox" id="toggleInput" checked="true" onchange="toggleInputs();">

                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="checkbox" id="toggleInput" onchange="toggleInputs();">

                                                                </c:otherwise>
                                                            </c:choose>
                                                            <label for="toggleInput">Show Import Export Code Input</label>
                                                        </div>
                                                    </div>

                                                    <div class="form-group" id="inputFields" style="display: none;">
                                                        <div class="col-sm-3"></div>
                                                        <div class="col-sm-3">


                                                            <input type="text" id="ecc_no" name="ecc_no" class="form-control" maxlength="30" 
                                                                   value="${vendorInformation.ecc_no}"  >
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="hidden" class="form-control" id="eccNoFile1" name="eccNoFile1" accept="" value="${vendorInformation.ecc_file}">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.ecc_file}&id=${vendorInformation.id}">${vendorInformation.ecc_file}</a>
                                                            </span>
                                                            <input type="file" class="form-control" id="eccNoFile" name="eccNoFile" 
                                                                   accept=".pdf,.jpg,.jpeg,.png" 
                                                                   onchange="checkFileSizeIc(this, 'eccNoFileError');" 
                                                                   >
                                                            <span id="eccNoFileError" style="color: red; font-size: 11px; display: none;">
                                                                * File should not exceed 5MB
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <script>
                                                                                function toggleInputs() {
                                                                                const checkbox = document.getElementById('toggleInput');
                                                                                        const inputFields = document.getElementById('inputFields');
                                                                                        inputFields.style.display = checkbox.checked ? 'block' : 'none';
                                                                                }

                                                    </script>
                                                    <script>
                                                                        // Function to check file size
                                                                        function checkFileSizeg(input, fileErrorGstin) {
                                                                        const file = input.files[0]; // Get the selected file
                                                                                const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                if (file && file.size > maxSize) {
                                                                        document.getElementById(fileErrorGstin).style.display = 'block'; // Show error message
                                                                                input.value = ''; // Clear the file input
                                                                        } else {
                                                                        document.getElementById(fileErrorGstin).style.display = 'none'; // Hide error message
                                                                        }
                                                                        }
                                                    </script>
                                                    <script>
                                                                        // Function to check file size
                                                                        function checkFileSizep(input, fileErrorPan) {
                                                                        const file = input.files[0]; // Get the selected file
                                                                                const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                if (file && file.size > maxSize) {
                                                                        document.getElementById(fileErrorPan).style.display = 'block'; // Show error message
                                                                                input.value = ''; // Clear the file input
                                                                        } else {
                                                                        document.getElementById(fileErrorPan).style.display = 'none'; // Hide error message
                                                                        }
                                                                        }
                                                    </script>
                                                    <script>
                                                                        // Function to check file size
                                                                        function checkFileSizem(input, fileErrorServiceTax) {
                                                                        const file = input.files[0]; // Get the selected file
                                                                                const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                if (file && file.size > maxSize) {
                                                                        document.getElementById(fileErrorServiceTax).style.display = 'block'; // Show error message
                                                                                input.value = ''; // Clear the file input
                                                                        } else {
                                                                        document.getElementById(fileErrorServiceTax).style.display = 'none'; // Hide error message
                                                                        }
                                                                        }
                                                    </script>
                                                    <script>
                                                                        // Function to check file size
                                                                        function checkFileSizepf(input, fileErrorPfAttachment) {
                                                                        const file = input.files[0]; // Get the selected file
                                                                                const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                if (file && file.size > maxSize) {
                                                                        document.getElementById(fileErrorPfAttachment).style.display = 'block'; // Show error message
                                                                                input.value = ''; // Clear the file input
                                                                        } else {
                                                                        document.getElementById(fileErrorPfAttachment).style.display = 'none'; // Hide error message
                                                                        }
                                                                        }
                                                    </script>
                                                    <script>
                                                                        // Function to check file size
                                                                        function checkFileSizeIc(input, eccNoFileError) {
                                                                        const file = input.files[0]; // Get the selected file
                                                                                const maxSize = 5 * 1024 * 1024; // 5MB in bytes

                                                                                if (file && file.size > maxSize) {
                                                                        document.getElementById(eccNoFileError).style.display = 'block'; // Show error message
                                                                                input.value = ''; // Clear the file input
                                                                        } else {
                                                                        document.getElementById(eccNoFileError).style.display = 'none'; // Hide error message
                                                                        }
                                                                        }
                                                    </script>

                                                    <br>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label class="control-label">Payment/Banking Information</label>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Account Number.<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="accountNumber"  class="form-control"   maxlength="30" required="required"/>
                                                        </div>

                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Bank Name <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="bankName"  class="form-control"   maxlength="30" required="required"/>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Branch<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="branch"  class="form-control"   maxlength="30" required="required"/>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">IFSC Code<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="ifscCode"  class="form-control"   maxlength="30" required="required"/>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Swift Code (if any)<span style="color: red;font-size: 12px;"></span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="swiftCode"  class="form-control"   maxlength="30" />
                                                        </div>

                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label"> Cancel Cheque <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.cancelCheck}&id=${vendorInformation.id}">${vendorInformation.cancelCheck}</a>

                                                            </span>
                                                            <input type="hidden" name="cancelcheck1" id="cancelcheck1" value="${vendorInformation.cancelCheck}">
                                                            <input type="file" class="form-control" id="cancelcheck" name="cancelcheck" accept="" onchange="checkFileSize();">
                                                        </div>
                                                    </div>



                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Financial Year</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Financial Amount</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Financial Attachment</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-sm-3">

                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="finical1" id="finicalInput1"  class="form-control"   maxlength="30" />

                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="finicalAmount1"  class="form-control"   maxlength="30" />
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <span><a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment1}&id=${vendorInformation.id}">${vendorInformation.finicalAttachment1}</a>
                                                            </span>
                                                            <input type="hidden"  class="form-control" id="finicalAttachment11" value="${vendorInformation.finicalAttachment1}" name="finicalAttachment11" accept="" >

                                                            <input type="file" class="form-control" id="finicalAttachment1" onchange="checkFileSize();" name="finicalAttachment1" accept="" >
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">

                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="finical2" id="finicalInput2"  class="form-control"   maxlength="30" />

                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="finicalAmount2"  class="form-control"   maxlength="30" />
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <span><a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment2}&id=${vendorInformation.id}">${vendorInformation.finicalAttachment2}</a>
                                                            </span>
                                                            <input type="hidden" class="form-control" id="finicalAttachment22" value="${vendorInformation.finicalAttachment2}" name="finicalAttachment22" accept="">

                                                            <input type="file" class="form-control" onchange="checkFileSize();" id="finicalAttachment2" name="finicalAttachment2" >
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-3">

                                                        </div>

                                                        <div class="col-sm-3">
                                                            <form:input  path="finical3" id="finicalInput3"   class="form-control"   maxlength="30" />
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input  path="finicalAmount3"   class="form-control"   maxlength="30" />
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <span><a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment3}&id=${vendorInformation.id}">${vendorInformation.finicalAttachment3}</a>
                                                            </span>
                                                            <input type="hidden" class="form-control" id="finicalAttachment33" value="${vendorInformation.finicalAttachment3}" name="finicalAttachment33" accept="" >

                                                            <input type="file" onchange="checkFileSize(this);" class="form-control"  id="finicalAttachment3" name="finicalAttachment3" >
                                                        </div>
                                                    </div>



                                                    <script>

                                                                                function checkFileSize(input) {
                                                                                const file = input.files[0];
                                                                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                                                                        if (file && file.size > maxSize) {
                                                                                document.getElementById('fileError').style.display = 'block';
                                                                                        input.value = ''; // Clear the file input
                                                                                } else {
                                                                                document.getElementById('fileError').style.display = 'none';
                                                                                }
                                                                                }



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
                                                                        });</script>












                                                    <h5>Add External Vendor Email</h5>
                                                    <div class="form-group">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="table-responsive">
                                                                <table id="policyTable5" class="table table-bordered table-striped table-hover" style="" align="center">
                                                                    <tr>
                                                                        <th>Sr. No.</th>
                                                                        <th>Vendor Email</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                    <c:set var="c" value="0"/>
                                                                    <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>

                                                                    <c:if test="${vendorInformation.email1 != ''}">
                                                                        <tr>
                                                                            <td style="width: 15vh;">
                                                                                <input style="width: 15vh;" type="text" class="form-control" name="srNo1" value="${c + 1}" readonly />
                                                                            </td>
                                                                            <td>
                                                                                <input name="emails" value="${vendorInformation.email1}" class="form-control" maxlength="30" />
                                                                            </td>
                                                                            <td>
                                                                                <span style="margin-top: 5px;">
                                                                                    &nbsp;&nbsp;
                                                                                    <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email1}&a=1">
                                                                                        <i class="fa fa-trash"></i>
                                                                                    </a>
                                                                                </span>
                                                                            </td>
                                                                        </tr>
                                                                        <c:set var="c" value="${c + 1}" />
                                                                    </c:if>

                                                                    <c:if test="${vendorInformation.email2 != ''}">
                                                                        <tr>
                                                                            <td style="width: 15vh;">
                                                                                <input style="width: 15vh;" type="text" class="form-control" name="srNo2" value="${c + 1}" readonly />
                                                                            </td>
                                                                            <td>
                                                                                <input name="emails" value="${vendorInformation.email2}" class="form-control" maxlength="30" />
                                                                            </td>
                                                                            <td>
                                                                                <span style="margin-top: 5px;">
                                                                                    &nbsp;&nbsp;
                                                                                    <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email2}&a=2">
                                                                                        <i class="fa fa-trash"></i>
                                                                                    </a>
                                                                                </span>
                                                                            </td>
                                                                        </tr>
                                                                        <c:set var="c" value="${c + 1}" />
                                                                    </c:if>

                                                                    <c:if test="${vendorInformation.email3 != ''}">
                                                                        <tr>
                                                                            <td style="width: 15vh;">
                                                                                <input style="width: 15vh;" type="text" class="form-control" name="srNo3" value="${c + 1}" readonly />
                                                                            </td>
                                                                            <td>
                                                                                <input name="emails" value="${vendorInformation.email3}" class="form-control" maxlength="30" />
                                                                            </td>
                                                                            <td>
                                                                                <span style="margin-top: 5px;">
                                                                                    &nbsp;&nbsp;
                                                                                    <a href="vendorInformation.htm?act=deleteExternalVendor&id=${vendorInformation.id}&loginId=${vendorInformation.email3}&a=3">
                                                                                        <i class="fa fa-trash"></i>
                                                                                    </a>
                                                                                </span>
                                                                            </td>
                                                                        </tr>
                                                                        <c:set var="c" value="${c + 1}" />
                                                                    </c:if>

                                                                    <!-- Add new email row -->
                                                                    <c:if test="${c!=3}">
                                                                        <tr id="policyRow1">
                                                                            <td id="policyId1" style="width: 15vh;">
                                                                                <input style="width: 15vh;" type="text" id="sr" class="form-control" name="srNo1" value="${c + 1}" readonly />
                                                                            </td>
                                                                            <td id="name1">
                                                                                <input type="text" class="form-control" name="emails" placeholder="Vendor Email" id="email1" />
                                                                            </td>
                                                                            <td>
                                                                                <span style="margin-top: 5px;">
                                                                                    &nbsp;&nbsp; <input type="button" value="+" id="policyCloneid5" />
                                                                                </span>
                                                                            </td>
                                                                        </tr>
                                                                    </c:if>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <script>

                                                                                var tempCount5 = document.getElementById("sr").value;
                                                                                $(function () {
                                                                                $("#policyCloneid5").on("click", function () {
                                                                                var currentRows = $("#policyTable5 tr").length - 1; // Subtract 1 for the header row
                                                                                        if (currentRows >= 3) {
                                                                                alert("You can only add up to 3 emails.");
                                                                                        return;
                                                                                }
                                                                                tempCount5++;
                                                                                        var clone = "<tr id='addmoreFile" + tempCount5 + "' style='clear:both;'>"
                                                                                        + "<td style=\"width: 15vh;\" id=\"policyId" + tempCount5 + "\"><input style=\"width: 15vh; \" type=\"text\" class=\"form-control\" name=\"srNo" + tempCount5 + "\" value=\"" + tempCount5 + "\" readonly></td>"
                                                                                        + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Vendor Email\" name=\"emails" + "\" id=\"email" + tempCount5 + "\"></td>"
                                                                                        + "<td >"
                                                                                        + "<span style='margin-top: 5px;'>"
                                                                                        + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;'   onclick=\"removePolicy('addmoreFile" + tempCount5 + "');\"/>"
                                                                                        + "</span>"
                                                                                        + "</td>" + "</tr>";
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

                                                    <div class="form-group" style="margin-top: 10px;">
                                                        <div class="col-sm-3">
                                                            <label>Comment</label>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <textarea name="comments" class="form-control "></textarea>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6 col-sm-offset-5">
                                                            <input type="submit" class="btn btn1"  <c:if test="${(vendorInformation.status1 == '10' 
                                                                                                                 || vendorInformation.status1 == '9' 
                                                                                                                 || vendorInformation.status1 == '11' 
                                                                                                                 || vendorInformation.status1 == '8' 
                                                                                                                 || vendorInformation.status1 == '1' 
                                                                                                                 || vendorInformation.status1 == '2') 
                                                                                                                 && vendorInformation.auditorFlag != '3'}">disabled="true"</c:if> id="submit1" title="submit1" value="Submit" >
                                                            </div>
                                                        </div>
                                                    </div>
                                            </c:if>

                                        </div>
                                    </section>


                                </form:form>

                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->

            </section><!-- /.content -->
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>


    </body>


    <body onload="toggleGSTFields(); toggleInputs();">

    </body>
</html>
