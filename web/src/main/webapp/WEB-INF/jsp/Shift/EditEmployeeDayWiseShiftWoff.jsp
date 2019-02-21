<%--
    Document   : ShiftRotationCreate
    Created on : Nov 4, 2015, 2:27:08 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Woff Create</title>
    </head>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>WO Edit : </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Wo Edit</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="shiftRotationMaster.htm?act=submitEmployeeShiftAssignWoff" method="post" commandName="shiftGenerateMonthlySchedule"
                   name='form1' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
            <form:hidden path="noOfDays"></form:hidden>
            <input type="hidden" id="monthSelect" name="monthSelect" value="${monthSelect}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <form class="form-horizontal" role="form">
                                        <div class="box box-info collapsed-box ">
                                            <div class="box-header">
                                                <h3 class="box-title">Employee Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
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
                                                                <input type="Text" class="form-control" value="${employeeMaster[0]}" readonly>
                                                            <input type="hidden" class="form-control" id="empid" name="empid" value="${employeeMaster[0]}">
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[1]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Team:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text"  class="form-control" value="${employeeMaster[10]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Sub-Team:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[11]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[2]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[3]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control"  value="${employeeMaster[5]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${reportingManager}" readonly>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                        <!--Read only entries Starts here-->
                                        <div class="box box-info collapsed-box ">
                                            <div class="box-header">
                                                <h3 class="box-title">Woff Change:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                </div>
                                            </div> 
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">



                                                    <div class=" col-sm-6">
                                                        <label>Day Of Month:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <input type="text" name="dayNo" value="${dayNo}" class="form-control"  readonly="true">
                                                </div>   
                                                  <div class="col-sm-6" >
                                                      <label>WO Change Date:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <div class="input-group date form_datetime"  name="shiftIdChange" id="shiftIdChange"  data-date-format="d/m/yyyy" data-link-field="dtp_input1" >
                                                            <form:input path="" name="rotationdate" id="rotationdate" class="form-control" size="16" value="${rotationdate}" readonly="true" ></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                  </div>

<!--                                                <div class="col-sm-6">
                                                    <label>Shift Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <%--<form:select path="day${dayNo}" class="form-control" >--%>
                                                        <%--<form:option value="" label="-- Select --" />--%>
                                                        <%--<form:options items="${shiftMap}" />--%>
                                                    <%--</form:select>--%>
                                                    <%--<form:select path="" id="poolCarRequestSelectId" class="form-control ">--%>
                                                </div>-->
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Reason For Woff:<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="col-sm-7">
                                                    <textarea path="" name="reasonForWoff" id="reasonForWoff" value="" class="form-control" rows="6">${reasonForWoff}</textarea>
                                                        <!--<span id="" style="color: red;"></span>-->
                                                </div>
                                            </div>

                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                    <div>&nbsp;</div>
                                          

                                </div><!-- /.box-body -->
                                <div class="form-group" id="">
                                    <div class=" col-sm-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1" style="width: 100px;">SUBMIT</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>

            </section>
        </form:form>
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <script type="text/javascript">
        var start_date = new Date();
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            startDate: start_date,
            forceParse: 0
//            showMeridian: 1,
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
