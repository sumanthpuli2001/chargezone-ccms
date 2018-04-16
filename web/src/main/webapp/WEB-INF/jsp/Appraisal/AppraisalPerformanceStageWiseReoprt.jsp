<%--
    Document   :
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : Dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Stage-Wise Report</title>
    </head>

    <script>
        function selectDropsDown11(val) {
            if (val == 'stageWise') {
                $('#employeeName').show();
//                $('#stages').show();
//                $('#selecctallId').show();

                $('#departmentIdDiv').show();
                $('#yearid').show();
//                $('#competencyEId').hide(500);

            } else if (val == 'competency') {
//                $('#competencyEId').show();
//                $('#stages').hide();
//                $('#stages1').hide();
//                $('#selecctallId').hide();
//                $('#yearid').hide();

//                $('#departmentIdDiv').show();

            } else if (val == 'rating') {
//                $('#competencyEId').hide(500);
//                $('#stages').hide();
//                $('#stages1').hide();
//                $('#selecctallId').hide();
                $('#yearid').show();
                $('#departmentIdDiv').show();

            } else if (val == 'idp') {
//                $('#competencyEId').hide(500);
//                $('#stages').hide();
//                $('#stages1').hide();
//                $('#selecctallId').hide();
//                $('#yearid').hide();

//                $('#departmentIdDiv').show();

            }
        }
    </script>

    <style>
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>
    <script>
        function searchSubmit11() {
            var flag = true;
            var checkboxes = "";
            checkboxes = document.getElementById("employeeMasterId1");
            
            if ('' == checkboxes.value) {

                document.getElementById('fill1').innerHTML = 'Please Enter Employee Name/ID';
                flag = false;
            } else {
                flag = true;
            }
           
            return flag;
        }

    </script>
    <script>
        function myFunction() {
          
            document.getElementById("fill1").innerHTML = " ";
        }
    </script>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee PMP Search: </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="appraisalPerformance.htm?act=searchAppraisalPerformanceReoprtSubmit" method="post" commandName="appraisalPerformanceMaster"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <!--<h3 class="box-title">Employee Detail</h3>-->
                                    <!--                                        <div class="box-tools pull-right">
                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                            </div>-->
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Searching Criteria:</label>
                                                    <select name="valDetail" name="valDetail" class="form-control" onchange="selectDropsDown11(this.value);">
                                                        <option value="stageWise">By Stage Wise Search</option>
                                                        <option value="rating">By Rating Search</option>
                                                        <!--                                                        <option value="competency">By Competency Evaluation Search</option>
                                                                                                                <option value="idp">By IDP Search</option>-->
                                                    </select>
                                                </div>
                                                <!--                                                <div class="col-sm-6" id="competencyEId" style="display: none;">
                                                                                                    <label>Competency Evaluation:</label>
                                                                                                    <select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>
                                                                                                    <option value="">--SELECT--</option>
                                                <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                                    <option value="${competencyMap.key}">${competencyMap.value}</option>
                                                <%--</c:forEach>--%>
                                                </select>
                                            </div>-->

                                                <div class="col-sm-3" id="yearid" >
                                                    <label>Cycle Name:</label>
                                                    <select name="pmpyear" id="pmpyear" class="form-control"/>
                                                    <!--<option value="">--SELECT--</option>-->
                                                    <c:forEach var="pmpyearMap" items="${pmpyearList}">
                                                        <option value="${pmpyearMap.key}">${pmpyearMap.value}</option>
                                                    </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <br/>
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6" id="employeeName">
                                                    <label>Employee ID/Name:</label>
                                                    <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6" id="departmentIdDiv">
                                                    <label>Department Name:</label>
                                                    <input type="text" id="departmentId" name="departmentId" class="form-control">
                                                </div>
                                            </div>


                                            <!--                                            <div class="form-group" id="selecctallId" style="margin-left: 25px;">
                                                                                            <input type="checkbox" id="selecctall">
                                                                                            <label>ALL SELECT</label>
                                                                                        </div>-->
                                            <!--                                            <div class="form-group" id="stages">

                                                                                            <ul class="checkbox-grid">
                                                                                                <li>
                                                                                                    <input type="checkbox" name="kragoal" class="checkbox1" value="kragoal" id="kragoal"/>
                                                                                                    <label>Goal Setting By Employee</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="weightage" class="checkbox1" value="weightage" id="weightage"/>
                                                                                                    <label>Goal Approval By Manager</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="empMidYearSelfAssementGoal" class="checkbox1" value="empMidYearSelfAssementGoal" id="empMidYearSelfAssementGoal"/>
                                                                                                    <label>Employee’s Mid Year Self Assessment</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="managerMidYearReviewEvaluation" class="checkbox1" value="managerMidYearReviewEvaluation " id="managerMidYearReviewEvaluation"/>
                                                                                                    <label>Manager’s Mid Year Review</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="empEndYearSelfAssementGoal" class="checkbox1" value="empEndYearSelfAssementGoal" id="empEndYearSelfAssementGoal"/>
                                                                                                    <label>Employee’s End Year Self Assessment</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="managerEndYearReviewEvaluation" class="checkbox1" value="managerEndYearReviewEvaluation" id="managerEndYearReviewEvaluation"/>
                                                                                                    <label>Manager’s End Year Review</label>
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>-->



                                            <div class="form-group">
                                                <div class=" col-sm-12" style="text-align: center;">
                                                    <button type="submit" class="btn btn-primary" style="width: 100px;" >EXPORT</button>
                                                </div>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
        <section class="content-header">
            <h1>Employee Year Wise Report Search: </h1>

        </section>
        <form:form action="appraisalPerformance.htm?act=searchReoprtByYearWiseSubmit" method="post" commandName="appraisalPerformanceMaster"
                   name='form1' onsubmit='return searchSubmit11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <!--<h3 class="box-title">Employee Detail</h3>-->
                                    <!--                                        <div class="box-tools pull-right">
                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                            </div>-->
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <!--                                                <div class="col-sm-6">
                                                                                                    <label>Searching Criteria:</label>
                                                                                                    <select name="valDetail" name="valDetail" class="form-control" onchange="selectDropsDown11(this.value);">
                                                                                                        <option value="stageWise">By Stage Wise Search</option>
                                                                                                        <option value="rating">By Rating Search</option>
                                                                                                                                                                <option value="competency">By Competency Evaluation Search</option>
                                                                                                                                                                <option value="idp">By IDP Search</option>
                                                                                                    </select>
                                                                                                </div>-->
                                                <!--                                                <div class="col-sm-6" id="competencyEId" style="display: none;">
                                                                                                    <label>Competency Evaluation:</label>
                                                                                                    <select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>
                                                                                                    <option value="">--SELECT--</option>
                                                <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                                    <option value="${competencyMap.key}">${competencyMap.value}</option>
                                                <%--</c:forEach>--%>
                                                </select>
                                            </div>-->
                                                <div class="col-sm-6" id="employeeName">
                                                    <label>Employee ID/Name:</label>
                                                    <input type="text" oninput="myFunction()"  id="employeeMasterId1" name="employeeMasterIdForYear" class="form-control">
                                                    <label id="fill1" style="color: red;"></label>
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
                                            </div>
                                        </div>
                                    </div>

                                    <br/>
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <!--                                            <div class="form-group">
                                                                                            <div class="col-sm-6" id="employeeName">
                                                                                                <label>Employee ID/Name:</label>
                                                                                                <input type="text" id="employeeMasterId1" name="employeeMasterId" class="form-control">
                                                                                            </div>
                                            
                                                                                        </div>-->
                                            <!--                                            <div class="form-group">
                                                                                            <div class="col-sm-6" id="departmentIdDiv">
                                                                                                <label>Department Name:</label>
                                                                                                <input type="text" id="departmentId1" name="departmentId" class="form-control">
                                                                                            </div>
                                                                                        </div>-->


                                            <!--                                            <div class="form-group" id="selecctallId" style="margin-left: 25px;">
                                                                                            <input type="checkbox" id="selecctall">
                                                                                            <label>ALL SELECT</label>
                                                                                        </div>-->
                                            <!--                                            <div class="form-group" id="stages">

                                                                                            <ul class="checkbox-grid">
                                                                                                <li>
                                                                                                    <input type="checkbox" name="kragoal" class="checkbox1" value="kragoal" id="kragoal"/>
                                                                                                    <label>Goal Setting By Employee</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="weightage" class="checkbox1" value="weightage" id="weightage"/>
                                                                                                    <label>Goal Approval By Manager</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="empMidYearSelfAssementGoal" class="checkbox1" value="empMidYearSelfAssementGoal" id="empMidYearSelfAssementGoal"/>
                                                                                                    <label>Employee’s Mid Year Self Assessment</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="managerMidYearReviewEvaluation" class="checkbox1" value="managerMidYearReviewEvaluation " id="managerMidYearReviewEvaluation"/>
                                                                                                    <label>Manager’s Mid Year Review</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="empEndYearSelfAssementGoal" class="checkbox1" value="empEndYearSelfAssementGoal" id="empEndYearSelfAssementGoal"/>
                                                                                                    <label>Employee’s End Year Self Assessment</label>
                                                                                                </li>
                                                                                                <li>
                                                                                                    <input type="checkbox" name="managerEndYearReviewEvaluation" class="checkbox1" value="managerEndYearReviewEvaluation" id="managerEndYearReviewEvaluation"/>
                                                                                                    <label>Manager’s End Year Review</label>
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>-->



                                            <div class="form-group" id="yearExport">
                                                <div class=" col-sm-12" style="text-align: center;">
                                                    <button type="submit" class="btn btn-primary" style="width: 100px;" >EXPORT</button>
                                                </div>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
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
            forceParse: 0,
            endDate: new Date()
        });</script>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeMasterId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeMasterId1").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#zydexLocationId").tokenInput(${zydexLocationList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#levelId").tokenInput(${levelList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#departmentId").tokenInput(${departmentList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#departmentId1").tokenInput(${departmentList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $('#selecctall').on('ifChecked', function (event) {
            //        if ($('.checkAll').filter(':checked').length == $('.check').length) {
            $('.checkbox1').iCheck('check');
            //        }
        });
        $('#selecctall').on('ifUnchecked', function (event) {
            $('.checkbox1').iCheck('uncheck');
        });</script>
</html>
