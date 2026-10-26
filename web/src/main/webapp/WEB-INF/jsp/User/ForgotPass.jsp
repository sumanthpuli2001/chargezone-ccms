<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>VMS Login</title>

        <!-- Favicon -->
        <link rel="apple-touch-icon" sizes="57x57" href="StorageYard/assets/favicon/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="StorageYard/assets/favicon/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="StorageYard/assets/favicon/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="StorageYard/assets/favicon/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="StorageYard/assets/favicon/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="StorageYard/assets/favicon/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="StorageYard/assets/favicon/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="StorageYard/assets/favicon/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="StorageYard/assets/favicon/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192" href="StorageYard/assets/favicon/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="StorageYard/assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="StorageYard/assets/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="StorageYard/assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="StorageYard/assets/favicon/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="StorageYard/assets/favicon/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">

        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="StorageYard/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="StorageYard/assets/css/all.min.css">
        <link rel="stylesheet" href="StorageYard/assets/css/sweetalert2.min.css">

        <!-- Theme CSS -->
        <link rel="stylesheet" href="StorageYard/assets/css/auth.css">
    </head>

    <body>
        <!-- Page Content -->
        <div class="login-wrapper d-flex justify-content-center align-items-center overflow-hidden">
            <div class="container">
                <div class="auth-inner position-relative mx-auto">
                    <form class="position-relative row mx-0"  action="out.html?act=checkPassword" method="POST">
                        
                       
                        <div class="col-lg-5 p-4 card-white">
                            <img  src="StorageYard/Images/logo.png" alt="Company Logo">
                        </div>
                        
                        <div class="col-lg-7 p-md-4 p-3">
                            <div class="form-content">
                                <h3 class="mb-4 fw-bolder text-lg-start text-center mt-auto">Forgot Password</h3>
                                
                        
                                <c:if test="${not empty successMessage}">
                                    <div class="alert alert-success">
                                        ${successMessage}
                                    </div>
                                </c:if>

                                <c:if test="${not empty failureMessage}">
                                    <div class="alert alert-danger">
                                        ${failureMessage}
                                    </div>
                                </c:if>

                           

                                <div class="form-group mb-3">
                                    <label for="username">User Name<span class="text-danger">*</span></label>
                                    <input type="text" name="loginName" id="username" class="form-control"
                                           value="" autocomplete="off"  placeholder="Enter username" required>
                                </div>

                                <div class="row align-items-center">
<!--                                    <div class="col-md-5">
                                        <div class="form-group mb-3">
                                            <label for="mobile_number">Mobile Number</label>
                                            <input type="tel" name="mobileNo" id="mobile_number" class="form-control"
                                                   value="" autocomplete="off"  placeholder="Enter mobile number">
                                        </div>
                                    </div>-->
<!--                                    <div class="col-md-1">
                                        <p class="mb-0 fw-500 tiny-text light-color">Or</p>
                                    </div>-->
                                    <div class="col-md-12">
                                        <div class="form-group mb-3">
                                            <label for="email">Email<span class="text-danger">*</span></label>
                                            <input type="email" name="emailId" id="email" required="true" class="form-control"
                                                   placeholder="Enter email" autocomplete="off">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group mb-3 pt-2">
                                    <button type="submit"
                                            class="btn theme-btn d-flex align-items-center justify-content-center w-100">
                                        <img src="StorageYard/assets/images/arrow-right-to-arc.svg" class="form-btn-icon mr-2"
                                             onload="SVGInject(this)" alt="Icon"> Submit
                                    </button>
                                </div>

                                <div class="text-end d-flex align-items-center justify-content-between py-1 mt-auto">
                                    <a href="logIn.html?act=firstStep" class="form-link"><i class="fa-solid fa-angle-left"></i> Back to
                                        Login</a>
                                </div>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <!-- Page Content -->

        <!-- JS Libraries -->
        <script src="StorageYard/assets/js/jquery-3.7.1.min.js"></script>
        <script src="StorageYard/assets/js/bootstrap.bundle.min.js"></script>
        <script src="StorageYard/assets/js/sweetalert2.all.min.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
        <!--<script src="StorageYard/assets/js/auth.js"></script>-->
    </body>

</html>