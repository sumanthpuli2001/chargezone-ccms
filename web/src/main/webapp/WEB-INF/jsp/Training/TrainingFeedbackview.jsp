<%-- 
    Document   : TrainingFeedbackview
    Created on : Mar 26, 2018, 12:05:39 PM
    Author     : Aman
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>Feedback Details:</h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Feedback Details</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <!-- Custom Tabs -->
                <div class="nav-tabs-custom">
                    <div class="tab-content">
                        <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                            <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label>Employee Name : </label>&nbsp;&nbsp;${feedback[0][3]}
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>Description  : </label>&nbsp;&nbsp;${feedback[0][1]}
                                </div>
                                
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>DateTime : </label>&nbsp;&nbsp;${feedback[0][2]}
                                </div>
                                
                            </div>
                        </div>
                           
                    </div><!-- /.tab-content -->



                </div>
                <input type="button" class="btn btn-primary" value="Back" onclick="window.location = 'trainingIdentification.htm?act=showcalendar'" />
            </div>
        </div><!-- nav-tabs-custom -->
    </section>
    <!--        </div> /.col -->

</div>