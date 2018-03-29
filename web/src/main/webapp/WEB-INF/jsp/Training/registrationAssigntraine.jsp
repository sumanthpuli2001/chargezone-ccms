<%-- 
    Document   : registrationAssigntraine
    Created on : Mar 10, 2018, 2:50:07 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>Trainee List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home111</a></li>
                <li class="active">Trainee List</li>
            </ol>
        </section>

        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to Assigne?");
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

            function checkBlankField() {
                var flag = true;
                if ($('#trainingMaster').val() == '') {
                    document.getElementById('trainingMasterError').innerHTML = '-It must not be empty or white space.';
                    flag = false;
                }
                if ($('#description').val() == '') {
                    document.getElementById('descriptionError').innerHTML = '-It must not be empty or white space.';
                    flag = false;
                }
              
              if(flag){
                  return deleteCheck11(); 
              }
                return flag;
            }

            function trainingOnChange(idString) {
                if (document.getElementById(idString).innerHTML != null) {
                    document.getElementById(idString).innerHTML = '';
                }
            }

        </script>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="trainingIdentification.htm?act=trainingAssignSubmit" method="post" commandName="trainingIdentification"
                   name='form1' onsubmit='return checkBlankField();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                    <!--<button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>-->
                                    <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                    <!--<button type="button" class="btn btn-primary" style="width: 200px !important;" onclick="window.location = 'trainingIdentification.htm?act=newAssignTraine'"><i class="fa fa-plus"></i>&nbsp&nbsp;Assigne Traine</button>-->
                                </c:if>
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
                                                                    <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                        <th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>
                                                                        <%--</c:if>--%>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Employee Name</th>
                                                                    <th style="width: 50px;">Department Name</th>
                                                                    <th style="width: 50px;">Designation Name</th>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                                    <%--</c:if>--%>
                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>

                                                                <!--<td>-->
                                                                <!--                                                                        <div class="btn-group">
                                                                                                                                            <button type="button" onclick="viewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                                                                            &nbsp;&nbsp;View
                                                                                                                                        </button>
                                                                                                                                    </div>-->
                                                                <%--<c:if test="${list[6] eq 0 || list[6] eq 1}">--%>
                                                                <!--                                                                    <div class="btn-group">
                                                                                                                                        <button type="button" onclick="editViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                                                                            &nbsp;&nbsp;&nbsp;&nbsp;Edit
                                                                                                                                        </button>
                                                                                                                                    </div>-->
                                                                <%--</c:if>--%>

                                                                <!--</td>-->
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                    <div class="tab-content">
                                        <div class="box-header">
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                                                <label>Training Tittle<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="trainingMaster.id" id="trainingMaster"  class="form-control" onchange="trainingOnChange('trainingMasterError');">
                                                                <form:option value="" label="-- Select --" />
                                                                <form:options items="${tlist}"/>
                                                            </form:select>
                                                            <span style="font-size: 14px; color: #dd4b39;" id="trainingMasterError"></span>
                                                            <%--<form:errors path="trainingMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12 col-sm-12">
                                                            <label>Description:<span style="color: red;font-size: 12px;">*</span></label><br>
                                                            <form:textarea style="resize: none; width:515px !important"  path="description" id="description" onchange="trainingOnChange('descriptionError');"></form:textarea>
                                                            <br>
                                                            <span style="font-size: 14px; color: #dd4b39;" id="descriptionError"></span>
                                                        </div>


                                                    </div> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>


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
    </script>
</html>

