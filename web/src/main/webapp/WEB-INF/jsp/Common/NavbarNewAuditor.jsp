<%-- 
    Document   : NavbarNewAuditor
    Created on : Oct 13, 2025, 12:45:02 PM
    Author     : Admin
--%>

<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>	
<!DOCTYPE html>	
<html>	
    <head></head>

    <section class="sidebar">
        <ul class="side-nav list-unstyled">

            <li class="side-nav-item mb-2">
                <a href="auditorMaster.htm?act=loginHomePage" class="nav-link">
                    <i class="fa fa-home fa-lg mr-3" ></i>Auditor HomePage
                </a>
            </li>
            <li class="side-nav-item mb-2">
                <a href="userMaster.htm?act=passwordChangeV" class="nav-link">
                    <i class="fa fa-key fa-lg mr-3" ></i>Change Password
                </a>
            </li>
            <li class="side-nav-item mb-2">
                <a href="logOut.htm?act=logout" class="nav-link">
                    <i class="fa fa-power-off mr-3" ></i>Sign out
                </a>
            </li>
        </ul>
    </section>

    <%-- <aside class="main-sidebar">	
         <!-- sidebar: style can be found in sidebar.less -->	
         <section class="sidebar" style="background-color: #fff;height: 100%;">	
             <ul class="sidebar-menu">	
 <!--
                 <li  class="treeview active">
                     <a href="auditorMaster.htm?act=loginHomePage" >	
                         <i class="fa fa-circle-o" style="color: #585858;"></i> <span style="color: #424242;">Auditor HomePage</span>	
                     </a>	
                 </li>	-->

                <style>
                    .fa-passwd-reset > .fa-lock {
                        font-size: 1.6rem; 
                    }

                    .fa-passwd-reset > .undo-icon {
                        font-size: 0.9rem;
                        position: absolute;
                        bottom: 2px;
                        right: 11px;
                        transform: rotate(-40deg);
                        text-shadow:
                            0px -1px 0 white,
                            0px -1px 0 white,
                            0px 0 0 white,
                            0px 0px 0 white;

                    }
                    .link-cus{
                        /*padding: 12px 5px 12px 15px !important;*/
                    }
                </style>
                <li class="treeview">
                    <a class="link-cus" href="userMaster.htm?act=passwordChangeV" >	
                        <span class="fa-passwd-reset fa-stack" style="position: relative; display: inline-block;">
                            <i class="fa fa-lock" style=" color: #585858;"></i>
                            <i class="fa fa-undo undo-icon" style="position: absolute; color: #585858;"></i>
                        </span>
                        <span style="color: #424242;">Change Password</span>	
                    </a>	
                </li>

                <li class="treeview">	
                    <a href="logOut.htm?act=logout" >	
                        <i class="fa fa-power-off" style="color: #424242;"></i> <span style="color: #424242;">Sign out</span>	
                    </a>	
                </li>
            </ul>	
        </section>	
        <!-- /.sidebar -->	
    </aside>	--%>



</html>