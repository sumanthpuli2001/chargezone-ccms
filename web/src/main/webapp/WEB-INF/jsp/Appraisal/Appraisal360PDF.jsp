<%-- 
    Document   : Appraisal360PDF
    Created on : Mar 18, 2016, 12:35:30 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appraisal Feedback Form</title>
        <script>
            window.print();
        </script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
<div class="box-header" style="text-align: right;">
                            <span><img src="StorageYard/Images/logo.png"  style="text-align: right;"/></span>
                        </div>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">

                            <!--form horizontal starts here-->
                            <form:form action="appraisal360.htm?act=submitAppraisal360Employee" method="post" commandName="appraisal360" name='form1' class="form-horizontal" role="form">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Details of Employee about whom feedback is given:</h3>
                                        <div class="box-tools pull-right">
                                            <!--<span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Employee Name:<span style="color: red;font-size: 12px;"></span>&nbsp;&nbsp;&nbsp;${(list.get(0))[0]}</label>
                                                        <!--<input  class="form-control" readonly="true" value="${(list.get(0))[0]}"></input>-->

                                                    </div>

                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span>&nbsp;&nbsp;&nbsp;${(list.get(0))[2]}</label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->

                                                        <!--<input class="form-control" name="performedDateStr" id="performedDateStr" value="${(list.get(0))[2]}"  readonly='true'/>-->
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                        <!--<div style="color: red">-->
                                                        <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                        <!--</div>-->
                                                        <!--</div>-->
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date:<span style="color: red;font-size: 12px;"></span>&nbsp;&nbsp;&nbsp;${(list.get(0))[3]}</label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                        <!--<input class="form-control" name="completeDateStr" id="completeDateStr" value="${(list.get(0))[3]}" readonly='true'/>-->
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                        <!--<div style="color: red">-->
                                                        <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                        <!--</div>-->
                                                    </div>
                                                </div>
                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                <c:forEach var="list" items="${list}" varStatus="index">
                                    <hr>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Details of ${list[1]} , who is giving a feedback:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<span id="spanId${index.count}">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun${index.count}();"><i class="fa fa-plus" id="minusId${index.count}" ></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Status:&nbsp;&nbsp;&nbsp;</label>
                                                            <c:if test="${list[9]eq 0}">
                                                                Pending
                                                            </c:if>
                                                            <c:if test="${list[9]eq 1}">
                                                                Completed
                                                            </c:if>


                                                        </div>
                                                    </div>


                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="table-responsive">
                                                                <table border="1" cellspacing="0" id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                    <tr style="background-color: darkgrey">
                                                                        <th style="text-align: center;" colspan="6">BEHAVIORS</th>
                                                                    </tr>
                                                                    <tr style="background-color: darkgrey">
                                                                        <th style="text-align: center;" colspan="6">Please rate Winning Leadership Behaviours (WLB) on a 5 Pointer Rating Scale</th>
                                                                    </tr>


                                                                    <tr style="background-color: darkgrey">
                                                                        <th><b>Winning Leadership Behaviors (WLB)</b></th>
                                                                        <th style="width: 10%;text-align: center">Below Average</th>
                                                                        <th style="width: 10%;text-align: center">Average</th>
                                                                        <th style="width: 10%;text-align: center">Good</th>
                                                                        <th style="width: 10%;text-align: center">Very Good</th>
                                                                        <th style="width: 10%;text-align: center">Excellent</th>
                                                                    </tr>
                                                                    <tr style="background-color: lightgrey">
                                                                        <th></th>
                                                                        <th style="width: 15px; text-align: center">1</th>
                                                                        <th style="width: 15px; text-align: center">2</th>
                                                                        <th style="width: 15px; text-align: center">3</th>
                                                                        <th style="width: 15px; text-align: center">4</th>
                                                                        <th style="width: 15px; text-align: center">5</th>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${list[4]eq 0}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="1" checked="checked"/></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="3" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="4" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="5" ></td>
                                                                            </c:if>

                                                                        <c:if test="${list[4]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="3" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="4" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 1: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[11]}</textarea></td>
                                                                    </tr>

                                                                    <tr>
                                                                        <c:if test="${list[5]eq 0}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r7${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r7${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r7${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r7${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r7${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r8${index.count}" value="1" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r8${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r8${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r8${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r8${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r9${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r9${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r9${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r9${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r9${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r10${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r10${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r10${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r10${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r10${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r11${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r11${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r11${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r11${index.count}" value="4" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r11${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r12${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r12${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r12${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r12${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r12${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 2: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[12]}</textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${list[6]eq 0}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r13${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r13${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r13${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r13${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r13${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r14${index.count}" value="1" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r14${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r14${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r14${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r14${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r15${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r15${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r15${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r15${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r15${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r16${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r16${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r16${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r16${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r16${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r17${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r17${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r17${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r17${index.count}" value="4" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r17${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r18${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r18${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r18${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r18${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r18${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 3: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[13]}</textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${list[7]eq 0}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r19${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r19${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r19${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r19${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r19${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 1}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r20${index.count}" value="1" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r20${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r20${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r20${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r20${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 2}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r21${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r21${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r21${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r21${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r21${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 3}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r22${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r22${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r22${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r22${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r22${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 4}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r23${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r23${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r23${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r23${index.count}" value="4"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r23${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 5}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r24${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r24${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r24${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r24${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r24${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 4: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[14]}</textarea></td>
                                                                    </tr>
                                                                    <tr >
                                                                        <c:if test="${list[8]eq 0}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r25${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r25${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r25${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r25${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r25${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r26${index.count}" value="1"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r26${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r26${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r26${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r26${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r27${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r27${index.count}" value="2"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r27${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r27${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r27${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r28${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r28${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r28${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r28${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r28${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r29${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r29${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r29${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r29${index.count}" value="4"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r29${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r30${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r30${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r30${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r30${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r30${index.count}" value="5"  checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 5: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[15]}</textarea></td>
                                                                    </tr>

                                                                    <!--                                                        <tr>
                                                                                                                                <td  style="background-color: lightgrey"><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                                                                                <td><input type="radio" value=""></td>
                                                                                                                                <td><input type="radio" value=""></td>
                                                                                                                                <td><input type="radio" value=""></td>
                                                                                                                                <td><input type="radio" value=""></td>
                                                                                                                                <td><input type="radio" value=""></td>
                                                                                                                            </tr>-->

                                                                </table>
                                                            </div>
                                                        </div><!-- /.col -->

                                                        <!--/.col-->
                                                        <!--<div class="box-body no-padding">-->
                                                        <!--<div class="row">-->
                                                        <!--<div class="col-md-12 col-sm-12">-->

                                                        <!--</div> /.row -->
                                                        <!--</div> /.box-body -->
                                                        <!--</div> /.box-body -->
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <br/>
                                                    <br/>
                                                    <label>Additional Employee Remarks / Comments:&nbsp;&nbsp;&nbsp;${list[10]}</label>
                                                    <!--<textarea  class="form-control"  readonly="true">${list[10]}</textarea>-->
                                                </div>
                                            </div><!-- /.col -->
                                        </div>

                                    </div>

                                </c:forEach>
                                <!--Additional Remark and Comments In Detail completes Here-->

                            </form:form>
                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                            <!--</div> /.tab-content -->
                        </div>
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div>
</div><!-- /.content-wrapper -->


</html>

