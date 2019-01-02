<%-- 
    Document   : ApplayLoginpage
    Created on : 23 Feb, 2018, 11:59:06 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to delete?");
                if (checkboxes) {
                    checkboxes = document.getElementsByName('checkId');
        </script>

    </head>
    <body>
        <section class="content-header">
            <table>

                <td style="text-align: left;">
                    <span><img src="StorageYard/Images/logo.png"  style="width: 150px;float: left;margin-top: 5%;margin-left: 5%;"/></span> 
                </td>
            </table>
            <center><h1>Login:</h1></center>
            <ol class="breadcrumb">
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <br/>
        <br/>
        <form:form class="form-horizontal" role="form" method="post" name='form1'
                   commandName="applayJobUserMaster" onsubmit='return deleteCheck11();' action="vacancy.htm?act=loginCandidate&id=${vacid}">
            <form:hidden path="id"></form:hidden>
            <input type="text" name="checkId" value="${applayJobUserMaster.id}"/>
            <input type="hidden" name="vacid" value="${vacid}"/>
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
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered" style="width: 85%;margin-left: 7%;">
                                                <table id="table_1" class="table table-bordered table-striped table-hover"  align="center"  >
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

                                                                    <!--                                                                    <th>sr.no</th>-->
                                                                    <th style="width: 142px;">Vacancy Name</th>
                                                                    <th style="width: 185px;">Number Of Position</th>
                                                                    <th style="width: 130px;">Experience</th>
                                                                    <!--<th style="width: 105px;">Start Date</th>-->
                                                                    <th style="width: 132px;">Vacancy Last Date</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 132px;">Action</th>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>

                                                                <!--                                                                <td>1</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[4]}</td>
                                                                <!--<td>${list[6]}</td>-->
                                                                <td>${list[7]}</td>
                                                                <!--<td>${list[2]}</td>-->
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="editViewClick(${list[0]},${applayJobUserMaster.id});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
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
            </br>

            <!--                <div class="form-group">
                                <div class=" col-sm-offset-0">
                                    <button type="submit" class="btn btn-primary" style="text-align: center; width: 100px;" data-original-title="" title="" >Submit</button>
                                <button type="button" class="btn btn-primary" style="float: center; width: 120px;" onclick="window.location = 'vacancy.htm?act=signUp&id=${vacid}'"><i class="fa fa-sign-in"></i>&nbsp&nbsp&nbsp;Sign Up</button>
                                </div>
                            </div>-->

        </form:form>
        <script>
                    function editViewClick(id,appyjobid) {
                        window.location = 'vacancy.htm?act=viewVacancySignup&id=' + id + '&checkId=' + appyjobid;
            }
        </script>
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    </body>
</html>

