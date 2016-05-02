<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

            //=====Blank password on username change (end)================//

        </script>


    </head>

    <body >
        <c:set var="userName" value=""/>
        <c:set var="password" value=""/>
        <c:set var="rememberMe" value=""/>
        <c:if test="${cookie.userNameCookie.value ne '' && cookie.userNameCookie.value ne null}">
            <c:set var="userName" value="${cookie.userNameCookie.value}"/>
        </c:if>
        <c:if test="${cookie.passwordCookie.value ne '' && cookie.passwordCookie.value ne null}">
            <c:set var="password" value="${cookie.passwordCookie.value}"/>
        </c:if>
        <c:if test="${cookie.rememberMeCookie.value ne '' && cookie.rememberMeCookie.value ne null}">
            <c:set var="rememberMe" value="${cookie.rememberMeCookie.value}"/>
        </c:if>
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
                    <!--<a class="navbar-brand" href="index.html">Zydex Login</a>-->
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <!--                <div class="collapse navbar-collapse" id="top-navbar-1">
                <ul class="nav navbar-nav navbar-right">
                <li>
                <span class="li-text">
                Put some text or
                </span>
                <a href="#"><strong>links</strong></a>
                <span class="li-text">
                here, or some icons:
                </span>
                <span class="li-social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-envelope"></i></a>
                <a href="#"><i class="fa fa-skype"></i></a>
                </span>
                </li>
                </ul>
                </div>-->
            </div>
        </nav>

        <!-- Top content -->
        <!--<div class="top-content">-->

        <!--<div class="inner-bg">-->
        <!--<div class="container">-->
        <!--                    <div class="row">
                                <div class="col-sm-8 col-sm-offset-2 text">
                                    <h1><strong>Zydex</strong> Login Form</h1>
                                    <div class="description">
                                        <p>
                                        This is a free responsive contact form made with Bootstrap.
                                        Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                                        </p>
                                    </div>
                                </div>
                            </div>-->
        <div class="row" style="margin-left: 0px !important;margin-right: 0px !important;">

            <div class="col-sm-8 col-sm-offset-2 form-box">
                <!--                            <div class="form-top">
                                                <div class="form-top-left">
                                                    <h3>Login</h3>
                                                    <p>Fill in the UserName Password:</p>
                                                </div>
                                                <div class="form-top-right">
                                                    <i class="fa fa-envelope"></i>
                                                </div>
                                            </div>-->
                <div class="form-group">


                    <c:if test="${!empty successMessage}">
                        <div class="fadeOutEffect alert alert-info"  style="padding: 0px;" role="alert">${successMessage}</div>
                    </c:if>
                    <c:if test="${!empty faliureMessage}">
                        <div class="fadeOutEffect alert alert-danger" style="padding: 0px;" role="alert">${faliureMessage}</div>
                    </c:if>
                </div>
                <!--<div class="form-bottom contact-form">-->
                <form:form role="form" cssClass="form-signin" action="logIn.html?act=loginSubmit" method="post" commandName="userMaster" name='form1' onsubmit='return saveSubmit11();'>
                    <input type="hidden" name="lockCounter" value="0"/>
                    <div class="form-group" style="padding: 0px; margin-top: 50px;" >

                        <div class="col-sm-1">
                            <label class="sr-only" for="contact-email">Username: ${cookie.userNameCookie.value}</label>
                        </div>
                        <div class="col-sm-4">
                            <form:input path="userName" value="${userName}" cssClass="contact-subject form-control" placeholder="Enter User Name" onchange="formFieldManager();"></form:input>
                            </div>
                            <div >
                                <label class="sr-only" for="contact-subject">Password:</label>
                            </div>
                            <div class="col-sm-4">
                            <form:password path="password" value="${password}" cssClass="contact-subject form-control" placeholder="Password"></form:password>
                            </div>
                            <div class="col-sm-2">
                                <button type="submit" class="btn"><span class="fa fa-sign-in"></span>&nbsp;&nbsp;Sign In</button>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-4">
                            <c:choose>
                                <c:when test="${fn:trim(rememberMe) eq '1'}">
                                    <input type="checkbox" class="checkbox-inline" name="rememberMe" value="1" checked="checked"/> <font style="color: black;">Remember Me.<font>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" class="checkbox-inline" name="rememberMe" value="1"/> <font style="color: black;">Remember Me.<font>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!--<label class="sr-only" for="contact-subject">Password</label>-->
                        <%--<form:password path="password" value="" cssClass="contact-subject form-control" placeholder="Password"></form:password>--%>
                        <%--<form:errors path="password" cssClass="errorDiv"></form:errors>--%>
                        <!--<input type="text" name="Password" placeholder="Password..." class="contact-subject form-control" id="contact-subject">-->
                        <div class="col-sm-5">
                            <div><a href="out.html?act=forgotPassword" style="color:  #19b9e7;"><spring:message code="loginPage.label.msg1"></spring:message></a></div>
                            </div>
                        </div>
                </form:form>
                <!--modal-->
                <div id="pwdModal" class=" modal fade" tabindex="-1" role="dialog" aria-hidden="true" >
                    <form:form  cssClass="form-signin" action="logIn.html?act=resetPassword" method="post"  name='form2' >
                        <div class="modal-dialog">
                            <div class="modal-content" style="background-color: rgba(0,0,0,0.5);">
                                <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <div class="text-center" >
                                                <p style="color: black;font-size: 20px;">Please provide your registered E-mail Address.</p>
                                                <div>
                                                    <fieldset>
                                                        <div class="form-group">
                                                            <input class="form-control input-lg" placeholder="E-mail Address" name="reset_email" type="email" required="true">
                                                        </div>
                                                        <input class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit" id="submit_email">
                                                    </fieldset>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
                <!--</div>-->
            </div>
        </div>
        <!--</div>-->
        <!--</div>-->
        <!--</div>-->

        <!--</div>-->

        <!-- Javascript -->
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <!--<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>-->
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>

        <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
        <![endif]-->
        <script>
            //=====Blank password on username change (start)========//
            var $userName = $("#userName");
            var $password = $("#password");
//            var $functionCallingCounter = 0;
            function setBlankPassword() {
                if ($userName.val() == "") {
//                    alert("vlaue of user name" + $userName.val());
                    $password.val('');
//                    $functionCallingCounter = 1;
                }

            }
            $userName.on("keyup", setBlankPassword);
        </script>
    </body>

</html>
