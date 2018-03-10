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
        <script>
            function ApplayClick(id) {
                window.location = 'vacancy.htm?act=applayForJob&id=' + id;
            }
        </script>
    </head>
    <body style="width:95%;">
        <section class="content-header" style='margin-top:5%; margin-left:5%;'>
            <button type="button" class="btn btn-primary" style="float: left; width: 170px;" onclick="ApplayClick(${vacancyMaster.id});"><i class="fa fa-check"></i>&nbsp&nbsp&nbsp;Applay For Job1</button>
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
                        <p style='font-size:19px; font-weight:600; text-align: left;'>Bulwarks System</p>
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
                            <p>
                                <label style="font-weight: 500;">From Date:</label> 
                                <label style=" font-weight: normal;font-size:14px; color: grey;">${vacancyMaster.fromDate}</label>
                            </p>
                            <p>
                                <label style="font-weight: 500;">To Date:</label>
                                <label style=" font-weight: normal;font-size:14px; color: grey;">${vacancyMaster.toDate}</label>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Description:</label>
                                <label style='font-weight:normal;font-size:14px; color: grey;'>${vacancyMaster.description}</label>
                            </p>
                            
                        </div>
                        <div class="col-md-8 col-sm-12 col-xs-12" style="width: 65% !important;">

                            <p>
                                <label style="font-weight: 500;">Name:</label> 
                                <label style=" font-weight: normal;font-size:14px; color: grey;" >${vacancyMaster.name}</label>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Work Experience:</label>
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
                                <label style="font-weight: 500;">Employee Category:</label>
                                <c:forEach  var="list" items="${categoryList}">
                                    <c:if test="${vacancyMaster.mprEmployeeCategory.id eq list.key}">
                                        <label style=" font-weight: normal;font-size:14px; color: grey;">${list.value}</label>
                                    </c:if>
                                </c:forEach>
                            </p>
                            <p>
                                <label style="font-weight: 500;">Skill:</label>
                                <label style='font-weight:normal;font-size:14px; color: grey;'>${vacancyMaster.skill}</label>
                           
                            </p>
                            <p>
                                <label style="font-weight: 500;">Salary Range:</label>
                                <label style=" font-weight: normal; font-size:14px; color: grey;">${vacancyMaster.salaryRange}</label>
                            </p>

                            
                            <!--                                <p>
                                                               <label style="font-weight: 500;">Responsibility:</label>  
                                                               <label style=" font-weight: normal;font-size:14px; color: grey;">${vacancyMaster.responsibility}</label> 
                                                            </p>-->


                        </div>
                    </div>
                    <!--<div class="form-group" style='margin-left: 3%;'>-->

                    <!--                            <div class="col-sm-2" style="text-align: left; width:7.666667%;" >
                                                    <label>Department:</label>
                                                </div>-->
                    <!--<div class="col-sm-2">-->
                    <!--                                <label>
                    <%--<form:options  items="${deptMap}" ></form:options>--%>
              </label>-->
                    <%--<c:forEach  var="list" items="${deptMap}">--%>
                    <%--<c:if test="${vacancyMaster.departmentMaster.id eq list.key}">--%>
                        <!--<label class="label">${list.value}</label>-->
                    <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<form:select disabled="false" path="departmentMaster.id" id="departmentMaster" class="form-control" readonly="true" >--%>
                    <%--<form:option value="" label="-- Select --" />--%>
                    <%--<form:options  items="${deptMap}" ></form:options>--%>
                    <%--</form:select>--%>  
                    <%--<form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>--%>
                    <!--</div>-->
                    <!--                            <div class="col-sm-2" style="text-align: left; width:7.666667%;">
                                                    <label>Location:</label>
                                                </div>
                                                <div class="col-sm-2">-->
                    <%--<c:forEach  var="list" items="${locationMap}">--%>
                    <%--<c:if test="${vacancyMaster.locationMaster.id eq list.key}">--%>
                        <!--<label class="label">${list.value}</label>-->
                    <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<form:select disabled="true" path="locationMaster.id" id="locationMaster" class="form-control" readonly="true">--%>
                    <%--<form:option value="" label="-- Select --" />--%>
                    <%--<form:options items="${locationMap}"/>--%>
                    <%--</form:select>--%>
                    <%--<form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>--%>
                    <!--</div>-->
                    <!--                             <div class="col-sm-2" style="text-align: left; width:7.666667%;">
                                                    <label>Job Type:</label>
                                                </div>-->
                    <!--                            <div class="col-sm-2">
                    <%--<c:forEach  var="list" items="${jobtype1}">--%>
                    <%--<c:if test="${vacancyMaster.jobtypeMaster.id eq list.key}">--%>
                        <label class="label">${list.value}</label>
                    <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<form:select disabled="true" path="jobtypeMaster.id" id="jobtypeMaster" class="form-control" readonly="true">--%>
                    <%--<form:option value="" label="-- Select --" />--%>
                    <%--<form:options items="${jobtype1}"></form:options>--%>
                    <%--</form:select>--%>
                    <%--<form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>-->

                    <!--</div>-->
                    <!--                        <div class="form-group">
                                                <div class="col-sm-1">
                    
                                                </div>
                                               
                                                
                                            </div>-->
                    <!--                        <div class="form-group">
                                                
                                                <div class="col-sm-2" style="text-align: left; width:10.666667%;">
                                                    <label>Employee Category:</label>
                                                </div>
                                                <div class="col-sm-2">
                    <%--<c:forEach  var="list" items="${categoryList}">--%>
                    <%--<c:if test="${vacancyMaster.mprEmployeeCategory.id eq list.key}">--%>
                        <label class="label">${list.value}</label>
                    <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<form:select disabled="true" path="mprEmployeeCategory.id" id="mprEmployeeCategory" class="form-control" readonly="true">--%>
                    <%--<form:option value="" label="-- Select --" />--%>
                    <%--<form:options items="${categoryList}"></form:options>--%>
                    <%--</form:select>--%>
                    <%--<form:errors path="mprEmployeeCategory.id" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-2" style="text-align: left">
                    <label>Employee Type:</label>
                </div>
                <div class="col-sm-2" style='font-weight: 300 !important;'>
                    <%--<c:forEach  var="list" items="${emptypeList}">--%>
                    <%--<c:if test="${vacancyMaster.mprEmployeeTypeMaster.id eq list.key}">--%>
                        <label class="label">${list.value}</label>
                    <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<form:select disabled="true" path="mprEmployeeTypeMaster.id" id="mprEmployeeTypeMaster" class="form-control" readonly="true">--%>
                    <%--<form:option value="" label="-- Select --" />--%>
                    <%--<form:options items="${emptypeList}"></form:options>--%>
                    <%--</form:select>--%>
                    <%--<form:errors path="mprEmployeeTypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>-->
                    <!--                        <div class="form-group">
                                                <div class="col-sm-1">
                    
                                                </div>
                                                <div class="col-sm-2" style="text-align: left">
                                                    <label>From Date:</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="label">${vacancyMaster.fromDate}</label>
                                                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                    <%--<form:input path="fromDate" class="form-control" onchange="dateDifference(this.value);" placeholder="From Date" readonly="true"></form:input>--%>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    <%--<form:errors path="fromDate" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-2" style="text-align: left">
                    <label>To Date:</label>
                </div>
                <div class="col-sm-3">
                    <label class="label">${vacancyMaster.toDate}</label>
                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                    <%--<form:input path="toDate" class="form-control" onchange="dateDifference(this.value);" placeholder="To Date" readonly="true"></form:input>--%>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    <%--<form:errors path="toDate" cssClass="errorDiv"></form:errors>--%>
                </div>
           </div>
                    <!--                        <div class="form-group">
                                                <div class="col-sm-1">
                    
                                                </div>
                                                <div class="col-sm-2" style="text-align: left">
                                                    <label>Name:</label>
                                                </div>
                                                <div class="col-sm-3">
                                                     <label class="label" >${vacancyMaster.name}</label>
                    <%--<form:input path="name" class="form-control" placeholder="Name" readonly="true"></form:input>--%>
                    <%--<form:errors path="name" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-2" style="text-align: left">
                    <label>Skill:</label>
                </div>
                <div class="col-sm-3">
                    <label class="label">${vacancyMaster.skill}</label>
                    <%--<form:input path="skill" class="form-control" placeholder="skill" readonly="true"></form:input>--%>
                    <%--<form:errors path="skill" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>-->
                    <!--                        <div class="form-group">
                                                <div class="col-sm-1">
                    
                                                </div>
                                                <div class="col-sm-2" style="text-align: left">
                                                    <label>Number Of Position:</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="label">${vacancyMaster.numberOfPosition}</label>
                    <%--<form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position" readonly="true"></form:input>--%>
                    <%--<form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-2" style="text-align: left; width:7.666667%;">
                    <label>Designation:</label>
                </div>
                <div class="col-sm-2">
                    <%--<c:forEach  var="list" items="${desigList}">--%>
                    <%--<c:if test="${vacancyMaster.designationMaster.id eq list.key}">--%>
                        <label class="label">${list.value}</label>
                    <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<form:select disabled="true" path="designationMaster.id" id="designationMaster" class="form-control" readonly="true">--%>
                    <%--<form:option value="" label="-- Select --" />--%>
                    <%--<form:options items="${desigList}"></form:options>--%>
                    <%--</form:select>--%>
                    <%--<form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-2" style="text-align: left">
                    <label>Work Experience:</label>
                </div>
                <div class="col-sm-3">
                    <label class="label">${vacancyMaster.experience}</label>
                    <%--<form:input path="experience" class="form-control" placeholder="Experience" readonly="true"></form:input>--%>
                    <%--<form:errors path="experience" cssClass="errorDiv"></form:errors>--%>
                </div>

            </div>-->
                    <!--                        <div class="form-group">
                                                <div class="col-sm-1">
                    
                                                </div>
                                                <div class="col-sm-2" style="text-align: left">
                                                    <label>Salary Range:</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="label">${vacancyMaster.salaryRange}</label>
                    <%--<form:input path="salaryRange" class="form-control" placeholder="salaryRange" readonly="true"></form:input>--%>
                    <%--<form:errors path="salaryRange" cssClass="errorDiv"></form:errors>--%>
                </div>
                <div class="col-sm-2" style="text-align: left">
                    <label>Responsibility:</label>
                </div>
                <div class="col-sm-3">
                    <label class="label">${vacancyMaster.responsibility}</label>
                    <%--<form:input path="responsibility" class="form-control" placeholder="Responsibility" readonly="true"></form:input>--%>
                    <%--<form:errors path="responsibility" cssClass="errorDiv"></form:errors>--%>
                </div>
            </div>-->
                    <!--                        <div class="form-group">
                                                <div class="col-sm-1">
                    
                                                </div>
                                                <div class="col-sm-2" style="text-align: left">
                                                    <label>Description:</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="label">${vacancyMaster.description}</label>
                    <%--<form:input path="description" class="form-control" placeholder="description" readonly="true"></form:input>--%>
                    </div>
                </div>-->
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
