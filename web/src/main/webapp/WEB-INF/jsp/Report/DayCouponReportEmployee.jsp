<%-- 
    Document   : DayCouponReportEmployee
    Created on : 22-Jul-2020, 13:11:26
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
    <script>
        function viewClick(id) {
            window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
        }
    </script>


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
        <form:form class="form-horizontal" role="form1" action="report.htm?act=searchDayCoupon" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
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
                                                <div class="col-sm-3" style="pointer-events: none">
                                                    <label class="control-label">Type :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="type" id="type" value="${type}"  class="form-control">
                                                        <c:choose>
                                                            <c:when test="${fn:contains(sessionScope.type,'E')}">
                                                                <option  value="E" selected="selected">Employee</option>
                                                                <option value="C">Contractor</option>
                                                                <option value="A">Apprentice</option>
                                                            </c:when>
                                                            <c:when test="${fn:contains(sessionScope.type,'C')}">
                                                                <option value="E">Employee</option>
                                                                <option value="C" selected="selected">Contractor</option>
                                                                <option value="A">Apprentice</option>
                                                            </c:when>
                                                            <c:when test="${fn:contains(sessionScope.type,'A')}">
                                                                <option value="E">Employee</option>
                                                                <option value="C">Contractor</option>
                                                                <option value="A" selected="selected">Apprentice</option>
                                                            </c:when>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">Name :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <input name="name" id="name" readonly="true" class="form-control" value="${sessionScope.user.userFullName}" size="16" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label>Item:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="item" id="item" value="${item}" class="form-control"/>
                                                    <option value="All">All</option>
                                                    <c:forEach var="couponType" items="${couponMap}">
                                                        <c:choose>
                                                            <c:when test="${couponType eq item}">
                                                                <option value="${couponType.key}" selected="true">${couponType.value}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${couponType.key}">${couponType.value}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    </select>
                                                    <span id="companyError" style="color: red;"></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
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
                                        <c:choose>
                                            <c:when test="${!(personDetailsFinal eq 'empty')}"> 
                                                <div class="box-header" style="text-align: right;">
                                                    <!--                                                    <button type="button" id="btnExport" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                                                                        <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">-->
                                                </div>
                                            </c:when>
                                        </c:choose>
                                        <div id="printableArea">
                                            <table  id="tableid"  class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <c:choose>
                                                    <c:when test="${empty personDetailsFinal}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th colspan="19" style="text-align: center">
                                                                    GUJARAT INDUSTRIES POWER COMPANY LIMITED                                                            
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <th colspan="19" style="text-align: center">
                                                                    ISSUE OF COUPONS TO GIPCL EMPLOYEE From ${dFrom} To ${eFrom}                                                          
                                                                </th>
                                                            </tr>
                                                            <tr  style="text-align: center">
                                                                <th rowspan="3">Sr.No</th>  
                                                                <th rowspan="3">Date</th>
                                                                <th rowspan="3">Code</th>
                                                                <th rowspan="3">Name Of EMPLOYEE</th>
                                                                <th colspan="14" style="text-align: center">Denomination No. of Coupons Issued</th>
                                                                <th rowspan="2">Total</th>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="coupon" items="${couponList}">
                                                                    <th style="text-align: center" colspan="2">${coupon.couponType}</th>
                                                                    </c:forEach>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="coupon" items="${couponList}">
                                                                    <th colspan="1">Rs(S)${coupon.couponPrice}</th>
                                                                    <th colspan="1">Rs(A)${coupon.acPrive}</th>
                                                                    </c:forEach>
                                                                <th> Amount </th>
                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="personDetailsFinal" items="${personDetailsFinal}" varStatus="status">
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td>${personDetailsFinal[0]}</td>
                                                            <td>${personDetailsFinal[2]}</td>
                                                            <td>${personDetailsFinal[1]}</td>

                                                            <c:forEach var="coupon" items="${couponList}">
                                                                <c:choose>
                                                                    <c:when test="${finalList[status.count -1][0] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][1]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][2]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][3] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][4]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][5]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][6] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][7]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][8]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][9] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][10]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][11]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][12] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][13]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][14]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][15] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][16]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][17]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][18] eq coupon.couponType}">
                                                                        <td style="text-align: center">${finalList[status.count -1][19]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][20]}</td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <td style="text-align: center">0</td>
                                                                        <td style="text-align: center">0</td>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                            <th style="text-align: center">${totalAmountFinal[status.count -1][0]}</th>
                                                        </tr>   
                                                    </c:forEach>
                                                </tbody>                                           
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