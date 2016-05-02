<%-- 
    Document   : VisitorResultDashboard
    Created on : Feb 13, 2016, 2:53:33 PM
    Author     : Vinita
--%>
<%-- 
    Document   : VisitorResult
    Created on : Nov 7, 2015, 12:59:59 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
           <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
            <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Management</title>
         <script>
            function viewClick(id) {
                window.location = "visitorManagement.htm?act=EmpviewClick&id=" + id;
            }
        </script>
    </head>
    <body>
             <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Visitor Management Form: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Visitor Management</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form action="visitorManagement.htm?act=searchSubmit" method="post" commandName="visitorManagement"
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
                                                            <c:when test="${empty visitorlist}">
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
                                                                        <th>Visitor's Name</th>
                                                                        <th>Visitor's Organization</th>
                                                                        <th>Date</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${visitorlist}">
                                                                <tr>
                                                                        <!--<td align="center"><input type="checkbox" name="checkId" value="${list.id}" /></td>-->
                                                                        <td>${list.visitorName}</td>
                                                                        <td>${list.visitorOrganization}</td>
                                                                        <td>${list.incomingDateTime}</td>

                                                                         <td>
                                                                    <c:if test="${list.status eq 1}"><span class="badge">Pending</span></c:if> 
                                                                    <c:if test="${list.status eq 2}"><span class="label label-success">Approved</span></c:if>
                                                                    <c:if test="${list.status eq 3}"><span class="label label-danger">Rejected</span></c:if>
                                                                    <c:if test="${list.status eq 4}"><span class="label label-danger">Returned</span></c:if>
                                                                    <c:if test="${list.status eq 8}"><span class="label label-success">Withdraw Approved</span></c:if>
                                                                    
                                                                    <c:if test="${list.status eq 5}"><span class="badge">Pending</span></c:if>
                                                                    <c:if test="${list.status eq 6}"><span class="badge">Withdraw Pending</span></c:if>
                                                                    <c:if test="${list.status eq 7}"><span class="label label-danger">Withdraw Rejected</span></c:if>
                                                                    <c:if test="${list.status eq 9}"><span class="label label-danger">Returned Withdraw</span></c:if>
                                                                    <c:if test="${list.status eq 10}"><span class="badge">Returned Withdraw Pending</span></c:if>
                                                                    
                                                                    </td>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                          <c:if test="${list.status  eq 1 || list.status  eq 2 || list.status  eq 4 || list.status  eq 9}">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" onclick="viewClick(${list.id});">View
                                                                                </button>
<!--                                                                                <ul class="dropdown-menu">
                                                                                    <li>
                                                                                        <a href="#"
                                                                                           onclick="viewClick(${list.id});">
                                                                                            View
                                                                                        </a>
                                                                                    </li>

                                                                                </ul>-->
                                                                           </c:if>
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
<!--<script>
            function createNew(){
                window.location = 'visitorManagement.htm?act=createClick';
            }
        </script>-->
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
