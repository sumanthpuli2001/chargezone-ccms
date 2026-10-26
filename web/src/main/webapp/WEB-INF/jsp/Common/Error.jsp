<%@page contentType="text/html" pageEncoding="UTF-8" session="false" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Error Page</title>
        <link rel="shortcut icon" href="StorageYard/Images/Icon/favicon.ico" type="image/x-icon">
        <link rel="icon" href="StorageYard/Images/Icon/favicon.ico" type="image/x-icon">
        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
        <style>
            body {
                padding-top: 50px;
                background-color: #f5f5f5;
            }
            .logo-img {
                width: 160px;
                margin: 20px auto;
                display: block;
            }
            .stack-trace {
                max-height: 150px;
                overflow-y: auto;
                background: #f9f9f9;
                padding: 10px;
            }
            .error-img {
                max-width: 100%;
                height: auto;
            }
            .contact-info-box {
                margin-top: 20px;
                font-size: 15px;
                background: #f2dede;
                padding: 10px;
                border-radius: 4px;
                border: 1px solid #ebccd1;
                color: #a94442;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="text-center">
                <img src="StorageYard/Images/logo.png" alt="Logo" class="logo-img">
                <h1 class="text-danger">Oops! Something Went Wrong</h1>
                <p class="lead">We're sorry, but an unexpected error has occurred.</p>
            </div>

            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">Error Information</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-8">
                            <table class="table table-bordered">
                                <tr>
                                    <th>Error:</th>
                                    <td>${pageContext.exception}</td>
                                </tr>
                                <tr>
                                    <th>URI:</th>
                                    <td>${pageContext.errorData.requestURI}</td>
                                </tr>
                                <tr>
                                    <th>Status Code:</th>
                                    <td>${pageContext.errorData.statusCode}</td>
                                </tr>
                                <tr>
                                    <th>Stack Trace:</th>
                                    <td class="stack-trace">
                                        <c:forEach items="${pageContext.exception.stackTrace}" var="trace">
                                            ${trace}<br/>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </table>
                            <div class="text-right">
                                <button class="btn btn-primary" onclick="window.history.back();">Go Back</button>
                            </div>
                            <div class="contact-info-box">
                                <strong>If the issue persists, please contact the IT Department at:</strong><br><br>
                                📧 <strong>Email:</strong> <a href="mailto:it.support@example.com" style="color: #a94442;">samir@bulwarks.com</a><br>
                                📞 <strong>Phone:</strong> <a href="tel:+91 9099039811" style="color: #a94442;">+91 9099039811</a>
                            </div>

                        </div>

                        <div class="col-md-4 text-center">
                            <img src="StorageYard/Images/disco.jpg" alt="Error Visual" class="error-img img-thumbnail">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    </body>
</html>
