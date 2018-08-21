<%-- 
    Document   : CandidateRequestList
    Created on : 24 Feb, 2018, 12:11:11 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Candidate List</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Candidate Job Applying Request List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Candidate Request List</li>
            </ol>
        </section>

        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to delete?");
                if (checkboxes) {
                    checkboxes = document.getElementsByName('checkId');
                    for (var i = 0, n = checkboxes.length; i < n; i++) {
                        if (checkboxes[i].checked) {
                            return true;
                        }
                    }
                    alert("Please, Select one or more record(s).");
                }
                return false;
            }
        </script>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="recruitment.htm?act=searchDateWise" method="post" commandName="candidateApplyJob"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div>
                                    <!--                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">&nbsp; F To F</button>-->
                                    <!--<button type="button" class="btn btn-default " data-toggle="modal" data-target="#myModalOnline">Online Assessment</button>-->
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label>From Date:<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label>To Date<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-2">
                                                    <label>Search<span style="color: red;font-size: 5px;"></span></label>
                                                    <button type="submit" class="btn btn-primary" style="width: 10px;" data-original-title="" title="" >SEARCH</button>
                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                    <!--<th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>-->
                                                                    <%--</c:if>--%>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Name of Candidate</th>
                                                                    <!--<th style="width: 50px;">Qualification</th>-->
                                                                    <!--<th style="width: 50px;">Email Address</th>-->
                                                                    <!--<th style="width: 50px;">Experience Joining Year</th>-->
                                                                    <th style="width: 50px;">Position Applied For</th>
                                                                    <th style="width: 50px;">Department</th>
                                                                    <th style="width: 50px;">Date Of Application</th>
                                                                    <th style="width: 50px;">Application Status</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 50px;">Action</th>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                    <!--<td align="center" style="width: 1px;"><input type="checkbox" id="checkId" name="checkId"  value="${list[0]}"  /></td>-->
                                                                <%--</c:if>--%>
                                                                <!--<td>/</td>-->
                                                                <td>${list[3]}</td>
                                                                <!--<td>${list[4]}</td>-->
                                                                <!--<td>${list[5]}</td>-->
                                                                <!--<td>${list[6]}</td>-->
                                                                <td>${list[7]}</td>
                                                                <td>${list[10]}</td>
                                                                <td>${list[9]}</td>
                                                                <td>
                                                                    <c:if test="${list[8] eq 0}"><span class="label label-default">New Applicant</span></c:if>
                                                                    <c:if test="${list[8] eq 1}"><span class="label label-default">New Applicant</span></c:if>
                                                                    <c:if test="${list[8] eq 2}"><span class="label label-default">Shortlisted</span></c:if>
                                                                    <c:if test="${list[8] eq 3}"><span class="label label-default">Rejected</span></c:if>
                                                                    <c:if test="${list[8] eq 4}"><span class="label label-default">Online Assessment</span></c:if>
                                                                    <c:if test="${list[8] eq 5}"><span class="label label-default">Assessment Submission </span></c:if>
                                                                    <c:if test="${list[8] eq 6}"><span class="label label-default">Assessment Pass </span></c:if>
                                                                    <c:if test="${list[8] eq 7}"><span class="label label-default">Assessment Fail</span></c:if>
                                                                    <c:if test="${list[8] eq 8}"><span class="label label-default">F2F interview Invitation</span></c:if>
                                                                    <c:if test="${list[8] eq 9}"><span class="label label-default">Candidate On hold</span></c:if>
                                                                    <c:if test="${list[8] eq 10}"><span class="label label-default">Candidate Rejected </span></c:if>
                                                                    <c:if test="${list[8] eq 11 || list[8] eq 20}"><span class="label label-default">Candidate Selected</span></c:if>
                                                                    <c:if test="${list[8] eq 12}"><span class="label label-default">Employee Induction</span></c:if>
                                                                    <c:if test="${list[8] eq 13}"><span class="label label-default">Employee On board </span></c:if>
                                                                    <c:if test="${list[8] eq 14}"><span class="label label-default">Send Offer Later </span></c:if>
                                                                    </td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="ViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>
                                                                </td>
                                                                <%--</c:if>--%>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script>
        function ViewClick(id) {
            window.location = 'recruitment.htm?act=CandidateViewClick&id=' + id;
        }
    </script>

    <!-- ONLINE Modal -->
    <div class="container">
        <div class="modal fade" id="myModalOnline" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Online Assessment</h4>
                    </div>
                    <form:form class="form-horizontal" method="post" commandName="onlineAssessment" action="onlineAssessment.htm?act=submitAssessment"
                               onsubmit='return checkBoxCheck();'>
                        <section class="content">
                            <!--<div class="col-md-12">-->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <form:input path="id" id="id" class="form-control" type="hidden"></form:input>

                                                            <label>Question Paper Name :<span style="color: red;font-size: 12px;"></span></label>

                                                            <select name="questions" class="form-control">
                                                                <option value="">--Select--</option>
                                                            <c:forEach items="${questions}" var="questions">
                                                                <option value="${questions.key}">${questions.value}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Passing Percentage : <span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="passingPercentage" id="passingPercentage" class="form-control" placeholder="Enter Passing Percentage"></form:input>
                                                        <form:errors path="passingPercentage" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Assessment Duration : <span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="duration" id="duration" class="form-control" placeholder="Enter Duration"></form:input>
                                                        <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity From :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select From Date" name="validityFrom" readonly="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity To :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker1" class="form-control" name="validityTo" placeholder="Please select To Date" readonly="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Number Of Attempt : <span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="noOfAttampt" id="noOfAttampt" class="form-control" placeholder="Enter Number Of Attempt"></form:input>
                                                        <form:errors path="noOfAttampt" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Number of Questions :<span style="color: red;font-size: 12px;"></span></label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Total Marks :<span style="color: red;font-size: 12px;"></span></label>


                                                    </div>


                                                </div>

                                            </div>



                                            <!--<div class="row">-->
                                            <div class="form-group">
                                                <div class=" col-sm-5 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                                </div>
                                            </div>
                                            <div style="float: right;">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--</div>-->
                            <!--</div>-->

                        </section>
                    </form:form>

                </div>
            </div>
        </div>
    </div>

    <!-- FACE TO FACE FORE MODAL -->
    <div class="container">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Face To Face</h4>
                    </div>
                    <div class="modal-body">
                        <p>Some text in the modal.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>

    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>-->
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

<script>
    $(document).ready(function () {
        $('#datetimepicker1').datepicker({
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>
<script>

    function checkBoxCheck() {
        var checkboxes = "";

        checkboxes = document.getElementsByName('checkId');
        for (var i = 0, n = checkboxes.length; i < n; i++) {
            if (checkboxes[i].checked) {

                return true;
            }
        }
        alert("Please, Select one or more record(s).");
        return false;
    }

</script>
