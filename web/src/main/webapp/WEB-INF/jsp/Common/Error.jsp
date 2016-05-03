<%@page contentType="text/html" pageEncoding="UTF-8" session="false" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="shortcut icon" href="StorageYard/Images/Icon/favicon.ico" type="image/x-icon">
        <link rel="icon" href="StorageYard/Images/Icon/favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
        <title>Error Page</title>
    </head>

    <!--    <body class="navbar-fixed">
            <div style="background-color: #ffffff">
                <div style="width: 100%;">
                    <div class="title24 titleBold" style="margin: 20px;">Sorry, That's an Error.</div>
                    <div style="margin: 20px;">
                        <div style="margin: 20px">Description about Error : </div>
    
                        <div style="margin: 30px;overflow: hidden">
                            <div style="float: left;width: 40%">The requested resource could not be found.</div>
                            <div style="float: right;margin: 30px"><img src="StorageYard/Images/Error.jpg"></div>
                        </div>
                    </div>
                </div>
                <div class="title16" style="clear: both;margin: 20px;">If you want to go back then click <a href="" onclick="window.history.back();">here</a>.</div>
            </div>
        </body>-->
    <body class="navbar-fixed">
        <div style="background-color: #ffffff; display: none;" id="errorId">
            <div style="width: 100%;">
                <div class="title24 titleBold" style="margin: 20px;">Sorry, That's an Error.</div>
                <div style="margin: 20px;">
                    <div style="margin: 20px">Description about Error : </div>


                    <div style="margin: 30px;overflow: hidden">
                        <!--<div style="float: left;width: 40%">The requested resource could not be found.</div>-->
                        <table style="margin: 20px;" width="60%" border="1">
                            <tr valign="top">
                                <td ><b>Error:</b></td>
                                <td>${pageContext.exception}</td>
                            </tr>
                            <tr valign="top">
                                <td><b>URI:</b></td>
                                <td>${pageContext.errorData.requestURI}</td>
                            </tr>
                            <tr valign="top">
                                <td><b>Status code:</b></td>
                                <td>${pageContext.errorData.statusCode}</td>
                            </tr>
                            <tr valign="top">
                                <td><b>Stack trace:</b></td>
                                <td>
                                    ${pageContext.exception.stackTrace[0]}
                                </td>
                            </tr>
                        </table>
                        <div style="float: right;margin: 30px"><img src="StorageYard/Images/Error.jpg"></div>
                    </div>
                </div>
            </div>
            <!--<div class="title16" style="clear: both;margin: 20px;">If you want to go back then click <a href="" onclick="window.history.back();">here</a>.</div>-->
        </div>
        <div style="background-color: #ffffff">
            <div class="wrapper">
                <table id="table_1" style="width: 100%">
                    <tbody>
                        <tr style="background-color: #3c8dbc"> 
                            <td colspan="3">
                                <a href="#" class="logo">
                                    <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px; margin: 20px;" /></span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="titleBold" style="font-size: 50px; margin: 20px;">Something is Wrong</div>
                            </td> 
                        </tr>
                        <tr>
                            <td style="width: 40%; padding-left:20px;font-size: 30px;">
                                Description about it :<br /><br />
                                - Your page is not Found Please Contact to IT Department.
                            </td> 
                            <td>
                                <div style="margin: 20px"><img src="StorageYard/Images/disco.jpg" onclick="document.getElementById('errorId').style.display='block';"></div>
                            </td>
                        </tr>
                    </tbody>
                </table>
<!--                <div class="title16" style="clear: both;margin: 20px;">If you want to go to login page.
                    <button type="button" class="btn btn-primary" onclick="location.href = 'logIn.html?act=loginClick';"  style="background-color: #0070c0;border-radius: 6px;width: auto;text-align: center; font-weight: bold; " >Click Here</button>

                    <a href="logIn.html?act=loginClick">Click here</a>.
                </div>-->
            </div>
        </div>                    
    </body>
</html>
