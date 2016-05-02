<%-- 
    Document   : IntervalMasterPage
    Created on : Feb 13, 2016, 11:16:09 AM
    Author     : BlackBull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interval Master</title>
    </head>

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

    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Interval Master Page: </h1>

            </section>
            <div class="content">
           <!-- Main content -->
            <form:form action="intervalMaster.htm?act=createSubmit" method="post" commandName="intervalMaster"
                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                <%--<form:hidden path="id"></form:hidden>--%>
                <!--<form class="form-horizontal" role="form" commandName>-->

                <!--Read only entries Starts here-->
                <!--<div class="box box-info collapsed-box ">-->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">                                                
                                            <div class="form-group">
                                                <div class="col-sm-4 col-sm-offset-1">
                                                    <label>Module Name<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div>
                                                        <form:select path="module" id="module" class="form-control" required="true">
                                                            <form:option value="" label="-- Select --"></form:option>
                                                            <form:option value="Expense" >Expense</form:option> 
                                                            <form:option value="GatePass">Gate Pass</form:option> 
                                                            <form:option value="Travel">Travel</form:option>
                                                            <form:option value="Leave">Leave</form:option>
                                                            <form:option value="PoolCar">Pool Car</form:option>
                                                        </form:select>
                                                    </div>

                                                    <%--<form:errors path="module" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                                <div class=" col-sm-4 col-sm-offset-2">
                                                    <label>No of Days<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="days" class="form-control" required="true" type="number"></form:input>
                                                    <%--<form:errors path="portNo" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                            </div>
                                            <button  type="submit" class="btn btn-primary center-block" style="width: 100px;font-weight: bold;" id="saveSubmit1" >SUBMIT</button>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>

            </form:form>
            
            <c:if test="${!empty successmessage}">
                <div class="fadeOutEffect alert alert-success" role="alert">${successmessage}</div>
            </c:if>
            <c:if test="${!empty failuremessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failuremessage}</div>
            </c:if>
            <div class="nav-tabs-custom">
                <div class="tab-content">
                    <%--<form:form  method="post" commandName="intervalMaster"--%>
                                <%--name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">--%>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <br/>
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                    <c:choose>
                                                        <c:when test="${empty intervalList}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="text-align: justify;width: 60%;">Module Name</th>
                                                                    <th style="text-align: center;width: 20%;">Days</th>
                                                                    <th style="text-align: center;width: 20%;">Action</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <c:forEach var="intervalList" items="${intervalList}">
                                                                        <td>${intervalList.module}</td>
                                                                        <td>${intervalList.days}</td>
                                                                        <td>
                                                                            <button class="btn btn-default center-block" style="width: 75px;" onclick="location.href = 'intervalMaster.htm?act=editClick&id=${intervalList.id}'">
                                                                                Edit 
                                                                            </button>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%--</form:form>--%>
                </div>
            </div>
            </div>
        </div>
    </body>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
