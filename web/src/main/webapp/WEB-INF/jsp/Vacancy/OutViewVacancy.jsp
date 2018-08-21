<%-- 
    Document   : viewVacancy
    Created on : 16 Feb, 2018, 2:20:34 PM
    Author     : Vikas
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Apply For Job</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">

        <!--        <style>
                    .labelDiv {
                        width: 120px;
                    }
                </style>-->
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
            function ApplayClick(id) {
                window.location = 'vacancy.htm?act=applayForJob&id=' + id;
            }
        </script>
    </head>
    <body style="width:95%;">
        <section class="content-header" style='margin-top:5%; margin-left:5%;'>
            <button type="button" class="btn btn-primary" style="float: left; width: 170px;" onclick="ApplayClick(${vacancyMaster.id});"><i class="fa fa-check"></i>&nbsp&nbsp&nbsp;Apply For Job</button>
            <button type="button" class="btn btn-primary" style="float: right; width: 120px;" onclick="window.location = 'vacancy.htm?act=backButton'"><i class="fa fa-backward"></i>&nbsp&nbsp&nbsp;Back</button>
            <h1>View Vacancy Detail</h1>
        </section>
        <br>  </br>
        <br></br>
        <form:form class="form-horizontal" method="post"
                   commandName="vacancyMaster" action="vacancy.htm?act=vacancySubmitCreate">
            <section class="content">
                <div class="row">
                    <div class="col-md-12 col-sm-12" style="text-align: left; margin-left: 15%; width: 85%;">
                        <p style='font-size:19px; font-weight:600; text-align: left;'>SPC Lifesciencess Pvt.Ltd</p>
                        <div class='col-md-4 col-sm-4 col-xs-12'>

                            <p>
                                <label style="font-weight: 500;">Location:</label> <c:forEach  var="list" items="${locationMap}">
                                    <c:if test="${vacancyMaster.locationMaster.id eq list.key}">
                                        <label style=" font-weight: normal;font-size:14px; color: grey;">${list.value}</label>
                                    </c:if>
                                </c:forEach></p>
                            <p>
                                <label style="font-weight: 500;">Number Of Position:</label>
                                <label style=" font-weight: normal;font-size:14px; color: grey;">${vacancyMaster.numberOfPosition}</label>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Designation:</label>
                                <c:forEach  var="list" items="${desigList}">
                                    <c:if test="${vacancyMaster.designationMaster.id eq list.key}">
                                        <label style=" font-weight: normal;font-size:14px; color: grey;">${list.value}</label>
                                    </c:if>
                                </c:forEach>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Department:</label>
                                <c:forEach  var="list" items="${deptMap}">
                                    <c:if test="${vacancyMaster.departmentMaster.id eq list.key}">
                                        <label style=" font-weight: normal;font-size:14px; color: grey;">${list.value}</label>
                                    </c:if>
                                </c:forEach>
                            </p>
                            <!--                            <p>
                                                            <label style="font-weight: 500;">From Date:</label> 
                                                            <label style=" font-weight: normal;font-size:14px; color: grey;">${vacancyMaster.fromDate}</label>
                                                        </p>-->
                            <p>
                                <label style="font-weight: 500;">Vacancy Last Date:</label>
                                <label style=" font-weight: normal;font-size:14px; color: grey;">${vacancyMaster.toDate}</label>
                            </p>


                        </div>
                        <div class="col-md-8 col-sm-12 col-xs-12" style="width: 65% !important;">

                            <p>
                                <label style="font-weight: 500;">Name:</label> 
                                <label style=" font-weight: normal;font-size:14px; color: grey;" >${vacancyMaster.name}</label>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Work Experience(In Years):</label>
                                <label style=" font-weight: normal; font-size:14px; color: grey;">${vacancyMaster.experience}</label>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Job Type:</label> 
                                <c:forEach  var="list" items="${jobtype1}">
                                    <c:if test="${vacancyMaster.jobtypeMaster.id eq list.key}">
                                        <label style=" font-weight: normal;font-size:14px; color: grey;">${list.value}</label>
                                    </c:if>
                                </c:forEach>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Salary :</label>
                                <label style=" font-weight: normal; font-size:14px; color: grey;">${vacancyMaster.salaryRange}</label>
                            </p>
                        </div>
                        <div>
                            <p>
                                <label style="font-weight: 500;">:-Description-:</label>
                                <label style='font-weight:normal;font-size:14px; color: grey;'>${vacancyMaster.description}</label>
                            </p>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
        <script>
            function editViewClick(id) {
                window.location = 'vacancy.htm?act=viewVacancy&id=' + id;
            }
        </script>
        <style>
            .label{


            }

        </style>

        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>

    </body>

</html>
