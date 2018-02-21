<%-- 
    Document   : CreateApproval
    Created on : 17 Feb, 2018, 4:39:07 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Vacancy Detail List Report</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Approval:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Approval</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 12px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="employeeMaster" action="approval.htm?act=approvalSubmit">
                                    <form:hidden path="id"></form:hidden>
                                        <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                            <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                            <form:input path="employeeName" class="form-control"></form:input>
                                            <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label"> * Approval Setting Name:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                            <div class="col-sm-6">
                                            <%--<form:input path="name" class="form-control"  placeholder="Name"  maxlength="20"/>--%>
                                            <%--<form:errors path="name" cssClass="errorDiv"/>--%>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label"> * Add User :<span style="color: red;font-size: 12px;">*</span> </label>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <tr>
                                                        <th style="text-align: center;width: 6%;">Sr No.</th>
                                                        <th style="text-align: center">User Name <span style="color: red;font-size: 12px;">*</span></th>
                                                        <th style="text-align: center">Level <span style="color: red;font-size: 12px;">*</span></th>
                                                        <th style="text-align: center">Add New<span style="color: red;font-size: 12px;">*</span></th>
                                                    <input type="hidden" name="userCount" id="userCount" value="1">
                                                    </tr>
                                                    <tr>
                                                    <input type="hidden" name="countId" id="countId" value="1">
                                                    <td style="text-align: center">1</td>
                                                    <td>
                                                        <%--<form:input path="employeeName" class="form-control"></form:input>--%>
                                                            <span id="userNameError1" style="color: red;"></span>
                                                        </td>
                                                        <td><input type="Text" name="fromLocation1" id="leave" value="1" class="form-control">
                                                            <span id="leaveError1" style="color: red;"></span>
                                                        </td>
                                                        <td style="text-align: center">
                                                            <span style='margin-top: 5px;' class="col-sm-1">
                                                                <input type="button" value="+" id="addUser" />
                                                            </span>
                                                        </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>
                                            <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                        <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                    </div>-->
                                        </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        jQuery.noConflict();
        alert(${list});
        jQuery(document).ready(function () {
            jQuery("#employeeName").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });

    </script>

</html>
