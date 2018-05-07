<%-- 
    Document   : reports
    Created on : May 5, 2018, 5:39:23 PM
    Author     : Aman
--%>

<%@page import="com.bul.zydex.model.EmployeeMaster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head onload="rrshowSlides(1);">
        <title>Report</title>
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Report</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Report</a></li>
                <li class="active"></li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">

                        <div class="tab-content">
                            <br>
                            <div class="row">

                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <a class="label label-primary" style="font-size: 20px"  href="hrServiceRequest.htm?act=searchSubmit">
                                        <i class="fa fa-envelope"></i><strong> HR Help Desk </strong>
                                    </a>
                                </div>
                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                    <a class="label label-primary" style="font-size: 20px" href="homeController.htm?act=kaizen">
                                        <i class="fa fa-twitch"></i>
                                        <strong>Kaizen</strong>
                                    </a>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-3">
                                    <!--<a class="label label-primary" style="font-size: 20px" href="hrServiceRequest.htm?act=searchSubmit">-->
                                    <a class="label label-primary" style="font-size: 20px" href="emergencyContact.htm?act=viewContact">
                                        <i class="fa fa-book"></i> &nbsp<strong>Emergency Contact</strong>
                                    </a>
                                </div>
                                <!--                                <div  class="col-xs-4 col-sm-4 col-md-3">
                                                                    <a class="label label-info" style="font-size: 20px"  href="classifiedBox.htm?act=searchSubmit" >
                                                                        <i class="fa fa-weixin"></i>
                                                                        <strong>Classified</strong>
                                                                    </a>
                                                                </div>-->


                            </div>
                            <br><br>
                            <div class="row">

                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <a class="label label-primary" style="font-size: 20px"  href="http://www.spcls.co.in/csr.aspx" target="_blank">
                                        <i class="fa fa-pencil-square-o"></i> &nbsp<strong>CSR</strong>
                                    </a>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <a class="label label-primary" style="font-size: 20px"  href="http://www.spcls.co.in/news-events.aspx" target="_blank">
                                        <i class="fa fa-newspaper-o"></i> &nbsp<strong>News & Event</strong>
                                    </a>
                                </div>
                                <div  class="col-xs-4 col-sm-4 col-md-3">
                                    <a class="label label-primary" style="font-size: 20px" href="holidayMaster.htm?act=viewHolidaysLocationWise">
                                        <i class="fa fa-twitch"></i>
                                        <strong>Holiday List</strong>
                                    </a>
                                </div>


                            </div>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</section>
</div>
<%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>








</html>




