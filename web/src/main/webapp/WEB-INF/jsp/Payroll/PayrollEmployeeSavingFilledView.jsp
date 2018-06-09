<%-- 
    Document   : PayrollEmployeeSavingFilledView
    Created on : Apr 18, 2018, 10:21:23 AM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title> Employee Saving </title>
    </head>
    <script>
        function viewClick(id, fyid) {
            window.location = "taxSavingSubmit.htm?act=viewFilledEmployeeSavingClick&eid=" + id + "&fid=" + fyid;

        }
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>FILLED EMPLOYEE SAVING DETAIL</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Filled Employee Saving Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="taxSavingSubmit.htm?act=searchFormEmployeeFilledSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">

                                            <div class="col-sm-4">
                                                <label>Financial year:<span style="color: red;font-size: 12px;">*</span></label>
                                                <select name="fnyear" id="fnyear" class="form-control ">
                                                    <option value="">--Select--</option>
                                                    <c:forEach var="finyear" items="${financialYearList}">
                                                        <option value="${finyear.key}" label="${finyear.value}" ></option>
                                                    </c:forEach>
                                                </select>
                                                <span id="fnError" style="color: red;"></span>
                                            </div>
                                            <br>

                                        </div>
                                        <!--</div> /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="form-group">
                                    <div class=" col-sm-12">
                                        <center>
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                        </center>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>

            </section>
        </form:form>
        
        <form:form action="" method="post" commandName="taxSavingSubmit" name='form1'  class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table  class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty employeelist}">
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
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <input style="display: none;" type="Text" name="employeeListLength"  value="${fn:length(employeelist)}"/>
                                                            <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                                <tr>
                                                                    <td>${list[0]}</td>
                                                                    <td>${list[1]}</td>
                                                                    <c:if test="${list[4] eq 1}"><td><span style="font-size:15px" class="label label-default">Pending</span></td></c:if>
                                                                    <c:if test="${list[4] eq 2}"><td><span style="font-size:15px" class="label label-success">Approved</span></td></c:if>
                                                                    <c:if test="${list[4] eq 3}"><td><span style="font-size:15px" class="label label-warning">Partially Approved</span></td></c:if>
                                                                    <c:if test="${list[4] eq 4}"><td><span style="font-size:15px" class="label label-danger">Rejected</span></td></c:if>
                                                                    <c:if test="${list[4] eq 5}"><td><span style="font-size:15px" class="label label-info">Recycled </span></td></c:if>
                                                                    <td>  
                                                                        <button type="button" onclick="viewClick('${list[2]}', '${list[3]}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </td>

                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <c:if test="${!empty employeelist}">

                                                </c:if>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->

                        </div>
                    </div><!-- /.col -->
                </section>
        </form:form>

    </div>
    
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

