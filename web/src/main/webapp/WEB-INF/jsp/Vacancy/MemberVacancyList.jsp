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
            function homeClick(id) {
                alert(id);
                window.location = 'vacancy.htm?act=backToHome&id=' + id;
            }
        </script>
    </head>
    <body>
        <section class="content-header">
            <button type="button" class="btn btn-primary" style="float: right; width: 130px;" onclick="window.location = 'vacancy.htm?act=backToHomeVacancyList'"><i class="fa fa-home"></i>&nbsp&nbsp&nbsp;Home</button>
            <!--<button type="button" class="btn btn-primary" style="float: left; width: 130px;" onclick="window.location = 'vacancy.htm?act=signUp'"><i class="fa fa-user"></i>&nbsp&nbsp&nbsp;My Profile</button>-->
            <label>Candidate User Name &nbsp : &nbsp&nbsp${applayJobUserMaster.userName}</label>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <br/>
        <br/>
        <ul class="nav nav-tabs" style="text-align: center" >
            <li class="active " ><a href="">My Application</a></li>
            <li ><a href="vacancy.htm?act=myProfileClick">My Profile</a></li>
            <li ><a href="vacancy.htm?act=clickassessment">Assessment</a></li>
        </ul>
        <br/>
        <br/>
        <!--        <div class="form-group">
                    <div class=" col-sm-offset-0">
                        <button type="submit" class="btn btn-primary" style="text-align: center; width: 150px;" data-original-title="" title="" >My Application</button>
                        <button type="submit" class="btn btn-primary" style="text-align: center; width: 150px;" data-original-title="" title="" >My profile</button>
                        <button type="submit" class="btn btn-primary" style="text-align: center; width: 150px;" data-original-title="" title="" >Assessment</button>
                    </div>
                </div>-->
        <form:form action="vacancy.htm?act=clickDeleteVacancy" method="post" commandName="vacancyMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                                                    <th style="width: 50px;">Vacancy Name</th>
                                                                    <th style="width: 50px;">Number Of Position</th>
                                                                    <th style="width: 50px;">Experience</th>
                                                                    <th style="width: 50px;">Start Date</th>
                                                                    <th style="width: 50px;">End Date</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 50px;">Action</th>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                            <thead>
                                                                <tr>
                                                                    <th>${list.name}</th>
                                                                    <th>${list.numberOfPosition}</th>
                                                                    <th>${list.experience}</th>
                                                                    <th>${list.fromDate}</th>
                                                                    <th>${list.toDate}</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 50px;"><a href="vacancy.htm?act=applyJobRegistration">Apply</a></th>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
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


        <%--</form:form>--%>
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    </body>
</html>
