<%--
    Document   : LocationList
    Created on : Oct 20, 2015, 12:46:42 PM
    Author     : Irfan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Assign Salary List</title>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Yearly Salary List:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Yearly Salary List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="" method="post" commandName="employeeSalaryProcess"
                   name='form2'  class="form-horizontal" role="form">


            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:choose>
                                    <c:when test="${!empty finalList}">
                                        <div class="box-header" style="text-align: right;">
                                            <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                            <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                        </div>
                                    </c:when>
                                </c:choose>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div id="printableArea">
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
                                            <!--                                                <header>
                                                                                                <center><b><font size="4">Employee Salary Report <c:if test="${month eq 1}">January</c:if>
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
                                            ' ${year}  </font></b></center> 
                                </header>-->
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <div class=" table table-bordered table-responsive">
                                                            <table id="tableid" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                <c:choose>
                                                                    <c:when test="${empty finalList}">
                                                                        <tr>
                                                                            <td align="center">
                                                                                <c:out value="There is no record found."></c:out>
                                                                                </td>
                                                                            </tr>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <thead>
                                                                            <tr>
                                                                                <c:forEach var="headerList" items="${headerList123}">
                                                                                    <th>${headerList}</th>  
                                                                                    </c:forEach>
                                                                            </tr>
                                                                        </thead>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <tbody>
                                                                    <c:forEach var="finalMap1" items="${finalList}">
                                                                        <tr>

                                                                            <c:forEach var="headeStr" items="${headerList123}">
                                                                                <td>
                                                                                    <c:if test="${finalMap1[headeStr] eq null}">-</c:if>
                                                                                    <c:if test="${finalMap1[headeStr] ne null}">${finalMap1[headeStr]}</c:if>
                                                                                    </td>

                                                                            </c:forEach>


                                                                        </tr>
                                                                    </c:forEach>

                                                                </tbody>                                           
                                                            </table>
                                                            <br>
                                                        <div class="row" align="center"><b>Note:</b>This is an electronically generated document, hence does not require signature</div>
                                                        </div>
                                                    </div>


                                                </div>  
                                            </div>
                                        </div> 
                                    </div>  
                                </div> 

                            </div>
                        </div> 
                    </div>
                </div>
            </section>


        </form:form>
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
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
