	<%-- 	
    Document   : NavbarCmss	
    Created on : 25-May-2020, 14:40:47	
    Author     : Aman Bahukhandi 	
--%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>	
<!DOCTYPE html>	
<html>	
    <head>	
    </head>	
    <!-- Left side column. contains the logo and sidebar -->	
    <aside class="main-sidebar">	
        <!-- sidebar: style can be found in sidebar.less -->	
        <section class="sidebar" style="background-color: #fff;height: 100%;">	
            <ul class="sidebar-menu">	
             
              
                
                  
                	
                	
                  <li  class="treeview active">
                    <a href="auditorMaster.htm?act=loginHomePage" >	
                        <i class="fa fa-circle-o" style="color: #585858;"></i> <span style="color: #424242;">Auditor HomePage</span>	
                    </a>	
                </li>	
                	
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
    </aside>	
</html>