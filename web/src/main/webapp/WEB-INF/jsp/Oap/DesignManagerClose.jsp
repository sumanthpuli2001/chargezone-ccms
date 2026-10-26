<%-- 
    Document   : DesignManagerClose
    Created on : Apr 30, 2025, 10:25:14 AM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Design CoOrdinator Close</title>
        <style>
            textArea{
                resize: vertical;
            }
        </style>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div style="display: flex; height: 25px; justify-content: space-between; align-items: center;">
                <h3 style="margin-top: 1px;">Design CoOrdinator Close</h3>

                <div style="display: flex; justify-content: flex-end;">
                    <div style="display: flex; gap: 10px; align-items: center;">

                        <input type="button" class="btn btn-primary" onclick="history.back();" title="Go back to the previous page" value="Back">
                    </div>
                </div>
            </div>

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="oapForm.htm?act=DesignCoordinatorClose" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                    <input type="hidden" name="id" value="${id}">
                                    <input type="hidden" name="id1" value="${list2.id}">
                                    <input type="hidden" name="id2" value="${list3.id}">

                                    <c:if test="${list3.id == 0}">
                                        <h4 style="padding-left: 25px;">OAP Form Details</h4>
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="table_11" class="table table-bordered table-striped table-hover" align="center">
                                                    <thead>
                                                        <tr>
                                                            <th>Document No</th>
                                                            <th>Pcs Name</th>
                                                            <th>Project Name</th>
                                                            <th>Pcs CoOrdinates</th>
                                                            <th>Client Name</th>
                                                            <th>Department</th>
                                                            <th>Date</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>${list2.documentNo}</td>
                                                            <td>${list2.pcsName}</td>
                                                            <td>${list2.projectName}</td>
                                                            <td>${list2.pcsCoordinates}</td>
                                                            <td>${list2.mobileNo}</td>
                                                            <td>${list2.department}</td>
                                                            <td>${list2.createdDate}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <h4 style="padding-left: 25px;">CRC Form Details</h4>               
                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="max-width: 97%;" align="center">
                                            <thead>
                                                <tr>


                                                    <th>Document No</th>
                                                    <th>PCS Name </th>
                                                    <th>PCS Drawing Number </th>
                                                    <th>Prepared By </th>
                                                    <th>Scope Of Work </th>
                                                    <th>Designation </th>

                                                </tr>
                                            </thead>

                                            <tbody>

                                            <input type="hidden" name="id" id="id" value="${crcForm.id}">

                                            <tr >
                                                <td>${crcForm.documentNo}</td> 
                                                <td>${crcForm.pcsName}</td>
                                                <td>${crcForm.pcsDrawingNumber}</td> 
                                                <td>${crcForm.preparedBy}</td>
                                                <td>${crcForm.scopeWork}</td> 
                                                <td>${crcForm.designation}</td>  


                                                </tbody>



                                        </table>
                                    </c:if>           

                                    <c:if test="${list2.id == 0}">
                                        <h4 style="padding-left: 25px;">AOC Form Details</h4>
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="table_12" class="table table-bordered table-striped table-hover" align="center">
                                                    <thead>
                                                        <tr>
                                                            <th>Document Number</th>
                                                            <th>Depo.Name</th>
                                                            <th>Project Name</th>
                                                            <th>Created By</th>
                                                            <th>Client Name</th>
                                                            <th>Date</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>${list3.documentNo}</td>
                                                            <td>${list3.hubDepoName}</td>
                                                            <td>${list3.clientProjectName}</td>
                                                            <td>${list3.userId}</td>
                                                            <td>${list3.mobileNo}</td>
                                                            <td>${list3.createdDate}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>   
                                        <h4 style="padding-left: 25px;">KICKOFF Form Details</h4>
                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="max-width: 97%;" align="center">
                                            <thead>
                                                <tr>
                                                    <th>Document No</th>
                                                    <th>Hub Location</th>
                                                    <th>Project Name</th>
                                                    <th>Designation</th>
                                                    <th>Date & Time</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${kickOffForm.documentNo}</td>
                                                    <td>${kickOffForm.hubLocation}</td>
                                                    <td>${kickOffForm.projectName}</td>
                                                    <td>${kickOffForm.designation}</td>
                                                    <td>${kickOffForm.dateTime}</td>
                                                </tr>
                                            </tbody>
                                        </table>

                                    </c:if>



<br>
                                <div class="form-group">
                                    <div class="col-sm-3">
                                        <label class="control-label" style="padding-left: 25px;">Comment:<span style="color: red;font-size: 12px;">*</span></label>
                                    </div>
                                    <div class="col-sm-3">
                                        <textarea type="text"  required="true" class="form-control" id="comment" name="comment"></textarea>
                                    </div>
                                </div>
                                <br>

                                <div class="form-group">
                                    <div class="col-sm-5 col-sm-offset-5">
                                        <input type="submit" class="btn btn-danger" style="width: 100px;"  title="" value="Close">
                                    </div>
                                </div>


                                    
                                </div>
                                



                            </form:form>

                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->



                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
    </div>


</section><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<!--datetime-->
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>
