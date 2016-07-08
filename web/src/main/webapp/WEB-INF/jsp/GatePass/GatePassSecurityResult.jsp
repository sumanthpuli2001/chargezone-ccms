<%-- 
    Document   : GatePassSecurityResult
    Created on : Nov 25, 2015, 2:21:06 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
            <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Gate Pass</title>
          <script>
            function viewClick(id, empId) {
                window.location = "gatePass.htm?act=viewSecurityClick&id=" + id + "&empId=" + empId;
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
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
                 <form:form class="form-horizontal" role="form" action="gatePass.htm?act=securityApproveSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="departmentMaster" id="departmentMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="designationMaster" id="designationMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${desigList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="designationMaster" cssClass="errorDiv"></form:errors>
                                                    </div>

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
                                                <div class="col-sm-6">
                                                    <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>

                                            </div>
                                                   
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
 <br/>
                                <div class="form-group">
                                    <div class="col-sm-6 col-sm-offset-0">
                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >Search</button>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
            <form:form action="" method="post" commandName="gatePass"
                       name='form1' class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;margin-left:960px;" onclick="window.location = 'gatePass.htm?act=exportToExcel'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
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
                                                            <c:when test="${empty Securitylist}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <th style="width: 10%">Emp Id</th>
                                                                        <th style="width: 10%">Emp Name</th>
<!--                                                                        <th style="width: 10%">Approver Id</th>
                                                                        <th style="width: 10%">Approver Name</th>-->
                                                                        <th >Assets</th>
                                                                        <th >Return Type</th>
                                                                        <th >Date And Time</th>
                                                                        <th >Requested Date</th>
                                                                        <th>Status</th>
                                                                        <th style="width: 10%">Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="Securitylist" items="${Securitylist}">
                                                                <tr>
                                                                
                                                                    <td style="width: 10%">${Securitylist[1]}</td>
                                                                    <td style="width: 10%">${Securitylist[2]}</td>
                                                                    <td style="width: 10%">${Securitylist[3]}</td>
                                                                  
                                                                    <td style="width: 10%">
                                                                       <c:if test="${Securitylist[4] eq true}">Returnable Gate Pass</c:if>
                                                                       <c:if test="${Securitylist[4] eq false}">Non-Returnable Gate Pass</c:if>
                                                                        </td>
                                                                    <td>${Securitylist[5]}</td>
                                                                      <td>${Securitylist[11]}</td>
                                                                    <td style="width: 10%">
                                                                        <c:if test="${Securitylist[7] eq 1}">
                                                                           <span class="badge">Requested</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 2}">
                                                                            <span class="badge"> Approval Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 4}">
                                                                        <span class="label label-success">Approved by ${Securitylist[8]}</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 9}">
                                                                        <span class="badge"> Approval Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 8}">
                                                                        <span class="badge"> Approval Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 3}">
                                                                         <span class="label label-danger">Rejected by ${Securitylist[9]}</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 5}">
                                                                         <span class="label label-danger">Rejected by ${Securitylist[8]}</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 6}">
                                                                         <span class="label label-warning">Returned by ${Securitylist[9]}</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 7}">
                                                                         <span class="label label-warning">Returned by ${Securitylist[8]}</span>
                                                                        </c:if>
                                                                        <c:if test="${Securitylist[7] eq 14}">
                                                                         <span class="label label-warning">Withdraw</span>
                                                                        </c:if>
                                                                        </td>
                                                                        <td style="width: 10%">
                                                                            <c:if test="${Securitylist[7] eq 2 ||Securitylist[7] eq 9}">
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle"   onclick="viewClick(${Securitylist[0]},${Securitylist[6]});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                            View
                                                                                </button>
                                                                            </div>
                                                                                            </c:if>
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
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeName").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });

    </script>
   
   
          <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
