<%-- 
    Document   : VendorListView4
    Created on : 11 Jan, 2024, 5:50:33 PM
    Author     : Bulwark-5
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Bid Information</title>
    </head>
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tender Bid Information</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Bid Information</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="tenderMaster.htm?act=vendorReviseBid" method="post" enctype="multipart/form-data" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">

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
                                    <P align="right">
                                        <input type="button" class="btn btn-primary" style="width: 100px;" onclick="history.back();" title="" value="Back" >
                                    </P>
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <!--                                            <div class="table">-->
                                                                                           <!--     <a href="tenderMaster.htm?act=priceBidPrintAll&refNo=${refNo}">Print All</a> -->

                                            <table id="table_11" class="table table-bordered" style="" align="Center"  >

                                                <thead>
                                                    <tr>

                                                        <th>Tender Ref No.</th>
                                                        <th>Vendor Id</th>
                                                        <th>Vendor Name</th>
                                                        <th>Vendor Email Id</th>
                                                        <th>Vendor Location</th>
                                                        <th>View All Attachment</th>
                                                        <th>View</th>

                                                        <th>Print</th>

                                                    </tr>
                                                </thead>
                                                <c:set var="count" value="0" scope="page" />
                                                <tbody>
                                                    <c:forEach var="list1" items="${list1}" varStatus="status">
                                                        <tr>

                                                            <td>${list1[0]}</td>
                                                            <td>${list1[1]}</td>
                                                            <td>${list1[2]}</td>
                                                            <td>${list1[5]}</td>
                                                            <td>${list1[3]}</td>

                                                            <td>
                                                                <a href="#" onclick="window.open('tenderMaster.htm?act=vendorAllAttachView1&refNo=${list1[0]}&vendorCode=${list1[1]}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                                        ">View</a>

                                                            </td>
                                                            <td>
                                                                <c:if test="${tenderPhase == '3'}">
                                                                    <a href="tenderMaster.htm?act=preBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid View</a><br>
                                                                </c:if>
                                                                <c:if test="${tenderPhase != '1'}">
                                                                    <a href="tenderMaster.htm?act=techBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid View</a><br>    
                                                                </c:if>


                                                                <c:if test="${tender_type == 'Service Manually'}">
                                                                    <a href="tenderMaster.htm?act=priceBidServiceView&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid View</a>
                                                                </c:if>
                                                                <c:if test="${tender_type != 'Service Manually'}">
                                                                    <a href="tenderMaster.htm?act=priceBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid View</a>
                                                                    <c:if test="${list1[6] == '1'}">
                                                                        <br><a href="tenderMaster.htm?act=priceBidReviseView&refNo=${list1[0]}&vendorCode=${list1[1]}">Revise Price Bid View</a>
                                                                    </c:if>
                                                                </c:if>


                                                            </td>


                                                            <td>
                                                                <c:if test="${tenderPhase == '3'}">
                                                                    <a target="blank" href="tenderMaster.htm?act=preBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Bid Print</a><br>
                                                                </c:if>
                                                                <c:if test="${tenderPhase != '1'}">
                                                                    <a target="blank" href="tenderMaster.htm?act=techBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Tech Bid Print</a><br>    
                                                                </c:if>
                                                                <c:if test="${tender_type == 'Service Manually'}">
                                                                    <a target="blank" href="tenderMaster.htm?act=priceBidServicePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                                                </c:if>
                                                                <c:if test="${tender_type != 'Service Manually'}">
                                                                    <a target="blank" href="tenderMaster.htm?act=priceBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Price Bid Print</a>
                                                                    <c:if test="${list1[6] == '1'}">
                                                                        <br><a target="blank" href="tenderMaster.htm?act=priceBidRevisePrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Revise Price Bid Print</a>
                                                                    </c:if>
                                                                </c:if>


                                                            </td>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>


                                            </table>

                                            <div class="row">

                                                <div class="col-md-12 col-sm-12">

                                                    <!--       <c:if test="${tenderPhase == '3'}">
                                                               <a href="tenderMaster.htm?act=preBidComparisonView&refNo=${list1[0]}&vendorCode=${list1[1]}">Pre Qualification Comparison</a><br>
                                                    </c:if>
                                                    <c:if test="${tenderPhase != '1'}">
                                                        <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=techBidComparisonView&refNo=${list1[0]}&vendorCode=${list1[1]}">Technical Comparison</a></label><br><br>
                                                    </c:if> 
                                                                                        
                                                <div class="form-group" style="margin-bottom: 15px;">
                                                    <div class="col-sm-3">
                                                        <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonSummaryView&refNo=${refNo}">Price Bid Comparison Summary VIew </a></label>
                                                    </div>
                                                    
                                                </div>
                                                <div class="form-group" style="margin-bottom: 15px;">
                                                    <div class="col-sm-3">
                                                        <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonView&refNo=${refNo}">Price Bid Comparison VIew </a></label>
                                                    </div>
                                                    
                                                </div>
                                                
                                                    <div class="form-group" style="margin-bottom: 15px;">
                                                    <div class="col-sm-3">
                                                        <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonWithReviseView&refNo=${refNo}">Price Bid Comparison With Revise VIew </a></label>
                                                    </div>
                                                    
                                                </div> -->

                                                    <div class="form-group" style="margin-bottom: 15px;">
                                                        <div class="col-sm-3">
                                                            <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonData&refNo=${refNo}">Price Bid Comparison VIew </a></label>
                                                        </div>

                                                    </div>

                                                    <div class="form-group" style="margin-bottom: 15px;">
                                                        <div class="col-sm-3">
                                                            <label class="control-label" style="padding-top: 0px;"><a href="tenderMaster.htm?act=priceBidComparisonData1&refNo=${refNo}">Price Bid Comparison With Tax VIew </a></label>
                                                        </div>

                                                    </div>

                                                </div>

                                            </div>

                                            <br>
                                            <h3>Approval Details</h3>
                                            <br>

                                            <table id="table_12" class="table table-bordered" style="" align="Center"  >
                                                <thead>
                                                    <tr>

                                                        <th>Comment</th>
                                                        <th>Date Time</th>
                                                        <th>View</th>

                                                    </tr>
                                                </thead>
                                                <c:set var="count" value="0" scope="page" />
                                                <tbody>
                                                    <tr>
                                                        <td>${tenderPriceApproval.approvalRemark}</td>
                                                        <td>${tenderPriceApproval.dateTime}</td>
                                                        <td><a href="tenderMaster.htm?act=viewApproveUserList&id=${tenderPriceApproval.id}">View</a></td>
                                                    </tr>
                                                </tbody>
                                            </table>


                                            <br>
                                            <h3>Approval Comments</h3>
                                            <br>

                                            <table id="table_12" class="table table-bordered" style="" align="Center"  >
                                                <thead>
                                                    <tr>
                                                        <th>User Id</th>
                                                        <th>Comment</th>
                                                        <th>Date Time</th>

                                                    </tr>
                                                </thead>
                                                <c:set var="count" value="0" scope="page" />
                                                <tbody>
                                                    <c:forEach var="list2" items="${list21}" varStatus="status">
                                                        <tr>

                                                            <td>${list2.userId}</td>
                                                            <td>${list2.approvalComment}</td>
                                                            <td>${list2.dateTime}</td>

                                                        </tr>
                                                    </c:forEach>
                                                    <c:forEach var="list2" items="${list2}" varStatus="status">
                                                        <tr>

                                                            <td>${list2.userId}</td>
                                                            <td>${list2.approvalComment}</td>
                                                            <td>${list2.dateTime}</td>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Auditor Report :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <textarea name="a_comments" class="form-control" readonly="true">${tenderMaster.auditComments}</textarea>
                                                </div>

                                            </div>            

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">PO Number :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="po_no" class="form-control"   maxlength="30" />
                                                </div>

                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Comments<span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-5">
                                                    <textarea name="comments" id="comments" maxlength="250" class="form-control" required="true">${tenderMaster.comments}</textarea>
                                                    <small id="charCount_comments" style="font-size: 12px; color: green;">250 characters remaining</small>

                                                    <script type="text/javascript">
                                                        document.addEventListener("DOMContentLoaded", function () {
                                                            var textarea = document.getElementById("comments");
                                                            var counter = document.getElementById("charCount_comments");
                                                            var maxChars = 250;

                                                            function updateCounter() {
                                                                var count = textarea.value.length;
                                                                var remaining = maxChars - count;
                                                                counter.textContent = remaining + " characters remaining";

                                                                if (remaining <= 20) {
                                                                    counter.style.color = "red";
                                                                } else {
                                                                    counter.style.color = "green";
                                                                }
                                                            }

                                                            updateCounter(); // For pre-filled remarks in edit mode
                                                            textarea.addEventListener("input", updateCounter);
                                                        });
                                                    </script>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Attach File</label>
                                                </div>
                                                <div class="col-sm-5">
                                                    <input type="file" name="generalfile" value="" class="form-control" />
                                                    <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${tenderMaster.auditFile}&RefNo=${tenderMaster.refNo}">${tenderMaster.auditFile}</a>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="tenderMaster.htm?act=addPoNumber" title="" value="Add P.O. No" >
                                                    <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="tenderMaster.htm?act=holdTender" title="" value="Hold" >
                                                </div>
                                            </div>
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

