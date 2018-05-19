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
            <h1>Employee Detail</h1>
        </section>

        <form:form class="form-horizontal" role="form" action="" commandName=""  method="post" name='form'>

            <div class="box-body no-padding">
                <div class="row">
                    <div class="col-md-6 col-sm-6">
                        <img src="${profilePicturePath}">

                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="table table-bordered">
                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                <tr>
                                    <td>Employee Name: ${empDetail.employeeName}</td>
                                    <td>Department:  ${department.departmentName}</td>
                                </tr>
                                <tr>
                                    <td>Designation  ${designation.designationName}</td>
                                    <td>Email:  ${empDetail.emailAddress}</td>
                                </tr>
                                <tr>
                                    <td>Contact:  ${empDetail.contactNo1}</td>
                                </tr>
                            </table>
                        </div>


                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.box-body -->

        </form:form>
    </body>
</html>

