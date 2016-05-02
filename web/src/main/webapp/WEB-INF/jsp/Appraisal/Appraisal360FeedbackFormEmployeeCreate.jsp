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
        var wlbFlag = false;
        function saveSubmitAll() {
            saveSubmit1();
            saveSubmit2();
            saveSubmit3();
            saveSubmit4();
            saveSubmit5();
            if (wlbFlag === false)
            {
                return false;
            }
            else {
                return true;
            }

        }
        function saveSubmit1() {
            var wlb1CheckCount = 0;
            var rads = document.getElementsByName("wlb1");
            for (var i = 0; i < rads.length; i++) {
                if (rads[i].checked) {
                    wlb1CheckCount++;
                }
            }
            if (wlb1CheckCount === 0) {
                alert("Please Enter WLB 1 Behavoiur Point..!!!");
                wlbFlag = false;
            } else {
                wlbFlag = true;
            }
        }

        function saveSubmit2() {
            var wlb1CheckCount = 0;
            var rads = document.getElementsByName("wlb2");
            for (var i = 0; i < rads.length; i++) {
                if (rads[i].checked) {
                    wlb1CheckCount++;
                }
            }
            if (wlb1CheckCount === 0) {
                alert("Please Enter WLB 2 Behavoiur Point..!!!");
                wlbFlag = false;
            } else {
                wlbFlag = true;
            }
        }
        function saveSubmit3() {
            var wlb1CheckCount = 0;
            var rads = document.getElementsByName("wlb3");
            for (var i = 0; i < rads.length; i++) {
                if (rads[i].checked) {
                    wlb1CheckCount++;
                }
            }
            if (wlb1CheckCount === 0) {
                alert("Please Enter WLB 3 Behavoiur Point..!!!");
                wlbFlag = false;
            } else {
                wlbFlag = true;
            }
        }
        function saveSubmit4() {
            var wlb1CheckCount = 0;
            var rads = document.getElementsByName("wlb4");
            for (var i = 0; i < rads.length; i++) {
                if (rads[i].checked) {
                    wlb1CheckCount++;
                }
            }
            if (wlb1CheckCount === 0) {
                alert("Please Enter WLB 4 Behavoiur Point..!!!");
                wlbFlag = false;
            } else {
                wlbFlag = true;
            }
        }
        function saveSubmit5() {
            var wlb1CheckCount = 0;
            var rads = document.getElementsByName("wlb5");
            for (var i = 0; i < rads.length; i++) {
                if (rads[i].checked) {
                    wlb1CheckCount++;
                }
            }
            if (wlb1CheckCount === 0) {
                alert("Please Enter WLB 5 Behavoiur Point..!!!");

                wlbFlag = false;
            } else {
                wlbFlag = true;
            }
        }
