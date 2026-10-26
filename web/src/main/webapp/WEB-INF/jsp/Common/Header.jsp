<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--<title>Zydex | Dashboard</title>-->
        <!--        <meta http-equiv='cache-control' content='no-cache'>
                <meta http-equiv='expires' content='0'>
                <meta http-equiv='pragma' content='no-cache'>-->

        <meta http-equiv='cache-control' content='no-cache'>
        <meta http-equiv='expires' content='0'>
        <meta http-equiv='pragma' content='no-cache'>
        <meta http-equiv="Expires" content="-1">

        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>

    </head>


    <body class="hold-transition skin-blue sidebar-mini"><!--    closed in footer's second last line-->
        <div class="wrapper">
            <!--         wrapper will close in footer and comment is given there by me-->
            <header class="main-header">
                <div class="sidebar-header" style="background-color: white;">
                    <a  class="logo">
                        <!-- mini logo for sidebar mini 50x50 pixels -->
                        <!--<span class="logo-mini"><b>Z</b>ydex</span>-->
                        <!-- logo for regular state and mobile devices -->
                        <span class="logo-lg" style="background-color: white;">
                            <img src="StorageYard/Images/logo.png" style="/* height:50px; *//* padding-bottom: 8px; *//* border-color: white !important; *//* border: 4px !important; */background-color: white;">
                        </span>
                    </a>
                </div>
                <!-- Logo -->
                <%--<a href="userMaster.htm?act=goToDashboard" class="logo" style="background-color: #ffffff;">--%>
                <%--                <a  class="logo" style="background-color: #ffffff;">
                                     mini logo for sidebar mini 50x50 pixels 
                                    <span class="logo-mini"><b>Z</b>ydex</span>
                                     logo for regular state and mobile devices 
                                    <span class="logo-lg"><img src="StorageYard/Images/logo.png"  style="height: 45px"/></span>
                                </a>--%>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top" role="navigation" style="background-color:#223e4e;border: #223e4e;">
                    <!-- Sidebar toggle button-->
                    <a href="#"  class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>

                    <ul class="nav navbar-left">
                        <li class="hidden-xs">
                            <font style="font-size: 30px;color: white;"><b></b></font>
                        </li>
                    </ul>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav m-auto" style="color: #fff0;float: right;margin:14px 20px 13px 20px;">
                            <li class="nav-item">
                                <%--   <a class="nav-link" href="StorageYard/Admin_Guide.pdf"><i class="fa fa-info"></i>&nbsp;Help</a> --%>
                            </li>
                            <li class="nav-item dropdown user user-menu">
                                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="true">
                                    <img src="StorageYard/UserProfile/User/default.png" class="user-image" alt="User Image">
                                    <!--                                    <span class="hidden-xs" style="color: #ebebeb;">System Admin</span>-->${sessionScope.user.userFullName}
                                </a>
                                <ul class="dropdown-menu dropdown-menu-right" style="margin-top: 13px;">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="StorageYard/UserProfile/User/default.png" class="img-circle" alt="User Image">
                                        <p>${sessionScope.user.userFullName}</p>
                                        <p>
                                        
                                             <c:choose>
                                                <c:when test="${sessionScope.user.userType == 0 }">
                                                    <a href="userMaster.htm?act=passwordChange" class="" style="color: white">Change Password</a>
                                                </c:when>
                                                <c:otherwise>
                                                    
                                                </c:otherwise>
                                            </c:choose>
                                            
                                        
                                        </p>
                                    </li>
                                    <li class="user-footer">
                                        <div>

                                            <c:choose>
                                                <c:when test="${sessionScope.user.userType == 0 }">
                                                    <a href="userMaster.htm?act=userMasterProfile" class="btn-infoog btn btn-sm  text-left" id="selfProfileId" style="display:none;">

                                                        <i class="fa fa-user" aria-hidden="true"></i>

                                                        &nbsp;
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="userMaster.htm?act=userMasterProfile" class="btn-infoog btn btn-sm  text-left" id="selfProfileId">

                                                        <i class="fa fa-user" aria-hidden="true"></i>

                                                        &nbsp;
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>


                                            <a href="logOut.htm?act=logout" class="btn-infoor btn btn-sm pull-right">
                                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                                                &nbsp; Signout</a><br>
                                            <!--- pageGenTimeSecS--->
                                            <!--- replace last "S" with small for displaying response generated in milliSeconds."s"--->
                                        </div>


                                    </li>
                                </ul>
                            </li>


                        </ul>

                    </div>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">

                        <%--<form class="navbar-form navbar-left navbar-search alt" role="search">--%>
                        <%--                        <div class="navbar-form navbar-left navbar-search alt form-group">
                                                    
                                                    <input type="text" id="searchBox" class="form-control" placeholder="Employee Search..." value="" style="border-radius: 10px;">
                                                </div>--%>
                        <%--</form>--%>
                        <%--                        <ul class="nav navbar-nav">
                                                     User Account: style can be found in dropdown.less 
                                                    <li class="dropdown user user-menu">
                                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                            <img src="${sessionScope.profilePicturePath}" class="user-image" alt="User Image">
                                                            <span class="hidden-xs">${sessionScope.employeeInfo.employeeName}</span>
                                                        </a>
                                                        <ul class="dropdown-menu">
                                                             User image 
                                                            <li class="user-header">
                                                                <img src="${sessionScope.profilePicturePath}" class="img-circle" alt="User Image">
                                                                <p>${sessionScope.employeeInfo.employeeName}</p>
                                                                <p><a href="employeeMaster.htm?act=changePassWordClick&userid=${sessionScope.userRight.userMaster.id}" class=""  style="color: white">Change Password</a></p>
                                                            </li>
                                                            <li class="user-footer">
                                                                <div class="pull-left">
                                                                    <a href="employeeMaster.htm?act=viewOwnProfile&id=${sessionScope.employeeInfo.id}&userid=${sessionScope.userRight.userMaster.id}" class="btn btn-default btn-flat">Profile</a>
                                                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                                                </div>
                                                                <div class="pull-right">
                                                                    <a href="logOut.htm?act=logout" class="btn btn-default btn-flat">Sign out</a><br/>
                                                                    - pageGenTimeSecS-
                                                                    - replace last "S" with small for displaying response generated in milliSeconds."s"-
                                                                </div>
                                                                <br>
                        
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>--%>
                    </div>
                </nav>
            </header>
            <script>
                $("#searchBox").keypress(function (e) {
                    if (e.keyCode == 13) {
                        var searchString = $('#searchBox').val();
                        window.location = "employeeMaster.htm?act=getEmployeeDetailsBySearchString&searchString=" + searchString;
                    }
                });
            </script>
            <script>
                $(document).ready(function () {
                    try {

                        $('#table_1').DataTable({
                            "ordering": false
                        });
                    } catch (ex) {

                    }
                });
            </script>

    </body>