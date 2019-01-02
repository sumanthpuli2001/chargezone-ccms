<%-- 
    Document   : TrainingQuestionAnsCheck
    Created on : 23 Mar, 2018, 6:12:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>


    <head>
        <title>View Question Paper Ans</title>
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

    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>View Question Paper Answer</h1>

            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View Question Paper Answer</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">
        <form:form class="form-horizontal" method="post" commandName="trainingAssessment" action="trainingAssessment.htm?act=submitResult">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <%--<c:choose>--%>
                                        <%--<c:when test="${empty list2}">--%>
                                        <c:if test="${not empty list2}">
                                            <div  class="col-sm-6 col-sm-offset-3">

                                                <h4> <label>Candidate User Name&nbsp;:&nbsp;</label><label style="color: #0064cd">${employeeName}</label></h4> 
                                            </div>
                                        </c:if>
                                        <c:if test="${empty list2}">
                                            <div class="col-sm-6 col-sm-offset-5">

                                                <c:out value="There is no record found."></c:out>
                                                </div>
                                        </c:if>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>

                                        <input type="hidden" name="candidateId" id="candidateID" value="${candidateID}">
                                        <input type="hidden" name="countDetailId" id="countDetailId" >
                                        <c:if test="${not empty list2}">
                                            <div class="form-group">
                                                <div class="col-sm-8"><h4><b>Questions</b></h4></div>
                                                <div class="col-sm-2"><h4><b>Answer Status</b></h4></div>
                                                <div class="col-sm-2"><h4><b>Marks</b></h4></div>
                                            </div>
                                        </c:if>

                                        <c:forEach var="employeeAdditional" items="${list2}" varStatus="status">

                                            <input type="hidden" id="eventdate" name="eventdate" value="${eventdate}">
                                            <input type="hidden" id="id" name="id" value="${employeeAdditional[8]}">
                                            <input type="hidden" id="id" name="type" value="${employeeAdditional[1]}">
                                            <input type="hidden" id="pp" name="pp" value="${employeeAdditional[6]}">
                                            <input type="hidden" id="ttm" name="ttm" value="${employeeAdditional[7]}">
                                            <input type="hidden" id="ttm" name="assessmentId" value="${employeeAdditional[9]}">
                                            <div class="form-group">
                                                <div class="col-sm-8" >
                                                    ${status.count}. ${employeeAdditional[0]}
                                                </div>
                                                <c:if test="${employeeAdditional[1] eq 0}">
                                                    <div class="col-sm-2">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[4]}">
                                                            Correct
                                                            <input type="hidden" name="mcqStatus${status.count}" value="0">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[4]}">
                                                            Incorrect
                                                            <input type="hidden" name="mcqStatus${status.count}" value="1">
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${employeeAdditional[3] eq employeeAdditional[4]}">
                                                        <div class="col-sm-2">
                                                            <input type="text" value="${employeeAdditional[5]}" id="givenMarks2${status.count}" name="givenMarks2" class="form-control" readonly="true">
                                                            /Out of <b>${employeeAdditional[5]}</b>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${employeeAdditional[3] ne employeeAdditional[4]}">
                                                        <div class="col-sm-2">
                                                            <input type="text" value="0" name="givenMarks2" class="form-control" id="givenMarks2${status.count}" readonly="true">
                                                            /Out of <b>${employeeAdditional[5]}</b>
                                                        </div>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${employeeAdditional[1] eq 1}">

                                                    <div class="col-sm-2">
                                                        <c:if test="${employeeAdditional[11] eq 0}">
                                                            Correct
                                                            <input type="hidden" name="mcqStatus${status.count}" value="0">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[11] eq 1}">
                                                            Incorrect
                                                            <input type="hidden" name="mcqStatus${status.count}" value="1">
                                                        </c:if>