//            var rads = document.getElementsByName("radio1");
//            for (var i = 0; i < rads.length; i++)
//                if (rads[i].checked) {
//                    alert(rads[i]);
//                    return true;
//                } else {
//                    alert("Please Enter WLB 3 Behavoiur Point..!!!");
//                    return false;
//                }
//            var rads = document.getElementsByName("radio2");
//            for (var i = 0; i < rads.length; i++)
//                if (rads[i].checked) {
//                    alert(rads[i]);
//                    return true;
//                } else {
//                    alert("Please Enter WLB 4 Behavoiur Point..!!!");
//                    return false;
//                }
//            var rads = document.getElementsByName("radio3");
//            for (var i = 0; i < rads.length; i++)
//                if (rads[i].checked) {
//                    alert(rads[i]);
//                    return true;
//                } else {
//                    alert("Please Enter WLB 5 Behavoiur Point..!!!");
//                    return false;
//                }
//        }

    </script>
    <script>

        $(function () {
            $("#WorkTypeSelectId").on("change", function () {
                var selectedValue = this.value;
                if (selectedValue == "HourlyBase") {
                    $('#hourlyBaseTitleDiv').show();
                    $('#shiftNameDiv').hide();

                }
                else if (selectedValue == "ShiftBase") {
                    $('#shiftNameDiv').show();
                    $('#hourlyBaseTitleDiv').hide();
                }
                else {
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
                            <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                            <br/>
                            <br/>
                            <!--form horizontal starts here-->
                            <form:form action="appraisal360.htm?act=submitAppraisal360Employee" method="post" commandName="appraisal360" name='form1' onsubmit="return saveSubmitAll();" class="form-horizontal" role="form">
                                <%--<c:catch var ="catchException">--%>
                                <c:forEach items="${list1}" var="list">
                                    <input type="hidden" name="appId" value="${list[4]}"/>  
                                    <input type="hidden" name="forId" value="${list[5]}"/>
                                    <input type="hidden" name="doneId" value="${list[6]}"/>
                                    <input type="hidden" name="hrId" value="${list[7]}"/>
                                </c:forEach>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Details of Employee about whom feedback is given:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Employee No.:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.employeeId}">
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.employeeName}">
                                                    </div>
                                                </div><!-- /.col -->
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.designationMaster.designationName}">
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.levelMaster.level}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.departmentMaster.departmentName}">
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.locationMaster.location}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Reporting Manager:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster1.child2}">
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Details of Employee who is giving a feedback:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Employee No.:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster2.employeeId}" readonly='true'>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly="true" value="${employeeMaster2.employeeName}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster2.designationMaster.designationName}" readonly='true'>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster2.levelMaster.level}" readonly='true'>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster2.departmentMaster.departmentName}" readonly='true'>
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster2.locationMaster.location}" readonly='true'>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Start Date:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" name="performedDateStr" value="${list1[0][2]}" readonly='true'>
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>End Date:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" name="completeDateStr" value="${list1[0][3]}" readonly='true'>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Reporting Manager:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster2.child1}" readonly='true'>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                <%--</c:catch>--%>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Behaviors:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
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
                                                            <td style="background-color: lightgrey"><b>WLB 1: Walk the Talk (Definition mentioned below)</b><br>&nbsp;&nbsp;- Do & Act What you Preach<br>&nbsp;&nbsp;- Keep commitments<br>&nbsp;&nbsp;- Talk Straight – Be Honest & Tell the Truth<br>&nbsp;&nbsp;- Use simple language and call things what they are<br>&nbsp;&nbsp;- Don’t manipulate people nor distort facts</td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb1" value="1"/> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb1" value="2"/> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb1" value="3"/> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb1" value="4"/> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb1" value="5" /> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 1: Remark:</b></td>
                                                            <td colspan="5"><form:textarea path="wlb1Remark" class="form-control"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 2: Deliver Results  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb2" value="1"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb2" value="2"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb2" value="3"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb2" value="4" /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb2" value="5"  /> </td>
                                                        </tr>
                                                         <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 2: Remark:</b></td>
                                                            <td colspan="5"><form:textarea path="wlb2Remark" class="form-control"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb3" value="1"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb3" value="2"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb3" value="3" /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb3" value="4" /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb3" value="5" /> </td>
                                                        </tr>
                                                          <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 3: Remark:</b></td>
                                                            <td colspan="5"><form:textarea path="wlb3Remark" class="form-control"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb4" value="1"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb4" value="2"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb4" value="3"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb4" value="4"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb4" value="5"  /> </td>
                                                        </tr>
                                                         <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 4: Remark:</b></td>
                                                            <td colspan="5"><form:textarea path="wlb4Remark" class="form-control"/></td>
                                                        </tr>
                                                        <tr >
                                                            <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose</b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb5" value="1"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb5" value="2"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb5" value="3" /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb5" value="4"  /> </td>
                                                            <td style="text-align: center;vertical-align: middle"><form:radiobutton path="wlb5" value="5"  /> </td>
                                                        </tr>
                                                          <tr>
                                                            <td style="background-color: lightgrey"><b>WLB 5: Remark:</b></td>
                                                            <td colspan="5"><form:textarea path="wlb5Remark" class="form-control"/></td>
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

                                            <!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Remarks / Comments In Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Additional Employee Remarks / Comments:</label>
                                                        <form:textarea path="remarkEmp" class="form-control"/>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Additional Remark and Comments In Detail completes Here-->
                                    <!--form horizontal ends here-->
                                    <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
                                    <!--</div> /.tab-content -->
                                </div><!-- nav-tabs-custom -->

                                <br/>
                                <div class="form-group">
                                    <div class="col-sm-12" style="text-align: center">
                                        <button type="submit" class="btn btn-primary" value="Submit" style="width: 100px;">SUBMIT</button>
                                        <!--<button type="submit" class="btn btn-primary" >Submit</button>-->
                                    </div>
                                </div>
                            </div><!-- /.col -->
                        </form:form>
                    </div>
                </div>
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!--    <script type="text/javascript">
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

        </script>-->
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
        });</script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

