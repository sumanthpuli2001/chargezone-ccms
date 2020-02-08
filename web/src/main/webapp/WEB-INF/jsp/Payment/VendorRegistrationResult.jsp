<%-- 
    Document   : VendorRegistrationResult
    Created on : Feb 4, 2020, 3:32:46 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Registration Result</title>
        <script>
            function viewClick1(vendorId) {
                //            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
                window.location = 'payment.html?act=viewClick1&vendorId=' + vendorId ;
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

    </head>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>VENDOR REGISTRATION RESULT </h1>
            <!--            <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                            <li class="active">Employees List</li>
                        </ol>-->
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->

        <form:form action="payment.html?act=deleteSubmit1" method="post"  commandName="payment" name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 130px;" onclick="window.location = 'payment.html?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;Upload Vendor</button>
                                <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'payment.html?act=createClick1'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>

                                <div class="table table-bordered" style="padding-top: 20px;"> 
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
                                                        <th style="width: 50px;">Vendor Code</th>
                                                        <th style="width: 50px;">Vendor Name</th>
                                                        <th style="width: 50px;">Action</th>

                                                        <%--</c:if>--%>

                                                    </tr>
                                                </thead>
                                            </c:otherwise>
                                        </c:choose>
                                        <tbody>
                                           <!--<input type="checkbox" name="checkId" id="deptCheckId" value="${savingList.id}">-->
                                            <c:forEach  var="savingList1" items="${list}">
                                                <tr>
                                                    <td align="Center">
                                                        <input type="checkbox" name="checkId" id="deptCheckId" value="${savingList1.vendorId}">
                                                    </td>
                                                    <td> ${savingList1.vendorId}
                                                    </td>
                                                    <td>
                                                        ${savingList1.vendor}
                                                    </td>
                                                    <td><a href="#"onclick="viewClick1(${savingList1.vendorId});">Edit </a></td>
                                            
                                            <!--<td>-->
                                            <!--                                                                    <div class="btn-group">
                                                                                                                    <button type="button" onclick="viewClick(${savingList.id});" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                                                        &nbsp;&nbsp;Edit
                                                                                                                    </button>
                                            
                                                                                                                </div>-->
                                            <!--</td>-->
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </section>
        </form:form>

    </div><!-- /.col -->


    <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
    <!-- /.content -->


    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>

