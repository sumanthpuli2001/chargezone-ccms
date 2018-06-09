<%-- 
    Document   : CreateAssignTraine
    Created on : Mar 10, 2018, 2:19:08 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Training Assessment</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>TRAINING ASSESSMENT LIST</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Assessment List</li>
            </ol>
        </section>

        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to delete?");
                if (checkboxes) {
                    checkboxes = document.getElementsByName('checkId');
                    for (var i = 0, n = checkboxes.length; i < n; i++) {
                        if (checkboxes[i].checked) {
                            return true;
                        }
                    }
                    alert("Please, Select one or more record(s).");
                }
                return false;
            }

            
//            function TimedRefresh() {
//                alert("hi")
//               location.reload();
//            };
//
//            $(document).ready(function() {
//              setTimeout("TimedRefresh()", 500); .
//            });
        </script>
        <script>
            function viewClicklist(id, empid, onlineAssment) {
//                alert("hi");
//            window.location = 'payrollSalaryType.htm?act=viewClick&id=' + id;
                window.location = 'trainingAssessment.htm?act=clickassessmentOnlineTest&id=' + id + '&empid=' + empid + '&onlineAssment=' + onlineAssment;
            }
        </script>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <body>
        <form:form action="" method="post" 
                   name='form1'  commandName="trainingAssessment" onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

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
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
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
                                                                <tr>
                                                                    <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <!--<th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>-->
                                                                    <%--</c:if>--%>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Question Paper</th>
                                                                    <th style="width: 50px;">passing Percentage</th>
                                                                    <th style="width: 50px;">Validity From</th>
                                                                    <th style="width: 50px;">Validity To</th>
                                                                    <th style="width: 50px;">Duration</th>
                                                                    <th style="width: 50px;">No of Attempt</th>
                                                                    <th style="width: 50px;">No Of Question</th>
                                                                    <th style="width: 50px;">Total Marks</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 50px;">Action</th>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list2}">
                                                            <tr>
                                                                <td>${list[10]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[6]}</td>
                                                                <td>${list[7]}</td>
                                                                <td>${list[8]}</td>
                                                                <td>${list[9]}</td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>


                                                                <!--                                                                    <div class="btn-group">
                                                                                                                                        <button type="button" onclick="viewClick(${list[2]},${list[11]},${list[0]});" class="btn btn-default" >
                                                                                                                                            &nbsp;&nbsp;&nbsp;&nbsp;Take Test
                                                                                                                                        </button>
                                                                                                                                    </div>-->
                                                                <td style="width: 50px;"><a style="cursor: pointer;" onclick='viewClicklist(${list[2]},${list[11]},${list[0]});'>Take Test</a></td>


                                                            </tr>
                                                        </c:forEach>

                                                    </tbody>
                                                </table>
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
        </body>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <script>
        function editViewClick(id) {
            window.location = 'trainer.htm?act=newEditTrainer&id=' + id;
        }
    </script>




    /////////////////New Modal 

    <div class="container">
        <div class="modal fade" id="myModalOnline" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Training Identification</h4>
                    </div>
                    <form:form class="form-horizontal" method="post" commandName="trainingIdentification" 
                               action="trainingIdentification.htm?act=trainingAssignSubmit" >
                        <section class="content">
                            <!--<div class="col-md-12">-->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>
                                                        <input type="hidden" id="id1" name="id">
                                                        <label>Training Tittle:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:select path="trainingMaster"  class="form-control">
                                                                <form:option value="" label="-- Select --" />
                                                                <form:options items="${tlist}"/>
                                                            </form:select>

                                                        <!--                                                        <select name="trainingMastername" class="form-control">
                                                                                                                    <option value="">--Select--</option>
                                                        <%--<c:forEach items="${tlist}" var="trainingMastername">--%>
                                                            <option value="${trainingMastername.key}">${trainingMastername.value}</option>
                                                        <%--</c:forEach>--%>
                                                    </select>-->
                                                    </div>
                                                </div>
                                            </div>
                                            <!--<div class="row">-->
                                            <div class="form-group">
                                                <div class=" col-sm-5 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                                </div>
                                            </div>
                                            <div style="float: right;">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--</div>-->
                            <!--</div>-->

                        </section>
                    </form:form>

                </div>
            </div>
        </div>
    </div>



</html>
