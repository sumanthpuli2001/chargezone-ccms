<%-- 
    Document   : FinacialApprovalActiveView
    Created on : 7 Jan, 2025, 9:43:19 AM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Financial Active View</title>


        <style>

            @media print {
                a[href]:after {
                    content: none !important;
                }
            }


            /* Main container */
            .main-container {

                margin: 20px auto;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                background-color: #f9f9f9;
                font-family: Arial, sans-serif;
            }

            /* Flex container for top row */
            .flex-row {
                display: flex;
                justify-content: space-between;
                gap: 20px;
                margin-bottom: 20px;
            }

            /* Styling for left and right tables */
            .flex-table {
                flex: 1;
                border-collapse: collapse;
                width: 100%;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            .table-title {
                font-size: 18px;
                font-weight: bold;
                padding: 12px;

                text-align: center;
                background-color: #e0e7ff;
            }

            /* Table headers */
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #dddddd;
            }

            /* Alternate row colors */
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #e9f5ff;
            }

            /* Styling for bottom table */
            .bottom-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            /* Link styling */
            a {
                /*color: #007BFF;*/
                text-decoration: none;
                /*font-weight: bold;*/
            }

            a:hover {
                /*text-decoration: underline;*/
            }

            /* Table cell styling */
            td:first-child {
                /*font-weight: bold;*/
/*                width: 35%;*/
                color: #333;
            }
        </style>

    </head>
    <script>
        function recycle() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;
            window.location = 'vendorInformation.htm?act=RecycleButtonApproval&id=' + y + '&comment=' + comment1;
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


        function print() {
            var id = document.getElementById('id').value;


            window.location = 'vendorInformation.htm?act=financialApprovalPrint&id=' + id;
        }



    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Financial Active View</h4>
                <div>
