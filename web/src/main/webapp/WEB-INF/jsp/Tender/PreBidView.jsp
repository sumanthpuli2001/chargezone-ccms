<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Aman Bahukhandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Pre Qualification View</title>
        
<script language="javascript" type="text/javascript">
    function gettender() 
    {
        
        var t=document.getElementById("refNo").value;
        var tenderPhase = document.getElementById("tenderPhase").value;
        window.location='tenderMaster.htm?act=getTender&refNo='+t+'&tenderPhase='+tenderPhase;
    }
      
</script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Pre Qualification View</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor Pre Qualification View</li>
            </ol>
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
                                <form:form action="tenderMaster.htm?act=submitTenderMaster" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    
                                    Tender information
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Tender No.</th>
                                            <td>${refNo}</td>
                                            <th>Tender Title</th>
                                            <td>${title}</td>
                                        </tr>
                                        <tr>
                                            <th>RFQ No.</th>
                                            <td>${rfqNo}</td>
                                            <th>Vendor Name</th>
                                            <td>${vendorCode} ${vendorName}</td>
                                        </tr>
                                        <tr>
                                            <th>Tender Date Time</th>
                                            <td>${announceDate}</td>
                                            <th>Due Date Time</th>
                                            <td>${submitLastdate}</td>
                                        </tr>
                                        <tr>
                                            <th>PR No.</th>
                                            <td>${prNo}</td>
                                        </tr>
                                        <tr>
                                            <th>Tender Pre Qualification Remark</th>
                                            <td>${preQualificationRemark}</td>
                                        </tr>
                                        
                                    </table>
                                    
                                        
                                    Tender Contact Person
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Created by</th>
                                            <td>${contactPerson}</td>
                                            <th>Number</th>
                                            <td>${tenderAdminContactNumber}</td>
                                        </tr>
                                        <tr>
                                            <th>Authorize by</th>
                                            <td>${tenderAuthorizePerson}</td>
                                            <th>Number</th>
                                            <td>${tenderAuthorizeContactNo}</td>
                                        </tr>
                                        
                                    </table>
                                    
                                        
                                        
                                    Vendor Quotation Details
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Quotation No</th>
                                            <td>${offerNo}</td>
                                            <th>Date</th>
                                            <td>${offerDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Contact Person</th>
                                            <td>${contact_person}</td>
                                            <th>Contact Number</th>
                                            <td>${contact_no}</td>
                                        </tr>
                                        <tr>
                                            <th>Contact Email</th>
                                            <td>${contact_email}</td>
                                            <th>GST No</th>
                                            <td>${gst_no}</td>
                                        </tr>
                                        
                                    </table>
                                        
                                    Fee Details
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Fee</th>
                                            <td>${fee}</td>
                                            <th>Fee Date</th>
                                            <td>${fee_date}</td>
                                        </tr>
                                        <tr>
                                            <th>Drawee Bank</th>
                                            <td>${fee_drawee_bank}</td>
                                            <th>Cheque No</th>
                                            <td>${fee_cheque_no}</td>
                                        </tr>
                                        <tr>
                                            <th>Attachment</th>
                                            <td>${fee_attach}</td>
                                        </tr>
                                    </table>
                                        
                                    EMD Details
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>EMD</th>
                                            <td>${emd}</td>
                                            <th>EMD Date</th>
                                            <td>${emd_date}</td>
                                        </tr>
                                        <tr>
                                            <th>Drawee Bank</th>
                                            <td>${emd_drawee_bank}</td>
                                            <th>Cheque No</th>
                                            <td>${emd_cheque_no}</td>
                                        </tr>
                                        <tr>
                                            <th>Cash / Cheque</th>
                                            <td>${cash_cheque}</td>
                                            <th>Attachment</th>
                                            <td>${emd_attach}</td>
                                        </tr>
                                    </table>
                                    
                                    
                                    Attachment By Vendor
                                    <hr>
                                              <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
						<th><div align="center">Sr. No.</div></th>
                                                <th><div align="center">Item Description</div></th>
						<th><div align="center">Attachment Required</div></th>
						<th><div align="center">Attachment</div></th>
                                                </tr>
                                                </thead>
                                                            <tbody>
                                                         
                                                    <c:forEach var="vendorPreBidAttachment" items="${vendorPreBidAttachment}" varStatus="status">
                                                        <tr>
                                                            <td> ${status.count}</td>
                                                            <td>${vendorPreBidAttachment.description}</td>
                                                            <td>${vendorPreBidAttachment.attachmentRequired}</td>
                                                            <td>${vendorPreBidAttachment.attachment}</td>
                                                            
                                                        </tr>
                                                        </c:forEach>
                                                            </tbody>
                                                </table>
                                    
                                    Vendor Terms & Condition
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Delivery Location</th>
                                            <td>${deliveryLocation}</td>
                                            <th>Delivery Period (In Weeks)</th>
                                            <td>${deliveryPeriod}</td>
                                        </tr>
                                        <tr>
                                            <th>Terms of Payment</th>
                                            <td>${termsOfPayment}</td>
                                            <th>Validity Period</th>
                                            <td>${validityPeriod}</td>
                                        </tr>
                                        <tr>
                                            <th>Mode of Transport</th>
                                            <td>${modeOfTransport}</td>
                                            <th>Inco Terms</th>
                                            <td>${incoTerms}</td>
                                        </tr>
                                        <tr>
                                            <th>Insurance</th>
                                            <td>${insurance}</td>
                                            <th>Freight</th>
                                            <td>${freight}</td>
                                        </tr>
                                    </table>
                                    
                                    Vendor Remark For Technical
                                    <hr>
                                    
                                    <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th>Deviation</th>
                                            <td>${preBidDeviation}</td>
                                        </tr>
                                        <tr>
                                            <th>Remark</th>
                                            <td>${preBidRemark}</td>
                                        </tr>
                                    </table>
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
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
