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
                window.location = "visitorManagement.htm?act=viewClickByEmployee&id=" + id;
            }
        </script>
        <!--        <style>
                    table{
                        /*table-layout: fixed;*/
                        overflow-x: scroll;
                        overflow-y: scroll;
                    }
                    tbody{
                        /*display: block;*/
                        overflow: scroll;
                    }
                    thead{
                        /*display: block;*/
                        overflow: scroll;
                    }
                </style>-->
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
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" value="${startDate}"/>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" value="${endDate}"/>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Status:<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="status" id="status" class="form-control">
                                                            <option value="" <c:if test="${'' eq status}">selected="selected"</c:if>>--Select--</option>
                                                            <option value="1" <c:if test="${1 == status}">selected="selected"</c:if>>Pending</option>
                                                            <option value="2" <c:if test="${2 == status}">selected="selected"</c:if>>Confirmed</option>
                                                            <option value="8" <c:if test="${8 == status}">selected="selected"</c:if>>Withdrawn</option>
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
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive" style="font-size: 12px;text-align: center;">   
                                                <table id="table_1" class="table table-bordered table-hover" style="text-align: center;" >
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
                                                                    <th style="width: 10%">Action</th>
                                                                    <th style="width: 20%">Location</th>
                                                                    <th style="width: 20%">Visit's To</th>
                                                                    <th style="width: 20%">Visitor's Name</th>
                                                                    <th style="width: 20%">Visitor Coming From</th>
                                                                    <th style="width: 20%">Visitor Organization</th>
                                                                    <th style="width: 20%">Requested Date</th>
                                                                    <th style="width: 20%">Incoming Date</th>
                                                                    <th style="width: 20%">Meeting Off Date</th>
                                                                    <th style="width: 20%">Outgoing Date</th>
                                                                    <th style="width: 20%">Duration(In-Out)</th>
                                                                    <th style="width: 20%">Duration(Meet-Out)</th>
                                                                    <th style="width: 20%">Status</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="visitorlist" items="${visitorlist}">
                                                            <tr>
                                                                <td>
                                                                    <div class="btn-group center-block">
                                                                        <button class="btn btn-default " style="width: 75px;" onclick="viewClick('${visitorlist[0]}');">
                                                                            View
                                                                        </button>
                                                                    </div>
                                                                </td>
                                                                <td>${visitorlist[5]}</td>
                                                                <td>${visitorlist[3]}(${visitorlist[4]})</td>
                                                                <td>${visitorlist[2]}</td>
                                                                <td>${visitorlist[6]}</td>
                                                                <td>${visitorlist[14]}</td>
                                                                <td>${visitorlist[7]}</td>
                                                                <td>${visitorlist[8]}</td>
                                                                <td>${visitorlist[9]}</td>
                                                                <td>${visitorlist[10]}</td>
                                                                <td>
                                                                    <c:if test="${null eq visitorlist[11]}">-</c:if>
                                                                    <c:if test="${null ne visitorlist[11]}">${visitorlist[11]}</c:if>
                                                                </td>
                                                                <td>
                                                                    <c:if test="${null eq visitorlist[13]}">-</c:if>
                                                                    <c:if test="${null ne visitorlist[13]}">${visitorlist[13]}</c:if>
                                                                <td>
                                                                    <c:if test="${visitorlist[12] eq 1}"><span class="badge" style="font-size:10px; ">Pending</span></c:if> 
                                                                    <c:if test="${visitorlist[12] eq 2}"><span class="label label-success">Confirmed</span></c:if>
                                                                    <c:if test="${visitorlist[12] eq 8}"><span class="label label-warning">Withdrawn</span></c:if>
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
    </body>
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
</html>
