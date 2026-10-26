<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head onload="rrshowSlides(1);">
        <title>Dashboard</title>
        <script>
            jQuery.noConflict();
            jQuery(document).ready(function () {

                jQuery("#employeeName").tokenInput(${list}, {
                    preventDuplicates: true,
                    noResultsText: "No Result",
                    tokenLimit: "1",
                    searchingText: "Searching ... .. ."
                });
            });

        </script>


        <style>
            .nav-tabs>li>a {
                color: #555;
                transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out;
            }

            .nav-tabs>li.active>a,
            .nav-tabs>li>a:hover {
                background-color: #5bc0de;
                color: #fff;
            }

            .nav-tabs>li.active>a {
                background-color: #486783;
                color: #fff;
            }

            .nav-tabs>li>a>i {
                margin-right: 5px;
            }

            .nav-tabs>li>a .badge {
                background-color: #d9534f;
            }

            .nav-tabs {
                border-bottom: 2px solid #ddd;
            }

            .nav-tabs>li {
                margin-bottom: -2px;
            }

            .nav-tabs>li>a {
                border: 1px solid transparent;
                border-radius: 4px 4px 0 0;
            }

            .nav-tabs>li.active>a,
            .nav-tabs>li.active>a:focus,
            .nav-tabs>li.active>a:hover {
                border: 1px solid #ddd;
                border-bottom-color: transparent;
            }

            .nav-tabs>li>a:hover {
                border-color: #eee #eee #ddd;
            }
        </style>

        <style>
            .table {
                background-color: #f9f9f9;
            }



            .table th, .table td {
                text-align: center;
                vertical-align: middle;
            }

            .table tbody tr:nth-child(odd) {
                background-color: #f2f2f2;
            }

            .table tbody tr:hover {
                background-color: #e6f7ff;
            }

            .table .btn {
                margin: 2px;
                font-size: 12px;
                padding: 5px 10px;
            }

            .btn-default {
                background-color: #d9534f;
                color: white;
            }

            .btn-default:hover {
                background-color: #c9302c;
            }

            .btn-primary, .btn-info {
                color: white;
            }

            .btn-primary {
                background-color: #0275d8;
            }

            .btn-info {
                background-color: #5bc0de;
            }

            .btn-primary:hover {
                background-color: #025aa5;
            }

            .btn-info:hover {
                background-color: #31b0d5;
            }
        </style>

    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tender Dashboard</h1>
            <ol class="breadcrumb">

                <li class="active">Tender Dashboard</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">

                        <div id="exTab" class="container" style="width: 100%;">

                            <ul class="nav nav-pills nav-tabs">
                                <li>
                                    <a href="prMaster.htm?act=assignDashboard">
                                        <i class="fa fa-file-text-o"></i>
                                        PR Approval
                                        <span class="badge" id="tenderPriceApprovalSize" name="tenderPriceApprovalSize">${tenderPriceApprovalSize}</span>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="prMaster.htm?act=assignTenderDashboard">
                                        <i class="fa fa-truck"></i>
                                        Create Tender
                                        <span class="badge" id="prMasterSize" name="prMasterSize">${prMasterSize}</span>
                                    </a>
                                </li>
<!--                                <li class="">
                                    <a href="prMaster.htm?act=assignBidDashboard">
                                        <i class="fa fa-envelope-o"></i>
                                        Bid Receive
                                        <span class="badge" id="" name="">${readPoCount}</span>
                                    </a>
                                </li>-->
                            </ul>
                        </div>










                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="">
                                            <div class="box-header">
                                            </div>
                                            
                                                
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <!--                                            <div class="table">-->




                                            <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty prMaster}">
                                                        <tr>
                                                            <td align="Center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th>Sr. No.</th>
                                                                <th>PR Number</th>
                                                                <th>Title</th>
                                                                <th>Created By</th>
                                                                <th>Date Time</th>
                                                                <th>Approval Status</th>
                                                                <th>View</th>

                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach var="list" items="${prMaster}" varStatus="status">
                                                            <input type="hidden" name="id" id="id" value="${list.id}">
                                                            <tr>
                                                                <td>${status.count}</td>
                                                                <td>${list.prNo}</td>
                                                                <td>${list.title}</td>
                                                                <td>${list.contactPerson}</td>
                                                                <td>${list.announceDate}</td>
                                                                <c:if test="${list.authorizeFlag == 0}">
                                                                    <td>Pending</td>
                                                                </c:if>

                                                                <c:if test="${list.authorizeFlag == 1}">
                                                                    <td>Approve</td>
                                                                </c:if>

                                                                <td>

                                                                    <a href="prMaster.htm?act=searchView&id=${list.id}">View</a>
                                                                    <c:if test="${list.authorizeFlag == 1}">
                                                                        <br><a href="prMaster.htm?act=searchView1&id=${list.id}">Create Tender</a>

                                                                        <c:if test="${list.tenderFlag == 0}">
                                                                            <br><a href="prMaster.htm?act=searchView2&id=${list.id}">Assign Tender</a>
                                                                        </c:if>
                                                                        <c:if test="${list.tenderFlag == 1}">    
                                                                            <br><a href="prMaster.htm?act=searchView2&id=${list.id}">Re-assign Tender</a>
                                                                        </c:if>
                                                                    </c:if>
                                                                </td>

                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>

                                                    </c:otherwise>
                                                </c:choose>
                                            </table>

                                            <!--                                            </div>-->
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                                            
                                            
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1">
                                </div>
                            </div>
                            <br>
                            <br>



                        </div>

                    </div>
                </div>
        </section>
    </div>
    <!--</div>
    </div>-->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>