<!--                                                        <input class="form-check-input" name="mcqStatus${status.count}" required type="radio"  value="0" >
<label class="form-check-label" for="radio100${employeeAdditional[6]}">Correct</label> &nbsp;
<input class="form-check-input" name="mcqStatus${status.count}"  required type="radio"  value="1" >
<label class="form-check-label" for="radio100${employeeAdditional[6]}">Incorrect</label>-->
                                                    </div>
                                                    <!--                                                    <div class="col-sm-1">
                                                                                                        </div>-->
                                                    <div class="col-sm-2">

                                                        <input type="text" name="givenMarks2" class="form-control" id="givenMarks3${status.count}"  max="${employeeAdditional[5]}"
                                                               oninput="maxLengthCheck(this)" onkeypress="return isNumeric(event)"  value="${employeeAdditional[12]}" required>
                                                        <label>/Out Of <input type="hidden" value="${employeeAdditional[5]}" id="outOf${status.count}" ><input type="hidden" id="counter" value="${status.count}">
                                                            ${employeeAdditional[5]}</label>
                                                    </div>
                                                </c:if>

                                                <c:if test="${employeeAdditional[1] eq 0}">
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[11]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[2]}"  checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[11]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[2]}"  disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[3]}">${employeeAdditional[10]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[13]}">
                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[4]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[13]}">
                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[4]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">${employeeAdditional[12]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[15]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[7]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[15]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[7]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[8]}">${employeeAdditional[14]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[17]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[9]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[17]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[10]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[10]}">${employeeAdditional[16]}</label>
                                                    </div>
                                                </c:if>
                                                <c:if test="${employeeAdditional[1] eq 1}">
                                                    <div class="col-sm-8">
                                                        <textarea type="text" class="form-control"  name="${status.count}" id="${status.count}" rows="4" cols="70" readonly="true">${employeeAdditional[10]}</textarea>
                                                    </div>
                                                </c:if>



                                            </div>



                                        </c:forEach>
                                        <%--</c:otherwise>--%>

                                        <c:if test="${not empty list2}">
                                            <div class="row">
                                                <div class="form-group">

                                                    <div  class="col-sm-3">


                                                        <h4> <label> Result Status :</label>&nbsp;${questionanswerResult[2]}
                                                            <!--<label style="color: red;" id="reStatusFail"></label><input type="hidden" id="failResult" name="failResult">-->
                                                            <!--<label style="color: green;" id="reStatusPass"></label><input type="hidden" id="passResult" name="passResult">-->
                                                        </h4>

                                                    </div>
                                                    <div  class="col-sm-3">


                                                        <h4> <label> Percentage :&nbsp;</label>${questionanswerResult[0]}
                                                            <label style="color: blue;" id="per"></label>
                                                            <!--<input type="hidden" name="percentageResult" id="percentageResult">-->
                                                        </h4>

                                                    </div>
                                                    <div  class="col-sm-3">


                                                        <h4> <label>Obtain Marks :</label>&nbsp;<label id="obtainTT" ></label>${questionanswerResult[1]}
                                                            <!--<input type="hidden" name="totalResult" id="totalResult">-->
                                                        </h4>



                                                    </div>
                                                    <div style="float: right;" class="col-sm-3">


                                                        <h4> <label>Total Marks :</label>&nbsp;<label id="tt" ></label>${questionanswerResult[3]}
                                                            <!--<input type="hidden" name="totalResult" id="totalResult">-->
                                                        </h4>



                                                    </div>



                                                </div>


                                                <!--                                                <div class="form-group">
                                                                                                    <div class=" col-sm-6 col-sm-offset-4">
                                                                                                        <a onclick="totalcal()" class="btn btn-default">Check Result</a>
                                                                                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                                                                                    </div>
                                                                                                </div>-->
                                            </div>
                                        </c:if>
                                        <%--</c:choose>--%>
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
    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
    <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
    <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
    <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
    <script src="StorageYard/JS/login/scripts.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">

    <script>
                                                                   initSample();
    </script>
</html>
<script>
    function totalcal() {
        var data;
        var givenMarks2;
        var givenMarks3;
        var ttlm = 0;
        var len = document.getElementById("countDetailId").value;
        for (var i = 1; i < parseInt(len) + 1; i++) {
//            data1 = document.getElementById("candidateIDEmp" + i).value;
            if (document.getElementById("givenMarks2" + i) == null) {
                givenMarks2 = 0
            } else {
                givenMarks2 = document.getElementById("givenMarks2" + i).value;

                ttlm = ttlm + Number(givenMarks2);
            }
            if (document.getElementById("givenMarks3" + i) == null) {
                givenMarks3 = 0
            } else {
                givenMarks3 = document.getElementById("givenMarks3" + i).value;
                ttlm = ttlm + Number(givenMarks3);

            }
        }

        var pp = document.getElementById("pp").value;
        var ttm = document.getElementById("ttm").value;
//        var text_value1 = $("#givenMarks1").val();
//        var text_value3 = $("#givenMarks3").val();

//        var ttlm = Number(givenMarks2) + Number(givenMarks3);
        var per = (ttlm * 100) / Number(ttm);

        document.getElementById("obtainTT").innerHTML = ttlm;
        document.getElementById("per").innerText = Number(per).toFixed(2);
        document.getElementById("percentageResult").value = Number(per).toFixed(2);
        if (per < pp) {
            document.getElementById("reStatusFail").innerText = "FAIL";
            document.getElementById("failResult").value = "FAIL";
            document.getElementById("reStatusPass").innerText = "";
            document.getElementById("passResult").value = "";

        } else {
            document.getElementById("reStatusPass").innerText = "PASS";
            document.getElementById("failResult").value = "";
            document.getElementById("reStatusFail").innerText = "";
            document.getElementById("passResult").value = "PASS";
        }

        document.getElementById("tt").innerText = ttm;
        document.getElementById("totalResult").value = ttlm;
    }
//    $(document).ready(function () {
//       
//// Function to get input value.
//        $('#givenMarks2').click(function () {
//            var text_value = $("#givenMarks2").val();
//            if (text_value == '') {
//                alert("Enter Some Text In Input Field");
//            } else {
//                alert(text_value);
//            }
//        });
//        $('#givenMarks1').click(function () {
//            var text_value = $("#givenMarks1").val();
//            if (text_value == '') {
//                alert("Enter Some Text In Input Field");
//            } else {
//                alert(text_value);
//            }
//        });
//    });
</script>
<script>
    function maxLengthCheck(object) {

        if (object.value > object.max || object.value.length > object.max.length) {
//            if (object.value.length > object.max.length)
            object.value = "";
//            object.value = object.value.slice(0, object.max.length);
        }
    }

    function isNumeric(evt) {
        var theEvent = evt || window.event;
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
        var regex = /[0-9]|\./;
        if (!regex.test(key)) {
            theEvent.returnValue = false;
            if (theEvent.preventDefault)
                theEvent.preventDefault();
        }
    }
//    function incorrectValue() {
//        var index = document.getElementById("counter").value;
////        var index = document.getElementById("counter").value;
//        alert(index);
//        document.getElementById('givenMarks3' + index).innerHTML = ;
//
//    }
</script>

