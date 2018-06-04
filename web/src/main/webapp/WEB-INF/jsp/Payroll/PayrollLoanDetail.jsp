<%--
    Document   : LocationList
    Created on : Oct 20, 2015, 12:46:42 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Loan Details </title>
    </head>
    <script>
          function viewClick(id) {
            window.location = 'payrollLoanType.htm?act=viewClickLoanDetail&id=' + id;
        }
//        function toggle(source) {
//            alert("hit it");
//            var checkboxes = "";
//            checkboxes = document.getElementsByName('deptId');
//            for (var i = 0, n = checkboxes.length; i < n; i++) {
//                if (checkboxes[i].checked) {
//                    return true;
//                }
//            }
//            alert("Please, Select one or more record(s).");
//            return false;
//        }
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
            <h1>ALL LIST LOAN DETAILS </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Loan Details </li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="payrollLoanType.htm?act=deleteSubmitLoanDetail" method="post" 
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'payrollLoanType.htm?act=createClickLoanDetail'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty payrollLoanDetaillist}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                    <!--<th>Sr.No.</th>-->
                                                                    <th>Employee Name</th>
                                                                    <th>Loan Type</th>
                                                                    <th>Loan Interest Rates</th>
                                                                    <th>Loan Amount</th>
                                                                    <th>Monthly EMI</th>
                                                                    <!--<th>Monthly Ins.</th>-->
                                                                    <th>From Date</th>
                                                                    <th>To Date</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach  var="savingList" items="${payrollLoanDetaillist}" >
                                                            <tr>
                                                                <td align="Center">
                                                                    <input type="checkbox" name="checkId" id="deptCheckId" value="${savingList.id}">
                                                                </td>
                                                                <td>
                                                                    ${savingList.employeeMaster.employeeName}
                                                                </td>
                                                                <td>
                                                                    ${savingList.payrollLoanType.text}
                                                                </td>
                                                                <td>
                                                                    ${savingList.instRate}
                                                                </td>
                                                                <td>
                                                                    ${savingList.loanAmount}
                                                                </td>
                                                                <td>
                                                                    ${savingList.monltyEmi}
                                                                </td>
                                                                <td>
                                                                    ${savingList.startDate}
                                                                </td>
                                                                <td>
                                                                    ${savingList.endDate}
                                                                </td>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewClick(${savingList.id});" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;Edit
                                                                        </button>

                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>

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