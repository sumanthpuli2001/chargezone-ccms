<%--
    Document   : Hrview
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resignation Form</title>
        <style>
            .tooltip-inner{
                max-width: 70% !important; /* Max Width of the popover (depending on the container!) */
            }
        </style>
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
        function changeFunc() {
            var empid = document.getElementById("employeeMaster").value;
            alert(empid);
            $.ajax({
                method: "POST",
                url: "resignationMaster.htm?act=employeeAjax",
                data: {empId: empid},
                success: function (data, textStatus, jqXHR) {
                    alert(data);
                    var str = data.split("/");
                    document.getElementById("empNo").value = str[0]
                    document.getElementById("dept").value = str[2]
                    document.getElementById("desc").value = str[3]
                    document.getElementById("level1").value = str[4]
                    document.getElementById("manager").value = str[5]
                    document.getElementById("location").value = str[6]
                }
            })
        }
        ;
    </script>
    <script>
        function saveSubmit11() {
            var flag3 = true;
            if (document.getElementById("relievingDate").value == '') {
                document.getElementById("RelieveDateError").innerHTML = "- It must be Selected";
                alert('Please Select Relieving Date and Time');
                flag3 = false;
            } else {
                document.getElementById("RelieveDateError").innerHTML = "";

            }
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Processing ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Resignation Form : </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Resignation</li>
            </ol>
            <div class="col-md-12" style="text-align: center;">
                <!--<input type="button" value="Print" id="printBtn" name="printBtn" style="margin-left: 959px; width: 100px;" class="btn btn-primary" onclick="appraisalSelectedPrint()">-->
                <a href="resignationMaster.htm?act=printClick&id=${id}&empId=${empid}" target="_blank"  class="btn btn-primary">Print</a>
                <input type="hidden" id="empId" name="empId" value="${empid}">
                <input type="hidden" id="id" name="id" value="${id}">
            </div>
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
                            <!--form horizontal starts here-->
                            <form:form action="resignationMaster.htm?act=HRApprove" method="post" commandName="resignationMaster"
                                       name='form1'  class="form-horizontal" role="form">
                                <input type="hidden" name="id" value="${resignationMaster.id}"/>
                                <!--Read only entries Starts here-->
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <c:forEach var="list" items="${list}">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Employee No.:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="hidden" class="form-control" name="empId" value="${list[0]}">
                                                            <input type="Text" class="form-control" name="empId" value="${list[7]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list[1]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list[3]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list[4]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list[2]}" readonly>
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${list[6]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster.employeeName}" readonly>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </c:forEach>
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Employee detail completes here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Resignation Information:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Resignation Effective Date & Time:</label>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <form:input class="form-control" path="effectiveDatetime"  readonly='true'></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <div style="color: red"><form:errors path="effectiveDatetime" cssClass="errorDiv"></form:errors></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                <c:choose>
                                                    <c:when test="${resignationMaster.relievingDate eq '' || resignationMaster.relievingDate eq null}">
                                                        <div class="form-group" style="pointer-events: none;">
                                                            <label class="col-sm-3 control-label">Relieving Date:</label>
                                                            <div class="col-sm-1">
                                                                <input type="radio" name="relivingDateRadio" id="relivingDateShow_id" value="relivingDateShow">
                                                            </div>
                                                            <label class="col-sm-3 control-label">As Per Employment Rule:</label>
                                                            <div class="col-sm-1">
                                                                <input type="radio" name="relivingDateRadio" checked="true" id="relivingDateHide_id" value="relivingDateHide">
                                                            </div>
                                                            <span id="relivingDateRadioError" style="color: red;"></span>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>

                                                        <div class="form-group" style="pointer-events: none;">
                                                            <label class="col-sm-3 control-label">Relieving Date:</label>
                                                            <div class="col-sm-1">
                                                                <input type="radio" name="relivingDateRadio" checked="true" id="relivingDateShow_id" value="relivingDateShow">
                                                            </div>
                                                            <label class="col-sm-3 control-label">As Per Employment Rule:</label>
                                                            <div class="col-sm-1">
                                                                <input type="radio" name="relivingDateRadio" id="relivingDateHide_id" value="relivingDateHide">
                                                            </div>
                                                            <span id="relivingDateRadioError" style="color: red;"></span>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
                                                <div class="form-group" >
                                                    <label class="col-sm-3 control-label">Relieving Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <form:input class="form-control" path="relievingDate"  readonly='true'></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            </div>
                                                            <span id="RelieveDateError" style="color: red;"></span>
                                                        </div>
                                                        <!--<div style="color: red">
                                                    <%--<form:errors path="relievingDate" cssClass="errorDiv"></form:errors>--%>
                                                        </div>-->
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" rel="tooltip" data-html="true" data-toggle="tooltip"  data-placement="right"
                                                           data-title="<div style='text-align: left;'>1) Termination Letter given by the Company<br>2) Company demanding Resignation to avoid giving termination letter to save his/her career<br>3) Employee Absconding from duties
                                                           <br>4) Resignation of an employee undergoing PIP (Performance Improvement Plan)<br>5) Resignation of a non performing employee (Who has been already informed about his/her non-performance formally through email)</div>">Good Attrition:</label>
                                                    <div class="col-sm-1" style="pointer-events: none;">
                                                        <c:if test="${resignationMaster.attrition eq 'Good Attrition'}">
                                                            <input type="radio" name="attrition" checked="true" id="goodAttrition_id" value="Good Attrition">
                                                        </c:if>
                                                        <c:if test="${resignationMaster.attrition ne 'Good Attrition'}">
                                                            <input type="radio" name="attrition"  id="goodAttrition_id" value="Good Attrition">
                                                        </c:if>
                                                    </div>
                                                    <label class="col-sm-2 control-label" rel="tooltip" data-html="true" data-toggle="tooltip"  data-placement="right"
                                                           data-title="<div style='text-align: left;'>1) Employee Resigning on his own (Not undergoing through PIP)<br>
                                                           2) Employee Resigning on his own (Not given any negative Performance feedback formally through email till now)</div>">Bad Attrition:</label>
                                                    <div class="col-sm-1" style="pointer-events: none;">
                                                        <c:if test="${resignationMaster.attrition eq 'Bad Attrition'}">
                                                            <input type="radio" name="attrition" checked="true"  id="badAttrition_id" value="Bad Attrition">
                                                        </c:if>
                                                        <c:if test="${resignationMaster.attrition ne 'Bad Attrition'}">
                                                            <input type="radio" name="attrition"  id="badAttrition_id" value="Bad Attrition">
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--Resignation Information completes Here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Reason Of Resignation:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-md-2">Reason:</label>
                                                    <div class="col-sm-12">
                                                        <c:choose>
                                                            <c:when test="${sessionScope.userRight.hr}">
                                                                <form:textarea path="reason" class="form-control" rows="6" readonly="true"></form:textarea>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:textarea path="reason" class="form-control" rows="6" readonly="true"></form:textarea>
                                                                <div style="color: red"><form:errors path="reason" cssClass="errorDiv"></form:errors></div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Manager Comment:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-md-2">Comment:</label>
                                                    <div class="col-sm-12">
                                                        <form:textarea path="managerComment" class="form-control" rows="6" readonly="true"></form:textarea>

                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">HR Comment:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-md-2">Comment:</label>
                                                        <div class="col-sm-12">
                                                        <form:textarea path="hrComment" class="form-control" rows="6" ></form:textarea>

                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Reason In Detail completes Here-->
                                    <div class="form-group">
                                        <!--<div class="col-sm-offset-1 col-sm-5">-->
                                    <c:if test="${resignationMaster.status eq 4}">
                                        <div class="col-sm-12" style="text-align: center">
                                            <button type="submit" class="btn btn-success" style="width: 100px;" onclick='return saveSubmit11();' name="btnType" value="APPROVE">ACCEPT</button>
                                        </div>
                                    </c:if>
                                    <c:if test="${resignationMaster.status eq 2}">
                                        <div class="col-sm-6" style="text-align: left">
                                            <button type="submit" class="btn btn-success" style="width: 100px;" onclick='return saveSubmit11();' name="btnType" value="APPROVE">ACCEPT</button>
                                        </div>
                                        <div class="col-sm-6" style="text-align: right">
                                            <button type="submit" class="btn btn-warning" style="width: 100px;" name="btnType" value="RETURN">RETURN</button>
                                        </div>
                                    </c:if>
                                    <c:if test="${resignationMaster.status eq 7 || resignationMaster.status eq 10}">
                                        <!--<input type="submit" class="btn btn-primary" style="width: 100px;" name="btnType" value="WITHDRAWAPPROVE"/>-->
                                        <div class="col-sm-6" style="text-align: left">
                                            <button type="submit" class="btn btn-success" style="width: 100px;" name="btnType" value="WITHDRAWAPPROVE">APPROVE</button>
                                        </div>
                                        <div class="col-sm-6" style="text-align: right">
                                            <button type="submit" class="btn btn-danger" style="width: 100px;"  onclick='return saveSubmit11();'  name="btnType" value="WITHDRAWREJECT">REJECT</button>
                                        </div>
                                    </c:if>
                                    <!--</div>-->
                                </div>
                            </form:form>
                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
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
            forceParse: 0,
            showMeridian: 1
//            startDate: new Date()
        });
//        $('.form_datetime1').datetimepicker({
//            //language:  'fr',
//            weekStart: 1,
//            todayBtn: 1,
//            autoclose: 1,
//            todayHighlight: 1,
//            startView: 2,
//            forceParse: 0,
//            showMeridian: 1
//
//        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>