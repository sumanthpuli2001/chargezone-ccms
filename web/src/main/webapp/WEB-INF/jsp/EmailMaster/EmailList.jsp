<%-- 
    Document   : AddVendor
    Created on : 17 Oct, 2023, 11:31:29 AM
    Author     : Seth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title>Email List</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
        }
    </script>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Email List</h4>
                <div>
                    <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >


                </div>  

            </div>
        </section>


        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="auditorMaster.htm?act=deleteAuditor" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
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

                                                <table id="table_1" class="display  responsive table table-bordered table-striped table-hover" style="" align="Center">



                                                    <thead>
                                                        <tr>
                                                            <th  class="centered-header">Sr No.</th>
                                                            <th class="centered-header">Title</th>
                                                            <th class="centered-header">Action</th>




                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <c:forEach var="list" items="${list}" varStatus="status2">
                                                            <tr>
                                                              
                                                                <td>${status2.index + 1}</td>
                                                                <td>${list.title}</td>
                                                              
                                                              
                                                                <td>
                                                                    <a href="employeeMaster.htm?act=emailEditPage&id=${list.id}" class="btn btn-sm btn-primary">
                                                                        <i class="fa fa-edit"></i> Edit
                                                                    </a>
                                                                </td>


                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>


                                                </table>


                                            </div>
                                        </div>









                                    </div><!-- /.col -->
                                </div><!-- /.row -->

                            </div><!-- /.box-body -->

                        </div>
                    </div>
                </div>

            </section>
        </form:form>

    </div>



    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>