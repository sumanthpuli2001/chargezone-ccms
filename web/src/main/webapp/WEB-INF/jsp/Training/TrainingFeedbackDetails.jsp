<%-- 
    Document   : TrainingFeedbackDetails
    Created on : Mar 21, 2018, 4:15:12 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>

    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training Feedback</title>

    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Feedback Details</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training feedback details</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
            <br>
        <input  type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />
        <!-- Main content -->
        <form:form action="trainingIdentification.htm?act=showTrainingFeedbackList" method="post" commandName="employeeFeedback"
                   name='form1' class="form-horizontal" role="form">

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-primary" title="" onclick="window.location = 'trainingIdentification.htm?act=showTrainingFeedbackList2'"><i class="fa fa-search"></i>&nbsp;&nbsp;Search</button>-->
                                <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                                <!--<div class="col-sm-5">-->

<!--                                <div class="col-sm-5">
                                    ${trainingsMaps}
                                    <label>Training:<span style="color: red;font-size: 12px;">*</span></label>
                                    <select id="TrainingId" path="trainingMaster.id" name="TrainingId" class="form-control" >
                                        <option value="">--SELECT--</option>
                                        <%--<c:forEach var="trainingsMaps" items="${trainingsMaps}">--%>
                                            <option value="${trainingsMaps.key}">${trainingsMaps.value}</option>
                                        <%--</c:forEach>--%>
                                    </select>
                                    <%--<form:errors path="trainingMaster.id" cssClass="errorDiv"></form:errors>--%>
                                    </div>-->
                                </div>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                <c:choose>
                                                    <c:when test="${empty trainingFeedbackList}">
                                                        <tr>
                                                            <td align="Center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <!--<th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>-->
                                                                <th>Sr.No.</th>
                                                                <th>Employee Name</th>
                                                                <th>Feedback</th>
                                                                <th>Description</th>
                                                                <th style="width: 50px;">Action</th>
                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <!--${trainingFeedbackList}-->
                                                            <c:forEach  var="trainingFeedbackList" items="${trainingFeedbackList}">
                                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                                                <tr>
<!--                                                                    <td align="Center">
                                                                        <input type="checkbox" name="checkId" id="checkId" value="${trainingFeedbackList[0]}">
                                                                    </td>-->
                                                                    <td>
                                                                        <c:out value = "${count}"/>
                                                                    </td>
                                                                    <td>
                                                                        ${trainingFeedbackList[4]}
                                                                    </td>
                                                                    <td>
                                                                        ${trainingFeedbackList[1]}
                                                                    </td>
                                                                    <td>
                                                                        ${trainingFeedbackList[2]}
                                                                    </td>
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" onclick="viewClick(${trainingFeedbackList[5]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;View
                                                                            </button>
                                                                        </div>
                                                                    </td>                                                              
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                                
                                        </div>
                                    </div>

                                </div><!-- /.tab-pane 
                            </div>
                        </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                        </section>
                    </form:form><!-- /.content -->
                </div>
                <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

                <script>
                    function viewClick(id) {
                        window.location = 'trainingIdentification.htm?act=showFeedbackView&id=' + id;
                    }
                </script>
                </html>
