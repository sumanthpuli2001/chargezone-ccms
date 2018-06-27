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
        <form:form class="form-horizontal" role="form" action="" commandName=""  method="post" name='form'>

            <div class="box-body no-padding">
                <div class="row">
                    <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                        <div class="box-header" style="background-color: #006fad;text-align: center;">
                            <h3 class="box-title" id="rAndR" style="font-size: 30px;color: white;font-weight:700;font-size:16px;">EMPLOYEE DETAILS</h3>
                        </div>
                        <div class="box-body" style="text-align: center;">
                            <div class="col-md-9 col-sm-12 col-xs-12 col-lg-6">
                                <div class="col-md-6 col-sm-6 col-xs-6" style="text-align: center;">
                                    <img src="${profilePicturePath}" height="200" width="200" >
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <div class="table table-bordered">
                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                            <tr>
                                                <th>Employee Name:</th>
                                                <td>${empDetail.employeeName}</td>
                                            </tr>
                                            <tr>
                                                <th>Department:</th>
                                                <td> ${department.departmentName}</td>
                                            </tr>
                                            <tr>
                                                <th>Designation:</th>
                                                <td> ${designation.designationName}</td>
                                            </tr>
                                            <tr>
                                                <th>Email:</th>
                                                <td> ${empDetail.officeEmailId}</td>
                                            </tr>
                                            <tr>
                                                <th>Contact:</th>
                                                <td> ${empDetail.contactNo2}</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                        </div>
                    </div><!-- /.box-body -->
                </div>
            </div>
        </form:form>
    </body>
</html>

