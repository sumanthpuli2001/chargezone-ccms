<%-- 
    Document   : DayCouponReport
    Created on : Jul 1, 2020, 12:30:16 PM
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

                                                <!--                                                <div class="col-sm-3">
                                                                                                    <label class="control-label">Name :<span style="color: red;font-size: 12px;">*</span></label>
                                                                                                    <input name="name" id="name"  class="form-control" value="${name}" size="16" />
                                                                                                </div>-->
                                                <div class="col-sm-3">
                                                    <label class="control-label">Code :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <input name="cardCode" id="cardCode"  class="form-control" value="${cardCode}" size="16" />
                                                </div>
                                            </div>
                                            <div class="form-group">

                                                <div class="col-sm-3">
                                                    <label>Item:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="item" id="item" value="${item}" class="form-control"/>
                                                    <option value="All">All</option>
                                                    <c:forEach var="couponType" items="${couponMap}">
                                                        <%--<c:choose>--%>
                                                        <%--<c:when test="${couponType.key eq item}">--%>
                                                            <!--<option value="${couponType.key}" selected="true">${couponType.value}</option>-->
                                                        <%--</c:when>--%>
                                                        <%--<c:otherwise>--%>
                                                        <option value="${couponType.key}">${couponType.value}</option>
                                                        <%--</c:otherwise>--%>
                                                        <%--</c:choose>--%>
                                                    </c:forEach>
                                                    </select>
                                                    <span id="companyError" style="color: red;"></span>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">Select Report Type :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="type" id="type" value="${type}"  class="form-control">
                                                        <option value="D">Daily Basis</option>
                                                        <option value="M">Monthly Basis</option>
                                                    </select>
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
                                                    <button type="button" id="btnExport" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                    <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
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
                                                                <th colspan="47" style="text-align: center">
                                                                    GUJARAT INDUSTRIES POWER COMPANY LIMITED                                                            
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <th colspan="47" style="text-align: center">
                                                                    COUPONS Report From ${dFrom} To ${eFrom}                                                          
                                                                </th>
                                                            </tr>
                                                            <tr  style="text-align: center">
                                                                <th rowspan="3">Sr.No</th>  
                                                                <th rowspan="3">Date</th>
                                                                <th rowspan="3">Code</th>
                                                                <th rowspan="3">Name Of EMPLOYEE</th>
                                                                <th colspan="25" style="text-align: center">Denomination No. of Coupons Issued</th>
                                                                <th rowspan="2">Total</th>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="coupon" items="${couponList}">
                                                                    <th style="text-align: center" colspan="3">${coupon.couponType}</th>
                                                                    </c:forEach>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="coupon" items="${couponList}">
                                                                    <th colspan="1">Rs(S)${coupon.couponPrice}</th>
                                                                    <th colspan="1">Rs(S)${coupon.secondPrice}</th>
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
                                                            <td>${personDetailsFinal[1]}</td>
                                                            <td>${personDetailsFinal[2]}</td>

                                                            <c:forEach var="coupon" items="${couponList}">
                                                                <c:choose>
                                                                    <c:when test="${finalList[status.count -1][0] eq coupon.couponType && finalList[status.count -1][0] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][1]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][2]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][3]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][4] eq coupon.couponType && finalList[status.count -1][4] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][5]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][6]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][7]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][8] eq coupon.couponType && finalList[status.count -1][8] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][9]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][10]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][11]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][12] eq coupon.couponType && finalList[status.count -1][12] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][13]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][14]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][15]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][16] eq coupon.couponType && finalList[status.count -1][16] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][17]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][18]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][19]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][20] eq coupon.couponType && finalList[status.count -1][20] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][21]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][22]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][23]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][24] eq coupon.couponType && finalList[status.count -1][24] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][25]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][26]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][27]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][28] eq coupon.couponType && finalList[status.count -1][28] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][29]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][30]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][31]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][32] eq coupon.couponType && finalList[status.count -1][32] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][33]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][34]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][35]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][36] eq coupon.couponType && finalList[status.count -1][36] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][37]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][38]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][39]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][40] eq coupon.couponType && finalList[status.count -1][40] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][41]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][42]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][43]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][44] eq coupon.couponType && finalList[status.count -1][44] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][45]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][46]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][47]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][48] eq coupon.couponType && finalList[status.count -1][48] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][49]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][50]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][51]}</td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[status.count -1][52] eq coupon.couponType && finalList[status.count -1][52] ne '0'}">
                                                                        <td style="text-align: center">${finalList[status.count -1][53]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][54]}</td>
                                                                        <td style="text-align: center">${finalList[status.count -1][55]}</td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <td style="text-align: center">0</td>
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
    function ExportToExcel() {
        var htmltable = document.getElementById('tableid');
        var html = htmltable.outerHTML;
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
    }
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>