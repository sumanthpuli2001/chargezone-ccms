<%-- 
    Document   : SafetyCriteriaRecycleView
    Created on : 3 Nov, 2025, 09:57:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>Vendor Safety Details</title>
    </head>

    <body>
        <style>
            .alert-static{
                color:#721c24;
                background-color:#f8d7da;
                border-color:#f5c6cb
            }
            .alert-static hr{
                border-top-color:#f1b0b7
            }
            .input-percent {
                position: relative;
            }

            .input-percent input {
                padding-right: 25px; 
                text-align: left;  
            }

            .input-percent::after {
                content: "%";
                position: absolute;
                right: 10px;
                top: 50%;
                transform: translateY(-50%);
                color: #555;
                pointer-events: none;
                
            }
             table > tbody > tr:nth-of-type(odd) {
                background-color: #F3F7FF;
            }
            table > thead > tr {
                background: skyblue;
            }
        </style>
        <style>           
            input[type="text"], textarea {
                text-transform: uppercase;
            }
        </style>

        <script>
            document.addEventListener("input", function (e) {
                const el = e.target;

                if (
                    el.matches("input:not([type='hidden']):not([type='checkbox']):not([type='radio']), textarea")
                ) {
                    if (el.type === "email") {
                        el.value = el.value.toLowerCase();
                    } else {
                        el.value = el.value.toUpperCase();
                    }
                }
            });
        </script>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=safetyCriteriaRecycleSubmit"  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Vendor Safety Details</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
                    <hr>
                    
                    <c:if test="${!empty failureMessage}">                        
                        <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">                       
                        <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>       

                    <input type="hidden" id="VInformationId" name="VInformationId" value="${vendorInformation.id}">

                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">

                            <li class="tab-item mr-2">
                                <a href="vendorInformation.htm?act=policyUpdateLevelOneVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>>Basic Information</a>
                                </li>                            

                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=policyUpdateVendorInformation" class="tab-link transition-0" <c:if test="${vendorInformation.finacialFlag=='3'|| vendorInformation.finacialFlag=='6'|| vendorInformation.finacialFlag=='10'
                                      || (vendorInformation.status1 == '10' && vendorInformation.finacialFlag == '1')}">style="color: red;"</c:if>>Financial Information</a>
                                </li>

                            <c:if test="${rightsMap['TECHNICAL'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=electricTechnicalRecycle" class="tab-link transition-0" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>>Technical Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HR'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=hrCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>>HR Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HSE'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=safetyCriteriaRecycleView" class="tab-link active transition-0" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style="color: red;"</c:if>>Safety Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['IT'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=itCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.itApprovalFlag=='3'}">style="color: red;"</c:if>>IT Information</a>
                                    </li>
                            </c:if>

                            <li class="tab-item">
                                <a href="vendorInformation.htm?act=activeVenderProfileView" class="tab-link transition-0">Vendor Information</a>
                            </li>
                        </ul>
                    </div>
                    <c:if test="${vendorInformation.status1 == 6 || vendorInformation.status1 == 7 || vendorInformation.status1 == 501 || vendorInformation.finacialFlag=='3' || vendorInformation.technicalFlag=='3' || vendorInformation.hrApprovalFlag=='3' || vendorInformation.safteyApprovalFlag=='3' || vendorInformation.itApprovalFlag=='3'}">
                        <br>
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>                        
                                <c:if test="${vendorInformation.finacialFlag=='3'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Financial Approval Team. </strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.technicalFlag=='3'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Technical Team </strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.hrApprovalFlag=='3'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By HR Approval Team. </strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By Safety Approval Team</strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.itApprovalFlag=='3'}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Recycle By IT Approval Team</strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.status1 == 6}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Reject from Buyer.</strong> <br>
                                </c:if>
                                <c:if test="${vendorInformation.status1 == 7}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Reject from Procurement Head. </strong><br>
                                </c:if>
                                <c:if test="${vendorInformation.status1 == 501}">
                                    <strong>Note:</strong> <strong class="text-danger fs-15">Reject from Compliance Officer. </strong><br>
                                </c:if>
                                <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                                <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                            </div>
                        </div> 
                    </c:if> 
                    <br>
                    
                    <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">
                        <div class="rounded-4 mt-4">

                            <table id="table_1" class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                <tr style=" background-color:skyblue;">
                                    <th style="width: 5%">Sr No.</th>
                                    <th style="width: 15%">Criteria</th>
                                    <th style="width: 20%">Selection Criteria</th>
                                    <th style="width: 10%">Score</th>
                                    <th style="width: 20%">Comment</th>
                                    <th style="width: 15%">Attachment</th>
                                    <th style="width: 10%">Safety Score</th>
                                    <th style="width: 10%">Safety Comment</th>
                                </tr>

                                <c:set var="prevGroup" value="" />
                                <c:set var="prevCategory" value="" />
                                <c:set var="prevSubCategory" value="" />

                                <c:forEach var="list" items="${list6}" varStatus="status">
                                    <!-- Group header -->
                                    <c:if test="${list[1] != prevGroup or list[6] != prevCategory or list[7] != prevSubCategory}">
                                        <tr>
                                            <td colspan="8">
                                                <b style="font-size: 14px;">
                                                    Group Name: ${list[1]}
                                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                                    <c:if test="${list[6] != '0'}">
                                                        Group Category Name: ${list[6]} &nbsp;&nbsp;&nbsp;&nbsp;
                                                    </c:if>
                                                    <c:if test="${list[7] != '0'}">
                                                        Group Sub Category Name: ${list[7]}
                                                    </c:if>
                                                </b>
                                            </td>
                                        </tr>

                                        <c:set var="prevGroup" value="${list[1]}" />
                                        <c:set var="prevCategory" value="${list[6]}" />
                                        <c:set var="prevSubCategory" value="${list[7]}" />
                                    </c:if>

                                    <tr>
                                        <td>${status.count}</td>
                                        <td><pre class="terms-details">${list[2]}</pre></td>
                                        <td><pre class="terms-details">${list[3]}</pre></td>

                                        <td>
                                            <c:forEach var="list66" items="${list66}">
                                                <c:if test="${list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">
                                                    <input type="hidden" name="hrId" value="${list66.id}"/>
                                                    <c:if test="${list66.accept=='1' || list66.accept=='2'}">
                                                        <input type="hidden" name="score" value="${list66.score}"/>
                                                    </c:if>
                                                    <select name="score" class="select-input" id="score" onchange="handleScoreChange(this);"
                                                            <c:if test="${list66.accept=='1' || list66.accept=='2'}">disabled</c:if>>
                                                                <option value="">--Select--</option>
                                                                <option value="0" <c:if test="${list66.score=='0'}">selected</c:if>>No</option>
                                                            <option value="1" <c:if test="${list66.score=='1'}">selected</c:if>>Yes</option>
                                                            </select>
                                                </c:if>
                                            </c:forEach>
                                        </td>

                                        <td>
                                            <c:forEach var="list66" items="${list66}">
                                                <c:if test="${list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">
                                                    <textarea name="comment" class="input-field"  id="comment"
                                                              <c:if test="${list66.accept=='1' || list66.accept=='2'}">readonly</c:if>>${list66.comment}</textarea>
                                                </c:if>
                                            </c:forEach>
                                        </td>

                                        <td>
                                            <c:forEach var="list66" items="${list66}">
                                                <c:if test="${list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">

                                                    <c:if test="${list66.attachement!=null && not empty list66.attachement}">                                        
                                                        <span class="file-wrapper">
                                                            <span class="file-name text-break">${list66.attachement}</span>
                                                            <span class="file-actions">
                                                                <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list66.attachement}&foldName=HSE&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/HSE/${list66.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                            </span>
                                                        </span>
                                                    </c:if>
                                                    <input type="hidden" name="attachment1" value="${list66.attachement}"/>
                                                    <input type="file" name="attachment" class="input-field" style="${(list[4]=='No' || list66.accept=='1' || list66.accept=='2') ? 'display: none;' : ''}"
                                                           onchange="validateFileSize(this, 'fileError${status.count}')">
                                                    <span id="fileError${status.count}" style="color:red; font-size:11px; display:none;">
                                                        * File should not exceed 5MB
                                                    </span>
                                                </c:if>
                                            </c:forEach>
                                        </td>

                                        <td>
                                            <c:forEach var="list66" items="${list66}">
                                                <c:if test="${list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">
                                                    <input type="text" name="accept" readonly class="input-field" value="${list66.accept == '2' ? 'Accept' : (list66.accept == '1' ? 'Partial Accept' : (list66.accept == '0' ? 'Reject' : ''))}">
                                                </c:if>
                                            </c:forEach>
                                        </td>

                                        <td>
                                            <c:forEach var="list66" items="${list66}">
                                                <c:if test="${list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">
                                                    <textarea type="text" readonly  class="input-field" value="">${list66.safetyComment}</textarea>
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td colspan="3"><b>Total</b></td>
                                    <td><input type="text" id="totalScore" readonly name="totalScore" class="input-field"></td>
                                    <td colspan="2"></td>
                                    <td><input type="text" id="totalAccept" readonly name="totalAccept" class="input-field"></td>
                                    <td></td>
                                </tr>

                                <tr>
                                    <td colspan="3"><b>Total Percentage</b></td>
                                    <td><input type="text" id="percentageScore" readonly name="percentageScore" class="input-field"></td>
                                    <td colspan="2"></td>
                                    <td><input type="text" id="percentageAccept" readonly name="percentageAccept" class="input-field"></td>
                                    <td></td>
                                </tr>
                            </table>





                            <div class="col-12 p-0">
                                <div class="form-group comment-box">
                                    <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                    <textarea type="text" maxlength="250" class="textarea-field comment" id="comments" name="comments"  required="true"></textarea>
                                </div>
                            </div>                                                        

                            <div class="form-group">
                                <div style="display: flex;  justify-content: center;">
                                    <button type="submit" id="submit1" class="btn theme-btn">Submit</button>
                                </div>
                            </div>                                                       


                        </div>
                        <script>
                            function handleScoreChange(selectElement) {
                                var row = selectElement.closest("tr");
                                var comment = row.querySelector("textarea[name='comment']");

                                if (selectElement.disabled) {
                                    comment.readOnly = true;
                                    return;
                                }

                                if (selectElement.value === "1") {
                                    comment.value = "";
                                    comment.readOnly = true;
                                } else {
                                    comment.readOnly = false;
                                }
                            }

                            window.onload = function () {
                                document.querySelectorAll("select[name='score']").forEach(function (select) {
                                    handleScoreChange(select);
                                });
                            };
                        </script>

                                                        <script>
                                                            function validateFileSize(input, errorId) {
                                                                const file = input.files[0];
                                                                        const maxSize = 5 * 1024 * 1024; // 5MB
                                                                        const errorEl = document.getElementById(errorId);
                                                                        if (file && file.size > maxSize) {
                                                                errorEl.style.display = 'block';
                                                                        input.value = '';
                                                                } else {
                                                                errorEl.style.display = 'none';
                                                                }
                                                            }

                                                            function calculateTotals() {

                                                                const vendorSelects = document.querySelectorAll("select[name='score']");
                                                                const hrInputs = document.getElementsByName("accept");

                                                                let vendorSum = 0;
                                                                let hrSum = 0;

                                                                // Vendor Score
                                                                vendorSelects.forEach(function (s) {
                                                                    if (s.value === "1") {
                                                                        vendorSum++;
                                                                    }
                                                                });

                                                                // Accept Score
                                                                for (let h of hrInputs) {
                                                                    const value = h.value.trim().toLowerCase();

                                                                    if (value === "accept") {
                                                                        hrSum += 2;
                                                                    } else if (value === "partial accept") {
                                                                        hrSum += 1;
                                                                    }
                                                                }

                                                                const totalVendorPossible = vendorSelects.length;
                                                                const totalHrPossible = hrInputs.length * 2;

                                                                const vendorPercentage = totalVendorPossible > 0
                                                                    ? ((vendorSum * 100) / totalVendorPossible).toFixed(2)
                                                                    : "0.00";

                                                                const hrPercentage = totalHrPossible > 0
                                                                    ? ((hrSum * 100) / totalHrPossible).toFixed(2)
                                                                    : "0.00";

                                                                document.getElementById("totalScore").value = vendorSum;
                                                                document.getElementById("percentageScore").value = vendorPercentage + "%";

                                                                document.getElementById("totalAccept").value = hrSum;
                                                                document.getElementById("percentageAccept").value = hrPercentage + "%";
                                                            }

                                                            document.addEventListener("DOMContentLoaded", function () {
                                                                document.querySelectorAll("select[name='score']").forEach(function(select) {
                                                                    handleScoreChange(select);
                                                                });

                                                                calculateTotals();
                                                            });
                                                        </script>
                                                </c:if>





                                                <!--For Read only True-->

                                                <c:if test="${ vendorInformation.safteyApprovalFlag=='1' || vendorInformation.safteyApprovalFlag=='0'}">
                                                <%--<c:if test="${vendorInformation.safteyApprovalFlag=='3'}">--%>
                                                   
                                                    <div class="table">
                                                        <table id="table_1" class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                                            <tr style=" background-color:skyblue;">
                                                                <th style="width: 5%">Sr No.</th>
                                                                <th style="width: 15%">Criteria</th>
                                                                <th style="width: 18%">Selection Criteria</th>
                                                                <th style="width: 10%">Vendor Score</th>
                                                                <th style="width: 18%">Comment</th>
                                                                <th style="width: 15%">Attachment</th>
                                                                <th style="width: 9%">Safety Score</th>
                                                                <th style="width: 10%">Safety Comment</th>
                                                            </tr>

                                                            <c:set var="prevGroup" value="" />
                                                            <c:set var="prevCategory" value="" />
                                                            <c:set var="prevSubCategory" value="" />

                                                            <c:forEach var="list" items="${list6}" varStatus="status">
                                                                <!-- Print header when new group/category/subcategory appears -->
                                                                <c:if test="${list[1] != prevGroup or list[6] != prevCategory or list[7] != prevSubCategory}">
                                                                    <tr>
                                                                        <td colspan="8">
                                                                            <b style="font-size: 14px;">
                                                                                Group Name: ${list[1]}
                                                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                                                <c:if test="${list[6] != '0'}">
                                                                                    Group Category Name: ${list[6]} &nbsp;&nbsp;&nbsp;&nbsp;
                                                                                </c:if>
                                                                                <c:if test="${list[7] != '0'}">
                                                                                    Group Sub Category Name: ${list[7]}
                                                                                </c:if>
                                                                            </b>
                                                                        </td>
                                                                    </tr>

                                                                    <c:set var="prevGroup" value="${list[1]}" />
                                                                    <c:set var="prevCategory" value="${list[6]}" />
                                                                    <c:set var="prevSubCategory" value="${list[7]}" />
                                                                </c:if>

                                                                <c:forEach var="list66" items="${list66}">
                                                                    <c:if test="${list[2] == list66.criteriaName && list[3] == list66.criteriaDescription}">
                                                                        <tr>
                                                                            <td>${status.count}</td>
                                                                            <td><pre class="terms-details">${list[2]}</pre></td>
                                                                            <td><pre class="terms-details">${list[3]}</pre></td>

                                                                            <td>
                                                                                <input type="text" name="score" readonly class="input-field"
                                                                                       value="${list66.score == '1' ? 'Yes' : 'No'}">
                                                                            </td>

                                                                            <td>
                                                                                <textarea readonly name="comment" disabled class="input-field">${list66.comment}</textarea>
                                                                            </td>

                                                                            <td>                                                                                
                                                                                <c:if test="${list66.attachement!=null && not empty list66.attachement}">                                        
                                                                                    <span class="file-wrapper">
                                                                                        <span class="file-name text-break">${list66.attachement}</span>
                                                                                        <span class="file-actions">
                                                                                            <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list66.attachement}&foldName=HSE&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/HSE/${list66.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                                        </span>
                                                                                    </span>
                                                                                </c:if>
                                                                            </td>

                                                                            <td>
                                                                                <input type="text" name="accept" readonly class="input-field"
                                                                                       value="${list66.accept == '2' ? 'Accept' : (list66.accept == '1' ? 'Partial Accept' : (list66.accept == '0' ? 'Reject' : ''))}">
                                                                            </td>

                                                                            <td>
                                                                                <textarea type="text" name="hrComment" readonly class="input-field" value="">${list66.safetyComment}</textarea>
                                                                            </td>
                                                                        </tr>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </c:forEach>

                                                            <tr>
                                                                <td colspan="3"><b>Total</b></td>
                                                                <td><input type="text" id="totalVendor" readonly name="totalVendor" class="input-field"></td>
                                                                <td colspan="2"></td>
                                                                <td><input type="text" id="totalSafety" readonly name="totalSafety" class="input-field"></td>
                                                                <td></td>
                                                            </tr>

                                                            <tr>
                                                                <td colspan="3"><b>Total Percentage</b></td>
                                                                <td><input type="text" id="percentageVendor" readonly name="percentageVendor" class="input-field"></td>
                                                                <td colspan="2"></td>
                                                                <td><input type="text" id="percentageSafety" readonly name="percentageSafety" class="input-field"></td>
                                                                <td></td>
                                                            </tr>
                                                        </table>



                                                    </div>
                                                    <script>
                                                        function calculateTotals() {
                                                            const vendorInputs = document.getElementsByName("score");
                                                            const hrInputs = document.getElementsByName("accept");

                                                            let vendorSum = 0;
                                                            let hrSum = 0;

                                                            for (let v of vendorInputs) {
                                                                if (v.value.trim().toLowerCase() === "yes") {
                                                                    vendorSum++;
                                                                }
                                                            }

                                                            for (let h of hrInputs) {
                                                                const value = h.value.trim().toLowerCase();

                                                                if (value === "accept") {
                                                                    hrSum += 2;
                                                                } else if (value === "partial accept") {
                                                                    hrSum += 1;
                                                                }
                                                            }

                                                            const totalVendorPossible = vendorInputs.length;
                                                            const totalHrPossible = hrInputs.length * 2;

                                                            const vendorPercentage = totalVendorPossible > 0
                                                                ? ((vendorSum * 100) / totalVendorPossible).toFixed(2)
                                                                : "0.00";

                                                            const hrPercentage = totalHrPossible > 0
                                                                ? ((hrSum * 100) / totalHrPossible).toFixed(2)
                                                                : "0.00";

                                                            document.getElementById("totalVendor").value = vendorSum;
                                                            document.getElementById("percentageVendor").value = vendorPercentage + "%";

                                                            document.getElementById("totalSafety").value = hrSum;
                                                            document.getElementById("percentageSafety").value = hrPercentage + "%";
                                                        }

                                                        window.addEventListener("load", calculateTotals);
                                                    </script>
                    </c:if>


                </form:form>
            </section>
        </main>
        <script>
                            function validateFileSize(input, errorId) {
                            const file = input.files[0];
                                    const maxSize = 5 * 1024 * 1024;
                                    if (file && file.size > maxSize) {
                            document.getElementById(errorId).style.display = 'block';
                                    input.value = '';
                            } else {
                            document.getElementById(errorId).style.display = 'none';
                            }
                            }
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
