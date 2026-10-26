<%-- 
    Document   : ServiceRightsList
    Created on : 16 Jun, 2022, 12:08:16 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Right List</title>
    </head>
    <script>
        function viewClick(id) {
            var rightName = $('#rightName' + id).val();
            window.location = 'right.htm?act=viewServiceRightsClick&id=' + rightName;
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
            <h1>Right List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Right List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="right.htm?act=deleteServiceRight" method="post" commandName="rightMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                    <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'right.htm?act=createServiceRights'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                    <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
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
                                                                    <th>Department</th>
                                                                    <th>Location</th>
                                                                    <th>SAP</th>
                                                                    <th>Service 1</th>
                                                                    <th>Service 2</th>
                                                                    <th>Service 3</th>
                                                                    <th>Service 4</th>
                                                                    <th>Service 5</th>
                                                                    <th>Service 6</th>
                                                                    <th>View/Edit</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="deptCheckId" value="${list.id}">
                                                                        </td>
                                                                        <td> ${status.count}</td>
                                                                        <td>${list.department}</td>
                                                                        <td>${list.location}</td>
                                                                        <td>${list.sap}</td>
                                                                        <td>${list.service1}</td>
                                                                        <td>${list.service2}</td>
                                                                        <td>${list.service3}</td>
                                                                        <td>${list.service4}</td>
                                                                        <td>${list.service5}</td>
                                                                        <td>${list.service6}</td>
                                                                             <td>
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle"  id="rightName${status.count}" value="${list.id}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list.id});">
                                                                                        &nbsp;View/Edit
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

