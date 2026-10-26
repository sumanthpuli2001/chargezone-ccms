<%-- 
    Document   : ElectricTechnicalRecycle
    Created on : 1 Nov, 2025, 09:57:57 AM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>Vendor Technical Details</title>
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
                <form:form action="vendorInformation.htm?act=electricTechnicalRecyclesubmit"  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Vendor Technical Details </h5>
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
                                    <a href="vendorInformation.htm?act=policyUpdateVendorInformation"
                                       class="tab-link transition-0"
                                    <c:if test="${vendorInformation.finacialFlag == '3'
                                        || vendorInformation.finacialFlag == '6'
                                        || vendorInformation.finacialFlag == '10'
                                        || (vendorInformation.status1 == '10' && vendorInformation.finacialFlag == '1')}">
                                        style="color: red;"
                                    </c:if>>
                                    Financial Information
                                </a>
                            </li>

                            <c:if test="${rightsMap['TECHNICAL'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=electricTechnicalRecycle" class="tab-link active transition-0" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>>Technical Information</a>
                                </li>
                            </c:if>

                            <c:if test="${rightsMap['HR'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=hrCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>>HR Information</a>
                                    </li>
                            </c:if>

                            <c:if test="${rightsMap['HSE'] != null}">
                                <li class="tab-item mr-2">
                                    <a href="vendorInformation.htm?act=safetyCriteriaRecycleView" class="tab-link transition-0" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style="color: red;"</c:if>>Safety Information</a>
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
                    
                    <c:if test="${vendorInformation.technicalFlag=='3'}">
                        
                        <div class="rounded-4 mt-4">

                            <table id="table3" class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                                <tr style="background-color:skyblue;">
                                    <th style="width: 5%">Sr No.</th>
                                    <th style="width: 15%">Criteria</th>
                                    <th style="width: 20%">Selection Criteria</th>
                                    <th style="width: 10%">Vendor Score</th>
                                    <th style="width: 16%">Comment</th>
                                    <th style="width: 15%">Attachment</th>
                                    <th style="width: 10%">Technical Score</th>
                                    <th style="width: 10%">Technical Comment</th>
                                </tr>

                                <c:set var="prevGroup" value="" />
                                <c:set var="prevCategory" value="" />
                                <c:set var="prevSubCategory" value="" />
                                <c:forEach var="list" items="${list}" varStatus="status">
                                    <c:if test="${list[1] != prevGroup or list[6] != prevCategory or list[7] != prevSubCategory}">
                                        <tr>
                                            <td colspan="8">
                                                <b style="font-size: 14px;">
                                                    Group Name : ${list[1]}
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <c:if test="${list[6] != '0'}">
                                                        Group Category Name : ${list[6]} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    </c:if>
                                                    <c:if test="${list[7] != '0'}">
                                                        Group Sub Category Name : ${list[7]}
                                                    </c:if>
                                                </b>
                                            </td>
                                        </tr>
                                        <c:set var="prevGroup" value="${list[1]}" />
                                        <c:set var="prevCategory" value="${list[6]}" />
                                        <c:set var="prevSubCategory" value="${list[7]}" />
                                    </c:if>

                                    <c:set var="i" value="0"/>
                                    <c:forEach var="list1" items="${list1}">
                                        <c:if test="${list[2] == list1.criteria && list[3] == list1.selectionCriteria}">
                                            <c:set var="i" value="1"/>
                                            <input type="hidden" name="vendorCriteriaMasterId" value="${list[8]}"  >
                                            <input type="hidden" name="electricId" value="${list1.id}"/>
                                            <input type="hidden" name="topicname" value='${list[2]}' >
                                            <input type="hidden" name="topicname2" value='${list[3]}'  >
                                            <input type="hidden" name="compulsaryFlag" value="${list[4]}">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td>${list[2]}</td>
                                                <td>${list[3]}</td>

                                                <td>
                                                    <c:if test="${list1.response=='1' || list1.response=='2'}">
                                                        <input type="hidden" name="score" value="${list1.score}"/>
                                                    </c:if>
                                                    <select name="score" class="select-input score" id="score" onchange="handleScoreChange();" <c:if test="${list1.response == '1' || list1.response == '2'}">disabled</c:if>>
                                                        <option value="">--Select--</option>
                                                        <option value="1" <c:if test="${list1.score == '1'}">selected</c:if>>Yes</option>
                                                        <option value="0" <c:if test="${list1.score == '0'}">selected</c:if>>No</option>
                                                    </select>
                                                </td>

                                                <td><textarea name="comment" class="input-field comment" id="comment" <c:if test="${list1.response == '1' || list1.response == '2'}">readonly</c:if>>${list1.comment}</textarea></td>

                                                <td>
                                                    <input type="hidden" name="attachment1" value="${list1.attachment}"/>
                                                    <c:if test="${list1.attachment!=null && not empty list1.attachment}">                                        
                                                        <span class="file-wrapper">
                                                            <span class="file-name text-break">${list1.attachment}</span>
                                                            <span class="file-actions">
                                                                <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list1.attachment}&foldName=TECHNICAL&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                                <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/TECHNICAL/${list1.attachment}"><span class="fa fa-solid fa-eye"></span></a>					
                                                            </span>
                                                        </span>
                                                    </c:if>                                                
                                                    
                                                    <c:if test="${list[4] == 'Yes'}">
                                                        <c:if test="${list1.response == '1' || list1.response == '2'}">
                                                            <input type="file" name="attachment"  class="input-field" style="${(list[4]=='No' || list1.response == '1' || list1.response == '2' ) ? 'display: none;' : ''}" onchange="validateFileSize(this, 'fileError${status.count}')" >                                                    
                                                        </c:if>
                                                        <c:if test="${list1.response != '1' && list1.response != '2'}">
                                                            <input type="file" name="attachment"   class="input-field" style="${(list[4]=='No' || list1.response == '1' || list1.response == '2' ) ? 'display: none;' : ''}" onchange="validateFileSize(this, 'fileError${status.count}')" required>                                                    
                                                        </c:if>                                                           
                                                    </c:if>
                                                    <c:if test="${list[4] == 'No'}">
                                                        <input type="file" name="attachment"  class="input-field" style="${(list[4]=='No' || list1.response == '1' || list1.response == '2' ) ? 'display: none;' : ''}" onchange="validateFileSize(this, 'fileError${status.count}')" >                                                    
                                                    </c:if>                                                        
                                                    <span id="fileError${status.count}" style="color:red; font-size:11px; display:none;">* File should not exceed 5MB</span>
                                                </td>

                                                <td><input type="text" name="response" readonly class="input-field" value="${list1.response == '2' ? 'Accept' : (list1.response == '1' ? 'Partial Accept' : (list1.response == '0' ? 'Reject' : ''))}"></td>
                                                
                                                <td><textarea type="text" name="tremark" readonly class="input-field" maxlenght="250">${list1.technicalComment}</textarea></td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${i==0}">
                                        <input type="hidden" name="electricId" value="0" />
                                        <input type="hidden" name="vendorCriteriaMasterId" value="${list[8]}">
                                        <input type="hidden" name="topicname" value='${list[2]}'>
                                        <input type="hidden" name="topicname2" value='${list[3]}'>
                                        <input type="hidden" name="compulsaryFlag" value="${list[4]}">
                                        
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${list[2]}</td>
                                            <td>${list[3]}</td>


                                            <td>
                                                <select name="score" id="score${status.count}" class="select-input" onchange="response();" required="required">
                                                    <option value="">--Select--</option>
                                                    <option value="1">Yes</option>
                                                    <option value="0">No</option>
                                                </select>
                                            </td>

                                            <td><textarea name="comment" class="input-field" maxlength="250" ></textarea></td>
                                            
                                            <td>
                                                <c:choose>
                                                    <c:when test="${list[4]=='Yes'}">
                                                        <input type="hidden" name="attachment1" value="" />
                                                        <input type="file" name="attachment" id="file${status.count}" class="input-field" 
                                                            onchange="validateFileSize(this,'fileError${status.count}')" required>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="hidden" name="attachment1" value="" />
                                                        <input style="display: none;" type="file" name="attachment" id="file${status.count}"
                                                            class="input-field" onchange="validateFileSize(this,'fileError${status.count}')" />
                                                    </c:otherwise>
                                                </c:choose>
                                                <span id="fileError${status.count}" style="color:red;font-size:11px;display:none;">
                                                    * File should not exceed 5MB
                                                </span>
                                                <input type="hidden" name="compulsaryFlag" value="${list[4]}">
                                            </td>

                                            <td><input type="text" name="response" readonly class="input-field" value=""></td>
                                            
                                            <td><textarea type="text" name="tremark" readonly class="input-field" maxlength="250"></textarea></td>
                                        </tr>

                                    </c:if>
                                </c:forEach>

                                <tr>
                                    <td colspan="3"><b>Total</b></td>
                                    <td><input type="text" id="totalVendor" readonly name="totalVendor" class="input-field"></td>
                                    <td colspan="2"></td>
                                    <td><input type="text" id="totalTech" readonly name="totalTech" class="input-field"></td>
                                    <td></td>
                                </tr>

                                <tr>
                                    <td colspan="3"><b>Total Percentage</b></td>
                                    <td><input type="text" id="percentageVendor" readonly name="percentageVendor" class="input-field"></td>
                                    <td colspan="2"></td>
                                    <td><input type="text" id="percentageTech" readonly name="percentageTech" class="input-field"></td>
                                    <td></td>
                                </tr>
                            </table>

                            <div class="col-12 p-0">
                                <div class="form-group comment-box">
                                    <label class="control-label">Comment :<span class="text-danger">*</span></label>
                                    <textarea type="text" maxlength="250" class="textarea-field comments" id="comments" name="comments"  required="true"></textarea>
                                </div>
                            </div>                               
                            <div class="form-group">
                                <div style="display: flex;  justify-content: center;">
                                    <button type="submit" class="btn theme-btn" id="submit1">Submit</button>
                                </div>
                            </div>

                        </div>
                        <script>

                            document.addEventListener("DOMContentLoaded", function () {

                                document.querySelectorAll("#table3 tbody tr").forEach(function (row) {

                                    let score = row.querySelector(".score");
                                    let comment = row.querySelector(".comment");

                                    if (!score || !comment) {
                                        return;
                                    }

                                    function handleChange() {
                                        if (score.disabled) {
                                            comment.readOnly = true;
                                            return;
                                        }

                                        if (score.value === "1") {
                                            comment.value = "";
                                            comment.readOnly = true;
                                        } else {
                                            comment.readOnly = false;
                                        }
                                    }

                                    handleChange();
                                    score.addEventListener("change", handleChange);
                                });
                            });

                            </script>
                                                            
                        <script>                           

                            function calculateTotals() {
                                const vendorSelects = document.getElementsByName("score");
                                const techInputs = document.getElementsByName("response");

                                let vendorSum = 0;
                                let techSum = 0;

                                for (let i = 0; i < vendorSelects.length; i++) {
                                    if (vendorSelects[i].value === "1") {
                                        vendorSum++;
                                    }
                                }

                                for (let i = 0; i < techInputs.length; i++) {
                                    const val = techInputs[i].value.trim().toLowerCase();

                                    if (val === "accept") {
                                        techSum += 2;
                                    } else if (val === "partial accept") {
                                        techSum += 1;
                                    }
                                }

                                const totalVendorPossible = vendorSelects.length;
                                const totalTechPossible = techInputs.length * 2;

                                const vendorPercentage = totalVendorPossible > 0
                                    ? ((vendorSum * 100) / totalVendorPossible).toFixed(2)
                                    : "0.00";

                                const techPercentage = totalTechPossible > 0
                                    ? ((techSum * 100) / totalTechPossible).toFixed(2)
                                    : "0.00";

                                document.getElementById("totalVendor").value = vendorSum;
                                document.getElementById("percentageVendor").value = vendorPercentage + "%";

                                document.getElementById("totalTech").value = techSum;
                                document.getElementById("percentageTech").value = techPercentage + "%";
                            }

                             document.addEventListener("DOMContentLoaded", function () {
                                document.querySelectorAll("select[name='score']").forEach(function(select) {
                                    handleScoreChange(select);
                                });

                                calculateTotals();
                            });
                    </script>
                </c:if>
                    
                <script>
                    function handleScoreChange(el) {
                        const select = el || event.target;
                        const row = select.closest("tr");
                        const comment = row ? row.querySelector(".comment") : null;
                        if (comment) {
                            if (select.disabled) {
                                comment.readOnly = true;
                            } else if (select.value === "1") {
                                comment.value = "";
                                comment.readOnly = true;
                            } else {
                                comment.readOnly = false;
                            }
                        }
                        calculateTotals();
                    }

                    document.addEventListener("DOMContentLoaded", function () {
                        document.querySelectorAll("#table3 tbody tr").forEach(function (row) {
                            const score = row.querySelector(".score");
                            if (score) {
                                handleScoreChange(score);
                            }
                        });
                    });
                </script>


                <c:if test="${vendorInformation.technicalFlag=='1' || vendorInformation.technicalFlag=='0' || vendorInformation.technicalFlag=='10'}">

                    <div class="">
                        <table id="table3" class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;">
                            <tr style="background-color:skyblue;">
                                <th style="width: 5%">Sr No.</th>
                                <th style="width: 15%">Criteria</th>
                                <th style="width: 20%">Selection Criteria</th>
                                <th style="width: 10%">Vendor Score</th>
                                <th style="width: 16%">Comment</th>
                                <th style="width: 15%">Attachment</th>
                                <th style="width: 10%">Technical Score</th>
                                <th style="width: 10%">Technical Comment</th>
                            </tr>

                            <c:set var="prevGroup" value="" />
                            <c:set var="prevCategory" value="" />
                            <c:set var="prevSubCategory" value="" />

                            <c:forEach var="list" items="${list}" varStatus="status">
                                <c:if test="${list[1] != prevGroup or list[6] != prevCategory or list[7] != prevSubCategory}">
                                    <tr>
                                        <td colspan="8">
                                            <b style="font-size: 14px;">
                                                Group Name : ${list[1]}
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <c:if test="${list[6] != '0'}">
                                                    Group Category Name : ${list[6]} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </c:if>
                                                <c:if test="${list[7] != '0'}">
                                                    Group Sub Category Name : ${list[7]}
                                                </c:if>
                                            </b>
                                        </td>
                                    </tr>
                                    <c:set var="prevGroup" value="${list[1]}" />
                                    <c:set var="prevCategory" value="${list[6]}" />
                                    <c:set var="prevSubCategory" value="${list[7]}" />
                                </c:if>

                                <c:forEach var="list1" items="${list1}">
                                    <c:if test="${list[2] == list1.criteria && list[3] == list1.selectionCriteria}">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${list[2]}</td>
                                            <td>${list[3]}</td>

                                            <td><input type="text" name="score" readonly class="input-field" value="${list1.score == '1' ? 'Yes' : 'No'}"></td>

                                            <td><textarea name="comment" readonly class="input-field">${list1.comment}</textarea></td>

                                            <td>
                                                <c:if test="${list1.attachment!=null && not empty list1.attachment}">                                        
                                                    <span class="file-wrapper">
                                                        <span class="file-name text-break">${list1.attachment}</span>
                                                        <span class="file-actions">
                                                            <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list1.attachment}&foldName=TECHNICAL&id=${vendorInformation.id}">&nbsp;<span class="fa fa-download"></span></a>
                                                            <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${vendorInformation.id}/TECHNICAL/${list1.attachment}"><span class="fa fa-solid fa-eye"></span></a>					
                                                        </span>
                                                    </span>
                                                </c:if>                                                                                
                                            </td>

                                            <td><input type="text" name="technicalScore" readonly class="input-field" value="${list1.response == '2' ? 'Accept' : (list1.response == '1' ? 'Partial Accept' : (list1.response == '0' ? 'Reject' : ''))}"></td>

                                            <td><textarea type="text" readonly class="input-field" maxlength="250" value="">${list1.technicalComment}</textarea></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>

                            <tr>
                                <td colspan="3"><b>Total</b></td>
                                <td><input type="text" id="totalVendor" readonly name="totalVendor" class="input-field"></td>
                                <td colspan="2"></td>
                                <td><input type="text" id="totalTech" readonly name="totalTech" class="input-field"></td>
                                <td></td>
                            </tr>

                            <tr>
                                <td colspan="3"><b>Total Percentage</b></td>
                                <td><input type="text" id="percentageVendor" readonly name="percentageVendor" class="input-field"></td>
                                <td colspan="2"></td>
                                <td><input type="text" id="percentageTech" readonly name="percentageTech" class="input-field"></td>
                                <td></td>
                            </tr>
                        </table>

                        <script>
                            function calculateTotals() {
                                const vendorInputs = document.getElementsByName("score");
                                const techInputs = document.getElementsByName("technicalScore");

                                let vendorSum = 0;
                                let techSum = 0;

                                for (let i = 0; i < vendorInputs.length; i++) {
                                    const val = vendorInputs[i].value.trim().toLowerCase();

                                    if (val === "yes") {
                                        vendorSum++;
                                    }
                                }

                                for (let i = 0; i < techInputs.length; i++) {
                                    const val = techInputs[i].value.trim().toLowerCase();

                                    if (val === "accept") {
                                        techSum += 2;
                                    } else if (val === "partial accept") {
                                        techSum += 1;
                                    }
                                }

                                const totalVendorPossible = vendorInputs.length;
                                const totalTechPossible = techInputs.length * 2;

                                const vendorPercentage = totalVendorPossible > 0
                                    ? (vendorSum * 100) / totalVendorPossible
                                    : 0;

                                const techPercentage = totalTechPossible > 0
                                    ? (techSum * 100) / totalTechPossible
                                    : 0;

                                document.getElementById("totalVendor").value = vendorSum;
                                document.getElementById("percentageVendor").value =
                                    vendorPercentage.toFixed(2) + "%";

                                document.getElementById("totalTech").value = techSum;
                                document.getElementById("percentageTech").value =
                                    techPercentage.toFixed(2) + "%";
                            }

                            window.addEventListener("load", calculateTotals);
                        </script>
                    </div>
                </c:if>
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
            </form:form>
        </section>
    </main>       
</body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
