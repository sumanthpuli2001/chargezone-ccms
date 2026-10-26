<%-- 
    Document   : TenderReport
    Created on : 6 Jun, 2022, 9:55:33 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Report</title>
    </head>
    <style>
            #loading {
                position: fixed;
                display: block;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                text-align: center;
                opacity: 0.7;
                background-color: #fff;
                z-index: 99;
            }

            #loading-image {
                position: absolute;
                top: 50%;
                left: 50%;
                z-index: 100;
            }
        </style>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'employeeMaster.htm?act=viewClick&id=' + loginName;
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
    <div id="loading">
        <img id="loading-image" src="StorageYard/Images/ajax-loader.gif" alt="Loading..." />
    </div>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tender Report</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Report</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="tenderMaster.htm?act=tenderReportList" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
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
<!--                                            <div class="table">-->

                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">Tender No. :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <input type="text" name="tender_no" value="" class="form-control" maxlength="30" />
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">Project Name :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <input type="text" name="tender_title" value="" class="form-control" maxlength="30" />
                                                    </div>
                                                </div>
                                                
                                               
                                                <hr>
                                                 Opening Date
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">From Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class='input-group date' id='datetimepicker1'>
                                                <input name="open_from_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker1').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">To Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <div class='input-group date' id='datetimepicker2'>
                                                <input name="open_to_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker2').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                
                                                <hr>
                                                Closing Date
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">From Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class='input-group date' id='datetimepicker3'>
                                                <input name="close_from_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker3').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">To Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <div class='input-group date' id='datetimepicker4'>
                                                <input name="close_to_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker4').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                </div>
                                                

                                            <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="$('#loading').show();" title="" value="Search">
                                        </div>
                                    </div>
                            
                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr. No.</th>
                                                                    <th>Tender No.</th>
                                                                    
                                                                    <th>Project Name</th>
                                                                    <th>Tender Start Date</th>
                                                                    <th>Tender End Date</th>
                                                                    <th>EMD</th>
                                                                    <th>Created By</th>
                                                                    <th>Tender Type</th>
                                                                   
                                                                    <th>Bid Sent To No. Of Vendor</th>
                                                                    <th>Bid Received/Regret From No. Of Vendor</th>
                                                                    <th>Bid Status</th>
                                                                        
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${bs}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td><a href="tenderMaster.htm?act=tenderInfo&tender_no=${list.refNo}">${list.refNo}</a></td>
                                                                       
                                                                        <td>${list.title}</td>
                                                                        <td>${list.tender_date}</td>
                                                                        <td>${list.tender_due_date}</td>
                                                                        <td>${list.emd}</td>
                                                                        <td>${list.created_by}</td>
                                                                        <td>${list.tenderPhase} Part</td>
                                                                        
                                                                        <td>
                                                                            <a href="#" onclick="window.open('tenderMaster.htm?act=tenderVendorTotal&tender_no=${list.refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">${list.vendor_total}</a>
                                                                        </td>
                                                                        <td>
                                                                            <a href="#" onclick="window.open('tenderMaster.htm?act=tenderBidVendorTotal&tender_no=${list.refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">${list.total_bid}/${list.total_regret}</a>
                                                                        </td>
                                                                        <td>
                                                                            ${list.bid_status}
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
     <script>
        $(window).load(function () {
            $('#loading').hide();
        });
        
    </script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>

