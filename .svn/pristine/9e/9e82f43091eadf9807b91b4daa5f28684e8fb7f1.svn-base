<%-- 
    Document   : ItServiceRequestResult
    Created on : Nov 30, 2015, 6:04:53 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IT Service Request Result</title>
        <script>
            function viewClick(id) {
                window.location = "itServiceRequest.htm?act=EmpviewClick&id=" + id;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>IT Service Request Result:</h1>
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
            <!-- Main content -->
            <form:form class="form-horizontal" role="form" action="itServiceRequest.htm?act=searchEmpResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <a class="btn btn-primary" href="#" style="float: right;" onclick="createNew();"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</a>
                                    <div style="clear: both"></div>
                                    <div class="box-header">

                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">


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
                                               
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="form-group">
                                        <div class=" col-sm-6 col-sm-offset-0">
                                            <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SEARCH</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </form:form>
            <form:form action="" method="post" commandName="itServiceRequest"
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
                                                                        <th>IT Service Request</th>
                                                                        <!--<th>Status</th>-->
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}">
                                                                <tr>
                                                                    <td>${list[1].text}</td>
                                                                    <!--                                                               <td>
                                                                    <%--<c:if test="${list[2] eq 1}"><span class="badge">Requested</span></c:if>--%> 
                                                                    <%--<c:if test="${list[2] eq 2}"><span class="label label-success">Approved</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 3}"><span class="label label-danger">Rejected</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 4}"><span class="label label-danger">Returned</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 8}"><span class="label label-success">Withdraw Approved</span></c:if>--%>
                                                                    
                                                                    <%--<c:if test="${list[2] eq 5}"><span class="badge">Pending</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 6}"><span class="badge">Withdraw Pending</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 7}"><span class="label label-danger">Withdraw Rejected</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 9}"><span class="label label-danger">Returned Withdraw</span></c:if>--%>
                                                                    <%--<c:if test="${list[2] eq 10}"><span class="badge">Returned Withdraw Pending</span></c:if>--%>
                                                                    
                                                                    </td>-->
                                                                    <td style="width: 20%">
                                                                        <div class="btn-group">
                                                                            <%--<c:if test="${list[2] eq 1 || list[2] eq 2 || list[2] eq 4 || list[2] eq 9}">--%>
                                                                                <button type="button" onclick="viewClick(${list[0]});" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                        View
                                                                                </button>

                                                                            <%--</c:if>--%>
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

            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        </div>
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
        <script>
            function createNew() {
                window.location = 'itServiceRequest.htm?act=createClick';
            }
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
