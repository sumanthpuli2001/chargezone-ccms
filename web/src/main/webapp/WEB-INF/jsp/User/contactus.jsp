<%-- 
    Document   : contactus
    Created on : 26 Oct, 2021, 2:51:17 PM
    Author     : admin
--%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Contact US</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

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
        <style>
            /*.card {
                border: 0;
                margin-bottom: 30px;
                margin-top: 30px;
                border-radius: 6px;
                color: rgba(0, 0, 0, 0.87);
                background: #ffffff;
                width: 100%;
                box-shadow: 0 2px 2px 0 rgb(0 0 0 / 14%), 0 3px 1px -2px rgb(0 0 0 / 20%), 0 1px 5px 0 rgb(0 0 0 / 12%);
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;}*/
            .card-login .card-header {
                margin-left: 20px;
                margin-right: 20px;
                margin-top: -40px;
                padding: 20px 0;
                margin-bottom: 15px;
            }
            .card [class*="header-"], .card[class*="bg-"] {
                color: #ffffff;
            }
            .card .card-header-primary {
                box-shadow: 0 5px 20px 0px rgb(0 0 0 / 20%), 0 13px 24px -23px rgb(34 62 78);
            }
            .card .card-header {
                border-radius: 3px;
                margin-left: 15px;
                margin-right: 15px;
                margin-top: -40px;
                border: 0;
                background: linear-gradient( 48deg, #223e4e, #bdbdbd);
            }
        </style>
    </head>
    <body >
        <%@include file="/WEB-INF/jsp/Common/Header3.jsp"%>
        <div class="bgloginn" style="background: url(StorageYard/Images/home-bg.jpg);background-size: cover;position: relative;background-image: beige;min-height: 73vh;">
            <div class="col-sm-12" style="top: 15%;">
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-sm-7 col-sm-offset-3">
                            <div class="card card-login">
                                <form:form role="form" cssClass="form-signin" action="logIn.html?act=loginSubmit" method="post" commandName="userMaster" name='form1' onsubmit='return saveSubmit11();'>
                                    <div class="card-header card-header-primary text-center">
                                        <h3 class="card-title">Login</h3>

                                    </div>
                                    <input type="hidden" name="lockCounter" value="0"/>
                                    <c:if test="${!empty successMessage}">
                                        <div class="alert alert-info" role="alert">${successMessage}</div>
                                    </c:if>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <form:input path="loginName" value="${userName}" cssClass="contact-subject form-control" placeholder="Enter User Name" onchange="formFieldManager();" autocomplete="off"  ></form:input>
                                            </div>
                                            <hr style="clear:both;border: 0px;">
                                            <div class="col-sm-12">
                                                <label class="sr-only" for="contact-subject">Password:</label>
                                            </div>
                                            <div class="col-sm-12">
                                            <form:password path="password" value="${password}" cssClass="contact-subject form-control" placeholder="Password" autocomplete="off" ></form:password>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="hidden" value="1"/>
                                            </div>
                                            <hr style="clear:both;border: 0px;">
                                            <div class="col align-self-center">
                                                <button type="submit" class="btn" style="background: #CDDC39;"><span class="fa fa-sign-in"></span>&nbsp;&nbsp;Sign In</button>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="hidden" value="1"/>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-sm-12 text-left">
                                            <c:if test="${!empty faliureMessage}">
                                                <div class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${faliureMessage}</div>
                                            </c:if>
                                        </div>
                                        <div>

                                            <div class="col-sm-12"><a href="out.html?act=out" style="color:  #223e4e"><i class="fa fa-key"></i>&nbsp;Forgot Password</a> 
                                                &nbsp;<a href=href="http://www.bulwarks.com/" style="color: #223e4e" target="_blank"><i class="fa fa-info"></i>&nbsp;Help</a></div>
                                            <hr style="clear:both;border: 0px;"/>
                                            <div class="col-sm-12"><a href="out.html?act=forgotuser" style="color:  #223e4e"><i class="fa fa-user"></i>&nbsp;Forgot Username</a></div>
                                            <hr style="clear:both;border: 0px;"/>
                                            <div class="col-sm-12"><a href="out.html?act=forgotuser" style="color:  #223e4e"><i class="fa fa-unlock-alt"></i>&nbsp;Unlock User</a></div>
                                            <hr style="clear:both;border: 0px;"/>
                                            <div class="col-sm-12"><a href="out.html?act=forgotuser" style="color:  #223e4e"><i class="fa fa-home"></i>&nbsp;Back to Home Page</a></div>
                                            <hr style="clear:both;border: 0px;"/>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="row" style="margin-top: 10%;color: white;">
                        <div class="col-sm-6">
                            <div align="left">
                                <b><u>Gujarat Industries Power Company Ltd.</b></u><br>Post:&nbsp;Ranoli - 391 350,<br> Dist.: Vadodara,<br> Gujarat - India<br>
                                <br>
                                <br>
                                <i class="fa fa-envelope"></i>&nbsp; Email: <a title="Send us an email.." href="mailto:purchase@gipcl.com"><b>purchase@gipcl.com</b></a> <br><br>
                                <i class="fa fa-fax" aria-hidden="true"></i>&nbsp;Fax : +91-265-2231207
                                <br><br><i class="fa fa-phone-square" aria-hidden="true"></i>&nbsp;Phone: 0265-2232768/2213/0159 
                                <br><br>For <b>Tender Related Problem </b>Ext. No. 229/259/240/287
                                <br>For  <b>Technical Problem</b> Ext. No 446/272/437

                                <br>
                                <br><br>


                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div align="left">
                                <b><u>Surat Lignite Power Plant.</b></u> <br>AT &amp; P.O. Nani Naroli,<br> Taluka: Mangrol- 394110,<br> Dist.: Surat,<br> Gujarat - India<br>
                                <br>
                                <i class="fa fa-envelope"></i>&nbsp;Email: <a title="Send us an email.." href="mailto:slpp_pur@gipcl.com"><b>slpp_pur@gipcl.com</b></a>
                                <br><br><i class="fa fa-fax" aria-hidden="true"></i>&nbsp;Fax : +91-2629-261073/74
                                <br><br><i class="fa fa-phone-square" aria-hidden="true"></i>&nbsp;Phone: 02629-261063-261070
                                <br><br>For <b>Tender Related Problem </b>Ext. No. 2312/2313/2315/2311
                                <br>For  <b>Technical Problem</b> Ext. No 2514

                                <br>
                                <br><br>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <%@include file="/WEB-INF/jsp/Common/Footer2.jsp"%>
            <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
