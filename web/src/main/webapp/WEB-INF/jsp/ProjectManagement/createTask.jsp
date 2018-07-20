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
        <title>Create Task</title>
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
            <form:form class="form-horizontal" role="form" action="projectManagement.htm?act=taskSubmit" commandName="createTask" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                <section class="content">
                    <input type="hidden" name="projectId" id="projectId" value="${projectId}">
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
                                                        <div class="col-sm-4">
                                                            <label> Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="name" class="form-control"></form:input>
                                                            <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label>Planned Start:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                                <form:input path="plannedStart" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div> 
                                                            <div class="col-sm-4">
                                                                <label>Planned Finish:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                                <form:input path="plannedFinish" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div> 

                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-4">
                                                                <div style="padding: 26px;">
                                                                <form:checkbox path="manuallySchedule" name="manuallySchedule"></form:checkbox>
                                                                    <label >Manually Schedule</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label> Duration:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="duration" placeholder="No of Days"  class="form-control"></form:input>
                                                            <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label> Planned Effort:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="plannedEffort" placeholder="No of Hours" class="form-control"></form:input>
                                                            <form:errors path="plannedEffort" cssClass="errorDiv"></form:errors>
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
                                                            <div class="col-sm-4">
                                                                <label> Task % Completed:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="taskCompleted"   class="form-control"></form:input>
                                                            <form:errors path="taskCompleted" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label>Priority :<span style="color: red;font-size: 12px;"></span></label>
                                                                <form:select path="priorityMaster.id" id="priority" class="form-control " >
                                                                    <form:option label="-- Select --"  value="" ></form:option>
                                                                    <c:forEach var="list2" items="${list2}" >
                                                                        <form:option value="${list2.key}">${list2.value}</form:option>
                                                                    </c:forEach>
                                                                </form:select>
                                                            <span style="font-size: 14px; color: #dd4b39;" id="trainingTypeError"></span>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div style="padding: 26px;">
                                                                <form:checkbox path="timeLogging" name="timeLogging"></form:checkbox>
                                                                    <label >Allow time logging</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-4">
                                                                <label>Actual Start:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                                <form:input path="actualStart" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div> 
                                                            <div class="col-sm-4">
                                                                <label>Actual Finish:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                                <form:input path="actualFinish" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div> 
                                                        </div>
                                                        <h3> Financial</h3>
                                                        <div class="form-group">
                                                            <div class="col-sm-4">
                                                                <label> Budget(Amount):<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="budget"   class="form-control"></form:input>
                                                            <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label> Planed Labor Cost:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="plannedLabourCost"   class="form-control"></form:input>
                                                            <form:errors path="plannedLabourCost" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <label> Planned Fixed Cost:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:input path="plannedFixedCost"   class="form-control"></form:input>
                                                            <form:errors path="plannedFixedCost" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-4">
                                                                <label> Billing Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="billingType" class="form-control">
                                                                <form:option label="-- Select --"  value="" ></form:option>
                                                                <form:option value="NoBilling">No Billing</form:option>
                                                                <form:option value="Fixedprice">Fixed price</form:option>
                                                                <form:option value="TimeandMaterial">Time and Material</form:option>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <!--<th style="text-align: center;width:55px">Sr No.</th>-->
                                                                    <th style="text-align: center;"> Attachment</th>
                                                                    <th style="text-align: center;width:55px"></th>
                                                                </tr>
                                                                <input type="hidden" name="firstStepCount" id="firstStepCount" value="1">
                                                                <tr id="cloneTr_Id">
                                                                    <!--<td style="text-align: center">1</td>-->
                                                                    <td>
                                                                        <input type="file" class="form-control" id="certificateId1" name="certificateId1" accept="image/jpg,image/jpeg,image/png" onchange="checkCertificateFileSize(1);">
                                                                        <span style="font-size: 14px; color: red;" id="certificateError"></span>
                                                                    </td>
                                                                    <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                            <input type="button" value="+" id="step1cloneid" />  </span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Resources :</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <table id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <!--<th style="text-align: center;width:55px">Sr No.</th>-->
                                                                    <th style="text-align: center;"> Department</th>
                                                                    <th style="text-align: center;"> Employee</th>
                                                                    <th style="text-align: center;"> Authorize</th>
                                                                    <th style="text-align: center;width:55px"></th>
                                                                </tr>
                                                                <!--<input type="hidden" name="firstStepCount" id="firstStepCount" value="1">-->
                                                                <tr>
                                                                    <!--<td style="text-align: center">1</td>-->
                                                                    <td id="departmentId1">
                                                                        <div>
                                                                            <select class="form-control" id="departmentId1" name="departmentId1" onchange="getEmployee(this.value, 1);">
                                                                                <option value="">--SELECT--</option>
                                                                                <c:forEach var="comp" items="${list4}" varStatus = "status">
                                                                                    <option value="${comp.key}">${comp.value}</option>
                                                                                </c:forEach>
                                                                            </select>

                                                                        </div>

                                                                    </td>
                                                                <input type="hidden" name="firstStepCount11" id="firstStepCount11" value="1">
                                                                <input type="hidden" name="firstStepCount12" id="firstStepCount12" value="1">
                                                                <td>
                                                                    <select class="form-control" id="employeeId1" name="employeeId1" >
                                                                        <option value="" label="-- Select --" />
                                                                    </select>
                                                                </td>
                                                                <td style="text-align: center;">
                                                                    <input type="checkbox" name="authorize1" id="authorize1" >
                                                                </td>
                                                                <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                        <input type="button" value="+" id="step1cloneid11" />  </span>
                                                                </td>
                                                                </tr>
                                                            </table>
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

    </body>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });</script>
