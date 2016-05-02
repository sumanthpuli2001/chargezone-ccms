<%-- 
    Document   : ForgotPwdReset
    Created on : Feb 2, 2016, 12:44:06 PM
    Author     : BlackBull
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
        <title>Employee Cafe Login</title>

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
        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Checking ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
            $(function () {
                $("#username").focus();
            });
        </script>
    </head>

    <body>

        <!-- Top menu -->
        <nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
            </div>
        </nav>

        <!-- Top content -->
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Zydex</strong></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top" style="height: auto;">
                                <div class="form-top-left">
                                    <h3>Recover Credential</h3>
                                    <p>Reset Password:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-pencil"></i>
                                </div>
                            </div>

                            <div class="form-bottom contact-form">
                                <form:form role="form" cssClass="form-signin" action="logIn.html?act=resetPwdAfterLoginSubmit" method="post" commandName="forgotPwd" name='form1' onsubmit='return saveSubmit11();'>
                                    <div class="form-group">
                                        <label class="sr-only" for="contact-subject">Password</label>
                                        <form:input path="password" value="" cssClass="contact-subject form-control" placeholder="Enter password"></form:input><br/>
                                        <form:input path="password" value="" cssClass="contact-subject form-control" placeholder="Re-enter password"></form:input>
                                        <%--<form:errors path="password" cssClass="errorDiv"></form:errors>--%>
                                        <!--<input type="text" name="Password" placeholder="Password..." class="contact-subject form-control" id="contact-subject">-->
                                    </div>
                                    <div class="form-group">
                                        <%

                                            String failureMessage = (String) request.getAttribute("failureMessage");
                                            if (failureMessage != null) {
                                                out.print("<div class='form-control alert alert-danger'>" + failureMessage + "</div>");
                                            }
                                            String successMessage = (String) request.getAttribute("successMessage");
                                            if (successMessage != null) {
                                                out.print("<div class='form-control alert alert-success'>" + successMessage + "</div>");
                                            }
                                        %>
                                    </div>
                                    <button type="submit" class="btn">Login</button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <!-- Javascript -->
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
    <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
    <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
    <script src="StorageYard/JS/login/scripts.js"></script>

    <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->

</body>

</html>

