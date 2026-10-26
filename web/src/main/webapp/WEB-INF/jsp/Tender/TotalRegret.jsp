<%-- 
    Document   : VendorEvaluation
    Created on : 7 Jun, 2022, 4:15:03 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title>Vendor Tender Regret Info  </title>
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
            <h1>Vendor Tender Regret Info</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor Tender Regret Info</li>
            </ol>
        </section>
        
        
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
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
                                                        <thead>
                                                            <tr  style="text-align: center">
                                                                <th>Sr No.</th>  
                                                                <th>Tender No.</th>
                                                                
                                                            </tr>
                                                        </thead>
                                                <tbody>
                                                        <tr>
                                                            <c:forEach var="list3" items="${list3}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td>${list3.refNo}</td>
                                                                        
                                                                    </tr>
                                                                </c:forEach>
                                                            
                                                        </tr>   
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
