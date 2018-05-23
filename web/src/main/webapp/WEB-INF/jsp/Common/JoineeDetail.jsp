   <%-- 
    Document   : newJoinee
    Created on : May 18, 2018, 3:03:09 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
    <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Detail</title>
    </head>
    <body>
        <section class="content-header">
            <h1 style="text-align: center;">Employee Detail</h1>
        </section>
        <br/>
        <form:form class="form-horizontal" role="form" action="" commandName=""  method="post" name='form'>

            <div class="box-body no-padding">
                <div class="row">
                    <div class="col-md-6 col-sm-6" style="text-align: center;">
                        <img src="${profilePicturePath}">
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="table table-bordered">
                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <tr>
                                    <th>Employee Name:</th>
                                    <td>${empDetail.employeeName}</td>
                                    <td>&nbsp;</td>
                                    <th>Department: </th>
                                    <td> ${department.departmentName}</td>
                                </tr>
                                <tr>
                                    <th>Designation :</th>
                                    <td> ${designation.designationName}</td>
                                    <td>&nbsp;</td>
                                    <th>Email: </th>
                                    <td> ${empDetail.emailAddress}</td>
                                </tr>
                                <tr>
                                    <th>Contact: </th>
                                    <td> ${empDetail.contactNo1}</td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </div>


                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.box-body -->

        </form:form>
    </body>
</html>

