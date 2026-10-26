<%-- 
    Document   : PasswordChangeV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Reset password</title>
    </head>
    <style>
        .main-content1 {
            position: relative;
            padding: 1.125rem 1.5rem;
            width: 100%;
            height: calc(100vh - 73px);
            margin-left: auto;
            margin-top: auto;
            overflow-y: auto;
        }
    </style>
    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>


            <section class="main-content1">
                <form:form action="userMaster.htm?act=submitPasswordA" method="post" commandName="userMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top mb-0 d-flex align-items-center justify-content-between">
                        <div class="page-title d-flex align-items-center">
                            <h5 class="fw-600 mb-0">Reset password</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Cancel</a>
                            <button type="submit" class="btn theme-btn" onclick="return Validate()"  title="" value="SUBMIT">Submit</button>
                        </div>
                    </div>
                     <c:if test="${!empty successMessage}">
                    <div id="successMsg" class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div id="failureMsg" class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${failureMessage}</div>
                </c:if>
                    <hr>
                 <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.<br>
                            <strong>Note:</strong> Password must contain at least one number, one uppercase, one lowercase letter, One special character<strong> @!#$%^&*</strong> and at least 8 or more characters
                        </div>
                    </div>
                   
                    <br>
                    <div class="row">
                        <div class="col-lg-3 ">
                            <div class="form-group">
                                <label class="control-label">User Full Name :<span class="text-danger">*</span></label>
                                <form:input path="userFullName" class="form-control" readonly="true"  maxlength="30" required="required"/>
                            </div>
                        </div>

                        <div class="col-lg-3 ">
                            <div class="form-group">
                                <label class="control-label">Login Name :<span class="text-danger">*</span></label>
                                <form:input path="loginName" class="form-control" readonly="true"  maxlength="30" required="required"/>
                            </div>
                        </div>
                        <div class="col-lg-3 ">
                            <label class="control-label">Password :<span class="text-danger">*</span></label>
                            <div class="form-group input-group">
                                <form:input type="password" id="password" name="password" 
                                            pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&*]).{8,}" 
                                            path="password" class="form-control" maxlength="30" required="required"/>
                                <div class="input-group-append">
                                    <span class="input-group-text" onclick="togglePassword('password', this)" id="togglePassword">
                                        <i class="fas fa-eye"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <label class="control-label">Confirm Password :<span class="text-danger">*</span></label>
                            <div class="form-group input-group">
                                <input type="password" id="password1" name="password1" class="form-control" maxlength="30" required="required"/>
                                <div class="input-group-append">
                                    <span class="input-group-text" onclick="togglePassword('password1', this)" id="togglePassword">
                                        <i class="fas fa-eye"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>

            </section>
        </main> 
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
                function Validate() {
                var pass = $('#password').val();
                        var pass1 = $('#password1').val();
                        if (pass != pass1) {
               Swal.fire({
  icon: 'error',
  title: 'Error',
  text: 'Passwords do not match'
});
                        return false;
                }
                return true;
                }
    </script>

    <script>
        function togglePassword(fieldId, button) {
        const input = document.getElementById(fieldId);
                const icon = button.querySelector('i');
                if (input.type === "password") {
        input.type = "text";
                icon.classList.remove("fa-eye");
                icon.classList.add("fa-eye-slash");
        } else {
        input.type = "password";
                icon.classList.remove("fa-eye-slash");
                icon.classList.add("fa-eye");
        }
        }
    </script>

</html>
