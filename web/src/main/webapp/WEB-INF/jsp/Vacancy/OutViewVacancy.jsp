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
        <title>Forgot Password</title>

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
    </head>
    <body>
        <section class="content-header">
            <button type="button" class="btn btn-primary" style="float: left; width: 155px;" onclick="window.location = 'vacancy.htm?act=jobApplaClick'"><i class="fa fa-check"></i>&nbsp&nbsp&nbsp;Applay For Job</button>
            <button type="button" class="btn btn-primary" style="float: right; width: 120px;" onclick="window.location = 'vacancy.htm?act=backButton'"><i class="fa fa-backward"></i>&nbsp&nbsp&nbsp;Back</button>
            <h1>View Vacancy Detail</h1>
        </section>
        <form:form class="form-horizontal" method="post"
                   commandName="vacancyMaster" action="vacancy.htm?act=vacancySubmitCreate">
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Department:</label>
                        <form:select path="departmentMaster.id" id="departmentMaster" class="form-control" readonly="true">
                            <%--<form:option value="" label="-- Select --" />--%>
                            <form:options items="${deptMap}"></form:options>
                        </form:select>
                        <%--<form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>Location:</label>
                        <form:select path="locationMaster.id" id="locationMaster" class="form-control" readonly="true">
                            <%--<form:option value="" label="-- Select --" />--%>
                            <form:options items="${locationMap}"/>
                        </form:select>
                        <%--<form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Job Type:</label>
                        <form:select path="jobtypeMaster.id" id="jobtypeMaster" class="form-control" readonly="true">
                            <%--<form:option value="" label="-- Select --" />--%>
                            <form:options items="${jobtype1}"></form:options>
                        </form:select>
                        <%--<form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>Designation:</label>
                        <form:select path="designationMaster.id" id="designationMaster" class="form-control" readonly="true">
                            <%--<form:option value="" label="-- Select --" />--%>
                            <form:options items="${desigList}"></form:options>
                        </form:select>
                        <%--<form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Employee Category:</label>
                        <form:select path="mprEmployeeCategory.id" id="mprEmployeeCategory" class="form-control" readonly="true">
                            <%--<form:option value="" label="-- Select --" />--%>
                            <form:options items="${categoryList}"></form:options>
                        </form:select>
                        <%--<form:errors path="mprEmployeeCategory.id" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>Employee Type:</label>
                        <form:select path="mprEmployeeTypeMaster.id" id="mprEmployeeTypeMaster" class="form-control" readonly="true">
                            <%--<form:option value="" label="-- Select --" />--%>
                            <form:options items="${emptypeList}"></form:options>
                        </form:select>
                        <%--<form:errors path="mprEmployeeTypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>From Date:</label>
                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                        <form:input path="fromDate" class="form-control" onchange="dateDifference(this.value);" placeholder="From Date" readonly="true"></form:input>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    <%--<form:errors path="fromDate" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>To Date:</label>
                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                        <form:input path="toDate" class="form-control" onchange="dateDifference(this.value);" placeholder="To Date" readonly="true"></form:input>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    <%--<form:errors path="toDate" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Name:</label>
                        <form:input path="name" class="form-control" placeholder="Name" readonly="true"></form:input>
                        <%--<form:errors path="name" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>Skill:</label>
                        <form:input path="skill" class="form-control" placeholder="skill" readonly="true"></form:input>
                        <%--<form:errors path="skill" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Number Of Position:</label>
                        <form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position" readonly="true"></form:input>
                        <%--<form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>Work Experience:</label>
                        <form:input path="experience" class="form-control" placeholder="Experience" readonly="true"></form:input>
                        <%--<form:errors path="experience" cssClass="errorDiv"></form:errors>--%>
                </div>

            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Salary Range:</label>
                        <form:input path="salaryRange" class="form-control" placeholder="salaryRange" readonly="true"></form:input>
                        <%--<form:errors path="salaryRange" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-6">
                    <label>Responsibility:</label>
                        <form:input path="responsibility" class="form-control" placeholder="Responsibility" readonly="true"></form:input>
                        <%--<form:errors path="responsibility" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <label>Description:</label>
                        <form:input path="description" class="form-control" placeholder="description" readonly="true"></form:input>
                    </div>
                    </div>

        </form:form>
        <script>
            function editViewClick(id) {
                window.location = 'vacancy.htm?act=viewVacancy&id=' + id;
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
