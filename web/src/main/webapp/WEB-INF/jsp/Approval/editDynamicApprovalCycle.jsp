<%-- 
    Document   : editDynamicApprovalCycle
    Created on : 9 Jul, 2018, 12:31:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Approval Cycle</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Approval Cycle :</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Approval Cycle</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <!--<button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'approval.htm?act=approvalList'">List</button>-->
                                <span style="color: red;font-size: 12px;">* indicates mandatory field.</span>

                                <form:form class="form-horizontal" method="post"
                                           commandName="dynamicApprovalSettingSupport" action="dynamicApprovalSetting.htm?act=submitDynamicApproval"  >
                                    <form:hidden path="id"></form:hidden>

                                      
                                    <div class="form-group">

                                        
                                        <div class="col-sm-6">
                                            <label>Department Name:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="designationMasterId" class="form-control" >
                                                <form:option value="" label="-- Select --"/>
                                                <form:options items="${designationList}" />
                                            </form:select>
                                            <span id="leaveTypeMasterError" style="color: red;"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-sm-6">
                                            <label>Approver Name :<span style="color: red;font-size: 12px;">*</span></label>
                                            <!--                                            <div>
                                                                                            <input type="text" name="policyId1" id="policyId1" class="form-control"/>
                                                                                            <errors id="policyerror" cssClass="errorDiv"></errors>
                                            
                                                                                        </div>-->
                                            <form:input path="approverId" class="form-control"></form:input>
                                            <form:errors path="approverId" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Email Notification :<span style="color: red;font-size: 12px;"></span></label>
                                            <form:input path="emailUserId" class="form-control"></form:input>
                                            <form:errors path="emailUserId" cssClass="errorDiv"></form:errors>
                                                <!--                                                <div>
                                                                                                                                                        <input type="text" name="policyId2" id="policyId2" class="form-control"/>
                                                                                                                                                        <errors id="policyerror" cssClass="errorDiv"></errors>
                                                
                                                                                                </div>-->
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <div class="table-responsive">
                                                    <table id="policyTable" class="table table-bordered table-striped table-hover" style="margin-top: 10px" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Approver Name</th>
                                                            <th style="text-align: center; vertical-align: middle">Action</th>
                                                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                    <c:forEach var="list" items="${approverList}">
                                                        <tr>

                                                            <td style="text-align: center">
                                                                ${list[1]}
                                                            </td>

                                                            <td style="text-align: center">
                                                                <button type="button"  onclick="deleteApproverClick(${list[0]},${dynamicApprovalSettingSupport.id})"/>Delete
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="table-responsive">
                                                <table id="policyTable" class="table table-bordered table-striped table-hover" style="margin-top: 10px" align="Center"  >
                                                    <tr>
                                                        <th style="text-align: center; vertical-align: middle">Email Notification Name</th>
                                                        <th style="text-align: center; vertical-align: middle">Action</th>
                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                                    <c:forEach var="list" items="${emailList}">
                                                        <tr>

                                                            <td style="text-align: center">
                                                                ${list[1]}
                                                            </td>

                                                            <td style="text-align: center">
                                                                <button type="button" onclick="deleteEmilClick(${list[0]},${dynamicApprovalSettingSupport.id})"/>Delete
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="form-group">


                                    </div>


                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"   title="" value="SUBMIT">
                                        </div>

                                    </div>

                                </div>

                            </form:form>
                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
        </section>
    </div><!-- /.content-wrapper -->
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {


            jQuery("#approverId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                searchingText: "Searching ... .. ."
                        //            prePopulate: ${preList1}
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {

            jQuery("#emailUserId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                searchingText: "Searching ... .. ."
            });
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        function deleteApproverClick(ApproverId, id) {
            window.location = 'dynamicApprovalSetting.htm?act=deleteApproverClick&id=' + id + '&ApproverId=' + ApproverId;
        }
        function deleteEmilClick(emailID, id) {
            window.location = 'dynamicApprovalSetting.htm?act=deleteEmilClick&id=' + id + '&emailID=' + emailID;
        }
    </script>
    <script>
        function getProjectName(moduleID) {

            $("#projectDiv1 label").remove();
            $("#projectDiv1 select").remove();
            $("#projectDiv label").remove();
            $("#projectDiv select").remove();
            $.ajax({
                data: 'moduleID=' + moduleID,
                url: "dynamicApprovalSetting.htm?act=selectProjectName",
                success: function (content) {
//                    alert(content);
                    var obj = JSON.parse(content);
                    var count = Object.keys(obj['projectNameKey']).length;
                    if (count > 0) {

                        var data = "<label> Project Name: <span style = 'color: red;font-size: 12px;'>*</span></label>" +
                                "<select class = 'form-control' id = 'projectName' name = 'projectName' ><option>-- Select --</option>";
                        var desigJSON = obj['projectNameKey'];
                        var desigJSONKey = Object.keys(obj['projectNameKey']);
                        for (i = 0; i < count; i++) {
                            data += "<option value=" + desigJSONKey[i] + ">" + desigJSON[desigJSONKey[i]] + "</option>";
                        }
                        data += '</select>';
                        $(data).appendTo('#projectDiv');
                    }
                }
            });
        }
    </script>

</html>

