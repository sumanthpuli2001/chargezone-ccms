<%-- 
    Document   : PoolcarpendingDashboard
    Created on : Feb 11, 2016, 12:20:04 PM
    Author     : Vinita
--%>

<%-- 
    Document   : PoolCarResult
    Created on : Oct 16, 2015, 12:52:42 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pool Car Request Result</title>
        <script>
            function viewClick(id) {
                window.location = "poolCarRequest.htm?act=EmpviewClick&id=" + id;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Pool Car Request: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Pool Car Result</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form action="poolCarRequest.htm?act=createClick" method="post" commandName="poolCarRequest"
                       name='form1' class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <!--<a class="btn btn-primary" href="#" style="float: right;" onclick="createNew();"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</a>-->
                                    <div style="clear: both"></div>
                                    <div class="box-header">
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty poolCarRequestList}">
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
                                                                        <th>Start Date And Time</th>
                                                                        <th>End  Date And Time</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${poolCarRequestList}">
                                                                <tr>
                                                                    <%--<c:if test="${list.status eq 1 || list.status eq 6  || list.status eq 4  || list.status eq 16 }">--%>
                                                                        <!--<td align="center"><input type="checkbox" name="checkId" value="${list.id}" /></td>-->
                                                                        <td>${list.startDateTime}</td>
                                                                        <td>${list.endDateTime}</td>

                                                                        <td>
                                                                    <c:if test="${list.status eq 1}"><span class="badge">Requested</span></c:if> 
                                                                    <c:if test="${list.status eq 2}"><span class="badge">Approval Pending</span></c:if> 
                                                                    <c:if test="${list.status eq 4}"><span class="label label-success">Approved</span></c:if> 
                                                                    <c:if test="${list.status eq 3 || list.status eq 5}"><span class="label label-danger">Rejected</span></c:if> 
                                                                    <c:if test="${list.status eq 6}"><span class="label label-warning">Returned by Approver</span></c:if> 
                                                                    <c:if test="${list.status eq 7}"><span class="label label-warning">Returned by Admin</span></c:if> 
                                                                    <c:if test="${list.status eq 8}"><span class="badge"> Pending</span></c:if> 
                                                                    <c:if test="${list.status eq 9}"><span class="badge"> Pending</span></c:if> 
                                                                    <c:if test="${list.status eq 10}"><span class="badge">Withdraw Requested</span></c:if> 
                                                                    <c:if test="${list.status eq 12}"><span class="badge">Withdraw Pending</span></c:if> 
                                                                    <c:if test="${list.status eq 14}"><span class="label label-warning">Withdraw </span></c:if> 
                                                                    <c:if test="${list.status eq 13 || list.status eq 15}"><span class="label label-danger">Withdraw Rejected</span></c:if> 
                                                                    <c:if test="${list.status eq 16}"><span class="label label-danger">Withdraw Returned</span></c:if> 
                                                                    <c:if test="${list.status eq 17}"><span class="label label-danger">Withdraw Returned to Approver</span></c:if> 
                                                                    <c:if test="${list.status eq 18}"><span class="badge">Withdraw Pending</span></c:if> 
                                                                    <c:if test="${list.status eq 19}"><span class="badge">Withdraw Pending</span></c:if>     
                                                                        </td>

                                                                        <td>
                                                                            <div class="btn-group">
                                                                                      <c:if test="${list.status eq 1 || list.status eq 6 || list.status eq 7 || list.status eq 4  || list.status eq 16 }">
                                                                                <button type="button" class="btn btn-default dropdown-toggle"   onclick="viewClick(${list.id});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                            View
                                                                                </button>
<!--                                                                                <ul class="dropdown-menu">
                                                                                    <li>
                                                                                      
                                                                                    </li>
                                                                                </ul>-->
                                                                                      </c:if>
                                                                            </div>
                                                                        </td>
                                                                    <%--</c:if>--%>
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
        <script>
            function createNew(){
                window.location = 'poolCarRequest.htm?act=createClick';
            }
        </script>
    </body>
</html>


