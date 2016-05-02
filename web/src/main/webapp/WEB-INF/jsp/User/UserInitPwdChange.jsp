<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
        <title>First Time Login</title>
        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">

            <div>
                <h1>&nbsp;&nbsp;&nbsp;Change Initial Password:</h1>
                <hr />

                <!--                <div class="alert alert-info" role="alert">
                                    <div>There are some rules for new password.</div>
                                    <div>&nbsp;-&nbsp;It must contains one digit from 0-9.</div>
                                    <div>&nbsp;-&nbsp;It must contains one lowercase characters.</div>
                                    <div>&nbsp;-&nbsp;It must contains one uppercase characters.</div>
                                    <div>&nbsp;-&nbsp;It must contains one special symbols in the list "@#$%".</div>
                                    <div>&nbsp;-&nbsp;It has to match anything with previous condition checking.</div>
                                    <div>&nbsp;-&nbsp;It has to have length at least 8 characters and maximum of 45.</div>
                                </div>-->

                <c:if test="${!empty faliureMessage}">
                    <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
                </c:if>

                <form:form action="logIn.html?act=newPwdSubmit" method="post" commandName="userModel"
                           name='form1' onsubmit='return saveSubmit11();' cssClass="form-horizontal" role="form">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">UserName</label>
                        <div class="col-sm-10">
                            <form:input path="username" class="form-control" value="${userName}" readonly="true"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword" class="col-sm-2 control-label">Current Password<font style="color: red;font-size: 16px;">*</font></label>
                            <div class="col-sm-10">
                            <form:password path="password" class="form-control" placeholder="Enter Current Password"></form:password>
                            <form:errors path="password" cssClass="errorDiv"></form:errors>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword" class="col-sm-2 control-label">New Password<font style="color: red;font-size: 16px;">*</font></label>
                            <div class="col-sm-10">
                            <form:password path="newPassword" class="form-control" placeholder="Enter New Password"></form:password>
                            <form:errors path="newPassword" cssClass="errorDiv"></form:errors>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword" class="col-sm-2 control-label">Confirm Password<font style="color: red;font-size: 16px;">*</font></label>
                            <div class="col-sm-10">
                            <form:password path="confirmPassword" class="form-control" placeholder="Enter Confirm Password"></form:password>
                            <form:errors path="confirmPassword" cssClass="errorDiv"></form:errors>
                            </div>
                        </div>

                        <hr />
                        <button type="submit" class="btn btn-primary" id="saveSubmit1" >Save</button>
                </form:form>

            </div>
        </div>

        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    </body>
</html>
