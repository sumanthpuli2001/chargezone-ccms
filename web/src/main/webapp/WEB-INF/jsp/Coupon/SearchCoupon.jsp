<%-- 
    Document   : SearchCoupon
    Created on : Jun 22, 2020, 10:50:07 AM
    Author     : Aman Bahukhandi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title> </title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
        }
        function deleteClick(id) {
            window.location = 'specialCoupon.htm?act=deletePunched&checkId=' + id;
        }
    </script>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1></h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active"></li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="specialCoupon.htm?act=searchPunchData" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">

                                                <div class="col-sm-3">
                                                    <label class="control-label">From Date :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime"   data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                                                        <input name="startDate" id="startDate"  class="form-control" value="${dFrom}" size="16" readonly="true" required="required"/>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">To Date :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime"   data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                                                        <input id="endDate" name="endDate"  class="form-control" size="16" value="${eFrom}" readonly="true" required="required"/>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label">Card Code :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <input name="cardCode" id="cardCode"  class="form-control" value="${cardCode}" size="16" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label>Item:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="item" id="item" class="form-control"/>
                                                    <c:forEach var="couponType" items="${couponMap}">
                                                        <c:choose>
                                                            <c:when test="${couponType.key eq item}">
                                                                <option value="${couponType.key}" selected="true">${couponType.value}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${couponType.key}">${couponType.value}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                    </select>
                                                    <span id="companyError" style="color: red;"></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                    </div>
                                </div>
                            </div><!-- /.box-body -->

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
        <form:form  method="post"  commandName="pdm"
                    name='form2'  onsubmit='return deleteCheck11();' class="form-horizontal" >
            <c:if test="${search ne 'none'}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table table-bordered">
                                <div class=" table table-bordered table-responsive">
                                    <table id="showEmpData" class="table table-bordered table-striped table-hover" style="" align="Center">
                                        <c:choose>
                                            <c:when test="${empty pds}">
                                                <tr>
                                                    <td align="center">
                                                        <c:out value="There is no record found."></c:out>
                                                        </td>
                                                    </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <thead>
                                                    <tr style="text-align: center">
                                                        <th>Sr.No</th>  
                                                        <th>Code</th>
                                                        <th>Name</th>
                                                        <th>Date</th>
                                                        <th>Time</th>
                                                        <th>Item</th>
                                                        <th>Quantity</th>
                                                        <th>Price</th>
                                                        <th>Edit</th>
                                                        <th>Delete</th>
                                                    </tr>
                                                </thead>
                                            </c:otherwise>
                                        </c:choose>
                                        <tbody>
                                            <c:forEach var="pds" items="${pds}" varStatus="status">
                                                <tr>
                                                    <td> ${status.count}</td>
                                                    <td>${pds[2]}</td>
                                                    <td>${pds[0]}</td>
                                                    <td>${pds[3]}</td>
                                                    <td>${pds[4]}</td>
                                                    <c:forEach var="coupon" items="${couponMap}">
                                                        <c:choose>
                                                            <c:when test="${coupon.key eq pds[5]}">
                                                                <td>${coupon.value}</td>
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>
                                                    <td>${pds[6]}</td>
                                                    <td>${pds[7]}</td>
                                                    <td>
                                                        <div class="btn-group">
                                                            <button type="button" class="btn btn-default dropdown-toggle" id="loginName${status.count}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${pds[1]});">
                                                                &nbsp;View/Edit
                                                            </button>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="btn-group">
                                                            <button type="button" class="btn btn-default dropdown-toggle"   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="deleteClick(${pds[1]});">
                                                                &nbsp;Delete
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>   
                                            </c:forEach>
                                        </tbody>                                           
                                    </table>
                                </div>
                            </div>

                        </div>  
                    </div>
                </section>
            </div>
        </c:if>
    </form:form>
</div>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });</script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>


