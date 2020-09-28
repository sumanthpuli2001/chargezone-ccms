<%-- 
    Document   : CouponList
    Created on : Jun 19, 2020, 10:08:59 AM
    Author     : Aman Bahukhandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Coupon List</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'coupon.htm?act=viewClick&id=' + id;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Coupon List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Coupon List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="coupon.htm?act=disableCoupon" method="post" commandName="couponMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${fn:contains(sessionScope.wright[4],'W')}">
                                    <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'coupon.htm?act=createCouponMaster'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                </c:if>
                                <c:if test="${fn:contains(sessionScope.wright[4],'D')}">
                                    <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                </c:if>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                    <th>Sr.No.</th>
                                                                    <th>Coupon Type</th>
                                                                    <th>Subsidise Price1</th>
                                                                    <th>Subsidise Quantity1 </th>
                                                                    <th>Monthly Limit For Sub1 </th>
                                                                    <th>Subsidise Price2 </th>
                                                                    <th>Subsidise Quantity2 </th>
                                                                    <th>Monthly Limit For Sub2 </th>
                                                                    <th>Commercial Price </th>
                                                                        <c:if test="${fn:contains(sessionScope.wright[4],'U')}">
                                                                        <th>View/Edit</th>
                                                                        </c:if>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="deptCheckId" value="${list.srNo}">
                                                                        </td>
                                                                        <td> ${status.count}</td>
                                                                        <td>${list.couponType}</td>
                                                                        <td>${list.couponPrice}</td>
                                                                        <td>${list.qty1}</td>
                                                                        <td>${list.limitMonthSub1}</td>
                                                                        <td>${list.secondPrice}</td>
                                                                        <td>${list.limitMonthSub2}</td>
                                                                        <td>${list.secondPrice}</td>
                                                                        <td>${list.acPrive}</td>
                                                                        <c:if test="${fn:contains(sessionScope.wright[4],'U')}">
                                                                            <td>
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle" id="loginName${status.count}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list.srNo});">
                                                                                        &nbsp;View/Edit
                                                                                    </button>

                                                                                </div>
                                                                            </td>
                                                                        </c:if>

                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>