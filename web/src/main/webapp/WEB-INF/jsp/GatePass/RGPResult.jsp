<%-- 
    Document   : RGPResult
    Created on : Nov 26, 2015, 12:17:07 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
            <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gate Pass Form</title>
        <script>
            function viewClick(id,empId) {
                window.location = "gatePass.htm?act=rgpview&id=" + id + "&empId=" +empId;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Return Gate Pass Form: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Return Gate Pass</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form action="" method="post" commandName="gatePass"
                       name='form1' class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div style="clear: both"></div>
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
                                                                        <th>Assets</th>
                                                                        <th>Material out Date And Time</th>
                                                                        <th>Expected Date & Time Of Return</th>
                                                                        <th>Action</th>
<!--                                                                    <th>Emp Id</th>
                                                                        <th>Emp Name</th>
                                                                        <th>Approver Id</th>
                                                                        <th>Approver Name</th>
                                                                        <th>Return Type</th>
                                                                        <th>Status</th>-->
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                    <td>${list[3]}</td>
                                                                    <td>${list[5]}</td>
                                                                    <td>${list[6]}</td>
<!--                                                                <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[8]}</td>
                                                                    <td>${list[9]}</td>-->
<!--                                                                    <td>
                                                                       <%--<c:if test="${list[4] eq true}">Returnable Gate Pass</c:if>--%>
                                                                       <%--<c:if test="${list[4] eq false}">Non-Returnable Gate Pass</c:if>--%>
                                                                        </td>-->
                                                                    <!--<td>${list[8]}</td>-->
<!--                                                                    <td>
                                                                         <%--<c:if test="${list[7] eq 2}">Approval Pending</c:if>--%>
                                                                         <%--<c:if test="${list[7] eq 2}">Approval Pending</c:if>--%>
                                                                         <%--<c:if test="${list[7] eq 9}"> Return Request Approval Pending </c:if>--%>
                                                                    </td>-->
                                                                   
                                                                        
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" onclick="viewClick(${list[0]},${list[7]});" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                            View
                                                                                </button>
<!--                                                                                <ul class="dropdown-menu">
                                                                                    <li>
                                                                                    </li>

                                                                                </ul>-->
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

