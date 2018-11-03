<%-- 
    Document   : VisitorRequestSecurityViewPrint
    Created on : Aug 29, 2018, 4:46:19 PM
    Author     : DELL3
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Print</title>
        <style>
            table {
                border:1px solid #000 !important;
                padding: 3px !important;
            }
            th, td {
                padding: 3px !important;
                border:1px solid #000 !important;
            }
        </style>
    </head>
    <body onload="window.print();">
        <!--<body>-->
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Visitor's Pass</h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
                    <li class="active">Visitor's Pass</li>
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
                                    <c:if test="${!empty successMessage}">
                                        <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                    </c:if>
                                    <c:if test="${!empty failureMessage}">
                                        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                    </c:if>

                                    <form:form action="" method="post" commandName="visitorManagement" name='form1' class="form-horizontal" id="form1" role="form">
                                        <!--<h3 style="text-align: center;border-bottom: 2px solid black;font-size: 18px !important;"><b>Visitor's Pass</b></h3>-->
                                        <div class="table-responsive" >
                                            <table class="table table-bordered table-responsive" style="border: 1px solid black !important;">
                                                <tr>
                                                    <td style="font-size: 16px !important; vertical-align: middle; width:120px">
                                                        <img style="width:120px; height: 120px;" src="StorageYard/companylogo/spc.jpg" class="img-responsive" alt="SPC"></img>
                                                    </td>
                                                    <td style="text-align: center; vertical-align: middle;padding:0 0 !important;">
                                                        <h3>SPC Lifesciences - ${zlm.zydexLocation}</h3>
                                                        <!--<h4><small>(${zlm.zydexLocation})</small></h4>-->
                                                        <h5><b>Visitor's Pass(Valid for One Day)</b></h5>
                                                    </td>
                                                    <td style="text-align: right; vertical-align: middle;width:145px">
                                                        <img style="width: 145px; height: 120px;" src="${visitorManagement.visitorPhotograph}" class="img-responsive"></img>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="table-responsive table-bordered">
                                            <table class="table table-responsive" style="font-size: 14px;text-align: left;">
                                                <tr style="font-size: 12px !important; vertical-align: middle;">
                                                    <!--                                                    <td><b>Requested By:</b></td>
                                                                                                        <td>${employeeMaster.employeeName}</td>-->
                                                    <td><b>Visitor Name:</b></td>
                                                    <td>${visitorManagement.visitorName}</td>
                                                    <td><b>Visitor Organization:</b></td>
                                                    <td>${visitorManagement.visitorOrganization}</td>
                                                </tr>
                                                <!--                                                <tr style="font-size: 12px !important; vertical-align: middle;">
                                                                                                    <td><b>Requested Date:</b></td>
                                                                                                    <td>${visitorManagement.requestDate}</td>
                                                                                                    
                                                                                                </tr>-->
                                                <tr style="font-size: 12px !important; vertical-align: middle;">
                                                    <td><b>Incoming Date & Time:</b></td>
                                                    <td>${incomingTime}</td>
                                                    <td><b>Visitor Visits To:</b></td>
                                                    <td>${employeeVisitsTo.employeeName}&nbsp;(${designation.designationName})</br>M:&nbsp;${employeeVisitsTo.contactNo1}</td>
                                                </tr>
                                                <c:if test="${(visitorManagement.meetingOffDate ne null and visitorManagement.meetingOffDate ne '') and (visitorManagement.visitorComingFrom ne null and visitorManagement.visitorComingFrom ne '')}">
                                                    <tr style="font-size: 12px !important; vertical-align: middle;">
                                                        <td><b>Meeting Off Date:</b></td>
                                                        <td>${visitorManagement.meetingOffDate}</td>
                                                        <td><b>Outgoing Date:</b></td>
                                                        <td>${visitorManagement.outgoingDateTime}</td>
                                                    </tr>
                                                </c:if>
                                                <tr style="font-size: 12px !important; vertical-align: middle;">
                                                    <td><b>Visitor Contact:</b></td>
                                                    <td>${visitorManagement.visitorContactDetail}</td>
                                                    <td><b>Visitor Coming From:</b></td>
                                                    <td>${visitorManagement.visitorComingFrom}</td>
                                                </tr>
                                                <tr style="font-size: 12px !important; vertical-align: middle;">
                                                    <td><b>Accessories:</b></td>
                                                    <td colspan="3">${visitorManagement.accesories}</td>
                                                </tr>
                                                <tr style="font-size: 12px !important; vertical-align: middle;">
                                                    <td><b>Reason:</b></td>
                                                    <td colspan="3">${visitorManagement.reason}</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-responsive">
                                                <tr>
                                                    <td style="font-size: 12px !important; vertical-align: middle;text-align: center;width:200px;">
                                                        <b>Visitor's Signature</b>
                                                    </td>
                                                    <td style="font-size: 12px !important; vertical-align: middle;text-align: center;width:200px;">
                                                        <b>Security Signature</b>
                                                    </td>
                                                    <td style="font-size: 12px !important; vertical-align: middle;text-align: center;" colspan="2">
                                                        <b>Visited Person's Signature & Time</b>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td></br></br></td>
                                                    <td></br></br></td>
                                                    <td style="font-size: 8px;text-align: center;vertical-align: baseline !important;"></br></br></br>-------------------------</br>Signature</td>
                                                    <td style="font-size: 8px;text-align: center;vertical-align: baseline !important;"></br></br></br>-------------------------</br>Date & Time</td>
                                                </tr>
                                            </table> 
                                        </div>
                                    </form:form>
                                </div>

                            </div> <!-- /container -->

                        </div> 
                    </div> 
                </div> 
            </section> 
        </div> 
    </body>
</html>
