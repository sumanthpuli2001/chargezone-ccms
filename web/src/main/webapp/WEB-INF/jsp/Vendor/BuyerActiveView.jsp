<%-- 
    Document   : BuyerActiveView
    Created on : 13 Feb, 2025, 4:30:04 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Vendor List</title>


        <style>
            .h4-container {
                display: flex;
                justify-content: space-between; /* This will distribute them evenly */
            }

            h4 {
                margin: 0 10px; /* Adjust the spacing between them as needed */
            }
            @media print {
                a[href]:after {
                    content: none !important;
                }
            }
        </style>
    </head>
    <script>
        function recycle() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;
            window.location = 'vendorInformation.htm?act=recyclevendor&id=' + y + '&comment=' + comment1;
        }
        function reject() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;
            window.location = 'vendorInformation.htm?act=rejectvendor&id=' + y + '&comment=' + comment1;
        }

        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'approvalSetting.htm?act=viewClick&id=' + loginName;
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

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Vendor List</h4>
                <div>
                    <input type="button"  class="btn btn-primary" style="" onclick="window.print();" title="" value="Print" >
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
        <form:form action="vendorInformation.htm?act=buyerActiveViewSubmit" method="post"
                   name='form1' class="form-horizontal" role="form">
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
                                            <div class="table table-bordered">


                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <input type="hidden" id="id" name="id" value="${list.id}">
                                                    <input type="hidden" id="id1" name="id1" value="${list.id}">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td>Company Name :</td>
                                                            <td>${list.companyName}</td>

                                                        </tr>



                                                    </table>

                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td>Policy File :</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}"> ${list.policy1File}</a>
                                                            </td>
                                                        </tr>

                                                    </table>


                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td>Type Of Company </td>
                                                            <td>${list.typeOfConcern}</td>
                                                        </tr>

                                                    </table>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <span class="control-label" style="margin-left: 8px;">Type Of Vendors  :<span style="color: red;font-size: 12px;"></span></span>
                                                        </div>
                                                        <div class="col-sm-12">
                                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                <c:forEach var="list222" items="${list222}" varStatus="status">

                                                                    <tr>
                                                                    <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list222[2]}<" />
                                                                    <td>${list222[2]}</td>
                                                                    <td>${list222[3]}</td>
                                                                    <td>${list222[4]}</td>
                                                                    </tr>
                                                                </c:forEach>

                                                            </table>
                                                        </div>
                                                    </div>
                                                    <table  class="table table-bordered table-striped table-hover" align="center">
                                                        <tr class="table-title">
                                                            <td colspan="2">Location Details</td>
                                                        </tr>

                                                        <tbody>
                                                            <tr>
                                                                <td>Country</td>
                                                                <td>${list.officeCountry}</td> <!-- Example Name -->


                                                            </tr>
                                                            <tr>
                                                                <td>State</td>
                                                                <td>${list.officeState}</td> <!-- Example Name -->
                                                            </tr>
                                                            <tr>
                                                                <td>City</td>
                                                                <td>${list.officeCity}</td> <!-- Example Name -->
                                                            </tr>



                                                        </tbody>
                                                    </table>     









                                                    <table  class="table table-bordered table-striped table-hover" align="center">
                                                        <tr class="table-title">
                                                            <td colspan="2">External Provider Details</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Address </td>
                                                            <td>Office</td>

                                                        </tr>
                                                        <tr>
                                                            <td>House No</td>
                                                            <td>${list.officeAddressLine1}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Street</td>
                                                            <td>${list.officeAddressLine2}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>District</td>
                                                            <td>${list.officeAddressLine3}</td>

                                                        </tr>


                                                        <tr>
                                                            <td>Pin </td>
                                                            <td>${list.officePin}</td>

                                                        </tr>


                                                        <tr>
                                                            <td>Year of Establishment of Company </td>
                                                            <td>${list.establishment}</td>

                                                        </tr>

                                                        <tr>
                                                            <td>Company Website </td>
                                                            <td>${list.officeWebsite}</td>

                                                        </tr>

                                                        <tr>
                                                            <td>Primary Mobile Number</td>
                                                            <td>${list.officeTelephone}</td>

                                                        </tr>

                                                        <tr>
                                                            <td>Secondary Mobile number</td>
                                                            <td>${list.secoundMobile}</td>

                                                        </tr>



                                                    </table>




                                                    <table  class="table table-bordered table-striped table-hover" align="center">
                                                        <thead>
                                                            <tr class="table-title" >
                                                                <th>External Provider Contacts</th>
                                                                <th>Name</th>
                                                                <th>Job Title</th>
                                                                <th>Phone No.</th>
                                                                <th>Email </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Sales/Commercial Contact(s)</td>
                                                                <td>${list.sales_name}</td> <!-- Example Name -->
                                                                <td>${list.sales_job}</td> <!-- Example Job Title -->
                                                                <td>${list.sales_phone}</td> <!-- Example Contact -->
                                                                <td>${list.saleEmail}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Technical Contact(s)</td>
                                                                <td>${list.technical_name}</td> <!-- Example Name -->
                                                                <td>${list.technical_job}</td> <!-- Example Job Title -->
                                                                <td>${list.technical_phone}</td>
                                                                <td>${list.technicalContactEmail}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Finance and Accounts</td>
                                                                <td>${list.quality_name}</td> <!-- Example Name -->
                                                                <td>${list.quality_job}</td> <!-- Example Job Title -->
                                                                <td>${list.quality_phone}</td>
                                                                <td>${list.qualityEmail}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>




                                                    <div class="table-responsive">
                                                        <table class="table table-bordered">

                                                            <tbody>
                                                                <!-- GST No -->
                                                                <tr>
                                                                    <td>GST No. </td>
                                                                    <c:if test="${list.gstStatus=='1'}">
                                                                        <td><strong>GST No. Applicable</strong></td>
                                                                        <td>${list.gstinNo}</td>
                                                                        <td>
                                                                            <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.gstinFile}&amp;id=${list.id}">
                                                                                ${list.gstinFile}
                                                                            </a>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${list.gstStatus=='0'}">
                                                                        <td colspan="3"><strong>GST No. Not Applicable</strong></td>
                                                                        <td>${list.gstRemark}</td>
                                                                    </c:if>

                                                                </tr>
                                                                <!-- PAN No -->
                                                                <tr>
                                                                    <td colspan="2">PAN No. </td>
                                                                    <td >${list.panNo}</td>
                                                                    <td>
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.panFile}&amp;id=${list.id}">
                                                                            ${list.panFile}
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                                <!-- MSME No -->
                                                                <tr>
                                                                    <td colspan="2">MSME No</td>
                                                                    <td >${list.service_tax}</td>
                                                                    <td>
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.service_file}&amp;id=${list.id}">
                                                                            ${list.service_file}
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                                <!-- EPF No -->
                                                                <tr>
                                                                    <td colspan="2">EPFO No. </td>
                                                                    <td >${list.pfNo}</td>
                                                                    <td>
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.pfAttachment}&amp;id=${list.id}">
                                                                            ${list.pfAttachment}
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                                <!-- IEC -->
                                                                <tr>
                                                                    <td colspan="2">Import Export Code </td>
                                                                    <td > ${list.ecc_no}</td>
                                                                    <td>
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.ecc_file}&amp;id=${list.id}">
                                                                            ${list.ecc_file}
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                    <table id="table_1" class="table table-bordered table-striped table-hover" align="center">
                                                        <thead>
                                                            <tr>
                                                        <h4>Payment/Banking Information:</h4>

                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Account Number.</td>
                                                                <td>${list.accountNumber}</td> <!-- Example Name -->


                                                            </tr>
                                                            <tr>
                                                                <td>Bank Name</td>
                                                                <td>${list.bankName}</td> <!-- Example Name -->
                                                            </tr>
                                                            <tr>
                                                                <td>Branch.</td>
                                                                <td>${list.branch}</td> <!-- Example Name -->
                                                            </tr>

                                                            <tr>
                                                                <td>IFSC Code.</td>
                                                                <td>${list.ifscCode}</td> <!-- Example Name -->
                                                            </tr>
                                                            <tr>
                                                                <td>Swift Code (if any)</td>
                                                                <td>${list.swiftCode}</td> <!-- Example Name -->

                                                            </tr>
                                                            <tr>
                                                                <td> Cancel Cheque</td>
                                                                <!--<td>${list.cancelCheck}</td>  Example Name -->

                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.cancelCheck}&id=${list.id}"> ${list.cancelCheck}</a>
                                                                </td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                    <table id="table_122" class="table table-bordered table-striped table-hover" align="center">
                                                        <tr>
                                                            <td>Company</td>
                                                            <td>${list.buyerCompany}</td>
                                                            <td>Purchasing Organization</td>
                                                            <td>${list.purchasingGroup}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Currency</td>
                                                            <td>${list.currency}</td>
                                                            <td>Group Calculation Schema</td>
                                                            <td>${list.groupCalculation}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>BP Group</td>
                                                            <td>${list.bpGroup}</td>
                                                            <td>Terms of Payment Key</td>
                                                            <td>${list.termOfPayment}</td>
                                                        </tr>

                                                    </table>

                                                    <table id="table_122" class="table table-bordered table-striped table-hover" align="center">


                                                        <tr class="table-title">
                                                            <td colspan="7">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                                        </tr>
                                                        <tbody>
                                                            <tr>
                                                                <td>Financial Year</td>
                                                                <td>${list.finical1}</td> <!-- Example Name -->
                                                                <td>${list.finicalAmount1}</td>
                                                                <td><a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment1}&id=${list.id}">${list.finicalAttachment1}</a></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Financial Year</td>
                                                                <td>${list.finical2}</td> <!-- Example Name -->
                                                                <td>${list.finicalAmount2}</td>
                                                                <td><a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment2}&id=${list.id}">${list.finicalAttachment2}</a></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Financial Year</td>
                                                                <td>${list.finical3}</td> <!-- Example Name -->
                                                                <td>${list.finicalAmount3}</td>
                                                                <td><a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment3}&id=${list.id}">${list.finicalAttachment3}</a></td>
                                                            </tr>




                                                        </tbody>
                                                    </table>


                                                    <h5 style="margin-left: 8px;">Approval Status</h5>
                                                    <table id="table_1223" class="table table-bordered table-striped table-hover" align="center">
                                                        <thead>

                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Financial Approval</td>
                                                                <td>${list.approvalTwo}</td> <!-- Example Name -->
                                                                <td>
                                                                    <c:if test="${list.finacialFlag=='1'}">
                                                                        Approve
                                                                    </c:if>
                                                                    <c:if test="${list.finacialFlag=='0'}">
                                                                        Pending
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Technical Approval</td>
                                                                <td>${list.technicalApproval}</td> <!-- Example Name -->
                                                                <td>
                                                                    <c:if test="${list.technicalFlag=='1'}">
                                                                        Approve
                                                                    </c:if>
                                                                    <c:if test="${list.technicalFlag=='0'}">
                                                                        Pending
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>HR Approval</td>
                                                                <td>${list.hrApproval}</td> <!-- Example Name -->
                                                                <td>
                                                                    <c:if test="${list.hrApprovalFlag=='1'}">
                                                                        Approve
                                                                    </c:if>
                                                                    <c:if test="${list.hrApprovalFlag=='0'}">
                                                                        Pending
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Safety Approval</td>
                                                                <td>${list.safetyApproval}</td> <!-- Example Name -->
                                                                <td>
                                                                    <c:if test="${list.safteyApprovalFlag=='1'}">
                                                                        Approve
                                                                    </c:if>
                                                                    <c:if test="${list.safteyApprovalFlag=='0'}">
                                                                        Pending
                                                                    </c:if>
                                                                </td>
                                                            </tr>

                                                        </tbody>
                                                    </table>


                                                </c:forEach>
                                                <h5 style="margin-left: 8px;">External Email Id</h5>
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >

                                                    <c:forEach var="userList" items="${userList}" varStatus="status">
                                                        <tr>
                                                            <td>${status.count}</td>
                                                            <td>${userList.loginName}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>



                                                <table id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <tr>
                                                        <th colspan="5">Approval History</th>
                                                    </tr>
                                                    <tr>
                                                        <th style="text-align: center; vertical-align: middle">Sr. No.</th>
                                                        <th style="text-align: center; vertical-align: middle">User</th>
                                                        <th style="text-align: center; vertical-align: middle">Date Time</th>
                                                        <th style="text-align: center; vertical-align: middle">Comment</th>
                                                        <th style="text-align: center; vertical-align: middle">Action</th>
                                                    </tr>
                                                    <c:forEach var="vendorApproval" items="${vendorApproval}" varStatus="status">
                                                        <tr>
                                                            <td style="text-align: center">
                                                                ${status.count}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.userId}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.dateTime}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.description}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.activity}
                                                            </td>

                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                              

                                             

                                            </form:form>

                                        </div>
                                    </div>

                                </div><!-- /.tab-pane -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>

    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

