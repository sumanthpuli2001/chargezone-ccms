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
        <section class="sidebar" style="background-color: #fff;">
            <ul class="sidebar-menu">
                <li class="active treeview">
                    <a href="homeController.htm?act=openHomePage">
                        <i class="fa fa-home fa-lg" style="color: #424242;"></i> <span style="color: #424242;">Homepage</span>
                    </a>
                </li>
              
                <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-pie-chart fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Master</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <c:if test="${fn:contains(sessionScope.wright[0],'R')}">
                            <li><a href="userMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Manage User</a></li>
                            </c:if>
                            <c:if test="${fn:contains(sessionScope.wright[1],'R')}">
                            <li><a href="employeeMaster.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Employee</a></li>
                            </c:if>
                            <c:if test="${fn:contains(sessionScope.wright[2],'R')}">
                            <li><a href="contractor.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Contractor</a></li>
                            </c:if>
                            <%--<c:if test="${fn:contains(sessionScope.wright[3],'R')}">--%>
                        <!--<li><a href="apprentices.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Apprentice</a></li>-->
                        <%--</c:if>--%>
                        <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                            <li><a href="device.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Device</a></li>
                            </c:if>
                    </ul>
                </li>
                </c:if>
                <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="glyphicon glyphicon-gift" style="color: #585858;"></i>
                        <span style="color: #585858;">Coupon Management</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <c:if test="${fn:contains(sessionScope.wright[4],'R')}">
                            <li><a href="coupon.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Coupon</a></li>
                            </c:if>
                            <c:if test="${fn:contains(sessionScope.wright[9],'R')}">
                            <li><a href="recharge.htm?act=CretaeRecharge"><i class="fa fa-circle-o"></i>Manage Recharge</a></li>
                            </c:if>
                            <c:if test="${fn:contains(sessionScope.wright[4],'R')}">
                            <li><a href="specialCoupon.htm?act=showList"><i class="fa fa-circle-o"></i>Manage Special Coupon</a></li>
                            </c:if>
                        <li><a href="specialCoupon.htm?act=addCouponPunch"><i class="fa fa-circle-o"></i>Add Coupon punch</a></li>
                        <li><a href="specialCoupon.htm?act=searchPunch"><i class="fa fa-circle-o"></i>Edit punch</a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="fa fa-rupee fa-lg" style="color: #585858;"></i>
                        <span style="color: #585858;">Recharge Card</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <%--<c:if test="${fn:contains(sessionScope.wright[4],'R')}">--%>
                        <li><a href="recharge.htm?act=searchRecharge"><i class="fa fa-circle-o"></i>Recharge card</a></li>
                        <li><a href="recharge.htm?act=rechargeView"><i class="fa fa-circle-o"></i>Recharge View</a></li>
                            <%--</c:if>--%>
                    </ul>
                </li>
                </c:if>
                <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="glyphicon glyphicon-filter" style="color: #585858;"></i>
                            <span style="color: #585858;">Right Management</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="right.htm?act=showList"><i class="fa fa-circle-o"></i>Add Right</a></li>
                        </ul>
                    </li>
                </c:if>
                   
                <li class="treeview" style="color: #585858;">
                    <a href="#" style="background: #fff;">
                        <i class="glyphicon glyphicon-filter" style="color: #585858;"></i>
                        <span style="color: #585858;">Reports</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <%--<c:if test="${fn:contains(sessionScope.valueOfAll,'0')}">--%>
                        <li><a href="report.htm?act=showList"><i class="fa fa-circle-o"></i>Day Coupon Report</a></li>
                            <%--</c:if>--%>
                            <c:if test="${fn:contains(sessionScope.valueOfAll,'1')}">
                            <li><a href="report.htm?act=showListEmployee"><i class="fa fa-circle-o"></i>Day Coupon Report</a></li>
                            </c:if>
                            <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                            <li><a href="report.htm?act=showMachineList"><i class="fa fa-circle-o"></i>Machine Report</a></li>
                            <li><a href="report.htm?act=showAmountReport"><i class="fa fa-circle-o"></i>Actual Amount Report</a></li>
                            <li><a href="report.htm?act=showPaymentDeductionReport"><i class="fa fa-circle-o"></i>Payment Deduction Report</a></li>
                            <!--<li><a href="report.htm?act=searchOverTimeReport"><i class="fa fa-circle-o"></i>OverTime Report</a></li>-->
                            <!--<li><a href="report.htm?act=showLastDayReport"><i class="fa fa-circle-o"></i>Last Date Report</a></li>-->
                            <!--<li><a href="report.htm?act=showContracctorBalReport"><i class="fa fa-circle-o"></i>Contractor Balance Report</a></li>-->
                        </c:if>
                    </ul>
                </li>
                <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="glyphicon glyphicon-book" style="color: #585858;"></i>
                            <span style="color: #585858;">Log</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="homeController.htm?act=showList"><i class="fa fa-circle-o"></i>Logs</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${fn:contains(sessionScope.wright[6],'R')}">
                    <li class="treeview" style="color: #585858;">
                        <a href="#" style="background: #fff;">
                            <i class="glyphicon glyphicon-folder-close" style="color: #585858;"></i>
                            <span style="color: #585858;">Recycle & Backup</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="userMaster.htm?act=showBackupList"><i class="fa fa-circle-o"></i>User Management</a></li>
                            <li><a href="employeeMaster.htm?act=showBackupList"><i class="fa fa-circle-o"></i>Employee Management</a></li>
                            <li><a href="contractor.htm?act=showBackupList"><i class="fa fa-circle-o"></i>Contractor Management</a></li>
                            <li><a href="coupon.htm?act=showBackupList"><i class="fa fa-circle-o"></i>Coupon Management</a></li>
                            <li><a href="right.htm?act=showBackupList"><i class="fa fa-circle-o"></i>Right Management</a></li>
                            <li><a href="report.htm?act=createBackup"><i class="fa fa-circle-o"></i>Backup</a></li>
                            <li><a href="report.htm?act=dataDeletionSearch"><i class="fa fa-circle-o"></i>Data Deletion</a></li>
                        </ul>
                    </li>
                </c:if>

                <li class="active treeview">
                    <a href="logOut.htm?act=logout" >
                        <i class="glyphicon glyphicon-off" style="color: #424242;"></i> <span style="color: #424242;">Sign out</span>
                    </a>
                </li>
            </ul>

        </section>
        <!-- /.sidebar -->
    </aside>
</html>
<style>
    .skin-blue .sidebar-menu>li:hover>a, .skin-blue .sidebar-menu>li.active>a {
        color: #fff;
        background: #fff;
    }
    .skin-blue .wrapper
    {
        background-color: #fff;
    }


</style>