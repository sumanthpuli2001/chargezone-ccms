<%-- 
    Document   : PaymentSlip
    Created on : Feb 15, 2020, 4:37:23 PM
    Author     : admin
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
        <title>Payment Status</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

    </head>
    <div class="content-wrapper" >
        <center>
        
        <table width="70%">
            <tr><td>
               
        <section class="content-header">
            <h3>Gujarat Industries Power Company Ltd.</h3>
            <h4>Regd. Office : P.O. Petrochemicals – 391 346, Dist. Vadodara (Gujarat)
                               CIN – L99999GJ1985PLC007868</h4>
            <br>
                      <h5>Reciept</h5>
        </section>
       
        <table width="100%" style="align: left;">
            <tr>
                <td width="25%" align="left">Receipt Ref. No.</td>
                <td></td>
            </tr>
            <tr>
                <td width="25%" align="left">Date (Time):</td>
                <td></td>
            </tr>
            <tr>
                <td width="25%" align="left">Received with thanks</td>
                <td></td>
            </tr>
            <tr>
                <td width="25%" align="left">An Amount of :</td>
                <td></td>
            </tr>
            <tr>
                <td width="25%" align="left">from :</td>
                <td></td>
            </tr>
            <tr>
                <td width="25%" align="left">Towards :</td>
                <td></td>
            </tr>
        </table>
        This receipt is electronically generated and no signature required.

                </td>
            </tr>
        </table>
            </center>
        <body>
            
           
           

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