</html>
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
    });</script>
<script>
    var i1 = 1;
    $(function () {
        $("#step1cloneid").on("click", function () {
            i1 = document.getElementById("firstStepCount").value;
            i1++;
            if (i1 <= 8) {
                var clone = "<tr id='cloneTr_Id" + i1 + "'>"
                        + "<td><input type=\"file\" class=\"form-control\" accept='image/jpg,image/jpeg,image/png' id='certificateId" + i1 + "' name='certificateId" + i1 + "' onchange='checkCertificateFileSize(" + i1 + ")'/></td>"
                        + "<td style=\"text-align: center\"><input type =\"button\" value=\"-\" onclick=\"removeStep1Tr('cloneTr_Id" + i1 + "');\"/>"
                        + "</tr>";
                $("#table_1").append(clone);
                document.getElementById("firstStepCount").value = i1;
            }
        });
    });
    function removeStep1Tr(cloneTr_Id) {
        try {
            i1--;
            var val = document.getElementById("firstStepCount").value;
            val = val - 1;
            document.getElementById("firstStepCount").value = val;
            var element1 = document.getElementById(cloneTr_Id);
            element1.parentNode.removeChild(element1);
        } catch (e) {
        }
    }
</script>
<script>
    var tempCount3 = 1;
    $(function () {
        $("#step1cloneid11").on("click", function () {
            tempCount3 = document.getElementById("firstStepCount12").value;
            tempCount3++;
            var clone = "<tr id='cloneTr_Id" + tempCount3 + "'>"
                    + "<td><div><select id='departmentId" + tempCount3 + "' name='departmentId" + tempCount3 + "' class='form-control'  onchange='getEmployee(this.value," + tempCount3 + ");'>"
                    + "<option value=''> --SELECT-- </option>"
                    + "<c:forEach var='comp' items='${list4}' varStatus = 'status'>"
                    + "<option value ='${comp.key}'>${comp.value}</option>"
                    + "</c:forEach>"
                    + "</select>"
                    + "</div><span id='policyError" + tempCount3 + "' style='color: red;'></span></td>"
                    + "<td><div><select id='employeeId" + tempCount3 + "' name='employeeId" + tempCount3 + "' class='form-control'>"
                    + "<option value=''> --SELECT-- </option>"
                    + "</select>"
                    + "</div><span id='policyError" + tempCount3 + "' style='color: red;'></span></td>"
                    + "<td style='text-align: center'><input type='checkbox' name='authorize" + tempCount3 + "' id='authorize" + tempCount3 + "'</td>"
                    + "<td style='text-align: center'><input type ='button' value='-' onclick=\"removeStep1Tr11('cloneTr_Id" + tempCount3 + "');\"/>"
                    + "</tr>";
            $("#table_2").append(clone);
            document.getElementById("firstStepCount12").value = tempCount3;
            document.getElementById("firstStepCount11").value = tempCount3;
        });
    });
    function removeStep1Tr11(cloneTr_Id) {
        try {
            var val = document.getElementById("firstStepCount11").value;
            document.getElementById("firstStepCount12").value = val;
            val = val - 1;
            document.getElementById("firstStepCount11").value = val;
            var element1 = document.getElementById(cloneTr_Id);
            element1.parentNode.removeChild(element1);
        } catch (e) {
        }
    }
    </script>
    <script>

        function getEmployee(departmentId, dropDownId) {
            $("#employeeId" + dropDownId + " option").remove();
            $.ajax({
                data: 'departmentId=' + departmentId,
                url: "projectManagement.htm?act=setEmployee",
                success: function (content)
                {
                    var obj = JSON.parse(content);
//                    alert(obj);
                    var count = Object.keys(obj['employeeKey']).length;
//                    alert(count);
                    var data = "<option>-- Select --</option>";
                    var desigJSON = obj['employeeKey'];
//                    alert("1 = :"+desigJSON);
                    //contains key
                    var desigJSONKey = Object.keys(obj['employeeKey']);
//                    alert("2 = : "+desigJSON[desigJSONKey[1]]);
                    for (var i = 0; i < count; i++) {
                        data += "<option value=" + desigJSONKey[i] + ">" + desigJSON[desigJSONKey[i]] + "</option>";
                    }
                    $(data).appendTo('#employeeId' + dropDownId);
                }
            });
        }
    </script>

<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>