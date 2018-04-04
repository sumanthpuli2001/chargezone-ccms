<%-- 
    Document   : TrainingAssessment
    Created on : 22 Mar, 2018, 2:50:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
<%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training Details</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">

        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }

        </style>
        <script>
            function editClick(id) {
                window.location = 'questionLibrary.htm?act=createQuestionPaper&id=' + id;
            }
            function deleteClick(id, eprId) {
                window.location = 'questionLibrary.htm?act=deleteClick&id=' + id + '&eprId=' + eprId;
            }


            function check() {
                //                var checkboxes = confirm("Are you sure want to delete ?");
                if (true) {
                    var checkboxes = document.getElementsByName('checkId');
                    for (var i = 0, n = checkboxes.length; i < n; i++) {
                        if (checkboxes[i].checked) {
                            return true;
                        }
                    }
                    alert("Please, Select one or more record(s).");
                }
                return false;
//                $(document).ready( function() {
//        // Select all
//        $("A[href='#select_all']").click( function() {
//            $("#" + $(this).attr('checkId') + " INPUT[type='checkbox']").attr('checked', true);
//            return false;
//        });
//           });
            }
        </script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
        <script>
            $(document).ready(function () {
                $('#datetimepicker1').datepicker({
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                alert("ok");
                $('#datetimepicker2').datepicker({
                });
            });
        </script>
        
         <script>
        function checkBlankField() {
            var flag = true;
            if ($('#questions').val() == '') {
                document.getElementById('questionsError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#passingPercentage').val() == '') {
                document.getElementById('passingPercentageError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#duration').val() == '') {
                document.getElementById('durationError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#datepicker1').val() == '') {
                document.getElementById('datepicker1Error').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#datepicker2').val() == '') {
                document.getElementById('datepicker2Error').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#noOfAttampt').val() == '') {
                document.getElementById('noOfAttamptError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if(flag){
                  return checkBoxCheck(); 
              }
//            if ($('#description').val() == '') {
//                document.getElementById('descriptionError').innerHTML = '-It must not be empty or white space.';
//                flag = false;
//            }
            return flag;
        }

        function trainingOnChange(idString) {
            if (document.getElementById(idString).innerHTML != null) {
                document.getElementById(idString).innerHTML = '';
            }
        }
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
        
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h2>Training Details:</h2>
            <ol class="breadcrumb" style="    padding: 0px 15px;font-size:13px;">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Details</li>
            </ol>
        </section>
        
        <div style="text-align: left;">
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <!--        <input type="button" class="btn btn-primary" value="Back" style="float: left" onclick="window.location = 'trainerLogin.htm?act=showcalendar'" />-->
        <form:form class="form-horizontal" method="post" commandName="trainingAssessment" action="trainerLogin.htm?act=submitTrainingAssessment"
                   onsubmit='return checkBlankField();'>
            <section class="content">
                <!--<div class="col-md-12">-->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<h1>Trainings Details:</h1>-->
                                <div class="box-header">
                                </div>
                                <div class="row" style="margin-left:9%;">
                                    
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="font-size:13px;text-align: left;">
                                            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                             <label>Training Title : </label>&nbsp;&nbsp;${trainingMaster.trainingTitle}
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                            <label>Training Requester : </label>&nbsp;&nbsp;${trainingMaster.trainingOwner}
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                           <label>Training Type : </label>&nbsp;&nbsp;${trainingMaster.trainingType.training} 
                                        </div>
                                       
                                        
                                        </div>
                                         <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="font-size:13px; text-align: left;">
                                              <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                             <label>Training sub-type : </label>&nbsp;&nbsp;${trainingMaster.trainingSubType.trainingsubtype}
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                            <label>Training Source : </label>&nbsp;&nbsp;${trainingMaster.trainingSource}
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                           <label>Trainer : </label>&nbsp;&nbsp;${trainingMaster.trainer.trainerName}
                                        </div>
                                       
                                        
                                        </div>
                                    
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="font-size:13px;">
                                         <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                           <label>Start Date : </label>&nbsp;&nbsp;${trainingMaster.startDate}
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                            <label>End Date : </label>&nbsp;&nbsp;${trainingMaster.endDate}
                                        </div>
                                         <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                            <label>Training time from : </label>&nbsp;&nbsp;${trainingMaster.trainingTimeForm}
                                        </div>
                                       <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                             <label>Training time to : </label>&nbsp;&nbsp;${trainingMaster.trainingTimeTo}
                                       </div>
                                        
                                    </div>
                                        <style>
                                            .col-lg-2{
                                                width: 18.666667%;
                                            }
                                                
                                        </style>
                                  
                                  
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="font-size:13px;">
                                         <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                            <label>Venue : </label>&nbsp;&nbsp;${trainingMaster.venue}
                                        </div>
                                        <div class ="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="text-align: left;">
                                            <label>Description : </label>&nbsp; &nbsp;${trainingMaster.trainingDescription}
                                            
                                        </div>
                                        
                                    </div>
<!--                                    <div class ="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class ="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                                            <label>Description : </label>&nbsp; &nbsp;
                                            ${trainingMaster.trainingDescription}</textarea>
                                        </div>
                                    </div>-->

                                </div>
                            </div><!-- /.tab-content -->

                        </div>

                    </div>

                </div>


                <div class="nav-tabs-custom" style=" margin-top: 2%;text-align: left;"  >
                    <div class="tab-content">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12 col-sm-12" style="width: 90%;margin-left: 5%;font-size:13px;">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                            <input type="hidden" name="trainingMasterId" value="${trainingMaster.id}"/>
                                            <input type="hidden" id="eventdate" name="eventdate" value="${eventdate}">
                                            <label>Question Paper Name :<span style="color: red;font-size: 12px;">*</span></label>

                                            <select name="questionPaper.id" class="form-control" id="questions" onchange="getTotalMarksAndNoOfQue(this);trainingOnChange('questionsError');" style="font-size:13px;    height: 25px;     padding: 3px 12px;">
                                                <option value="">--Select--</option>
                                                <c:forEach items="${questions}" var="questions">
                                                    <option value="${questions.key}">${questions.value}</option>
                                                </c:forEach>
                                            </select>
                                             <span style="font-size: 14px; color: #dd4b39;" id="questionsError"></span>
                                        </div>
                                        <div class="col-sm-3">
                                            <label>Passing Percentage : <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="passingPercentage" id="passingPercentage" class="form-control" onchange="trainingOnChange('passingPercentageError');" placeholder="Enter Passing Percentage" style="font-size:13px;height: 25px;"></form:input>
                                            <form:errors path="passingPercentage" cssClass="errorDiv"></form:errors>
                                            <span style="font-size: 14px; color: #dd4b39;" id="passingPercentageError"></span>
                                            </div>
                                            <div class="col-sm-3">
                                                <label>Duration (In Minutes):<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="duration" id="duration" class="form-control" placeholder="Enter Duration" onchange="trainingOnChange('durationError');" style="font-size:13px;    height: 25px;"></form:input>
                                            <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                            <span style="font-size: 14px; color: #dd4b39;" id="durationError"></span>
                                            </div>
                                            <div class="col-sm-3    ">
                                            <label>Validity From :<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="validityFrom" id="datepicker1" class="form-control" placeholder="Please select From Date" onchange="trainingOnChange('datepicker1Error');" readonly="true"  style="font-size:13px;    height: 25px;" ></form:input>
                                                <!--<span style="color: red;font-size: 12px;"><form:errors path="validityFrom" cssClass="errorDiv"></form:errors></span>-->
                                             <span style="font-size: 14px; color: #dd4b39;" id="datepicker1Error"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                        <!--                                            <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select From Date" name="validityFrom" readonly="true"/>-->
                                        
                                            <div class="col-sm-3">
                                            <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                            <label>Validity To :<span style="color: red;font-size: 12px;">*</span></label>
                                            <input type="text" id="datepicker2" class="form-control" name="validityTo" onchange="trainingOnChange('datepicker2Error');" placeholder="Please select To Date" readonly="true" style="font-size:13px;    height: 25px;"/>
                                            <span style="font-size: 14px; color: #dd4b39;" id="datepicker2Error"></span>
                                            </div>
                                        <div class="col-sm-3">
                                            <label>Number Of Attempts :<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="noOfAttampt" id="noOfAttampt" class="form-control" onchange="trainingOnChange('noOfAttamptError');" placeholder="Enter Number Of Attempt" style="font-size:13px;     height: 25px;"></form:input>
                                            <form:errors path="noOfAttampt" cssClass="errorDiv"></form:errors>
                                            <span style="font-size: 14px; color: #dd4b39;" id="noOfAttamptError"></span>
                                            </div>
                                             <div class="col-sm-3>
                                            <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                            <label>Number of Questions :<span style="color: red;font-size: 12px;    height: 25px;" ></span></label>
                                            <!--<label id="test" name="test"></label>-->
                                            <label ></label>
                                            <input type="hidden" id="NoOfQue" name="NoOfQue" >
                                        </div>
                                            <div class="col-sm-3">

                                            <label>Total Marks :<span style="color: red;font-size: 12px;"></span></label>
                                            <label id="test2" name="test2"></label>
                                            <input type="hidden" id="totalMarks" name="totalMarks" >

                                        </div>
                                        </div>
                                        <div class="form-group">
                                           
                                        


                                    </div>

                                </div>
                                <div class="row" >

                                    <div class="col-md-12 col-sm-12" style="margin-top: 3%;font-size:13px;"> 
                                        <!--<div class="table table-bordered">-->

                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="width: 85%;margin-left: 7%;" align="center"  >
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

                                                            <!--<th style="width: 50px;"></th>-->

                                                            <th align="Center" style="width: 1px;"><input type="checkbox" id="toggleId" align="Center" >
                                                            <a rel="group_1" href="#select_all">Select All</a></th>
                                                            <th style="width: 50px;">Trainings</th>
                                                            <!--<th style="width: 50px;">Attendance</th>-->

                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <!--${list[0]}-->
                                                        <c:forEach var="list"  items="${list}" varStatus="status">
                                                            <tr>

                                                                <td align="Center">
                                                                    <input type="checkbox"  name="checkId" id="checkId" value="${list[0]}">
                                                                </td>

                                                                        <!--<td>${status.count}</td>-->

                                                                <td>${list[1]}</td>
                                                                <!--<td>-->
                                                                <%--<c:if test="${shosts eq true}">--%>
                                                                <%--<c:if test="${list[2] eq 0}">--%>
                                                                <!--<td><b style="color: green">PR</b></td>-->
                                                                <%--</c:if>--%> 
                                                                <%--<c:if test="${list[2] eq 1}">--%>
                                                                <!--<td><b style="color: red">AB</b></td>-->
                                                                <%--</c:if>--%> 
                                                                <%--</c:if>--%> 
                                                                <c:if test="${shosts eq false}">
                                                                    <td></td>
                                                                </c:if> 
                                                                <!--</td>-->
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>

                                                </c:otherwise>

                                            </c:choose>

                                        </table>
                                        <br>
                                        <%--<c:if test="${shosts eq false}">--%>
                                        <!--<button type="submit" class="btn btn-primary" style="float: left" title="" style="width: 100px;"><i class="fa fa-"></i>Submit</button>-->
                                        <!--<a style="float: right"  class="btn btn-primary" onclick="window.location = 'trainerLogin.htm?act=trainerAssessMent&id=${trainingMasterId}&eventdate=${eventdate}'">Online Assessment</a>-->
                                        <!--        <input type="button" class="btn btn-primary" value="Back" style="float: left" onclick="window.location = 'trainerLogin.htm?act=showcalendar'" />-->
                                        <%--</c:if>--%>
                                        <!--</div>-->
                                    </div>

                                </div><!-- /.tab-pane -->



                                <!--<div class="row">-->
                                <div class="form-group" style="float: right; margin-right:3%;">
                                    <div class=" col-sm-2" style="padding-right:26%;">
                                        <input type="button"  class="btn btn-primary" value="Back"  onclick="window.location = 'trainerLogin.htm?act=showcalendar'" style="background-color: #19b9e7; font-size: 11px;"/>
                                    </div>
                                    <div class=" col-sm-2">
                                        <button type="submit"  class="btn btn-primary" style=" font-size: 11px;height: 29px;padding: 0 12px; ">Submit</button>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!--</div>-->
                <!--</div>-->

            
        </form:form>

          </div>
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        function viewClick(id)
        {
            window.location = 'trainerLogin.htm?act=editClick&id=' + id;
        }

    </script>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
    <script>
        //            $(function () {
        //                $("#datepicker").datepicker();
        //            });
        $("#datepicker1").datepicker({dateFormat: 'dd/mm/yy'});
        $("#datepicker2").datepicker({dateFormat: 'dd/mm/yy'});
        //              $(function () {
        //                $("#datepicker2").datepicker();
        //            });
    </script>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid ;
            text-align: left;
            padding: 8px;
        }
    </style>
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
    <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
    <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
    <script src="StorageYard/JS/login/scripts.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>

</html>
<script>

        function getTotalMarksAndNoOfQue(id) {

            try {

                $.ajax({
                    type: "POST",
                    url: "onlineAssessment.htm?act=getTotalMarksAndNoOfQue&id=" + id.value,
                    data: {},
                    dataType: "json",
                    success: function (responseTxt) {
//                    document.getElementById("name").value = JSON.stringify(responseTxt.check);
//                    document.getElementById("email").value = JSON.stringify(responseTxt.val2);
//                    document.getElementById("name").value = responseTxt
                        var v1 = JSON.stringify(responseTxt.check);
                        var v2 = JSON.stringify(responseTxt.val2);
                        document.getElementById("test2").innerHTML = responseTxt.check;
                        document.getElementById("test").innerHTML = responseTxt.val2;
//                        $('#test2').html(responseTxt.check).modal('show');
//                        $('#test').html(responseTxt.val2).modal('show');

                        document.getElementById("NoOfQue").value = responseTxt.val2;
                        document.getElementById("totalMarks").value = responseTxt.check;
//                    $('#NoOfQue').val(v1);
//                    $('#totalMarks').val(v2);
//                    alert(JSON.stringify(responseTxt.check));

//                    document.getElementById("").innerHTML = responseTxt;
                        if (responseTxt != '') {
                            document.getElementById("").value = "";


                        }
                    },
                    error: function () {

                    }
                });



            } catch (e) {

            }


        }

</script>