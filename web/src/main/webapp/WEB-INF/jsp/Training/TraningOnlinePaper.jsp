<%-- 
    Document   : MemberVacancyList
    Created on : 23 Feb, 2018, 11:51:30 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Form</title>

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
        <script type="text/javascript" src="StorageYard/Other/flipclock/js/libs/base.js"></script> 
        <script type="text/javascript" src="StorageYard/Other/flipclock/js/libs/flipclock.js"></script>
        <script type="text/javascript" src="StorageYard/Other/flipclock/js/faces/dailycounter.js"></script> 

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
//            window.onbeforeunload = function () {
//                return false;
//            }
//            < script type = "text/javascript" >
//                    $('p').append(Math.random());
//            $(window).bind({
//                beforeunload: function (ev) {
//                    ev.preventDefault();
//                },
//                unload: function (ev) {
//                    ev.preventDefault();
//                }
//            });</script>
    </script>



    <script>
        function viewClick(id) {
//                alert(id);
//            window.location = 'payrollSalaryType.htm?act=viewClick&id=' + id;
            window.location = 'vacancy.htm?act=clickassessmentOnlineTest&id=' + id;
        }
    </script>
    <!--        <script>
    
                function saveSubmit11() {
                    alert("hii");
                    var flag3 = true;
                    var countDetailId = document.getElementById("countDetailId").value;
                    for (var i = 1; i <= countDetailId; i++) {
    
                        var hotelBookingRequired = document.getElementById("radio100" + i).value;
                        alert(hotelBookingRequired);
                        //                    alert(hotelBookingRequired + "aaaa" + i);
    
    
                    }
                }
    
            </script>-->
    <script>
        function homeClick(id) {
//                alert(id);
            window.location = 'vacancy.htm?act=backToHome&id=' + id;
        }
    </script>
    <script>
        function submitFormbyhome() {

            var onlineAssmentID = document.getElementById("onlineAssmentID").value;
            window.location = 'trainingAssessment.htm?act=backToHomeVacancyListCandidate&onlineAssmentID=' + onlineAssmentID;
        }
    </script>
    <script>
        function submitFormbyLOgout() {
//            alert("hii");
            var onlineAssmentID = document.getElementById("onlineAssmentID").value;
            window.location = 'vacancy.htm?act=logoutCandidateLogout&onlineAssmentID=' + onlineAssmentID;
        }
    </script>
