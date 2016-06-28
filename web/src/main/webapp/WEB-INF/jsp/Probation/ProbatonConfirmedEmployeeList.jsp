<%--
    Document   : ProbatonConfirmedEmployeeList
    Created on : Jun 23, 2016, 3:15:23 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probation Confirmed</title>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Probation Confirmed</h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Result</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form action="" method="post" commandName="ptc"
                       name='form1' class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div style="clear: both"></div>
                                    <div class="box-header" style="text-align: right;">
                                        <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'probationToConfirmation.htm?act=exportToExcelProbationconfirmedEmployee'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty probatonConfirmedList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <th>Employee Id</th>
                                                                        <th>Employee Name</th>
                                                                        <th>Department</th>
                                                                        <th>Designation</th>
                                                                        <th>Date of Joining</th>
                                                                        <th>Date of Confirmation</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="probatonConfirmedList" items="${probatonConfirmedList}" varStatus="status">
                                                                <tr>
                                                                    <!--<td></td>-->
                                                                    <td>${probatonConfirmedList[0]}</td>
                                                                    <td>${probatonConfirmedList[1]}</td>
                                                                    <td>${probatonConfirmedList[2]}</td>
                                                                    <td>${probatonConfirmedList[3]}</td>
                                                                    <td>${probatonConfirmedList[4]}</td>
                                                                    <td>${probatonConfirmedList[5]}</td>
                                                                    <td><span class="label label-success">Confirmed</span></td>
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle"  onclick="viewClick(${probatonConfirmedList[7]},${probatonConfirmedList[8]});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                View </button>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>

            </form:form>

        </div>
        <script>
            function viewClick(id, empId) {
                window.location = "probationToConfirmation.htm?act=viewProbationconfirmedEmployee&id=" + id + "&empId=" + empId;
            }
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    </body>
</html>
