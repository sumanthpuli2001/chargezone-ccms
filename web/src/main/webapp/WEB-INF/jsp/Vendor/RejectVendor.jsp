<%-- 
    Document   : 
    Created on : Jun 11, 2020, 2:38:52 PM
    Author     : Samir Tailor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Vendor List</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'vendorInformation.htm?act=activevendorviewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="approvalSetting.htm?act=deleteapprovalSetting" method="post" commandName="vendorInformation1"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div id="exTab" class="">	
                                <ul class="nav nav-pills nav-tabs ">
                                    <li><a href="vendorInformation.htm?act=newVendor"><i class="fa fa-circle-o"></i>New Vendor</a></li>
                                    <li><a href="vendorInformation.htm?act=inprogressVendor"><i class="fa fa-circle-o"></i>In Progress</a></li>
                                    <li><a href="vendorInformation.htm?act=firstLevelnApprove"><i class="fa fa-circle-o"></i>1 <sup>st</sup> Level Approve</a></li>
                                    <li><a href="vendorInformation.htm?act=finacialApproval"><i class="fa fa-circle-o"></i>Finacial Approval</a></li>
                                    <li><a href="vendorInformation.htm?act=technicalApproval"><i class="fa fa-circle-o"></i>Technical Approval</a></li>
                                    <li><a href="vendorInformation.htm?act=hrApproval"><i class="fa fa-circle-o"></i>HR Approval</a></li>

                                    <li><a href="vendorInformation.htm?act=safetyApproval"><i class="fa fa-circle-o"></i>Safety Approval</a></li>
                                    <!--<li><a href="vendorInformation.htm?act=secondLevelApprove"><i class="fa fa-circle-o"></i>2<sup>nd</sup> Level Approve</a></li>-->
                                    <li><a href="vendorInformation.htm?act=activeVendor"><i class="fa fa-circle-o"></i>Active Vendor</a></li>
                                    <li class="active"><a href="vendorInformation.htm?act=rejectVendor"><i class="fa fa-circle-o"></i>Reject Vendor</a></li>
                                    <li><a href="vendorInformation.htm?act=allVendor"><i class="fa fa-circle-o"></i>All Vendor</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">
                                        <input type="button" class="btn btn-primary" style="width: 100px; margin-left: 156vh; margin-top: -5vh;" onclick="history.back();" title="" value="Back" >

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty vendorInformation1}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr.No.</th>
                                                                    <th>Email Id</th>
                                                                    <th>Company Name</th>
                                                                    <th>Contact Name</th>
                                                                        <c:if test="${fn:contains(sessionScope.wright[1],'U')}">
                                                                        <th>View</th>
                                                                        </c:if>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${vendorInformation1}" varStatus="status">
                                                                    <tr>
                                                                        <td> ${status.count}</td>
                                                                        <td>${list.vendorEmailId}</td>
                                                                        <td>${list.companyName}</td>
                                                                        <td>${list.contactName}</td>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" id="loginName${status.count}" value="${list.id}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${status.count});">
                                                                                    &nbsp;View
                                                                                </button>

                                                                            </div>
                                                                        </td>

                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

