<%-- 
    Document   : SafetyCriteriaRecycleView
    Created on : 6 Jan, 2025, 10:42:58 AM
    Author     : bulwarks-2
--%>

<%-- 
    Document   : VendorSafetyLevelOneCriteria
    Created on : 4 Jan, 2025, 1:02:09 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Auditor Approval Details</title>

        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }

        </style>


        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper" style="min-height: 720px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div style="display: flex; height: 25px;
                     justify-content: space-between;
                     align-items: center;">
                    <h4 style="margin-top: 1px;">Auditor Approval Details</h4>
                    <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
                </div>
            </section>

            <!-- Main content -->
            <form:form action="vendorInformation.htm?act=auditorRecycleSubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                       class="form-horizontal" role="form" name="form">
                <input type="hidden" id="VInformationId" name="VInformationId" value="${VInformationId}"/>


                <section class="content">

                    <div class="row">
                        <div class="col-md-12">

                            <div class="nav-tabs-custom">
                                <c:if test="${vendorInformation.status1=='3' or vendorInformation.finacialFlag=='3' or vendorInformation.technicalFlag=='3' or vendorInformation.hrApprovalFlag=='3' or vendorInformation.safteyApprovalFlag=='3'}">
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
                                        <c:if test="${vendorInformation.auditorFlag=='3'}">
                                            <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Auditor Approval Team</p>
                                        </c:if>
                                    </div>
                                </c:if>

                                <div id="exTab" class="">	
                                    <ul class="nav nav-pills nav-tabs ">
                                        <li ><a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>1 <sup>st</sup> Level Approve</a></li>
                                        <li><a href="vendorInformation.htm?act=policyUpdateVendorInformation" <c:if test="${vendorInformation.finacialFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Financial Approval</a></li>
                                        <li><a href="vendorInformation.htm?act=electricTechnicalRecycle" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Technical Approval</a></li>
                                        <li ><a href="vendorInformation.htm?act=hrCriteriaRecycleView" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>HR Approval</a></li>

                                            <li><a href="vendorInformation.htm?act=safetyCriteriaRecycleView" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style=""</c:if>><i class="fa fa-circle-o"></i>Safety Approval</a></li>
                                        <li  class="active"><a href="vendorInformation.htm?act=auditorCriteriaRecycleView" <c:if test="${vendorInformation.auditorFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Auditor Approval</a></li>
                                            <li><a href="vendorInformation.htm?act=activeVenderProfileView"><i class="fa fa-circle-o"></i>View Vendor</a></li>
                                        </ul>
                                    </div>
                                    <div class="tab-content">


                                    <c:if test="${vendorInformation.auditorFlag== 1 || vendorInformation.auditorFlag== 0}">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Auditor Name :</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="text" readonly  class="form-control" value="${vendorInformation.auditorName}"  maxlength="30" />

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Email ID :</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="text" readonly class="form-control" value="${vendorInformation.vendorEmailId}"  maxlength="30" />
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Attachment</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=getAuditorAttachmentFile&amp;fileName=${vendorInformation.auditorAttachment}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.auditorAttachment}</a>
                                                            </span>                                                    </div>
                                                    </div>






                                                </div>
                                            </div>
                                        </div>
                                    </c:if>



                                    <c:if test="${vendorInformation.auditorFlag== 3}">

                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Auditor Name :</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="text" readonly  class="form-control" value="${vendorInformation.auditorName}"  maxlength="30" />

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Email ID :</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="text" readonly class="form-control" value="${vendorInformation.vendorEmailId}"  maxlength="30" />
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Attachment</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <span>
                                                                <a href="vendorInformation.htm?act=getAuditorAttachmentFile&amp;fileName=${vendorInformation.auditorAttachment}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.auditorAttachment}</a>
                                                            </span>                                                  
                                                        </div>
                                                    </div>
                                                            
                                                            
                                                            
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


                                                    <div class="form-group">
                                                        <div class="col-sm-6 col-sm-offset-5">
                                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" title="" value="SUBMIT">
                                                        </div>
                                                    </div>



                                                </div>
                                            </div>
                                        </div>
                                    </c:if>


                                </div>

                            </div>
                        </div>
                </section>
                <script>
                    function response() {

                        var l = document.form.criteriaName ? document.form.criteriaName.length : 0;
                        var i = 1;
                        var sum = 0;
                        var sum1 = 0;
                        var total = l * 2;
                        if (l == null) {

                            var accept = parseFloat(document.getElementById("score1").value) || 0;
                            var accepts = parseFloat(document.getElementById("accepts1").value) || 0;
                            sum += accept;
                            sum1 += accepts;
                            var totals = 2;
                            var total1 = (sum * 100) / totals;
                            var total2 = (sum1 * 100) / totals;
                            document.getElementById("total").value = sum;
                            document.getElementById("percentage").value = total1.toFixed(2);
                            document.getElementById("totalHr").value = sum1;
                            document.getElementById("percentageHr").value = total2.toFixed(2);
                        } else {
                            while (i <= l) {
                                var accept = parseFloat(document.getElementById("score" + i).value) || 0;
                                var accepts = parseFloat(document.getElementById("accepts" + i).value) || 0;
                                sum += accept;
                                sum1 += accepts;
                                i++;
                            }
                            var total1 = (sum * 100) / total;
                            var total2 = (sum1 * 100) / total;
                            document.getElementById("total").value = sum;
                            document.getElementById("percentage").value = total1.toFixed(2);
                            document.getElementById("totalHr").value = sum1;
                            document.getElementById("percentageHr").value = total2.toFixed(2);
                        }


                    }
                </script>

            </form:form>
        </div>


        <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>

    </body>
    <body onload="response();">

    </body>

</html>



