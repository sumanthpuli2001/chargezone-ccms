<%-- 
    Document   : createProject
    Created on : Jun 13, 2018, 4:29:24 PM
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
                <h1>CREATE PROJECT: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Create Project</li>
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
                                                            <label >Planned Date:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="datetimepicker1" name="plannedDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Deadline</label>
                                                            <input type="text" name="deadline" class="form-control"/>
                                                        </div> 
                                                        <div class="col-sm-6">
                                                            <label >Manager</label>
                                                            <!--<input type="text" name="manager" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Client</label>
                                                            <!--<input type="text" name="client" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div> 
                                                        <div class="col-sm-6">
                                                            <label >State</label>
                                                            <!--<input type="text" name="state" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Priority</label>
                                                            <!--<input type="text" name="priority" class="form-control"/>-->
                                                            <select class="form-control">
                                                                <option value="volvo">A</option>
                                                                <option value="saab">B</option>
                                                                <option value="mercedes">C</option>
                                                                <option value="audi">D</option>
                                                            </select>
                                                        </div> 
                                                        <div class="col-sm-6">
                                                            <label >Work Location</label>
                                                            <input type="text" name="workLocation" class="form-control"/>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Risk Impact</label>
                                                            <input type="text" name="riskImpact" class="form-control"/>
                                                        </div> 
                                                        <div class="col-sm-6">
                                                            <label > Risk Probability</label>
                                                            <input type="text" name="riskProbability" class="form-control"/>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label > Potential Cost</label>
                                                            <input type="text" name="potentialCost" class="form-control"/>
                                                        </div> 
                                                        <div class="col-sm-6">
                                                            <label >  Mitigation Cost</label>
                                                            <input type="text" name="mitigationCost" class="form-control"/>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>  Mitigation Plan</label>
                                                            <input type="text" name="mitigationPlan" class="form-control"/>
                                                        </div> 
                                                        <div class="col-sm-6">
                                                            <label >  Project Finish Date</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="datetimepicker2" name="projectFinishDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Advanced</h3>
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
                                                            <label>Work Location</label>
                                                            <input type="text" name="wlocation" class="form-control"/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Project Code</label>
                                                            <input type="text" name="projectCode" class="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Budget</label>
                                                            <input type="text" name="budget" class="form-control"/>
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
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Task % Complete</label>
                                                            <input type="text" name="taskPercent" class="form-control"/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Description</label>
                                                            <input type="text" name="description" class="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                <tr>
                                                                    <th style="text-align: center;width:55px">Sr No.</th>
                                                                    <th style="text-align: center;"> Attachment</th>
                                                                    <th style="text-align: center;width:55px"></th>
                                                                </tr>
                                                                <input type="hidden" name="firstStepCount" id="firstStepCount" value="1">
                                                                <tr id="cloneTr_Id">
                                                                    <td style="text-align: center">1</td>
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
</script>
<script>
    var i1 = 1;
    $(function () {
        $("#step1cloneid").on("click", function () {
            i1 = document.getElementById("firstStepCount").value;
            i1++;
            if (i1 <= 8) {
                var clone = "<tr id='cloneTr_Id" + i1 + "'>"
                        + "<td style=\"text-align: center\">" + i1 + "</td>"
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