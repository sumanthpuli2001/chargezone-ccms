<%-- 
    Document   : empResult
    Created on : Feb 19, 2016, 12:46:34 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
         <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probation To Confirmation</title>
    </head>
    <body>
         <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Probation To Confirmation </h1>
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
                                    <div class="box-header">
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty emplist}">
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
                                                                        <th>Assessment From Date</th>
                                                                        <c:choose>
                                                                         <c:when test="${Status eq 4}">
                                                                        <th>Assessment To Date(Extended Date)</th>
                                                                        </c:when>
                                                                             <c:otherwise>
                                                                        <th>Assessment To Date</th>
                                                                              </c:otherwise>
                                                                                </c:choose>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${emplist}" >
                                                                <tr>
                                                                    <!--<td></td>--> 
                                                            <td>${list[1]}</td>
                                                            <td>${list[2]}</td>
                                                            <td>${list[6]}</td>
                                                            <td>${list[7]}</td>
                                                            <td>
                                                             <c:if test="${list[5] eq 1}"><span class="badge">Submitted by ${managerName}</span></c:if> 
                                                             <c:if test="${list[5] eq 2}"><span class="badge">Submitted by ${functionalHeadName}</span></c:if> 
                                                             <c:if test="${list[5] gt 2}"><span class="badge">Submitted by ${list[10]}</span></c:if> 
                                                            </td>
                                                                    <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" onclick="viewClick(${list[0]},${list[4]});" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                            View
                                                                                </button>
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
            function viewClick(id, empId){
                window.location = "probationToConfirmation.htm?act=hrview&id=" + id + "&empId=" + empId;
            }
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
