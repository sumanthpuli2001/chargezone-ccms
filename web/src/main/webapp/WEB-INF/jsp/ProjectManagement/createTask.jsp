<%-- 
    Document   : createTask
    Created on : Jun 15, 2018, 4:50:51 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probation To Confirmation</title>
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
    </head>

    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>CREATE TASK: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Create Task</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <!-- Main content -->
            <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=createSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                <section class="content">
                    <input type="hidden" name="shiftName" id="shiftName" value="${shiftName}">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Basic:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Name</label>
                                                            <input type="text" name="name" class="form-control"/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label >Planned Start:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="datetimepicker1" name="plannedStart" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Planned Finish:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="datetimepicker2" name="plannedFinish" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div style="padding: 26px;">
                                                                <input type="checkbox" name="manuallySchedule"/>
                                                                <label >Manually Schedule</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Duration:</label>
                                                            <input type="text" name="duration" class="form-control"/>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label >Planned Effort:</label>
                                                            <input type="text" name="plannedEffort" class="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Schedule Type:</label>
                                                            <!--<input type="text" name="scheduleType" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label >Constraint Type:</label>
                                                            <!--<input type="text" name="constraintType" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Advanced :</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>%Comp</label>
                                                            <input type="text" name="comp" class="form-control"/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Priority</label>
                                                            <!--<input type="text" name="priority" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <div style="padding: 26px;">
                                                                <input type="checkbox" name="timeLogging"/>
                                                                <label >Allow time logging</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Actual Start:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="datetimepicker3" name="actualStart" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Actual Finish:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="datetimepicker4" name="actualfinish" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!--                                                    <div class="form-group">
                                                                                                            
                                                                                                        </div>-->
                                                    <h3> Financial</h3>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Budget</label>
                                                            <input type="text" name="budget" class="form-control"/>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Planed Labor Cost</label>
                                                            <input type="text" name="laborCost" class="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Planned Fixed Cost</label>
                                                            <input type="text" name="fixedCost" class="form-control"/>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Billing Type</label>
                                                            <!--<input type="text" name="billingType" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </form:form>
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
<script>
                                                    $(document).ready(function () {
                                                        $('#datetimepicker1').datepicker({
                                                        });
                                                    });
                                                    $(document).ready(function () {
                                                        $('#datetimepicker2').datepicker({
                                                        });
                                                    });
                                                    $(document).ready(function () {
                                                        $('#datetimepicker3').datepicker({
                                                        });
                                                    });
                                                    $(document).ready(function () {
                                                        $('#datetimepicker4').datepicker({
                                                        });
                                                    });
</script>