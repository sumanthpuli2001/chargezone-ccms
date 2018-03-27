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
        <title>Training Identification</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Training Identification List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home111</a></li>
                <li class="active">Training Identification List</li>
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
        </script>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="trainingIdentification.htm?act=trainingIdentificationdeleteDeleteSubmit" method="post" commandName="trainingIdentification"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                    <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                    <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                    <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'trainingIdentification.htm?act=newAssignTraine'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
                                <%--</c:if>--%>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                        <th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>
                                                                        </c:if>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Employee Name</th>
                                                                    <th style="width: 50px;">Training Tittle</th>
                                                                    <th style="width: 50px;">Description</th>
                                                                    <!--<th style="width: 50px;">Status</th>-->
                                                                    <!--<th style="width: 50px;">Status</th>-->
                                                                    <th style="width: 50px;">Action</th>
                                                                    <!--<th style="width: 50px;">Edit</th>-->
                                                                    <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                                    </c:if>
                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <!--<td>${list[4]}</td>-->
                                                                <%--<c:if test="${list[6] == 0}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 2}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 1}"><td><span class="label label-warning">Recycled</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 3}"><td><span class="label label-danger">Rejected</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 4}"><td><span class="label label-success">Approved</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 5}"><td><span class="label label-success">Final Approved</span></td></c:if>--%>

                                                                <td>
                                                                    <!--                                                                        <div class="btn-group">
                                                                                                                                                <button type="button" onclick="viewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                                                                                &nbsp;&nbsp;View
                                                                                                                                            </button>
                                                                                                                                        </div>-->
                                                                    <%--<c:if test="${list[6] eq 0 || list[6] eq 1}">--%>
                                                                    <div class="btn-group">
                                                                        <button type="button" data-toggle="modal" data-target="#myModalOnline" onclick="setid(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;&nbsp;&nbsp;Edit
                                                                        </button>
                                                                    </div>
                                                                    <%--</c:if>--%>

                                                                </td>
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

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <script>
        function editViewClick(id) {
            window.location = 'trainer.htm?act=newEditTrainer&id=' + id;
        }
    </script>
    <script>
        function viewClick(id) {
            window.location = 'recruitment.htm?act=viewMPPShow&id=' + id;
        }
        function setid(id) {
//            alert(id);
            document.getElementById("id1").value = id;
           $('#test2').html(id).modal('show');
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
