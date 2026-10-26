<%-- 
    Document   : RequestedVendorInvitation
    Created on : 25 Jan, 2025, 12:13:31 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requested Vendor Invitation</title>


    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">Requested Vendor Invitation</h3>
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

                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="vendorInvitation.htm?act=submitVendorInvitation" method="post" commandName="vendorRequestDetails"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="venderRequestId" id="venderRequestId" value="${vendorRequestDetails.id}">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Company Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input class="form-control" id="companyName" readonly="true" name="companyName" value="${vendorRequestDetails.company}" maxlength="30" required="required">

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Email ID :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            
                                            <input class="form-control" id="vendorEmailId" readonly="true" name="vendorEmailId" value="${vendorRequestDetails.email}"  maxlength="30" required="required">

                                        </div>
                                    </div>
                                    <!--                                           <div class="form-group">
                                                                            <div class="col-sm-3">
                                                                                <label class="control-label">Bp Group :<span style="color: red;font-size: 12px;">*</span></label>
                                                                            </div>
                                                                            <div class="col-sm-3">                                            
                                    
                                                                                <select class="form-control" name="bpGroup" id="bpGroup" required="true">
                                                                                    <option value="">--Select--</option>
                                    <c:forEach var="list3" items="${list3}">
                                        <option value="${list3.bpGroupName}  - ${list3.discription}">${list3.bpGroupName}  -  ${list3.discription}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>-->
                                    <div class="checkbox-container">
                                        <div class="checkbox-label">
                                            <!-- Checkbox Section 1 (Group options) -->
                                            <!--                                            <div class="checkbox-container">-->
                                            <div class="nested-options show" id="group-options">


                                                <table style="width: 100%; margin-bottom: 15px; border-collapse: collapse;">
                                                    <thead>
                                                        <tr>
                                                            <th style="border: 2px solid #000; padding: 10px; background-color: #f2f2f2;">Group Name</th>
                                                            <th style="border: 2px solid #000; padding: 10px; background-color: #f2f2f2;">Categories</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="item" items="${list}" varStatus="status">

                                                       
                                                            <!-- Display Group Row -->
                                                            <tr>
                                                                <td style="border: 1px solid #ddd; padding: 8px;">
                                                                    <!-- Group name from the item -->
                                                                    <div style="display: flex; align-items: center;">
                                                                        <input type="checkbox" name="groupIdd"  value="${item.id}" id="checkbox-${item.id}" onclick="toggleCategoryList(${item.id})"  <c:forEach var="list5" items="${list5}"><c:if test="${list5[2]==item.groupName}">checked="true"</c:if></c:forEach> >
                                                                        <span style="font-size: 13px; margin-left: 10px;">${item.groupName}</span>
                                                                    </div>
                                                                </td>
                                                                <td style="border: 1px solid #ddd; padding: 8px;">
                                                                    <div id="category-list-container-${item.id}" style="display: none; padding-left: 20px;">
                                                                        <c:forEach var="subItem" items="${list1}" varStatus="subStatus">
                                                                            <c:if test="${subItem.groupMasterId == item.id}">
                                                                                <div>
                                                                                    <input type="checkbox" id="checkboxx-${subItem.id}" name="groupCategoryId" value="${subItem.id}" onclick="SubtoggleCategoryList(${subItem.id})" class="category-option"  <c:forEach var="list5" items="${list5}"><c:if test="${list5[3]==subItem.groupCatogryName}">checked="true"</c:if></c:forEach>>
                                                                                    <span for="category-${subItem.id}" style="font-size: 13px;">
                                                                                        ${subItem.groupCatogryName}
                                                                                    </span>
                                                                                </div>

                                                                                <!-- Now checking the list of subsubitems correctly -->
                                                                                <div id="category-list-containerrr-${subItem.id}" style="display: none; padding-left: 20px; border-left: 2px solid #ddd; padding-top: 10px; margin-left: 20px;">
                                                                                    <c:forEach var="subsubitem" items="${list2}" varStatus="subsubStatus">
                                                                                        <c:if test="${subsubitem.groupCategoryId == subItem.id}">
                                                                                            <div style="border: 1px solid #ddd; padding: 8px; margin-bottom: 8px;">
                                                                                                <input type="checkbox" name="groupSubcategory" value="${subsubitem.id}" class="category-option"  <c:forEach var="list5" items="${list5}"><c:if test="${list5[4]==subsubitem.subCategoryName}">checked="true"</c:if></c:forEach>>
                                                                                                <span for="category-${subsubitem.id}" style="font-size: 13px;">
                                                                                                    ${subsubitem.subCategoryName}
                                                                                                </span>
                                                                                            </div>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </div>

                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>





                                            </div>




                                            <br>

                                            <div class="form-group row">
                                                <div class="col-sm-2">
                                                    <label for="financialApproval">Financial Approval</label>
                                                </div>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="financialApproval" name="financialApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                        <option value="">--SELECT--</option>
                                                        <c:forEach var="financialList" items="${financialList}">
                                                            <option value="${financialList}">${financialList}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-2">
                                                    <label for="technicalApproval">Technical Approval</label>
                                                </div>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="technicalApproval" name="technicalApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                        <option value="">--SELECT--</option>
                                                        <c:forEach var="technicalList" items="${technicalList}">
                                                            <option value="${technicalList}">${technicalList}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-sm-2">
                                                    <label for="hrApproval">HR Approval</label>
                                                </div>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="hrApproval" name="hrApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                        <option value="">--SELECT--</option>
                                                        <c:forEach var="hrList" items="${hrList}">
                                                            <option value="${hrList}">${hrList}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-2">
                                                    <label for="safetyApproval">Safety Approval</label>
                                                </div>
                                                <div class="col-sm-4">
                                                    <select class="form-control" id="safetyApproval" name="safetyApproval" style="font-size: 12px; padding: 5px;" required="required">
                                                        <option value="">--SELECT--</option>
                                                        <c:forEach var="safetyList" items="${safetyList}">
                                                            <option value="${safetyList}">${safetyList}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <input type="submit" class="btn btn-primary" style="width: 100px; margin-top: 30px;"  title="" value="SUBMIT">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
    </div>
