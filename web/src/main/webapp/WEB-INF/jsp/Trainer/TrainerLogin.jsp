<%-- 
    Document   : TrainerLogin
    Created on : Mar 10, 2018, 4:37:29 PM
    Author     : DELL3
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


    </head>
    <body>
        <section class="content-header">
            <h1>Trainer Login</h1>
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
        <form:form role="form" cssClass="form-signin" action="trainerLogin.htm?act=loginSubmit" method="post" commandName="trainerMaster" name='form1' onsubmit='return saveSubmit11();'>
            <input type="hidden" name="lockCounter" value="0"/>
            <section class="content">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="form-group">
                            <div class="col-sm-1">
                            </div>
                            <div class="col-sm-2" style="text-align: left">
                                <label>User Name:<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-2">
                                <input path="userName" name="userName" class="form-control"/>
                                <%--<form:errors path="employeeId" cssClass="errorDiv"></form:errors>--%>
                            </div>


                            <div class="col-sm-2" style="text-align: left" >
                                <label>Password :<span style="color: red;font-size: 12px;">*</span></label>
                            </div>
                            <div class="col-sm-2">
                                <input path="password" name="password" type="password" class="form-control"/>
                                <%--<form:errors path="employeeName" cssClass="errorDiv"></form:errors>--%>
                            </div>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <div class=" col-sm-offset-0">
                                    <button type="submit" class="btn btn-primary" style="text-align: center; width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                    <!--<button type="button" class="btn btn-primary" style="text-align: center; width: 100px;" data-original-title="" title="" onclick="window.location = 'trainerLogin.htm?act=backToHome'">BACK</button>-->
                                    <button type="button" class="btn btn-primary" onclick="location.href='logIn.html?act=loginClick';"  style="text-align: center; width: 100px;" >BACK</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form:form>
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    </body>
</html>

