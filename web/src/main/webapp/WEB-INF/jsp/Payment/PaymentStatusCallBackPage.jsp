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
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

    </head>
    <body>
        <br/>
        <br/>
        <br/>
        <div class="containers" >

            <br><br><br><br><br>      <br><br><br>         
            <div style="width: 60%; height:150px;;margin:0 auto;">

                <form:form class="form-horizontal" method="post" action="payment.html?act=gotoHome" commandName="paymentStatus" >
                    <div>

                        <div class="form-group">
                          
                            <div class="col-sm-2">
                                <label>Order Id2:</label>
                            </div>
                            <div class="col-sm-4">
                                <form:input path="orderId" class="form-control" readonly="true"></form:input>
                            </div>
                            <div class="col-sm-2">
                                <label>Status:</label>
                            </div>
                            <div class="col-sm-4">
                            <form:input path="status" class="form-control" readonly="true"></form:input>
                                
                            </div>
                        </div>
                    </div>

                </div>
                <button type="submit" class="btn btn-primary" id="saveSubmit1" >BACK HOME</button>
                
            </div>
        </form:form>

        <!--</div>-->
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