</section><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
<script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
<script>
                                                                                     // Function to toggle the visibility of the category list based on checkbox status
                                                                                     function toggleCategoryList(groupId) {
                                                                                         var checkbox = document.getElementById('checkbox-' + groupId);
                                                                                         var categoryListContainer = document.getElementById('category-list-container-' + groupId);

                                                                                         if (checkbox && categoryListContainer) {
                                                                                             categoryListContainer.style.display = checkbox.checked ? 'block' : 'none';
                                                                                         }
                                                                                     }

                                                                                     function SubtoggleCategoryList(groupId) {
                                                                                         var checkbox = document.getElementById('checkboxx-' + groupId);
                                                                                         var categoryListContainer = document.getElementById('category-list-containerrr-' + groupId);

                                                                                         if (checkbox && categoryListContainer) {
                                                                                             categoryListContainer.style.display = checkbox.checked ? 'block' : 'none';
                                                                                         }
                                                                                     }

                                                                                     // Function to initialize checkboxes on page load
                                                                                     function initializeCheckboxes() {
                                                                                         var checkboxes = document.querySelectorAll('[id^="checkbox-"]');
                                                                                         for (var i = 0; i < checkboxes.length; i++) {
                                                                                             var checkbox = checkboxes[i];
                                                                                             var groupId = checkbox.id.replace('checkbox-', '');
                                                                                             toggleCategoryList(groupId); // Call function on load
                                                                                             checkbox.addEventListener('click', function () {
                                                                                                 toggleCategoryList(this.id.replace('checkbox-', ''));
                                                                                             });
                                                                                         }

                                                                                         var subCheckboxes = document.querySelectorAll('[id^="checkboxx-"]');
                                                                                         for (var j = 0; j < subCheckboxes.length; j++) {
                                                                                             var subCheckbox = subCheckboxes[j];
                                                                                             var subGroupId = subCheckbox.id.replace('checkboxx-', '');
                                                                                             SubtoggleCategoryList(subGroupId); // Call function on load
                                                                                             subCheckbox.addEventListener('click', function () {
                                                                                                 SubtoggleCategoryList(this.id.replace('checkboxx-', ''));
                                                                                             });
                                                                                         }
                                                                                     }

                                                                                     // Run when the DOM is fully loaded
                                                                                     document.addEventListener("DOMContentLoaded", initializeCheckboxes);
</script>

</html>

