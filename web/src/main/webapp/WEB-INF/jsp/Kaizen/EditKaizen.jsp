<%-- 
    Document   : EditKaizen
    Created on : Apr 21, 2018, 3:13:00 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head> 
        <title>Training Type Master </title>

    </head>
    <style>
        table, th, th {
            border: 2px solid black;
            border-collapse: collapse;
        }
        th, th {
            padding: 15px;
        }
        .disabledInput{
            background-color: black;
        }
    </style>
    
    <script>
        function checkBlankField() {
            var flag = true;
            if ($('#teamLeader').val() == '') {
                document.getElementById('teamLeaderError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#teamName').val() == '') {
                document.getElementById('teamNameError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#ideaGenerator').val() == '') {
                document.getElementById('ideaGeneratorError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#department').val() == '') {
                document.getElementById('departmentError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#teamMember').val() == '') {
                document.getElementById('teamMemberError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#problemDescription').val() == '') {
                document.getElementById('problemDescriptionError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#budgetRequirement').val() == '') {
                document.getElementById('budgetRequirementError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#improvementDescription').val() == '') {
                document.getElementById('improvementDescriptionError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#tangibleBenefit').val() == '') {
                document.getElementById('tangibleBenefitError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#intangibleBenefit').val() == '') {
                document.getElementById('intangibleBenefitError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#horizontalDeployment').val() == '') {
                document.getElementById('horizontalDeploymentError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            return flag;
        }

        function kaizenOnchangeFunction(idString) {
            if (document.getElementById(idString).innerHTML != null) {
                document.getElementById(idString).innerHTML = '';
            }
        }

    </script>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>Edit Kaizen</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Kaizen</li>
            </ol>
        </section>
        <form:form action="kaizen.htm?act=editKaizenSubmit" method="post" commandName="kaizenMaster" enctype="multipart/form-data"
                     onsubmit='return checkBlankField();' name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <%--<form:hidden path="${list.id}" name="id"/>--%>
                                <input type="hidden" name="id" value="${list.id}">
                                <div class="table">
                                    <table style="width:100%">
                                        <tr>
                                            <th colspan="3">Kaizen Sr. No.</th>
                                            <th colspan="5"><input type="text" size="3px;" readonly="" name="srNo" value="${list.srNo}"></th>
                                            <th colspan="2">Team Leader</th>
                                            <th colspan="2"><input name="teamLeader"  id="teamLeader" value="${list.teamLeader}" type="text"onchange="kaizenOnchangeFunction('teamLeaderError');"><br>
                                                 <span style="font-size: 14px; color: #dd4b39;" id="teamLeaderError"></span></th>
                                        </tr>
                                        <tr>
                                            <th colspan="3">Team Name </th>
                                            <th colspan="5"><input name="teamName"id="teamName" value="${list.teamName}" type="text" size="50px;"onchange="kaizenOnchangeFunction('teamNameError');"><br>
                                                <span style="font-size: 14px; color: #dd4b39;" id="teamNameError"></span></th>
                                            <th colspan="2">Kaizen Idea Generator</th>
                                            <th colspan="2"><input name="ideaGenerator" id="ideaGenerator" value="${list.ideaGenerator}" type="text"onchange="kaizenOnchangeFunction('ideaGeneratorError');"><br>
                                                 <span style="font-size: 14px; color: #dd4b39;" id="ideaGeneratorError"></span></th>
                                        </tr>
                                        <tr>
                                            <th colspan="3">Department </th>
                                            <th colspan="5"><input name="department"id="department"  value="${list.department}" type="text" size="50px;"onchange="kaizenOnchangeFunction('departmentError');"><br>
                                                <span style="font-size: 14px; color: #dd4b39;" id="departmentError"></span></th>
                                            <th colspan="2" rowspan="3">Team Member </th>
                                            <th colspan="2" rowspan="3"><textarea name="teamMember"id="teamMember"  style="resize: none" value=""  rows="8" cols="23"onchange="kaizenOnchangeFunction('teamMemberError');">${list.teamMember}</textarea>
                                                <br> <span style="font-size: 14px; color: #dd4b39;" id="teamMemberError"></span></th>
                                        </tr>
                                        <tr style="vertical-align: top;">
                                            <th colspan="3" rowspan="5">
                                                Problem Description :   <br><br>
                                                <textarea style="resize: none"  name="problemDescription"id="problemDescription" rows="12" cols="35"onchange="kaizenOnchangeFunction('problemDescriptionError');">${list.problemDescription}</textarea>
                                                <br> <span style="font-size: 14px; color: #dd4b39;" id="problemDescriptionError"></span></th>
                                            <th colspan="5" rowspan="5" style="text-align: center;" >
                                                Before Photo <br>
                                                <input type="file" name="beforePhoto" class="form-control" id="beforePhoto"  accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                                <img hight="300" width="400" src="StorageYard/Kaizen/beforePhoto/${list.beforePhoto}"  >
                                            </th>
                                            <!--<th colspan="2"><input name="teamMember" type="text"></th>-->
                                        </tr>
                                        <tr>
                                            <!--<th colspan="2"><input name="teamMember" type="text"></th>-->
                                        </tr>
                                        <tr>
                                            <th colspan="2">Start Date </th>
                                            <th colspan="2"> 
                                                <input type="text" name="startDate" value=" ${list.startDate}" id="datetimepicker2" class="form-control" placeholder="Please select start Date"  name="validityFrom" readonly="true" required="true"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">Completion Date  </th>
                                            <th colspan="2"><input type="text" value=" ${list.compiletionDate}" name="compiletionDate" id="datetimepicker1" class="form-control" placeholder="Please select Completion Date" name="validityFrom" readonly="true" required="true"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">Budget Requirement  </th>
                                            <th colspan="2"><input name="budgetRequirement" id="budgetRequirement"  value="${list.budgetRequirement}" type="text"onchange="kaizenOnchangeFunction('budgetRequirementError');"><br>
                                                <span style="font-size: 14px; color: #dd4b39;" id="budgetRequirementError"></span>
                                        </tr>
                                        <tr style="vertical-align: top;">
                                            <th colspan="3" rowspan="5">Improvement Description :<br><br>

                                                <textarea name="improvementDescription"id="improvementDescription" style="resize: none"  rows="12" cols="35"onchange="kaizenOnchangeFunction('improvementDescriptionError');">${list.improvementDescription}</textarea>
                                                <br><br>  <span style="font-size: 14px; color: #dd4b39;" id="improvementDescriptionError"></span></th>
                                            <th colspan="5" rowspan="5" style="text-align: center;">After Photo<br>
                                                <input type="file"   class="form-control" id="afterPhoto" name="afterPhoto" accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                                <img hight="300" width="400" src="StorageYard/Kaizen/afterPhoto/${list.afterPhoto}">
                                            </th>
                                            <th colspan="2" rowspan="1">Tangible Benefit </th>
                                            <th colspan="2" rowspan="1"><input name="tangibleBenefit" id="tangibleBenefit" value="${list.tangibleBenefit}"type="text" onchange="kaizenOnchangeFunction('tangibleBenefitError');">
                                                <br>  <span style="font-size: 14px; color: #dd4b39;" id="tangibleBenefitError"></span></th>
                                        </tr>
                                        <tr>
                                            <th colspan="2" rowspan="1">Intangible Benefit </th>
                                            <th colspan="2" rowspan="1"><input name="intangibleBenefit" id="intangibleBenefit" value="${list.intangibleBenefit}" type="text" onchange="kaizenOnchangeFunction('intangibleBenefitError');">
                                                <br>  <span style="font-size: 14px; color: #dd4b39;" id="intangibleBenefitError"></span></th>
                                        </tr>
                                        <tr>
                                            <th colspan="2" rowspan="3" style="vertical-align: top;height: 200px !important;">Horizontal Deployment: </th>
                                            <th colspan="2" rowspan="3" style="height: 200px !important; vertical-align: top;">
                                                <textarea name="horizontalDeployment" id="horizontalDeployment"  style="resize: none" rows="8" cols="23" onchange="kaizenOnchangeFunction('horizontalDeploymentError');">${list.horizontalDeployment}</textarea>
                                                <br>  <span style="font-size: 14px; color: #dd4b39;" id="horizontalDeploymentError"></span></th>
                                        </tr>

                                        <tr></tr>
                                        <tr></tr>
                                        <tr>
                                            <td colspan="2" >
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b>Productivity</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.productivity eq 1}">
                                                            <input type="checkbox" name="productivity" value="1" checked="true"/>  
                                                        </c:if>
                                                        <c:if test="${list.productivity ne 1}">
                                                            <input type="checkbox" name="productivity" value="1" />  
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b> Quality</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.quality eq 1}">
                                                            <input type="checkbox" name="quality" value="1" checked="true" />

                                                        </c:if>
                                                        <c:if test="${list.quality ne 1}">
                                                            <input type="checkbox" name="quality" value="1"  />

                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2" >
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b>Delivery</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.delivery eq 1}">
                                                            <input type="checkbox" name="delivery" value="1" checked="true"/> 
                                                        </c:if>
                                                        <c:if test="${list.delivery ne 1}">
                                                            <input type="checkbox" name="delivery" value="1" /> 
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b>  Safety</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.safety eq 1}">
                                                            <input type="checkbox" name="safety" value="1" checked="true" />
                                                        </c:if>
                                                        <c:if test="${list.safety ne 1}">
                                                            <input type="checkbox" name="safety" value="1" />
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>

                                            <td colspan="2" >
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b> Cost</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.cost eq 1}">
                                                            <input type="checkbox" name="cost" value="1" checked="true"/>  
                                                        </c:if>
                                                        <c:if test="${list.cost ne 1}">
                                                            <input type="checkbox" name="cost" value="1" />  
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b> Morale</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.morale eq 1}">
                                                            <input type="checkbox" name="morale" value="1" checked="true" /> 
                                                        </c:if>
                                                        <c:if test="${list.morale ne 1}">
                                                            <input type="checkbox" name="morale" value="1" /> 
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <div class="form-group">
                                        <br>
                                        <div class="col-sm-6 col-sm-offset-5">
