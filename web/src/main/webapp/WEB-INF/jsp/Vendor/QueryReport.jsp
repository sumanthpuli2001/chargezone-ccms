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
        <title>Tender Followup Report  </title>
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
            <h1>Tender Followup Report</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Followup Report</li>
            </ol>
        </section>
        
        
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="vendor.htm?act=queryReportSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Tender No. </label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="tender_no" class="form-control"   maxlength="100" />
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
                                            <c:when test="${!(vendorInfo eq 'empty')}"> 
                                                <!--<div class="box-header" style="text-align: right;">
                                                    <button type="button" id="btnExport" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                    <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                                </div>-->
                                            </c:when>
                                        </c:choose>
                                        <div id="printableArea">
                                            <table  id="tableid"  class="table table-bordered table-striped table-hover" style="" align="Center">
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
                                                            <tr  style="text-align: center">
                                                                <th>Sr No.</th>  
                                                                <th>Tender No.</th>  
                                                                <th>Subject</th>  
                                                                <th>Message</th>  
                                                                <th>From User</th>
                                                                <th>To User</th>
                                                                <th>Date Time</th>
                                                                
                                                            </tr>
                                                           
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="list" items="${commMaster}" varStatus="status">
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td> ${list.tenderNo}</td>
                                                            <td> ${list.subject}</td>
                                                            <td> ${list.msg}</td>
                                                            <td> ${list.vendorCode}</td>
                                                            <td> ${list.userId}</td>
                                                            <td> ${list.msgdatetime}</td>
                                                            
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