</head>
<body onload=" setTime()">
    <section class="content-header">
        <button type="button" class="btn btn-primary" style="float: right; width: 130px;" onclick="submitFormbyhome();"><i class="fa fa-home"></i>&nbsp&nbsp&nbsp;Home</button>
        <!--<button type="button" class="btn btn-primary" style="float: left; width: 130px;" onclick="submitFormbyLOgout();"><i class="fa fa-long-arrow-left"></i>&nbsp&nbsp&nbsp;Log Out</button>-->
        <!--<button type="button" class="btn btn-primary" style="float: left; width: 130px;" onclick="window.location = 'vacancy.htm?act=logout'"><i class="fa fa-long-arrow-left"></i>&nbsp&nbsp&nbsp;Log Out</button>-->
        <label>Trainer User Name&nbsp : &nbsp&nbsp${sessionScope.ApplayJobUserMaster.userName}</label>
    </section>
    <c:if test="${!empty successMessage}">
        <div class="alert alert-info" role="alert">${successMessage}</div>
    </c:if>
    <c:if test="${!empty failureMessage}">
        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
    </c:if>
    <br/>
    <br/>

    <br/>
    <br/>
    <!--   
    <div class="form-group">
                <div class=" col-sm-offset-0">
                    <button type="submit" class="btn btn-primary" style="text-align: center; width: 150px;" data-original-title="" title="" >My Application</button>
                    <button type="submit" class="btn btn-primary" style="text-align: center; width: 150px;" data-original-title="" title="" >My profile</button>
                    <button type="submit" class="btn btn-primary" style="text-align: center; width: 150px;" data-original-title="" title="" >Assessment</button>
                </div>
            </div>-->

    <script>
        function setTime() {
            document.getElementById('Duration').value;
//                 var Duration = document.getElementById("Duration").value;
//                alert(document.getElementById('timer').innerHTML);
//                alert( document.getElementById('Duration').value);
            startTimer();
        }

        function saveSubmit() {

            var data;
            var data1;
            var finalData = [];
            var finalData1 = [];
            var finalData2 = [];
            var candidateId = document.getElementById("onlineAssmentID").value;
//                alert(candidateId);
            var len = document.getElementById("countDetailId").value;
            for (var i = 1; i < parseInt(len) + 1; i++) {
                data1 = document.getElementById("candidateIDEmp" + i).value;
                data = $('input[name=' + i + ']:checked').val();
//                    data1 = $('input[name=candidateID' + i + ']:checked').val();
                if (data === undefined) {
                    data = $('#' + i).val();
                }
                finalData.push(data);
                finalData1.push(data1);
            }
            $.ajax({
                type: "POST",
                url: "trainingAssessment.htm?act=clickSubmitQuestionAnswer&finalData=" + finalData + "&candidateId=" + candidateId + "&finalData1=" + finalData1,
                data: {},
                dataType: "text",
                success: function (responseTxt) {
//                      window.location = "trainingAssessment.htm?act=clickassessment";
//                    saveSubmiturl();
//                    window.location = "trainingAssessment.htm?act=clickassessment";

                },
            });


//            alert("hii");
////                alert(finalData.toString());
//             alert("hii2");
//            window.location = "vacancy.htm?act=Login";
//                 action="vacancy.htm?act=clickSubmitQuestionAnswer" 
        }
    </script>



    <script>


        function startTimer() {
            //Current System Time
            var todayDateTime = new Date();
            var th = todayDateTime.getHours();
            var tm = todayDateTime.getMinutes();
            var ts = todayDateTime.getSeconds();
            var currentTime = new Date();
            currentTime.setHours(th);
            currentTime.setMinutes(tm);
            currentTime.setSeconds(ts);

            //Test Start Time
            var finalStartTime = document.getElementById('StartTime').value;
//            alert(finalStartTime);
            var TestStartTime = new Date();
            var timeArray1 = finalStartTime.split(':');
            TestStartTime.setHours(timeArray1[0]);
            TestStartTime.setMinutes(timeArray1[1]);
            TestStartTime.setSeconds(timeArray1[2]);



            //test total time
            var presentTime = document.getElementById('Duration').value;
            var TestTotalTime = new Date();
            var timeArray2 = presentTime.split(':');
            TestTotalTime.setHours(timeArray2[0]);
            TestTotalTime.setMinutes(timeArray2[1]);
            TestTotalTime.setSeconds(timeArray2[2]);


            var dddd = (((parseInt(timeArray2[0]) * 60) + parseInt(timeArray2[1])) * 60 * 1000) + (parseInt(timeArray2[2]) * 1000);

            var timeDiff1 = (currentTime.getTime() - TestStartTime.getTime());

            var timeDiff = dddd - timeDiff1;

//            alert(dddd);
//            alert(currentTime.getTime());
//            alert(TestStartTime.getTime());

            var milliseconds = parseInt(timeDiff);
            var h11 = Math.floor(milliseconds / 3600000);
            var m11 = Math.floor((milliseconds - (h11 * 3600000)) / 60000);
            var s11 = parseInt((milliseconds - (h11 * 3600000) - (m11 * 60000)) / 1000);
            var h = h11;
            var m = m11;
            var s = checkSecond(parseInt(s11) - 1);
            if (s == 59) {
                m = m - 1;
            }
            if (h < 0) {
                h = 12 + h;
            }
            document.getElementById('Duration1').value =
                    h + ":" + m + ":" + s;
//            if (parseInt(h) = 0 && parseInt(m) = 0 && parseInt(s) = 0) {
//                saveSubmitexpired();
//            }
            if (h == 0 && m == 0 && s == 0) {
                saveSubmitexpired();
            }
            setTimeout(startTimer, 1000);
        }

        function checkSecond(sec) {
            if (sec == 0) {
                sec = "0" + sec
//                saveSubmitexpired();
            }
            ;
            // add zero in front of numbers < 10
            if (sec < 0) {
                sec = "59"
                //                    alert("hiii");
            }
            ;
            return sec;
        }
    </script>



    <script>
        function saveSubmitexpired() {
            var onlineAssmentID = document.getElementById("onlineAssmentID").value;
            window.location = 'trainingAssessment.htm?act=clickSubmitQuestionAnswerExpired&onlineAssmentID=' + onlineAssmentID;
        }
    </script>
    <script>
        function saveSubmiturl() {
             
//            var onlineAssmentID = document.getElementById("onlineAssmentID").value;
            window.location.href  = 'trainingAssessment.htm?act=clickassessment';
            
        }
    </script>
    <!--    <script>
    
            var oldURL = "";
            var currentURL = window.location = 'vacancy.htm?act=clickassessmentOnlineTest&id=' + id + '&candidateID=' + candidateID + '&onlineAssment=' + onlineAssment;
            $(window).load(function checkURLchange(currentURL) {
    
                if (currentURL != oldURL) {
                    alert("url changed!");
                    oldURL = currentURL;
                }
    
                oldURL = window.location.href;
                setInterval(function () {
                    checkURLchange(window.location.href);
                }, 1000);
            });
    //        $(window).load(function() {...});
    
    //        checkURLchange();
        </script>-->

    <!--        //       -->



    <form:form onsubmit="saveSubmit();"
               method="post"
               name='form1'  class="form-horizontal" role="form" action="trainingAssessment.htm?act=clickassessment">
        <%--action="vacancy.htm?act=clickSubmitQuestionAnswer"--%> 
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                            </div>

                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12" style="width:96%;">
                                        <div class="table table-bordered" style="margin-left: 2%; margin-right: 5%;">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style=" text-align: left; border-bottom: 0px !important; margin-right: 5%;"   >
                                                <c:choose>
                                                    <c:when test="${empty list2}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!--<div id="clockDiv" class="clock" style="margin:1em;"></div>-->
                                                        <div><input type="hidden" name="Duration" id="Duration" value="${Duration}" readonly="true"></div>
                                                        <div>Time left =<input type="text" name="Duration" id="Duration1" readonly="true"></div>
                                                        <thead>

                                                        <input type="hidden" name="candidateID" id="candidateID" value="${candidateID}">
                                                        <input type="hidden" name="onlineAssmentID" id="onlineAssmentID" value="${onlineAssmentID}">
                                                        <input type="hidden" name="StartTime" id="StartTime" value="${StartTime}">

                                                        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">
                                                        <c:forEach var="employeeAdditional" items="${list2}" varStatus="status">
                                                            <%--<c:if test="${employeeAdditional[1] ne 0.0}">--%>

                                                            <tr>
                                                                <td>${status.count}. ${employeeAdditional[0]}
                                                                    <input type="hidden" name="candidateIDEmp${status.count}" id="candidateIDEmp${status.count}" value="${employeeAdditional[2]}">
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <c:if test="${employeeAdditional[1] eq 0}">

                                                                    <!--                                                                        <input type="checkbox" class="form-check-input" id="checkbox104">
                                                                                                                                            <label class="form-check-label" for="checkbox1">${employeeAdditional[2]}</label>-->
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[4]}" >
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[4]}">${employeeAdditional[3]}</label></td></tr>
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[6]}">
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">${employeeAdditional[5]}</label></td></tr>
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[8]}">
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[8]}">${employeeAdditional[7]}</label></td></tr>
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[10]}">
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[10]}">${employeeAdditional[9]}</label></td></tr>
                                                                    </c:if>
                                                                    <c:if test="${employeeAdditional[1] eq 1}">
                                                                <td><textarea type="text" name="${status.count}" id="${status.count}" rows="4"  value="${employeeAdditional[2]}" cols="70" placeholder="Enter your answer here..."></textarea></td>
                                                                </c:if>
                                                            </tr>

                                                        </c:forEach>

                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>

                                            </table>
                                            <div class="form-group">

                                                <div class=" col-sm-2">
                                                    <button type="submit" class="btn btn-primary" data-original-title=""  title="" style="text-align: center" >Submit</button> 
                                                </div>
                                            </div>
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







    <%--</form:form>--%>
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
    <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
    <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
    <script src="StorageYard/JS/login/scripts.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
</body>
<style>

    .table-bordered>thead>tr>td{
        border: 0px solid #ddd;
    }

</style>
</html>