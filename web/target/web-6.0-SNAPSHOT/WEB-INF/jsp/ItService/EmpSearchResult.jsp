<%-- 
    Document   : EmpSearchResult
    Created on : Dec 2, 2015, 12:52:03 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
         <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Search Result</title>
    </head>
   <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Search IT Service Request: </h1>
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
        <!-- Main content -->
        <form:form action="" method="post" commandName="itServiceRequest"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
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
                                                                 
                                                                    <th>Request Type</th>
                                                                    <th>Status</th>
                                                                 
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                             
                                                                <td>${list[0].text}</td>
                                                                <td>
                                                                    <c:if test="${list[1] eq 1}"><span class="badge">Pending</span></c:if> 
                                                                    <c:if test="${list[1] eq 2}"><span class="label label-success">Approved</span></c:if>
                                                                    <c:if test="${list[1] eq 3}"><span class="label label-danger">Rejected</span></c:if>
                                                                    <c:if test="${list[1] eq 4}"><span class="label label-danger">Returned</span></c:if>
                                                                    <c:if test="${list[1] eq 8}"><span class="label label-success">Withdraw Approved</span></c:if>
                                                                    
                                                                    <c:if test="${list[1] eq 5}"><span class="badge">Pending</span></c:if>
                                                                    <c:if test="${list[1] eq 6}"><span class="badge">Withdraw Pending</span></c:if>
                                                                    <c:if test="${list[1] eq 7}"><span class="label label-danger">Withdraw Rejected</span></c:if>
                                                                    <c:if test="${list[1] eq 9}"><span class="label label-danger">Returned Withdraw</span></c:if>
                                                                    <c:if test="${list[1] eq 10}"><span class="badge">Returned Withdraw Pending</span></c:if>
                                                                    
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

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>


