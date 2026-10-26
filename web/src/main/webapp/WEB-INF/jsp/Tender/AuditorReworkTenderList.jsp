<%-- 
    Document   : AuditorReworkTenderList
    Created on : 11 Jan, 2024, 5:23:50 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Approved Tender List</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = '' + loginName;
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
            <h1>Approved Tender List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Approved Tender List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="tenderMaster.htm?act=vendorReviseBid" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <input type="hidden" name="refNo" value="${refNo}">
            <input type="hidden" name="id" value="${id}">
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
                                           
                                            
                                            <table id="table_11" class="table table-bordered" style="" align="Center"  >

                                                <thead>
                                                    <tr>

                                                        <th>Tender No.</th>
                                                        <th>Tender Title</th>
                                                        <th>Tender Date</th>
                                                        <th>Tender Due Date</th>
                                                        <th>Status</th>
                                                        <th>View</th>


                                                    </tr>
                                                </thead>
                                                <c:set var="count" value="0" scope="page" />
                                                <tbody>

                                                    <c:forEach var="li" items="${list}" varStatus="status">

                                                       
                                                        <tr class="text-center">

                                                            <td>${li[1]}</td>
                                                            <td>${li[3]}</td>
                                                            <td>${li[4]}</td>
                                                            <td>${li[5]}</td>
                                                            <c:if test="${li[2] == 0}">
                                                                <td>Pending</td>
                                                            </c:if>
                                                            
                                                            <c:if test="${li[2] == 1}">
                                                                <td>Approve</td>
                                                            </c:if>
                                                            
                                                            <c:if test="${li[2] == 2}">
                                                                <td>Rework</td>
                                                            </c:if>
                                                                
                                                            <c:if test="${li[2] == 3}">
                                                                <td>Reject</td>
                                                            </c:if>
                                                                <td>
                                                                    <a href="tenderMaster.htm?act=vendorListView4&id=${li[0]}">
                                                                                    bid opened
                                                                                </a>
                                                                                
                                                                            </td>
                                                        </tr>

                                                    </c:forEach>

                                                </tbody>


                                            </table>


                                            <!--                                            </div>-->


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
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>



