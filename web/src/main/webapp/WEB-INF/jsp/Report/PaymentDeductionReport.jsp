<%-- 
    Document   : PaymentDeductionReport
    Created on : 12-Jul-2020, 23:08:46
    Author     : Aman Bahukhandi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title> </title>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1></h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active"></li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="report.htm?act=searchPaymentDeductionReport" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">

                                                <div class="col-sm-3">
                                                    <label class="control-label">From Date :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime"   data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                                                        <input name="startDate" id="startDate"  class="form-control" value="${dFrom}" size="16" readonly="true" required="required"/>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">To Date :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime"   data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                                                        <input id="endDate" name="endDate"  class="form-control" size="16" value="${eFrom}" readonly="true" required="required"/>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">Type :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="type" id="type" value="${type}"  class="form-control">
                                                        <option value="E">Employee</option>
                                                        <option value="D">Employee Department</option>
                                                        <option value="C">Contractor</option>
                                                        <option value="G">Guest</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">Name :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <input name="name" id="name"  class="form-control" value="${name}" size="16" />
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Generate</button>
                                    </div>
                                </div>
                            </div><!-- /.box-body -->

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
        <form:form  method="post"  commandName="pdm"
                    name='form2'  onsubmit='return deleteCheck11();' class="form-horizontal" >
            <c:if test="${search ne 'none'}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table table-bordered">
                                <div class=" table table-bordered table-responsive">
                                    <div class="tab-content">
                                        <div id="printableArea">
                                            <table  id="tableid"  class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <c:choose>
                                                    <c:when test="${empty employeeListFinal}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="box-header" style="text-align: right;">
                                                            <button type="button" id="btnExport" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                            <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                                        </div>
                                                        <thead>
                                                            <tr>
                                                                <th colspan="12" style="text-align: center">
                                                                    GUJARAT INDUSTRIES POWER COMPANY LIMITED                                                            
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <th colspan="12" style="text-align: center">
                                                                    COUPON PAYMENT DEDUCTION TO GIPCL EMPLOYEE From ${dFrom} To ${eFrom}   
                                                                </th>
                                                            </tr>
                                                            <tr  style="text-align: center">
                                                                <th >Sr.No</th>  
                                                                <th colspan="3">Code</th>
                                                                <th colspan="3">RF ID</th>
                                                                <th colspan="3">Name of Employee</th>
                                                                <th colspan="2">Total Amount</th>
                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <c:forEach var="personDetailsFinal" items="${employeeListFinal}" varStatus="status">
                                                                <tr>
                                                                    <td> ${status.count}</td>
                                                                    <td colspan="3">${personDetailsFinal[1]}</td>
                                                                    <td colspan="3">${personDetailsFinal[3]}</td>
                                                                    <td colspan="3">${personDetailsFinal[0]}</td>
                                                                    <td colspan="2">
                                                                        <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${personDetailsFinal[2]}" >
                                                                        </fmt:formatNumber>
                                                                    </td>
                                                                </tr>   
                                                            </c:forEach>
                                                            <tr>
                                                                <th colspan="10" style="text-align: right">Total</th>
                                                                <th colspan="2">
                                                                    <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${totalAmount}" >
                                                                    </fmt:formatNumber>
                                                                </th>
                                                            </tr>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>  
                    </div>
                </section>
            </div>
        </c:if>
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
    });</script>

<script type="text/javascript">
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;

        document.body.innerHTML = printContents;

        window.print();

        document.body.innerHTML = originalContents;
    }
</script>
<script type="text/javascript">
    function ExportToExcel(tableid) {
        var htmltable = document.getElementById('tableid');
        var html = htmltable.outerHTML;
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
    }
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
