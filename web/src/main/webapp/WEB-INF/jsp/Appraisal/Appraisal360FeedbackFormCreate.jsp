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
        function valEmp() {
            var ab1 = document.getElementById("employeeMasterByRefForEmpId").value;
            var ab2[] = document.getElementById("employeeMasterByRefDoneEmpId").value;
        }
    </script>
    <script>
//ths script is for validate end date should be always bigger than end date.
        function dateValidator(counter) {
            var startDate = document.getElementById("performedDateStr1").value;
            var endDate = document.getElementById("completeDateStr1").value;
            if (startDate) {
                var startDatearray = startDate.split("/");
                var endDatearray = endDate.split("/");
                var sDate = new Date(startDatearray[2], startDatearray[1] - 1, startDatearray[0]);
                var eDate = new Date(endDatearray[2], endDatearray[1] - 1, endDatearray[0]);
                if (sDate > eDate) {
                    document.getElementById("completeDateStr1").value = "";
                    alert("End date should be greater than Start date");
                    return false;
                } else {
                    if (counter == 0) {
                        document.getElementById("completeDateStr1").value = startDate;
                    }
                }
                counter++;
            } else {
                document.getElementById("completeDateStr1").value = "";
                alert("startdate must not be empty");
            }
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
                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <br/>
                            <br/>
                            <!--form horizontal starts here-->
                            <form:form action="appraisal360.htm?act=submitAppraisal360HR" method="post" commandName="appraisal360" name='form1' class="form-horizontal" role="form">
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Details of Employee about whom feedback is given:</h3>
                                        <div class="box-tools pull-right">
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>-->
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeMasterByRefForEmpId"  class="form-control" onchange="return valEmp()"></form:input>
                                                        <form:errors path="employeeMasterByRefForEmpId" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-3" id="yearid" >
                                                            <label>Year:</label>
                                                            <select name="cycleYear" id="cycleYear" class="form-control"/>
                                                            <!--<option value="">--SELECT--</option>-->
                                                        <c:forEach var="cycleYear" items="${cycleYear}">
                                                            <option value="${cycleYear}">${cycleYear}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Details of Employee who is giving a feedback:</h3>
                                        <div class="box-tools pull-right">
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>-->
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Employee Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeMasterByRefDoneEmpId" class="form-control"></form:input>
                                                        <form:errors path="employeeMasterByRefDoneEmpId" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input class="form-control" path="performedDateStr" id="performedDateStr1" style="z-index:1;" onchange="dateValidator(0)" readonly='true'></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                            </div>
                                                            <div style="color: red"><form:errors class="form-control" path="performedDateStr" cssClass="errorDiv"></form:errors></div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input class="form-control" path="completeDateStr" id="completeDateStr1" readonly="true" onchange="dateValidator(1)"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                            </div>
                                                            <div style="color: red"><form:errors class="form-control" path="completeDateStr" cssClass="errorDiv"></form:errors></div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                <c:choose>
                                    <c:when test="${sessionScope.userRight.hr}"></c:when>
                                    <c:otherwise>


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
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="background-color: lightgrey"><b>WLB 2: Deliver Results</b><br>&nbsp;&nbsp;- Master the art of execution & Establish a track record of results<br>&nbsp;&nbsp;- Practice Accountability – Hold self & others accountable<br>&nbsp;&nbsp;- Get the best out of you and your team<br>&nbsp;&nbsp;- Be on time and within budget<br>&nbsp;&nbsp;- Don’t find excuses for not delivering<br>&nbsp;&nbsp;- Celebrate success with the team</td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio" value=""></td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="background-color: lightgrey"><b>WLB 3: Build Relationships & Develop Others  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Be grounded at all times & approachable<br>&nbsp;&nbsp;- Treat people with utmost respect & care<br>&nbsp;&nbsp;- Understand other’s perspective & concern<br>&nbsp;&nbsp;- Invest in developing the talent<br>&nbsp;&nbsp;- Give your team the right opportunities to learn and grow<br>&nbsp;&nbsp;- Create a learning environment & help others to learn from success stories & failures<br>&nbsp;&nbsp;- Learn the Art of ‘Story Telling’ </td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio1" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio1" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio1" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio1" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio1" value=""></td>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="background-color: lightgrey"><b>WLB 4: Act with Courage  (Definition mentioned below)</b><br>&nbsp;&nbsp;- Take a stand – have your individual opinion & stand by it<br>&nbsp;&nbsp;- Don’t shy away from conflicts<br>&nbsp;&nbsp;- Deal with the issues head on – never procrastinate<br>&nbsp;&nbsp;- Never bury your head in the sand<br>&nbsp;&nbsp;- Be direct & candid</td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio2" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio2" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio2" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio2" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio2" value=""></td>
                                                                </tr>
                                                                <tr >
                                                                    <td style="background-color: lightgrey"><b>WLB 5: Believe in Vision & Purpose  (Definition mentioned below) </b><br>&nbsp;&nbsp;- Be Far-sighted & Look beyond the obvious<br>&nbsp;&nbsp;- Be Strategic – Have a macro & micro perspective, Innovate<br>&nbsp;&nbsp;- Be Entrepreneurial <br>&nbsp;&nbsp;- Communicate your Vision to your team<br>&nbsp;&nbsp;- Make sure everyone on board under stand's the purpose<br>&nbsp;&nbsp;- Communicate ‘What’ , Why and When to align people to your Vision & Purpose</td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio3" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio3" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio3" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio3" value=""></td>
                                                                    <td style="text-align: center;vertical-align: middle"><input type="radio" name="radio3" value=""></td>
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
                                                            <div class="col-sm-6">
                                                                <label>Additional Remarks / Comments:</label>
                                                                <textarea class="form-control" rows="5" > </textarea>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                <!--Additional Remark and Comments In Detail completes Here-->
                                <!--form horizontal ends here-->
                                <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                                <!--</div> /.tab-content -->
                                <div class="form-group">
                                    <div class="col-sm-12" style="text-align: center;">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px;">SUBMIT</button>
                                    </div>
                                    <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                </div>

                            </form:form>
                        </div><!-- /.col -->
                    </div>
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
            showMeridian: 1,
            startDate: new Date()
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
                searchingText: "Searching ... .. ."
                        //            prePopulate: ${preList}

            });
            jQuery("#employeeMasterByRefDoneEmpId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                searchingText: "Searching ... .. ."
                        //            prePopulate: ${preList1}
            });
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

