<%-- 
    Document   : VendorHrCriteria
    Created on : 29 Oct, 2025, 03:00:57 PM
    Author     : fnp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>

    <head>
        <title>Vendor HR Criteria</title>       
    </head>

    <body>
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
        
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            textarea {
                width: 100%;
                height: 60px;
                resize: vertical;
            }
            input[type="file"] {
                width: 100%;
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
        <style>
            input[type="text"], textarea {
                text-transform: uppercase;
            }
        </style>
        <style>
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
        </style>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
            document.querySelectorAll("input:not([type='hidden']):not([type='checkbox']):not([type='radio']), textarea").forEach(function (el) {
            el.addEventListener("input", function () {
            this.value = this.value.toUpperCase();
            });
            });
            });</script>

        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">

            <section id="printSection" class="main-content">
                <form:form action="vendorInformation.htm?act=hrCriteriaSubmit"  enctype="multipart/form-data" method="post" commandName="vendorInformation"
                           name='form' class="form-horizontal" role="form">                    
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Vendor HR Criteria</h5>
                        </div>
                        <div class="cta d-flex align-items-center" style="gap:15px;">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>                                            
                            <!--<button type="submit" class="btn theme-btn">Save & Continue</button>-->
                            <c:if test="${vendorInformation3.status1 != 3 && vendorInformation3.status1 != 4 && vendorInformation3.status1 != 5}">
                                <button type="submit" id="vendhrcri1" class="btn theme-btn" formaction="vendorInformation.htm?act=vendorHrShow" onclick="return Validate()">Next</button>                                
                            </c:if>
                        </div>
                    </div>
                    <hr>
                    

                    <input type="hidden" id="VInformationId" name="VInformationId" value="${VInformationId}"/>


                    <div class="rounded-4 mt-4">
               
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> For any queries or assistance regarding the HR Criteria, please contact our Help Line.<br>
                                <strong>Help Line:</strong> +91 8596745263 <br>
                                <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                                <span style="color:red; font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                            </div>
                        </div>
                        <br>
                        <table class="table table-bordered custom-table mb-3" style="width:100%; table-layout:fixed; border-collapse:collapse;"> <!-- Set maximum width and border -->

                        <thead>
                            <tr>
                                <td colspan="4" style=" background-color: skyblue; text-align: center;"><strong>TYPES OF VENDOR</strong></td>
                            </tr>
                        </thead>
                        <tbody>
                                <tr>                                    
                                    <th>Group Name</th>
                                    <th>Group Category Name</th>
                                    <th colspan="2">Group Sub Category Name</th>
                                </tr>
                            <c:forEach var="list" items="${list}" varStatus="status">
                                <tr>
                                    <input type="hidden" class="input-field" id="groupId" name="groupId" value="${list[2]}<" />
                                    <td>${list[2]}</td>
                                    <td>${list[3]}</td>
                                    <td colspan="2">${list[4]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        </table><br>
                        
                        <table class="table table-bordered custom-table mb-3" style="width:100%;  ">

                            <thead>
                                <tr>
                                    <th colspan="6" style=" background-color: skyblue; text-align: center;">
                                        CRITERIA  DETAILS
                                    </th>
                                </tr>


                                <tr>
                                    <th style="width: 5%;">Sr.No</th>
                                    <th style="width: 23%;">Criteria</th>
                                    <th style="width: 22%;">Selection Criteria</th>
                                    <th style="width: 15%;">Score</th>
                                    <th style="width: 15%;">Comment</th>
                                    <th style="width: 20%;">Attachment</th>
                                </tr>



                            </thead>

                            <c:set var="groupname" value=""/>


                            <c:choose>
                                <c:when test="${!empty list66}">
                                    <c:set var="prevGroup" value="" />
                                    <c:set var="prevCategory" value="" />
                                    <c:set var="prevSubCategory" value="" />

                                    <c:forEach var="list" items="${list6}" varStatus="status">

                                        <c:if test="${list[1] ne prevGroup or list[6] ne prevCategory or list[7] ne prevSubCategory}">
                                            <tr>
                                                <td colspan="6">
                                                    <b style="font-size: 14px;">
                                                        Group Name : ${list[1]} 
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <c:if test="${list[6] ne '0'}">
                                                            Group Category Name : ${list[6]} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                        <c:if test="${list[7] ne '0'}">
                                                            Group Sub Category Name : ${list[7]}
                                                        </c:if>
                                                    </b>
                                                </td>
                                            </tr>

                                            <!-- Update values so it won’t repeat -->
                                            <c:set var="prevGroup" value="${list[1]}" />
                                            <c:set var="prevCategory" value="${list[6]}" />
                                            <c:set var="prevSubCategory" value="${list[7]}" />
                                        </c:if>    
                                        <tr>
                                            <td>${status.count}</td>
                                            <td class="terms-details">${list[2]} <c:if test="${list[4]=='Yes'}"><span class="text-danger">*</span></c:if></td>
                                            <td class="terms-details">${list[3]}</td>
                                        <input type="hidden" name="vendorCriteriaMasterId" value="${list[8]}">
                                        <input type="hidden" name="criteriaName" value='${list[2]}'  >
                                        <input type="hidden" name="criteriaDescription" value='${list[3]}'  >

                                        <c:forEach var="list66" items="${list66}" varStatus="status">
                                            <input type="hidden" value="${list66.id}"  name="hrId" id="hrId">
                                            <c:if test="${list[8]==list66.vendorCriteriaMasterId && list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">
                                                <td>
                                                    <select name="score" id="score${status.count}" class="select-input" onchange="response();" required="required">
                                                        <c:choose>
                                                            <c:when test="${list66.score=='0'}">
                                                                <option value="">--Select--</option>
                                                                <option value="1">Yes</option>
                                                                <option selected="true" value="0">No</option>
                                                            </c:when>
                                                            <c:when test="${list66.score=='1'}">
                                                                <option value="">--Select--</option>
                                                                <option selected="true" value="1">Yes</option>
                                                                <option value="0">No</option>
                                                            </c:when>

                                                            <c:otherwise>
                                                                <option value="">--Select--</option>
                                                                <option value="1">Yes</option>
                                                                <option value="0">No</option>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </select>
                                                </td>
                                                <td><textarea name="comment" class="input-field" maxlength="250" required="required" readonly>${list66.comment}</textarea></td>
                                                <c:if test="${list[4]=='Yes'}">
                                                    <td>
                                                        <c:if test="${list66.attachement!=null && not empty list66.attachement}">                                        
                                                            <span class="file-wrapper">
                                                                <span class="file-name text-break">${list66.attachement}</span>
                                                                <span class="file-actions">
                                                                    <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list66.attachement}&foldName=HR&id=${VInformationId}">&nbsp;<span class="fa fa-download"></span></a>
                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${VInformationId}/HR/${list66.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                </span>
                                                            </span>
                                                        </c:if>                                                        
                                                        <input type="hidden" class="input-field" name="attachment1" value="${list66.attachement}">
                                                        <input   type="file"  class="input-field"   name="attachment" id="file${status.count}"  onchange="validateFileSize(this, 'fileError${status.count}');"  <c:if test="${empty list66.attachement}">required="true"</c:if>>
                                                        <span id="fileError${status.count}" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                    </td>
                                                </c:if>
                                                <c:if test="${list[4]=='No'}">
                                                    <td>                                                        
                                                        <c:if test="${list66.attachement!=null && not empty list66.attachement}">                                        
                                                            <span class="file-wrapper">
                                                                <span class="file-name text-break">${list66.attachement}</span>
                                                                <span class="file-actions">
                                                                    <a class="fw-600 text-break gradient-text" href="vendorInformation.htm?act=downloadCriteriaFileAprrove&amp;fileName=${list66.attachement}&foldName=HR&id=${VInformationId}">&nbsp;<span class="fa fa-download"></span></a>
                                                                    <a target="#" class="text-break gradient-text fw-600" href="StorageYard/UserProfile/Vendor/${VInformationId}/HR/${list66.attachement}"><span class="fa fa-solid fa-eye"></span></a>					
                                                                </span>
                                                            </span>
                                                        </c:if>
                                                        <input type="hidden" class="input-field" name="attachment1" value="${list66.attachement}">
                                                        <input type="file"  class="input-field"   name="attachment"   id="file${status.count}" style="display: none;" onchange="validateFileSize(this, 'fileError${status.count}');"  >
                                                        <span id="fileError${status.count}" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                    </td>
                                                </c:if>
                                            </c:if>

                                        </c:forEach>


                                        <input type="hidden" name="compulsaryFlag" value="${list[4]}">

                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="prevGroup" value="" />
                                    <c:set var="prevCategory" value="" />
                                    <c:set var="prevSubCategory" value="" />

                                    <c:forEach var="list" items="${list6}" varStatus="status">

                                        <c:if test="${list[1] ne prevGroup or list[6] ne prevCategory or list[7] ne prevSubCategory}">
                                            <tr>
                                                <td colspan="6">
                                                    <b style="font-size: 14px;">
                                                        Group Name : ${list[1]} 
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <c:if test="${list[6] ne '0'}">
                                                            Group Category Name : ${list[6]} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        </c:if>
                                                        <c:if test="${list[7] ne '0'}">
                                                            Group Sub Category Name : ${list[7]}
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
                                            <td class="terms-details">${list[2]} <c:if test="${list[4]=='Yes'}"><span class="text-danger">*</span></c:if></td>
                                            <td class="terms-details">${list[3]}</td>

                                        <input type="hidden" name="vendorCriteriaMasterId" value="${list[8]}"  >
                                        <input type="hidden" name="criteriaName" value='${list[2]}'  >
                                        <input type="hidden" name="criteriaDescription" value='${list[3]}'  >

                                        <td>
                                            <select name="score" id="score${status.count}" class="select-input" onchange="response();" required="required">
                                                <option value="">--Select--</option>
                                                <option value="1">Yes</option>
                                                <option value="0">No</option>
                                            </select>
                                        </td>

                                        <td><textarea name="comment" class="textarea-field" maxlength="250" required="required" readonly></textarea></td>
                                        <td>

                                            <c:if test="${list[4]=='Yes'}">
                                                <input type="file" class="input-field"  name="attachment" id="file${status.count}" onchange="validateFileSize(this, 'fileError${status.count}');" required="required">

                                            </c:if>
                                            <c:if test="${list[4]=='No'}">
                                                <input type="file" class="input-field" name="attachment" id="file${status.count}" style="display: none;" onchange="validateFileSize(this, 'fileError${status.count}');" >

                                            </c:if>

                                            <span id="fileError${status.count}" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                        </td>

                                        <input type="hidden" name="compulsaryFlag" value="${list[4]}"  >

                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            <tr>
                                <td colspan="3">Total</td>
                                <td><input type="text" id="total" readonly="true" name="total" class="input-field"></td>
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td colspan="3">Total Percentage</td>
                                <td><div class="input-percent"><input type="text" id="percentage" readonly="true" name="percentage" class="input-field"></div></td>
                                <td colspan="2"></td>
                            </tr>

                        </table>

                     
                                    <script>
                                                function validateFileSize(input, errorId) {
                                                const file = input.files[0]; // Get the selected file
                                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                                        if (file && file.size > maxSize) {
                                                document.getElementById(errorId).style.display = 'block';
                                                        input.value = ''; // Clear the file input
                                                } else {
                                                document.getElementById(errorId).style.display = 'none';
                                                }
                                                }
                                    </script>
                                    <script>
                                        function response() {

                                        var l = document.form.criteriaName ? document.form.criteriaName.length : 0;
                                                var i = 1;
                                                var sum = 0;
                                                var total = l * 2;
                                                // ✅ NEW CODE: Handle comment readonly/required based on Yes/No
                                                var selects = document.querySelectorAll('select[name="score"]');
                                                selects.forEach(function(sel) {
                                                var textarea = sel.closest('td').nextElementSibling.querySelector('textarea');
                                                        if (sel.value === "1") { // Yes selected
                                                textarea.readOnly = true;
                                                        textarea.required = false;
                                                        textarea.value = ""; // clear any text if present
                                                } else if (sel.value === "0") { // No selected
                                                textarea.readOnly = false;
                                                        textarea.required = true;
                                                } else { // nothing selected
                                                textarea.readOnly = false;
                                                        textarea.required = false;
                                                }
                                                });
                                                // ✅ EXISTING LOGIC (unchanged)
                                                if (l == null) {
                                        var accept = parseFloat(document.getElementById("score1").value) || 0;
                                                sum += accept;
                                                var totals = 2;
                                                var total1 = (sum * 100) / totals;
                                                document.getElementById("total").value = sum;
                                                document.getElementById("percentage").value = total1.toFixed(2) * 2;
                                        } else {
                                        while (i <= l) {
                                        var accept = parseFloat(document.getElementById("score" + i).value) || 0;
                                                sum += accept;
                                                i++;
                                        }
                                        var total1 = (sum * 100) / total;
                                                console.log(total);
                                                document.getElementById("total").value = sum;
                                                document.getElementById("percentage").value = total1.toFixed(2) * 2;
                                        }
                                        }
                                           window.addEventListener("load", response);
                                    </script>

                          </div>
                            <div class="form-group">
                                <div style="display: flex; gap:15px; justify-content: center;">
                                    <button type="submit" class="btn theme-btn">Save & Continue</button>
                                    <%--<c:if test="${vendorInformation3.status1 != 3 && vendorInformation3.status1 != 4 && vendorInformation3.status1 != 5}">
                                        <button type="submit" id="vendhrcri" class="btn theme-btn" formaction="vendorInformation.htm?act=vendorHrShow" onclick="return Validate()">Next</button>                                        
                                    </c:if>--%>
                                </div>
                            </div>
                            
                            
                </form:form>
            </section>
        </main>
        <script>
document.getElementById("vendhrcri1").addEventListener('click', function () {

    const requiredFields = document.querySelectorAll('input[required], textarea[required], select[required]');
    
    requiredFields.forEach(function(field) {
        field.removeAttribute('required');
    });

});
</script>
       
    </body>
    
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>


