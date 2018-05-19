<%-- 
    Document   : Form5
    Created on : May 16, 2018, 1:06:56 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head> 
        <title>Form 5 </title>

    </head>
    <style>
        table, th, th {
            border: 2px solid black;
            border-collapse: collapse;
        }
        th, th {
            padding: 15px;
        }
    </style>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Form 5</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Reports</a></li>
                <li class="active">Form 5</li>
            </ol>
        </section>
        <form:form action="kaizen.htm?act=kaizenSubmit" method="post" commandName="kaizenMaster" enctype="multipart/form-data"  
                   onsubmit='return checkBlankField();' name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">

                                <div class="table">
                                    <table style="width:100%">
                                        <div style="text-align: center;font-size: 25px;"><strong>Employees Provident Fund Scheme</strong></div>
                                        <div style="text-align: center;font-size: 25px;"><strong>Form 5</strong></div>
                                        <div style="text-align: center;font-weight: bold;">[Paragraph 36(2)(a) of the Employees’ Provident Funds Scheme, 1952 and <br>
                                            Para 20(4) of the Employees’ Pension Scheme, 1995]
                                        </div>
                                        <br>
                                        <div style="text-align: center;font-weight: bold;">
                                            Return of Employees qualifying for membership of the Employees’ Provident<br>
                                            Fund, Employees Pension Fund & Employees’ Deposit Linked Insurance Fund <br>
                                            for the first time during the month of_____________________			
                                        </div>
                                        <br>
                                        <div style="text-align: center;font-weight: bold;">
                                            (To be sent to the Commissioner with Form 2 (EPF & EPS)
                                        </div>
                                        <div style="text-align: center;font-weight: bold;">
                                            Name and Address of the Factory/Establishment___________________________<br>
                                            ______________________________________________________________________
                                        </div>
                                        <br>
                                        <div style="text-align: center;font-weight: bold;">
                                            Code No. of Factory/Establishment ……………………………………………………
                                        </div>

                                        <tr>
                                            <th colspan="1">SI.No</th>
                                            <th colspan="2">User ID</th>
                                            <th colspan="3">Name of Employee (in block capitals)</th>
                                            <th colspan="3">Father’s name (or Husband’s name in case of married woman)</th>
                                            <th colspan="2">Date of Birth</th>
                                            <th colspan="1">Sex</th>
                                        </tr>
                                        <tbody>
                                            <c:forEach var="list"  items="${list}" varStatus="loop">
                                                <tr>
                                                    <td colspan="1" style="text-align: center">${loop.index + 1}</td>
                                                    <td colspan="2" style="text-align: center">${list[1]}</td>
                                                    <td colspan="3" style="text-align: center">${list[2]}</td>
                                                    <td colspan="3" style="text-align: center">${list[3]}</td>
                                                    <td colspan="2" style="text-align: center">${list[4]}</td>
                                                    <td colspan="1" style="text-align: center">
                                                        <c:if test="${list[5] eq false}">
                                                            Male
                                                        </c:if>
                                                        <c:if test="${list[5] eq true}">
                                                            Female
                                                        </c:if>
                                                    </td>
                                                    <!--<td colspan="1" style="text-align: center">${list[5]}</td>-->
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <div>
                                        <div style="text-align: right;font-weight: bold;margin-top: 70px;">
                                            Signature of the Employer or<br>
                                            other authorised officer of the<br>
                                            Factory/Establishment
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Date ……………..	
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            Stamp of the Factory/Establishment
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <br>
                                        <br>
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="button" class="btn btn-primary" value="Print" onclick="window.print('printDiv')">
                                            <!--<input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">-->
                                        </div>
                                    </div>
                                </div>
                            </div> <!--/tab-content -->
                        </div><!-- nav-tabs-custom -->


                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
</html>