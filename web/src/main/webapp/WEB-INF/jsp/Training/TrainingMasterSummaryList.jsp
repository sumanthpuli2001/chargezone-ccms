<%-- 
    Document   : TrainingMaster
    Created on : Mar 8, 2018, 4:02:42 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training Master</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>TRAINING</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Master</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="trainingMaster.htm?act=deleteClick" method="post" commandName="TrainingMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.location = 'trainingMaster.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>-->
                                <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                                  <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'trainingMaster.htm?act=exportToExcelTrainingSummary'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
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
                                                                    <!--<th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>-->
                                                                    <th>Title</th>
                                                                    <th>Description</th>
                                                                    <th>Department</th>
                                                                    <th>Trainer</th>
                                                                    <th>Training Type</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach  var="trainingList" items="${list}">
                                                                    <tr>
<!--                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="checkId" value="${trainingList[0]}">
                                                                        </td>-->
                                                                        <td>
                                                                            ${trainingList[1]}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList[2]}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList[7]}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList[3]}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList[4]}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList[5]}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList[6]}
                                                                        </td>
                                                                        <td>
                                                                            <%--<fmt:formatDate var="date_to_comare" value="${trainingList[5]}" pattern="dd/MM/yyyy"/>--%>
                                                                            <fmt:parseDate value="${trainingList[5]}" pattern="dd/MM/yyyy" 
                                                                                           var="parsedDate" type="date" />

                                                                            <fmt:formatDate value="${parsedDate}" var="stdDatum" 
                                                                                            type="date" pattern="dd/MM/yyyy" />
                                                                            <!--// started--> 
                                                                            <jsp:useBean id="today" class="java.util.Date" />



                                                                            <fmt:formatDate value="${today}" var="stdTodayDatum" 
                                                                                            type="date" pattern="dd/MM/yyyy" />
                                                                            <!--today-->

                                                                            <fmt:parseDate value="${trainingList[6]}" pattern="dd/MM/yyyy" 
                                                                                           var="parsedendDate" type="date" />

                                                                            <fmt:formatDate value="${parsedendDate}" var="stdEndDatum" 
                                                                                            type="date" pattern="dd/MM/yyyy" />
                                                                            <!--endDate-->




                                                                            <c:if test="${parsedDate gt today}">
                                                                                <span span class="badge"> Yet to Start</span>
                                                                            </c:if>
                                                                            <%--<c:if test="${stdDatum gt stdTodayDatum}">--%>
                                                                                <!--<span span class="badge"> Yet to Start</span>-->
                                                                            <%--</c:if>--%>
                                                                            <c:if test="${today ge parsedDate && today le parsedendDate}">
                                                                                <span span class="badge"> Started</span>
                                                                            </c:if>
                                                                            <%--<c:if test="${stdTodayDatum ge stdDatum && stdTodayDatum le stdEndDatum}">--%>
                                                                                <!--<span span class="badge"> Started</span>-->
                                                                            <%--</c:if>--%>
                                                                            <c:if test="${parsedendDate lt today}">
                                                                                <span class="label label-success"> Finished</span>

                                                                            </c:if>
                                                                            <%--<c:if test="${stdEndDatum le stdTodayDatum}">--%>
                                                                                <!--<span class="label label-success"> Finished</span>-->

                                                                            <%--</c:if>--%>









                                                                            <!--                                                                            <div class="btn-group">
                                                                                                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick(${trainingList[0]});">
                                                                                                                                                                &nbsp;Edit
                                                                                                                                                            </button>
                                                                            
                                                                                                                                                        </div>-->
                                                                        </td>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick(${trainingList[0]});">
                                                                                    &nbsp;View
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

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script>
        function viewClick(id)
        {
//            alert('hello '+id);
            window.location = 'trainingMaster.htm?act=VieweditClick&id=' + id;
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
