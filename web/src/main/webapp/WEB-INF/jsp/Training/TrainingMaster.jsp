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
        <title>JSP Page</title>
    </head>
     <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Trainings:</h1>
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
        <form:form action="trainingMaster.htm?act=deleteClick" method="post" commandName="trainingList"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.location = 'trainingMaster.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    
                                                   <c:choose>
                                                        <c:when test="${empty trainingList}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                    <th>Sr.No.</th>
                                                                    <th>Title</th>
                                                                    <th>Description</th>
                                                                    <th>Training Requester</th>
                                                                    <th>venue</th>
                                                                    <th>cost</th>
                                                                    <th>Company Sponsor</th>
                                                                    <th>Training Source</th>
                                                                    <th>status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <!--${trainingTitle}-->
                                                                <c:forEach  var="trainingList" items="${trainingList}">
                                                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="checkId" value="${trainingList.id}">
                                                                        </td>
                                                                        <td>
                                                                            <c:out value = "${count}"/>
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.trainingTitle}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.trainingDescription}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.trainingOwner}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.venue}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.cost}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.companySponsor}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.trainingSource}
                                                                        </td>
                                                                        <td>
                                                                            ${trainingList.status}
                                                                        </td>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick(${trainingList.id});">
                                                                                    &nbsp;Edit
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
            window.location = 'trainingMaster.htm?act=editClick&id=' + id;
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
