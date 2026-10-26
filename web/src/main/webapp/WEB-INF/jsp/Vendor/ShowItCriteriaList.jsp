<%-- 
    Document   : ShowItCriteriaList
    Created on : 23 Aug, 2025, 2:56:57 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>IT Criteria List</title>
    </head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />

    <script>
        function viewClick(id) {
//             alert("P");
////            var x1=document.getElementById('id').value;
//            var x= $('#id' + id).val();
            var rightName = $('#rightName' + id).val();
            window.location = 'group.htm?act=itCriteriaEdit&id=' + rightName;
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

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">IT Criteria</h4>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="group.htm?act=deleteItCriteriaDetails" method="post" commandName="rightMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'group.htm?act=createItCriteria'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered"></div>

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
                                                                <th style="width: 1px;" ><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                <th>Sr.No.</th>
                                                                <th>Group Name</th>
                                                                <th>Criteria Name</th>
                                                                <th>Criteria Description </th>
                                                                <th>Complusary</th>
                                                                <th>Action</th>

                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                                <tr>
                                                                    <td align="Center">
                                                                        <input  type="checkbox" name="checkId" id="deptCheckId" value="${list[0]}">
                                                                    </td>
                                                                    <td>${status.count}</td>
                                                                    <td >${list[1]}</td>
                                                                    <td >${list[2]}</td>
                                                                    <td >${list[3]}</td>
                                                                    <td>
                                                                        <c:choose>
                                                                            <c:when test="${list[4] == '1'}">
                                                                                <i class="fa fa-check-circle text-success" title="Compulsory"></i>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <i class="fa fa-times-circle text-danger" title="Not Compulsory"></i>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </td>

                                                                    <td style="text-align: center;">
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle"  id="rightName${list[0]}" value="${list[0]}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list[0]});">
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