<!--                                            <button type="button" onclick="viewClick(${list.id});" class="btn btn-primary" aria-haspopup="true" aria-expanded="false">
                                                &nbsp;&nbsp;Approved
                                            </button>-->
                                            <div class="col-sm-4" style="text-align: left">
                                                <button type="submit" class="btn btn-success"   class="btn btn-primary" name="btnType"   style="width: 100px"> &nbsp;&nbsp;Submit</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div> <!--/tab-content -->
                        </div><!-- nav-tabs-custom -->


                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
    <script>

        function check(old1) {
            alert("in");
            if (old1 = 1) {
                document.getElementById("checkBoxClass").checked = true;
            } else {
                document.getElementById("checkBoxClass").checked = false;
            }
        }

        function viewClick(id) {
            alert(id);
            window.location = 'kaizen.htm?act=approvedKaizen&id=' + id;
        }

    </script>
    <script>
        $(document).ready(function () {
            $('#datetimepicker2').datepicker({
            });
        });
        $(document).ready(function () {
            $('#datetimepicker1').datepicker({
            });
        });
    </script>
    <script>
        function checkFileSize() {
            if (typeof FileReader !== "undefined") {
                var fileSize = document.getElementById('photograph').files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 102400) {
                    document.getElementById('photograph').value = '';
                    document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
                } else {
                    document.getElementById('photographError').innerHTML = '';
                }
                // check file size
        }
    </script>
</html>