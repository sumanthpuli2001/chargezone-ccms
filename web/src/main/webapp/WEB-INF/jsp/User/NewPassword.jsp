<%-- 
    Document   : NewPassword
    Created on : Feb 22, 2016, 11:10:43 AM
    Author     : BlackBull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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
    <script type="text/javascript">
        $(function () {
            $("#saveSubmit1").click(function () {
                var password = $("#new_password").val();
                var confirmPassword = $("#new1_password").val();
                if (password != confirmPassword) {
                    alert("Passwords do not match.");
                    return false;
                }
                return true;
            });
        });
    </script>


    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <c:if test="${!empty successmessage}" >
                <script>
                    alert("${successmessage}");
                </script>
                <!--<div class="fadeOutEffect alert alert-success" role="alert"></div>-->
            </c:if>
            <c:if test="${!empty failuremessage}">
                <script>
                    alert("${failuremessage}");
                </script>
                <!--<div class="fadeOutEffect alert alert-danger" role="alert"></div>-->
            </c:if>

            <section class="content-header">
                <h1>Change User Password</h1>

            </section>
            <div class="content">
                <!-- Main content -->
                <form:form action="employeeMaster.htm?act=changePassWordSubmit" method="post" commandName="userMaster"
                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                    <form:hidden path="id"></form:hidden>
                        <!--<form class="form-horizontal" role="form" commandName>-->

                        <!--Read only entries Starts here-->
                        <!--<div class="box box-info collapsed-box ">-->
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <div class="box-body no-padding">
                                            <!--<div class="row">-->
                                            <div class="col-sm-6 ">                                                
                                                <div class="form-group">
                                                    <!--<div class="col-sm-4">-->
                                                    <label>Current Password<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div>
                                                    <form:input type="password" path="password" class="col-sm-6 form-control" required="true"  placeholder="Enter Current Password" />
                                                </div>
                                                <label>New Password (Alpha Numeric)<span style="color: red;font-size: 12px;">*</span></label>
                                                <div>
                                                    <input type="password" id="new_password" name="new_password" class="col-sm-6 form-control" required="true"  placeholder="Enter New Password"/>
                                                </div>
                                                <label>Confirm Password<span style="color: red;font-size: 12px;">*</span></label>
                                                <div>
                                                    <input type="password" id="new1_password" name="new1_password" class="col-sm-6 form-control" required="true"  placeholder="Confirm New Password" />
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <br/>
                                    <button  type="submit" class="btn btn-primary center-block" style="width: 100px;" id="saveSubmit1" onsubmit="return compare()" >SUBMIT</button>
                                    <br/>
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </form:form>
            </div>
        </div>
        <!--        <script>
                    function compare() {
                        var ok = true;
                        if ($("#new_password").val() !== $("#new1_password").val()) {
                            alert("Password not same..");
                            document.getElementById("new_password").style.borderColor = "#E34234";
                            document.getElementById("new1_password").style.borderColor = "#E34234";
                            ok = false;
                        }
                        else(){
                            alert("Password Match");
                            ok = true;
                        }
                        return ok;
                    }
                </script>-->
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>

</html>