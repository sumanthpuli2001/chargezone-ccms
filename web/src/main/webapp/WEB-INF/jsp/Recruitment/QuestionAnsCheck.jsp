<%-- 
    Document   : QuestionAnsCheck
    Created on : 13 Mar, 2018, 10:48:49 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Check Question Paper Ans</title>

    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Check Question Paper Answer</h1>
            <label>Candidate User Name&nbsp; : &nbsp;&nbsp;${ajuMaster.userName}</label>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Check Question Paper Answer</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" method="post" commandName="questionLibrary" action="questionLibrary.htm?act=submitQuestionLibrarynewRecord">
            <%--action="vacancy.htm?act=clickSubmitQuestionAnswer"--%> 
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12" style="width:96%;">
                                            <div class="table table-bordered" style="margin-left: 2%; margin-right: 5%;">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style=" text-align: left; border-bottom: 0px !important; margin-right: 5%;"   >
                                                    <c:choose>
                                                        <c:when test="${empty list2}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>

                                                            <input type="hidden" name="candidateID" id="candidateID" value="${candidateID}">
                                                            <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">
                                                            <c:forEach var="employeeAdditional" items="${list2}" varStatus="status">
                                                                <%--<c:if test="${employeeAdditional[1] ne 0.0}">--%>

                                                                <tr>
                                                                    <td>${status.count}. ${employeeAdditional[0]}</td>
                                                                </tr>
                                                                <tr>
                                                                    <c:if test="${employeeAdditional[1] eq 0}">

                                                                        <!--                                                                        <input type="checkbox" class="form-check-input" id="checkbox104">
                                                                                                                                                <label class="form-check-label" for="checkbox1">${employeeAdditional[2]}</label>-->
                                                                    <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[3]}" >
                                                                            <label class="form-check-label" for="radio100${employeeAdditional[3]}">${employeeAdditional[2]}</label></td></tr>
                                                                    <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[5]}">
                                                                            <label class="form-check-label" for="radio100${employeeAdditional[5]}">${employeeAdditional[4]}</label></td></tr>
                                                                    <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[7]}">
                                                                            <label class="form-check-label" for="radio100${employeeAdditional[7]}">${employeeAdditional[6]}</label></td></tr>
                                                                    <tr><td><input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[9]}">
                                                                            <label class="form-check-label" for="radio100${employeeAdditional[9]}">${employeeAdditional[8]}</label></td></tr>
                                                                        </c:if>
                                                                        <c:if test="${employeeAdditional[1] eq 1}">
                                                                    <td><textarea type="text" name="${status.count}" id="${status.count}" rows="4" cols="70" placeholder="Enter your answer here..."></textarea></td>
                                                                    </c:if>
                                                                </tr>

                                                            </c:forEach>

                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </table>
                                                <div class="form-group">

                                                    <div class=" col-sm-2">
                                                        <button type="submit" class="btn btn-primary" data-original-title=""  title="" style="text-align: center" >Submit</button> 
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
    <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script>
        initSample();
    </script>
