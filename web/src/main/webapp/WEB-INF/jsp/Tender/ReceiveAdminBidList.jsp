<%-- 
    Document   : ReceiveAdminBidList
    Created on : 22 Jan, 2024, 12:01:15 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Receive Bid</title>
        <style>
            h1{
                font-weight: bold;
                margin: 0;
            }
        </style>
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


        <section class="content-header" style="display: flex; justify-content: space-between; align-items: center;">
            <h1>RECEIVE BID</h1>
            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="history.back();" title="" value="Back" >

        </section>

        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                                                <th>Tender Date</th>
                                                                <th>Tender Due Date</th>

                                                                <th>Created By</th>
                                                                <th>Tender Type</th>
                                                                <th>Bid Sent To No. Of Vendor</th>
                                                                <th>Bid Received/Regret From No. Of Vendor</th>
                                                                <th>Bid Status</th>
                                                                <th>Send To Buyer</th>    
                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach var="list" items="${bs}" varStatus="status">
                                                                <tr>
                                                                    <td>${status.count}</td>
                                                                    <td>${list.refNo}</td>

                                                                    <td>${list.title}</td>
                                                                    <td>${list.tender_date}</td>
                                                                    <td>${list.tender_due_date}</td>

                                                                    <td>${list.created_by}</td>
                                                                    <td>${list.tenderPhase} Part</td>
                                                                    <td>
                                                                        <a href="#" onclick="window.open('tenderMaster.htm?act=tenderVendorTotal&tender_no=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                                                ">${list.vendor_total}</a>
                                                                    </td>
                                                                    <td>
                                                                        <a href="#" onclick="window.open('tenderMaster.htm?act=tenderBidVendorTotal&tender_no=${list.refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                                                ">${list.total_bid}/${list.total_regret}</a>
                                                                    </td>
                                                                    <td>
                                                                        <c:if test="${list.bid_status == '1'}">


                                                                            <c:if test="${list.tenderPhase == 3}">

                                                                                <c:if test="${list.pre_bid_open_flag == '0'}">
                                                                                    <a href="tenderMaster.htm?act=preBidOpenView&id=${list.tender_id}">
                                                                                        Pre bid yet to be open <br><br> 
                                                                                    </a>
                                                                                </c:if>
                                                                                <c:if test="${list.pre_bid_approve_flag == 1 && list.pre_bid_open_flag == 1}">
                                                                                    <a href="tenderMaster.htm?act=preBidOpenView&id=${list.tender_id}">
                                                                                        Pre bid open <br><br>
                                                                                    </a>
                                                                                </c:if>
                                                                            </c:if>
                                                                            <c:if test="${list.tenderPhase == 3 || list.tenderPhase == 2}">

                                                                                <c:if test="${list.tenderPhase == 3 && list.pre_bid_approve_flag == 1 && list.tech_bid_open_flag == 0}">
                                                                                    <a href="tenderMaster.htm?act=techBidOpenView&id=${list.tender_id}">
                                                                                        Tech. bid yet to be open <br><br>
                                                                                    </a>
                                                                                </c:if>    
                                                                                <c:if test="${list.tenderPhase == 2 && list.tech_bid_open_flag == 0}">
                                                                                    <a href="tenderMaster.htm?act=techBidOpenView&id=${list.tender_id}">
                                                                                        Tech. bid yet to be open <br><br>
                                                                                    </a>
                                                                                </c:if>    

                                                                                <c:if test="${list.tech_bid_open_flag == 1}">
                                                                                    <a href="tenderMaster.htm?act=techBidOpenView&id=${list.tender_id}">
                                                                                        Tech. bid open <br><br>
                                                                                    </a>
                                                                                </c:if>
                                                                            </c:if>

                                                                            <c:if test="${list.tenderPhase == 1 && list.price_bid_open_flag == 0}">
                                                                                <a href="tenderMaster.htm?act=priceBidOpenView&id=${list.tender_id}">
                                                                                    bid yet to be open <br><br>
                                                                                </a>
                                                                            </c:if>
                                                                            <c:if test="${list.tenderPhase == 3 || list.tenderPhase == 2}">
                                                                                <c:if test="${list.tech_bid_approve_flag == 1}">
                                                                                    <a href="tenderMaster.htm?act=priceBidOpenView&id=${list.tender_id}">
                                                                                        bid yet to be open <br><br>
                                                                                    </a>
                                                                                </c:if>
                                                                            </c:if>
                                                                        </c:if>
                                                                    </td>
                                                                    <td>
                                                                        <a href="tenderMaster.htm?act=sendToBuyer&id=${list.tender_id}">
                                                                            Send To Buyer 
                                                                        </a>
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

</html>


