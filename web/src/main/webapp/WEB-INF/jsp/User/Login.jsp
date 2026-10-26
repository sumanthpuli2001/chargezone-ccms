<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<meta http-equiv="X-Frame-Options" content="deny" />
<meta http-equiv="Content-Security-Policy" content="frame-ancestors 'none'">
<!DOCTYPE html>
<html lang="en">
    <headers>
        <frame-options policy="Deny" />
        <hsts disable="true"/>
    </headers>
    <head>
        <meta http-equiv="X-Frame-Options" content="deny" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-Procurement Login</title>

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

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="StorageYard/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="StorageYard/assets/css/all.min.css">
        <link rel="stylesheet" href="StorageYard/assets/css/sweetalert2.min.css">
        <link rel="stylesheet" href="StorageYard/assets/css/auth.css">

        <script src="StorageYard/assets/js/svg-inject.min.js"></script>

        <style>        
            .home-bg {
                background: url("StorageYard/Images/background.jpg") no-repeat center center;
                width: 100%;
                height: 90vh;
                background-size: 100% 100%;
            }
        </style>

        <style>
        @font-face {
            font-family: 'password-mask';
            font-style: normal;
            font-weight: 400;
            src: url(https://jsbin-user-assets.s3.amazonaws.com/rafaelcastrocouto/password.ttf);
        }
        input.key {
            font-family: 'password-mask';
        }
        .form-control[readonly] {
            background-color: #ffffff !important;
        }
        </style>

        <style>
            .captcha-box {
                display: flex;
                align-items: center;
                gap: 10px;
                margin-bottom: 10px;
            }
            #captcha-canvas {
                border: 1px solid #ccc;
                border-radius: 4px;
                pointer-events: none;
                user-select: none;
            }
            .captcha-refresh {
                cursor: pointer;
                font-size: 20px;
            }
            .grecaptcha-badge {
                z-index: 9999;
            }
        </style>

    </head>

    <body>
<div class="login-wrapper d-flex justify-content-center align-items-center overflow-hidden home-bg ps-5" style="padding-right:14rem;">
            <div class="col-sm-4">
                <div class="auth-inner position-relative mx-auto">
                    <form:form role="form" class="position-relative row mx-0" id="loginForm1" action="logIn.html?act=loginSubmit" method="post" commandName="userMaster" name='form1' autocomplete="off" onsubmit='return validateCaptcha();'>
                        <input type="hidden" name="lockCounter" value="0"/>
                        <input type="hidden" id="g-recaptcha-response" name="g-recaptcha-response" value=""/>

                    <hr>
                    <div class="col-12 p-md-3 p-3">
                        <div class="form-content">

                            <h3 class="mb-2 fw-bolder text-center text-sm-start">
                                Login Your Account
                            </h3>

                            <c:if test="${!empty successMessage}">
                                <div class="alert alert-info">${successMessage}</div>
                            </c:if>

                            <c:if test="${!empty faliureMessage}">
                                <div class="alert alert-danger">${faliureMessage}</div>
                            </c:if>

                            <hr>

                            <div class="form-group mb-3">
                                <label>User Name<span class="text-danger">*</span></label>
                                <form:input path="loginName"
                                            id="loginNameInput"
                                            cssClass="form-control"
                                            placeholder="Enter User Name"
                                            autocomplete="off"
                                            readonly="true"
                                            onfocus="this.removeAttribute('readonly');"
                                            style="background-color: #ffffff;"
                                            required="true"/>
                            </div>

                            <div class="form-group mb-3">
                                <label>Password<span class="text-danger">*</span></label>
                                <form:input path="password"
                                            id="passwordInput"
                                            cssClass="form-control key"
                                            placeholder="Password"
                                            type="text"
                                            autocomplete="off"
                                            readonly="true"
                                            onfocus="this.removeAttribute('readonly');"
                                            style="background-color: #ffffff;"
                                            required="true"/>
                            </div>

                            <span id="captcha-error" style="color: red; display: none;">Enter correct CAPTCHA</span>
                            <div class="form-group mb-3">
                                <div class="captcha-box">
                                    <canvas id="captcha-canvas" width="200" height="50"></canvas>
                                    <span class="captcha-refresh" onclick="generateCaptcha()">&#x21bb;</span>
                                </div>
                                <input type="text"
                                       id="captcha-input"
                                       name="captcha-input-field"
                                       class="form-control"
                                       placeholder="Enter CAPTCHA"
                                       autocomplete="new-password"
                                       autocorrect="off"
                                       autocapitalize="off"
                                       spellcheck="false"
                                       role="presentation"
                                       data-gramm="false"
                                       data-gramm_editor="false"
                                       data-enable-grammarly="false"
                                       required />
                            </div>

                            <div class="form-group mb-3">
                                <button type="submit"
                                        class="btn theme-btn w-100">
                                    Login Now
                                </button>
                            </div>

                            <div class="d-flex flex-column flex-sm-row justify-content-between align-items-center gap-2 mt-3">
                                <a href="out.html?act=out" class="form-link">
                                    Forgot Password?
                                </a>
                            </div>

                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>

        <script>
            let generatedCaptchaText = "";

            function generateCaptcha() {
                const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$%^&#@!*+-";
                generatedCaptchaText = "";
                for (let i = 0; i < 6; i++) {
                    generatedCaptchaText += characters.charAt(Math.floor(Math.random() * characters.length));
                }

                const canvas = document.getElementById("captcha-canvas");
                const ctx = canvas.getContext("2d");
                ctx.clearRect(0, 0, canvas.width, canvas.height);
                ctx.font = "30px Arial";
                ctx.fillStyle = "darkblue";
                ctx.fillText(generatedCaptchaText, 20, 40);
            }

            function validateCaptcha() {
                const form = document.form1;
                const usernameField = document.getElementById("loginNameInput");
                const passwordField = document.getElementById("passwordInput");

                usernameField.removeAttribute('readonly');
                passwordField.removeAttribute('readonly');

                if (!form.checkValidity()) {
                    form.reportValidity();
                    return false;
                }

                const enteredCaptcha = document.getElementById("captcha-input").value;
                const captchaErrorElement = document.getElementById("captcha-error");

                if (enteredCaptcha !== generatedCaptchaText) {
                    captchaErrorElement.style.display = "block";
                    generateCaptcha();
                    document.getElementById("captcha-input").value = "";
                    return false;
                }
                captchaErrorElement.style.display = "none";
                if (typeof grecaptcha !== 'undefined' && grecaptcha.ready) {
                    try {
                        grecaptcha.ready(function () {
                            grecaptcha.execute('6LcA1WwtAAAAAFdKRYjaBCsCTIR28P8DZzsDqDYk', {action: 'login'}).then(function (token) {
                                document.getElementById('g-recaptcha-response').value = token;
                                form.submit();
                            }).catch(function() {
                                form.submit();
                            });
                        });
                        return false;
                    } catch(e) {
                        return true;
                    }
                }
                return true;
            }

            document.addEventListener("DOMContentLoaded", function () {
                document.getElementById("captcha-input").value = "";
                generateCaptcha();
            });
        </script>

        <script src="StorageYard/assets/js/jquery-3.7.1.min.js"></script>
        <script src="StorageYard/assets/js/bootstrap.bundle.min.js"></script>
        <script src="StorageYard/assets/js/sweetalert2.all.min.js"></script>
        <script src="StorageYard/assets/js/auth.js"></script>

</body>
<script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
</html>