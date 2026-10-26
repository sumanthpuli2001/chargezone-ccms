<%-- 
    Document   : VendorRequestApproval
    Created on : 22 Jan, 2025, 10:51:15 AM
    Author     : bulwarks-2
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Request Approval</title>


    </head>
    <script>
        function viewClick(id) {

            window.location = 'vendorInvitation.htm?act=vendorRequestApprovalSubmit&id=' + id;
        }
        function viewClick1(id) {

            window.location = 'vendorInvitation.htm?act=vendorRequestRecycle&id=' + id ;
        }
        function viewClick2(id) {

            window.location = 'vendorInvitation.htm?act=vendorRequestReject&id=' + id ;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Vendor Request Approval</h4>
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

                                <form:form action="" method="post" commandName="" class="form-horizontal" role="form">


                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="col-md-12 col-sm-12">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty vendorApprovalsetting}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Contact Name</th>
                                                                    <th>Email</th>
                                                                    <th>Company</th>
                                                                    <th>User</th>
                                                                    <th>Justification</th>
                                                                    <th>Action</th>

                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${vendorApprovalsetting}" varStatus="status">
                                                                    <tr>


                                                                        <td >${list[4]}</td>

                                                                        <td >${list[5]}</td>
                                                                        <td >${list[6]}</td>
                                                                        <td >${list[2]}</td>
                                                                        <td >${list[8]}</td>


                                                                        <td >
                                                                            <div class="btn-group" style="display: flex; flex-direction:row; gap:5px;">
                                                                                <button type="button" class="btn btn-default dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list[7]});">
                                                                                    &nbsp;Approve
                                                                                </button>

                                                                                <button type="button" class="btn btn-default dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick1(${list[7]});">
                                                                                    &nbsp;Hold
                                                                                </button>
                                                                                <button type="button" class="btn btn-default dropdown-toggle"   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick2(${list[7]});">
                                                                                    &nbsp;Reject
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


