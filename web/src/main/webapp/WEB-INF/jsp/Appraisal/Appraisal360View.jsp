


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appraisal Feedback Form</title>
    </head>

    <script>     
        $(function () {
            $("#WorkTypeSelectId").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "HourlyBase") {
                    $('#hourlyBaseTitleDiv').show();
                    $('#shiftNameDiv').hide();

                } else if (selectedValue == "ShiftBase") {
                    $('#shiftNameDiv').show();
                    $('#hourlyBaseTitleDiv').hide();
                } else {
                    $('#hourlyBaseTitleDiv').hide();
                    $('#shiftNameDiv').hide();
                }
            });
            $('input:radio[name="group2"]').change(function () {
                if ($(this).is(':checked') && $(this).val() == 'married') {
                    $('#spousNameDiv').show();
                } else {
                    $('#spousNameDiv').hide();
                }
            });
        });
    </script>
    <script>
        function buttonFun1() {
            var className = $('#minusId1').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId1').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId1').innerHTML = 'Expand';
            }
        }
        function buttonFun2() {
            var className = $('#minusId2').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId2').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId2').innerHTML = 'Expand';
            }
        }
        function buttonFun3() {
            var className = $('#minusId3').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId3').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId3').innerHTML = 'Expand';
            }
        }
        function buttonFun4() {
            var className = $('#minusId4').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId4').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId4').innerHTML = 'Expand';
            }
        }
        function buttonFun5() {
            var className = $('#minusId5').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId5').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId5').innerHTML = 'Expand';
            }
        }

    </script>
    <script>
        function appraisal360Print() {
            var ForID = '${param.ForID}';
            var perDate = '${param.perDate}';
            var compDate = '${param.compDate}';
//            var userid = document.getElementById("userid").value;
//            var appraisalId = document.getElementById("appraisalId").value;
//            alert(empId);
//            alert(appraisalId);
//            alert(userid);
            var path = 'appraisal360.htm?act=exportToPDF&ForID=' + ForID + '&perDate=' + perDate + '&compDate=' + compDate;
//            ;
//             window.print(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes')
            popupWindow = window.open(path, 'popUpWindow', 'height=700,width=900,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes,type=text/css')
//             mywindow.document.write('<link rel="stylesheet" href="/WEB-INF/jsp/Common/Top.jsp" type="text/css" />');
//            window.print();
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>360 Degree Feedback Form:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">360 Appraisal</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <!--<input type="button" class="btn btn-primary" value="PRINT" style="width: 100px;" text-align="right"/>-->
                            <!--<div class="col-sm-2">-->
                            <!--</div>-->
                            <span style="alignment-adjust: right;">
                                <button type="button" class="btn btn-facebook" style="width: 100px;text-align: right;" onclick="appraisal360Print();"><i class="fa fa-file-pdf-o"></i>&nbsp&nbsp;EXPORT</button>
                            </span>
                            <br/>
                            <br/>
                            <!--form horizontal starts here-->
                            <form:form action="appraisal360.htm?act=submitAppraisal360Employee" method="post" commandName="appraisal360" name='form' id="form1" class="form-horizontal" role="form1">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Details of Employee about whom feedback is given:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Employee Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <input  class="form-control" readonly="true" value="${(list.get(0))[0]}"></input>

                                                    </div>

                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->

                                                        <input class="form-control" name="performedDateStr" id="performedDateStr" value="${(list.get(0))[2]}"  readonly='true'/>
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                        <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                        <!--<div style="color: red">-->
                                                        <%--<form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                        <!--</div>-->
                                                        <!--</div>-->
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                        <input class="form-control" name="completeDateStr" id="completeDateStr" value="${(list.get(0))[3]}" readonly='true'/>
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
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Details of ${list[1]} , who is giving a feedback:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId${index.count}">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun${index.count}();"><i class="fa fa-plus" id="minusId${index.count}" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Status:</label>
                                                            <c:if test="${list[9]eq 0}">
                                                                <input  class="form-control" readonly="true" value="Pending"></input>
                                                            </c:if>
                                                            <c:if test="${list[9]eq 1}">
                                                                <input  class="form-control" readonly="true" value="Completed"></input>
                                                            </c:if>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="table-responsive">
                                                                <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="1" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="2" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="3" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="4" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r1${index.count}" value="5" disabled='disabled'></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="1" checked="checked"/></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="2" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="3" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="4" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r2${index.count}" value="5" disabled='disabled'></td>
                                                                            </c:if>

                                                                        <c:if test="${list[4]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="1" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="2" checked="checked" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="3" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="4" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r3${index.count}" value="5" disabled='disabled'></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="1" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="2" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="3" checked="checked" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="4" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r4${index.count}" value="5" disabled='disabled'></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="1" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="2" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="3" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="4" checked="checked" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r5${index.count}" value="5" disabled='disabled'></td>
                                                                            </c:if>
                                                                            <c:if test="${list[4]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="1" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="2" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="3" disabled='disabled'></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r6${index.count}" value="4" disabled='disabled'></td>
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
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r7${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r7${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r7${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r7${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r7${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r8${index.count}" value="1" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r8${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r8${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r8${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r8${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r9${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r9${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r9${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r9${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r9${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r10${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r10${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r10${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r10${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r10${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r11${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r11${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r11${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r11${index.count}" value="4" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r11${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[5]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r12${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r12${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r12${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r12${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r12${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 2: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[12]}</textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${list[6]eq 0}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r13${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r13${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r13${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r13${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r13${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r14${index.count}" value="1" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r14${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r14${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r14${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r14${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r15${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r15${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r15${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r15${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r15${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r16${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r16${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r16${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r16${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r16${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r17${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r17${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r17${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r17${index.count}" value="4" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r17${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[6]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r18${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r18${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r18${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r18${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r18${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 3: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control" readonly="true">${list[13]}</textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${list[7]eq 0}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r19${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r19${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r19${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r19${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r19${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 1}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r20${index.count}" value="1" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r20${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r20${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r20${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r20${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 2}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r21${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r21${index.count}" value="2" checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r21${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r21${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r21${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 3}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r22${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r22${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r22${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r22${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r22${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 4}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r23${index.count}" value="1"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r23${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r23${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r23${index.count}" value="4"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r23${index.count}" value="5" ></td>
                                                                            </c:if>
                                                                            <c:if test="${list[7]eq 5}">
                                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r24${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r24${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r24${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r24${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r24${index.count}" value="5" checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 4: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[14]}</textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${list[8]eq 0}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r25${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r25${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r25${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r25${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r25${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 1}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r26${index.count}" value="1"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r26${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r26${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r26${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r26${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 2}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r27${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r27${index.count}" value="2"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r27${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r27${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r27${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 3}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r28${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r28${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" name="r28${index.count}" value="3"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r28${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r28${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 4}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r29${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r29${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r29${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r29${index.count}" value="4"  checked="checked"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r29${index.count}" value="5"></td>
                                                                            </c:if>
                                                                            <c:if test="${list[8]eq 5}">
                                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r30${index.count}" value="1" ></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r30${index.count}" value="2"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r30${index.count}" value="3"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio" disabled='disabled' name="r30${index.count}" value="4"></td>
                                                                            <td style="text-align: center;vertical-align: middle"><input type="radio"  name="r30${index.count}" value="5"  checked="checked"></td>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="background-color: lightgrey"><b>WLB 5: Remark:</b></td>
                                                                        <td colspan="5"> <textarea  class="form-control"  readonly="true">${list[15]}</textarea></td>
                                                                    </tr>

                                                                    <!--                                                        <tr>
                                                                                                                                <td  style="background-color: lightgrey"><b style="font-size: 16px">TOTAL SCORE</b></td>
                                                                                                                                <td><input type="radio" disabled='disabled' value=""></td>
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
                                                    <label>Additional Employee Remarks / Comments:</label>
                                                    <textarea  class="form-control"  readonly="true">${list[10]}</textarea>
                                                </div>
                                            </div><!-- /.col -->
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label>Average result of feedback marks given by, ${list[1]}</label>
                                                    <div class="table table-bordered">
                                                        <table class="table table-bordered ">
                                                            <tr>    
                                                                <th>Given Remarks</th> 
                                                                <th>Total Remarks</th>
                                                            </tr>

                                                            <tr>
                                                                <td class='tdGivenRemarks'>${list[4]+list[5]+list[6]+list[7]+list[8]}</td>
                                                                <td>25</td>
                                                            </tr>  
                                                        </table>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div>

                                    </div>

                                </c:forEach>
                                
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Average Remarks given by all eligible Employees:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Average Remarks given by all Employees : </span></label>
                                                        <div class="table table-bordered">
                                                            <table class="table table-bordered ">
                                                                <tr>
                                                                   <th>Total Average Remarks</th>       
                                                                </tr>   
                                                                <tr>
                                                                    <td><label id='labelTotalAverageRemarks'></label></td>   
                                                                </tr>  
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                 
                                <!--Additional Remark and Comments In Detail completes Here-->
                                <div class="form-group">
                                    <div class="col-sm-12" style="text-align: center">
                                        <input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" style="width: 100px;" />
                                        <!--<button type="submit" class="btn btn-primary" >Submit</button>-->
                                    </div>
                                </div>
                            </form:form>
                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                            <!--</div> /.tab-content -->
                        </div>
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
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
        forceParse: 0,
        showMeridian: 1
    });

</script>
<script>
    jQuery.noConflict();
    jQuery(document).ready(function () {
        //            alert("xkvn");
 
        
        jQuery("#employeeMasterByRefForEmpId").tokenInput(${list}, {
            preventDuplicates: true,
            noResultsText: "No Result",
            tokenLimit: "1",
            searchingText: "Searching ... .. .",
        });
        jQuery("#employeeMasterByRefDoneEmpId").tokenInput(${list}, {
            preventDuplicates: true,
            noResultsText: "No Result",
            searchingText: "Searching ... .. .",
        });
    });
</script>

<script>
        var sum = 0;
        var counter = 0;
        $('.tdGivenRemarks').each(function(){
            if($(this).text() !== '0')
            {
                sum += parseInt($(this).text());
                counter++;
            }
        });
        var avg = sum/counter;
        $('#labelTotalAverageRemarks').text(avg);
</script>

<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>

