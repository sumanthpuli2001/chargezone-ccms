<%-- 
    Document   : applyJobRegistration
    Created on : Feb 20, 2018, 2:20:17 PM
    Author     : Aman
--%>
<!--
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
<%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
<%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
<head>
    <title>Candidate Registration   </title>
</head>
<body>
   




</body>
<%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
</html>-->



<%-- 
    Document   : ShowVacancyList
    Created on : 16 Feb, 2018, 11:24:21 AM
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
        <title>Candidate Registration</title>

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
        <!--        <style>
                    element.style {
                        left: 0px !important;
                        top: 0px !important;
                        overflow: hidden !important;
                        margin: 0px !important;
                        padding: 0px !important;
                        height: 442px !important;
                        width: 1349px !important;
                        z-index: -999999 !important;
                        position: fixed !important;
                        margin-top: -50px !important;
                    }
                </style>-->
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
            <h1>Candidate Registration</h1>
            <button type="button" class="btn btn-primary" style="float: left; width: 120px;" onclick="window.location = 'vacancy.htm?act=backButton'"><i class="fa fa-backward"></i>&nbsp&nbsp&nbsp;Back</button>
            <button type="button" class="btn btn-primary" style="float: right; width: 120px;" onclick="window.location = 'vacancy.htm?act=showVacancyList'"><i class="fa fa-home"></i>&nbsp&nbsp&nbsp;Home</button>
           
        </section>
            <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <br/>
        <br/>
        <form:form action="vacancy.htm?act=submitRegistration" method="post" commandName="candidateApplyJob"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="form-group">

                            <div class="col-sm-1">

                            </div>
                            <div class="col-sm-2" style="text-align: left">
                                <label>Candidate Name:<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-3">
                                <form:input path="name" class="form-control" placeholder="Enter Candidate Name"></form:input>
                                <form:errors path="name" cssClass="errorDiv"></form:errors>
                                </div>

                                <div class="col-sm-2" style="text-align: left" >
                                    <label>D.O.B :<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3">
                                <form:input path="dob" class="form-control" placeholder="Enter D.O.B"></form:input>
                                <form:errors path="dob" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">

                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Father Name:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3">
                                <form:input path="fatherName" class="form-control" placeholder="Enter Father Name"></form:input>
                                <form:errors path="fatherName" cssClass="errorDiv"></form:errors>
                                </div>

                                <div class="col-sm-2" style="text-align: left">
                                    <label>Mother Name:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3">
                                <form:input path="motherName" class="form-control" placeholder="Enter Mother Name"></form:input>
                                <form:errors path="motherName" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">

                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Father D.O.B :<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3">
                                <form:input path="fatherDob"  class="form-control" size="16" placeholder="DD/MM/YYYY" ></form:input>
                                <form:errors path="fatherDob" cssClass="errorDiv"></form:errors>
                                </div>

                                <div class="col-sm-2" style="text-align: left">
                                    <label>Mother D.O.B :<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3">
                                <form:input path="motherDob"  class="form-control" size="16" placeholder="DD/MM/YYYY" ></form:input>
                                <form:errors path="motherDob" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">

                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Sex :<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                    <input type="radio" path="gender" value="false"/>Male&nbsp;&nbsp;
                                    <input type="radio" path="gender" value="true"/>Female
                                <%--<form:errors path="employeeId" cssClass="errorDiv"></form:errors>--%>
                            </div>

                            <div class="col-sm-2" style="text-align: left">
                                <label>Marital Status:<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-3" style="text-align: left;">
                                <input type="radio" path="maritalStatus"  value="UnMarried"/>UnMarried
                                <input type="radio" path="maritalStatus"  value="Married"/>Married
                                <input type="radio" path="maritalStatus" value="Other"/>Other
                                <%--<form:errors path="employeeName" cssClass="errorDiv"></form:errors>--%>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-sm-1">

                            </div>
                            <div class="col-sm-2" style="text-align: left">
                                <label>Photograph<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-3" style="text-align: left;">
                                <form:input type="file" path="photograph" class="form-control" id="photograph" name="photograph" accept="image/jpg,image/jpeg,image/png"></form:input>
                                <form:errors path="photograph" cssClass="errorDiv"></form:errors>
                                </div>

                                <div class="col-sm-2" style="text-align: left">
                                    <label>Blood Group :<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                    <select path="bloodGroup" id="bloodGroups" class="form-control ">
                                        <option value="">--Select--</option>
                                        <option value="A +ve">A +ve</option>
                                        <option value="A -ve">A -ve</option>
                                        <option value="B +ve">B +ve</option>
                                        <option value="B -ve">B -ve</option>
                                        <option value="AB +ve">AB +ve</option>
                                        <option value="AB -ve">AB -ve</option>
                                        <option value="O +ve">O +ve</option>
                                        <option value="O -ve">O -ve</option>
                                    </select>
                                <form:errors path="bloodGroup" cssClass="errorDiv"></form:errors>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-sm-1">
                            </div>
                            <div class="col-sm-2" style="text-align: left">
                                <label>Present Address:<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-3" style="text-align: left;">
                                <form:textarea path="presentAddress" class="form-control" placeholder="Enter Present Address"></form:textarea>
                                <form:errors path="presentAddress" cssClass="errorDiv"></form:errors>
                                </div>

                                <div class="col-sm-2" style="text-align: left">
                                    <label>Permanent Address:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:textarea path="permanentAddress" class="form-control" placeholder="Enter Permanent Address"></form:textarea>
                                <form:errors path="permanentAddress" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>City:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:input path="city" class="form-control" placeholder="Enter City"></form:input>
                                <form:errors path="city" cssClass="errorDiv"></form:errors>
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Email.Id<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:input path="emailId" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="abc@domain.com" required=""></form:input>
                                <form:errors path="emailId" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Contact No :<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:input path="contactNo" placeholder="Enter Contact No" id="contactNo1" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                <form:errors path="contactNo" cssClass="errorDiv"></form:errors>
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Emergency Contact Person:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:input path="emergencyContactPerson" class="form-control" placeholder="Enter Emergency contact Person"></form:input>
                                <form:errors path="emergencyContactPerson" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Emergency Contact Number:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:input path="emergencyContactNo" placeholder="Enter Emergency Contact No"  maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                <form:errors path="emergencyContactNo" cssClass="errorDiv"></form:errors>
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Highest Education Qualification<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                <form:input path="highestEducationQualification" placeholder="Enter Highest Education" class="form-control"></form:input>
                                <form:errors path="highestEducationQualification" cssClass="errorDiv"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-1">
                                </div>
                                <div class="col-sm-2" style="text-align: left">
                                    <label>Experience On Date Of Joining: Year:<span style="color: red;font-size: 12px;">*</span></label>
                                </div>
                                <div class="col-sm-3" style="text-align: left;">
                                    <form:input path="experianceDateJoiningYear" placeholder="Enter Date of Joining Year" class="form-control"></form:input>
                                <form:errors path="experianceDateJoiningYear" cssClass="errorDiv"></form:errors>
                            </div>
                            <div class="col-sm-2" style="text-align: left">
                                <label>Experience On Date Of Joining: Month:<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-3" style="text-align: left;">
                                <form:input path="experianceDateJoiningMonth" placeholder="Enter Date of Joining Month" class="form-control"></form:input>
                                <form:errors path="experianceDateJoiningMonth" cssClass="errorDiv"></form:errors>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-sm-1">
                            </div>
                            <div class="col-sm-2" style="text-align: left">
                                <label>Certificate Attach :<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-3" style="text-align: left;">
                            <form:input path="certificateAttach" type="file" class="form-control" id="certificateId1" name="certificateId1" accept="image/jpg,image/jpeg,image/png" onchange="checkCertificateFileSize(1);"></form:input>
                                <form:errors path="certificateAttach" cssClass="errorDiv"></form:errors>
                            </div>


                        </div>





                    </div><!-- /.col -->
                </div><!-- /.row -->

            </section>
            <div class="form-group">
                <div class=" col-sm-6 col-sm-offset-7">
                    <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                </div>
            </div>

        </form:form>
        <script>
            function editViewClick(id) {
                window.location = 'vacancy.htm?act=viewVacancy&id=' + id;
            }
        </script>
        <!-- Javascript -->
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>

