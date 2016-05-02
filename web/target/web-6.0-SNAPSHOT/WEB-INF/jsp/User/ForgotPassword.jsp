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
        <br/>
        <br/>
        <br/>
        <div class="containers" >

            <br><br><br><br><br>      <br><br><br>         
            <div style="width: 60%; height:300px;;margin:0 auto;">
            <!--<div style="width: 60%; height:300px;margin:20px; margin-left: 250px;">-->


                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info" style="padding: 0px" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty faliureMessage}">
                    <div class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${faliureMessage}</div>
                </c:if>
                <!--<div class="form-bottom contact-form">-->

                <form:form action="out.html?act=forgotPasswordSubmit" method="post" commandName="forgotPwdModel"
                           name='form1' onsubmit='return saveSubmit11();' cssClass="form-horizontal" role="form">

                    <div>


                        <!--                        <div class="radio">
                                                    <label>
                                                        <input type="radio" name="level" id='l1' value="1" onclick="click11();">
                                                        &nbsp;&nbsp;I don't know my username and/or password.
                                                        &nbsp;&nbsp;I don't know my password.
                                                    </label>
                                                </div>-->
                        <!--<div id="11" style="display: none">-->
                        <!--<div id="11" >-->

                        <div class="form-group">
                            <div class="col-sm-4">
                                <div for="inputPassword" class="control-label" style="color: black;font-weight: bold;margin-top:50px;">Employee Code:</div>
                            </div>
                            <div class="col-sm-6">
                                <form:input path="emailL1" class="form-control" style="margin-top:50px;" placeholder="Enter Employee Code"></form:input>
                                <%--<form:errors path="emailL1" cssClass="errorDiv"></form:errors>--%>
                            </div>
                        </div>
                        <!--</div>-->

                        <!--                            <div class="radio">
                                                        <label>
                                                            <input type="radio" name="level" id='l2' value="2" onclick="click22();">
                                                            &nbsp;&nbsp; my account locked.
                                                        </label>
                                                    </div>-->
                        <!--                            <div id="22" style="display: none">
                                                        <br />
                                                        <div class="form-group">
                                                            <label for="inputPassword" class="col-sm-2 control-label">Enter Email-ID<font style="color: red;font-size: 16px;">*</font></label>
                                                            <div class="col-sm-10">
                        <%--<form:input path="emailL2" class="form-control" placeholder="Enter Employee Code"></form:input>--%>
                        <%--<form:errors path="emailL2" cssClass="errorDiv"></form:errors>--%>
                        </div>
                    </div>
                </div>-->

                        <!--                            <div class="radio">
                                                        <label>
                                                            <input type="radio" name="level" id='l3' value="3" onclick="click33();">
                                                            &nbsp;&nbsp; other problems signing in.
                                                        </label>
                                                    </div>-->
                        <!--                            <div id="33" style="display: none">
                                                        <br />
                                                        <div class="form-group">
                                                            <label for="inputPassword" class="col-sm-2 control-label">Enter Email-ID<font style="color: red;font-size: 16px;">*</font></label>
                                                            <div class="col-sm-10">
                        <%--<form:input path="emailL3" class="form-control" placeholder="Enter Employee Code"></form:input>--%>
                        <%--<form:errors path="emailL3" cssClass="errorDiv"></form:errors>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label">Enter Text</label>
                        <div class="col-sm-10">
                        <form:textarea path="textL3" class="form-control" placeholder="Enter Text Here."></form:textarea>
                        <%--<form:errors path="textL3" cssClass="errorDiv"></form:errors>--%>
                        </div>
                    </div>
                </div>-->

                        <!--<hr />-->
                        <button type="submit" class="btn btn-primary" id="saveSubmit1" >Continue</button>
                        <button type="button" class="btn btn-primary" id="saveSubmit1" onclick="window.location = 'logIn.html?act=loginClick';">Go To Login</button>

                    </div>

                    <spring:bind path="level">
                        <c:set value='${status.value}' var='levelValue' />
                        <c:choose>
                            <c:when test="${levelValue eq 1}"><script>click11();</script></c:when>
                            <%--<c:when test="${levelValue eq 2}"><script>click22();</script></c:when>--%>
                            <%--<c:when test="${levelValue eq 3}"><script>click33();</script></c:when>--%>
                        </c:choose>
                    </spring:bind>

                </form:form>

                <!--</div>-->
            </div>
        </div>
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