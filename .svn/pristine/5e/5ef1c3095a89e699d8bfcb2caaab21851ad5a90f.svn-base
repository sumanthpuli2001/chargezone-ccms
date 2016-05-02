<%-- 
    Document   : GatePassResult
    Created on : Nov 24, 2015, 2:47:05 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
            <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gate Pass Form</title>
        <script>
            function viewClick(id) {
                window.location = "gatePass.htm?act=EmpviewClick&id=" + id;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Gate Pass Form: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Gate Pass</li>
                </ol>
            </section>
           
           <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                   <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
                                <div class="box-header">
                           <a class="btn btn-primary" href="#" style="float: right;" onclick="createNew();"><i class="fa fa-plus"></i>&nbsp;&nbsp;NEW</a>
                                </div>
                              
                                 <form:form action="gatePass.htm?act=searchSubmit" method="post"
                                           name='form1' class="form-horizontal" role="form">
                                <%--<form:form class="form-horizontal" role="form" action="gatePass.htm?act=searchEmpResult"  enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>--%>
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
                                            <div class="form-group">
                                                    <div class=" col-sm-offset-0 col-sm-6">
                                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SEARCH</button>
                                                    </div>
                                                </div>
                                        
                                             <div class="tab-pane" id="tab_3"></div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                              

                                
                                </form:form>
                            </div>
                        </div>
                    </div>
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
                                      <%--<form:form action="gatePass.htm?act=searchSubmit" method="post" commandName="gatePass"--%>
                       <!--name='form1' class="form-horizontal" role="form">-->
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
                                                                        <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                                                                        <th>Assets</th>
                                                                        <th>Return Type</th>
                                                                        <th>Date And Time</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}">
                                                                <tr>
                                                                       
                                                                        <td>${list[3]}</td>
                                                                        <td>
                                                                            <c:if test="${list[4] eq true}">Returnable Gate Pass</c:if>
                                                                            <c:if test="${list[4] eq false}">Non-Returnable Gate Pass</c:if>
                                                                            </td>
                                                                        <td>${list[5]}</td>
                                                                             <td>
                                                                    <c:if test="${list[8] eq 1}"><span class="badge">Requested</span></c:if> 
                                                                    <c:if test="${list[8] eq 2}"><span class="badge">Approved by ${list[9]}</span></c:if> 
                                                                    <c:if test="${list[8] eq 4}"><span class="label label-success">Approved by ${list[10]}</span></c:if> 
                                                                    <c:if test="${list[8] eq 3 }"><span class="label label-danger">Rejected  by ${list[9]}</span></c:if> 
                                                                    <c:if test="${list[8] eq 5}"><span class="label label-danger">Rejected  by ${list[10]}</span></c:if> 
                                                                    <c:if test="${list[8] eq 6}"><span class="label label-warning">Returned by ${list[9]}</span></c:if> 
                                                                    <c:if test="${list[8] eq 7}"><span class="label label-warning">Returned by ${list[10]}</span></c:if> 
                                                                    <c:if test="${list[8] eq 8}"><span class="badge"> Pending</span></c:if> 
                                                                    <c:if test="${list[8] eq 9}"><span class="badge"> Pending</span></c:if> 
                                                                    <%--<c:if test="${list[8] eq 10}"><span class="badge">Withdraw Requested</span></c:if>--%> 
                                                                    <%--<c:if test="${list[8] eq 12}"><span class="badge">Withdraw Pending</span></c:if>--%> 
                                                                    <c:if test="${list[8] eq 14}"><span class="label label-warning">Withdraw </span></c:if> 
                                                                    <%--<c:if test="${list[8] eq 13 || list[8] eq 15}"><span class="label label-danger">Withdraw Rejected</span></c:if>--%> 
                                                                    <%--<c:if test="${list[8] eq 16}"><span class="label label-danger">Withdraw Returned</span></c:if>--%> 
                                                                    <%--<c:if test="${list[8] eq 17}"><span class="label label-danger">Withdraw Returned to Approver</span></c:if>--%> 
                                                                    <%--<c:if test="${list[8] eq 18}"><span class="badge">Withdraw Pending</span></c:if>--%> 
                                                                    <%--<c:if test="${list[8] eq 19}"><span class="badge">Withdraw Pending</span></c:if>--%>     
                                                                        </td>

                                                                        
                                                                        <td>
                                                                            <div class="btn-group">
                                                                            <c:if test="${list[8] eq 1 || list[8] eq 6  || list[8] eq 4  || list[8] eq 16 }">
                                                                                <button type="button" class="btn btn-default dropdown-toggle"  onclick="viewClick(${list[0]});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                                <%--</form:form>--%>
                                      </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>

           
        </div>
        <script>
            function createNew(){
                window.location = 'gatePass.htm?act=createClick';
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
