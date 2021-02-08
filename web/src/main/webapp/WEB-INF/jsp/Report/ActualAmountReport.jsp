<%-- 
    Document   : ActualAmountReport
    Created on : 08-Jul-2020, 16:29:27
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
        <form:form class="form-horizontal" role="form1" action="report.htm?act=searchAmountCoupon" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                    <label>Item:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="item" id="item" value="${item}" class="form-control"/>
                                                    <option value="All">All</option>
                                                    <c:forEach var="couponType" items="${couponMap}">
                                                        <c:choose>
                                                            <c:when test="${couponType.key eq item}">
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
                                        <div id="printableArea">
                                            <table  id="tableid"  class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <c:choose>
                                                    <c:when test="${empty finalList}">
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
                                                                <th colspan="30" style="text-align: center">
                                                                    GUJARAT INDUSTRIES POWER COMPANY LIMITED                                                            
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <th colspan="30" style="text-align: center">
                                                                    ACTUAL AMOUNT OF EMPLOYEE AND CONTRACTOR                                                
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <th colspan="30" style="text-align: center">
                                                                    REPORT OF CANTEEN COUPON CONSUMED From ${dFrom} To ${eFrom}  
                                                                </th>
                                                            </tr>
                                                            <tr  style="text-align: center">
                                                                <th rowspan="3">Date</th>
                                                                    <c:forEach var="coupon" items="${couponListAll}">
                                                                    <th style="text-align: center" colspan="2">${coupon.couponType}</th>
                                                                    </c:forEach>
                                                                <th rowspan="2">Total</th>
                                                            </tr>
                                                            <tr  style="text-align: center">
                                                                <c:forEach var="coupon" items="${couponListAll}">
                                                                    <th style="text-align: center" colspan="2">Rs ${coupon.acPrive}</th>
                                                                    </c:forEach>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="coupon" items="${couponListAll}">
                                                                    <th colspan="1">NO.</th>
                                                                    <th colspan="1">Rupees</th>
                                                                    </c:forEach>
                                                                <th >Rupees</th>
                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="finalList" items="${finalList}" varStatus="status">
                                                        <tr>
                                                            <td>${dateAmountFinalList[status.count-1][0]}</td>

                                                            <c:forEach var="coupon" items="${couponListAll}">
                                                                <c:choose>
                                                                    <c:when test="${finalList[0] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[1]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[1] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[3] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[4]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[4] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[6] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[7]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[7] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[9] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[10]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[10] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[12] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[13]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[13] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[15] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[16]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[16] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${finalList[18] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[19]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[19] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>
                                                                        <c:when test="${finalList[21] eq coupon.srNo}">
                                                                        <td style="text-align: center">${finalList[22]}</td>
                                                                        <td style="text-align: center"> 
                                                                            <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${finalList[22] * coupon.acPrive}" >
                                                                            </fmt:formatNumber>
                                                                        </td>
                                                                    </c:when>

                                                                    <c:otherwise>
                                                                        <td style="text-align: center">0</td>
                                                                        <td style="text-align: center">0</td>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                            <td > 
                                                                <fmt:formatNumber type = "number"  maxFractionDigits = "3"  value = "${dateAmountFinalList[status.count-1][1]}" >
                                                                </fmt:formatNumber>
                                                            </td>
                                                        </tr>   
                                                    </c:forEach>
                                                </tbody>  
                                               
                                                <thead>
                                                    <tr>
                                                        <th colspan="1" style="border: 1px solid black;">Total</th>

                                                        <c:forEach var="coupon" items="${couponListAll}" >

                                                            <c:if test="${item ne 'All'}">
                                                                <c:if test="${coupon.srNo eq '1'}">
                                                                    <th style="border: 1px solid black;">${tea}</th>
                                                                    <th style="border: 1px solid black;">${teaActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '2'}">
                                                                    <th style="border: 1px solid black;">${coffee}</th>
                                                                    <th style="border: 1px solid black;">${coffeeActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '3'}">
                                                                    <th style="border: 1px solid black;">${wet}</th>
                                                                    <th style="border: 1px solid black;">${wetActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '4'}">
                                                                    <th style="border: 1px solid black;">${dry}</th>
                                                                    <th style="border: 1px solid black;">${dryActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '5'}">
                                                                    <th style="border: 1px solid black;">${meals}</th>
                                                                    <th style="border: 1px solid black;">${mealActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '6'}">
                                                                    <th style="border: 1px solid black;">${ex1p}</th>
                                                                    <th style="border: 1px solid black;">${ex1pActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '7'}">
                                                                    <th style="border: 1px solid black;">${ex1r}</th>
                                                                    <th style="border: 1px solid black;">${ex1rActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '8'}">
                                                                    <th style="border: 1px solid black;">${ex1v}</th>
                                                                    <th style="border: 1px solid black;">${ex1vActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '9'}">
                                                                    <th style="border: 1px solid black;">${ex2}</th>
                                                                    <th style="border: 1px solid black;">${ex2Actual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '10'}">
                                                                    <th style="border: 1px solid black;">${ex2p}</th>
                                                                    <th style="border: 1px solid black;">${ex2pActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '11'}">
                                                                    <th style="border: 1px solid black;">${milk}</th>
                                                                    <th style="border: 1px solid black;">${milkActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '12'}">
                                                                    <th style="border: 1px solid black;">${ag}</th>
                                                                    <th style="border: 1px solid black;">${agActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '13'}">
                                                                    <th style="border: 1px solid black;">${sc}</th>
                                                                    <th style="border: 1px solid black;">${scActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                    <c:if test="${coupon.srNo eq '14'}">
                                                                    <th style="border: 1px solid black;">${Bmilk}</th>
                                                                    <th style="border: 1px solid black;">${BmilkActual}</th>

                                                                    <th style="border: 1px solid black;">${newAmount}</th>
                                                                    </c:if>
                                                                </c:if>
                                                                <c:if test="${item eq 'All'}">
                                                                    <c:if test="${coupon.srNo eq '1'}">
                                                                    <th style="border: 1px solid black;">${tea}</th>
                                                                    <th style="border: 1px solid black;">${teaActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '2'}">
                                                                    <th style="border: 1px solid black;">${coffee}</th>
                                                                    <th style="border: 1px solid black;">${coffeeActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '3'}">
                                                                    <th style="border: 1px solid black;">${wet}</th>
                                                                    <th style="border: 1px solid black;">${wetActual}</th>
                                                                     <th style="border: 1px solid black;">${newAmount}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '4'}">
                                                                    <th style="border: 1px solid black;">${dry}</th>
                                                                    <th style="border: 1px solid black;">${dryActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '5'}">
                                                                    <th style="border: 1px solid black;">${meals}</th>
                                                                    <th style="border: 1px solid black;">${mealActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '6'}">
                                                                    <th style="border: 1px solid black;">${ex1p}</th>
                                                                    <th style="border: 1px solid black;">${ex1pActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '7'}">
                                                                    <th style="border: 1px solid black;">${ex1r}</th>
                                                                    <th style="border: 1px solid black;">${ex1rActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '8'}">
                                                                    <th style="border: 1px solid black;">${ex1v}</th>
                                                                    <th style="border: 1px solid black;">${ex1vActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '9'}">
                                                                    <th style="border: 1px solid black;">${ex2}</th>
                                                                    <th style="border: 1px solid black;">${ex2Actual}</th>

                                                                    </c:if>
                                                                <c:if test="${coupon.srNo eq '10'}">
                                                                    <th style="border: 1px solid black;">${ex2p}</th>
                                                                    <th style="border: 1px solid black;">${ex2pActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '11'}">
                                                                    <th style="border: 1px solid black;">${milk}</th>
                                                                    <th style="border: 1px solid black;">${milkActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '12'}">
                                                                    <th style="border: 1px solid black;">${ag}</th>
                                                                    <th style="border: 1px solid black;">${agActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '13'}">
                                                                    <th style="border: 1px solid black;">${sc}</th>
                                                                    <th style="border: 1px solid black;">${scActual}</th>

                                                                </c:if>
                                                                <c:if test="${coupon.srNo eq '14'}">
                                                                    <th style="border: 1px solid black;">${Bmilk}</th>
                                                                    <th style="border: 1px solid black;">${BmilkActual}</th>

                                                                   
                                                                    </c:if>
                                                                </c:if>
                                                            </c:forEach>
                                                    </tr>
                                                </thead>

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