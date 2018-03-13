<%-- 
    Document   : QuestionAnsCheck
    Created on : 13 Mar, 2018, 10:48:49 AM
    Author     : Admin
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
<html>

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
            function viewClick(id) {
//                alert(id);
//            window.location = 'payrollSalaryType.htm?act=viewClick&id=' + id;
                window.location = 'vacancy.htm?act=clickassessmentOnlineTest&id=' + id;
            }
        </script>
       
        <script>
            function homeClick(id) {
//                alert(id);
                window.location = 'vacancy.htm?act=backToHome&id=' + id;
            }
        </script>
        <script>
            function submitForm(id) {
                alert(id);
//                window.location = 'vacancy.htm?act=backToHome&id=' + id;
            }
        </script>
    </head>
    <body>
        <section class="content-header">
            <button type="button" class="btn btn-primary" style="float: right; width: 130px;" onclick="window.location = 'vacancy.htm?act=backToHomeVacancyList'"><i class="fa fa-home"></i>&nbsp&nbsp&nbsp;Home</button>
            <button type="button" class="btn btn-primary" style="float: left; width: 130px;" onclick="window.location = 'vacancy.htm?act=logout'"><i class="fa fa-long-arrow-left"></i>&nbsp&nbsp&nbsp;Log Out</button>
            <label>Candidate User Name&nbsp : &nbsp&nbsp${ajuMaster.userName}</label>
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
 
    <script>

        function saveSubmit() {
            var data;
            var finalData = [];
            var candidateId = document.getElementById("candidateID").value;
//                alert(candidateId);
            var len = document.getElementById("countDetailId").value;
            for (var i = 1; i < parseInt(len) + 1; i++) {
                data = $('input[name=' + i + ']:checked').val();
                if (data === undefined) {
                    data = $('#' + i).val();
                }
                finalData.push(data);
            }
            $.ajax({
                type: "POST",
                url: "vacancy.htm?act=clickSubmitQuestionAnswer&finalData=" + finalData + "&candidateId=" + candidateId,
                data: {},
                dataType: "text",
                success: function (responseTxt) {
                    document.getElementById("endwoandHlerrorDiv").innerHTML = responseTxt;
                    if (responseTxt != '') {
                        document.getElementById("startDateTime").value = "";
                        document.getElementById("endDateTime").value = "";
                    }
                },
                error: function () {
//                            alert('Error occured');
                }
            });
//                alert(finalData.toString());
//                    window.location = "vacancy.htm?act=clickSubmitQuestionAnswer&finalData=" + finalData.toString();
//                 action="vacancy.htm?act=clickSubmitQuestionAnswer" 
        }
    </script>
    <!--        //       -->



    <form:form onsubmit="saveSubmit();"
               method="post"
               name='form1'  class="form-horizontal" role="form">
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
                                                        <thead>

                                                        <input type="hidden" name="candidateID" id="candidateID" value="${candidateID}">
                                                        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">
                                                        <c:forEach var="employeeAdditional" items="${list2}" varStatus="status">
                                                            <%--<c:if test="${employeeAdditional[1] ne 0.0}">--%>

                                                            <tr>
                                                                <td>${status.count}. ${employeeAdditional[0]}</td>
                                                            </tr>
                                                            <tr>
                                                            <c:if test="${employeeAdditional[1] eq 0}">

                                                                <!--                                                                        <input type="checkbox" class="form-check-input" id="checkbox104">
                                                                                                                                        <label class="form-check-label" for="checkbox1">${employeeAdditional[2]}</label>-->
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[3]}" >
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[3]}">${employeeAdditional[2]}</label></td></tr>
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[5]}">
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[5]}">${employeeAdditional[4]}</label></td></tr>
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[7]}">
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[7]}">${employeeAdditional[6]}</label></td></tr>
                                                                <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[9]}">
                                                                        <label class="form-check-label" for="radio100${employeeAdditional[9]}">${employeeAdditional[8]}</label></td></tr>
                                                            </c:if>
                                                            <c:if test="${employeeAdditional[1] eq 1}">
                                                                <td><textarea type="text" name="${status.count}" id="${status.count}" rows="4" cols="70" placeholder="Enter your answer here..."></textarea></td>
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
</html>
<style>

    .table-bordered>thead>tr>td{
        border: 0px solid #ddd;
    }

</style>


</html>
