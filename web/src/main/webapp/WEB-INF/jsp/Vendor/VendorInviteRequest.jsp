<%-- 
    Document   : VendorInviteRequest
    Created on : 21 Jan, 2025, 1:10:05 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Vendor Recommendation Request</title>


    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">New Vendor Recommendation Request</h4>
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
                                <form:form action="vendorInvitation.htm?act=vendorRequestApproveSubmit" method="post" commandName="vendorRequestDetails"
                                           class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Company Name:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="company" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                       
                                            <div class="col-sm-2">
                                                <label class="control-label">Contact Name:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-3">                                            
                                                <form:input path="contactaName" class="form-control"   maxlength="30" required="required"/>
                                            </div>
                                        
                                    </div>


                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Email ID :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="email" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact No:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:input path="phoneNo" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Address :<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:textarea path="address" class="form-control"   maxlength="30" ></form:textarea>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Justification for Recommendation :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <form:textarea path="description" class="form-control"   maxlength="30" required="required"></form:textarea>
                                        </div>
                                    </div>
                                        
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
                                                                        <input type="checkbox" name="groupIdd"  value="${item.id}" id="checkbox-${item.id}" onclick="toggleCategoryList(${item.id})">
                                                                        <span style="font-size: 13px; margin-left: 10px;">${item.groupName}</span>
                                                                    </div>
                                                                </td>
                                                                <td style="border: 1px solid #ddd; padding: 8px;">
                                                                    <div id="category-list-container-${item.id}" style="display: none; padding-left: 20px;">
                                                                        <c:forEach var="subItem" items="${list1}" varStatus="subStatus">
                                                                            <c:if test="${subItem.groupMasterId == item.id}">
                                                                                <div>
                                                                                    <input type="checkbox" id="checkboxx-${subItem.id}" name="groupCategoryId" value="${subItem.id}" onclick="SubtoggleCategoryList(${subItem.id})" class="category-option">
                                                                                    <span for="category-${subItem.id}" style="font-size: 13px;">
                                                                                        ${subItem.groupCatogryName}
                                                                                    </span>
                                                                                </div>

                                                                                <!-- Now checking the list of subsubitems correctly -->
                                                                                <div id="category-list-containerrr-${subItem.id}" style="display: none; padding-left: 20px; border-left: 2px solid #ddd; padding-top: 10px; margin-left: 20px;">
                                                                                    <c:forEach var="subsubitem" items="${list2}" varStatus="subsubStatus">
                                                                                        <c:if test="${subsubitem.groupCategoryId == subItem.id}">
                                                                                            <div style="border: 1px solid #ddd; padding: 8px; margin-bottom: 8px;">
                                                                                                <input type="checkbox" name="groupSubcategory" value="${subsubitem.id}" class="category-option">
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


                                                <script>
                                                    // Function to toggle the visibility of the category list based on checkbox status
                                                    function toggleCategoryList(groupId) {
                                                        var checkbox = document.getElementById('checkbox-' + groupId);
                                                        var categoryListContainer = document.getElementById('category-list-container-' + groupId);

                                                        // Toggle visibility
                                                        if (checkbox.checked) {
                                                            categoryListContainer.style.display = 'block';  // Show the categories
                                                        } else {
                                                            categoryListContainer.style.display = 'none';  // Hide the categories
                                                        }
                                                    }

                                                    function SubtoggleCategoryList(groupId) {
                                                        var checkbox = document.getElementById('checkboxx-' + groupId);
                                                        var categoryListContainer = document.getElementById('category-list-containerrr-' + groupId);

                                                        // Toggle visibility
                                                        if (checkbox.checked) {
                                                            categoryListContainer.style.display = 'block';  // Show the categories
                                                        } else {
                                                            categoryListContainer.style.display = 'none';  // Hide the categories
                                                        }
                                                    }

                                                </script>

                                            </div>

                                    
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Approval Matrix :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">                                            

                                            <select class="form-control" id="approvalMatrix" name="approval">
                                                <option value="">--Select--</option>
                                                <c:forEach var="vendorApprovalsetting" items="${vendorApprovalsetting}">
                                                    <option value="${vendorApprovalsetting.id}">${vendorApprovalsetting.approvalName}</option>
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
</html>

