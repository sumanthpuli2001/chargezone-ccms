<%-- 
    Document   : CafeApproverResult
    Created on : Nov 5, 2015, 10:52:48 AM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cafe Request Result</title>
         <script>
            function viewClick(id, empId) {
                window.location = "cafeteriaRequest.htm?act=viewClick&id=" + id + "&empId=" + empId;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Cafeteria Request: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Cafeteria Request Result</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
                 <form:form action="" method="post" commandName="cafeteriaRequest"
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
                                                            <c:when test="${empty cafeRequestList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                                                                        <th>Employee Id</th>
                                                                        <th>Employee Name</th>
                                                                        <th>Request</th>
                                                                        <th>No.of Employees/Visitors</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${cafeRequestList}">
                                                            <tr>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                               <td><c:if test="${list[6] eq 1}">
                                                                        Approval Pending
                                                                        </c:if>
                                                                        <c:if test="${list[6] eq 7}">
                                                                        Returned by Admin
                                                                        </c:if>
                                                                        <c:if test="${list[6] eq 8}">
                                                                      Return Request Approval Pending
                                                                        </c:if>
                                                                      <c:if test="${list[6] eq 10}">
                                                                      Withdraw Request Approval Pending
                                                                        </c:if>
                                                                       <c:if test="${list[6] eq 17}">
                                                                      Withdraw Request Returned by Admin
                                                                        </c:if>
                                                                       <c:if test="${list[6] eq 18}">
                                                                     Returned Withdraw Request Approval Pending
                                                                        </c:if>
                                                               </td>
                                                                <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                    Action <span class="caret"></span>
                                                                                </button>
                                                                                <ul class="dropdown-menu">
                                                                                    <li>
                                                                                        <a href="#"  onclick="viewClick(${list[0]},${list[5]});">
                                                                                            &nbsp;&nbsp;View
                                                                                        </a>
                                                                                    </li>

                                                                                </ul>
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
