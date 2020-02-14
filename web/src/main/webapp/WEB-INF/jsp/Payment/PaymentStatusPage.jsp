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
        <title>Payment Status</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">



        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">

     
    </head>
    <body>
        <br/>
        <br/>
        <br/>
        <div class="containers" >

            <br><br><br><br><br>      <br><br><br>         
            <div style="width: 60%; height:150px;;margin:0 auto;">

                <form:form >
                    <div>

                        <div class="form-group">
                            <div class="col-sm-4">
                                <div for="inputPassword" class="control-label" style="color: black;font-weight: bold;margin-top:50px;">Order Id:</div>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" path="emailL1" class="form-control" style="margin-top:50px;" readonly="true">
                            </div>
                            <div class="col-sm-4">
                                <div for="inputPassword" class="control-label" style="color: black;font-weight: bold;margin-top:50px;">Status:</div>
                            </div>
                            <div class="col-sm-6">
                                <textarea type="text" path="emailL1" class="form-control" style="margin-top:50px;" readonly="true"></textarea>
                            </div>


                        </div>
                    </div>
                    
                </div>
                     <button type="submit" class="btn btn-primary" id="saveSubmit1" >OK</button>

                <!--<hr />-->
               
                <!--<button type="button" class="btn btn-primary" id="saveSubmit1" onclick="window.location = 'logIn.html?act=loginClick';">Go To Login</button>-->

            </div>

            <%--<spring:bind path="level">--%>
            <%--<c:set value='${status.value}' var='levelValue' />--%>
            <%--<c:choose>--%>
            <%--<c:when test="${levelValue eq 1}"><script>click11();</script></c:when>--%>

            <%--</c:choose>--%>
            <%--</spring:bind>--%>

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



</body>

</html>