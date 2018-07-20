<%-- 
    Document   : createProject
    Created on : Jun 13, 2018, 4:29:24 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Project</title>

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
        <form:form class="form-horizontal" role="form" action="projectManagement.htm?act=SubmitProject" commandName="projectManagement" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="id" id="id" value="${projectManagement.id}">
                
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
                                                        <label> Project Code:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="projectCode" class="form-control"></form:input>
                                                        <form:errors path="projectCode" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label> Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="name" class="form-control"></form:input>
                                                        <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <label>Planned Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                            <form:input path="plannedDate" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <%--<form:errors path="fromDate" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label >Deadline</label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                            <form:input path="deadline" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div> 
                                                        <div class="col-sm-4">
                                                            <label>Client :<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="clientMaster.id" id="client" class="form-control " >
                                                                <form:option label="-- Select --"  value="" ></form:option>
                                                                <c:forEach var="listClient" items="${listClient}" >
                                                                    <form:option value="${listClient.key}">${listClient.value}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                        <span style="font-size: 14px; color: #dd4b39;" id="trainingTypeError"></span>

                                                        <!--<input type="text" name="client" class="fom-control"/>-->
                                                    </div> 

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Stage :<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="stateMaster.id" id="state" class="form-control " >
                                                                <form:option label="-- Select --"  value="" ></form:option>
                                                                <c:forEach var="list1" items="${list1}" >
                                                                    <form:option value="${list1.key}">${list1.value}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                        <span style="font-size: 14px; color: #dd4b39;" id="trainingTypeError"></span>
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
                                                        <label> Risk Impact:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="riskImpact" class="form-control">
                                                            <form:option label="-- Select --"  value="" ></form:option>
                                                            <form:option value="low">Low</form:option>
                                                            <form:option value="medium">Medium</form:option>
                                                            <form:option value="high">High</form:option>
                                                        </form:select>
                                                    </div> 
                                                </div>
                                                <div class="form-group">

                                                    <div class="col-sm-4">
                                                        <label> Work Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="zydexLocationMaster.id" id="zydexLocationMaster" class="form-control " >
                                                            <form:option label="-- Select --"  value="" ></form:option>
                                                            <c:forEach var="list3" items="${list3}" >
                                                                <form:option value="${list3.key}">${list3.value}</form:option>
                                                            </c:forEach>   
                                                        </form:select>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label >  Project Finish Date:</label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                            <form:input path="finishDate" class="form-control" onchange="dateDifference(this.value);" placeholder="DD/MM/YYYY" readonly="true" ></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4" id="levelIdDiv1">
                                                            <label> Manager:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="manager" id="manager" class="form-control" onchange="reportingLevelSet();"></form:input>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Financial</h3>
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
                                                            <label> Project % Complete:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="taskCompleted" class="form-control"></form:input>
                                                        <form:errors path="taskCompleted" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label> Budget:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="budget" class="form-control"></form:input>
                                                        <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                        </div>
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
                                                    <div class="col-md-12 col-sm-12">
                                                        <label> Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div>
                                                            <form:textarea  path="description" rows="5" cols="145"></form:textarea>
                                                            <form:errors path="description" cssClass="errorDiv"/>
                                                        </div>
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
        });
    </script>
    <script>
        function checkCertificateFileSize(id) {
            if (typeof FileReader !== "undefined") {
                var fileSize = document.getElementById('certificateId' + id).files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 1048576) {
                    document.getElementById('certificateId' + id).value = '';
                    document.getElementById('certificateError').innerHTML = "- It must not more than 1mb";
                } else {
                    document.getElementById('certificateError').innerHTML = '';
                }
                // check file size
            }


        }
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
        <script>
//            jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#manager").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                minChars: "2",
                hintText: "Type atleast two Letter",
                searchingText: "Searching ... .. .",
                prePopulate: ${preList}
                
            });
        });

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
