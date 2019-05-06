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
                <!-- Logo -->
                <a href="userMaster.htm?act=goToDashboard" class="logo" style="background-color: #ffffff;">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <!--<span class="logo-mini"><b>Z</b>ydex</span>-->
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><img src="StorageYard/Images/logo.png"  style="height: 45px"/></span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top" role="navigation" style="background-color:#006fad;">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <ul class="nav navbar-left">
                        <li class="hidden-xs">
                            <font style="font-size: 30px;color: white;"><b>&nbsp&nbsp&nbsp&nbsp&nbsp Vadera & Co</b></font>
                        </li>
                    </ul>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        
                        <!--<form class="navbar-form navbar-left navbar-search alt" role="search">-->
                        <div class="navbar-form navbar-left navbar-search alt form-group">
                            
                            <input type="text" id="searchBox" class="form-control" placeholder="Employee Search..." value="" style="border-radius: 10px;">
                        </div>
                        <!--</form>-->
                        <ul class="nav navbar-nav">
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="${sessionScope.profilePicturePath}" class="user-image" alt="User Image">
                                    <span class="hidden-xs">${sessionScope.employeeInfo.employeeName}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="${sessionScope.profilePicturePath}" class="img-circle" alt="User Image">
                                        <p>${sessionScope.employeeInfo.employeeName}</p>
                                        <p><a href="employeeMaster.htm?act=changePassWordClick&userid=${sessionScope.userRight.userMaster.id}" class=""  style="color: white">Change Password</a></p>
                                    </li>
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="employeeMaster.htm?act=viewOwnProfile&id=${sessionScope.employeeInfo.id}&userid=${sessionScope.userRight.userMaster.id}" class="btn btn-default btn-flat">Profile</a>
                                            <!--<a href="#" class="btn btn-default btn-flat">Profile</a>-->
                                        </div>
                                        <div class="pull-right">
                                            <a href="logOut.htm?act=logout" class="btn btn-default btn-flat">Sign out</a><br/>
                                            <!--- pageGenTimeSecS--->
                                            <!--- replace last "S" with small for displaying response generated in milliSeconds."s"--->
                                        </div>
                                        <br>

                                    </li>
                                </ul>
                            </li>
                        </ul>
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