<!--                    <button type="button" class="btn btn-primary" title="" style="width: 100px;" onclick="print()">&nbsp;&nbsp;Print</button>-->

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
        <form:form action="vendorInformation.htm?act=ButtonActiveApprovals" method="post"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">

                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                               
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">


                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <input type="hidden" id="id" name="id" value="${list.id}">
                                                    <input type="hidden" id="id1" name="id1" value="${list.id}">

                                                    <div class="main-container">
                                                        <!-- Top row with Company Information and Policy File -->
                                                        <div class="flex-row">
                                                            <!-- Company Information Table (Left Side) -->
                                                            <table  class="flex-table">
                                                              
                                                                <tr class="table-title">
                                                                    <td colspan="2">Company Information</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Company Name:</td>
                                                                    <td>${list.companyName}</td>
                                                                </tr>     
                                                                </tr>



                                                            </table>

                                                            <table  class="flex-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                                <tr class="table-title">
                                                                    <td colspan="2">Policy File</td>
                                                                </tr>

                                                                <tr>
                                                                    <td>Policy File:</td>
                                                                    <td>
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}"> ${list.policy1File}</a>
                                                                    </td>
                                                                </tr>

                                                            </table>

                                                        </div>



                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                                            <tr>
                                                                <td>Type Of Company </td>
                                                                <td>${list.typeOfConcern}</td>
                                                            </tr>





                                                        </table>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label class="control-label" style="margin-left: 8px;">Type Of Vendors  :<span style="color: red;font-size: 12px;"></span></label>
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

                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" align="center">

                                                            <tr class="table-title">
                                                                <td colspan="2">Location Details</td>
                                                            </tr>


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




                                                        </table> 









                                                        <table  class="bottom-table"  id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr class="table-title">
                                                                <td colspan="2">External Provider Details</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Address </td>
                                                                <td>Office</td>

                                                            </tr>
                                                            <tr>
                                                                <td>House No.</td>
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
                                                                <td>Primary Mobile No</td>
                                                                <td>${list.officeTelephone}</td>

                                                            </tr>

                                                            <tr>
                                                                <td>Secondary Mobile No</td>
                                                                <td>${list.secoundMobile}</td>

                                                            </tr>



                                                        </table>

                                                        <table class="bottom-table"  class="table table-bordered table-striped table-hover">
                                                            <thead>
                                                                <tr class="table-title" >
                                                                    <th>Vendor Contacts</th>
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
                                                                    <td>Finance and Accounts </td>
                                                                    <td>${list.quality_name}</td> <!-- Example Name -->
                                                                    <td>${list.quality_job}</td> <!-- Example Job Title -->
                                                                    <td>${list.quality_phone}</td>
                                                                    <td>${list.qualityEmail}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>



                                                      <table class="bottom-table"  class="table table-bordered table-striped table-hover" >

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

                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" align="center">
                                                            <tr class="table-title">
                                                                <td colspan="3">Payment/Banking Information:</td>
                                                            </tr>
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

                                                        <div class="table-responsive">
                                                            <table class="bottom-table">
                                                                <thead><tr class="table-title">
                                                                        <td colspan="7" style="font-weight: bold; background-color: skyblue;">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</td>
                                                                    </tr>
                                                                    <tr style="background: gainsboro;">
                                                                        <th>Year</th>
                                                                        <th>Financial Year</th>
                                                                        <th>Financial Amount</th>
                                                                        <th>Financial Attachment</th>
                                                                    </tr>
                                                                </thead>
                                                                  <tbody>
                                                            <!-- 1st Year -->
                                                            <tr>
                                                                <td>1st Year </td>
                                                                <td>${list.finical1}</td>
                                                                <td>${list.finicalAmount1}</td>
                                                                <td>
                                                                    <c:if test="${list.finicalAttachment1!='' &&  list.finicalAttachment1!=null}">
                                                                        ${list.finicalAttachment1}
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment1}&amp;id=${list.id}">
                                                                            &nbsp;<span class="fa fa-download"></span>
                                                                        </a>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <!-- 2nd Year -->
                                                            <tr>
                                                                <td>2nd Year </td>
                                                                <td>${list.finical2}</td>
                                                                <td>${list.finicalAmount2}</td>
                                                                <td>
                                                                    <c:if test="${list.finicalAttachment2!='' &&  list.finicalAttachment2!=null}">
                                                                        ${list.finicalAttachment2} 
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment2}&amp;id=${list.id}">
                                                                            &nbsp;<span class="fa fa-download"></span>
                                                                        </a>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <!-- 3rd Year -->
                                                            <tr>
                                                                <td>3rd Year </td>
                                                                <td>${list.finical3}</td>
                                                                <td>${list.finicalAmount3}</td>
                                                                <td>
                                                                    <c:if test="${list.finicalAttachment3!='' &&  list.finicalAttachment3!=null}">
                                                                        ${v.finicalAttachment3}<a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.finicalAttachment3}&amp;id=${list.id}">
                                                                            &nbsp;<span class="fa fa-download"></span>
                                                                        </a>
                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                        </table>
                                                    </div>
                                                    <br>
                                                                 <table  class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                            <tr>
                                                                <td>Reconciliation Account</td>
                                                                <td>${list.recAccountNo}</td>
                                                                <td>Bank Key</td>
                                                                <td>${list.bankKey}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Account No</td>
                                                                <td>${list.accountNo}</td>
                                                                <td>Tax Details</td>
                                                                <td>${list.taxDetails}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Tax No</td>
                                                                <td>${list.taxNumber}</td>

                                                            </tr>
                                                             <tr>
                                                                <td>Without Holding Tax Type</td>
                                                                <td>${list.withoutHoldingTaxType}</td>
                                                                <td>Without Holding Tax Type</td>
                                                                <td>${list.withoutHoldingTaxCode}</td>
                                                            </tr>
                                                            
                                                        </table>
                                                    </div>
                                                </c:forEach>

                                                <div class="main-container">

                                                    <table  class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                        <tr>
                                                            <th colspan="5">Approval History</th>
                                                        </tr>
                                                    </table>
                                                    <table   class="bottom-table" id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th >Sr. No.</th>
                                                            <th>User</th>
                                                            <th >Date Time</th>
                                                            <th >Comment</th>
                                                            <th >Action</th>
                                                        </tr>
                                                        <c:forEach var="vendorApproval" items="${vendorApproval}" varStatus="status">
                                                            <tr>
                                                                <td >
                                                                    ${status.count}
                                                                </td>
                                                                <td >
                                                                    ${vendorApproval.userId}
                                                                </td>
                                                                <td >
                                                                    ${vendorApproval.dateTime}
                                                                </td>
                                                                <td >
                                                                    ${vendorApproval.description}
                                                                </td>
                                                                <td >
                                                                    ${vendorApproval.activity}
                                                                </td>

                                                            </tr>
                                                        </c:forEach>
                                                    </table>




                                                    <br>
                                                    <br>





                                                    <table  class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                        <tr>
                                                            <td>Comment</td>
                                                            <td>
                                                                <textarea name="comment" class="form-control "></textarea>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <div class="form-group">
                                                        <div class="col-sm-12" style="text-align: center;margin-top: 10px;">
                                                            <input type="submit" class="btn btn-primary" style="width:120px!important;" id="submit1" title="submit1" value="Send To Vendor" >
                                                        </div>
                                                    </div>


                                                </div>

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

