<%--
    Document   : TravelRequestCeoResult
    Created on : Feb 5, 2016, 3:10:37 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Result</title>
        <script>
            function viewClick(id, empId) {
                window.location = 'travelRequestMaster.htm?act=viewResultCEOSide&id=' + id + "&empId=" + empId;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Travel Request: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Travel Result</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form action="" method="post" commandName="travelRequestMaster"
                       name='form1' class="form-horizontal" role="form">
                <form:hidden path="id"></form:hidden>
                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>-->
                                        <div class="box-header">
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty list}">
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
                                                                        <th>Travel Type</th>
                                                                        <th>Travel Request No.</th>
                                                                        <th>Start Date Time</th>
                                                                        <th>End Date Time</th>
                                                                        <th>Requested Date</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}">
                                                                <tr>
                                                                    <td>${list[0]}</td>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td><b>${list[3]}</b></td>
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[5]}</td>
                                                                    <td>${list[10]}</td> 
                                                                    <c:if test="${list[8] eq 6}">
                                                                        <td><span class="badge">Pending</span></td>
                                                                    </c:if>
                                                                    <c:if test="${list[8] eq 5}">
                                                                        <td><span class="label label-success">Approved by ${list[9]} </span></td>
                                                                    </c:if>
                                                                          
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default" onclick="viewClick(${list[6]}, ${list[7]});">
                                                                                &nbsp;&nbsp;View</button>
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

        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    </body>
</html>

