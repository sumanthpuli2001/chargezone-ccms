<%-- 
    Document   : oapTracker
    Created on : May 15, 2025, 3:30:43 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>OAP Tracker</title>

    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">OAP Tracker</h3>
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
        <form:form action="sapConnection.htm?act=deleteSapDetails" method="post" commandName="rightMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'sapConnection.htm?act=sapCreate'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>-->
                                <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">

                                            <!--                                            <div class="table">-->
                                            <div >
                                                <table id="table_1"  class="display nowrap table table-bordered table-striped table-hover" align="center">



                                                    <thead>
                                                        <tr>
                                                            <th>Sr No</th>
                                                            <th>Document No</th>
                                                            <th>Created Date</th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>
                                                            <th>Approval Date </th>





                                                        </tr>
                                                    </thead>
                                                    <c:set var="count" value="0" scope="page" />




                                                </table>
                                            </div>
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
    $(document).ready(function () {
        if ($.fn.dataTable.isDataTable('#table_1')) {
            $('#table_1').DataTable().destroy();
        }

        $('#table_1').DataTable({
            scrollX: true,
              "ordering": false
        });
    });

</script>
<%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
</html>



