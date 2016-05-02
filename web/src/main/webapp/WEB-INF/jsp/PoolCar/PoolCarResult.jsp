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
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <a class="btn btn-primary" href="#" style=" float: right;" onclick="createNew();"><i class="fa fa-plus"></i>&nbsp;&nbsp;NEW</a>
                                <div style="clear: both"></div>
                                <div class="box-header">
                                </div>
                                <form:form action="poolCarRequest.htm?act=searchEmpResult" method="post"
                                           name='form1' class="form-horizontal" role="form">

                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"/>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"/>
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
                                                            <option value="4">Approved</option>
                                                            <option value="3">Rejected by approver</option>
                                                            <option value="5">Rejected by admin</option>
                                                            <option value="6">Returned by Approver</option>
                                                            <option value="7">Returned by admin</option>
                                                            <option value="14">Withdraw</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br/>
                                                <div class="form-group">
                                                    <div class=" col-sm-offset-0 col-sm-6">
                                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SEARCH</button>
                                                    </div>
                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </form:form>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
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
                                                                <!--<td align="center"><input type="checkbox" name="checkId" value="$list.id}" /></td>-->
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>

                                                                <td>
                                                                    <c:if test="${list[2] eq 1}"><span class="badge">Requested</span></c:if> 
                                                                    <c:if test="${list[2] eq 2}"><span class="badge">HR Approval Pending</span></c:if> 
                                                                    <c:if test="${list[2] eq 4}"><span class="label label-success">Approved by ${list[5]}</span></c:if> 
                                                                    <c:if test="${list[2] eq 3 }"><span class="label label-danger">Rejected  by ${list[4]}</span></c:if> 
                                                                    <c:if test="${ list[2] eq 5}"><span class="label label-danger">Rejected by ${list[5]}</span></c:if> 
                                                                    <c:if test="${list[2] eq 6}"><span class="label label-warning">Returned by ${list[4]}</span></c:if> 
                                                                    <c:if test="${list[2] eq 7}"><span class="label label-warning">Returned  by ${list[5]}</span></c:if> 
                                                                    <c:if test="${list[2] eq 8}"><span class="badge"> Pending</span></c:if> 
                                                                    <c:if test="${list[2] eq 9}"><span class="badge"> Pending</span></c:if> 
                                                                    <%--<c:if test="${list[2] eq 10}"><span class="badge">Withdraw Requested</span></c:if>--%> 
                                                                    <%--<c:if test="${list[2] eq 12}"><span class="badge">Withdraw Pending</span></c:if>--%> 
                                                                    <c:if test="${list[2] eq 14}"><span class="label label-warning">Withdraw</span></c:if> 
                                                                    <%--<c:if test="${list[2] eq 13 || list[2] eq 15}"><span class="label label-danger">Withdraw Rejected</span></c:if>--%> 
                                                                    <%--<c:if test="${list[2] eq 16}"><span class="label label-danger">Withdraw Returned</span></c:if>--%> 
                                                                    <%--<c:if test="${list[2] eq 17}"><span class="label label-danger">Withdraw Returned to Approver</span></c:if>--%> 
                                                                    <%--<c:if test="${list[2] eq 18}"><span class="badge">Withdraw Pending</span></c:if>--%> 
                                                                    <%--<c:if test="${list[2] eq 19}"><span class="badge">Withdraw Pending</span></c:if>--%>     
                                                                    </td>

                                                                    <td>
                                                                        <div class="btn-group">
                                                                        <c:if test="${list[2] eq 1 || list[2] eq 6 || list[2] eq 7 || list[2] eq 4  || list[2] eq 16 }">
                                                                            <button type="button" onclick="viewClick(${list[3]});" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                    View
                                                                            </button>
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
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
        <script>
            function createNew() {
                window.location = 'poolCarRequest.htm?act=createClick';
            }
        </script>

    </body>
</html>
