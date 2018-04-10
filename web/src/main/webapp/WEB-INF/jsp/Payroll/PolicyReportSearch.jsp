<%--
    Document   : LeaveApplicatioFormForEmployee
    Created on : Oct 6, 2015, 11:17:03 AM
    Author     : Irfan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <div class="content-wrapper">
        <script>

            function saveSubmit11() {
                var flag3 = true;
//            alert(document.getElementById("month").value);
                if (document.getElementById("policyId1").value == '') {
                    document.getElementById("policyError").innerHTML = "- It must be selected.";
                    flag3 = false;
                } else {
                    document.getElementById("policyError").innerHTML = '';
                }
                if (document.getElementById("month").value == '') {
                    document.getElementById("monthError").innerHTML = "- It must be selected.";
                    flag3 = false;
                } else {
                    document.getElementById("monthError").innerHTML = '';
                }
//            alert(flag3);
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Policy :</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Policy</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <!--form horizontal starts here-->
                            <!--Read only entries Starts here-->
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <form:form action="policyMaster.htm?act=searchFormPolicyDetailSubmit" method="post" commandName="employeePolicyDetail"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <div class="box box-info">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-md-6" id="employeeName">
                                                        <label>Employee Name:</label>
                                                        <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                    </div>

                                                </div>


                                            </div><!-- /.col -->



                                        </div><!-- /.row -->
                                        <div class="row">
                                            <input type="hidden" name="policyName" id="policyName" value="${policyMaster.policyName}">
                                            <div class="col-sm-6">
                                                <label>policy Type :<span style="color: red;font-size: 12px;"></span></label>
                                                <select name="policyId1" id="policyId1"  class="form-control">
                                                    <option value="" label="-- Select --" ></option>
                                                    <c:forEach var="comp" items="${policy}">
                                                        <option value="${comp.key}" label="${comp.value}" ></option>
                                                    </c:forEach>
                                                </select>
                                                <span id="policyError" style="color: red;"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Months:<span style="color: red;font-size: 12px;">*</span></label>
                                                <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                <select name="month" id="month" class="form-control ">
                                                    <option value="">--Select--</option>
                                                    <option value="01">January</option>
                                                    <option value="02">February</option>
                                                    <option value="03">March </option>
                                                    <option value="04">April</option>
                                                    <option value="05">May</option>
                                                    <option value="06">June</option>
                                                    <option value="07">July</option>
                                                    <option value="08">August</option>
                                                    <option value="09">September</option>
                                                    <option value="10">October </option>
                                                    <option value="11">November </option>
                                                    <option value="12">December</option>

                                                </select>
                                                <span id="monthError" style="color: red;"></span>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>Year:<span style="color: red;font-size: 12px;"></span></label>  
                                                <select name="year11" id="year11" class="form-control ">

                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" style="text-align: left;">
                                        <button type="submit" id="sunmit_button" class="btn btn-primary" style="width: 100px;" data-original-title="" title="">SEARCH</button>
                                    </div>
                                </div>

                            </form:form>
                            <form:form action="" method="post" commandName="policyMaster.htm"
                                       name='form2'  class="form-horizontal" role="form">
                                <c:if test="${search ne 'none'}">
                                    <input type="hidden" name="month" value="${month}">
                                    <input type="hidden" name="year" value="${year}">
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
                                                                    <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                                                </div>

                                                                <div id="printableArea">

                                                                    <header>
                                                                        <center>  <img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/></center>
                                                                        <div class="form-group">
                                                                            <center><b><font size="4">SPC Life Science </font></b></center> 
                                                                        </div>
                                                                        <center><b><font size="4">${policyName[0]} Deduction Statement for the month of
                                                                                <c:if test="${month eq 1}">January</c:if>
                                                                                <c:if test="${month eq 2}">February</c:if>
                                                                                <c:if test="${month eq 3}">March</c:if>
                                                                                <c:if test="${month eq 4}">April</c:if>
                                                                                <c:if test="${month eq 5}">May</c:if>
                                                                                <c:if test="${month eq 6}">June</c:if>
                                                                                <c:if test="${month eq 7}">July</c:if>
                                                                                <c:if test="${month eq 8}">August</c:if>
                                                                                <c:if test="${month eq 9}">September</c:if>
                                                                                <c:if test="${month eq 10}">October</c:if>
                                                                                <c:if test="${month eq 11}">November</c:if>
                                                                                <c:if test="${month eq 12}">December</c:if>
                                                                                ${year} </font></b></center> 
                                                                    </header>



                                                                    <%
                                                                        Date date = new Date();
                                                                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                                        //                                           out.print( "Date.." + df.format(date));
                                                                        out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                                                                    %>
                                                                </c:when>
                                                            </c:choose>
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
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th>Sr.No</th>
                                                                                                <th>Emp Id</th>
                                                                                                <th>Emp Name</th>
                                                                                                <!--<th>Policy Type</th>-->
                                                                                                <th>Policy No</th>
                                                                                                <th> Amount To Ded.</th>
                                                                                                <th> Amount To Deducted.</th>



                                                                                            </tr>
                                                                                        </thead>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                                <tbody>
                                                                                <input style="display: none;" type="Text" name="employeeListLength"  value="${fn:length(employeelist)}"/>

                                                                                <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                                                                    <tr>
                                                                                        <td><c:out value = "${count}"/></td>
                                                                                        <td>${list[0]}</td>
                                                                                        <td>${list[1]}</td>
                                                                                        <!--<td>${list[4]}</td>-->
                                                                                        <td>${list[2]}0</td>
                                                                                        <td>${list[3]}0</td>
                                                                                        <td>${list[3]}0</td>





                                                                                    </tr>
                                                                                </c:forEach>
                                                                                <c:choose>
                                                                                    <c:when test="${!empty employeelist}">
                                                                                        <tr>
                                                                                            <td></td>
                                                                                            <td></td>
                                                                                            <td></td>

                                                                                            <td><b>Total Amount</b></td>
                                                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${totalpolicydeductionAmount}"></fmt:formatNumber>.00</td>
                                                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${totalpolicydeductionAmount}"></fmt:formatNumber>.00</td>



                                                                                            </tr>
                                                                                    </c:when>
                                                                                </c:choose>
                                                                                </tbody>
                                                                            </table>
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
                    <!--form horizontal ends here-->
                </div><!-- /.tab-content -->
            </div><!-- nav-tabs-custom -->
    </div><!-- /.col -->
</div>
</section><!-- /.content -->
</div><!-- /.content-wrapper -->

<script type="text/javascript">
    window.onload = init;
    function init() {
        document.form1.month.options[new Date().getMonth()].selected = true;
    }
    var start = 1990;
    var end = new Date().getFullYear();
    var options11 = "";

    for (var year1 = end; year1 >= start; year1--) {
        options11 += "<option>" + year1 + "</option>";
    }
    document.getElementById('year11').innerHTML = options11;
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
<style>
    .class-with-width { width: 150px !important; }
</style>    
<script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>  
</html>
