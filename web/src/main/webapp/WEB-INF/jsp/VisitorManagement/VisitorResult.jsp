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
                <h1> Visitor Request: </h1>
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
            <form:form class="form-horizontal" role="form" action="visitorManagement.htm?act=searchEmpResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                <a class="btn btn-primary" href="#" style="float: right;" onclick="createNew();"><i class="fa fa-plus"></i>&nbsp;&nbsp;NEW</a></h1>
                                                <div style="float: right"></div>
                                                <br/>
                                                <br/>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Status:<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="status" id="status" class="form-control">
                                                            <option value="">--Select--</option>
                                                            <option value="1">Requested</option>
                                                            <option value="2">Approved</option>
                                                            <option value="8">Withdraw</option>
                                                        </select>
                                                    </div>
                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="form-group">
                                        <div class=" col-sm-2 col-sm-offset-0">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px;">SEARCH</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </form:form>

            
            <section class="content">
                <%--<form:form action="visitorManagement.htm?act=searchSubmit" method="post" commandName="visitorManagement"--%>
                <!--name='form1' class="form-horizontal" role="form">-->
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
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="width: 100%" align="Center"  >
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
                                                                    <th style="width: 20%">Visitor's Name</th>
                                                                    <th style="width: 20%">Visitor's Organization</th>
                                                                    <th style="width: 20%">Date</th>
                                                                    <th style="width: 20%">Requested Date</th>
                                                                    <th style="width: 20%">Status</th>
                                                                    <th style="width: 10%">Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="visitorlist" items="${visitorlist}">
                                                            <tr>
                                                                    <!--<td align="center"><input type="checkbox" name="checkId" value="${visitorlist[4]}" /></td>-->
                                                                <td>${visitorlist[0]}</td>
                                                                <td>${visitorlist[1]}</td>
                                                                <td>${visitorlist[2]}</td>
                                                                <td>${visitorlist[6]}</td>

                                                                <td>
                                                                    <c:if test="${visitorlist[3] eq 1}"><span class="badge">Pending</span></c:if> 
                                                                    <c:if test="${visitorlist[3] eq 2}"><span class="label label-success">Approved By ${visitorlist[5]}</span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 3}"><span class="label label-danger">Rejected </span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 4}"><span class="label label-warning">Returned </span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 8}"><span class="label label-warning">Withdrawn</span></c:if>

                                                                    <c:if test="${visitorlist[3] eq 5}"><span class="badge">Pending</span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 6}"><span class="badge">Withdraw Pending</span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 7}"><span class="label label-danger">Withdraw Rejected</span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 9}"><span class="label label-warning">Returned Withdraw</span></c:if>
                                                                    <c:if test="${visitorlist[3] eq 10}"><span class="label label-primary">Returned Withdraw Pending</span></c:if>

                                                                    </td>
                                                                    <td>
                                                                        <div class="btn-group center-block">
                                                                        <c:if test="${visitorlist[3]  eq 1 || visitorlist[3]  eq 2 || visitorlist[3]  eq 4 || visitorlist[3]  eq 9}">
                                                                            <button class="btn btn-default " style="width: 75px;" onclick="viewClick('${visitorlist[4]}');">
                                                                                View
                                                                            </button>
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
                <%--</form:form>--%>
            </section>
        </div>
        <script>
            function createNew() {
                window.location = 'visitorManagement.htm?act=createClick';
            }
        </script>
        <script type="text/javascript">
            $('.form_datetime').datetimepicker({
                //language:  'fr',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0
            });
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
