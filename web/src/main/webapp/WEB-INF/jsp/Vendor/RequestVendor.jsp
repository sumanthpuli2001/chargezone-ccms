<%-- 
    Document   : RequestVendor
    Created on : 25 Jan, 2025, 12:00:30 PM
    Author     : bulwarks-2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Requested Vendor</title>
    </head>
    <script>
        function viewClick(id) {

            var rightName = $('#rightName' + id).val();
            window.location = 'vendorInvitation.htm?act=requestedVendorInvitation&id=' + rightName;
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

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Requested Vendor</h4>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="" method="post" commandName=""
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">


                                <div class="box-body no-padding">
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">


                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty list}">
                                                        <tr>
                                                            <td align="Center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th>Sr.No.</th>
                                                                <th>Company Name</th>
                                                                <th>Email</th>
                                                                <th>Contact Name</th>
                                                                <th>Address</th>
                                                                <th>Phone No.</th>
                                                                <th>Action</th>

                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                                <tr>

                                                                    <td> ${status.count}</td>
                                                                    <td style="text-align: center;">${list[3]}</td>

                                                                    <td style="text-align: center;">${list[2]}</td>
                                                                    <td style="text-align: center;">${list[5]}</td>
                                                                    <td style="text-align: center;">${list[1]}</td>

                                                                    <td style="text-align: center;">${list[4]}</td>




                                                                    <td style="text-align: center;">


                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle"  id="rightName${list[0]}" value="${list[0]}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list[0]});">
                                                                                &nbsp;Invite Vendor
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


