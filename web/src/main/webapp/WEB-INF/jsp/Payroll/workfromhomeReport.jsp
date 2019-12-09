<%--
    Document   : PayrollTaxRuleCreate
    Created on : Jul 14, 2016, 4:39:27 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1> Work From Home Report </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Report</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="attendanceRegularization" action="attendanceRegularizationMaster.htm?act=searchFormEmployeeWorkfromHomeDetailSubmit" >
                                    <div class="form-group">


                                        <div class="col-md-6" id="employeeName">
                                            <label>Employee Name:</label>
                                            <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                        </div>
                                    </div>



                                    <div class="form-group">


                                        <div class="col-sm-6">
                                            <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="startDateTime" class="form-control"  placeholder="Enter Start Date"></form:input>
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <errors id="startDateTimeerror" style="color:#dd4b39"></errors>
                                            </div>
                                            <!--                                        <div class="form-group">-->
                                            <div class="col-sm-6">
                                                <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="endDateTime" class="form-control"  placeholder="Enter End Date"></form:input>
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <errors path="endDateTimeerror"  style="color:#dd4b39"></errors>
                                            </div>

                                        </div>



                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>

                                        </div>
                                </form:form>
                                <form:form action="" method="post" commandName=""
                                           name='form2'  class="form-horizontal" role="form">
                                    <c:if test="${search ne 'none'}">

                                        <section class="content">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <!-- Custom Tabs -->
                                                    <div class="nav-tabs-custom">
                                                        <div class="tab-content">
                                                            <c:choose>
                                                                <c:when test="${!empty employeelist}">
                                                                    <div class="box-header" style="text-align: right;">
                                                                        <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                                        <input type="button" class="btn btn-facebook" style="width: 100px;"  value="Print" onclick="printDiv('printableArea')">
                                                                    </div>
                                                                </c:when>
                                                            </c:choose>
                                                            <div id="printableArea">
                                                                <div class="box-body no-padding">
                                                                    <div class="row">
                                                                        <div class="col-md-12 col-sm-12">
                                                                            <div class="table table-bordered">
                                                                                <table id="tableid"  class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                                    <c:choose>
                                                                                        <c:when test="${empty employeelist}">
                                                                                            <tr>
                                                                                                <td align="center">
                                                                                                    <c:out value="There is no record found."></c:out>
                                                                                                    </td>
                                                                                                </tr>
                                                                                        </c:when>
                                                                                        <c:otherwise>

                                                                                            <center> <img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/> </center>
                                                                                                <%
                                                                                                    Date date = new Date();
                                                                                                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                                                                    //                                           out.print( "Date.." + df.format(date));
                                                                                                    out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                                                                                                %>
                                                                                            <div class="form-group">
                                                                                                <center><b><font size="4">Vadera & Co.</font></b></center> 
                                                                                            </div>
                                                                                            <div class="form-group">
                                                                                                <header>
                                                                                                    <center><b><font size="4">Work From Home Report

                                                                                                            </font></b></center> 
                                                                                                </header>
                                                                                                &nbsp;
                                                                                            </div>
                                                                                            <thead>
                                                                                                <tr>

                                                                                                    <th>Sr.No</th>
                                                                                                    <th>Emp Id</th>
                                                                                                    <th>Emp Name</th>
                                                                                                    <th>Start Date Time</th>
                                                                                                    <th>End Date Time</th>
                                                                                                    <th>OT Hours</th>






                                                                                                </tr>
                                                                                            </thead>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                    <tbody>
                                                                                    <input style="display: none;" type="Text" name="employeeListLength"  value="${fn:length(employeelist)}"/>

                                                                                    <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                                                        <tr>
                                                                                            <c:if test="${list[0] ne null}">
                                                                                                <td>${status.count}</td>
                                                                                                <td>${list[0]}</td>
                                                                                                <td>${list[1]}</td>
                                                                                                <td>${list[2]}</td>
                                                                                                <td>${list[3]}</td>
                                                                                                <td>${list[4]}</td>
                                                                                            </c:if>









                                                                                        </tr>
                                                                                    </c:forEach>


                                                                                    </tbody>
                                                                                </table>
                                                                                <br>
                                                                                <div class="row" align="center"><b>Note:</b>This is an electronically generated document, hence does not require signature</div>
                                                                            </div>


                                                                            <c:if test="${!empty employeelist}">

                                                                            </c:if>

                                                                        </div><!-- /.col -->
                                                                    </div><!-- /.row -->
                                                                </div><!-- /.box-body -->
                                                            </div><!-- /.tab-content -->
                                                        </div><!-- nav-tabs-custom -->

                                                    </div>
                                                </div><!-- /.col -->
                                        </section>
                                    </div>
                                </c:if>
                            </div>
                        </form:form>
                    </div><!-- /.tab-pane -->
                </div><!-- /.tab-content -->
            </div><!-- nav-tabs-custom -->
    </div><!-- /.col -->
</div>
</section><!-- /.content -->
</div><!-- /.content-wrapper -->
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
        jQuery("#employeeMasterId").tokenInput(${list}, {
            preventDuplicates: true,
            noResultsText: "No Result",
            tokenLimit: "1",
            searchingText: "Searching ... .. .",
        });
    });
</script>
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
